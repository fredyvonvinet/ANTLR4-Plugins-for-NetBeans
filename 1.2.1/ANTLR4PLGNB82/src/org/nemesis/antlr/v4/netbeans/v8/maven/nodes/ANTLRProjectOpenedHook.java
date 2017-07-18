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
package org.nemesis.antlr.v4.netbeans.v8.maven.nodes;

import java.io.File;

import org.netbeans.api.project.Project;
import org.netbeans.spi.project.ProjectServiceProvider;

import org.netbeans.spi.project.ui.ProjectOpenedHook;

import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;

/**
 *
 * @author Frédéric Yvon Vinet
 */
@ProjectServiceProvider 
    (service = ProjectOpenedHook.class         ,
     projectType = "org-netbeans-modules-maven")
public class ANTLRProjectOpenedHook extends ProjectOpenedHook {
    protected final Project project;

    public ANTLRProjectOpenedHook(Project project) {
        this.project = project;
    }

    @Override
    protected void projectOpened() {
//        System.out.println();
//        System.out.println("ANTLRProjectOpenedHook.projectOpened()");
        FileObject projectRootDir = project.getProjectDirectory();
        FileObject antlr4FO = projectRootDir.getFileObject("src/main/antlr4");
     // If the project is not ANTLR aware then antlr4FO will be null
        if (antlr4FO != null) {
            File antlr4Dir = FileUtil.toFile(antlr4FO);
         // src/main/antlr4 exists but we have to check it is a directory
            if (antlr4Dir.isDirectory())
                prepareNodeRenamingTask();
        }
    }


    @Override
    protected void projectClosed() {
//        System.out.println();
//        System.out.println("ANTLRProjectOpenedHook.projectClosed()");
    }
    
    
    private void prepareNodeRenamingTask() {
        Thread r = new Thread(new ANTLR4NodeRenamer(project));
        r.start();
    }
}