/*
 * [The "BSD license"]
 *  Copyright (c) 2012-2015 Terence Parr
 *  Copyright (c) 2012-2015 Sam Harwell
 *  Copyright (c) 2015-2016 Gerald Rosenberg
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

/**
 *	A grammar for ANTLR v4 implemented using v4 syntax
 *
 *	Modified 2015.06.16 gbr
 *	-- update for compatibility with Antlr v4.5
 *
 *      Modified 2016.07 by FYV:
 *      - whitespace chracters have been are skipped rather than being sent to
 *        OFF_CHANNEL channel,
 *      - LexerAdaptor Java class removed (ugly: it uses parts of its 
 *        ANTLR-generated child class),
 *      - TOKEN_REF in fact does not always reference a token. In fact, at lexer
 *        level, it is not possible to know if an id beginning with an uppercase
 *        letter reference a token or not. It is not even possible to know if it
 *        is a token reference or a token declaration or an id for something 
 *        else. So TOKEN_REF has been replaced by ID_STARTING_WITH_UPPERCASE,
 *      - For the same reasons, RULE_REF has been replaced by 
 *        ID_STARTING_WITH_LOWERCASE.
 *      - In order to determine if an ID is an ID_STARTING_WITH_UPPERCASE or an
 *        ID_STARTING_WITH_LOWERCASE, we do it through action. If you don't care
 *        about the first letter, you have to use an identifier and not an ID.
 *      - id rule has been removed,
 *      - code from LexerAdaptor class has been put in actions inside the 
 *        current file.
 **/
lexer grammar ANTLRv4Lexer;

import LexBasic;

@members {
private int _currentRuleId = Token.INVALID_TYPE;
private int _idMode = 0;
private boolean _fragment = false;

public int getCurrentRuleId() {
    return _currentRuleId;
}

public void setCurrentRuleId(int ruleType) {
    this._currentRuleId = ruleType;
}

private boolean inLexerRule() {
    return _fragment
           ? true
           : _currentRuleId == ANTLRv4Lexer.ID_STARTING_WITH_UPPERCASE;
}

@Override
public Token emit() {
//    System.out.println("emit() : type=" + _type);
    if (_type == ANTLRv4Lexer.ID_STARTING_WITH_UPPERCASE |
        _type == ANTLRv4Lexer.ID_STARTING_WITH_LOWERCASE) {
	if (_currentRuleId == Token.INVALID_TYPE) { // if outside of rule def
            _currentRuleId = _type; // set to inside lexer or parser rule
        }
    } else if (_type == ANTLRv4Lexer.SEMI) { // exit rule def
        _currentRuleId = Token.INVALID_TYPE;
    }

    return super.emit();
}
}


tokens
   { ID_STARTING_WITH_UPPERCASE, ID_STARTING_WITH_LOWERCASE, LEXER_CHAR_SET }


// ======================================================
// Lexer specification
//
// -------------------------
// Comments

DOC_COMMENT
   : DocComment
   ;


BLOCK_COMMENT
   : BlockComment -> skip
   ;


LINE_COMMENT
   : LineComment -> skip
   ;


// -------------------------
// Integer
//

INT
   : DecimalNumeral
   ;

// -------------------------
// Literal string
//
// ANTLR makes no distinction between a single character literal and a
// multi-character string. All literals are single quote delimited and
// may contain unicode escape sequences of the form \uxxxx, where x
// is a valid hexadecimal number (per Unicode standard).

STRING_LITERAL
   : SQuoteLiteral
   ;


UNTERMINATED_STRING_LITERAL
   : USQuoteLiteral
   ;


/*******************************************
 * rule for passing in BracketContent mode *
 *******************************************/
BEGIN_ARGUMENT :
    LBrack
    {
  // If we are in a lexer rule, then the brackets can only represent a lexer 
  // char set definition so we pass in lexer char set mode
     if (inLexerRule()) {
 //        System.out.println("It is a lexer char set definition");
         pushMode(ANTLRv4Lexer.LexerCharSet);
         more();
  // else we are in a parser rule and the brackets represent argument(s)
     } else {
 //        System.out.println("It is an argument definition");
         pushMode(ANTLRv4Lexer.Argument);
     }
    }
    ;


// -------------------------
// Actions

BEGIN_ACTION :
    LBrace -> pushMode(Action)
    ;

// -------------------------
// Keywords
//
// Keywords may not be used as labels for rules or in any other context where
// they would be ambiguous with the keyword vs some other identifier.  OPTIONS,
// TOKENS, & CHANNELS blocks are handled idiomatically in dedicated lexical modes.

OPTIONS
   : 'options' -> pushMode (Options)
   ;


TOKENS
   : 'tokens' -> pushMode (Tokens)
   ;


CHANNELS
   : 'channels' -> pushMode (Channels)
   ;


IMPORT :
    'import'
    {
     _idMode = ANTLRv4Lexer.IMPORT;
    }
    ;


FRAGMENT :
    'fragment'
    {
     _idMode = ANTLRv4Lexer.FRAGMENT;
     _fragment = true;
    }
    ;


LEXER
   : 'lexer'
   ;


PARSER
   : 'parser'
   ;


GRAMMAR :
    'grammar'
    {
     _idMode=ANTLRv4Lexer.GRAMMAR;
    }
    ;


PROTECTED
   : 'protected'
   ;


PUBLIC
   : 'public'
   ;


PRIVATE
   : 'private'
   ;


RETURNS
   : 'returns'
   ;


LOCALS
   : 'locals'
   ;


THROWS
   : 'throws'
   ;


CATCH
   : 'catch'
   ;


FINALLY
   : 'finally'
   ;


MODE :
    'mode'
    {
     _idMode = ANTLRv4Lexer.MODE;
    }
    ;


// -------------------------
// Punctuation

COLON :
    Colon
    {
     if (_idMode == ANTLRv4Lexer.FRAGMENT)
         _idMode = 0;
    }
    ;


COLONCOLON
   : DColon
   ;


COMMA
   : Comma
   ;


SEMI :
    Semi
    {
     if ((_idMode == ANTLRv4Lexer.GRAMMAR) ||
         (_idMode == ANTLRv4Lexer.IMPORT)  ||
         (_idMode == ANTLRv4Lexer.MODE)      )
         _idMode = 0;
    if (_fragment)
        _fragment = false;
    }
    ;


LPAREN
   : LParen
   ;


RPAREN
   : RParen
   ;


LBRACE
   : LBrace
   ;


RBRACE
   : RBrace
   ;


RARROW :
    RArrow -> pushMode(LexerCommands)
    ;


LT
   : Lt
   ;


ASSOC :
    'assoc'
    ;


RIGHT :
    'right'
    ;


LEFT :
    'left'
    ;


FAIL :
    'fail'
    ;


GT
   : Gt
   ;


ASSIGN
   : Equal
   ;


QUESTION
   : Question
   ;


STAR
   : Star
   ;


PLUS_ASSIGN
   : PlusAssign
   ;


PLUS
   : Plus
   ;


OR
   : Pipe
   ;


DOLLAR
   : Dollar
   ;


RANGE
   : Range
   ;


DOT
   : Dot
   ;


AT
   : At
   ;


HEADER :
    'header'
    ;


MEMBERS :
    'members'
    ;


SHARP
   : Sharp
   ;


NOT
   : Tilde
   ;

// -------------------------
// Identifiers - allows unicode rule/token names

ID :
    NameStartChar NameChar*
    {
//     System.out.println("ID token rule");
     String idValue = getText();
//     System.out.println("ID value=" + idValue);
     if (_idMode == 0) {
         if ( Character.isUpperCase(idValue.charAt(0)) )
             setType(ID_STARTING_WITH_UPPERCASE);
         else
             setType(ID_STARTING_WITH_LOWERCASE);
     }
    }
    ;


// -------------------------
// Whitespace
// FYV : channel (OFF_CHANNEL) replaced by skip
WS
   : Ws + -> skip
   ;


// -------------------------
// Illegal Characters
//
// This is an illegal character trap which is always the last rule in the
// lexer specification. It matches a single character of any value and being
// the last rule in the file will match when no other rule knows what to do
// about the character. It is reported as an error but is not passed on to the
// parser. This means that the parser to deal with the gramamr file anyway
// but we will not try to analyse or code generate from a file with lexical
// errors.
//
// Comment this rule out to allow the error to be propagated to the parse
ERRCHAR
   : .
   ;




// ======================================================
// Lexer modes
// -------------------------
// Arguments
mode Argument;
// E.g., [int x, List<String> a[]]
NESTED_ARGUMENT
   : LBrack -> type (ARGUMENT_CONTENT) , pushMode (Argument)
   ;

ARGUMENT_ESCAPE
   : EscAny -> type (ARGUMENT_CONTENT)
   ;

ARGUMENT_STRING_LITERAL
   : DQuoteLiteral -> type (ARGUMENT_CONTENT)
   ;

ARGUMENT_CHAR_LITERAL
   : SQuoteLiteral -> type (ARGUMENT_CONTENT)
   ;

END_ARGUMENT :
    RBrack
    {
     popMode();
     if (_modeStack.size() > 0) {
         setType(ANTLRv4Lexer.ARGUMENT_CONTENT);
     }
    }
    ;
      
// added this to return non-EOF token type here. EOF does something weird
UNTERMINATED_ARGUMENT
   : EOF -> popMode
   ;

ARGUMENT_CONTENT
   : .
   ;


// -------------------------
// Actions
//
// Many language targets use {} as block delimiters and so we
// must recursively match {} delimited blocks to balance the
// braces. Additionally, we must make some assumptions about
// literal string representation in the target language. We assume
// that they are delimited by ' or " and so consume these
// in their own alts so as not to inadvertantly match {}.
mode Action;
NESTED_ACTION
   : LBrace -> type (ACTION_CONTENT) , pushMode (Action)
   ;

ACTION_ESCAPE
   : EscAny -> type (ACTION_CONTENT)
   ;

ACTION_STRING_LITERAL
   : DQuoteLiteral -> type (ACTION_CONTENT)
   ;

ACTION_CHAR_LITERAL
   : SQuoteLiteral -> type (ACTION_CONTENT)
   ;

ACTION_DOC_COMMENT
   : DocComment -> type (ACTION_CONTENT)
   ;

ACTION_BLOCK_COMMENT
   : BlockComment -> type (ACTION_CONTENT)
   ;

ACTION_LINE_COMMENT
   : LineComment -> type (ACTION_CONTENT)
   ;

END_ACTION :
    RBrace
    {
     popMode();
     if (_modeStack.size() > 0) {
        setType(ANTLRv4Lexer.ACTION_CONTENT);
     }
    }
    ;

UNTERMINATED_ACTION
   : EOF -> popMode
   ;

ACTION_CONTENT
   : .
   ;

// -------------------------
mode Options;
OPT_DOC_COMMENT
   : DocComment -> type (DOC_COMMENT)
   ;

OPT_BLOCK_COMMENT
   : BlockComment -> type (BLOCK_COMMENT), skip
   ;

OPT_LINE_COMMENT
   : LineComment -> type (LINE_COMMENT), skip
   ;

OPT_LBRACE
   : LBrace -> type (LBRACE)
   ;

OPT_RBRACE
   : RBrace -> type (RBRACE) , popMode
   ;

SUPER_CLASS :
    'superClass'
    ;

LANGUAGE :
    'language'
    ;

TOKEN_VOCAB :
    'tokenVocab'
    ;

TOKEN_LABEL_TYPE :
    'TokenLabelType'
    ;

OPT_ID :
    NameStartChar NameChar* -> type(ID)
    ;

OPT_DOT
   : Dot -> type (DOT)
   ;

OPT_ASSIGN
   : Equal -> type (ASSIGN)
   ;

OPT_STRING_LITERAL
   : SQuoteLiteral -> type (STRING_LITERAL)
   ;

OPT_INT
   : Int -> type (INT)
   ;

OPT_STAR
   : Star -> type (STAR)
   ;

OPT_SEMI
   : Semi -> type (SEMI)
   ;

OPT_WS
   : Ws + -> type (WS), skip
   ;

OPT_ERR :
    . -> type(ERRCHAR)
    ;

// -------------------------
mode Tokens;
TOK_DOC_COMMENT
   : DocComment -> type (DOC_COMMENT)
   ;

TOK_BLOCK_COMMENT
   : BlockComment -> type (BLOCK_COMMENT), skip
   ;

TOK_LINE_COMMENT
   : LineComment -> type (LINE_COMMENT), skip
   ;

TOK_LBRACE
   : LBrace -> type (LBRACE)
   ;

TOK_RBRACE
   : RBrace -> type (RBRACE) , popMode
   ;

TOK_ID :
    NameStartChar NameChar*
    {
     String idValue = getText();
     if ( Character.isUpperCase(idValue.charAt(0)) )
         setType(ID_STARTING_WITH_UPPERCASE);
     else
         setType(ID_STARTING_WITH_LOWERCASE);
//     System.out.println("TOK_ID: returned token type=" + _SYMBOLIC_NAMES[_type]);
    }
    ;

TOK_DOT
   : Dot -> type (DOT)
   ;

TOK_COMMA
   : Comma -> type (COMMA)
   ;

TOK_WS
   : Ws + -> type (WS) , skip
   ;

// -------------------------
mode Channels;
// currently same as Tokens mode; distinguished by keyword
CHN_DOC_COMMENT
   : DocComment -> type (DOC_COMMENT)
   ;

CHN_BLOCK_COMMENT
   : BlockComment -> type (BLOCK_COMMENT), skip
   ;

CHN_LINE_COMMENT
   : LineComment -> type (LINE_COMMENT), skip
   ;

CHN_LBRACE
   : LBrace -> type (LBRACE)
   ;

CHN_RBRACE
   : RBrace -> type (RBRACE) , popMode
   ;

// FYV : a channel identifier is always an ID whatever the first letter is
CHN_ID :
    NameStartChar NameChar* -> type(ID)
    ;

CHN_DOT
   : Dot -> type (DOT)
   ;

CHN_COMMA
   : Comma -> type (COMMA)
   ;

CHN_WS
   : Ws + -> type (WS) , skip
   ;

/******************
 * Lexer commands *
 ******************/
mode LexerCommands;

LEXER_COMMAND_LINE_COMMENT :
    LineComment -> type (LINE_COMMENT), skip
    ;

SKIP_COMMAND :
    'skip'
    ;

MORE_COMMAND :
    'more'
    ;

TYPE_COMMAND :
    'type'
    ;

CHANNEL_COMMAND :
    'channel'
    ;

MODE_COMMAND :
    'mode'
    ;

PUSHMODE_COMMAND :
    'pushMode'
    ;

POPMODE_COMMAND :
    'popMode'
    ;

LEXER_COMMAND_LPAREN :
    LParen -> type(LPAREN)
    ;

LEXER_COMMAND_ID :
    NameStartChar NameChar* -> type(ID)
    ;

LEXER_COMMAND_INT :
    DecimalNumeral -> type(INT)
    ;

LEXER_COMMAND_RPAREN :
    RParen -> type(RPAREN)
    ;

LEXER_COMMAND_COMMA :
    Comma -> type(COMMA)
    ;

LEXER_COMMAND_WS :
    Ws + -> type(WS), skip
    ;

LEXER_COMMAND_SEMI :
    Semi -> popMode, type(SEMI)
    ;


// -------------------------

mode LexerCharSet;
LEXER_CHAR_SET_BODY
   : (~ [\]\\] | EscAny) + -> more
  ;

LEXER_CHAR_SET
   : RBrack -> popMode
   ;

UNTERMINATED_CHAR_SET
   : EOF -> popMode
   ;
