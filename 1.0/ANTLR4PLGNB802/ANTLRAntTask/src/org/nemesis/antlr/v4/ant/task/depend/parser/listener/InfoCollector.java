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
package org.nemesis.antlr.v4.ant.task.depend.parser.listener;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.nemesis.antlr.v4.ant.task.depend.parser.impl.ANTLRv4BaseListener;
import org.nemesis.antlr.v4.ant.task.depend.parser.impl.ANTLRv4Parser;

/**
 *
 * @author Frédéric Yvon Vinet
 */
public class InfoCollector extends ANTLRv4BaseListener {
    private static final Logger LOG = Logger.getLogger("ANTLR depend parser");
    
    private       String            grammarName;
    private       GrammarType       grammarType;
    private final ArrayList<String> importedGrammarFiles;
    private final ArrayList<String> importedTokenFiles;
    private       int               parserRuleNumber;
    private       int               lexerRuleNumber;
    private final Path              relativeGrammarFileDirPath;

    public String getGrammarName() {
        return grammarName;
    }
    
    public GrammarType getGrammarType() {
        return grammarType;
    }

    public ArrayList<String> getImportedGrammarFiles() {
        return importedGrammarFiles;
    }

    public ArrayList<String> getImportedTokenFiles() {
        return importedTokenFiles;
    }

    public int getParserRuleNumber() {
        return parserRuleNumber;
    }

    public int getLexerRuleNumber() {
        return lexerRuleNumber;
    }


    public InfoCollector(Path relativeGrammarFileDirPath) {
        this.grammarName = null;
        this.grammarType = GrammarType.UNDEFINED;
        this.importedGrammarFiles = new ArrayList<>();
        this.importedTokenFiles = new ArrayList<>();
        this.lexerRuleNumber = 0;
        this.parserRuleNumber = 0;
        this.relativeGrammarFileDirPath = relativeGrammarFileDirPath;
    }


    @Override
    public void exitGrammarSpec(ANTLRv4Parser.GrammarSpecContext ctx) {
        grammarName = ctx.identifier().getText();
        ANTLRv4Parser.GrammarTypeContext gtc = ctx.grammarType();
        if (gtc.LEXER() != null)
            grammarType = GrammarType.LEXER;
        else if (gtc.PARSER() != null)
            grammarType = GrammarType.PARSER;
        else if (gtc.GRAMMAR() != null)
            grammarType = GrammarType.COMBINED;
        else
            grammarType = GrammarType.UNDEFINED;
    }


    private static final String ANTLR_GRAMMAR_FILE_EXT = ".g4";
  /**
   * Called at the end of an import statement.
   * 
   * @param ctx 
   */
    @Override
    public void exitDelegateGrammar(ANTLRv4Parser.DelegateGrammarContext ctx) {
        ANTLRv4Parser.IdentifierContext ic = ctx.grammarIdentifier().identifier();
        StringBuilder importedGrammarFile = new StringBuilder();
        importedGrammarFile.append(ic.getText());
        importedGrammarFile.append(ANTLR_GRAMMAR_FILE_EXT);
        Path importedGrammarFileRelativePath =
                               Paths.get(relativeGrammarFileDirPath.toString(),
                                         importedGrammarFile.toString()       );
        importedGrammarFiles.add(importedGrammarFileRelativePath.toString());
    }


    private static final String ANTLR_TOKENS_FILE_EXT = ".tokens";

    @Override
    public void exitTokenVocabSpec(ANTLRv4Parser.TokenVocabSpecContext ctx) {
        StringBuilder tokenSourceFileName = new StringBuilder();
        tokenSourceFileName.append(ctx.identifier().getText());
        tokenSourceFileName.append(ANTLR_TOKENS_FILE_EXT);
        Path importedTokensFileRelativePath =
                               Paths.get(relativeGrammarFileDirPath.toString(),
                                         tokenSourceFileName.toString()       );
        importedTokenFiles.add(importedTokensFileRelativePath.toString());
    }
    
    
    @Override
    public void exitParserRuleSpec(ANTLRv4Parser.ParserRuleSpecContext ctx) {
        parserRuleNumber++;
    }
    
    
    @Override
    public void exitLexerRuleSpec(ANTLRv4Parser.LexerRuleSpecContext ctx) {
        lexerRuleNumber++;
    }
}