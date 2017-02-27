grammar ParserRuleOptions;

/*
 * There is no options allowed for parser rules
 * but ANTLR syntax allow to add some in future
 */
interpreterRule options { // a line comment
/*
 * No valid option is accepted in a parser rule options block
 */

} : 'a';
