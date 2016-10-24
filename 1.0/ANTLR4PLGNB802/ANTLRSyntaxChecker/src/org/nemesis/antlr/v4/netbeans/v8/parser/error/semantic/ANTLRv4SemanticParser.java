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
package org.nemesis.antlr.v4.netbeans.v8.parser.error.semantic;

import org.nemesis.antlr.v4.netbeans.v8.parser.ANTLRv4GrammarChecker;
import org.nemesis.antlr.v4.netbeans.v8.parser.NBANTLRv4ParsingError;
import org.nemesis.antlr.v4.netbeans.v8.parser.impl.ANTLRv4BaseListener;
import org.nemesis.antlr.v4.netbeans.v8.parser.impl.ANTLRv4Parser;
import org.nemesis.antlr.v4.netbeans.v8.parser.impl.ANTLRv4Parser.TokenIdentifierContext;

import org.antlr.v4.runtime.RecognitionException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import java.util.logging.Logger;

import org.netbeans.api.project.ProjectManager;

import org.netbeans.modules.csl.api.Severity;

import org.netbeans.spi.project.support.ant.PropertyEvaluator;
import org.netbeans.spi.project.support.ant.PropertyProvider;
import org.netbeans.spi.project.support.ant.PropertyUtils;

import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;


/**
 *
 * @author Frédéric Yvon Vinet
 */
public class ANTLRv4SemanticParser extends ANTLRv4BaseListener {
    private static final Logger LOG = Logger.getLogger("ANTLR semantic parser");
    
    private final String                       parsedFileName;
    private       GrammarDeclaration           grammarDeclaration;
    private final String                       grammarName;
    private final String                       grammarDirectory;
    private       GrammarType                  grammarType;
    
    private final Set<String>                  ruleDeclarations;
    private final Map<String, RuleDeclaration> parserRuleDeclarations;
    private       String                       firstParserRuleDeclaration;
    private       String                       firstImportedParserRule;
    private final Map<String, RuleReference>   ruleReferences;
    private final List<NBANTLRv4ParsingError>  semanticErrors;
    
    public boolean encounteredError() {
        return getErrorNumber() != 0;
    }
    public int getErrorNumber() {
        return semanticErrors.size();
    }
    public List<NBANTLRv4ParsingError> getSemanticError() {
        return semanticErrors;
    }

    
    public GrammarType getGrammarType() {
        return grammarType;
    }
    
    public Set<String> getRuleDeclarations() {
        return ruleDeclarations;
    }
    
    public Map<String, RuleDeclaration> getParserRuleDeclarations() {
        return parserRuleDeclarations;
    }

    public Map<String, RuleReference> getRuleReferences() {
        return ruleReferences;
    }
    
    
    public String getFirstParserRule() {
        return (this.firstParserRuleDeclaration != null) ?
                   this.firstParserRuleDeclaration
                :
                   this.firstImportedParserRule;
    }
    
    public ANTLRv4SemanticParser(String parsedFileName) {
        this.parsedFileName = parsedFileName;
        Path path = Paths.get(parsedFileName);
        String grammarFileName = path.toFile().getName();
        int index = grammarFileName.indexOf(".");
        this.grammarName = grammarFileName.substring(0, index);
        index = parsedFileName.indexOf(grammarName);
        this.grammarDirectory = parsedFileName.substring(0, index);
        
//        System.out.println("grammarName=" + grammarName);
//        System.out.println("grammarDirectory=" + grammarDirectory);
        
        this.grammarType = GrammarType.UNDEFINED;
        this.grammarDeclaration = null;
        
        this.ruleDeclarations = new HashSet<>();
     // Some tokens are predefined and common to all lexers
        ruleDeclarations.add("EOF");
        this.parserRuleDeclarations = new HashMap<>();
        this.firstParserRuleDeclaration = null;
        this.ruleReferences = new HashMap<>();
        this.semanticErrors = new ArrayList<>();
    }
    
    
    @Override
    public void exitGrammarSpec(ANTLRv4Parser.GrammarSpecContext ctx) {
        ANTLRv4Parser.IdentifierContext ic = ctx.identifier();
        String recoveredGrammarName = ic.getText();
        int index = ic.ID().getSymbol().getStartIndex();
        if (!recoveredGrammarName.equals(grammarName)) {
            String key = "antlr.error.grammar.must.be.equal.to.the.grammar.file.name";

            String displayName = "The grammar name must be equal to the " +
                    "grammar file name (without extension)";
            String description = displayName;
            NBANTLRv4ParsingError semanticError = new NBANTLRv4ParsingError
                                (parsedFileName,
                                 Severity.ERROR,
                                 key           ,
                                 index         ,
                                 displayName   ,
                                 description   );
            semanticErrors.add(semanticError);
        }
        
        ANTLRv4Parser.GrammarTypeContext gtc = ctx.grammarType();
        if (gtc.LEXER() != null)
            grammarType = GrammarType.LEXER;
        else if (gtc.PARSER() != null)
            grammarType = GrammarType.PARSER;
        else if (gtc.GRAMMAR() != null)
            grammarType = GrammarType.COMBINED;
        else
            grammarType = GrammarType.UNDEFINED;
        grammarDeclaration = new GrammarDeclaration
             (grammarType, grammarName, index);
    }
    
    
  /**
   * Called at the end of an import statement.
   * 
   * @param ctx 
   */
    @Override
    public void exitDelegateGrammar(ANTLRv4Parser.DelegateGrammarContext ctx) {
        ANTLRv4Parser.IdentifierContext ic = ctx.grammarIdentifier().identifier();
        String importedGrammarName = ic.getText();
        int index = ic.ID().getSymbol().getStartIndex();
        if (importedGrammarName.equals(grammarName)) {
            String key = "antlr.error.import.a.grammar.cannot.import.itself";

            String displayName = "A grammar cannot import itself ";
            String description = displayName;
            NBANTLRv4ParsingError semanticError = new NBANTLRv4ParsingError
                    (parsedFileName,
                     Severity.ERROR,
                     key           ,
                     index         ,
                     displayName   ,
                     description   );
            semanticErrors.add(semanticError);
        } else {
         // we build the grammar file path as a local path from current working directory
            Path importedGrammarFilePath = Paths.get(grammarDirectory, importedGrammarName + ".g4");
            File importedGrammarFile = importedGrammarFilePath.toFile();
            if (!importedGrammarFile.exists()) {
                String key = "antlr.error.import.grammar.not.found";
                String displayName = "Unable to import the grammar file " +
                                     importedGrammarName + ".g4" + 
                                     " in the directory of " + grammarName;
                String description = importedGrammarName +
                                     " has been searched in " + grammarDirectory;
                NBANTLRv4ParsingError semanticError = new NBANTLRv4ParsingError
                    (parsedFileName,
                     Severity.ERROR,
                     key           ,
                     index         ,
                     displayName   ,
                     description   );
                semanticErrors.add(semanticError);
            } else {
                GrammarType importedGrammarType =
                        parseGrammarFile(importedGrammarFile.getPath(), index);
                switch (grammarType) {
                    case LEXER :
                        if ((importedGrammarType != GrammarType.LEXER) &&
                            (importedGrammarType != GrammarType.UNDEFINED)) {
                            String key = "antlr.error.import.lexer.grammar.can.only.import.lexer.grammars";
                            String displayName =
                              "A lexer grammar can only include lexer grammars";
                            String description = displayName +
                               "grammar " + grammarName + " is a lexer grammar" +
                               "grammar " + importedGrammarName + " is a " + importedGrammarType + " grammar";
                            NBANTLRv4ParsingError semanticError = new NBANTLRv4ParsingError
                                (parsedFileName,
                                 Severity.ERROR,
                                 key           ,
                                 index         ,
                                 displayName   ,
                                 description   );
                            semanticErrors.add(semanticError);
                        }
                        break;
                    case PARSER :
                        if ((importedGrammarType != GrammarType.PARSER) &&
                            (importedGrammarType != GrammarType.UNDEFINED)) {
                            String key = "antlr.error.import.parser.grammar.can.only.import.parser.grammars";
                            String displayName =
                              "A parser grammar can only import parser grammars";
                            String description = displayName +
                               "grammar " + grammarName + " is a parser grammar" +
                               "grammar " + importedGrammarName + " is a " + importedGrammarType + " grammar";
                            NBANTLRv4ParsingError semanticError = new NBANTLRv4ParsingError
                                (parsedFileName,
                                 Severity.ERROR,
                                 key           ,
                                 index         ,
                                 displayName   ,
                                 description   );
                            semanticErrors.add(semanticError);
                        }
                        break;
                    case COMBINED :
                        if (importedGrammarType == GrammarType.COMBINED) {
                            String key = "antlr.error.import.combined.grammar.can.only.import.parser.and.lexer.grammars";
                            String displayName =
                              "A combined grammar can only include parser and lexer grammars";
                            String description = displayName +
                               "grammar " + grammarName + " is a combined grammar" +
                               "grammar " + importedGrammarName + " is a " + importedGrammarType + " grammar";
                            NBANTLRv4ParsingError semanticError = new NBANTLRv4ParsingError
                                (parsedFileName,
                                 Severity.ERROR,
                                 key           ,
                                 index         ,
                                 displayName   ,
                                 description   );
                            semanticErrors.add(semanticError);
                        }
                        break;
                    case UNDEFINED:
                        break;
                }
            }
        }
    }
    
    
    @Override
    public void exitTokenVocabSpec(ANTLRv4Parser.TokenVocabSpecContext ctx) {
        String tokenSourceId = ctx.identifier().getText();
        int index = ctx.identifier().ID().getSymbol().getStartIndex();
        List<String> recoveredTokens = recoverTokensFrom(tokenSourceId, index);
        ruleDeclarations.addAll(recoveredTokens);
    }
    
    
    @Override
    public void exitTokensSpec(ANTLRv4Parser.TokensSpecContext ctx) {
        ANTLRv4Parser.TokenListContext tlc = ctx.tokenList();
        if (tlc == null) {
            String key = "antlr.warning.tokens.empty.token.list";
            int index = ctx.RBRACE().getSymbol().getStartIndex();
            String displayName =
                "empty token list";
            String description = displayName;
            NBANTLRv4ParsingError semanticWarning = new NBANTLRv4ParsingError
                                (parsedFileName,
                                 Severity.WARNING,
                                 key           ,
                                 index         ,
                                 displayName   ,
                                 description   );
            semanticErrors.add(semanticWarning);
        } else {
            List<TokenIdentifierContext> tics = tlc.tokenIdentifier();
            Iterator<TokenIdentifierContext> tici = tics.iterator();
            TokenIdentifierContext tic;
            String token;
            while (tici.hasNext()) {
                tic = tici.next();
                token = tic.getText();
                ruleDeclarations.add(token);
            }
        }
    }
    
    
    @Override
    public void exitParserRuleDeclaration(ANTLRv4Parser.ParserRuleDeclarationContext ctx) {
     // We add the id of the rule to the set of id
     // it enables to check that each parser rule reference has a correspondent
     // parser rule definition
        ANTLRv4Parser.ParserRuleIdentifierContext pric =
                ctx.parserRuleIdentifier();
        String parserRuleId = pric.ID_STARTING_WITH_LOWERCASE().getText();
        if (grammarType == GrammarType.LEXER) {
            String key = "antlr.error.parserRule.lexer.grammar.can.only.contain.lexer.rule.declarations";
            int index = pric.ID_STARTING_WITH_LOWERCASE().getSymbol().getStartIndex();
            String displayName =
                "a lexer grammar can only contain lexer rule declarations";
            String description = displayName + "\n" +
                                 "rule " + parserRuleId + " is a parser rule";
            NBANTLRv4ParsingError semanticError = new NBANTLRv4ParsingError
                                (parsedFileName,
                                 Severity.ERROR,
                                 key           ,
                                 index         ,
                                 displayName   ,
                                 description   );
            semanticErrors.add(semanticError);
        } else {
            if (firstParserRuleDeclaration == null)
                firstParserRuleDeclaration = parserRuleId;
            if (!ruleDeclarations.contains(parserRuleId)) {
                ruleDeclarations.add(parserRuleId);
                int index = pric.ID_STARTING_WITH_LOWERCASE().getSymbol().getStartIndex();;
                RuleDeclaration ruleDeclaration = new RuleDeclaration(parserRuleId, index);
                parserRuleDeclarations.put(parserRuleId, ruleDeclaration);
            } else {
                String key = "antlr.error.parserRule.already.declared";
                int index = pric.ID_STARTING_WITH_LOWERCASE().getSymbol().getStartIndex();
                String displayName = "rule " + parserRuleId +
                                     " is already declared!";
                String description = displayName;
                NBANTLRv4ParsingError semanticError = new NBANTLRv4ParsingError
                                (parsedFileName,
                                 Severity.ERROR,
                                 key           ,
                                 index         ,
                                 displayName   ,
                                 description   );
                semanticErrors.add(semanticError);
            }
        }
    }
    
    
    @Override
    public void exitParserRuleReference(ANTLRv4Parser.ParserRuleReferenceContext ctx) {
        String parserRuleRefId = ctx.parserRuleIdentifier().ID_STARTING_WITH_LOWERCASE().getText();
        if (!ruleReferences.containsKey(parserRuleRefId)) {
            int index = ctx.parserRuleIdentifier().ID_STARTING_WITH_LOWERCASE().getSymbol().getStartIndex();
            RuleReference ruleRef = new RuleReference(parserRuleRefId, index);
            ruleReferences.put(parserRuleRefId, ruleRef);
        }
    }
    
    
  /**
   * Is called from a lexer or parser rule when its definition contains
   * a string literal or a lexer rule reference.
   * 
   * @param ctx 
   */
    @Override
    public void exitTerminal(ANTLRv4Parser.TerminalContext ctx) {
        ANTLRv4Parser.TokenIdentifierContext lric = ctx.tokenIdentifier();
        if (lric != null) {
            String lexerRuleId = lric.ID_STARTING_WITH_UPPERCASE().getText();
            if (!ruleReferences.containsKey(lexerRuleId)) {
                int index = lric.ID_STARTING_WITH_UPPERCASE().getSymbol().getStartIndex();
                RuleReference ruleRef = new RuleReference(lexerRuleId, index);
                ruleReferences.put(lexerRuleId, ruleRef);
            }
        } else {
            if (grammarType == GrammarType.PARSER) {
                String lexerLiteral = ctx.STRING_LITERAL().getText();
                String key = "antlr.error.parser.grammar.cannot.add.implicitly.lexer.token.through.literal.use";
                int index = ctx.STRING_LITERAL().getSymbol().getStartIndex();
                String displayName = "A parser grammar cannot add implicitly a lexer token through a literal use.";
                String description = displayName + "\n" +
                                     "literal in fault : " + lexerLiteral;
                NBANTLRv4ParsingError semanticError = new NBANTLRv4ParsingError
                                (parsedFileName  ,
                                 Severity.ERROR,
                                 key             ,
                                 index           ,
                                 displayName     ,
                                 description     );
                semanticErrors.add(semanticError);
            }
        }
    }
    
    
    @Override
    public void exitLexerRuleDeclaration(ANTLRv4Parser.LexerRuleDeclarationContext ctx) {
        String lexerRuleId;
        ANTLRv4Parser.TokenIdentifierContext lric = ctx.tokenIdentifier();
        if (lric != null) {
            lexerRuleId = lric.ID_STARTING_WITH_UPPERCASE().getText();
        } else {
            lexerRuleId = ctx.identifier().getText();
        }
        if (grammarType == GrammarType.PARSER) {
            String key = "antlr.error.parser.grammar.can.only.contain.parser.rule.declaration";
            int index = (ctx.FRAGMENT() == null) ?
                         ctx.tokenIdentifier().getStart().getStartIndex() :
                         ctx.FRAGMENT().getSymbol().getStartIndex();
            String displayName = "a parser grammar can only contain parser rule declaration";
            String description = displayName + "\n" +
                                 "rule " + lexerRuleId + " is a lexer rule";
            NBANTLRv4ParsingError semanticError = new NBANTLRv4ParsingError
                                (parsedFileName  ,
                                 Severity.ERROR,
                                 key             ,
                                 index           ,
                                 displayName     ,
                                 description     );
            semanticErrors.add(semanticError);
        } else {
            if (!ruleDeclarations.contains(lexerRuleId))
                ruleDeclarations.add(lexerRuleId);
        }
    }
    
    
    @Override
    public void exitModeSpec(ANTLRv4Parser.ModeSpecContext ctx) {
        if (grammarType != GrammarType.LEXER) {
            String key = "antlr.warning.mode.only.lexer.grammar.can.contain.mode.specifications";
            int index = ctx.MODE().getSymbol().getStartIndex();
            String displayName = "Only lexer grammar can contain mode specifications";
            String description = displayName;
            NBANTLRv4ParsingError semanticError = new NBANTLRv4ParsingError
                                (parsedFileName  ,
                                 Severity.ERROR,
                                 key             ,
                                 index           ,
                                 displayName     ,
                                 description     );
            semanticErrors.add(semanticError);
        }
    }
    
    
  /**
   * We check that each parser reference used has a correspondent parser rule
   * definition.
   * 
   * For doing that we must wait that all grammar source file has been 
   * semantically parsed (the parser rule declaration can be located before 
   * the parser rule declaration where the parser rule reference appears or
   * after or even it can refer to the parser rule where the parser rule 
   * refernece appears).
   */
    public void checkRuleReferences() {
       Set<String> ruleIds = ruleReferences.keySet();
       Iterator<String> it = ruleIds.iterator();
       String ruleId;
       while (it.hasNext()) {
           ruleId = it.next();
           if (!ruleDeclarations.contains(ruleId)) {
            // If the rule reference surely references a lexer rule (or token rule)
            // then a simple warning if it is not found (from a rule or in tokens
            // declaration)
               if (Character.isUpperCase(ruleId.charAt(0))) {
                   String key = "antlr.warning.parserRule.implicit.definition.of.token";
                   int index = ruleReferences.get(ruleId).getRuleReferenceIndex();
                   String displayName = "implicit definition of token " + ruleId;
                   String description = displayName;
                   NBANTLRv4ParsingError semanticWarning = new NBANTLRv4ParsingError
                                (parsedFileName  ,
                                 Severity.WARNING,
                                 key             ,
                                 index           ,
                                 displayName     ,
                                 description     );
                   semanticErrors.add(semanticWarning);
               } else {
                   String key = "antlr.warning.parserRule.rule.reference.has.no.correspondent.declaration";
                   int index = ruleReferences.get(ruleId).getRuleReferenceIndex();
                   String displayName = "The rule reference " + ruleId +
                                        " has no correspondent declaration";
                   String description = displayName;
                   NBANTLRv4ParsingError semanticError = new NBANTLRv4ParsingError
                                (parsedFileName  ,
                                 Severity.ERROR,
                                 key             ,
                                 index           ,
                                 displayName     ,
                                 description     );
                   semanticErrors.add(semanticError);
               }
           }
       }
    }
    
    
    public void checkParserRuleDeclarations() {
        Set<String> parserRuleIds = parserRuleDeclarations.keySet();
        Iterator<String> it = parserRuleIds.iterator();
        String ruleId;
        while (it.hasNext()) {
            ruleId = it.next();
            if (!ruleReferences.containsKey(ruleId) &&
                !ruleId.equals(firstParserRuleDeclaration)) {
                String key = "antlr.warning.parserRule.declaration.used.nowhere";
                int index = parserRuleDeclarations.get(ruleId).getRuleIndex();
                String displayName = "The rule declaration " + ruleId +
                                     " is used nowhere";
                String description = displayName;
                NBANTLRv4ParsingError semanticWarning = new NBANTLRv4ParsingError
                                (parsedFileName  ,
                                 Severity.WARNING,
                                 key             ,
                                 index           ,
                                 displayName     ,
                                 description     );
                semanticErrors.add(semanticWarning);
           }
       }
    }
    
    private GrammarType parseGrammarFile(String grammarFileName, int index) {
//        System.out.println("ANTLRv4SemanticParser : grammarFileName=" +
//                           grammarFileName);
        GrammarType answer;
        ANTLRv4GrammarChecker agc = new ANTLRv4GrammarChecker();
        try (
            InputStream is = new FileInputStream(grammarFileName);
        ) {
            int c;
            StringBuilder content = new StringBuilder();
            while((c = is.read()) != -1)
                content.append((char) c);
            agc.check(content.toString(), grammarFileName);

         // We recover the rules declared in the parsed file
         // (usefull only in case of recursive grammar file parsing, e.g. import)
            ruleDeclarations.addAll(agc.getRuleDeclarations());
            parserRuleDeclarations.putAll(agc.getParserRuleDeclarations());
            ruleReferences.putAll(agc.getRuleReferences());
         // We modify the index of each imported (in such a way that a warning
         // or error will refere to their associated import statement)
            Map<String, RuleDeclaration> importedParserRules =
                                                agc.getParserRuleDeclarations();
            Set<String> importedRuleIds = importedParserRules.keySet();
            Iterator<String> it = importedRuleIds.iterator();
            String ruleId;
            RuleDeclaration rd;
            while (it.hasNext()) {
                ruleId = it.next();
                rd = importedParserRules.get(ruleId);
                rd.setRuleIndex(index);
            }
         // we recover the first rule found in the imported grammar
         // (It will only be usefull if the current grammar is a combined one)
            firstImportedParserRule = agc.getFirstParserRule();
            answer = agc.getGrammarType();
        } catch (FileNotFoundException ex) {
            answer = GrammarType.UNDEFINED;
            LOG.severe("Unable to find the file " + grammarFileName);
        } catch (IOException ex) {
            answer = GrammarType.UNDEFINED;
            LOG.severe("Strange! Unable to close the file " + grammarFileName);
        } catch (RecognitionException ex) {
            answer = GrammarType.UNDEFINED;
            LOG.severe(ex.toString());
        }
        return answer;
    }
    
    public void checkThereIsAtLeastARule() {
        if (ruleDeclarations.isEmpty()) {
            String key = "antlr.error.semantic.global";
            int index = grammarDeclaration.getIndex();
            String displayName = "A grammar file must have at least one rule";
            String description = "A lexer grammar file must have at least one" +
                                 "token declaration rule\n" +
                                 "A parser grammar file must have at least one"+
                                 " parser rule\n" +
                                 "a combined grammar file must have at least" +
                                 "one perser rule and one lexer rule (defined" +
                                 " in the dile or imported)";
            NBANTLRv4ParsingError semanticError = new NBANTLRv4ParsingError
                        (parsedFileName,
                         Severity.ERROR,
                         key           ,
                         index         ,
                         displayName   ,
                         description   );
            semanticErrors.add(semanticError);
        }
    }
    
    
    private List<String> recoverTokensFrom(String tokenSourceId, int index) {
        List<String> recoveredTokens;
        ProjectManager pm = ProjectManager.getDefault();
     // We look for the project directory (it is a parent directory of grammarDirectory)
        FileObject fo = FileUtil.toFileObject(new File(grammarDirectory));
        boolean found = false;
        while (!found && (fo != null)) {
            if (pm.isProject(fo))
                found = true;
            else
                fo = fo.getParent();
        }
        if (fo == null)
            LOG.severe("Strange unable to find a project that exists and is open");
        Path propertyFilePath = Paths.get(fo.getPath(), "nbproject", "project.properties");
        File propertiesFile = propertyFilePath.toFile();
        PropertyProvider propertyProvider = PropertyUtils.propertiesFilePropertyProvider(propertiesFile);
        PropertyEvaluator propertyEvaluator = PropertyUtils.sequentialPropertyEvaluator(null, propertyProvider);
     // We recover the property giving the location of .tokens file that is
     // the destination directory of ANTLR generator
        String destDir = propertyEvaluator.getProperty("antlr.generator.dest.dir");
        Path tokenSourceFilePath = Paths.get(fo.getPath(), destDir, tokenSourceId + ".tokens");
        File tokenSourceGrammarFile = tokenSourceFilePath.toFile();
        if (tokenSourceGrammarFile.exists()) {
            recoveredTokens = parseTokenFile(tokenSourceFilePath);
        } else {
            String key = "antlr.error.semantic.options.tokenVocab.unable.to.find.token.file";
            String displayName = "No token file named " + tokenSourceId + ".tokens" +
                                 " has been found in destination directory " + destDir;
            String description = displayName;
            NBANTLRv4ParsingError semanticError = new NBANTLRv4ParsingError
                        (parsedFileName,
                         Severity.ERROR,
                         key           ,
                         index         ,
                         displayName   ,
                         description   );
            semanticErrors.add(semanticError);
            recoveredTokens = new ArrayList<>();
        }
        
        return recoveredTokens;
    }
    
    
    private List<String> parseTokenFile(Path tokenSourceFilePath) {
        List<String> answer = new ArrayList<>();
        try {
            final List<String> tokenDefs = Files.readAllLines
                                  (tokenSourceFilePath, StandardCharsets.UTF_8);
            for (String tokenDef : tokenDefs) {
                String[] tokenItems = tokenDef.split("=");
                String tokenName = tokenItems[0];
                if (!tokenName.startsWith("'"))
                    ruleDeclarations.add(tokenName);
            }
        } catch (IOException ex) {
            LOG.severe("Unable to read token file: " + tokenSourceFilePath.toString());
            LOG.severe(ex.getMessage());
        }
        
        return answer;
    }
}