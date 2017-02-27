lexer grammar ImportedLexerGrammar;

options { tokenVocab = ImportedTokens2; }

tokens { ILG_1_TOKEN_1 }

// some lexer rules
ILG_1_TOKEN_2 : [a-zA-Z]+ ; // match identifiers
ILG_1_TOKEN_3 : [0-9]+ ; // match integers
ILG_1_TOKEN_4 : '\r'? '\n' ; // return newlines to parser

fragment ILG_1_FRAGMENT : 'importedFragment';