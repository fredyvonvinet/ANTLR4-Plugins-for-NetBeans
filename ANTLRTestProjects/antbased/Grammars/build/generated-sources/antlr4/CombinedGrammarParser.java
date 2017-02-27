// Generated from D:\NetBeansProjects\ANTLRTestProjects\antbased\Grammars\grammar\CombinedGrammar.g4 by ANTLR 4.6
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
		T1=1, T2=2;
	public static final int
		RULE_localRule = 0, RULE_importedRule2 = 1;
	public static final String[] ruleNames = {
		"localRule", "importedRule2"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'t1'", "'t2'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "T1", "T2"
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
	public static class LocalRuleContext extends ParserRuleContext {
		public ImportedRule2Context importedRule2() {
			return getRuleContext(ImportedRule2Context.class,0);
		}
		public LocalRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localRule; }
	}

	public final LocalRuleContext localRule() throws RecognitionException {
		LocalRuleContext _localctx = new LocalRuleContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_localRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4);
			importedRule2();
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

	public static class ImportedRule2Context extends ParserRuleContext {
		public TerminalNode T1() { return getToken(CombinedGrammarParser.T1, 0); }
		public ImportedRule2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importedRule2; }
	}

	public final ImportedRule2Context importedRule2() throws RecognitionException {
		ImportedRule2Context _localctx = new ImportedRule2Context(_ctx, getState());
		enterRule(_localctx, 2, RULE_importedRule2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(6);
			match(T1);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\4\13\4\2\t\2\4\3"+
		"\t\3\3\2\3\2\3\3\3\3\3\3\2\2\4\2\4\2\2\b\2\6\3\2\2\2\4\b\3\2\2\2\6\7\5"+
		"\4\3\2\7\3\3\2\2\2\b\t\7\3\2\2\t\5\3\2\2\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}