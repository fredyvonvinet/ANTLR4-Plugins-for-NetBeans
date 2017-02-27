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

import javax.swing.text.JTextComponent;

import org.netbeans.api.editor.mimelookup.MimeRegistration;

import org.netbeans.spi.editor.completion.CompletionProvider;
import org.netbeans.spi.editor.completion.CompletionTask;

import org.netbeans.spi.editor.completion.support.AsyncCompletionTask;

/**
 *
 * @author Frédéric Yvon Vinet
 */
@MimeRegistration(mimeType = "text/x-g4"            ,
                  service = CompletionProvider.class,
                  position = 668                    )
public class GrammarCodeCompletion implements CompletionProvider {
    public GrammarCodeCompletion() {
//        System.out.println("GrammarCodeCompletion:GrammarCodeCompletion() : begin");
//        System.out.println("GrammarCodeCompletion:GrammarCodeCompletion() : end");
    }
    
    
 /**
  * We need to create a task only if the required task type is completion.
  * In all other cases, we do nothing.
  * 
  * @param type
  * @param component
  * @return 
  */
    @Override
    public CompletionTask createTask(int type, JTextComponent component) {
//        System.out.println("GrammarCodeCompletion:createTask(int,JTextComponent) -> CompletionTask : begin");
        CompletionTask answer;
        switch (type) {
            case COMPLETION_QUERY_TYPE:
                answer =  new AsyncCompletionTask
                    (new GrammarCompletionQuery(),
                     component                   );
                break;
            default:
                answer = null;
        }
//        System.out.println("GrammarCodeCompletion:createTask(int, JTextComponent) -> CompletionTask : end");
        return answer;
    }
    
    
  /**
   * This method determines whether the code completion box appears 
   * automatically or not.
   * 
   * @param component
   * @param typedText
   * @return 0 means that the code completion box will never appear unless the
   * user explicitly asks for it.
   */
    @Override
    public int getAutoQueryTypes(JTextComponent component, String typedText) {
//        System.out.println("GrammarCodeCompletion:getAutoQueryTypes(JTextComponent, String) -> int: begin");
//        System.out.println("typed text=" + typedText);
//        System.out.println("GrammarCodeCompletion:getAutoQueryTypes(JTextComponent, String) -> int: end");
        return 0;
    }
}