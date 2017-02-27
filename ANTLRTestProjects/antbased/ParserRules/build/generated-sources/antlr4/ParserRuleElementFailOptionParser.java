// Generated from D:\NetBeansProjects\ANTLRTestProjects\antbased\ParserRules\grammar\ParserRuleElementFailOption.g4 by ANTLR 4.6
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ParserRuleElementFailOptionParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, INT=4, WS=5;
	public static final int
		RULE_vec4 = 0, RULE_ints = 1;
	public static final String[] ruleNames = {
		"vec4", "ints"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'['", "']'", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "INT", "WS"
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
	public String getGrammarFileName() { return "ParserRuleElementFailOption.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ParserRuleElementFailOptionParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class Vec4Context extends ParserRuleContext {
		public IntsContext ints() {
			return getRuleContext(IntsContext.class,0);
		}
		public Vec4Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vec4; }
	}

	public final Vec4Context vec4() throws RecognitionException {
		Vec4Context _localctx = new Vec4Context(_ctx, getState());
		enterRule(_localctx, 0, RULE_vec4);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4);
			match(T__0);
			setState(5);
			ints(4);
			setState(6);
			match(T__1);
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

	public static class IntsContext extends ParserRuleContext {
		public int max;
		public int i = 1;
		public List<TerminalNode> INT() { return getTokens(ParserRuleElementFailOptionParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(ParserRuleElementFailOptionParser.INT, i);
		}
		public IntsContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public IntsContext(ParserRuleContext parent, int invokingState, int max) {
			super(parent, invokingState);
			this.max = max;
		}
		@Override public int getRuleIndex() { return RULE_ints; }
	}

	public final IntsContext ints(int max) throws RecognitionException {
		IntsContext _localctx = new IntsContext(_ctx, getState(), max);
		enterRule(_localctx, 2, RULE_ints);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8);
			match(INT);
			setState(15);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(9);
				match(T__2);
				_localctx.i++;
				setState(11);
				if (!(_localctx.i<=_localctx.max)) throw new FailedPredicateException(this, "$i<=$max", "exceeded max "+_localctx.max);
				setState(12);
				match(INT);
				}
				}
				setState(17);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return ints_sempred((IntsContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean ints_sempred(IntsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return _localctx.i<=_localctx.max;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\7\25\4\2\t\2\4\3"+
		"\t\3\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\7\3\20\n\3\f\3\16\3\23\13\3\3"+
		"\3\2\2\4\2\4\2\2\23\2\6\3\2\2\2\4\n\3\2\2\2\6\7\7\3\2\2\7\b\5\4\3\2\b"+
		"\t\7\4\2\2\t\3\3\2\2\2\n\21\7\6\2\2\13\f\7\5\2\2\f\r\b\3\1\2\r\16\6\3"+
		"\2\3\16\20\7\6\2\2\17\13\3\2\2\2\20\23\3\2\2\2\21\17\3\2\2\2\21\22\3\2"+
		"\2\2\22\5\3\2\2\2\23\21\3\2\2\2\3\21";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}