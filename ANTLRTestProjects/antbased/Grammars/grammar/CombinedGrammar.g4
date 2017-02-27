/******************************************************
 * A multi-line Javadoc-like comment about my grammar *
 ******************************************************/
/*
 block comment
*/
grammar CombinedGrammar; // line comment

import ParserGrammar; // line comment
// Next statement must lead to an error message
// import ImportedCombinedGrammar;
/*
 block comment
*/
// import ImportedLexerGrammar; // Previous import must lead to an error message

options { tokenVocab=LexerGrammar; }


localRule : importedRule2;