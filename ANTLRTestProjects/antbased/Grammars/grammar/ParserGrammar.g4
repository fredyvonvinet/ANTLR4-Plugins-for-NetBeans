/**
 a document coment
*/
/*
 a block comment
*/
parser  // a line comment
grammar  // a line comment
ParserGrammar  // a line comment
;  // a line comment

options { tokenVocab=LexerGrammar; }
// Next import statement must lead to an error message
// import ImportedLexerGrammar;

// Next import statement try to import a grammar that does not exist so it
// must lead to an error message
// import NonExistingGrammar; 

/*
 a block comment
*/
//import  // a line comment
//ImportedParserGrammar  // a line comment
//; // a line comment

importedRule2 : T1;