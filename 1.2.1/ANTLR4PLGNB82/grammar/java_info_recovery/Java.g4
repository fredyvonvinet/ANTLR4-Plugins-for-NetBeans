/*
 [The "BSD licence"]
 Copyright (c) 2013 Terence Parr, Sam Harwell
 All rights reserved.
 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the
    documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
    derived from this software without specific prior written permission.
 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

/** A Java 1.7 grammar for ANTLR v4 derived from ANTLR v3 Java grammar.
 *  Uses ANTLR v4's left-recursive expression notation.
 *  It parses ECJ, Netbeans, JDK etc...
 *
 *  Sam Harwell cleaned this up significantly and updated to 1.7!
 *
 *  You can test with
 *
 *  $ antlr4 Java.g4
 *  $ javac *.java
 *  $ grun Java compilationUnit *.java
 */
grammar Java;


options { tokenVocab = JavaLexer; }

// starting point for parsing a java file
compilationUnit :
    packageDeclaration?
    importDeclaration*
    typeDeclaration*
    EOF
    ;



packageDeclaration :
    annotation*
    PACKAGE qualifiedName SEMI
    ;

annotation :
    AT annotationName ( LPAREN AUP_PARAMETERS* RPAREN )?
    ;

annotationName :
    qualifiedName
    ;

qualifiedName :
    IDENTIFIER (DOT IDENTIFIER)*
    ;



importDeclaration :
    IMPORT STATIC? qualifiedName (DOT STAR)? SEMI
    ;



typeDeclaration :
    classOrInterfaceModifier* classDeclaration          |
    classOrInterfaceModifier* enumDeclaration           |
    classOrInterfaceModifier* interfaceDeclaration      |
    classOrInterfaceModifier* annotationTypeDeclaration |
    SEMI
    ;



classOrInterfaceModifier :
    annotation  | // class or interface
    ( PUBLIC    | // class or interface
      PROTECTED | // class or interface
      PRIVATE   | // class or interface
      STATIC    | // class or interface
      ABSTRACT  | // class or interface
      FINAL     | // class only -- does not apply to interfaces
      STRICTFP  ) // class or interface
    ;

classDeclaration :
    CLASS IDENTIFIER typeParameters?
    (EXTENDS typeType)?
    (IMPLEMENTS typeList)?
    body
    ;

typeParameters :
    LT typeParameter (COMMA typeParameter)* GT
    ;

typeParameter :
    IDENTIFIER (EXTENDS typeBound)?
    ;

typeBound :
    typeType (BIN_AND typeType)*
    ;

typeType :
    classOrInterfaceType (LBRACKET RBRACKET)*
    ;

classOrInterfaceType :
    IDENTIFIER typeArguments? (DOT IDENTIFIER typeArguments? )*
    ;



typeArguments :
    LT typeArgument (COMMA typeArgument)* GT
    ;

typeArgument :
    typeType |
    QUESTION ((EXTENDS | SUPER) typeType)?
    ;

typeList :
    typeType (COMMA typeType)*
    ;

body :
    LBRACE
    BODY*
    RBRACE
    ;



enumDeclaration :
    ENUM IDENTIFIER (IMPLEMENTS typeList)?
    body
    ;



interfaceDeclaration :
    INTERFACE IDENTIFIER typeParameters? (EXTENDS typeList)?
    body
    ;



annotationTypeDeclaration :
    AT INTERFACE IDENTIFIER
    body
    ;