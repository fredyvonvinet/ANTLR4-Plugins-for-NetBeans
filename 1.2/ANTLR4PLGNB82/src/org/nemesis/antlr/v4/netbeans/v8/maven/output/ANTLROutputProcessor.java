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

import java.io.File;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.netbeans.modules.maven.api.output.OutputProcessor;
import org.netbeans.modules.maven.api.output.OutputVisitor;

import org.openide.filesystems.FileUtil;

/**
 * 
 * @author Frédéric Yvon Vinet
 */
public class ANTLROutputProcessor implements OutputProcessor {
    private static final String[] ANTLR_GOALS = new String[] {
        "mojo-execute#antlr4:antlr4", //NOI18N
    };
    /** @see org.codehaus.plexus.compiler.javac.JavacCompiler#compile */
    private static final String GROUP_GRAMMAR_PATH = "grammar";
    private static final String GROUP_LINE_NR = "linenr";
    private static final String GROUP_DESCRIPTION = "description";
    private static final String GROUP_DRIVE_NAME = "drive";
    private static final Pattern failPattern  = Pattern.compile
            ("(?<" + GROUP_GRAMMAR_PATH + ">[^\\s]+\\.g4)" + // named capturing group
             " " +
             "\\[" +
                 "(?<" + GROUP_LINE_NR + ">[0-9]+)"+ // named capturing group (line number)
                 "\\:" +
                 "([0-9]*)" + // non-named capturing group (column number)
             "\\]" +
             "\\: " +
             "[^\\:]+" + // 
             "\\:" +
             "(?<" + GROUP_DESCRIPTION + ">.*)", // NOI18N
             Pattern.DOTALL             );
    private static final Pattern windowsDriveInfoPattern = Pattern.compile
           ("(?:\\[INFO\\] )?" + // non-capturing group
            "Compiling " +
            "\\d+" + // 1 or n digits
            " source files? to " +
            "(?<" + GROUP_DRIVE_NAME + ">[A-Za-z]:)" + // named capturing group
            "\\\\.+");
    
    public ANTLROutputProcessor() {
//        System.out.println("ANTLROutputProcessor.ANTLROutputProcessor()");
    }

    @Override
    public String[] getRegisteredOutputSequences() {
        return ANTLR_GOALS;
    }

    
  /**
   * Called for each line in a Maven registered output sequence
   * @param line
   * @param outputVisitor 
   */
    @Override
    public void processLine(String line, OutputVisitor outputVisitor) {
//        System.out.println("ANTLROutputProcessor.processLine(String,OutputVisitor)");
        Matcher match = failPattern.matcher(line);
        if (match.matches()) {
            String grammarFilePath = match.group(GROUP_GRAMMAR_PATH);
            File grammarFile = new File(grammarFilePath);
            String lineNum = match.group(GROUP_LINE_NR);
            String description = match.group(GROUP_DESCRIPTION);
            int lineNumber;
            try {
                lineNumber = Integer.parseInt(lineNum);
            } catch (NumberFormatException exc) {
                lineNumber = -1;
            }
            outputVisitor.setOutputListener
                     (new ANTLRCodeGenerationListener
                            (grammarFile, lineNumber, description),
                      !description.contains("[deprecation]") ); //NOI18N
            FileUtil.refreshFor(grammarFile);
            StringBuilder newLine = new StringBuilder();
            newLine.append(grammarFilePath);
            newLine.append(":");
            newLine.append(lineNum);
            newLine.append(": ");
            newLine.append("error");
            newLine.append(":");
            newLine.append(description);
         // We update the output visitor with new line
            outputVisitor.setLine(newLine.toString());
        }    
    }

  /**
   * Called at the begining of a Maven registered output sequence
   * @param string
   * @param ov 
   */
    @Override
    public void sequenceStart(String string, OutputVisitor ov) {
    }

  /**
   * Called at the end of a Maven registered output sequence
   * @param string
   * @param ov 
   */
    @Override
    public void sequenceEnd(String string, OutputVisitor ov) {
    }

  /**
   * Called if a Maven registered output sequence fails
   * @param string
   * @param ov 
   */
    @Override
    public void sequenceFail(String string, OutputVisitor ov) {
    }
}