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
package org.nemesis.antlr.v4.netbeans.v8.maven.source;

import java.io.File;

import java.nio.file.Path;

import java.util.HashSet;
import java.util.Set;

import org.netbeans.api.project.Project;

import org.netbeans.modules.maven.spi.nodes.OtherSourcesExclude;

import org.netbeans.spi.project.ProjectServiceProvider;

import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;

/**
 * src/main/antlr4 must not be considered as an OtherSourceRoot but as a Java
 * source for enabling automatic indexing that is required for error badging 
 * management so we exclude it when this directory is present in the associated
 * project root directory.
 * 
 * @author  Frédéric Yvon Vinet
 */
@ProjectServiceProvider(
        service={OtherSourcesExclude.class     },
        projectType="org-netbeans-modules-maven")
public class ANTLRMavenSourcesImpl
       implements OtherSourcesExclude {
    private static final String ANTLR4 = "src/main/antlr4"; //NOI18N
    
    protected final Project       proj;
    protected final FileObject    projectDirectory;
    
    public ANTLRMavenSourcesImpl(Project project) {
//        System.out.println();
//        System.out.println("ANTLRMavenSourcesImpl.ANTLRMavenSourcesImpl(Project) : begin");
        this.proj = project;
        this.projectDirectory = proj.getProjectDirectory();
//        System.out.println("ANTLRMavenSourcesImpl.ANTLRMavenSourcesImpl(Project) : end");
    }
    
  /**
   * Method coming from MavenSourcesImpl and declared in interface
   * OtherSourcesExclude.
   * 
   * @return 
   */
    @Override
    public Set<Path> excludedFolders() {
//        System.out.println("ANTLRMavenSourcesImpl.excludedFolders() -> Set<Path>");
        HashSet<Path> answer = new HashSet<>();
        File projectDir = FileUtil.toFile(projectDirectory);
        File antlr4Dir = new File(projectDir, ANTLR4);
        if (antlr4Dir.exists()     &&
            antlr4Dir.isDirectory()  )
            answer.add(antlr4Dir.toPath());
/*
        System.out.println("- excluded folder number=" + answer.size());
        for (Path path : answer) {
            System.out.println("  * excluded folder path=" + path);
        }
*/
        return answer;
    }
}