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
package org.nemesis.antlr.v4.netbeans.v8.grammar.file;

import java.io.IOException;

import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.text.StyledDocument;

import org.nemesis.antlr.v4.netbeans.v8.grammar.code.checking.NBANTLRv4Parser.ANTLRv4ParserResult;

import org.nemesis.antlr.v4.netbeans.v8.generic.parsing.ParsingError;
import org.nemesis.antlr.v4.netbeans.v8.project.helper.ProjectHelper;

import org.netbeans.modules.parsing.api.Snapshot;

import org.netbeans.modules.parsing.spi.Parser.Result;

import org.netbeans.modules.parsing.spi.indexing.Context;
import org.netbeans.modules.parsing.spi.indexing.EmbeddingIndexer;
import org.netbeans.modules.parsing.spi.indexing.EmbeddingIndexerFactory;
import org.netbeans.modules.parsing.spi.indexing.ErrorsCache;
import org.netbeans.modules.parsing.spi.indexing.ErrorsCache.ErrorKind;
import org.netbeans.modules.parsing.spi.indexing.ErrorsCache.Convertor;
import org.netbeans.modules.parsing.spi.indexing.Indexable;

import org.netbeans.modules.parsing.spi.indexing.support.IndexingSupport;

import org.openide.text.NbDocument;

/**
 *
 * @author Frédéric Yvon Vinet
 */
public class ErrorBadgingUpdater extends EmbeddingIndexer {
    private final static Logger LOG = Logger.getLogger
                                          (ErrorBadgingUpdater.class.getName());
    
    private ErrorBadgingUpdater() {
/*
        System.out.println();
        System.out.println("ErrorBadgingUpdater instantiated");
        System.out.println();
*/
    }
    
    
    @Override
    protected void index(final Indexable indxbl,
                         final Result    result,
                         final Context   cntxt ) {
//        System.out.println("ErrorBadgingUpdater:index() : begin");
        ANTLRv4ParserResult parserResult = (ANTLRv4ParserResult) result;
//        System.out.println("URL of indexable=" + indxbl.getURL());
        List<ParsingError> errorList = parserResult.getDiagnostics();
//        System.out.println("- document processed=" + result.getSnapshot().getSource().getFileObject().getName());
//        System.out.println("- Number of errors/warnings=" + errorList.size());
        if (!errorList.isEmpty()) {
            StyledDocument sDoc = ProjectHelper.getDocument
                             (result.getSnapshot().getSource().getFileObject());
            Convertor<ParsingError> convertor = new ErrorConvertor(sDoc);
            ErrorsCache.setErrors(cntxt.getRootURI(),
                                  indxbl            ,
                                  errorList         ,
                                  convertor         );
        }
//        System.out.println("ErrorBadgingUpdater:index() : end");
    }
    
    
    public static class Factory extends EmbeddingIndexerFactory {
        private static final String MIME = "text/x-g4";
        private static final int    VERSION = 1;
        private static final String NAME = "antlr.grammar.errors";

        @Override
        public EmbeddingIndexer createIndexer(Indexable indxbl, Snapshot snpsht) {
            EmbeddingIndexer answer;
            if (indxbl.getMimeType().equals(MIME))
                answer = new ErrorBadgingUpdater();
            else
                answer = null;
            return answer;
        }
        

        @Override
        public void filesDeleted(Iterable<? extends Indexable> itrbl, Context cntxt) {
            for(Indexable ixbl : itrbl) {
                try {
                    IndexingSupport.getInstance(cntxt).removeDocuments(ixbl);
                } catch (IOException e) {
                    LOG.log(Level.WARNING, null, e);
                }
            }
        }

        
        @Override
        public void filesDirty(Iterable<? extends Indexable> itrbl, Context cntxt) {
            for(Indexable ixbl : itrbl) {
                try {
                    IndexingSupport.getInstance(cntxt).markDirtyDocuments(ixbl);
                } catch (IOException e) {
                    LOG.log(Level.WARNING, null, e);
                }
            }
        }

        
        @Override
        public int getIndexVersion() {
            return VERSION;
        }
        

        @Override
        public String getIndexerName() {
            return NAME;
        }
    }

    private final class ErrorConvertor
                  implements Convertor<ParsingError>  {
        private final StyledDocument sDoc;
        
        public ErrorConvertor(StyledDocument sDoc) {
            this.sDoc = sDoc;
        }
        
        
        @Override
        public ErrorKind getKind(ParsingError err) {
            switch (err.getSeverity()) {
                case ERROR:
                    return ErrorKind.ERROR;
                case WARNING:
                    return ErrorKind.WARNING;
                default:
                    return null;
            }
        }
        

        @Override
        public int getLineNumber(ParsingError err) {
            int errorOffset = err.getStartPosition();
            int errorLine = NbDocument.findLineNumber(sDoc, errorOffset);
            return errorLine;
        }
        

        @Override
        public String getMessage(ParsingError err) {
            return err.getDescription();
        }
    }
}