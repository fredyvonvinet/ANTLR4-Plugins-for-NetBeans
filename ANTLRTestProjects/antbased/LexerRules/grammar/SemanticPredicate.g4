lexer grammar SemanticPredicate;

// semantic predicates are processed as actions by colored syntax edition
ENUM:
    [a-z]+ {getText().equals("enum")}?
    {System.out.println("enum!");}
    ;