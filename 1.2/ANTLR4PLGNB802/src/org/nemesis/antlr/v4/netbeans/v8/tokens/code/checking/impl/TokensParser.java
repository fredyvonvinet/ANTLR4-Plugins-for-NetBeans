// Generated from Tokens.g4 by ANTLR 4.6
package org.nemesis.antlr.v4.netbeans.v8.tokens.code.checking.impl;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TokensParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TOKEN_ID=1, TOKEN_LITERAL=2, TOKEN_VALUE=3, EQUAL=4, CR=5, WS=6, ERROR=7;
	public static final int
		RULE_token_declarations = 0, RULE_line = 1, RULE_token_declaration = 2;
	public static final String[] ruleNames = {
		"token_declarations", "line", "token_declaration"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "TOKEN_ID", "TOKEN_LITERAL", "TOKEN_VALUE", "EQUAL", "CR", "WS", 
		"ERROR"
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
	public String getGrammarFileName() { return "Tokens.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TokensParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class Token_declarationsContext extends ParserRuleContext {
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public Token_declarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_token_declarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterToken_declarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitToken_declarations(this);
		}
	}

	public final Token_declarationsContext token_declarations() throws RecognitionException {
		Token_declarationsContext _localctx = new Token_declarationsContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_token_declarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(9);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TOKEN_ID || _la==TOKEN_LITERAL) {
				{
				{
				setState(6);
				line();
				}
				}
				setState(11);
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

	public static class LineContext extends ParserRuleContext {
		public Token_declarationContext token_declaration() {
			return getRuleContext(Token_declarationContext.class,0);
		}
		public TerminalNode CR() { return getToken(TokensParser.CR, 0); }
		public TerminalNode EOF() { return getToken(TokensParser.EOF, 0); }
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitLine(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_line);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12);
			token_declaration();
			setState(13);
			_la = _input.LA(1);
			if ( !(_la==EOF || _la==CR) ) {
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

	public static class Token_declarationContext extends ParserRuleContext {
		public TerminalNode EQUAL() { return getToken(TokensParser.EQUAL, 0); }
		public TerminalNode TOKEN_VALUE() { return getToken(TokensParser.TOKEN_VALUE, 0); }
		public TerminalNode TOKEN_ID() { return getToken(TokensParser.TOKEN_ID, 0); }
		public TerminalNode TOKEN_LITERAL() { return getToken(TokensParser.TOKEN_LITERAL, 0); }
		public List<TerminalNode> WS() { return getTokens(TokensParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(TokensParser.WS, i);
		}
		public Token_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_token_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterToken_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitToken_declaration(this);
		}
	}

	public final Token_declarationContext token_declaration() throws RecognitionException {
		Token_declarationContext _localctx = new Token_declarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_token_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15);
			_la = _input.LA(1);
			if ( !(_la==TOKEN_ID || _la==TOKEN_LITERAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(19);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(16);
				match(WS);
				}
				}
				setState(21);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(22);
			match(EQUAL);
			setState(26);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(23);
				match(WS);
				}
				}
				setState(28);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(29);
			match(TOKEN_VALUE);
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(30);
				match(WS);
				}
				}
				setState(35);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\t\'\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\3\2\7\2\n\n\2\f\2\16\2\r\13\2\3\3\3\3\3\3\3\4\3\4\7\4\24\n"+
		"\4\f\4\16\4\27\13\4\3\4\3\4\7\4\33\n\4\f\4\16\4\36\13\4\3\4\3\4\7\4\""+
		"\n\4\f\4\16\4%\13\4\3\4\2\2\5\2\4\6\2\4\3\3\7\7\3\2\3\4\'\2\13\3\2\2\2"+
		"\4\16\3\2\2\2\6\21\3\2\2\2\b\n\5\4\3\2\t\b\3\2\2\2\n\r\3\2\2\2\13\t\3"+
		"\2\2\2\13\f\3\2\2\2\f\3\3\2\2\2\r\13\3\2\2\2\16\17\5\6\4\2\17\20\t\2\2"+
		"\2\20\5\3\2\2\2\21\25\t\3\2\2\22\24\7\b\2\2\23\22\3\2\2\2\24\27\3\2\2"+
		"\2\25\23\3\2\2\2\25\26\3\2\2\2\26\30\3\2\2\2\27\25\3\2\2\2\30\34\7\6\2"+
		"\2\31\33\7\b\2\2\32\31\3\2\2\2\33\36\3\2\2\2\34\32\3\2\2\2\34\35\3\2\2"+
		"\2\35\37\3\2\2\2\36\34\3\2\2\2\37#\7\5\2\2 \"\7\b\2\2! \3\2\2\2\"%\3\2"+
		"\2\2#!\3\2\2\2#$\3\2\2\2$\7\3\2\2\2%#\3\2\2\2\6\13\25\34#";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}