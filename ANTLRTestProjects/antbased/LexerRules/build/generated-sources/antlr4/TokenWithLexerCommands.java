// Generated from D:\NetBeansProjects\ANTLRTestProjects\antbased\LexerRules\grammar\TokenWithLexerCommands.g4 by ANTLR 4.6
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TokenWithLexerCommands extends Lexer {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TOKEN1=1, TOKEN2=2, ID6=3, ID2=4, ID8=5, ID3=6, ID5=7, ID7=8;
	public static final int
		MyChannel=2;
	public static final int MyMode = 1;
	public static String[] modeNames = {
		"DEFAULT_MODE", "MyMode"
	};

	public static final String[] ruleNames = {
		"ID1", "ID2", "ID3", "ID8", "ID4", "ID5", "ID7"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, "'azerty'", null, "'itsuken'", "'id6'", "'id7'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "TOKEN1", "TOKEN2", "ID6", "ID2", "ID8", "ID3", "ID5", "ID7"
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


	public TokenWithLexerCommands(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TokenWithLexerCommands.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\nM\b\1\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\6\5\62\n\5\r\5\16\5\63\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\2\2\t\4\2\6\6\b\b\n\7\f\2\16\t\20\n\4\2\3\3\4\2C\\c|L\2"+
		"\4\3\2\2\2\2\6\3\2\2\2\2\b\3\2\2\2\2\n\3\2\2\2\3\f\3\2\2\2\3\16\3\2\2"+
		"\2\3\20\3\2\2\2\4\22\3\2\2\2\6\34\3\2\2\2\b&\3\2\2\2\n\61\3\2\2\2\f\65"+
		"\3\2\2\2\16A\3\2\2\2\20G\3\2\2\2\22\23\7s\2\2\23\24\7y\2\2\24\25\7g\2"+
		"\2\25\26\7t\2\2\26\27\7v\2\2\27\30\7{\2\2\30\31\3\2\2\2\31\32\b\2\2\2"+
		"\32\33\b\2\3\2\33\5\3\2\2\2\34\35\7c\2\2\35\36\7|\2\2\36\37\7g\2\2\37"+
		" \7t\2\2 !\7v\2\2!\"\7{\2\2\"#\3\2\2\2#$\b\3\4\2$%\b\3\5\2%\7\3\2\2\2"+
		"&\'\7k\2\2\'(\7v\2\2()\7u\2\2)*\7w\2\2*+\7m\2\2+,\7g\2\2,-\7p\2\2-.\3"+
		"\2\2\2./\b\4\6\2/\t\3\2\2\2\60\62\t\2\2\2\61\60\3\2\2\2\62\63\3\2\2\2"+
		"\63\61\3\2\2\2\63\64\3\2\2\2\64\13\3\2\2\2\65\66\7u\2\2\66\67\7g\2\2\67"+
		"8\7t\2\289\7v\2\29:\7g\2\2:;\7v\2\2;<\7j\2\2<=\3\2\2\2=>\b\6\7\2>?\b\6"+
		"\b\2?@\b\6\t\2@\r\3\2\2\2AB\7k\2\2BC\7f\2\2CD\78\2\2DE\3\2\2\2EF\b\7\n"+
		"\2F\17\3\2\2\2GH\7k\2\2HI\7f\2\2IJ\79\2\2JK\3\2\2\2KL\b\b\13\2L\21\3\2"+
		"\2\2\5\2\3\63\f\t\6\2\7\3\2\b\2\2\4\3\2\5\2\2\t\5\2\2\4\2\6\2\2\t\7\2"+
		"\t\4\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}