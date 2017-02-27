grammar AllPossibleOptionsWithinAPackage1;

/*
 Next Java import statement are parsed for hyperlinks
*/
@header {
package myorg.mypackage;
import anotherorg.anotherpackage.MySuperClass2;
import anotherorg.anotherpackage.MyToken2;
}

/*
 block comment
*/
options
{ // a line comment
 language='Java'; // there is no check for the string value
 // All next hyperlinks must be functional
 superClass=MySuperClass2; // If previous class file does not exist then error messsge
 tokenVocab=MyTokenFile2; // If previous token file does not exist then error messsge
 TokenLabelType=MyToken2; // If previous class file does not exist then error messsge
} // line comment

rule1 : 'a'; // a foo parser rule for enabling to generate code