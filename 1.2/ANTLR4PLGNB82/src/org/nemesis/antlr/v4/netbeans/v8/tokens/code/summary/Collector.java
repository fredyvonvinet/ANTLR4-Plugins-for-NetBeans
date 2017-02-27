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
package org.nemesis.antlr.v4.netbeans.v8.tokens.code.summary;

import java.nio.file.Path;

import javax.swing.text.Document;

import org.antlr.v4.runtime.Token;

import org.antlr.v4.runtime.tree.TerminalNode;

import org.nemesis.antlr.v4.netbeans.v8.tokens.code.checking.impl.TokensBaseListener;
import org.nemesis.antlr.v4.netbeans.v8.tokens.code.checking.impl.TokensParser.Token_declarationContext;
import org.nemesis.antlr.v4.netbeans.v8.tokens.code.checking.impl.TokensParser.Token_declarationsContext;

/**
 *
 * @author Frédéric Yvon Vinet
 */
public class Collector extends TokensBaseListener {
    protected final Document      doc;
    protected final Path          sourceFilePath;
    protected       TokensSummary summary;
    
    public Collector(Document doc, Path sourceFilePath) {
//        System.out.println("Collector:Collector(Document, Path) : begin");
        this.doc = doc;
        this.sourceFilePath = sourceFilePath;
        this.summary        = new TokensSummary(sourceFilePath);
     // If doc had a previous summary then it is garbage collected
        this.doc.putProperty(TokensSummary.class, summary);
//        System.out.println("Collector:Collector(Document, Path) : end");
    }
    
    
    @Override
    public void exitToken_declarations(Token_declarationsContext ctx) {
        summary.save();
    }
    
    
    @Override
    public void exitToken_declaration(Token_declarationContext ctx) {
        TerminalNode tokenIdTN = ctx.TOKEN_ID();
        TerminalNode tokenLiteralTN = ctx.TOKEN_LITERAL();
        if (tokenIdTN != null) {
            Token idToken = tokenIdTN.getSymbol();
            if (idToken != null) {
                String tokenId = idToken.getText();
                if (!tokenId.equals("<missing TOKEN_ID>")) {
                    this.summary.addTokenId(tokenId);
                    int offset = idToken.getStartIndex();
                    this.summary.putTokenIdOffset(tokenId, offset);
                }
            }
        } else if (tokenLiteralTN != null) {
            Token literalToken = tokenLiteralTN.getSymbol();
            if (literalToken != null) {
                String tokenLiteral = literalToken.getText();
                if (!tokenLiteral.equals("<missing TOKEN_LITERAL>")) {
                    this.summary.addTokenLiteral(tokenLiteral);
                    int offset = literalToken.getStartIndex();
                    this.summary.putTokenLiteralOffset(tokenLiteral, offset);
                }
            }
        }
    }
}
