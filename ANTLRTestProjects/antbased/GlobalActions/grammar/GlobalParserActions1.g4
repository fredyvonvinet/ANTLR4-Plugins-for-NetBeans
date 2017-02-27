parser grammar GlobalParserActions1;

options { tokenVocab=GlobalLexerActions1; }

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

rule1 : T;