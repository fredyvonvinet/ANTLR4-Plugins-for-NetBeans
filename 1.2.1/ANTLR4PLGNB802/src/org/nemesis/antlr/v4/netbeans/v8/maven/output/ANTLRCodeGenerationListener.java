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
package org.nemesis.antlr.v4.netbeans.v8.maven.output;

import java.awt.Toolkit;

import java.io.File;
import java.io.IOException;

import javax.swing.SwingUtilities;

import org.openide.ErrorManager;

import org.openide.cookies.EditorCookie;

import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;

import org.openide.loaders.DataObject;
import org.openide.loaders.DataObjectNotFoundException;

import org.openide.text.Line;

import org.openide.util.RequestProcessor;

import org.openide.windows.OutputEvent;
import org.openide.windows.OutputListener;

/**
 *
 * @author Frédéric Yvon Vinet
 */
public class ANTLRCodeGenerationListener implements OutputListener {
    private static final RequestProcessor RP = new RequestProcessor
                                            (ANTLRCodeGenerationListener.class);
    
                  File   grammarFile;
    private final int    line;
    private final String text;
   
    
    public ANTLRCodeGenerationListener(File grammarFile, int line, String textAnn) {
        this.grammarFile = grammarFile;
        this.text = textAnn;
        this.line = line;
    }

    @Override
    public void outputLineSelected(OutputEvent oe) {
    }

    @Override
    public void outputLineAction(OutputEvent oe) {
//        System.out.println("ANTLRCodeGenerationListener.outputLineAction(OutputEvent)");
        RP.post(new Runnable() {
            @Override
            public void run() {
                FileUtil.refreshFor(grammarFile);
                FileObject file = FileUtil.toFileObject(grammarFile);
                if (file == null) {
                    beep();                   
                    return;
                }
                try {
                    DataObject dob = DataObject.find(file);
                    final EditorCookie ed = dob.getLookup().lookup(EditorCookie.class);
                    if (ed != null && file == dob.getPrimaryFile()) {
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    if (line == -1) {
                                        ed.open();
                                    } else {
                                        ed.openDocument();
                                        try {
                                            Line l = ed.getLineSet().getOriginal(line - 1);
                                            if (!l.isDeleted()) {
                                                l.show(Line.ShowOpenType.REUSE, Line.ShowVisibilityType.FOCUS);
                                            }
                                        } catch (IndexOutOfBoundsException ioobe) {
                                            // Probably harmless. Bogus line number.
                                            ed.open();
                                        }
                                    }
                                } catch (IOException ioe) {
                                    ErrorManager.getDefault().notify(ioe);
                                }
                            }
                        });
                    } else {
                        beep();
                    }
                } catch (DataObjectNotFoundException donfe) {
                    ErrorManager.getDefault().notify(donfe);
                }
            }
        });
    }

    @Override
    public void outputLineCleared(OutputEvent oe) {
    }
    
    
    @Override
    public String toString() {
        return "error[" + grammarFile + ":" + line + ":" + text + "]"; // NOI18N
    }
    
    
    private void beep() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Toolkit.getDefaultToolkit().beep();
            }
        });
    }
}