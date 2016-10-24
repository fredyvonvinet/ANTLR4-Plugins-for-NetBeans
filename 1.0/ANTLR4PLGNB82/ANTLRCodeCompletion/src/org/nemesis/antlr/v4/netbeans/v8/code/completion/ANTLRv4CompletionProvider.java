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

import javax.swing.text.JTextComponent;

import org.netbeans.api.editor.mimelookup.MimeRegistration;

import org.netbeans.spi.editor.completion.CompletionProvider;
import org.netbeans.spi.editor.completion.CompletionTask;
import org.netbeans.spi.editor.completion.support.AsyncCompletionQuery;
import org.netbeans.spi.editor.completion.support.AsyncCompletionTask;

/**
 *
 * @author Frédéric Yvon Vinet
 */
@MimeRegistration(mimeType = "text/x-g4", service = CompletionProvider.class)
public class ANTLRv4CompletionProvider implements CompletionProvider{
    public ANTLRv4CompletionProvider() {
    }

    
    @Override
    public CompletionTask createTask(int queryType, JTextComponent jtc) {
        CompletionTask answer;
        if (queryType != CompletionProvider.COMPLETION_QUERY_TYPE)
            answer = null;
        else {
            AsyncCompletionQuery asyncCompletionQuery = new ANTLRCompletionQuery();
            answer = new AsyncCompletionTask(asyncCompletionQuery, jtc);
        }
        return answer;
    }

    
  /**
   * Defines if the code completion box appears automatically or not.
   * Here the implementation imposes a non automatic completion box.
   * User has to require it for making appear it (by default by pressing Ctrl-Space).
   * 
   * @param jtc
   * @param string
   * @return 
   */
    @Override
    public int getAutoQueryTypes(JTextComponent jtc, String string) {
        return 0;
    }
}
