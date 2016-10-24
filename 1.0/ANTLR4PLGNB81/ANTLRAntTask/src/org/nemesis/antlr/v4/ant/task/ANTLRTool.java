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
package org.nemesis.antlr.v4.ant.task;

import java.io.File;

class ANTLRTool {
    protected final String antlrLibrary;
    protected final String antlrDestdir;
    protected final boolean listener;
    protected final boolean visitor;
    protected final String codePackage;
    protected final boolean atn;
    
    protected static final String ANTLR_OUTPUT_DIR_OPTION = "-o";
    protected static final String ANTLR_DEPEND_OPTION = "-depend";
    protected static final String ANTLR_NO_LISTENER_OPTION = "-no-listener";
    protected static final String ANTLR_VISITOR_OPTION = "-visitor";
    protected static final String ANTLR_ATN_OPTION = "-atn";
    protected static final String ANTLR_PACKAGE_OPTION = "-package";
    protected static final String JAVA_CLASSPATH_OPTION = "-cp";
    protected static final String JAVA_EXEC;
    
    static {
        String javaExec = findJavaInterpreter();
        if (javaExec.contains(" ")) {
            JAVA_EXEC = "\"" + javaExec + "\"";
        } else {
            JAVA_EXEC = javaExec;
        }
    }

    public ANTLRTool(String  antlrLibrary,
                     String  antlrDestdir,
                     boolean listener    ,
                     boolean visitor     ,
                     String  codePackage ,
                     boolean atn         ) {
        this.antlrLibrary = antlrLibrary;
        this.antlrDestdir = antlrDestdir;
        this.listener = listener;
        this.visitor = visitor;
        this.atn = atn;
        this.codePackage = codePackage;
    }


    private static String findJavaInterpreter() {
        String javaHomeName = System.getProperty("java.home");
        if (javaHomeName == null) {
            throw new RuntimeException("java.home system property has been suppressed\nUnable to find the Java interpreter home directory");
        }

        File javaHome = new File(javaHomeName);
        if (!javaHome.exists()) {
            throw new RuntimeException("java.home property calue : " + javaHomeName + "\nThat directory does not exist.\nUnable to find the Java interpreter");
        }

        String javaCommandWithPath = null;

        File javaExec = getFileForCurrentOS(javaHome, "bin/java");
        if (javaExec != null) {
            javaCommandWithPath = javaExec.getAbsolutePath();
        } else {
            javaExec = getFileForCurrentOS(javaHome, "bin/java.exe");
            if (javaExec != null) {
                javaCommandWithPath = javaExec.getAbsolutePath();
            } else {
                javaCommandWithPath = "java";
            }
        }
        return javaCommandWithPath;
    }

    private static File getFileForCurrentOS(File dir, String localExecName) {
        String osSpecificPath = localExecName.replace('/', File.separatorChar);
        File file = new File(dir, osSpecificPath);
        if (!file.exists()) {
            return null;
        }
        return file;
    }
}