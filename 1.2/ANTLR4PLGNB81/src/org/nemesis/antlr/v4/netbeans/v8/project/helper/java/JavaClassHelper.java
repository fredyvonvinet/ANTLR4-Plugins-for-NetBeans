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
package org.nemesis.antlr.v4.netbeans.v8.project.helper.java;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import java.net.URL;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.LexerInterpreter;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserInterpreter;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.WritableToken;

import org.antlr.v4.runtime.tree.pattern.RuleTagToken;
import org.antlr.v4.runtime.tree.pattern.TokenTagToken;
import org.antlr.v4.runtime.tree.xpath.XPathLexer;
import org.apache.bcel.classfile.ClassParser;

import org.apache.bcel.classfile.JavaClass;

import org.nemesis.antlr.v4.netbeans.v8.project.helper.ProjectHelper;

import org.nemesis.antlr.v4.netbeans.v8.project.helper.java.impl.JavaLexer;
import org.nemesis.antlr.v4.netbeans.v8.project.helper.java.impl.JavaParser;
import org.netbeans.api.java.classpath.ClassPath;
import org.netbeans.api.java.classpath.GlobalPathRegistry;
import org.netbeans.api.project.Project;

/**
 *
 * @author Frédéric Yvon Vinet
 */
public class JavaClassHelper {
 /**
  * Determine if a class contained in a given file (parameter 
  * potentialChildClassPath is a local path relative to project Java source 
  * directory given ) is extending one of ANTLR Token classes or
  * implementing one of ANTLR Token interfaces.
  * 
  * The task is done by a parsing of that Java source file.
  * 
  * @param projectJavaSrcDir absolute project Java source directory
  * @param potentialChildClassPath relative path to a Java source
  * @param answer
  * @return 
  */
    public static boolean isExtendingImplementingANTLRToken
            (String         projectJavaSrcDir      ,
             Path           potentialChildClassPath,
             JavaSourceType answer                 ) {
//        System.out.println("JavaClassHelper:isExtendingImplementingANTLRToken() -> boolean : begin");
        assert projectJavaSrcDir != null;
        assert potentialChildClassPath != null;
        boolean inheritsFrom;
     // We define the three Token classes provided by ANTLR
        Class<?> motherClass = CommonToken.class;
        JavaSourceClass commonTokenANTLRClass = new JavaSourceClass
                      (motherClass.getPackage().getName(),
                       motherClass.getSimpleName()       );
        motherClass = TokenTagToken.class;
        JavaSourceClass tokenTagTokenANTLRClass = new JavaSourceClass
                      (motherClass.getPackage().getName(),
                       motherClass.getSimpleName()       );
        motherClass = RuleTagToken.class;
        JavaSourceClass ruleTagTokenANTLRClass = new JavaSourceClass
                      (motherClass.getPackage().getName(),
                       motherClass.getSimpleName()       );
//        System.out.println("common Token ANTLR Class:");
//        System.out.println("- package name=" + commonTokenANTLRClass.getPackage());
//        System.out.println("- simple class name=" + commonTokenANTLRClass.getSimpleName());
//        System.out.println("- class name=" + commonTokenANTLRClass.getName());
//        System.out.println("- local file path=" + commonTokenANTLRClass.getLocalFilePath());
        
     // We parse Java file for determining if its contained type is a class and
     // its potential super class
        List<JavaSourceClass> implementedInterfaces = new ArrayList<>();
        JavaSourceClass superClassOfPCC = getSuperClassAndImplementedInterfaces
            (potentialChildClassPath, answer, implementedInterfaces);
        if (superClassOfPCC == null) {
         // Java type pointed by potentialChildClassPath is not a class or is a 
         // class but does not have a superclass
            inheritsFrom = false;
        } else {
         // Java type pointed by potentialChildClassPath is a class and has a
         // superclass
            if (superClassOfPCC.equals(commonTokenANTLRClass)   ||
                superClassOfPCC.equals(tokenTagTokenANTLRClass) ||
                superClassOfPCC.equals(ruleTagTokenANTLRClass)    ) {
                inheritsFrom = true;
            } else {
             // superclass of our Java type is not one of Token classes provided
             // by ANTLR. But perhaps this superclass extends or implements one
             // of Token classes provided by ANTLR.
             // We build the path from project directory, project Java 
             // source directory and class path transformed in local 
             // path
                String localMotherFileName = superClassOfPCC.getLocalFilePath();
                Path superClassPath = Paths.get
                           (projectJavaSrcDir  ,
                            localMotherFileName);
                if (Files.exists(superClassPath)) {
                    inheritsFrom = isExtendingImplementingANTLRToken
                                      (projectJavaSrcDir, superClassPath, null);
                } else 
                    inheritsFrom = false;
            }
        }
        
     // Now we take care of potential implemented interfaces
        Class<?> implementedInterface = Token.class;
        JavaSourceClass tokenANTLRInterface = new JavaSourceClass
                      (implementedInterface.getPackage().getName(),
                       implementedInterface.getSimpleName()       );
        implementedInterface = WritableToken.class;
        JavaSourceClass writableTokenANTLRInterface = new JavaSourceClass
                      (implementedInterface.getPackage().getName(),
                       implementedInterface.getSimpleName()       );
        boolean implementsInterface = false;
        if (!implementedInterfaces.isEmpty()) {
         // We scan all interfaces till we find an ANTLR Token interface
            Iterator<JavaSourceClass> jscIt = implementedInterfaces.iterator();
            JavaSourceClass jsc;
            while (jscIt.hasNext()) {
                jsc = jscIt.next();
                if (jsc.equals(tokenANTLRInterface)        ||
                    jsc.equals(writableTokenANTLRInterface)  ) {
                    implementsInterface = true;
                }
            }
        }
//        System.out.println("JavaClassHelper:isExtendingImplementingANTLRToken() -> boolean : end");
        return inheritsFrom || implementsInterface ;
    }
    
    
 /**
  * Determine if a Java class parsed from a .class file (given by parameter 
  * javaClass) is extending one of ANTLR token classes or implementing one of
  * ANTLR token interfaces.
  * 
  * @param javaClass
  * @return 
  */
    public static boolean isExtendingImplementingANTLRToken
            (JavaClass javaClass) {
        assert javaClass != null;
        boolean answer = false;
        try {
         // We only need to process public class
            if (javaClass.isClass() &&
                javaClass.isPublic()  ) {
             // Every class has a super class if no extends statement is defined
             // then it means that superclass is java.lang.Object
                JavaClass superClass = javaClass.getSuperClass();
                String superClassName = superClass.getClassName();
                if (superClassName.equals("org.antlr.v4.runtime.CommonToken") ||
                    superClassName.equals("org.antlr.v4.runtime.tree.pattern.RuleTagToken") ||
                    superClassName.equals("org.antlr.v4.runtime.tree.pattern.TokenTagToken")) {
                    answer = true;
                }
                if (!answer) {
                    JavaClass[] javaInterfaces = javaClass.getInterfaces();
                    int i = 0;
                    JavaClass javaInterface;
                    while (i < javaInterfaces.length && !answer) {
                        javaInterface = javaInterfaces[i++];
                        String javaInterfaceName = javaInterface.getClassName();
                        if (javaInterfaceName.equals("org.antlr.v4.runtime.Token") ||
                            javaInterfaceName.equals("org.antlr.v4.runtime.WritableToken")) {
                            answer = true;
                        }
                    }
                }
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return answer;
    }
    
    
 /**
  * Determine if a class contained in a given file (parameter 
  * potentialChildClassPath is a local path relative to project Java source 
  * directory given ) is extending one of ANTLR lexer classes.
  * 
  * The task is done by a parsing of that Java source file.
  * 
  * @param projectJavaSrcDir absolute project Java source directory
  * @param potentialChildClassPath relative path to a Java source
  * @param answer
  * @return 
  */
    public static boolean isExtendingANTLRLexer
            (String         projectJavaSrcDir      ,
             Path           potentialChildClassPath,
             JavaSourceType answer                 ) {
//        System.out.println("JavaClassHelper:isExtendingANTLRLexer() -> boolean : begin");
        assert projectJavaSrcDir != null;
        assert potentialChildClassPath != null;
        boolean inheritsFrom;
     // We define the three Token classes provided by ANTLR
        Class<?> motherClass = Lexer.class;
        JavaSourceClass lexerANTLRClass = new JavaSourceClass
                      (motherClass.getPackage().getName(),
                       motherClass.getSimpleName()       );
        motherClass = LexerInterpreter.class;
        JavaSourceClass lexerInterpreterANTLRClass = new JavaSourceClass
                      (motherClass.getPackage().getName(),
                       motherClass.getSimpleName()       );
        motherClass = XPathLexer.class;
        JavaSourceClass xPathLexer = new JavaSourceClass
                      (motherClass.getPackage().getName(),
                       motherClass.getSimpleName()       );
//        System.out.println("Lexer ANTLR Class:");
//        System.out.println("- package name=" + lexerANTLRClass.getPackage());
//        System.out.println("- simple class name=" + lexerANTLRClass.getSimpleName());
//        System.out.println("- class name=" + lexerANTLRClass.getName());
//        System.out.println("- local file path=" + lexerANTLRClass.getLocalFilePath());
        
     // We parse Java file for determining if its contained type is a class and
     // its potential super class
        List<JavaSourceClass> implementedInterfaces = new ArrayList<>();
        JavaSourceClass superClassOfPCC = getSuperClassAndImplementedInterfaces
            (potentialChildClassPath, answer, implementedInterfaces);
        if (superClassOfPCC == null) {
         // Java type pointed by potentialChildClassPath is not a class or is a 
         // class but does not have a superclass
            inheritsFrom = false;
        } else {
         // Java type pointed by potentialChildClassPath is a class and has a
         // superclass
            if (superClassOfPCC.equals(lexerANTLRClass)            ||
                superClassOfPCC.equals(lexerInterpreterANTLRClass) ||
                superClassOfPCC.equals(xPathLexer)                   ) {
                inheritsFrom = true;
            } else {
             // superclass of our Java type is not one of Token classes provided
             // by ANTLR. But perhaps this superclass extends or implements one
             // of Token classes provided by ANTLR.
             // We build the path from project directory, project Java 
             // source directory and class path transformed in local 
             // path
                String localMotherFileName = superClassOfPCC.getLocalFilePath();
                Path superClassPath = Paths.get
                           (projectJavaSrcDir  ,
                            localMotherFileName);
                if (Files.exists(superClassPath)) {
                    inheritsFrom = isExtendingANTLRLexer
                                      (projectJavaSrcDir, superClassPath, null);
                } else 
                    inheritsFrom = false;
            }
        }
//        System.out.println("JavaClassHelper:isExtendingANTLRLexer() -> boolean : end");
        return inheritsFrom;
    }
    
    
 /**
  * Determine if a Java class parsed from a .class file (given by parameter 
  * javaClass) is extending one of ANTLR lexer classes.
  * 
  * @param javaClass
  * @return 
  */
    public static boolean isExtendingANTLRLexer(JavaClass javaClass) {
        assert javaClass != null;
        boolean answer = false;
        try {
         // We only need to process public class
            if (javaClass.isClass() &&
                javaClass.isPublic()  ) {
             // Every class has a super class if no extends statement is defined
             // then it means that superclass is java.lang.Object
                JavaClass superClass = javaClass.getSuperClass();
                String superClassName = superClass.getClassName();
                if (superClassName.equals(Lexer.class.getName()) ||
                    superClassName.equals(LexerInterpreter.class.getName()) ||
                    superClassName.equals(XPathLexer.class.getName())) {
                    answer = true;
                }
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return answer;
    }
    
    
 /**
  * Determine if a class contained in a given file (parameter 
  * potentialChildClassPath is a local path relative to project Java source 
  * directory given ) is extending one of ANTLR Parser classes.
  * 
  * The task is done by a parsing of that Java source file.
  * 
  * @param projectJavaSrcDir absolute project Java source directory
  * @param potentialChildClassPath relative path to a Java source
  * @param answer
  * @return 
  */
    public static boolean isExtendingANTLRParser
            (String         projectJavaSrcDir      ,
             Path           potentialChildClassPath,
             JavaSourceType answer                 ) {
//        System.out.println("JavaClassHelper:isExtendingANTLRParser(String, Path) -> boolean : begin");
        assert projectJavaSrcDir != null;
        assert potentialChildClassPath != null;
        boolean inheritsFrom;
     // We define the three Token classes provided by ANTLR
        Class<?> motherClass = Parser.class;
        JavaSourceClass parserANTLRClass = new JavaSourceClass
                      (motherClass.getPackage().getName(),
                       motherClass.getSimpleName()       );
        motherClass = ParserInterpreter.class;
        JavaSourceClass parserInterpreterANTLRClass = new JavaSourceClass
                      (motherClass.getPackage().getName(),
                       motherClass.getSimpleName()       );
//        System.out.println("Parser ANTLR Class:");
//        System.out.println("- package name=" + parserANTLRClass.getPackage());
//        System.out.println("- simple class name=" + parserANTLRClass.getSimpleName());
//        System.out.println("- class name=" + parserANTLRClass.getName());
//        System.out.println("- local file path=" + parserANTLRClass.getLocalFilePath());
        
     // We parse Java file for determining if its contained type is a class and
     // its potential super class
        List<JavaSourceClass> implementedInterfaces = new ArrayList<>();
        JavaSourceClass superClassOfPCC = getSuperClassAndImplementedInterfaces
            (potentialChildClassPath, answer, implementedInterfaces);
        if (superClassOfPCC == null) {
         // Java type pointed by potentialChildClassPath is not a class or is a 
         // class but does not have a superclass
            inheritsFrom = false;
        } else {
         // Java type pointed by potentialChildClassPath is a class and has a
         // superclass
            if (superClassOfPCC.equals(parserANTLRClass)           ||
                superClassOfPCC.equals(parserInterpreterANTLRClass)  ) {
                inheritsFrom = true;
            } else {
             // superclass of our Java type is not one of Token classes provided
             // by ANTLR. But perhaps this superclass extends or implements one
             // of Token classes provided by ANTLR.
             // We build the path from project directory, project Java 
             // source directory and class path transformed in local 
             // path
                String localMotherFileName = superClassOfPCC.getLocalFilePath();
                Path superClassPath = Paths.get
                           (projectJavaSrcDir  ,
                            localMotherFileName);
                if (Files.exists(superClassPath)) {
                    inheritsFrom = isExtendingANTLRParser
                                      (projectJavaSrcDir, superClassPath, null);
                } else 
                    inheritsFrom = false;
            }
        }
//        System.out.println("JavaClassHelper:isExtendingANTLRParser(String, Path) -> boolean : end");
        return inheritsFrom;
    }
    
    
 /**
  * Determine if a Java class parsed from a .class file (given by parameter 
  * javaClass) is extending one of ANTLR parser classes.
  * 
  * @param javaClass
  * @return 
  */
    public static boolean isExtendingANTLRParser(JavaClass javaClass) {
        assert javaClass != null;
        boolean answer = false;
        try {
         // We only need to process public class
            if (javaClass.isClass() &&
                javaClass.isPublic()  ) {
             // Every class has a super class if no extends statement is defined
             // then it means that superclass is java.lang.Object
                JavaClass superClass = javaClass.getSuperClass();
                String superClassName = superClass.getClassName();
                if (superClassName.equals(Parser.class.getName()) ||
                    superClassName.equals(ParserInterpreter.class.getName())) {
                    answer = true;
                }
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return answer;
    }
    
    
    public static JavaClass getJavaClassInLibraries
            (Project project, String qualifiedJavaClassName) {
//        System.out.println("ProjectHelper:getJavaClassInLibraries(Project, String) : begin");
        JavaClass javaClass = null;
        GlobalPathRegistry gpr = GlobalPathRegistry.getDefault();
        Set<ClassPath> classPaths = gpr.getPaths(ClassPath.COMPILE);
        Iterator<ClassPath> classPathIt = classPaths.iterator();
        
        ClassPath.Entry entry;
     // We needn't to look for in the build/classes directory of project
        String projectDir = project.getProjectDirectory().getPath();
        String localBuildDir = "build/classes";
        Path localClassPath = Paths.get(projectDir, localBuildDir);
        URL localURL;
        Set<URL> alreadyProcessed = new HashSet<>();
        try {
            localURL = localClassPath.toUri().toURL();
//            System.out.println("- local URL to skip:" + localURL);
//            System.out.println("- classpath content:");
            ClassPath classPath;
            List<ClassPath.Entry> entries;
            boolean found = false;
            while (classPathIt.hasNext() && !found) {
                classPath = classPathIt.next();
                entries = classPath.entries();
                Iterator<ClassPath.Entry> entryIt = entries.iterator();
                while (entryIt.hasNext() && !found) {
                    entry = entryIt.next();
                    URL url = entry.getURL();
                    String jarPath = url.getPath();
//                    System.out.println("  - " + jarPath);
                 // We must only process .jar files (ANTLR runtime and complete
                 // libraries excepted) and already processed libraries must not
                 // be processed twice
                    if (!url.equals(localURL)           &&
                        !alreadyProcessed.contains(url) &&
                        jarPath.contains(".jar")           ) {
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
                        while (jarEntries.hasMoreElements() && !found) {
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
                                javaClass = cp.parse();
//                                System.out.println("    class name=" + javaClass.getClassName());
                                if (javaClass.getClassName().equals(qualifiedJavaClassName)) {
//                                    System.out.println("    searched class found!");
                                    found = true;
                                }
                            }
                        }
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
//        System.out.println("ProjectHelper:getJavaClassInLibraries(Project, String) : end");
        return javaClass;
    }
    
           
    private static JavaSourceClass getSuperClassAndImplementedInterfaces
            (Path                  javaFilePath         ,
             JavaSourceType        originalType         ,
             List<JavaSourceClass> implementedInterfaces) {
//        System.out.println("JavaClassHelper.getSuperClass(Path) -> JavaClass : begin");
        assert javaFilePath != null;
        JavaSourceClass answer;
        try (Reader sr = new FileReader(javaFilePath.toString()) ) {
            ANTLRInputStream input = new ANTLRInputStream(sr);
            JavaLexer lexer = new JavaLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            JavaParser parser = new JavaParser(tokens);
            parser.removeErrorListeners(); // remove ConsoleErrorListener
            SuperClassFinder scf = new SuperClassFinder();
            parser.addParseListener(scf); // 
            parser.compilationUnit();
//            System.out.println("- Java file parsed");
            answer = scf.getSuperClass();
            if (originalType != null)
                originalType.setJavaClass(scf.getJavaClass());
            implementedInterfaces.addAll(scf.getImplementedInterfaces());
        } catch (IOException ex) {
//            System.out.println("IOException : Java file not parsed");
            answer = null;
        }
//        System.out.println("JavaClassHelper.getSuperClass(Path) -> JavaClass : end");
        return answer;
    }
    
    
    public static boolean isInheritingFrom
            (Class<?> potentialChildClass, Class<?> potentialMotherClass) {
        boolean inheritsFrom;
        if (potentialChildClass == null)
            inheritsFrom = false;
        else {
         // We test if it inherist from motherClass
            Class<?> motherClass = potentialChildClass.getSuperclass();
            if (motherClass == null)
                inheritsFrom = false;
            else {
                if (motherClass.equals(potentialMotherClass))
                    inheritsFrom = true;
                else
                    inheritsFrom = isInheritingFrom(motherClass, potentialMotherClass);
            }
        }
        return inheritsFrom;
    }
    
    
    public static Class<?> loadClass(String className) {
        Class<?> answer;
        ClassLoader ccl = ProjectHelper.class.getClassLoader();
        ClassLoader tcl = new TemporaryClassLoader(ccl);
        try {
            answer = tcl.loadClass(className);
        } catch (ClassNotFoundException ex) {
            answer = null;
        }
        return answer;
    }
}