package org.nemesis.parsers;

import java.util.Collection;
import org.antlr.v4.runtime.ParserInterpreter;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.atn.ATN;

/**
 *
 * @author Frédéric Yvon Vinet
 */
public class Parser2 extends ParserInterpreter {
    public Parser2
            (String             grammarFileName,
             Collection<String> tokenNames     ,
             Collection<String> ruleNames      ,
             ATN                atn            ,
             TokenStream        input          ) {
        super(grammarFileName, tokenNames, ruleNames, atn, input);
    }
    
}
