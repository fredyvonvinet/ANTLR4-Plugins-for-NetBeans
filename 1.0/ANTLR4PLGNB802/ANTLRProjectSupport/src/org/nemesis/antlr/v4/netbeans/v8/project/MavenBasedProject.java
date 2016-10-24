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
package org.nemesis.antlr.v4.netbeans.v8.project;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import org.nemesis.antlr.v4.netbeans.v8.project.action.J2SEProjectToBeAdapted;
import org.nemesis.antlr.v4.netbeans.v8.project.action.TaskException;

import org.netbeans.api.project.Project;

import org.openide.filesystems.FileObject;


/**
 *
 * @author Frédéric Yvon Vinet
 */
public class MavenBasedProject extends J2SEProjectToBeAdapted {
    private static final String GRAMMAR_DIRECTORY_NAME = "src/main/antlr4";
    private static final String IMPORTED_GRAMMAR_DIRECTORY_NAME = "src/main/antlr4/imports";
    
    private static final String LINE_TERMINATOR = System.getProperty("line.separator");
    
    public MavenBasedProject(Project project) {
        super(project);
    }
    
    
    @Override
    public void addANTLRSupport() throws TaskException {
     // Task 1: we create the grammar directory
        FileObject projectDirectory = project.getProjectDirectory();
        File grammarDirectory = createANTLRGrammarDirectories(projectDirectory);
        
     // Task 2: we declare the ANTLR 4.5 Maven plugin into POM file
        declareANTLRPlugininPOM(projectDirectory);
    }
    
    
    private File createANTLRGrammarDirectories(FileObject projectDirectory)
        throws TaskException {
     // We try to create the directory, if it already exists then an 
     // IOException will be raised
        String projectDirectoryPathName = projectDirectory.getPath();
        final FileSystem fs = FileSystems.getDefault();
        Path grammarDirectoryPath = fs.getPath(projectDirectoryPathName, GRAMMAR_DIRECTORY_NAME);
        File grammarDirectory = grammarDirectoryPath.toFile();
        if (!grammarDirectory.exists()) {
            grammarDirectory.mkdirs();
            out.println("* ... ANTLR grammar file directory created              *");
         // At that point, we can be sure that the directory didn't exist so
         // ANTLR wasn't deployed in that project so we can do everything that
         // is required for a right ANTLR deployment
        } else {
            out.println("* ... ANTLR grammar directory already exists            *");
        }
        
        Path importedGrammarDirectoryPath = fs.getPath(projectDirectoryPathName, IMPORTED_GRAMMAR_DIRECTORY_NAME);
        File importedGrammarDirectory = importedGrammarDirectoryPath.toFile();
        if (!importedGrammarDirectory.exists()) {
            importedGrammarDirectory.mkdirs();
            out.println("* ... ANTLR imported grammar file directory created     *");
         // At that point, we can be sure that the directory didn't exist so
         // ANTLR wasn't deployed in that project so we can do everything that
         // is required for a right ANTLR deployment
        } else {
            out.println("* ... ANTLR imported grammar directory already exists   *");
        }

        return grammarDirectory;
    }
    
    
    private void declareANTLRPlugininPOM(FileObject projectDirectory) 
            throws TaskException {
        String projectDirectoryPathName = projectDirectory.getPath();
        final FileSystem fs = FileSystems.getDefault();
        Path pOMPath = fs.getPath(projectDirectoryPathName, "pom.xml");
        List<String> lines;
        try {
            lines = Files.readAllLines(pOMPath, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            err.println("* Unable to find/read POM file in project directory     *");
            throw new TaskException();
        }
        
     // We parse the lines for putting on several lines the element build if we
     // find one
        List<String> lines2 = putOnSeveralLines(lines, "build", "project", 1);
        lines2 = putOnSeveralLines(lines2, "pluginManagement", "build", 2);
        lines2 = putOnSeveralLines(lines2, "plugins", "pluginManagement", 3);
        lines2 = putOnSeveralLines(lines2, "plugins", "build", 2);
        lines2 = putOnSeveralLines(lines2, "dependencyManagement", "project", 1);
        lines2 = putOnSeveralLines(lines2, "dependencies", "dependencyManagement", 2);
        lines2 = putOnSeveralLines(lines2, "dependencies", "project", 1);

     // We parse the lines for discovering what XML elements must be recovred
     // that is plugin elements from build/pluginManagement/plugins element and 
     // plugin elements from build element
        boolean buildMarkup = false;
        boolean intoBuildMarkup = false;
        
        boolean pluginManagementMarkup = false;
        boolean intoPluginManagement = false;
        
        boolean pluginsMarkupinManagementMarkup = false;
        boolean intoPluginsInPluginManagement = false;
        
        boolean pluginsMarkup = false;
        
        boolean intoDependencyManagement = false;
        boolean dependencyManagementMarkup = false;
        
        boolean intoDependenciesInDependencyManagement = false;
        boolean dependenciesInDependencyManagementMarkup = false;
        
        boolean dependenciesMarkup = false;
        boolean intoDependencies = false;
        
        Iterator<String> it = lines2.iterator();
        String line;
        while (it.hasNext()) {
            line = it.next();
            if (line.contains("<build")) {
                intoBuildMarkup = true;
                buildMarkup = true;
            } else if (line.contains("<dependencyManagement")) {
                intoDependencyManagement = true;
                dependencyManagementMarkup = true;
            } if (!intoDependencyManagement && line.contains("<dependencies")) {
                intoDependencies = true;
                dependenciesMarkup = true;
            } else if (intoBuildMarkup) {
                if (line.contains("<pluginManagement")) {
                    intoPluginManagement = true;
                    pluginManagementMarkup = true;
                } else if (intoPluginManagement) {
                    if (line.contains("<plugins")) {
                        pluginsMarkupinManagementMarkup = true;
                        intoPluginsInPluginManagement = true;
                    } else if (line.contains("</plugins")) {
                        intoPluginsInPluginManagement = false;
                    } else if (line.contains("</pluginManagement")) {
                        intoPluginManagement = false;
                    }
                } else if (!intoPluginManagement && line.contains("<plugins")) {
                    pluginsMarkup = true;
                } else if (line.contains("</build"))
                    intoBuildMarkup = false;
            } else if (intoDependencyManagement) {
                if (line.contains("dependencies")) {
                    dependenciesInDependencyManagementMarkup = true;
                    intoDependenciesInDependencyManagement = true;
                } else if (line.contains("</dependencies")) {
                    intoDependenciesInDependencyManagement = false;
                } else if (line.contains("</dependencyManagement")) {
                    intoDependencyManagement = false;
                }
            } else if (intoDependencies) {
                if (line.contains("</dependencies"))
                    intoDependencies = false;
            }
        }
        
        intoDependencyManagement = false;
        intoDependenciesInDependencyManagement = false;
        intoDependencies = false;
        intoPluginManagement = false;
     // Now we write the output file
        try (
            OutputStream out = Files.newOutputStream
                (pOMPath                             ,
                 StandardOpenOption.TRUNCATE_EXISTING,
                 StandardOpenOption.WRITE            );
        ) {
            it = lines2.iterator();
            while (it.hasNext()) {
                line = it.next();
                
             // We manage dependencyManagement for ANTLR
                if (dependencyManagementMarkup) {
                    if (dependenciesInDependencyManagementMarkup) {
                        if (intoDependenciesInDependencyManagement) {
                         // So we have to insert our dependency at the end of
                         // dependencies
                            if (line.contains("</dependencies"))
                                insertANTLRDependencyElement(out, "    ");
                        }
                        if (line.contains("<dependencyManagement"))
                            intoDependencyManagement = true;
                        else if (line.contains("</dependencyManagement"))
                            intoDependencyManagement = false;
                        else if (intoDependencyManagement && line.contains("<dependencies"))
                            intoDependenciesInDependencyManagement = true;
                        else if (intoDependenciesInDependencyManagement && line.contains("</dependencies"))
                            intoDependenciesInDependencyManagement = false;
                    } else {
                     // So we have to insert all dependencies element at the
                     // end of dependencyManagement
                        if (line.contains("</dependencyManagement")) {
                            intoDependencyManagement = false;
                            insertFullDependenciesElement(out, "    ");
                        } else if (line.contains("<dependencyManagement"))
                            intoDependencyManagement = true;
                    }
                } else {
                 // We wait for the end of the project element for adding our
                 // <dependencyManagement> element
                    if (line.contains("</project>"))
                        insertFullDependencyManagementElement(out);
                }
                
             // We manage dependencies for ANTLR
                if (dependenciesMarkup) {
                 // Since there is some dependencies to recover, we wait for the
                 // end of dependencies for 
                    if (!intoDependencyManagement && line.contains("</dependencies"))
                        insertANTLRDependencyElement(out, "");
                } else {
                 // We wait for the end of the project element for adding our
                 // <dependencies> element
                    if (line.contains("</project>"))
                        insertFullDependenciesElement(out, "");
                }
                
             // We manage the ANTLR plugin declaration
                if (buildMarkup) {
                    if (pluginManagementMarkup) {
                        if (intoPluginManagement) {
                            if (pluginsMarkupinManagementMarkup) {
                             // We wait for the end of the plugins element for
                             // inserting our <plugin> element
                                if (line.contains("</plugins"))
                                    insertPluginElement(out, "    ");
                            } else {
                             // We wait for the end of the pluginManagement element
                             // for adding our <plugins> element
                                if (line.contains("</pluginManagement"))
                                    insertFullPluginsElement(out, "    ");
                            }
                        }
                        if (line.contains("<pluginManagement"))
                            intoPluginManagement = true;
                        if (line.contains("</pluginManagement"))
                            intoPluginManagement = false;
                    } else {
                     // We wait for the end of the build element for adding our
                     // <pluginManagement> element
                        if (line.contains("</build"))
                            insertFullPluginManagementElement(out);
                    }
                    if (pluginsMarkup) {
                     // Only if we are outside pluginManagement element,
                     // we wait for the end of the plugins element for inserting
                     // our <plugin> element
                        if (!intoPluginManagement && line.contains("</plugins"))
                            insertPluginElement(out, "");
                    } else {
                     // We wait for the end of the build element for inserting
                     // our <plugins> element
                        if (line.contains("/build"))
                            insertFullPluginsElement(out, "");
                    }
                } else {
                    if (line.contains("</project>"))
                        insertFullBuildElement(out);
                }

                out.write(line.getBytes());
                out.write(LINE_TERMINATOR.getBytes());
            }
        } catch (IOException ex) {
            err.println("* Unable to write pom.xml file");
            throw new TaskException();
        }
        
        out.println("* ... Maven plugin for ANTLR 4 declared in POM          *");
    }
    
        
    private List<String> putOnSeveralLines
            (List<String> lines                  ,
             String       elementName            ,
             String       parentElementName      ,
             int          elementIndentationLevel) {
     // We compute the identation from the indentation level
        StringBuilder indentation = new StringBuilder();
        for (int i = 0; i < elementIndentationLevel; i++)
            indentation.append("    ");
        
        String startingMarkup = "<" + elementName;
        String endingMarkup = "</" + elementName;
//        out.println();
//        out.println("élément recherché=" + elementName);
//        out.println("élément père de l'élément recherché=" + parentElementName);
        
        ArrayList<String> lines2 = new ArrayList<>();
        Iterator<String> it = lines.iterator();
        String line;
        String subComponent, subComponent2;
        int begin, start, end;
        boolean searchingForEndOfMarkup = false;
        boolean inParent = false;
        Stack<String> parents = new Stack<>();
        String currentParent = null;

        while (it.hasNext()) {
            line = it.next();
//            System.out.println("current line=" + line);
            if (searchingForEndOfMarkup) {
                if (line.contains(">")) {
                    searchingForEndOfMarkup = false;
                 // Everything that is between ">" and the end of line must be
                 // put in another line
                    start = line.indexOf(">");
                    subComponent = line.substring(start + 1);
                    lines2.add(subComponent);
                }
            } else {
                if (currentParent != null) {
                    if (currentParent.equals(parentElementName))
                        inParent = true;
                    else
                        inParent = false;
                }
                if (inParent && line.contains(startingMarkup)) {
//                    System.out.println("entrée dans l'élément recherché");
                    begin = line.indexOf(startingMarkup);
                 // we recover what is before the element and put it in a line
                 // if it is not white space characters
                    subComponent = line.substring(0, begin);
                    subComponent2 = subComponent.trim();
                    if (subComponent2.length() != 0)
                        lines2.add(subComponent);
                    lines2.add(indentation.toString() + startingMarkup + ">");

                    start = line.indexOf(">", begin);
                    if (start == -1) {
                        searchingForEndOfMarkup = true;
                    } else {
                     // Everything that is between ">" and the end of line (or
                     // the ending markup) must be put in another line if the
                     // string is not a white space string
                        subComponent = line.substring(start + 1);
                        if (subComponent.contains(endingMarkup)) {
                            end = subComponent.indexOf(endingMarkup);
                            subComponent2 = subComponent.substring(0, end);
                            subComponent2 = subComponent2.trim();
                            if (!subComponent2.equals(""))
                                lines2.add(indentation.toString() + "    " + subComponent2);
                            lines2.add(indentation.toString() + endingMarkup + ">");
                         // We must find the end of the ending markup for next step
                            start = subComponent.indexOf(">", end);
                            if (start == -1)
                                searchingForEndOfMarkup = true;
                            else {
                            // We must not forget what is after the ending markup 
                            // if there is something there
                               subComponent = subComponent.substring(start + 1);
                               subComponent = subComponent.trim();
                               if (!subComponent.equals(""))
                                   lines2.add(indentation.toString() + subComponent);
                            }
                        } else {
                            subComponent2 = subComponent.trim();
                            if (subComponent2.length() != 0)
                                lines2.add(indentation.toString() + subComponent);
                        }
                    }
                } else {
                    lines2.add(line);
                }
             // We update the stack of parents
                if (line.contains("<")) {
                    currentParent = getParentAtTheEndOfLine(parents, line);
                }
            }
        }
        return lines2;
    }
    
    
    private String getParentAtTheEndOfLine(Stack<String> parents, String line) {
        String currentMarkup;
        Iterator<String> markupIt = new MarkupIterator(line);
        while (markupIt.hasNext()) {
            currentMarkup = markupIt.next();
//            out.println("getParentAtTheEndOfLine(): current markup=" + currentMarkup);
         // At this point there is two possibilities:
         // - the markup delimits the entrance into an element (the first character
         //   cannot be a / character),
         // - the markup delimits the exit from an element (the first character is
         //   a / character.
            if (currentMarkup.startsWith("/")) {
                String elementName = parents.pop();
//                out.println("getParentAtTheEndOfLine(): end of element " + elementName);
            } else {
                parents.push(currentMarkup);
//                out.println("getParentAtTheEndOfLine(): start of element " + currentMarkup);
            }
        }
        String parent;
        if (!parents.empty()) {
            parent = parents.peek();
//            out.println("getParentAtTheEndOfLine(): parent at the end of line=" + parent);
        } else {
            parent = null;
        }
        return parent;
    }
    
    
    private void insertFullDependencyManagementElement(OutputStream out)
            throws IOException {
        out.write("    <dependencyManagement>".getBytes());
        out.write(LINE_TERMINATOR.getBytes());
        insertFullDependenciesElement(out, "    ");
        out.write("    </dependencyManagement>".getBytes());
        out.write(LINE_TERMINATOR.getBytes());
    }
    
    
    private void insertFullDependenciesElement(OutputStream out, String prefix)
            throws IOException {
        out.write((prefix + "    <dependencies>").getBytes());
        out.write(LINE_TERMINATOR.getBytes());
        insertANTLRDependencyElement(out, prefix);
        out.write((prefix + "    </dependencies>").getBytes());
        out.write(LINE_TERMINATOR.getBytes());
    }
    
    
    private void insertANTLRDependencyElement(OutputStream out, String prefix)
            throws IOException {
        out.write((prefix + "        <dependency>").getBytes());
        out.write(LINE_TERMINATOR.getBytes());
        out.write((prefix + "            <groupId>org.antlr</groupId>").getBytes());
        out.write(LINE_TERMINATOR.getBytes());
        out.write((prefix + "            <artifactId>antlr4-maven-plugin</artifactId>").getBytes());
        out.write(LINE_TERMINATOR.getBytes());
        out.write((prefix + "            <version>4.5.3</version>").getBytes());
        out.write(LINE_TERMINATOR.getBytes());
        out.write((prefix + "            <type>maven-plugin</type>").getBytes());
        out.write(LINE_TERMINATOR.getBytes());
        out.write((prefix + "        </dependency>").getBytes());
        out.write(LINE_TERMINATOR.getBytes());
    }
    
   /*
     The XML Schema for POM file declares that each element may be declared in
     any order.
     So we choose to write the build element at the end
     We write each line till we find where we can create the <build> XML markup.
     Then we add it with its submarkups.
     Then we continue to write each line
    */
    private void insertFullBuildElement(OutputStream out) 
            throws IOException {
        out.write("    <build>".getBytes());
        out.write(LINE_TERMINATOR.getBytes());
        insertFullPluginManagementElement(out);
        insertFullPluginsElement(out, "");
        out.write("    </build>".getBytes());
        out.write(LINE_TERMINATOR.getBytes());
    }
    
    
    private void insertFullPluginManagementElement(OutputStream out) 
            throws IOException {
        out.write("        <pluginManagement>".getBytes());
        out.write(LINE_TERMINATOR.getBytes());
        insertFullPluginsElement(out, "    ");
        out.write("        </pluginManagement>".getBytes());
        out.write(LINE_TERMINATOR.getBytes());
    }
    
    
    private void insertFullPluginsElement(OutputStream out, String prefix) 
            throws IOException {
        out.write((prefix + "        <plugins>").getBytes());
        out.write(LINE_TERMINATOR.getBytes());
        insertPluginElement(out, prefix);
        out.write((prefix + "        </plugins>").getBytes());
        out.write(LINE_TERMINATOR.getBytes());
    }
    
    
    private void insertPluginElement(OutputStream out, String prefix) 
            throws IOException {
        out.write((prefix + "            <plugin>").getBytes());
        out.write(LINE_TERMINATOR.getBytes());
        out.write((prefix + "                <groupId>org.antlr</groupId>").getBytes());
        out.write(LINE_TERMINATOR.getBytes());
        out.write((prefix + "                <artifactId>antlr4-maven-plugin</artifactId>").getBytes());
        out.write(LINE_TERMINATOR.getBytes());
        out.write((prefix + "                <version>4.5.3</version>").getBytes());
        out.write(LINE_TERMINATOR.getBytes());
        out.write((prefix + "                <configuration>").getBytes());
        out.write(LINE_TERMINATOR.getBytes());
        out.write((prefix + "                    <libDirectory>src/main/antlr4/imports</libDirectory>").getBytes());
        out.write(LINE_TERMINATOR.getBytes());
        out.write((prefix + "                </configuration>").getBytes());
        out.write(LINE_TERMINATOR.getBytes());
        out.write((prefix + "                <executions>").getBytes());
        out.write(LINE_TERMINATOR.getBytes());
        out.write((prefix + "                    <execution>").getBytes());
        out.write(LINE_TERMINATOR.getBytes());
        out.write((prefix + "                        <goals>").getBytes());
        out.write(LINE_TERMINATOR.getBytes());
        out.write((prefix + "                            <goal>antlr4</goal>").getBytes());
        out.write(LINE_TERMINATOR.getBytes());
        out.write((prefix + "                        </goals>").getBytes());
        out.write(LINE_TERMINATOR.getBytes());
        out.write((prefix + "                    </execution>").getBytes());
        out.write(LINE_TERMINATOR.getBytes());
        out.write((prefix + "                </executions>").getBytes());
        out.write(LINE_TERMINATOR.getBytes());
        out.write((prefix + "            </plugin>").getBytes());
        out.write(LINE_TERMINATOR.getBytes());
    }
}
