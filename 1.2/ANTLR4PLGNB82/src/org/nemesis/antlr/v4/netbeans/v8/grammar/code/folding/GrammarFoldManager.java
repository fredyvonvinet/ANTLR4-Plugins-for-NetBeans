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
package org.nemesis.antlr.v4.netbeans.v8.grammar.code.folding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.event.DocumentEvent;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.StyledDocument;

import org.nemesis.antlr.v4.netbeans.v8.grammar.code.coloring.ANTLRv4TokenId;

import org.netbeans.api.editor.fold.Fold;
import org.netbeans.api.editor.fold.FoldType;

import org.netbeans.api.lexer.TokenHierarchy;
import org.netbeans.api.lexer.TokenSequence;

import org.netbeans.spi.editor.fold.FoldHierarchyTransaction;
import org.netbeans.spi.editor.fold.FoldInfo;
import org.netbeans.spi.editor.fold.FoldManager;
import org.netbeans.spi.editor.fold.FoldOperation;

import org.openide.text.NbDocument;

import org.openide.util.Exceptions;

/**
 * 
 * @author Frédéric Yvon Vinet
 */
public class GrammarFoldManager implements FoldManager {
    private       FoldOperation         operation;
    private final Map<Integer,FoldInfo> candidateFolds;
    private       Document              doc;
    
    public GrammarFoldManager() {
        candidateFolds = new HashMap<>();
//        System.out.println("GrammarFoldManager.GrammarFoldManager()");
    }

    @Override
    public void init(FoldOperation operation) {
//        System.out.println("GrammarFoldManager.init(FoldOperation) : begin");
        this.operation = operation;
        doc = operation.getHierarchy().getComponent().getDocument();
//        System.out.println("GrammarFoldManager.init(FoldOperation) : end");
    }

  /**
   * Called each time an editor for MIME=text/x-g4 is opened.
   * 
   * @param transaction
   */
    @Override
    public void initFolds(FoldHierarchyTransaction transaction) {
//        System.out.println("GrammarFoldManager.initFolds() : begin");
        candidateFolds.clear();
        
     // When we initialize it is sure that all potential folds are folds
        List<FoldInfo> folds = parseForPotentialFolds();
        Iterator<FoldInfo> it = folds.iterator();
        while (it.hasNext()) {
            FoldInfo foldInfo = it.next();
            try {
                operation.addToHierarchy
                        (foldInfo.getType() ,
                         foldInfo.getStart(),
                         foldInfo.getEnd()  ,
                         null               , // collapsed assigned automatically
                         null               , // we use default template available in type
                         null               , // no display override
                         null               , // No extra info
                         transaction        );
            } catch (BadLocationException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
//        System.out.println("GrammarFoldManager.initFolds() : end");
    }
    
    
  /**
   * If some characters are inserted inside a fold then it is automatically
   * updated, that is its end is automatically updated. Then the current
   * method is called for doing extra work (but in our case, we have nothing
   * to do).
   *
   * If some characters are inserted in guarded areas of a fold, destroying 
   * syntactically this fold, then fold is automatically removed from its
   * operation, then NetBeans framework calls removeDamagedNotify method and 
   * then insertUpdate.
   *
   * If some characters are inserted before a fold then it is also  
   * automatically updated that is its begin and end are updated. Then the
   * insertUpdate method is called.
   *
   * Each time a character is inserted in a document with a managed MIME type
   * (see GrammarFoldManagerFactory class), insertUpdate method is called.
   * 
   * Next code illustrates all these points.
   **/
    @Override
    public void insertUpdate(DocumentEvent de, FoldHierarchyTransaction fht) {
//        System.out.println("GrammarFoldManager.insertUpdate() : begin");
     // The problem is too complex for finding a valid solution able to manage
     // all possible cases. So we simply reinitialize the folds from scratch.
        clearFolds(fht);
        initFolds(fht);
        
//        System.out.println("GrammarFoldManager.insertUpdate() : end");
    }
    
    
  /**
   * If some characters are removed from a fold then it is automatically
   * updated. Its end is automatically updated.
   *
   * If removed characters are in guarded areas (at beginning or at end),
   * fold is automatically removed from its operation.
   *
   * If removed characters are located before a fold, fold begin and end are
   * updated.
   *
   * removeUpdate method is called each time a character is deleted from a 
   * document with the managed MIME type (see GrammarFoldManagerFactory class).
   *
   * We can check all these points from next code execution.
   * 
   * @param de
   * @param fht 
   */
    @Override
    public void removeUpdate(DocumentEvent de, FoldHierarchyTransaction fht) {
//        System.out.println("GrammarFoldManager.removeUpdate() : begin");
     // The problem is too complex for finding a valid solution able to manage
     // all possible cases. So we simply reinitialize the folds from scratch.
        clearFolds(fht);
        initFolds(fht);
//        System.out.println("GrammarFoldManager.removeUpdate() : end");
    }
    
    
    @Override
    public void changedUpdate(DocumentEvent de, FoldHierarchyTransaction fht) {
/*
        int offset = de.getOffset();
        System.out.println("GrammarFoldManager.changedUpdate()");
        System.out.println("- Caret offset=" + offset);
        displayFolds();
*/
    }

    
    @Override
    public void removeEmptyNotify(Fold fold) {
/*
        System.out.println("GrammarFoldManager.removeEmptyNotify() : begin");
        displayFolds();
        System.out.println("GrammarFoldManager.removeEmptyNotify() : end");
*/
    }

    
  /*
      If some characters are inserted in guarded areas of a fold, destroying 
      syntactically this fold, then fold is automatically removed from its
      operation. then NetBeans framework calls removeDamagedNotify method,
      then insertUpdate method.
      
      If a fold is syntactically destroyed by deleting a character of a 
      guarded area, then fold is automatically removed from its operation and
      removeDamagedNotify method is called then removeUpdate method.
      The destruction of an existing fold by destroying its guarded areas may
      lead to the creation of new fold if child folds is forbidden.
      
      We can check all these points from next code execution.
    */
    @Override
    public void removeDamagedNotify(Fold fold) {
/*
        System.out.println("GrammarFoldManager.removeDamagedNotify() : begin");
        displayFolds();
        System.out.println("GrammarFoldManager.removeDamagedNotify() : end");
*/
    }
    
  /**
   * Never called in our case because we have chosen automatic collapse / 
   * expansion (see initFolds method)
   * 
   * @param fold 
   */
    @Override
    public void expandNotify(Fold fold) {
//        System.out.println("GrammarFoldManager.expandNotify()");
    }

    
  /**
   * Called when the editor containing the managed document is closed.
   * 
   */
    @Override
    public void release() {
//        System.out.println("GrammarFoldManager.release()");
    }
    
    
    private List<FoldInfo> parseForPotentialFolds() {
        ArrayList<FoldInfo> answer = new ArrayList<>();
        StyledDocument sDoc = (StyledDocument) doc;
        TokenHierarchy<Document> hi = TokenHierarchy.get(doc);
        TokenSequence<?> ts =  hi.tokenSequence();
        FoldType type;
        int offset, startOffset = -1, startLine, endLine;
        String tokenName;
        while (ts.moveNext()) {
            offset = ts.offset();
            org.netbeans.api.lexer.Token<?> token = ts.token();
            ANTLRv4TokenId id = (ANTLRv4TokenId) token.id();
            tokenName = id.name();
//            System.out.println("GrammarFoldManager.parseForPotentialFolds() : " + tokenName);
            switch (tokenName) {
                case "DOC_COMMENT":
                case "BLOCK_COMMENT": {
                    int endOffset = offset + token.length();
                    startLine = NbDocument.findLineNumber(sDoc, offset);
                    endLine = NbDocument.findLineNumber(sDoc, endOffset);
                    type = GrammarFoldType.COMMENT_FOLD_TYPE;
                    FoldInfo foldInfo = FoldInfo.range
                                                  (offset   ,
                                                   endOffset,
                                                   type     );
                    if (endLine >= startLine + 2) {
                        answer.add(foldInfo);
                    } else {
                        for (int off = offset; off <= endOffset; off++)
                            candidateFolds.put(off, foldInfo);
                    }
                    break;
                }
                case "BEGIN_ACTION":
                    startOffset = offset;
                    break;
                case "END_ACTION": {
                    if (startOffset != -1) {
                        int endOffset = offset + token.length();
                        startLine = NbDocument.findLineNumber(sDoc, startOffset);
                        endLine = NbDocument.findLineNumber(sDoc, endOffset);
//                    System.out.println("startLine=" + startLine);
//                    System.out.println("startLine=" + endLine);
                        type = GrammarFoldType.ACTION_FOLD_TYPE;
                        FoldInfo foldInfo = FoldInfo.range
                                                  (startOffset,
                                                   endOffset  ,
                                                   type       );
                        if (endLine >= startLine + 2) {
                            answer.add(foldInfo);
                        } else {
                            for (int off = offset; off <= endOffset; off++)
                                candidateFolds.put(off, foldInfo);
                        }
                    }
                    break;
                }
            }
        }
        return answer;
    }
    
    
    private void updateHierarchy
            (List<FoldInfo>           foldInfos,
             FoldHierarchyTransaction fht      ) throws BadLocationException {
//        System.out.println("updateHierarchy() : start");
        Iterator<FoldInfo> it = foldInfos.iterator();
        while (it.hasNext()) {
            FoldInfo foldInfo = it.next();
            Fold fold = getFoldEqualTo(foldInfo);
            if (fold == null) {
             // There is no corresponding fold so there is a new fold
                List<Fold> folds = getFoldsContainedIn(foldInfo);
             // If there are folds contained in the new fold then we must remove
             // them
                if (!folds.isEmpty()) {
//                    System.out.println("some folds are contained in current fold info");
                 // We remove the fold that is contained in our new fold
                    Iterator<Fold> it2 = folds.iterator();
                    while (it2.hasNext()) {
                        fold = it2.next();
                        operation.removeFromHierarchy(fold, fht);
//                        System.out.println("- removed fold type=" + fold.getType());
//                        System.out.println("  removed fold start=" + fold.getStartOffset());
//                        System.out.println("  removed fold end=" + fold.getEndOffset());
                    }
                }
             // We add the new Fold
//                System.out.println("- added fold type=" + foldInfo.getType());
//                System.out.println("  added fold start=" + foldInfo.getStart());
//                System.out.println("  added fold end=" + foldInfo.getEnd());
                operation.addToHierarchy
                        (foldInfo.getType() ,
                         foldInfo.getStart(),
                         foldInfo.getEnd()  ,
                         null               , // collapsed assigned automatically
                         null               , // we use default template available in type
                         null               , // no display override
                         null               , // No extra info
                         fht                );
            }
        }
//        System.out.println("updateHierarchy() : end");
    }
    
    
    private Fold getFoldEqualTo(FoldInfo foldInfo) {
        Fold fold = null;
        Iterator<Fold> it = operation.foldIterator();
        boolean found = false;
        int foldInfoStart = foldInfo.getStart();
        int foldInfoEnd = foldInfo.getEnd();
        FoldType foldInfoType = foldInfo.getType();
        int foldStart, foldEnd;
        FoldType foldType;
        while (it.hasNext() && !found) {
            fold = it.next();
            foldStart = fold.getStartOffset();
            foldEnd = fold.getEndOffset();
            foldType = fold.getType();
            if ((foldStart == foldInfoStart)    &&
                (foldEnd == foldInfoEnd)        &&
                foldType.isKindOf(foldInfoType)   )
                found = true;
        }
        if (!found)
            fold = null;
        return fold;
    }
    
    
    private List<Fold> getFoldsContainedIn(FoldInfo foldInfo) {
        int start = foldInfo.getStart();
        int end   = foldInfo.getEnd();
//        System.out.println("getFoldContainedIn()");
//        System.out.println("start=" + start + " end=" + end);
        Iterator<Fold> it = operation.foldIterator();
        List<Fold> answer = new ArrayList<>();
        Fold fold;
        int foldStart, foldEnd;
        while (it.hasNext()) {
            fold = it.next();
            foldStart = fold.getStartOffset();
            foldEnd = fold.getEndOffset();
//            System.out.println("foldStart=" + foldStart + " foldEnd=" + foldEnd);
            if ((start < foldStart) &&
                (end > foldEnd)       )
                answer.add(fold);
        }
        return answer;
    }
    
    
  /**
   * Deletes all folds
   */
    private void clearFolds(FoldHierarchyTransaction fht) {
        Iterator<Fold> foldIt = operation.foldIterator();
        while (foldIt.hasNext()) {
            Fold fold = foldIt.next();
            operation.removeFromHierarchy(fold, fht);
            foldIt = operation.foldIterator();
        }
    }
    
    
    private void displayFolds() {
        Iterator<Fold> it = operation.foldIterator();
        System.out.println("- List of folds:");
        while (it.hasNext()) {
            Fold fold = it.next();
            System.out.println("  * Fold description=" + fold.getDescription());
            System.out.println("    Fold type label=" + fold.getType().getLabel());
            int startTokenStart = fold.getStartOffset();
            int startTokenEnd   = fold.getGuardedStart();
            int endTokenEnd     = fold.getEndOffset();
            int endTokenStart   = fold.getGuardedEnd();
            System.out.println("    Start guarded area start offset=" + startTokenStart);
            System.out.println("    Start guarded area end offset=" + startTokenEnd);
            System.out.println("    End guarded area start offset=" + endTokenStart);
            System.out.println("    End guarded area end offset=" + endTokenEnd);
        }
    }
}