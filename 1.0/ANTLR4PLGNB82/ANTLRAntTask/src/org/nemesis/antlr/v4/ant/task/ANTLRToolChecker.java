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
import java.lang.reflect.Field;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import org.apache.tools.ant.BuildException;

class ANTLRToolChecker {
    private static final String TOOL_CLASS_NAME =
                                              "org.antlr.v4.Tool";
    private static final String CHARSTREAM_CLASS_NAME =
                                              "org.antlr.v4.runtime.CharStream";

    private static final String ANTLR_VERSION = "VERSION";
    public static String checkANTLRToolPresence(String library)
            throws BuildException {
        String version;
     // First step: We update the classpath for adding library
        File libraryFile = new File(library);
        if (!libraryFile.exists())
            throw new BuildException(library + " does not exist");
        if (!libraryFile.isFile())
            throw new BuildException(library + " is not a file");
        if (!libraryFile.canRead())
            throw new BuildException(library + " is not readable");

        URLClassLoader systemClassloader = (URLClassLoader)ClassLoader.getSystemClassLoader();
        Class systemClassLoaderClass = URLClassLoader.class;
        try {
            URL antlrLibraryURL = libraryFile.toURI().toURL();  
            Method method = systemClassLoaderClass.getDeclaredMethod("addURL", new Class[] { URL.class });
            method.setAccessible(true);
            method.invoke(systemClassloader, new Object[] { antlrLibraryURL });
        } catch (MalformedURLException ex) {
            throw new BuildException("Invalid classpath: " + library);
        } catch (NoSuchMethodException ex) {
            throw new BuildException("Strange! Unable to find addURL(URL) method in URLClassLoader class");
        } catch (SecurityException ex) {
            throw new BuildException("Strange! Unable to access addURL(URL) method in URLClassLoader class due to security");
        } catch (IllegalAccessException ex) {
            throw new BuildException("Strange! Unable to call addURL(URL) method in URLClassLoader class although we acquire the right to do it");
        } catch (IllegalArgumentException ex) {
            throw new BuildException("Strange! Unable to call addURL(URL) method in URLClassLoader class due to invalid object or parameter");
        } catch (InvocationTargetException ex) {
            throw new BuildException("Strange! The addURL(URL) method has been called but sent anexception\n" + ex.getCause().getMessage());
        }
     
        try {
            Class<?> tool = systemClassloader.loadClass(TOOL_CLASS_NAME);
            Field versionField = tool.getField(ANTLR_VERSION);
            Object objectValue = versionField.get(null);
            version = (String) objectValue;
        } catch (ClassNotFoundException ex) {
            throw new BuildException
                ("Unable to load ANTLR code generator\nclasspath: " +
                 library + "\nclass name: " + TOOL_CLASS_NAME);
        } catch (NoSuchFieldException |
                 IllegalAccessException ex) {
            throw new BuildException
                ("Unable to recover ANTLR version\nclasspath: " +
                 library + "\nclass name: " + TOOL_CLASS_NAME);
        }
        return version;
    }
}