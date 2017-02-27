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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.tree.TerminalNode;

import org.nemesis.antlr.v4.netbeans.v8.project.helper.java.impl.JavaBaseListener;

import org.nemesis.antlr.v4.netbeans.v8.project.helper.java.impl.JavaParser.ClassDeclarationContext;
import org.nemesis.antlr.v4.netbeans.v8.project.helper.java.impl.JavaParser.ClassOrInterfaceModifierContext;
import org.nemesis.antlr.v4.netbeans.v8.project.helper.java.impl.JavaParser.ClassOrInterfaceTypeContext;
import org.nemesis.antlr.v4.netbeans.v8.project.helper.java.impl.JavaParser.ImportDeclarationContext;
import org.nemesis.antlr.v4.netbeans.v8.project.helper.java.impl.JavaParser.PackageDeclarationContext;
import org.nemesis.antlr.v4.netbeans.v8.project.helper.java.impl.JavaParser.QualifiedNameContext;
import org.nemesis.antlr.v4.netbeans.v8.project.helper.java.impl.JavaParser.TypeListContext;
import org.nemesis.antlr.v4.netbeans.v8.project.helper.java.impl.JavaParser.TypeTypeContext;

/**
 *
 * @author Frédéric Yvon Vinet
 */
public class SuperClassFinder extends JavaBaseListener {
    protected       String                  currentPackageName;
    protected       String                  simpleClassName;
    protected final HashMap<String, String> classToPackages;
    protected       boolean                 publicType;
    protected final List<String>            fullImportedPackages;
    protected       JavaSourceClass         superClass;
    protected final List<JavaSourceClass>   implementedInterfaces;

    public JavaSourceClass getSuperClass() {
        return superClass;
    }
    
    public JavaSourceClass getJavaClass() {
        return new JavaSourceClass(currentPackageName, simpleClassName);
    }

    public List<JavaSourceClass> getImplementedInterfaces() {
        return implementedInterfaces;
    }
    
    public SuperClassFinder() {
        this.currentPackageName = null; // if there is no package statement then there is no package
        this.simpleClassName = null;
        this.classToPackages = new HashMap<>();
        this.publicType = false; // If there is no public modifier it is a private
        this.fullImportedPackages = new ArrayList<>();
        this.superClass = null;
        this.implementedInterfaces = new ArrayList<>();
    }

    
    @Override
    public void exitPackageDeclaration(PackageDeclarationContext ctx) {
//        System.out.println("SuperClassFinder:exitPackageDeclaration(PackageDeclarationContext) : begin");
        QualifiedNameContext qnc = ctx.qualifiedName();
        if (qnc != null) {
            currentPackageName = qnc.getText();
//            System.out.println("- package name=" + currentPackageName);
        }
//        System.out.println("SuperClassFinder:exitPackageDeclaration(PackageDeclarationContext) : end");
    }
    

    private static final Pattern PATTERN = Pattern.compile("\\p{Lu}");
    @Override
    public void exitImportDeclaration(ImportDeclarationContext ctx) {
//        System.out.println("SuperClassFinder:exitImportDeclaration(ImportDeclarationContext) : begin");
        QualifiedNameContext qnc = ctx.qualifiedName();
        String qualifiedName = qnc.getText();
        TerminalNode starTN = ctx.STAR();
        if (starTN == null) {
         // We look for the first occurrence of an uppercase character
         // It marks the begin of the class name.
            Matcher matcher = PATTERN.matcher(qualifiedName);
            if (matcher.find()) {
                int index = matcher.start();
             // Normally, index is always greater than or equal to 2
             // but in case of erroneous import statement, it is possible to have
             // index equalt to 0 or 1. In such a case, we ignore the import
             // statement
                if (index >= 2) {
                    String packageName = qualifiedName.substring(0, index - 1);
                    String className = qualifiedName.substring(index);
//                    System.out.println("- imported class package name=" + packageName);
//                    System.out.println("  imported class name=" + className);
                    classToPackages.put(className, packageName);
                }
            } // If matcher finds nothing: import statement is erroneous
        } else {
         // There is a star so qualified name represents a package name
            String packageName = qualifiedName;
            fullImportedPackages.add(packageName);
        }
//        System.out.println("SuperClassFinder:exitImportDeclaration(ImportDeclarationContext) : end");
    }
    

    @Override
    public void exitClassOrInterfaceModifier(ClassOrInterfaceModifierContext ctx) {
//        System.out.println("SuperClassFinder:exitClassOrInterfaceModifier(ClassOrInterfaceModifierContext) : begin");
        TerminalNode publicTN = ctx.PUBLIC();
        publicType = publicTN != null;
//        System.out.println("- is it a public type? " + publicType);
//        System.out.println("SuperClassFinder:exitClassOrInterfaceModifier(ClassOrInterfaceModifierContext) : end");
    }
    

    @Override
    public void exitClassDeclaration(ClassDeclarationContext ctx) {
//        System.out.println("SuperClassFinder:exitClassDeclaration(ClassDeclarationContext) : begin");
        TerminalNode classTN = ctx.CLASS();
     // We look for a class
        if (classTN != null) {
            simpleClassName = ctx.IDENTIFIER().getSymbol().getText();
//            System.out.println("- parsed type is a class!");
//            System.out.println("  and its name is :" + simpleClassName);

         // We recover the eventual inherited class name (qualified or not)
            TypeTypeContext ttc = ctx.typeType();
            if (ttc != null) {
//                System.out.println("- parsed type has a superclass!");
                ClassOrInterfaceTypeContext coitc = ttc.classOrInterfaceType();
                List<TerminalNode> classIdentifiers = coitc.IDENTIFIER();
             // We build the potentially qualified inherited class name
                StringBuilder className = new StringBuilder();
                Iterator<TerminalNode> cIIt = classIdentifiers.iterator();
                TerminalNode classIdentifierTN;
                while (cIIt.hasNext()) {
                    classIdentifierTN = cIIt.next();
                    if (!className.toString().equals(""))
                        className.append(".");
                    className.append(classIdentifierTN.getSymbol().getText());
                }
             // We determine if the recovered name of inherited class is qualified
             // or not
                String qualifiedClassName = className.toString();
//                System.out.println("  qualified superclass name=" + qualifiedClassName);
                String superClassPackageName, superClassName;
                int index = qualifiedClassName.lastIndexOf(".");
                if (index == -1) {
                 // No dot has been found so it means that our class name is not
                 // qualified
                    superClassName = qualifiedClassName;
                 // The package of the super class must be defined in an import
                 // clauses or it is in the same package as current class
                    superClassPackageName = classToPackages.get(superClassName);
                    if (superClassPackageName == null) {
                     // Super class is not defined in a non stared import statement
                     // Currently we do not take into account stared imports
                       
                     // So the last possibility is that the package of super class
                     // is the package of the current class
                        superClassPackageName = currentPackageName;
                    }
                } else {
                 // We have found a dot so it means our class name is qualified
                    superClassPackageName =
                                         qualifiedClassName.substring(0, index);
                    superClassName = qualifiedClassName.substring(index + 1);
                }
                superClass = new JavaSourceClass(superClassPackageName,
                                                 superClassName       );
            }
            
         // Now we manage the interface implementations
            TypeListContext tlc = ctx.typeList();
            if (tlc != null) {
                List<TypeTypeContext> typeTypes = tlc.typeType();
                Iterator<TypeTypeContext> ttcIt = typeTypes.iterator();
                while (ttcIt.hasNext()) {
                    ttc = ttcIt.next();
                    if (ttc != null) {
//                        System.out.println("- parsed type implements an interface!");
                        ClassOrInterfaceTypeContext coitc = ttc.classOrInterfaceType();
                        List<TerminalNode> classIdentifiers = coitc.IDENTIFIER();
                     // We build the potentially qualified implemented interface name
                        StringBuilder qualifiedClassNameBuilder = new StringBuilder();
                        Iterator<TerminalNode> cIIt = classIdentifiers.iterator();
                        TerminalNode classIdentifierTN;
                        while (cIIt.hasNext()) {
                            classIdentifierTN = cIIt.next();
                            if (!qualifiedClassNameBuilder.toString().equals(""))
                                qualifiedClassNameBuilder.append(".");
                            qualifiedClassNameBuilder.append(classIdentifierTN.getSymbol().getText());
                        }
                        String qualifiedClassName = qualifiedClassNameBuilder.toString();
//                        System.out.println("  its name is " + qualifiedClassName);
                     // We extract its package name
                        Matcher matcher = PATTERN.matcher(qualifiedClassName);
                        if (matcher.find()) {
                            int index = matcher.start();
                            String packageName;
                            String className;
                         // Only two cases must be managed:
                         // - index == 0 : no package specified,
                         // - index >= 2 : a package is specified
                         // if index == 1 then the implements clause is erroneous
                         // so we skip it.
                            if (index == 0) {
                             // class name does not contain a package name
                                className = qualifiedClassName;
                             // package name is not defined in the implements
                             // clause. So we look for an import statement
                             // for that class
                                packageName = classToPackages.get(className);
                             // If our interface is not imported then it must be
                             // in current package
                                JavaSourceClass jsc;
                                if (packageName == null) {
                                 // Current class may have or may not have a
                                 // package!
                                 // It is not forbidden even if not recommended
                                 // So currentPackageName may be null but it is
                                 // allowed by JavaSourceClass
                                    packageName = currentPackageName;
                                }
                                jsc = new JavaSourceClass
                                                (packageName,
                                                 className  );
//                                System.out.println("- implementyed class package name=" + packageName);
//                                System.out.println("  implemented class name=" + className);
                                implementedInterfaces.add(jsc);
                            } else if (index >= 2) {
                                packageName = qualifiedClassName.substring(0, index - 1);
                                className = qualifiedClassName.substring(index);
//                                System.out.println("- implementyed class package name=" + packageName);
//                                System.out.println("  implemented class name=" + className);
                                JavaSourceClass jsc = new JavaSourceClass
                                                (packageName,
                                                 className  );
                                implementedInterfaces.add(jsc);
                            }
                        }
                    }
                }
            }
        }
//        System.out.println("SuperClassFinder:exitClassDeclaration(ClassDeclarationContext) : end");
    }
}