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
package org.nemesis.antlr.v4.netbeans.v8.parser;


import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import java.util.logging.Logger;

import org.nemesis.antlr.v4.netbeans.v8.parser.error.semantic.ANTLRv4SemanticParser;
import org.nemesis.antlr.v4.netbeans.v8.parser.error.semantic.GrammarType;
import org.nemesis.antlr.v4.netbeans.v8.parser.error.semantic.RuleDeclaration;
import org.nemesis.antlr.v4.netbeans.v8.parser.error.semantic.RuleReference;
import org.nemesis.antlr.v4.netbeans.v8.parser.error.syntactic.ANTLRv4SyntacticErrorListener;

import org.nemesis.antlr.v4.netbeans.v8.parser.impl.ANTLRv4Lexer;
import org.nemesis.antlr.v4.netbeans.v8.parser.impl.ANTLRv4Parser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;


/**
 *
 * @author Frédéric Yvon Vinet
 */
public class ANTLRv4GrammarChecker {
    private static final Logger LOG = Logger.getLogger("ANTLR semantic parser");
    
    private       ANTLRv4Parser                 parser;
    private       GrammarType                   grammarType;
    private final Set<String>                   ruleDeclarations;
    private final Map<String, RuleReference>    ruleReferences;
    private final Map<String, RuleDeclaration>  parserRuleDeclarations;
    private       String                        firstParserRule;
    private       ANTLRv4SyntacticErrorListener syntacticErrorListener;
    private       ANTLRv4SemanticParser         semanticParser;
    
    public ANTLRv4Parser getParser() {
        return parser;
    }
    
    public GrammarType getGrammarType() {
        return this.grammarType;
    }
    
    public Set<String> getRuleDeclarations() {
        return this.ruleDeclarations;
    }
    
    public Map<String, RuleDeclaration> getParserRuleDeclarations() {
        return this.parserRuleDeclarations;
    }
    
    public Map<String, RuleReference> getRuleReferences() {
        return this.ruleReferences;
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
    
    
    public ANTLRv4GrammarChecker() {
        this.parser = null;
        this.grammarType = GrammarType.UNDEFINED;
        this.ruleDeclarations = new HashSet<>();
        this.parserRuleDeclarations = new HashMap<>();
        this.firstParserRule = null;
        this.syntacticErrorListener = null;
        this.semanticParser = null;
        this.ruleReferences = new HashMap<>();
    }
    
    
    public void check(String contentToBeParsed, String sourceFilePath) {
        try (Reader sr = new StringReader(contentToBeParsed) ) {
            ANTLRInputStream input = new ANTLRInputStream(sr);
            ANTLRv4Lexer lexer = new ANTLRv4Lexer(input);
            
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            parser = new ANTLRv4Parser(tokens);
            
            syntacticErrorListener = new ANTLRv4SyntacticErrorListener();
            parser.removeErrorListeners(); // remove ConsoleErrorListener
            parser.addErrorListener(syntacticErrorListener); // add ours
            
         // We recover the parse tree and we pass it to our walker
            ParseTree tree = parser.grammarFile();

         // We only launch a semantic parsing in case of syntactic parsing success
            if (!syntacticErrorListener.encounteredError()) {
                ParseTreeWalker walker = new ParseTreeWalker();
                semanticParser = new ANTLRv4SemanticParser(sourceFilePath);

                walker.walk(semanticParser, tree);
             // We recover the type of the grammar
                grammarType = semanticParser.getGrammarType();
                semanticParser.checkThereIsAtLeastARule();
                switch (grammarType) {
                    case PARSER :
                        semanticParser.checkRuleReferences();
                        break;
                    case COMBINED :
                        semanticParser.checkRuleReferences();
                        semanticParser.checkParserRuleDeclarations();
                        break;
                    default:
                }

             // We recover the rules declared in the parsed file
             // (usefull only in case of recursive grammar file parsing, e.g. import)
                ruleDeclarations.addAll(semanticParser.getRuleDeclarations());
                ruleReferences.putAll(semanticParser.getRuleReferences());
                parserRuleDeclarations.putAll(semanticParser.getParserRuleDeclarations());
             // We recover the first imported parser rule
                firstParserRule = semanticParser.getFirstParserRule();
            }
        } catch (IOException ex) {
            LOG.severe("Strange! Unable to read the String Buffer");
        } catch (RecognitionException ex) {
            LOG.severe(ex.toString());
        }
    }
}