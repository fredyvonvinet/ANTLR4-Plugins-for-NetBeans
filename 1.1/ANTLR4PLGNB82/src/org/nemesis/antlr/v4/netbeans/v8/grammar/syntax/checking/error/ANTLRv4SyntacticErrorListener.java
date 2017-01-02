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
package org.nemesis.antlr.v4.netbeans.v8.grammar.syntax.checking.error;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.nemesis.antlr.v4.netbeans.v8.generic.parsing.ParsingError;
import org.nemesis.antlr.v4.netbeans.v8.grammar.syntax.checking.impl.ANTLRv4Parser;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.IntervalSet;

import org.netbeans.modules.csl.api.Severity;

import org.openide.filesystems.FileObject;

/**
 *
 * @author Frédéric Yvon Vinet
 */
public class ANTLRv4SyntacticErrorListener extends BaseErrorListener {
    private final List<ParsingError> parsingErrors;
    private final FileObject         objectToBeParsed;
    
    public boolean encounteredError() {
        return getErrorNumber() != 0;
    }
    public int getErrorNumber() {
        return parsingErrors.size();
    }
    public List<ParsingError> getParsingError() {
        return parsingErrors;
    }
    
    public ANTLRv4SyntacticErrorListener(FileObject objectToBeParsed) {
        this.parsingErrors = new ArrayList<>();
        this.objectToBeParsed = objectToBeParsed;
    }
    
    @Override
    public void syntaxError
        (Recognizer<?, ?>     recognizer        ,
         Object               offendingSymbol   ,
         int                  line              ,
         int                  charPositionInLine,
         String               msg               ,
         RecognitionException e                 ) {
     // We build the error key from the rule stack
        ANTLRv4Parser parser = (ANTLRv4Parser) recognizer;
        List<String> stack = parser.getRuleInvocationStack();
        Collections.reverse(stack);
        StringBuilder ruleStack = new StringBuilder("antlr.grammar.error.syntax");
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
        
        ParsingError parsingError = new ParsingError
            (objectToBeParsed      ,
             Severity.ERROR        ,
             key                   ,
             index                 ,
             displayName.toString(),
             description.toString());
        parsingErrors.add(parsingError);
    }
}