package org.nemesis.lexers;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.atn.ATN;

/**
 *
 * @author Frédéric Yvon Vinet
 */
public class Lexer1 extends Lexer {
    public Lexer1(CharStream cs) {
        super(cs);
    }
    
    @Override
    public String[] getRuleNames() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getGrammarFileName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ATN getATN() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}