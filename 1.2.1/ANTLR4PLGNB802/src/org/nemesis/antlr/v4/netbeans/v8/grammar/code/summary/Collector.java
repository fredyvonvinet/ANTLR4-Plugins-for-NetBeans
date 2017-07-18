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
package org.nemesis.antlr.v4.netbeans.v8.grammar.code.summary;

import java.io.IOException;

import java.nio.file.Path;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.text.Document;

import org.antlr.v4.runtime.Token;

import org.antlr.v4.runtime.tree.TerminalNode;

import org.nemesis.antlr.v4.netbeans.v8.grammar.code.checking.impl.ANTLRv4BaseListener;
import org.nemesis.antlr.v4.netbeans.v8.grammar.code.checking.impl.ANTLRv4Parser.ChannelsSpecContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.code.checking.impl.ANTLRv4Parser.ClassIdentifierContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.code.checking.impl.ANTLRv4Parser.DelegateGrammarContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.code.checking.impl.ANTLRv4Parser.FragmentRuleDeclarationContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.code.checking.impl.ANTLRv4Parser.GenericClassIdentifierContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.code.checking.impl.ANTLRv4Parser.GrammarFileContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.code.checking.impl.ANTLRv4Parser.GrammarIdentifierContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.code.checking.impl.ANTLRv4Parser.GrammarSpecContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.code.checking.impl.ANTLRv4Parser.GrammarTypeContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.code.checking.impl.ANTLRv4Parser.IdListContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.code.checking.impl.ANTLRv4Parser.IdentifierContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.code.checking.impl.ANTLRv4Parser.ImportDeclarationContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.code.checking.impl.ANTLRv4Parser.ModeDecContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.code.checking.impl.ANTLRv4Parser.PackageIdentifierContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.code.checking.impl.ANTLRv4Parser.ParserRuleDeclarationContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.code.checking.impl.ANTLRv4Parser.ParserRuleIdentifierContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.code.checking.impl.ANTLRv4Parser.SingleTypeImportDeclarationContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.code.checking.impl.ANTLRv4Parser.SuperClassSpecContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.code.checking.impl.ANTLRv4Parser.TokenLabelTypeSpecContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.code.checking.impl.ANTLRv4Parser.TokenListContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.code.checking.impl.ANTLRv4Parser.TokenRuleDeclarationContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.code.checking.impl.ANTLRv4Parser.TokenVocabSpecContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.code.checking.impl.ANTLRv4Parser.TokensSpecContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.code.coloring.impl.ANTLRv4Lexer;

import org.openide.loaders.DataObjectNotFoundException;


/**
 *
 * @author Frédéric Yvon Vinet
 */
public class Collector extends ANTLRv4BaseListener {
    protected final Path           sourceFilePath;
    protected final Document       doc;
    protected       GrammarSummary summary;
    
    protected       String         currentMode;

    
    public Collector(Document doc, Path sourceFilePath)
            throws DataObjectNotFoundException, IOException  {
//        System.out.println("Collector:Collector(Document, Path) : begin");
//        System.out.println("- source file path=" + sourceFilePath);
        assert doc != null;
        assert sourceFilePath != null;
        this.sourceFilePath = sourceFilePath;
        this.doc            = doc;
        this.summary        = new GrammarSummary(sourceFilePath);
     // If doc had a previous summary then it is garbage collected
        this.doc.putProperty(GrammarSummary.class, summary);
        this.currentMode = DEFAULT_MODE;
     // We add the default mode to the list of modes at the end because we need
     // to do it only for lexer grammar so we nned to have grammar type.
//        System.out.println("Collector:Collector(Document, Path) : end");
    }
    
 // normally DEFAULT_MODE = "DEFAULT_MODE"
    private final static String DEFAULT_MODE = ANTLRv4Lexer.modeNames[0];
    @Override
    public void exitGrammarFile(GrammarFileContext ctx) {
//        System.out.println("Collector:exitGrammarFile(GrammarFileContext) : begin");
//        System.out.println("- processing of " + sourceFilePath);
     // At the end of file processing we are able to deduce the beginning of 
     // default mode
        GrammarType grammarType = summary.getGrammarType();
        if (grammarType == GrammarType.LEXER) {
         // We deduce where the default mode begins by recovering the first 
         // token rule of that mode
            Map<String, List<String>> tokenRuleIdOfMode = summary.getTokenRuleIdsOfMode();
            List<String> tokenRulesOfDefaultMode = tokenRuleIdOfMode.get(DEFAULT_MODE);
            if (tokenRulesOfDefaultMode != null) {
                if (!tokenRulesOfDefaultMode.isEmpty()) {
                 // We add the default mode to the list of modes
                    List<String> modes = this.summary.getModes();
                    modes.add(DEFAULT_MODE);
                    String firstRuleOfDefaultMode =
                                                 tokenRulesOfDefaultMode.get(0);
                    Map<String, Integer> tokenRuleIdStartOffsets =
                                           summary.getTokenRuleIdStartOffsets();
                    Map<String, Integer> tokenRuleIdEndOffsets =
                                             summary.getTokenRuleIdEndOffsets();
                    int firstRuleIdStartOffset =
                            tokenRuleIdStartOffsets.get(firstRuleOfDefaultMode);
                    int firstRuleIdEndOffset =
                              tokenRuleIdEndOffsets.get(firstRuleOfDefaultMode);
                    Map<String, Integer> modeStartOffsets = summary.getModeStartOffsets();
                    Map<String, Integer> modeEndOffsets = summary.getModeEndOffsets();
                    modeStartOffsets.put(DEFAULT_MODE, firstRuleIdStartOffset);
                    modeEndOffsets.put(DEFAULT_MODE, firstRuleIdEndOffset);
                }
            }
        }
        
        summary.save();
//        System.out.println("Collector:exitGrammarFile(GrammarFileContext) : end");
    }
    
    
    @Override
    public void exitGrammarSpec(GrammarSpecContext ctx) {
        GrammarType grammarType = GrammarType.UNDEFINED;
        int startOffset = -1, endOffset = -1;
        GrammarTypeContext gtc = ctx.grammarType();
        if (gtc != null) {
            TerminalNode lexer = gtc.LEXER();
            TerminalNode parser = gtc.PARSER();
            TerminalNode grammar = gtc.GRAMMAR();
            if (lexer != null  &&
                parser == null &&
                grammar != null  ) {
                grammarType = GrammarType.LEXER;
            }
            if (lexer == null  &&
                parser != null &&
                grammar != null  ) {
                grammarType = GrammarType.PARSER;
            }
            if (lexer == null  &&
                parser == null &&
                grammar != null  ) {
                grammarType = GrammarType.COMBINED;
            }
            
            String grammarName = null;
            IdentifierContext ic = ctx.identifier();
            if (ic != null) {
                TerminalNode idTN = ic.ID();
                if (idTN != null) {
                    Token idToken = idTN.getSymbol();
                    if (idToken != null) {
                        grammarName = idToken.getText();
                        if (grammarName.equals("<missing ID>")) {
                            grammarName = null;
                            startOffset = -1;
                            endOffset   = -1;
                        } else {
                            startOffset = idToken.getStartIndex();
                            endOffset   = idToken.getStopIndex();
                        }
                    }
                }
            }
            summary.setGrammarType(grammarType);
            summary.setGrammarName(grammarName);
            summary.setGrammarIdStartOffset(startOffset);
            summary.setGrammarIdEndOffset(endOffset);
        }
    }
    
    
 /**
  * Called at the end of a Java package declaration,
  * 
  * @param ctx 
  */
    @Override
    public void exitPackageIdentifier(PackageIdentifierContext ctx) {
        List<IdentifierContext> ids = ctx.identifier();
        if (ids != null) {
            Iterator<IdentifierContext> it = ids.iterator();
            StringBuilder packageNameBuilder = new StringBuilder();
            IdentifierContext ic;
            Token token;
            while (it.hasNext()) {
                ic = it.next();
                TerminalNode idTN = ic.ID();
                if (idTN != null) {
                    token = idTN.getSymbol();
                    if (token != null) {
                        String id = token.getText();
                        if (id.equals("<missing ID>"))
                            id = "";
                        if ("".equals(packageNameBuilder.toString()))
                            packageNameBuilder.append(id);
                        else {
                            packageNameBuilder.append(".");
                            packageNameBuilder.append(id);
                        }
                    }
                }
            }
            String packageName = packageNameBuilder.toString();
            summary.setPackageName(packageName);
        }
    }
    
    
/**
   * Called at the end of a Java import statement located in a @header action 
   * block. It is used for recovering all imported imported classes with their
   * package. With that information, we are able to check if a class used in 
   * an ANTLR declaration (TokenLabelType or superClass options) is really 
   * accessible.
   * It is also recovered for building an HyperlinkParser that will use that
   * information for generating an hyperlink for the same ANTLR declaration 
   * to the file containng the class.
   * 
   * @param ctx 
   */
    @Override
    public void exitImportDeclaration(ImportDeclarationContext ctx) {
//        System.out.println("Collector:exitImportDeclaration() : begin");
        SingleTypeImportDeclarationContext stidc = ctx.singleTypeImportDeclaration();
        ClassIdentifierContext cic = stidc.classIdentifier();
        StringBuilder classNameBuilder = new StringBuilder();
        IdentifierContext ic;
        List<IdentifierContext> idcs;
        String generic = null;
        int startOffset = -1;
        int endOffset = -1;
        if (cic != null) {
            idcs = cic.identifier();
        } else {
         // There is also the possibility to have a generic identifier
            GenericClassIdentifierContext gic = stidc.genericClassIdentifier();
         // Normally gic cannot be null except in case of syntax error
            if (gic != null) {
                idcs = gic.identifier();
                generic = ".*";
            } else
                idcs = null;
        }
        if (idcs != null) {
            Iterator<IdentifierContext> it = idcs.iterator();
            while (it.hasNext()) {
                ic = it.next();
                if (ic != null) {
                    TerminalNode idTN = ic.ID();
                    if (idTN != null) {
                        Token idToken = idTN.getSymbol();
                        if (idToken != null) {
                            String id = idToken.getText();
                            if (!id.equals("<missing ID>")) {
                                if ("".equals(classNameBuilder.toString()))
                                    classNameBuilder.append(id);
                                else {
                                    classNameBuilder.append(".");
                                    classNameBuilder.append(id);
                                }
                                if (startOffset == -1) 
                                    startOffset = idToken.getStartIndex();
                                if (endOffset < idToken.getStopIndex()) 
                                    endOffset = idToken.getStopIndex();
                            } else {
                                if (startOffset == -1) {
                                 // The id is missing and startOffset is not 
                                 // defined so the first id is missing so the
                                 // start of id is the next dot character if it
                                 // exists
                                    TerminalNode firstDot = null;
                                    if (cic != null) {
                                        firstDot = cic.DOT(0);
                                    } else {
                                        GenericClassIdentifierContext gic = stidc.genericClassIdentifier();
                                     // Normally gic cannot be null except in case of syntax error
                                        if (gic != null) {
                                            firstDot = gic.DOT(0);
                                        }
                                    }
                                    if (firstDot != null)
                                        startOffset =
                                           firstDot.getSymbol().getStartIndex();
                                }
                                
                            }
                        }
                    }
                }
            }
            if (generic != null)
                classNameBuilder.append(generic);
//            System.out.println("Collector : found import declaration = " + classNameBuilder.toString());
            String className = classNameBuilder.toString();
            summary.addJavaImport(className);
            summary.putJavaImportIdStartOffset(className, startOffset);
            summary.putJavaImportIdEndOffset(className, endOffset);
        }
//        System.out.println("Collector:exitImportDeclaration() : end");
    }
    
    
    @Override
    public void exitDelegateGrammar(DelegateGrammarContext ctx) {
        GrammarIdentifierContext gic = ctx.grammarIdentifier();
        if (gic != null) {
            IdentifierContext ic = gic.identifier();
            if (ic != null) {
                TerminalNode idTN = ic.ID();
                Token grammarIdToken = idTN.getSymbol();
                String grammarId = grammarIdToken.getText();
                if (!grammarId.equals("<missing ID>")) {
//                    System.out.println("grammar Id=" + grammarId);
                    summary.addImportedGrammar(grammarId);
                    int startOffset = grammarIdToken.getStartIndex();
                    int endOffset   = grammarIdToken.getStopIndex();
                    summary.putImportedGrammarIdStartOffset(grammarId, startOffset);
                    summary.putImportedGrammarIdEndOffset(grammarId, endOffset);
                }
            }
        }
    }
    
    
    @Override
    public void exitTokenVocabSpec(TokenVocabSpecContext ctx) {
        IdentifierContext ic = ctx.identifier();
        if (ic != null) {
            TerminalNode idTN = ic.ID();
         // If there is an equal sign without tokens file specified then idTN is
         // null
            if (idTN != null) {
                Token idToken = idTN.getSymbol();
                String tokenId = idToken.getText();
                if (!tokenId.equals("<missing ID>")) {
//                    System.out.println("token id=" + tokenId);
                    summary.addImportedTokenFile(tokenId);
                    int startOffset = idToken.getStartIndex();
                    summary.putImportedTokenFileIdStartOffset(tokenId, startOffset);
                    int endOffset   = idToken.getStopIndex();
                    summary.putImportedTokenFileIdEndOffset(tokenId, endOffset);
                }
            }
        }
    }
    
    
    @Override
    public void exitSuperClassSpec(SuperClassSpecContext ctx) {
        ClassIdentifierContext cic = ctx.classIdentifier();
        if (cic != null) {
            List<IdentifierContext> ics = cic.identifier();
            if (ics != null) {
                StringBuilder id = new StringBuilder();
                for (IdentifierContext ic : ics) {
                    String lid = ic.getText();
                    if (lid != null &&
                        !lid.equals("<missing ID>")) {
                        if (!id.toString().equals(""))
                            id.append(".");
                        id.append(lid);
                    }
                }
//                System.out.println("superClass=" + id.toString());
                summary.setSuperClass(id.toString());
            }
        }
    }
    
    
    @Override
    public void exitTokenLabelTypeSpec(TokenLabelTypeSpecContext ctx) {
        ClassIdentifierContext cic = ctx.classIdentifier();
        if (cic != null) {
            List<IdentifierContext> ics = cic.identifier();
            if (ics != null) {
                StringBuilder id = new StringBuilder();
                for (IdentifierContext ic : ics) {
                    String lid = ic.getText();
                    if (lid != null &&
                        !lid.equals("<missing ID>")) {
                        if (!id.toString().equals(""))
                            id.append(".");
                        id.append(lid);
                    }
                }
//                System.out.println("tokenClass=" + id.toString());
                summary.setTokenClass(id.toString());
            }
        }
    }
    
    
    @Override
    public void exitTokensSpec(TokensSpecContext ctx) {
        TokenListContext tlc = ctx.tokenList();
        if (tlc != null) {
            List<TerminalNode> idTNs = tlc.TOKEN_ID();
            Token idToken;
            String tokenId;
            for (TerminalNode idTN : idTNs) {
                idToken = idTN.getSymbol();
                tokenId = idToken.getText();
                summary.addToken(tokenId);
                int offset = idToken.getStartIndex();
                summary.putTokenOffset(tokenId, offset);
            }
        }
    }
    
    
    @Override
    public void exitChannelsSpec(ChannelsSpecContext ctx) {
        IdListContext ilc = ctx.idList();
     // If there is no identifier list then ilc is null
        if (ilc != null) {
            List<IdentifierContext> ics = ilc.identifier();
            for (IdentifierContext ic : ics) {
                TerminalNode idTN = ic.ID();
                Token idToken = idTN.getSymbol();
                    if (idToken != null) {
                    String id = idToken.getText();
                    if (!id.equals("<missing ID>")) {
//                        System.out.println("id=" + id);
                        summary.addChannel(id);
                        int startOffset = idToken.getStartIndex();
                        int endOffset   = idToken.getStopIndex();
                        summary.putChannelStartOffset(id, startOffset);
                        summary.putChannelEndOffset(id, endOffset);
                    }
                }
            }
        }
    }
    
    
    @Override
    public void exitModeDec(ModeDecContext ctx) {
        IdentifierContext ic = ctx.identifier();
     // ic is never null even if there is no identifier
        TerminalNode idTN = ic.ID();
        if (idTN != null) {
         // idTN is never null
            Token idToken = idTN.getSymbol();
         // idToken is never null
            String id = idToken.getText();
            int startOffset = idToken.getStartIndex();
            int endOffset = idToken.getStopIndex();
            summary.addMode(id);
            summary.putModeStartOffset(id, startOffset);
            summary.putModeEndOffset(id, endOffset);
            currentMode = id;
        }
    }
    
    
    @Override
    public void exitTokenRuleDeclaration (TokenRuleDeclarationContext ctx) {
//        System.out.println("Collector:exitTokenRuleDeclaration(TokenRuleDeclarationContext) : begin");
        TerminalNode idTN = ctx.TOKEN_ID();
        if (idTN != null) {
            Token idToken = idTN.getSymbol();
            String id = idToken.getText();
//            System.out.println("- id=" + id);
            if (!id.equals("<missing TOKEN_ID>")) {
                summary.addTokenRuleId(id);
                Map<String, List<String>> tokenRuleIdsOfMode =
                                                summary.getTokenRuleIdsOfMode();
                List<String> tokenRuleIdsOfCurrentMode =
                                            tokenRuleIdsOfMode.get(currentMode);
//                System.out.println("- mode=" + currentMode);
//                System.out.println("- id=" + id);
                if (tokenRuleIdsOfCurrentMode == null) {
                    tokenRuleIdsOfCurrentMode = new ArrayList<>();
                    tokenRuleIdsOfMode.put(currentMode, tokenRuleIdsOfCurrentMode);
                    tokenRuleIdsOfCurrentMode.add(id);
                } else {
                    tokenRuleIdsOfCurrentMode.add(id);
                }
                int startOffset = idToken.getStartIndex();
                int endOffset   = idToken.getStopIndex();
                summary.putTokenRuleIdStartOffset(id, startOffset);
                summary.putTokenRuleIdEndOffset(id, endOffset);
            }
        }
//        System.out.println("Collector:exitTokenRuleDeclaration(TokenRuleDeclarationContext) : end");
    }
    
    
    @Override
    public void exitFragmentRuleDeclaration (FragmentRuleDeclarationContext ctx) {
//        System.out.println("Collector:exitFragmentRuleDeclaration(FragmentRuleDeclarationContext) : begin");
        TerminalNode idTN = ctx.TOKEN_ID();
     // If a fragment has no id defined but a semicolon is defined then idTN 
     // will be null
        if (idTN != null) {
            Token idToken = idTN.getSymbol();
            String id = idToken.getText();
//            System.out.println("- id=" + id);
         // If a fragment has no id defined but a colon is defined then idTN 
         // will not be null but id will be equal to "<missing TOKEN_ID>"
            if (!id.equals("<missing TOKEN_ID>")) {
                summary.addFragmentRuleId(id);
                Map<String, List<String>> fragmentRuleIdsOfMode =
                                             summary.getFragmentRuleIdsOfMode();
                List<String> fragmentRuleIdsOfCurrentMode =
                                         fragmentRuleIdsOfMode.get(currentMode);
//                System.out.println("- mode=" + currentMode);
//                System.out.println("- id=" + id);
                if (fragmentRuleIdsOfCurrentMode == null) {
                    fragmentRuleIdsOfCurrentMode = new ArrayList<>();
                    fragmentRuleIdsOfMode.put(currentMode, fragmentRuleIdsOfCurrentMode);
                    fragmentRuleIdsOfCurrentMode.add(id);
                } else {
                    fragmentRuleIdsOfCurrentMode.add(id);
                }
                int startOffset = idToken.getStartIndex();
                int endOffset   = idToken.getStopIndex();
                summary.putFragmentRuleIdStartOffset(id, startOffset);
                summary.putFragmentRuleIdEndOffset(id, endOffset);
            }
        }
//        System.out.println("Collector:exitFragmentRuleDeclaration(FragmentRuleDeclarationContext) : end");
    }
    
    
    @Override
    public void exitParserRuleDeclaration (ParserRuleDeclarationContext ctx) {
//        System.out.println("Collector:exitParserRuleDeclaration(ParserRuleDeclarationContext) : begin");
        ParserRuleIdentifierContext pric = ctx.parserRuleIdentifier();
        if (pric != null) {
            TerminalNode priTN = pric.PARSER_RULE_ID();
            if (priTN != null) {
                Token priToken = priTN.getSymbol();
                if (priToken != null) {
                    String parserRuleId = priToken.getText();
//                    System.out.println("- parser rule id=" + parserRuleId);
                    if (!parserRuleId.equals("<missing PARSER_RULE_ID>")) {
                        summary.addParserRuleId(parserRuleId);
                        int startOffset = priToken.getStartIndex();
                        int endOffset   = priToken.getStopIndex();
                        summary.putParserRuleIdStartOffset(parserRuleId, startOffset);
                        summary.putParserRuleIdEndOffset(parserRuleId, endOffset);
                    }
                }
            }
        }
//        System.out.println("Collector:exitParserRuleDeclaration(ParserRuleDeclarationContext) : end");
    }
}