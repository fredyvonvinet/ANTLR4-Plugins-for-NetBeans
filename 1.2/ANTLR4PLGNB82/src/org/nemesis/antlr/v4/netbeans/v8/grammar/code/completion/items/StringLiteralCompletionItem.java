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
package org.nemesis.antlr.v4.netbeans.v8.grammar.code.completion.items;

import java.awt.Color;

import javax.swing.ImageIcon;

import org.openide.util.ImageUtilities;

/**
 *
 * @author Frédéric Yvon Vinet
 */
public class StringLiteralCompletionItem extends GrammarCompletionItem {
    protected static ImageIcon icon =
        new ImageIcon(ImageUtilities.loadImage
          ("org/nemesis/antlr/v4/netbeans/v8/grammar/code/completion/items" +
           "/literalIcon.png"));
    protected static Color color = Color.decode("0x966496");
    
    public StringLiteralCompletionItem
            (String  text                       ,
             int     insertionOffset            ,
             int     caretOffset                ,
             boolean extraWhitespaceAlreadyThere) {
        super(text, insertionOffset, caretOffset, extraWhitespaceAlreadyThere);
    }
    
    
    @Override
    public ImageIcon getIcon() {
        return icon;
    }
    
    
    @Override
    public Color getTextColor(boolean selected) {
        return (selected ? Color.white : color);
    }
    
    
 /**
  * It is the third method to be called when we press Ctrl-Space
  * 
  * @return the item's priority.
  */
    @Override
    public int getSortPriority() {
//        System.out.println("GrammarCompletionItem.getSortPriority() -> int : begin");
//        System.out.println("GrammarCompletionItem.getSortPriority() -> int : end");
        return SortOrder.STRING_LITERAL;
    }
    
    
    @Override
    public boolean isExtraWhitespaceRequired() {
        return true;
    }
}