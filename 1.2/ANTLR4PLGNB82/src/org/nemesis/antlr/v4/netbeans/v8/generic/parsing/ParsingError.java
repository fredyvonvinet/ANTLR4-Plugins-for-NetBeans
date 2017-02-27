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
package org.nemesis.antlr.v4.netbeans.v8.generic.parsing;

import org.netbeans.modules.csl.api.Error.Badging;
import org.netbeans.modules.csl.api.Severity;

import org.openide.filesystems.FileObject;

/**
 * It is mandatory to implement Error.Badging rather than Error because, we want 
 * error badges to be shown in 'Projects' tab.
 * 
 * @author Frédéric Yvon Vinet
 */
public class ParsingError implements Badging {
    protected FileObject fileObject;
    protected Severity   severity;
    protected String     key;
    protected int        parsingErrorStartOffset; // in the root char stream
    protected int        parsingErrorEndOffset; // in the root char stream
    protected String     displayName;
    protected String     description;
    
    public ParsingError
        (FileObject fileObject             ,
         Severity   severity               ,
         String     key                    ,
         int        parsingErrorStartOffset,
         int        parsingErrorEndOffset  ,
         String     displayName            ,
         String     description            ) {
        this.fileObject = fileObject;
        this.severity = severity;
        this.key = key;
        this.parsingErrorStartOffset = parsingErrorStartOffset;
        this.parsingErrorEndOffset = parsingErrorEndOffset;
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
        return fileObject;
    }

 /**
  * @return Get the position of the error in the parsing input source (in other
  * words, this is the AST-based offset and may need translation to obtain the 
  * document offset in documents with an embedding model).
  */
    @Override
    public int getStartPosition() {
        return parsingErrorStartOffset;
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
        return parsingErrorEndOffset;
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
        return false;
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

    
    @Override
    public boolean showExplorerBadge() {
        return true;
    }
    

    public boolean equals(ParsingError err) {
        boolean answer = true;
        if (!fileObject.equals(err.fileObject))
            answer = false;
        if (!severity.equals(err.severity))
            answer = false;
        if (!severity.equals(err.severity))
            answer = false;
        if (!key.equals(err.key))
            answer = false;
        if (parsingErrorStartOffset != err.parsingErrorStartOffset)
            answer = false;
        if (parsingErrorEndOffset != err.parsingErrorEndOffset)
            answer = false;
        if (!displayName.equals(err.displayName))
            answer = false;
        if (!description.equals(err.description))
            answer = false;
        return answer;
    }
}