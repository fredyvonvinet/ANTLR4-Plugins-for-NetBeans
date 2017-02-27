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
package org.nemesis.antlr.v4.netbeans.v8.grammar.code.coloring;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.misc.Interval;

import org.netbeans.spi.lexer.LexerInput;

/**
 *
 * @author Frédéric Yvon Vinet
 */
public class ANTLRv4CharStream implements CharStream {

    private class CharStreamState {
        int index;
        int line;
        int charPositionInLine;
    }

    private final LexerInput input;
    private final String     name;
    private       int        line = 1;
    private       int        charPositionInLine = 0;
    private       int        index = 0;
    private       List<CharStreamState> markers;
    private       int markDepth = 0;
    private       int lastMarker;

    public ANTLRv4CharStream(LexerInput input, String name) {
        this.input = input;
        this.name = name;
    }

 /*****************************************************************************
  * Implementation of the method defined in IntStream interface.
  * 
  * consumes the current symbol in the stream. This method has the following 
  * effects:
  * - Forward movement: The value of index() before calling this method is less 
  * than the value of index() after calling this method.
  * - Ordered lookahead: The value of LA(1) before calling this method becomes
  * the value of LA(-1) after calling this method.
  * 
  * Note that calling this method does not guarantee that index() is incremented
  * by exactly 1, as that would preclude the ability to implement filtering 
  * streams (e.g. CommonTokenStream which distinguishes between "on-channel" 
  * and "off-channel" tokens).
  * 
  * @throw:
  * - IllegalStateException: if an attempt is made to consume the end of the
  *   stream (i.e. if LA(1)==EOF before calling consume).
  *****/
    @Override
    public void consume() {
//        System.out.println("ANTLRv4CharStream: consume()");
        int c = input.read();
        index++;
        charPositionInLine++;

        if (c == '\n') {
            line++;
            charPositionInLine = 0;
        }
    }

 /*****************************************************************************
  * Implementation of the method defined in IntStream interface.
  * 
  * Gets the value of the symbol at offset i from the current position.
  * When i==1, this method returns the value of the current symbol in the stream
  * (which is the next symbol to be consumed). When i==-1, this method returns
  * the value of the previously read symbol in the stream. It is not valid to
  * call this method with i==0, but the specific behavior is unspecified because
  * this method is frequently called from performance-critical code.
  * This method is guaranteed to succeed if any of the following are true:
  * - i > 0
  * - i == -1 and index() returns a value greater than the value of index() 
  * after the stream was constructed and LA(1) was called in that order. 
  * Specifying the current index() relative to the index after the stream was 
  * created allows for filtering implementations that do not return every symbol
  * from the underlying source. Specifying the call to LA(1) allows for lazily 
  * initialized streams.
  * - LA(i) refers to a symbol consumed within a marked region that has not yet
  * been released.
  * 
  * @return : value is unspecified if i lower than 0 and fewer than -i calls to
  * consume() have occurred from the beginning of the stream before calling this
  * method.
  * 
  * @param i : If i represents a position at or beyond the end of the stream, 
  * this method returns EOF.
  * 
  * @Throws:
  * UnsupportedOperationException: if the stream does not support retrieving the
  * value of the specified symbol
  ***/
    @Override
    public int LA(int i) {
//        System.out.println("ANTLRv4CharStream: LA(" + i + ")");
        
        if (i == 0) {
            return 0; // undefined
        }

        int c = 0;
        for (int j = 0; j < i; j++) {
            c = read();
        }
        backup(i);
        return c;
    }
    

 /*****************************************************************************
  * Implementation of the method defined in IntStream interface.
  * 
  * A mark provides a guarantee that seek() operations will be valid over a 
  * "marked range" extending from the index where mark() was called to the 
  * current index(). This allows the use of streaming input sources by 
  * specifying the minimum buffering requirements to support arbitrary 
  * lookahead during prediction.
  * 
  * The returned mark is an opaque handle (type int) which is passed to 
  * release() when the guarantees provided by the marked range are no longer 
  * necessary. When calls to mark()/release() are nested, the marks must be 
  * released in reverse order of which they were obtained. Since marked regions
  * are used during performance-critical sections of prediction, the specific 
  * behavior of invalid usage is unspecified (i.e. a mark is not released, or a
  * mark is released twice, or marks are not released in reverse order from 
  * which they were created).
  * 
  * The behavior of this method is unspecified if no call to an initializing 
  * method has occurred after this stream was constructed.
  * 
  * This method does not change the current position in the input stream.
  * 
  * The following example shows the use of mark(), release(mark), index(), and 
  * seek(index) as part of an operation to safely work within a marked region, 
  * then restore the stream position to its original value and release the mark.
  * 
  * IntStream stream = ...;
  * int index = -1;
  * int mark = stream.mark();
  * try {
  *     index = stream.index();
  *  // perform work here...
  * } finally {
  *     if (index != -1) {
  *         stream.seek(index);
  *     }
  *     stream.release(mark);
  * }
  * 
  * @return: An opaque marker which should be passed to release() when the marked range is no longer required.
  */
    @Override
    public int mark() {
        if (markers == null) {
            markers = new ArrayList<>();
            markers.add(null); // depth 0 means no backtracking, leave blank
        }
        markDepth++;
        CharStreamState state;
        if (markDepth >= markers.size()) {
            state = new CharStreamState();
            markers.add(state);
        } else {
            state = markers.get(markDepth);
        }
        state.index = index;
        state.line = line;
        state.charPositionInLine = charPositionInLine;
        lastMarker = markDepth;

        return markDepth;
    }
    
 /***************************************
  * Implementation of the method defined in IntStream interface.
  * 
  * This method releases a marked range created by a call to mark().
  * Calls to release() must appear in the reverse order of the corresponding 
  * calls to mark(). If a mark is released twice, or if marks are not released
  * in reverse order of the corresponding calls to mark(), the behavior is 
  * unspecified.
  * 
  * For more information and an example, see mark().
  * 
  * Parameters:
  * @param marker : A marker returned by a call to mark().
  */
    @Override
    public void release(int marker) {
        // unwind any other markers made after m and release m
        markDepth = marker;
        // release this marker
        markDepth--;
    }
    
  /*****************************************************************
   * Implementation of the method coming from IntStream.
   * 
   * @return : Returns the total number of symbols in the stream, including a
   * single EOF symbol.
   * 
   * @Throws:
   * - UnsupportedOperationException - if the size of the stream is unknown.
   */
    @Override
    public int index() {
        return index;
    }
    
 /************************************************************************
  * Implementation of the method coming from IntStream.
  * 
  * Set the input cursor to the position indicated by i.
  * If the specified index lies past the end of the stream, the operation
  * behaves as though index was the index of the EOF symbol. After this method 
  * returns without throwing an exception, then at least one of the following 
  * will be true:
  * - index() will return the index of the first symbol appearing at or after 
  * the specified index. Specifically, implementations which filter their  
  * sources should automatically adjust index forward the minimum amount 
  * required for the operation to target a non-ignored symbol.
  * - LA(1) returns EOF.
  * This operation is guaranteed to not throw an exception if index lies within
  * a marked region. For more information on marked regions, see mark(). The 
  * behavior of this method is unspecified if no call to an initializing method
  * has occurred after this stream was constructed.
  * 
  * @param i : The absolute index to seek to.
  */
    @Override
    public void seek(int i) {
        if (i < this.index) {
            backup(this.index - i);
            this.index = i; // just jump; don't update stream state (line, ...)
            return;
        }

        // seek forward, consume until p hits index
        while (this.index < i) {
            consume();
        }
    }
 
    
 /*****************************************************************************
  * Implementation of the method coming from IntStream.
  * 
  * @return : the total number of symbols in the stream, including a single EOF
  * symbol.
  * 
  * @throw:
  * - UnsupportedOperationException : if the size of the stream is unknown.
  *****************************************************************************/
    @Override
    public int size() {
        return 2147483647; // We do not have the size so we put it at maximum for
        // being a  ble to call CommonToken.getText() that calls this method
        // for checking it is not arrived ar end
    }
    
 /*****************************************************************************
  * Implementation of the method coming from IntStream.
  * 
  * @return : Gets the name of the underlying symbol source. This method returns a 
  * non-null, non-empty string. If such a name is not known, this method returns
  * UNKNOWN_SOURCE_NAME.
  * 
  **/
    @Override
    public String getSourceName() {
        return name;
    }
    
    
 /****
  * Implementation of the method coming from CharStream.
  * 
  * This method returns the text for a range of characters within this input 
  * stream. This method is guaranteed to not throw an exception if the specified
  * interval lies entirely within a marked range. For more information about 
  * marked ranges, see IntStream.mark().
  * 
  * @param intrvl: an interval within the stream
  * 
  * @return: the text of the specified interval.
  * 
  * @throw:
  * - NullPointerException : if interval is null
  * - IllegalArgumentException : if interval.a lower than 0, or if interval.b 
  *   greater than interval.a- 1, or if interval.b lies at or past the end of 
  *   the stream
  * - UnsupportedOperationException : if the stream does not support getting the
  *   text of the specified interval
  ***/
    @Override
    public String getText(Interval intrvl) {
        int start = intrvl.a;
        int end = intrvl.b;
/*
        CharSequence cs = input.readText(start, end);
*/
     // most of the time length equals to input.readLength() but sometimes
     // it equals to input.readLength() - 1
        int length = end - start + 1; 
     // The ANTLR CharStream interface & NetBeans LexerInput class have a different
     // logic
     // Here, we always want to read from 0 to input.readLength()
     //   System.out.println("ANTLRv4CharStream:getText(Interval) : length=" + length + " readLength()=" + input.readLength());
        CharSequence cs = input.readText(0, length);
        return cs.toString();
    }

    
    private int read() {
        int result = input.read();
        if (result == LexerInput.EOF) {
            result = CharStream.EOF;
        }
//        System.out.println("ANTLRv4CharStream : read char=" + String.valueOf((char) result) + " ASCII code=" + result);
        return result;
    }
    
    
    private void backup(int count) {
        input.backup(count);
    }
}