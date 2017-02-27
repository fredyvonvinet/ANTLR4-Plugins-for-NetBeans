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
package org.nemesis.antlr.v4.netbeans.v8.grammar.code.hyperlink;

import java.io.File;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.text.Document;
import javax.swing.text.StyledDocument;

import org.netbeans.api.editor.mimelookup.MimeRegistration;

import org.netbeans.lib.editor.hyperlink.spi.HyperlinkProvider;

import org.openide.cookies.EditorCookie;
import org.openide.cookies.LineCookie;

import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;

import org.openide.loaders.DataObject;
import org.openide.loaders.DataObjectNotFoundException;

import org.openide.text.Line;
import org.openide.text.Line.Set;
import org.openide.text.NbDocument;

import org.openide.util.Lookup;

/**
 *
 * @author Frédéric Yvon Vinet
 */
@MimeRegistration(mimeType = "text/x-g4", service = HyperlinkProvider.class)
public class GrammarHyperlinkProvider implements HyperlinkProvider {
    public GrammarHyperlinkProvider() {
    }
    
    
    @Override
    public boolean isHyperlinkPoint(Document doc, int offset) {
        boolean answer = false;
        Hyperlinks links = (Hyperlinks) doc.getProperty(Hyperlinks.class);
        if (links != null) {
//            System.out.println("Links exists");
            ArrayList<Hyperlink> possibleLinks = links.getLinks(offset);
            if (possibleLinks != null) {
//                System.out.println("Possible links exist");
                answer = true;
            }
        }
        return answer;
    }
    
    
    @Override
    public int[] getHyperlinkSpan(Document doc, int offset) {
        int[] answer = null;
        Hyperlinks links = (Hyperlinks) doc.getProperty(Hyperlinks.class);
        if (links != null) {
            ArrayList<Hyperlink> possibleLinks = links.getLinks(offset);
            if (possibleLinks != null) {
//                System.out.println("Possible links exist");
                Iterator<Hyperlink> it = possibleLinks.iterator();
             // All possible links share the same span so we only recover 
             // first one
                if (it.hasNext()) {
                    Hyperlink hyperlink = it.next();
                    int startOffset = hyperlink.getStart();
                    int endOffset   = hyperlink.getEnd();
//                    System.out.println("startOffset=" + startOffset);
//                    System.out.println("endOffset=" + endOffset);
                    answer = new int[]{startOffset, endOffset};
                }
            }
        }
        return answer;
    }
    
    
    @Override
    public void performClickAction(Document doc, int offset) {
        Hyperlinks links = (Hyperlinks) doc.getProperty(Hyperlinks.class);
        if (links != null) {
            ArrayList<Hyperlink> possibleLinks = links.getLinks(offset);
//            System.out.println("hyperlink instance number=" + possibleLinks.size());
            Iterator<Hyperlink> it = possibleLinks.iterator();
            boolean found = false;
            Hyperlink hyperlink = null;
            while (it.hasNext() && !found) {
                hyperlink = it.next();
                File targetFile = hyperlink.getTargetFile();
//                System.out.println("file=" + targetFile.getPath());
                if (targetFile.exists()) {
                    found = true;
                    
                 // It is possible that the target file is the currently 
                 // open file, in such a case it is useless to open it but  
                 // it does not lead to an error so we do not manage that
                 // case
                    FileObject targetFileObject = FileUtil.toFileObject
                                                                   (targetFile);
                 // The file exists so its DataObject exists as well but
                 // we have to manage the DataObjectNotFoundException even 
                 // if it is impossible it raises (except in case of 
                 // NetBeans bug)
                    try {
                        DataObject grammarDataObject = DataObject.find
                                                             (targetFileObject);
                        EditorCookie ec = grammarDataObject.getLookup().lookup(EditorCookie.class);
                        Lookup grammarLookup = grammarDataObject.getLookup();
                        if (ec != null) {
                            ec.open();
                            StyledDocument sDoc = ec.getDocument();
                            LineCookie lc = grammarLookup.lookup(LineCookie.class);
                            if (lc != null) {
                                int targetOffset = hyperlink.getTargetOffset();
/*
                                System.out.println
                                              ("GrammarHyperlinkProvider : " +
                                               "targetOffset=" + targetOffset);
*/
                                int lineIndex = NbDocument.findLineNumber(sDoc, targetOffset);
//                                int lineIndex = LineDocumentUtils.getLineIndex
//                                                             (ld, targetOffset);
                                int lineStartOffset = NbDocument.findLineOffset(sDoc, lineIndex);
//                                int lineStartOffset = LineDocumentUtils.getLineStart
//                                                             (ld, targetOffset);
                                int columnIndex = targetOffset - lineStartOffset;
/*
                                System.out.println("GrammarHyperlinkProvider : " +
                                               "lineIndex=" + lineIndex +
                                               " lineStartOffset=" + lineStartOffset +
                                               " columnIndex=" + columnIndex);
*/
                                Set set = lc.getLineSet();
                                Line line = set.getOriginal(lineIndex);
                                line.show(Line.ShowOpenType.OPEN        ,
                                          Line.ShowVisibilityType.FOCUS ,
                                          columnIndex                   );
                            }
                        }
                        /*
                        EditCookie editCookie = grammarLookup.lookup
                                                             (EditCookie.class);
                        if (editCookie != null)
                            editCookie.edit();
                        */
                    } catch (DataObjectNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
}