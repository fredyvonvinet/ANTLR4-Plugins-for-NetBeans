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
package org.nemesis.antlr.v4.netbeans.v8.tokens.code.checking;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import java.nio.file.Path;

import java.util.List;

import java.util.logging.Logger;

import javax.swing.event.ChangeListener;

import javax.swing.text.Document;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;

import org.nemesis.antlr.v4.netbeans.v8.generic.parsing.ParsingError;

import org.nemesis.antlr.v4.netbeans.v8.project.ProjectType;

import org.nemesis.antlr.v4.netbeans.v8.project.helper.ProjectHelper;

import org.nemesis.antlr.v4.netbeans.v8.tokens.code.checking.syntax.TokensSyntacticErrorListener;

import org.nemesis.antlr.v4.netbeans.v8.tokens.code.checking.impl.TokensLexer;
import org.nemesis.antlr.v4.netbeans.v8.tokens.code.checking.impl.TokensParser;

import org.nemesis.antlr.v4.netbeans.v8.tokens.code.summary.Collector;

import org.netbeans.api.project.Project;

import org.netbeans.modules.csl.spi.ParserResult;

import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.api.Task;

import org.netbeans.modules.parsing.spi.ParseException;
import org.netbeans.modules.parsing.spi.Parser;
import org.netbeans.modules.parsing.spi.SourceModificationEvent;

import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;

/**
 *
 * @author Frédéric Yvon Vinet
 */
public class TokensParserAdapter extends Parser {
    private static final Logger LOG = Logger.getLogger
                        ("ANTLR plugin:" + TokensParserAdapter.class.getName());
    
    private       TokensParserResult  result ;
    
    public TokensParserAdapter() {
//        System.out.println("TokensParserAdapter:TokensParserAdapter() : begin");
        this.result = null;
//        System.out.println("TokensParserAdapter:TokensParserAdapter() : end");
    }
    
    
    @Override
    public void parse(Snapshot                snapshot,
                      Task                    task    ,
                      SourceModificationEvent event   ) throws ParseException {
//        System.out.println("TokensParserAdapter:parse(Snapshot, Task, SourceModificationEvent) : begin");
        FileObject tokensFO = snapshot.getSource().getFileObject();
        Document doc = ProjectHelper.getDocument(tokensFO);
        Project project = ProjectHelper.getProject(doc);
        ProjectType projectType = ProjectHelper.getProjectType(project);

        Path tokensFilePath = FileUtil.toFile(tokensFO).toPath();
        String contentToBeParsed = snapshot.getText().toString();
        try (Reader sr = new StringReader(contentToBeParsed) ) {
            ANTLRInputStream input = new ANTLRInputStream(sr);
            TokensLexer lexer = new TokensLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);  
            TokensParser tokensParser = new TokensParser(tokens);

            TokensSyntacticErrorListener syntacticErrorListener =
                                     new TokensSyntacticErrorListener(tokensFO);
            tokensParser.removeErrorListeners(); // remove ConsoleErrorListener
            tokensParser.addErrorListener(syntacticErrorListener); // add ours
         // If we are in an undefined project type, we do not collect info
            if (projectType != ProjectType.UNDEFINED) {
                Collector collector = new Collector(doc, tokensFilePath);
                tokensParser.addParseListener(collector);
            }
            
            tokensParser.token_declarations();
            List<ParsingError> errors = syntacticErrorListener.getParsingError();
            
            result = new TokensParserResult(snapshot, errors);
        } catch (IOException ex) {
            LOG.severe("Strange! Unable to read the String Buffer");
        } catch (RecognitionException ex) {
            LOG.severe(ex.toString());
        }
//        System.out.println("TokensParserAdapter:parse(Snapshot, Task, SourceModificationEvent) : end");
    }

    
    @Override
    public Result getResult (Task task) {
        return result;
    }

    
    @Override
    public void addChangeListener (ChangeListener changeListener) {
    }

    @Override
    public void removeChangeListener (ChangeListener changeListener) {
    }

    
    public static class TokensParserResult extends ParserResult {
        private       boolean            valid;
        private final List<ParsingError> errors;

        TokensParserResult
             (Snapshot           snapshot,
              List<ParsingError> errors  ) {
            super (snapshot);
            this.errors = errors;
            this.valid = true;
        }

        @Override
        protected void invalidate () {
            valid = false;
        }
        
        
        @Override
        public List<ParsingError> getDiagnostics() {
            return errors;
        }
    }
}