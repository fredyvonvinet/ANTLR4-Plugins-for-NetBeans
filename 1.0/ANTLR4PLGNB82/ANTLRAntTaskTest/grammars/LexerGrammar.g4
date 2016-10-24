lexer grammar LexerGrammar;

ID  :   LowerCase IDChar;

fragment LowerCase : [a..z];

fragment UpperCase : [A..Z];

fragment Digit : [0..9];

fragment Underscore : '_';

fragment IDChar :
    LowerCase |
    UpperCase |
    Digit |
    Underscore;

