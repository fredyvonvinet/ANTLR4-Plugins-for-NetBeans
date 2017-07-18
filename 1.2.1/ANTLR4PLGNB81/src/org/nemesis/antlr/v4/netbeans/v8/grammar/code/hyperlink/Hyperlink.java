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
package org.nemesis.antlr.v4.netbeans.v8.grammar.code.hyperlink;

import java.io.File;

/**
 * An hyperlink points to a given file (it may exist or not).
 * If the given file does not exist then the hyperlink will not work (without
 * error message). As soon as the pointed file is created, the hyperlink will
 * be functional without reparsing the source file.
 * 
 * If the target is in the same file as the source of hyperlink, then there is
 * one and only one hyperlink per source.
 * 
 * But if the target may be in a file that can be in several directory, then
 * there is several hyperlinks per source. The hyperlinkProvider will chosse the
 * first that is pointing to an existing file.
 * .
 * @author Frédéric Yvon Vinet
 */
public class Hyperlink {
    private final int               start;
    private final int               end;
    private final HyperlinkCategory category;
    private final File              targetFile;
    private final String            targetWord;
    private final int               targetOffset;

    
    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public HyperlinkCategory getCategory() {
        return category;
    }

    public File getTargetFile() {
        return targetFile;
    }

    public String getTargetWord() {
        return targetWord;
    }

    public int getTargetOffset() {
        return targetOffset;
    }
    
    
    public Hyperlink(int               start       ,
                     int               end         ,
                     HyperlinkCategory category    ,
                     File              targetFile  ,
                     String            targetWord  ,
                     int               targetOffset) {
        this.start        = start;
        this.end          = end;
        this.category     = category;
        this.targetFile   = targetFile;
        this.targetWord   = targetWord;
        this.targetOffset = targetOffset;
    }
}
