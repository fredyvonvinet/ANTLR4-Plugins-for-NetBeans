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
package org.nemesis.antlr.v4.netbeans.v8.grammar.hyperlink;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Hyperlinks class regroups all hyperlinks of a given document.
 * Hyperlinks instance are created by the parser class NBANTLRv4Parser in
 * package org.nemesis.antlr.v4.netbeans.v8.grammar.hyperlink.parser.
 * Then, hyperlinks are used by GrammarHyperlinkProvider in order to decide
 * if what is beneath mouse cursor is an hyperlink or not (method 
 * isHyperlinkPoint(Document,int)) and in order to activate an hyperlink
 * (method performClickAction(Document, int)).
 * 
 * @author Frédéric Yvon Vinet
 */
public class Hyperlinks {
    private final HashMap<Integer, ArrayList<Hyperlink>> links;
    
    public Hyperlinks() {
        this.links = new HashMap<>();
    }
    
    public void addLink(Hyperlink hyperlink) {
        int start = hyperlink.getStart();
        int end = hyperlink.getEnd();
     // For each position between start and end, we define our link as the target
        for (int i = start; i <= end; i++) {
            ArrayList<Hyperlink> list = links.get(i);
            if (list == null) {
                list = new ArrayList<>();
                links.put(i, list);
            }
            list.add(hyperlink);
        }
    }
    
    
    public void removeLink(Hyperlink hyperlink) {
        int start = hyperlink.getStart();
        int end = hyperlink.getEnd();
     // For each position between start and end, we define our link as the target
        for (int i = start; i <= end; i++) {
            ArrayList<Hyperlink> list = links.get(i);
            if (list != null)
                list.remove(hyperlink);
        }
    }
    
    
  /**
   * Gives the possible hyperlinks asociated to the given offset.
   * Only one may be the right one. For each link, you test existence of the
   * corresponding file and if it exists, you have found the target.
   * 
   * @param offset: mouse position in open document
   * @return the hyperlink associated with mouse position defined by offset
   */
    public ArrayList<Hyperlink> getLinks(int offset) {
        return links.get(offset);
    }
}
