grammar RuleExceptionManagement;

parserRule1 :
    'foo'
    ;
catch[FailedPredicateException fpe] { }
catch[RecognitionException e] { }
finally {System.out.println("exit rule rule1");}