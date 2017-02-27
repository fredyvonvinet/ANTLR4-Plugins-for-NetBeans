lexer grammar GrammarWithTokens;

/*
 * a block comment
 */
tokens { // line comment
    TOKEN1, // line comment
    TOKEN2 // line comment
//  , token3 // previous declaration must lead to an error message
} // line comment

T : 'a' -> type(TOKEN1); // the token provided in type must exist

/****************************************************************************
 * In ANTLR 4.6, a fragment id must begin by an uppercase character.        *
 * In 4.5.3, it was not mandatory: it could begin by a lowercase character. *
 ****************************************************************************/
fragment F1: 'a';