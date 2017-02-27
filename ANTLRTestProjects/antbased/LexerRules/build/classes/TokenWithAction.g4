lexer grammar TokenWithAction;

tokens { T }

ID :
    'azerty'
    {
     setType(T);
    }
    ;