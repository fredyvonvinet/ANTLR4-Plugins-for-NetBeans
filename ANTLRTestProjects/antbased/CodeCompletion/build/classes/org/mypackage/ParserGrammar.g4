/******************************************************
 * A multi-line Javadoc-like comment about my grammar *
 ******************************************************/
parser grammar ParserGrammar;

options { tokenVocab=LexerGrammar; }

tokens { PG_TOKEN }

rule1 : gr1=LG_TOKEN_1* gr2=rule2;

rule2 : ILG_1_TOKEN_3+ PG_TOKEN ;

rule3 : 'azerty';