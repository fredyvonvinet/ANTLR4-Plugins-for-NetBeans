lexer grammar TokensFileLexer;

import LexBasic;

TOKEN_ID : NameStartChar NameChar*;

TOKEN_LITERAL : SQuoteLiteral;

TOKEN_VALUE : DecimalNumeral;

EQUAL : Equal;

WS : Ws+
    {
     getText();
    };

// If no rule above the current rulehas been activated then we have a lexer error
ERROR : .;
