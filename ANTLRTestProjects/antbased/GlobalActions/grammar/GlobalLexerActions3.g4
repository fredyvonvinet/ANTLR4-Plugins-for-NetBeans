lexer grammar GlobalLexerActions3;

/*
 *
 */
@parser::header {
/**
 * this is a Javadoc comment that will be added in the header of Java generated
 * class.
 */
}

@parser::members {
protected int anAttributeAddedToParser = 0;

public int getAnAttributeAddedToParser() {
    return anAttributeAddedToParser;
}
}

T : 'a'; // a foo token declaration in order to generate code without error