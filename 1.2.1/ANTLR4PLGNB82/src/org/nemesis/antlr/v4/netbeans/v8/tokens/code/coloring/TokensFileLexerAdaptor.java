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
package org.nemesis.antlr.v4.netbeans.v8.tokens.code.coloring;

import org.antlr.v4.runtime.Token;

import org.nemesis.antlr.v4.netbeans.v8.grammar.code.coloring.ANTLRv4CharStream;
import org.nemesis.antlr.v4.netbeans.v8.grammar.code.coloring.ANTLRv4TokenId;
import org.nemesis.antlr.v4.netbeans.v8.tokens.code.coloring.impl.TokensFileLexer;

import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

/**
 *
 * @author Frédéric Yvon Vinet
 */
public class TokensFileLexerAdaptor implements Lexer<ANTLRv4TokenId> {
    private final LexerRestartInfo<ANTLRv4TokenId> info;
    private final TokensFileLexer                  tokensFileLexer;

    public TokensFileLexerAdaptor(LexerRestartInfo<ANTLRv4TokenId> info) {
//        System.out.print("- TokensFileLexerAdaptor : constructor");
        this.info = info;
        ANTLRv4CharStream charStream = new ANTLRv4CharStream
                                                          (info.input()       ,
                                                           "ANTLRTokensEditor");
        this.tokensFileLexer = new TokensFileLexer(charStream);
    }

    @Override
    public org.netbeans.api.lexer.Token<ANTLRv4TokenId> nextToken() {
        org.netbeans.api.lexer.Token<ANTLRv4TokenId> returnedNBToken;
        Token currentToken = tokensFileLexer.nextToken();
        int currentTokenType = currentToken.getType();
//        System.out.print("- TokensFileLexerAdaptor : currentTokenType=" + currentTokenType);
        if (currentTokenType != TokensFileLexer.EOF) {
            ANTLRv4TokenId currentTokenId = TokensFileLanguageHierarchy.getToken(currentTokenType);
//            System.out.println("  TokensFileLexerAdaptor : currentTokenId=" + currentTokenId.name());
            if (currentTokenId != null)
                returnedNBToken = info.tokenFactory().createToken(currentTokenId);
            else
                returnedNBToken = null;
        } else
            returnedNBToken = null;
        return returnedNBToken;
    }

    @Override
    public Object state() {
        return null;
    }

    @Override
    public void release() {}
}