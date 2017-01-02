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
package org.nemesis.antlr.v4.netbeans.v8.tokens.syntax.coloring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.nemesis.antlr.v4.netbeans.v8.grammar.syntax.coloring.ANTLRv4TokenId;

import org.openide.util.Exceptions;


/**
 *
 * @author Fredéric Yvon Vinet inspired from James Reid work
 */
public class TokensFileTokenFileReader {
    private final HashMap<String, String>   tokenTypes;
    private final ArrayList<ANTLRv4TokenId> tokens;

    public TokensFileTokenFileReader() {
        tokenTypes = new HashMap<>();
        tokens = new ArrayList<>();
        init();
    }

    /**
     * Initializes the map to include any keywords in the ANTLR language.
     */
    private void init() {
        tokenTypes.put("TOKEN_ID", "tokenIdentifier");
        tokenTypes.put("TOKEN_LITERAL", "tokenLiteral");
        tokenTypes.put("TOKEN_VALUE", "tokenValue");
        tokenTypes.put("EQUAL", "equal");
        
        tokenTypes.put("WS", "");
        
        tokenTypes.put("ERROR", "");
    }

    /**
     * Reads the token file from the ANTLR parser and generates
     * appropriate tokens.
     *
     * @return
     */
    public List<ANTLRv4TokenId> readTokenFile() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inp = classLoader.getResourceAsStream("org/nemesis/antlr/v4/netbeans/v8/tokens/syntax/coloring/impl/TokensFileLexer.tokens");
        BufferedReader input = new BufferedReader(new InputStreamReader(inp));
        readTokenFile(input);
        return tokens;
    }

    /**
     * Reads in the token file.
     *
     * @param buff
     */
    private void readTokenFile(BufferedReader buff) {
        String line;
        try {
            while ((line = buff.readLine()) != null) {
                String[] splLine = line.split("=");
                String name = splLine[0];
             // If the token name starts with ' character then it is a doublon
             // so it is not added in the token list
                if (!name.startsWith("'")) {
                    int tok = Integer.parseInt(splLine[1].trim());
                    ANTLRv4TokenId id;
                    String tokenCategory = tokenTypes.get(name);
                    if (tokenCategory != null) {
                      //if the value exists, put it in the correct category
                        id = new ANTLRv4TokenId(name, tokenCategory, tok);
                    } else {
                      //if we don't recognize the token, consider it to a separator
                        id = new ANTLRv4TokenId(name, "separator", tok);
                    }
                 // add it into the vector of tokens
                    tokens.add(id);
                }
            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
}