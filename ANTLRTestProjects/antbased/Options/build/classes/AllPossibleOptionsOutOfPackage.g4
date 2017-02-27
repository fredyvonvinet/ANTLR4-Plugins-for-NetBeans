grammar AllPossibleOptionsOutOfPackage;

/*
 block comment
*/
options 
{ // a line comment
 language='Java'; // there is no check for the string value
 // All next hyperlinks must be functional
 superClass=MySuperClass1; // If previous class file does not exist then error messsge
 tokenVocab=MyTokenFile1; // If previous token file does not exist then error messsge
 TokenLabelType=MyToken1; // If previous class file does not exist then error messsge
} // line comment

rule1 : 'a'; // a foo rule for enabling the grammar to generate code