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
import java.awt.Font;
import java.awt.Graphics;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.StyledDocument;

import org.netbeans.api.editor.completion.Completion;

import org.netbeans.spi.editor.completion.CompletionItem;
import org.netbeans.spi.editor.completion.CompletionTask;
import org.netbeans.spi.editor.completion.support.CompletionUtilities;

import org.openide.util.Exceptions;

/**
 * This class provides a default implementation for all grammar completion 
 * items.
 * 
 * @author Frédéric Yvon Vinet
 */
public abstract class GrammarCompletionItem implements CompletionItem {
    protected static Color fieldColor = Color.decode("0x0000B2");
    
    protected String  text;
    protected int     insertionOffset;
    protected int     caretOffset;
    protected boolean extraWhitespaceAlreadyThere;
    
    
    public GrammarCompletionItem
        (String  text                       ,
         int     insertionOffset            ,
         int     caretOffset                ,
         boolean extraWhitespaceAlreadyThere) {
//        System.out.println("GrammarCompletionItem.GrammarCompletionItem(String, int) : begin");
        assert text != null;
        this.text = text;
        this.caretOffset = caretOffset;
        this.insertionOffset = insertionOffset;
//        System.out.println("GrammarCompletionItem.GrammarCompletionItem(String, int) : end");
    }
    
        
    public abstract ImageIcon getIcon();
    
    
    public abstract Color getTextColor(boolean selected);
    
    
 /**
  * It is the first method to be called when we press Ctrl-Space.
  * 
  * When enabled for the item the instant substitution should process the item
  * in the same way like when the item is displayed and Enter key gets pressed 
  * by the user.
  * 
  * @param jtc
  * @return 
  */
    @Override
    public boolean instantSubstitution(JTextComponent jtc) {
//        System.out.println("GrammarCompletionItem.instantSubstitution(JTextComponent) -> boolean : begin");
//        System.out.println("GrammarCompletionItem.instantSubstitution(JTextComponent) -> boolean : end");
        return false;
    }
    
    
 /**
  * This is the second method to becalled when we press Ctrl-Space.
  * 
  * Get the preferred visual width of this item.
  * 
  * @param graphics
  * @param font
  * @return 
  */
    @Override
    public int getPreferredWidth(Graphics graphics, Font font) {
//        System.out.println("GrammarCompletionItem.getPreferredWidth(Graphics, Font) -> int : begin");
//        System.out.println("GrammarCompletionItem.getPreferredWidth(Graphics, Font) -> int : end");
        return CompletionUtilities.getPreferredWidth(text, null, graphics, font);
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
        return SortOrder.DEFAULT;
    }
    

 /**
  * It is the fourth method to be called when we press Ctrl-Space.
  * 
  * Render this item into the given graphics.
  * 
  * @param grphcs
  * @param defaultFont
  * @param defaultColor
  * @param backgroundColor
  * @param width
  * @param height
  * @param selected 
  */
    @Override
    public void render(Graphics grphcs         ,
                       Font     defaultFont    ,
                       Color    defaultColor   ,
                       Color    backgroundColor,
                       int      width          ,
                       int      height         ,
                       boolean  selected       ) {
//        System.out.println("GrammarCompletionItem.render(Graphics, ...) : begin");
        ImageIcon fieldIcon = getIcon();
        assert fieldIcon != null;
        CompletionUtilities.renderHtml
            (fieldIcon             ,
             text                  ,
             null                  ,
             grphcs                ,
             defaultFont           ,
             getTextColor(selected),
             width                 ,
             height                ,
             selected              );
//        System.out.println("GrammarCompletionItem.render(Graphics, ...) : end");
    }
    
    
 /**
  * It is the fifth and sixth method to be called when we press Ctrl-Space.
  * 
  * Process the key pressed when this completion item was selected in the 
  * completion popup window.
  * 
  * @param ke 
  */
    @Override
    public void processKeyEvent(KeyEvent ke) {
//        System.out.println("GrammarCompletionItem.processKeyEvent(KeyEvent) : begin");
//        System.out.println("GrammarCompletionItem.processKeyEvent(KeyEvent) : end");
    }
    

 /**
  * It is the seventh method to be called when we press Ctrl-Space.
  * Returns a task used to obtain a documentation associated with the item if 
  * there is any.
  * 
  * @return 
  */
    @Override
    public CompletionTask createDocumentationTask() {
//        System.out.println("GrammarCompletionItem.createDocumentationTask() -> CompletionTask : begin");
//        System.out.println("GrammarCompletionItem.createDocumentationTask() -> CompletionTask : end");
        return null;
    }
    
 /**
  * Returns a task used to obtain a tooltip hint associated with the item if 
  * there is any.
  * @return 
  */
    @Override
    public CompletionTask createToolTipTask() {
//        System.out.println("GrammarCompletionItem.createToolTipTask() -> CompletionTask : begin");
//        System.out.println("GrammarCompletionItem.createToolTipTask() -> CompletionTask : end");
        return null;
    }
    

 /**
  * It is the method called when we select a proposition in the list of
  * completion propositions.
  * 
  * @param jtc 
  */
    @Override
    public void defaultAction(JTextComponent jtc) {
//        System.out.println("GrammarCompletionItem.defaultAction(JTextComponent) : begin");
        try {
            StyledDocument doc = (StyledDocument) jtc.getDocument();
         // We add a whitespace after or not after text in function of the type
         // of item
            StringBuilder textToBeInserted = new StringBuilder();
            textToBeInserted.append(text);
            if (isExtraWhitespaceRequired()) {
             // An extra whitespace character is required after that item in
             // order to allow code completion to work just after inerting our
             // text but perhaps it is already present
                textToBeInserted.append(" ");
            }
            
         // Here we remove the characters starting at the start offset
         // and ending at the point where the caret is currently found:
            if (caretOffset != insertionOffset) {
             // We must check that text located between insertionOffset and
             // caretOffset forms the beginning of the chosen proposition
             // if yes then we delete this string else we only insert it
                String previousString = doc.getText
                               (insertionOffset, caretOffset - insertionOffset);
                if (text.startsWith(previousString)) {
                    doc.remove(insertionOffset, caretOffset - insertionOffset);
                    doc.insertString(insertionOffset            ,
                                     textToBeInserted.toString(),
                                     null                       );
                } else
                    doc.insertString(caretOffset                ,
                                     textToBeInserted.toString(),
                                     null                       );
            } else {
                doc.insertString(caretOffset                ,
                                 textToBeInserted.toString(),
                                 null                       );
            }
         // This statement will close the code completion box:
            Completion.get().hideAll();
        } catch (BadLocationException ex) {
            Exceptions.printStackTrace(ex);
        }
//        System.out.println("GrammarCompletionItem.defaultAction(JTextComponent) : end");
    }
    
 /**
  * 
  * @return a text used to sort items alphabetically.
  */
    @Override
    public CharSequence getSortText() {
//        System.out.println("GrammarCompletionItem.getSortText() -> CharSequence : begin");
//        System.out.println("GrammarCompletionItem.getSortText() -> CharSequence : end");
        return text;
    }
    
    
 /**
  * Returns a text used for finding of a longest common prefix after the TAB 
  * gets pressed or when the completion is opened explicitly.
  * @return 
  */
    @Override
    public CharSequence getInsertPrefix() {
//        System.out.println("GrammarCompletionItem.getInsertPrefix() -> CharSequence : begin");
//        System.out.println("GrammarCompletionItem.getInsertPrefix() -> CharSequence : end");
        return text;
    }
    
    
    public boolean equals(String word) {
        assert word != null;
        return text.equals(word);
    }
    
    public boolean startsWith(String word) {
        assert word != null;
        return text.startsWith(word);
    }
    
    
    public abstract boolean isExtraWhitespaceRequired();
}