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
package org.nemesis.antlr.v4.netbeans.v8.grammar.code.checking;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import java.nio.file.Path;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.logging.Logger;

import javax.swing.text.Document;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import org.nemesis.antlr.v4.netbeans.v8.generic.parsing.ParsingError;

import org.nemesis.antlr.v4.netbeans.v8.grammar.code.checking.semantics.ANTLRv4SemanticParser;

import org.nemesis.antlr.v4.netbeans.v8.grammar.code.checking.syntax.ANTLRv4SyntacticErrorListener;

import org.nemesis.antlr.v4.netbeans.v8.grammar.code.checking.impl.ANTLRv4Lexer;
import org.nemesis.antlr.v4.netbeans.v8.grammar.code.checking.impl.ANTLRv4Parser;

import org.nemesis.antlr.v4.netbeans.v8.grammar.code.hyperlink.parser.HyperlinkParser;

import org.nemesis.antlr.v4.netbeans.v8.grammar.code.summary.Collector;
import org.nemesis.antlr.v4.netbeans.v8.grammar.code.summary.GrammarSummary;
import org.nemesis.antlr.v4.netbeans.v8.grammar.code.summary.GrammarType;
import org.nemesis.antlr.v4.netbeans.v8.grammar.code.summary.RuleDeclaration;
import org.nemesis.antlr.v4.netbeans.v8.project.ProjectType;
import org.nemesis.antlr.v4.netbeans.v8.project.helper.ProjectHelper;

import org.netbeans.api.project.Project;

import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;

/**
 *
 * @author Frédéric Yvon Vinet
 */
public class ANTLRv4GrammarChecker {
    private static final Logger LOG = Logger.getLogger
                        ("ANTLR plugin:"+ANTLRv4GrammarChecker.class.getName());
    
    private       ANTLRv4Parser                 parser;
    private final Document                      doc;
    private final Path                          grammarFilePath;
    private       String                        grammarName;
    private       GrammarType                   grammarType;
    private final Map<String, RuleDeclaration>  tokenRuleDeclarations;
    private       String                        firstParserRule;
    private       String                        packageName;
    private       ANTLRv4SyntacticErrorListener syntacticErrorListener;
    private       ANTLRv4SemanticParser         semanticParser;
    private       List<ParsingError>            semanticErrors;
    private       List<ParsingError>            semanticWarnings;

    
    public ANTLRv4Parser getParser() {
        return parser;
    }
    
    public String getGrammarName() {
        return grammarName;
    }
    
    public GrammarType getGrammarType() {
        return this.grammarType;
    }
    
    public Map<String, RuleDeclaration> getTokenRuleDeclarations() {
        return this.tokenRuleDeclarations;
    }

    public String getFirstParserRule() {
        return this.firstParserRule;
    }
    
    public ANTLRv4SyntacticErrorListener getSyntacticErrorListener() {
        return syntacticErrorListener;
    }
    
    public ANTLRv4SemanticParser getSemanticParser() {
        return semanticParser;
    }
    
    public boolean encounteredSyntacticError() {
        return syntacticErrorListener == null
               ? false
               : syntacticErrorListener.encounteredError();
    }
    
    public List<ParsingError> getSyntacticErrors() {
        return syntacticErrorListener == null
               ? null : syntacticErrorListener.getParsingError();
    }
    
    public List<ParsingError> getSemanticErrors() {
        return semanticErrors;
    }
    
    public int getSemanticErrorNumber() {
        return semanticErrors == null ? 0 : semanticErrors.size();
    }
    
    public boolean encounteredSemanticError() {
        return semanticErrors == null
               ? false
               : !semanticErrors.isEmpty();
    }
    
    public List<ParsingError> getSemanticWarnings() {
        return semanticWarnings;
    }
    
    public int getSemanticWarningNumber() {
        return semanticWarnings == null ? 0 : semanticWarnings.size();
    }
    
    public boolean encounteredSemanticWarning() {
        return semanticWarnings == null
               ? false
               : !semanticWarnings.isEmpty();
    }
 /**
  * 
  * @param doc : may be null. If it is null no hyperlink parsing will occur
  */
    public ANTLRv4GrammarChecker(Document doc, Path grammarFilePath) {
        assert doc != null;
        assert grammarFilePath != null;
        this.doc = doc;
        this.grammarFilePath = grammarFilePath;
        this.parser = null;
        this.grammarName = null;
        this.grammarType = GrammarType.UNDEFINED;
        this.tokenRuleDeclarations = new HashMap<>();
        this.firstParserRule = null;
        this.syntacticErrorListener = null;
        this.semanticParser = null;

        this.packageName = null;
        this.semanticErrors = null;
        this.semanticWarnings = null;
    }
    
    
    public void check(String contentToBeParsed) {
        assert contentToBeParsed != null;
        Project project = ProjectHelper.getProject(doc);
        ProjectType projectType = ProjectHelper.getProjectType(project);

        try (
            Reader sr = new StringReader(contentToBeParsed);
        ) {
            ANTLRInputStream input = new ANTLRInputStream(sr);
            ANTLRv4Lexer lexer = new ANTLRv4Lexer(input);
                
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            parser = new ANTLRv4Parser(tokens);
            
            File grammarFile = grammarFilePath.toFile();
            FileObject grammarFO = FileUtil.toFileObject(grammarFile);
            syntacticErrorListener = new ANTLRv4SyntacticErrorListener(grammarFO);
            parser.removeErrorListeners(); // remove ConsoleErrorListener
            parser.addErrorListener(syntacticErrorListener); // add ours
            
         // If we are in an undefined project type, we do nothing
            if (projectType != ProjectType.UNDEFINED) {
             // We add a collector in charge of collecting a summary of grammar
             // (summary is attached to parsed document as a property with 
             // GrammarSummary.class as a key)
                Collector collector = new Collector(doc, grammarFilePath);
                parser.addParseListener(collector);
            }
         // First step : we parse our grammar
            ParseTree tree = parser.grammarFile();
            
         // Second step: we walk through parse tree in order to recover semantic
         // info and determine if there are semantic errors
         // If we are in an undefined project type, we do nothing
            if (projectType != ProjectType.UNDEFINED) {
                ParseTreeWalker walker = new ParseTreeWalker();
                GrammarSummary summary = (GrammarSummary) 
                                          doc.getProperty(GrammarSummary.class);
                semanticParser = new ANTLRv4SemanticParser(grammarFilePath, summary);
                walker.walk(semanticParser, tree);
                semanticErrors = semanticParser.getSemanticErrors();
                semanticWarnings = semanticParser.getSemanticWarnings();
                
             // We recover info about our grammar and we run some post-process
             // checkings
                grammarName = semanticParser.getGrammarName();
                grammarType = semanticParser.getGrammarType();
                packageName = semanticParser.getPackageName();
             // We recover the first imported parser rule
                firstParserRule = semanticParser.getFirstParserRule();
            
             // We launch a post walk check
                semanticParser.check();
            
             // third step: we walk through parse tree again in order to prepare
             // hyperlinks
                HyperlinkParser hyperlinkParser = new HyperlinkParser(doc);
                walker.walk(hyperlinkParser, tree);
            }
        } catch (IOException ex) {
                LOG.severe("Strange! Unable to read the String Buffer");
        } catch (RecognitionException ex) {
                LOG.severe(ex.toString());
        }
    }
}