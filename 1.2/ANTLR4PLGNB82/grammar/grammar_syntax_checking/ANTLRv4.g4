/*
 * [The "BSD license"]
 *  Copyright (c) 2012-2014 Terence Parr
 *  Copyright (c) 2012-2014 Sam Harwell
 *  Copyright (c) 2015 Gerald Rosenberg
 *  Copyright (c) 2016 Frédéric Vinet
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions
 *  are met:
 *
 *  1. Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *  3. The name of the author may not be used to endorse or promote products
 *     derived from this software without specific prior written permission.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 *  IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 *  OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 *  IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 *  INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 *  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 *  DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 *  THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 *  THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
/*	A grammar for ANTLR v4 written in ANTLR v4.
 *
 *	Modified 2015.06.16 gbr
 *	-- update for compatibility with Antlr v4.5
 *	-- add mode for channels
 *	-- moved members to LexerAdaptor
 * 	-- move fragments to imports
 *     
 *      Modified 2016.07 by FYV :
 *      - some rules have been renamed :
 *        - the names of high level rules have been homogenized : usage of Spec
 *          suffix,
 *        - grammarPrequel becomes analyzerDirectiveSpec,
 *        - now all names of low level rules enable to know if the rule is used
 *          by a parser rule or a lexer rule (easier understanding and 
 *          debugging),
 *      - the way to manage fragment-based rules have been changed,
 *      - some lexer rules have been changed (see ANTLRv4Lexer.g4) so these
 *        changes have impacts on parser rules,
 *      - the content between brackets is now managed at parser level in all 
 *        cases (even lexer char set, see comments in ANTLRv4Lexer.g4),
 */

grammar ANTLRv4;

options
   { tokenVocab = ANTLRv4Lexer; }


// The main entry point for parsing a v4 grammar.
grammarFile :
    grammarSpec
    (analyzerDirectiveSpec+ | ) // equivalent to analyzerDirectiveSpec* but enables getExpectedTokens() to work
    ruleSpec+ // There must be at least one rule
    (modeSpec+ | ) // equivalent to modeSpec* but enables getExpectedTokens() to work
    EOF
    ;


grammarSpec :
    (DOC_COMMENT+ | )
    grammarType identifier SEMI
    ;

// FYV modification : parentheses removed
grammarType :
    LEXER GRAMMAR | PARSER GRAMMAR | GRAMMAR
    ;

// This is the list of all constructs that can be declared before
// the set of rules that compose the grammar, and is invoked 0..n
// times by the analyzerDirectiveSpec rule.
analyzerDirectiveSpec :
    (DOC_COMMENT+ | )
    (optionsSpec      |
     delegateGrammars |
     tokensSpec       |
     channelsSpec     |
     action            )
    ;

// ------------
// Options - things that affect analysis and/or code generation
// For enabling getExpectedTokens() to work we replace the next definition:
// optionsSpec
//   : OPTIONS LBRACE (optionSpec SEMI)* RBRACE
//   ;
// by:
optionsSpec :
    OPTIONS LBRACE ((optionSpec SEMI)+ | ) RBRACE
    ;

optionSpec :
    superClassSpec |
    languageSpec |
    tokenVocabSpec |
    tokenLabelTypeSpec
    ;

superClassSpec :
    SUPER_CLASS ASSIGN classIdentifier
    ;

// Valid languages are 'Java', 'JavaScript', 'CSharp', 'Python2', 'Python3'
languageSpec :
    LANGUAGE ASSIGN STRING_LITERAL
    ;

tokenVocabSpec :
    TOKEN_VOCAB ASSIGN identifier
    ;

tokenLabelTypeSpec :
    TOKEN_LABEL_TYPE ASSIGN classIdentifier
    ;


// ------------
// Delegates
delegateGrammars :
    IMPORT delegateGrammarList SEMI
    ;

delegateGrammarList :
    delegateGrammar ((COMMA delegateGrammar)+ | )
    ;

delegateGrammar :
    (identifier ASSIGN | ) grammarIdentifier
    ;

grammarIdentifier :
    identifier
    ;

// ------------
// Tokens & Channels
tokensSpec :
    TOKENS LBRACE (tokenList | ) RBRACE // equivalent to tokenList? but enables getExpectedTokens() to work
    ;

tokenList :
    TOKEN_ID ((COMMA TOKEN_ID)+ | )
    ;

channelsSpec :
    CHANNELS LBRACE (idList | ) RBRACE // equivalent to idList? but enables getExpectedTokens() to work
    ;

idList :
    identifier ((COMMA identifier)+ | )
    ;

// Match stuff like @parser::members {int i;}
action :
    AT (actionDestination COLONCOLON | ) (headerAction | memberAction) // equivalent to (actionDestination COLONCOLON)? but enables getExpectedTokens() to work
    ;

headerAction :
    HEADER headerActionBlock 
    ;

memberAction :
    MEMBERS actionBlock
    ;

// Scope names could collide with keywords; allow them as ids for action scopes
actionDestination :
    LEXER |
    PARSER
    ;


/*
 FYV: Now we parse action block content in order to be able to recover Java
      import statements.
      Originally it was ACTION_CONTENT* so a list of tokens (reduced to one
      token most of the time)
*/
headerActionBlock :
    BEGIN_ACTION headerActionContent END_ACTION
    ;

headerActionContent :
    packageDeclaration?
    importDeclaration*
    ;

packageDeclaration :
    HEADER_PACKAGE packageIdentifier SEMI
    ;

// We only manage single type import declaration
importDeclaration :
    singleTypeImportDeclaration
    ;

singleTypeImportDeclaration :
    HEADER_IMPORT HDR_IMPRT_STATIC? (classIdentifier | genericClassIdentifier) SEMI
    ;



actionBlock :
    BEGIN_ACTION (ACTION_CONTENT+ | ) END_ACTION // equivalent to ACTION_CONTENT* but enables getExpectedTokens() to work
    ;




modeSpec :
    (DOC_COMMENT+ | )
    modeDec
    (lexerRuleSpec+ | )
    ;

modeDec :
    MODE identifier SEMI
    ;

/*
We cannot use rule as a rule identifier because it conflicts with ANTLR code.
So we use ruleSpec
*/
ruleSpec :
    parserRuleSpec |
    lexerRuleSpec
    ;

/*****************************
 * Parser rule specification *
 *****************************/
parserRuleSpec :
    (DOC_COMMENT+ | )
    parserRuleDeclaration COLON parserRuleDefinition SEMI
    exceptionGroup
    ;

parserRuleDeclaration :
    parserRuleIdentifier
    (actionBlockArguments | )
    (parserRuleReturns | )
    (throwsSpec | )
    (localsSpec | )
    (parserRulePrequel+ | )
    ;

exceptionGroup :
    (exceptionHandler+ | ) (finallyClause | )
    ;

exceptionHandler
   : CATCH actionBlockArguments actionBlock
   ;

finallyClause :
    FINALLY actionBlock
    ;

parserRulePrequel :
    optionsSpec |
    ruleAction
    ;

parserRuleReturns :
    RETURNS actionBlockArguments
    ;

// --------------
// Exception spec
throwsSpec :
    THROWS identifier (COMMA identifier)*
    ;

localsSpec :
    LOCALS actionBlockArguments
    ;

/** Match stuff like @init {int i;} */
ruleAction :
    AT (INIT | AFTER) actionBlock
    ;


parserRuleDefinition :
    parserRuleLabeledAlternative (OR parserRuleLabeledAlternative)*
    ;

parserRuleLabeledAlternative :
    parserRuleAlternative (SHARP identifier)?
    ;

// --------------------
// Parser Rule Alts
altList :
    parserRuleAlternative (OR parserRuleAlternative)*
    ;

parserRuleAlternative :
    parserRuleElement+ |
    // explicitly allow empty alts
    ;

parserRuleElement :
    labeledParserRuleElement ebnfSuffix? |
    parserRuleAtom ebnfSuffix? |
    ebnf |
    actionBlock |
    actionBlock QUESTION elementOptions?
    ;

labeledParserRuleElement :
    identifier (ASSIGN | PLUS_ASSIGN) (parserRuleAtom | block)
    ;

parserRuleAtom
   : characterRange
   | terminal
   | parserRuleReference
   | notSet
   | DOT elementOptions?
   ;

parserRuleReference
   : parserRuleIdentifier actionBlockArguments? elementOptions?
   ;


actionBlockArguments :
    BEGIN_ARGUMENT ARGUMENT_CONTENT* END_ARGUMENT
    ;
    

/****************************
 * Lexer rule specification *
 ****************************/
lexerRuleSpec :
    (DOC_COMMENT+ | )
    (tokenRuleDeclaration | fragmentRuleDeclaration)
    ;

tokenRuleDeclaration :
    TOKEN_ID COLON lexerRuleBlock SEMI
    ;

fragmentRuleDeclaration :
    FRAGMENT TOKEN_ID COLON lexerRuleBlock SEMI
    ;

lexerRuleBlock :
    lexerRuleAlt ((OR lexerRuleAlt)+ | )
    ;

lexerRuleAlt :
    lexerRuleElements (lexerCommands | ) |
 // explicitly allow empty alts
    ;

lexerRuleElements :
    lexerRuleElement +
    ;

lexerRuleElement :
    lexerRuleAtom (ebnfSuffix | ) |
    lexerRuleElementBlock (ebnfSuffix | ) |
    actionBlock (QUESTION | )
    ;

lexerRuleElementBlock :
    LPAREN lexerRuleBlock RPAREN
    ;

// E.g., channel(HIDDEN), skip, more, mode(INSIDE), push(INSIDE), pop
lexerCommands :
    RARROW lexerCommand ((COMMA lexerCommand)+ | )
    ;

lexerCommand :
    LEXCOM_SKIP |
    LEXCOM_MORE |
    LEXCOM_TYPE LPAREN (TOKEN_ID | INT) RPAREN |
    lexComChannel |
    lexComMode |
    lexComPushMode |
    LEXCOM_POPMODE
    ;

lexComChannel :
    LEXCOM_CHANNEL LPAREN (identifier | INT) RPAREN
    ;

lexComMode :
    LEXCOM_MODE LPAREN (identifier | INT) RPAREN
    ;

lexComPushMode :
    LEXCOM_PUSHMODE LPAREN (identifier | INT) RPAREN
    ;

lexerRuleAtom :
    characterRange |
    terminal |
    notSet |
    LEXER_CHAR_SET |
    DOT (elementOptions | )
    ;

// --------------------
// EBNF and blocks
ebnf :
    block (ebnfSuffix | )
    ;

ebnfSuffix :
    QUESTION (QUESTION | ) |
    STAR (QUESTION | ) |
    PLUS (QUESTION | )
    ;





// --------------------
// Inverted element set
notSet :
    NOT setElement |
    NOT blockSet
    ;

blockSet :
    LPAREN setElement ((OR setElement)+ | ) RPAREN
    ;

setElement :
    TOKEN_ID (elementOptions | ) |
    STRING_LITERAL (elementOptions | ) |
    characterRange |
    LEXER_CHAR_SET
    ;

// -------------
// Grammar Block
block :
    LPAREN (((optionsSpec | ) (ruleAction+ | ) COLON) | ) altList RPAREN
    ;


// ---------------
// Character Range
characterRange :
    STRING_LITERAL RANGE STRING_LITERAL
    ;

terminal :
    TOKEN_ID (elementOptions | ) |
    STRING_LITERAL (elementOptions | )
    ;

// Terminals may be adorned with certain options when
// reference in the grammar: TOK<,,,>
elementOptions :
    LT elementOption ((COMMA elementOption)+ | ) GT
    ;

elementOption :
    tokenOption
    ;

tokenOption :
    ASSOC ASSIGN (RIGHT | LEFT) |
    FAIL ASSIGN (STRING_LITERAL | actionBlock)
    ;
// Semantic predicate option are only valid for semantic predicate so may only be found
// in parser rule definition


/***********************
 * general identifiers * 
 ***********************/
// in parser rule definition an identifier can represent a parser / lexer rule reference
// or athe id of the element that will be used in an action block
// for making the difference between the two first cases and the third one, we have
// to wait for '=' or '+=' token that are placed after the id so it is not possible.
// That's why we add ID_STARTING_WITH_UPPERCASE and ID_STARTING_WITH_LOWERCASE in
// the possibilities for an identifier
identifier :
    ID
    ;

ruleElementIdentifier :
    TOKEN_ID |
    PARSER_RULE_ID
    ;

classIdentifier :
    identifier ((DOT identifier)+ | )
    ;

genericClassIdentifier :
    identifier ((DOT identifier)+ | ) DOT STAR
    ;

packageIdentifier :
    identifier ((DOT identifier)+ | )
    ;

parserRuleIdentifier :
    PARSER_RULE_ID
    ;
