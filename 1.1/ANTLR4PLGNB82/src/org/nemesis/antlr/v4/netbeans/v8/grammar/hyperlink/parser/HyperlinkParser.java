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
package org.nemesis.antlr.v4.netbeans.v8.grammar.hyperlink.parser;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.text.Document;

import org.antlr.v4.runtime.Token;

import org.nemesis.antlr.v4.netbeans.v8.grammar.hyperlink.Hyperlink;
import org.nemesis.antlr.v4.netbeans.v8.grammar.hyperlink.HyperlinkCategory;
import org.nemesis.antlr.v4.netbeans.v8.grammar.hyperlink.Hyperlinks;

import org.nemesis.antlr.v4.netbeans.v8.grammar.semantic.checking.error.RuleDeclaration;

import org.nemesis.antlr.v4.netbeans.v8.grammar.syntax.checking.impl.ANTLRv4BaseListener;
import org.nemesis.antlr.v4.netbeans.v8.grammar.syntax.checking.impl.ANTLRv4Parser;
import org.nemesis.antlr.v4.netbeans.v8.grammar.syntax.checking.impl.ANTLRv4Parser.ClassIdentifierContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.syntax.checking.impl.ANTLRv4Parser.DelegateGrammarContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.syntax.checking.impl.ANTLRv4Parser.IdentifierContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.syntax.checking.impl.ANTLRv4Parser.ParserRuleIdentifierContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.syntax.checking.impl.ANTLRv4Parser.ParserRuleReferenceContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.syntax.checking.impl.ANTLRv4Parser.SuperClassSpecContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.syntax.checking.impl.ANTLRv4Parser.TerminalContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.syntax.checking.impl.ANTLRv4Parser.TokenIdentifierContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.syntax.checking.impl.ANTLRv4Parser.TokenLabelTypeSpecContext;
import org.nemesis.antlr.v4.netbeans.v8.grammar.syntax.checking.impl.ANTLRv4Parser.TokenVocabSpecContext;

import org.nemesis.antlr.v4.netbeans.v8.project.ProjectType;

import org.netbeans.api.project.FileOwnerQuery;
import org.netbeans.api.project.Project;

import org.netbeans.api.project.ant.AntBuildExtender;

import org.netbeans.modules.editor.NbEditorUtilities;

import org.netbeans.modules.maven.api.NbMavenProject;

import org.netbeans.spi.project.support.ant.PropertyEvaluator;
import org.netbeans.spi.project.support.ant.PropertyProvider;
import org.netbeans.spi.project.support.ant.PropertyUtils;

import org.openide.filesystems.FileObject;

import org.openide.loaders.DataObject;

import org.openide.util.Lookup;

/**
 *
 * @author Frédéric Yvon Vinet
 */
public class HyperlinkParser extends ANTLRv4BaseListener {
    private final Document    doc;
    private final FileObject  docFO;
    private final Hyperlinks  links;
    
    private final Project     project;
    private final ProjectType projectType;
    private final String      projectDirectoryPathName;
    
    private final String            packageName;
    private final ArrayList<String> javaImports;
    private final Map<String, RuleDeclaration> parserRuleDeclarations;
    private final Map<String, RuleDeclaration> tokenRuleDeclarations;
    
    
    public HyperlinkParser
            (Document                     doc                   ,
             String                       packageName           ,
             ArrayList<String>            javaImports           ,
             Map<String, RuleDeclaration> parserRuleDeclarations,
             Map<String, RuleDeclaration> tokenRuleDeclarations ) {
        this.doc = doc;
        assert null != doc;
        this.links = new Hyperlinks();
     // If doc has a previous hyperlinks then it is overwritten
        this.doc.putProperty(Hyperlinks.class, links);
     // We recover the FileObject of the current document
        this.docFO = getFileObject(doc);
        
     // We will need to know in which project we are for being able to determine
     // the project type (ant-based or Maven-based)
        this.project = getProject(doc);
        this.projectType = getProjectType(project);
        FileObject projectDirFO = project.getProjectDirectory();
        this.projectDirectoryPathName = projectDirFO.getPath();
        this.packageName = packageName;
        this.javaImports = javaImports;
        this.parserRuleDeclarations = parserRuleDeclarations;
        this.tokenRuleDeclarations = tokenRuleDeclarations;
    }
    
    
 /**
  * Called at the end of an import statement.
  * 
  * @param ctx 
  */
    @Override
    public void exitDelegateGrammar(DelegateGrammarContext ctx) {
        IdentifierContext ic = ctx.grammarIdentifier().identifier();

        Token token = ic.ID().getSymbol();
        int start = token.getStartIndex();
        int end   = token.getStopIndex() + 1;
        String targetWord = token.getText();
        
        String importedGrammarName = ic.getText();
        StringBuilder importedGrammarFileName = new StringBuilder();
        importedGrammarFileName.append(importedGrammarName);
        importedGrammarFileName.append(".g4");
        
     // We recover the directory of the current document
        FileObject docDirFO = docFO.getParent();
        String docAbsoluteDir = docDirFO.getPath();
        
     // We recover the file we want to open in: 
     // - the same directory as current grammar file or in 
     //   antlr.generator.import.dir directory if it is an ant-based project,
     // - the same directory as current grammar file or in 
     //   src/main/antlr4/imports directory if it is a Maven-Based project.
     
     // Step 1: We recover the file in the same directory as current grammar
     // file
        Path importedGrammarFilePath = Paths.get
                                           (docAbsoluteDir                    ,
                                            importedGrammarFileName.toString());
        File importedGrammarFile = importedGrammarFilePath.toFile();
 
        Hyperlink link = new Hyperlink(start                    ,
                                       end                      , 
                                       HyperlinkCategory.GRAMMAR,
                                       importedGrammarFile      ,
                                       targetWord               ,
                                       0                        );
        links.addLink(link);
        
     // Step 2: depends of project type
        Path importedGrammarPath = null;
        switch (projectType) {
            case ANT_BASED:
             // The file may be also in the directory defined by
             // antlr.generator.import.dir ant property
             // So we need to recover that project property
                String importDir = getAntProjectProperty
                                                 ("antlr.generator.import.dir");
             // If importDir is null (property not defined) then there is no
             // more possibility
                if (importDir != null) {
                 // The property is defined but may be empty or full of space
                 // characters
                    importDir = importDir.trim();
                 // If it is empty it is as if it was not defined so there is no 
                 // more possibility.
                 // But if it is not empty then it remains a possibility
                    if (!importDir.equals("")) {
                        importedGrammarPath = Paths.get
                                           (projectDirectoryPathName          ,
                                            importDir                         ,
                                            importedGrammarFileName.toString());
                    }
                }
                break;
            case MAVEN_BASED:
                importedGrammarPath = Paths.get
                                           (projectDirectoryPathName          ,
                                            "src/main/antlr4/imports"         ,
                                            importedGrammarFileName.toString());
                break;
            default:
                
        }
        
        if (importedGrammarPath != null) {
            importedGrammarFile = importedGrammarPath.toFile();
            link = new Hyperlink(start                    ,
                                 end                      , 
                                 HyperlinkCategory.GRAMMAR,
                                 importedGrammarFile      ,
                                 targetWord               ,
                                 0                        );
            links.addLink(link);
        }
    }
    
    
 /**
  * Called at the end of a superClass option declaration
  * @param ctx 
  */
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
        String targetWord = fullQualifiedSuperClass.substring(start + 1);
        String superClassPackage;
        if (start == -1)
            superClassPackage = "";
        else
            superClassPackage = fullQualifiedSuperClass.substring(0, start);

//        System.out.println("HyperlinkParser : targetWord=" + targetWord);
//        System.out.println("HyperlinkParser : packageName=" + superClassPackageName);
        
     // There is a link to fullQualifiedSuperClass transformed in directory
        String superClassFilePathString = fullQualifiedSuperClass.replace
                                                                     (".", "/");
        superClassFilePathString = superClassFilePathString + ".java";
//        System.out.println("HyperlinkParser : superClassFilePathString 1=" + superClassFilePathString);
        
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
        if (srcDir != null) {
            Path superClassPath = Paths.get(projectDirectoryPathName ,
                                            srcDir                   ,
                                            superClassFilePathString );
         // We add the hyperlink
            File superClassFile = superClassPath.toFile();
            Hyperlink link = new Hyperlink(targetStart           ,
                                           targetEnd             ,
                                           HyperlinkCategory.JAVA,
                                           superClassFile        ,
                                           targetWord            ,
                                           0                     );
            links.addLink(link);

         // If no package has been specified, it is also possible that package
         // is defined in a Java import statement. If it is the case, then this
         // declaration nullify the previous one.
            if ("".equals(superClassPackage)) {
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
//                    System.out.println("HyperlinkParser : importedClassName=" + importedClassName);
//                    System.out.println("HyperlinkParser : targetWord=" + targetWord);
                    if (importedClassName.equals(targetWord)) {
                        found = true;
                        superClassFilePathString = fullQualifiedImportedClassName
                                                        .replace(".", "/");
                        superClassFilePathString = superClassFilePathString + ".java";
//                        System.out.println("HyperlinkParser : superClassFilePathString 2=" + superClassFilePathString);
                        superClassPath = Paths.get(projectDirectoryPathName,
                                                   srcDir                  ,
                                                   superClassFilePathString);
                     // We add the hyperlink
                        superClassFile = superClassPath.toFile();
                     // A package has been found so there is no doubt the only
                     // possible link is the next qualified link so we remove
                     // the previous link
                        links.removeLink(link);
                        link = new Hyperlink(targetStart           ,
                                             targetEnd             ,
                                             HyperlinkCategory.JAVA,
                                             superClassFile        ,
                                             targetWord            ,
                                             0                     );
                        links.addLink(link);
                    }
                }
            }
        }
    }
    
    
 /**
  * Called at the end of a tokenVocab option declaration
  * @param ctx 
  */
    @Override
    public void exitTokenVocabSpec(TokenVocabSpecContext ctx) {
        ANTLRv4Parser.IdentifierContext ic = ctx.identifier();
        Token token = ic.ID().getSymbol();
        int targetStart = token.getStartIndex();
        int targetEnd   = token.getStopIndex() + 1;
        String targetWord = token.getText();
        String tokenFileName = targetWord + ".tokens";
     // There are two places where the token file may be:
     // - for ant-based projects:
     //   * in antlr.generator.dest.dir directory concatenated with package name
     //     transformed in directory structure (may be specified as 
     //     antlr.generator.option.code.package or with a Java package statement
     //     in @header declaration in current grammar file)
     //   * in antlr.generator.import.dir directory
     // - for Maven-based projects:
     //   * in target/generated-sources/antlr4 directory concatenated with 
     //     package name transformed in directory structure
     //   * in src/main/antlr4/imports directory
        String srcDir, packageDir;
        switch (projectType) {
            case ANT_BASED:
                srcDir = getAntProjectProperty("antlr.generator.dest.dir");
                if (packageName == null) {
                    packageDir = getAntProjectProperty("antlr.generator.option.code.package");
                    if (packageDir == null)
                        packageDir = "";
                    else
                        packageDir = packageDir.trim();
                } else
                    packageDir = packageName;
                packageDir = packageDir.replace(".", "/");
                break;
            case MAVEN_BASED:
                srcDir = "target/generated-sources/antlr4";
                if (packageName == null)
                    packageDir = "";
                else
                    packageDir = packageName;
                break;
            default:
                srcDir = null;
                packageDir = null;
        }
        if (srcDir != null) {
            Path tokenFilePath = Paths.get(projectDirectoryPathName,
                                           srcDir                  ,
                                           packageDir              ,
                                           tokenFileName           );
         // We add the hyperlink
            File tokenClassFile = tokenFilePath.toFile();
            Hyperlink link = new Hyperlink(targetStart             ,
                                           targetEnd               ,
                                           HyperlinkCategory.TOKENS,
                                           tokenClassFile          ,
                                           targetWord              ,
                                           0                       );
            links.addLink(link);
        }
        
        switch (projectType) {
            case ANT_BASED:
                srcDir = getAntProjectProperty("antlr.generator.import.dir");
                break;
            case MAVEN_BASED:
                srcDir = "src/main/antlr4/imports";
                break;
            default:
        }
        if (srcDir != null) {
            Path tokenFilePath = Paths.get(projectDirectoryPathName,
                                           srcDir                  ,
                                           tokenFileName           );
         // We add the hyperlink
            File tokenClassFile = tokenFilePath.toFile();
            Hyperlink link = new Hyperlink(targetStart             ,
                                           targetEnd               ,
                                           HyperlinkCategory.TOKENS,
                                           tokenClassFile          ,
                                           targetWord              ,
                                           0                       );
            links.addLink(link);
        }
    }
    
    
 /**
  * Called at the end of a TokenLabelType option declaration.
  * @param ctx
  */
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
        String targetWord = fullQualifiedTokenClass.substring(start + 1);
        String tokenClassPackage;
        if (start == -1)
            tokenClassPackage = "";
        else
            tokenClassPackage = fullQualifiedTokenClass.substring(0, start);

//        System.out.println("HyperlinkParser : targetWord=" + targetWord);
//        System.out.println("HyperlinkParser : packageName=" + superClassPackageName);
        
     // There is a link to fullQualifiedTokenClass transformed in directory
        String tokenClassFilePathString = fullQualifiedTokenClass.replace
                                                                     (".", "/");
        tokenClassFilePathString = tokenClassFilePathString + ".java";
//        System.out.println("HyperlinkParser : tokenClassFilePathString 1=" + tokenClassFilePathString);
        
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
        if (srcDir != null) {
            Path superClassPath = Paths.get(projectDirectoryPathName ,
                                            srcDir                   ,
                                            tokenClassFilePathString );
         // We add the hyperlink
            File superClassFile = superClassPath.toFile();
            Hyperlink link = new Hyperlink(targetStart           ,
                                           targetEnd             ,
                                           HyperlinkCategory.JAVA,
                                           superClassFile        ,
                                           targetWord            ,
                                           0                     );
            links.addLink(link);

         // If no package has been specified, it is also possible that package
         // is defined in a Java import statement
            if ("".equals(tokenClassPackage)) {
                Iterator<String> it2 = javaImports.iterator();
                String fullQualifiedImportedTokenClass;
                String importedTokenClass;
                boolean found = false;
                while (it2.hasNext() && !found) {
                    fullQualifiedImportedTokenClass = it2.next();
                    start = fullQualifiedImportedTokenClass.lastIndexOf(".");
                    importedTokenClass = fullQualifiedImportedTokenClass.substring(start + 1);

//                    System.out.println("HyperlinkParser : importedClassName=" + importedClassName);
//                    System.out.println("HyperlinkParser : targetWord=" + targetWord);
                    if (importedTokenClass.equals(targetWord)) {
                        found = true;
                        tokenClassFilePathString = fullQualifiedImportedTokenClass
                                                             .replace(".", "/");
                        tokenClassFilePathString = tokenClassFilePathString + ".java";
//                        System.out.println("HyperlinkParser : tokenClassFilePathString 2=" + tokenClassFilePathString);
                        superClassPath = Paths.get(projectDirectoryPathName,
                                                   srcDir                  ,
                                                   tokenClassFilePathString);
                     // We add the hyperlink
                        superClassFile = superClassPath.toFile();
                     // A package has been found so there is no doubt the only
                     // possible link is the next qualified link so we remove
                     // the previous link
                        links.removeLink(link);
                        link = new Hyperlink(targetStart           ,
                                             targetEnd             ,
                                             HyperlinkCategory.JAVA,
                                             superClassFile        ,
                                             targetWord            ,
                                             0                     );
                        links.addLink(link);
                    }
                }
            }
        }
    }

    
 /**
  * Called at the end of a parser rule reference use
  * @param ctx 
  */
    @Override
    public void exitParserRuleReference(ParserRuleReferenceContext ctx) {
        ParserRuleIdentifierContext pric = ctx.parserRuleIdentifier();
        Token id = pric.ID_STARTING_WITH_LOWERCASE().getSymbol();
        int linkStart = id.getStartIndex();
        int linkEnd   = id.getStopIndex() + 1;
        String targetWord = id.getText();
        RuleDeclaration rd = parserRuleDeclarations.get(targetWord);
        if (rd != null) {
            Path targetFilePath = rd.getFilePath();
            int targetOffset = rd.getRuleOffset();
/*
            System.out.println("- HyperlinkParser::exitParserRuleReference : "+
                               "filePath=" + targetFilePath +
                               " offset=" + targetOffset +
                               " rule ID=" + rd.getRuleID());
*/
            Hyperlink link = new Hyperlink(linkStart                 ,
                                           linkEnd                   ,
                                           HyperlinkCategory.RULE_REF,
                                           targetFilePath.toFile()   ,
                                           targetWord                ,
                                           targetOffset              );
            links.addLink(link);
        }
    }
    
    
 /**
  * Called at the end of a terminal (token) reference use (in a parser rule or
  * in a lexer rule).
  * 
  * @param ctx 
  */
    @Override
    public void exitTerminal(TerminalContext ctx) {
        TokenIdentifierContext tic = ctx.tokenIdentifier();
        if (tic != null) {
            Token id = tic.ID_STARTING_WITH_UPPERCASE().getSymbol();
            int tokenStart = id.getStartIndex();
            int tokenEnd   = id.getStopIndex() + 1;
            String targetWord = id.getText();
//            System.out.println("HyperlinkParser : token reference encountered: " + targetWord);
            RuleDeclaration rd = tokenRuleDeclarations.get(targetWord);
            if (rd != null) {
                Path filePath = rd.getFilePath();
                int targetOffset = rd.getRuleOffset();
//                System.out.println("- HyperlinkParser: filePath=" + filePath + " index=" + targetOffset);
                Hyperlink link = new Hyperlink(tokenStart                ,
                                               tokenEnd                  ,
                                               HyperlinkCategory.RULE_REF,
                                               filePath.toFile()         ,
                                               targetWord                ,
                                               targetOffset              );
                links.addLink(link);
            }
        }
    }
    
    
    private Project getProject(Document doc) {
        Project l_project = null;
        DataObject docDataObj = NbEditorUtilities.getDataObject(doc);
        if (docDataObj != null)
            l_project = FileOwnerQuery.getOwner(docDataObj.getPrimaryFile());
        return l_project;
    }
    
    
    private ProjectType getProjectType(Project project) {
        ProjectType projectType = ProjectType.UNDEFINED;
        Lookup projectLookup = project.getLookup();
        AntBuildExtender antBuildExtender =
                                   projectLookup.lookup(AntBuildExtender.class);
        
     // If an AntBuildExtender has been found then the project is an ant-based
     // one
        if (antBuildExtender != null)
            projectType = ProjectType.ANT_BASED;
        else {
            NbMavenProject nBMavenProject =
                                     projectLookup.lookup(NbMavenProject.class);
            if (nBMavenProject != null) {
                projectType = ProjectType.MAVEN_BASED;
            }
        }
        
        return projectType;
    }
    
    
 /**
  * Returns the FileObject associated to the document passed as parameter.
  * @param doc
  * @return 
  */
    private FileObject getFileObject(Document doc) {
        FileObject answer;
        DataObject docDataObj = NbEditorUtilities.getDataObject(doc);
        if (docDataObj != null) {
            answer = docDataObj.getPrimaryFile();
        } else
            answer = null;
        return answer;
    }
    
    
    private String getAntProjectProperty(String propertyName) {
        Path propertyFilePath = Paths.get(projectDirectoryPathName,
                                          "nbproject"             ,
                                          "project.properties"    );
        File propertiesFile = propertyFilePath.toFile();
        PropertyProvider propertyProvider = PropertyUtils.
                                 propertiesFilePropertyProvider(propertiesFile);
        PropertyEvaluator propertyEvaluator = PropertyUtils.
                            sequentialPropertyEvaluator(null, propertyProvider);
        return propertyEvaluator.getProperty(propertyName);
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
        }
        return classNameWithPackage.toString();
    }
}