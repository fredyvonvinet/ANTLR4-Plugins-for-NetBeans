lexer grammar GlobalLexerActions2;

@header {
/**
 * this is a Javadoc comment that will be added in the header of Java generated
 * class.
 */
}

@members {
protected int anAttributeAddedToLexer = 0;

public int getAnAttributeAddedToLexer() {
    return anAttributeAddedToLexer;
}
}

T : 'a'; // a foo token declaration in order to generate code without error