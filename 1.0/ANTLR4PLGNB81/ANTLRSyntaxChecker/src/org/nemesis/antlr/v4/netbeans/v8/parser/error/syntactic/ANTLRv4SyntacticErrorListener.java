/*
BSD License

Copyright (c) 2016, Frédéric Yvon Vinet
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

* Redistributions of source code must retain the above copyright
  notice, this list of conditions and the following disclaimer.
* Redistributions in binary form must reproduce the above copyright
  notice, this list of conditions and the following disclaimer in the
  documentation and/or other materials provided with the distribution.
* The name of its author may not be used to endorse or promote products
  derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY
EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT 
LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF 
LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF 
ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.nemesis.antlr.v4.netbeans.v8.parser.error.syntactic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nemesis.antlr.v4.netbeans.v8.parser.NBANTLRv4ParsingError;
import org.nemesis.antlr.v4.netbeans.v8.parser.impl.ANTLRv4Parser;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.IntervalSet;

import org.netbeans.modules.csl.api.Severity;

/**
 *
 * @author Frédéric Yvon Vinet
 */
public class ANTLRv4SyntacticErrorListener extends BaseErrorListener {
    private static final String[] _SYMBOLIC_NAMES = {
		null, "ID_STARTING_WITH_UPPERCASE", "ID_STARTING_WITH_LOWERCASE", "LEXER_CHAR_SET", 
		"DOC_COMMENT", "BLOCK_COMMENT", "LINE_COMMENT", "INT", "STRING_LITERAL", 
		"UNTERMINATED_STRING_LITERAL", "BEGIN_ARGUMENT", "BEGIN_ACTION", "OPTIONS", 
		"TOKENS", "CHANNELS", "IMPORT", "FRAGMENT", "LEXER", "PARSER", "GRAMMAR", 
		"PROTECTED", "PUBLIC", "PRIVATE", "RETURNS", "LOCALS", "THROWS", "CATCH", 
		"FINALLY", "MODE", "COLON", "COLONCOLON", "COMMA", "SEMI", "LPAREN", "RPAREN", 
		"LBRACE", "RBRACE", "RARROW", "LT", "GT", "ASSIGN", "QUESTION", "STAR", 
		"PLUS_ASSIGN", "PLUS", "OR", "DOLLAR", "RANGE", "DOT", "AT", "SHARP", 
		"NOT", "ID", "WS", "END_ARGUMENT", "UNTERMINATED_ARGUMENT", "ARGUMENT_CONTENT", 
		"END_ACTION", "UNTERMINATED_ACTION", "ACTION_CONTENT", "SUPER_CLASS", 
		"LANGUAGE", "TOKEN_VOCAB", "TOKEN_LABEL_TYPE", "TOK_ID", "UNTERMINATED_CHAR_SET"
	};
        
    private static final Map<Integer,String> DISPLAYED_TOKEN_NAME =
        new HashMap<>();
    static {
        DISPLAYED_TOKEN_NAME.put(ANTLRv4Parser.ID_STARTING_WITH_UPPERCASE, "token identifier");
        DISPLAYED_TOKEN_NAME.put(ANTLRv4Parser.ID_STARTING_WITH_LOWERCASE, "rule identifier");
        DISPLAYED_TOKEN_NAME.put(ANTLRv4Parser.LEXER_CHAR_SET, "rule identifier");
        DISPLAYED_TOKEN_NAME.put(ANTLRv4Parser.DOC_COMMENT, "document comment");
        DISPLAYED_TOKEN_NAME.put(ANTLRv4Parser.BLOCK_COMMENT, "block comment");
        DISPLAYED_TOKEN_NAME.put(ANTLRv4Parser.LINE_COMMENT, "line comment");
        DISPLAYED_TOKEN_NAME.put(ANTLRv4Parser.INT, "integer");
        DISPLAYED_TOKEN_NAME.put(ANTLRv4Parser.STRING_LITERAL, "string literal");
        DISPLAYED_TOKEN_NAME.put(ANTLRv4Parser.BEGIN_ARGUMENT, "argument");
        DISPLAYED_TOKEN_NAME.put(ANTLRv4Parser.BEGIN_ACTION, "action");
        DISPLAYED_TOKEN_NAME.put(ANTLRv4Parser.OPTIONS, "option list declaration");
        DISPLAYED_TOKEN_NAME.put(ANTLRv4Parser.TOKENS, "token list declaration");
        DISPLAYED_TOKEN_NAME.put(ANTLRv4Parser.CHANNELS, "channel list declaration");
        DISPLAYED_TOKEN_NAME.put(ANTLRv4Parser.IMPORT, "grammer import declaration");
        DISPLAYED_TOKEN_NAME.put(ANTLRv4Parser.FRAGMENT, "fragment declaration");
        DISPLAYED_TOKEN_NAME.put(ANTLRv4Parser.LEXER, "lexer keyword");
        DISPLAYED_TOKEN_NAME.put(ANTLRv4Parser.PARSER, "parser keyword");
        DISPLAYED_TOKEN_NAME.put(ANTLRv4Parser.GRAMMAR, "grammar declaration");
    }
    
    private final List<NBANTLRv4ParsingError> parsingErrors;
    
    public boolean encounteredError() {
        return getErrorNumber() != 0;
    }
    public int getErrorNumber() {
        return parsingErrors.size();
    }
    public List<NBANTLRv4ParsingError> getParsingError() {
        return parsingErrors;
    }
    
    public ANTLRv4SyntacticErrorListener() {
        this.parsingErrors = new ArrayList<>();
    }
    
    @Override
    public void syntaxError
        (Recognizer<?, ?>     recognizer        ,
         Object               offendingSymbol   ,
         int                  line              ,
         int                  charPositionInLine,
         String               msg               ,
         RecognitionException e                 ) {
        ANTLRv4Parser parser = (ANTLRv4Parser) recognizer;
        String grammarFileName = parser.getGrammarFileName();
        
     // We build the error key from the rule stack
        List<String> stack = parser.getRuleInvocationStack();
        Collections.reverse(stack);
        StringBuilder ruleStack = new StringBuilder("antlr.error.syntax");
        for (String rule : stack) {
            ruleStack.append(".");
            ruleStack.append(rule);
        }
        
     // ... and we add the offending token
        CommonToken offendingToken = (CommonToken) offendingSymbol;
        
     // We need to recover the position of the offending symbol rather than
     // the error in the char stream
        int index = offendingToken.getStartIndex();
        
        String TokenValue = offendingToken.getText();
        ruleStack.append(".unexpected.");
        ruleStack.append(TokenValue);
        String key = ruleStack.toString();

        StringBuilder displayName = new StringBuilder("at position ");
        displayName.append(line);
        displayName.append(":");
        displayName.append(charPositionInLine + 1);
        displayName.append(" unexpected symbol '");
        displayName.append(TokenValue);
        displayName.append("'");
        
        StringBuilder description = new StringBuilder(displayName);
/*
     // We recover the list of expected tokens
        IntervalSet tis = parser.getExpectedTokens();
        List<Integer> tokenIds = tis.toList();
        for (Integer tokenId : tokenIds) {
            DISPLAYED_TOKEN_NAME.get(tokenId);
        }
*/
        if (e != null) {
            IntervalSet expectedTokens = e.getExpectedTokens();
            String hint = expectedTokens.toString(parser.getVocabulary());
            description.append('\n');
            description.append(hint);
        }
        
        NBANTLRv4ParsingError parsingError = new NBANTLRv4ParsingError
            (grammarFileName       ,
             Severity.ERROR        ,
             key                   ,
             index                 ,
             displayName.toString(),
             description.toString());
        parsingErrors.add(parsingError);
    }
}
