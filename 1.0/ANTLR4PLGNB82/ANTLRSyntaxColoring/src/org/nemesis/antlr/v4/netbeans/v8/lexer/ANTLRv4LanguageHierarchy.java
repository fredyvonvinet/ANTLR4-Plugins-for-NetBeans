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
package org.nemesis.antlr.v4.netbeans.v8.lexer;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.netbeans.api.lexer.Language;
import org.netbeans.spi.lexer.LanguageHierarchy;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

/**
 *
 * @author Frédéric Yvon Vinet
 */
public class ANTLRv4LanguageHierarchy extends LanguageHierarchy<ANTLRv4TokenId> {
    private static List<ANTLRv4TokenId>               tokens;
    private static final Map<Integer, ANTLRv4TokenId> idToToken = new HashMap<>();
    private static final Language<ANTLRv4TokenId>     language
            = new ANTLRv4LanguageHierarchy().language();

    private static void init() {
        ANTLRv4TokenFileReader reader = new ANTLRv4TokenFileReader();
        tokens = reader.readTokenFile();
        for (ANTLRv4TokenId token : tokens) {
            idToToken.put(token.ordinal(), token);
        }
    }

    /**
     * Returns an actual ANTLRv4TokenId from an id. This essentially allows
     * the syntax highlighter to decide the color of specific words.
     * @param id
     * @return
     */
    static synchronized ANTLRv4TokenId getToken(int id) {
        if (idToToken == null) {
            init();
        }
        return idToToken.get(id);
    }

    @Override
    protected synchronized Collection<ANTLRv4TokenId> createTokenIds() {
        if (tokens == null) {
            init();
        }
        return tokens;
    }
    
    public static Language<ANTLRv4TokenId> getLanguage() {
        return language;
    }

    /**
     * Creates a lexer object for use in syntax highlighting.
     *
     * @param info
     * @return
     */
    @Override
    protected synchronized Lexer<ANTLRv4TokenId> createLexer(LexerRestartInfo<ANTLRv4TokenId> info) {
        return new NBANTLRv4Lexer(info);
    }

    @Override
    protected String mimeType() {
        return "text/x-g4";
    }
}