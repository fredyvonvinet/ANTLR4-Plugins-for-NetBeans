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

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.ArrayList;

import org.nemesis.antlr.v4.ant.task.depend.parser.impl.ANTLRv4Lexer;
import org.nemesis.antlr.v4.ant.task.depend.parser.impl.ANTLRv4Parser;
import org.nemesis.antlr.v4.ant.task.depend.parser.listener.GrammarType;
import org.nemesis.antlr.v4.ant.task.depend.parser.listener.InfoCollector;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import org.apache.tools.ant.BuildException;

class ANTLRDependenceRecoverer {
    private static ANTLRDependenceRecoverer instance = null;
    
    private final String  destdir;
    private final boolean listener;
    private final boolean visitor;
    private final String  codePackage;
    private final boolean atn;
    
    private ArrayList<String> importedGrammarFiles;
    private ArrayList<String> importedTokenFiles;
    private ArrayList<String> generatedFiles;

    public static ANTLRDependenceRecoverer getInstance() {
        return instance;
    }

    public ArrayList<String> getImportedGrammarFiles() {
        return importedGrammarFiles;
    }

    public ArrayList<String> getImportedTokenFiles() {
        return importedTokenFiles;
    }

    public ArrayList<String> getGeneratedFiles() {
        return generatedFiles;
    }
    
    
    public ANTLRDependenceRecoverer(String  destdir,
                                    boolean listener    ,
                                    boolean visitor     ,
                                    String  codePackage ,
                                    boolean atn         ) {
        instance = this;
        
        this.destdir = destdir;
        this.listener = listener;
        this.visitor = visitor;
        this.codePackage = codePackage;
        this.atn = atn;
        
        importedGrammarFiles = null;
        importedTokenFiles = null;
        generatedFiles = null;
    }
    

    private static final String JAVA_EXT = ".java";
    private static final String TOKENS_EXT = ".tokens";
    public void defineDependencesOf(ANTLRFile grammarFile) {
        String absoluteGrammarFileDir = grammarFile.getPath().getParent().toString();
        FileConverter fileConverter = FileConverter.getInstance();
        if (fileConverter == null)
            throw new BuildException("You forgot to initialize path converter");
        Path relativeGrammarFileDirPath =
           fileConverter.convertIntoRelativeSrcPath(absoluteGrammarFileDir);
        
//        System.out.println("defineDependencesOf(): relative grammar file dir path = " + relativeGrammarFileDirPath);
        
        generatedFiles = new ArrayList<>();
        try (
            InputStream is = new FileInputStream(grammarFile.getPath().toFile());
        ) {
         // We do not define ANTLR dependences by using ANTLR -depend option.
         // It may seem weird. In fact, this option has several bugs. For
         // instance, the three next ones:
         // - the dependence to tokens file leads to a local file path and an
         //   absolute path for other ones (if the path of the grammar file is
         //   absolute),
         // - the imported grammars are not in the list of files that grammar
         //   depends on!!!
         // - if a parser grammar has no rule, ANTLR generator generates no 
         //   parser Java class but it appears in the list of dependent files.
            ANTLRInputStream input = new ANTLRInputStream(is);
            ANTLRv4Lexer lexer = new ANTLRv4Lexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            ANTLRv4Parser parser = new ANTLRv4Parser(tokens);
            
         // remove ConsoleErrorListener for not being annoyed by possible
         // syntactic errors
            parser.removeErrorListeners();
            
            InfoCollector dependInfoCollector = new InfoCollector(relativeGrammarFileDirPath);
            parser.addParseListener(dependInfoCollector);
            
            parser.grammarFile();
            
            GrammarType grammarType = dependInfoCollector.getGrammarType();
            String grammarName = dependInfoCollector.getGrammarName();
            importedGrammarFiles =dependInfoCollector.getImportedGrammarFiles();
            importedTokenFiles = dependInfoCollector.getImportedTokenFiles();
            
            switch (grammarType) {
                case LEXER: {
                 // A lexer grammar leads to the generation of:
                 // - a lexer
                    StringBuilder lexerClassFile = new StringBuilder();
                    lexerClassFile.append(grammarName);
                    lexerClassFile.append(JAVA_EXT);
                    Path lexerClassFileRelativePath =
                               Paths.get(relativeGrammarFileDirPath.toString(),
                                         lexerClassFile.toString()            );
                    generatedFiles.add(lexerClassFileRelativePath.toString());
                 // - a lexer token file
                    StringBuilder lexerTokensFile = new StringBuilder();
                    lexerTokensFile.append(grammarName);
                    lexerTokensFile.append(TOKENS_EXT);
                    Path lexerTokensFileRelativePath =
                               Paths.get(relativeGrammarFileDirPath.toString(),
                                         lexerTokensFile.toString()           );
                    generatedFiles.add(lexerTokensFileRelativePath.toString());
                    break;
                }
                case PARSER: {
                 // A parser grammar leads to the generation of:
                 // - a parser
                    StringBuilder parserClassFile = new StringBuilder();
                    parserClassFile.append(grammarName);
                    parserClassFile.append(JAVA_EXT);
                    Path parserClassFileRelativePath =
                               Paths.get(relativeGrammarFileDirPath.toString(),
                                         parserClassFile.toString()           );
                    generatedFiles.add(parserClassFileRelativePath.toString());
                 // - a parser token file
                    StringBuilder parserTokensFile = new StringBuilder();
                    parserTokensFile.append(grammarName);
                    parserTokensFile.append(TOKENS_EXT);
                    Path parserTokensFileRelativePath =
                               Paths.get(relativeGrammarFileDirPath.toString(),
                                         parserTokensFile.toString()          );
                    generatedFiles.add(parserTokensFileRelativePath.toString());
                 // - a Listener and a BaseListener if listener is true
                    if (listener) {
                        StringBuilder baseListenerClassFile = new StringBuilder();
                        baseListenerClassFile.append(grammarName);
                        baseListenerClassFile.append("BaseListener");
                        baseListenerClassFile.append(JAVA_EXT);
                        Path baseListenerClassFileRelativePath =
                               Paths.get(relativeGrammarFileDirPath.toString(),
                                         baseListenerClassFile.toString()     );
                        generatedFiles.add(baseListenerClassFileRelativePath.toString());
                        StringBuilder listenerClassFile = new StringBuilder();
                        listenerClassFile.append(grammarName);
                        listenerClassFile.append("Listener");
                        listenerClassFile.append(JAVA_EXT);
                        Path listenerClassFileRelativePath =
                               Paths.get(relativeGrammarFileDirPath.toString(),
                                         listenerClassFile.toString()         );
                        generatedFiles.add(listenerClassFileRelativePath.toString());
                    }
                 // - a Visitor and a BaseVisitor if visitor is true
                    if (visitor) {
                        StringBuilder baseVisitorClassFile = new StringBuilder();
                        baseVisitorClassFile.append(grammarName);
                        baseVisitorClassFile.append("BaseVisitor");
                        baseVisitorClassFile.append(JAVA_EXT);
                        Path baseVisitorClassFileRelativePath =
                               Paths.get(relativeGrammarFileDirPath.toString(),
                                         baseVisitorClassFile.toString()      );
                        generatedFiles.add(baseVisitorClassFileRelativePath.toString());
                        StringBuilder visitorClassFile = new StringBuilder();
                        visitorClassFile.append(grammarName);
                        visitorClassFile.append("Visitor");
                        visitorClassFile.append(JAVA_EXT);
                        Path visitorClassFileRelativePath =
                               Paths.get(relativeGrammarFileDirPath.toString(),
                                         visitorClassFile.toString()          );
                        generatedFiles.add(visitorClassFileRelativePath.toString());
                    }
                    break;
                }
                case COMBINED: {
                 // A parser grammar leads to the generation of:
                 // - a parser
                    StringBuilder parserClassFile = new StringBuilder();
                    parserClassFile.append(grammarName);
                    parserClassFile.append("Parser");
                    parserClassFile.append(JAVA_EXT);
                    Path parserClassFileRelativePath =
                               Paths.get(relativeGrammarFileDirPath.toString(),
                                         parserClassFile.toString()           );
                    generatedFiles.add(parserClassFileRelativePath.toString());
                 // - a parser token file
                    StringBuilder parserTokensFile = new StringBuilder();
                    parserTokensFile.append(grammarName);
                    parserTokensFile.append(TOKENS_EXT);
                    Path parserTokensFileRelativePath =
                               Paths.get(relativeGrammarFileDirPath.toString(),
                                         parserTokensFile.toString()          );
                    generatedFiles.add(parserTokensFileRelativePath.toString());
                 // - a lexer
                    StringBuilder lexerClassFile = new StringBuilder();
                    lexerClassFile.append(grammarName);
                    lexerClassFile.append("Lexer");
                    lexerClassFile.append(JAVA_EXT);
                    Path lexerClassFileRelativePath =
                               Paths.get(relativeGrammarFileDirPath.toString(),
                                         lexerClassFile.toString()            );
                    generatedFiles.add(lexerClassFileRelativePath.toString());
                 // - a lexer token file
                    StringBuilder lexerTokensFile = new StringBuilder();
                    lexerTokensFile.append(grammarName);
                    lexerTokensFile.append("Lexer");
                    lexerTokensFile.append(TOKENS_EXT);
                    Path lexerTokensFileRelativePath =
                               Paths.get(relativeGrammarFileDirPath.toString(),
                                         lexerTokensFile.toString()           );
                    generatedFiles.add(lexerTokensFileRelativePath.toString());
                 // - a Listener and a BaseListener if listener is true
                    if (listener) {
                        StringBuilder baseListenerClassFile = new StringBuilder();
                        baseListenerClassFile.append(grammarName);
                        baseListenerClassFile.append("BaseListener");
                        baseListenerClassFile.append(JAVA_EXT);
                        Path baseListenerFileRelativePath =
                               Paths.get(relativeGrammarFileDirPath.toString(),
                                         baseListenerClassFile.toString()     );
                        generatedFiles.add(baseListenerFileRelativePath.toString());
                        StringBuilder listenerClassFile = new StringBuilder();
                        listenerClassFile.append(grammarName);
                        listenerClassFile.append("Listener");
                        listenerClassFile.append(JAVA_EXT);
                        Path listenerClassFileRelativePath =
                               Paths.get(relativeGrammarFileDirPath.toString(),
                                         listenerClassFile.toString()         );
                        generatedFiles.add(listenerClassFileRelativePath.toString());
                    }
                 // - a Visitor and a BaseVisitor if visitor is true
                    if (visitor) {
                        StringBuilder baseVisitorClassFile = new StringBuilder();
                        baseVisitorClassFile.append(grammarName);
                        baseVisitorClassFile.append("BaseVisitor");
                        baseVisitorClassFile.append(JAVA_EXT);
                        Path baseVisitorFileRelativePath =
                               Paths.get(relativeGrammarFileDirPath.toString(),
                                         baseVisitorClassFile.toString()      );
                        generatedFiles.add(baseVisitorFileRelativePath.toString());
                        StringBuilder visitorClassFile = new StringBuilder();
                        visitorClassFile.append(grammarName);
                        visitorClassFile.append("Visitor");
                        visitorClassFile.append(JAVA_EXT);
                        Path visitorClassFileRelativePath =
                               Paths.get(relativeGrammarFileDirPath.toString(),
                                         visitorClassFile.toString()          );
                        generatedFiles.add(visitorClassFileRelativePath.toString());
                    }
                    break;
                }
                case UNDEFINED:
                 // If a syntactic error has prevented to determine the grammar
                 // type, we do nothing
                    break;
            }
        } catch (IOException ex) {
            throw new BuildException("Unable to read file " + grammarFile.getPath().toString());
        }
    }
}