// Generated from ANTLRv4.g4 by ANTLR 4.6
package org.nemesis.antlr.v4.netbeans.v8.grammar.code.checking.impl;
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
		TOKEN_ID=1, PARSER_RULE_ID=2, ID=3, LEXER_CHAR_SET=4, DOC_COMMENT=5, BLOCK_COMMENT=6, 
		LINE_COMMENT=7, INT=8, STRING_LITERAL=9, UNTERMINATED_STRING_LITERAL=10, 
		BEGIN_ARGUMENT=11, BEGIN_ACTION=12, OPTIONS=13, TOKENS=14, CHANNELS=15, 
		IMPORT=16, FRAGMENT=17, LEXER=18, PARSER=19, GRAMMAR=20, RETURNS=21, LOCALS=22, 
		INIT=23, AFTER=24, THROWS=25, CATCH=26, FINALLY=27, MODE=28, COLON=29, 
		COLONCOLON=30, COMMA=31, SEMI=32, LPAREN=33, RPAREN=34, LBRACE=35, RBRACE=36, 
		RARROW=37, LT=38, ASSOC=39, RIGHT=40, LEFT=41, FAIL=42, GT=43, ASSIGN=44, 
		QUESTION=45, STAR=46, PLUS_ASSIGN=47, PLUS=48, OR=49, DOLLAR=50, RANGE=51, 
		DOT=52, AT=53, HEADER=54, MEMBERS=55, SHARP=56, NOT=57, TOKEN_OR_PARSER_RULE_ID=58, 
		WS=59, ERRCHAR=60, END_ARGUMENT=61, UNTERMINATED_ARGUMENT=62, ARGUMENT_CONTENT=63, 
		HEADER_P_LINE_COMMENT=64, HEADER_P_BLOCK_COMMENT=65, HEADER_P_START=66, 
		HEADER_P_WS=67, HEADER_P_UNTERMINATED=68, HEADER_LINE_COMMENT=69, HEADER_BLOCK_COMMENT=70, 
		HEADER_NESTED=71, HEADER_PACKAGE=72, HEADER_IMPORT=73, HEADER_WS=74, HEADER_END=75, 
		UNTERMINATED_HEADER=76, HEADER_CONTENT=77, HDR_PCKG_LINE_COMMENT=78, HDR_PCKG_WS=79, 
		HDR_PCKG_UNTERMINATED=80, HDR_PCKG_CONTENT=81, HDR_IMPRT_LINE_COMMENT=82, 
		HDR_IMPRT_WS=83, HDR_IMPRT_STATIC=84, HDR_IMPRT_UNTERMINATED=85, HDR_IMPRT_CONTENT=86, 
		END_ACTION=87, UNTERMINATED_ACTION=88, ACTION_CONTENT=89, OPT_WS=90, OPT_BLOCK_COMMENT=91, 
		OPT_LINE_COMMENT=92, SUPER_CLASS=93, LANGUAGE=94, TOKEN_VOCAB=95, TOKEN_LABEL_TYPE=96, 
		OPT_UNTERMINATED=97, TOK_WS=98, TOK_BLOCK_COMMENT=99, TOK_LINE_COMMENT=100, 
		TOK_ID=101, TOK_UNTERMINATED=102, CHN_WS=103, CHN_BLOCK_COMMENT=104, CHN_LINE_COMMENT=105, 
		CHN_UNTERMINATED=106, IMPORT_WS=107, IMPORT_LINE_COMMENT=108, IMPORT_BLOCK_COMMENT=109, 
		IMPORT_UNTERMINATED=110, ID_WS=111, ID_LINE_COMMENT=112, ID_BLOCK_COMMENT=113, 
		ID_UNTERMINATED=114, TOKDEC_WS=115, TOKDEC_ID=116, TOKDEC_LBRACE=117, 
		TOKDEC_UNTERMINATED=118, FRAGDEC_LINE_COMMENT=119, FRAGDEC_WS=120, FRAGDEC_ID=121, 
		FRAGDEC_LBRACE=122, FRAGDEC_UNTERMINATED=123, PARDEC_LINE_COMMENT=124, 
		PARDEC_BLOCK_COMMENT=125, PARDEC_WS=126, PARDEC_ID=127, PARDEC_BEGIN_ARGUMENT=128, 
		PARDEC_LBRACE=129, PARDEC_UNTERMINATED=130, PARDEC_OPT_WS=131, PARDEC_OPT_BLOCK_COMMENT=132, 
		PARDEC_OPT_LINE_COMMENT=133, PARDEC_OPT_UNTERMINATED=134, LEXCOM_BLOCK_COMMENT=135, 
		LEXCOM_LINE_COMMENT=136, LEXCOM_WS=137, LEXCOM_SKIP=138, LEXCOM_MORE=139, 
		LEXCOM_TYPE=140, LEXCOM_CHANNEL=141, LEXCOM_MODE=142, LEXCOM_PUSHMODE=143, 
		LEXCOM_POPMODE=144, LEXCOM_UNTERMINATED=145, TYPE_WS=146, TYPE_LINE_COMMENT=147, 
		TYPE_TOKEN_ID=148, TYPE_UNTERMINATED=149, LEXER_CHAR_SET_UNTERMINATED=150;
	public static final int
		RULE_grammarFile = 0, RULE_grammarSpec = 1, RULE_grammarType = 2, RULE_analyzerDirectiveSpec = 3, 
		RULE_optionsSpec = 4, RULE_optionSpec = 5, RULE_superClassSpec = 6, RULE_languageSpec = 7, 
		RULE_tokenVocabSpec = 8, RULE_tokenLabelTypeSpec = 9, RULE_delegateGrammars = 10, 
		RULE_delegateGrammarList = 11, RULE_delegateGrammar = 12, RULE_grammarIdentifier = 13, 
		RULE_tokensSpec = 14, RULE_tokenList = 15, RULE_channelsSpec = 16, RULE_idList = 17, 
		RULE_action = 18, RULE_headerAction = 19, RULE_memberAction = 20, RULE_actionDestination = 21, 
		RULE_headerActionBlock = 22, RULE_headerActionContent = 23, RULE_packageDeclaration = 24, 
		RULE_importDeclaration = 25, RULE_singleTypeImportDeclaration = 26, RULE_actionBlock = 27, 
		RULE_modeSpec = 28, RULE_modeDec = 29, RULE_ruleSpec = 30, RULE_parserRuleSpec = 31, 
		RULE_parserRuleDeclaration = 32, RULE_exceptionGroup = 33, RULE_exceptionHandler = 34, 
		RULE_finallyClause = 35, RULE_parserRulePrequel = 36, RULE_parserRuleReturns = 37, 
		RULE_throwsSpec = 38, RULE_localsSpec = 39, RULE_ruleAction = 40, RULE_parserRuleDefinition = 41, 
		RULE_parserRuleLabeledAlternative = 42, RULE_altList = 43, RULE_parserRuleAlternative = 44, 
		RULE_parserRuleElement = 45, RULE_labeledParserRuleElement = 46, RULE_parserRuleAtom = 47, 
		RULE_parserRuleReference = 48, RULE_actionBlockArguments = 49, RULE_lexerRuleSpec = 50, 
		RULE_tokenRuleDeclaration = 51, RULE_fragmentRuleDeclaration = 52, RULE_lexerRuleBlock = 53, 
		RULE_lexerRuleAlt = 54, RULE_lexerRuleElements = 55, RULE_lexerRuleElement = 56, 
		RULE_lexerRuleElementBlock = 57, RULE_lexerCommands = 58, RULE_lexerCommand = 59, 
		RULE_lexComChannel = 60, RULE_lexComMode = 61, RULE_lexComPushMode = 62, 
		RULE_lexerRuleAtom = 63, RULE_ebnf = 64, RULE_ebnfSuffix = 65, RULE_notSet = 66, 
		RULE_blockSet = 67, RULE_setElement = 68, RULE_block = 69, RULE_characterRange = 70, 
		RULE_terminal = 71, RULE_elementOptions = 72, RULE_elementOption = 73, 
		RULE_tokenOption = 74, RULE_identifier = 75, RULE_ruleElementIdentifier = 76, 
		RULE_classIdentifier = 77, RULE_genericClassIdentifier = 78, RULE_packageIdentifier = 79, 
		RULE_parserRuleIdentifier = 80;
	public static final String[] ruleNames = {
		"grammarFile", "grammarSpec", "grammarType", "analyzerDirectiveSpec", 
		"optionsSpec", "optionSpec", "superClassSpec", "languageSpec", "tokenVocabSpec", 
		"tokenLabelTypeSpec", "delegateGrammars", "delegateGrammarList", "delegateGrammar", 
		"grammarIdentifier", "tokensSpec", "tokenList", "channelsSpec", "idList", 
		"action", "headerAction", "memberAction", "actionDestination", "headerActionBlock", 
		"headerActionContent", "packageDeclaration", "importDeclaration", "singleTypeImportDeclaration", 
		"actionBlock", "modeSpec", "modeDec", "ruleSpec", "parserRuleSpec", "parserRuleDeclaration", 
		"exceptionGroup", "exceptionHandler", "finallyClause", "parserRulePrequel", 
		"parserRuleReturns", "throwsSpec", "localsSpec", "ruleAction", "parserRuleDefinition", 
		"parserRuleLabeledAlternative", "altList", "parserRuleAlternative", "parserRuleElement", 
		"labeledParserRuleElement", "parserRuleAtom", "parserRuleReference", "actionBlockArguments", 
		"lexerRuleSpec", "tokenRuleDeclaration", "fragmentRuleDeclaration", "lexerRuleBlock", 
		"lexerRuleAlt", "lexerRuleElements", "lexerRuleElement", "lexerRuleElementBlock", 
		"lexerCommands", "lexerCommand", "lexComChannel", "lexComMode", "lexComPushMode", 
		"lexerRuleAtom", "ebnf", "ebnfSuffix", "notSet", "blockSet", "setElement", 
		"block", "characterRange", "terminal", "elementOptions", "elementOption", 
		"tokenOption", "identifier", "ruleElementIdentifier", "classIdentifier", 
		"genericClassIdentifier", "packageIdentifier", "parserRuleIdentifier"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "'options'", "'tokens'", "'channels'", null, "'fragment'", "'lexer'", 
		"'parser'", "'grammar'", null, null, null, null, null, "'catch'", "'finally'", 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "'header'", "'members'", null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, "'package'", 
		null, null, null, null, null, null, null, null, null, null, null, "'static'", 
		null, null, null, null, null, null, null, null, "'superClass'", "'language'", 
		"'tokenVocab'", "'TokenLabelType'", null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, "'skip'", 
		"'more'", "'type'", "'channel'", null, "'pushMode'", "'popMode'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "TOKEN_ID", "PARSER_RULE_ID", "ID", "LEXER_CHAR_SET", "DOC_COMMENT", 
		"BLOCK_COMMENT", "LINE_COMMENT", "INT", "STRING_LITERAL", "UNTERMINATED_STRING_LITERAL", 
		"BEGIN_ARGUMENT", "BEGIN_ACTION", "OPTIONS", "TOKENS", "CHANNELS", "IMPORT", 
		"FRAGMENT", "LEXER", "PARSER", "GRAMMAR", "RETURNS", "LOCALS", "INIT", 
		"AFTER", "THROWS", "CATCH", "FINALLY", "MODE", "COLON", "COLONCOLON", 
		"COMMA", "SEMI", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "RARROW", "LT", 
		"ASSOC", "RIGHT", "LEFT", "FAIL", "GT", "ASSIGN", "QUESTION", "STAR", 
		"PLUS_ASSIGN", "PLUS", "OR", "DOLLAR", "RANGE", "DOT", "AT", "HEADER", 
		"MEMBERS", "SHARP", "NOT", "TOKEN_OR_PARSER_RULE_ID", "WS", "ERRCHAR", 
		"END_ARGUMENT", "UNTERMINATED_ARGUMENT", "ARGUMENT_CONTENT", "HEADER_P_LINE_COMMENT", 
		"HEADER_P_BLOCK_COMMENT", "HEADER_P_START", "HEADER_P_WS", "HEADER_P_UNTERMINATED", 
		"HEADER_LINE_COMMENT", "HEADER_BLOCK_COMMENT", "HEADER_NESTED", "HEADER_PACKAGE", 
		"HEADER_IMPORT", "HEADER_WS", "HEADER_END", "UNTERMINATED_HEADER", "HEADER_CONTENT", 
		"HDR_PCKG_LINE_COMMENT", "HDR_PCKG_WS", "HDR_PCKG_UNTERMINATED", "HDR_PCKG_CONTENT", 
		"HDR_IMPRT_LINE_COMMENT", "HDR_IMPRT_WS", "HDR_IMPRT_STATIC", "HDR_IMPRT_UNTERMINATED", 
		"HDR_IMPRT_CONTENT", "END_ACTION", "UNTERMINATED_ACTION", "ACTION_CONTENT", 
		"OPT_WS", "OPT_BLOCK_COMMENT", "OPT_LINE_COMMENT", "SUPER_CLASS", "LANGUAGE", 
		"TOKEN_VOCAB", "TOKEN_LABEL_TYPE", "OPT_UNTERMINATED", "TOK_WS", "TOK_BLOCK_COMMENT", 
		"TOK_LINE_COMMENT", "TOK_ID", "TOK_UNTERMINATED", "CHN_WS", "CHN_BLOCK_COMMENT", 
		"CHN_LINE_COMMENT", "CHN_UNTERMINATED", "IMPORT_WS", "IMPORT_LINE_COMMENT", 
		"IMPORT_BLOCK_COMMENT", "IMPORT_UNTERMINATED", "ID_WS", "ID_LINE_COMMENT", 
		"ID_BLOCK_COMMENT", "ID_UNTERMINATED", "TOKDEC_WS", "TOKDEC_ID", "TOKDEC_LBRACE", 
		"TOKDEC_UNTERMINATED", "FRAGDEC_LINE_COMMENT", "FRAGDEC_WS", "FRAGDEC_ID", 
		"FRAGDEC_LBRACE", "FRAGDEC_UNTERMINATED", "PARDEC_LINE_COMMENT", "PARDEC_BLOCK_COMMENT", 
		"PARDEC_WS", "PARDEC_ID", "PARDEC_BEGIN_ARGUMENT", "PARDEC_LBRACE", "PARDEC_UNTERMINATED", 
		"PARDEC_OPT_WS", "PARDEC_OPT_BLOCK_COMMENT", "PARDEC_OPT_LINE_COMMENT", 
		"PARDEC_OPT_UNTERMINATED", "LEXCOM_BLOCK_COMMENT", "LEXCOM_LINE_COMMENT", 
		"LEXCOM_WS", "LEXCOM_SKIP", "LEXCOM_MORE", "LEXCOM_TYPE", "LEXCOM_CHANNEL", 
		"LEXCOM_MODE", "LEXCOM_PUSHMODE", "LEXCOM_POPMODE", "LEXCOM_UNTERMINATED", 
		"TYPE_WS", "TYPE_LINE_COMMENT", "TYPE_TOKEN_ID", "TYPE_UNTERMINATED", 
		"LEXER_CHAR_SET_UNTERMINATED"
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
		public List<RuleSpecContext> ruleSpec() {
			return getRuleContexts(RuleSpecContext.class);
		}
		public RuleSpecContext ruleSpec(int i) {
			return getRuleContext(RuleSpecContext.class,i);
		}
		public List<AnalyzerDirectiveSpecContext> analyzerDirectiveSpec() {
			return getRuleContexts(AnalyzerDirectiveSpecContext.class);
		}
		public AnalyzerDirectiveSpecContext analyzerDirectiveSpec(int i) {
			return getRuleContext(AnalyzerDirectiveSpecContext.class,i);
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			grammarSpec();
			setState(169);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(164); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(163);
						analyzerDirectiveSpec();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(166); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				{
				}
				break;
			}
			setState(172); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(171);
					ruleSpec();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(174); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(182);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOC_COMMENT:
			case MODE:
				{
				setState(177); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(176);
					modeSpec();
					}
					}
					setState(179); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==DOC_COMMENT || _la==MODE );
				}
				break;
			case EOF:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(184);
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
			setState(192);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOC_COMMENT:
				{
				setState(187); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(186);
					match(DOC_COMMENT);
					}
					}
					setState(189); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==DOC_COMMENT );
				}
				break;
			case LEXER:
			case PARSER:
			case GRAMMAR:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(194);
			grammarType();
			setState(195);
			identifier();
			setState(196);
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
			setState(203);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEXER:
				enterOuterAlt(_localctx, 1);
				{
				setState(198);
				match(LEXER);
				setState(199);
				match(GRAMMAR);
				}
				break;
			case PARSER:
				enterOuterAlt(_localctx, 2);
				{
				setState(200);
				match(PARSER);
				setState(201);
				match(GRAMMAR);
				}
				break;
			case GRAMMAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(202);
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
		public List<TerminalNode> DOC_COMMENT() { return getTokens(ANTLRv4Parser.DOC_COMMENT); }
		public TerminalNode DOC_COMMENT(int i) {
			return getToken(ANTLRv4Parser.DOC_COMMENT, i);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOC_COMMENT:
				{
				setState(206); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(205);
					match(DOC_COMMENT);
					}
					}
					setState(208); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==DOC_COMMENT );
				}
				break;
			case OPTIONS:
			case TOKENS:
			case CHANNELS:
			case IMPORT:
			case AT:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(218);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPTIONS:
				{
				setState(213);
				optionsSpec();
				}
				break;
			case IMPORT:
				{
				setState(214);
				delegateGrammars();
				}
				break;
			case TOKENS:
				{
				setState(215);
				tokensSpec();
				}
				break;
			case CHANNELS:
				{
				setState(216);
				channelsSpec();
				}
				break;
			case AT:
				{
				setState(217);
				action();
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
			setState(220);
			match(OPTIONS);
			setState(221);
			match(LBRACE);
			setState(230);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SUPER_CLASS:
			case LANGUAGE:
			case TOKEN_VOCAB:
			case TOKEN_LABEL_TYPE:
				{
				setState(225); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(222);
					optionSpec();
					setState(223);
					match(SEMI);
					}
					}
					setState(227); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & ((1L << (SUPER_CLASS - 93)) | (1L << (LANGUAGE - 93)) | (1L << (TOKEN_VOCAB - 93)) | (1L << (TOKEN_LABEL_TYPE - 93)))) != 0) );
				}
				break;
			case RBRACE:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(232);
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
			setState(238);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SUPER_CLASS:
				enterOuterAlt(_localctx, 1);
				{
				setState(234);
				superClassSpec();
				}
				break;
			case LANGUAGE:
				enterOuterAlt(_localctx, 2);
				{
				setState(235);
				languageSpec();
				}
				break;
			case TOKEN_VOCAB:
				enterOuterAlt(_localctx, 3);
				{
				setState(236);
				tokenVocabSpec();
				}
				break;
			case TOKEN_LABEL_TYPE:
				enterOuterAlt(_localctx, 4);
				{
				setState(237);
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
			setState(240);
			match(SUPER_CLASS);
			setState(241);
			match(ASSIGN);
			setState(242);
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
			setState(244);
			match(LANGUAGE);
			setState(245);
			match(ASSIGN);
			setState(246);
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
			setState(248);
			match(TOKEN_VOCAB);
			setState(249);
			match(ASSIGN);
			setState(250);
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
			setState(252);
			match(TOKEN_LABEL_TYPE);
			setState(253);
			match(ASSIGN);
			setState(254);
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
		public DelegateGrammarListContext delegateGrammarList() {
			return getRuleContext(DelegateGrammarListContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ANTLRv4Parser.SEMI, 0); }
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			match(IMPORT);
			setState(257);
			delegateGrammarList();
			setState(258);
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

	public static class DelegateGrammarListContext extends ParserRuleContext {
		public List<DelegateGrammarContext> delegateGrammar() {
			return getRuleContexts(DelegateGrammarContext.class);
		}
		public DelegateGrammarContext delegateGrammar(int i) {
			return getRuleContext(DelegateGrammarContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ANTLRv4Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ANTLRv4Parser.COMMA, i);
		}
		public DelegateGrammarListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delegateGrammarList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterDelegateGrammarList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitDelegateGrammarList(this);
		}
	}

	public final DelegateGrammarListContext delegateGrammarList() throws RecognitionException {
		DelegateGrammarListContext _localctx = new DelegateGrammarListContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_delegateGrammarList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			delegateGrammar();
			setState(268);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMMA:
				{
				setState(263); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(261);
					match(COMMA);
					setState(262);
					delegateGrammar();
					}
					}
					setState(265); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				}
				break;
			case SEMI:
				{
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
		enterRule(_localctx, 24, RULE_delegateGrammar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(270);
				identifier();
				setState(271);
				match(ASSIGN);
				}
				break;
			case 2:
				{
				}
				break;
			}
			setState(276);
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
		enterRule(_localctx, 26, RULE_grammarIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
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
		enterRule(_localctx, 28, RULE_tokensSpec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			match(TOKENS);
			setState(281);
			match(LBRACE);
			setState(284);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TOKEN_ID:
				{
				setState(282);
				tokenList();
				}
				break;
			case RBRACE:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(286);
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
		public List<TerminalNode> TOKEN_ID() { return getTokens(ANTLRv4Parser.TOKEN_ID); }
		public TerminalNode TOKEN_ID(int i) {
			return getToken(ANTLRv4Parser.TOKEN_ID, i);
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
		enterRule(_localctx, 30, RULE_tokenList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			match(TOKEN_ID);
			setState(296);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMMA:
				{
				setState(291); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(289);
					match(COMMA);
					setState(290);
					match(TOKEN_ID);
					}
					}
					setState(293); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				}
				break;
			case RBRACE:
				{
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
		enterRule(_localctx, 32, RULE_channelsSpec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			match(CHANNELS);
			setState(299);
			match(LBRACE);
			setState(302);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(300);
				idList();
				}
				break;
			case RBRACE:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(304);
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
		enterRule(_localctx, 34, RULE_idList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			identifier();
			setState(314);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMMA:
				{
				setState(309); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(307);
					match(COMMA);
					setState(308);
					identifier();
					}
					}
					setState(311); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				}
				break;
			case RBRACE:
				{
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

	public static class ActionContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(ANTLRv4Parser.AT, 0); }
		public ActionDestinationContext actionDestination() {
			return getRuleContext(ActionDestinationContext.class,0);
		}
		public TerminalNode COLONCOLON() { return getToken(ANTLRv4Parser.COLONCOLON, 0); }
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
		enterRule(_localctx, 36, RULE_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
			match(AT);
			setState(321);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEXER:
			case PARSER:
				{
				setState(317);
				actionDestination();
				setState(318);
				match(COLONCOLON);
				}
				break;
			case HEADER:
			case MEMBERS:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(325);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HEADER:
				{
				setState(323);
				headerAction();
				}
				break;
			case MEMBERS:
				{
				setState(324);
				memberAction();
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

	public static class HeaderActionContext extends ParserRuleContext {
		public TerminalNode HEADER() { return getToken(ANTLRv4Parser.HEADER, 0); }
		public HeaderActionBlockContext headerActionBlock() {
			return getRuleContext(HeaderActionBlockContext.class,0);
		}
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
		enterRule(_localctx, 38, RULE_headerAction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
			match(HEADER);
			setState(328);
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
		public TerminalNode MEMBERS() { return getToken(ANTLRv4Parser.MEMBERS, 0); }
		public ActionBlockContext actionBlock() {
			return getRuleContext(ActionBlockContext.class,0);
		}
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
		enterRule(_localctx, 40, RULE_memberAction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
			match(MEMBERS);
			setState(331);
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
		enterRule(_localctx, 42, RULE_actionDestination);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333);
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
		enterRule(_localctx, 44, RULE_headerActionBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			match(BEGIN_ACTION);
			setState(336);
			headerActionContent();
			setState(337);
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
		enterRule(_localctx, 46, RULE_headerActionContent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HEADER_PACKAGE) {
				{
				setState(339);
				packageDeclaration();
				}
			}

			setState(345);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==HEADER_IMPORT) {
				{
				{
				setState(342);
				importDeclaration();
				}
				}
				setState(347);
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
		enterRule(_localctx, 48, RULE_packageDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(348);
			match(HEADER_PACKAGE);
			setState(349);
			packageIdentifier();
			setState(350);
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
		enterRule(_localctx, 50, RULE_importDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
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
		public TerminalNode HDR_IMPRT_STATIC() { return getToken(ANTLRv4Parser.HDR_IMPRT_STATIC, 0); }
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
		enterRule(_localctx, 52, RULE_singleTypeImportDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			match(HEADER_IMPORT);
			setState(356);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HDR_IMPRT_STATIC) {
				{
				setState(355);
				match(HDR_IMPRT_STATIC);
				}
			}

			setState(360);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(358);
				classIdentifier();
				}
				break;
			case 2:
				{
				setState(359);
				genericClassIdentifier();
				}
				break;
			}
			setState(362);
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
		enterRule(_localctx, 54, RULE_actionBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			match(BEGIN_ACTION);
			setState(371);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ACTION_CONTENT:
				{
				setState(366); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(365);
					match(ACTION_CONTENT);
					}
					}
					setState(368); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ACTION_CONTENT );
				}
				break;
			case END_ACTION:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(373);
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
		public ModeDecContext modeDec() {
			return getRuleContext(ModeDecContext.class,0);
		}
		public List<TerminalNode> DOC_COMMENT() { return getTokens(ANTLRv4Parser.DOC_COMMENT); }
		public TerminalNode DOC_COMMENT(int i) {
			return getToken(ANTLRv4Parser.DOC_COMMENT, i);
		}
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
		enterRule(_localctx, 56, RULE_modeSpec);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOC_COMMENT:
				{
				setState(376); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(375);
					match(DOC_COMMENT);
					}
					}
					setState(378); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==DOC_COMMENT );
				}
				break;
			case MODE:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(383);
			modeDec();
			setState(390);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(385); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(384);
						lexerRuleSpec();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(387); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				{
				}
				break;
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

	public static class ModeDecContext extends ParserRuleContext {
		public TerminalNode MODE() { return getToken(ANTLRv4Parser.MODE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ANTLRv4Parser.SEMI, 0); }
		public ModeDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modeDec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterModeDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitModeDec(this);
		}
	}

	public final ModeDecContext modeDec() throws RecognitionException {
		ModeDecContext _localctx = new ModeDecContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_modeDec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(392);
			match(MODE);
			setState(393);
			identifier();
			setState(394);
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
		enterRule(_localctx, 60, RULE_ruleSpec);
		try {
			setState(398);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(396);
				parserRuleSpec();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(397);
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
		enterRule(_localctx, 62, RULE_parserRuleSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(406);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOC_COMMENT:
				{
				setState(401); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(400);
					match(DOC_COMMENT);
					}
					}
					setState(403); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==DOC_COMMENT );
				}
				break;
			case PARSER_RULE_ID:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(408);
			parserRuleDeclaration();
			setState(409);
			match(COLON);
			setState(410);
			parserRuleDefinition();
			setState(411);
			match(SEMI);
			setState(412);
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
		enterRule(_localctx, 64, RULE_parserRuleDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(414);
			parserRuleIdentifier();
			setState(417);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BEGIN_ARGUMENT:
				{
				setState(415);
				actionBlockArguments();
				}
				break;
			case OPTIONS:
			case RETURNS:
			case LOCALS:
			case THROWS:
			case COLON:
			case AT:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(421);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RETURNS:
				{
				setState(419);
				parserRuleReturns();
				}
				break;
			case OPTIONS:
			case LOCALS:
			case THROWS:
			case COLON:
			case AT:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(425);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case THROWS:
				{
				setState(423);
				throwsSpec();
				}
				break;
			case OPTIONS:
			case LOCALS:
			case COLON:
			case AT:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(429);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LOCALS:
				{
				setState(427);
				localsSpec();
				}
				break;
			case OPTIONS:
			case COLON:
			case AT:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(437);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPTIONS:
			case AT:
				{
				setState(432); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(431);
					parserRulePrequel();
					}
					}
					setState(434); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==OPTIONS || _la==AT );
				}
				break;
			case COLON:
				{
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

	public static class ExceptionGroupContext extends ParserRuleContext {
		public FinallyClauseContext finallyClause() {
			return getRuleContext(FinallyClauseContext.class,0);
		}
		public List<ExceptionHandlerContext> exceptionHandler() {
			return getRuleContexts(ExceptionHandlerContext.class);
		}
		public ExceptionHandlerContext exceptionHandler(int i) {
			return getRuleContext(ExceptionHandlerContext.class,i);
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
		enterRule(_localctx, 66, RULE_exceptionGroup);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(445);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CATCH:
				{
				setState(440); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(439);
					exceptionHandler();
					}
					}
					setState(442); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==CATCH );
				}
				break;
			case EOF:
			case TOKEN_ID:
			case PARSER_RULE_ID:
			case DOC_COMMENT:
			case FRAGMENT:
			case FINALLY:
			case MODE:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(449);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FINALLY:
				{
				setState(447);
				finallyClause();
				}
				break;
			case EOF:
			case TOKEN_ID:
			case PARSER_RULE_ID:
			case DOC_COMMENT:
			case FRAGMENT:
			case MODE:
				{
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
		enterRule(_localctx, 68, RULE_exceptionHandler);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(451);
			match(CATCH);
			setState(452);
			actionBlockArguments();
			setState(453);
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
		enterRule(_localctx, 70, RULE_finallyClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(455);
			match(FINALLY);
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
		enterRule(_localctx, 72, RULE_parserRulePrequel);
		try {
			setState(460);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPTIONS:
				enterOuterAlt(_localctx, 1);
				{
				setState(458);
				optionsSpec();
				}
				break;
			case AT:
				enterOuterAlt(_localctx, 2);
				{
				setState(459);
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
		enterRule(_localctx, 74, RULE_parserRuleReturns);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(462);
			match(RETURNS);
			setState(463);
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
		enterRule(_localctx, 76, RULE_throwsSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(465);
			match(THROWS);
			setState(466);
			identifier();
			setState(471);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(467);
				match(COMMA);
				setState(468);
				identifier();
				}
				}
				setState(473);
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
		enterRule(_localctx, 78, RULE_localsSpec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(474);
			match(LOCALS);
			setState(475);
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
		enterRule(_localctx, 80, RULE_ruleAction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(477);
			match(AT);
			setState(478);
			_la = _input.LA(1);
			if ( !(_la==INIT || _la==AFTER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(479);
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
		enterRule(_localctx, 82, RULE_parserRuleDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(481);
			parserRuleLabeledAlternative();
			setState(486);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(482);
				match(OR);
				setState(483);
				parserRuleLabeledAlternative();
				}
				}
				setState(488);
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
		enterRule(_localctx, 84, RULE_parserRuleLabeledAlternative);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(489);
			parserRuleAlternative();
			setState(492);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SHARP) {
				{
				setState(490);
				match(SHARP);
				setState(491);
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
		enterRule(_localctx, 86, RULE_altList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(494);
			parserRuleAlternative();
			setState(499);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(495);
				match(OR);
				setState(496);
				parserRuleAlternative();
				}
				}
				setState(501);
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
		enterRule(_localctx, 88, RULE_parserRuleAlternative);
		int _la;
		try {
			setState(508);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TOKEN_ID:
			case PARSER_RULE_ID:
			case ID:
			case STRING_LITERAL:
			case BEGIN_ACTION:
			case LPAREN:
			case DOT:
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(503); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(502);
					parserRuleElement();
					}
					}
					setState(505); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TOKEN_ID) | (1L << PARSER_RULE_ID) | (1L << ID) | (1L << STRING_LITERAL) | (1L << BEGIN_ACTION) | (1L << LPAREN) | (1L << DOT) | (1L << NOT))) != 0) );
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
		enterRule(_localctx, 90, RULE_parserRuleElement);
		int _la;
		try {
			setState(525);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(510);
				labeledParserRuleElement();
				setState(512);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << QUESTION) | (1L << STAR) | (1L << PLUS))) != 0)) {
					{
					setState(511);
					ebnfSuffix();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(514);
				parserRuleAtom();
				setState(516);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << QUESTION) | (1L << STAR) | (1L << PLUS))) != 0)) {
					{
					setState(515);
					ebnfSuffix();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(518);
				ebnf();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(519);
				actionBlock();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(520);
				actionBlock();
				setState(521);
				match(QUESTION);
				setState(523);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(522);
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
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
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
		enterRule(_localctx, 92, RULE_labeledParserRuleElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(527);
			identifier();
			setState(528);
			_la = _input.LA(1);
			if ( !(_la==ASSIGN || _la==PLUS_ASSIGN) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(531);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TOKEN_ID:
			case PARSER_RULE_ID:
			case STRING_LITERAL:
			case DOT:
			case NOT:
				{
				setState(529);
				parserRuleAtom();
				}
				break;
			case LPAREN:
				{
				setState(530);
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
		enterRule(_localctx, 94, RULE_parserRuleAtom);
		int _la;
		try {
			setState(541);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(533);
				characterRange();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(534);
				terminal();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(535);
				parserRuleReference();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(536);
				notSet();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(537);
				match(DOT);
				setState(539);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(538);
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
		enterRule(_localctx, 96, RULE_parserRuleReference);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(543);
			parserRuleIdentifier();
			setState(545);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BEGIN_ARGUMENT) {
				{
				setState(544);
				actionBlockArguments();
				}
			}

			setState(548);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(547);
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
		enterRule(_localctx, 98, RULE_actionBlockArguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(550);
			match(BEGIN_ARGUMENT);
			setState(554);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ARGUMENT_CONTENT) {
				{
				{
				setState(551);
				match(ARGUMENT_CONTENT);
				}
				}
				setState(556);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(557);
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
		public TokenRuleDeclarationContext tokenRuleDeclaration() {
			return getRuleContext(TokenRuleDeclarationContext.class,0);
		}
		public FragmentRuleDeclarationContext fragmentRuleDeclaration() {
			return getRuleContext(FragmentRuleDeclarationContext.class,0);
		}
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
		enterRule(_localctx, 100, RULE_lexerRuleSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(565);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOC_COMMENT:
				{
				setState(560); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(559);
					match(DOC_COMMENT);
					}
					}
					setState(562); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==DOC_COMMENT );
				}
				break;
			case TOKEN_ID:
			case FRAGMENT:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(569);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TOKEN_ID:
				{
				setState(567);
				tokenRuleDeclaration();
				}
				break;
			case FRAGMENT:
				{
				setState(568);
				fragmentRuleDeclaration();
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

	public static class TokenRuleDeclarationContext extends ParserRuleContext {
		public TerminalNode TOKEN_ID() { return getToken(ANTLRv4Parser.TOKEN_ID, 0); }
		public TerminalNode COLON() { return getToken(ANTLRv4Parser.COLON, 0); }
		public LexerRuleBlockContext lexerRuleBlock() {
			return getRuleContext(LexerRuleBlockContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ANTLRv4Parser.SEMI, 0); }
		public TokenRuleDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tokenRuleDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterTokenRuleDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitTokenRuleDeclaration(this);
		}
	}

	public final TokenRuleDeclarationContext tokenRuleDeclaration() throws RecognitionException {
		TokenRuleDeclarationContext _localctx = new TokenRuleDeclarationContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_tokenRuleDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(571);
			match(TOKEN_ID);
			setState(572);
			match(COLON);
			setState(573);
			lexerRuleBlock();
			setState(574);
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

	public static class FragmentRuleDeclarationContext extends ParserRuleContext {
		public TerminalNode FRAGMENT() { return getToken(ANTLRv4Parser.FRAGMENT, 0); }
		public TerminalNode TOKEN_ID() { return getToken(ANTLRv4Parser.TOKEN_ID, 0); }
		public TerminalNode COLON() { return getToken(ANTLRv4Parser.COLON, 0); }
		public LexerRuleBlockContext lexerRuleBlock() {
			return getRuleContext(LexerRuleBlockContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ANTLRv4Parser.SEMI, 0); }
		public FragmentRuleDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fragmentRuleDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterFragmentRuleDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitFragmentRuleDeclaration(this);
		}
	}

	public final FragmentRuleDeclarationContext fragmentRuleDeclaration() throws RecognitionException {
		FragmentRuleDeclarationContext _localctx = new FragmentRuleDeclarationContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_fragmentRuleDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(576);
			match(FRAGMENT);
			setState(577);
			match(TOKEN_ID);
			setState(578);
			match(COLON);
			setState(579);
			lexerRuleBlock();
			setState(580);
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
		enterRule(_localctx, 106, RULE_lexerRuleBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(582);
			lexerRuleAlt();
			setState(590);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OR:
				{
				setState(585); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(583);
					match(OR);
					setState(584);
					lexerRuleAlt();
					}
					}
					setState(587); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==OR );
				}
				break;
			case SEMI:
			case RPAREN:
				{
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
		enterRule(_localctx, 108, RULE_lexerRuleAlt);
		try {
			setState(598);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TOKEN_ID:
			case LEXER_CHAR_SET:
			case STRING_LITERAL:
			case BEGIN_ACTION:
			case LPAREN:
			case DOT:
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(592);
				lexerRuleElements();
				setState(595);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case RARROW:
					{
					setState(593);
					lexerCommands();
					}
					break;
				case SEMI:
				case RPAREN:
				case OR:
					{
					}
					break;
				default:
					throw new NoViableAltException(this);
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
		enterRule(_localctx, 110, RULE_lexerRuleElements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(601); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(600);
				lexerRuleElement();
				}
				}
				setState(603); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TOKEN_ID) | (1L << LEXER_CHAR_SET) | (1L << STRING_LITERAL) | (1L << BEGIN_ACTION) | (1L << LPAREN) | (1L << DOT) | (1L << NOT))) != 0) );
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
		public LexerRuleAtomContext lexerRuleAtom() {
			return getRuleContext(LexerRuleAtomContext.class,0);
		}
		public EbnfSuffixContext ebnfSuffix() {
			return getRuleContext(EbnfSuffixContext.class,0);
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
		enterRule(_localctx, 112, RULE_lexerRuleElement);
		try {
			setState(620);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TOKEN_ID:
			case LEXER_CHAR_SET:
			case STRING_LITERAL:
			case DOT:
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(605);
				lexerRuleAtom();
				setState(608);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case QUESTION:
				case STAR:
				case PLUS:
					{
					setState(606);
					ebnfSuffix();
					}
					break;
				case TOKEN_ID:
				case LEXER_CHAR_SET:
				case STRING_LITERAL:
				case BEGIN_ACTION:
				case SEMI:
				case LPAREN:
				case RPAREN:
				case RARROW:
				case OR:
				case DOT:
				case NOT:
					{
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(610);
				lexerRuleElementBlock();
				setState(613);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case QUESTION:
				case STAR:
				case PLUS:
					{
					setState(611);
					ebnfSuffix();
					}
					break;
				case TOKEN_ID:
				case LEXER_CHAR_SET:
				case STRING_LITERAL:
				case BEGIN_ACTION:
				case SEMI:
				case LPAREN:
				case RPAREN:
				case RARROW:
				case OR:
				case DOT:
				case NOT:
					{
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case BEGIN_ACTION:
				enterOuterAlt(_localctx, 3);
				{
				setState(615);
				actionBlock();
				setState(618);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case QUESTION:
					{
					setState(616);
					match(QUESTION);
					}
					break;
				case TOKEN_ID:
				case LEXER_CHAR_SET:
				case STRING_LITERAL:
				case BEGIN_ACTION:
				case SEMI:
				case LPAREN:
				case RPAREN:
				case RARROW:
				case OR:
				case DOT:
				case NOT:
					{
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
		enterRule(_localctx, 114, RULE_lexerRuleElementBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(622);
			match(LPAREN);
			setState(623);
			lexerRuleBlock();
			setState(624);
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
		enterRule(_localctx, 116, RULE_lexerCommands);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(626);
			match(RARROW);
			setState(627);
			lexerCommand();
			setState(635);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMMA:
				{
				setState(630); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(628);
					match(COMMA);
					setState(629);
					lexerCommand();
					}
					}
					setState(632); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				}
				break;
			case SEMI:
			case RPAREN:
			case OR:
				{
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

	public static class LexerCommandContext extends ParserRuleContext {
		public TerminalNode LEXCOM_SKIP() { return getToken(ANTLRv4Parser.LEXCOM_SKIP, 0); }
		public TerminalNode LEXCOM_MORE() { return getToken(ANTLRv4Parser.LEXCOM_MORE, 0); }
		public TerminalNode LEXCOM_TYPE() { return getToken(ANTLRv4Parser.LEXCOM_TYPE, 0); }
		public TerminalNode LPAREN() { return getToken(ANTLRv4Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ANTLRv4Parser.RPAREN, 0); }
		public TerminalNode TOKEN_ID() { return getToken(ANTLRv4Parser.TOKEN_ID, 0); }
		public TerminalNode INT() { return getToken(ANTLRv4Parser.INT, 0); }
		public LexComChannelContext lexComChannel() {
			return getRuleContext(LexComChannelContext.class,0);
		}
		public LexComModeContext lexComMode() {
			return getRuleContext(LexComModeContext.class,0);
		}
		public LexComPushModeContext lexComPushMode() {
			return getRuleContext(LexComPushModeContext.class,0);
		}
		public TerminalNode LEXCOM_POPMODE() { return getToken(ANTLRv4Parser.LEXCOM_POPMODE, 0); }
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
		enterRule(_localctx, 118, RULE_lexerCommand);
		int _la;
		try {
			setState(647);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEXCOM_SKIP:
				enterOuterAlt(_localctx, 1);
				{
				setState(637);
				match(LEXCOM_SKIP);
				}
				break;
			case LEXCOM_MORE:
				enterOuterAlt(_localctx, 2);
				{
				setState(638);
				match(LEXCOM_MORE);
				}
				break;
			case LEXCOM_TYPE:
				enterOuterAlt(_localctx, 3);
				{
				setState(639);
				match(LEXCOM_TYPE);
				setState(640);
				match(LPAREN);
				setState(641);
				_la = _input.LA(1);
				if ( !(_la==TOKEN_ID || _la==INT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(642);
				match(RPAREN);
				}
				break;
			case LEXCOM_CHANNEL:
				enterOuterAlt(_localctx, 4);
				{
				setState(643);
				lexComChannel();
				}
				break;
			case LEXCOM_MODE:
				enterOuterAlt(_localctx, 5);
				{
				setState(644);
				lexComMode();
				}
				break;
			case LEXCOM_PUSHMODE:
				enterOuterAlt(_localctx, 6);
				{
				setState(645);
				lexComPushMode();
				}
				break;
			case LEXCOM_POPMODE:
				enterOuterAlt(_localctx, 7);
				{
				setState(646);
				match(LEXCOM_POPMODE);
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

	public static class LexComChannelContext extends ParserRuleContext {
		public TerminalNode LEXCOM_CHANNEL() { return getToken(ANTLRv4Parser.LEXCOM_CHANNEL, 0); }
		public TerminalNode LPAREN() { return getToken(ANTLRv4Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ANTLRv4Parser.RPAREN, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode INT() { return getToken(ANTLRv4Parser.INT, 0); }
		public LexComChannelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lexComChannel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterLexComChannel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitLexComChannel(this);
		}
	}

	public final LexComChannelContext lexComChannel() throws RecognitionException {
		LexComChannelContext _localctx = new LexComChannelContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_lexComChannel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(649);
			match(LEXCOM_CHANNEL);
			setState(650);
			match(LPAREN);
			setState(653);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(651);
				identifier();
				}
				break;
			case INT:
				{
				setState(652);
				match(INT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(655);
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

	public static class LexComModeContext extends ParserRuleContext {
		public TerminalNode LEXCOM_MODE() { return getToken(ANTLRv4Parser.LEXCOM_MODE, 0); }
		public TerminalNode LPAREN() { return getToken(ANTLRv4Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ANTLRv4Parser.RPAREN, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode INT() { return getToken(ANTLRv4Parser.INT, 0); }
		public LexComModeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lexComMode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterLexComMode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitLexComMode(this);
		}
	}

	public final LexComModeContext lexComMode() throws RecognitionException {
		LexComModeContext _localctx = new LexComModeContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_lexComMode);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(657);
			match(LEXCOM_MODE);
			setState(658);
			match(LPAREN);
			setState(661);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(659);
				identifier();
				}
				break;
			case INT:
				{
				setState(660);
				match(INT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(663);
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

	public static class LexComPushModeContext extends ParserRuleContext {
		public TerminalNode LEXCOM_PUSHMODE() { return getToken(ANTLRv4Parser.LEXCOM_PUSHMODE, 0); }
		public TerminalNode LPAREN() { return getToken(ANTLRv4Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ANTLRv4Parser.RPAREN, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode INT() { return getToken(ANTLRv4Parser.INT, 0); }
		public LexComPushModeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lexComPushMode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).enterLexComPushMode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ANTLRv4Listener ) ((ANTLRv4Listener)listener).exitLexComPushMode(this);
		}
	}

	public final LexComPushModeContext lexComPushMode() throws RecognitionException {
		LexComPushModeContext _localctx = new LexComPushModeContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_lexComPushMode);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(665);
			match(LEXCOM_PUSHMODE);
			setState(666);
			match(LPAREN);
			setState(669);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(667);
				identifier();
				}
				break;
			case INT:
				{
				setState(668);
				match(INT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(671);
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
		enterRule(_localctx, 126, RULE_lexerRuleAtom);
		try {
			setState(682);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,83,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(673);
				characterRange();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(674);
				terminal();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(675);
				notSet();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(676);
				match(LEXER_CHAR_SET);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(677);
				match(DOT);
				setState(680);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LT:
					{
					setState(678);
					elementOptions();
					}
					break;
				case TOKEN_ID:
				case LEXER_CHAR_SET:
				case STRING_LITERAL:
				case BEGIN_ACTION:
				case SEMI:
				case LPAREN:
				case RPAREN:
				case RARROW:
				case QUESTION:
				case STAR:
				case PLUS:
				case OR:
				case DOT:
				case NOT:
					{
					}
					break;
				default:
					throw new NoViableAltException(this);
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
		public EbnfSuffixContext ebnfSuffix() {
			return getRuleContext(EbnfSuffixContext.class,0);
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
		enterRule(_localctx, 128, RULE_ebnf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(684);
			block();
			setState(687);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case QUESTION:
			case STAR:
			case PLUS:
				{
				setState(685);
				ebnfSuffix();
				}
				break;
			case TOKEN_ID:
			case PARSER_RULE_ID:
			case ID:
			case STRING_LITERAL:
			case BEGIN_ACTION:
			case SEMI:
			case LPAREN:
			case RPAREN:
			case OR:
			case DOT:
			case SHARP:
			case NOT:
				{
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
		enterRule(_localctx, 130, RULE_ebnfSuffix);
		try {
			setState(704);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case QUESTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(689);
				match(QUESTION);
				setState(692);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case QUESTION:
					{
					setState(690);
					match(QUESTION);
					}
					break;
				case TOKEN_ID:
				case PARSER_RULE_ID:
				case ID:
				case LEXER_CHAR_SET:
				case STRING_LITERAL:
				case BEGIN_ACTION:
				case SEMI:
				case LPAREN:
				case RPAREN:
				case RARROW:
				case OR:
				case DOT:
				case SHARP:
				case NOT:
					{
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(694);
				match(STAR);
				setState(697);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case QUESTION:
					{
					setState(695);
					match(QUESTION);
					}
					break;
				case TOKEN_ID:
				case PARSER_RULE_ID:
				case ID:
				case LEXER_CHAR_SET:
				case STRING_LITERAL:
				case BEGIN_ACTION:
				case SEMI:
				case LPAREN:
				case RPAREN:
				case RARROW:
				case OR:
				case DOT:
				case SHARP:
				case NOT:
					{
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case PLUS:
				enterOuterAlt(_localctx, 3);
				{
				setState(699);
				match(PLUS);
				setState(702);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case QUESTION:
					{
					setState(700);
					match(QUESTION);
					}
					break;
				case TOKEN_ID:
				case PARSER_RULE_ID:
				case ID:
				case LEXER_CHAR_SET:
				case STRING_LITERAL:
				case BEGIN_ACTION:
				case SEMI:
				case LPAREN:
				case RPAREN:
				case RARROW:
				case OR:
				case DOT:
				case SHARP:
				case NOT:
					{
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
		enterRule(_localctx, 132, RULE_notSet);
		try {
			setState(710);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,89,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(706);
				match(NOT);
				setState(707);
				setElement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(708);
				match(NOT);
				setState(709);
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
		enterRule(_localctx, 134, RULE_blockSet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(712);
			match(LPAREN);
			setState(713);
			setElement();
			setState(721);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OR:
				{
				setState(716); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(714);
					match(OR);
					setState(715);
					setElement();
					}
					}
					setState(718); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==OR );
				}
				break;
			case RPAREN:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(723);
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
		public TerminalNode TOKEN_ID() { return getToken(ANTLRv4Parser.TOKEN_ID, 0); }
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
		enterRule(_localctx, 136, RULE_setElement);
		try {
			setState(737);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,94,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(725);
				match(TOKEN_ID);
				setState(728);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LT:
					{
					setState(726);
					elementOptions();
					}
					break;
				case TOKEN_ID:
				case PARSER_RULE_ID:
				case ID:
				case LEXER_CHAR_SET:
				case STRING_LITERAL:
				case BEGIN_ACTION:
				case SEMI:
				case LPAREN:
				case RPAREN:
				case RARROW:
				case QUESTION:
				case STAR:
				case PLUS:
				case OR:
				case DOT:
				case SHARP:
				case NOT:
					{
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(730);
				match(STRING_LITERAL);
				setState(733);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LT:
					{
					setState(731);
					elementOptions();
					}
					break;
				case TOKEN_ID:
				case PARSER_RULE_ID:
				case ID:
				case LEXER_CHAR_SET:
				case STRING_LITERAL:
				case BEGIN_ACTION:
				case SEMI:
				case LPAREN:
				case RPAREN:
				case RARROW:
				case QUESTION:
				case STAR:
				case PLUS:
				case OR:
				case DOT:
				case SHARP:
				case NOT:
					{
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(735);
				characterRange();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(736);
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
		enterRule(_localctx, 138, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(739);
			match(LPAREN);
			setState(754);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPTIONS:
			case COLON:
			case AT:
				{
				{
				setState(742);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case OPTIONS:
					{
					setState(740);
					optionsSpec();
					}
					break;
				case COLON:
				case AT:
					{
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(750);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case AT:
					{
					setState(745); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(744);
						ruleAction();
						}
						}
						setState(747); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==AT );
					}
					break;
				case COLON:
					{
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(752);
				match(COLON);
				}
				}
				break;
			case TOKEN_ID:
			case PARSER_RULE_ID:
			case ID:
			case STRING_LITERAL:
			case BEGIN_ACTION:
			case LPAREN:
			case RPAREN:
			case OR:
			case DOT:
			case NOT:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(756);
			altList();
			setState(757);
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
		enterRule(_localctx, 140, RULE_characterRange);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(759);
			match(STRING_LITERAL);
			setState(760);
			match(RANGE);
			setState(761);
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
		public TerminalNode TOKEN_ID() { return getToken(ANTLRv4Parser.TOKEN_ID, 0); }
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
		enterRule(_localctx, 142, RULE_terminal);
		try {
			setState(773);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TOKEN_ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(763);
				match(TOKEN_ID);
				setState(766);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LT:
					{
					setState(764);
					elementOptions();
					}
					break;
				case TOKEN_ID:
				case PARSER_RULE_ID:
				case ID:
				case LEXER_CHAR_SET:
				case STRING_LITERAL:
				case BEGIN_ACTION:
				case SEMI:
				case LPAREN:
				case RPAREN:
				case RARROW:
				case QUESTION:
				case STAR:
				case PLUS:
				case OR:
				case DOT:
				case SHARP:
				case NOT:
					{
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(768);
				match(STRING_LITERAL);
				setState(771);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LT:
					{
					setState(769);
					elementOptions();
					}
					break;
				case TOKEN_ID:
				case PARSER_RULE_ID:
				case ID:
				case LEXER_CHAR_SET:
				case STRING_LITERAL:
				case BEGIN_ACTION:
				case SEMI:
				case LPAREN:
				case RPAREN:
				case RARROW:
				case QUESTION:
				case STAR:
				case PLUS:
				case OR:
				case DOT:
				case SHARP:
				case NOT:
					{
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
		enterRule(_localctx, 144, RULE_elementOptions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(775);
			match(LT);
			setState(776);
			elementOption();
			setState(784);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMMA:
				{
				setState(779); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(777);
					match(COMMA);
					setState(778);
					elementOption();
					}
					}
					setState(781); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				}
				break;
			case GT:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(786);
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
		enterRule(_localctx, 146, RULE_elementOption);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(788);
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
		enterRule(_localctx, 148, RULE_tokenOption);
		int _la;
		try {
			setState(799);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ASSOC:
				enterOuterAlt(_localctx, 1);
				{
				setState(790);
				match(ASSOC);
				setState(791);
				match(ASSIGN);
				setState(792);
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
				setState(793);
				match(FAIL);
				setState(794);
				match(ASSIGN);
				setState(797);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING_LITERAL:
					{
					setState(795);
					match(STRING_LITERAL);
					}
					break;
				case BEGIN_ACTION:
					{
					setState(796);
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
		enterRule(_localctx, 150, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(801);
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
		public TerminalNode TOKEN_ID() { return getToken(ANTLRv4Parser.TOKEN_ID, 0); }
		public TerminalNode PARSER_RULE_ID() { return getToken(ANTLRv4Parser.PARSER_RULE_ID, 0); }
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
		enterRule(_localctx, 152, RULE_ruleElementIdentifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(803);
			_la = _input.LA(1);
			if ( !(_la==TOKEN_ID || _la==PARSER_RULE_ID) ) {
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
		enterRule(_localctx, 154, RULE_classIdentifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(805);
			identifier();
			setState(813);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOT:
				{
				setState(808); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(806);
					match(DOT);
					setState(807);
					identifier();
					}
					}
					setState(810); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==DOT );
				}
				break;
			case SEMI:
				{
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
		enterRule(_localctx, 156, RULE_genericClassIdentifier);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(815);
			identifier();
			setState(823);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,109,_ctx) ) {
			case 1:
				{
				setState(818); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(816);
						match(DOT);
						setState(817);
						identifier();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(820); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,108,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				{
				}
				break;
			}
			setState(825);
			match(DOT);
			setState(826);
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
		enterRule(_localctx, 158, RULE_packageIdentifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(828);
			identifier();
			setState(836);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOT:
				{
				setState(831); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(829);
					match(DOT);
					setState(830);
					identifier();
					}
					}
					setState(833); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==DOT );
				}
				break;
			case SEMI:
				{
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

	public static class ParserRuleIdentifierContext extends ParserRuleContext {
		public TerminalNode PARSER_RULE_ID() { return getToken(ANTLRv4Parser.PARSER_RULE_ID, 0); }
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
		enterRule(_localctx, 160, RULE_parserRuleIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(838);
			match(PARSER_RULE_ID);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u0098\u034b\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\3\2\3\2\6\2"+
		"\u00a7\n\2\r\2\16\2\u00a8\3\2\5\2\u00ac\n\2\3\2\6\2\u00af\n\2\r\2\16\2"+
		"\u00b0\3\2\6\2\u00b4\n\2\r\2\16\2\u00b5\3\2\5\2\u00b9\n\2\3\2\3\2\3\3"+
		"\6\3\u00be\n\3\r\3\16\3\u00bf\3\3\5\3\u00c3\n\3\3\3\3\3\3\3\3\3\3\4\3"+
		"\4\3\4\3\4\3\4\5\4\u00ce\n\4\3\5\6\5\u00d1\n\5\r\5\16\5\u00d2\3\5\5\5"+
		"\u00d6\n\5\3\5\3\5\3\5\3\5\3\5\5\5\u00dd\n\5\3\6\3\6\3\6\3\6\3\6\6\6\u00e4"+
		"\n\6\r\6\16\6\u00e5\3\6\5\6\u00e9\n\6\3\6\3\6\3\7\3\7\3\7\3\7\5\7\u00f1"+
		"\n\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\6\r\u010a\n\r\r\r\16\r\u010b\3\r\5\r\u010f"+
		"\n\r\3\16\3\16\3\16\3\16\5\16\u0115\n\16\3\16\3\16\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\5\20\u011f\n\20\3\20\3\20\3\21\3\21\3\21\6\21\u0126\n\21\r"+
		"\21\16\21\u0127\3\21\5\21\u012b\n\21\3\22\3\22\3\22\3\22\5\22\u0131\n"+
		"\22\3\22\3\22\3\23\3\23\3\23\6\23\u0138\n\23\r\23\16\23\u0139\3\23\5\23"+
		"\u013d\n\23\3\24\3\24\3\24\3\24\3\24\5\24\u0144\n\24\3\24\3\24\5\24\u0148"+
		"\n\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\3\31"+
		"\5\31\u0157\n\31\3\31\7\31\u015a\n\31\f\31\16\31\u015d\13\31\3\32\3\32"+
		"\3\32\3\32\3\33\3\33\3\34\3\34\5\34\u0167\n\34\3\34\3\34\5\34\u016b\n"+
		"\34\3\34\3\34\3\35\3\35\6\35\u0171\n\35\r\35\16\35\u0172\3\35\5\35\u0176"+
		"\n\35\3\35\3\35\3\36\6\36\u017b\n\36\r\36\16\36\u017c\3\36\5\36\u0180"+
		"\n\36\3\36\3\36\6\36\u0184\n\36\r\36\16\36\u0185\3\36\5\36\u0189\n\36"+
		"\3\37\3\37\3\37\3\37\3 \3 \5 \u0191\n \3!\6!\u0194\n!\r!\16!\u0195\3!"+
		"\5!\u0199\n!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\5\"\u01a4\n\"\3\"\3\"\5\"\u01a8"+
		"\n\"\3\"\3\"\5\"\u01ac\n\"\3\"\3\"\5\"\u01b0\n\"\3\"\6\"\u01b3\n\"\r\""+
		"\16\"\u01b4\3\"\5\"\u01b8\n\"\3#\6#\u01bb\n#\r#\16#\u01bc\3#\5#\u01c0"+
		"\n#\3#\3#\5#\u01c4\n#\3$\3$\3$\3$\3%\3%\3%\3&\3&\5&\u01cf\n&\3\'\3\'\3"+
		"\'\3(\3(\3(\3(\7(\u01d8\n(\f(\16(\u01db\13(\3)\3)\3)\3*\3*\3*\3*\3+\3"+
		"+\3+\7+\u01e7\n+\f+\16+\u01ea\13+\3,\3,\3,\5,\u01ef\n,\3-\3-\3-\7-\u01f4"+
		"\n-\f-\16-\u01f7\13-\3.\6.\u01fa\n.\r.\16.\u01fb\3.\5.\u01ff\n.\3/\3/"+
		"\5/\u0203\n/\3/\3/\5/\u0207\n/\3/\3/\3/\3/\3/\5/\u020e\n/\5/\u0210\n/"+
		"\3\60\3\60\3\60\3\60\5\60\u0216\n\60\3\61\3\61\3\61\3\61\3\61\3\61\5\61"+
		"\u021e\n\61\5\61\u0220\n\61\3\62\3\62\5\62\u0224\n\62\3\62\5\62\u0227"+
		"\n\62\3\63\3\63\7\63\u022b\n\63\f\63\16\63\u022e\13\63\3\63\3\63\3\64"+
		"\6\64\u0233\n\64\r\64\16\64\u0234\3\64\5\64\u0238\n\64\3\64\3\64\5\64"+
		"\u023c\n\64\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\66\3\67"+
		"\3\67\3\67\6\67\u024c\n\67\r\67\16\67\u024d\3\67\5\67\u0251\n\67\38\3"+
		"8\38\58\u0256\n8\38\58\u0259\n8\39\69\u025c\n9\r9\169\u025d\3:\3:\3:\5"+
		":\u0263\n:\3:\3:\3:\5:\u0268\n:\3:\3:\3:\5:\u026d\n:\5:\u026f\n:\3;\3"+
		";\3;\3;\3<\3<\3<\3<\6<\u0279\n<\r<\16<\u027a\3<\5<\u027e\n<\3=\3=\3=\3"+
		"=\3=\3=\3=\3=\3=\3=\5=\u028a\n=\3>\3>\3>\3>\5>\u0290\n>\3>\3>\3?\3?\3"+
		"?\3?\5?\u0298\n?\3?\3?\3@\3@\3@\3@\5@\u02a0\n@\3@\3@\3A\3A\3A\3A\3A\3"+
		"A\3A\5A\u02ab\nA\5A\u02ad\nA\3B\3B\3B\5B\u02b2\nB\3C\3C\3C\5C\u02b7\n"+
		"C\3C\3C\3C\5C\u02bc\nC\3C\3C\3C\5C\u02c1\nC\5C\u02c3\nC\3D\3D\3D\3D\5"+
		"D\u02c9\nD\3E\3E\3E\3E\6E\u02cf\nE\rE\16E\u02d0\3E\5E\u02d4\nE\3E\3E\3"+
		"F\3F\3F\5F\u02db\nF\3F\3F\3F\5F\u02e0\nF\3F\3F\5F\u02e4\nF\3G\3G\3G\5"+
		"G\u02e9\nG\3G\6G\u02ec\nG\rG\16G\u02ed\3G\5G\u02f1\nG\3G\3G\5G\u02f5\n"+
		"G\3G\3G\3G\3H\3H\3H\3H\3I\3I\3I\5I\u0301\nI\3I\3I\3I\5I\u0306\nI\5I\u0308"+
		"\nI\3J\3J\3J\3J\6J\u030e\nJ\rJ\16J\u030f\3J\5J\u0313\nJ\3J\3J\3K\3K\3"+
		"L\3L\3L\3L\3L\3L\3L\5L\u0320\nL\5L\u0322\nL\3M\3M\3N\3N\3O\3O\3O\6O\u032b"+
		"\nO\rO\16O\u032c\3O\5O\u0330\nO\3P\3P\3P\6P\u0335\nP\rP\16P\u0336\3P\5"+
		"P\u033a\nP\3P\3P\3P\3Q\3Q\3Q\6Q\u0342\nQ\rQ\16Q\u0343\3Q\5Q\u0347\nQ\3"+
		"R\3R\3R\2\2S\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64"+
		"\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088"+
		"\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0"+
		"\u00a2\2\b\3\2\24\25\3\2\31\32\4\2..\61\61\4\2\3\3\n\n\3\2*+\3\2\3\4\u0381"+
		"\2\u00a4\3\2\2\2\4\u00c2\3\2\2\2\6\u00cd\3\2\2\2\b\u00d5\3\2\2\2\n\u00de"+
		"\3\2\2\2\f\u00f0\3\2\2\2\16\u00f2\3\2\2\2\20\u00f6\3\2\2\2\22\u00fa\3"+
		"\2\2\2\24\u00fe\3\2\2\2\26\u0102\3\2\2\2\30\u0106\3\2\2\2\32\u0114\3\2"+
		"\2\2\34\u0118\3\2\2\2\36\u011a\3\2\2\2 \u0122\3\2\2\2\"\u012c\3\2\2\2"+
		"$\u0134\3\2\2\2&\u013e\3\2\2\2(\u0149\3\2\2\2*\u014c\3\2\2\2,\u014f\3"+
		"\2\2\2.\u0151\3\2\2\2\60\u0156\3\2\2\2\62\u015e\3\2\2\2\64\u0162\3\2\2"+
		"\2\66\u0164\3\2\2\28\u016e\3\2\2\2:\u017f\3\2\2\2<\u018a\3\2\2\2>\u0190"+
		"\3\2\2\2@\u0198\3\2\2\2B\u01a0\3\2\2\2D\u01bf\3\2\2\2F\u01c5\3\2\2\2H"+
		"\u01c9\3\2\2\2J\u01ce\3\2\2\2L\u01d0\3\2\2\2N\u01d3\3\2\2\2P\u01dc\3\2"+
		"\2\2R\u01df\3\2\2\2T\u01e3\3\2\2\2V\u01eb\3\2\2\2X\u01f0\3\2\2\2Z\u01fe"+
		"\3\2\2\2\\\u020f\3\2\2\2^\u0211\3\2\2\2`\u021f\3\2\2\2b\u0221\3\2\2\2"+
		"d\u0228\3\2\2\2f\u0237\3\2\2\2h\u023d\3\2\2\2j\u0242\3\2\2\2l\u0248\3"+
		"\2\2\2n\u0258\3\2\2\2p\u025b\3\2\2\2r\u026e\3\2\2\2t\u0270\3\2\2\2v\u0274"+
		"\3\2\2\2x\u0289\3\2\2\2z\u028b\3\2\2\2|\u0293\3\2\2\2~\u029b\3\2\2\2\u0080"+
		"\u02ac\3\2\2\2\u0082\u02ae\3\2\2\2\u0084\u02c2\3\2\2\2\u0086\u02c8\3\2"+
		"\2\2\u0088\u02ca\3\2\2\2\u008a\u02e3\3\2\2\2\u008c\u02e5\3\2\2\2\u008e"+
		"\u02f9\3\2\2\2\u0090\u0307\3\2\2\2\u0092\u0309\3\2\2\2\u0094\u0316\3\2"+
		"\2\2\u0096\u0321\3\2\2\2\u0098\u0323\3\2\2\2\u009a\u0325\3\2\2\2\u009c"+
		"\u0327\3\2\2\2\u009e\u0331\3\2\2\2\u00a0\u033e\3\2\2\2\u00a2\u0348\3\2"+
		"\2\2\u00a4\u00ab\5\4\3\2\u00a5\u00a7\5\b\5\2\u00a6\u00a5\3\2\2\2\u00a7"+
		"\u00a8\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ac\3\2"+
		"\2\2\u00aa\u00ac\3\2\2\2\u00ab\u00a6\3\2\2\2\u00ab\u00aa\3\2\2\2\u00ac"+
		"\u00ae\3\2\2\2\u00ad\u00af\5> \2\u00ae\u00ad\3\2\2\2\u00af\u00b0\3\2\2"+
		"\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b8\3\2\2\2\u00b2\u00b4"+
		"\5:\36\2\u00b3\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5"+
		"\u00b6\3\2\2\2\u00b6\u00b9\3\2\2\2\u00b7\u00b9\3\2\2\2\u00b8\u00b3\3\2"+
		"\2\2\u00b8\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\7\2\2\3\u00bb"+
		"\3\3\2\2\2\u00bc\u00be\7\7\2\2\u00bd\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2"+
		"\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00c3"+
		"\3\2\2\2\u00c2\u00bd\3\2\2\2\u00c2\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4"+
		"\u00c5\5\6\4\2\u00c5\u00c6\5\u0098M\2\u00c6\u00c7\7\"\2\2\u00c7\5\3\2"+
		"\2\2\u00c8\u00c9\7\24\2\2\u00c9\u00ce\7\26\2\2\u00ca\u00cb\7\25\2\2\u00cb"+
		"\u00ce\7\26\2\2\u00cc\u00ce\7\26\2\2\u00cd\u00c8\3\2\2\2\u00cd\u00ca\3"+
		"\2\2\2\u00cd\u00cc\3\2\2\2\u00ce\7\3\2\2\2\u00cf\u00d1\7\7\2\2\u00d0\u00cf"+
		"\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3"+
		"\u00d6\3\2\2\2\u00d4\u00d6\3\2\2\2\u00d5\u00d0\3\2\2\2\u00d5\u00d4\3\2"+
		"\2\2\u00d6\u00dc\3\2\2\2\u00d7\u00dd\5\n\6\2\u00d8\u00dd\5\26\f\2\u00d9"+
		"\u00dd\5\36\20\2\u00da\u00dd\5\"\22\2\u00db\u00dd\5&\24\2\u00dc\u00d7"+
		"\3\2\2\2\u00dc\u00d8\3\2\2\2\u00dc\u00d9\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc"+
		"\u00db\3\2\2\2\u00dd\t\3\2\2\2\u00de\u00df\7\17\2\2\u00df\u00e8\7%\2\2"+
		"\u00e0\u00e1\5\f\7\2\u00e1\u00e2\7\"\2\2\u00e2\u00e4\3\2\2\2\u00e3\u00e0"+
		"\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6"+
		"\u00e9\3\2\2\2\u00e7\u00e9\3\2\2\2\u00e8\u00e3\3\2\2\2\u00e8\u00e7\3\2"+
		"\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb\7&\2\2\u00eb\13\3\2\2\2\u00ec\u00f1"+
		"\5\16\b\2\u00ed\u00f1\5\20\t\2\u00ee\u00f1\5\22\n\2\u00ef\u00f1\5\24\13"+
		"\2\u00f0\u00ec\3\2\2\2\u00f0\u00ed\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00ef"+
		"\3\2\2\2\u00f1\r\3\2\2\2\u00f2\u00f3\7_\2\2\u00f3\u00f4\7.\2\2\u00f4\u00f5"+
		"\5\u009cO\2\u00f5\17\3\2\2\2\u00f6\u00f7\7`\2\2\u00f7\u00f8\7.\2\2\u00f8"+
		"\u00f9\7\13\2\2\u00f9\21\3\2\2\2\u00fa\u00fb\7a\2\2\u00fb\u00fc\7.\2\2"+
		"\u00fc\u00fd\5\u0098M\2\u00fd\23\3\2\2\2\u00fe\u00ff\7b\2\2\u00ff\u0100"+
		"\7.\2\2\u0100\u0101\5\u009cO\2\u0101\25\3\2\2\2\u0102\u0103\7\22\2\2\u0103"+
		"\u0104\5\30\r\2\u0104\u0105\7\"\2\2\u0105\27\3\2\2\2\u0106\u010e\5\32"+
		"\16\2\u0107\u0108\7!\2\2\u0108\u010a\5\32\16\2\u0109\u0107\3\2\2\2\u010a"+
		"\u010b\3\2\2\2\u010b\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010f\3\2"+
		"\2\2\u010d\u010f\3\2\2\2\u010e\u0109\3\2\2\2\u010e\u010d\3\2\2\2\u010f"+
		"\31\3\2\2\2\u0110\u0111\5\u0098M\2\u0111\u0112\7.\2\2\u0112\u0115\3\2"+
		"\2\2\u0113\u0115\3\2\2\2\u0114\u0110\3\2\2\2\u0114\u0113\3\2\2\2\u0115"+
		"\u0116\3\2\2\2\u0116\u0117\5\34\17\2\u0117\33\3\2\2\2\u0118\u0119\5\u0098"+
		"M\2\u0119\35\3\2\2\2\u011a\u011b\7\20\2\2\u011b\u011e\7%\2\2\u011c\u011f"+
		"\5 \21\2\u011d\u011f\3\2\2\2\u011e\u011c\3\2\2\2\u011e\u011d\3\2\2\2\u011f"+
		"\u0120\3\2\2\2\u0120\u0121\7&\2\2\u0121\37\3\2\2\2\u0122\u012a\7\3\2\2"+
		"\u0123\u0124\7!\2\2\u0124\u0126\7\3\2\2\u0125\u0123\3\2\2\2\u0126\u0127"+
		"\3\2\2\2\u0127\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u012b\3\2\2\2\u0129"+
		"\u012b\3\2\2\2\u012a\u0125\3\2\2\2\u012a\u0129\3\2\2\2\u012b!\3\2\2\2"+
		"\u012c\u012d\7\21\2\2\u012d\u0130\7%\2\2\u012e\u0131\5$\23\2\u012f\u0131"+
		"\3\2\2\2\u0130\u012e\3\2\2\2\u0130\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132"+
		"\u0133\7&\2\2\u0133#\3\2\2\2\u0134\u013c\5\u0098M\2\u0135\u0136\7!\2\2"+
		"\u0136\u0138\5\u0098M\2\u0137\u0135\3\2\2\2\u0138\u0139\3\2\2\2\u0139"+
		"\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013d\3\2\2\2\u013b\u013d\3\2"+
		"\2\2\u013c\u0137\3\2\2\2\u013c\u013b\3\2\2\2\u013d%\3\2\2\2\u013e\u0143"+
		"\7\67\2\2\u013f\u0140\5,\27\2\u0140\u0141\7 \2\2\u0141\u0144\3\2\2\2\u0142"+
		"\u0144\3\2\2\2\u0143\u013f\3\2\2\2\u0143\u0142\3\2\2\2\u0144\u0147\3\2"+
		"\2\2\u0145\u0148\5(\25\2\u0146\u0148\5*\26\2\u0147\u0145\3\2\2\2\u0147"+
		"\u0146\3\2\2\2\u0148\'\3\2\2\2\u0149\u014a\78\2\2\u014a\u014b\5.\30\2"+
		"\u014b)\3\2\2\2\u014c\u014d\79\2\2\u014d\u014e\58\35\2\u014e+\3\2\2\2"+
		"\u014f\u0150\t\2\2\2\u0150-\3\2\2\2\u0151\u0152\7\16\2\2\u0152\u0153\5"+
		"\60\31\2\u0153\u0154\7Y\2\2\u0154/\3\2\2\2\u0155\u0157\5\62\32\2\u0156"+
		"\u0155\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u015b\3\2\2\2\u0158\u015a\5\64"+
		"\33\2\u0159\u0158\3\2\2\2\u015a\u015d\3\2\2\2\u015b\u0159\3\2\2\2\u015b"+
		"\u015c\3\2\2\2\u015c\61\3\2\2\2\u015d\u015b\3\2\2\2\u015e\u015f\7J\2\2"+
		"\u015f\u0160\5\u00a0Q\2\u0160\u0161\7\"\2\2\u0161\63\3\2\2\2\u0162\u0163"+
		"\5\66\34\2\u0163\65\3\2\2\2\u0164\u0166\7K\2\2\u0165\u0167\7V\2\2\u0166"+
		"\u0165\3\2\2\2\u0166\u0167\3\2\2\2\u0167\u016a\3\2\2\2\u0168\u016b\5\u009c"+
		"O\2\u0169\u016b\5\u009eP\2\u016a\u0168\3\2\2\2\u016a\u0169\3\2\2\2\u016b"+
		"\u016c\3\2\2\2\u016c\u016d\7\"\2\2\u016d\67\3\2\2\2\u016e\u0175\7\16\2"+
		"\2\u016f\u0171\7[\2\2\u0170\u016f\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u0170"+
		"\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0176\3\2\2\2\u0174\u0176\3\2\2\2\u0175"+
		"\u0170\3\2\2\2\u0175\u0174\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u0178\7Y"+
		"\2\2\u01789\3\2\2\2\u0179\u017b\7\7\2\2\u017a\u0179\3\2\2\2\u017b\u017c"+
		"\3\2\2\2\u017c\u017a\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u0180\3\2\2\2\u017e"+
		"\u0180\3\2\2\2\u017f\u017a\3\2\2\2\u017f\u017e\3\2\2\2\u0180\u0181\3\2"+
		"\2\2\u0181\u0188\5<\37\2\u0182\u0184\5f\64\2\u0183\u0182\3\2\2\2\u0184"+
		"\u0185\3\2\2\2\u0185\u0183\3\2\2\2\u0185\u0186\3\2\2\2\u0186\u0189\3\2"+
		"\2\2\u0187\u0189\3\2\2\2\u0188\u0183\3\2\2\2\u0188\u0187\3\2\2\2\u0189"+
		";\3\2\2\2\u018a\u018b\7\36\2\2\u018b\u018c\5\u0098M\2\u018c\u018d\7\""+
		"\2\2\u018d=\3\2\2\2\u018e\u0191\5@!\2\u018f\u0191\5f\64\2\u0190\u018e"+
		"\3\2\2\2\u0190\u018f\3\2\2\2\u0191?\3\2\2\2\u0192\u0194\7\7\2\2\u0193"+
		"\u0192\3\2\2\2\u0194\u0195\3\2\2\2\u0195\u0193\3\2\2\2\u0195\u0196\3\2"+
		"\2\2\u0196\u0199\3\2\2\2\u0197\u0199\3\2\2\2\u0198\u0193\3\2\2\2\u0198"+
		"\u0197\3\2\2\2\u0199\u019a\3\2\2\2\u019a\u019b\5B\"\2\u019b\u019c\7\37"+
		"\2\2\u019c\u019d\5T+\2\u019d\u019e\7\"\2\2\u019e\u019f\5D#\2\u019fA\3"+
		"\2\2\2\u01a0\u01a3\5\u00a2R\2\u01a1\u01a4\5d\63\2\u01a2\u01a4\3\2\2\2"+
		"\u01a3\u01a1\3\2\2\2\u01a3\u01a2\3\2\2\2\u01a4\u01a7\3\2\2\2\u01a5\u01a8"+
		"\5L\'\2\u01a6\u01a8\3\2\2\2\u01a7\u01a5\3\2\2\2\u01a7\u01a6\3\2\2\2\u01a8"+
		"\u01ab\3\2\2\2\u01a9\u01ac\5N(\2\u01aa\u01ac\3\2\2\2\u01ab\u01a9\3\2\2"+
		"\2\u01ab\u01aa\3\2\2\2\u01ac\u01af\3\2\2\2\u01ad\u01b0\5P)\2\u01ae\u01b0"+
		"\3\2\2\2\u01af\u01ad\3\2\2\2\u01af\u01ae\3\2\2\2\u01b0\u01b7\3\2\2\2\u01b1"+
		"\u01b3\5J&\2\u01b2\u01b1\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4\u01b2\3\2\2"+
		"\2\u01b4\u01b5\3\2\2\2\u01b5\u01b8\3\2\2\2\u01b6\u01b8\3\2\2\2\u01b7\u01b2"+
		"\3\2\2\2\u01b7\u01b6\3\2\2\2\u01b8C\3\2\2\2\u01b9\u01bb\5F$\2\u01ba\u01b9"+
		"\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc\u01ba\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd"+
		"\u01c0\3\2\2\2\u01be\u01c0\3\2\2\2\u01bf\u01ba\3\2\2\2\u01bf\u01be\3\2"+
		"\2\2\u01c0\u01c3\3\2\2\2\u01c1\u01c4\5H%\2\u01c2\u01c4\3\2\2\2\u01c3\u01c1"+
		"\3\2\2\2\u01c3\u01c2\3\2\2\2\u01c4E\3\2\2\2\u01c5\u01c6\7\34\2\2\u01c6"+
		"\u01c7\5d\63\2\u01c7\u01c8\58\35\2\u01c8G\3\2\2\2\u01c9\u01ca\7\35\2\2"+
		"\u01ca\u01cb\58\35\2\u01cbI\3\2\2\2\u01cc\u01cf\5\n\6\2\u01cd\u01cf\5"+
		"R*\2\u01ce\u01cc\3\2\2\2\u01ce\u01cd\3\2\2\2\u01cfK\3\2\2\2\u01d0\u01d1"+
		"\7\27\2\2\u01d1\u01d2\5d\63\2\u01d2M\3\2\2\2\u01d3\u01d4\7\33\2\2\u01d4"+
		"\u01d9\5\u0098M\2\u01d5\u01d6\7!\2\2\u01d6\u01d8\5\u0098M\2\u01d7\u01d5"+
		"\3\2\2\2\u01d8\u01db\3\2\2\2\u01d9\u01d7\3\2\2\2\u01d9\u01da\3\2\2\2\u01da"+
		"O\3\2\2\2\u01db\u01d9\3\2\2\2\u01dc\u01dd\7\30\2\2\u01dd\u01de\5d\63\2"+
		"\u01deQ\3\2\2\2\u01df\u01e0\7\67\2\2\u01e0\u01e1\t\3\2\2\u01e1\u01e2\5"+
		"8\35\2\u01e2S\3\2\2\2\u01e3\u01e8\5V,\2\u01e4\u01e5\7\63\2\2\u01e5\u01e7"+
		"\5V,\2\u01e6\u01e4\3\2\2\2\u01e7\u01ea\3\2\2\2\u01e8\u01e6\3\2\2\2\u01e8"+
		"\u01e9\3\2\2\2\u01e9U\3\2\2\2\u01ea\u01e8\3\2\2\2\u01eb\u01ee\5Z.\2\u01ec"+
		"\u01ed\7:\2\2\u01ed\u01ef\5\u0098M\2\u01ee\u01ec\3\2\2\2\u01ee\u01ef\3"+
		"\2\2\2\u01efW\3\2\2\2\u01f0\u01f5\5Z.\2\u01f1\u01f2\7\63\2\2\u01f2\u01f4"+
		"\5Z.\2\u01f3\u01f1\3\2\2\2\u01f4\u01f7\3\2\2\2\u01f5\u01f3\3\2\2\2\u01f5"+
		"\u01f6\3\2\2\2\u01f6Y\3\2\2\2\u01f7\u01f5\3\2\2\2\u01f8\u01fa\5\\/\2\u01f9"+
		"\u01f8\3\2\2\2\u01fa\u01fb\3\2\2\2\u01fb\u01f9\3\2\2\2\u01fb\u01fc\3\2"+
		"\2\2\u01fc\u01ff\3\2\2\2\u01fd\u01ff\3\2\2\2\u01fe\u01f9\3\2\2\2\u01fe"+
		"\u01fd\3\2\2\2\u01ff[\3\2\2\2\u0200\u0202\5^\60\2\u0201\u0203\5\u0084"+
		"C\2\u0202\u0201\3\2\2\2\u0202\u0203\3\2\2\2\u0203\u0210\3\2\2\2\u0204"+
		"\u0206\5`\61\2\u0205\u0207\5\u0084C\2\u0206\u0205\3\2\2\2\u0206\u0207"+
		"\3\2\2\2\u0207\u0210\3\2\2\2\u0208\u0210\5\u0082B\2\u0209\u0210\58\35"+
		"\2\u020a\u020b\58\35\2\u020b\u020d\7/\2\2\u020c\u020e\5\u0092J\2\u020d"+
		"\u020c\3\2\2\2\u020d\u020e\3\2\2\2\u020e\u0210\3\2\2\2\u020f\u0200\3\2"+
		"\2\2\u020f\u0204\3\2\2\2\u020f\u0208\3\2\2\2\u020f\u0209\3\2\2\2\u020f"+
		"\u020a\3\2\2\2\u0210]\3\2\2\2\u0211\u0212\5\u0098M\2\u0212\u0215\t\4\2"+
		"\2\u0213\u0216\5`\61\2\u0214\u0216\5\u008cG\2\u0215\u0213\3\2\2\2\u0215"+
		"\u0214\3\2\2\2\u0216_\3\2\2\2\u0217\u0220\5\u008eH\2\u0218\u0220\5\u0090"+
		"I\2\u0219\u0220\5b\62\2\u021a\u0220\5\u0086D\2\u021b\u021d\7\66\2\2\u021c"+
		"\u021e\5\u0092J\2\u021d\u021c\3\2\2\2\u021d\u021e\3\2\2\2\u021e\u0220"+
		"\3\2\2\2\u021f\u0217\3\2\2\2\u021f\u0218\3\2\2\2\u021f\u0219\3\2\2\2\u021f"+
		"\u021a\3\2\2\2\u021f\u021b\3\2\2\2\u0220a\3\2\2\2\u0221\u0223\5\u00a2"+
		"R\2\u0222\u0224\5d\63\2\u0223\u0222\3\2\2\2\u0223\u0224\3\2\2\2\u0224"+
		"\u0226\3\2\2\2\u0225\u0227\5\u0092J\2\u0226\u0225\3\2\2\2\u0226\u0227"+
		"\3\2\2\2\u0227c\3\2\2\2\u0228\u022c\7\r\2\2\u0229\u022b\7A\2\2\u022a\u0229"+
		"\3\2\2\2\u022b\u022e\3\2\2\2\u022c\u022a\3\2\2\2\u022c\u022d\3\2\2\2\u022d"+
		"\u022f\3\2\2\2\u022e\u022c\3\2\2\2\u022f\u0230\7?\2\2\u0230e\3\2\2\2\u0231"+
		"\u0233\7\7\2\2\u0232\u0231\3\2\2\2\u0233\u0234\3\2\2\2\u0234\u0232\3\2"+
		"\2\2\u0234\u0235\3\2\2\2\u0235\u0238\3\2\2\2\u0236\u0238\3\2\2\2\u0237"+
		"\u0232\3\2\2\2\u0237\u0236\3\2\2\2\u0238\u023b\3\2\2\2\u0239\u023c\5h"+
		"\65\2\u023a\u023c\5j\66\2\u023b\u0239\3\2\2\2\u023b\u023a\3\2\2\2\u023c"+
		"g\3\2\2\2\u023d\u023e\7\3\2\2\u023e\u023f\7\37\2\2\u023f\u0240\5l\67\2"+
		"\u0240\u0241\7\"\2\2\u0241i\3\2\2\2\u0242\u0243\7\23\2\2\u0243\u0244\7"+
		"\3\2\2\u0244\u0245\7\37\2\2\u0245\u0246\5l\67\2\u0246\u0247\7\"\2\2\u0247"+
		"k\3\2\2\2\u0248\u0250\5n8\2\u0249\u024a\7\63\2\2\u024a\u024c\5n8\2\u024b"+
		"\u0249\3\2\2\2\u024c\u024d\3\2\2\2\u024d\u024b\3\2\2\2\u024d\u024e\3\2"+
		"\2\2\u024e\u0251\3\2\2\2\u024f\u0251\3\2\2\2\u0250\u024b\3\2\2\2\u0250"+
		"\u024f\3\2\2\2\u0251m\3\2\2\2\u0252\u0255\5p9\2\u0253\u0256\5v<\2\u0254"+
		"\u0256\3\2\2\2\u0255\u0253\3\2\2\2\u0255\u0254\3\2\2\2\u0256\u0259\3\2"+
		"\2\2\u0257\u0259\3\2\2\2\u0258\u0252\3\2\2\2\u0258\u0257\3\2\2\2\u0259"+
		"o\3\2\2\2\u025a\u025c\5r:\2\u025b\u025a\3\2\2\2\u025c\u025d\3\2\2\2\u025d"+
		"\u025b\3\2\2\2\u025d\u025e\3\2\2\2\u025eq\3\2\2\2\u025f\u0262\5\u0080"+
		"A\2\u0260\u0263\5\u0084C\2\u0261\u0263\3\2\2\2\u0262\u0260\3\2\2\2\u0262"+
		"\u0261\3\2\2\2\u0263\u026f\3\2\2\2\u0264\u0267\5t;\2\u0265\u0268\5\u0084"+
		"C\2\u0266\u0268\3\2\2\2\u0267\u0265\3\2\2\2\u0267\u0266\3\2\2\2\u0268"+
		"\u026f\3\2\2\2\u0269\u026c\58\35\2\u026a\u026d\7/\2\2\u026b\u026d\3\2"+
		"\2\2\u026c\u026a\3\2\2\2\u026c\u026b\3\2\2\2\u026d\u026f\3\2\2\2\u026e"+
		"\u025f\3\2\2\2\u026e\u0264\3\2\2\2\u026e\u0269\3\2\2\2\u026fs\3\2\2\2"+
		"\u0270\u0271\7#\2\2\u0271\u0272\5l\67\2\u0272\u0273\7$\2\2\u0273u\3\2"+
		"\2\2\u0274\u0275\7\'\2\2\u0275\u027d\5x=\2\u0276\u0277\7!\2\2\u0277\u0279"+
		"\5x=\2\u0278\u0276\3\2\2\2\u0279\u027a\3\2\2\2\u027a\u0278\3\2\2\2\u027a"+
		"\u027b\3\2\2\2\u027b\u027e\3\2\2\2\u027c\u027e\3\2\2\2\u027d\u0278\3\2"+
		"\2\2\u027d\u027c\3\2\2\2\u027ew\3\2\2\2\u027f\u028a\7\u008c\2\2\u0280"+
		"\u028a\7\u008d\2\2\u0281\u0282\7\u008e\2\2\u0282\u0283\7#\2\2\u0283\u0284"+
		"\t\5\2\2\u0284\u028a\7$\2\2\u0285\u028a\5z>\2\u0286\u028a\5|?\2\u0287"+
		"\u028a\5~@\2\u0288\u028a\7\u0092\2\2\u0289\u027f\3\2\2\2\u0289\u0280\3"+
		"\2\2\2\u0289\u0281\3\2\2\2\u0289\u0285\3\2\2\2\u0289\u0286\3\2\2\2\u0289"+
		"\u0287\3\2\2\2\u0289\u0288\3\2\2\2\u028ay\3\2\2\2\u028b\u028c\7\u008f"+
		"\2\2\u028c\u028f\7#\2\2\u028d\u0290\5\u0098M\2\u028e\u0290\7\n\2\2\u028f"+
		"\u028d\3\2\2\2\u028f\u028e\3\2\2\2\u0290\u0291\3\2\2\2\u0291\u0292\7$"+
		"\2\2\u0292{\3\2\2\2\u0293\u0294\7\u0090\2\2\u0294\u0297\7#\2\2\u0295\u0298"+
		"\5\u0098M\2\u0296\u0298\7\n\2\2\u0297\u0295\3\2\2\2\u0297\u0296\3\2\2"+
		"\2\u0298\u0299\3\2\2\2\u0299\u029a\7$\2\2\u029a}\3\2\2\2\u029b\u029c\7"+
		"\u0091\2\2\u029c\u029f\7#\2\2\u029d\u02a0\5\u0098M\2\u029e\u02a0\7\n\2"+
		"\2\u029f\u029d\3\2\2\2\u029f\u029e\3\2\2\2\u02a0\u02a1\3\2\2\2\u02a1\u02a2"+
		"\7$\2\2\u02a2\177\3\2\2\2\u02a3\u02ad\5\u008eH\2\u02a4\u02ad\5\u0090I"+
		"\2\u02a5\u02ad\5\u0086D\2\u02a6\u02ad\7\6\2\2\u02a7\u02aa\7\66\2\2\u02a8"+
		"\u02ab\5\u0092J\2\u02a9\u02ab\3\2\2\2\u02aa\u02a8\3\2\2\2\u02aa\u02a9"+
		"\3\2\2\2\u02ab\u02ad\3\2\2\2\u02ac\u02a3\3\2\2\2\u02ac\u02a4\3\2\2\2\u02ac"+
		"\u02a5\3\2\2\2\u02ac\u02a6\3\2\2\2\u02ac\u02a7\3\2\2\2\u02ad\u0081\3\2"+
		"\2\2\u02ae\u02b1\5\u008cG\2\u02af\u02b2\5\u0084C\2\u02b0\u02b2\3\2\2\2"+
		"\u02b1\u02af\3\2\2\2\u02b1\u02b0\3\2\2\2\u02b2\u0083\3\2\2\2\u02b3\u02b6"+
		"\7/\2\2\u02b4\u02b7\7/\2\2\u02b5\u02b7\3\2\2\2\u02b6\u02b4\3\2\2\2\u02b6"+
		"\u02b5\3\2\2\2\u02b7\u02c3\3\2\2\2\u02b8\u02bb\7\60\2\2\u02b9\u02bc\7"+
		"/\2\2\u02ba\u02bc\3\2\2\2\u02bb\u02b9\3\2\2\2\u02bb\u02ba\3\2\2\2\u02bc"+
		"\u02c3\3\2\2\2\u02bd\u02c0\7\62\2\2\u02be\u02c1\7/\2\2\u02bf\u02c1\3\2"+
		"\2\2\u02c0\u02be\3\2\2\2\u02c0\u02bf\3\2\2\2\u02c1\u02c3\3\2\2\2\u02c2"+
		"\u02b3\3\2\2\2\u02c2\u02b8\3\2\2\2\u02c2\u02bd\3\2\2\2\u02c3\u0085\3\2"+
		"\2\2\u02c4\u02c5\7;\2\2\u02c5\u02c9\5\u008aF\2\u02c6\u02c7\7;\2\2\u02c7"+
		"\u02c9\5\u0088E\2\u02c8\u02c4\3\2\2\2\u02c8\u02c6\3\2\2\2\u02c9\u0087"+
		"\3\2\2\2\u02ca\u02cb\7#\2\2\u02cb\u02d3\5\u008aF\2\u02cc\u02cd\7\63\2"+
		"\2\u02cd\u02cf\5\u008aF\2\u02ce\u02cc\3\2\2\2\u02cf\u02d0\3\2\2\2\u02d0"+
		"\u02ce\3\2\2\2\u02d0\u02d1\3\2\2\2\u02d1\u02d4\3\2\2\2\u02d2\u02d4\3\2"+
		"\2\2\u02d3\u02ce\3\2\2\2\u02d3\u02d2\3\2\2\2\u02d4\u02d5\3\2\2\2\u02d5"+
		"\u02d6\7$\2\2\u02d6\u0089\3\2\2\2\u02d7\u02da\7\3\2\2\u02d8\u02db\5\u0092"+
		"J\2\u02d9\u02db\3\2\2\2\u02da\u02d8\3\2\2\2\u02da\u02d9\3\2\2\2\u02db"+
		"\u02e4\3\2\2\2\u02dc\u02df\7\13\2\2\u02dd\u02e0\5\u0092J\2\u02de\u02e0"+
		"\3\2\2\2\u02df\u02dd\3\2\2\2\u02df\u02de\3\2\2\2\u02e0\u02e4\3\2\2\2\u02e1"+
		"\u02e4\5\u008eH\2\u02e2\u02e4\7\6\2\2\u02e3\u02d7\3\2\2\2\u02e3\u02dc"+
		"\3\2\2\2\u02e3\u02e1\3\2\2\2\u02e3\u02e2\3\2\2\2\u02e4\u008b\3\2\2\2\u02e5"+
		"\u02f4\7#\2\2\u02e6\u02e9\5\n\6\2\u02e7\u02e9\3\2\2\2\u02e8\u02e6\3\2"+
		"\2\2\u02e8\u02e7\3\2\2\2\u02e9\u02f0\3\2\2\2\u02ea\u02ec\5R*\2\u02eb\u02ea"+
		"\3\2\2\2\u02ec\u02ed\3\2\2\2\u02ed\u02eb\3\2\2\2\u02ed\u02ee\3\2\2\2\u02ee"+
		"\u02f1\3\2\2\2\u02ef\u02f1\3\2\2\2\u02f0\u02eb\3\2\2\2\u02f0\u02ef\3\2"+
		"\2\2\u02f1\u02f2\3\2\2\2\u02f2\u02f5\7\37\2\2\u02f3\u02f5\3\2\2\2\u02f4"+
		"\u02e8\3\2\2\2\u02f4\u02f3\3\2\2\2\u02f5\u02f6\3\2\2\2\u02f6\u02f7\5X"+
		"-\2\u02f7\u02f8\7$\2\2\u02f8\u008d\3\2\2\2\u02f9\u02fa\7\13\2\2\u02fa"+
		"\u02fb\7\65\2\2\u02fb\u02fc\7\13\2\2\u02fc\u008f\3\2\2\2\u02fd\u0300\7"+
		"\3\2\2\u02fe\u0301\5\u0092J\2\u02ff\u0301\3\2\2\2\u0300\u02fe\3\2\2\2"+
		"\u0300\u02ff\3\2\2\2\u0301\u0308\3\2\2\2\u0302\u0305\7\13\2\2\u0303\u0306"+
		"\5\u0092J\2\u0304\u0306\3\2\2\2\u0305\u0303\3\2\2\2\u0305\u0304\3\2\2"+
		"\2\u0306\u0308\3\2\2\2\u0307\u02fd\3\2\2\2\u0307\u0302\3\2\2\2\u0308\u0091"+
		"\3\2\2\2\u0309\u030a\7(\2\2\u030a\u0312\5\u0094K\2\u030b\u030c\7!\2\2"+
		"\u030c\u030e\5\u0094K\2\u030d\u030b\3\2\2\2\u030e\u030f\3\2\2\2\u030f"+
		"\u030d\3\2\2\2\u030f\u0310\3\2\2\2\u0310\u0313\3\2\2\2\u0311\u0313\3\2"+
		"\2\2\u0312\u030d\3\2\2\2\u0312\u0311\3\2\2\2\u0313\u0314\3\2\2\2\u0314"+
		"\u0315\7-\2\2\u0315\u0093\3\2\2\2\u0316\u0317\5\u0096L\2\u0317\u0095\3"+
		"\2\2\2\u0318\u0319\7)\2\2\u0319\u031a\7.\2\2\u031a\u0322\t\6\2\2\u031b"+
		"\u031c\7,\2\2\u031c\u031f\7.\2\2\u031d\u0320\7\13\2\2\u031e\u0320\58\35"+
		"\2\u031f\u031d\3\2\2\2\u031f\u031e\3\2\2\2\u0320\u0322\3\2\2\2\u0321\u0318"+
		"\3\2\2\2\u0321\u031b\3\2\2\2\u0322\u0097\3\2\2\2\u0323\u0324\7\5\2\2\u0324"+
		"\u0099\3\2\2\2\u0325\u0326\t\7\2\2\u0326\u009b\3\2\2\2\u0327\u032f\5\u0098"+
		"M\2\u0328\u0329\7\66\2\2\u0329\u032b\5\u0098M\2\u032a\u0328\3\2\2\2\u032b"+
		"\u032c\3\2\2\2\u032c\u032a\3\2\2\2\u032c\u032d\3\2\2\2\u032d\u0330\3\2"+
		"\2\2\u032e\u0330\3\2\2\2\u032f\u032a\3\2\2\2\u032f\u032e\3\2\2\2\u0330"+
		"\u009d\3\2\2\2\u0331\u0339\5\u0098M\2\u0332\u0333\7\66\2\2\u0333\u0335"+
		"\5\u0098M\2\u0334\u0332\3\2\2\2\u0335\u0336\3\2\2\2\u0336\u0334\3\2\2"+
		"\2\u0336\u0337\3\2\2\2\u0337\u033a\3\2\2\2\u0338\u033a\3\2\2\2\u0339\u0334"+
		"\3\2\2\2\u0339\u0338\3\2\2\2\u033a\u033b\3\2\2\2\u033b\u033c\7\66\2\2"+
		"\u033c\u033d\7\60\2\2\u033d\u009f\3\2\2\2\u033e\u0346\5\u0098M\2\u033f"+
		"\u0340\7\66\2\2\u0340\u0342\5\u0098M\2\u0341\u033f\3\2\2\2\u0342\u0343"+
		"\3\2\2\2\u0343\u0341\3\2\2\2\u0343\u0344\3\2\2\2\u0344\u0347\3\2\2\2\u0345"+
		"\u0347\3\2\2\2\u0346\u0341\3\2\2\2\u0346\u0345\3\2\2\2\u0347\u00a1\3\2"+
		"\2\2\u0348\u0349\7\4\2\2\u0349\u00a3\3\2\2\2r\u00a8\u00ab\u00b0\u00b5"+
		"\u00b8\u00bf\u00c2\u00cd\u00d2\u00d5\u00dc\u00e5\u00e8\u00f0\u010b\u010e"+
		"\u0114\u011e\u0127\u012a\u0130\u0139\u013c\u0143\u0147\u0156\u015b\u0166"+
		"\u016a\u0172\u0175\u017c\u017f\u0185\u0188\u0190\u0195\u0198\u01a3\u01a7"+
		"\u01ab\u01af\u01b4\u01b7\u01bc\u01bf\u01c3\u01ce\u01d9\u01e8\u01ee\u01f5"+
		"\u01fb\u01fe\u0202\u0206\u020d\u020f\u0215\u021d\u021f\u0223\u0226\u022c"+
		"\u0234\u0237\u023b\u024d\u0250\u0255\u0258\u025d\u0262\u0267\u026c\u026e"+
		"\u027a\u027d\u0289\u028f\u0297\u029f\u02aa\u02ac\u02b1\u02b6\u02bb\u02c0"+
		"\u02c2\u02c8\u02d0\u02d3\u02da\u02df\u02e3\u02e8\u02ed\u02f0\u02f4\u0300"+
		"\u0305\u0307\u030f\u0312\u031f\u0321\u032c\u032f\u0336\u0339\u0343\u0346";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}