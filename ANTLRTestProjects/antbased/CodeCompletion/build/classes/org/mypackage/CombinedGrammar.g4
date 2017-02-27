/******************************************************
 * A multi-line Javadoc-like comment about my grammar *
 ******************************************************/
grammar CombinedGrammar;

import ParserGrammar;

tokens { TOK }

options { tokenVocab=LexerGrammar; }

// channels { CHANNEL4 }

/* ANTLR test if a parser rule id is already used locally but it does not test
   if a parser rule id is already used by an imported parser rule!!!! */
rule4 :
// ANTLR does not test if all element labals of an alternative are different
    eltLabel1=rule1 ID+ INT eltLabel2=TOK ILG_1_TOKEN_4 (eltLabel3=FRAGMENT? rule2+) #altLabel1 |
    eltLabel1=rule2 #altLabel2 | // ANTLR does not test if alternatives of the same rule
                                 // have different ids. It leads to a strange error at 
                                 // Java compilation time!!!
    eltLabel1=rule5 #altLabel3
    ;

rule5 :
    eltLabel1=rule2 #altLabel4 |
    eltLabel1=rule1 #altLabel5
    ;

// some lexer rules
ID : [a-zA-Z]+  FRAGMENT ; // match identifiers
INT : [0-9]+ ; // match integers
NEWLINE: '\r'? '\n' ; // return newlines to parser

//mode ModeB;

fragment FRAGMENT : [a-z]  ;