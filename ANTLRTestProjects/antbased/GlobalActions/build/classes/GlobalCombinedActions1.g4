grammar GlobalCombinedActions1;

tokens { T }

/*
 A combined grammar with at least one lexer rule generates:
 - a lexer,
 - a lexer token file
 - a parser,
 - a parser token file.
 So we can add a header and members to parser and lexer

 A combined grammar without lexer rule generates only :
 - a parser,
 - a parser token file.
*/
@parser::header {
/**
 * this is a Javadoc comment that will be added in the header of Java generated
 * parser class.
 */
}


@parser::members {
protected int anAttributeAddedToParser = 0;

public int getAnAttributeAddedToParser() {
    return anAttributeAddedToParser;
}
}

@lexer::header {
/**
 * this is a Javadoc comment that will be added in the header of Java generated
 * lexer class.
 */
}

@lexer::members {
protected int anAttributeAddedToLexer = 0;

public int getAnAttributeAddedToLexer() {
    return anAttributeAddedToLexer;
}
}

rule1 : T;

T2 : 'b';