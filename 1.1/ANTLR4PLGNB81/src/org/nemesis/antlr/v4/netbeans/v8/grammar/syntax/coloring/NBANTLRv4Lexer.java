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
package org.nemesis.antlr.v4.netbeans.v8.grammar.syntax.coloring;

import org.antlr.v4.runtime.IntStream;

import org.nemesis.antlr.v4.netbeans.v8.grammar.syntax.coloring.impl.ANTLRv4Lexer;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.IntegerStack;

import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

/**
 *
 * @author Frédéric Yvon Vinet
 */
public class NBANTLRv4Lexer implements Lexer<ANTLRv4TokenId> {
    private final LexerRestartInfo<ANTLRv4TokenId> info;
    private final ANTLRv4Lexer                     antlrLexer;
    private       IntegerStack                     modes;

    public NBANTLRv4Lexer(LexerRestartInfo<ANTLRv4TokenId> info) {
//        System.out.println("NBANTLRv4Lexer.NBANTLRv4Lexer(LexerRestartInfo<ANTLRv4TokenId>) : begin");
        this.info = info;
      //  info.state() represente un objet que l'on a associé au token modifié
      // et qui représente l'état interne du lexer au moment de sa génération
      // Dans notre cas, il s'agit de la liste des modes dans lequel se trouvait
      // le lexer ANTLR
        Object state = info.state();
        modes = null;
/*
        if (state == null)
            System.out.println("- There is no state associated to this lexer");
        else {
            System.out.println("- There is a state associated to this lexer");
            if (state instanceof IntegerStack) {
                modes = (IntegerStack) state;
                System.out.println("  And this state is an IntegerStack!");
            }
        }
*/
        ANTLRv4CharStream charStream = new ANTLRv4CharStream
                                                         (info.input()        ,
                                                          "ANTLRGrammarEditor");
        this.antlrLexer = new ANTLRv4Lexer(charStream);
        
        if (modes != null) {
            int mode;
//            System.out.println("  lexer mode number=" + modes.size());
//            System.out.println("  Restored modes:");
            for (int i=0; i < modes.size(); i++) {
                mode = modes.get(i);
//                System.out.println("  - lexer mode[" + i + "]=" + ANTLRv4Lexer.modeNames[mode]);
                if (i != modes.size() - 1)
                    antlrLexer._modeStack.add(mode);
                else
                    antlrLexer._mode = mode;
            }
            
        }
//        System.out.println("NBANTLRv4Lexer.NBANTLRv4Lexer(LexerRestartInfo<ANTLRv4TokenId>) : end");
    }
    

    @Override
    public org.netbeans.api.lexer.Token<ANTLRv4TokenId> nextToken() {
//        System.out.println("NBANTLRv4Lexer.nextToken() -> Token : begin");
        org.netbeans.api.lexer.Token<ANTLRv4TokenId> returnedNBToken;
        
        Token nextToken = antlrLexer.nextToken();
        int nextTokenType = nextToken.getType();
//        System.out.println("- next token type=" + antlrLexer.getVocabulary().getSymbolicName(nextTokenType));
//        System.out.println("  token content='" + nextToken.getText() + "'");
        if (nextTokenType != ANTLRv4Lexer.EOF) {
         // if it is an id with lowercase or uppercase, it means that it is
         // true or that it may be an ID if there is  '=' or '+=' just after
            if ((nextTokenType == ANTLRv4Lexer.ID_STARTING_WITH_UPPERCASE) ||
                (nextTokenType == ANTLRv4Lexer.ID_STARTING_WITH_LOWERCASE)) {
                char nextChar = (char) 0;
                boolean found = false;
                boolean end = false;
                int i = 1;
             // We loop till we find a non space character
                while (!found && !end) {
                    nextChar = (char) antlrLexer._input.LA(i);
                    if (nextChar == (char) IntStream.EOF)
                        end = true;
                    else {
                        if ((nextChar != ' ')  &&
                            (nextChar != '\t') &&
                            (nextChar != '\n') &&
                            (nextChar != '\r')    ) {
//                            System.out.println("NBANTLRv4Lexer.nextToken() : next char=" + nextChar + " int value=" + (int) nextChar);
                            found = true;
                        } else
                            i++;
                    }
                }
                if (!end) {
                    char nextChar2 = (char) antlrLexer._input.LA(++i);
                    StringBuilder tokenText = new StringBuilder().append(nextChar);
                    tokenText.append(nextChar2);
                
                    if ((nextChar == '=') ||
                        (tokenText.toString().equals("+=")))
                        nextTokenType = ANTLRv4Lexer.ID;
                }
            }
            ANTLRv4TokenId nextTokenId = ANTLRv4LanguageHierarchy.getToken(nextTokenType);
            
            if (nextTokenId != null) {
//                System.out.println("NBANTLRv4Lexer.nextToken() : next Token Id=" + nextTokenId.name());
             // Il existe une méthode createPropertyToken() qui admet un parametre reLexerStart
             // qui permet de réinitialiser l'état du lexer lors de l'instantiation de NBANTLRv4Lexer
             // via le parametre info de type LexerRestartInfo<ANTLRv4TokenId>
             // we must make a copy of these modes because they will evoluate at
             // next token
             //   TokenPropertyProvider<ANTLRv4TokenId> tpp = new ModesTokenPropertyProvider(modes);
             //   System.out.println("NBANTLRv4Lexer.nextToken() : token length=" + currentTokenId.name().length());
             //   returnedNBToken = info.tokenFactory().createPropertyToken(currentTokenId, currentTokenId.name().length(), tpp);
             // original statement
                returnedNBToken = info.tokenFactory().createToken(nextTokenId);
                
             // We make a copy of internal lexer state after having recovered 
             // next token in order to be able to restore it in case of future
             // differential lexing
                modes = new IntegerStack(antlrLexer._modeStack);
                modes.push(antlrLexer._mode);
/*
                System.out.println("- lexer mode number=" + modes.size());
                for (int i=0; i < modes.size(); i++)
                    System.out.println("  - lexer mode[" + i + "]=" + ANTLRv4Lexer.modeNames[modes.get(i)]);
*/
            } else
                returnedNBToken = null;
        } else
            returnedNBToken = null;
//        System.out.println("NBANTLRv4Lexer.nextToken() -> Token : end");
        return returnedNBToken;
    }

    @Override
    public Object state() {
/*
        System.out.println("NBANTLRv4Lexer.state() -> Object : begin");
        System.out.println("lexer mode number=" + modes.size());
        for (int i=0; i < modes.size(); i++)
            System.out.println("- lexer mode[" + i + "]=" + ANTLRv4Lexer.modeNames[modes.get(i)]);
        System.out.println("NBANTLRv4Lexer.state() -> Object : end");
*/
        return modes;
    }

    @Override
    public void release() {}
}