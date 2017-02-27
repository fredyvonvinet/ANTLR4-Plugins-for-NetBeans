grammar ParserRuleElementAssocOption;

expr :
    expr '^'<assoc=right> expr // ^ operator is right associative
    | INT
    ;

INT : '0'..'9'+ ;
WS : [ \n]+ -> skip ;