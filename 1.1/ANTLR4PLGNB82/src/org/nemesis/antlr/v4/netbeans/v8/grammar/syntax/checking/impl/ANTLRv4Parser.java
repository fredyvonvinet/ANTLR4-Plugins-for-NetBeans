// Generated from ANTLRv4.g4 by ANTLR 4.6
package org.nemesis.antlr.v4.netbeans.v8.grammar.syntax.checking.impl;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ANTLRv4Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ID_STARTING_WITH_UPPERCASE=1, ID_STARTING_WITH_LOWERCASE=2, LEXER_CHAR_SET=3, 
		DOC_COMMENT=4, BLOCK_COMMENT=5, LINE_COMMENT=6, INT=7, STRING_LITERAL=8, 
		UNTERMINATED_STRING_LITERAL=9, BEGIN_ARGUMENT=10, BEGIN_ACTION=11, OPTIONS=12, 
		TOKENS=13, CHANNELS=14, IMPORT=15, FRAGMENT=16, LEXER=17, PARSER=18, GRAMMAR=19, 
		PROTECTED=20, PUBLIC=21, PRIVATE=22, RETURNS=23, LOCALS=24, INIT=25, AFTER=26, 
		THROWS=27, CATCH=28, FINALLY=29, MODE=30, COLON=31, COLONCOLON=32, COMMA=33, 
		SEMI=34, LPAREN=35, RPAREN=36, LBRACE=37, RBRACE=38, RARROW=39, LT=40, 
		ASSOC=41, RIGHT=42, LEFT=43, FAIL=44, GT=45, ASSIGN=46, QUESTION=47, STAR=48, 
		PLUS_ASSIGN=49, PLUS=50, OR=51, DOLLAR=52, RANGE=53, DOT=54, AT=55, HEADER=56, 
		MEMBERS=57, SHARP=58, NOT=59, ID=60, WS=61, ERRCHAR=62, END_ARGUMENT=63, 
		UNTERMINATED_ARGUMENT=64, ARGUMENT_CONTENT=65, HEADER_P_LINE_COMMENT=66, 
		HEADER_P_WS=67, HEADER_PACKAGE=68, HEADER_IMPORT=69, HEADER_STATIC=70, 
		HEADER_WS=71, HEADER_END=72, UNTERMINATED_HEADER=73, END_ACTION=74, UNTERMINATED_ACTION=75, 
		ACTION_CONTENT=76, OPT_BLOCK_COMMENT=77, OPT_LINE_COMMENT=78, SUPER_CLASS=79, 
		LANGUAGE=80, TOKEN_VOCAB=81, TOKEN_LABEL_TYPE=82, OPT_WS=83, TOK_BLOCK_COMMENT=84, 
		TOK_LINE_COMMENT=85, TOK_ID=86, TOK_WS=87, CHN_BLOCK_COMMENT=88, CHN_LINE_COMMENT=89, 
		CHN_WS=90, ALT_WS=91, ALT_UNTERMINATED=92, LEXER_COMMAND_LINE_COMMENT=93, 
		SKIP_COMMAND=94, MORE_COMMAND=95, TYPE_COMMAND=96, CHANNEL_COMMAND=97, 
		MODE_COMMAND=98, PUSHMODE_COMMAND=99, POPMODE_COMMAND=100, LEXER_COMMAND_WS=101, 
		UNTERMINATED_CHAR_SET=102, HEADER_STAR=103, HEADER_SEMI=104, HEADER_DOT=105;
	public static final int
		RULE_grammarFile = 0, RULE_grammarSpec = 1, RULE_grammarType = 2, RULE_analyzerDirectiveSpec = 3, 
		RULE_optionsSpec = 4, RULE_optionSpec = 5, RULE_superClassSpec = 6, RULE_languageSpec = 7, 
		RULE_tokenVocabSpec = 8, RULE_tokenLabelTypeSpec = 9, RULE_delegateGrammars = 10, 
		RULE_delegateGrammar = 11, RULE_grammarIdentifier = 12, RULE_tokensSpec = 13, 
		RULE_tokenList = 14, RULE_channelsSpec = 15, RULE_idList = 16, RULE_action = 17, 
		RULE_headerAction = 18, RULE_memberAction = 19, RULE_actionDestination = 20, 
		RULE_headerActionBlock = 21, RULE_headerActionContent = 22, RULE_packageDeclaration = 23, 
		RULE_importDeclaration = 24, RULE_singleTypeImportDeclaration = 25, RULE_actionBlock = 26, 
		RULE_modeSpec = 27, RULE_ruleSpec = 28, RULE_parserRuleSpec = 29, RULE_parserRuleDeclaration = 30, 
		RULE_exceptionGroup = 31, RULE_exceptionHandler = 32, RULE_finallyClause = 33, 
		RULE_parserRulePrequel = 34, RULE_parserRuleReturns = 35, RULE_throwsSpec = 36, 
		RULE_localsSpec = 37, RULE_ruleAction = 38, RULE_parserRuleVisibility = 39, 
		RULE_parserRuleDefinition = 40, RULE_parserRuleLabeledAlternative = 41, 
		RULE_altList = 42, RULE_parserRuleAlternative = 43, RULE_parserRuleElement = 44, 
		RULE_labeledParserRuleElement = 45, RULE_parserRuleAtom = 46, RULE_parserRuleReference = 47, 
		RULE_actionBlockArguments = 48, RULE_lexerRuleSpec = 49, RULE_lexerRuleDeclaration = 50, 
		RULE_lexerRuleBlock = 51, RULE_lexerRuleAlt = 52, RULE_lexerRuleElements = 53, 
		RULE_lexerRuleElement = 54, RULE_labeledLexerRuleElement = 55, RULE_lexerRuleElementBlock = 56, 
		RULE_lexerCommands = 57, RULE_lexerCommand = 58, RULE_lexerCommandExpr = 59, 
		RULE_lexerRuleAtom = 60, RULE_ebnf = 61, RULE_blockSuffix = 62, RULE_ebnfSuffix = 63, 
		RULE_notSet = 64, RULE_blockSet = 65, RULE_setElement = 66, RULE_block = 67, 
		RULE_characterRange = 68, RULE_terminal = 69, RULE_elementOptions = 70, 
		RULE_elementOption = 71, RULE_tokenOption = 72, RULE_identifier = 73, 
		RULE_ruleElementIdentifier = 74, RULE_classIdentifier = 75, RULE_genericClassIdentifier = 76, 
		RULE_packageIdentifier = 77, RULE_parserRuleIdentifier = 78, RULE_tokenIdentifier = 79;
	public static final String[] ruleNames = {
		"grammarFile", "grammarSpec", "grammarType", "analyzerDirectiveSpec", 
		"optionsSpec", "optionSpec", "superClassSpec", "languageSpec", "tokenVocabSpec", 
		"tokenLabelTypeSpec", "delegateGrammars", "delegateGrammar", "grammarIdentifier", 
		"tokensSpec", "tokenList", "channelsSpec", "idList", "action", "headerAction", 
		"memberAction", "actionDestination", "headerActionBlock", "headerActionContent", 
		"packageDeclaration", "importDeclaration", "singleTypeImportDeclaration", 
		"actionBlock", "modeSpec", "ruleSpec", "parserRuleSpec", "parserRuleDeclaration", 
		"exceptionGroup", "exceptionHandler", "finallyClause", "parserRulePrequel", 
		"parserRuleReturns", "throwsSpec", "localsSpec", "ruleAction", "parserRuleVisibility", 
		"parserRuleDefinition", "parserRuleLabeledAlternative", "altList", "parserRuleAlternative", 
		"parserRuleElement", "labeledParserRuleElement", "parserRuleAtom", "parserRuleReference", 
		"actionBlockArguments", "lexerRuleSpec", "lexerRuleDeclaration", "lexerRuleBlock", 
		"lexerRuleAlt", "lexerRuleElements", "lexerRuleElement", "labeledLexerRuleElement", 
		"lexerRuleElementBlock", "lexerCommands", "lexerCommand", "lexerCommandExpr", 
		"lexerRuleAtom", "ebnf", "blockSuffix", "ebnfSuffix", "notSet", "blockSet", 
		"setElement", "block", "characterRange", "terminal", "elementOptions", 
		"elementOption", "tokenOption", "identifier", "ruleElementIdentifier", 
		"classIdentifier", "genericClassIdentifier", "packageIdentifier", "parserRuleIdentifier", 
		"tokenIdentifier"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"'options'", "'tokens'", "'channels'", null, "'fragment'", "'lexer'", 
		"'parser'", "'grammar'", "'protected'", "'public'", "'private'", "'returns'", 
		"'locals'", "'init'", "'after'", "'throws'", "'catch'", "'finally'", null, 
		null, null, null, null, null, null, null, null, null, null, "'assoc'", 
		"'right'", "'left'", "'fail'", null, null, null, null, null, null, null, 
		null, null, null, null, "'header'", "'members'", null, null, null, null, 
		null, null, null, null, null, null, "'package'", null, "'static'", null, 
		null, null, null, null, null, null, null, "'superClass'", "'language'", 
		"'tokenVocab'", "'TokenLabelType'", null, null, null, null, null, null, 
		null, null, null, null, null, "'skip'", "'more'", "'type'", "'channel'", 
		null, "'pushMode'", "'popMode'", null, null, "'*'", "';'", "'.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ID_STARTING_WITH_UPPERCASE", "ID_STARTING_WITH_LOWERCASE", "LEXER_CHAR_SET", 
		"DOC_COMMENT", "BLOCK_COMMENT", "LINE_COMMENT", "INT", "STRING_LITERAL", 
		"UNTERMINATED_STRING_LITERAL", "BEGIN_ARGUMENT", "BEGIN_ACTION", "OPTIONS", 
		"TOKENS", "CHANNELS", "IMPORT", "FRAGMENT", "LEXER", "PARSER", "GRAMMAR", 
		"PROTECTED", "PUBLIC", "PRIVATE", "RETURNS", "LOCALS", "INIT", "AFTER", 
		"THROWS", "CATCH", "FINALLY", "MODE", "COLON", "COLONCOLON", "COMMA", 
		"SEMI", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "RARROW", "LT", "ASSOC", 
		"RIGHT", "LEFT", "FAIL", "GT", "ASSIGN", "QUESTION", "STAR", "PLUS_ASSIGN", 
		"PLUS", "OR", "DOLLAR", "RANGE", "DOT", "AT", "HEADER", "MEMBERS", "SHARP", 
		"NOT", "ID", "WS", "ERRCHAR", "END_ARGUMENT", "UNTERMINATED_ARGUMENT", 
		"ARGUMENT_CONTENT", "HEADER_P_LINE_COMMENT", "HEADER_P_WS", "HEADER_PACKAGE", 
		"HEADER_IMPORT", "HEADER_STATIC", "HEADER_WS", "HEADER_END", "UNTERMINATED_HEADER", 
		"END_ACTION", "UNTERMINATED_ACTION", "ACTION_CONTENT", "OPT_BLOCK_COMMENT", 
		"OPT_LINE_COMMENT", "SUPER_CLASS", "LANGUAGE", "TOKEN_VOCAB", "TOKEN_LABEL_TYPE", 
		"OPT_WS", "TOK_BLOCK_COMMENT", "TOK_LINE_COMMENT", "TOK_ID", "TOK_WS", 
		"CHN_BLOCK_COMMENT", "CHN_LINE_COMMENT", "CHN_WS", "ALT_WS", "ALT_UNTERMINATED", 
		"LEXER_COMMAND_LINE_COMMENT", "SKIP_COMMAND", "MORE_COMMAND", "TYPE_COMMAND", 
		"CHANNEL_COMMAND", "MODE_COMMAND", "PUSHMODE_COMMAND", "POPMODE_COMMAND", 
		"LEXER_COMMAND_WS", "UNTERMINATED_CHAR_SET", "HEADER_STAR", "HEADER_SEMI", 
		"HEADER_DOT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ANTLRv4.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ANTLRv4Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class GrammarFileContext extends ParserRuleContext {
		public GrammarSpecContext grammarSpec() {
			return getRuleContext(GrammarSpecContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ANTLRv4Parser.EOF, 0); }
		public List<AnalyzerDirectiveSpecContext> analyzerDirectiveSpec() {
			return getRuleContexts(AnalyzerDirectiveSpecContext.class);
		}
		public AnalyzerDirectiveSpecContext analyzerDirectiveSpec(int i) {
			return getRuleContext(AnalyzerDirectiveSpecContext.class,i);
		}
		public List<RuleSpecContext> ruleSpec() {
			return getRuleContexts(RuleSpecContext.class);
		}
		public RuleSpecContext ruleSpec(int i) {
			return getRuleContext(RuleSpecContext.class,i);
		}
		public List<ModeSpecContext> modeSpec() {
			return getRuleContexts(ModeSpecContext.class);
		}
		public ModeSpecContext modeSpec(int i) {
			return getRuleContext(ModeSpecContext.class,i);
		}
		public GrammarFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grammarFile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterGrammarFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitGrammarFile(this);
		}
	}

	public final GrammarFileContext grammarFile() throws RecognitionException {
		GrammarFileContext _localctx = new GrammarFileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_grammarFile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			grammarSpec();
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPTIONS) | (1L << TOKENS) | (1L << CHANNELS) | (1L << IMPORT) | (1L << AT))) != 0)) {
				{
				{
				setState(161);
				analyzerDirectiveSpec();
				}
				}
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID_STARTING_WITH_UPPERCASE) | (1L << ID_STARTING_WITH_LOWERCASE) | (1L << DOC_COMMENT) | (1L << FRAGMENT) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << PRIVATE))) != 0)) {
				{
				{
				setState(167);
				ruleSpec();
				}
				}
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MODE) {
				{
				{
				setState(173);
				modeSpec();
				}
				}
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(179);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GrammarSpecContext extends ParserRuleContext {
		public GrammarTypeContext grammarType() {
			return getRuleContext(GrammarTypeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ANTLRv4Parser.SEMI, 0); }
		public List<TerminalNode> DOC_COMMENT() { return getTokens(ANTLRv4Parser.DOC_COMMENT); }
		public TerminalNode DOC_COMMENT(int i) {
			return getToken(ANTLRv4Parser.DOC_COMMENT, i);
		}
		public GrammarSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grammarSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterGrammarSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitGrammarSpec(this);
		}
	}

	public final GrammarSpecContext grammarSpec() throws RecognitionException {
		GrammarSpecContext _localctx = new GrammarSpecContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_grammarSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOC_COMMENT) {
				{
				{
				setState(181);
				match(DOC_COMMENT);
				}
				}
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(187);
			grammarType();
			setState(188);
			identifier();
			setState(189);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GrammarTypeContext extends ParserRuleContext {
		public TerminalNode LEXER() { return getToken(ANTLRv4Parser.LEXER, 0); }
		public TerminalNode GRAMMAR() { return getToken(ANTLRv4Parser.GRAMMAR, 0); }
		public TerminalNode PARSER() { return getToken(ANTLRv4Parser.PARSER, 0); }
		public GrammarTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grammarType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterGrammarType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitGrammarType(this);
		}
	}

	public final GrammarTypeContext grammarType() throws RecognitionException {
		GrammarTypeContext _localctx = new GrammarTypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_grammarType);
		try {
			setState(196);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEXER:
				enterOuterAlt(_localctx, 1);
				{
				setState(191);
				match(LEXER);
				setState(192);
				match(GRAMMAR);
				}
				break;
			case PARSER:
				enterOuterAlt(_localctx, 2);
				{
				setState(193);
				match(PARSER);
				setState(194);
				match(GRAMMAR);
				}
				break;
			case GRAMMAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(195);
				match(GRAMMAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnalyzerDirectiveSpecContext extends ParserRuleContext {
		public OptionsSpecContext optionsSpec() {
			return getRuleContext(OptionsSpecContext.class,0);
		}
		public DelegateGrammarsContext delegateGrammars() {
			return getRuleContext(DelegateGrammarsContext.class,0);
		}
		public TokensSpecContext tokensSpec() {
			return getRuleContext(TokensSpecContext.class,0);
		}
		public ChannelsSpecContext channelsSpec() {
			return getRuleContext(ChannelsSpecContext.class,0);
		}
		public ActionContext action() {
			return getRuleContext(ActionContext.class,0);
		}
		public AnalyzerDirectiveSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_analyzerDirectiveSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterAnalyzerDirectiveSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitAnalyzerDirectiveSpec(this);
		}
	}

	public final AnalyzerDirectiveSpecContext analyzerDirectiveSpec() throws RecognitionException {
		AnalyzerDirectiveSpecContext _localctx = new AnalyzerDirectiveSpecContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_analyzerDirectiveSpec);
		try {
			setState(203);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPTIONS:
				enterOuterAlt(_localctx, 1);
				{
				setState(198);
				optionsSpec();
				}
				break;
			case IMPORT:
				enterOuterAlt(_localctx, 2);
				{
				setState(199);
				delegateGrammars();
				}
				break;
			case TOKENS:
				enterOuterAlt(_localctx, 3);
				{
				setState(200);
				tokensSpec();
				}
				break;
			case CHANNELS:
				enterOuterAlt(_localctx, 4);
				{
				setState(201);
				channelsSpec();
				}
				break;
			case AT:
				enterOuterAlt(_localctx, 5);
				{
				setState(202);
				action();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OptionsSpecContext extends ParserRuleContext {
		public TerminalNode OPTIONS() { return getToken(ANTLRv4Parser.OPTIONS, 0); }
		public TerminalNode LBRACE() { return getToken(ANTLRv4Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ANTLRv4Parser.RBRACE, 0); }
		public List<OptionSpecContext> optionSpec() {
			return getRuleContexts(OptionSpecContext.class);
		}
		public OptionSpecContext optionSpec(int i) {
			return getRuleContext(OptionSpecContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(ANTLRv4Parser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(ANTLRv4Parser.SEMI, i);
		}
		public OptionsSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optionsSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterOptionsSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitOptionsSpec(this);
		}
	}

	public final OptionsSpecContext optionsSpec() throws RecognitionException {
		OptionsSpecContext _localctx = new OptionsSpecContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_optionsSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(OPTIONS);
			setState(206);
			match(LBRACE);
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & ((1L << (SUPER_CLASS - 79)) | (1L << (LANGUAGE - 79)) | (1L << (TOKEN_VOCAB - 79)) | (1L << (TOKEN_LABEL_TYPE - 79)))) != 0)) {
				{
				{
				setState(207);
				optionSpec();
				setState(208);
				match(SEMI);
				}
				}
				setState(214);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(215);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OptionSpecContext extends ParserRuleContext {
		public SuperClassSpecContext superClassSpec() {
			return getRuleContext(SuperClassSpecContext.class,0);
		}
		public LanguageSpecContext languageSpec() {
			return getRuleContext(LanguageSpecContext.class,0);
		}
		public TokenVocabSpecContext tokenVocabSpec() {
			return getRuleContext(TokenVocabSpecContext.class,0);
		}
		public TokenLabelTypeSpecContext tokenLabelTypeSpec() {
			return getRuleContext(TokenLabelTypeSpecContext.class,0);
		}
		public OptionSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optionSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterOptionSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitOptionSpec(this);
		}
	}

	public final OptionSpecContext optionSpec() throws RecognitionException {
		OptionSpecContext _localctx = new OptionSpecContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_optionSpec);
		try {
			setState(221);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SUPER_CLASS:
				enterOuterAlt(_localctx, 1);
				{
				setState(217);
				superClassSpec();
				}
				break;
			case LANGUAGE:
				enterOuterAlt(_localctx, 2);
				{
				setState(218);
				languageSpec();
				}
				break;
			case TOKEN_VOCAB:
				enterOuterAlt(_localctx, 3);
				{
				setState(219);
				tokenVocabSpec();
				}
				break;
			case TOKEN_LABEL_TYPE:
				enterOuterAlt(_localctx, 4);
				{
				setState(220);
				tokenLabelTypeSpec();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SuperClassSpecContext extends ParserRuleContext {
		public TerminalNode SUPER_CLASS() { return getToken(ANTLRv4Parser.SUPER_CLASS, 0); }
		public TerminalNode ASSIGN() { return getToken(ANTLRv4Parser.ASSIGN, 0); }
		public ClassIdentifierContext classIdentifier() {
			return getRuleContext(ClassIdentifierContext.class,0);
		}
		public SuperClassSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_superClassSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterSuperClassSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitSuperClassSpec(this);
		}
	}

	public final SuperClassSpecContext superClassSpec() throws RecognitionException {
		SuperClassSpecContext _localctx = new SuperClassSpecContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_superClassSpec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(SUPER_CLASS);
			setState(224);
			match(ASSIGN);
			setState(225);
			classIdentifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LanguageSpecContext extends ParserRuleContext {
		public TerminalNode LANGUAGE() { return getToken(ANTLRv4Parser.LANGUAGE, 0); }
		public TerminalNode ASSIGN() { return getToken(ANTLRv4Parser.ASSIGN, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(ANTLRv4Parser.STRING_LITERAL, 0); }
		public LanguageSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_languageSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterLanguageSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitLanguageSpec(this);
		}
	}

	public final LanguageSpecContext languageSpec() throws RecognitionException {
		LanguageSpecContext _localctx = new LanguageSpecContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_languageSpec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(LANGUAGE);
			setState(228);
			match(ASSIGN);
			setState(229);
			match(STRING_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TokenVocabSpecContext extends ParserRuleContext {
		public TerminalNode TOKEN_VOCAB() { return getToken(ANTLRv4Parser.TOKEN_VOCAB, 0); }
		public TerminalNode ASSIGN() { return getToken(ANTLRv4Parser.ASSIGN, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TokenVocabSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tokenVocabSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterTokenVocabSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitTokenVocabSpec(this);
		}
	}

	public final TokenVocabSpecContext tokenVocabSpec() throws RecognitionException {
		TokenVocabSpecContext _localctx = new TokenVocabSpecContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_tokenVocabSpec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(TOKEN_VOCAB);
			setState(232);
			match(ASSIGN);
			setState(233);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TokenLabelTypeSpecContext extends ParserRuleContext {
		public TerminalNode TOKEN_LABEL_TYPE() { return getToken(ANTLRv4Parser.TOKEN_LABEL_TYPE, 0); }
		public TerminalNode ASSIGN() { return getToken(ANTLRv4Parser.ASSIGN, 0); }
		public ClassIdentifierContext classIdentifier() {
			return getRuleContext(ClassIdentifierContext.class,0);
		}
		public TokenLabelTypeSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tokenLabelTypeSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterTokenLabelTypeSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitTokenLabelTypeSpec(this);
		}
	}

	public final TokenLabelTypeSpecContext tokenLabelTypeSpec() throws RecognitionException {
		TokenLabelTypeSpecContext _localctx = new TokenLabelTypeSpecContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_tokenLabelTypeSpec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			match(TOKEN_LABEL_TYPE);
			setState(236);
			match(ASSIGN);
			setState(237);
			classIdentifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DelegateGrammarsContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(ANTLRv4Parser.IMPORT, 0); }
		public List<DelegateGrammarContext> delegateGrammar() {
			return getRuleContexts(DelegateGrammarContext.class);
		}
		public DelegateGrammarContext delegateGrammar(int i) {
			return getRuleContext(DelegateGrammarContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(ANTLRv4Parser.SEMI, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ANTLRv4Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ANTLRv4Parser.COMMA, i);
		}
		public DelegateGrammarsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delegateGrammars; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterDelegateGrammars(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitDelegateGrammars(this);
		}
	}

	public final DelegateGrammarsContext delegateGrammars() throws RecognitionException {
		DelegateGrammarsContext _localctx = new DelegateGrammarsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_delegateGrammars);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			match(IMPORT);
			setState(240);
			delegateGrammar();
			setState(245);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(241);
				match(COMMA);
				setState(242);
				delegateGrammar();
				}
				}
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(248);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DelegateGrammarContext extends ParserRuleContext {
		public GrammarIdentifierContext grammarIdentifier() {
			return getRuleContext(GrammarIdentifierContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(ANTLRv4Parser.ASSIGN, 0); }
		public DelegateGrammarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delegateGrammar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterDelegateGrammar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitDelegateGrammar(this);
		}
	}

	public final DelegateGrammarContext delegateGrammar() throws RecognitionException {
		DelegateGrammarContext _localctx = new DelegateGrammarContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_delegateGrammar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(250);
				identifier();
				setState(251);
				match(ASSIGN);
				}
				break;
			}
			setState(255);
			grammarIdentifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GrammarIdentifierContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public GrammarIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grammarIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterGrammarIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitGrammarIdentifier(this);
		}
	}

	public final GrammarIdentifierContext grammarIdentifier() throws RecognitionException {
		GrammarIdentifierContext _localctx = new GrammarIdentifierContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_grammarIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TokensSpecContext extends ParserRuleContext {
		public TerminalNode TOKENS() { return getToken(ANTLRv4Parser.TOKENS, 0); }
		public TerminalNode LBRACE() { return getToken(ANTLRv4Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ANTLRv4Parser.RBRACE, 0); }
		public TokenListContext tokenList() {
			return getRuleContext(TokenListContext.class,0);
		}
		public TokensSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tokensSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterTokensSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitTokensSpec(this);
		}
	}

	public final TokensSpecContext tokensSpec() throws RecognitionException {
		TokensSpecContext _localctx = new TokensSpecContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_tokensSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			match(TOKENS);
			setState(260);
			match(LBRACE);
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID_STARTING_WITH_UPPERCASE) {
				{
				setState(261);
				tokenList();
				}
			}

			setState(264);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TokenListContext extends ParserRuleContext {
		public List<TokenIdentifierContext> tokenIdentifier() {
			return getRuleContexts(TokenIdentifierContext.class);
		}
		public TokenIdentifierContext tokenIdentifier(int i) {
			return getRuleContext(TokenIdentifierContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ANTLRv4Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ANTLRv4Parser.COMMA, i);
		}
		public TokenListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tokenList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterTokenList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitTokenList(this);
		}
	}

	public final TokenListContext tokenList() throws RecognitionException {
		TokenListContext _localctx = new TokenListContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_tokenList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			tokenIdentifier();
			setState(271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(267);
				match(COMMA);
				setState(268);
				tokenIdentifier();
				}
				}
				setState(273);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ChannelsSpecContext extends ParserRuleContext {
		public TerminalNode CHANNELS() { return getToken(ANTLRv4Parser.CHANNELS, 0); }
		public TerminalNode LBRACE() { return getToken(ANTLRv4Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ANTLRv4Parser.RBRACE, 0); }
		public IdListContext idList() {
			return getRuleContext(IdListContext.class,0);
		}
		public ChannelsSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_channelsSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterChannelsSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitChannelsSpec(this);
		}
	}

	public final ChannelsSpecContext channelsSpec() throws RecognitionException {
		ChannelsSpecContext _localctx = new ChannelsSpecContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_channelsSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			match(CHANNELS);
			setState(275);
			match(LBRACE);
			setState(277);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(276);
				idList();
				}
			}

			setState(279);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdListContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ANTLRv4Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ANTLRv4Parser.COMMA, i);
		}
		public IdListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterIdList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitIdList(this);
		}
	}

	public final IdListContext idList() throws RecognitionException {
		IdListContext _localctx = new IdListContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_idList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			identifier();
			setState(286);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(282);
					match(COMMA);
					setState(283);
					identifier();
					}
					} 
				}
				setState(288);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			setState(290);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(289);
				match(COMMA);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ActionContext extends ParserRuleContext {
		public HeaderActionContext headerAction() {
			return getRuleContext(HeaderActionContext.class,0);
		}
		public MemberActionContext memberAction() {
			return getRuleContext(MemberActionContext.class,0);
		}
		public ActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitAction(this);
		}
	}

	public final ActionContext action() throws RecognitionException {
		ActionContext _localctx = new ActionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_action);
		try {
			setState(294);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(292);
				headerAction();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(293);
				memberAction();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HeaderActionContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(ANTLRv4Parser.AT, 0); }
		public TerminalNode HEADER() { return getToken(ANTLRv4Parser.HEADER, 0); }
		public HeaderActionBlockContext headerActionBlock() {
			return getRuleContext(HeaderActionBlockContext.class,0);
		}
		public ActionDestinationContext actionDestination() {
			return getRuleContext(ActionDestinationContext.class,0);
		}
		public TerminalNode COLONCOLON() { return getToken(ANTLRv4Parser.COLONCOLON, 0); }
		public HeaderActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_headerAction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterHeaderAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitHeaderAction(this);
		}
	}

	public final HeaderActionContext headerAction() throws RecognitionException {
		HeaderActionContext _localctx = new HeaderActionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_headerAction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			match(AT);
			setState(300);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LEXER || _la==PARSER) {
				{
				setState(297);
				actionDestination();
				setState(298);
				match(COLONCOLON);
				}
			}

			setState(302);
			match(HEADER);
			setState(303);
			headerActionBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MemberActionContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(ANTLRv4Parser.AT, 0); }
		public TerminalNode MEMBERS() { return getToken(ANTLRv4Parser.MEMBERS, 0); }
		public ActionBlockContext actionBlock() {
			return getRuleContext(ActionBlockContext.class,0);
		}
		public ActionDestinationContext actionDestination() {
			return getRuleContext(ActionDestinationContext.class,0);
		}
		public TerminalNode COLONCOLON() { return getToken(ANTLRv4Parser.COLONCOLON, 0); }
		public MemberActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberAction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterMemberAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitMemberAction(this);
		}
	}

	public final MemberActionContext memberAction() throws RecognitionException {
		MemberActionContext _localctx = new MemberActionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_memberAction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			match(AT);
			setState(309);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LEXER || _la==PARSER) {
				{
				setState(306);
				actionDestination();
				setState(307);
				match(COLONCOLON);
				}
			}

			setState(311);
			match(MEMBERS);
			setState(312);
			actionBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ActionDestinationContext extends ParserRuleContext {
		public TerminalNode LEXER() { return getToken(ANTLRv4Parser.LEXER, 0); }
		public TerminalNode PARSER() { return getToken(ANTLRv4Parser.PARSER, 0); }
		public ActionDestinationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actionDestination; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterActionDestination(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitActionDestination(this);
		}
	}

	public final ActionDestinationContext actionDestination() throws RecognitionException {
		ActionDestinationContext _localctx = new ActionDestinationContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_actionDestination);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			_la = _input.LA(1);
			if ( !(_la==LEXER || _la==PARSER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HeaderActionBlockContext extends ParserRuleContext {
		public TerminalNode BEGIN_ACTION() { return getToken(ANTLRv4Parser.BEGIN_ACTION, 0); }
		public HeaderActionContentContext headerActionContent() {
			return getRuleContext(HeaderActionContentContext.class,0);
		}
		public TerminalNode END_ACTION() { return getToken(ANTLRv4Parser.END_ACTION, 0); }
		public HeaderActionBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_headerActionBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterHeaderActionBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitHeaderActionBlock(this);
		}
	}

	public final HeaderActionBlockContext headerActionBlock() throws RecognitionException {
		HeaderActionBlockContext _localctx = new HeaderActionBlockContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_headerActionBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
			match(BEGIN_ACTION);
			setState(317);
			headerActionContent();
			setState(318);
			match(END_ACTION);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HeaderActionContentContext extends ParserRuleContext {
		public List<TerminalNode> ACTION_CONTENT() { return getTokens(ANTLRv4Parser.ACTION_CONTENT); }
		public TerminalNode ACTION_CONTENT(int i) {
			return getToken(ANTLRv4Parser.ACTION_CONTENT, i);
		}
		public PackageDeclarationContext packageDeclaration() {
			return getRuleContext(PackageDeclarationContext.class,0);
		}
		public List<ImportDeclarationContext> importDeclaration() {
			return getRuleContexts(ImportDeclarationContext.class);
		}
		public ImportDeclarationContext importDeclaration(int i) {
			return getRuleContext(ImportDeclarationContext.class,i);
		}
		public HeaderActionContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_headerActionContent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterHeaderActionContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitHeaderActionContent(this);
		}
	}

	public final HeaderActionContentContext headerActionContent() throws RecognitionException {
		HeaderActionContentContext _localctx = new HeaderActionContentContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_headerActionContent);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(320);
					match(ACTION_CONTENT);
					}
					} 
				}
				setState(325);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			setState(327);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HEADER_PACKAGE) {
				{
				setState(326);
				packageDeclaration();
				}
			}

			setState(332);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ACTION_CONTENT) {
				{
				{
				setState(329);
				match(ACTION_CONTENT);
				}
				}
				setState(334);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(344);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==HEADER_IMPORT) {
				{
				{
				setState(335);
				importDeclaration();
				setState(339);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ACTION_CONTENT) {
					{
					{
					setState(336);
					match(ACTION_CONTENT);
					}
					}
					setState(341);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(346);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PackageDeclarationContext extends ParserRuleContext {
		public TerminalNode HEADER_PACKAGE() { return getToken(ANTLRv4Parser.HEADER_PACKAGE, 0); }
		public PackageIdentifierContext packageIdentifier() {
			return getRuleContext(PackageIdentifierContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ANTLRv4Parser.SEMI, 0); }
		public PackageDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterPackageDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitPackageDeclaration(this);
		}
	}

	public final PackageDeclarationContext packageDeclaration() throws RecognitionException {
		PackageDeclarationContext _localctx = new PackageDeclarationContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_packageDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(347);
			match(HEADER_PACKAGE);
			setState(348);
			packageIdentifier();
			setState(349);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImportDeclarationContext extends ParserRuleContext {
		public SingleTypeImportDeclarationContext singleTypeImportDeclaration() {
			return getRuleContext(SingleTypeImportDeclarationContext.class,0);
		}
		public ImportDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterImportDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitImportDeclaration(this);
		}
	}

	public final ImportDeclarationContext importDeclaration() throws RecognitionException {
		ImportDeclarationContext _localctx = new ImportDeclarationContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_importDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(351);
			singleTypeImportDeclaration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleTypeImportDeclarationContext extends ParserRuleContext {
		public TerminalNode HEADER_IMPORT() { return getToken(ANTLRv4Parser.HEADER_IMPORT, 0); }
		public TerminalNode SEMI() { return getToken(ANTLRv4Parser.SEMI, 0); }
		public ClassIdentifierContext classIdentifier() {
			return getRuleContext(ClassIdentifierContext.class,0);
		}
		public GenericClassIdentifierContext genericClassIdentifier() {
			return getRuleContext(GenericClassIdentifierContext.class,0);
		}
		public TerminalNode HEADER_STATIC() { return getToken(ANTLRv4Parser.HEADER_STATIC, 0); }
		public SingleTypeImportDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleTypeImportDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterSingleTypeImportDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitSingleTypeImportDeclaration(this);
		}
	}

	public final SingleTypeImportDeclarationContext singleTypeImportDeclaration() throws RecognitionException {
		SingleTypeImportDeclarationContext _localctx = new SingleTypeImportDeclarationContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_singleTypeImportDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			match(HEADER_IMPORT);
			setState(355);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HEADER_STATIC) {
				{
				setState(354);
				match(HEADER_STATIC);
				}
			}

			setState(359);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(357);
				classIdentifier();
				}
				break;
			case 2:
				{
				setState(358);
				genericClassIdentifier();
				}
				break;
			}
			setState(361);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ActionBlockContext extends ParserRuleContext {
		public TerminalNode BEGIN_ACTION() { return getToken(ANTLRv4Parser.BEGIN_ACTION, 0); }
		public TerminalNode END_ACTION() { return getToken(ANTLRv4Parser.END_ACTION, 0); }
		public List<TerminalNode> ACTION_CONTENT() { return getTokens(ANTLRv4Parser.ACTION_CONTENT); }
		public TerminalNode ACTION_CONTENT(int i) {
			return getToken(ANTLRv4Parser.ACTION_CONTENT, i);
		}
		public ActionBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actionBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterActionBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitActionBlock(this);
		}
	}

	public final ActionBlockContext actionBlock() throws RecognitionException {
		ActionBlockContext _localctx = new ActionBlockContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_actionBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363);
			match(BEGIN_ACTION);
			setState(367);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ACTION_CONTENT) {
				{
				{
				setState(364);
				match(ACTION_CONTENT);
				}
				}
				setState(369);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(370);
			match(END_ACTION);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModeSpecContext extends ParserRuleContext {
		public TerminalNode MODE() { return getToken(ANTLRv4Parser.MODE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ANTLRv4Parser.SEMI, 0); }
		public List<LexerRuleSpecContext> lexerRuleSpec() {
			return getRuleContexts(LexerRuleSpecContext.class);
		}
		public LexerRuleSpecContext lexerRuleSpec(int i) {
			return getRuleContext(LexerRuleSpecContext.class,i);
		}
		public ModeSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modeSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterModeSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitModeSpec(this);
		}
	}

	public final ModeSpecContext modeSpec() throws RecognitionException {
		ModeSpecContext _localctx = new ModeSpecContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_modeSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			match(MODE);
			setState(373);
			identifier();
			setState(374);
			match(SEMI);
			setState(378);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID_STARTING_WITH_UPPERCASE) | (1L << DOC_COMMENT) | (1L << FRAGMENT))) != 0)) {
				{
				{
				setState(375);
				lexerRuleSpec();
				}
				}
				setState(380);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RuleSpecContext extends ParserRuleContext {
		public ParserRuleSpecContext parserRuleSpec() {
			return getRuleContext(ParserRuleSpecContext.class,0);
		}
		public LexerRuleSpecContext lexerRuleSpec() {
			return getRuleContext(LexerRuleSpecContext.class,0);
		}
		public RuleSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterRuleSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitRuleSpec(this);
		}
	}

	public final RuleSpecContext ruleSpec() throws RecognitionException {
		RuleSpecContext _localctx = new RuleSpecContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_ruleSpec);
		try {
			setState(383);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(381);
				parserRuleSpec();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(382);
				lexerRuleSpec();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParserRuleSpecContext extends ParserRuleContext {
		public ParserRuleDeclarationContext parserRuleDeclaration() {
			return getRuleContext(ParserRuleDeclarationContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ANTLRv4Parser.COLON, 0); }
		public ParserRuleDefinitionContext parserRuleDefinition() {
			return getRuleContext(ParserRuleDefinitionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ANTLRv4Parser.SEMI, 0); }
		public ExceptionGroupContext exceptionGroup() {
			return getRuleContext(ExceptionGroupContext.class,0);
		}
		public List<TerminalNode> DOC_COMMENT() { return getTokens(ANTLRv4Parser.DOC_COMMENT); }
		public TerminalNode DOC_COMMENT(int i) {
			return getToken(ANTLRv4Parser.DOC_COMMENT, i);
		}
		public ParserRuleSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parserRuleSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterParserRuleSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitParserRuleSpec(this);
		}
	}

	public final ParserRuleSpecContext parserRuleSpec() throws RecognitionException {
		ParserRuleSpecContext _localctx = new ParserRuleSpecContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_parserRuleSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(388);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOC_COMMENT) {
				{
				{
				setState(385);
				match(DOC_COMMENT);
				}
				}
				setState(390);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(391);
			parserRuleDeclaration();
			setState(392);
			match(COLON);
			setState(393);
			parserRuleDefinition();
			setState(394);
			match(SEMI);
			setState(395);
			exceptionGroup();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParserRuleDeclarationContext extends ParserRuleContext {
		public ParserRuleIdentifierContext parserRuleIdentifier() {
			return getRuleContext(ParserRuleIdentifierContext.class,0);
		}
		public ParserRuleVisibilityContext parserRuleVisibility() {
			return getRuleContext(ParserRuleVisibilityContext.class,0);
		}
		public ActionBlockArgumentsContext actionBlockArguments() {
			return getRuleContext(ActionBlockArgumentsContext.class,0);
		}
		public ParserRuleReturnsContext parserRuleReturns() {
			return getRuleContext(ParserRuleReturnsContext.class,0);
		}
		public ThrowsSpecContext throwsSpec() {
			return getRuleContext(ThrowsSpecContext.class,0);
		}
		public LocalsSpecContext localsSpec() {
			return getRuleContext(LocalsSpecContext.class,0);
		}
		public List<ParserRulePrequelContext> parserRulePrequel() {
			return getRuleContexts(ParserRulePrequelContext.class);
		}
		public ParserRulePrequelContext parserRulePrequel(int i) {
			return getRuleContext(ParserRulePrequelContext.class,i);
		}
		public ParserRuleDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parserRuleDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterParserRuleDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitParserRuleDeclaration(this);
		}
	}

	public final ParserRuleDeclarationContext parserRuleDeclaration() throws RecognitionException {
		ParserRuleDeclarationContext _localctx = new ParserRuleDeclarationContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_parserRuleDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(398);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PROTECTED) | (1L << PUBLIC) | (1L << PRIVATE))) != 0)) {
				{
				setState(397);
				parserRuleVisibility();
				}
			}

			setState(400);
			parserRuleIdentifier();
			setState(402);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BEGIN_ARGUMENT) {
				{
				setState(401);
				actionBlockArguments();
				}
			}

			setState(405);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RETURNS) {
				{
				setState(404);
				parserRuleReturns();
				}
			}

			setState(408);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==THROWS) {
				{
				setState(407);
				throwsSpec();
				}
			}

			setState(411);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LOCALS) {
				{
				setState(410);
				localsSpec();
				}
			}

			setState(416);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OPTIONS || _la==AT) {
				{
				{
				setState(413);
				parserRulePrequel();
				}
				}
				setState(418);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExceptionGroupContext extends ParserRuleContext {
		public List<ExceptionHandlerContext> exceptionHandler() {
			return getRuleContexts(ExceptionHandlerContext.class);
		}
		public ExceptionHandlerContext exceptionHandler(int i) {
			return getRuleContext(ExceptionHandlerContext.class,i);
		}
		public FinallyClauseContext finallyClause() {
			return getRuleContext(FinallyClauseContext.class,0);
		}
		public ExceptionGroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exceptionGroup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterExceptionGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitExceptionGroup(this);
		}
	}

	public final ExceptionGroupContext exceptionGroup() throws RecognitionException {
		ExceptionGroupContext _localctx = new ExceptionGroupContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_exceptionGroup);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(422);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CATCH) {
				{
				{
				setState(419);
				exceptionHandler();
				}
				}
				setState(424);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(426);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FINALLY) {
				{
				setState(425);
				finallyClause();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExceptionHandlerContext extends ParserRuleContext {
		public TerminalNode CATCH() { return getToken(ANTLRv4Parser.CATCH, 0); }
		public ActionBlockArgumentsContext actionBlockArguments() {
			return getRuleContext(ActionBlockArgumentsContext.class,0);
		}
		public ActionBlockContext actionBlock() {
			return getRuleContext(ActionBlockContext.class,0);
		}
		public ExceptionHandlerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exceptionHandler; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterExceptionHandler(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitExceptionHandler(this);
		}
	}

	public final ExceptionHandlerContext exceptionHandler() throws RecognitionException {
		ExceptionHandlerContext _localctx = new ExceptionHandlerContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_exceptionHandler);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(428);
			match(CATCH);
			setState(429);
			actionBlockArguments();
			setState(430);
			actionBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FinallyClauseContext extends ParserRuleContext {
		public TerminalNode FINALLY() { return getToken(ANTLRv4Parser.FINALLY, 0); }
		public ActionBlockContext actionBlock() {
			return getRuleContext(ActionBlockContext.class,0);
		}
		public FinallyClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finallyClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterFinallyClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitFinallyClause(this);
		}
	}

	public final FinallyClauseContext finallyClause() throws RecognitionException {
		FinallyClauseContext _localctx = new FinallyClauseContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_finallyClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(432);
			match(FINALLY);
			setState(433);
			actionBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParserRulePrequelContext extends ParserRuleContext {
		public OptionsSpecContext optionsSpec() {
			return getRuleContext(OptionsSpecContext.class,0);
		}
		public RuleActionContext ruleAction() {
			return getRuleContext(RuleActionContext.class,0);
		}
		public ParserRulePrequelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parserRulePrequel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterParserRulePrequel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitParserRulePrequel(this);
		}
	}

	public final ParserRulePrequelContext parserRulePrequel() throws RecognitionException {
		ParserRulePrequelContext _localctx = new ParserRulePrequelContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_parserRulePrequel);
		try {
			setState(437);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPTIONS:
				enterOuterAlt(_localctx, 1);
				{
				setState(435);
				optionsSpec();
				}
				break;
			case AT:
				enterOuterAlt(_localctx, 2);
				{
				setState(436);
				ruleAction();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParserRuleReturnsContext extends ParserRuleContext {
		public TerminalNode RETURNS() { return getToken(ANTLRv4Parser.RETURNS, 0); }
		public ActionBlockArgumentsContext actionBlockArguments() {
			return getRuleContext(ActionBlockArgumentsContext.class,0);
		}
		public ParserRuleReturnsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parserRuleReturns; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterParserRuleReturns(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitParserRuleReturns(this);
		}
	}

	public final ParserRuleReturnsContext parserRuleReturns() throws RecognitionException {
		ParserRuleReturnsContext _localctx = new ParserRuleReturnsContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_parserRuleReturns);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(439);
			match(RETURNS);
			setState(440);
			actionBlockArguments();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ThrowsSpecContext extends ParserRuleContext {
		public TerminalNode THROWS() { return getToken(ANTLRv4Parser.THROWS, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ANTLRv4Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ANTLRv4Parser.COMMA, i);
		}
		public ThrowsSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_throwsSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterThrowsSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitThrowsSpec(this);
		}
	}

	public final ThrowsSpecContext throwsSpec() throws RecognitionException {
		ThrowsSpecContext _localctx = new ThrowsSpecContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_throwsSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(442);
			match(THROWS);
			setState(443);
			identifier();
			setState(448);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(444);
				match(COMMA);
				setState(445);
				identifier();
				}
				}
				setState(450);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocalsSpecContext extends ParserRuleContext {
		public TerminalNode LOCALS() { return getToken(ANTLRv4Parser.LOCALS, 0); }
		public ActionBlockArgumentsContext actionBlockArguments() {
			return getRuleContext(ActionBlockArgumentsContext.class,0);
		}
		public LocalsSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localsSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterLocalsSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitLocalsSpec(this);
		}
	}

	public final LocalsSpecContext localsSpec() throws RecognitionException {
		LocalsSpecContext _localctx = new LocalsSpecContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_localsSpec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(451);
			match(LOCALS);
			setState(452);
			actionBlockArguments();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RuleActionContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(ANTLRv4Parser.AT, 0); }
		public ActionBlockContext actionBlock() {
			return getRuleContext(ActionBlockContext.class,0);
		}
		public TerminalNode INIT() { return getToken(ANTLRv4Parser.INIT, 0); }
		public TerminalNode AFTER() { return getToken(ANTLRv4Parser.AFTER, 0); }
		public RuleActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleAction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterRuleAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitRuleAction(this);
		}
	}

	public final RuleActionContext ruleAction() throws RecognitionException {
		RuleActionContext _localctx = new RuleActionContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_ruleAction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(454);
			match(AT);
			setState(455);
			_la = _input.LA(1);
			if ( !(_la==INIT || _la==AFTER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(456);
			actionBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParserRuleVisibilityContext extends ParserRuleContext {
		public TerminalNode PUBLIC() { return getToken(ANTLRv4Parser.PUBLIC, 0); }
		public TerminalNode PRIVATE() { return getToken(ANTLRv4Parser.PRIVATE, 0); }
		public TerminalNode PROTECTED() { return getToken(ANTLRv4Parser.PROTECTED, 0); }
		public ParserRuleVisibilityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parserRuleVisibility; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterParserRuleVisibility(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitParserRuleVisibility(this);
		}
	}

	public final ParserRuleVisibilityContext parserRuleVisibility() throws RecognitionException {
		ParserRuleVisibilityContext _localctx = new ParserRuleVisibilityContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_parserRuleVisibility);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(458);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PROTECTED) | (1L << PUBLIC) | (1L << PRIVATE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParserRuleDefinitionContext extends ParserRuleContext {
		public List<ParserRuleLabeledAlternativeContext> parserRuleLabeledAlternative() {
			return getRuleContexts(ParserRuleLabeledAlternativeContext.class);
		}
		public ParserRuleLabeledAlternativeContext parserRuleLabeledAlternative(int i) {
			return getRuleContext(ParserRuleLabeledAlternativeContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(ANTLRv4Parser.OR); }
		public TerminalNode OR(int i) {
			return getToken(ANTLRv4Parser.OR, i);
		}
		public ParserRuleDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parserRuleDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterParserRuleDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitParserRuleDefinition(this);
		}
	}

	public final ParserRuleDefinitionContext parserRuleDefinition() throws RecognitionException {
		ParserRuleDefinitionContext _localctx = new ParserRuleDefinitionContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_parserRuleDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(460);
			parserRuleLabeledAlternative();
			setState(465);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(461);
				match(OR);
				setState(462);
				parserRuleLabeledAlternative();
				}
				}
				setState(467);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParserRuleLabeledAlternativeContext extends ParserRuleContext {
		public ParserRuleAlternativeContext parserRuleAlternative() {
			return getRuleContext(ParserRuleAlternativeContext.class,0);
		}
		public TerminalNode SHARP() { return getToken(ANTLRv4Parser.SHARP, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ParserRuleLabeledAlternativeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parserRuleLabeledAlternative; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterParserRuleLabeledAlternative(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitParserRuleLabeledAlternative(this);
		}
	}

	public final ParserRuleLabeledAlternativeContext parserRuleLabeledAlternative() throws RecognitionException {
		ParserRuleLabeledAlternativeContext _localctx = new ParserRuleLabeledAlternativeContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_parserRuleLabeledAlternative);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(468);
			parserRuleAlternative();
			setState(471);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SHARP) {
				{
				setState(469);
				match(SHARP);
				setState(470);
				identifier();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AltListContext extends ParserRuleContext {
		public List<ParserRuleAlternativeContext> parserRuleAlternative() {
			return getRuleContexts(ParserRuleAlternativeContext.class);
		}
		public ParserRuleAlternativeContext parserRuleAlternative(int i) {
			return getRuleContext(ParserRuleAlternativeContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(ANTLRv4Parser.OR); }
		public TerminalNode OR(int i) {
			return getToken(ANTLRv4Parser.OR, i);
		}
		public AltListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_altList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterAltList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitAltList(this);
		}
	}

	public final AltListContext altList() throws RecognitionException {
		AltListContext _localctx = new AltListContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_altList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(473);
			parserRuleAlternative();
			setState(478);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(474);
				match(OR);
				setState(475);
				parserRuleAlternative();
				}
				}
				setState(480);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParserRuleAlternativeContext extends ParserRuleContext {
		public List<ParserRuleElementContext> parserRuleElement() {
			return getRuleContexts(ParserRuleElementContext.class);
		}
		public ParserRuleElementContext parserRuleElement(int i) {
			return getRuleContext(ParserRuleElementContext.class,i);
		}
		public ParserRuleAlternativeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parserRuleAlternative; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterParserRuleAlternative(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitParserRuleAlternative(this);
		}
	}

	public final ParserRuleAlternativeContext parserRuleAlternative() throws RecognitionException {
		ParserRuleAlternativeContext _localctx = new ParserRuleAlternativeContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_parserRuleAlternative);
		int _la;
		try {
			setState(487);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID_STARTING_WITH_UPPERCASE:
			case ID_STARTING_WITH_LOWERCASE:
			case STRING_LITERAL:
			case BEGIN_ACTION:
			case LPAREN:
			case DOT:
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(482); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(481);
					parserRuleElement();
					}
					}
					setState(484); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID_STARTING_WITH_UPPERCASE) | (1L << ID_STARTING_WITH_LOWERCASE) | (1L << STRING_LITERAL) | (1L << BEGIN_ACTION) | (1L << LPAREN) | (1L << DOT) | (1L << NOT))) != 0) );
				}
				break;
			case SEMI:
			case RPAREN:
			case OR:
			case SHARP:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParserRuleElementContext extends ParserRuleContext {
		public LabeledParserRuleElementContext labeledParserRuleElement() {
			return getRuleContext(LabeledParserRuleElementContext.class,0);
		}
		public EbnfSuffixContext ebnfSuffix() {
			return getRuleContext(EbnfSuffixContext.class,0);
		}
		public ParserRuleAtomContext parserRuleAtom() {
			return getRuleContext(ParserRuleAtomContext.class,0);
		}
		public EbnfContext ebnf() {
			return getRuleContext(EbnfContext.class,0);
		}
		public ActionBlockContext actionBlock() {
			return getRuleContext(ActionBlockContext.class,0);
		}
		public TerminalNode QUESTION() { return getToken(ANTLRv4Parser.QUESTION, 0); }
		public ElementOptionsContext elementOptions() {
			return getRuleContext(ElementOptionsContext.class,0);
		}
		public ParserRuleElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parserRuleElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterParserRuleElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitParserRuleElement(this);
		}
	}

	public final ParserRuleElementContext parserRuleElement() throws RecognitionException {
		ParserRuleElementContext _localctx = new ParserRuleElementContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_parserRuleElement);
		int _la;
		try {
			setState(504);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(489);
				labeledParserRuleElement();
				setState(491);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << QUESTION) | (1L << STAR) | (1L << PLUS))) != 0)) {
					{
					setState(490);
					ebnfSuffix();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(493);
				parserRuleAtom();
				setState(495);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << QUESTION) | (1L << STAR) | (1L << PLUS))) != 0)) {
					{
					setState(494);
					ebnfSuffix();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(497);
				ebnf();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(498);
				actionBlock();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(499);
				actionBlock();
				setState(500);
				match(QUESTION);
				setState(502);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(501);
					elementOptions();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabeledParserRuleElementContext extends ParserRuleContext {
		public RuleElementIdentifierContext ruleElementIdentifier() {
			return getRuleContext(RuleElementIdentifierContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(ANTLRv4Parser.ASSIGN, 0); }
		public TerminalNode PLUS_ASSIGN() { return getToken(ANTLRv4Parser.PLUS_ASSIGN, 0); }
		public ParserRuleAtomContext parserRuleAtom() {
			return getRuleContext(ParserRuleAtomContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public LabeledParserRuleElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labeledParserRuleElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterLabeledParserRuleElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitLabeledParserRuleElement(this);
		}
	}

	public final LabeledParserRuleElementContext labeledParserRuleElement() throws RecognitionException {
		LabeledParserRuleElementContext _localctx = new LabeledParserRuleElementContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_labeledParserRuleElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(506);
			ruleElementIdentifier();
			setState(507);
			_la = _input.LA(1);
			if ( !(_la==ASSIGN || _la==PLUS_ASSIGN) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(510);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID_STARTING_WITH_UPPERCASE:
			case ID_STARTING_WITH_LOWERCASE:
			case STRING_LITERAL:
			case DOT:
			case NOT:
				{
				setState(508);
				parserRuleAtom();
				}
				break;
			case LPAREN:
				{
				setState(509);
				block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParserRuleAtomContext extends ParserRuleContext {
		public CharacterRangeContext characterRange() {
			return getRuleContext(CharacterRangeContext.class,0);
		}
		public TerminalContext terminal() {
			return getRuleContext(TerminalContext.class,0);
		}
		public ParserRuleReferenceContext parserRuleReference() {
			return getRuleContext(ParserRuleReferenceContext.class,0);
		}
		public NotSetContext notSet() {
			return getRuleContext(NotSetContext.class,0);
		}
		public TerminalNode DOT() { return getToken(ANTLRv4Parser.DOT, 0); }
		public ElementOptionsContext elementOptions() {
			return getRuleContext(ElementOptionsContext.class,0);
		}
		public ParserRuleAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parserRuleAtom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterParserRuleAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitParserRuleAtom(this);
		}
	}

	public final ParserRuleAtomContext parserRuleAtom() throws RecognitionException {
		ParserRuleAtomContext _localctx = new ParserRuleAtomContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_parserRuleAtom);
		int _la;
		try {
			setState(520);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(512);
				characterRange();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(513);
				terminal();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(514);
				parserRuleReference();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(515);
				notSet();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(516);
				match(DOT);
				setState(518);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(517);
					elementOptions();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParserRuleReferenceContext extends ParserRuleContext {
		public ParserRuleIdentifierContext parserRuleIdentifier() {
			return getRuleContext(ParserRuleIdentifierContext.class,0);
		}
		public ActionBlockArgumentsContext actionBlockArguments() {
			return getRuleContext(ActionBlockArgumentsContext.class,0);
		}
		public ElementOptionsContext elementOptions() {
			return getRuleContext(ElementOptionsContext.class,0);
		}
		public ParserRuleReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parserRuleReference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterParserRuleReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitParserRuleReference(this);
		}
	}

	public final ParserRuleReferenceContext parserRuleReference() throws RecognitionException {
		ParserRuleReferenceContext _localctx = new ParserRuleReferenceContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_parserRuleReference);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(522);
			parserRuleIdentifier();
			setState(524);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BEGIN_ARGUMENT) {
				{
				setState(523);
				actionBlockArguments();
				}
			}

			setState(527);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(526);
				elementOptions();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ActionBlockArgumentsContext extends ParserRuleContext {
		public TerminalNode BEGIN_ARGUMENT() { return getToken(ANTLRv4Parser.BEGIN_ARGUMENT, 0); }
		public TerminalNode END_ARGUMENT() { return getToken(ANTLRv4Parser.END_ARGUMENT, 0); }
		public List<TerminalNode> ARGUMENT_CONTENT() { return getTokens(ANTLRv4Parser.ARGUMENT_CONTENT); }
		public TerminalNode ARGUMENT_CONTENT(int i) {
			return getToken(ANTLRv4Parser.ARGUMENT_CONTENT, i);
		}
		public ActionBlockArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actionBlockArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterActionBlockArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitActionBlockArguments(this);
		}
	}

	public final ActionBlockArgumentsContext actionBlockArguments() throws RecognitionException {
		ActionBlockArgumentsContext _localctx = new ActionBlockArgumentsContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_actionBlockArguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(529);
			match(BEGIN_ARGUMENT);
			setState(533);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ARGUMENT_CONTENT) {
				{
				{
				setState(530);
				match(ARGUMENT_CONTENT);
				}
				}
				setState(535);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(536);
			match(END_ARGUMENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LexerRuleSpecContext extends ParserRuleContext {
		public LexerRuleDeclarationContext lexerRuleDeclaration() {
			return getRuleContext(LexerRuleDeclarationContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ANTLRv4Parser.COLON, 0); }
		public LexerRuleBlockContext lexerRuleBlock() {
			return getRuleContext(LexerRuleBlockContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ANTLRv4Parser.SEMI, 0); }
		public List<TerminalNode> DOC_COMMENT() { return getTokens(ANTLRv4Parser.DOC_COMMENT); }
		public TerminalNode DOC_COMMENT(int i) {
			return getToken(ANTLRv4Parser.DOC_COMMENT, i);
		}
		public LexerRuleSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lexerRuleSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterLexerRuleSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitLexerRuleSpec(this);
		}
	}

	public final LexerRuleSpecContext lexerRuleSpec() throws RecognitionException {
		LexerRuleSpecContext _localctx = new LexerRuleSpecContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_lexerRuleSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(541);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOC_COMMENT) {
				{
				{
				setState(538);
				match(DOC_COMMENT);
				}
				}
				setState(543);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(544);
			lexerRuleDeclaration();
			setState(545);
			match(COLON);
			setState(546);
			lexerRuleBlock();
			setState(547);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LexerRuleDeclarationContext extends ParserRuleContext {
		public TokenIdentifierContext tokenIdentifier() {
			return getRuleContext(TokenIdentifierContext.class,0);
		}
		public TerminalNode FRAGMENT() { return getToken(ANTLRv4Parser.FRAGMENT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public LexerRuleDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lexerRuleDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterLexerRuleDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitLexerRuleDeclaration(this);
		}
	}

	public final LexerRuleDeclarationContext lexerRuleDeclaration() throws RecognitionException {
		LexerRuleDeclarationContext _localctx = new LexerRuleDeclarationContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_lexerRuleDeclaration);
		try {
			setState(552);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID_STARTING_WITH_UPPERCASE:
				enterOuterAlt(_localctx, 1);
				{
				setState(549);
				tokenIdentifier();
				}
				break;
			case FRAGMENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(550);
				match(FRAGMENT);
				setState(551);
				identifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LexerRuleBlockContext extends ParserRuleContext {
		public List<LexerRuleAltContext> lexerRuleAlt() {
			return getRuleContexts(LexerRuleAltContext.class);
		}
		public LexerRuleAltContext lexerRuleAlt(int i) {
			return getRuleContext(LexerRuleAltContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(ANTLRv4Parser.OR); }
		public TerminalNode OR(int i) {
			return getToken(ANTLRv4Parser.OR, i);
		}
		public LexerRuleBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lexerRuleBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterLexerRuleBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitLexerRuleBlock(this);
		}
	}

	public final LexerRuleBlockContext lexerRuleBlock() throws RecognitionException {
		LexerRuleBlockContext _localctx = new LexerRuleBlockContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_lexerRuleBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(554);
			lexerRuleAlt();
			setState(559);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(555);
				match(OR);
				setState(556);
				lexerRuleAlt();
				}
				}
				setState(561);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LexerRuleAltContext extends ParserRuleContext {
		public LexerRuleElementsContext lexerRuleElements() {
			return getRuleContext(LexerRuleElementsContext.class,0);
		}
		public LexerCommandsContext lexerCommands() {
			return getRuleContext(LexerCommandsContext.class,0);
		}
		public LexerRuleAltContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lexerRuleAlt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterLexerRuleAlt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitLexerRuleAlt(this);
		}
	}

	public final LexerRuleAltContext lexerRuleAlt() throws RecognitionException {
		LexerRuleAltContext _localctx = new LexerRuleAltContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_lexerRuleAlt);
		int _la;
		try {
			setState(567);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID_STARTING_WITH_UPPERCASE:
			case ID_STARTING_WITH_LOWERCASE:
			case LEXER_CHAR_SET:
			case STRING_LITERAL:
			case BEGIN_ACTION:
			case LPAREN:
			case DOT:
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(562);
				lexerRuleElements();
				setState(564);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RARROW) {
					{
					setState(563);
					lexerCommands();
					}
				}

				}
				break;
			case SEMI:
			case RPAREN:
			case OR:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LexerRuleElementsContext extends ParserRuleContext {
		public List<LexerRuleElementContext> lexerRuleElement() {
			return getRuleContexts(LexerRuleElementContext.class);
		}
		public LexerRuleElementContext lexerRuleElement(int i) {
			return getRuleContext(LexerRuleElementContext.class,i);
		}
		public LexerRuleElementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lexerRuleElements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterLexerRuleElements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitLexerRuleElements(this);
		}
	}

	public final LexerRuleElementsContext lexerRuleElements() throws RecognitionException {
		LexerRuleElementsContext _localctx = new LexerRuleElementsContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_lexerRuleElements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(570); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(569);
				lexerRuleElement();
				}
				}
				setState(572); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID_STARTING_WITH_UPPERCASE) | (1L << ID_STARTING_WITH_LOWERCASE) | (1L << LEXER_CHAR_SET) | (1L << STRING_LITERAL) | (1L << BEGIN_ACTION) | (1L << LPAREN) | (1L << DOT) | (1L << NOT))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LexerRuleElementContext extends ParserRuleContext {
		public LabeledLexerRuleElementContext labeledLexerRuleElement() {
			return getRuleContext(LabeledLexerRuleElementContext.class,0);
		}
		public EbnfSuffixContext ebnfSuffix() {
			return getRuleContext(EbnfSuffixContext.class,0);
		}
		public LexerRuleAtomContext lexerRuleAtom() {
			return getRuleContext(LexerRuleAtomContext.class,0);
		}
		public LexerRuleElementBlockContext lexerRuleElementBlock() {
			return getRuleContext(LexerRuleElementBlockContext.class,0);
		}
		public ActionBlockContext actionBlock() {
			return getRuleContext(ActionBlockContext.class,0);
		}
		public TerminalNode QUESTION() { return getToken(ANTLRv4Parser.QUESTION, 0); }
		public LexerRuleElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lexerRuleElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterLexerRuleElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitLexerRuleElement(this);
		}
	}

	public final LexerRuleElementContext lexerRuleElement() throws RecognitionException {
		LexerRuleElementContext _localctx = new LexerRuleElementContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_lexerRuleElement);
		int _la;
		try {
			setState(590);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(574);
				labeledLexerRuleElement();
				setState(576);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << QUESTION) | (1L << STAR) | (1L << PLUS))) != 0)) {
					{
					setState(575);
					ebnfSuffix();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(578);
				lexerRuleAtom();
				setState(580);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << QUESTION) | (1L << STAR) | (1L << PLUS))) != 0)) {
					{
					setState(579);
					ebnfSuffix();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(582);
				lexerRuleElementBlock();
				setState(584);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << QUESTION) | (1L << STAR) | (1L << PLUS))) != 0)) {
					{
					setState(583);
					ebnfSuffix();
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(586);
				actionBlock();
				setState(588);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==QUESTION) {
					{
					setState(587);
					match(QUESTION);
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabeledLexerRuleElementContext extends ParserRuleContext {
		public RuleElementIdentifierContext ruleElementIdentifier() {
			return getRuleContext(RuleElementIdentifierContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(ANTLRv4Parser.ASSIGN, 0); }
		public TerminalNode PLUS_ASSIGN() { return getToken(ANTLRv4Parser.PLUS_ASSIGN, 0); }
		public LexerRuleAtomContext lexerRuleAtom() {
			return getRuleContext(LexerRuleAtomContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public LabeledLexerRuleElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labeledLexerRuleElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterLabeledLexerRuleElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitLabeledLexerRuleElement(this);
		}
	}

	public final LabeledLexerRuleElementContext labeledLexerRuleElement() throws RecognitionException {
		LabeledLexerRuleElementContext _localctx = new LabeledLexerRuleElementContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_labeledLexerRuleElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(592);
			ruleElementIdentifier();
			setState(593);
			_la = _input.LA(1);
			if ( !(_la==ASSIGN || _la==PLUS_ASSIGN) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(596);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID_STARTING_WITH_UPPERCASE:
			case LEXER_CHAR_SET:
			case STRING_LITERAL:
			case DOT:
			case NOT:
				{
				setState(594);
				lexerRuleAtom();
				}
				break;
			case LPAREN:
				{
				setState(595);
				block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LexerRuleElementBlockContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(ANTLRv4Parser.LPAREN, 0); }
		public LexerRuleBlockContext lexerRuleBlock() {
			return getRuleContext(LexerRuleBlockContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ANTLRv4Parser.RPAREN, 0); }
		public LexerRuleElementBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lexerRuleElementBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterLexerRuleElementBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitLexerRuleElementBlock(this);
		}
	}

	public final LexerRuleElementBlockContext lexerRuleElementBlock() throws RecognitionException {
		LexerRuleElementBlockContext _localctx = new LexerRuleElementBlockContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_lexerRuleElementBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(598);
			match(LPAREN);
			setState(599);
			lexerRuleBlock();
			setState(600);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LexerCommandsContext extends ParserRuleContext {
		public TerminalNode RARROW() { return getToken(ANTLRv4Parser.RARROW, 0); }
		public List<LexerCommandContext> lexerCommand() {
			return getRuleContexts(LexerCommandContext.class);
		}
		public LexerCommandContext lexerCommand(int i) {
			return getRuleContext(LexerCommandContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ANTLRv4Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ANTLRv4Parser.COMMA, i);
		}
		public LexerCommandsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lexerCommands; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterLexerCommands(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitLexerCommands(this);
		}
	}

	public final LexerCommandsContext lexerCommands() throws RecognitionException {
		LexerCommandsContext _localctx = new LexerCommandsContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_lexerCommands);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(602);
			match(RARROW);
			setState(603);
			lexerCommand();
			setState(608);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(604);
				match(COMMA);
				setState(605);
				lexerCommand();
				}
				}
				setState(610);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LexerCommandContext extends ParserRuleContext {
		public TerminalNode SKIP_COMMAND() { return getToken(ANTLRv4Parser.SKIP_COMMAND, 0); }
		public TerminalNode MORE_COMMAND() { return getToken(ANTLRv4Parser.MORE_COMMAND, 0); }
		public TerminalNode TYPE_COMMAND() { return getToken(ANTLRv4Parser.TYPE_COMMAND, 0); }
		public TerminalNode LPAREN() { return getToken(ANTLRv4Parser.LPAREN, 0); }
		public LexerCommandExprContext lexerCommandExpr() {
			return getRuleContext(LexerCommandExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ANTLRv4Parser.RPAREN, 0); }
		public TerminalNode CHANNEL_COMMAND() { return getToken(ANTLRv4Parser.CHANNEL_COMMAND, 0); }
		public TerminalNode MODE_COMMAND() { return getToken(ANTLRv4Parser.MODE_COMMAND, 0); }
		public TerminalNode PUSHMODE_COMMAND() { return getToken(ANTLRv4Parser.PUSHMODE_COMMAND, 0); }
		public TerminalNode POPMODE_COMMAND() { return getToken(ANTLRv4Parser.POPMODE_COMMAND, 0); }
		public LexerCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lexerCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterLexerCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitLexerCommand(this);
		}
	}

	public final LexerCommandContext lexerCommand() throws RecognitionException {
		LexerCommandContext _localctx = new LexerCommandContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_lexerCommand);
		try {
			setState(634);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SKIP_COMMAND:
				enterOuterAlt(_localctx, 1);
				{
				setState(611);
				match(SKIP_COMMAND);
				}
				break;
			case MORE_COMMAND:
				enterOuterAlt(_localctx, 2);
				{
				setState(612);
				match(MORE_COMMAND);
				}
				break;
			case TYPE_COMMAND:
				enterOuterAlt(_localctx, 3);
				{
				setState(613);
				match(TYPE_COMMAND);
				setState(614);
				match(LPAREN);
				setState(615);
				lexerCommandExpr();
				setState(616);
				match(RPAREN);
				}
				break;
			case CHANNEL_COMMAND:
				enterOuterAlt(_localctx, 4);
				{
				setState(618);
				match(CHANNEL_COMMAND);
				setState(619);
				match(LPAREN);
				setState(620);
				lexerCommandExpr();
				setState(621);
				match(RPAREN);
				}
				break;
			case MODE_COMMAND:
				enterOuterAlt(_localctx, 5);
				{
				setState(623);
				match(MODE_COMMAND);
				setState(624);
				match(LPAREN);
				setState(625);
				lexerCommandExpr();
				setState(626);
				match(RPAREN);
				}
				break;
			case PUSHMODE_COMMAND:
				enterOuterAlt(_localctx, 6);
				{
				setState(628);
				match(PUSHMODE_COMMAND);
				setState(629);
				match(LPAREN);
				setState(630);
				lexerCommandExpr();
				setState(631);
				match(RPAREN);
				}
				break;
			case POPMODE_COMMAND:
				enterOuterAlt(_localctx, 7);
				{
				setState(633);
				match(POPMODE_COMMAND);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LexerCommandExprContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode INT() { return getToken(ANTLRv4Parser.INT, 0); }
		public LexerCommandExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lexerCommandExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterLexerCommandExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitLexerCommandExpr(this);
		}
	}

	public final LexerCommandExprContext lexerCommandExpr() throws RecognitionException {
		LexerCommandExprContext _localctx = new LexerCommandExprContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_lexerCommandExpr);
		try {
			setState(638);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(636);
				identifier();
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(637);
				match(INT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LexerRuleAtomContext extends ParserRuleContext {
		public CharacterRangeContext characterRange() {
			return getRuleContext(CharacterRangeContext.class,0);
		}
		public TerminalContext terminal() {
			return getRuleContext(TerminalContext.class,0);
		}
		public NotSetContext notSet() {
			return getRuleContext(NotSetContext.class,0);
		}
		public TerminalNode LEXER_CHAR_SET() { return getToken(ANTLRv4Parser.LEXER_CHAR_SET, 0); }
		public TerminalNode DOT() { return getToken(ANTLRv4Parser.DOT, 0); }
		public ElementOptionsContext elementOptions() {
			return getRuleContext(ElementOptionsContext.class,0);
		}
		public LexerRuleAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lexerRuleAtom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterLexerRuleAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitLexerRuleAtom(this);
		}
	}

	public final LexerRuleAtomContext lexerRuleAtom() throws RecognitionException {
		LexerRuleAtomContext _localctx = new LexerRuleAtomContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_lexerRuleAtom);
		int _la;
		try {
			setState(648);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(640);
				characterRange();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(641);
				terminal();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(642);
				notSet();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(643);
				match(LEXER_CHAR_SET);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(644);
				match(DOT);
				setState(646);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(645);
					elementOptions();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EbnfContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BlockSuffixContext blockSuffix() {
			return getRuleContext(BlockSuffixContext.class,0);
		}
		public EbnfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ebnf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterEbnf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitEbnf(this);
		}
	}

	public final EbnfContext ebnf() throws RecognitionException {
		EbnfContext _localctx = new EbnfContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_ebnf);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(650);
			block();
			setState(652);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << QUESTION) | (1L << STAR) | (1L << PLUS))) != 0)) {
				{
				setState(651);
				blockSuffix();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockSuffixContext extends ParserRuleContext {
		public EbnfSuffixContext ebnfSuffix() {
			return getRuleContext(EbnfSuffixContext.class,0);
		}
		public BlockSuffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockSuffix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterBlockSuffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitBlockSuffix(this);
		}
	}

	public final BlockSuffixContext blockSuffix() throws RecognitionException {
		BlockSuffixContext _localctx = new BlockSuffixContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_blockSuffix);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(654);
			ebnfSuffix();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EbnfSuffixContext extends ParserRuleContext {
		public List<TerminalNode> QUESTION() { return getTokens(ANTLRv4Parser.QUESTION); }
		public TerminalNode QUESTION(int i) {
			return getToken(ANTLRv4Parser.QUESTION, i);
		}
		public TerminalNode STAR() { return getToken(ANTLRv4Parser.STAR, 0); }
		public TerminalNode PLUS() { return getToken(ANTLRv4Parser.PLUS, 0); }
		public EbnfSuffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ebnfSuffix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterEbnfSuffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitEbnfSuffix(this);
		}
	}

	public final EbnfSuffixContext ebnfSuffix() throws RecognitionException {
		EbnfSuffixContext _localctx = new EbnfSuffixContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_ebnfSuffix);
		int _la;
		try {
			setState(668);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case QUESTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(656);
				match(QUESTION);
				setState(658);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==QUESTION) {
					{
					setState(657);
					match(QUESTION);
					}
				}

				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(660);
				match(STAR);
				setState(662);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==QUESTION) {
					{
					setState(661);
					match(QUESTION);
					}
				}

				}
				break;
			case PLUS:
				enterOuterAlt(_localctx, 3);
				{
				setState(664);
				match(PLUS);
				setState(666);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==QUESTION) {
					{
					setState(665);
					match(QUESTION);
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NotSetContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(ANTLRv4Parser.NOT, 0); }
		public SetElementContext setElement() {
			return getRuleContext(SetElementContext.class,0);
		}
		public BlockSetContext blockSet() {
			return getRuleContext(BlockSetContext.class,0);
		}
		public NotSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notSet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterNotSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitNotSet(this);
		}
	}

	public final NotSetContext notSet() throws RecognitionException {
		NotSetContext _localctx = new NotSetContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_notSet);
		try {
			setState(674);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,76,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(670);
				match(NOT);
				setState(671);
				setElement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(672);
				match(NOT);
				setState(673);
				blockSet();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockSetContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(ANTLRv4Parser.LPAREN, 0); }
		public List<SetElementContext> setElement() {
			return getRuleContexts(SetElementContext.class);
		}
		public SetElementContext setElement(int i) {
			return getRuleContext(SetElementContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(ANTLRv4Parser.RPAREN, 0); }
		public List<TerminalNode> OR() { return getTokens(ANTLRv4Parser.OR); }
		public TerminalNode OR(int i) {
			return getToken(ANTLRv4Parser.OR, i);
		}
		public BlockSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockSet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterBlockSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitBlockSet(this);
		}
	}

	public final BlockSetContext blockSet() throws RecognitionException {
		BlockSetContext _localctx = new BlockSetContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_blockSet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(676);
			match(LPAREN);
			setState(677);
			setElement();
			setState(682);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(678);
				match(OR);
				setState(679);
				setElement();
				}
				}
				setState(684);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(685);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetElementContext extends ParserRuleContext {
		public TokenIdentifierContext tokenIdentifier() {
			return getRuleContext(TokenIdentifierContext.class,0);
		}
		public ElementOptionsContext elementOptions() {
			return getRuleContext(ElementOptionsContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(ANTLRv4Parser.STRING_LITERAL, 0); }
		public CharacterRangeContext characterRange() {
			return getRuleContext(CharacterRangeContext.class,0);
		}
		public TerminalNode LEXER_CHAR_SET() { return getToken(ANTLRv4Parser.LEXER_CHAR_SET, 0); }
		public SetElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterSetElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitSetElement(this);
		}
	}

	public final SetElementContext setElement() throws RecognitionException {
		SetElementContext _localctx = new SetElementContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_setElement);
		int _la;
		try {
			setState(697);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,80,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(687);
				tokenIdentifier();
				setState(689);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(688);
					elementOptions();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(691);
				match(STRING_LITERAL);
				setState(693);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(692);
					elementOptions();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(695);
				characterRange();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(696);
				match(LEXER_CHAR_SET);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(ANTLRv4Parser.LPAREN, 0); }
		public AltListContext altList() {
			return getRuleContext(AltListContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ANTLRv4Parser.RPAREN, 0); }
		public TerminalNode COLON() { return getToken(ANTLRv4Parser.COLON, 0); }
		public OptionsSpecContext optionsSpec() {
			return getRuleContext(OptionsSpecContext.class,0);
		}
		public List<RuleActionContext> ruleAction() {
			return getRuleContexts(RuleActionContext.class);
		}
		public RuleActionContext ruleAction(int i) {
			return getRuleContext(RuleActionContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(699);
			match(LPAREN);
			setState(710);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPTIONS) | (1L << COLON) | (1L << AT))) != 0)) {
				{
				setState(701);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPTIONS) {
					{
					setState(700);
					optionsSpec();
					}
				}

				setState(706);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT) {
					{
					{
					setState(703);
					ruleAction();
					}
					}
					setState(708);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(709);
				match(COLON);
				}
			}

			setState(712);
			altList();
			setState(713);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CharacterRangeContext extends ParserRuleContext {
		public List<TerminalNode> STRING_LITERAL() { return getTokens(ANTLRv4Parser.STRING_LITERAL); }
		public TerminalNode STRING_LITERAL(int i) {
			return getToken(ANTLRv4Parser.STRING_LITERAL, i);
		}
		public TerminalNode RANGE() { return getToken(ANTLRv4Parser.RANGE, 0); }
		public CharacterRangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_characterRange; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterCharacterRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitCharacterRange(this);
		}
	}

	public final CharacterRangeContext characterRange() throws RecognitionException {
		CharacterRangeContext _localctx = new CharacterRangeContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_characterRange);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(715);
			match(STRING_LITERAL);
			setState(716);
			match(RANGE);
			setState(717);
			match(STRING_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TerminalContext extends ParserRuleContext {
		public TokenIdentifierContext tokenIdentifier() {
			return getRuleContext(TokenIdentifierContext.class,0);
		}
		public ElementOptionsContext elementOptions() {
			return getRuleContext(ElementOptionsContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(ANTLRv4Parser.STRING_LITERAL, 0); }
		public TerminalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_terminal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterTerminal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitTerminal(this);
		}
	}

	public final TerminalContext terminal() throws RecognitionException {
		TerminalContext _localctx = new TerminalContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_terminal);
		int _la;
		try {
			setState(727);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID_STARTING_WITH_UPPERCASE:
				enterOuterAlt(_localctx, 1);
				{
				setState(719);
				tokenIdentifier();
				setState(721);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(720);
					elementOptions();
					}
				}

				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(723);
				match(STRING_LITERAL);
				setState(725);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(724);
					elementOptions();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementOptionsContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(ANTLRv4Parser.LT, 0); }
		public List<ElementOptionContext> elementOption() {
			return getRuleContexts(ElementOptionContext.class);
		}
		public ElementOptionContext elementOption(int i) {
			return getRuleContext(ElementOptionContext.class,i);
		}
		public TerminalNode GT() { return getToken(ANTLRv4Parser.GT, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ANTLRv4Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ANTLRv4Parser.COMMA, i);
		}
		public ElementOptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementOptions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterElementOptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitElementOptions(this);
		}
	}

	public final ElementOptionsContext elementOptions() throws RecognitionException {
		ElementOptionsContext _localctx = new ElementOptionsContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_elementOptions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(729);
			match(LT);
			setState(730);
			elementOption();
			setState(735);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(731);
				match(COMMA);
				setState(732);
				elementOption();
				}
				}
				setState(737);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(738);
			match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementOptionContext extends ParserRuleContext {
		public TokenOptionContext tokenOption() {
			return getRuleContext(TokenOptionContext.class,0);
		}
		public ElementOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterElementOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitElementOption(this);
		}
	}

	public final ElementOptionContext elementOption() throws RecognitionException {
		ElementOptionContext _localctx = new ElementOptionContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_elementOption);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(740);
			tokenOption();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TokenOptionContext extends ParserRuleContext {
		public TerminalNode ASSOC() { return getToken(ANTLRv4Parser.ASSOC, 0); }
		public TerminalNode ASSIGN() { return getToken(ANTLRv4Parser.ASSIGN, 0); }
		public TerminalNode RIGHT() { return getToken(ANTLRv4Parser.RIGHT, 0); }
		public TerminalNode LEFT() { return getToken(ANTLRv4Parser.LEFT, 0); }
		public TerminalNode FAIL() { return getToken(ANTLRv4Parser.FAIL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(ANTLRv4Parser.STRING_LITERAL, 0); }
		public ActionBlockContext actionBlock() {
			return getRuleContext(ActionBlockContext.class,0);
		}
		public TokenOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tokenOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterTokenOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitTokenOption(this);
		}
	}

	public final TokenOptionContext tokenOption() throws RecognitionException {
		TokenOptionContext _localctx = new TokenOptionContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_tokenOption);
		int _la;
		try {
			setState(751);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ASSOC:
				enterOuterAlt(_localctx, 1);
				{
				setState(742);
				match(ASSOC);
				setState(743);
				match(ASSIGN);
				setState(744);
				_la = _input.LA(1);
				if ( !(_la==RIGHT || _la==LEFT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case FAIL:
				enterOuterAlt(_localctx, 2);
				{
				setState(745);
				match(FAIL);
				setState(746);
				match(ASSIGN);
				setState(749);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING_LITERAL:
					{
					setState(747);
					match(STRING_LITERAL);
					}
					break;
				case BEGIN_ACTION:
					{
					setState(748);
					actionBlock();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ANTLRv4Parser.ID, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitIdentifier(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(753);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RuleElementIdentifierContext extends ParserRuleContext {
		public TerminalNode ID_STARTING_WITH_UPPERCASE() { return getToken(ANTLRv4Parser.ID_STARTING_WITH_UPPERCASE, 0); }
		public TerminalNode ID_STARTING_WITH_LOWERCASE() { return getToken(ANTLRv4Parser.ID_STARTING_WITH_LOWERCASE, 0); }
		public RuleElementIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleElementIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterRuleElementIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitRuleElementIdentifier(this);
		}
	}

	public final RuleElementIdentifierContext ruleElementIdentifier() throws RecognitionException {
		RuleElementIdentifierContext _localctx = new RuleElementIdentifierContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_ruleElementIdentifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(755);
			_la = _input.LA(1);
			if ( !(_la==ID_STARTING_WITH_UPPERCASE || _la==ID_STARTING_WITH_LOWERCASE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassIdentifierContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(ANTLRv4Parser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(ANTLRv4Parser.DOT, i);
		}
		public ClassIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterClassIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitClassIdentifier(this);
		}
	}

	public final ClassIdentifierContext classIdentifier() throws RecognitionException {
		ClassIdentifierContext _localctx = new ClassIdentifierContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_classIdentifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(757);
			identifier();
			setState(762);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(758);
				match(DOT);
				setState(759);
				identifier();
				}
				}
				setState(764);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GenericClassIdentifierContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(ANTLRv4Parser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(ANTLRv4Parser.DOT, i);
		}
		public TerminalNode STAR() { return getToken(ANTLRv4Parser.STAR, 0); }
		public GenericClassIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericClassIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterGenericClassIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitGenericClassIdentifier(this);
		}
	}

	public final GenericClassIdentifierContext genericClassIdentifier() throws RecognitionException {
		GenericClassIdentifierContext _localctx = new GenericClassIdentifierContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_genericClassIdentifier);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(765);
			identifier();
			setState(770);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,91,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(766);
					match(DOT);
					setState(767);
					identifier();
					}
					} 
				}
				setState(772);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,91,_ctx);
			}
			setState(773);
			match(DOT);
			setState(774);
			match(STAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PackageIdentifierContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(ANTLRv4Parser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(ANTLRv4Parser.DOT, i);
		}
		public PackageIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterPackageIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitPackageIdentifier(this);
		}
	}

	public final PackageIdentifierContext packageIdentifier() throws RecognitionException {
		PackageIdentifierContext _localctx = new PackageIdentifierContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_packageIdentifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(776);
			identifier();
			setState(781);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(777);
				match(DOT);
				setState(778);
				identifier();
				}
				}
				setState(783);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParserRuleIdentifierContext extends ParserRuleContext {
		public TerminalNode ID_STARTING_WITH_LOWERCASE() { return getToken(ANTLRv4Parser.ID_STARTING_WITH_LOWERCASE, 0); }
		public ParserRuleIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parserRuleIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterParserRuleIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitParserRuleIdentifier(this);
		}
	}

	public final ParserRuleIdentifierContext parserRuleIdentifier() throws RecognitionException {
		ParserRuleIdentifierContext _localctx = new ParserRuleIdentifierContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_parserRuleIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(784);
			match(ID_STARTING_WITH_LOWERCASE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TokenIdentifierContext extends ParserRuleContext {
		public TerminalNode ID_STARTING_WITH_UPPERCASE() { return getToken(ANTLRv4Parser.ID_STARTING_WITH_UPPERCASE, 0); }
		public TokenIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tokenIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterTokenIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitTokenIdentifier(this);
		}
	}

	public final TokenIdentifierContext tokenIdentifier() throws RecognitionException {
		TokenIdentifierContext _localctx = new TokenIdentifierContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_tokenIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(786);
			match(ID_STARTING_WITH_UPPERCASE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3k\u0317\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\3\2\3\2\7\2\u00a5"+
		"\n\2\f\2\16\2\u00a8\13\2\3\2\7\2\u00ab\n\2\f\2\16\2\u00ae\13\2\3\2\7\2"+
		"\u00b1\n\2\f\2\16\2\u00b4\13\2\3\2\3\2\3\3\7\3\u00b9\n\3\f\3\16\3\u00bc"+
		"\13\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\5\4\u00c7\n\4\3\5\3\5\3\5\3"+
		"\5\3\5\5\5\u00ce\n\5\3\6\3\6\3\6\3\6\3\6\7\6\u00d5\n\6\f\6\16\6\u00d8"+
		"\13\6\3\6\3\6\3\7\3\7\3\7\3\7\5\7\u00e0\n\7\3\b\3\b\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\7\f\u00f6\n"+
		"\f\f\f\16\f\u00f9\13\f\3\f\3\f\3\r\3\r\3\r\5\r\u0100\n\r\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\3\17\5\17\u0109\n\17\3\17\3\17\3\20\3\20\3\20\7\20\u0110"+
		"\n\20\f\20\16\20\u0113\13\20\3\21\3\21\3\21\5\21\u0118\n\21\3\21\3\21"+
		"\3\22\3\22\3\22\7\22\u011f\n\22\f\22\16\22\u0122\13\22\3\22\5\22\u0125"+
		"\n\22\3\23\3\23\5\23\u0129\n\23\3\24\3\24\3\24\3\24\5\24\u012f\n\24\3"+
		"\24\3\24\3\24\3\25\3\25\3\25\3\25\5\25\u0138\n\25\3\25\3\25\3\25\3\26"+
		"\3\26\3\27\3\27\3\27\3\27\3\30\7\30\u0144\n\30\f\30\16\30\u0147\13\30"+
		"\3\30\5\30\u014a\n\30\3\30\7\30\u014d\n\30\f\30\16\30\u0150\13\30\3\30"+
		"\3\30\7\30\u0154\n\30\f\30\16\30\u0157\13\30\7\30\u0159\n\30\f\30\16\30"+
		"\u015c\13\30\3\31\3\31\3\31\3\31\3\32\3\32\3\33\3\33\5\33\u0166\n\33\3"+
		"\33\3\33\5\33\u016a\n\33\3\33\3\33\3\34\3\34\7\34\u0170\n\34\f\34\16\34"+
		"\u0173\13\34\3\34\3\34\3\35\3\35\3\35\3\35\7\35\u017b\n\35\f\35\16\35"+
		"\u017e\13\35\3\36\3\36\5\36\u0182\n\36\3\37\7\37\u0185\n\37\f\37\16\37"+
		"\u0188\13\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \5 \u0191\n \3 \3 \5 \u0195"+
		"\n \3 \5 \u0198\n \3 \5 \u019b\n \3 \5 \u019e\n \3 \7 \u01a1\n \f \16"+
		" \u01a4\13 \3!\7!\u01a7\n!\f!\16!\u01aa\13!\3!\5!\u01ad\n!\3\"\3\"\3\""+
		"\3\"\3#\3#\3#\3$\3$\5$\u01b8\n$\3%\3%\3%\3&\3&\3&\3&\7&\u01c1\n&\f&\16"+
		"&\u01c4\13&\3\'\3\'\3\'\3(\3(\3(\3(\3)\3)\3*\3*\3*\7*\u01d2\n*\f*\16*"+
		"\u01d5\13*\3+\3+\3+\5+\u01da\n+\3,\3,\3,\7,\u01df\n,\f,\16,\u01e2\13,"+
		"\3-\6-\u01e5\n-\r-\16-\u01e6\3-\5-\u01ea\n-\3.\3.\5.\u01ee\n.\3.\3.\5"+
		".\u01f2\n.\3.\3.\3.\3.\3.\5.\u01f9\n.\5.\u01fb\n.\3/\3/\3/\3/\5/\u0201"+
		"\n/\3\60\3\60\3\60\3\60\3\60\3\60\5\60\u0209\n\60\5\60\u020b\n\60\3\61"+
		"\3\61\5\61\u020f\n\61\3\61\5\61\u0212\n\61\3\62\3\62\7\62\u0216\n\62\f"+
		"\62\16\62\u0219\13\62\3\62\3\62\3\63\7\63\u021e\n\63\f\63\16\63\u0221"+
		"\13\63\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\5\64\u022b\n\64\3\65\3"+
		"\65\3\65\7\65\u0230\n\65\f\65\16\65\u0233\13\65\3\66\3\66\5\66\u0237\n"+
		"\66\3\66\5\66\u023a\n\66\3\67\6\67\u023d\n\67\r\67\16\67\u023e\38\38\5"+
		"8\u0243\n8\38\38\58\u0247\n8\38\38\58\u024b\n8\38\38\58\u024f\n8\58\u0251"+
		"\n8\39\39\39\39\59\u0257\n9\3:\3:\3:\3:\3;\3;\3;\3;\7;\u0261\n;\f;\16"+
		";\u0264\13;\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3"+
		"<\3<\3<\3<\5<\u027d\n<\3=\3=\5=\u0281\n=\3>\3>\3>\3>\3>\3>\5>\u0289\n"+
		">\5>\u028b\n>\3?\3?\5?\u028f\n?\3@\3@\3A\3A\5A\u0295\nA\3A\3A\5A\u0299"+
		"\nA\3A\3A\5A\u029d\nA\5A\u029f\nA\3B\3B\3B\3B\5B\u02a5\nB\3C\3C\3C\3C"+
		"\7C\u02ab\nC\fC\16C\u02ae\13C\3C\3C\3D\3D\5D\u02b4\nD\3D\3D\5D\u02b8\n"+
		"D\3D\3D\5D\u02bc\nD\3E\3E\5E\u02c0\nE\3E\7E\u02c3\nE\fE\16E\u02c6\13E"+
		"\3E\5E\u02c9\nE\3E\3E\3E\3F\3F\3F\3F\3G\3G\5G\u02d4\nG\3G\3G\5G\u02d8"+
		"\nG\5G\u02da\nG\3H\3H\3H\3H\7H\u02e0\nH\fH\16H\u02e3\13H\3H\3H\3I\3I\3"+
		"J\3J\3J\3J\3J\3J\3J\5J\u02f0\nJ\5J\u02f2\nJ\3K\3K\3L\3L\3M\3M\3M\7M\u02fb"+
		"\nM\fM\16M\u02fe\13M\3N\3N\3N\7N\u0303\nN\fN\16N\u0306\13N\3N\3N\3N\3"+
		"O\3O\3O\7O\u030e\nO\fO\16O\u0311\13O\3P\3P\3Q\3Q\3Q\2\2R\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bd"+
		"fhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092"+
		"\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\2\b\3\2\23\24\3\2\33\34\3\2"+
		"\26\30\4\2\60\60\63\63\3\2,-\3\2\3\4\u033c\2\u00a2\3\2\2\2\4\u00ba\3\2"+
		"\2\2\6\u00c6\3\2\2\2\b\u00cd\3\2\2\2\n\u00cf\3\2\2\2\f\u00df\3\2\2\2\16"+
		"\u00e1\3\2\2\2\20\u00e5\3\2\2\2\22\u00e9\3\2\2\2\24\u00ed\3\2\2\2\26\u00f1"+
		"\3\2\2\2\30\u00ff\3\2\2\2\32\u0103\3\2\2\2\34\u0105\3\2\2\2\36\u010c\3"+
		"\2\2\2 \u0114\3\2\2\2\"\u011b\3\2\2\2$\u0128\3\2\2\2&\u012a\3\2\2\2(\u0133"+
		"\3\2\2\2*\u013c\3\2\2\2,\u013e\3\2\2\2.\u0145\3\2\2\2\60\u015d\3\2\2\2"+
		"\62\u0161\3\2\2\2\64\u0163\3\2\2\2\66\u016d\3\2\2\28\u0176\3\2\2\2:\u0181"+
		"\3\2\2\2<\u0186\3\2\2\2>\u0190\3\2\2\2@\u01a8\3\2\2\2B\u01ae\3\2\2\2D"+
		"\u01b2\3\2\2\2F\u01b7\3\2\2\2H\u01b9\3\2\2\2J\u01bc\3\2\2\2L\u01c5\3\2"+
		"\2\2N\u01c8\3\2\2\2P\u01cc\3\2\2\2R\u01ce\3\2\2\2T\u01d6\3\2\2\2V\u01db"+
		"\3\2\2\2X\u01e9\3\2\2\2Z\u01fa\3\2\2\2\\\u01fc\3\2\2\2^\u020a\3\2\2\2"+
		"`\u020c\3\2\2\2b\u0213\3\2\2\2d\u021f\3\2\2\2f\u022a\3\2\2\2h\u022c\3"+
		"\2\2\2j\u0239\3\2\2\2l\u023c\3\2\2\2n\u0250\3\2\2\2p\u0252\3\2\2\2r\u0258"+
		"\3\2\2\2t\u025c\3\2\2\2v\u027c\3\2\2\2x\u0280\3\2\2\2z\u028a\3\2\2\2|"+
		"\u028c\3\2\2\2~\u0290\3\2\2\2\u0080\u029e\3\2\2\2\u0082\u02a4\3\2\2\2"+
		"\u0084\u02a6\3\2\2\2\u0086\u02bb\3\2\2\2\u0088\u02bd\3\2\2\2\u008a\u02cd"+
		"\3\2\2\2\u008c\u02d9\3\2\2\2\u008e\u02db\3\2\2\2\u0090\u02e6\3\2\2\2\u0092"+
		"\u02f1\3\2\2\2\u0094\u02f3\3\2\2\2\u0096\u02f5\3\2\2\2\u0098\u02f7\3\2"+
		"\2\2\u009a\u02ff\3\2\2\2\u009c\u030a\3\2\2\2\u009e\u0312\3\2\2\2\u00a0"+
		"\u0314\3\2\2\2\u00a2\u00a6\5\4\3\2\u00a3\u00a5\5\b\5\2\u00a4\u00a3\3\2"+
		"\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7"+
		"\u00ac\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9\u00ab\5:\36\2\u00aa\u00a9\3\2"+
		"\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad"+
		"\u00b2\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b1\58\35\2\u00b0\u00af\3\2"+
		"\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3"+
		"\u00b5\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b6\7\2\2\3\u00b6\3\3\2\2\2"+
		"\u00b7\u00b9\7\6\2\2\u00b8\u00b7\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00b8"+
		"\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bd\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd"+
		"\u00be\5\6\4\2\u00be\u00bf\5\u0094K\2\u00bf\u00c0\7$\2\2\u00c0\5\3\2\2"+
		"\2\u00c1\u00c2\7\23\2\2\u00c2\u00c7\7\25\2\2\u00c3\u00c4\7\24\2\2\u00c4"+
		"\u00c7\7\25\2\2\u00c5\u00c7\7\25\2\2\u00c6\u00c1\3\2\2\2\u00c6\u00c3\3"+
		"\2\2\2\u00c6\u00c5\3\2\2\2\u00c7\7\3\2\2\2\u00c8\u00ce\5\n\6\2\u00c9\u00ce"+
		"\5\26\f\2\u00ca\u00ce\5\34\17\2\u00cb\u00ce\5 \21\2\u00cc\u00ce\5$\23"+
		"\2\u00cd\u00c8\3\2\2\2\u00cd\u00c9\3\2\2\2\u00cd\u00ca\3\2\2\2\u00cd\u00cb"+
		"\3\2\2\2\u00cd\u00cc\3\2\2\2\u00ce\t\3\2\2\2\u00cf\u00d0\7\16\2\2\u00d0"+
		"\u00d6\7\'\2\2\u00d1\u00d2\5\f\7\2\u00d2\u00d3\7$\2\2\u00d3\u00d5\3\2"+
		"\2\2\u00d4\u00d1\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6"+
		"\u00d7\3\2\2\2\u00d7\u00d9\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d9\u00da\7("+
		"\2\2\u00da\13\3\2\2\2\u00db\u00e0\5\16\b\2\u00dc\u00e0\5\20\t\2\u00dd"+
		"\u00e0\5\22\n\2\u00de\u00e0\5\24\13\2\u00df\u00db\3\2\2\2\u00df\u00dc"+
		"\3\2\2\2\u00df\u00dd\3\2\2\2\u00df\u00de\3\2\2\2\u00e0\r\3\2\2\2\u00e1"+
		"\u00e2\7Q\2\2\u00e2\u00e3\7\60\2\2\u00e3\u00e4\5\u0098M\2\u00e4\17\3\2"+
		"\2\2\u00e5\u00e6\7R\2\2\u00e6\u00e7\7\60\2\2\u00e7\u00e8\7\n\2\2\u00e8"+
		"\21\3\2\2\2\u00e9\u00ea\7S\2\2\u00ea\u00eb\7\60\2\2\u00eb\u00ec\5\u0094"+
		"K\2\u00ec\23\3\2\2\2\u00ed\u00ee\7T\2\2\u00ee\u00ef\7\60\2\2\u00ef\u00f0"+
		"\5\u0098M\2\u00f0\25\3\2\2\2\u00f1\u00f2\7\21\2\2\u00f2\u00f7\5\30\r\2"+
		"\u00f3\u00f4\7#\2\2\u00f4\u00f6\5\30\r\2\u00f5\u00f3\3\2\2\2\u00f6\u00f9"+
		"\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00fa\3\2\2\2\u00f9"+
		"\u00f7\3\2\2\2\u00fa\u00fb\7$\2\2\u00fb\27\3\2\2\2\u00fc\u00fd\5\u0094"+
		"K\2\u00fd\u00fe\7\60\2\2\u00fe\u0100\3\2\2\2\u00ff\u00fc\3\2\2\2\u00ff"+
		"\u0100\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u0102\5\32\16\2\u0102\31\3\2"+
		"\2\2\u0103\u0104\5\u0094K\2\u0104\33\3\2\2\2\u0105\u0106\7\17\2\2\u0106"+
		"\u0108\7\'\2\2\u0107\u0109\5\36\20\2\u0108\u0107\3\2\2\2\u0108\u0109\3"+
		"\2\2\2\u0109\u010a\3\2\2\2\u010a\u010b\7(\2\2\u010b\35\3\2\2\2\u010c\u0111"+
		"\5\u00a0Q\2\u010d\u010e\7#\2\2\u010e\u0110\5\u00a0Q\2\u010f\u010d\3\2"+
		"\2\2\u0110\u0113\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112"+
		"\37\3\2\2\2\u0113\u0111\3\2\2\2\u0114\u0115\7\20\2\2\u0115\u0117\7\'\2"+
		"\2\u0116\u0118\5\"\22\2\u0117\u0116\3\2\2\2\u0117\u0118\3\2\2\2\u0118"+
		"\u0119\3\2\2\2\u0119\u011a\7(\2\2\u011a!\3\2\2\2\u011b\u0120\5\u0094K"+
		"\2\u011c\u011d\7#\2\2\u011d\u011f\5\u0094K\2\u011e\u011c\3\2\2\2\u011f"+
		"\u0122\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0124\3\2"+
		"\2\2\u0122\u0120\3\2\2\2\u0123\u0125\7#\2\2\u0124\u0123\3\2\2\2\u0124"+
		"\u0125\3\2\2\2\u0125#\3\2\2\2\u0126\u0129\5&\24\2\u0127\u0129\5(\25\2"+
		"\u0128\u0126\3\2\2\2\u0128\u0127\3\2\2\2\u0129%\3\2\2\2\u012a\u012e\7"+
		"9\2\2\u012b\u012c\5*\26\2\u012c\u012d\7\"\2\2\u012d\u012f\3\2\2\2\u012e"+
		"\u012b\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0131\7:"+
		"\2\2\u0131\u0132\5,\27\2\u0132\'\3\2\2\2\u0133\u0137\79\2\2\u0134\u0135"+
		"\5*\26\2\u0135\u0136\7\"\2\2\u0136\u0138\3\2\2\2\u0137\u0134\3\2\2\2\u0137"+
		"\u0138\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u013a\7;\2\2\u013a\u013b\5\66"+
		"\34\2\u013b)\3\2\2\2\u013c\u013d\t\2\2\2\u013d+\3\2\2\2\u013e\u013f\7"+
		"\r\2\2\u013f\u0140\5.\30\2\u0140\u0141\7L\2\2\u0141-\3\2\2\2\u0142\u0144"+
		"\7N\2\2\u0143\u0142\3\2\2\2\u0144\u0147\3\2\2\2\u0145\u0143\3\2\2\2\u0145"+
		"\u0146\3\2\2\2\u0146\u0149\3\2\2\2\u0147\u0145\3\2\2\2\u0148\u014a\5\60"+
		"\31\2\u0149\u0148\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u014e\3\2\2\2\u014b"+
		"\u014d\7N\2\2\u014c\u014b\3\2\2\2\u014d\u0150\3\2\2\2\u014e\u014c\3\2"+
		"\2\2\u014e\u014f\3\2\2\2\u014f\u015a\3\2\2\2\u0150\u014e\3\2\2\2\u0151"+
		"\u0155\5\62\32\2\u0152\u0154\7N\2\2\u0153\u0152\3\2\2\2\u0154\u0157\3"+
		"\2\2\2\u0155\u0153\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u0159\3\2\2\2\u0157"+
		"\u0155\3\2\2\2\u0158\u0151\3\2\2\2\u0159\u015c\3\2\2\2\u015a\u0158\3\2"+
		"\2\2\u015a\u015b\3\2\2\2\u015b/\3\2\2\2\u015c\u015a\3\2\2\2\u015d\u015e"+
		"\7F\2\2\u015e\u015f\5\u009cO\2\u015f\u0160\7$\2\2\u0160\61\3\2\2\2\u0161"+
		"\u0162\5\64\33\2\u0162\63\3\2\2\2\u0163\u0165\7G\2\2\u0164\u0166\7H\2"+
		"\2\u0165\u0164\3\2\2\2\u0165\u0166\3\2\2\2\u0166\u0169\3\2\2\2\u0167\u016a"+
		"\5\u0098M\2\u0168\u016a\5\u009aN\2\u0169\u0167\3\2\2\2\u0169\u0168\3\2"+
		"\2\2\u016a\u016b\3\2\2\2\u016b\u016c\7$\2\2\u016c\65\3\2\2\2\u016d\u0171"+
		"\7\r\2\2\u016e\u0170\7N\2\2\u016f\u016e\3\2\2\2\u0170\u0173\3\2\2\2\u0171"+
		"\u016f\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u0174\3\2\2\2\u0173\u0171\3\2"+
		"\2\2\u0174\u0175\7L\2\2\u0175\67\3\2\2\2\u0176\u0177\7 \2\2\u0177\u0178"+
		"\5\u0094K\2\u0178\u017c\7$\2\2\u0179\u017b\5d\63\2\u017a\u0179\3\2\2\2"+
		"\u017b\u017e\3\2\2\2\u017c\u017a\3\2\2\2\u017c\u017d\3\2\2\2\u017d9\3"+
		"\2\2\2\u017e\u017c\3\2\2\2\u017f\u0182\5<\37\2\u0180\u0182\5d\63\2\u0181"+
		"\u017f\3\2\2\2\u0181\u0180\3\2\2\2\u0182;\3\2\2\2\u0183\u0185\7\6\2\2"+
		"\u0184\u0183\3\2\2\2\u0185\u0188\3\2\2\2\u0186\u0184\3\2\2\2\u0186\u0187"+
		"\3\2\2\2\u0187\u0189\3\2\2\2\u0188\u0186\3\2\2\2\u0189\u018a\5> \2\u018a"+
		"\u018b\7!\2\2\u018b\u018c\5R*\2\u018c\u018d\7$\2\2\u018d\u018e\5@!\2\u018e"+
		"=\3\2\2\2\u018f\u0191\5P)\2\u0190\u018f\3\2\2\2\u0190\u0191\3\2\2\2\u0191"+
		"\u0192\3\2\2\2\u0192\u0194\5\u009eP\2\u0193\u0195\5b\62\2\u0194\u0193"+
		"\3\2\2\2\u0194\u0195\3\2\2\2\u0195\u0197\3\2\2\2\u0196\u0198\5H%\2\u0197"+
		"\u0196\3\2\2\2\u0197\u0198\3\2\2\2\u0198\u019a\3\2\2\2\u0199\u019b\5J"+
		"&\2\u019a\u0199\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u019d\3\2\2\2\u019c"+
		"\u019e\5L\'\2\u019d\u019c\3\2\2\2\u019d\u019e\3\2\2\2\u019e\u01a2\3\2"+
		"\2\2\u019f\u01a1\5F$\2\u01a0\u019f\3\2\2\2\u01a1\u01a4\3\2\2\2\u01a2\u01a0"+
		"\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3?\3\2\2\2\u01a4\u01a2\3\2\2\2\u01a5"+
		"\u01a7\5B\"\2\u01a6\u01a5\3\2\2\2\u01a7\u01aa\3\2\2\2\u01a8\u01a6\3\2"+
		"\2\2\u01a8\u01a9\3\2\2\2\u01a9\u01ac\3\2\2\2\u01aa\u01a8\3\2\2\2\u01ab"+
		"\u01ad\5D#\2\u01ac\u01ab\3\2\2\2\u01ac\u01ad\3\2\2\2\u01adA\3\2\2\2\u01ae"+
		"\u01af\7\36\2\2\u01af\u01b0\5b\62\2\u01b0\u01b1\5\66\34\2\u01b1C\3\2\2"+
		"\2\u01b2\u01b3\7\37\2\2\u01b3\u01b4\5\66\34\2\u01b4E\3\2\2\2\u01b5\u01b8"+
		"\5\n\6\2\u01b6\u01b8\5N(\2\u01b7\u01b5\3\2\2\2\u01b7\u01b6\3\2\2\2\u01b8"+
		"G\3\2\2\2\u01b9\u01ba\7\31\2\2\u01ba\u01bb\5b\62\2\u01bbI\3\2\2\2\u01bc"+
		"\u01bd\7\35\2\2\u01bd\u01c2\5\u0094K\2\u01be\u01bf\7#\2\2\u01bf\u01c1"+
		"\5\u0094K\2\u01c0\u01be\3\2\2\2\u01c1\u01c4\3\2\2\2\u01c2\u01c0\3\2\2"+
		"\2\u01c2\u01c3\3\2\2\2\u01c3K\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c5\u01c6"+
		"\7\32\2\2\u01c6\u01c7\5b\62\2\u01c7M\3\2\2\2\u01c8\u01c9\79\2\2\u01c9"+
		"\u01ca\t\3\2\2\u01ca\u01cb\5\66\34\2\u01cbO\3\2\2\2\u01cc\u01cd\t\4\2"+
		"\2\u01cdQ\3\2\2\2\u01ce\u01d3\5T+\2\u01cf\u01d0\7\65\2\2\u01d0\u01d2\5"+
		"T+\2\u01d1\u01cf\3\2\2\2\u01d2\u01d5\3\2\2\2\u01d3\u01d1\3\2\2\2\u01d3"+
		"\u01d4\3\2\2\2\u01d4S\3\2\2\2\u01d5\u01d3\3\2\2\2\u01d6\u01d9\5X-\2\u01d7"+
		"\u01d8\7<\2\2\u01d8\u01da\5\u0094K\2\u01d9\u01d7\3\2\2\2\u01d9\u01da\3"+
		"\2\2\2\u01daU\3\2\2\2\u01db\u01e0\5X-\2\u01dc\u01dd\7\65\2\2\u01dd\u01df"+
		"\5X-\2\u01de\u01dc\3\2\2\2\u01df\u01e2\3\2\2\2\u01e0\u01de\3\2\2\2\u01e0"+
		"\u01e1\3\2\2\2\u01e1W\3\2\2\2\u01e2\u01e0\3\2\2\2\u01e3\u01e5\5Z.\2\u01e4"+
		"\u01e3\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6\u01e4\3\2\2\2\u01e6\u01e7\3\2"+
		"\2\2\u01e7\u01ea\3\2\2\2\u01e8\u01ea\3\2\2\2\u01e9\u01e4\3\2\2\2\u01e9"+
		"\u01e8\3\2\2\2\u01eaY\3\2\2\2\u01eb\u01ed\5\\/\2\u01ec\u01ee\5\u0080A"+
		"\2\u01ed\u01ec\3\2\2\2\u01ed\u01ee\3\2\2\2\u01ee\u01fb\3\2\2\2\u01ef\u01f1"+
		"\5^\60\2\u01f0\u01f2\5\u0080A\2\u01f1\u01f0\3\2\2\2\u01f1\u01f2\3\2\2"+
		"\2\u01f2\u01fb\3\2\2\2\u01f3\u01fb\5|?\2\u01f4\u01fb\5\66\34\2\u01f5\u01f6"+
		"\5\66\34\2\u01f6\u01f8\7\61\2\2\u01f7\u01f9\5\u008eH\2\u01f8\u01f7\3\2"+
		"\2\2\u01f8\u01f9\3\2\2\2\u01f9\u01fb\3\2\2\2\u01fa\u01eb\3\2\2\2\u01fa"+
		"\u01ef\3\2\2\2\u01fa\u01f3\3\2\2\2\u01fa\u01f4\3\2\2\2\u01fa\u01f5\3\2"+
		"\2\2\u01fb[\3\2\2\2\u01fc\u01fd\5\u0096L\2\u01fd\u0200\t\5\2\2\u01fe\u0201"+
		"\5^\60\2\u01ff\u0201\5\u0088E\2\u0200\u01fe\3\2\2\2\u0200\u01ff\3\2\2"+
		"\2\u0201]\3\2\2\2\u0202\u020b\5\u008aF\2\u0203\u020b\5\u008cG\2\u0204"+
		"\u020b\5`\61\2\u0205\u020b\5\u0082B\2\u0206\u0208\78\2\2\u0207\u0209\5"+
		"\u008eH\2\u0208\u0207\3\2\2\2\u0208\u0209\3\2\2\2\u0209\u020b\3\2\2\2"+
		"\u020a\u0202\3\2\2\2\u020a\u0203\3\2\2\2\u020a\u0204\3\2\2\2\u020a\u0205"+
		"\3\2\2\2\u020a\u0206\3\2\2\2\u020b_\3\2\2\2\u020c\u020e\5\u009eP\2\u020d"+
		"\u020f\5b\62\2\u020e\u020d\3\2\2\2\u020e\u020f\3\2\2\2\u020f\u0211\3\2"+
		"\2\2\u0210\u0212\5\u008eH\2\u0211\u0210\3\2\2\2\u0211\u0212\3\2\2\2\u0212"+
		"a\3\2\2\2\u0213\u0217\7\f\2\2\u0214\u0216\7C\2\2\u0215\u0214\3\2\2\2\u0216"+
		"\u0219\3\2\2\2\u0217\u0215\3\2\2\2\u0217\u0218\3\2\2\2\u0218\u021a\3\2"+
		"\2\2\u0219\u0217\3\2\2\2\u021a\u021b\7A\2\2\u021bc\3\2\2\2\u021c\u021e"+
		"\7\6\2\2\u021d\u021c\3\2\2\2\u021e\u0221\3\2\2\2\u021f\u021d\3\2\2\2\u021f"+
		"\u0220\3\2\2\2\u0220\u0222\3\2\2\2\u0221\u021f\3\2\2\2\u0222\u0223\5f"+
		"\64\2\u0223\u0224\7!\2\2\u0224\u0225\5h\65\2\u0225\u0226\7$\2\2\u0226"+
		"e\3\2\2\2\u0227\u022b\5\u00a0Q\2\u0228\u0229\7\22\2\2\u0229\u022b\5\u0094"+
		"K\2\u022a\u0227\3\2\2\2\u022a\u0228\3\2\2\2\u022bg\3\2\2\2\u022c\u0231"+
		"\5j\66\2\u022d\u022e\7\65\2\2\u022e\u0230\5j\66\2\u022f\u022d\3\2\2\2"+
		"\u0230\u0233\3\2\2\2\u0231\u022f\3\2\2\2\u0231\u0232\3\2\2\2\u0232i\3"+
		"\2\2\2\u0233\u0231\3\2\2\2\u0234\u0236\5l\67\2\u0235\u0237\5t;\2\u0236"+
		"\u0235\3\2\2\2\u0236\u0237\3\2\2\2\u0237\u023a\3\2\2\2\u0238\u023a\3\2"+
		"\2\2\u0239\u0234\3\2\2\2\u0239\u0238\3\2\2\2\u023ak\3\2\2\2\u023b\u023d"+
		"\5n8\2\u023c\u023b\3\2\2\2\u023d\u023e\3\2\2\2\u023e\u023c\3\2\2\2\u023e"+
		"\u023f\3\2\2\2\u023fm\3\2\2\2\u0240\u0242\5p9\2\u0241\u0243\5\u0080A\2"+
		"\u0242\u0241\3\2\2\2\u0242\u0243\3\2\2\2\u0243\u0251\3\2\2\2\u0244\u0246"+
		"\5z>\2\u0245\u0247\5\u0080A\2\u0246\u0245\3\2\2\2\u0246\u0247\3\2\2\2"+
		"\u0247\u0251\3\2\2\2\u0248\u024a\5r:\2\u0249\u024b\5\u0080A\2\u024a\u0249"+
		"\3\2\2\2\u024a\u024b\3\2\2\2\u024b\u0251\3\2\2\2\u024c\u024e\5\66\34\2"+
		"\u024d\u024f\7\61\2\2\u024e\u024d\3\2\2\2\u024e\u024f\3\2\2\2\u024f\u0251"+
		"\3\2\2\2\u0250\u0240\3\2\2\2\u0250\u0244\3\2\2\2\u0250\u0248\3\2\2\2\u0250"+
		"\u024c\3\2\2\2\u0251o\3\2\2\2\u0252\u0253\5\u0096L\2\u0253\u0256\t\5\2"+
		"\2\u0254\u0257\5z>\2\u0255\u0257\5\u0088E\2\u0256\u0254\3\2\2\2\u0256"+
		"\u0255\3\2\2\2\u0257q\3\2\2\2\u0258\u0259\7%\2\2\u0259\u025a\5h\65\2\u025a"+
		"\u025b\7&\2\2\u025bs\3\2\2\2\u025c\u025d\7)\2\2\u025d\u0262\5v<\2\u025e"+
		"\u025f\7#\2\2\u025f\u0261\5v<\2\u0260\u025e\3\2\2\2\u0261\u0264\3\2\2"+
		"\2\u0262\u0260\3\2\2\2\u0262\u0263\3\2\2\2\u0263u\3\2\2\2\u0264\u0262"+
		"\3\2\2\2\u0265\u027d\7`\2\2\u0266\u027d\7a\2\2\u0267\u0268\7b\2\2\u0268"+
		"\u0269\7%\2\2\u0269\u026a\5x=\2\u026a\u026b\7&\2\2\u026b\u027d\3\2\2\2"+
		"\u026c\u026d\7c\2\2\u026d\u026e\7%\2\2\u026e\u026f\5x=\2\u026f\u0270\7"+
		"&\2\2\u0270\u027d\3\2\2\2\u0271\u0272\7d\2\2\u0272\u0273\7%\2\2\u0273"+
		"\u0274\5x=\2\u0274\u0275\7&\2\2\u0275\u027d\3\2\2\2\u0276\u0277\7e\2\2"+
		"\u0277\u0278\7%\2\2\u0278\u0279\5x=\2\u0279\u027a\7&\2\2\u027a\u027d\3"+
		"\2\2\2\u027b\u027d\7f\2\2\u027c\u0265\3\2\2\2\u027c\u0266\3\2\2\2\u027c"+
		"\u0267\3\2\2\2\u027c\u026c\3\2\2\2\u027c\u0271\3\2\2\2\u027c\u0276\3\2"+
		"\2\2\u027c\u027b\3\2\2\2\u027dw\3\2\2\2\u027e\u0281\5\u0094K\2\u027f\u0281"+
		"\7\t\2\2\u0280\u027e\3\2\2\2\u0280\u027f\3\2\2\2\u0281y\3\2\2\2\u0282"+
		"\u028b\5\u008aF\2\u0283\u028b\5\u008cG\2\u0284\u028b\5\u0082B\2\u0285"+
		"\u028b\7\5\2\2\u0286\u0288\78\2\2\u0287\u0289\5\u008eH\2\u0288\u0287\3"+
		"\2\2\2\u0288\u0289\3\2\2\2\u0289\u028b\3\2\2\2\u028a\u0282\3\2\2\2\u028a"+
		"\u0283\3\2\2\2\u028a\u0284\3\2\2\2\u028a\u0285\3\2\2\2\u028a\u0286\3\2"+
		"\2\2\u028b{\3\2\2\2\u028c\u028e\5\u0088E\2\u028d\u028f\5~@\2\u028e\u028d"+
		"\3\2\2\2\u028e\u028f\3\2\2\2\u028f}\3\2\2\2\u0290\u0291\5\u0080A\2\u0291"+
		"\177\3\2\2\2\u0292\u0294\7\61\2\2\u0293\u0295\7\61\2\2\u0294\u0293\3\2"+
		"\2\2\u0294\u0295\3\2\2\2\u0295\u029f\3\2\2\2\u0296\u0298\7\62\2\2\u0297"+
		"\u0299\7\61\2\2\u0298\u0297\3\2\2\2\u0298\u0299\3\2\2\2\u0299\u029f\3"+
		"\2\2\2\u029a\u029c\7\64\2\2\u029b\u029d\7\61\2\2\u029c\u029b\3\2\2\2\u029c"+
		"\u029d\3\2\2\2\u029d\u029f\3\2\2\2\u029e\u0292\3\2\2\2\u029e\u0296\3\2"+
		"\2\2\u029e\u029a\3\2\2\2\u029f\u0081\3\2\2\2\u02a0\u02a1\7=\2\2\u02a1"+
		"\u02a5\5\u0086D\2\u02a2\u02a3\7=\2\2\u02a3\u02a5\5\u0084C\2\u02a4\u02a0"+
		"\3\2\2\2\u02a4\u02a2\3\2\2\2\u02a5\u0083\3\2\2\2\u02a6\u02a7\7%\2\2\u02a7"+
		"\u02ac\5\u0086D\2\u02a8\u02a9\7\65\2\2\u02a9\u02ab\5\u0086D\2\u02aa\u02a8"+
		"\3\2\2\2\u02ab\u02ae\3\2\2\2\u02ac\u02aa\3\2\2\2\u02ac\u02ad\3\2\2\2\u02ad"+
		"\u02af\3\2\2\2\u02ae\u02ac\3\2\2\2\u02af\u02b0\7&\2\2\u02b0\u0085\3\2"+
		"\2\2\u02b1\u02b3\5\u00a0Q\2\u02b2\u02b4\5\u008eH\2\u02b3\u02b2\3\2\2\2"+
		"\u02b3\u02b4\3\2\2\2\u02b4\u02bc\3\2\2\2\u02b5\u02b7\7\n\2\2\u02b6\u02b8"+
		"\5\u008eH\2\u02b7\u02b6\3\2\2\2\u02b7\u02b8\3\2\2\2\u02b8\u02bc\3\2\2"+
		"\2\u02b9\u02bc\5\u008aF\2\u02ba\u02bc\7\5\2\2\u02bb\u02b1\3\2\2\2\u02bb"+
		"\u02b5\3\2\2\2\u02bb\u02b9\3\2\2\2\u02bb\u02ba\3\2\2\2\u02bc\u0087\3\2"+
		"\2\2\u02bd\u02c8\7%\2\2\u02be\u02c0\5\n\6\2\u02bf\u02be\3\2\2\2\u02bf"+
		"\u02c0\3\2\2\2\u02c0\u02c4\3\2\2\2\u02c1\u02c3\5N(\2\u02c2\u02c1\3\2\2"+
		"\2\u02c3\u02c6\3\2\2\2\u02c4\u02c2\3\2\2\2\u02c4\u02c5\3\2\2\2\u02c5\u02c7"+
		"\3\2\2\2\u02c6\u02c4\3\2\2\2\u02c7\u02c9\7!\2\2\u02c8\u02bf\3\2\2\2\u02c8"+
		"\u02c9\3\2\2\2\u02c9\u02ca\3\2\2\2\u02ca\u02cb\5V,\2\u02cb\u02cc\7&\2"+
		"\2\u02cc\u0089\3\2\2\2\u02cd\u02ce\7\n\2\2\u02ce\u02cf\7\67\2\2\u02cf"+
		"\u02d0\7\n\2\2\u02d0\u008b\3\2\2\2\u02d1\u02d3\5\u00a0Q\2\u02d2\u02d4"+
		"\5\u008eH\2\u02d3\u02d2\3\2\2\2\u02d3\u02d4\3\2\2\2\u02d4\u02da\3\2\2"+
		"\2\u02d5\u02d7\7\n\2\2\u02d6\u02d8\5\u008eH\2\u02d7\u02d6\3\2\2\2\u02d7"+
		"\u02d8\3\2\2\2\u02d8\u02da\3\2\2\2\u02d9\u02d1\3\2\2\2\u02d9\u02d5\3\2"+
		"\2\2\u02da\u008d\3\2\2\2\u02db\u02dc\7*\2\2\u02dc\u02e1\5\u0090I\2\u02dd"+
		"\u02de\7#\2\2\u02de\u02e0\5\u0090I\2\u02df\u02dd\3\2\2\2\u02e0\u02e3\3"+
		"\2\2\2\u02e1\u02df\3\2\2\2\u02e1\u02e2\3\2\2\2\u02e2\u02e4\3\2\2\2\u02e3"+
		"\u02e1\3\2\2\2\u02e4\u02e5\7/\2\2\u02e5\u008f\3\2\2\2\u02e6\u02e7\5\u0092"+
		"J\2\u02e7\u0091\3\2\2\2\u02e8\u02e9\7+\2\2\u02e9\u02ea\7\60\2\2\u02ea"+
		"\u02f2\t\6\2\2\u02eb\u02ec\7.\2\2\u02ec\u02ef\7\60\2\2\u02ed\u02f0\7\n"+
		"\2\2\u02ee\u02f0\5\66\34\2\u02ef\u02ed\3\2\2\2\u02ef\u02ee\3\2\2\2\u02f0"+
		"\u02f2\3\2\2\2\u02f1\u02e8\3\2\2\2\u02f1\u02eb\3\2\2\2\u02f2\u0093\3\2"+
		"\2\2\u02f3\u02f4\7>\2\2\u02f4\u0095\3\2\2\2\u02f5\u02f6\t\7\2\2\u02f6"+
		"\u0097\3\2\2\2\u02f7\u02fc\5\u0094K\2\u02f8\u02f9\78\2\2\u02f9\u02fb\5"+
		"\u0094K\2\u02fa\u02f8\3\2\2\2\u02fb\u02fe\3\2\2\2\u02fc\u02fa\3\2\2\2"+
		"\u02fc\u02fd\3\2\2\2\u02fd\u0099\3\2\2\2\u02fe\u02fc\3\2\2\2\u02ff\u0304"+
		"\5\u0094K\2\u0300\u0301\78\2\2\u0301\u0303\5\u0094K\2\u0302\u0300\3\2"+
		"\2\2\u0303\u0306\3\2\2\2\u0304\u0302\3\2\2\2\u0304\u0305\3\2\2\2\u0305"+
		"\u0307\3\2\2\2\u0306\u0304\3\2\2\2\u0307\u0308\78\2\2\u0308\u0309\7\62"+
		"\2\2\u0309\u009b\3\2\2\2\u030a\u030f\5\u0094K\2\u030b\u030c\78\2\2\u030c"+
		"\u030e\5\u0094K\2\u030d\u030b\3\2\2\2\u030e\u0311\3\2\2\2\u030f\u030d"+
		"\3\2\2\2\u030f\u0310\3\2\2\2\u0310\u009d\3\2\2\2\u0311\u030f\3\2\2\2\u0312"+
		"\u0313\7\4\2\2\u0313\u009f\3\2\2\2\u0314\u0315\7\3\2\2\u0315\u00a1\3\2"+
		"\2\2_\u00a6\u00ac\u00b2\u00ba\u00c6\u00cd\u00d6\u00df\u00f7\u00ff\u0108"+
		"\u0111\u0117\u0120\u0124\u0128\u012e\u0137\u0145\u0149\u014e\u0155\u015a"+
		"\u0165\u0169\u0171\u017c\u0181\u0186\u0190\u0194\u0197\u019a\u019d\u01a2"+
		"\u01a8\u01ac\u01b7\u01c2\u01d3\u01d9\u01e0\u01e6\u01e9\u01ed\u01f1\u01f8"+
		"\u01fa\u0200\u0208\u020a\u020e\u0211\u0217\u021f\u022a\u0231\u0236\u0239"+
		"\u023e\u0242\u0246\u024a\u024e\u0250\u0256\u0262\u027c\u0280\u0288\u028a"+
		"\u028e\u0294\u0298\u029c\u029e\u02a4\u02ac\u02b3\u02b7\u02bb\u02bf\u02c4"+
		"\u02c8\u02d3\u02d7\u02d9\u02e1\u02ef\u02f1\u02fc\u0304\u030f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}