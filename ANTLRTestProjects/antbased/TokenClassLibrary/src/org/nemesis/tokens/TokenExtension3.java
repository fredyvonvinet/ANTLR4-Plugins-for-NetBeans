package org.nemesis.tokens;

import org.antlr.v4.runtime.tree.pattern.RuleTagToken;

/**
 * This class is just used for checking that token Java class are correctly found
 * by code completion when code completion is asked for option TokenLabelType.
 * Here that class is included in a library and searched in that library.
 * 
 * @author Frédéric Yvon Vinet
 */
public class TokenExtension3 extends RuleTagToken {

    public TokenExtension3(String ruleName, int bypassTokenType) {
        super(ruleName, bypassTokenType);
    }
    
}
