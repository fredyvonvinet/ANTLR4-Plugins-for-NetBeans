/*
BSD License

Copyright (c) 2016, Frédéric Yvon Vinet
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

* Redistributions of source code must retain the above copyright
  notice, this list of conditions and the following disclaimer.
* Redistributions in binary form must reproduce the above copyright
  notice, this list of conditions and the following disclaimer in the
  documentation and/or other materials provided with the distribution.
* The name of its author may not be used to endorse or promote products
  derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY
EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT 
LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF 
LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF 
ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.nemesis.antlr.v4.netbeans.v8.grammar.code.completion;

import java.nio.file.Path;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.text.Document;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;

import org.antlr.v4.runtime.misc.IntervalSet;
import org.antlr.v4.runtime.tree.TerminalNode;

import org.nemesis.antlr.v4.netbeans.v8.grammar.code.completion.items.CommentCompletionItem;
import org.nemesis.antlr.v4.netbeans.v8.grammar.code.completion.items.GrammarCompletionItem;
import org.nemesis.antlr.v4.netbeans.v8.grammar.code.completion.items.IdentifierCompletionItem;
import org.nemesis.antlr.v4.netbeans.v8.grammar.code.completion.items.KeywordCompletionItem;
import org.nemesis.antlr.v4.netbeans.v8.grammar.code.completion.items.ParserRuleIdentifierCompletionItem;
import org.nemesis.antlr.v4.netbeans.v8.grammar.code.completion.items.PunctuationCompletionItem;
import org.nemesis.antlr.v4.netbeans.v8.grammar.code.completion.items.StringLiteralCompletionItem;
import org.nemesis.antlr.v4.netbeans.v8.grammar.code.completion.items.LexerRuleIdCompletionItem;

import org.nemesis.antlr.v4.netbeans.v8.grammar.code.summary.GrammarType;

import org.nemesis.antlr.v4.netbeans.v8.grammar.code.checking.impl.ANTLRv4Lexer;
import org.nemesis.antlr.v4.netbeans.v8.grammar.code.checking.impl.ANTLRv4Parser;
import org.nemesis.antlr.v4.netbeans.v8.grammar.code.checking.impl.ANTLRv4Parser.FragmentRuleDeclarationContext;

import org.nemesis.antlr.v4.netbeans.v8.grammar.code.summary.GrammarSummary;

import org.nemesis.antlr.v4.netbeans.v8.project.helper.ProjectHelper;

import org.netbeans.api.project.Project;

import org.netbeans.modules.editor.NbEditorUtilities;

/**
 *
 * @author Frédéric Yvon Vinet
 */
public class ExpectedTokenFinder extends BaseErrorListener {
    protected final Document                         doc;
    protected final Path                             grammarPath;
    protected final String                           grammarName;
    protected final GrammarType                      grammarType;
    protected final List<String>                     importedGrammarIds;
    protected final List<String>                     modes;
    protected final List<String>                     channels;
    protected final List<String>                     allTokenIds;
    protected final List<String>                     allFragmentRuleIds;
    protected final int                              lexerRuleNumber;
    protected final List<String>                     allParserRuleIds;
    
    protected int                                    insertionOffset;
    protected int                                    caretOffset;
    protected List<GrammarCompletionItem>            propositions;
    protected HashMap<String, HashMap<Integer,Rule>> rulesInError;
    protected boolean                                extraWhitespaceRequiredAfter;
    
    
    public boolean areThereAnyPropositions() {
        return !propositions.isEmpty();
    }
    
    public List<GrammarCompletionItem> getPropositions() {
        return propositions;
    }
    
    public HashMap<String, HashMap<Integer,Rule>> getRulesInError() {
        return rulesInError;
    }
    
    
    public ExpectedTokenFinder(Document doc                        ,
                               int      insertionOffset            ,
                               int      caretOffset                ,
                               boolean  extraWhitespaceRequiredAfter) {
//        System.out.println("ExpectedTokenFinder:ExpectedTokenFinder() : begin");
//        System.out.println("- document path=" + NbEditorUtilities.getFileObject(doc).getPath());
        assert doc != null;
        assert insertionOffset >= 0;
        assert insertionOffset <= doc.getLength();
        assert caretOffset >= 0;
        assert caretOffset <= doc.getLength();
        this.doc               = doc;
        GrammarSummary summary = (GrammarSummary) doc.getProperty
                                                         (GrammarSummary.class);
     // For recovering the grammar path, it is also possible to do it from doc
     // with :
     // Path grammarPath = NbEditorUtilities.getFileObject(doc).toFile().toPath();
        this.grammarPath          = summary.getSourceFilePath();
     // For recovering the grammar name, it is also possible to do it from doc
     // with :
     // String grammarName = NbEditorUtilities.getFileObject(doc).getName();
        this.grammarName          = summary.getGrammarName();
        this.grammarType          = summary.getGrammarType();
        this.importedGrammarIds   = summary.getImportedGrammars();
        this.modes                = summary.getModes();
        this.channels             = summary.getChannels();
        List<String> tokenRuleIds = summary.getTokenRuleIds();
        List<String> tokenIds     = summary.getTokens();
        List<String> importedTokenIds = summary.getImportedTokenIds();
        List<String> fragmentRuleIds  = summary.getFragmentRuleIds();
        List<String> importedFragmentRuleIds = summary.getImportedFragmentRuleIds();
        List<String> parserRuleIds1 = summary.getParserRuleIds();
        List<String> parserRuleIds2 = summary.getImportedParserRuleIds();
        
     // allTokenIds hosts all token ids defined or declared in current grammar
     // (through token rule or tokens block) or imported (from a tokens file or
     // grammar file)
        this.allTokenIds = new ArrayList<>();
        this.allTokenIds.addAll(tokenRuleIds);
        this.allTokenIds.addAll(tokenIds);
        this.allTokenIds.addAll(importedTokenIds);
/*
        System.out.println("imported token ids:");
        for (String tokenId : importedTokenIds)
            System.out.print(" " + tokenId);
        System.out.println();
*/
        
        this.allFragmentRuleIds = new ArrayList<>();
        this.allFragmentRuleIds.addAll(fragmentRuleIds);
        this.allFragmentRuleIds.addAll(importedFragmentRuleIds);
        
        this.allParserRuleIds = new ArrayList<>();
        this.allParserRuleIds.addAll(parserRuleIds1);
        this.allParserRuleIds.addAll(parserRuleIds2);

        this.lexerRuleNumber              = summary.getTokenRuleNumber();
        
        this.insertionOffset              = insertionOffset;
        this.caretOffset                  = caretOffset;
        this.propositions                 = new ArrayList<>();
        this.rulesInError                 = new HashMap<>();
        this.extraWhitespaceRequiredAfter = extraWhitespaceRequiredAfter;

//        System.out.println("ExpectedTokenFinder:ExpectedTokenFinder() : end");
    }
    
    
    @Override
    public void syntaxError
        (Recognizer<?, ?>     recognizer        ,
         Object               offendingSymbol   ,
         int                  line              ,
         int                  charPositionInLine,
         String               msg               ,
         RecognitionException e                 ) {
//        System.out.println();
//        System.out.println("ExpectedTokenFinder:syntaxError(Recognizer<?, ?>, ...) : begin");

        ANTLRv4Parser parser = (ANTLRv4Parser) recognizer;

        List<String> stack = parser.getRuleInvocationStack();
        StringBuilder callStackBuilder = new StringBuilder();
        Iterator<String> stringIt = stack.iterator();
     // the stack is never empty so there is always one value
        Collections.reverse(stack);
        stringIt.hasNext();
        String value = stringIt.next();
        callStackBuilder.append(value);
        while (stringIt.hasNext()) {
            value = stringIt.next();
            callStackBuilder.append("/");
            callStackBuilder.append(value);
        }
        String callStack = callStackBuilder.toString();
//        System.out.println("- caret offset=" + caretOffset);
//        System.out.println("- call stack=" + callStack);
        
        ParserRuleContext prc = parser.getContext();
        int startOffset = prc.getStart().getStartIndex();
//        System.out.println("- rule start offset=" + startOffset);
        
     // If the rule is not ended: there is no stop token
        Token stopToken = prc.getStop();

        HashMap<Integer,Rule> sameRulesInError = rulesInError.get(callStack);
        if (sameRulesInError == null) {
            sameRulesInError = new HashMap<>();
            rulesInError.put(callStack, sameRulesInError);
        }
     // We determine if caret is located in the rule where an error has been 
     // found. If it is located in this rule we have got a prposition to do else
     // none
        boolean proposition = false;
        if (stopToken == null) {
         // We add current rule as in the map of rules in error with the same call stack
            sameRulesInError.put(startOffset, new Rule(callStack, startOffset));
            if (startOffset <= caretOffset)
                proposition  = true;
        } else {
            int stopOffset = prc.getStop().getStopIndex();
//            System.out.println("- rule stop offset=" + stopOffset);
            sameRulesInError.put(startOffset, new Rule(callStack, startOffset, stopOffset));
            if ((startOffset <= caretOffset) &&
                (caretOffset <= stopOffset)    ) {
                proposition  = true;
            }
        }
        if (proposition) {
//            System.out.println("- We should have got some propositions");
//            IntervalSet is = parser.getExpectedTokensWithinCurrentRule();
            IntervalSet is = parser.getExpectedTokens();
            List<Integer> tokens = is.toList();
//            if (tokens.isEmpty())
//                System.out.println(".. but in fact the list of expected tokens is empty");
            Iterator<Integer> tokenIt = tokens.iterator();
            while (tokenIt.hasNext()) {
                int tokenId = tokenIt.next();
                List<GrammarCompletionItem> grammarCompletionItems =
                                      convertIntoCompletionItem
                                             (prc                        ,
                                              tokenId                    ,
                                              callStackBuilder.toString());
                propositions.addAll(grammarCompletionItems);
            }
        }

//        System.out.println("ExpectedTokenFinder:syntaxError(Recognizer<?, ?>, ...) : end");
    }
    
    
    private List<GrammarCompletionItem> convertIntoCompletionItem
            (ParserRuleContext prc, int tokenId, String callStack) {
//        System.out.println("ExpectedTokenFinder:convertIntoCompletionItem(int) -> GrammarCompletionItem : begin");
        String tokenLiteralName = ANTLRv4Parser.VOCABULARY.getLiteralName(tokenId);
//        System.out.println("- token id=" + tokenId);
//        System.out.println("  token type=" + ANTLRv4Parser.VOCABULARY.getSymbolicName(tokenId));
//        System.out.println("  token literal name=" + tokenLiteralName);
//        System.out.println("- call stack=" + callStack);
        
        List<GrammarCompletionItem> answer = new ArrayList<>();
        String tokenValue = null;
        if (tokenLiteralName != null) {
         // We remove the "'" characters located at start and end of literal name
            tokenValue = tokenLiteralName.substring(1, tokenLiteralName.length() - 1);
//            System.out.println("  token value=" + tokenValue);
        }

        GrammarCompletionItem gci;
        switch (tokenId) {
            case ANTLRv4Lexer.OPTIONS:
            case ANTLRv4Lexer.TOKENS:
            case ANTLRv4Lexer.LEXER:
            case ANTLRv4Lexer.PARSER:
            case ANTLRv4Lexer.GRAMMAR:
            case ANTLRv4Lexer.CATCH:
            case ANTLRv4Lexer.FINALLY:
            case ANTLRv4Lexer.ASSOC:
            case ANTLRv4Lexer.HEADER:
            case ANTLRv4Lexer.MEMBERS:
            case ANTLRv4Lexer.SUPER_CLASS:
            case ANTLRv4Lexer.LANGUAGE:
            case ANTLRv4Lexer.TOKEN_VOCAB:
            case ANTLRv4Lexer.TOKEN_LABEL_TYPE:
            case ANTLRv4Lexer.LEXCOM_SKIP:
            case ANTLRv4Lexer.LEXCOM_MORE:
            case ANTLRv4Lexer.LEXCOM_TYPE:
            case ANTLRv4Lexer.LEXCOM_CHANNEL:
            case ANTLRv4Lexer.LEXCOM_PUSHMODE:
            case ANTLRv4Lexer.LEXCOM_POPMODE:
                gci = new KeywordCompletionItem
                           (tokenValue                  ,
                            insertionOffset             ,
                            caretOffset                 ,
                            extraWhitespaceRequiredAfter);
                answer.add(gci);
                break;
            
            case ANTLRv4Lexer.CHANNELS:
            case ANTLRv4Lexer.MODE:
            case ANTLRv4Lexer.FRAGMENT:
             // We propose these keywords as code completion only if we are in
             // a lexer grammar
                switch (grammarType) {
                    case LEXER:
                    case COMBINED:
                        gci = new KeywordCompletionItem
                           (tokenValue                  ,
                            insertionOffset             ,
                            caretOffset                 ,
                            extraWhitespaceRequiredAfter);
                        answer.add(gci);
                        break;
                    default:
                }
                break;
                
            case ANTLRv4Lexer.RIGHT:
                tokenValue = "right";
                gci = new KeywordCompletionItem
                           (tokenValue                  ,
                            insertionOffset             ,
                            caretOffset                 ,
                            extraWhitespaceRequiredAfter);
                answer.add(gci);
                break;
            case ANTLRv4Lexer.LEFT:
                tokenValue = "left";
                gci = new KeywordCompletionItem
                           (tokenValue                  ,
                            insertionOffset             ,
                            caretOffset                 ,
                            extraWhitespaceRequiredAfter);
                answer.add(gci);
                break;
                
            case ANTLRv4Lexer.LEXCOM_MODE:
                tokenValue = "mode";
                gci = new KeywordCompletionItem
                              (tokenValue                  ,
                               insertionOffset             ,
                               caretOffset                 ,
                               extraWhitespaceRequiredAfter);
                answer.add(gci);
                break;
            case ANTLRv4Lexer.INIT:
                tokenValue = "init";
                gci = new KeywordCompletionItem
                              (tokenValue                  ,
                               insertionOffset             ,
                               caretOffset                 ,
                               extraWhitespaceRequiredAfter);
                answer.add(gci);
                break;
            case ANTLRv4Lexer.AFTER:
                tokenValue = "after";
                gci = new KeywordCompletionItem
                                 (tokenValue                  ,
                                  insertionOffset             ,
                                  caretOffset                 ,
                                  extraWhitespaceRequiredAfter);
                answer.add(gci);
                break;
            case ANTLRv4Lexer.THROWS:
                tokenValue = "throws";
                gci = new KeywordCompletionItem
                                  (tokenValue                  ,
                                   insertionOffset             ,
                                   caretOffset                 ,
                                   extraWhitespaceRequiredAfter);
                answer.add(gci);
                break;
            case ANTLRv4Lexer.LOCALS:
                tokenValue = "locals";
                gci = new KeywordCompletionItem
                                 (tokenValue                  ,
                                  insertionOffset             ,
                                  caretOffset                 ,
                                  extraWhitespaceRequiredAfter);
                answer.add(gci);
                break;
            case ANTLRv4Lexer.RETURNS:
                tokenValue = "returns";
                gci = new KeywordCompletionItem
                                    (tokenValue                  ,
                                     insertionOffset             ,
                                     caretOffset                 ,
                                     extraWhitespaceRequiredAfter);
                answer.add(gci);
                break;
                
            case ANTLRv4Lexer.ID:
             // We try to determine if we are able to determine a value for
             // this identifier
             // We may find an identifier in:
             // - a grammar declaration,
             // - a grammar import,
             // - an option list declaration (tokenVocab, superClass, 
             //   TokenLabelType),
             // - a channel list declaration,
             // - a channel lexer statement,
             // - a mode declaration,
             // - a rule elment label,
             // - a rule alternative label,
             // - a pushMode, mode statement,
                if (callStack.equals("grammarFile/grammarSpec/identifier")) {
                 // Here whatever extraWhitespace says, we never add whitespace
                 // Here we propose the name of current grammar so grammarName
                 // may be null! So we deduce its value from its file name
                    tokenValue = NbEditorUtilities.getFileObject(doc).getName();;
                    gci = new IdentifierCompletionItem
                                    (tokenValue                  ,
                                     insertionOffset             ,
                                     caretOffset                 ,
                                     extraWhitespaceRequiredAfter);
                    answer.add(gci);
                } else if (callStack.equals
                        ("grammarFile/analyzerDirectiveSpec/delegateGrammars" +
                         "/delegateGrammarList/delegateGrammar")) {
                 // Caret cannot be placed on grammar name if there is one.
                 // It cannot be after grammar name because of call stack
                 // calue. So caret is necessarily placed before grammar
                 // name if there is one.
                 // If there is no grammar name it is proposed by next case.
                 // So the only possible case compatible with token type is
                 // to add a variable (referencing the name of imported 
                 // grammar)
                    tokenValue = "grammarLabel=";
                    gci = new IdentifierCompletionItem
                                   (tokenValue                  ,
                                     insertionOffset             ,
                                     caretOffset                 ,
                                     extraWhitespaceRequiredAfter);
                    answer.add(gci);
                 // We look for a grammar whose file is in ANTLR source 
                 // directory or ANTLR import directory
                 // Normally, we should eliminate grammars incompatible with
                 // current grammar type (from import point of view).
                 // It is not done yet.
                    List<String> possibleGrammarFiles =
                              ProjectHelper.retrieveGrammarsImportableFrom(doc);
                    Iterator<String> stringIt = possibleGrammarFiles.iterator();
                    String possibleGrammarFile;
                    while (stringIt.hasNext()) {
                        possibleGrammarFile = stringIt.next();
                        gci = new IdentifierCompletionItem
                                                 (possibleGrammarFile         ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                        answer.add(gci);
                    }
                } else if (callStack.equals
                        ("grammarFile/analyzerDirectiveSpec/delegateGrammars" +
                         "/delegateGrammarList/delegateGrammar"+
                         "/grammarIdentifier/identifier")) {
                 // We look for a grammar whose file is in ANTLR source 
                 // directory or ANTLR import directory
                 // Normally, we should eliminate grammars incompatible with
                 // current grammar type (from import point of view).
                 // It is not done yet.
                    List<String> possibleGrammarFiles =
                              ProjectHelper.retrieveGrammarsImportableFrom(doc);
                    Iterator<String> stringIt = possibleGrammarFiles.iterator();
                    String possibleGrammarFile;
                    while (stringIt.hasNext()) {
                        possibleGrammarFile = stringIt.next();
                        gci = new IdentifierCompletionItem
                                                 (possibleGrammarFile         ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                        answer.add(gci);
                    }
                } else if (callStack.equals
                        ("grammarFile/analyzerDirectiveSpec/optionsSpec" +
                         "/optionSpec/tokenLabelTypeSpec/classIdentifier" +
                         "/identifier")) {
                 // We look for Java classes implementing 
                 // org.antlr.v4.runtime.Token (some are provided by ANTLR
                 // library but new ones may provided by current project)
                    gci = new IdentifierCompletionItem
                                           ("org.antlr.v4.runtime.CommonToken",
                                            insertionOffset                   ,
                                            caretOffset                       ,
                                            extraWhitespaceRequiredAfter      );
                    answer.add(gci);
                    gci = new IdentifierCompletionItem
                             ("org.antlr.v4.runtime.tree.pattern.RuleTagToken",
                              insertionOffset                                 ,
                              caretOffset                                     ,
                              extraWhitespaceRequiredAfter                    );
                    answer.add(gci);
                    gci = new IdentifierCompletionItem
                            ("org.antlr.v4.runtime.tree.pattern.TokenTagToken",
                             insertionOffset                                  ,
                             caretOffset                                      ,
                             extraWhitespaceRequiredAfter                     );
                    answer.add(gci);
                        
                    Project project = ProjectHelper.getProject(doc);
                    List<String> possibleJavaClasses = ProjectHelper.
                              retrieveJavaClassesExtendingImplementingANTLRToken
                                                  (project);
                    Iterator<String> stringIt = possibleJavaClasses.iterator();
                    String possibleJavaClass;
                    while (stringIt.hasNext()) {
                        possibleJavaClass = stringIt.next();
                        gci = new IdentifierCompletionItem
                                                 (possibleJavaClass           ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                        answer.add(gci);
                    }
//                    System.out.println("final completion item number=" + answer.size());
                } else if (callStack.equals
                        ("grammarFile/analyzerDirectiveSpec/optionsSpec" +
                         "/optionSpec/superClassSpec/classIdentifier" +
                         "/identifier")) {
                 // We look for Java classes inheriting from
                 // org.antlr.v4.runtime.Lexer if it is a lexer grammar
                 // or from org.antlr.v4.runtime.Parser if it is a parser
                 // or combined grammar
                    Project project = ProjectHelper.getProject(doc);
                    List<String> possibleJavaClasses;
                    switch (grammarType) {
                        case LEXER:
//                            System.out.println("lexer grammar");
                            possibleJavaClasses = ProjectHelper.
                                          retrieveJavaClassesExtendingANTLRLexer
                                                                      (project);
                            break;
                        case PARSER:
                        case COMBINED: // For a combined grammar superClass applies to generated parser
                            possibleJavaClasses = ProjectHelper.
                                         retrieveJavaClassesExtendingANTLRParser
                                                                      (project);
                            break;
                        default:
 //                           System.out.println("undefined grammar");
                            possibleJavaClasses = null;
                    }
                    if (possibleJavaClasses != null) {
                        Iterator<String> stringIt =
                                                 possibleJavaClasses.iterator();
                        String possibleJavaClass;
                        while (stringIt.hasNext()) {
                            possibleJavaClass = stringIt.next();
                            gci = new IdentifierCompletionItem
                                                 (possibleJavaClass           ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                            answer.add(gci);
                        }
                    }
                } else if (callStack.equals
                        ("grammarFile/analyzerDirectiveSpec/optionsSpec" +
                         "/optionSpec/tokenVocabSpec/identifier")) {
//                    System.out.println("answer size=" + answer.size());
                 // We look for tokens file located in same directory
                 // as importing grammar or in imports directory or
                 // in destination directory
                 // Token files generated by current grammar must not be 
                 // proposed. In function of grammar type, token files 
                 // generated by current grammar are not the same.
                    List<String> excludedTokenFiles = new ArrayList<>();
                    excludedTokenFiles.add(grammarName);
                    if (grammarType == GrammarType.COMBINED) {
                     // If current grammar has at least one lexer rule
                     // then it will generate a token file associate to
                     // parser with the name of grammar and a token
                     // file associated to a lexer
//                        System.out.println("lexer Rule Number=" + lexerRuleNumber);
                        if (lexerRuleNumber != 0)
                            excludedTokenFiles.add(grammarName + "Lexer");
                    }
                    Project project = ProjectHelper.getProject(doc);
                    List<String> possibleTokenFiles = ProjectHelper.
                                       retrieveTokenFilesInProjectImportableFrom
                                     (project, grammarPath, excludedTokenFiles);
//                    System.out.println("- possible Token Files:");
                    for (String possibleTokenFile : possibleTokenFiles) {
//                        System.out.println("  * " + possibleTokenFile);
                        gci = new IdentifierCompletionItem
                                                 (possibleTokenFile           ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                        answer.add(gci);
                    }
                } else if
                    (callStack.equals
                        ("grammarFile/analyzerDirectiveSpec/channelsSpec") ||
                     callStack.equals
                        ("grammarFile/analyzerDirectiveSpec/channelsSpec" +
                         "/idList/identifier")) {
                 // We have to add an identifier to a channel
                    tokenValue = "AChannelId";
                    gci = new IdentifierCompletionItem
                                                 (tokenValue                  ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                    answer.add(gci);
                } else if
                    (callStack.equals
                        ("grammarFile/ruleSpec/lexerRuleSpec" +
                         "/tokenRuleDeclaration/lexerRuleBlock" +
                         "/lexerRuleAlt/lexerCommands/lexerCommand" +
                         "/lexComChannel") ||
                     callStack.equals
                        ("grammarFile/modeSpec/lexerRuleSpec" +
                         "/tokenRuleDeclaration/lexerRuleBlock" +
                         "/lexerRuleAlt/lexerCommands/lexerCommand" +
                         "/lexComChannel")) {
                 // We have to propose the list of channels defined in that
                 // grammar (are channels imported from other grammars?)
                    for (String channel : channels) {
                        gci = new IdentifierCompletionItem
                                                 (channel                        ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                        answer.add(gci);
                    }
                } else if
                   (callStack.equals
                        ("grammarFile/ruleSpec/lexerRuleSpec" +
                         "/tokenRuleDeclaration/lexerRuleBlock" +
                         "/lexerRuleAlt/lexerCommands/lexerCommand" +
                         "/lexComMode") ||
                     callStack.equals
                        ("grammarFile/modeSpec/lexerRuleSpec" +
                         "/tokenRuleDeclaration/lexerRuleBlock" +
                         "/lexerRuleAlt/lexerCommands/lexerCommand" +
                         "/lexComMode") ||
                     callStack.equals
                        ("grammarFile/ruleSpec/lexerRuleSpec" +
                         "/tokenRuleDeclaration/lexerRuleBlock" +
                         "/lexerRuleAlt/lexerCommands/lexerCommand" +
                         "/lexComPushMode") ||
                     callStack.equals
                        ("grammarFile/modeSpec/lexerRuleSpec" +
                         "/tokenRuleDeclaration/lexerRuleBlock" +
                         "/lexerRuleAlt/lexerCommands/lexerCommand" +
                         "/lexComPushMode")) {
                 // We have to propose the list of modes defined in that
                 // grammar (are modes imported from other grammars?)
                    for (String mode : modes) {
                        gci = new IdentifierCompletionItem
                                                 (mode                        ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                        answer.add(gci);
                    }
             // Next test must be placed after previous ones in order not to 
             // hide them
                } else if
                    (callStack.startsWith
                        ("grammarFile/ruleSpec/lexerRuleSpec") ||
                     callStack.startsWith
                        ("grammarFile/modeSpec/lexerRuleSpec")) {
                 // We propose to add an element label
                    gci = new IdentifierCompletionItem
                                                 ("elmtLabel"                 ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                    answer.add(gci);
                } else if (callStack.equals
                        ("grammarFile/ruleSpec/parserRuleSpec" +
                         "/parserRuleDefinition" +
                         "/parserRuleLabeledAlternative/identifier")) {
                 // We propose to add an alternative label
                    gci = new IdentifierCompletionItem
                                                 ("altLabel"                  ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                    answer.add(gci);
                } else if
                    (callStack.equals
                        ("grammarFile/ruleSpec/parserRuleSpec" +
                         "/parserRuleDefinition" + 
                         "/parserRuleLabeledAlternative" +
                         "/parserRuleAlternative") ||
                     callStack.equals
                        ("grammarFile/ruleSpec/parserRuleSpec" +
                         "/parserRuleDefinition" +
                         "/parserRuleLabeledAlternative" +
                         "/parserRuleAlternative/parserRuleElement" +
                         "/parserRuleAtom/terminal") ||
                     callStack.equals
                        ("grammarFile/ruleSpec/parserRuleSpec" +
                         "/parserRuleDefinition" +
                         "/parserRuleLabeledAlternative" +
                         "/parserRuleAlternative/parserRuleElement" +
                         "/labeledParserRuleElement" +
                         "/parserRuleAtom/terminal") ||
                     callStack.equals
                        ("grammarFile/ruleSpec/parserRuleSpec" +
                         "/parserRuleDefinition" +
                         "/parserRuleLabeledAlternative" +
                         "/parserRuleAlternative/parserRuleElement" +
                         "/ebnfSuffix") ||
                     callStack.equals
                        ("grammarFile/ruleSpec/parserRuleSpec" + 
                         "/parserRuleDefinition" +
                         "/parserRuleLabeledAlternative" +
                         "/parserRuleAlternative/parserRuleElement/ebnf") ||
                     callStack.equals
                        ("grammarFile/ruleSpec/parserRuleSpec" +
                         "/parserRuleDefinition" +
                         "/parserRuleLabeledAlternative" +
                         "/parserRuleAlternative/parserRuleElement/ebnf" +
                         "/block") ||
                     callStack.equals
                        ("grammarFile/ruleSpec/parserRuleSpec"+
                         "/parserRuleDefinition" +
                         "/parserRuleLabeledAlternative" +
                         "/parserRuleAlternative/parserRuleElement" +
                         "/ebnf/block/altList/parserRuleAlternative" +
                         "/parserRuleElement/labeledParserRuleElement" +
                         "/parserRuleAtom/terminal") ||
                     callStack.equals
                        ("grammarFile/ruleSpec/parserRuleSpec" +
                         "/parserRuleDefinition" +
                         "/parserRuleLabeledAlternative" +
                         "/parserRuleAlternative/parserRuleElement/ebnf"+
                         "/block/altList/parserRuleAlternative" +
                         "/parserRuleElement/ebnfSuffix")) {
                 // We propose to add an element label
                    gci = new IdentifierCompletionItem
                                                 ("elmtLabel"                 ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                    answer.add(gci);
                } else {
//                        System.out.println("unmanaged call stack value : " + callStack);
                }
                break;
                
            case ANTLRv4Lexer.BEGIN_ARGUMENT:
                tokenValue = "[";
                gci = new PunctuationCompletionItem
                                                 (tokenValue                  ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                answer.add(gci);
                break;
            case ANTLRv4Lexer.END_ARGUMENT:
                tokenValue = "]";
                gci = new PunctuationCompletionItem
                                                 (tokenValue                  , 
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                answer.add(gci);
                break;
            case ANTLRv4Lexer.BEGIN_ACTION:
                tokenValue = "{";
                gci = new PunctuationCompletionItem
                                                 (tokenValue                  ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                answer.add(gci);
                break;
            case ANTLRv4Lexer.END_ACTION:
                tokenValue = "}";
                gci = new PunctuationCompletionItem
                                                 (tokenValue                  ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                answer.add(gci);
                break;
            case ANTLRv4Lexer.COLON:
                tokenValue = ":";
                gci = new PunctuationCompletionItem
                                                 (tokenValue                  ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                answer.add(gci);
                break;
            case ANTLRv4Lexer.COLONCOLON:
                tokenValue = "::";
                gci = new PunctuationCompletionItem
                                                 (tokenValue                  ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                answer.add(gci);
                break;
            case ANTLRv4Lexer.COMMA:
                tokenValue = ",";
                gci = new PunctuationCompletionItem
                                                 (tokenValue                  ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                answer.add(gci);
                break;
            case ANTLRv4Lexer.SEMI:
                tokenValue = ";";
                gci = new PunctuationCompletionItem
                                                 (tokenValue                  ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                answer.add(gci);
                break;
            case ANTLRv4Lexer.LPAREN:
                tokenValue = "(";
                gci = new PunctuationCompletionItem
                                                 (tokenValue                  ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                answer.add(gci);
                break;
            case ANTLRv4Lexer.RPAREN:
                tokenValue = ")";
                gci = new PunctuationCompletionItem
                                                 (tokenValue                  ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                answer.add(gci);
                break;
            case ANTLRv4Lexer.LBRACE:
                tokenValue = "{";
                gci = new PunctuationCompletionItem
                                                 (tokenValue                  ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                answer.add(gci);
                break;
            case ANTLRv4Lexer.RBRACE:
                tokenValue = "}";
                gci = new PunctuationCompletionItem
                                                 (tokenValue                  ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                answer.add(gci);
                break;
            case ANTLRv4Lexer.RARROW:
             // Completion box displays text as HTML so '>' character use is
             // forbidden
                tokenValue = "-&gt;";
                gci = new PunctuationCompletionItem
                                                 (tokenValue                  ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                answer.add(gci);
                break;
            case ANTLRv4Lexer.LT:
             // Completion box displays text as HTML so '<' character use is
             // forbidden
                tokenValue = "&lt;";
                gci = new PunctuationCompletionItem
                                                 (tokenValue                  ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                answer.add(gci);
                break;
            case ANTLRv4Lexer.GT:
             // Completion box displays text as HTML so '>' character use is
             // forbidden
                tokenValue = "&gt;";
                gci = new PunctuationCompletionItem
                                                 (tokenValue                  ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                answer.add(gci);
                break;
            case ANTLRv4Lexer.ASSIGN:
                tokenValue = "=";
                gci = new PunctuationCompletionItem
                                                 (tokenValue                  ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                answer.add(gci);
                break;
            case ANTLRv4Lexer.QUESTION:
                tokenValue = "?";
                gci = new PunctuationCompletionItem
                                                 (tokenValue                  ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                answer.add(gci);
                break;
            case ANTLRv4Lexer.STAR:
                tokenValue = "*";
                gci = new PunctuationCompletionItem
                                                 (tokenValue                  ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                answer.add(gci);
                break;
            case ANTLRv4Lexer.PLUS_ASSIGN:
                tokenValue = "+=";
                gci = new PunctuationCompletionItem
                                                 (tokenValue                  ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                answer.add(gci);
                break;
            case ANTLRv4Lexer.PLUS:
                tokenValue = "+";
                gci = new PunctuationCompletionItem
                                                 (tokenValue                  ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                answer.add(gci);
                break;
            case ANTLRv4Lexer.OR:
                tokenValue = "|";
                gci = new PunctuationCompletionItem
                                                 (tokenValue                  ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                answer.add(gci);
                break;
            case ANTLRv4Lexer.DOLLAR:
                tokenValue = "*";
                gci = new PunctuationCompletionItem
                                                 (tokenValue                  ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                answer.add(gci);
                break;
            case ANTLRv4Lexer.RANGE:
                tokenValue = "..";
                gci = new PunctuationCompletionItem
                                                 (tokenValue                  ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                answer.add(gci);
                break;
            case ANTLRv4Lexer.DOT:
                tokenValue = ".";
                gci = new PunctuationCompletionItem
                                                 (tokenValue                  ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                answer.add(gci);
                break;
            case ANTLRv4Lexer.AT:
                tokenValue = "@";
                gci = new PunctuationCompletionItem
                                                 (tokenValue                  ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                answer.add(gci);
                break;
            case ANTLRv4Lexer.SHARP:
                tokenValue = "#";
                gci = new PunctuationCompletionItem
                                                 (tokenValue                  ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                answer.add(gci);
                break;
            case ANTLRv4Lexer.NOT:
                tokenValue = "~";
                gci = new PunctuationCompletionItem
                                                 (tokenValue                  ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                answer.add(gci);
                break;
                
            case ANTLRv4Lexer.INT:
                switch (callStack) {
                    case "grammarFile/ruleSpec/lexerRuleSpec" +
                         "/tokenRuleDeclaration/lexerRuleBlock/lexerRuleAlt" +
                         "/lexerCommands/lexerCommand":
                    case "grammarFile/modeSpec/lexerRuleSpec" +
                         "/tokenRuleDeclaration/lexerRuleBlock/lexerRuleAlt" +
                         "/lexerCommands/lexerCommand":
                     // The only lexer command not managed at a lower level and
                     // that could accept an integer value as parameter is
                     // type().
                     // Normally we have to propose the list of integer values 
                     // corresponding to available tokens.
                     // But as putting integer in place of token label is very
                     // dangerous, we propose nothing voluntarily
                        break;
                    case "grammarFile/ruleSpec/lexerRuleSpec" +
                         "/tokenRuleDeclaration/lexerRuleBlock/lexerRuleAlt" +
                         "/lexerCommands/lexerCommand/lexComChannel":
                    case "grammarFile/modeSpec/lexerRuleSpec" +
                         "/tokenRuleDeclaration/lexerRuleBlock/lexerRuleAlt" +
                         "/lexerCommands/lexerCommand/lexComChannel":
                     // Normally we have to propose the list of integer values 
                     // corresponding to available channels.
                     // But as putting integer in place of a channel label is 
                     // very dangerous, we propose nothing voluntarily
                        break;
                    case "grammarFile/ruleSpec/lexerRuleSpec" +
                         "/tokenRuleDeclaration/lexerRuleBlock/lexerRuleAlt" +
                         "/lexerCommands/lexerCommand/lexComPushMode":
                    case "grammarFile/modeSpec/lexerRuleSpec" +
                         "/tokenRuleDeclaration/lexerRuleBlock/lexerRuleAlt" +
                         "/lexerCommands/lexerCommand/lexComPushMode":
                    case "grammarFile/ruleSpec/lexerRuleSpec" +
                         "/tokenRuleDeclaration/lexerRuleBlock/lexerRuleAlt" +
                         "/lexerCommands/lexerCommand/lexComMode":
                    case "grammarFile/modeSpec/lexerRuleSpec" +
                         "/tokenRuleDeclaration/lexerRuleBlock/lexerRuleAlt" +
                         "/lexerCommands/lexerCommand/lexComMode":
                     // Normally we have to propose the list of integer values 
                     // corresponding to available modes.
                     // But as putting integer in place of a mode label is very
                     // dangerous, we propose nothing voluntarily
                        break;
                    default:
//                        System.out.println("unmanaged call stack value=" + callStack);
                }
                break;
            case ANTLRv4Lexer.STRING_LITERAL:
                switch (callStack) {
                    case "grammarFile/analyzerDirectiveSpec/optionsSpec/optionSpec/languageSpec":
                        tokenValue = "'Java'";
                        gci = new StringLiteralCompletionItem
                                                 (tokenValue                  ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                        answer.add(gci);
                        tokenValue = "'JavaScript'";
                        gci = new StringLiteralCompletionItem
                                                 (tokenValue                  ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                        answer.add(gci);
                        tokenValue = "'CSharp'";
                        gci = new StringLiteralCompletionItem
                                                 (tokenValue                  ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                        answer.add(gci);
                        tokenValue = "'Python2'";
                        gci = new StringLiteralCompletionItem
                                                 (tokenValue                  ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                        answer.add(gci);
                        tokenValue = "'Python3'";
                        gci = new StringLiteralCompletionItem
                                                 (tokenValue                  ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                        answer.add(gci);
                        break;
                    default:
                        tokenValue = "'a string literal'";
                        gci = new StringLiteralCompletionItem
                                                 (tokenValue                  ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                        answer.add(gci);
                }
                break;
            case ANTLRv4Lexer.TOKEN_ID:
             // there are several possible cases in function of call stack
                if (callStack.equals("grammarFile") ||
                    callStack.equals("grammarFile/analyzerDirectiveSpec/tokensSpec") ||
                    callStack.equals("grammarFile/analyzerDirectiveSpec/tokensSpec/tokenList") ||
                    callStack.equals("grammarFile/ruleSpec") ||
                    callStack.equals("grammarFile/modeSpec") ) {
                 // Here, it means we have the possibility to create a new
                 // token declaration (but not if grammar is a parser grammar).
                 // There is an error so it means that it lacks one rule so a
                 // token rule or a parser rule is needed. Here we propose a
                 // token rule declaration
                    switch (grammarType) {
                        case LEXER:
                        case COMBINED:
                            gci= new LexerRuleIdCompletionItem
                                                 ("A_TOKEN_ID"                ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                            answer.add(gci);
                            break;
                        default:
                    }
                } else if (callStack.equals
                              ("grammarFile/ruleSpec/lexerRuleSpec"+
                               "/fragmentRuleDeclaration") ||
                           callStack.equals
                               ("grammarFile/modeSpec/lexerRuleSpec"+
                                "/fragmentRuleDeclaration") ) {
                    gci= new LexerRuleIdCompletionItem
                                                 ("A_FRAGMENT_ID"             ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                    answer.add(gci);
                    
                } else if (callStack.equals
                              ("grammarFile/ruleSpec/lexerRuleSpec"+
                               "/tokenRuleDeclaration/lexerRuleBlock" +
                               "/lexerRuleAlt/lexerCommands/lexerCommand") ||
                           callStack.equals
                               ("grammarFile/modeSpec/lexerRuleSpec"+
                                "/tokenRuleDeclaration/lexerRuleBlock" +
                                "/lexerRuleAlt/lexerCommands/lexerCommand") ) {
                 // The only possibility is that we are in a type lexer 
                 // command that requires a token id as a parameter.
                 // We have to propose all possible token ids available in 
                 // that grammar (defined in a token rule in that grammar or
                 // in an imported rule or declared in the tokens statement
                 // of that grammar)
                    for (String propTokenId : allTokenIds) {
                        gci= new LexerRuleIdCompletionItem
                                                 (propTokenId                 ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                        answer.add(gci);
                    }
             // Next test must be placed after the previous one for not hiding it
                } else if (callStack.startsWith
                              ("grammarFile/ruleSpec/lexerRuleSpec" + 
                               "/tokenRuleDeclaration/lexerRuleBlock") ||
                           callStack.startsWith
                              ("grammarFile/modeSpec/lexerRuleSpec" + 
                               "/tokenRuleDeclaration/lexerRuleBlock")   ) {
                 // We are in a lexer token rule and ANTLR propose to add a 
                 // TOKEN_ID.
                 // In fact it proposes to add a fragment id because we cannot
                 // reference a token in a token rule
                    for (String fragmentId : allFragmentRuleIds) {
                        gci= new LexerRuleIdCompletionItem
                                                 (fragmentId                  ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                        answer.add(gci);
                    }
                } else if (callStack.startsWith
                              ("grammarFile/ruleSpec/lexerRuleSpec" +
                               "/fragmentRuleDeclaration/lexerRuleBlock" +
                               "/lexerRuleAlt")                           ||
                           callStack.startsWith
                              ("grammarFile/modeSpec/lexerRuleSpec" +
                               "/fragmentRuleDeclaration/lexerRuleBlock" +
                               "/lexerRuleAlt")                             ) {
                 // We are in a fragment rule and ANTLR propose to add a
                 // TOKEN_ID.
                 // In fact it proposes to add a fragment id because we cannot
                 // reference a token in a fragment rule. And we must exclude
                 // current fragment from proposition because a fragment cannot
                 // reference itself. So we have to recover it from context.
                 // We climb in context hierarchy till we reach
                 // fragmentRuleDeclarationCointext
                    ParserRuleContext context = prc;
                    while (!(context instanceof FragmentRuleDeclarationContext)) {
                        context = context.getParent();
                    }
                    FragmentRuleDeclarationContext frdc =
                                       (FragmentRuleDeclarationContext) context;
                    TerminalNode fragmentIdTN = frdc.TOKEN_ID();
                    String currentFragmentId = null;
                    if (fragmentIdTN != null) {
                        Token fragmentIdToken = fragmentIdTN.getSymbol();
                        currentFragmentId = fragmentIdToken.getText();
//                        System.out.println("////// fragment Id=" + currentFragmentId);
                        if (currentFragmentId.equals("<missing TOKEN_ID>"))
                            currentFragmentId = null;
                    }
                    for (String fragmentId : allFragmentRuleIds) {
                        if (currentFragmentId == null ||
                            !fragmentId.equals(currentFragmentId)) {
                            gci= new LexerRuleIdCompletionItem
                                                 (fragmentId                  ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                            answer.add(gci);
                        }
                    }
                } else if (callStack.startsWith
                              ("grammarFile/ruleSpec/parserRuleSpec")) {
                 // We can add token
                    for (String propTokenId : allTokenIds) {
                        gci= new LexerRuleIdCompletionItem
                                                 (propTokenId                 ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                        answer.add(gci);
                    }
                 // ...  or fragment
                    for (String propFragId : allFragmentRuleIds) {
                        gci= new LexerRuleIdCompletionItem
                                                 (propFragId                  ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                        answer.add(gci);
                    }
                } else {
//                    System.out.println("unmanaged call stack value : " + callStack);
                }
                break;
            case ANTLRv4Lexer.PARSER_RULE_ID:
                if (callStack.equals("grammarFile")) {
                    switch (grammarType) {
                        case PARSER:
                        case COMBINED:
                         // It means we can propose to add a parser rule declaration
                            gci= new ParserRuleIdentifierCompletionItem
                                                 ("aParserRuleId"             ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                            answer.add(gci);
                            break;
                        default:
                    }
                } else if (callStack.equals("grammarFile/ruleSpec")) {
                 // It means we can propose to add a parser rule declaration
                    gci= new ParserRuleIdentifierCompletionItem
                                                 ("aParserRuleId"             ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                        answer.add(gci);
                } else if (callStack.startsWith
                        ("grammarFile/ruleSpec/parserRuleSpec" +
                         "/parserRuleDefinition")) {
                 // We propose the list of parser rule already defined
                    for (String parserRuleId : allParserRuleIds) {
                        gci= new ParserRuleIdentifierCompletionItem
                                                 (parserRuleId                ,
                                                  insertionOffset             ,
                                                  caretOffset                 ,
                                                  extraWhitespaceRequiredAfter);
                        answer.add(gci);
                    }
                } else {
//                    System.out.println("unmanaged call stack value : " + callStack);
                }
                break;
            case ANTLRv4Lexer.DOC_COMMENT:
                gci= new CommentCompletionItem("/** document comment */"   ,
                                               insertionOffset             ,
                                               caretOffset                 ,
                                               extraWhitespaceRequiredAfter);
                answer.add(gci);
                break;
            case ANTLRv4Lexer.IMPORT:
                gci= new KeywordCompletionItem("import"                    ,
                                               insertionOffset             ,
                                               caretOffset                 ,
                                               extraWhitespaceRequiredAfter);
                answer.add(gci);
                break;
            case ANTLRv4Lexer.LEXER_CHAR_SET:
                gci= new KeywordCompletionItem("[a-z]"                     ,
                                               insertionOffset             ,
                                               caretOffset                 ,
                                               extraWhitespaceRequiredAfter);
                answer.add(gci);
                break;
            default:
             // Strangely, ANTLR sometimes proposes token types with negative 
             // int value. Normally negative values are reserved for pseudo  
             // tokens like EOF (int value of -1) that marks the end of file.
             // We simply ignore these values. Other ones must lead to error
             // messages : a case has been forgotten!
                if (tokenId > 0)
                    System.err.println
                          ("Unmanaged token type=" +
                           ANTLRv4Lexer.VOCABULARY.getSymbolicName(tokenId) +
                           " int value=" + tokenId);
        }

//        System.out.println("ExpectedTokenFinder:convertIntoCompletionItem(int) -> GrammarCompletionItem : end");
        return answer;
    }
}