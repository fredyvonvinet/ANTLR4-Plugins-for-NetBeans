// Generated from D:\NetBeansProjects\ANTLRTestProjects\antbased\CodeCompletion\grammar\org\mypackage\ParserGrammar.g4 by ANTLR 4.6
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
public class ParserGrammar extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IT_1_TOKEN_1=1, IT_1_TOKEN_2=2, LG_TOKEN_1=3, LG_TOKEN_2=4, ILG_1_TOKEN_1=5, 
		LG_TOKEN_3=6, ILG_1_TOKEN_2=7, ILG_1_TOKEN_3=8, ILG_1_TOKEN_4=9, LG_TOKEN_5=10, 
		PG_TOKEN=11;
	public static final int
		RULE_rule1 = 0, RULE_rule2 = 1, RULE_rule3 = 2;
	public static final String[] ruleNames = {
		"rule1", "rule2", "rule3"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "'azerty'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "IT_1_TOKEN_1", "IT_1_TOKEN_2", "LG_TOKEN_1", "LG_TOKEN_2", "ILG_1_TOKEN_1", 
		"LG_TOKEN_3", "ILG_1_TOKEN_2", "ILG_1_TOKEN_3", "ILG_1_TOKEN_4", "LG_TOKEN_5", 
		"PG_TOKEN"
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
	public String getGrammarFileName() { return "ParserGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ParserGrammar(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class Rule1Context extends ParserRuleContext {
		public Token gr1;
		public Rule2Context gr2;
		public Rule2Context rule2() {
			return getRuleContext(Rule2Context.class,0);
		}
		public List<TerminalNode> LG_TOKEN_1() { return getTokens(ParserGrammar.LG_TOKEN_1); }
		public TerminalNode LG_TOKEN_1(int i) {
			return getToken(ParserGrammar.LG_TOKEN_1, i);
		}
		public Rule1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rule1; }
	}

	public final Rule1Context rule1() throws RecognitionException {
		Rule1Context _localctx = new Rule1Context(_ctx, getState());
		enterRule(_localctx, 0, RULE_rule1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(9);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LG_TOKEN_1) {
				{
				{
				setState(6);
				((Rule1Context)_localctx).gr1 = match(LG_TOKEN_1);
				}
				}
				setState(11);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(12);
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
		public TerminalNode PG_TOKEN() { return getToken(ParserGrammar.PG_TOKEN, 0); }
		public List<TerminalNode> ILG_1_TOKEN_3() { return getTokens(ParserGrammar.ILG_1_TOKEN_3); }
		public TerminalNode ILG_1_TOKEN_3(int i) {
			return getToken(ParserGrammar.ILG_1_TOKEN_3, i);
		}
		public Rule2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rule2; }
	}

	public final Rule2Context rule2() throws RecognitionException {
		Rule2Context _localctx = new Rule2Context(_ctx, getState());
		enterRule(_localctx, 2, RULE_rule2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(14);
				match(ILG_1_TOKEN_3);
				}
				}
				setState(17); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ILG_1_TOKEN_3 );
			setState(19);
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
		enterRule(_localctx, 4, RULE_rule3);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			match(LG_TOKEN_5);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\r\32\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\3\2\7\2\n\n\2\f\2\16\2\r\13\2\3\2\3\2\3\3\6\3\22\n\3\r\3"+
		"\16\3\23\3\3\3\3\3\4\3\4\3\4\2\2\5\2\4\6\2\2\30\2\13\3\2\2\2\4\21\3\2"+
		"\2\2\6\27\3\2\2\2\b\n\7\5\2\2\t\b\3\2\2\2\n\r\3\2\2\2\13\t\3\2\2\2\13"+
		"\f\3\2\2\2\f\16\3\2\2\2\r\13\3\2\2\2\16\17\5\4\3\2\17\3\3\2\2\2\20\22"+
		"\7\n\2\2\21\20\3\2\2\2\22\23\3\2\2\2\23\21\3\2\2\2\23\24\3\2\2\2\24\25"+
		"\3\2\2\2\25\26\7\r\2\2\26\5\3\2\2\2\27\30\7\f\2\2\30\7\3\2\2\2\4\13\23";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}