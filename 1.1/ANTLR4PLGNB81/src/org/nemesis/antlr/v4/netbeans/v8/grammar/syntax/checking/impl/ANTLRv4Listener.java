// Generated from ANTLRv4.g4 by ANTLR 4.6
package org.nemesis.antlr.v4.netbeans.v8.grammar.syntax.checking.impl;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ANTLRv4Parser}.
 */
public interface ANTLRv4Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#grammarFile}.
	 * @param ctx the parse tree
	 */
	void enterGrammarFile(ANTLRv4Parser.GrammarFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#grammarFile}.
	 * @param ctx the parse tree
	 */
	void exitGrammarFile(ANTLRv4Parser.GrammarFileContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#grammarSpec}.
	 * @param ctx the parse tree
	 */
	void enterGrammarSpec(ANTLRv4Parser.GrammarSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#grammarSpec}.
	 * @param ctx the parse tree
	 */
	void exitGrammarSpec(ANTLRv4Parser.GrammarSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#grammarType}.
	 * @param ctx the parse tree
	 */
	void enterGrammarType(ANTLRv4Parser.GrammarTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#grammarType}.
	 * @param ctx the parse tree
	 */
	void exitGrammarType(ANTLRv4Parser.GrammarTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#analyzerDirectiveSpec}.
	 * @param ctx the parse tree
	 */
	void enterAnalyzerDirectiveSpec(ANTLRv4Parser.AnalyzerDirectiveSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#analyzerDirectiveSpec}.
	 * @param ctx the parse tree
	 */
	void exitAnalyzerDirectiveSpec(ANTLRv4Parser.AnalyzerDirectiveSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#optionsSpec}.
	 * @param ctx the parse tree
	 */
	void enterOptionsSpec(ANTLRv4Parser.OptionsSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#optionsSpec}.
	 * @param ctx the parse tree
	 */
	void exitOptionsSpec(ANTLRv4Parser.OptionsSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#optionSpec}.
	 * @param ctx the parse tree
	 */
	void enterOptionSpec(ANTLRv4Parser.OptionSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#optionSpec}.
	 * @param ctx the parse tree
	 */
	void exitOptionSpec(ANTLRv4Parser.OptionSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#superClassSpec}.
	 * @param ctx the parse tree
	 */
	void enterSuperClassSpec(ANTLRv4Parser.SuperClassSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#superClassSpec}.
	 * @param ctx the parse tree
	 */
	void exitSuperClassSpec(ANTLRv4Parser.SuperClassSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#languageSpec}.
	 * @param ctx the parse tree
	 */
	void enterLanguageSpec(ANTLRv4Parser.LanguageSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#languageSpec}.
	 * @param ctx the parse tree
	 */
	void exitLanguageSpec(ANTLRv4Parser.LanguageSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#tokenVocabSpec}.
	 * @param ctx the parse tree
	 */
	void enterTokenVocabSpec(ANTLRv4Parser.TokenVocabSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#tokenVocabSpec}.
	 * @param ctx the parse tree
	 */
	void exitTokenVocabSpec(ANTLRv4Parser.TokenVocabSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#tokenLabelTypeSpec}.
	 * @param ctx the parse tree
	 */
	void enterTokenLabelTypeSpec(ANTLRv4Parser.TokenLabelTypeSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#tokenLabelTypeSpec}.
	 * @param ctx the parse tree
	 */
	void exitTokenLabelTypeSpec(ANTLRv4Parser.TokenLabelTypeSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#delegateGrammars}.
	 * @param ctx the parse tree
	 */
	void enterDelegateGrammars(ANTLRv4Parser.DelegateGrammarsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#delegateGrammars}.
	 * @param ctx the parse tree
	 */
	void exitDelegateGrammars(ANTLRv4Parser.DelegateGrammarsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#delegateGrammar}.
	 * @param ctx the parse tree
	 */
	void enterDelegateGrammar(ANTLRv4Parser.DelegateGrammarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#delegateGrammar}.
	 * @param ctx the parse tree
	 */
	void exitDelegateGrammar(ANTLRv4Parser.DelegateGrammarContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#grammarIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterGrammarIdentifier(ANTLRv4Parser.GrammarIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#grammarIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitGrammarIdentifier(ANTLRv4Parser.GrammarIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#tokensSpec}.
	 * @param ctx the parse tree
	 */
	void enterTokensSpec(ANTLRv4Parser.TokensSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#tokensSpec}.
	 * @param ctx the parse tree
	 */
	void exitTokensSpec(ANTLRv4Parser.TokensSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#tokenList}.
	 * @param ctx the parse tree
	 */
	void enterTokenList(ANTLRv4Parser.TokenListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#tokenList}.
	 * @param ctx the parse tree
	 */
	void exitTokenList(ANTLRv4Parser.TokenListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#channelsSpec}.
	 * @param ctx the parse tree
	 */
	void enterChannelsSpec(ANTLRv4Parser.ChannelsSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#channelsSpec}.
	 * @param ctx the parse tree
	 */
	void exitChannelsSpec(ANTLRv4Parser.ChannelsSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#idList}.
	 * @param ctx the parse tree
	 */
	void enterIdList(ANTLRv4Parser.IdListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#idList}.
	 * @param ctx the parse tree
	 */
	void exitIdList(ANTLRv4Parser.IdListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#action}.
	 * @param ctx the parse tree
	 */
	void enterAction(ANTLRv4Parser.ActionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#action}.
	 * @param ctx the parse tree
	 */
	void exitAction(ANTLRv4Parser.ActionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#headerAction}.
	 * @param ctx the parse tree
	 */
	void enterHeaderAction(ANTLRv4Parser.HeaderActionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#headerAction}.
	 * @param ctx the parse tree
	 */
	void exitHeaderAction(ANTLRv4Parser.HeaderActionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#memberAction}.
	 * @param ctx the parse tree
	 */
	void enterMemberAction(ANTLRv4Parser.MemberActionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#memberAction}.
	 * @param ctx the parse tree
	 */
	void exitMemberAction(ANTLRv4Parser.MemberActionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#actionDestination}.
	 * @param ctx the parse tree
	 */
	void enterActionDestination(ANTLRv4Parser.ActionDestinationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#actionDestination}.
	 * @param ctx the parse tree
	 */
	void exitActionDestination(ANTLRv4Parser.ActionDestinationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#headerActionBlock}.
	 * @param ctx the parse tree
	 */
	void enterHeaderActionBlock(ANTLRv4Parser.HeaderActionBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#headerActionBlock}.
	 * @param ctx the parse tree
	 */
	void exitHeaderActionBlock(ANTLRv4Parser.HeaderActionBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#headerActionContent}.
	 * @param ctx the parse tree
	 */
	void enterHeaderActionContent(ANTLRv4Parser.HeaderActionContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#headerActionContent}.
	 * @param ctx the parse tree
	 */
	void exitHeaderActionContent(ANTLRv4Parser.HeaderActionContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterPackageDeclaration(ANTLRv4Parser.PackageDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitPackageDeclaration(ANTLRv4Parser.PackageDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterImportDeclaration(ANTLRv4Parser.ImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitImportDeclaration(ANTLRv4Parser.ImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#singleTypeImportDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterSingleTypeImportDeclaration(ANTLRv4Parser.SingleTypeImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#singleTypeImportDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitSingleTypeImportDeclaration(ANTLRv4Parser.SingleTypeImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#actionBlock}.
	 * @param ctx the parse tree
	 */
	void enterActionBlock(ANTLRv4Parser.ActionBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#actionBlock}.
	 * @param ctx the parse tree
	 */
	void exitActionBlock(ANTLRv4Parser.ActionBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#modeSpec}.
	 * @param ctx the parse tree
	 */
	void enterModeSpec(ANTLRv4Parser.ModeSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#modeSpec}.
	 * @param ctx the parse tree
	 */
	void exitModeSpec(ANTLRv4Parser.ModeSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#ruleSpec}.
	 * @param ctx the parse tree
	 */
	void enterRuleSpec(ANTLRv4Parser.RuleSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#ruleSpec}.
	 * @param ctx the parse tree
	 */
	void exitRuleSpec(ANTLRv4Parser.RuleSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#parserRuleSpec}.
	 * @param ctx the parse tree
	 */
	void enterParserRuleSpec(ANTLRv4Parser.ParserRuleSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#parserRuleSpec}.
	 * @param ctx the parse tree
	 */
	void exitParserRuleSpec(ANTLRv4Parser.ParserRuleSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#parserRuleDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterParserRuleDeclaration(ANTLRv4Parser.ParserRuleDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#parserRuleDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitParserRuleDeclaration(ANTLRv4Parser.ParserRuleDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#exceptionGroup}.
	 * @param ctx the parse tree
	 */
	void enterExceptionGroup(ANTLRv4Parser.ExceptionGroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#exceptionGroup}.
	 * @param ctx the parse tree
	 */
	void exitExceptionGroup(ANTLRv4Parser.ExceptionGroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#exceptionHandler}.
	 * @param ctx the parse tree
	 */
	void enterExceptionHandler(ANTLRv4Parser.ExceptionHandlerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#exceptionHandler}.
	 * @param ctx the parse tree
	 */
	void exitExceptionHandler(ANTLRv4Parser.ExceptionHandlerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#finallyClause}.
	 * @param ctx the parse tree
	 */
	void enterFinallyClause(ANTLRv4Parser.FinallyClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#finallyClause}.
	 * @param ctx the parse tree
	 */
	void exitFinallyClause(ANTLRv4Parser.FinallyClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#parserRulePrequel}.
	 * @param ctx the parse tree
	 */
	void enterParserRulePrequel(ANTLRv4Parser.ParserRulePrequelContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#parserRulePrequel}.
	 * @param ctx the parse tree
	 */
	void exitParserRulePrequel(ANTLRv4Parser.ParserRulePrequelContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#parserRuleReturns}.
	 * @param ctx the parse tree
	 */
	void enterParserRuleReturns(ANTLRv4Parser.ParserRuleReturnsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#parserRuleReturns}.
	 * @param ctx the parse tree
	 */
	void exitParserRuleReturns(ANTLRv4Parser.ParserRuleReturnsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#throwsSpec}.
	 * @param ctx the parse tree
	 */
	void enterThrowsSpec(ANTLRv4Parser.ThrowsSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#throwsSpec}.
	 * @param ctx the parse tree
	 */
	void exitThrowsSpec(ANTLRv4Parser.ThrowsSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#localsSpec}.
	 * @param ctx the parse tree
	 */
	void enterLocalsSpec(ANTLRv4Parser.LocalsSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#localsSpec}.
	 * @param ctx the parse tree
	 */
	void exitLocalsSpec(ANTLRv4Parser.LocalsSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#ruleAction}.
	 * @param ctx the parse tree
	 */
	void enterRuleAction(ANTLRv4Parser.RuleActionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#ruleAction}.
	 * @param ctx the parse tree
	 */
	void exitRuleAction(ANTLRv4Parser.RuleActionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#parserRuleVisibility}.
	 * @param ctx the parse tree
	 */
	void enterParserRuleVisibility(ANTLRv4Parser.ParserRuleVisibilityContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#parserRuleVisibility}.
	 * @param ctx the parse tree
	 */
	void exitParserRuleVisibility(ANTLRv4Parser.ParserRuleVisibilityContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#parserRuleDefinition}.
	 * @param ctx the parse tree
	 */
	void enterParserRuleDefinition(ANTLRv4Parser.ParserRuleDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#parserRuleDefinition}.
	 * @param ctx the parse tree
	 */
	void exitParserRuleDefinition(ANTLRv4Parser.ParserRuleDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#parserRuleLabeledAlternative}.
	 * @param ctx the parse tree
	 */
	void enterParserRuleLabeledAlternative(ANTLRv4Parser.ParserRuleLabeledAlternativeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#parserRuleLabeledAlternative}.
	 * @param ctx the parse tree
	 */
	void exitParserRuleLabeledAlternative(ANTLRv4Parser.ParserRuleLabeledAlternativeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#altList}.
	 * @param ctx the parse tree
	 */
	void enterAltList(ANTLRv4Parser.AltListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#altList}.
	 * @param ctx the parse tree
	 */
	void exitAltList(ANTLRv4Parser.AltListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#parserRuleAlternative}.
	 * @param ctx the parse tree
	 */
	void enterParserRuleAlternative(ANTLRv4Parser.ParserRuleAlternativeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#parserRuleAlternative}.
	 * @param ctx the parse tree
	 */
	void exitParserRuleAlternative(ANTLRv4Parser.ParserRuleAlternativeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#parserRuleElement}.
	 * @param ctx the parse tree
	 */
	void enterParserRuleElement(ANTLRv4Parser.ParserRuleElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#parserRuleElement}.
	 * @param ctx the parse tree
	 */
	void exitParserRuleElement(ANTLRv4Parser.ParserRuleElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#labeledParserRuleElement}.
	 * @param ctx the parse tree
	 */
	void enterLabeledParserRuleElement(ANTLRv4Parser.LabeledParserRuleElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#labeledParserRuleElement}.
	 * @param ctx the parse tree
	 */
	void exitLabeledParserRuleElement(ANTLRv4Parser.LabeledParserRuleElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#parserRuleAtom}.
	 * @param ctx the parse tree
	 */
	void enterParserRuleAtom(ANTLRv4Parser.ParserRuleAtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#parserRuleAtom}.
	 * @param ctx the parse tree
	 */
	void exitParserRuleAtom(ANTLRv4Parser.ParserRuleAtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#parserRuleReference}.
	 * @param ctx the parse tree
	 */
	void enterParserRuleReference(ANTLRv4Parser.ParserRuleReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#parserRuleReference}.
	 * @param ctx the parse tree
	 */
	void exitParserRuleReference(ANTLRv4Parser.ParserRuleReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#actionBlockArguments}.
	 * @param ctx the parse tree
	 */
	void enterActionBlockArguments(ANTLRv4Parser.ActionBlockArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#actionBlockArguments}.
	 * @param ctx the parse tree
	 */
	void exitActionBlockArguments(ANTLRv4Parser.ActionBlockArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#lexerRuleSpec}.
	 * @param ctx the parse tree
	 */
	void enterLexerRuleSpec(ANTLRv4Parser.LexerRuleSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#lexerRuleSpec}.
	 * @param ctx the parse tree
	 */
	void exitLexerRuleSpec(ANTLRv4Parser.LexerRuleSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#lexerRuleDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLexerRuleDeclaration(ANTLRv4Parser.LexerRuleDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#lexerRuleDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLexerRuleDeclaration(ANTLRv4Parser.LexerRuleDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#lexerRuleBlock}.
	 * @param ctx the parse tree
	 */
	void enterLexerRuleBlock(ANTLRv4Parser.LexerRuleBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#lexerRuleBlock}.
	 * @param ctx the parse tree
	 */
	void exitLexerRuleBlock(ANTLRv4Parser.LexerRuleBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#lexerRuleAlt}.
	 * @param ctx the parse tree
	 */
	void enterLexerRuleAlt(ANTLRv4Parser.LexerRuleAltContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#lexerRuleAlt}.
	 * @param ctx the parse tree
	 */
	void exitLexerRuleAlt(ANTLRv4Parser.LexerRuleAltContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#lexerRuleElements}.
	 * @param ctx the parse tree
	 */
	void enterLexerRuleElements(ANTLRv4Parser.LexerRuleElementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#lexerRuleElements}.
	 * @param ctx the parse tree
	 */
	void exitLexerRuleElements(ANTLRv4Parser.LexerRuleElementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#lexerRuleElement}.
	 * @param ctx the parse tree
	 */
	void enterLexerRuleElement(ANTLRv4Parser.LexerRuleElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#lexerRuleElement}.
	 * @param ctx the parse tree
	 */
	void exitLexerRuleElement(ANTLRv4Parser.LexerRuleElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#labeledLexerRuleElement}.
	 * @param ctx the parse tree
	 */
	void enterLabeledLexerRuleElement(ANTLRv4Parser.LabeledLexerRuleElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#labeledLexerRuleElement}.
	 * @param ctx the parse tree
	 */
	void exitLabeledLexerRuleElement(ANTLRv4Parser.LabeledLexerRuleElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#lexerRuleElementBlock}.
	 * @param ctx the parse tree
	 */
	void enterLexerRuleElementBlock(ANTLRv4Parser.LexerRuleElementBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#lexerRuleElementBlock}.
	 * @param ctx the parse tree
	 */
	void exitLexerRuleElementBlock(ANTLRv4Parser.LexerRuleElementBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#lexerCommands}.
	 * @param ctx the parse tree
	 */
	void enterLexerCommands(ANTLRv4Parser.LexerCommandsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#lexerCommands}.
	 * @param ctx the parse tree
	 */
	void exitLexerCommands(ANTLRv4Parser.LexerCommandsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#lexerCommand}.
	 * @param ctx the parse tree
	 */
	void enterLexerCommand(ANTLRv4Parser.LexerCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#lexerCommand}.
	 * @param ctx the parse tree
	 */
	void exitLexerCommand(ANTLRv4Parser.LexerCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#lexerCommandExpr}.
	 * @param ctx the parse tree
	 */
	void enterLexerCommandExpr(ANTLRv4Parser.LexerCommandExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#lexerCommandExpr}.
	 * @param ctx the parse tree
	 */
	void exitLexerCommandExpr(ANTLRv4Parser.LexerCommandExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#lexerRuleAtom}.
	 * @param ctx the parse tree
	 */
	void enterLexerRuleAtom(ANTLRv4Parser.LexerRuleAtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#lexerRuleAtom}.
	 * @param ctx the parse tree
	 */
	void exitLexerRuleAtom(ANTLRv4Parser.LexerRuleAtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#ebnf}.
	 * @param ctx the parse tree
	 */
	void enterEbnf(ANTLRv4Parser.EbnfContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#ebnf}.
	 * @param ctx the parse tree
	 */
	void exitEbnf(ANTLRv4Parser.EbnfContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#blockSuffix}.
	 * @param ctx the parse tree
	 */
	void enterBlockSuffix(ANTLRv4Parser.BlockSuffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#blockSuffix}.
	 * @param ctx the parse tree
	 */
	void exitBlockSuffix(ANTLRv4Parser.BlockSuffixContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#ebnfSuffix}.
	 * @param ctx the parse tree
	 */
	void enterEbnfSuffix(ANTLRv4Parser.EbnfSuffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#ebnfSuffix}.
	 * @param ctx the parse tree
	 */
	void exitEbnfSuffix(ANTLRv4Parser.EbnfSuffixContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#notSet}.
	 * @param ctx the parse tree
	 */
	void enterNotSet(ANTLRv4Parser.NotSetContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#notSet}.
	 * @param ctx the parse tree
	 */
	void exitNotSet(ANTLRv4Parser.NotSetContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#blockSet}.
	 * @param ctx the parse tree
	 */
	void enterBlockSet(ANTLRv4Parser.BlockSetContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#blockSet}.
	 * @param ctx the parse tree
	 */
	void exitBlockSet(ANTLRv4Parser.BlockSetContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#setElement}.
	 * @param ctx the parse tree
	 */
	void enterSetElement(ANTLRv4Parser.SetElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#setElement}.
	 * @param ctx the parse tree
	 */
	void exitSetElement(ANTLRv4Parser.SetElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(ANTLRv4Parser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(ANTLRv4Parser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#characterRange}.
	 * @param ctx the parse tree
	 */
	void enterCharacterRange(ANTLRv4Parser.CharacterRangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#characterRange}.
	 * @param ctx the parse tree
	 */
	void exitCharacterRange(ANTLRv4Parser.CharacterRangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#terminal}.
	 * @param ctx the parse tree
	 */
	void enterTerminal(ANTLRv4Parser.TerminalContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#terminal}.
	 * @param ctx the parse tree
	 */
	void exitTerminal(ANTLRv4Parser.TerminalContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#elementOptions}.
	 * @param ctx the parse tree
	 */
	void enterElementOptions(ANTLRv4Parser.ElementOptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#elementOptions}.
	 * @param ctx the parse tree
	 */
	void exitElementOptions(ANTLRv4Parser.ElementOptionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#elementOption}.
	 * @param ctx the parse tree
	 */
	void enterElementOption(ANTLRv4Parser.ElementOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#elementOption}.
	 * @param ctx the parse tree
	 */
	void exitElementOption(ANTLRv4Parser.ElementOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#tokenOption}.
	 * @param ctx the parse tree
	 */
	void enterTokenOption(ANTLRv4Parser.TokenOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#tokenOption}.
	 * @param ctx the parse tree
	 */
	void exitTokenOption(ANTLRv4Parser.TokenOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(ANTLRv4Parser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(ANTLRv4Parser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#ruleElementIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterRuleElementIdentifier(ANTLRv4Parser.RuleElementIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#ruleElementIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitRuleElementIdentifier(ANTLRv4Parser.RuleElementIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#classIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterClassIdentifier(ANTLRv4Parser.ClassIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#classIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitClassIdentifier(ANTLRv4Parser.ClassIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#genericClassIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterGenericClassIdentifier(ANTLRv4Parser.GenericClassIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#genericClassIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitGenericClassIdentifier(ANTLRv4Parser.GenericClassIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#packageIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterPackageIdentifier(ANTLRv4Parser.PackageIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#packageIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitPackageIdentifier(ANTLRv4Parser.PackageIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#parserRuleIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterParserRuleIdentifier(ANTLRv4Parser.ParserRuleIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#parserRuleIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitParserRuleIdentifier(ANTLRv4Parser.ParserRuleIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRv4Parser#tokenIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTokenIdentifier(ANTLRv4Parser.TokenIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRv4Parser#tokenIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTokenIdentifier(ANTLRv4Parser.TokenIdentifierContext ctx);
}