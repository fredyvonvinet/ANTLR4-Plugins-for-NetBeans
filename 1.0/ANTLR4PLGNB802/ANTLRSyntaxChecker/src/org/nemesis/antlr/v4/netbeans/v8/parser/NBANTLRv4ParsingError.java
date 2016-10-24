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

import java.io.File;

import org.netbeans.modules.csl.api.Error;
import org.netbeans.modules.csl.api.Severity;

import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;

/**
 *
 * @author Frédéric Yvon Vinet
 */
public class NBANTLRv4ParsingError implements Error {
    protected FileObject grammarFileObject;
    protected Severity   severity;
    protected String     key;
    protected int        parsingErrorPosition; // in the root char stream
    protected String     displayName;
    protected String     description;
    
    public NBANTLRv4ParsingError
        (String   grammarFileName     ,
         Severity severity            ,
         String   key                 ,
         int      parsingErrorPosition,
         String   displayName         ,
         String   description         ) {
     // grammar file resource without directory specification
        File grammarFile = new File(grammarFileName);
     // grammar file resource with directory specification
        File normalizedGrammarFile = FileUtil.normalizeFile(grammarFile);
        this.grammarFileObject = FileUtil.toFileObject(normalizedGrammarFile);
        this.severity = severity;
        this.key = key;
        this.parsingErrorPosition = parsingErrorPosition;
        this.displayName = displayName;
        this.description = description;
    }
    
 /**
  * @return Provide a short user-visible (and therefore localized) description
  * of this error
  */
    @Override
    public String getDisplayName() {
        return displayName;
    }

 /**
  * @return Provide a full sentence description of this item, suitable for 
  * display in a tooltip for example
  */
    @Override
    public String getDescription() {
        return description;
    }

 /**
  * @return Return a unique id/key for this error, such as 
  * "compiler.err.abstract.cant.be.instantiated". This key is used for error
  * hints providers.
  */
    @Override
    public String getKey() {
        return key;
    }

  /**
   * @return Get the file object associated with this error, if any
   */
    @Override
    public FileObject getFile() {
        return grammarFileObject;
    }

 /**
  * @return Get the position of the error in the parsing input source (in other
  * words, this is the AST-based offset and may need translation to obtain the 
  * document offset in documents with an embedding model).
  */
    @Override
    public int getStartPosition() {
        return parsingErrorPosition;
    }

 /**
  * Get the end offset of the error in the parsing input source (in other words,
  * this is the AST-based offset and may need translation to obtain the document
  * offset in documents with an embedding model).
  * 
  * @return The end position, or -1 if unknown.
  */
    @Override
    public int getEndPosition() {
        return parsingErrorPosition;
    }

 /**
  * Defines the way how an error annotation for this error behaves in the 
  * editor.
  * 
  * @return true if the error annotation should span over the whole line, false 
  * if the annotation is restricted exactly by the range defined by 
  * getStart/EndPostion().
  */
    @Override
    public boolean isLineError() {
        return true;
    }

 /**
  * @return Get the severity of this error
  */
    @Override
    public Severity getSeverity() {
        return severity;
    }

 /**
  * @return Return optional parameters for this message. The parameters may 
  * provide the specific unknown symbol name for an unknown symbol error, etc.
  */
    @Override
    public Object[] getParameters() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
