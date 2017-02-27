lexer grammar TokenDeclarations;

tokens { EOF1 }

ID1 : [a-z]; // match identifiers 
ID2 : [0-9]+; // match integers
ID3 : [A-Z]*;
ID4 : ~[A-Z]*?;
NEWLINE:'\r'? '\n'; // return newlines to parser
EOF2 : EOF; // EOF is a reserved token id