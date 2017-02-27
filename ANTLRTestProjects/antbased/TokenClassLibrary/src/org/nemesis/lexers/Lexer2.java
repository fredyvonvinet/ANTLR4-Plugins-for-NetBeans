package org.nemesis.lexers;

import java.util.Collection;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.LexerInterpreter;
import org.antlr.v4.runtime.atn.ATN;

/**
 *
 * @author Frédéric Yvon Vinet
 */
public class Lexer2 extends LexerInterpreter {
    public Lexer2
        (String             grammarFileName,
         Collection<String> tokenNames     ,
         Collection<String> ruleNames      ,
         Collection<String> modeNames      ,
         ATN                atn            ,
         CharStream         input          ) {
        super(grammarFileName, tokenNames, ruleNames, modeNames, atn, input);
    }
}
