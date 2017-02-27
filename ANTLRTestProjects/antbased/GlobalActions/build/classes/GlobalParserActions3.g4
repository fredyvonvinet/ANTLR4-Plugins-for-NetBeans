parser grammar GlobalParserActions3;

options { tokenVocab=GlobalLexerActions1; }

/*
 Next declaration is allowed by ANTLR 4.5.3 and 4.6!
 Obviously, it should not be the case because we are in a parser grammar: no
 lexer will be generated!
*/
@lexer::header {
/**
 * this is a Javadoc comment that will be added in the header of Java generated
 * class.
 */
}

/*
 Next declaration is allowed by ANTLR 4.5.3 and 4.6!
 Obviously, it should not be the case because we are in a parser grammar: no
 lexer will be generated!
*/
@lexer::members {
protected int anAttributeAddedToLexer = 0;

public int getAnAttributeAddedToLexer() {
    return anAttributeAddedToLexer;
}
}

rule1 : T;