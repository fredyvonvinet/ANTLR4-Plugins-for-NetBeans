grammar ReturnsLabels;

@header {
package tools;
import java.util.*;
}

@parser::members {
    /** "memory" for our calculator; variable/value pairs go here */
    Map<String, Integer> memory = new HashMap<String, Integer>();

    int eval(int left, int op, int right) {
        switch ( op ) {
            case MUL : return left * right;
            case DIV : return left / right;
            case ADD : return left + right;
            case SUB : return left - right;
        }
        return 0;
    }
}

e returns [int v]:
    a=e op=('*'|'/') b=e {$v = eval($a.v, $op.type, $b.v);}
    | a=e op=('+'|'-') b=e {$v = eval($a.v, $op.type, $b.v);}
    | INT {$v = $INT.int;}
    | ID
    {
     String id = $ID.text;
     $v = memory.containsKey(id) ? memory.get(id) : 0;
    }
    | '(' e ')' {$v = $e.v;}
    ;

MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;

ID  :   [a-zA-Z]+ ;      // match identifiers
INT :   [0-9]+ ;         // match integers