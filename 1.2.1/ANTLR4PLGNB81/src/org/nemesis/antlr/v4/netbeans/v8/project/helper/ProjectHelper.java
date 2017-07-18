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
package org.nemesis.antlr.v4.netbeans.v8.project.helper;

import java.io.File;
import java.io.IOException;

import java.net.URL;

import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import java.util.regex.PatternSyntaxException;

import javax.swing.text.Document;
import javax.swing.text.StyledDocument;

import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.JavaClass;

import org.nemesis.antlr.v4.netbeans.v8.project.ProjectType;

import org.nemesis.antlr.v4.netbeans.v8.project.helper.java.JavaSourceType;
import org.nemesis.antlr.v4.netbeans.v8.project.helper.java.JavaClassHelper;
import org.nemesis.antlr.v4.netbeans.v8.project.helper.java.JavaSourceClass;

import org.netbeans.api.java.classpath.ClassPath;
import org.netbeans.api.java.classpath.ClassPath.Entry;
import org.netbeans.api.java.classpath.GlobalPathRegistry;

import org.netbeans.api.project.FileOwnerQuery;
import org.netbeans.api.project.Project;

import org.netbeans.api.project.ant.AntBuildExtender;

import org.netbeans.modules.editor.NbEditorUtilities;

import org.netbeans.modules.maven.api.NbMavenProject;
import org.openide.cookies.EditorCookie;

import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;

import org.openide.loaders.DataObject;

import org.openide.util.Lookup;

/**
 *
 * @author Frédéric Yvon Vinet
 */
public class ProjectHelper {
    public static Project getProject(Document doc) {
        assert doc != null;
        Project project = null;
        DataObject docDataObj = NbEditorUtilities.getDataObject(doc);
        if (docDataObj != null)
            project = FileOwnerQuery.getOwner(docDataObj.getPrimaryFile());
        return project;
    }
    
    
    public static Project getProject(Path absoluteFilePath) {
        assert absoluteFilePath != null;
        assert Files.exists(absoluteFilePath);
        File file = absoluteFilePath.toFile();
//        System.out.println("absolute File Path=" + absoluteFilePath);
        FileObject fileObject = FileUtil.toFileObject(file);
        Project project;
        if (fileObject != null)
            project = FileOwnerQuery.getOwner(fileObject);
        else
            project = null;
        return project;
    }
    
    
    public static File getDirectory(Document doc) {
        assert doc != null;
        File docFile = null;
        DataObject docDO = NbEditorUtilities.getDataObject(doc);
        if (docDO != null)
            docFile = FileUtil.toFile(docDO.getPrimaryFile().getParent());
        return docFile;
    }
    
    
 /**
  * Returns the FileObject associated to the document passed as parameter.
  * @param doc
  * @return 
  */
    public static FileObject getFileObject(Document doc) {
        assert doc != null;
        FileObject answer;
        DataObject docDataObj = NbEditorUtilities.getDataObject(doc);
        if (docDataObj != null) {
            answer = docDataObj.getPrimaryFile();
        } else
            answer = null;
        return answer;
    }
    
    
    public static StyledDocument getDocument(FileObject fileObject) {
        assert fileObject != null;
        StyledDocument doc;
        try {
            DataObject dataObject = DataObject.find(fileObject);
            EditorCookie doec = dataObject.getLookup().lookup
                                                           (EditorCookie.class);
            doc = doec.openDocument();
        } catch (IOException ex) {
            doc = null;
        }
        return doc;
    }
    
    
    public static ProjectType getProjectType(Project project) {
        assert project != null;
        ProjectType l_projectType = ProjectType.UNDEFINED;
        Lookup projectLookup = project.getLookup();
        AntBuildExtender antBuildExtender =
                                   projectLookup.lookup(AntBuildExtender.class);
        
     // If an AntBuildExtender has been found then the project is an ant-based
     // one
        if (antBuildExtender != null)
            l_projectType = ProjectType.ANT_BASED;
        else {
            NbMavenProject nBMavenProject =
                                     projectLookup.lookup(NbMavenProject.class);
            if (nBMavenProject != null) {
                l_projectType = ProjectType.MAVEN_BASED;
            }
        }
        
        return l_projectType;
    }
    
    
    public static File getANTLRSourceDir(Project project) {
        assert project != null;
        FileObject projectDirFO = project.getProjectDirectory();
        File projectDir = FileUtil.toFile(projectDirFO);
        String antlrSrc = null;
        ProjectType projectType = getProjectType(project);
        switch (projectType) {
            case ANT_BASED:
             // By default, it will return "grammar"
                antlrSrc = AntBasedProjectHelper.getAntProjectProperty
                                         (project, "antlr.generator.src.dir");
                break;
            case MAVEN_BASED:
                antlrSrc = "src/main/antlr4";
                break;
            case UNDEFINED:
                antlrSrc = null;
                break;
        }
        return antlrSrc == null ? null : new File(projectDir, antlrSrc);
    }
    
    
    public static File getANTLRImportDir(Project project) {
        assert project != null;
        FileObject projectDirFO = project.getProjectDirectory();
        File projectDir = FileUtil.toFile(projectDirFO);
        String antlrSrcImprt = null;
        ProjectType projectType = getProjectType(project);
        switch (projectType) {
            case ANT_BASED:
             // By default, it will return "grammar/imports"
                antlrSrcImprt = AntBasedProjectHelper.getAntProjectProperty
                                        (project, "antlr.generator.import.dir");
                break;
            case MAVEN_BASED:
                antlrSrcImprt = "src/main/antlr4/imports";
                break;
            case UNDEFINED:
                antlrSrcImprt = null;
                break;
        }
        return antlrSrcImprt == null ? null : new File(projectDir, antlrSrcImprt);
    }
        

    public static File getANTLRDestinationDir(Project project) {
        assert project != null;
        FileObject projectDirFO = project.getProjectDirectory();
        File projectDir = FileUtil.toFile(projectDirFO);
        String antlrDestination = null;
        ProjectType projectType = getProjectType(project);
        switch (projectType) {
            case ANT_BASED:
             // By default, it will return "grammar/imports"
                antlrDestination = AntBasedProjectHelper.getAntProjectProperty
                                          (project, "antlr.generator.dest.dir");
                break;
            case MAVEN_BASED:
                antlrDestination = "target/generated-sources/antlr4";
                break;
            case UNDEFINED:
                antlrDestination = null;
                break;
        }
        return antlrDestination == null ? null : new File(projectDir, antlrDestination);
    }
    
    
    public static File getJavaSourceDir(Project project) {
        assert project != null;
        ProjectType projectType = getProjectType(project);
        String javaSrcDir;
        switch (projectType) {
            case ANT_BASED :
                javaSrcDir = AntBasedProjectHelper.getAntProjectProperty
                                                           (project, "src.dir");
                break;
            case MAVEN_BASED :
                javaSrcDir = "src/main/java";
                break;
            default:
                javaSrcDir = "";
        }
        File projectDir = FileUtil.toFile(project.getProjectDirectory());
        
        return new File (projectDir, javaSrcDir);
    }
    
    
 /**
  * Find ANTLR grammar names that a grammar in a given document could import
  * whether associated project is ant-based or Maven-based.
  * 
  * @param project
  * @return 
  */
    public static List<String> retrieveGrammarsImportableFrom(Document doc) {
        assert doc != null;
        ArrayList<String> answer = new ArrayList<>();
        
     // First step: we retrieve ANTLR v4 grammar files from the directory 
     // containing our document
        FileObject docFO = NbEditorUtilities.getFileObject(doc);
        Path docPath = FileUtil.toFile(docFO).toPath();
        FileObject docDirFO = docFO.getParent();
        Path docDirPath = FileUtil.toFile(docDirFO).toPath();
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher
                                                               ("glob:**/*.g4");

        try (
            DirectoryStream<Path> filePathStream = Files.newDirectoryStream
                                                              (docDirPath);
        ) {
            Iterator<Path> iterator = filePathStream.iterator();
            while (iterator.hasNext()) {
                Path path = iterator.next();
//                System.out.println("- path=" + path.toString());
                if (matcher.matches(path) &&
                    !docPath.equals(path)   ) {
//                     System.out.println("  accepted");
                  // For recovering only the file name without the extension
                  // we use FileObject that owns a method extracting that info
                     File file = new File(path.toString());
                     FileObject fo = FileUtil.toFileObject(file);
                     answer.add(fo.getName());
                }
            }
        } catch (IOException           |
                 PatternSyntaxException ex) {
            ex.printStackTrace();
        }
        
     // Second step: we retrieve ANTLR v4 grammar files from ANTLR import 
     // directory
        Project project = getProject(doc);
        File importDir = getANTLRImportDir(project);
        Path importDirPath = importDir.toPath();
        if (!docDirPath.equals(importDirPath)) {
            try (
                DirectoryStream<Path> filePathStream = Files.newDirectoryStream
                                                              (importDirPath);
            ) {
                Iterator<Path> iterator = filePathStream.iterator();
                while (iterator.hasNext()) {
                    Path path = iterator.next();
//                    System.out.println("- path=" + path.toString());
                    if (matcher.matches(path)) {
//                        System.out.println("  accepted");
                     // For recovering only the file name without the extension
                     // we use FileObject that owns a method extracting that info
                        File file = new File(path.toString());
                        FileObject fo = FileUtil.toFileObject(file);
                        answer.add(fo.getName());
                    }
                }
            } catch (IOException         |
                 PatternSyntaxException ex) {
                ex.printStackTrace();
            }
        }
        
        return answer;
    }
    
    
    public static List<String> retrieveJavaClassesExtendingImplementingANTLRToken
            (Project project) {
//        System.out.println("ProjectHelper:retrieveJavaClassesExtendingImplementingANTLRToken(Project) : begin");
        assert project != null;
     // We scan all Java classes in Java source directory
        File javaSrcDir = getJavaSourceDir(project);
        Path javaSrcDirPath = Paths.get(javaSrcDir.getPath());
        List<String> answer =
                       retrieveProjectJavaClassesExtendingImplementingANTLRToken
                           (project, javaSrcDirPath);
        List<String> answer2 =
                       retrieveLibraryJavaClassesExtendingImplementingANTLRToken
                           (project);
        answer.addAll(answer2);
//        System.out.println("total answer number=" + answer.size());
//        System.out.println("ProjectHelper:retrieveJavaClassesExtendingImplementingANTLRToken(Project) : end");
        return answer;
    }
    
    
    private static List<String> retrieveProjectJavaClassesExtendingImplementingANTLRToken
            (Project project, Path dir) {
//        System.out.println("ProjectHelper:retrieveProjectJavaClassesExtendingImplementingANTLRToken(Project, Path) -> List<String> : begin");
        assert project != null;
        List<String> answer = new ArrayList<>();
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher
                                                             ("glob:**/*.java");
//        System.out.println("- content of directory: " + dir.toString());
        try (
            DirectoryStream<Path> filePathStream = Files.newDirectoryStream
                                                                          (dir);
        ) {
            String projectJavaSourceDir = getJavaSourceDir(project).getPath();
            Iterator<Path> iterator = filePathStream.iterator();
            while (iterator.hasNext()) {
                Path path = iterator.next();
//                System.out.println("  * path=" + path.toString());
                if (matcher.matches(path)) {
                 // We've got a Java source, but is it a class and does it 
                 // inherit from motherClass?
                    JavaSourceType javaType = new JavaSourceType();
                    if (JavaClassHelper.isExtendingImplementingANTLRToken
                            (projectJavaSourceDir, path, javaType)) {
                        JavaSourceClass javaClass = javaType.getJavaClass();
/*                      
                        System.out.println
                           ("  * " + javaClass.getName() +
                            " accepted because extending an ANTLR Token class");
*/
                        answer.add(javaClass.getName());
                    }
                } else {
                    if (Files.isDirectory(path)) {
                        List<String> subDirAnswer =
                        retrieveProjectJavaClassesExtendingImplementingANTLRToken
                                                   (project, path);
                        answer.addAll(subDirAnswer);
                    }
                }
            }
        } catch (IOException           |
                 PatternSyntaxException ex) {
            ex.printStackTrace();
        }
//        System.out.println("ProjectHelper:retrieveProjectJavaClassesExtendingImplementingANTLRToken(Project, Path) -> List<String> : end");
        return answer;
    }
    
    
    private static List<String> retrieveLibraryJavaClassesExtendingImplementingANTLRToken
                (Project project) {
//        System.out.println("ProjectHelper:retrieveLibraryJavaClassesExtendingImplementingANTLRToken() : begin");
        assert project != null;
        List<String> answer = new ArrayList<>();
        GlobalPathRegistry gpr = GlobalPathRegistry.getDefault();
        Set<ClassPath> classPaths = gpr.getPaths(ClassPath.COMPILE);
        Iterator<ClassPath> classPathIt = classPaths.iterator();
        ClassPath classPath;
        List<Entry> entries;
        Entry entry;
     // We needn't to look for in the build/classes directory of project
        String projectDir = project.getProjectDirectory().getPath();
        String localBuildDir = "build/classes";
        Path localClassPath = Paths.get(projectDir, localBuildDir);
        URL localURL;
        Set<URL> alreadyProcessed = new HashSet<>();
        try {
            localURL = localClassPath.toUri().toURL();
//            System.out.println("- local URI to skip:" + localURL);
//            System.out.println("- classpath content:");
            
            while (classPathIt.hasNext()) {
                classPath = classPathIt.next();
                entries = classPath.entries();
                Iterator<Entry> entryIt = entries.iterator();
                while (entryIt.hasNext()) {
                    entry = entryIt.next();
                    URL url = entry.getURL();
                    String jarPath = url.getPath();
//                    System.out.println("  - " + jarPath);
                 // We must only process .jar files (ANTLR runtime and complete
                 // libraries excepted) and already processed libraries must not
                 // be processed twice
                    if (!url.equals(localURL)              &&
                        !alreadyProcessed.contains(url)    &&
                        jarPath.contains(".jar")           &&
                        !jarPath.contains("antlr-runtime-")&&
                        !(jarPath.contains("antlr-") && jarPath.contains("-complete"))) {
//                        System.out.println("    That URL must be processed");
                        alreadyProcessed.add(url);
                        if (jarPath.contains("file:/"))
                         // We remove file:/ at beginning and /! at end in order
                         // to have a syntactically correct path
                            jarPath = jarPath.substring("file:/".length()   ,
                                                        jarPath.length() - 2);
                        else
                         // We remove / at beginning and / at end in order to
                         // have a syntactically correct path
                            jarPath = jarPath.substring("/".length()        ,
                                                        jarPath.length() - 1);
//                        System.out.println("    jar path=" + jarPath);
                        JarFile jarFile = new JarFile(jarPath);
                        Enumeration<JarEntry> jarEntries = jarFile.entries();
                        while (jarEntries.hasMoreElements()) {
                            JarEntry jarEntry = jarEntries.nextElement();
                            String jarEntryName = jarEntry.getName();
                            if (!jarEntry.isDirectory()              &&
                                jarEntryName.endsWith(".class")  ){
                             // We have a jar entry that is a Java .class file
                             // We could load it with an URL class loader but
                             // we only need to recover info about that class.
                             // We needn't to run it. So we use Apache Byte
                             // Code Engineering Library (Apache Commons BCEL)
                                ClassParser cp = new ClassParser(jarPath, jarEntryName);
                                JavaClass javaClass = cp.parse();
                                if (JavaClassHelper.isExtendingImplementingANTLRToken(javaClass)) {
                                    answer.add(javaClass.getClassName());
/*
                                    System.out.println
                                       ("    class " + javaClass.getClassName() +
                                        " is one of classes we are looking for");
*/
                                }
                            }
                        }
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

//        System.out.println("ProjectHelper:retrieveLibraryJavaClassesExtendingImplementingANTLRToken() : end");
        return answer;
    }
    
    
 /**
  * ANTLR Library comes with three classes able to be a Lexer:
  * - org.antlr.v4.runtime.Lexer,
  * - org.antlr.v4.runtime.LexerInterpreter,
  * - org.antlr.v4.runtime.tree.xpath.XPathLexer.
  * 
  * So we look for classes in local project or project libraries that inherit
  * from one of these ANTLR lexer classes.
  * 
  * @param project
  * @return 
  */
    public static List<String> retrieveJavaClassesExtendingANTLRLexer
        (Project project) {
        assert project != null;
        File javaSourceDir = getJavaSourceDir(project);
        Path javaSrcDirPath = Paths.get(javaSourceDir.getPath());
        List<String> answer = retrieveProjectJavaClassesExtendingANTLRLexer
                                                      (project, javaSrcDirPath);
        List<String> answer2 = retrieveLibraryJavaClassesExtendingANTLRLexer
                                                                      (project);
        answer.addAll(answer2);
        return answer;
    }
    
    
    private static List<String> retrieveProjectJavaClassesExtendingANTLRLexer
        (Project project, Path dir) {
//        System.out.println("ProjectHelper:retrieveProjectJavaClassesExtendingANTLRLexer(Project, Path) -> List<String> : begin");
        assert project != null;
        assert dir != null;
        List<String> answer = new ArrayList<>();
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher
                                                             ("glob:**/*.java");
//        System.out.println("- content of directory: " + dir.toString());
        try (
            DirectoryStream<Path> filePathStream = Files.newDirectoryStream
                                                                          (dir);
        ) {
            String projectJavaSourceDir = getJavaSourceDir(project).getPath();
            Iterator<Path> iterator = filePathStream.iterator();
            while (iterator.hasNext()) {
                Path path = iterator.next();
//                System.out.println("  * path=" + path.toString());
                if (matcher.matches(path)) {
                 // We've got a Java source, but is it a class and does it 
                 // inherit from motherClass?
                    JavaSourceType javaType = new JavaSourceType();
                    if (JavaClassHelper.isExtendingANTLRLexer
                            (projectJavaSourceDir, path, javaType)) {
                        JavaSourceClass javaClass = javaType.getJavaClass();
/*                      
                        System.out.println
                           ("  * " + javaClass.getName() +
                            " accepted because extending an ANTLR Token class");
*/
                        answer.add(javaClass.getName());
                    }
                } else {
                    if (Files.isDirectory(path)) {
                        List<String> subDirAnswer =
                                   retrieveProjectJavaClassesExtendingANTLRLexer
                                                   (project, path);
                        answer.addAll(subDirAnswer);
                    }
                }
            }
        } catch (IOException           |
                 PatternSyntaxException ex) {
            ex.printStackTrace();
        }
//        System.out.println("ProjectHelper:retrieveProjectJavaClassesExtendingANTLRLexer(Project, Path) -> List<String> : end");
        return answer;
    }
    
    
    private static List<String> retrieveLibraryJavaClassesExtendingANTLRLexer
                (Project project) {
//        System.out.println("ProjectHelper:retrieveLibraryJavaClassesExtendingANTLRLexer() : begin");
        assert project != null;
        List<String> answer = new ArrayList<>();
        GlobalPathRegistry gpr = GlobalPathRegistry.getDefault();
        Set<ClassPath> classPaths = gpr.getPaths(ClassPath.COMPILE);
        Iterator<ClassPath> classPathIt = classPaths.iterator();
        ClassPath classPath;
        List<Entry> entries;
        Entry entry;
     // We needn't to look for in the build/classes directory of project
        String projectDir = project.getProjectDirectory().getPath();
        String localBuildDir = "build/classes";
        Path localClassPath = Paths.get(projectDir, localBuildDir);
        URL localURL;
        Set<URL> alreadyProcessed = new HashSet<>();
        try {
            localURL = localClassPath.toUri().toURL();
//            System.out.println("- local URI to skip:" + localURL);
//            System.out.println("- classpath content:");
            
            while (classPathIt.hasNext()) {
                classPath = classPathIt.next();
                entries = classPath.entries();
                Iterator<Entry> entryIt = entries.iterator();
                while (entryIt.hasNext()) {
                    entry = entryIt.next();
                    URL url = entry.getURL();
                    String jarPath = url.getPath();
//                    System.out.println("  - " + jarPath);
                 // We must only process .jar files (ANTLR runtime and complete
                 // libraries excepted) and already processed libraries must not
                 // be processed twice
                    if (!url.equals(localURL)              &&
                        !alreadyProcessed.contains(url)    &&
                        jarPath.contains(".jar")           &&
                        !jarPath.contains("antlr-runtime-")&&
                        !(jarPath.contains("antlr-") && jarPath.contains("-complete"))) {
//                        System.out.println("    That URL must be processed");
                        alreadyProcessed.add(url);
                        if (jarPath.contains("file:/"))
                         // We remove file:/ at beginning and /! at end in order
                         // to have a syntactically correct path
                            jarPath = jarPath.substring("file:/".length()   ,
                                                        jarPath.length() - 2);
                        else
                         // We remove / at beginning and / at end in order to
                         // have a syntactically correct path
                            jarPath = jarPath.substring("/".length()        ,
                                                        jarPath.length() - 1);
//                        System.out.println("    jar path=" + jarPath);
                        JarFile jarFile = new JarFile(jarPath);
                        Enumeration<JarEntry> jarEntries = jarFile.entries();
                        while (jarEntries.hasMoreElements()) {
                            JarEntry jarEntry = jarEntries.nextElement();
                            String jarEntryName = jarEntry.getName();
                            if (!jarEntry.isDirectory()              &&
                                jarEntryName.endsWith(".class")  ){
                             // We have a jar entry that is a Java .class file
                             // We could load it with an URL class loader but
                             // we only need to recover info about that class.
                             // We needn't to run it. So we use Apache Byte
                             // Code Engineering Library (Apache Commons BCEL)
                                ClassParser cp = new ClassParser(jarPath, jarEntryName);
                                JavaClass javaClass = cp.parse();
                                if (JavaClassHelper.isExtendingANTLRLexer(javaClass)) {
                                    answer.add(javaClass.getClassName());
/*
                                    System.out.println
                                       ("    class " + javaClass.getClassName() +
                                        " is one of classes we are looking for");
*/
                                }
                            }
                        }
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

//        System.out.println("ProjectHelper:retrieveLibraryJavaClassesExtendingANTLRLexer() : end");
        return answer;
    }
    
    
 /**
  * ANTLR Library comes with three classes able to be a Parser:
  * - org.antlr.v4.runtime.Lexer,
  * - org.antlr.v4.runtime.LexerInterpreter,
  * - org.antlr.v4.runtime.tree.xpath.XPathLexer.
  * 
  * So we look for classes in local project or project libraries that inherit
  * from one of these ANTLR lexer classes.
  * 
  * @param project
  * @return 
  */
    public static List<String> retrieveJavaClassesExtendingANTLRParser
        (Project project) {
        assert project != null;
        File javaSourceDir = getJavaSourceDir(project);
        Path javaSrcDirPath = Paths.get(javaSourceDir.getPath());
        List<String> answer = retrieveProjectJavaClassesExtendingANTLRParser
                                                      (project, javaSrcDirPath);
        List<String> answer2 = retrieveLibraryJavaClassesExtendingANTLRParser
                                                                      (project);
        answer.addAll(answer2);
        return answer;
    }
    
    
    private static List<String> retrieveProjectJavaClassesExtendingANTLRParser
        (Project project, Path dir) {
//        System.out.println("ProjectHelper:retrieveProjectJavaClassesExtendingANTLRParser(Project, Path) -> List<String> : begin");
        assert project != null;
        assert dir != null;
        List<String> answer = new ArrayList<>();
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher
                                                             ("glob:**/*.java");
//        System.out.println("- content of directory: " + dir.toString());
        try (
            DirectoryStream<Path> filePathStream = Files.newDirectoryStream
                                                                          (dir);
        ) {
            String projectJavaSourceDir = getJavaSourceDir(project).getPath();
            Iterator<Path> iterator = filePathStream.iterator();
            while (iterator.hasNext()) {
                Path path = iterator.next();
//                System.out.println("  * path=" + path.toString());
                if (matcher.matches(path)) {
                 // We've got a Java source, but is it a class and does it 
                 // inherit from motherClass?
                    JavaSourceType javaType = new JavaSourceType();
                    if (JavaClassHelper.isExtendingANTLRParser
                            (projectJavaSourceDir, path, javaType)) {
                        JavaSourceClass javaClass = javaType.getJavaClass();
/*                      
                        System.out.println
                           ("  * " + javaClass.getName() +
                            " accepted because extending an ANTLR Token class");
*/
                        answer.add(javaClass.getName());
                    }
                } else {
                    if (Files.isDirectory(path)) {
                        List<String> subDirAnswer =
                                  retrieveProjectJavaClassesExtendingANTLRParser
                                                   (project, path);
                        answer.addAll(subDirAnswer);
                    }
                }
            }
        } catch (IOException           |
                 PatternSyntaxException ex) {
            ex.printStackTrace();
        }
//        System.out.println("ProjectHelper:retrieveProjectJavaClassesExtendingANTLRParser(Project, Path) -> List<String> : end");
        return answer;
    }
    
    
    private static List<String> retrieveLibraryJavaClassesExtendingANTLRParser
                (Project project) {
//        System.out.println("ProjectHelper:retrieveLibraryJavaClassesExtendingANTLRParser() : begin");
        assert project != null;
        List<String> answer = new ArrayList<>();
        GlobalPathRegistry gpr = GlobalPathRegistry.getDefault();
        Set<ClassPath> classPaths = gpr.getPaths(ClassPath.COMPILE);
        Iterator<ClassPath> classPathIt = classPaths.iterator();
        ClassPath classPath;
        List<Entry> entries;
        Entry entry;
     // We needn't to look for in the build/classes directory of project
        String projectDir = project.getProjectDirectory().getPath();
        String localBuildDir = "build/classes";
        Path localClassPath = Paths.get(projectDir, localBuildDir);
        URL localURL;
        Set<URL> alreadyProcessed = new HashSet<>();
        try {
            localURL = localClassPath.toUri().toURL();
//            System.out.println("- local URI to skip:" + localURL);
//            System.out.println("- classpath content:");
            
            while (classPathIt.hasNext()) {
                classPath = classPathIt.next();
                entries = classPath.entries();
                Iterator<Entry> entryIt = entries.iterator();
                while (entryIt.hasNext()) {
                    entry = entryIt.next();
                    URL url = entry.getURL();
                    String jarPath = url.getPath();
//                    System.out.println("  - " + jarPath);
                 // We must only process .jar files (ANTLR runtime and complete
                 // libraries excepted) and already processed libraries must not
                 // be processed twice
                    if (!url.equals(localURL)              &&
                        !alreadyProcessed.contains(url)    &&
                        jarPath.contains(".jar")           &&
                        !jarPath.contains("antlr-runtime-")&&
                        !(jarPath.contains("antlr-") && jarPath.contains("-complete"))) {
//                        System.out.println("    That URL must be processed");
                        alreadyProcessed.add(url);
                        if (jarPath.contains("file:/"))
                         // We remove file:/ at beginning and /! at end in order
                         // to have a syntactically correct path
                            jarPath = jarPath.substring("file:/".length()   ,
                                                        jarPath.length() - 2);
                        else
                         // We remove / at beginning and / at end in order to
                         // have a syntactically correct path
                            jarPath = jarPath.substring("/".length()        ,
                                                        jarPath.length() - 1);
//                        System.out.println("    jar path=" + jarPath);
                        JarFile jarFile = new JarFile(jarPath);
                        Enumeration<JarEntry> jarEntries = jarFile.entries();
                        while (jarEntries.hasMoreElements()) {
                            JarEntry jarEntry = jarEntries.nextElement();
                            String jarEntryName = jarEntry.getName();
                            if (!jarEntry.isDirectory()              &&
                                jarEntryName.endsWith(".class")  ){
                             // We have a jar entry that is a Java .class file
                             // We could load it with an URL class loader but
                             // we only need to recover info about that class.
                             // We needn't to run it. So we use Apache Byte
                             // Code Engineering Library (Apache Commons BCEL)
                                ClassParser cp = new ClassParser(jarPath, jarEntryName);
                                JavaClass javaClass = cp.parse();
                                if (JavaClassHelper.isExtendingANTLRParser(javaClass)) {
                                    answer.add(javaClass.getClassName());
/*
                                    System.out.println
                                       ("    class " + javaClass.getClassName() +
                                        " is one of classes we are looking for");
*/
                                }
                            }
                        }
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

//        System.out.println("ProjectHelper:retrieveLibraryJavaClassesExtendingANTLRParser() : end");
        return answer;
    }
    
    
 /**
  * Token files may be located in import directory or in ANTLR destination 
  * directory added with grammar subdir of importing grammar.
  * 
  * So we look for classes in local project in these directories.
  * 
  * @param project
  * @return 
  */
    public static List<String> retrieveTokenFilesInProjectImportableFrom
            (Project      project           ,
             Path         grammarPath       ,
             List<String> excludedTokenFiles) {
        System.out.println("ProjectHelper:retrieveTokenFilesInProjectImportableFrom() -> List<String> : begin");
        assert project != null;
        assert grammarPath != null;
        System.out.println("- source grammar=" + grammarPath);
     // We look for .tokens files in import directory
        File tokensSourceDir = getANTLRImportDir(project);
        Path tokenSrcDirPath = tokensSourceDir.toPath();
        List<String> answer = retrieveTokenFilesInDirImportableFrom
                                          (tokenSrcDirPath, excludedTokenFiles);
        System.out.println("- answer size=" + answer.size());
        
     // We look for .tokens files in the same directory as importing grammar
     // file
        Path absoluteGrammarDirPath = grammarPath.getParent();
        List<String> answer1 = retrieveTokenFilesInDirImportableFrom
                                   (absoluteGrammarDirPath, excludedTokenFiles);
        answer.addAll(answer1);
        System.out.println("- answer size=" + answer.size());
        
     // We look for .tokens files :
     // - in ANTLR destination directory added with relative path of the directory
     //   of our importing grammar if this one is diffrent from import directory
     // - else in ANTLR destination directory 
     // We build the relative path of the directory of our importing grammar
        File ANTLRSourceDir = ProjectHelper.getANTLRSourceDir(project);
        File ANTLRImportDir = ProjectHelper.getANTLRImportDir(project);
        File destinationSourceDir = ProjectHelper.getANTLRDestinationDir(project);
        if (ANTLRImportDir.equals(ANTLRSourceDir)) {
            tokenSrcDirPath = Paths.get(destinationSourceDir.getName());
        } else {
            Path absoluteANTLRSourceDir = ANTLRSourceDir.toPath();
            Path relativeGrammarDirPath = absoluteANTLRSourceDir.relativize
                                                       (absoluteGrammarDirPath);
            System.out.println("- relative grammar dir path=" +
                               relativeGrammarDirPath);
            tokenSrcDirPath = Paths.get(destinationSourceDir.getPath()   ,
                                        relativeGrammarDirPath.toString());
        }
        List<String> answer2 = retrieveTokenFilesInDirImportableFrom
                                 (tokenSrcDirPath, excludedTokenFiles);
        answer.addAll(answer2);
        System.out.println("- answer size=" + answer.size());
        
        /*
        Currently ANTLR does not look for token file in classpath so it is
        useless to propose token files placed in libraries
        List<String> answer2 = retrieveLibraryTokenFiles(project);
        answer.addAll(answer2);
        */
//        System.out.println("ProjectHelper:retrieveTokenFilesInProjectImportableFrom() -> List<String> : end");
        return answer;
    }
    
    
    private static List<String> retrieveTokenFilesInDirImportableFrom
            (Path         dir               ,
             List<String> excludedTokenFiles) {
//        System.out.println("ProjectHelper:retrieveTokenFilesInDirImportableFrom(Project, Path) -> List<String> : begin");
        assert dir != null;
        List<String> answer = new ArrayList<>();
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher
                                                           ("glob:**/*.tokens");
//        System.out.println("- content of directory: " + dir.toString());
        try (
            DirectoryStream<Path> filePathStream = Files.newDirectoryStream
                                                                          (dir);
        ) {
            Iterator<Path> iterator = filePathStream.iterator();
            while (iterator.hasNext()) {
                Path path = iterator.next();
//                System.out.println("  * path=" + path.toString());
                if (matcher.matches(path)) {
                 // We've got a tokens file
                 // We extract its file name from its path (extension must be
                 // removed)
                    String tokenFileName = path.getFileName().toString();
                    int end = tokenFileName.lastIndexOf(".tokens");
                    tokenFileName= tokenFileName.substring(0, end);
//                    System.out.println("    file name=" + tokenFileName);
                 // A grammar cannot import a token file generated by itself
                 // so the tokens files associated to the current grammar must
                 // not be proposed
                    if (!excludedTokenFiles.contains(tokenFileName)) {
                        answer.add(tokenFileName);

//                        System.out.println
//                             ("    " + tokenFileName +
//                              " accepted because ending with .tokens");

                    }
                }
            }
        } catch (IOException           |
                 PatternSyntaxException ex) {
            ex.printStackTrace();
        }
//        System.out.println("ProjectHelper:retrieveTokenFilesInDirImportableFrom(Project, Path) -> List<String> : end");
        return answer;
    }
}