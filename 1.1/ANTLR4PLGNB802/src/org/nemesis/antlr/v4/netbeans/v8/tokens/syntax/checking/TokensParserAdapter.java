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
package org.nemesis.antlr.v4.netbeans.v8.tokens.syntax.checking;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;

import java.util.List;

import java.util.logging.Logger;

import javax.swing.event.ChangeListener;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.nemesis.antlr.v4.netbeans.v8.generic.parsing.ParsingError;

import org.nemesis.antlr.v4.netbeans.v8.tokens.syntax.checking.error.TokensSyntacticErrorListener;
import org.nemesis.antlr.v4.netbeans.v8.tokens.syntax.checking.impl.TokensLexer;
import org.nemesis.antlr.v4.netbeans.v8.tokens.syntax.checking.impl.TokensParser;

import org.netbeans.modules.csl.api.Error;
import org.netbeans.modules.csl.spi.ParserResult;

import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.api.Task;
import org.netbeans.modules.parsing.spi.ParseException;
import org.netbeans.modules.parsing.spi.Parser;
import org.netbeans.modules.parsing.spi.SourceModificationEvent;
import org.openide.filesystems.FileObject;
import org.openide.util.ChangeSupport;
import org.openide.windows.IOProvider;

/**
 *
 * @author Frédéric Yvon Vinet
 */
public class TokensParserAdapter extends Parser {
    private static final Logger LOG = Logger.getLogger
                        ("ANTLR plugin:" + TokensParserAdapter.class.getName());
    
    private       ParserResult  result ;
    private final ChangeSupport changeSupport;
    
    public TokensParserAdapter() {
        this.result = null;
        this.changeSupport = new ChangeSupport(this);
    }
    
    
    @Override
    public void parse(Snapshot                snapshot,
                      Task                    task    ,
                      SourceModificationEvent event   ) throws ParseException {
        FileObject objectToBeParsed = snapshot.getSource().getFileObject();
        String contentToBeParsed = snapshot.getText().toString();
        try (Reader sr = new StringReader(contentToBeParsed) ) {
            ANTLRInputStream input = new ANTLRInputStream(sr);
            TokensLexer lexer = new TokensLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);  
            TokensParser tokensParser = new TokensParser(tokens);

            TokensSyntacticErrorListener syntacticErrorListener = new TokensSyntacticErrorListener(objectToBeParsed);
            tokensParser.removeErrorListeners(); // remove ConsoleErrorListener
            tokensParser.addErrorListener(syntacticErrorListener); // add ours
            
            tokensParser.token_declarations();
            List<ParsingError> errors = syntacticErrorListener.getParsingError();
            
            if (result == null) {
                result = new TokensParserAdapter.TokensParserResult
                                                             (snapshot, errors);
                changeSupport.fireChange();
            } else {
                boolean sameAsPreviousParsing = true;
                Iterator<ParsingError> it = errors.iterator();
                List<ParsingError> oldErrors = (List<ParsingError>)
                                                        result.getDiagnostics();
                if (oldErrors.size() != errors.size()) {
                    sameAsPreviousParsing = false;
                } else {
                    while (it.hasNext() && sameAsPreviousParsing) {
                        ParsingError error = it.next();
                        Iterator<ParsingError> it2 = oldErrors.iterator();
                        boolean found = false;
                        while (it2.hasNext() && !found) {
                            ParsingError oldError = it2.next();
                            if (oldError.equals(error))
                                found = true;
                        }
                        if (!found)
                            sameAsPreviousParsing = false;
                    }
                }
                if (!sameAsPreviousParsing) {
                    result = new TokensParserAdapter.TokensParserResult
                                                             (snapshot, errors);
                    changeSupport.fireChange();
                }
            }
        } catch (IOException ex) {
            LOG.severe("Strange! Unable to read the String Buffer");
        } catch (RecognitionException ex) {
            LOG.severe(ex.toString());
        }
    }

    
    @Override
    public Result getResult (Task task) {
        return result;
    }

    
    @Override
    public void addChangeListener (ChangeListener changeListener) {
        changeSupport.addChangeListener(changeListener);
/*
        System.out.println();
        System.out.println("TokensParserAdapter.addChangeListener() has been called");
        System.out.println();
*/
    }

    @Override
    public void removeChangeListener (ChangeListener changeListener) {
        changeSupport.removeChangeListener(changeListener);
/*
        System.out.println();
        System.out.println("TokensParserAdapter.removeChangeListener() has been called");
        System.out.println();
*/
    }

    
    public static class TokensParserResult extends ParserResult {
        private       boolean               valid;
        private final List<? extends Error> errors;

        TokensParserResult
             (Snapshot              snapshot,
              List<? extends Error> errors  ) {
            super (snapshot);
            this.errors = errors;
            this.valid = true;
        }

        @Override
        protected void invalidate () {
            valid = false;
        }
        
        
        @Override
        public List<? extends Error> getDiagnostics() {
            return errors;
        }
    }
}