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
package org.nemesis.antlr.v4.netbeans.v8.project.helper.java;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Frédéric Yvon Vinet
 */
public class JavaSourceClass {
    protected final String _package;
    protected final String simpleName;

    public String getPackage() {
        return _package;
    }

    public String getSimpleName() {
        return simpleName;
    }
    
    public String getName() {
        StringBuilder name = new StringBuilder();
        if (_package == null) {
            name.append(simpleName);
        } else {
            name.append(_package);
            name.append(".");
            name.append(simpleName);
        }
        return name.toString();
    }
    
    
    public JavaSourceClass(String _package, String name) {
        assert name != null;
        if (_package != null &&
            _package.equals(""))
            this._package = null;
        else
            this._package = _package;
        this.simpleName = name;
    }
    
    
    public boolean equals(JavaSourceClass otherJavaClass) {
        return this.getName().equals(otherJavaClass.getName());
    }
    
    
    public String getLocalFilePath() {
     // step 1: We extract the file name from name
     // if our Java class is an inner class then name may contain a parent class
     // that is our file name else the file name is the class name contained in 
     // name
        String fileName;
        int index = simpleName.indexOf(".");
        if (index == -1) {
            fileName = simpleName;
        } else {
            fileName = simpleName.substring(0, index);
        }
        
     // step 2: We build thz directory path string corresponding to our package
     // if there is some
        Path path;
        if (_package != null) {
            String packagePath = _package.replace(".", System.getProperty("file.separator"));
            path = Paths.get(packagePath, fileName);
        } else {
            path = Paths.get(fileName);
        }
        return path.toString();
    }
}
