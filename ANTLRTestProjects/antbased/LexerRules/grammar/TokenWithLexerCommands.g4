lexer grammar TokenWithLexerCommands;

import ImportedLexerGrammar;

channels { MyChannel }

options { tokenVocab = ImportedTokens; }

tokens { ID6 }

ID1 :
    'qwerty'
    -> type(ID2), pushMode(MyMode)
    ;

ID2 :
    'azerty'
    -> skip, mode(MyMode)
    ;

ID3 :
    'itsuken'
    -> more
    ;

mode MyMode;

ID4 : 'serteth' -> type(ID6), channel(MyChannel), popMode;

ID5 : 'id6' -> type(ID8);

ID7 : 'id7' -> type(TOKEN2);