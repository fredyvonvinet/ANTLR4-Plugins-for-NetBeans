lexer grammar LexerGrammarWithChannels;

/*
 * a block comment
*/
channels { // a line comment
    Channel1, // a line comment
    Channel2 // a line comment
} // a line comment

T : 'a' -> channel(Channel2); // channel provided by channel statement must exist