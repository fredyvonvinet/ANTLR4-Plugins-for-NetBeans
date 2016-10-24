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
import java.io.IOException;
import java.io.InputStream;

import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import java.util.regex.PatternSyntaxException;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;


public class Antlr4 extends Task {
    
    private String  srcdir;
    private String  destdir;
    private String  excludes;
    private String  library;
    private boolean listener;
    private boolean visitor;
    private boolean atn;
    private String  codePackage;

    public void setSrcdir(String srcdir) {
        this.srcdir = srcdir;
    }
   
    public void setDestdir(String destdir) {
        this.destdir = destdir;
    }
   
    public void setExcludes(String excludes) {
        this.excludes = excludes;
    }
  
    public void setLibrary(String library) {
        this.library = library;
    }
  
    public void setListener(boolean listener) {
        this.listener = listener;
    }

    public void setVisitor(boolean visitor) {
        this.visitor = visitor;
    }

    public void setAtn(boolean atn) {
        this.atn = atn;
    }

    public void setCodePackage(String codePackage) {
        String codePackage2 = codePackage.trim();
        if (!codePackage2.equals("")) {
            this.codePackage = codePackage2;
        }
    }
    
    private       String          codeGenerationANTLRVersion;
    private       String          antTaskANTLRVersion;
    private       String          projectDirectory;
    private       Path            projectDirectoryPath;
    private       String          absoluteSrcDir;
    private final ArrayList<Path> excludedFilePaths;
    private       String          absoluteDestDir;
    private       String          absoluteLibrary;
    
    private final ArrayList<GrammarFile> grammarFiles;
    private       ANTLRCodeGenerator     antlrCodeGenerator;
    
    private static final String DEFAULT_ANTLR_LIBRARY = "lib/antlr-4.5.3-complete.jar";
    public Antlr4() {
        this.srcdir = null;
        this.destdir = null;
        this.excludes = null;
    
        this.library = DEFAULT_ANTLR_LIBRARY;
        this.listener = true;
        this.visitor = false;
        this.atn = false;
        this.codePackage = null;
     
        this.grammarFiles = new ArrayList();
        this.antlrCodeGenerator = null;
        
        this.projectDirectory = null;
        this.absoluteSrcDir = null;
        this.excludedFilePaths = new ArrayList<>();
        this.absoluteDestDir = null;
        this.absoluteLibrary = null;
    }
 

    @Override
    public void execute() throws BuildException {
     // We recover the project root directory (project is an inherited
     // attribute, basedir is an ant built-in property)
     // It is not possible to do it in constructor because ant initialize project
     // attribute after the instantiation of the Task
        projectDirectory = project.getProperty("basedir");
        projectDirectoryPath = Paths.get(projectDirectory);
        
        checkMandatoryAttributePresence();
        checkDirParametersAndInitAbsolutesDirs();

        antTaskANTLRVersion = recoverClassPathANTLRVersion();
        codeGenerationANTLRVersion = ANTLRToolChecker.checkANTLRToolPresence(library);
        
        log("antlr4 ant task:");
        log("- ANTLR version used by antlr4 task: " + antTaskANTLRVersion);
        log("- Grammar files will be collected in next directory: " + srcdir);
        log(((excludes == null) ?
            "- With no excluded grammar file" :
            "- Grammar files excluded from generation process: "  + excludes));
        log("- Java files will be generated in next directory: " + destdir);
        log("- Used ANTLR library for code generation: " + library);
        log("- ANTLR version of this library: " + codeGenerationANTLRVersion);

        collectGrammarFiles(absoluteSrcDir);
        
        log("");
        log("Collected grammar files:");
        for (GrammarFile grammarFile : grammarFiles) {
            Path path = projectDirectoryPath.relativize(grammarFile.getPath());
            log("- " + path);
//            log("  " + grammarFile.getPath());
        }
        
        try {
            new ANTLRDependenceRecoverer(absoluteDestDir, listener, visitor, codePackage, atn);
        } catch (NoClassDefFoundError ex) {
            System.err.println("Error catched!");
            ex.getCause().printStackTrace();
        }
        new FileConverter(absoluteSrcDir, absoluteDestDir);
        antlrCodeGenerator = new ANTLRCodeGenerator(library, absoluteDestDir, listener, visitor, codePackage, atn);

        Iterator<GrammarFile> it = this.grammarFiles.iterator();
        while (it.hasNext()) {
            GrammarFile grammarFile = (GrammarFile)it.next();
            log("");
            Path relativeGrammarPath = projectDirectoryPath.relativize(grammarFile.getPath());
            log("Processing of " + relativeGrammarPath + ":");
            ArrayList<ANTLRFile> filesThatIDependOn = grammarFile.getFilesThatIDependOn();
            if (filesThatIDependOn.isEmpty()) {
                log("- depends of no file");
            } else {
                log("- depends of next file:");
                for (ANTLRFile fileThatIDependOn : filesThatIDependOn) {
                    Path relativePath = projectDirectoryPath.relativize(fileThatIDependOn.getPath());
                    log("  -> " + relativePath);
                }
            }

         // A dependent file may be:
         // - a generated file (generated from the current grammar),
         // - another grammar file that imports the current grammar file
            ArrayList<ANTLRFile> dependentFiles = grammarFile.getFilesThatDependOnMe();
            if (dependentFiles.isEmpty()) {
                log("- no dependent file");
            } else {
                log("- dependent files:");
                for (ANTLRFile dependentFile : dependentFiles) {
                    Path relativePath = projectDirectoryPath.relativize(dependentFile.getPath());
                    log("  -> " + relativePath);
                }
            }

            if (isGenerationRequiredFor(grammarFile)) {
                log("Conclusion: code generation required for " + relativeGrammarPath);
                antlrCodeGenerator.generateCodeFor(grammarFile);
            } else
                log("Conclusion: No code generation required for " + relativeGrammarPath);
        }
    }


    private void checkMandatoryAttributePresence() throws BuildException {
        if (srcdir == null)
            throw new BuildException("srcdir is a mandatory attribute of task antlr4");
        if (destdir == null)
            throw new BuildException("destdir is a mandatory attribute of task antlr4");
    }
    
    
    private void checkDirParametersAndInitAbsolutesDirs() {
     // srcdir ant attribute management
        try {
            Path srcdirPath = Paths.get(srcdir);
            if (srcdirPath.isAbsolute())
                absoluteSrcDir = srcdir;
            else
                absoluteSrcDir = Paths.get(projectDirectory, srcdir).toString();
            
            File dir = new File(absoluteSrcDir);
            if (!dir.exists())
                throw new BuildException("srcdir attribute points to a non existing directory");
            if (!dir.isDirectory())
                throw new BuildException("srcdir attribute points to a file");
            if (!dir.canRead())
                throw new BuildException("srcdir attribute points to a directory that current user does not have read access to");
        } catch (InvalidPathException ex) {
            throw new BuildException("Invalid path for srcdir attribute\n");
        }

     // destdir ant attribute management
        try {
            Path destdirPath = Paths.get(destdir);
            if (destdirPath.isAbsolute())
                absoluteDestDir = srcdir;
            else
                absoluteDestDir = Paths.get(projectDirectory, destdir).toString();
            
            File dir = new File(absoluteDestDir);
            if (!dir.exists()) {
                boolean creation = dir.mkdirs();
                if (!creation)
                    throw new BuildException("Unable to create directory: " + absoluteDestDir);
            }
            if (!dir.isDirectory())
                throw new BuildException("destdir attribute points to a file");
            if (!dir.canRead())
                throw new BuildException("destdir attribute points to a directory that current user does not have read access to");
        } catch (InvalidPathException ex) {
            throw new BuildException("Invalid path for destdir attribute\n");
        }
        
     // excludes ant attribute management
        if (excludes != null) {
            String[] excludedGrammars;
            if (excludes.contains(",")) {
               excludedGrammars = excludes.split(","); }
            else {
                if (excludes.contains(" ")) {
                    excludedGrammars = excludes.split(" ");
                } else {
                    excludedGrammars = new String[1];
                    excludedGrammars[0] = excludes;
                }
            }
            for (String excluded : excludedGrammars) {
             // We remove possible leading and trailing blanck characters
                String excludedFileName = excluded.trim();
                Path excludedPath = Paths.get(absoluteSrcDir, excludedFileName);
                excludedFilePaths.add(excludedPath);
            }
        }
        
     // library ant attribute management
        if (library != null) {
            Path libraryPath = Paths.get(library);
            if (libraryPath.isAbsolute())
                absoluteLibrary = library;
            else
                absoluteLibrary = Paths.get(projectDirectory, library).toString();
            
            File file = new File(absoluteLibrary);
            if (!file.exists())
                throw new BuildException("library attribute points to file that does not exist");
            if (!file.isFile())
                throw new BuildException("library attribute points to a directory");
            if (!file.canRead())
                throw new BuildException("library attribute points to a file that current user does not have read access to");
        }
    }
    
    
    private static final String MAVEN_POM_PROPERTY_FILE =
                               "META-INF/maven/org.antlr/antlr4-runtime/pom.properties";
    private static final String ANTLR_VERSION = "version";
    private String recoverClassPathANTLRVersion() {
        String version;
        try (
            InputStream is = Antlr4.class.getClassLoader().getResourceAsStream
                                                     (MAVEN_POM_PROPERTY_FILE);
        ) {
            if (is == null)
                throw new BuildException("Unable to find Maven POM file in classpath");
            Properties mavenProperties = new Properties();
            mavenProperties.load(is);
            version = mavenProperties.getProperty(ANTLR_VERSION);
        } catch (IOException ex) {
            throw new BuildException
                  ("Unable to find ANTLR version in antlr4 ant task classpath");
        }
        return version;
    }
    

    private void collectGrammarFiles(String SourceDir) {
        Path srcDirPath = Paths.get(SourceDir);
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.g4");

        try (
            DirectoryStream<Path> filePathStream = Files.newDirectoryStream(srcDirPath);
        ) {
            Iterator<Path> iterator = filePathStream.iterator();
            while (iterator.hasNext()) {
                Path path = iterator.next();
                if (matcher.matches(path)) {
                    if (!excludedFilePaths.contains(path)) {
                        GrammarFile grammarFile = new GrammarFile(path);
                        grammarFiles.add(grammarFile);
                    }
                } else if (path.toFile().isDirectory()) {
                    String sourceSubDir = path.toString();
                    collectGrammarFiles(sourceSubDir);
                }
            }
        } catch (IOException ex) {
            throw new BuildException("Unable to read in grammar source directory or its subdirectories");
        } catch (PatternSyntaxException ex) {
            throw new BuildException("Strange! Pattern file exception");
        }
    }


    private boolean isGenerationRequiredFor(ANTLRFile antlrFile) {
        File grammarfile = antlrFile.getPath().toFile();
        long grammarLastUpdateDate = grammarfile.lastModified();

        boolean generationRequired = false;
        
     // We scan all files that the current file depends on.
     // A grammar file can depend on:
     // - a token file generated by another grammar file (tokenVocab option),
     // - another grammar file (imported grammar).
        ArrayList<ANTLRFile> antlrFilesThatIDependOn = antlrFile.getFilesThatIDependOn();
        Iterator<ANTLRFile> it = antlrFilesThatIDependOn.iterator();
        while ((it.hasNext()) && (!generationRequired)) {
           ANTLRFile antlrFileThatIDependOn = it.next();
           File fileThatIDependOn = antlrFileThatIDependOn.getPath().toFile();
        // If the file that I depend on does not exist then it is probably a tokens file
           if (!fileThatIDependOn.exists()) {
            // We check that it is really a tokens file.
            // A grammar file may depend on:
            // - another grammar file (import statement). In that case, it is 
            //   not an artefact and normally that file exists,
            // - a tokens file (tokenVocab option). In that case, it is an 
            //   artefact and it is possible that it was not generated yet.
               if (antlrFileThatIDependOn.isArtefact()) {
                   ArrayList<ANTLRFile> antlrSourceFiles = antlrFileThatIDependOn.getFilesThatIDependOn();
                   if (antlrSourceFiles.size() == 0)
                       throw new BuildException("Strange the token file " + antlrFileThatIDependOn.getPath() + " has no grammar source");
                   if (antlrSourceFiles.size() > 1)
                       throw new BuildException("Strange a token file has several grammar sources: " + antlrFileThatIDependOn.getPath());
                   ANTLRFile source = (ANTLRFile)antlrSourceFiles.get(0);
                // Normally, that file is a grammar so it cannot be an artefact
                   if (source.isArtefact())
                       throw new BuildException
                           ("Strange a token file has a source that is not a " +
                            "grammar: " + antlrFileThatIDependOn.getPath() + 
                            "\nwith for source: " + source.getPath());
                   GrammarFile sourceGrammarFile = (GrammarFile) source;
                   Path relativePath = projectDirectoryPath.relativize(sourceGrammarFile.getPath());
                   log("Code generation required for " + relativePath);
                   antlrCodeGenerator.generateCodeFor(sourceGrammarFile);
                } else {
                   throw new BuildException("Strange! The file " +
                           antlrFileThatIDependOn.getPath() +
                           " is not considedered as an artefact and does not exist");
                }
          // else it exists so we compare the dates of the grammar with
          // the date of the current file that I depend on.
            } else {
             // A grammar file may depend on:
             // - another grammar file (import statement).
             // - a tokens file (tokenVocab option).
                long fileThatIDependOnLastUpdate = fileThatIDependOn.lastModified();
             // If the file that grammar depends on is older than the grammar
             // then the the generated files are necessarily more recent than the
             // that file so in that case no new code generation is required.
             // But if it is not the case, we have to compare the date of dependent
             // files with the date of the file that grammar depends on.
                if (grammarLastUpdateDate < fileThatIDependOnLastUpdate) {
                    ArrayList<ANTLRFile> generatedFiles = antlrFile.getFilesThatDependOnMe();
                    Iterator<ANTLRFile> it2 = generatedFiles.iterator();
                    while (it2.hasNext() && !generationRequired) {
                        ANTLRFile antlrGeneratedFile = it2.next();
                        File generatedFile = antlrGeneratedFile.getPath().toFile();
                        long generatedFileLastUpdate = generatedFile.lastModified();
                        if (generatedFileLastUpdate < fileThatIDependOnLastUpdate)
                            generationRequired = true;
                    }
                }
            }
        }

        if (!generationRequired) {
         // Two kind of files can depend on another grammar:
         // - the generated files (tokens and Java source implemnting parsers &
         //   lexers)
         // - another grammar. That case is not treated here because we do not 
         //   know if we have to generate code from it. If it is the case, it 
         //   will be treated as a grammar in the main list.
         // So here, the only case is the first one.
            ArrayList<ANTLRFile> antlrGeneratedFiles = antlrFile.getFilesThatDependOnMe();
            Iterator<ANTLRFile> it2 = antlrGeneratedFiles.iterator();
            while ((it2.hasNext()) && (!generationRequired)) {
                ANTLRFile antlrGeneratedFile = it2.next();
                if (antlrGeneratedFile.isArtefact()) {
                    File generatedFile = antlrGeneratedFile.getPath().toFile();
                    if (!generatedFile.exists()) {
                        System.out.println("generated file " + generatedFile.getPath() + " doesn't exist!");
                        generationRequired = true;
                    } else {
                        long generatedFilelastUpdateDate = generatedFile.lastModified();
//                    System.out.println(grammarfile + " : " + grammarLastUpdateDate);
//                    System.out.println(antlrGeneratedFile.getPath() + " : " + generatedFilelastUpdateDate);
                        if (generatedFilelastUpdateDate < grammarLastUpdateDate) {
                            generationRequired = true;
                        }
                    }
                }
            }
        }
        return generationRequired;
    }
}