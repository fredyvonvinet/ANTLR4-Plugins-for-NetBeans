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

import java.util.ArrayList;

import org.apache.tools.ant.BuildException;

class GrammarFile extends ANTLRFile {
    public GrammarFile(Path path) {
        super(path);
    }

    @Override
    public boolean isArtefact() {
        return false;
    }

    @Override
    protected void recoverDependences() {
        ANTLRDependenceRecoverer dependenceRecoverer = ANTLRDependenceRecoverer.getInstance();
        if (dependenceRecoverer == null) {
            throw new BuildException("ANTLR dependence recover not initialized");
        }
        dependenceRecoverer.defineDependencesOf(this);
        FileConverter fileConverter = FileConverter.getInstance();
        if (fileConverter == null)
            throw new BuildException("You forgot to initialize the file converter");
        
     // We add the imported grammar files to the list of files that current 
     // grammar depends on
        ArrayList<String> importedGrammarFiles = dependenceRecoverer.getImportedGrammarFiles();
        for (String importedGrammarFile : importedGrammarFiles) {
            Path absoluteImportedGrammarPath = fileConverter.convertIntoAbsoluteSrcPath(importedGrammarFile);
            ANTLRFile antlrImportedGrammarFile = ANTLRFile.getInstance(absoluteImportedGrammarPath.toString());
            if (antlrImportedGrammarFile == null) {
                antlrImportedGrammarFile = ANTLRFileFactory.create(absoluteImportedGrammarPath, null);
            }
            this.addFileThatIDependOn(antlrImportedGrammarFile);
            antlrImportedGrammarFile.addFileThatDependsOnMe(this);
        }
        
     // We add the imported tokens files to the list of files that current 
     // grammar depends on
        ArrayList<String> importedTokensFiles = dependenceRecoverer.getImportedTokenFiles();
        for (String importedTokensFile : importedTokensFiles) {
            Path absoluteImportedTokenFilePath = fileConverter.convertIntoAbsoluteDestPath(importedTokensFile);
            ANTLRFile antlrImportedTokensFile = ANTLRFile.getInstance(absoluteImportedTokenFilePath.toString());
            if (antlrImportedTokensFile == null) {
                antlrImportedTokensFile = ANTLRFileFactory.create(absoluteImportedTokenFilePath, null);
            }
            this.addFileThatIDependOn(antlrImportedTokensFile);
            antlrImportedTokensFile.addFileThatDependsOnMe(this);
        }
        
     // We add the generated files to the list of files that depends on current 
     // grammar
        ArrayList<String> generatedFiles = dependenceRecoverer.getGeneratedFiles();
        for (String generatedFile : generatedFiles) {
            Path absoluteGeneratedFilePath = fileConverter.convertIntoAbsoluteDestPath(generatedFile);
            ANTLRFile antlrGeneratedFile = ANTLRFile.getInstance(absoluteGeneratedFilePath.toString());
            if (antlrGeneratedFile == null) {
                antlrGeneratedFile = ANTLRFileFactory.create(absoluteGeneratedFilePath, true);
            }
            this.addFileThatDependsOnMe(antlrGeneratedFile);
            antlrGeneratedFile.addFileThatIDependOn(this);
        }
    }
}