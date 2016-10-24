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

import java.nio.file.Path;

import java.util.ArrayList;
import java.util.HashMap;

abstract class ANTLRFile {
    private static final HashMap<String, ANTLRFile> instances = new HashMap();

    public static ANTLRFile getInstance(String pathName) {
        return (ANTLRFile)instances.get(pathName);
    }
    
    
    protected final Path                 path;
    protected final ArrayList<ANTLRFile> filesThatDependsOnMe;
    protected final ArrayList<ANTLRFile> filesThatIDependOn;
    private         boolean              dependenceRecovered;
    
    public final Path getPath() {
        return this.path;
    }

    public final ArrayList<ANTLRFile> getFilesThatDependOnMe() {
        if (!this.dependenceRecovered) {
            this.dependenceRecovered = true;
            recoverDependences();
        }
        return this.filesThatDependsOnMe;
    }

    public final ArrayList<ANTLRFile> getFilesThatIDependOn() {
        if (!this.dependenceRecovered) {
            this.dependenceRecovered = true;
            recoverDependences();
        }
        return this.filesThatIDependOn;
    }

    protected final void addFileThatDependsOnMe(ANTLRFile file) {
        this.filesThatDependsOnMe.add(file);
    }

    protected final void addFileThatIDependOn(ANTLRFile file) {
        this.filesThatIDependOn.add(file);
    }

    public ANTLRFile(Path path) {
        instances.put(path.toString(), this);
        this.path = path;
        this.filesThatDependsOnMe = new ArrayList();
        this.filesThatIDependOn = new ArrayList();
        this.dependenceRecovered = false;
    }


    public abstract boolean isArtefact();
    protected abstract void recoverDependences();
}