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
package org.nemesis.antlr.v4.netbeans.v8.grammar.code.summary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
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

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.StyledDocument;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;

import org.nemesis.antlr.v4.netbeans.v8.grammar.code.checking.impl.ANTLRv4Lexer;
import org.nemesis.antlr.v4.netbeans.v8.grammar.code.checking.impl.ANTLRv4Parser;

import org.nemesis.antlr.v4.netbeans.v8.project.helper.ProjectHelper;

import org.nemesis.antlr.v4.netbeans.v8.tokens.code.checking.impl.TokensLexer;
import org.nemesis.antlr.v4.netbeans.v8.tokens.code.checking.impl.TokensParser;

import org.nemesis.antlr.v4.netbeans.v8.tokens.code.summary.TokensSummary;

import org.netbeans.api.project.Project;

import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;

import org.openide.text.NbDocument;

/**
 *
 * @author Frédéric Yvon Vinet
 */
public class GrammarSummary {
    protected final Path                      sourceFilePath;
    
    protected       String                    grammarName;
    protected       GrammarType               grammarType;
    protected       int                       grammarIdStartOffset;
    protected       int                       grammarIdEndOffset;
    
    protected       String                    packageName;
    
    protected final ArrayList<String>         javaImports;
    protected final Map<String, Integer>      javaImportIdStartOffsets;
    protected final Map<String, Integer>      javaImportIdEndOffsets;
    
    protected final List<String>              importedGrammars;
    protected final Map<String, Integer>      importedGrammarIdStartOffsets;
    protected final Map<String, Integer>      importedGrammarIdEndOffsets;
    
    protected final List<String>              importedTokenFiles;
    protected final Map<String, Integer>      importedTokenFileIdStartOffsets;
    protected final Map<String, Integer>      importedTokenFileIdEndOffsets;
    
    protected       String                    superClass;
    protected       String                    tokenClass;
    
    protected final ArrayList<String>         tokens;
    protected final Map<String, Integer>      tokenOffsets;
    
    protected final ArrayList<String>         channels;
    protected final Map<String, Integer>      channelStartOffsets;
    protected final Map<String, Integer>      channelEndOffsets;
    
    protected final ArrayList<String>         modes;
    protected final Map<String, Integer>      modeStartOffsets;
    protected final Map<String, Integer>      modeEndOffsets;
    
    protected final ArrayList<String>         tokenRuleIds;
    protected final Map<String, List<String>> tokenRuleIdsOfMode;
    protected final Map<String, Integer>      tokenRuleIdStartOffsets;
    protected final Map<String, Integer>      tokenRuleIdEndOffsets;
    
    protected final ArrayList<String>         fragmentRuleIds;
    protected final Map<String, List<String>> fragmentRuleIdsOfMode;
    protected final Map<String, Integer>      fragmentRuleIdStartOffsets;
    protected final Map<String, Integer>      fragmentRuleIdEndOffsets;
    
    protected final ArrayList<String>         parserRuleIds;
    protected final Map<String, Integer>      parserRuleIdStartOffsets;
    protected final Map<String, Integer>      parserRuleIdEndOffsets;
    
    protected       boolean                   importedItemsRecovered;
    protected final List<String>              importedTokenIds;
    protected final Map<String, Integer>      importedTokenIdOffsets;
    protected final Map<String, String>       importedTokenFilePaths;
    
    protected final List<String>              importedTokenLiterals;
    protected final Map<String, Integer>      importedTokenLiteralOffsets;
    protected final Map<String, String>       importedTokenLiteralFilePaths;
    
    protected final List<String>              importedFragmentRuleIds;
    protected final Map<String, Integer>      importedFragmentRuleIdOffsets;
    protected final Map<String, String>       importedFragmentFilePaths;

    protected final List<String>              importedParserRuleIds;
    protected final Map<String, Integer>      importedParserRuleIdStartOffsets;
    protected final Map<String, Integer>      importedParserRuleIdEndOffsets;
    protected final Map<String, String>       importedParserRuleFilePaths;
    
    
    public Path getSourceFilePath() {
        return sourceFilePath;
    }
    
    
    public String getGrammarName() {
        return grammarName;
    }
    public void setGrammarName(String grammarName) {
        this.grammarName = grammarName;
    }
    public int getGrammarIdStartOffset() {
        return grammarIdStartOffset;
    }
    public void setGrammarIdStartOffset(int grammarIdStartOffset) {
        this.grammarIdStartOffset = grammarIdStartOffset;
    }
    public int getGrammarIdEndOffset() {
        return grammarIdEndOffset;
    }
    public void setGrammarIdEndOffset(int grammarIdEndOffset) {
        this.grammarIdEndOffset = grammarIdEndOffset;
    }
    
    
    public GrammarType getGrammarType() {
        return grammarType;
    }
    public void setGrammarType(GrammarType grammarType) {
        this.grammarType = grammarType;
    }
    

    public String getPackageName() {
        return packageName;
    }
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
    
    
    public List<String> getJavaImports() {
        return javaImports;
    }
    public void addAllJavaImports(List<String> javaImports) {
        this.javaImports.addAll(javaImports);
    }
    public void addJavaImport(String javaImport) {
        this.javaImports.add(javaImport);
    }
    public Map<String, Integer> getJavaImportIdStartOffsets() {
        return javaImportIdStartOffsets;
    }
    public void putAllJavaImportIdStartOffsets(Map<String, Integer> javaImportIdStartOffsets) {
        this.javaImportIdStartOffsets.putAll(javaImportIdStartOffsets);
    }
    public void putJavaImportIdStartOffset(String javaImportId, Integer javaImportIdStartOffset) {
        javaImportIdStartOffsets.put(javaImportId, javaImportIdStartOffset);
    }
    public Map<String, Integer> getJavaImportIdEndOffsets() {
        return javaImportIdEndOffsets;
    }
    public void putAllJavaImportIdEndOffsets(Map<String, Integer> javaImportIdEndOffsets) {
        this.javaImportIdEndOffsets.putAll(javaImportIdEndOffsets);
    }
    public void putJavaImportIdEndOffset(String javaImportId, Integer javaImportIdEndOffset) {
        javaImportIdEndOffsets.put(javaImportId, javaImportIdEndOffset);
    }
    
    
    public List<String> getImportedGrammars() {
        return importedGrammars;
    }
    public void addAllImportedGrammars(List<String> importedGrammars) {
        this.importedGrammars.addAll(importedGrammars);
    }
    public void addImportedGrammar(String grammarId) {
        this.importedGrammars.add(grammarId);
    }
    public Map<String, Integer> getImportedGrammarIdStartOffsets() {
        return importedGrammarIdStartOffsets;
    }
    public void putAllImportedGrammarIdStartOffsets(Map<String, Integer> importedGrammarStartOffsets) {
        this.importedGrammarIdStartOffsets.putAll(importedGrammarStartOffsets);
    }
    public void putImportedGrammarIdStartOffset(String importedGrammarId, Integer importedGrammarStartOffset) {
        importedGrammarIdStartOffsets.put(importedGrammarId, importedGrammarStartOffset);
    }
    public Map<String, Integer> getImportedGrammarIdEndOffsets() {
        return importedGrammarIdEndOffsets;
    }
    public void putAllImportedGrammarIdEndOffsets(Map<String, Integer> importedGrammarEndOffsets) {
        this.importedGrammarIdEndOffsets.putAll(importedGrammarEndOffsets);
    }
    public void putImportedGrammarIdEndOffset(String importedGrammarId, Integer importedGrammarEndOffset) {
        importedGrammarIdEndOffsets.put(importedGrammarId, importedGrammarEndOffset);
    }

    
    public List<String> getImportedTokenFiles() {
        return importedTokenFiles;
    }
    public void addAllImportedTokenFiles(List<String> importedTokenFiles) {
        this.importedTokenFiles.addAll(importedTokenFiles);
    }
    public void addImportedTokenFile(String importedTokenFile) {
        this.importedTokenFiles.add(importedTokenFile);
    }
    public Map<String, Integer> getImportedTokenFileIdStartOffsets() {
        return importedTokenFileIdStartOffsets;
    }
    public void putAllImportedTokenFileIdStartOffsets(Map<String, Integer> importedTokenFileIdStartOffsets) {
        this.importedTokenFileIdStartOffsets.putAll(importedTokenFileIdStartOffsets);
    }
    public void putImportedTokenFileIdStartOffset(String importedTokenFileId, Integer importedTokenFileIdStartOffset) {
        importedTokenFileIdStartOffsets.put(importedTokenFileId, importedTokenFileIdStartOffset);
    }
    public Map<String, Integer> getImportedTokenFileIdEndOffsets() {
        return importedTokenFileIdEndOffsets;
    }
    public void putAllImportedTokenFileIdEndOffsets(Map<String, Integer> importedTokenFileIdEndOffsets) {
        this.importedTokenFileIdEndOffsets.putAll(importedTokenFileIdEndOffsets);
    }
    public void putImportedTokenFileIdEndOffset(String importedTokenFileId, Integer importedTokenFileIdEndOffset) {
        importedTokenFileIdEndOffsets.put(importedTokenFileId, importedTokenFileIdEndOffset);
    }

    
    public String getSuperClass() {
        return superClass;
    }
    public void setSuperClass(String superClass) {
        this.superClass = superClass;
    }

    
    public String getTokenClass() {
        return tokenClass;
    }
    public void setTokenClass(String tokenClass) {
        this.tokenClass = tokenClass;
    }

    
    public List<String> getTokens() {
        return tokens;
    }
    public void addAllTokens(List<String> tokens) {
        this.tokens.addAll(tokens);
    }
    public void addToken(String tokenId) {
        this.tokens.add(tokenId);
    }
    public Map<String, Integer> getTokenOffsets() {
        return tokenOffsets;
    }
    public void putAllTokenOffsets(Map<String, Integer> tokenOffsets) {
        this.tokenOffsets.putAll(tokenOffsets);
    }
    public void putTokenOffset(String tokenId, Integer tokenOffset) {
        tokenOffsets.put(tokenId, tokenOffset);
    }
    
    
    public List<String> getModes() {
        return modes;
    }
    public void addAllModes(List<String> modeIds) {
        this.modes.addAll(modeIds);
    }
    public void addMode(String modeId) {
        modes.add(modeId);
    }
    public Map<String, Integer> getModeStartOffsets() {
        return modeStartOffsets;
    }
    public void putAllModeStartOffsets(Map<String, Integer> modeStartOffsets) {
        this.modeStartOffsets.putAll(modeStartOffsets);
    }
    public void putModeStartOffset(String modeId, Integer modeStartOffset) {
        modeStartOffsets.put(modeId, modeStartOffset);
    }
    public Map<String, Integer> getModeEndOffsets() {
        return modeEndOffsets;
    }
    public void putAllModeEndOffsets(Map<String, Integer> modeEndOffsets) {
        this.modeEndOffsets.putAll(modeEndOffsets);
    }
    public void putModeEndOffset(String modeId, Integer modeEndOffset) {
        modeEndOffsets.put(modeId, modeEndOffset);
    }
    
    
    public List<String> getChannels() {
        return channels;
    }
    public void addAllChannels(List<String> channelIds) {
        this.channels.addAll(channelIds);
    }
    public void addChannel(String channelId) {
        this.channels.add(channelId);
    }
    public Map<String, Integer> getChannelStartOffsets() {
        return channelStartOffsets;
    }
    public void putAllChannelStartOffsets(Map<String, Integer> channelStartOffsets) {
        this.channelStartOffsets.putAll(channelStartOffsets);
    }
    public void putChannelStartOffset(String channelId, Integer channelStartOffset) {
        channelStartOffsets.put(channelId, channelStartOffset);
    }
    public Map<String, Integer> getChannelEndOffsets() {
        return channelEndOffsets;
    }
    public void putAllChannelEndOffsets(Map<String, Integer> channelEndOffsets) {
        this.channelEndOffsets.putAll(channelEndOffsets);
    }
    public void putChannelEndOffset(String channelId, Integer channelEndOffset) {
        channelEndOffsets.put(channelId, channelEndOffset);
    }
    
    
    public ArrayList<String> getTokenRuleIds() {
        return tokenRuleIds;
    }
    public void addAllTokenRuleIds(List<String> tokenRuleIds) {
        this.tokenRuleIds.addAll(tokenRuleIds);
    }
    public void addTokenRuleId(String tokenId) {
        this.tokenRuleIds.add(tokenId);
    }
    public int getTokenRuleNumber() {
        return this.tokenRuleIds.size();
    }
    public Map<String, Integer> getTokenRuleIdStartOffsets() {
        return tokenRuleIdStartOffsets;
    }
    public void putAllTokenRuleIdStartOffsets(Map<String, Integer> tokenRuleIdStartOffsets) {
        this.tokenRuleIdStartOffsets.putAll(tokenRuleIdStartOffsets);
    }
    public void putTokenRuleIdStartOffset(String modeId, Integer tokenRuleIdStartOffset) {
        tokenRuleIdStartOffsets.put(modeId, tokenRuleIdStartOffset);
    }
    public Map<String, Integer> getTokenRuleIdEndOffsets() {
        return tokenRuleIdEndOffsets;
    }
    public void putAllTokenRuleIdEndOffsets(Map<String, Integer> tokenRuleIdEndOffsets) {
        this.tokenRuleIdEndOffsets.putAll(tokenRuleIdEndOffsets);
    }
    public void putTokenRuleIdEndOffset(String modeId, Integer tokenRuleIdEndOffset) {
        this.tokenRuleIdEndOffsets.put(modeId, tokenRuleIdEndOffset);
    }
    
    
    public void putAllTokenRuleIdsOfMode(Map<String, List<String>> tokenRuleIdsOfMode) {
//        System.out.println("putAllTokenRuleIdsOfMode() : begin");
        this.tokenRuleIdsOfMode.putAll(tokenRuleIdsOfMode);
//        System.out.println("- size=" + tokenRuleIdsOfMode.size());
//        System.out.println("putAllTokenRuleIdsOfMode() : end");
    }
    public Map<String, List<String>> getTokenRuleIdsOfMode() {
        return this.tokenRuleIdsOfMode;
    }
    
    
    public ArrayList<String> getFragmentRuleIds() {
        return fragmentRuleIds;
    }
    public void addAllFragmentRuleIds(List<String> fragmentRuleIds) {
        this.fragmentRuleIds.addAll(fragmentRuleIds);
    }
    public void addFragmentRuleId(String fragmentRuleId) {
        this.fragmentRuleIds.add(fragmentRuleId);
    }
    public Map<String, Integer> getFragmentRuleIdStartOffsets() {
        return fragmentRuleIdStartOffsets;
    }
    public void putAllFragmentRuleIdStartOffsets(Map<String, Integer> fragmentRuleIdStartOffsets) {
        this.fragmentRuleIdStartOffsets.putAll(fragmentRuleIdStartOffsets);
    }
    public void putFragmentRuleIdStartOffset(String fragmentId, Integer fragmentRuleIdStartOffset) {
        fragmentRuleIdStartOffsets.put(fragmentId, fragmentRuleIdStartOffset);
    }
    public Map<String, Integer> getFragmentRuleIdEndOffsets() {
        return fragmentRuleIdEndOffsets;
    }
    public void putAllFragmentRuleIdEndOffsets(Map<String, Integer> fragmentRuleIdEndOffsets) {
        this.fragmentRuleIdEndOffsets.putAll(fragmentRuleIdEndOffsets);
    }
    public void putFragmentRuleIdEndOffset(String fragmentId, Integer fragmentRuleIdEndOffset) {
        fragmentRuleIdEndOffsets.put(fragmentId, fragmentRuleIdEndOffset);
    }
    
    
    public void putAllFragmentRuleIdsOfMode(Map<String, List<String>> fragmentRuleIdsOfMode) {
        this.fragmentRuleIdsOfMode.putAll(fragmentRuleIdsOfMode);
    }
    public Map<String, List<String>> getFragmentRuleIdsOfMode() {
        return this.fragmentRuleIdsOfMode;
    }

    
    public ArrayList<String> getParserRuleIds() {
        return parserRuleIds;
    }
    public void addAllParserRuleIds(List<String> parserRuleIds) {
        this.parserRuleIds.addAll(parserRuleIds);
    }
    public void addParserRuleId(String parserRuleId) {
        this.parserRuleIds.add(parserRuleId);
    }
    public Map<String, Integer> getParserRuleIdStartOffsets() {
        return parserRuleIdStartOffsets;
    }
    public void putAllParserRuleIdStartOffsets(Map<String, Integer> parserRuleIdStartOffsets) {
        this.parserRuleIdStartOffsets.putAll(parserRuleIdStartOffsets);
    }
    public void putParserRuleIdStartOffset(String parserRuleId, Integer parserRuleIdStartOffset) {
        this.parserRuleIdStartOffsets.put(parserRuleId, parserRuleIdStartOffset);
    }
    public Map<String, Integer> getParserRuleIdEndOffsets() {
        return parserRuleIdEndOffsets;
    }
    public void putAllParserRuleIdEndOffsets(Map<String, Integer> parserRuleIdEndOffsets) {
        this.parserRuleIdEndOffsets.putAll(parserRuleIdEndOffsets);
    }
    public void putParserRuleIdEndOffset(String parserRuleId, Integer parserRuleIdEndOffset) {
        this.parserRuleIdEndOffsets.put(parserRuleId, parserRuleIdEndOffset);
    }
    
    
 // - the tokens declared in token rules of imported grammars,
 // - or defined in tokens statement of imported grammars,
 // - or tokens from imported token files.
    public List<String> getImportedTokenIds() {
        if (!importedItemsRecovered)
            recoverImportedItems();
        return importedTokenIds;
    }
    public Map<String, Integer> getImportedTokenIdOffsets() {
        if (!importedItemsRecovered)
            recoverImportedItems();
        return importedTokenIdOffsets;
    }
    public Map<String, String> getImportedTokenFilePaths() {
        if (!importedItemsRecovered)
            recoverImportedItems();
        return importedTokenFilePaths;
    }
    
    
    public List<String> getImportedTokenLiterals() {
        if (!importedItemsRecovered)
            recoverImportedItems();
        return importedTokenLiterals;
    }
    public Map<String, Integer> getImportedTokenLiteralOffsets() {
        if (!importedItemsRecovered)
            recoverImportedItems();
        return importedTokenLiteralOffsets;
    }
    public Map<String, String> getImportedTokenLiteralFilePaths() {
        if (!importedItemsRecovered)
            recoverImportedItems();
        return importedTokenLiteralFilePaths;
    }
    
    
    public List<String> getImportedFragmentRuleIds() {
        if (!importedItemsRecovered)
            recoverImportedItems();
        return importedFragmentRuleIds;
    }
    public Map<String, Integer> getImportedFragmentRuleIdOffsets() {
        if (!importedItemsRecovered)
            recoverImportedItems();
        return importedFragmentRuleIdOffsets;
    }
    public Map<String, String> getImportedFragmentFilePaths() {
        if (!importedItemsRecovered)
            recoverImportedItems();
        return importedFragmentFilePaths;
    }
    
    
    public List<String> getImportedParserRuleIds() {
        if (!importedItemsRecovered)
            recoverImportedItems();
        return importedParserRuleIds;
    }
    public Map<String, Integer> getImportedParserRuleIdStartOffsets() {
        if (!importedItemsRecovered)
            recoverImportedItems();
        return importedParserRuleIdStartOffsets;
    }
    public Map<String, Integer> getImportedParserRuleIdEndOffsets() {
        if (!importedItemsRecovered)
            recoverImportedItems();
        return importedParserRuleIdEndOffsets;
    }
    public Map<String, String> getImportedParserRuleFilePaths() {
        if (!importedItemsRecovered)
            recoverImportedItems();
        return importedParserRuleFilePaths;
    }
    
    
    public GrammarSummary(Path sourceFilePath) {
        assert sourceFilePath != null;
        this.sourceFilePath = sourceFilePath;
        
        this.grammarName = null;
        this.grammarType = GrammarType.UNDEFINED;
        this.grammarIdStartOffset = -1;
        this.grammarIdEndOffset = -1;
        
        this.packageName = null;
        this.javaImports = new ArrayList<>();
        this.javaImportIdStartOffsets = new HashMap<>();
        this.javaImportIdEndOffsets   = new HashMap<>();
        
        this.importedGrammars = new ArrayList<>();
        this.importedGrammarIdStartOffsets = new HashMap<>();
        this.importedGrammarIdEndOffsets = new HashMap<>();
        
        this.importedTokenFiles = new ArrayList<>();
        this.importedTokenFileIdStartOffsets = new HashMap<>();
        this.importedTokenFileIdEndOffsets = new HashMap<>();
        
        this.superClass = null;
        this.tokenClass = null;
        
        this.tokens = new ArrayList<>();
        this.tokenOffsets = new HashMap<>();
        
        this.channels = new ArrayList<>();
        this.channelStartOffsets = new HashMap<>();
        this.channelEndOffsets = new HashMap<>();
        
        this.modes = new ArrayList<>();
        this.modeStartOffsets = new HashMap<>();
        this.modeEndOffsets = new HashMap<>();
        
        this.tokenRuleIds = new ArrayList<>();
        this.tokenRuleIdsOfMode = new HashMap<>();
        this.tokenRuleIdStartOffsets =  new HashMap<>();
        this.tokenRuleIdEndOffsets =  new HashMap<>();
        
        this.fragmentRuleIds = new ArrayList<>();
        this.fragmentRuleIdsOfMode = new HashMap<>();
        this.fragmentRuleIdStartOffsets = new HashMap<>();
        this.fragmentRuleIdEndOffsets = new HashMap<>();
        
        this.parserRuleIds = new ArrayList<>();
        this.parserRuleIdStartOffsets = new HashMap<>();
        this.parserRuleIdEndOffsets = new HashMap<>();
        
        this.importedItemsRecovered = false;
        
        this.importedTokenIds = new ArrayList<>();
        this.importedTokenIdOffsets = new HashMap<>();
        this.importedTokenFilePaths = new HashMap<>();
        
        this.importedTokenLiterals = new ArrayList<>();
        this.importedTokenLiteralOffsets = new HashMap<>();
        this.importedTokenLiteralFilePaths = new HashMap<>();
        
        this.importedFragmentRuleIds = new ArrayList<>();
        this.importedFragmentRuleIdOffsets = new HashMap<>();
        this.importedFragmentFilePaths = new HashMap<>();
        
        this.importedParserRuleIds = new ArrayList<>();
        this.importedParserRuleIdStartOffsets = new HashMap<>();
        this.importedParserRuleIdEndOffsets = new HashMap<>();
        this.importedParserRuleFilePaths = new HashMap<>();
    }
    
    
 /**
  * Imported tokens are:
  * - token defined in imported grammars (with the help of a token definition 
  *   rules),
  * - token declared in tokens section of imported grammars,
  * - token declared in imported token files (tokenVoca option).
  * 
  * Imported fragments are:
  * - fragment defined in imported grammars (with the help of fragment definition
  *   rules),
  * - fragment defined in imported grammars of imported grammars.
  * 
  * The method recovers also correspondent offset and file paths.
  * 
  * @return 
  */
    protected void recoverImportedItems() {
//        System.out.println("GrammarSummary:recoverImportedItems() -> List<String> : begin");
//        System.out.println("- process of file: " + sourceFilePath);
     // We load the document associated to our source path
        File grammarSource = sourceFilePath.toFile();
        FileObject grammarSourceFO = FileUtil.toFileObject(grammarSource);
        Document doc = NbDocument.getDocument(grammarSourceFO);
     // We recover the project info associated to that document
        Project project = ProjectHelper.getProject(doc);
        File antlrImportDir = ProjectHelper.getANTLRImportDir(project);
        String antlrImportDirPath = antlrImportDir.getPath();
        File importingGrammarDir = ProjectHelper.getDirectory(doc);
//        System.out.println("- importing grammar dir=" + importingGrammarDir);
        
     // We scan all imported grammars and recover for each grammar its token ids
     // and its fragment ids
//        System.out.println("- imported grammar scanning:");
        for (String importedGrammarId : importedGrammars) {
//            System.out.println("  * grammar: " + importedGrammarId);
         // We build the file name
            StringBuilder importedFileNameB = new StringBuilder();
            importedFileNameB.append(importedGrammarId);
            importedFileNameB.append(".g4");
            String importedFileName = importedFileNameB.toString();
//            System.out.println("    + We look for: " + importedFileName);
            
         // The imported grammar may be in the same directory as importing
         // grammar (in ANTLR directory or in one of its subdirectories) or in
         // import directory
            Path importedGrammarPath = Paths.get(importingGrammarDir.getPath(),
                                                 importedFileName             );
            File importedGrammar = null;
            if (Files.exists(importedGrammarPath)) {
//                System.out.println("    + File found in the same directory as importing grammar");
                importedGrammar = importedGrammarPath.toFile();
            } else {
             // We didn't find the file in the same directory as importing 
             // grammar, so now we look for it in import directory
                importedGrammarPath = Paths.get(antlrImportDirPath,
                                                importedFileName  );
                if (Files.exists(importedGrammarPath)) {
//                    System.out.println("    + File found in ANTLR import directory");
                    importedGrammar = importedGrammarPath.toFile();
                }
//                else
//                    System.out.println("    + File not found!!!");
            }
            if (importedGrammar != null) {
                FileObject importedGrammarFO =
                                         FileUtil.toFileObject(importedGrammar);
             // Next method always returns a document even if no editor hosts
             // the document but however it does not open an editor.
             // It just loads the document in memory if this one is not already
             // loaded
                StyledDocument importedGrammarDoc =
                                   ProjectHelper.getDocument(importedGrammarFO);
                GrammarSummary summary = (GrammarSummary)
                           importedGrammarDoc.getProperty(GrammarSummary.class);
             // If the imported document is not currently edited then there is 
             // no summary already loaded in memory
                if (summary == null) {
//                    System.out.println("    + summary not loaded yet");
                 // So we decide to load it from disk
                    String importedGrammarFilePathString =
                                                    importedGrammarFO.getPath();
                    summary = GrammarSummary.load
                                                (project                      ,
                                                 importedGrammarFilePathString);
                 // On first creation of a summary it is possible that imported
                 // grammar summary files don't exist yet. In this case, we have
                 // to force their creations by parsing them
                    if (summary == null) {
//                        System.out.println("    + No summary on disk cache");
                        try {
                            String content = importedGrammarDoc.getText
                                            (0, importedGrammarDoc.getLength());
                            try (Reader sr = new StringReader(content) ) {
                                ANTLRInputStream input = new ANTLRInputStream(sr);
                                ANTLRv4Lexer lexer = new ANTLRv4Lexer(input);
            
                                CommonTokenStream tokens = new CommonTokenStream
                                                                        (lexer);
                                ANTLRv4Parser parser = new ANTLRv4Parser(tokens);
                                parser.removeErrorListeners(); // remove ConsoleErrorListener
                             // We add a collector in charge of collecting a 
                             // summary of grammar (summary is attached to 
                             // parsed document as a property with
                             // GrammarSummary.class as a key)
                                Collector collector = new Collector
                                                     (doc, importedGrammarPath);
                                parser.addParseListener(collector);
                             // We parser the document content with only a 
                             // collector. So at the end of parsing, document 
                             // has a property containing our summary
                                parser.grammarFile();
                             // Now a summary is attached to our imported document
                                summary = (GrammarSummary)
                                                  importedGrammarDoc.getProperty
                                                         (GrammarSummary.class);
                            }
                        } catch(BadLocationException ex) {
                         // With thiese parameter values it is not possible to 
                         // have an exception of this type
                        } catch (IOException ex) {
                            
                        }

                    }
/*
                    if (summary != null)
                        System.out.println("    + summary loaded");
                    else
                        System.out.println("    + no summary found!!!");
*/
                }
                if (summary != null) {
                 // We recover all tokens defined in that grammar
                    List<String> importedTokenIds2 = summary.getTokenRuleIds();
                    importedTokenIds.addAll(importedTokenIds2);
                    Map<String,Integer> importedTokenIdOffsets2 =
                                           summary.getTokenRuleIdStartOffsets();
                    importedTokenIdOffsets.putAll(importedTokenIdOffsets2);
//                    System.out.println("    + list of token declared in local token rules:");
                    for (String importedTokenId : importedTokenIds2) {
//                        System.out.println("      - token Id=" + importedTokenId);
//                        System.out.println("        associated file path=" + importedGrammarPath.toString());
                        importedTokenFilePaths.put
                                               (importedTokenId               ,
                                                importedGrammarPath.toString());
                    }
                    
                 // We recover all tokens declared in tokens section in that
                 // imported grammar
                    List<String> importedTokens = summary.getTokens();
                    importedTokenIds.addAll(importedTokens);
                    Map<String,Integer> importedTokenOffsets2 =
                                                      summary.getTokenOffsets();
                    importedTokenIdOffsets.putAll(importedTokenOffsets2);
//                    System.out.println("    + list of token declared in local tokens statement:");
                    for (String importedTokenId : importedTokens) {
//                        System.out.println("      - token Id=" + importedTokenId);
//                        System.out.println("        associated file path=" + importedGrammarPath.toString());
                        importedTokenFilePaths.put
                                               (importedTokenId               ,
                                                importedGrammarPath.toString());
                    }
                
                 // We recover all tokens declared in imported tokens files or
                 // in imported grammar files.
                    List<String> importedTokenIds3 = summary.getImportedTokenIds();
                    this.importedTokenIds.addAll(importedTokenIds3);
//                    System.out.println("    + list of imported token ids (all categories):");
//                    for (String importedTokenId : importedTokens) {
//                        System.out.println("      - token Id=" + importedTokenId);
//                    }
                    Map<String,Integer> importedTokenOffsets3 =
                                            summary.getImportedTokenIdOffsets();
                    importedTokenIdOffsets.putAll(importedTokenOffsets3);
                    Map<String,String> importedTokenFilePaths2 =
                                            summary.getImportedTokenFilePaths();
                    this.importedTokenFilePaths.putAll(importedTokenFilePaths2);
                
                 // For fragments, it is simpler
                 // We recover fragment defined in that grammar
                    List<String> localFragmentIds = summary.getFragmentRuleIds();
                    this.importedFragmentRuleIds.addAll(localFragmentIds);
                    Map<String,Integer> localFragmentIdOffsets =
                                        summary.getFragmentRuleIdStartOffsets();
                    importedFragmentRuleIdOffsets.putAll
                                                       (localFragmentIdOffsets);
//                    System.out.println("    * list of local fragment rules:");
                    for (String localFragmentId : localFragmentIds) {
//                        System.out.println("      - fragment Id=" + localFragmentId);
//                        System.out.println("        associated file path=" + importedGrammarPath.toString());
                        importedFragmentFilePaths.put
                                               (localFragmentId               ,
                                                importedGrammarPath.toString());
                    }
                
                 // We recover fragment defined in imported grammar files
                    List<String> importedFragmentRuleIds =
                                           summary.getImportedFragmentRuleIds();
                    importedFragmentRuleIds.addAll(importedFragmentRuleIds);
                    Map<String,Integer> importedFragmentIdOffsets2 =
                                summary.getImportedFragmentRuleIdOffsets();
                    importedFragmentRuleIdOffsets.putAll
                                                   (importedFragmentIdOffsets2);
                    Map<String,String> importedFragmentFilePaths2 =
                                         summary.getImportedFragmentFilePaths();
                    importedFragmentFilePaths.putAll(importedFragmentFilePaths2);
//                    System.out.println("    * list of imported fragment rules:");
//                    for (String importedFragmentId : importedFragmentRuleIds) {
//                        System.out.println("      - fragment Id=" + importedFragmentId);
//                        System.out.println("        associated file path=" + importedFragmentFilePaths.get(importedFragmentId));
//                    }
                    
                 // Now we recover parser rules defined in that imported grammar
                    List<String> localParserRuleIds = summary.getParserRuleIds();
                    this.importedParserRuleIds.addAll(localParserRuleIds);
                    Map<String,Integer> localParserRuleIdStartOffsets =
                                          summary.getParserRuleIdStartOffsets();
                    importedParserRuleIdStartOffsets.putAll
                                                (localParserRuleIdStartOffsets);
                    Map<String,Integer> localParserRuleIdEndOffsets =
                                            summary.getParserRuleIdEndOffsets();
                    importedParserRuleIdEndOffsets.putAll
                                                (localParserRuleIdEndOffsets);
//                    System.out.println("    * list of parser rules defined directly in current grammar:");
                    for (String localParserRuleId : localParserRuleIds) {
//                        System.out.println("      - parser rule id=" + localParserRuleId);
//                        System.out.println("        associated file path=" + importedGrammarPath.toString());
                        importedParserRuleFilePaths.put
                                               (localParserRuleId             ,
                                                importedGrammarPath.toString());
                    }
                    
                 // Then we recover parser rules it imports from other grammars
                    List<String> importedParserRuleIds2 = summary.getImportedParserRuleIds();
                    importedParserRuleIds.addAll(importedParserRuleIds2);
                    Map<String,Integer> importedParserRuleIdStartOffsets2 =
                                  summary.getImportedParserRuleIdStartOffsets();
                    importedParserRuleIdStartOffsets.putAll
                                            (importedParserRuleIdStartOffsets2);
                    Map<String,String> importedParserRuleFilePaths2 =
                                       summary.getImportedParserRuleFilePaths();
                    importedParserRuleFilePaths.putAll(importedParserRuleFilePaths2);
/*
                    System.out.println("    * list of imported parser rules by current grammar:");
                    for (String importedParserRuleId : importedParserRuleIds2) {
                        System.out.println("      - fragment Id=" + importedParserRuleId);
                        System.out.println("        associated file path=" + importedParserRuleFilePaths.get(importedParserRuleId));
                    }
*/
                }
            }
        }
        
     // We scan all imported token files and recover for each file its token ids
        Path importingGrammarDirPath = importingGrammarDir.toPath();
//        System.out.println("- imported tokens file scanning:");
        for (String importedTokenFile : importedTokenFiles) {
//            System.out.println("  * imported token file path=" + importedTokenFile);
            recoverTokenIds
                          (project, importingGrammarDirPath, importedTokenFile);
        }
        
     // We display recovered tokens
//        System.out.println("- resulting imported token ids:");
//        for (String importedTokenId : importedTokenIds) {
//            System.out.println("  * imported token Id=" + importedTokenId);
//        }
        
        importedItemsRecovered = true;
//        System.out.println("GrammarSummary:recoverImportedItems() -> List<String> : end");
    }
    
    
    protected List<String> recoverTokenIds
            (Project project                ,
             Path    importingGrammarDirPath,
             String  importedTokenFileName  ) {
//        System.out.println("GrammarSummary:recoverTokenIds(Project, Path, String) -> List<String> : begin");
        assert project != null;
        assert importedTokenFileName!= null;
//        System.out.println("- process of file: " + importedTokenFileName);
//        System.out.println("- importing grammar dir path=" + importingGrammarDirPath);
        
     // We have to locate the file defined by importedTokenFileName
     // It may be placed in:
     // - the same directory as importing grammar,
     // - in ANTLR import directory if importing grammar is not in that 
     //   directory,
     // - in ANTLR destination directory concatenated with relative importing 
     //   grammar directory.
        File antlrDestinationDir = ProjectHelper.getANTLRDestinationDir(project);
        File antlrSrcDir = ProjectHelper.getANTLRSourceDir(project);
        File antlrImportDir = ProjectHelper.getANTLRImportDir(project);
        Path importedTokensFilePath = determineTokensFilePath
                     (importedTokenFileName       ,
                      importingGrammarDirPath     ,
                      antlrSrcDir.toPath()        ,
                      antlrImportDir.toPath()     ,
                      antlrDestinationDir.toPath());
     // It is possible that the imported token file does not exist (of course
     // the grammar will not compile but it must not lead to a null pointer
     // exception in tokens summary management)
        if (importedTokensFilePath != null) {
//            System.out.println("- imported tokens file path=" + importedTokensFilePath);
        
         // We look for the associated summary
            FileObject importedTokensFO = FileUtil.toFileObject
                                              (importedTokensFilePath.toFile());
         // Next method always returns a document even if no editor hosts
         // the document but however it does not open an editor.
         // It just loads the document in memory if this one is not already
         // loaded
            StyledDocument importedTokensDoc = ProjectHelper.getDocument
                                                             (importedTokensFO);
            TokensSummary summary = (TokensSummary) importedTokensDoc.getProperty
                                                          (TokensSummary.class);
            
         // If the imported document is not currently edited then there is no
         // summary already loaded in memory
            if (summary == null) {
//                System.out.println("  summary not loaded yet");
                summary = TokensSummary.load(project                    ,
                                             importedTokensFO.getPath());
                if (summary == null) {
//                    System.out.println("  No summary on disk cache");
                 // We parse the token file without syntactic error detection
                    try {
                        String content = importedTokensDoc.getText
                                             (0, importedTokensDoc.getLength());
                        try (Reader sr = new StringReader(content) ) {
                            ANTLRInputStream input = new ANTLRInputStream(sr);
                            TokensLexer lexer = new TokensLexer(input);
                            CommonTokenStream tokens = new CommonTokenStream(lexer);  
                            TokensParser tokensParser = new TokensParser(tokens);
                            tokensParser.removeErrorListeners(); // remove ConsoleErrorListener
                        
                            org.nemesis.antlr.v4.netbeans.v8.tokens.code.summary.Collector collector = new org.nemesis.antlr.v4.netbeans.v8.tokens.code.summary.Collector(importedTokensDoc, importedTokensFilePath);
                            tokensParser.addParseListener(collector);
                        
                            tokensParser.token_declarations();
//                            System.out.println("  document parsed");
                         // the tokens file has been parsed with a Collector so
                         // we must find a summary attached to our document
                            summary = 
                                   (TokensSummary) importedTokensDoc.getProperty
                                                          (TokensSummary.class);
                        }
                    } catch (BadLocationException ex) {
                      // Impossible that such exception appears with the
                      // chosen parameters of getText()
                    } catch (IOException ex) {
                        System.err.println("Strange! Unable to read the String Buffer");
                    } catch (RecognitionException ex) {
                        System.err.println(ex.toString());
                    }
                }
                else {
//                    System.out.println("  summary loaded");
                    importedTokensDoc.putProperty(TokensSummary.class, summary);
                }
            }
         // On first creation of a summary it is possible that any imported tokens 
         // file summaries don't exist yet.
            if (summary != null) {
             // We recover all token ids defined in that tokens file
                List<String> tokenIds = summary.getTokenIds();
                importedTokenIds.addAll(tokenIds);
                Map<String, Integer> tokenIdOffsets =
                                                    summary.getTokenIdOffsets();
                importedTokenIdOffsets.putAll(tokenIdOffsets);
                String sourceFilePathString =
                                         summary.getSourceFilePath().toString();
                for (String importedTokenId : tokenIds) {
                    importedTokenFilePaths.put
                                        (importedTokenId, sourceFilePathString);
                }
                
             // We recover all token literals defined in that tokens file
                List<String> tokenLiterals = summary.getTokenLiterals();
                importedTokenLiterals.addAll(tokenLiterals);
/*
                if (tokenLiterals.isEmpty())
                    System.out.println("- no imported token literal");
                else {
                    System.out.println("- imported token literals:");
                    for (String tokenLiteral : tokenLiterals)
                        System.out.println("  + " + tokenLiteral);
                }
*/
                Map<String, Integer> literalOffsets =
                                               summary.getTokenLiteralOffsets();
                importedTokenLiteralOffsets.putAll(literalOffsets);
                for (String importedTokenLiteral : tokenLiterals) {
                    importedTokenLiteralFilePaths.put
                                   (importedTokenLiteral, sourceFilePathString);
                }
            }
        }

//        System.out.println("GrammarSummary:recoverTokenIds(Project, Path, String) -> List<String> : end");
        return importedTokenIds;
    }

    
    static protected Path determineTokensFilePath
            (String  importedTokensFileName ,
             Path    importingGrammarDirPath,
             Path    antlrSrcDirPath        ,
             Path    antlrImportDirPath     ,
             Path    antlrDestinationDirPath) {
//        System.out.println("GrammarSummary:determineTokensFilePath() : begin");
//        System.out.println("- imported tokens File name=" + importedTokensFileName);
//        System.out.println("- importing grammar directory path=" + importingGrammarDirPath);
//        System.out.println("- antlr source directory path     =" + antlrSrcDirPath);
//        System.out.println("- antlr import directory path     =" + antlrImportDirPath);
//        System.out.println("- antlr destination directory path=" + antlrDestinationDirPath);

     // We have to locate the file defined by importedTokenFileName
     // It may be placed in:
     // - the same directory as importing grammar,
     // - in ANTLR import directory if importing grammar is not in that 
     //   directory,
     // - in ANTLR destination directory concatenated with relative importing g
     //   rammar directory.
        String importedTokensFileNameExt = importedTokensFileName + ".tokens";
        Path tokensFilePath = Paths.get(importingGrammarDirPath.toString(),
                                        importedTokensFileNameExt         );
//        System.out.println("- tokens File Path 1              =" + tokensFilePath);
        if (!Files.exists(tokensFilePath)) {
         // we didn't find tokens file in the same directory as importing grammar
            if (!importingGrammarDirPath.equals(antlrImportDirPath)) {
             // Importing grammar directory is not placed in import directory
             // So we can look for it in import directory
                tokensFilePath = Paths.get(antlrImportDirPath.toString(),
                                           importedTokensFileNameExt    );
//                System.out.println("- tokens File Path 2              =" + tokensFilePath);
                if (!Files.exists(tokensFilePath)) {
                 // We didn't find tokens file in import directory either
                 // so it may only be in destination directory concatenated with
                 // importing grammar relative directory
                    Path importingGrammarRelativeDir =
                            antlrSrcDirPath.relativize(importingGrammarDirPath);
                    tokensFilePath = Paths.get
                                       (antlrDestinationDirPath.toString()    ,
                                        importingGrammarRelativeDir.toString(),
                                        importedTokensFileNameExt             );
//                    System.out.println("- tokens File Path 3              =" + tokensFilePath);
                    if (!Files.exists(tokensFilePath))
                        tokensFilePath = null;
                }
            } else {
             // importing grammar is placed in import directory
             // so it is useless to look for in import directory.
             // We look for in destination directory
                Path importingGrammarRelativeDir =
                            antlrSrcDirPath.relativize(importingGrammarDirPath);
                tokensFilePath = Paths.get
                                       (antlrDestinationDirPath.toString()    ,
                                        importingGrammarRelativeDir.toString(),
                                        importedTokensFileNameExt             );
//                System.out.println("- tokens File Path 2              =" + tokensFilePath);
                if (!Files.exists(tokensFilePath))
                    tokensFilePath = null;
            }
        }
//        System.out.println("GrammarSummary:determineTokensFilePath() : end");
        return tokensFilePath;
    }
    
    
    protected static final String GRAMMAR_NAME = "grammar.name";
    protected static final String GRAMMAR_TYPE = "grammar.type";
    protected static final String GRAMMAR_START_OFFSET = "grammar.offset.start";
    protected static final String GRAMMAR_END_OFFSET  = "grammar.offset.end";
    
    protected static final String ANALYZER_PACKAGE = "analyzer.package";
    
    protected static final String ANALYZER_IMPORTS = "analyzer.imports";
    protected static final String ANALYZER_IMPORT_START_OFFSETS =
                                                "analyzer.imports.start.offset";
    protected static final String ANALYZER_IMPORT_END_OFFSETS =
                                                  "analyzer.imports.end.offset";
    
    protected static final String ANALYZER_SUPER_CLASS = "analyzer.super.class";
    protected static final String ANALYZER_TOKEN_CLASS = "analyzer.token.class";
    
    protected static final String IMPORTED_GRAMMAR_NAMES =
                                                      "grammars.imported.names";
    protected static final String IMPORTED_GRAMMAR_START_OFFSET =
                                               "grammars.imported.offset.start";
    protected static final String IMPORTED_GRAMMAR_END_OFFSET =
                                                 "grammars.imported.offset.end";
    
    protected static final String IMPORTED_TOKEN_FILE_NAMES =
                                                   "tokens.imported.file.names";
    protected static final String IMPORTED_TOKEN_FILE_START_OFFSET =
                                            "tokens.imported.file.offset.start";
    protected static final String IMPORTED_TOKEN_FILE_END_OFFSET =
                                              "tokens.imported.file.offset.end";
    
    protected static final String MODE_IDS     = "modes.id";
    protected static final String MODE_START_OFFSETS = "modes.start.offset";
    protected static final String MODE_END_OFFSETS = "modes.end.offset";
    
    protected static final String TOKEN_IDS     = "tokens.id";
    protected static final String TOKEN_OFFSETS = "tokens.offset";
    
    protected static final String TOKEN_RULE_IDS     = "tokens.rule.id";
    protected static final String TOKEN_RULE_ID_OF_MODES =
                                                       "tokens.rule.id.OfModes";
    protected static final String TOKEN_RULE_ID_START_OFFSETS =
                                                  "tokens.rule.id.offset.start";
    protected static final String TOKEN_RULE_ID_END_OFFSETS =
                                                    "tokens.rule.id.offset.end";
    
    protected static final String FRAGMENT_RULE_IDS       = "fragments.rule.id";
    protected static final String FRAGMENT_RULE_ID_START_OFFSETS =
                                               "fragments.rule.id.offset.start";
    protected static final String FRAGMENT_RULE_ID_END_OFFSETS =
                                                 "fragments.rule.id.offset.end";
    
    protected static final String PARSER_RULE_IDS       = "parser.rule.ids";
    protected static final String PARSER_RULE_ID_START_OFFSETS =
                                                 "parser.rule.ids.offset.start";
    protected static final String PARSER_RULE_ID_END_OFFSETS =
                                                   "parser.rule.ids.offset.end";
    protected static final String USER_HOME_DIRECTORY =
                                                System.getProperty("user.home");
    public void save () {
//        System.out.println("GrammarSummary:save() : begin");
//        System.out.println("- source file path " + sourceFilePath);
        try {
            Path summaryDirPath = getSummaryDirPath(sourceFilePath);
//            System.out.println
//                     ("- proposed directory path for storing our summary=" +
//                      summaryDirPath.toString()                             );
            
            if (!Files.exists(summaryDirPath)) {
                summaryDirPath = Files.createDirectories(summaryDirPath);
            }
            
         // We extract the file name from its path
            String grammarFileName = sourceFilePath.getFileName().toString();
            String summaryFileName = grammarFileName + ".properties";
            Path summaryPath = Paths.get(summaryDirPath.toString(),
                                         summaryFileName          );
//            System.out.println("- summary path =" + summaryPath);
            
         // We delete the previous instance of summary file if it exists
            Files.deleteIfExists(summaryPath);
            Properties props = new Properties();
            props.setProperty("sourceFileName", sourceFilePath.toString());
                
            if (grammarName == null)
                props.setProperty(GRAMMAR_NAME, "");
            else
                props.setProperty(GRAMMAR_NAME, grammarName);
                
            props.setProperty(GRAMMAR_TYPE          ,
                              grammarType.toString());
                
            props.setProperty(GRAMMAR_START_OFFSET                  ,
                              Integer.toString(grammarIdStartOffset));
                
            props.setProperty(GRAMMAR_END_OFFSET                  ,
                              Integer.toString(grammarIdEndOffset));
                
            if (packageName == null)
                props.setProperty(ANALYZER_PACKAGE, "");
            else
                props.setProperty(ANALYZER_PACKAGE, packageName);
                
            StringBuilder propertyValue = new StringBuilder();
            for (String javaImport : javaImports) {
                if (!propertyValue.toString().equals(""))
                    propertyValue.append(",");
                propertyValue.append(javaImport);
            }
            props.setProperty(ANALYZER_IMPORTS, propertyValue.toString());
            
            propertyValue = new StringBuilder();
            for (String javaImport : javaImports) {
                if (!propertyValue.toString().equals(""))
                    propertyValue.append(";");
                propertyValue.append("(");
                propertyValue.append(javaImport);
                propertyValue.append(",");
                propertyValue.append(javaImportIdStartOffsets.get(javaImport));
                propertyValue.append(")");
            }
            props.setProperty(ANALYZER_IMPORT_START_OFFSETS,
                              propertyValue.toString()     );
                
            propertyValue = new StringBuilder();
            for (String javaImport : javaImports) {
                if (!propertyValue.toString().equals(""))
                    propertyValue.append(";");
                propertyValue.append("(");
                propertyValue.append(javaImport);
                propertyValue.append(",");
                propertyValue.append(javaImportIdEndOffsets.get(javaImport));
                propertyValue.append(")");
            }
            props.setProperty(ANALYZER_IMPORT_END_OFFSETS,
                              propertyValue.toString()     );
                
            propertyValue = new StringBuilder();
            for (String importedGrammar : importedGrammars) {
                if (!propertyValue.toString().equals(""))
                    propertyValue.append(",");
                propertyValue.append(importedGrammar);
            }
            props.setProperty(IMPORTED_GRAMMAR_NAMES,propertyValue.toString());
                
            propertyValue = new StringBuilder();
            for (String importedGrammar : importedGrammars) {
                if (!propertyValue.toString().equals(""))
                    propertyValue.append(";");
                propertyValue.append("(");
                propertyValue.append(importedGrammar);
                propertyValue.append(",");
                propertyValue.append
                           (importedGrammarIdStartOffsets.get(importedGrammar));
                propertyValue.append(")");
            }
            props.setProperty(IMPORTED_GRAMMAR_START_OFFSET,
                              propertyValue.toString()     );
                
            propertyValue = new StringBuilder();
            for (String importedGrammar : importedGrammars) {
                if (!propertyValue.toString().equals(""))
                    propertyValue.append(";");
                propertyValue.append("(");
                propertyValue.append(importedGrammar);
                propertyValue.append(",");
                propertyValue.append
                             (importedGrammarIdEndOffsets.get(importedGrammar));
                propertyValue.append(")");
            }
            props.setProperty(IMPORTED_GRAMMAR_END_OFFSET,
                              propertyValue.toString()   );
                
            propertyValue = new StringBuilder();
            for (String importedTokenFile : importedTokenFiles) {
                if (!propertyValue.toString().equals(""))
                    propertyValue.append(",");
                propertyValue.append(importedTokenFile);
            }
            props.setProperty(IMPORTED_TOKEN_FILE_NAMES,
                              propertyValue.toString() );
                
            propertyValue = new StringBuilder();
            for (String importedTokenFile : importedTokenFiles) {
                if (!propertyValue.toString().equals(""))
                    propertyValue.append(";");
                propertyValue.append("(");
                propertyValue.append(importedTokenFile);
                propertyValue.append(",");
                propertyValue.append(importedTokenFileIdStartOffsets.get(importedTokenFile));
                propertyValue.append(")");
            }
            props.setProperty(IMPORTED_TOKEN_FILE_START_OFFSET,
                              propertyValue.toString()        );
            
            propertyValue = new StringBuilder();
            for (String importedTokenFile : importedTokenFiles) {
                if (!propertyValue.toString().equals(""))
                    propertyValue.append(";");
                propertyValue.append("(");
                propertyValue.append(importedTokenFile);
                propertyValue.append(",");
                propertyValue.append(importedTokenFileIdEndOffsets.get(importedTokenFile));
                propertyValue.append(")");
            }
            props.setProperty(IMPORTED_TOKEN_FILE_END_OFFSET,
                              propertyValue.toString()      );
                
            if (superClass == null)
                props.setProperty(ANALYZER_SUPER_CLASS, "");
            else
                props.setProperty(ANALYZER_SUPER_CLASS, superClass);
                
            if (tokenClass == null)
                props.setProperty(ANALYZER_TOKEN_CLASS, "");
            else
                props.setProperty(ANALYZER_TOKEN_CLASS, tokenClass);
                
            propertyValue = new StringBuilder();
            for (String channel : channels) {
                if (!propertyValue.toString().equals(""))
                    propertyValue.append(",");
                propertyValue.append(channel);
            }
            props.setProperty("channels", propertyValue.toString());
                
         // We save start offset of each channel
            propertyValue = new StringBuilder();
            for (String channelId : channels) {
                Integer offset = channelStartOffsets.get(channelId);
                if (!propertyValue.toString().equals(""))
                    propertyValue.append(";");
                propertyValue.append("(");
                propertyValue.append(channelId);
                propertyValue.append(",");
                propertyValue.append(offset);
                propertyValue.append(")");
            }
            props.setProperty("channels.start.offset", propertyValue.toString());
                
         // We save end offset of each channel
            propertyValue = new StringBuilder();
            for (String channelId : channels) {
                Integer offset = channelEndOffsets.get(channelId);
                if (!propertyValue.toString().equals(""))
                    propertyValue.append(";");
                propertyValue.append("(");
                propertyValue.append(channelId);
                propertyValue.append(",");
                propertyValue.append(offset);
                propertyValue.append(")");
            }
            props.setProperty("channels.end.offset", propertyValue.toString());
                
            propertyValue = new StringBuilder();
            for (String tokenId : tokens) {
                if (!propertyValue.toString().equals(""))
                    propertyValue.append(",");
                propertyValue.append(tokenId);
            }
            props.setProperty(TOKEN_IDS, propertyValue.toString());
            
         // We save offset of each token declaration in tokens statement
            propertyValue = new StringBuilder();
            for (String token : tokens) {
                Integer offset = tokenOffsets.get(token);
                if (!propertyValue.toString().equals(""))
                    propertyValue.append(";");
                propertyValue.append("(");
                propertyValue.append(token);
                propertyValue.append(",");
                propertyValue.append(offset);
                propertyValue.append(")");
            }
            props.setProperty(TOKEN_OFFSETS, propertyValue.toString());
                
            propertyValue = new StringBuilder();
            for (String mode : modes) {
                if (!propertyValue.toString().equals(""))
                    propertyValue.append(",");
                propertyValue.append(mode);
            }
            props.setProperty(MODE_IDS, propertyValue.toString());
                
         // We save start offset of each mode
            propertyValue = new StringBuilder();
            for (String mode : modes) {
                Integer offset = modeStartOffsets.get(mode);
                if (!propertyValue.toString().equals(""))
                    propertyValue.append(";");
                propertyValue.append("(");
                propertyValue.append(mode);
                propertyValue.append(",");
                propertyValue.append(offset);
                propertyValue.append(")");
            }
            props.setProperty(MODE_START_OFFSETS, propertyValue.toString());
                
         // We save end offset of each mode
            propertyValue = new StringBuilder();
            for (String mode : modes) {
                Integer offset = modeEndOffsets.get(mode);
                if (!propertyValue.toString().equals(""))
                    propertyValue.append(";");
                propertyValue.append("(");
                propertyValue.append(mode);
                propertyValue.append(",");
                propertyValue.append(offset);
                propertyValue.append(")");
            }
            props.setProperty(MODE_END_OFFSETS, propertyValue.toString());
                
            propertyValue = new StringBuilder();
            for (String tokenRuleId : tokenRuleIds) {
                if (!propertyValue.toString().equals(""))
                    propertyValue.append(",");
                propertyValue.append(tokenRuleId);
            }
            props.setProperty(TOKEN_RULE_IDS, propertyValue.toString());
                
            propertyValue = new StringBuilder();
//            System.out.println("- token rule ids of mode");
            for (String mode : modes) {
                List<String> tokenRuleIdsOfCurrentMode =
                                                   tokenRuleIdsOfMode.get(mode);
                StringBuilder localValues = new StringBuilder();
                if (tokenRuleIdsOfCurrentMode != null) {
//                    System.out.println("  * mode=" + mode);
                    if (!propertyValue.toString().equals(""))
                        propertyValue.append(";");
                    propertyValue.append("{");
                    propertyValue.append(mode);
                    propertyValue.append("(");
                    for (String tokenRuleId : tokenRuleIdsOfCurrentMode) {
//                        System.out.println("    + token Rule Id=" + tokenRuleId);
                        if (!localValues.toString().equals(""))
                            localValues.append(",");
                        localValues.append(tokenRuleId);
                    }
                    propertyValue.append(localValues);
                    propertyValue.append(")");
                    propertyValue.append("}");
                }
            }
            props.setProperty(TOKEN_RULE_ID_OF_MODES, propertyValue.toString());
                
         // We save start offset of each token rule id
            propertyValue = new StringBuilder();
            for (String token : tokenRuleIds) {
                Integer offset = tokenRuleIdStartOffsets.get(token);
                if (!propertyValue.toString().equals(""))
                    propertyValue.append(";");
                propertyValue.append("(");
                propertyValue.append(token);
                propertyValue.append(",");
                propertyValue.append(offset);
                propertyValue.append(")");
            }
            props.setProperty(TOKEN_RULE_ID_START_OFFSETS,
                              propertyValue.toString()   );
                
         // We save end offset of each token rule id
            propertyValue = new StringBuilder();
            for (String token : tokenRuleIds) {
                Integer offset = tokenRuleIdEndOffsets.get(token);
                if (!propertyValue.toString().equals(""))
                    propertyValue.append(";");
                propertyValue.append("(");
                propertyValue.append(token);
                propertyValue.append(",");
                propertyValue.append(offset);
                propertyValue.append(")");
            }
            props.setProperty(TOKEN_RULE_ID_END_OFFSETS,
                              propertyValue.toString() );
                
            propertyValue = new StringBuilder();
            for (String fragmentRuleId : fragmentRuleIds) {
                if (!propertyValue.toString().equals(""))
                    propertyValue.append(",");
                propertyValue.append(fragmentRuleId);
            }
            props.setProperty(FRAGMENT_RULE_IDS, propertyValue.toString());
                
            propertyValue = new StringBuilder();
//            System.out.println("- fragment rule ids of mode");
            for (String mode : modes) {
                List<String> fragmentRuleIdsOfCurrentMode =
                                                fragmentRuleIdsOfMode.get(mode);
                StringBuilder localValues = new StringBuilder();
                if (fragmentRuleIdsOfCurrentMode != null) {
//                    System.out.println("  * mode=" + mode);
                    if (!propertyValue.toString().equals(""))
                        propertyValue.append(";");
                    propertyValue.append("{");
                    propertyValue.append(mode);
                    propertyValue.append("(");
                    for (String fragmentRuleId : fragmentRuleIdsOfCurrentMode) {
//                        System.out.println("    + fragment Rule Id=" + fragmentRuleId);
                        if (!localValues.toString().equals(""))
                            localValues.append(",");
                        localValues.append(fragmentRuleId);
                    }
                    propertyValue.append(localValues);
                    propertyValue.append(")");
                    propertyValue.append("}");
                }
            }
            props.setProperty("fragments.ofMode", propertyValue.toString());
            
         // We save start offset of each fragment
            propertyValue = new StringBuilder();
            for (String fragmentId : fragmentRuleIds) {
                Integer offset = fragmentRuleIdStartOffsets.get(fragmentId);
                if (!propertyValue.toString().equals(""))
                    propertyValue.append(";");
                propertyValue.append("(");
                propertyValue.append(fragmentId);
                propertyValue.append(",");
                propertyValue.append(offset);
                propertyValue.append(")");
            }
            props.setProperty(FRAGMENT_RULE_ID_START_OFFSETS,
                              propertyValue.toString()      );
            
         // We save end offset of each fragment
            propertyValue = new StringBuilder();
            for (String fragmentId : fragmentRuleIds) {
                Integer offset = fragmentRuleIdEndOffsets.get(fragmentId);
                if (!propertyValue.toString().equals(""))
                    propertyValue.append(";");
                propertyValue.append("(");
                propertyValue.append(fragmentId);
                propertyValue.append(",");
                propertyValue.append(offset);
                propertyValue.append(")");
            }
            props.setProperty(FRAGMENT_RULE_ID_END_OFFSETS,
                              propertyValue.toString()    );
                
            propertyValue = new StringBuilder();
            for (String parserRuleId : parserRuleIds) {
                if (!propertyValue.toString().equals(""))
                    propertyValue.append(",");
                propertyValue.append(parserRuleId);
            }
            props.setProperty(PARSER_RULE_IDS, propertyValue.toString());
                
         // We save start offset of each parser rule id
            propertyValue = new StringBuilder();
            for (String parserRuleId : parserRuleIds) {
                Integer startOffset = parserRuleIdStartOffsets.get(parserRuleId);
                if (!propertyValue.toString().equals(""))
                    propertyValue.append(";");
                propertyValue.append("(");
                propertyValue.append(parserRuleId);
                propertyValue.append(",");
                propertyValue.append(startOffset);
                propertyValue.append(")");
            }
            props.setProperty(PARSER_RULE_ID_START_OFFSETS,
                              propertyValue.toString()    );
            
         // We save end offset of each parser rule id
            propertyValue = new StringBuilder();
            for (String parserRuleId : parserRuleIds) {
                Integer endOffset = parserRuleIdEndOffsets.get(parserRuleId);
                if (!propertyValue.toString().equals(""))
                    propertyValue.append(";");
                propertyValue.append("(");
                propertyValue.append(parserRuleId);
                propertyValue.append(",");
                propertyValue.append(endOffset);
                propertyValue.append(")");
            }
            props.setProperty(PARSER_RULE_ID_END_OFFSETS, propertyValue.toString());
                
            File summaryFile = summaryPath.toFile();
            try (
                OutputStream out = new FileOutputStream(summaryFile);
            ) {
                props.store(out                                         ,
                            "This file contains a content summary of " +
                            grammarFileName                             );
            }
        } catch (IllegalArgumentException ex) {
            System.err.println("invalid file path!");
        } catch (IOException ex) {
            System.err.println("problem during file reading!");
        }
//        System.out.println("GrammarSummary:save() : end");
    }
    
    
    public static GrammarSummary load(Project project, String grammarFile) {
//        System.out.println("GrammarSummary:load(Project, String) -> GrammarSummary : begin");
        assert project != null;
        assert grammarFile != null;
        GrammarSummary summary = null;
        Path grammarFilePath = Paths.get(grammarFile);
        assert Files.exists(grammarFilePath);
        
//        System.out.println("- antlr Src Dir =" + antlrSrcDir);
//        System.out.println("- grammar File  =" + grammarFile);
        Path grammarPath = Paths.get(grammarFile);
        Path summaryDirPath = getSummaryDirPath(grammarPath);
     // We extract the file name from its path
        String grammarFileName = grammarFilePath.getFileName().toString();
        String summaryFileName = grammarFileName + ".properties";
        Path summaryPath = Paths.get(summaryDirPath.toString(),
                                     summaryFileName          );
//        System.out.println("- summary path=" + summaryPath);

        if (Files.exists(summaryPath)       &&
            !Files.isDirectory(summaryPath) &&
            Files.isReadable(summaryPath)     ) {
            Properties props = new Properties();
            try {
                File summaryFile = summaryPath.toFile();
                try (
                    InputStream is = new FileInputStream(summaryFile);
                ) {
                    props.load(is);
                }
                String sourceFileName = props.getProperty("sourceFileName");
                sourceFileName = sourceFileName.trim();
                Path sourceFilePath = Paths.get(sourceFileName);
                
             // ****************
             // * grammar name *
             // ****************
                String grammarName = props.getProperty(GRAMMAR_NAME);
                grammarName = grammarName.trim();
                if (grammarName.equals(""))
                    grammarName = null;
                
             // ****************
             // * grammar type *
             // ****************
                String grammarTypeString = props.getProperty(GRAMMAR_TYPE);
                grammarTypeString = grammarTypeString.trim();
                GrammarType grammarType = GrammarType.toGrammarType
                                                            (grammarTypeString);
                
             // ************************
             // * grammar start offset *
             // ************************
                String grammarStartOffsetString = props.getProperty
                                                         (GRAMMAR_START_OFFSET);
                grammarStartOffsetString = grammarStartOffsetString.trim();
                int grammarIdStartOffset = Integer.parseInt
                                                     (grammarStartOffsetString);
                
             // **********************
             // * grammar end offset *
             // **********************
                String grammarEndOffsetString = props.getProperty
                                                           (GRAMMAR_END_OFFSET);
                grammarEndOffsetString = grammarEndOffsetString.trim();
                int grammarIdEndOffset = Integer.parseInt(grammarEndOffsetString);
                
             // *************************
             // * analyzer Java package *
             // *************************
                String packageName = props.getProperty(ANALYZER_PACKAGE);
                packageName = packageName.trim();
                if (packageName.equals(""))
                    packageName = null;
                
             // *************************
             // * analyzer Java imports *
             // *************************
                String javaImportsString = props.getProperty(ANALYZER_IMPORTS);
                javaImportsString = javaImportsString.trim();
                String[] importationArray;
                if (javaImportsString.equals(""))
                    importationArray = new String[0];
                else
                    importationArray = javaImportsString.split(",");
                List<String> javaImportations =
                         new ArrayList<String>(Arrays.asList(importationArray));
                
             // **************************************
             // * analyzer Java import start offsets *
             // **************************************
                String javaImportIdStartOffsetsString = props.getProperty
                                                (ANALYZER_IMPORT_START_OFFSETS);
                javaImportIdStartOffsetsString =
                                          javaImportIdStartOffsetsString.trim();
//                System.out.println("- Java import id start offsets string=" +
//                                   javaImportIdStartOffsetsString);
                String[] javaImportIdStartOffsetsArray;
                if (javaImportIdStartOffsetsString.equals(""))
                    javaImportIdStartOffsetsArray = new String[0];
                else
                    javaImportIdStartOffsetsArray =
                                      javaImportIdStartOffsetsString.split(";");
                Map<String, Integer> javaImportIdStartOffsets = new HashMap<>();
//                if (importedGrammarOffsetsArray.length != 0)
//                    System.out.println("  start offsets of Java import ids:");
                for (String javaImportIdStartOffsetString : javaImportIdStartOffsetsArray) {
//                    System.out.println("  + imported Grammar start Offset String=" +
//                                       importedGrammarOffsetString);
                    javaImportIdStartOffsetString =
                            javaImportIdStartOffsetString.substring
                                (1, javaImportIdStartOffsetString.length() - 1);
                    String[] javaImportIdStartOffsetArray =
                                       javaImportIdStartOffsetString.split(",");
                    String javaImportId = javaImportIdStartOffsetArray[0];
                    String value        = javaImportIdStartOffsetArray[1];
//                    System.out.println("  * Java import id=" + javaImportId);
//                    System.out.println("    start offset string=" + value);
                    Integer startOffset = Integer.parseInt(value);
                    javaImportIdStartOffsets.put(javaImportId, startOffset);
                }
                
             // ************************************
             // * analyzer Java import end offsets *
             // ************************************
                String javaImportIdEndOffsetsString = props.getProperty
                                                (ANALYZER_IMPORT_END_OFFSETS);
                javaImportIdEndOffsetsString =
                                            javaImportIdEndOffsetsString.trim();
//                System.out.println("- Java import id end offsets string=" +
//                                   javaImportIdEndOffsetsString);
                String[] javaImportIdEndOffsetsArray;
                if (javaImportIdEndOffsetsString.equals(""))
                    javaImportIdEndOffsetsArray = new String[0];
                else
                    javaImportIdEndOffsetsArray =
                                        javaImportIdEndOffsetsString.split(";");
                Map<String, Integer> javaImportIdEndOffsets = new HashMap<>();
//                if (importedGrammarOffsetsArray.length != 0)
//                    System.out.println("  start offsets of Java import ids:");
                for (String javaImportIdEndOffsetString : javaImportIdEndOffsetsArray) {
//                    System.out.println("  + imported Grammar start Offset String=" +
//                                       importedGrammarOffsetString);
                    javaImportIdEndOffsetString =
                            javaImportIdEndOffsetString.substring
                                  (1, javaImportIdEndOffsetString.length() - 1);
                    String[] javaImportIdEndOffsetArray =
                                         javaImportIdEndOffsetString.split(",");
                    String javaImportId = javaImportIdEndOffsetArray[0];
                    String value        = javaImportIdEndOffsetArray[1];
//                    System.out.println("  * Java import id=" + javaImportId);
//                    System.out.println("    end offset string=" + value);
                    Integer endOffset = Integer.parseInt(value);
                    javaImportIdEndOffsets.put(javaImportId, endOffset);
                }
                
             // *********************
             // * imported grammars *
             // *********************
                String importedGrammarsString = 
                                      props.getProperty(IMPORTED_GRAMMAR_NAMES);
                importedGrammarsString = importedGrammarsString.trim();
                String[] importedGrammarsArray;
                if (importedGrammarsString.equals(""))
                    importedGrammarsArray = new String[0];
                else
                    importedGrammarsArray = importedGrammarsString.split(",");
                List<String> importedGrammars =
                    new ArrayList<String>(Arrays.asList(importedGrammarsArray));
                
             // *********************************
             // * imported grammar start offset *
             // *********************************
                String importedGrammarOffsetsString = props.getProperty
                                                (IMPORTED_GRAMMAR_START_OFFSET);
                importedGrammarOffsetsString = importedGrammarOffsetsString.trim();
//                System.out.println("- imported grammar start offsets string=" +
//                                   importedGrammarOffsetsString);
                String[] importedGrammarOffsetsArray;
                if (importedGrammarOffsetsString.equals(""))
                    importedGrammarOffsetsArray = new String[0];
                else
                    importedGrammarOffsetsArray =
                                        importedGrammarOffsetsString.split(";");
                Map<String, Integer> importedGrammarStartOffsets =
                                                                new HashMap<>();
//                if (importedGrammarOffsetsArray.length != 0)
//                    System.out.println("  start offsets of imported grammars:");
                for (String importedGrammarOffsetString : importedGrammarOffsetsArray) {
//                    System.out.println("  + imported Grammar start Offset String=" +
//                                       importedGrammarOffsetString);
                    importedGrammarOffsetString =
                              importedGrammarOffsetString.substring
                                  (1, importedGrammarOffsetString.length() - 1);
                    String[] importedGrammarOffsetArray =
                                         importedGrammarOffsetString.split(",");
                    String importedGrammarId = importedGrammarOffsetArray[0];
                    String value             = importedGrammarOffsetArray[1];
//                    System.out.println("  * imported grammar id=" +
//                                       importedGrammarId           );
//                    System.out.println("    start offset string=" + value);
                    Integer offset = Integer.parseInt(value);
                    importedGrammarStartOffsets.put(importedGrammarId, offset);
                }
                
             // *******************************
             // * imported grammar end offset *
             // *******************************
                importedGrammarOffsetsString = props.getProperty
                                                  (IMPORTED_GRAMMAR_END_OFFSET);
                importedGrammarOffsetsString = importedGrammarOffsetsString.trim();
//                System.out.println("- imported grammar end offsets String=" +
//                                   importedGrammarOffsetsString);
                if (importedGrammarOffsetsString.equals(""))
                    importedGrammarOffsetsArray = new String[0];
                else {
                    importedGrammarOffsetsArray =
                                        importedGrammarOffsetsString.split(";");
                }
                Map<String, Integer> importedGrammarEndOffsets = new HashMap<>();
//                if (importedGrammarOffsetsArray.length != 0)
//                    System.out.println("  end offsets of imported grammars:");
                for (String importedGrammarOffsetString : importedGrammarOffsetsArray) {
//                    System.out.println("  + imported grammar end offset String=" +
//                                       importedGrammarOffsetString);
                    importedGrammarOffsetString =
                              importedGrammarOffsetString.substring
                                  (1, importedGrammarOffsetString.length() - 1);
                    String[] importedGrammarOffsetArray =
                                         importedGrammarOffsetString.split(",");
                    String importedGrammarId = importedGrammarOffsetArray[0];
                    String value             = importedGrammarOffsetArray[1];
                    Integer offset = Integer.parseInt(value);
                    importedGrammarEndOffsets.put(importedGrammarId, offset);
                }
                
             // *****************************
             // * imported token file names *
             // *****************************
                String importedTokenFilesString =
                                   props.getProperty(IMPORTED_TOKEN_FILE_NAMES);
                importedTokenFilesString = importedTokenFilesString.trim();
                String[] importedTokenFilesArray;
                if (importedTokenFilesString.equals(""))
                    importedTokenFilesArray = new String[0];
                else
                    importedTokenFilesArray =
                                            importedTokenFilesString.split(",");
                List<String> importedTokenFiles =
                  new ArrayList<String>(Arrays.asList(importedTokenFilesArray));
                
             // *************************************
             // * imported token file start offsets *
             // *************************************
                String importedTokenFileOffsetsString = props.getProperty
                                             (IMPORTED_TOKEN_FILE_START_OFFSET);
                importedTokenFileOffsetsString = importedTokenFileOffsetsString.trim();
//                System.out.println("- imported token File start offsets string=" +
//                                   importedTokenFileOffsetsString);
                String[] importedTokenFileOffsetsArray;
                if (importedTokenFileOffsetsString.equals(""))
                    importedTokenFileOffsetsArray = new String[0];
                else 
                    importedTokenFileOffsetsArray =
                                      importedTokenFileOffsetsString.split(";");
                Map<String, Integer> importedTokenFileStartOffsets =
                                                                new HashMap<>();
//                if (importedTokenFileOffsetsArray.length != 0)
//                    System.out.println("  start offsets of imported tokens files:");
                for (String importedTokenFileOffsetString : importedTokenFileOffsetsArray) {
//                    System.out.println("  + imported token file start offset string=" +
//                                       importedTokenFileOffsetString);
                    importedTokenFileOffsetString =
                            importedTokenFileOffsetString.substring
                                (1, importedTokenFileOffsetString.length() - 1);
                    String[] importedTokenFileOffsetArray =
                                       importedTokenFileOffsetString.split(",");
                    String importedTokenFileId 
                                              = importedTokenFileOffsetArray[0];
                    String value              = importedTokenFileOffsetArray[1];
//                    System.out.println("  + imported token file id=" +
//                                       importedTokenFileId             );
//                    System.out.println("  + start offset=" + value);
                    Integer offset = Integer.parseInt(value);
                    importedTokenFileStartOffsets.put(importedTokenFileId, offset);
                }
                
             // ***********************************
             // * imported token file end offsets *
             // ***********************************
                importedTokenFileOffsetsString = props.getProperty
                                               (IMPORTED_TOKEN_FILE_END_OFFSET);
                importedTokenFileOffsetsString = importedTokenFileOffsetsString.trim();
//                System.out.println("- imported token file end offsets String=" + importedTokenFileOffsetsString);
                if (importedTokenFileOffsetsString.equals(""))
                    importedTokenFileOffsetsArray = new String[0];
                else 
                    importedTokenFileOffsetsArray =
                                      importedTokenFileOffsetsString.split(";");
                Map<String, Integer> importedTokenFileEndOffsets =
                                                                new HashMap<>();
//                if (importedTokenFileOffsetsArray.length != 0)
//                    System.out.println("  end offsets of imported tokens files:");
                for (String importedTokenFileOffsetString : importedTokenFileOffsetsArray) {
//                    System.out.println("  + imported token file end offset string="
//                                       + importedTokenFileOffsetString);
                    importedTokenFileOffsetString =
                            importedTokenFileOffsetString.substring
                                (1, importedTokenFileOffsetString.length() - 1);
                    String[] importedTokenFileOffsetArray =
                                       importedTokenFileOffsetString.split(",");
                    String importedTokenFileId = importedTokenFileOffsetArray[0];
                    String value               = importedTokenFileOffsetArray[1];
                    Integer offset = Integer.parseInt(value);
//                    System.out.println("  + imported token file id=" +
//                                       importedTokenFileId             );
//                    System.out.println("  + end offset string=" + value);
                    importedTokenFileEndOffsets.put(importedTokenFileId, offset);
                }
                
             // ************************
             // * analyzer super class *
             // ************************
                String superClass = props.getProperty(ANALYZER_SUPER_CLASS);
                superClass = superClass.trim();
                if (superClass.equals(""))
                    superClass = null;
                
             // ************************
             // * analyzer token class *
             // ************************
                String tokenClass = props.getProperty(ANALYZER_TOKEN_CLASS);
                tokenClass = tokenClass.trim();
                if (tokenClass.equals(""))
                    tokenClass = null;
                
             // ***************
             // * channel ids *
             // ***************
                String channelsString = props.getProperty("channels");
                channelsString = channelsString.trim();
                String[] channelsArray;
                if (channelsString.equals(""))
                    channelsArray = new String[0];
                else
                    channelsArray = channelsString.split(",");
                List<String> channels =
                            new ArrayList<String>(Arrays.asList(channelsArray));
                
             // ****************************
             // * channel id start offsets *
             // ****************************
                String channelOffsetsString =
                                     props.getProperty("channels.start.offset");
                channelOffsetsString = channelOffsetsString.trim();
//                System.out.println("- channel id offsets string=" + channelOffsetsString);
                String[] channelOffsetsArray;
                if (channelOffsetsString.equals(""))
                    channelOffsetsArray = new String[0];
                else
                    channelOffsetsArray = channelOffsetsString.split(";");
                Map<String, Integer> channelStartOffsets = new HashMap<>();
//                if (channelOffsetsArray.length != 0)
//                    System.out.println("- start offsets of channel ids:");
                for (String channelOffsetString : channelOffsetsArray) {
//                    System.out.println("  + chennel id start offset string=" +
//                                       channelOffsetString);
                    channelOffsetString = channelOffsetString.substring
                                          (1, channelOffsetString.length() - 1);
                    String[] channelOffsetArray = channelOffsetString.split(",");
                    String channelId = channelOffsetArray[0];
                    String value     = channelOffsetArray[1];
                    Integer startOffset = Integer.parseInt(value);
//                    System.out.println("  + imported token file id=" +
//                                       channelId                    );
//                    System.out.println("  + start offset string=" + value);
                    channelStartOffsets.put(channelId, startOffset);
                }
                
             // **************************
             // * channel id end offsets *
             // **************************
                channelOffsetsString = props.getProperty("channels.end.offset");
                channelOffsetsString = channelOffsetsString.trim();
//                System.out.println("- channel id offsets string=" + channelOffsetsString);
                if (channelOffsetsString.equals(""))
                    channelOffsetsArray = new String[0];
                else
                    channelOffsetsArray = channelOffsetsString.split(";");
                Map<String, Integer> channelEndOffsets = new HashMap<>();
//                if (channelOffsetsArray.length != 0)
//                    System.out.println("- start offsets of channel ids:");
                for (String channelOffsetString : channelOffsetsArray) {
//                    System.out.println("  + chennel id start offset string=" +
//                                       channelOffsetString);
                    channelOffsetString = channelOffsetString.substring
                                          (1, channelOffsetString.length() - 1);
                    String[] channelOffsetArray = channelOffsetString.split(",");
                    String channelId = channelOffsetArray[0];
                    String value     = channelOffsetArray[1];
                    Integer endOffset = Integer.parseInt(value);
//                    System.out.println("  + imported token file id=" +
//                                       channelId                    );
//                    System.out.println("  + start offset string=" + value);
                    channelEndOffsets.put(channelId, endOffset);
                }
                
             // *********************************
             // * token ids of tokens statement *
             // *********************************
                String tokensString = props.getProperty(TOKEN_IDS);
                tokensString = tokensString.trim();
                String[] tokensArray;
                if (tokensString.equals(""))
                    tokensArray = new String[0];
                else
                    tokensArray = tokensString.split(",");
                List<String> tokens =
                              new ArrayList<String>(Arrays.asList(tokensArray));
                
             // ****************************************
             // * token id offsets of tokens statement *
             // ****************************************
                String tokenOffsetsString = props.getProperty(TOKEN_OFFSETS);
                tokenOffsetsString = tokenOffsetsString.trim();
                String[] tokenOffsetsArray;
                if (tokenOffsetsString.equals(""))
                    tokenOffsetsArray = new String[0];
                else
                    tokenOffsetsArray = tokenOffsetsString.split(";");
                Map<String, Integer> tokenOffsets = new HashMap<>();
                for (String tokenOffsetString : tokenOffsetsArray) {
                    tokenOffsetString = tokenOffsetString.substring
                                            (1, tokenOffsetString.length() - 1);
                    String[] tokenOffsetArray = tokenOffsetString.split(",");
                    String tokenId = tokenOffsetArray[0];
                    String value   = tokenOffsetArray[1];
                    Integer offset = Integer.parseInt(value);
                    tokenOffsets.put(tokenId, offset);
                }
                
             // ************
             // * mode ids *
             // ************
                String modesString = props.getProperty(MODE_IDS);
                modesString = modesString.trim();
                String[] modesArray;
                if (modesString.equals(""))
                    modesArray = new String[0];
                else
                    modesArray = modesString.split(",");
                List<String> modes =
                               new ArrayList<String>(Arrays.asList(modesArray));
                
             // *************************
             // * mode id start offsets *
             // *************************
                String modeOffsetsString = props.getProperty(MODE_START_OFFSETS);
                modeOffsetsString = modeOffsetsString.trim();
                String[] modeOffsetsArray;
                if (modeOffsetsString.equals(""))
                    modeOffsetsArray = new String[0];
                else
                    modeOffsetsArray = modeOffsetsString.split(";");
                Map<String, Integer> modeStartOffsets = new HashMap<>();
                for (String modeOffsetString : modeOffsetsArray) {
                    modeOffsetString = modeOffsetString.substring
                                             (1, modeOffsetString.length() - 1);
                    String[] modeOffsetArray = modeOffsetString.split(",");
                    String modeId = modeOffsetArray[0];
                    String value  = modeOffsetArray[1];
                    Integer startOffset = Integer.parseInt(value);
                    modeStartOffsets.put(modeId, startOffset);
                }
                
             // ***********************
             // * mode id end offsets *
             // ***********************
                modeOffsetsString = props.getProperty(MODE_END_OFFSETS);
                modeOffsetsString = modeOffsetsString.trim();
                if (modeOffsetsString.equals(""))
                    modeOffsetsArray = new String[0];
                else
                    modeOffsetsArray = modeOffsetsString.split(";");
                Map<String, Integer> modeEndOffsets = new HashMap<>();
                for (String modeOffsetString : modeOffsetsArray) {
                    modeOffsetString = modeOffsetString.substring
                                             (1, modeOffsetString.length() - 1);
                    String[] modeOffsetArray = modeOffsetString.split(",");
                    String modeId = modeOffsetArray[0];
                    String value  = modeOffsetArray[1];
                    Integer endOffset = Integer.parseInt(value);
                    modeEndOffsets.put(modeId, endOffset);
                }
                
             // ******************
             // * token rule ids *
             // ******************
                String tokenRuleIdsString = props.getProperty(TOKEN_RULE_IDS);
                tokenRuleIdsString = tokenRuleIdsString.trim();
                String[] tokenRuleIdsArray;
                if (tokenRuleIdsString.equals(""))
                    tokenRuleIdsArray = new String[0];
                else
                    tokenRuleIdsArray = tokenRuleIdsString.split(",");
                List<String> tokenRuleIds = new ArrayList<String>
                                             (Arrays.asList(tokenRuleIdsArray));
        
             // **************************
             // * token rule id of modes *
             // **************************
                String tokenRuleIdsOfModesString = props.getProperty
                                                       (TOKEN_RULE_ID_OF_MODES);
                tokenRuleIdsOfModesString = tokenRuleIdsOfModesString.trim();
//                System.out.println("- token rule ids of mode string=" +
//                                   tokenRuleIdsOfModesString           );
                String[] tokenRuleIdsOfModesArray;
                if (tokenRuleIdsOfModesString.equals(""))
                    tokenRuleIdsOfModesArray = new String[0];
                else {
                 // We supresse '{' and '}' characters
                    tokenRuleIdsOfModesString =
                        tokenRuleIdsOfModesString.substring
                                    (1, tokenRuleIdsOfModesString.length() - 1);
                    tokenRuleIdsOfModesArray = tokenRuleIdsOfModesString.split
                                                                          (";");
                }
                List<String> tokenRuleIdsOfModesString2 = new ArrayList<String>
                                      (Arrays.asList(tokenRuleIdsOfModesArray));
                Map<String, List<String>> tokenIdsOfMode = new HashMap<>();
                for (String tokenIdsOfModeString : tokenRuleIdsOfModesString2) {
//                    System.out.println("  + token ids of mode string=" +
//                                       tokenIdsOfModeString);
                    String[] parts = tokenIdsOfModeString.split("\\(");
                    String mode           = parts[0];
                    String tokenIdsString = parts[1];
                    tokenIdsString = tokenIdsString.substring
                                                (0,tokenIdsString.length() - 1);
//                    System.out.println("    mode=" + mode);
//                    System.out.println("    token ids string=" + tokenIdsString);
                    String[] tokenIdsOfCurrentModeArray = tokenIdsString.split(",");
                    if (tokenIdsOfCurrentModeArray.length != 0) {
                        List<String> tokenIdsOfCurrentMode = 
                                new ArrayList<String>
                                    (Arrays.asList(tokenIdsOfCurrentModeArray));
                        tokenIdsOfMode.put(mode, tokenIdsOfCurrentMode);
                    }
                }
                
             // *******************************
             // * token rule id start offsets *
             // *******************************
                String tokenRuleIdStartOffsetsString = props.getProperty
                                                  (TOKEN_RULE_ID_START_OFFSETS);
                tokenRuleIdStartOffsetsString = tokenRuleIdStartOffsetsString.trim();
                String[] tokenRuleIdStartOffsetsArray;
                if (tokenRuleIdStartOffsetsString.equals(""))
                    tokenRuleIdStartOffsetsArray = new String[0];
                else
                    tokenRuleIdStartOffsetsArray =
                                       tokenRuleIdStartOffsetsString.split(";");
                Map<String, Integer> tokenRuleIdStartOffsets = new HashMap<>();
                for (String tokenRuleIdStartOffsetString : tokenRuleIdStartOffsetsArray) {
                    tokenRuleIdStartOffsetString =
                             tokenRuleIdStartOffsetString.substring
                                 (1, tokenRuleIdStartOffsetString.length() - 1);
                    String[] tokenRuleIdStartOffsetArray =
                                        tokenRuleIdStartOffsetString.split(",");
                    String tokenId = tokenRuleIdStartOffsetArray[0];
                    String value   = tokenRuleIdStartOffsetArray[1];
                    Integer startOffset = Integer.parseInt(value);
                    tokenRuleIdStartOffsets.put(tokenId, startOffset);
                }
                
             // *****************************
             // * token rule id end offsets *
             // *****************************
                String tokenRuleEndOffsetsString = props.getProperty
                                                    (TOKEN_RULE_ID_END_OFFSETS);
                tokenRuleEndOffsetsString = tokenRuleEndOffsetsString.trim();
                String[] tokenRuleIdEndOffsetsArray;
                if (tokenRuleEndOffsetsString.equals(""))
                    tokenRuleIdEndOffsetsArray = new String[0];
                else
                    tokenRuleIdEndOffsetsArray = tokenRuleEndOffsetsString.split(";");
                Map<String, Integer> tokenRuleIdEndOffsets = new HashMap<>();
                for (String tokenRuleIdEndOffsetString : tokenRuleIdEndOffsetsArray) {
                    tokenRuleIdEndOffsetString =
                               tokenRuleIdEndOffsetString.substring
                                   (1, tokenRuleIdEndOffsetString.length() - 1);
                    String[] tokenRuleIdEndOffsetArray =
                                          tokenRuleIdEndOffsetString.split(",");
                    String tokenId = tokenRuleIdEndOffsetArray[0];
                    String value   = tokenRuleIdEndOffsetArray[1];
                    Integer endOffset = Integer.parseInt(value);
                    tokenRuleIdEndOffsets.put(tokenId, endOffset);
                }
                
             // *********************
             // * fragment rule ids *
             // *********************
                String fragmentIdsString = props.getProperty(FRAGMENT_RULE_IDS);
                fragmentIdsString = fragmentIdsString.trim();
                String[] fragmentIdsArray;
                if (fragmentIdsString.equals(""))
                    fragmentIdsArray = new String[0];
                else
                    fragmentIdsArray = fragmentIdsString.split(",");
                List<String> fragmentRuleIds = new ArrayList<String>
                                              (Arrays.asList(fragmentIdsArray));
                
             // *****************************
             // * fragment rule id of modes *
             // *****************************
                String fragmentRuleIdsOfModesString = props.getProperty
                                                           ("fragments.ofMode");
                fragmentRuleIdsOfModesString = fragmentRuleIdsOfModesString.trim();
//                System.out.println("- fragment rule ids of mode string=" +
//                                   tokenRuleIdsOfModesString           );
                String[] fragmentRuleIdsOfModesArray;
                if (fragmentRuleIdsOfModesString.equals(""))
                    fragmentRuleIdsOfModesArray = new String[0];
                else
                    fragmentRuleIdsOfModesArray =
                                        fragmentRuleIdsOfModesString.split(";");
                List<String> fragmentRuleIdsOfModesString2 =
                            new ArrayList<String>
                                   (Arrays.asList(fragmentRuleIdsOfModesArray));
                Map<String, List<String>> fragmentIdsOfMode = new HashMap<>();
                for (String fragmentIdsOfModeString : fragmentRuleIdsOfModesString2) {
//                    System.out.println("- fragment ids of mode string=" +
//                                       fragmentIdsOfModeString);
                    fragmentIdsOfModeString = fragmentIdsOfModeString.substring(1, fragmentIdsOfModeString.length()-1);
//                    System.out.println("  fragment ids of mode string 2=" + fragmentIdsOfModeString);
                    String[] parts = fragmentIdsOfModeString.split("\\(");
                    String mode = parts[0];
//                    System.out.println("  mode=" + mode);
                    fragmentIdsString = parts[1];
                    fragmentIdsString = fragmentIdsString.substring(0,fragmentIdsString.length() - 1);
//                    System.out.println("  fragment Ids string=" + fragmentIdsString);
                    String[] fragmentIdsOfCurrentModeArray = fragmentIdsString.split(",");
                    if (fragmentIdsOfCurrentModeArray.length != 0) {
                        List<String> fragmentIdsOfCurrentMode =
                             new ArrayList<String>
                                 (Arrays.asList(fragmentIdsOfCurrentModeArray));
                        fragmentIdsOfMode.put(mode, fragmentIdsOfCurrentMode);
                    }
                }
                
             // **********************************
             // * fragment rule id start offsets *
             // **********************************
                String fragmentRuleIdStartOffsetsString = props.getProperty
                                               (FRAGMENT_RULE_ID_START_OFFSETS);
                fragmentRuleIdStartOffsetsString =
                                        fragmentRuleIdStartOffsetsString.trim();
                String[] fragmentRuleIdStartOffsetsArray;
                if (fragmentRuleIdStartOffsetsString.equals(""))
                    fragmentRuleIdStartOffsetsArray = new String[0];
                else
                    fragmentRuleIdStartOffsetsArray =
                                    fragmentRuleIdStartOffsetsString.split(";");
                Map<String, Integer> fragmentRuleIdStartOffsets = new HashMap<>();
                for (String fragmentRuleIdStartOffsetString : fragmentRuleIdStartOffsetsArray) {
                    fragmentRuleIdStartOffsetString =
                          fragmentRuleIdStartOffsetString.substring
                              (1, fragmentRuleIdStartOffsetString.length() - 1);
                    String[] fragmentRuleIdStartOffsetArray =
                                     fragmentRuleIdStartOffsetString.split(",");
                    String fragmentId = fragmentRuleIdStartOffsetArray[0];
                    String value      = fragmentRuleIdStartOffsetArray[1];
                    Integer offset = Integer.parseInt(value);
                    fragmentRuleIdStartOffsets.put(fragmentId, offset);
                }
                
             // ********************************
             // * fragment rule id end offsets *
             // ********************************
                String fragmentRuleIdEndOffsetsString = props.getProperty
                                                 (FRAGMENT_RULE_ID_END_OFFSETS);
                fragmentRuleIdEndOffsetsString =
                                          fragmentRuleIdEndOffsetsString.trim();
                String[] fragmentRuleIdEndOffsetsArray;
                if (fragmentRuleIdEndOffsetsString.equals(""))
                    fragmentRuleIdEndOffsetsArray = new String[0];
                else
                    fragmentRuleIdEndOffsetsArray =
                                    fragmentRuleIdEndOffsetsString.split(";");
                Map<String, Integer> fragmentRuleIdEndOffsets = new HashMap<>();
                for (String fragmentRuleIdEndOffsetString : fragmentRuleIdEndOffsetsArray) {
                    fragmentRuleIdEndOffsetString =
                          fragmentRuleIdEndOffsetString.substring
                                (1, fragmentRuleIdEndOffsetString.length() - 1);
                    String[] fragmentRuleIdEndOffsetArray =
                                       fragmentRuleIdEndOffsetString.split(",");
                    String fragmentId = fragmentRuleIdEndOffsetArray[0];
                    String value      = fragmentRuleIdEndOffsetArray[1];
                    Integer offset = Integer.parseInt(value);
                    fragmentRuleIdEndOffsets.put(fragmentId, offset);
                }
                
             // *******************
             // * parser rule ids *
             // *******************
                String parserRuleIdsString = props.getProperty(PARSER_RULE_IDS);
                parserRuleIdsString = parserRuleIdsString.trim();
                String[] parserRuleIdsArray;
                if (parserRuleIdsString.equals(""))
                    parserRuleIdsArray = new String[0];
                else
                    parserRuleIdsArray = parserRuleIdsString.split(",");
                List<String> parserRuleIds = new ArrayList<String>
                                            (Arrays.asList(parserRuleIdsArray));
                
             // ********************************
             // * parser rule id start offsets *
             // ********************************
                String parserRuleIdStartOffsetsString = props.getProperty
                                                 (PARSER_RULE_ID_START_OFFSETS);
                parserRuleIdStartOffsetsString =
                                          parserRuleIdStartOffsetsString.trim();
                String[] parserRuleIdStartOffsetsArray;
                if (parserRuleIdStartOffsetsString.equals(""))
                    parserRuleIdStartOffsetsArray = new String[0];
                else
                    parserRuleIdStartOffsetsArray =
                                      parserRuleIdStartOffsetsString.split(";");
                Map<String, Integer> parserRuleIdStartOffsets = new HashMap<>();
                for (String parserRuleIdStartOffsetString : parserRuleIdStartOffsetsArray) {
                    parserRuleIdStartOffsetString =
                            parserRuleIdStartOffsetString.substring
                                (1, parserRuleIdStartOffsetString.length() - 1);
                    String[] parserRuleIdStartOffsetArray =
                                       parserRuleIdStartOffsetString.split(",");
                    String parserRuleId = parserRuleIdStartOffsetArray[0];
                    String value        = parserRuleIdStartOffsetArray[1];
                    Integer startOffset = Integer.parseInt(value);
                    parserRuleIdStartOffsets.put(parserRuleId, startOffset);
                }
                
             // ********************************
             // * parser rule id start offsets *
             // ********************************
                String parserRuleIdEndOffsetsString = props.getProperty
                                                 (PARSER_RULE_ID_START_OFFSETS);
                parserRuleIdEndOffsetsString =
                                          parserRuleIdEndOffsetsString.trim();
                String[] parserRuleIdEndOffsetsArray;
                if (parserRuleIdEndOffsetsString.equals(""))
                    parserRuleIdEndOffsetsArray = new String[0];
                else
                    parserRuleIdEndOffsetsArray =
                                        parserRuleIdEndOffsetsString.split(";");
                Map<String, Integer> parserRuleIdEndOffsets = new HashMap<>();
                for (String parserRuleIdEndOffsetString : parserRuleIdEndOffsetsArray) {
                    parserRuleIdEndOffsetString =
                            parserRuleIdEndOffsetString.substring
                                (1, parserRuleIdEndOffsetString.length() - 1);
                    String[] parserRuleIdEndOffsetArray =
                                         parserRuleIdEndOffsetString.split(",");
                    String parserRuleId = parserRuleIdEndOffsetArray[0];
                    String value        = parserRuleIdEndOffsetArray[1];
                    Integer endOffset = Integer.parseInt(value);
                    parserRuleIdEndOffsets.put(parserRuleId, endOffset);
                }
                
                summary = new GrammarSummary(sourceFilePath);

                summary.grammarType = grammarType;
                summary.grammarName = grammarName;
                summary.grammarIdStartOffset = grammarIdStartOffset;
                summary.grammarIdEndOffset   = grammarIdEndOffset;
                
                summary.packageName = packageName;
                summary.javaImports.addAll(javaImportations);
                summary.putAllJavaImportIdStartOffsets(javaImportIdStartOffsets);
                summary.putAllJavaImportIdEndOffsets(javaImportIdEndOffsets);
                
                summary.addAllImportedGrammars(importedGrammars);
                summary.putAllImportedGrammarIdStartOffsets(importedGrammarStartOffsets);
                summary.putAllImportedGrammarIdEndOffsets(importedGrammarEndOffsets);
                
                summary.addAllImportedTokenFiles(importedTokenFiles);
                summary.putAllImportedTokenFileIdStartOffsets(importedTokenFileStartOffsets);
                summary.putAllImportedTokenFileIdEndOffsets(importedTokenFileEndOffsets);
                
                summary.superClass = superClass;

                summary.tokenClass = tokenClass;
                
                summary.addAllChannels(channels);
                summary.putAllChannelStartOffsets(channelStartOffsets);
                summary.putAllChannelEndOffsets(channelEndOffsets);
                
                summary.addAllTokens(tokens);
                summary.putAllTokenOffsets(tokenOffsets);
                
                summary.addAllModes(modes);
                summary.putAllModeStartOffsets(modeStartOffsets);
                summary.putAllModeEndOffsets(modeEndOffsets);
                
                summary.addAllTokenRuleIds(tokenRuleIds);
                summary.putAllTokenRuleIdStartOffsets(tokenRuleIdStartOffsets);
                summary.putAllTokenRuleIdEndOffsets(tokenRuleIdEndOffsets);
                summary.putAllTokenRuleIdsOfMode(tokenIdsOfMode);
                
                summary.addAllFragmentRuleIds(fragmentRuleIds);
                summary.putAllFragmentRuleIdStartOffsets(fragmentRuleIdStartOffsets);
                summary.putAllFragmentRuleIdEndOffsets(fragmentRuleIdEndOffsets);
                summary.putAllFragmentRuleIdsOfMode(fragmentIdsOfMode);
                
                summary.addAllParserRuleIds(parserRuleIds);
                summary.putAllParserRuleIdStartOffsets(parserRuleIdStartOffsets);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
//        System.out.println("GrammarSummary:load(Project, String) -> GrammarSummary : end");
        return summary;
    }
    
    
    protected static Path getSummaryDirPath(Path sourceFilePath) {
//        System.out.println("GrammarSummary:getSummaryDirPath(Path) -> Path : begin");
     // We determine the project associated to our source path ...
        Project project = ProjectHelper.getProject(sourceFilePath);
        String projectDir = project.getProjectDirectory().getPath();
     // ... that enables us to determine the ANTLR source directory...
        File antlrSrcDir = ProjectHelper.getANTLRSourceDir(project);
     // ... that enables us to determine our grammar relative directory path
     // (relatively to ANTLR source directory)
        Path grammarDirPath = sourceFilePath.getParent();
        Path grammarDirRelativePath =
                                antlrSrcDir.toPath().relativize(grammarDirPath);
//        System.out.println("- grammar dir relative path=" + grammarDirRelativePath);
        
        String nbCacheDirectory =
                            System.getProperty("netbeans.default_userdir_root");
        String nbProductVersion = System.getProperty("netbeans.productversion");
//        System.out.println("- NetBeans user cache directory=" + nbCacheDirectory);
//        System.out.println("- NetNeans product version=" + nbProductVersion);
        Pattern versionPattern = Pattern.compile("(\\d(\\.\\d)*)");
        Matcher matcher = versionPattern.matcher(nbProductVersion);
        String nbVersion;
        if (matcher.find()) {
            nbVersion = matcher.group(1);
//            System.out.println("- NetBeans version=" + nbVersion);
        } else
            nbVersion = "unknown_version";

        Path summaryDirPath;
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

            summaryDirPath = Paths.get(nbCacheDirectory                 ,
                                       nbVersion                        ,
                                       "summaries"                      ,
                                       hashedProjectDir.toString()      ,
                                       grammarDirRelativePath.toString());
        } catch (NoSuchAlgorithmException |
                 UnsupportedEncodingException ex) {
         // SHA-1 cannot be unsupported
         // UTF-8 cannot be unsupported
            summaryDirPath = null;
        }
//        System.out.println("GrammarSummary:getSummaryDirPath(Path) -> Path : end");
        return summaryDirPath;
    }
}