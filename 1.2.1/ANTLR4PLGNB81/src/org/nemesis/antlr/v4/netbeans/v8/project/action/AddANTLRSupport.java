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
package org.nemesis.antlr.v4.netbeans.v8.project.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.nemesis.antlr.v4.netbeans.v8.project.AntBasedProject;
import org.nemesis.antlr.v4.netbeans.v8.project.MavenBasedProject;
import org.nemesis.antlr.v4.netbeans.v8.project.ProjectType;

import org.netbeans.api.project.Project;

import org.netbeans.api.project.ant.AntBuildExtender;

import org.netbeans.modules.java.j2seproject.J2SEProject;

import org.netbeans.modules.maven.api.NbMavenProject;

import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;

import org.openide.util.Lookup;
import org.openide.util.NbBundle.Messages;

import org.openide.windows.IOProvider;
import org.openide.windows.InputOutput;
import org.openide.windows.OutputWriter;

/**
 *
 * @author Frédéric Yvon Vinet
 */
@ActionID(
        category = "Project",
        id = "org.nemesis.antlr.v4.netbeans.v8.project.action.AddANTLRSupport"
)
@ActionRegistration(
        iconBase = "org/nemesis/antlr/v4/netbeans/v8/grammar/file/antlr-g4-file-type.png",
        displayName = "#CTL_AddANTLRSupport"
)
@ActionReference(
        path = "Menu/File",
        position = 650,
        separatorBefore = 625,
        separatorAfter = 675)
@Messages("CTL_AddANTLRSupport=Add ANTLR Support to project")
public final class AddANTLRSupport implements ActionListener {
    private static final InputOutput IO = IOProvider.getDefault().getIO
                                                         ("ANTLR plugin", true);
    
    private static final OutputWriter out = IO.getOut();
    private static final OutputWriter err = IO.getErr();
    
    private final Project     project;
    private final Lookup      projectLookup;
    private final ProjectType projectType;

    
    public AddANTLRSupport(Project project) {
        this.project = project;
        this.projectLookup = project.getLookup();
        this.projectType = getProjectType();
    }


    @Override
    public void actionPerformed(ActionEvent ev) {
        J2SEProjectToBeAdapted projectToBeAdapted;
        try {
            out.println("*********************************************************");
            out.println("* ANTLR project resource deployment: start              *");
            switch (projectType) {
                case ANT_BASED :
                    projectToBeAdapted = new AntBasedProject(project);
                    break;
                case MAVEN_BASED :
                    projectToBeAdapted = new MavenBasedProject(project);
                    break;
                default:
                    err.println("* Unmanaged type of project.                            *");
                    err.println("* Managed types of project are:                         *");
                    err.println("* - ant-based Java projects,                            *");
                    err.println("* - Maven-based Java projects.                          *");
                    throw new TaskException();
            }

         // Currently, the list of supported project types is:
         // - J2SE ant-based.
         // - J2SE Maven-based
         // If your project is a j2ee one, make a j2se library project where you
         // will develop your ANTLR project and make a dependency to it in your 
         // j2ee project
            boolean ok = checkProjectType();
            if (!ok) {
                err.println("* Your project is not a Java Standard Edition project.  *");
                err.println("* If your project is a Java Enterprise Edition (ant-    *");
                err.println("* based or maven-based) then:                           *");
                err.println("* 1°) create a Java Standard Edition project (ant-based *");
                err.println("*     or maven-based) for developping a library project,*");
                err.println("* 2°) add ANTLR support to your Java Standard Edition   *");
                err.println("*     project with ANTLR plugin,                        *");
                err.println("* 3°) add a dependency in your Enterprise Edition       *");
                err.println("*     project to the ANTLR Standard Edition one.        *");
            }
            
            projectToBeAdapted.addANTLRSupport();
            out.println("* ANTLR project resource deployment: end with SUCCESS   *");
            out.println("*********************************************************");
            out.println("");
            
         // We inform the user that it may change the used ANTLR release
            out.println("  The ANTLR plugin has configured your project for using the ANTLR 4.6 release.");
            out.println("  If your project requires another version, then:");
            switch (projectType) {
                case ANT_BASED:
                    out.println("  1°) download the required version of ANTLR for your project (the runtime release and the complete release),");
                    out.println("      (remark : the current ANTLR plugin supports all ANTLR 4.x releases)");
                    out.println("  2°) install them in NetBeans library repository");
                    out.println("  3°) change the antlr.runtime.jar property in your project.properties file");
                    out.println("      for pointing to your new ANTLR runtime library");
                    out.println("  4°) change the antlr.generator.jar property in your project.properties file");
                    out.println("      for pointing to your new ANTLR complete library");
                    break;
                case MAVEN_BASED:
                    out.println("  1°) open the POM file of your project");
                    out.println("  2°) search for the dependency for Maven ANTLR 4 plugin (<groupId>org.antlr</groupId>).");
                    out.println("      Normally, you should find one entry in local dependencies (project/dependencies)");
                    out.println("      and another one in global dependencies (project/dependencyManagement/dependencies),");
                    out.println("  3°) change the version element of the dependency you want to modify");
                    out.println("  4°) repeat the same changes in global plugin declaration (project/build/pluginManagement/plugins)");
                    out.println("      and local plugin declaration elements (project/build/plugins)");
                    break;
            }
        } catch (TaskException ex) {
            err.println("* ANTLR project resource deployment: end with FAILURE   *");
            err.println("*********************************************************");
        }
    }
    
    
    private ProjectType getProjectType() {
        ProjectType l_projectType = ProjectType.UNDEFINED;
        
        AntBuildExtender antBuildExtender =
                projectLookup.lookup(AntBuildExtender.class);
        
     // If an AntBuildExtender has been found then the project is an ant-based
     // one
        if (antBuildExtender != null)
            l_projectType = ProjectType.ANT_BASED;
        else {
            NbMavenProject nBMavenProject =
                                     projectLookup.lookup(NbMavenProject.class);
            if (nBMavenProject != null) {
                l_projectType = ProjectType.MAVEN_BASED;
            }
        }
        
        return l_projectType;
    }
    
    
    private boolean checkProjectType() throws TaskException {
        boolean ok = true;
        switch (projectType) {
            case ANT_BASED :
                J2SEProject j2seProject = projectLookup.lookup(J2SEProject.class);
                if (j2seProject == null) {
                    ok = false;
                }
                break;
            case MAVEN_BASED :
                NbMavenProject nBMavenProject =
                                     projectLookup.lookup(NbMavenProject.class);
                String packaging = nBMavenProject.getPackagingType();
                if (!packaging.equals("jar")) {
                    ok = false;
                }
                break;
            default:
                ok = false;
                break;
        }
        return ok;
    }
}