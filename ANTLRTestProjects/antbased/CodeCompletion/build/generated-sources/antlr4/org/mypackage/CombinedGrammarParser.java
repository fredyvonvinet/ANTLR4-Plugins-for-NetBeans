// Generated from D:\NetBeansProjects\ANTLRTestProjects\antbased\CodeCompletion\grammar\org\mypackage\CombinedGrammar.g4 by ANTLR 4.6
package org.mypackage;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CombinedGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, ID=2, INT=3, NEWLINE=4, IT_1_TOKEN_1=1, IT_1_TOKEN_2=2, LG_TOKEN_1=3, 
		LG_TOKEN_2=4, ILG_1_TOKEN_1=5, LG_TOKEN_3=6, ILG_1_TOKEN_2=7, ILG_1_TOKEN_3=8, 
		ILG_1_TOKEN_4=9, LG_TOKEN_5=10, TOK=11, PG_TOKEN=12, FRAGMENT=13;
	public static final int
		RULE_rule4 = 0, RULE_rule5 = 1, RULE_rule1 = 2, RULE_rule2 = 3, RULE_rule3 = 4;
	public static final String[] ruleNames = {
		"rule4", "rule5", "rule1", "rule2", "rule3"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'azerty'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "ID", "INT", "NEWLINE", "ILG_1_TOKEN_1", "LG_TOKEN_3", "ILG_1_TOKEN_2", 
		"ILG_1_TOKEN_3", "ILG_1_TOKEN_4", "LG_TOKEN_5", "TOK", "PG_TOKEN", "FRAGMENT"
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
	public String getGrammarFileName() { return "CombinedGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CombinedGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class Rule4Context extends ParserRuleContext {
		public Rule4Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rule4; }
	 
		public Rule4Context() { }
		public void copyFrom(Rule4Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AltLabel2Context extends Rule4Context {
		public Rule2Context eltLabel1;
		public Rule2Context rule2() {
			return getRuleContext(Rule2Context.class,0);
		}
		public AltLabel2Context(Rule4Context ctx) { copyFrom(ctx); }
	}
	public static class AltLabel1Context extends Rule4Context {
		public Rule1Context eltLabel1;
		public Token eltLabel2;
		public Token eltLabel3;
		public TerminalNode INT() { return getToken(CombinedGrammarParser.INT, 0); }
		public TerminalNode ILG_1_TOKEN_4() { return getToken(CombinedGrammarParser.ILG_1_TOKEN_4, 0); }
		public Rule1Context rule1() {
			return getRuleContext(Rule1Context.class,0);
		}
		public TerminalNode TOK() { return getToken(CombinedGrammarParser.TOK, 0); }
		public List<TerminalNode> ID() { return getTokens(CombinedGrammarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CombinedGrammarParser.ID, i);
		}
		public List<Rule2Context> rule2() {
			return getRuleContexts(Rule2Context.class);
		}
		public Rule2Context rule2(int i) {
			return getRuleContext(Rule2Context.class,i);
		}
		public TerminalNode FRAGMENT() { return getToken(CombinedGrammarParser.FRAGMENT, 0); }
		public AltLabel1Context(Rule4Context ctx) { copyFrom(ctx); }
	}
	public static class AltLabel3Context extends Rule4Context {
		public Rule5Context eltLabel1;
		public Rule5Context rule5() {
			return getRuleContext(Rule5Context.class,0);
		}
		public AltLabel3Context(Rule4Context ctx) { copyFrom(ctx); }
	}

	public final Rule4Context rule4() throws RecognitionException {
		Rule4Context _localctx = new Rule4Context(_ctx, getState());
		enterRule(_localctx, 0, RULE_rule4);
		int _la;
		try {
			setState(29);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new AltLabel1Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(10);
				((AltLabel1Context)_localctx).eltLabel1 = rule1();
				setState(12); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(11);
					match(ID);
					}
					}
					setState(14); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(16);
				match(INT);
				setState(17);
				((AltLabel1Context)_localctx).eltLabel2 = match(TOK);
				setState(18);
				match(ILG_1_TOKEN_4);
				{
				setState(20);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FRAGMENT) {
					{
					setState(19);
					((AltLabel1Context)_localctx).eltLabel3 = match(FRAGMENT);
					}
				}

				setState(23); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(22);
					rule2();
					}
					}
					setState(25); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ILG_1_TOKEN_3 );
				}
				}
				break;
			case 2:
				_localctx = new AltLabel2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(27);
				((AltLabel2Context)_localctx).eltLabel1 = rule2();
				}
				break;
			case 3:
				_localctx = new AltLabel3Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(28);
				((AltLabel3Context)_localctx).eltLabel1 = rule5();
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

	public static class Rule5Context extends ParserRuleContext {
		public Rule5Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rule5; }
	 
		public Rule5Context() { }
		public void copyFrom(Rule5Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AltLabel4Context extends Rule5Context {
		public Rule2Context eltLabel1;
		public Rule2Context rule2() {
			return getRuleContext(Rule2Context.class,0);
		}
		public AltLabel4Context(Rule5Context ctx) { copyFrom(ctx); }
	}
	public static class AltLabel5Context extends Rule5Context {
		public Rule1Context eltLabel1;
		public Rule1Context rule1() {
			return getRuleContext(Rule1Context.class,0);
		}
		public AltLabel5Context(Rule5Context ctx) { copyFrom(ctx); }
	}

	public final Rule5Context rule5() throws RecognitionException {
		Rule5Context _localctx = new Rule5Context(_ctx, getState());
		enterRule(_localctx, 2, RULE_rule5);
		try {
			setState(33);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new AltLabel4Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(31);
				((AltLabel4Context)_localctx).eltLabel1 = rule2();
				}
				break;
			case 2:
				_localctx = new AltLabel5Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(32);
				((AltLabel5Context)_localctx).eltLabel1 = rule1();
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

	public static class Rule1Context extends ParserRuleContext {
		public Token gr1;
		public Rule2Context gr2;
		public Rule2Context rule2() {
			return getRuleContext(Rule2Context.class,0);
		}
		public List<TerminalNode> LG_TOKEN_1() { return getTokens(CombinedGrammarParser.LG_TOKEN_1); }
		public TerminalNode LG_TOKEN_1(int i) {
			return getToken(CombinedGrammarParser.LG_TOKEN_1, i);
		}
		public Rule1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rule1; }
	}

	public final Rule1Context rule1() throws RecognitionException {
		Rule1Context _localctx = new Rule1Context(_ctx, getState());
		enterRule(_localctx, 4, RULE_rule1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INT) {
				{
				{
				setState(35);
				((Rule1Context)_localctx).gr1 = match(INT);
				}
				}
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(41);
			((Rule1Context)_localctx).gr2 = rule2();
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

	public static class Rule2Context extends ParserRuleContext {
		public TerminalNode PG_TOKEN() { return getToken(CombinedGrammarParser.PG_TOKEN, 0); }
		public List<TerminalNode> ILG_1_TOKEN_3() { return getTokens(CombinedGrammarParser.ILG_1_TOKEN_3); }
		public TerminalNode ILG_1_TOKEN_3(int i) {
			return getToken(CombinedGrammarParser.ILG_1_TOKEN_3, i);
		}
		public Rule2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rule2; }
	}

	public final Rule2Context rule2() throws RecognitionException {
		Rule2Context _localctx = new Rule2Context(_ctx, getState());
		enterRule(_localctx, 6, RULE_rule2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(43);
				match(ILG_1_TOKEN_3);
				}
				}
				setState(46); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ILG_1_TOKEN_3 );
			setState(48);
			match(PG_TOKEN);
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

	public static class Rule3Context extends ParserRuleContext {
		public Rule3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rule3; }
	}

	public final Rule3Context rule3() throws RecognitionException {
		Rule3Context _localctx = new Rule3Context(_ctx, getState());
		enterRule(_localctx, 8, RULE_rule3);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(T__0);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\17\67\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\6\2\17\n\2\r\2\16\2\20\3\2\3\2\3"+
		"\2\3\2\5\2\27\n\2\3\2\6\2\32\n\2\r\2\16\2\33\3\2\3\2\5\2 \n\2\3\3\3\3"+
		"\5\3$\n\3\3\4\7\4\'\n\4\f\4\16\4*\13\4\3\4\3\4\3\5\6\5/\n\5\r\5\16\5\60"+
		"\3\5\3\5\3\6\3\6\3\6\2\2\7\2\4\6\b\n\2\29\2\37\3\2\2\2\4#\3\2\2\2\6(\3"+
		"\2\2\2\b.\3\2\2\2\n\64\3\2\2\2\f\16\5\6\4\2\r\17\7\4\2\2\16\r\3\2\2\2"+
		"\17\20\3\2\2\2\20\16\3\2\2\2\20\21\3\2\2\2\21\22\3\2\2\2\22\23\7\5\2\2"+
		"\23\24\7\r\2\2\24\26\7\13\2\2\25\27\7\17\2\2\26\25\3\2\2\2\26\27\3\2\2"+
		"\2\27\31\3\2\2\2\30\32\5\b\5\2\31\30\3\2\2\2\32\33\3\2\2\2\33\31\3\2\2"+
		"\2\33\34\3\2\2\2\34 \3\2\2\2\35 \5\b\5\2\36 \5\4\3\2\37\f\3\2\2\2\37\35"+
		"\3\2\2\2\37\36\3\2\2\2 \3\3\2\2\2!$\5\b\5\2\"$\5\6\4\2#!\3\2\2\2#\"\3"+
		"\2\2\2$\5\3\2\2\2%\'\7\5\2\2&%\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2"+
		")+\3\2\2\2*(\3\2\2\2+,\5\b\5\2,\7\3\2\2\2-/\7\n\2\2.-\3\2\2\2/\60\3\2"+
		"\2\2\60.\3\2\2\2\60\61\3\2\2\2\61\62\3\2\2\2\62\63\7\16\2\2\63\t\3\2\2"+
		"\2\64\65\7\3\2\2\65\13\3\2\2\2\t\20\26\33\37#(\60";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}