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
package org.nemesis.antlr.v4.ant.task;

import java.nio.file.Path;
import java.nio.file.Paths;

class FileConverter {
    private static FileConverter instance;
    
    private final String absoluteSrcDir;
    private final String absoluteDestDir;

    public static FileConverter getInstance() {
        return instance;
    }

    public FileConverter(String absoluteSrcDir, String absoluteDestDir) {
        instance = this;
        this.absoluteSrcDir = absoluteSrcDir;
        this.absoluteDestDir = absoluteDestDir;
    }


    public Path convertIntoGrammarFilePath(Path tokenFilePath) {
        String tokenFileName = tokenFilePath.getFileName().toString();
        int endIndex = tokenFileName.indexOf(".tokens");
        String grammarName = tokenFileName.substring(0, endIndex);
        StringBuilder grammarFileName = new StringBuilder();
        grammarFileName.append(grammarName);
        grammarFileName.append(".g4");
        return Paths.get(absoluteSrcDir, grammarFileName.toString());
    }
    

    public Path convertIntoAbsoluteDestPath(String artefactFileRelativePath) {
        return Paths.get(absoluteDestDir, artefactFileRelativePath);
    }
    
    
    public Path convertIntoAbsoluteSrcPath(String grammarFileRelativePath) {
        return Paths.get(absoluteSrcDir, grammarFileRelativePath);
    }
    
    public Path convertIntoRelativeSrcPath(String grammarFileAbsolutePath) {
        Path absoluteSrcDirPath = Paths.get(absoluteSrcDir);
        Path grammarFileAbsolutePath2 = Paths.get(grammarFileAbsolutePath);
        return absoluteSrcDirPath.relativize(grammarFileAbsolutePath2);
    }
}