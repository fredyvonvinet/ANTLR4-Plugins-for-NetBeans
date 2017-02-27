lexer grammar FragmentDeclarations;

fragment ID1 : [a-z]; // match identifiers 
fragment ID2 : [0-9]+; // match integers
fragment ID3 : [A-Z]*;
fragment ID4 : ~[A-Z]*?;
fragment NEWLINE:'\r'? '\n'; // return newlines to parser

T : 'a'; // a lexer grammar without token definition leads to a strange bug in code generation