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
package org.nemesis.antlr.v4.netbeans.v8.tokens.code.summary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.nemesis.antlr.v4.netbeans.v8.project.helper.ProjectHelper;

import org.netbeans.api.project.Project;

/**
 *
 * @author Frédéric Yvon Vinet
 */
public class TokensSummary {
    protected final Path                sourceFilePath;
    protected final List<String>        tokenIds;
    protected final Map<String,Integer> tokenIdOffsets;
    protected final List<String>        tokenLiterals;
    protected final Map<String,Integer> tokenLiteralOffsets;

    public Path getSourceFilePath() {
        return sourceFilePath;
    }
    
    
    public List<String> getTokenIds() {
        return tokenIds;
    }
    public void addAllTokenIds(List<String> tokenIds) {
        this.tokenIds.addAll(tokenIds);
    }
    public void addTokenId(String tokenId) {
        this.tokenIds.add(tokenId);
    }
    public Map<String,Integer> getTokenIdOffsets() {
        return tokenIdOffsets;
    }
    public void putAllTokenIdOffsets(Map<String,Integer> tokenIdOffsets) {
        this.tokenIdOffsets.putAll(tokenIdOffsets);
    }
    public void putTokenIdOffset(String tokenId, Integer tokenIdOffset) {
        this.tokenIdOffsets.put(tokenId, tokenIdOffset);
    }
    
    
    public List<String> getTokenLiterals() {
        return tokenLiterals;
    }
    public void addAllTokenLiterals(List<String> tokenLiterals) {
        this.tokenLiterals.addAll(tokenLiterals);
    }
    public void addTokenLiteral(String tokenLiteral) {
        this.tokenLiterals.add(tokenLiteral);
    }
    public Map<String,Integer> getTokenLiteralOffsets() {
        return tokenLiteralOffsets;
    }
    public void putAllTokenLiteralOffsets(Map<String,Integer> tokenLiteralOffsets) {
        this.tokenLiteralOffsets.putAll(tokenLiteralOffsets);
    }
    public void putTokenLiteralOffset(String tokenLiteral, Integer tokenLiteralOffset) {
        this.tokenLiteralOffsets.put(tokenLiteral, tokenLiteralOffset);
    }
    
    
    public TokensSummary(Path sourceFilePath) {
        this.sourceFilePath = sourceFilePath;
        this.tokenIds = new ArrayList<>();
        this.tokenIdOffsets = new HashMap<>();
        this.tokenLiterals = new ArrayList<>();
        this.tokenLiteralOffsets = new HashMap<>();
    }
    
    
    protected static final String SOURCE_FILE_PATH = "source.file.path";
    protected static final String TOKEN_IDS = "tokens.id";
    protected static final String TOKEN_ID_OFFSETS = "tokens.id.offset";
    protected static final String TOKEN_LITERALS = "tokens.literal";
    protected static final String TOKEN_LITERAL_OFFSETS = "tokens.literal.offset";
    public void save() {
//        System.out.println("TokensSummary:save() : begin");
//        System.out.println("- source file path " + sourceFilePath);
        
        Path summaryPath = TokensSummary.determineSummaryFilePath
                                                               (sourceFilePath);
        if (summaryPath != null) {
            try {
             // We delete the previous instance of summary file if it exists
                Files.deleteIfExists(summaryPath);
                Properties props = new Properties();
                props.setProperty(SOURCE_FILE_PATH         ,
                                  sourceFilePath.toString());
                    
                StringBuilder propertyValue = new StringBuilder();
                for (String tokenId : tokenIds) {
                    if (!propertyValue.toString().equals(""))
                        propertyValue.append(",");
                    propertyValue.append(tokenId);
                }
                props.setProperty(TOKEN_IDS               ,
                                  propertyValue.toString());
                
                propertyValue = new StringBuilder();
                for (String tokenId : tokenIds) {
                    if (!propertyValue.toString().equals(""))
                        propertyValue.append(";");
                    propertyValue.append("(");
                    propertyValue.append(tokenId);
                    propertyValue.append(",");
                    Integer offset = tokenIdOffsets.get(tokenId);
                    propertyValue.append(offset);
                    propertyValue.append(")");
                }
                props.setProperty(TOKEN_ID_OFFSETS        ,
                                  propertyValue.toString());
                
                propertyValue = new StringBuilder();
                for (String tokenLiteral : tokenLiterals) {
                    if (!propertyValue.toString().equals(""))
                        propertyValue.append(",");
                    propertyValue.append(tokenLiteral);
                }
                props.setProperty(TOKEN_LITERALS          ,
                                  propertyValue.toString());
                
                propertyValue = new StringBuilder();
                for (String tokenLiteral : tokenLiterals) {
                    if (!propertyValue.toString().equals(""))
                        propertyValue.append(";");
                    propertyValue.append("(");
                    propertyValue.append(tokenLiteral);
                    propertyValue.append(",");
                    Integer offset = tokenLiteralOffsets.get(tokenLiteral);
                    propertyValue.append(offset);
                    propertyValue.append(")");
                }
                props.setProperty(TOKEN_LITERAL_OFFSETS   ,
                                  propertyValue.toString());
                
                File summaryFile = summaryPath.toFile();
                try (
                    OutputStream out = new FileOutputStream(summaryFile);
                ) {
                    String tokensFileName = sourceFilePath.getFileName().toString();
                    props.store(out                                         ,
                                "This file contains a content summary of " +
                                tokensFileName                              );
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
//        System.out.println("TokensSummary:save() : end");
    }
    
    
    static public TokensSummary load(Project project, String tokensFile) {
//        System.out.println("TokensSummary:load(Project, String) -> TokensSummary : begin");
        assert project != null;
        assert tokensFile != null;
        TokensSummary summary = null;
        
        Path tokensFilePath = Paths.get(tokensFile);
        Path summaryPath = TokensSummary.determineSummaryFilePath
                                                               (tokensFilePath);
        if (summaryPath != null) {
            if (Files.exists(summaryPath)       &&
                !Files.isDirectory(summaryPath) &&
                Files.isReadable(summaryPath)     ) {
                Properties props = new Properties();
                File summaryFile = summaryPath.toFile();
                try (
                    InputStream is = new FileInputStream(summaryFile);
                ) {
                    props.load(is);
                    
                 // ********************
                 // * source file name *
                 // ********************
                    String sourceFileName = props.getProperty(SOURCE_FILE_PATH);
                    Path sourceFilePath = Paths.get(sourceFileName);
                    
                 // *************
                 // * token ids *
                 // *************
                    String tokenIdsString = props.getProperty(TOKEN_IDS);
                    String[] tokenIdsArray = tokenIdsString.split(",");
                    ArrayList<String> tokenIds =
                            new ArrayList<String>(Arrays.asList(tokenIdsArray));
                    
                 // ********************
                 // * token id offsets *
                 // ********************
                    String tokenIdOffsetsString = props.getProperty
                                                             (TOKEN_ID_OFFSETS);
                    String[] tokenIdOffsetsArray;
//                    System.out.println("token id offsets string=" + tokenIdOffsetsString);
                    if (tokenIdOffsetsString.equals("")) {
                        tokenIdOffsetsArray = new String[0];
                    } else {
                        tokenIdOffsetsArray = tokenIdOffsetsString.split(";");
                    }
                    Map<String, Integer> tokenIdOffsets = new HashMap<>();
//                    System.out.println("- start offset of token id:");
                    for (String tokenIdOffsetString : tokenIdOffsetsArray) {
                        tokenIdOffsetString = tokenIdOffsetString.substring
                                          (1, tokenIdOffsetString.length() - 1);
//                        System.out.println("token Id Offset String=" +
//                                           tokenIdOffsetString        );
                        String[] tokenIdOffsetArray =
                                                 tokenIdOffsetString.split(",");
                        String tokenId = tokenIdOffsetArray[0];
//                        System.out.println("  * token id=" + tokenId);
                        String value = tokenIdOffsetArray[1];
//                        System.out.println("    token id start offset=" + value);
                        Integer offset = Integer.parseInt(value);
                        tokenIdOffsets.put(tokenId, offset);
                    }
                    
                 // ******************
                 // * token literals *
                 // ******************
                    String tokenLiteralsString = props.getProperty
                                                               (TOKEN_LITERALS);
                    String[] tokenLiteralsArray = tokenLiteralsString.split
                                                                          (",");
                    ArrayList<String> tokenLiterals = new ArrayList<String>
                                            (Arrays.asList(tokenLiteralsArray));
                    
                 // *************************
                 // * token literal offsets *
                 // *************************
                    String tokenLiteralOffsetsString = props.getProperty
                                                        (TOKEN_LITERAL_OFFSETS);
                    String[] tokenLiteralOffsetsArray;
//                    System.out.println("token id offsets string=" + tokenIdOffsetsString);
                    if (tokenLiteralOffsetsString.equals("")) {
                        tokenLiteralOffsetsArray = new String[0];
                    } else {
                        tokenLiteralOffsetsArray =
                                           tokenLiteralOffsetsString.split(";");
                    }
                    Map<String, Integer> tokenLiteralOffsets = new HashMap<>();
//                    System.out.println("- start offsets of token literals:");
                    for (String tokenLiteralOffsetString : tokenLiteralOffsetsArray) {
                        tokenLiteralOffsetString =
                                tokenLiteralOffsetString.substring
                                     (1, tokenLiteralOffsetString.length() - 1);
//                        System.out.println("token literal offset String=" +
//                                           tokenLiteralOffsetString        );
                        String[] tokenLiteralOffsetArray =
                                            tokenLiteralOffsetString.split(",");
                        String tokenLiteral = tokenLiteralOffsetArray[0];
                        String value   = tokenLiteralOffsetArray[1];
//                        System.out.println("  * token literal=" + tokenLiteral);
//                        System.out.println("    token literal start offset=" + value);
                        Integer offset = Integer.parseInt(value);
                        tokenLiteralOffsets.put(tokenLiteral, offset);
                    }
                    
                    summary = new TokensSummary(sourceFilePath);
                    summary.addAllTokenIds(tokenIds);
                    summary.putAllTokenIdOffsets(tokenIdOffsets);
                    summary.addAllTokenLiterals(tokenLiterals);
                    summary.putAllTokenLiteralOffsets(tokenLiteralOffsets);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        
//        System.out.println("TokensSummary:load(Project, String) -> TokensSummary : end");
        return summary;
    }
    
    
    protected static final String USER_HOME_DIRECTORY =
                                                System.getProperty("user.home");
    static protected Path determineSummaryFilePath(Path tokensFilePath) {
//        System.out.println("TokensSummary:determineSummaryFilePath() -> Path : begin");
        assert tokensFilePath != null;
        assert Files.exists(tokensFilePath);
        assert Files.isReadable(tokensFilePath);
        assert Files.isRegularFile(tokensFilePath);
//        System.out.println("- tokens file path " + tokensFilePath);
        Path summaryPath;
        Path summaryDirPath = getSummaryDirPath(tokensFilePath);
        if (summaryDirPath != null) {
            if (!Files.exists(summaryDirPath)) {
                try {
                    summaryDirPath = Files.createDirectories(summaryDirPath);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    summaryDirPath = null;
                }
            }
            if (summaryDirPath != null) {
             // We extract the file name from its path
                String tokensFileName = tokensFilePath.getFileName().toString();
                String summaryFileName = tokensFileName + ".properties";
                summaryPath = Paths.get(summaryDirPath.toString(),
                                        summaryFileName          );
//                System.out.println("  summary path=" + summaryPath);
            } else
                summaryPath = null;
        } else 
            summaryPath = null;
//        System.out.println("TokensSummary:determineSummaryFilePath() -> Path : end");
        return summaryPath;
    }
    
    
    
 /**
  * A tokens file may be placed in:
  * - a subdirectory of ANTLR source directory,
  * - ANTLR import directory (in fact a particular cas of previous one),
  * - a subdirectory of ANTLR destination directory.
  * For recovering, its relative directory, we have to look for where it is
  * placed.
  */
    protected static Path getSummaryDirPath(Path tokensFilePath) {
//        System.out.println("TokensSummary:getSummaryDirPath(Path) -> Path : begin");
        Path summaryDirPath;
     // We determine the project associated to our tokens file path ...
        Project project = ProjectHelper.getProject(tokensFilePath);
        String projectDir = project.getProjectDirectory().getPath();
     // ... that enables us to determine:
     // - the ANTLR source directory,
        File antlrSrcDir = ProjectHelper.getANTLRSourceDir(project);
        Path antlrSrcDirPath = antlrSrcDir.toPath();
     // - the ANTLR import directory...
        File antlrImportDir = ProjectHelper.getANTLRImportDir(project);
        Path antlrImportDirPath = antlrImportDir.toPath();
     // - the ANTLR destination directory...
        File antlrDestDir = ProjectHelper.getANTLRDestinationDir(project);
        Path antlrDestDirPath = antlrDestDir.toPath();
        Path tokensDirRelativePath;
     // We must start to test if tokens file is in import directory and after if
     // it is in source directory because import directory is a subdir of
     // source directory
        if (tokensFilePath.startsWith(antlrImportDirPath)) {
         // Our tokens file is placed in import directory
            tokensDirRelativePath = antlrSrcDirPath.relativize
                                                   (tokensFilePath.getParent());
        } else {
         // We didn't find the tokens file in ANTLR import dir so we look for it
         // in ANTLR source directory
            if (tokensFilePath.startsWith(antlrSrcDirPath)) {
                tokensDirRelativePath = antlrSrcDirPath.relativize
                                                   (tokensFilePath.getParent());
            } else {
             // We didn't find the tokens file in ANTLR import dir or ANTLR 
             // import dir. So now we look for it in ANTLR destination dir
                if (tokensFilePath.startsWith(antlrDestDirPath)) {
                    tokensDirRelativePath = antlrDestDirPath.relativize
                                                   (tokensFilePath.getParent());
                } else
                    tokensDirRelativePath = null;
            }
        }
        if (tokensDirRelativePath != null) {
//            System.out.println("- grammar dir relative path=" + grammarDirRelativePath);
            String nbCacheDirectory =
                            System.getProperty("netbeans.default_userdir_root");
            String nbProductVersion =
                                  System.getProperty("netbeans.productversion");
//            System.out.println("- NetBeans user cache directory=" + nbCacheDirectory);
//            System.out.println("- NetNeans product version=" + nbProductVersion);
            Pattern versionPattern = Pattern.compile("(\\d(\\.\\d)*)");
            Matcher matcher = versionPattern.matcher(nbProductVersion);
            String nbVersion;
            if (matcher.find()) {
                nbVersion = matcher.group(1);
//                System.out.println("- NetBeans version=" + nbVersion);
            } else
                nbVersion = "unknown_version";

            try {
             // Now we hash the project path in a string of constant length
                MessageDigest digest1 = MessageDigest.getInstance("SHA-1");
                byte[] hash1 = digest1.digest(projectDir.getBytes("UTF-8"));
                StringBuilder hashedProjectDir = new StringBuilder();
                for (int i = 0; i < hash1.length; i++) {
                    String hex = Integer.toHexString(0xff & hash1[i]);
                    if (hex.length() == 1)
                        hashedProjectDir.append('0');
                    hashedProjectDir.append(hex);
                }
                summaryDirPath = Paths.get(nbCacheDirectory                ,
                                           nbVersion                       ,
                                           "summaries"                     ,
                                           hashedProjectDir.toString()     ,
                                           tokensDirRelativePath.toString());
            } catch (NoSuchAlgorithmException |
                     UnsupportedEncodingException ex) {
             // SHA-1 cannot be unsupported
             // UTF-8 cannot be unsupported
                summaryDirPath = null;
            }
        } else
            summaryDirPath = null;
//        System.out.println("TokensSummary:getSummaryDirPath(Path) -> Path : end");
        return summaryDirPath;
    }
}