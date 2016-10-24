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
package org.nemesis.antlr.v4.netbeans.v8.code.completion;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import org.netbeans.spi.editor.completion.CompletionResultSet;
import org.netbeans.spi.editor.completion.support.AsyncCompletionQuery;

/**
 *
 * @author Frédéric Yvon Vinet
 */
public class ANTLRCompletionQuery extends AsyncCompletionQuery {
    @Override
    protected void query(CompletionResultSet crs        , 
                         Document            document   ,
                         int                 caretOffset) {
/*
        if (document != null)
            System.out.println("document length=" + document.getLength());
        else
            System.out.println("document=null");
        System.out.println("caret offset=" + caretOffset);
*/
     // We build the entry word that will lead the proposition for next characters
        int currentPosition = caretOffset;
        String currentLetter;
        StringBuilder currentWord = new StringBuilder();
        boolean endOfWord = false;
        try {
            while (!endOfWord) {
                if (currentPosition == 0)
                    endOfWord = true;
                else {
                    currentLetter = document.getText(currentPosition - 1, 1);
                    currentLetter = currentLetter.trim();
//                    System.out.println("currentLetter=" + currentLetter);
                    if (currentLetter.equals(""))
                        endOfWord = true;
                    else {
                        currentWord.insert(0, currentLetter);
                        currentPosition--;
                    }
                }
            }
            System.out.println("ANTLRCompletionQuery: entry word=" + currentWord);
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
        crs.finish();
    }
}