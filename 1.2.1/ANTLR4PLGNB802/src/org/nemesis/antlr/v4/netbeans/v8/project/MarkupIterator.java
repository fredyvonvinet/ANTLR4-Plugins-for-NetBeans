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
package org.nemesis.antlr.v4.netbeans.v8.project;

import java.util.Iterator;

/**
 *
 * @author Frédéric Yvon Vinet
 */
public class MarkupIterator implements Iterator<String> {
    private final String string;
    private       int    index;
    
    
    public MarkupIterator(String string) {
        this.string = string;
        this.index = 0;
    }
    
    
    @Override
    public boolean hasNext() {
        boolean answer;
        int xmlSpecialMarkupStart = string.indexOf("<?", index);
        if (xmlSpecialMarkupStart == -1) {
            int nextMarkupStart = string.indexOf("<", index);
            if (nextMarkupStart == -1)
                answer = false;
            else
                answer = true;
        } else {
         // We have found a <? markup, so we look for its closure now
            index = xmlSpecialMarkupStart + 2;
            int xmlSpecialMarkupEnd = string.indexOf("?>", index);
            if (xmlSpecialMarkupEnd == -1) {
             // We didn't find its closure so there is no standard markup on this line
                answer = false;
            } else {
             // We found its closure so we look for after it for ckecking if
             // there is a markup
                index = xmlSpecialMarkupEnd + 2;
                answer = hasNext();
            }
        }
//        System.out.println("MarkupIterator:hasNext(): answer=" + answer);
        return answer;
    }
    

    @Override
    public String next() {
        String currentMarkup;
        int nextMarkupStart = string.indexOf("<", index);
        int end = string.indexOf(">", nextMarkupStart);
        int end2;
        if (end == -1) {
         // the > character ending the markup is not on this line
         // so we search for the first white space after < ending the
         // markup name
            end = string.indexOf(" ", nextMarkupStart);
            if (end == -1) {
             // No white space found
             // So we search for the first \t character after < ending the
             // markup name
                end = string.indexOf("\t", nextMarkupStart);
                if (end == -1) {
                 // No \t character found
                 // So the end of the name is marked by the end of the string
                    currentMarkup = string.substring(nextMarkupStart + 1);
                    index = nextMarkupStart + 2;
                } else {
                 // A \t character has been found
                 // So the end of the name is marked by a \t character
                    currentMarkup = string.substring(nextMarkupStart + 1, end);
                    index = end + 1;
                }
            } else {
             // We have found a white space
             // So the end of the name is marked by a white space character
                currentMarkup = string.substring(nextMarkupStart + 1, end);
                index = end + 1;
            }
        } else {
         // The > character ending the markup is on this line.
         // So we search for a white space char delimiting the end
         // of the name before '>' character
            end2 = string.indexOf(" ", nextMarkupStart);
            if (end2 == -1) {
             // No white space character found.
             // So we look for the first tab character after < delimiting
             // the end of the name before '>' character
                end2 = string.indexOf("\t", nextMarkupStart);
                if (end2 == -1) {
                 // No \t character found.
                 // So the end of the name is marked by '>' character
                    currentMarkup = string.substring
                                                 (nextMarkupStart + 1, end);
                    index = end + 1;
                } else {
                 // a \t character has been found.
                 // So the end of the name is marked by this character if
                 // this character is placed before >
                    if (end2 < end) {
                     // the end of the name is marked by a \t
                     // character
                        currentMarkup = string.substring
                                                (nextMarkupStart + 1, end2);
                        index = end2 + 1;
                    } else {
                     // the end of the character is marked by >
                        currentMarkup = string.substring
                                                 (nextMarkupStart + 1, end);
                        index = end + 1;
                    }
                }
            } else {
             // A white space character has been found.
             // We check if it is placed before > character or not.
                if (end2 < end) {
                 // The end of the name is marked by a " " character
                    currentMarkup = string.substring
                                                (nextMarkupStart + 1, end2);
                    index = end2 + 1;
                } else {
                 // The end of the name is delimited by > character
                    currentMarkup = string.substring
                                                 (nextMarkupStart + 1, end);
                    index = end + 1;
                }
            }
        }
        return currentMarkup;
    }
}