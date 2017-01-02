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
package org.nemesis.antlr.v4.netbeans.v8.grammar.semantic.checking.error;

import org.nemesis.antlr.v4.netbeans.v8.grammar.syntax.checking.ANTLRv4GrammarChecker;
import org.nemesis.antlr.v4.netbeans.v8.generic.parsing.ParsingError;
import org.nemesis.antlr.v4.netbeans.v8.grammar.syntax.checking.impl.ANTLRv4BaseListener;
import org.nemesis.antlr.v4.netbeans.v8.grammar.syntax.checking.impl.ANTLRv4Parser;
import org.nemesis.antlr.v4.netbeans.v8.grammar.syntax.checking.impl.ANTLRv4Parser.TokenIdentifierContext;

import org.antlr.v4.runtime.RecognitionException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import org.nemesis.antlr.v4.netbeans.v8.grammar.syntax.checking.impl.ANTLRv4Parser.ClassIdentifierContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.syntax.checking.impl.ANTLRv4Parser.DelegateGrammarContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.syntax.checking.impl.ANTLRv4Parser.IdentifierContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.syntax.checking.impl.ANTLRv4Parser.ImportDeclarationContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.syntax.checking.impl.ANTLRv4Parser.LexerRuleDeclarationContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.syntax.checking.impl.ANTLRv4Parser.ModeSpecContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.syntax.checking.impl.ANTLRv4Parser.PackageIdentifierContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.syntax.checking.impl.ANTLRv4Parser.ParserRuleDeclarationContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.syntax.checking.impl.ANTLRv4Parser.ParserRuleIdentifierContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.syntax.checking.impl.ANTLRv4Parser.ParserRuleReferenceContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.syntax.checking.impl.ANTLRv4Parser.SingleTypeImportDeclarationContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.syntax.checking.impl.ANTLRv4Parser.SuperClassSpecContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.syntax.checking.impl.ANTLRv4Parser.TerminalContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.syntax.checking.impl.ANTLRv4Parser.TokenLabelTypeSpecContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.syntax.checking.impl.ANTLRv4Parser.TokenListContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.syntax.checking.impl.ANTLRv4Parser.TokenVocabSpecContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.syntax.checking.impl.ANTLRv4Parser.TokensSpecContext;

import org.nemesis.antlr.v4.netbeans.v8.project.ProjectType;

import org.netbeans.api.project.FileOwnerQuery;
import org.netbeans.api.project.Project;

import org.netbeans.api.project.ant.AntBuildExtender;

import org.netbeans.modules.csl.api.Severity;
import org.netbeans.modules.maven.api.NbMavenProject;

import org.netbeans.spi.project.support.ant.PropertyEvaluator;
import org.netbeans.spi.project.support.ant.PropertyProvider;
import org.netbeans.spi.project.support.ant.PropertyUtils;

import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;

import org.openide.util.Lookup;


/**
 *
 * @author Frédéric Yvon Vinet
 */
public class ANTLRv4SemanticParser extends ANTLRv4BaseListener {
    private static final Logger LOG = Logger.getLogger("ANTLR plugin:" + ANTLRv4SemanticParser.class.getName());
    
    private final String                       parsedFileName;
    private       GrammarDeclaration           grammarDeclaration;
    private final String                       grammarName;
    private final String                       parsedGrammarDirectory;
    private       GrammarType                  grammarType;
    
    private final Project                      project;
    private final String                       projectDirectory;
    private final ProjectType                  projectType;
    
    private final HashMap<Path, Integer>       importStatements;
    
    private       String            packageName;
    private final ArrayList<String> javaImports;
    
    private final Set<String>                  ruleDeclarations;
    private final Map<String, RuleDeclaration> parserRuleDeclarations;
    private final Map<String, RuleDeclaration> tokenRuleDeclarations;
    private       String                       firstParserRuleDeclaration;
    private       String                       firstImportedParserRule;
    private final Map<String, RuleReference>   ruleReferences;
    private final List<ParsingError>  semanticErrors;
    private final boolean                      semanticErrorRequired;
    
    
    public boolean encounteredError() {
        return getErrorNumber() != 0;
    }
    public int getErrorNumber() {
        return semanticErrors.size();
    }
    public List<ParsingError> getSemanticErrors() {
        return semanticErrors;
    }

    
    public GrammarType getGrammarType() {
        return grammarType;
    }

    public String getGrammarName() {
        return grammarName;
    }
    
    public Set<String> getRuleDeclarations() {
        return ruleDeclarations;
    }
    
    public Map<String, RuleDeclaration> getParserRuleDeclarations() {
        return parserRuleDeclarations;
    }
    
    public Map<String, RuleDeclaration> getTokenRuleDeclarations() {
        return tokenRuleDeclarations;
    }
    
    public Map<String, RuleReference> getRuleReferences() {
        return ruleReferences;
    }
    
    public String getFirstParserRule() {
        return (this.firstParserRuleDeclaration != null) ?
                   this.firstParserRuleDeclaration
                :
                   this.firstImportedParserRule;
    }

    public String getPackageName() {
        return packageName;
    }

    public ArrayList<String> getJavaImports() {
        return javaImports;
    }
    
    
    public ANTLRv4SemanticParser(String parsedFileName) {
        this.parsedFileName = parsedFileName;
        Path grammarFilePath = Paths.get(parsedFileName);
        String grammarFileName = grammarFilePath.toFile().getName();
        int index = grammarFileName.indexOf(".");
        this.grammarName = grammarFileName.substring(0, index);
        index = parsedFileName.indexOf(grammarName);
        this.parsedGrammarDirectory = parsedFileName.substring(0, index);
        
        this.project = getProject(grammarFilePath);
        FileObject projectDirectoryFileObject = project.getProjectDirectory();
        this.projectDirectory = projectDirectoryFileObject.getPath();
        this.projectType = getProjectType(project);
        
     // We determine if semantic error generation is diabled for current file
        Path propertyFilePath = Paths.get(projectDirectory                    ,
                                          "disable_semantic_errors.properties");
        File propertiesFile = propertyFilePath.toFile();
        if (propertiesFile.exists()) {
//            System.out.println("ANTLRv4SemanticParser.ANTLRv4SemanticParser() : property files exists");
            PropertyProvider propertyProvider = PropertyUtils.
                                 propertiesFilePropertyProvider(propertiesFile);
            PropertyEvaluator propertyEvaluator = PropertyUtils.
                            sequentialPropertyEvaluator(null, propertyProvider);
            String FilesInString = propertyEvaluator.getProperty
                                       ("antlr.semantic.errors.files.excluded");
            if (FilesInString != null) {
//                System.out.println("ANTLRv4SemanticParser.ANTLRv4SemanticParser() : searched property exists");
                String[] files = FilesInString.split(",");
                ArrayList<String> excludedFiles = new ArrayList<>();
                for (String file : files) {
                    Path excludedFilepath = Paths.get(projectDirectory,
                                                      file.trim()     );
//                    System.out.println("ANTLRv4SemanticParser.ANTLRv4SemanticParser() : excluded file=" + excludedFilepath);
                    excludedFiles.add(excludedFilepath.toString());
                }
                if (excludedFiles.contains(parsedFileName))
                    semanticErrorRequired = false;
                else
                    semanticErrorRequired = true;
            } else
                semanticErrorRequired = true;
        } else
            semanticErrorRequired = true;
//        System.out.println("ANTLRv4SemanticParser.ANTLRv4SemanticParser() : parsedFileName=" + parsedFileName);
//        System.out.println("ANTLRv4SemanticParser.ANTLRv4SemanticParser() : semanticErrorRequired?" + semanticErrorRequired);
        
//        System.out.println("grammarName=" + grammarName);
//        System.out.println("parsedGrammarDirectory=" + parsedGrammarDirectory);
        
        this.grammarType = GrammarType.UNDEFINED;
        this.grammarDeclaration = null;
        
        this.ruleDeclarations = new HashSet<>();
     // Some tokens are predefined and common to all lexers
        ruleDeclarations.add("EOF");
        this.parserRuleDeclarations = new HashMap<>();
        this.tokenRuleDeclarations = new HashMap<>();
        this.firstParserRuleDeclaration = null;
        this.ruleReferences = new HashMap<>();
        this.semanticErrors = new ArrayList<>();
        
        this.packageName = null;
        this.javaImports = new ArrayList<>();
        
        this.importStatements = new HashMap<>();
    }
    
    
    @Override
    public void exitGrammarSpec(ANTLRv4Parser.GrammarSpecContext ctx) {
        ANTLRv4Parser.IdentifierContext ic = ctx.identifier();
        String recoveredGrammarName = ic.getText();
        int index = ic.ID().getSymbol().getStartIndex();
        if (semanticErrorRequired) {
            if (!recoveredGrammarName.equals(grammarName)) {
                String key = "antlr.error.grammar.must.be.equal.to.the.grammar.file.name";
                File file = new File(parsedFileName);
                FileObject fo = FileUtil.toFileObject(file);
                String displayName = "The grammar name must be equal to the " +
                    "grammar file name (without extension)";
                String description = displayName;
                ParsingError semanticError = new ParsingError
                                (fo            ,
                                 Severity.ERROR,
                                 key           ,
                                 index         ,
                                 displayName   ,
                                 description   );
                semanticErrors.add(semanticError);
            }
        }
        
        ANTLRv4Parser.GrammarTypeContext gtc = ctx.grammarType();
        if (gtc.LEXER() != null)
            grammarType = GrammarType.LEXER;
        else if (gtc.PARSER() != null)
            grammarType = GrammarType.PARSER;
        else if (gtc.GRAMMAR() != null)
            grammarType = GrammarType.COMBINED;
        else
            grammarType = GrammarType.UNDEFINED;
        grammarDeclaration = new GrammarDeclaration
             (grammarType, grammarName, index);
    }
    
    
 /**
  * Called at the end of a Java package declaration,
  * 
  * @param ctx 
  */
    @Override
    public void exitPackageIdentifier(PackageIdentifierContext ctx) {
        List<IdentifierContext> ids = ctx.identifier();
        Iterator<IdentifierContext> it = ids.iterator();
        StringBuilder packageNameBuilder = new StringBuilder();
        IdentifierContext ic;
        Token token;
        while (it.hasNext()) {
            ic = it.next();
            token = ic.ID().getSymbol();
            if ("".equals(packageNameBuilder.toString()))
                packageNameBuilder.append(token.getText());
            else {
                packageNameBuilder.append(".");
                packageNameBuilder.append(token.getText());
            }
        }
        packageName = packageNameBuilder.toString();
    }
    
    
  /**
   * Called at the end of an ANTLR import statement.
   * 
   * @param ctx 
   */
    @Override
    public void exitDelegateGrammar(DelegateGrammarContext ctx) {
        IdentifierContext ic = ctx.grammarIdentifier().identifier();
        String importedGrammarName = ic.getText();
        String importedGrammarFileName = importedGrammarName + ".g4";
        int index = ic.ID().getSymbol().getStartIndex();
        if (semanticErrorRequired) {
            if (importedGrammarName.equals(grammarName)) {
                String key = "antlr.error.import.a.grammar.cannot.import.itself";
                String displayName = "A grammar cannot import itself ";
                String description = displayName;
                File file = new File(parsedFileName);
                FileObject fo = FileUtil.toFileObject(file);
                ParsingError semanticError = new ParsingError
                    (fo            ,
                     Severity.ERROR,
                     key           ,
                     index         ,
                     displayName   ,
                     description   );
                semanticErrors.add(semanticError);
            } else {
             // We look for the imported grammar from the same directory as the
             // current grammar file
             // we build the grammar file path as a local path from that directory
                Path importedGrammarFilePath = Paths.get
                                                      (parsedGrammarDirectory ,
                                                       importedGrammarFileName);
                File importedGrammarFile = importedGrammarFilePath.toFile();
                if (!importedGrammarFile.exists()) {
                 // We didn't find the file in that directory so now we look for 
                 // it in :
                 // - antlr.generator.import.dir directory if it is an ant-based 
                 //   project,
                 // - src/main/antlr4/imports if it is a Maven-based project.
                    switch (projectType) {
                        case ANT_BASED :
                            Path propertyFilePath = Paths.get
                                                         (projectDirectory    ,
                                                          "nbproject"         ,
                                                          "project.properties");
                            File propertiesFile = propertyFilePath.toFile();
                            PropertyProvider propertyProvider = PropertyUtils.
                                 propertiesFilePropertyProvider(propertiesFile);
                            PropertyEvaluator propertyEvaluator = PropertyUtils.
                            sequentialPropertyEvaluator(null, propertyProvider);
                            String importDir = propertyEvaluator.getProperty
                                                 ("antlr.generator.import.dir");
                            if (importDir != null) {
                                importDir = importDir.trim();
                                if (!importDir.equals("")) {
                                    importedGrammarFilePath = Paths.get
                                                   (projectDirectory       ,
                                                    importDir              ,
                                                    importedGrammarFileName);
                                    importedGrammarFile =
                                               importedGrammarFilePath.toFile();
                                } else
                                    importedGrammarFile = null;
                            } else
                                importedGrammarFile = null;
                            break;
                        case MAVEN_BASED :
                            importedGrammarFilePath = Paths.get
                                                   (projectDirectory         ,
                                                    "src/main/antlr4/imports",
                                                    importedGrammarFileName  );
                            importedGrammarFile = importedGrammarFilePath.toFile();
                            break;
                        default:
                            importedGrammarFile = null;
                    }
                }
                if ((importedGrammarFile == null) ||
                    !importedGrammarFile.exists()   ) {
                    String key = "antlr.error.import.grammar.not.found";
                    String displayName = "Unable to import the grammar file " +
                                         importedGrammarName + ".g4" + 
                                         " in the directory of " + grammarName;
                    String description = importedGrammarName +
                                    " has been searched in " + parsedGrammarDirectory;
                    File file = new File(parsedFileName);
                    FileObject fo = FileUtil.toFileObject(file);
                    ParsingError semanticError = new ParsingError
                                                               (fo            ,
                                                                Severity.ERROR,
                                                                key           ,
                                                                index         ,
                                                                displayName   ,
                                                                description   );
                    semanticErrors.add(semanticError);
                } else {
                    importStatements.put(importedGrammarFilePath, index);
                    GrammarType importedGrammarType =
                        parseGrammarFile(importedGrammarFile.getPath(), index);
                    switch (grammarType) {
                        case LEXER :
                            if ((importedGrammarType != GrammarType.LEXER) &&
                                (importedGrammarType != GrammarType.UNDEFINED)) {
                                String key = "antlr.error.import.lexer.grammar.can.only.import.lexer.grammars";
                                String displayName =
                                    "A lexer grammar can only include lexer grammars";
                                String description = displayName +
                                   "grammar " + grammarName + " is a lexer grammar" +
                                   "grammar " + importedGrammarName + " is a " + importedGrammarType + " grammar";
                                File file = new File(parsedFileName);
                                FileObject fo = FileUtil.toFileObject(file);
                                ParsingError semanticError = new ParsingError
                                    (fo            ,
                                     Severity.ERROR,
                                     key           ,
                                     index         ,
                                     displayName   ,
                                     description   );
                                semanticErrors.add(semanticError);
                            }
                            break;
                        case PARSER :
                            if ((importedGrammarType != GrammarType.PARSER) &&
                                (importedGrammarType != GrammarType.UNDEFINED)) {
                                String key = "antlr.error.import.parser.grammar.can.only.import.parser.grammars";
                                String displayName =
                                    "A parser grammar can only import parser grammars";
                                String description = displayName +
                                    "grammar " + grammarName + " is a parser grammar" +
                                    "grammar " + importedGrammarName + " is a " + importedGrammarType + " grammar";
                                File file = new File(parsedFileName);
                                FileObject fo = FileUtil.toFileObject(file);
                                ParsingError semanticError = new ParsingError
                                    (fo            ,
                                     Severity.ERROR,
                                     key           ,
                                     index         ,
                                     displayName   ,
                                     description   );
                                semanticErrors.add(semanticError);
                            }
                            break;
                        case COMBINED :
                            if (importedGrammarType == GrammarType.COMBINED) {
                                String key = "antlr.error.import.combined.grammar.can.only.import.parser.and.lexer.grammars";
                                String displayName =
                                    "A combined grammar can only include parser and lexer grammars";
                                String description = displayName +
                                    "grammar " + grammarName + " is a combined grammar" +
                                    "grammar " + importedGrammarName + " is a " + importedGrammarType + " grammar";
                                File file = new File(parsedFileName);
                                FileObject fo = FileUtil.toFileObject(file);
                                ParsingError semanticError = new ParsingError
                                    (fo            ,
                                     Severity.ERROR,
                                     key           ,
                                     index         ,
                                     displayName   ,
                                     description   );
                                semanticErrors.add(semanticError);
                            }
                            break;
                        case UNDEFINED:
                            break;
                    }
                }
            }
        }
    }
    
    
  /**
   * Called at the end of a Java import statement located in a @header action 
   * block. It is used for recovering all imported imported classes with their
   * package. With that information, we are able to check if a class used in 
   * an ANTLR declaration (TokenLabelType or superClass options) is really 
   * accessible.
   * It is also recovered for building an HyperlinkParser that will use that
   * information for generating an hyperlink for the same ANTLR declaration 
   * to the file containng the class.
   * 
   * @param ctx 
   */
    @Override
    public void exitImportDeclaration(ImportDeclarationContext ctx) {
        SingleTypeImportDeclarationContext stidc = ctx.singleTypeImportDeclaration();
        ClassIdentifierContext cic = stidc.classIdentifier();
        Token token;
        StringBuilder classNameBuilder = new StringBuilder();
        IdentifierContext ic;
        List<IdentifierContext> idcs;
        String generic = null;
        if (cic != null) {
            idcs = cic.identifier();
        } else {
         // There is also the possibility to have a genereic identifier
            ANTLRv4Parser.GenericClassIdentifierContext gic = stidc.genericClassIdentifier();
         // Normally gic cannot be null except in case of syntax error
            if (gic != null) {
                idcs = gic.identifier();
                generic = ".*";
            } else
                idcs = null;
        }
        if (idcs != null) {
            Iterator<IdentifierContext> it = idcs.iterator();
            while (it.hasNext()) {
                ic = it.next();
                token = ic.ID().getSymbol();
                if ("".equals(classNameBuilder.toString()))
                    classNameBuilder.append(token.getText());
                else {
                    classNameBuilder.append(".");
                    classNameBuilder.append(token.getText());
                }
            }
            if (generic != null)
                classNameBuilder.append(generic);
//            System.out.println("HyperlinkParser : found import declaration = " + classNameBuilder.toString());
            javaImports.add(classNameBuilder.toString());
        }
    }
    
    
    @Override
    public void exitSuperClassSpec(SuperClassSpecContext ctx) {
     // A class identifier may contain a package name so identifier returns
     // a list of identifiers
        ClassIdentifierContext cic = ctx.classIdentifier();
        int targetStart = cic.getStart().getStartIndex();
        int targetEnd   = cic.getStop().getStopIndex() + 1;
        String fullQualifiedSuperClass = getClassNameWithPackage(cic);
        
        int start = fullQualifiedSuperClass.lastIndexOf(".");
     // Next statement is valid even if start = -1
        String className = fullQualifiedSuperClass.substring(start + 1);
        String superClassPackage;
        if (start == -1)
            superClassPackage = "";
        else
            superClassPackage = fullQualifiedSuperClass.substring(0, start);
        
     // There is a link to fullQualifiedSuperClass transformed in directory
        String superClassFilePathString = fullQualifiedSuperClass.replace
                                                                     (".", "/");
        superClassFilePathString = superClassFilePathString + ".java";
     // The first place where Java source may be is:
     // - in antlr.generator.dest.dir (mandatory property) concatenated with
     //   its potential package transformed in directory structure if the project is 
     //   ant-based,
     // - in target/generated-sources/antlr4 concatenated with its potential 
     //   package transformed in directory structure if project is Maven-based.
        String srcDir;
        switch (projectType) {
            case ANT_BASED:
                srcDir = getAntProjectProperty("src.dir");
                break;
            case MAVEN_BASED:
                srcDir = "src/main/java";
                break;
            default:
                srcDir = null;
        }
        boolean error = false;
        if (srcDir != null) {
            Path superClassPath = Paths.get(projectDirectory        ,
                                            srcDir                  ,
                                            superClassFilePathString);
            File superClassFile = superClassPath.toFile();
//            System.out.println("superClassFile=" + superClassFile.getPath());
         // If the file is not in this directory and there is no package in
         // superClass then there may be a Java import statement telling where
         // to find the source
            if (!superClassFile.exists() &&
                "".equals(superClassPackage)) {
                Iterator<String> it2 = javaImports.iterator();
                String fullQualifiedImportedClassName;
                String importedClassName;
                boolean found = false;
                while (it2.hasNext() && !found) {
                    fullQualifiedImportedClassName = it2.next();
                    start = fullQualifiedImportedClassName.lastIndexOf(".");
                    importedClassName = fullQualifiedImportedClassName.substring(start + 1);
                 // here classNameWithPackage is just a class name because 
                 // superClassPackageName is empty
//                    System.out.println("importedClassName=" + importedClassName);
//                    System.out.println("targetWord=" + targetWord);
                    if (importedClassName.equals(className)) {
                        found = true;
                        superClassFilePathString = fullQualifiedImportedClassName
                                                        .replace(".", "/");
                        superClassFilePathString = superClassFilePathString + ".java";
//                        System.out.println("superClassFilePathString 2=" + superClassFilePathString);
                        superClassPath = Paths.get(projectDirectory        ,
                                                   srcDir                  ,
                                                   superClassFilePathString);
                        superClassFile = superClassPath.toFile();
                    }
                }
             // No Java import statement has been found so we have an error
                if (!found) {
                    error = true;
                } else {
                    error = !superClassFile.exists();
                }
            } else {
             // the superClass source has been found or there was a package 
             // specified
                if (!superClassFile.exists())
                    error = true;
            }
            if (error && semanticErrorRequired) {
                String key = "antlr.error.super.class.source.missing";
                int index = targetStart;
                String displayName = "unable to find super class Java source";
                String description = displayName;
                File file = new File(parsedFileName);
                FileObject fo = FileUtil.toFileObject(file);
                ParsingError semanticWarning = new ParsingError
                                (fo            ,
                                 Severity.ERROR,
                                 key           ,
                                 index         ,
                                 displayName   ,
                                 description   );
                semanticErrors.add(semanticWarning);
            }
        } else {
            if (semanticErrorRequired) {
             // src.dir property is missing in project.properties
                String key = "antlr.error.src.dir.property.missing";
                int index = targetStart;
                String displayName = "src.dir property is missing in project.properties file";
                String description = displayName;
                File file = new File(parsedFileName);
                FileObject fo = FileUtil.toFileObject(file);
                ParsingError semanticWarning = new ParsingError
                                (fo            ,
                                 Severity.ERROR,
                                 key           ,
                                 index         ,
                                 displayName   ,
                                 description   );
                semanticErrors.add(semanticWarning);
            }
        }
    }
    
    
    private String getClassNameWithPackage(ClassIdentifierContext ctx) {
        List<IdentifierContext> ics = ctx.identifier();
        Iterator<IdentifierContext> it = ics.iterator();
        IdentifierContext ic;
        Token token;
     // A word may be a package name or a class name if it is the last
     // ic of ics
        String word;
        StringBuilder classNameWithPackage = new StringBuilder();
        while (it.hasNext()) {
            ic = it.next();
            token = ic.ID().getSymbol();
            word = token.getText();
            if ("".equals(classNameWithPackage.toString()))
                classNameWithPackage.append(word);
            else {
                classNameWithPackage.append(".");
                classNameWithPackage.append(word);
            }
//            System.out.println("start=" + start + " end=" + end);
        }
        return classNameWithPackage.toString();
    }
    
    
    private String getAntProjectProperty(String propertyName) {
        Path propertyFilePath = Paths.get(projectDirectory    ,
                                          "nbproject"         ,
                                          "project.properties");
        File propertiesFile = propertyFilePath.toFile();
        PropertyProvider propertyProvider = PropertyUtils.
                                 propertiesFilePropertyProvider(propertiesFile);
        PropertyEvaluator propertyEvaluator = PropertyUtils.
                            sequentialPropertyEvaluator(null, propertyProvider);
        return propertyEvaluator.getProperty(propertyName);
    }
    
    
    @Override
    public void exitTokenVocabSpec(TokenVocabSpecContext ctx) {
     // We update the rule declarations
        String tokenSourceId = ctx.identifier().getText();
        int index = ctx.identifier().ID().getSymbol().getStartIndex();
     // If tokenSourceId does not exist, recoverTokensFrom method will raise
     // an error message
        List<String> recoveredTokens = recoverTokensFrom(tokenSourceId, index);
        ruleDeclarations.addAll(recoveredTokens);
    }
    
    
    @Override
    public void exitTokenLabelTypeSpec(TokenLabelTypeSpecContext ctx) {
     // A class identifier may contain a package name so identifier returns
     // a list of identifiers
        ClassIdentifierContext cic = ctx.classIdentifier();
        int targetStart = cic.getStart().getStartIndex();
        int targetEnd   = cic.getStop().getStopIndex() + 1;
        String fullQualifiedTokenClass = getClassNameWithPackage(cic);
        
        int start = fullQualifiedTokenClass.lastIndexOf(".");
     // Next statement is valid even if start = -1
        String className = fullQualifiedTokenClass.substring(start + 1);
        String tokenClassPackage;
        if (start == -1)
            tokenClassPackage = "";
        else
            tokenClassPackage = fullQualifiedTokenClass.substring(0, start);
        
     // There is a link to fullQualifiedSuperClass transformed in directory
        String tokenClassFilePathString = fullQualifiedTokenClass.replace
                                                                     (".", "/");
        tokenClassFilePathString = tokenClassFilePathString + ".java";
     // The first place where Java source may be is:
     // - in antlr.generator.dest.dir (mandatory property) concatenated with
     //   its potential package transformed in directory structure if the project is 
     //   ant-based,
     // - in target/generated-sources/antlr4 concatenated with its potential 
     //   package transformed in directory structure if project is Maven-based.
        String srcDir;
        switch (projectType) {
            case ANT_BASED:
                srcDir = getAntProjectProperty("src.dir");
                break;
            case MAVEN_BASED:
                srcDir = "src/main/java";
                break;
            default:
                srcDir = null;
        }
        boolean error = false;
        if (srcDir != null) {
            Path tokenClassPath = Paths.get(projectDirectory        ,
                                            srcDir                  ,
                                            tokenClassFilePathString);
            File tokenClassFile = tokenClassPath.toFile();
//            System.out.println("superClassFile=" + superClassFile.getPath());
         // If the file is not in this directory and there is no package in
         // superClass then there may be a Java import statement telling where
         // to find the source
            if (!tokenClassFile.exists() &&
                "".equals(tokenClassPackage)) {
                Iterator<String> it2 = javaImports.iterator();
                String fullQualifiedImportedClassName;
                String importedClassName;
                boolean found = false;
                while (it2.hasNext() && !found) {
                    fullQualifiedImportedClassName = it2.next();
                    start = fullQualifiedImportedClassName.lastIndexOf(".");
                    importedClassName = fullQualifiedImportedClassName.substring(start + 1);
                 // here classNameWithPackage is just a class name because 
                 // superClassPackageName is empty
//                    System.out.println("importedClassName=" + importedClassName);
//                    System.out.println("targetWord=" + targetWord);
                    if (importedClassName.equals(className)) {
                        found = true;
                        tokenClassFilePathString = fullQualifiedImportedClassName
                                                        .replace(".", "/");
                        tokenClassFilePathString = tokenClassFilePathString + ".java";
//                        System.out.println("superClassFilePathString 2=" + superClassFilePathString);
                        tokenClassPath = Paths.get(projectDirectory        ,
                                                   srcDir                  ,
                                                   tokenClassFilePathString);
                        tokenClassFile = tokenClassPath.toFile();
                    }
                }
             // No Java import statement has been found so we have an error
                if (!found) {
                    error = true;
                } else {
                    error = !tokenClassFile.exists();
                }
            } else {
             // the superClass source has been found or there was a package 
             // specified
                if (!tokenClassFile.exists())
                    error = true;
            }
            if (error && semanticErrorRequired) {
                String key = "antlr.error.super.class.source.missing";
                int index = targetStart;
                String displayName = "unable to find super class Java source";
                String description = displayName;
                File file = new File(parsedFileName);
                FileObject fo = FileUtil.toFileObject(file);
                ParsingError semanticWarning = new ParsingError
                                (fo            ,
                                 Severity.ERROR,
                                 key           ,
                                 index         ,
                                 displayName   ,
                                 description   );
                semanticErrors.add(semanticWarning);
            }
        } else {
            if (semanticErrorRequired) {
             // src.dir property is missing in project.properties
                String key = "antlr.error.src.dir.property.missing";
                int index = targetStart;
                String displayName = "src.dir property is missing in project.properties file";
                String description = displayName;
                File file = new File(parsedFileName);
                FileObject fo = FileUtil.toFileObject(file);
                ParsingError semanticWarning = new ParsingError
                                (fo            ,
                                 Severity.ERROR,
                                 key           ,
                                 index         ,
                                 displayName   ,
                                 description   );
                semanticErrors.add(semanticWarning);
            }
        }
    }
    
    
    @Override
    public void exitTokensSpec(TokensSpecContext ctx) {
        TokenListContext tlc = ctx.tokenList();
        if (tlc == null) {
            if (semanticErrorRequired) {
                String key = "antlr.warning.tokens.empty.token.list";
                int index = ctx.RBRACE().getSymbol().getStartIndex();
                String displayName = "empty token list";
                String description = displayName;
                File file = new File(parsedFileName);
                FileObject fo = FileUtil.toFileObject(file);
                ParsingError semanticWarning = new ParsingError
                                (fo              ,
                                 Severity.WARNING,
                                 key             ,
                                 index           ,
                                 displayName     ,
                                 description     );
                semanticErrors.add(semanticWarning);
            }
        } else {
            List<TokenIdentifierContext> tics = tlc.tokenIdentifier();
            Iterator<TokenIdentifierContext> tici = tics.iterator();
            TokenIdentifierContext tic;
            Token token;
            String word;
            while (tici.hasNext()) {
                tic = tici.next();
                if (tic != null) {
                    TerminalNode tn = tic.ID_STARTING_WITH_UPPERCASE();
                    if (tn != null) {
                        token = tn.getSymbol();
                        word = token.getText();
                        int tokenOffset = token.getStartIndex();
                        ruleDeclarations.add(word);
                        Path parsedFilePath = Paths.get(parsedFileName);
                        RuleDeclaration rd = new RuleDeclaration
                                            (parsedFilePath, word, tokenOffset);
                        tokenRuleDeclarations.put(word, rd);
//                        System.out.println("token rule declaration (in ANTLR tokens directive) inserted: " + token);
                    }
                }
            }
        }
    }
    
    
    @Override
    public void exitParserRuleDeclaration(ParserRuleDeclarationContext ctx) {
     // We add the id of the rule to the set of id
     // it enables to check that each parser rule reference has a correspondent
     // parser rule definition
        ParserRuleIdentifierContext pric = ctx.parserRuleIdentifier();
        Token token = pric.ID_STARTING_WITH_LOWERCASE().getSymbol();
        String parserRuleId = token.getText();
        int offset = token.getStartIndex();
/*
        System.out.println("SemanticParser::exitParserRuleDeclaration : " +
                           "parsed file name=" + parsedFileName +
                           " offset=" + offset +
                           " parserRuleId=" + parserRuleId);
*/
        switch (grammarType) {
            case LEXER: {
                if (semanticErrorRequired) {
                    String key = "antlr.error.parserRule.lexer.grammar.can.only." +
                             "contain.lexer.rule.declarations";
                    String displayName =
                     "a lexer grammar can only contain lexer rule declarations";
                    String description = displayName + "\n" +
                                 "rule " + parserRuleId + " is a parser rule";
                    File file = new File(parsedFileName);
                    FileObject fo = FileUtil.toFileObject(file);
                    ParsingError semanticError = new ParsingError
                                (fo            ,
                                 Severity.ERROR,
                                 key           ,
                                 offset        ,
                                 displayName   ,
                                 description   );
                    semanticErrors.add(semanticError);
                }
                break;
            }
            case COMBINED:
            case PARSER: {
                if (firstParserRuleDeclaration == null)
                    firstParserRuleDeclaration = parserRuleId;
                if (!ruleDeclarations.contains(parserRuleId)) {
                    ruleDeclarations.add(parserRuleId);
                    Path parsedFilePath = Paths.get(parsedFileName);
                    RuleDeclaration ruleDeclaration = new RuleDeclaration
                                          (parsedFilePath, parserRuleId, offset);
                    parserRuleDeclarations.put(parserRuleId, ruleDeclaration);
                } else {
                    if (semanticErrorRequired) {
                        String key = "antlr.error.parserRule.already.declared";
                        String displayName = "rule " + parserRuleId +
                                         " is already declared!";
                        String description = displayName;
                        File file = new File(parsedFileName);
                        FileObject fo = FileUtil.toFileObject(file);
                        ParsingError semanticError = new ParsingError
                                (fo            ,
                                 Severity.ERROR,
                                 key           ,
                                 offset        ,
                                 displayName   ,
                                 description   );
                        semanticErrors.add(semanticError);
                    }
                }
                break;
            }
            default:
        }
    }
    
    
    @Override
    public void exitParserRuleReference(ParserRuleReferenceContext ctx) {
        String parserRuleRefId = ctx.parserRuleIdentifier().ID_STARTING_WITH_LOWERCASE().getText();
        if (!ruleReferences.containsKey(parserRuleRefId)) {
            int index = ctx.parserRuleIdentifier().ID_STARTING_WITH_LOWERCASE().getSymbol().getStartIndex();
            RuleReference ruleRef = new RuleReference(parserRuleRefId, index);
            ruleReferences.put(parserRuleRefId, ruleRef);
        }
    }
    
    
  /**
   * Is called from a lexer or parser rule when its definition contains
   * a string literal or a lexer rule reference.
   * 
   * @param ctx 
   */
    @Override
    public void exitTerminal(TerminalContext ctx) {
        ANTLRv4Parser.TokenIdentifierContext lric = ctx.tokenIdentifier();
        if (lric != null) {
            String lexerRuleId = lric.ID_STARTING_WITH_UPPERCASE().getText();
            if (!ruleReferences.containsKey(lexerRuleId)) {
                int index = lric.ID_STARTING_WITH_UPPERCASE().getSymbol().getStartIndex();
                RuleReference ruleRef = new RuleReference(lexerRuleId, index);
                ruleReferences.put(lexerRuleId, ruleRef);
            }
        } else {
         // A parser grammar cannot define implicitly new token, so if we find
         // a literal and that literal is not defined in a token declaration
         // (through tokens) or an imported token file (through tokenVocab option)
            if (grammarType == GrammarType.PARSER) {
                String lexerLiteral = ctx.STRING_LITERAL().getText();
                if (!ruleDeclarations.contains(lexerLiteral) &&
                    semanticErrorRequired                      ) {
                    String key = "antlr.error.parser.grammar.cannot.add.implicitly.lexer.token.through.literal.use";
                    int index = ctx.STRING_LITERAL().getSymbol().getStartIndex();
                    String displayName = "A parser grammar cannot add implicitly a lexer token through a literal use.";
                    String description = displayName + "\n" +
                                     "literal in fault : " + lexerLiteral;
                    File file = new File(parsedFileName);
                    FileObject fo = FileUtil.toFileObject(file);
                    ParsingError semanticError = new ParsingError
                                (fo            ,
                                 Severity.ERROR,
                                 key           ,
                                 index         ,
                                 displayName   ,
                                 description   );
                    semanticErrors.add(semanticError);
                }
            }
        }
    }
    
    
    @Override
    public void exitLexerRuleDeclaration(LexerRuleDeclarationContext ctx) {
        String lexerRuleId;
        ANTLRv4Parser.TokenIdentifierContext lric = ctx.tokenIdentifier();
        if (lric != null) {
            lexerRuleId = lric.ID_STARTING_WITH_UPPERCASE().getText();
        } else {
            lexerRuleId = ctx.identifier().getText();
        }
        int index = (ctx.FRAGMENT() == null) ?
                     ctx.tokenIdentifier().getStart().getStartIndex() :
                     ctx.FRAGMENT().getSymbol().getStartIndex();
        if (grammarType == GrammarType.PARSER) {
            if (semanticErrorRequired) {
                String key = "antlr.error.parser.grammar.can.only.contain.parser.rule.declaration";

                String displayName = "a parser grammar can only contain parser rule declaration";
                String description = displayName + "\n" +
                                 "rule " + lexerRuleId + " is a lexer rule";
                File file = new File(parsedFileName);
                FileObject fo = FileUtil.toFileObject(file);
                ParsingError semanticError = new ParsingError
                                (fo            ,
                                 Severity.ERROR,
                                 key           ,
                                 index         ,
                                 displayName   ,
                                 description   );
                semanticErrors.add(semanticError);
            }
        } else {
            if (!ruleDeclarations.contains(lexerRuleId)) {
                ruleDeclarations.add(lexerRuleId);
                
                Path parsedFilePath = Paths.get(parsedFileName);
                RuleDeclaration rd = new RuleDeclaration
                                      (parsedFilePath, lexerRuleId, index);
                tokenRuleDeclarations.put(lexerRuleId, rd);
            }
        }
    }
    
    
    @Override
    public void exitModeSpec(ModeSpecContext ctx) {
        if (grammarType != GrammarType.LEXER &&
            semanticErrorRequired              ) {
            String key = "antlr.warning.mode.only.lexer.grammar.can.contain.mode.specifications";
            int index = ctx.MODE().getSymbol().getStartIndex();
            String displayName = "Only lexer grammar can contain mode specifications";
            String description = displayName;
            File file = new File(parsedFileName);
            FileObject fo = FileUtil.toFileObject(file);
            ParsingError semanticError = new ParsingError
                                (fo            ,
                                 Severity.ERROR,
                                 key           ,
                                 index         ,
                                 displayName   ,
                                 description   );
            semanticErrors.add(semanticError);
        }
    }
    
    
  /**
   * We check that each parser reference used has a correspondent parser rule
   * definition.
   * 
   * For doing that we must wait that all grammar source file has been 
   * semantically parsed (the parser rule declaration can be located before 
   * the parser rule declaration where the parser rule reference appears or
   * after or even it can refer to the parser rule where the parser rule 
   * refernece appears).
   */
    public void checkRuleReferences() {
        Set<String> ruleIds = ruleReferences.keySet();
        Iterator<String> it = ruleIds.iterator();
        String ruleId;
        while (it.hasNext()) {
            ruleId = it.next();
            if (!ruleDeclarations.contains(ruleId)) {
                if (semanticErrorRequired) {
                 // If the rule reference surely references a lexer rule (or token rule)
                 // then a simple warning if it is not found (from a rule or in tokens
                 // declaration)
                    if (Character.isUpperCase(ruleId.charAt(0))) {
                        String key = "antlr.warning.parserRule.implicit.definition.of.token";
                        int index = ruleReferences.get(ruleId).getRuleReferenceIndex();
                        String displayName = "implicit definition of token " + ruleId;
                        String description = displayName;
                        File file = new File(parsedFileName);
                        FileObject fo = FileUtil.toFileObject(file);
                        ParsingError semanticWarning = new ParsingError
                                (fo              ,
                                 Severity.WARNING,
                                 key             ,
                                 index           ,
                                 displayName     ,
                                 description     );
                        semanticErrors.add(semanticWarning);
                    } else {
                        String key = "antlr.warning.parserRule.rule.reference.has.no.correspondent.declaration";
                        int index = ruleReferences.get(ruleId).getRuleReferenceIndex();
                        String displayName = "The rule reference " + ruleId +
                                        " has no correspondent declaration";
                        String description = displayName;
                        File file = new File(parsedFileName);
                        FileObject fo = FileUtil.toFileObject(file);
                        ParsingError semanticError = new ParsingError
                                (fo            ,
                                 Severity.ERROR,
                                 key           ,
                                 index         ,
                                 displayName   ,
                                 description   );
                        semanticErrors.add(semanticError);
                    }
                }
            }
        }
    }
    
    
    public void checkParserRuleDeclarations() {
        Set<String> parserRuleIds = parserRuleDeclarations.keySet();
        Iterator<String> it = parserRuleIds.iterator();
        String ruleId;
        while (it.hasNext()) {
            ruleId = it.next();
            if (!ruleReferences.containsKey(ruleId)        &&
                !ruleId.equals(firstParserRuleDeclaration) &&
                semanticErrorRequired                        ) {
                String key = "antlr.warning.parserRule.declaration.used.nowhere";
                RuleDeclaration rd = parserRuleDeclarations.get(ruleId);
                Path originFilePath = rd.getFilePath();
                Path grammarFilePath = Paths.get(parsedFileName);
                int offset;
             // If the origin of the parser rule is local xe mark the warning on
             // the parser rule statement...
             // ...else it is extern and then we mark the warning on the import
             // statement having loaded the parser rule
                if (originFilePath.equals(grammarFilePath)) {
                    offset = rd.getRuleOffset();
                } else {
                    offset = importStatements.get(originFilePath);
                }
                String displayName = "The rule declaration " + ruleId +
                                     " is used nowhere";
                String description = displayName;
                File file = new File(parsedFileName);
                FileObject fo = FileUtil.toFileObject(file);
                ParsingError semanticWarning = new ParsingError
                                (fo              ,
                                 Severity.WARNING,
                                 key             ,
                                 offset          ,
                                 displayName     ,
                                 description     );
                semanticErrors.add(semanticWarning);
           }
       }
    }
    
    private GrammarType parseGrammarFile(String grammarFileName, int offset) {
//        System.out.println("ANTLRv4SemanticParser : grammarFileName=" +
//                           grammarFileName);
        GrammarType answer;
     // We does not need to generate hyperlinks for that imported grammar file
     // Its hyperlinks will be generated when user will open it (if he does it)
        ANTLRv4GrammarChecker agc = new ANTLRv4GrammarChecker(null);
        try (
            InputStream is = new FileInputStream(grammarFileName);
        ) {
            int c;
            StringBuilder content = new StringBuilder();
            while((c = is.read()) != -1)
                content.append((char) c);
            agc.check(content.toString(), grammarFileName);

         // We recover the rules declared in the parsed file
         // (usefull only in case of recursive grammar file parsing, e.g. import)
            ruleDeclarations.addAll(agc.getRuleDeclarations());
            parserRuleDeclarations.putAll(agc.getParserRuleDeclarations());
            tokenRuleDeclarations.putAll(agc.getTokenRuleDeclarations());
            ruleReferences.putAll(agc.getRuleReferences());
         // If there is syntactic or semantic errors in imported grammar
         // then we generate an error on associated import statement
         // or error will refere to their associated import statement)
            if (agc.encounteredSyntacticError()   ||
                agc.getSemanticErrorNumber() != 0 &&
                semanticErrorRequired               ) {
                String key = "antlr.error.import.grammar.contains.errors";
                String displayName = "The imported grammar in " + grammarFileName +
                                     " contains semantic errors";
                String description = displayName;
                File file = new File(parsedFileName);
                FileObject fo = FileUtil.toFileObject(file);
                ParsingError semanticError = new ParsingError
                                (fo            ,
                                 Severity.ERROR,
                                 key           ,
                                 offset        ,
                                 displayName   ,
                                 description   );
                semanticErrors.add(semanticError);
            }
/*
            Map<String, RuleDeclaration> importedParserRules =
                                                agc.getParserRuleDeclarations();
            Set<String> importedRuleIds = importedParserRules.keySet();
            Iterator<String> it = importedRuleIds.iterator();
            String ruleId;
            RuleDeclaration rd;
            while (it.hasNext()) {
                ruleId = it.next();
                rd = importedParserRules.get(ruleId);
                rd.setRuleOffset(offset);
            }
*/
         // we recover the first rule found in the imported grammar
         // (It will only be usefull if the current grammar is a combined one)
            firstImportedParserRule = agc.getFirstParserRule();
            answer = agc.getGrammarType();
        } catch (FileNotFoundException ex) {
            answer = GrammarType.UNDEFINED;
            LOG.severe("Unable to find the file " + grammarFileName);
        } catch (IOException ex) {
            answer = GrammarType.UNDEFINED;
            LOG.severe("Strange! Unable to close the file " + grammarFileName);
        } catch (RecognitionException ex) {
            answer = GrammarType.UNDEFINED;
            LOG.severe(ex.toString());
        }
        return answer;
    }
    
    public void checkThereIsAtLeastARule() {
        if (ruleDeclarations.isEmpty() &&
            semanticErrorRequired        ) {
            String key = "antlr.error.semantic.global";
            int index = grammarDeclaration.getIndex();
            String displayName = "A grammar file must have at least one rule";
            String description = "A lexer grammar file must have at least one" +
                                 "token declaration rule\n" +
                                 "A parser grammar file must have at least one"+
                                 " parser rule\n" +
                                 "a combined grammar file must have at least" +
                                 "one perser rule and one lexer rule (defined" +
                                 " in the dile or imported)";
            File file = new File(parsedFileName);
            FileObject fo = FileUtil.toFileObject(file);
            ParsingError semanticError = new ParsingError
                        (fo            ,
                         Severity.ERROR,
                         key           ,
                         index         ,
                         displayName   ,
                         description   );
            semanticErrors.add(semanticError);
        }
    }
    
    
    private List<String> recoverTokensFrom(String tokenSourceId, int index) {
        List<String> recoveredTokens = new ArrayList<>();;
        StringBuilder tokenFileName = new StringBuilder();
        tokenFileName.append(tokenSourceId);
        tokenFileName.append(".tokens");
        switch (projectType) {
            case ANT_BASED: {
                Path propertyFilePath = Paths.get(projectDirectory    ,
                                                  "nbproject"         ,
                                                  "project.properties");
                File propertiesFile = propertyFilePath.toFile();
                PropertyProvider propertyProvider = PropertyUtils.
                                 propertiesFilePropertyProvider(propertiesFile);
                PropertyEvaluator propertyEvaluator = PropertyUtils.
                            sequentialPropertyEvaluator(null, propertyProvider);
             // We recover the property giving the location of .tokens file that
             // is the destination directory of ANTLR generator
                String destDir = propertyEvaluator.getProperty
                                                   ("antlr.generator.dest.dir");
             // We extract the subdir of parsed file
                String srcDir = propertyEvaluator.getProperty
                                                    ("antlr.generator.src.dir");
                Path srcDirPath = Paths.get(projectDirectory, srcDir);
                Path absoluteGrammarDirectoryPath = Paths.get(parsedGrammarDirectory);
                Path relativeGrammarDirectoryPath = srcDirPath.relativize(absoluteGrammarDirectoryPath);
/*
                System.out.println("ANTLRv4SemanticParser.recoverTokensFrom() : parsedFileName=" + parsedFileName);
                System.out.println("ANTLRv4SemanticParser.recoverTokensFrom() : parsedGrammarDirectory=" + parsedGrammarDirectory);
                System.out.println("ANTLRv4SemanticParser.recoverTokensFrom() : srcDir=" + srcDir);
                System.out.println("ANTLRv4SemanticParser.recoverTokensFrom() : grammarName=" + grammarName);
                System.out.println("ANTLRv4SemanticParser.recoverTokensFrom() : relativeGrammarDirectory=" + relativeGrammarDirectoryPath);
*/
                
                String relativeGrammarDirectory = relativeGrammarDirectoryPath.toString();
                Path tokenSourceFilePath;
                if (relativeGrammarDirectory.equals(""))
                   tokenSourceFilePath = Paths.get(projectDirectory        ,
                                                   destDir                 ,
                                                   tokenFileName.toString());
                else
                   tokenSourceFilePath = Paths.get(projectDirectory        ,
                                                   destDir                 ,
                                                   relativeGrammarDirectory,
                                                   tokenFileName.toString());
//                System.out.println("ANTLRv4SemanticParser.recoverTokensFrom() : tokenSourceFilePath=" + tokenSourceFilePath);
                File tokenSourceFile = tokenSourceFilePath.toFile();
                if (tokenSourceFile.exists()) {
                    recoveredTokens = parseTokenFile(tokenSourceFilePath);
                } else {
//                    System.out.println("ANTLRv4SemanticParser.recoverTokensFrom() : token Source File not found in that path");
                 // We didn't find the file but it may be in antlr.generator.import.dir
                 // directory so we look for it in that directory
                    String importDir = propertyEvaluator.getProperty
                                                 ("antlr.generator.import.dir");
                    if (importDir != null) {
                        importDir = importDir.trim();
                        if (importDir.equals("")) {
                            if (semanticErrorRequired) {
                             // There is no import directory defined so we can 
                             // conclude that the tokens file doesn't exist
                                String key = "antlr.error.semantic.options" +
                                        ".tokenVocab.unable.to.find.token.file";
                                String displayName = "No token file named " + 
                                        tokenSourceId + ".tokens has been " +
                                        "found in destination directory " +
                                        destDir;
                                String description = displayName;
                                File file = new File(parsedFileName);
                                FileObject fo = FileUtil.toFileObject(file);
                                ParsingError semanticError =
                                        new ParsingError
                                            (fo            ,
                                             Severity.ERROR,
                                             key           ,
                                             index         ,
                                             displayName   ,
                                             description   );
                                semanticErrors.add(semanticError);
                            }
                        } else {
                            tokenSourceFilePath = Paths.get
                                                     (projectDirectory        ,
                                                      importDir               ,
                                                      tokenFileName.toString());
                            tokenSourceFile = tokenSourceFilePath.toFile();
                            if (tokenSourceFile.exists()) {
                                recoveredTokens = parseTokenFile(tokenSourceFilePath);
                            } else {
                                if (semanticErrorRequired) {
                                 // We didn't find the file so there is an error
                                    String key = "antlr.error.semantic.options" +
                                        ".tokenVocab.unable.to.find.token.file";
                                    String displayName = "No token file named " + 
                                        tokenSourceId + ".tokens has been " +
                                        "found in destination directory " +
                                        destDir + " or in import directory " +
                                        importDir;
                                    String description = displayName;
                                    File file = new File(parsedFileName);
                                    FileObject fo = FileUtil.toFileObject(file);
                                    ParsingError semanticError =
                                        new ParsingError
                                            (fo            ,
                                             Severity.ERROR,
                                             key           ,
                                             index         ,
                                             displayName   ,
                                             description   );
                                    semanticErrors.add(semanticError);
                                }
                            }
                        }
                    }
                }
                break;
            }
            case MAVEN_BASED: {
                Path srcDirPath = Paths.get(projectDirectory, "src/main/antlr4");
                Path absoluteGrammarDirectoryPath = Paths.get(parsedGrammarDirectory);
                Path relativeGrammarDirectoryPath = srcDirPath.relativize(absoluteGrammarDirectoryPath);
//                System.out.println("ANTLRv4SemanticParser.recoverTokensFrom() : relativeGrammarDirectory=" + relativeGrammarDirectoryPath);
                String relativeGrammarDirectory = relativeGrammarDirectoryPath.toString();
                Path tokenSourceFilePath;
                if (relativeGrammarDirectory.equals(""))
                    tokenSourceFilePath = Paths.get
                                            (projectDirectory                 ,
                                             "target/generated-sources/antlr4",
                                             tokenFileName.toString()         );
                else
                    tokenSourceFilePath = Paths.get
                                            (projectDirectory                 ,
                                             "target/generated-sources/antlr4",
                                             relativeGrammarDirectory         ,
                                             tokenFileName.toString()         );
                File tokenSourceFile = tokenSourceFilePath.toFile();
                if (tokenSourceFile.exists()) {
                    recoveredTokens = parseTokenFile(tokenSourceFilePath);
                } else {
                 // We didn't find the file but it may be in src/main/antlr4/imports
                 // directory so we look for it in that directory
                    tokenSourceFilePath = Paths.get(projectDirectory         ,
                                                    "src/main/antlr4/imports",
                                                    tokenFileName.toString() );
                    tokenSourceFile = tokenSourceFilePath.toFile();
                    if (tokenSourceFile.exists()) {
                        recoveredTokens = parseTokenFile(tokenSourceFilePath);
                    } else {
                        if (semanticErrorRequired) {
                            String key = "antlr.error.semantic.options.tokenVocab" +
                                ".unable.to.find.token.file";
                            String displayName = "No token file named " + 
                                tokenSourceId + ".tokens" +
                                " has been found in destination directory " +
                                "target/generated-sources/antlr4 or import " +
                                "directory src/main/antlr4/imports";
                            String description = displayName;
                            File file = new File(parsedFileName);
                            FileObject fo = FileUtil.toFileObject(file);
                            ParsingError semanticError = new ParsingError
                                (fo            ,
                                 Severity.ERROR,
                                 key           ,
                                 index         ,
                                 displayName   ,
                                 description   );
                            semanticErrors.add(semanticError);
                        }
                    }
                }
                break;
            }
            default:
        }
        return recoveredTokens;
    }
    
    
    private static final String TOKEN_PATTERN_STRING=
            "(" +
                "'[^']+'" + // a single quote string : ' + any char except ' + '
                "|" +
                "[" + 
                    "A-Z" +
                    "\\u00C0-\\u00D6" +
                    "\\u00D8-\\u00F6" +
                    "\\u00F8-\\u02FF" +
                    "\\u0370-\\u037D" +
                    "\\u037F-\\u1FFF" +
                    "\\u200C-\\u200D" +
                    "\\u2070-\\u218F" +
                    "\\u2C00-\\u2FEF" +
                    "\\u3001-\\uD7FF" +
                    "\\uF900-\\uFDCF" +
                    "\\uFDF0-\\uFFFD" +
                "]" +
                "[" +
                    "a-z" +
                    "A-Z" +
                    "0-9" +
                    "_" +
                    "\\u00C0-\\u00D6" +
                    "\\u00D8-\\u00F6" +
                    "\\u00F8-\\u02FF" +
                    "\\u0370-\\u037D" +
                    "\\u037F-\\u1FFF" +
                    "\\u200C-\\u200D" +
                    "\\u2070-\\u218F" +
                    "\\u2C00-\\u2FEF" +
                    "\\u3001-\\uD7FF" +
                    "\\uF900-\\uFDCF" +
                    "\\uFDF0-\\uFFFD" +
                    "\\u00B7" + // middle dot character
                    "\\u0300-\\u036F" + // COMBINING GRAVE to COMBINING LATIN SMALL LETTER X
                    "\\u203F-\\u2040" +
                "]*" + 
            ")"+
            "=";
    private static final Pattern TOKEN_PATTERN = Pattern.compile(TOKEN_PATTERN_STRING);
    
    private List<String> parseTokenFile(Path tokenSourceFilePath) {
        List<String> answer = new ArrayList<>();
        try {
            final List<String> tokenDefs = Files.readAllLines
                                  (tokenSourceFilePath, StandardCharsets.UTF_8);
            int lineLength, offset = 0;
            for (String tokenDef : tokenDefs) {
                lineLength = tokenDef.length();
                Matcher m = TOKEN_PATTERN.matcher(tokenDef);
                if (m.find()) {
                 // group(0) is the global group
                 // group(1) is the string before equal sign
                    String tokenName = m.group(1);
//                    System.out.println("ANTLRv4SemanticParser : tokenName=" + tokenName + " offset=" + offset);
                    ruleDeclarations.add(tokenName);
                    RuleDeclaration rd = new RuleDeclaration
                                                (tokenSourceFilePath,
                                                 tokenName          ,
                                                 offset             );
                    tokenRuleDeclarations.put(tokenName, rd);
                }
                offset += lineLength + 1; // There is a \n at the end of each line
            }
        } catch (IOException ex) {
            LOG.severe("Unable to read token file: " + tokenSourceFilePath.toString());
            LOG.severe(ex.getMessage());
        }
        
        return answer;
    }
    
    
    private Project getProject(Path absoluteFilePath) {
        File grammarFile = absoluteFilePath.toFile();
//        System.out.println("absolute File Path=" + absoluteFilePath);
        FileObject fileObject = FileUtil.toFileObject(grammarFile);
        Project l_project;
        if (fileObject != null)
            l_project = FileOwnerQuery.getOwner(fileObject);
        else
            l_project = null;
        return l_project;
    }
    
    
    private ProjectType getProjectType(Project project) {
        ProjectType l_projectType = ProjectType.UNDEFINED;
        if (project != null) {
            Lookup projectLookup = project.getLookup();
            AntBuildExtender antBuildExtender =
                                   projectLookup.lookup(AntBuildExtender.class);
         // If an AntBuildExtender has been found then the project is an 
         // ant-based one
            if (antBuildExtender != null)
                l_projectType = ProjectType.ANT_BASED;
            else {
                NbMavenProject nBMavenProject =
                                     projectLookup.lookup(NbMavenProject.class);
                if (nBMavenProject != null)
                    l_projectType = ProjectType.MAVEN_BASED;
            }
        }
        return l_projectType;
    }
}