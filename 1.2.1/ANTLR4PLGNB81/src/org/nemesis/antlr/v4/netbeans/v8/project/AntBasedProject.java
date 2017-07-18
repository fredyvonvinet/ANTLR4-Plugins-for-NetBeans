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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.nemesis.antlr.v4.netbeans.v8.project.action.J2SEProjectToBeAdapted;
import org.nemesis.antlr.v4.netbeans.v8.project.action.TaskException;

import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectManager;
import org.netbeans.api.project.ant.AntBuildExtender;
import org.netbeans.api.project.libraries.LibraryManager;

import org.netbeans.modules.java.j2seproject.J2SEProject;

import org.openide.filesystems.FileObject;

/**
 *
 * @author Frédéric Yvon Vinet
 */
public class AntBasedProject extends J2SEProjectToBeAdapted {
    private static final String GRAMMAR_DIRECTORY_NAME = "grammar";
    private static final String IMPORT_DIRECTORY_NAME = "imports";
    private static final String GRAMMAR_NODE_NAME = "Source ANTLR grammars";
    private static final String ANTLR4_ANT_TASK_DIRECTORY_NAME = "antext";
    private static final String ANT_BUILD_EXTENSION_FOR_ANTLR = "build-antlr4-impl.xml";
    
    private static final String LINE_TERMINATOR = System.getProperty("line.separator");
    private static final String FILE_SEPARATOR = System.getProperty("file.separator");
    
    private static final LibraryManager libraryManager = LibraryManager.getDefault();
   
    
    public AntBasedProject(Project project) {
        super(project);
    }
    
    
    @Override
    public void addANTLRSupport() throws TaskException {
     // Task 1: we create the grammar directory
        FileObject projectDirectory = project.getProjectDirectory();
        FileObject grammarDirectory = createANTLRGrammarDirectory(projectDirectory);
        
     // Task 2: We create the ant task directory that will host the Java library
     // containing the antlr4 ant task
        FileObject antTaskDirectory = createAntlr4AntTaskDirectory(projectDirectory);
     // We deploy the antlr4 ant task library
        File antlr4LibraryFile = createAntlr4AntExtensionLibrary(projectDirectory);
        
     // Task 3: The runtime and complete ANTLR 4.6 libraries have been
     // installed in NetBeans Library Repository by adding two Jave SE 
     // Library Descriptors to the project.
     // These installations are done only once at ANTLR plugin installation.
     // But we also add them in the lib directory of project.
        
     // Task 4: We copy the ant extension build XML file for ANTLR in the
     // nbproject directory
        File antlrBuildExtensionFile =
                    createANTBuildExtensionFileForANTLR(projectDirectory);
        
     // Task 5: We declare the extension in the main ant build XML file in the
     // root project directory
        integrateANTBuildExtensionFileForANTLR(antlrBuildExtensionFile);
        
     // Task 6: We add additional properties in project.properties file
     // (those properties are required by the ant build extension file)
        addPropertiesToProject();
        
     // Task 7: We make persistent the change. The project manager stores 
     // them into ant XML files
        saveModifications();
        
     // Task 8: We register the grammar directory as a source directory of
     // the project
        addGrammarDirectoryAsASourceRoot(grammarDirectory);
    }
    
    
    private FileObject createANTLRGrammarDirectory(FileObject projectDirectory)
        throws TaskException {
        FileObject grammarDirectoryFileObject;
     // We try to create the directory if it does not already exist
        String projectDirectoryPathName = projectDirectory.getPath();
        final FileSystem fs = FileSystems.getDefault();
        Path grammarDirectoryPath = fs.getPath(projectDirectoryPathName, GRAMMAR_DIRECTORY_NAME);
        File grammarDirectory = grammarDirectoryPath.toFile();
        if (!grammarDirectory.exists()) {
            grammarDirectory.mkdirs();
            out.println("* ... ANTLR grammar file directory created              *");
        } else {
            out.println("* ... ANTLR grammar directory already exists            *");
        }
        
     // We create the subdirectory for grammar and token file import
        Path importDirectoryPath = Paths.get(grammarDirectory.getAbsolutePath(),
                                             IMPORT_DIRECTORY_NAME             );
        File importsDirectory = importDirectoryPath.toFile();
        if (!importsDirectory.exists()) {
            importsDirectory.mkdirs();
            out.println("* ... default ANTLR grammar and token file import       *");
            out.println("*     directory created                                 *");
        } else {
            out.println("* ... default ANTLR grammar and token file import       *");
            out.println("*     directory already exists                          *");
        }
        grammarDirectoryFileObject = projectDirectory.getFileObject
                                                   (grammarDirectory.getPath());

        return grammarDirectoryFileObject;
    }
    
    
    private FileObject createAntlr4AntTaskDirectory(FileObject projectDirectory)
        throws TaskException {
        FileObject projectDirectoryFileObject;
        try {
         // We try to create the directory, if it already exists then an 
         // IOException will be raised
            FileObject nbProjectDirectory = projectDirectory.getFileObject("nbproject");
            projectDirectoryFileObject =
                    nbProjectDirectory.createFolder(ANTLR4_ANT_TASK_DIRECTORY_NAME);
            out.println("* ... ant task extension directory created              *");

         // At that point, we can be sure that the directory didn't exist so
         // ANTLR wasn't deployed in that project so we can do everything that
         // is required for a right ANTLR deployment
        } catch (IOException ex) {
            err.println("* ant task extension directory already exists             *");
            throw new TaskException();
        }
        return projectDirectoryFileObject;
    }
    
    
    private void addGrammarDirectoryAsASourceRoot(FileObject grammarDirectory)
            throws TaskException {
        StringBuilder projectXMLFileName = new StringBuilder(project.getProjectDirectory().getPath());
        String pathSeparator = System.getProperty("file.separator");
        projectXMLFileName.append(pathSeparator);
        projectXMLFileName.append("nbproject");
        projectXMLFileName.append(pathSeparator);
        projectXMLFileName.append("project.xml");
        FileSystem fs = FileSystems.getDefault();
        Path projectXMLFilePath = fs.getPath(projectXMLFileName.toString());

        try {
            List<String> lines = Files.readAllLines
                                  (projectXMLFilePath,
                                   StandardCharsets.UTF_8);
         // We transfer all lines of project.xml file in a LinkedList for being 
         // able to insert a new line in the middle of the list
            LinkedList<String> lines2 = new LinkedList<>(lines);
            
         // We look for configuration markup
            ListIterator<String> it = lines2.listIterator();
            boolean found = false;
            String line = null;
            int index = 0;
            while (it.hasNext() && !found) {
                line = it.next();
                if ((index = line.indexOf("<configuration", index)) != -1) {
                    found = true;
                }
            }
            if (!found) {
                err.println("* Unable to find <configuration> markup in project.xml file");
                throw new TaskException();
            }
            
         // We look for the data markup (in the same line and if not found in
         // the next lines)
            index = line.indexOf("<data", index);
            if (index == -1) {
                found = false;
                while (it.hasNext() && !found) {
                    line = it.next();
                    if ((index = line.indexOf("<data", index)) != -1) {
                        found = true;
                    }
                }
                if (!found) {
                    err.println("* Unable to find <data> markup in project.xml file");
                    throw new TaskException();
                }
            }

         // We look for the <source-roots> markup (in the same line and if not
         // found in the next lines)
            index = line.indexOf("<source-roots", index);
            if (index == -1) {
                found = false;
                while (it.hasNext() && !found) {
                    line = it.next();
                    if ((index = line.indexOf("<source-roots", index)) != -1) {
                        found = true;
                    }
                }
                if (!found) {
                    err.println("* Unable to find <source-roots> markup in project.xml file");
                    throw new TaskException();
                }
            }

         // We look for the ">" markup end (in the same line and if not
         // found in the next lines)
            index = line.indexOf(">", index);
            if (index == -1) {
                found = false;
                while (it.hasNext() && !found) {
                    line = it.next();
                    if ((index = line.indexOf(">", index)) != -1) {
                        found = true;
                    }
                }
                if (!found) {
                    err.println("* Unable to find the end of source-roots markup in project.xml file");
                    throw new TaskException();
                }
            }
         // At this point we have found the end of the source-roots markup that
         // controls the definition of source directories
         // So we add a line for declaring our new source root
            it.add("                <root id=\"antlr.generator.src.dir\" name=\"" +
                   GRAMMAR_NODE_NAME + "\"/>");
            
         // Now we rewrite the project.xml file
            OutputStream fout = Files.newOutputStream
                (projectXMLFilePath                  ,
                 StandardOpenOption.TRUNCATE_EXISTING,
                 StandardOpenOption.WRITE            );
            Iterator<String> it2 = lines2.iterator();
            while (it2.hasNext()) {
                line = it2.next();
                fout.write(line.getBytes());
                fout.write(LINE_TERMINATOR.getBytes());
            }
            fout.write("<!-- Modified by ANTLR plugin -->".getBytes());
            fout.write(LINE_TERMINATOR.getBytes());
            fout.close();
            
            out.println("* ... ANTLR grammar directory declared as a source root *");

        }  catch (IOException ex) {
            err.println("* Unable to open project.xml file of project");
            throw new TaskException();
        }
    }
    
    
    private static final String ANTLR4_ANT_EXTENSION_LIBRARY = "ANTLRAntTask-1.2.jar";
    
    private File createAntlr4AntExtensionLibrary
            (FileObject projectDirectory) throws TaskException {
        String projectDirectoryPath = projectDirectory.getPath();
     // Step 1: We build the path of the JAR resource that contains the
     // Here '/' is the Java JAR resource separator. It is defined by the 
     // Java specification. It is not related to the file system.
        final String jarResourceSeparator = "/";
        StringBuilder antlr4LibraryResourcePath = new StringBuilder(jarResourceSeparator);
        String resourceDirectory = getClass().getPackage().getName().replace(".", jarResourceSeparator);
        antlr4LibraryResourcePath.append(resourceDirectory);
        antlr4LibraryResourcePath.append(jarResourceSeparator);
        antlr4LibraryResourcePath.append(ANTLR4_ANT_EXTENSION_LIBRARY);
//        LOG.info("resource location: " + antlrBuildResourcePath.toString());

     // Step 2: We build the path of the ant build extension file dedicated
     // to ANTLR
        Path antlr4Library = Paths.get
                         (projectDirectoryPath          ,
                          "nbproject"                   ,
                          ANTLR4_ANT_TASK_DIRECTORY_NAME,
                          ANTLR4_ANT_EXTENSION_LIBRARY  );
        
     // File class is not autocloseable so antlrBuildExtensionFile stays out
     // of try-with-resource block
        File antlr4LibraryFile = new File(antlr4Library.toString());
        
        byte[] buffer = new byte[4096];
        int readBytes;
        try (
            InputStream in = getClass().getResourceAsStream
                                            (antlr4LibraryResourcePath.toString());
//            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            OutputStream fout = new FileOutputStream(antlr4LibraryFile);
        ) {
            while ((readBytes = in.read(buffer)) > 0) {
                fout.write(buffer, 0, readBytes);
            }
            int charCode;
            while ((charCode = in.read()) != -1)
                fout.write(charCode);
            out.println("* ... ant task extension library for ANTLR created      *");
        } catch (IOException ex) {
            err.println("* Unable to create the ant task extension library for ANTLR");
            throw new TaskException();
        }
        return antlr4LibraryFile;
    }
    
    
    private File createANTBuildExtensionFileForANTLR
            (FileObject projectDirectory) throws TaskException {
        String projectDirectoryPath = projectDirectory.getPath();
     // Step 1: We build the path of the JAR resource that contains the
     // Here '/' is the Java JAR resource separator. It is defined by the 
     // Java specification. It is not related to the file system.
        final String jarResourceSeparator = "/";
        StringBuilder antlrBuildResourcePath = new StringBuilder(jarResourceSeparator);
        String resourceDirectory = getClass().getPackage().getName().replace(".", jarResourceSeparator);
        antlrBuildResourcePath.append(resourceDirectory);
        antlrBuildResourcePath.append(jarResourceSeparator);
        antlrBuildResourcePath.append(ANT_BUILD_EXTENSION_FOR_ANTLR);
//        LOG.info("resource location: " + antlrBuildResourcePath.toString());

     // Step 2: We build the path of the ant build extension file dedicated
     // to ANTLR
        StringBuilder antlrBuildExtensionPath = new StringBuilder(projectDirectoryPath);
     // Now we need the file system item separator ('/' on UNIX, '\' on Windows)
        String fileSystemSeparator = System.getProperty("file.separator");
        antlrBuildExtensionPath.append(fileSystemSeparator);
        antlrBuildExtensionPath.append("nbproject");
        antlrBuildExtensionPath.append(fileSystemSeparator);
        antlrBuildExtensionPath.append(ANT_BUILD_EXTENSION_FOR_ANTLR);
//        LOG.info("ant build file destination: " + antlrBuildExtensionPath.toString());
        
     // File class is not autocloseable so antlrBuildExtensionFile stays out
     // of try-with-resource block
        File antlrBuildExtensionFile = new File(antlrBuildExtensionPath.toString());
        try (
            InputStream in = getClass().getResourceAsStream
                                            (antlrBuildResourcePath.toString());
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            FileWriter fout = new FileWriter(antlrBuildExtensionFile);
        ) {
            String line;
            while ((line = reader.readLine()) != null)
                fout.write(line + '\n');
            out.println("* ... ant build extension file for ANTLR created        *");
        } catch (IOException ex) {
            err.println("* Unable to create the ant build extension file for ANTLR");
            throw new TaskException();
        }
        return antlrBuildExtensionFile;
    }
    
    
    private void integrateANTBuildExtensionFileForANTLR
            (File antlrBuildExtensionFile) throws TaskException {
        final String antlrBuildExtensionFileName =
                antlrBuildExtensionFile.getName();
     // We scan the root build.xml file for finding the place where we can add
     // our import and target redefinitions
        final FileSystem fs = FileSystems.getDefault();
        final StringBuilder buildXMLFileName =
                new StringBuilder(project.getProjectDirectory().getPath());
        buildXMLFileName.append(FILE_SEPARATOR);
        buildXMLFileName.append("build.xml");
        
        final Path buildXMLFilePath = fs.getPath(buildXMLFileName.toString());
        
        final String antExtendionImport =
             "    <import file=\"nbproject/" + antlrBuildExtensionFileName + "\"/>";
        final String antTarget1 =
             "    <target name=\"-post-init\" depends=\"-antlr4.init\"/>";
        final String antTarget2 =
             "    <target name=\"-pre-compile\" depends=\"antlr4\"/>";
        List<String> lines;
        try {
            lines = Files.readAllLines
                                  (buildXMLFilePath      ,
                                   StandardCharsets.UTF_8);
        } catch (IOException ex) {
            err.println("* Unable to find/read the build.xml resource of project");
            throw new TaskException();
        }
        
        try (
            OutputStream fout = Files.newOutputStream
                (buildXMLFilePath                    ,
                 StandardOpenOption.TRUNCATE_EXISTING,
                 StandardOpenOption.WRITE            );
        ) {
            Iterator<String> it = lines.iterator();
            String line;
            while (it.hasNext()) {
                line = it.next();
                fout.write(line.getBytes());
                fout.write(LINE_TERMINATOR.getBytes());
                if (line.contains("<import file=\"nbproject/build-impl.xml\"")) {
                    fout.write(antExtendionImport.getBytes());
                    fout.write(LINE_TERMINATOR.getBytes());
                    fout.write(antTarget1.getBytes());
                    fout.write(LINE_TERMINATOR.getBytes());
                    fout.write(antTarget2.getBytes());
                    fout.write(LINE_TERMINATOR.getBytes());
                }
            }
        } catch (IOException ex) {
            err.println("* Unable to write build.xml file                        *");
            throw new TaskException();
        }
        
        out.println("* ... ant build extension file for ANTLR integrated     *");
    }
    
    
    private static final String[] ANTLR4_PROPERTIES = {
        "",
        "# ***********************",
        "# * ANTLR V4 properties *",
        "# ***********************",
        "# You may set a project relative path or an abolute path to antlr4 ant task jar",
        "# Normally, you should not change this value that points to your project antlr4",
        "# ant task library",
        "antlr.ant.task.jar=nbproject/antext/ANTLRAntTask-1.2.jar",
        "antlr.ant.task.antlr.runtime.jar=${libs.ANTLR_4.6_runtime.classpath}",
        "",
        "# You can set an absolute directory path or a project relative path",
        "antlr.generator.src.dir=grammar",
        "",
        "# comma-separated or whitespace-separated list of excluded grammar files",
        "# (from the directory antlr.generator.src.dir so here only file names relative",
        "#  to that directory)",
        "antlr.generator.src.excluded=",
        "",
        "# Optional directory where ANTLR will look for grammar files and token files",
        "# All files in that directory will be ignored by code generation launched by",
        "# antlr4 task.",
        "# If you delete default grammar/imports directory, because you do not need it,",
        "# then do not forget to define next property to an empty value",
        "antlr.generator.import.dir=grammar/imports",
        "",
        "# Where your lexer / parser code will be located",
        "antlr.generator.dest.dir=${build.generated.sources.dir}/antlr4",
        "",
        "# This property defines the ANTLR library that will be used for generating",
        "# Java code from your grammars.",
        "# You can set this property with :",
        "# - NetBeans library repository: ${libs.ANTLR_4.6_complete.classpath} or any",
        "#   other version you have installed in your NETBeans library repository,",
        "# - An ANTLR complete library of your choice defined by an absolute path  ",
        "#   pointing typically outside project directory,",
        "# - the antlr 4.6 complete library deployed in your project library repository: ",
        "#   lib/antlr-4.6-complete.jar (recommended because it enables your project to",
        "#   continue to work even if you uninstall NetBeans),",
        "# - empty property that will lead to use the library called project library.",
        "# Whatever choice, you have made, if no library is found, the antlr4 task will fail.",
        "antlr.generator.jar=${libs.ANTLR_4.6_complete.classpath}",
        "",
        "# required for running your generated parser",
        "antlr.runtime.jar=${libs.ANTLR_4.6_runtime.classpath}",
        "",
        "# defines if ANTLR will generate a listener or not (default value=true)",
        "antlr.generator.option.code.listener=false",
        "",
        "# defines if ANTLR will generate a listener or not (default value=false)",
        "antlr.generator.option.code.visitor=false",
        "",
        "# defines the package of generated classes",
        "# If you use this option (or if you put a Java package statement in ",
        "# the grammar header) do not forget to place grammars in the ",
        "# corresponding subdirectories of ${antlr.generator.dest.dir} as if they ",
        "# where a Java source. You do not have to modiify antlr.generator.dest.dir.",
        "antlr.generator.option.code.package=",
        "",
        "# defines if ANTLR will generate DOT graph files that represent the internal",
        "# augmented transition network (ATN) data structures that ANTLR uses to represent",
        "# grammars (default value=false)",
        "antlr.generator.option.atn=false"
    };
    
    private void addPropertiesToProject() throws TaskException {
        final String filePathSeparator = System.getProperty("file.separator");

        StringBuilder projectPropertiesFileNameBuilder = new StringBuilder
                                      (project.getProjectDirectory().getPath());
        projectPropertiesFileNameBuilder.append(filePathSeparator);
        projectPropertiesFileNameBuilder.append("nbproject");
        projectPropertiesFileNameBuilder.append(filePathSeparator);
        projectPropertiesFileNameBuilder.append("project.properties");
        
        StringBuilder newProjectPropertiesFileNameBuilder = new StringBuilder
                                      (project.getProjectDirectory().getPath());
        newProjectPropertiesFileNameBuilder.append(filePathSeparator);
        newProjectPropertiesFileNameBuilder.append("nbproject");
        newProjectPropertiesFileNameBuilder.append(filePathSeparator);
        newProjectPropertiesFileNameBuilder.append("newProject.properties");
        
        final FileSystem fs = FileSystems.getDefault();
        final Path projectPropertiesFilePath =
                        fs.getPath(projectPropertiesFileNameBuilder.toString());
        List<String> lines;
        try {
            lines = Files.readAllLines
                                  (projectPropertiesFilePath,
                                   StandardCharsets.UTF_8   );
        } catch (IOException ex) {
            err.println("* Unable to find/read the project.properties resource of project");
            throw new TaskException();
        }
        
        try (
            OutputStream fout = Files.newOutputStream
                (projectPropertiesFilePath           ,
                 StandardOpenOption.TRUNCATE_EXISTING,
                 StandardOpenOption.WRITE            );
        ) {
            Iterator<String> it = lines.iterator();
            String line;
            boolean javacOnSeveralLines = false;
            while (it.hasNext()) {
                line = it.next();
                if (!javacOnSeveralLines) {
                    if (!line.startsWith("javac.classpath")) {
                        fout.write(line.getBytes());
                        fout.write(LINE_TERMINATOR.getBytes());
                    } else {
                        fout.write(line.getBytes());
                        if (line.endsWith("\\"))
                            javacOnSeveralLines = true;
                        else {
                            if (line.equals("javac.classpath="))
                                fout.write("\\".getBytes());
                            else
                                fout.write(":\\".getBytes());
                            fout.write(LINE_TERMINATOR.getBytes());
                            fout.write("    ${libs.ANTLR_4.6_runtime.classpath}".getBytes());
                        }
                        fout.write(LINE_TERMINATOR.getBytes());
                    }
                } else {
                    fout.write(line.getBytes());
                    if (!line.endsWith("\\")) {
                        javacOnSeveralLines = false;
                        fout.write(":\\".getBytes());
                        fout.write(LINE_TERMINATOR.getBytes());
                        fout.write("    ${libs.ANTLR_4.6_runtime.classpath}".getBytes());
                    }
                    fout.write(LINE_TERMINATOR.getBytes());
                }
            }
            
         // We add the specific ANTLR properties at the end of project property file
            for (String propertyLine : ANTLR4_PROPERTIES) {
                fout.write(propertyLine.getBytes());
                fout.write(LINE_TERMINATOR.getBytes());
            }

            out.println("* ... ANTLR properties added to project.properties file *");
        } catch (IOException ex) {
            err.println("* Unable to open project.properties file");
            throw new TaskException();
        }
    }
    
    
    private void saveModifications() throws TaskException {
        ProjectManager projectManager = ProjectManager.getDefault();
        try {
            projectManager.saveProject(project);
        } catch (IOException ex) {
            err.println("* Unable to deploy the ANTLR support in ant build files of your project");
            throw new TaskException();
        }
    }
}