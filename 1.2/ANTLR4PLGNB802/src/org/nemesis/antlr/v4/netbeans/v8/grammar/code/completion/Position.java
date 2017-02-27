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
package org.nemesis.antlr.v4.netbeans.v8.grammar.code.completion;

import javax.swing.text.Document;

import org.nemesis.antlr.v4.netbeans.v8.grammar.code.coloring.ANTLRv4LanguageHierarchy;
import org.nemesis.antlr.v4.netbeans.v8.grammar.code.coloring.ANTLRv4TokenId;
import org.nemesis.antlr.v4.netbeans.v8.grammar.code.coloring.impl.ANTLRv4Lexer;

import org.netbeans.api.lexer.Token;
import org.netbeans.api.lexer.TokenHierarchy;
import org.netbeans.api.lexer.TokenSequence;

/**
 *
 * @author Frédéric Yvon Vinet
 */
public class Position {
    public enum PositionType {
        NO_TOKEN_AT_ALL,
        BEFORE_FIRST_TOKEN,
        ON_A_TOKEN,
        BETWEEN_TWO_TOKENS,
        AFTER_LAST_TOKEN,
        UNDEFINED
    };
    
    protected PositionType positionType;
 // if positionType == NO_TOKEN_AT_ALL tokenIndex=-1
 // if positionType == BEFORE_FIRST_TOKEN tokenIndex=-1
 // if positionType == ON_A_TOKEN represents the token on which caret is located
 // if positionType == BETWEEN_TWO_TOKENS represents the token located before caret
 // if positionType == AFTER_LAST_TOKEN represents the token located before caret
    protected int          tokenIndex;
    

    public PositionType getPositionType() {
        return positionType;
    }

    public int getTokenIndex() {
        return tokenIndex;
    }
    
    
    public Position(PositionType positionType, int tokenIndex) {
        this.positionType = positionType;
         switch(positionType) {
             case NO_TOKEN_AT_ALL:
             case BEFORE_FIRST_TOKEN:
                 this.tokenIndex = -1;
                 break;
             case ON_A_TOKEN:
             case BETWEEN_TWO_TOKENS:
             case AFTER_LAST_TOKEN:
                 this.tokenIndex = tokenIndex;
                 break;
             default:
         }
    }
    
    @Override
    public String toString() {
        String answer;
        switch (positionType) {
            case NO_TOKEN_AT_ALL:
                answer = "no token";
                break;
            case BEFORE_FIRST_TOKEN:
                answer = "before first token";
                break;
            case ON_A_TOKEN:
                answer = "on token of index " + tokenIndex;
                break;
            case BETWEEN_TWO_TOKENS:
                answer = "between token of index " + tokenIndex + " and token of index " + (tokenIndex + 1);
                break;
            case AFTER_LAST_TOKEN:
                answer = "after last token of index " + tokenIndex;
                break;
            case UNDEFINED:
                answer = "undefined";
                break;
            default:
                answer = "";
        }
        return answer;
    }
    
    
 /**
  * Converts an offset in a token position. See class Position.
  * 
  * @param offset
  * @return 
  */
    public static Position getPositionInTokenStream
            (int offset, TokenHierarchy<Document> tokenHierarchy) {
//        System.out.println("Position:getPositionInTokenStream(int) -> Position : begin");
        TokenSequence<ANTLRv4TokenId> tokens =
           tokenHierarchy.tokenSequence(ANTLRv4LanguageHierarchy.getLanguage());
        int index = -1;
        PositionType positionType = PositionType.UNDEFINED;
        if (tokens.isEmpty()) {
            positionType = PositionType.NO_TOKEN_AT_ALL;
            index = -1;
        } else {
            boolean end = false;
            tokens.moveStart();
//            System.out.println("- caret offset=" + offset);
//            System.out.println("- We scan tokens:");
            while (tokens.moveNext() && !end) {
                Token<ANTLRv4TokenId> token = tokens.token();
                int startOffset = token.offset(tokenHierarchy);
                int stopOffset = startOffset + token.length();
                
//                System.out.println("  - token start offset=" + startOffset);
//                System.out.println("    token stop offset=" + stopOffset);
//                System.out.println("    token name=" + token.id().name());
//                System.out.println("    token type value=" + token.id().ordinal());
//                System.out.println("    token primary category=" + token.id().primaryCategory());
//                System.out.println("    token text='" + token.text() + "'");

                int tokenType = token.id().ordinal();
             // ws is the only completely ignored token
                if (tokenType != ANTLRv4Lexer.WS) {
                 // line comment and block comment are not transmitted to parser
                 // so we just have to manage index differently but if we are
                 // on such tokens; we have to define position as such
                    if (tokenType != ANTLRv4Lexer.LINE_COMMENT &&
                        tokenType != ANTLRv4Lexer.BLOCK_COMMENT  ) {
                     // Here, our token is not a line or block comment
                        if (stopOffset <= offset)
                            index++;
                        else {
                            end = true;
                            if (startOffset < offset) {
                                positionType = PositionType.ON_A_TOKEN;
                            } else {
                                if (index == -1)
                                    positionType = PositionType.BEFORE_FIRST_TOKEN;
                                else
                                    positionType = PositionType.BETWEEN_TWO_TOKENS;
                            }
                        }
                    } else {
                     // Here our token is a line or block comment
                        if (offset <= startOffset) {
                         // In such a case, we are unable to know if caret is
                         // in position NO_TOKEN_AT_ALL (some tokens but no token
                         // transmitted to parser), BEFORE_FIRST_TOKEN,
                         // BETWEEN_TWO_TOKENS or AFTER_LAST_TOKEN.
                         // Next tokens will enable to decide (or not we they are
                         // all WS and line or block comments)
                        } else if (startOffset < offset &&
                                   offset <= stopOffset   ) {
                            positionType = PositionType.ON_A_TOKEN;
                            end = true;
                        }
                    }
                }
//                System.out.println("    index=" + index);
//                System.out.println("    position type=" + positionType);
            }
            if (positionType == PositionType.UNDEFINED) {
                if (index == -1)
                    positionType = PositionType.NO_TOKEN_AT_ALL;
                else
                    positionType = PositionType.AFTER_LAST_TOKEN;
            }
        }
//        System.out.println("Position:getPositionInTokenStream(int) -> Position : end");
        return new Position(positionType, index);
    }
}
