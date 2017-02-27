parser grammar GlobalParserActions2;

options { tokenVocab=GlobalLexerActions1; }

@header {
/**
 * this is a Javadoc comment that will be added in the header of Java generated
 * class.
 */
}


@members {
protected int anAttributeAddedToParser = 0;

public int getAnAttributeAddedToParser() {
    return anAttributeAddedToParser;
}
}

rule1 : T;