lexer grammar TokenDeclarationWithLabel;

// Next token declaration must lead to an error message: labels in token 
// definitions are no more supported in ANTLR 4
/*
ID1 :
    a=[a-z]
    b=[A-Z]*
    ;
*/

ID2 : 'a';