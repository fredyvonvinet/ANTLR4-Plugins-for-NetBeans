lexer grammar ImportedLexerGrammar2;

tokens { IMPORTED_TOKEN_1_2 }

// some lexer rules
IMPORTED_TOKEN_2_2 : [a-zA-Z]+ ; // match identifiers
IMPORTED_TOKEN_3_2 : [0-9]+ ; // match integers
IMPORTED_TOKEN_4_2 :'\r'? '\n' ; // return newlines to parser