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

import java.awt.Component;

import java.lang.reflect.InvocationTargetException;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Set;

import javax.swing.SwingUtilities;
import org.netbeans.api.project.Project;

import org.openide.explorer.ExplorerManager;

import org.openide.nodes.Children;
import org.openide.nodes.Node;

import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

/**
 *
 * @author Frédéric Yvon Vinet
 */
public class ANTLR4NodeRenamer implements Runnable {
    private final Project project;
    
    public ANTLR4NodeRenamer(Project project) {
        this.project = project;
    }
    
    
    @Override
    public void run() {
        boolean antlrNodeFound = false;
        while (!antlrNodeFound) {
         // In order to find the antlr 4 node in Projects tab associated
         // to the opened project, we have to:
         // 1°) retrieve TopComponent registry,
         // 2°) retrieve opened TopComponents,
         // 3°) find the TopComponent representing the Projects tab in
         //     opened TopComponents,
         // 4°) if Projects tab is closed then we open it through
         //     the window manager, then on next loop current process
         //     will go in step 5,
         // 5°) retrieve any of its components (the recovered
         //     TopComponent does not have registered ExplorerManager.
         //     Provider so we have to go down to its components for
         //     reretrieving an Explorer.Provider),
         // 6°) retrieve the Explorer.Provider of this component (each
         //     component has is ist own Explorer.Provider so different
         //     components have different Explorer.Provider but the
         //     subcomponents of the same TopComponent have the same
         //     ExplorerManager that's why we may retrieve any
         //     subcomponent of TopComponent),
         // 7°) retrieve the ExplorerManager,
         // 8°) retrieve its root context (its root node),
         // 9°) retrieve its child nodes,
         // 10°) find the project root node in these child nodes,
         // 11°) retrieve its child nodes,
         // 12°) find antlr 4 node in its child nodes.
         // Step 1
            TopComponent.Registry registry = TopComponent.getRegistry();
            
         // Step 2
            Set<TopComponent> topComponents = registry.getOpened();
            
         // Step 3
            Iterator<TopComponent> it = topComponents.iterator();
            TopComponent projectsTab = null;
            boolean projectTabFound = false;
            while (it.hasNext() && !projectTabFound) {
                TopComponent topComponent = it.next();
//                System.out.println("- top component name=" + topComponent.getName());
                if (topComponent.getName().equals("Projects")) {
                    projectTabFound = true;
                    projectsTab = topComponent;
                }
            }
         // If you have opened a project when Project tab was open and
         // then you closed Project tab then if you open a new project,
         // Project tab will be opened and so will be found in opened
         // TopComponent registry.
         // But if you closed Project tab before any project has been
         // loaded then Project tab will stay closed and so will not be
         // found.
            if (projectsTab == null) {
//                System.out.println("Projects tab is closed or does not exist yet!");
             // Step 4
             // We cannot call the window manager directly (its access is
             // restricted to AWT / Swing threads) so we have to encapsulate
             // its call in a runnable object that will be started inside a
             // Swing threading context
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                     // we must find project tab by another way
                        WindowManager wm = WindowManager.getDefault();
                        TopComponent projectTab = wm.findTopComponent("projectTabLogical_tc");
                        if (projectTab != null) {
//                            System.out.println("Project tab found and opened");
                            projectTab.open();
                        }
//                        } else
//                            System.out.println("Project tab not found");
                    }
                };
                try {
                 // We call our runnable in a swing thread context and we wait
                 // the end of its execution (it is useless to continue while 
                 // project tab is not opened)
                    SwingUtilities.invokeAndWait(runnable);
                } catch(InvocationTargetException |
                        InterruptedException        ex) {
                }
            } else {
//                System.out.println("Projects tab is open and found!");
             // Step 5
                Component anySubComponent = projectsTab.getComponent(0);
                        
             // Step 6
                ExplorerManager.Provider projectTabEMP = (ExplorerManager.Provider)
                                SwingUtilities.getAncestorOfClass
                                               (ExplorerManager.Provider.class,
                                                anySubComponent               );
/*
                if (projectTabEMP==null)
                    System.out.println("emp on subcomponent of topComponent is null");
                else {
                    System.out.println("emp on subcomponent of topComponent is not null");
                }
*/
             // Step 7
                ExplorerManager projectTabEM = projectTabEMP.getExplorerManager();
                        
             // Step 8
                Node projectTabRootNode = projectTabEM.getRootContext();
//                System.out.println("root node name=" + projectTabRootNode.getName());
//                System.out.println("root node display name=" + projectTabRootNode.getDisplayName());
                        
             // Step 9
                Children projectTabChildren = projectTabRootNode.getChildren();
                Node[] projectNodes = projectTabChildren.getNodes();
                        
             // Step 10
                boolean projectNodeFound = false;
                int j = 0;
             // it is important not to forget to call toString() for making
             // work equals method
                String projectDir = project.getProjectDirectory().toURL().toString();
                Node projectNode = null;
                while ((j < projectNodes.length) &&
                       !projectNodeFound           ) {
                    projectNode = projectNodes[j++];
//                    System.out.println("- node name=" + projectNode.getName());
//                    System.out.println("  node display name=" + projectNode.getDisplayName());
//                    System.out.println("  project root dir URL=" + projectDir);
                    if (projectNode.getName().equals(projectDir)) {
//                        System.out.println("  Project node found!");
                        projectNodeFound = true;
                    }
                }
                        
             // Normally project node cannot be not found except in case
             // of NetBeans shutdown
                if (projectNodeFound) {
                 // Step 11
                    Children projectNodeChildren = projectNode.getChildren();
                            
                 // Step 12
                    Enumeration<Node> projectNodeSubNodes = projectNodeChildren.nodes();
//                    System.out.println("  child node list:");
                    while (projectNodeSubNodes.hasMoreElements() &&
                           !antlrNodeFound                         ) {
                        Node subNode = projectNodeSubNodes.nextElement();
//                        System.out.println("  + node name=" + subNode.getName());
//                        System.out.println("    node display name=" + subNode.getDisplayName());
                        if (subNode.getName().equals("6GeneratedSourceRootantlr4")       &&
                            subNode.getDisplayName().equals("Generated Sources (antlr4)")  ) {
                            Children possibleAntlr4DirChildren = subNode.getChildren();
                            Enumeration<Node> possibleAntlr4DirNodes
                                            = possibleAntlr4DirChildren.nodes();
//                            System.out.println("    child node list:");
                            while (possibleAntlr4DirNodes.hasMoreElements() &&
                                   !antlrNodeFound                            ) {
                                Node childNode = possibleAntlr4DirNodes.nextElement();
//                                System.out.println("    * node name=" + childNode.getName());
//                                System.out.println("      node display name=" + childNode.getDisplayName());
                                if (childNode.getName().equals("imports")) {
//                                    System.out.println("      Right 'Generated Sources (antlr4)' node found for project " + project.getProjectDirectory().getName());
                                    antlrNodeFound = true;
                                    subNode.setDisplayName("Source ANTLR grammars");
                                 // Very strange: it changes the name of all imports
                                 // nodes except th right one that is the child
                                 // node of the found subnode!!!
//                                    childNode.setDisplayName("Imports");
                                }
                            }
                        }
                    }
                }
            }
//            System.out.println("");

            if (!antlrNodeFound) {
                try {
                 // This time must not be lower than 250 ms for preventing 
                 // a strange side effect: some antlr project nodes may not
                 // be renamed even though setDisplayName() is called!
                    Thread.sleep(250); 
                } catch (InterruptedException ex) {
                    antlrNodeFound = true;
                }
            }
        }
    }
}