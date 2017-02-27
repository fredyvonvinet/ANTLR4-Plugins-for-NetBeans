lexer grammar JavaLexer;

import LexBasic;


@lexer::members {
protected int initialStackedModeNumber = -1; // -1 means undefined value
}

// For syntax checking purpose we skip block comments
BLOCK_COMMENT :
    BlockComment -> skip
    ;

// For syntax checking purpose we skip line comments
LINE_COMMENT :
    LineComment -> skip
    ;

AT :
    '@' -> pushMode(AnnotationUse)
    ;

LPAREN :
    '('
    ;

RPAREN :
    ')'
    ;

SUPER :
    'super'
    ;

PACKAGE :
    'package'
    ;

IMPORT :
    'import'
    ;

DOT :
    '.'
    ;

STAR :
    '*'
    ;

SEMI :
    ';'
    ;

PUBLIC :
    'public'
    ;

PROTECTED :
    'protected'
    ;

PRIVATE :
    'private'
    ;

STATIC :
    'static'
    ;

FINAL :
    'final'
    ;

ABSTRACT :
    'abstract'
    ;

STRICTFP :
    'strictfp'
    ;

CLASS :
    'class'
    {
     initialStackedModeNumber = _modeStack.size();
     pushMode(TypeDeclaration);
    }
    ;

INTERFACE :
    'interface' -> pushMode(TypeDeclaration)
    ;

ENUM :
    'enum' -> pushMode(TypeDeclaration)
    ;

EXTENDS :
    'extends'
    ;

IMPLEMENTS :
    'implements'
    ;

LBRACE:
    '{'
    ;

RBRACE:
    '}'
    ;

QUESTION :
    '?'
    ;

BIN_AND :
    '&'
    ;

LT :
    '<'
    ;

GT :
    '>'
    ;

LBRACKET :
    '['
    ;

RBRACKET :
    ']'
    ;

COMMA :
    ','
    ;

IDENTIFIER :
    JavaLetter JavaLetterOrDigit*
    ;

// Whitespace
WS :
    Ws+ -> skip
    ;


fragment JavaLetter :
    [a-zA-Z$_]                      | // these are the "java letters" below 0x7F
    ~[\u0000-\u007F\uD800-\uDBFF]   | // covers all characters above 0x7F which are not a surrogate
    [\uD800-\uDBFF] [\uDC00-\uDFFF]   // covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
    ;

fragment JavaLetterOrDigit :
    [a-zA-Z0-9$_]                  | // these are the "java letters or digits" below 0x7F
    ~[\u0000-\u007F\uD800-\uDBFF]  | // covers all characters above 0x7F which are not a surrogate
    [\uD800-\uDBFF] [\uDC00-\uDFFF]  // covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
    ;



/*************************************
 * mode for managing annotation uses *
 *************************************/
mode AnnotationUse;

// For syntax checking purpose we skip block comments
AU_BLOCK_COMMENT :
    BlockComment -> skip
    ;

// For syntax checking purpose we skip line comments
AU_LINE_COMMENT :
    LineComment -> skip
    ;

AU_INTERFACE :
    'interface' -> type(INTERFACE), popMode // in fact we are not in an annotation
    ;                                       // use but in annotation declaration

AU_DOT :
    '.' -> type(DOT)
    ;

AU_IDENTIFIER :
    JavaLetter JavaLetterOrDigit* -> type(IDENTIFIER)
    ;

AU_LPAREN :
    '('
    {
     setType(LPAREN);
     initialStackedModeNumber = _modeStack.size();
     pushMode(AnnotationUseParameters);
    }
    ;

// Whitespace
AU_WS :
    Ws+ -> skip
    ;

AU_UNTERMINATED :
    EOF -> popMode
    ;


/***********************************************
 * mode for managing annotation use parameters *
 ***********************************************/
mode AnnotationUseParameters;
// For syntax checking purpose we skip block comments
AUP_BLOCK_COMMENT :
    BlockComment -> skip
    ;

// For syntax checking purpose we skip line comments
AUP_LINE_COMMENT :
    LineComment -> skip
    ;

AUP_NESTED :
    '(' -> more, pushMode(AnnotationUseParameters)
    ;

AUP_END :
    ')'
    {
     int mode = popMode();
//     System.out.println("AUP_END: _modeStack.size()=" + _modeStack.size());
//     System.out.println("AUP_END: initialStackedModeNumber=" + initialStackedModeNumber);
     if (_modeStack.size() > initialStackedModeNumber) {
        more();
     } else {
        setType(RPAREN);
        initialStackedModeNumber = -1;
     }
    }
    ;

AUP_UNTERMINATED :
    EOF -> popMode
    ;

AUP_PARAMETERS :
    ~[()]+
    ;


/**************************************
 * mode for managing type declaration *
 **************************************/
mode TypeDeclaration;

// For syntax checking purpose we skip block comments
TD_BLOCK_COMMENT :
    BlockComment -> skip
    ;

// For syntax checking purpose we skip line comments
TD_LINE_COMMENT :
    LineComment -> skip
    ;

TD_EXTENDS :
    'extends' -> type(EXTENDS)
    ;

TD_IMPLEMENTS :
    'implements' -> type(IMPLEMENTS)
    ;

TD_DOT :
    '.' -> type(DOT)
    ;

TD_COMMA :
    ',' -> type(COMMA)
    ;

TD_LT :
    '<' -> type(LT)
    ;

TD_GT :
    '>' -> type(GT)
    ;

TD_BODY_START:
    '{'
    {
     setType(LBRACE);
     initialStackedModeNumber = _modeStack.size();
     pushMode(Body);
//     System.out.println("- TD_BODY_START : We are now in mode Body");
    }
    ;

TD_IDENTIFIER :
    JavaLetter JavaLetterOrDigit* -> type(IDENTIFIER)
    ;

// Whitespace
TD_WS :
    Ws+ -> skip
    ;

TD_UNTERMINATED :
    EOF -> popMode
    ;


/***********************************************
 * mode for managing body of type declarations *
 ***********************************************/
mode Body;
BODY_INTERNAL:
    '{'
    {
     more();
     pushMode(Body);
//     System.out.println("- BODY_INTERNAL : We are now in mode Body");
    }
    ;

BODY_END :
    '}'
    {
     int mode = popMode(); // for exiting from current Body mode ()
//     System.out.println("- BODY_END: we are now in mode " + modeNames[mode]);
//     System.out.println("  BODY_END: _modeStack.size()=" + _modeStack.size());
//     System.out.println("  BODY_END: initialStackedModeNumber=" + initialStackedModeNumber);
     if (_modeStack.size() > initialStackedModeNumber) {
        more();
     } else {
        setType(RBRACE);
        initialStackedModeNumber = -1;
        mode = popMode();     // for exiting TypeDeclaration mode
     }
    }
    ;

BODY_UNTERMINATED :
    EOF -> popMode, popMode
    ;

BODY :
    ~[{}]+
    ;