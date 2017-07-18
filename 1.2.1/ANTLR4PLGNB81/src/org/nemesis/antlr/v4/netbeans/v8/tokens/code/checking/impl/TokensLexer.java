// Generated from TokensLexer.g4 by ANTLR 4.6
package org.nemesis.antlr.v4.netbeans.v8.tokens.code.checking.impl;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TokensLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TOKEN_ID=1, TOKEN_LITERAL=2, TOKEN_VALUE=3, EQUAL=4, CR=5, WS=6, ERROR=7;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"TOKEN_ID", "TOKEN_LITERAL", "TOKEN_VALUE", "EQUAL", "CR", "WS", "ERROR", 
		"Ws", "Hws", "Vws", "BlockComment", "DocComment", "LineComment", "EscSeq", 
		"EscAny", "UnicodeEsc", "DecimalNumeral", "HexDigit", "DecDigit", "BoolLiteral", 
		"CharLiteral", "SQuoteLiteral", "DQuoteLiteral", "USQuoteLiteral", "UpperCaseLatinChar", 
		"LowerCaseLatinChar", "LatinChar", "NameChar", "NameStartChar", "Int", 
		"Esc", "Colon", "DColon", "SQuote", "DQuote", "LParen", "RParen", "LBrace", 
		"RBrace", "LBrack", "RBrack", "RArrow", "Lt", "Gt", "Equal", "Question", 
		"Star", "Plus", "PlusAssign", "Underscore", "Pipe", "Dollar", "Comma", 
		"Semi", "Dot", "Range", "At", "Sharp", "Tilde"
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


	public TokensLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TokensLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\t\u015c\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\3\2\3"+
		"\2\7\2|\n\2\f\2\16\2\177\13\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7"+
		"\3\b\3\b\3\t\3\t\5\t\u008f\n\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\7\f\u0099"+
		"\n\f\f\f\16\f\u009c\13\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\7\r\u00a6\n\r"+
		"\f\r\16\r\u00a9\13\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\7\16\u00b2\n\16\f"+
		"\16\16\16\u00b5\13\16\3\17\3\17\3\17\3\17\5\17\u00bb\n\17\3\20\3\20\3"+
		"\20\3\21\3\21\3\21\3\21\3\21\5\21\u00c5\n\21\5\21\u00c7\n\21\5\21\u00c9"+
		"\n\21\5\21\u00cb\n\21\3\22\3\22\3\22\7\22\u00d0\n\22\f\22\16\22\u00d3"+
		"\13\22\5\22\u00d5\n\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\5\25\u00e4\n\25\3\26\3\26\3\26\5\26\u00e9\n\26\3\26"+
		"\3\26\3\27\3\27\3\27\7\27\u00f0\n\27\f\27\16\27\u00f3\13\27\3\27\3\27"+
		"\3\30\3\30\3\30\7\30\u00fa\n\30\f\30\16\30\u00fd\13\30\3\30\3\30\3\31"+
		"\3\31\3\31\7\31\u0104\n\31\f\31\16\31\u0107\13\31\3\32\3\32\3\33\3\33"+
		"\3\34\3\34\5\34\u010f\n\34\3\35\3\35\3\35\3\35\5\35\u0115\n\35\3\36\3"+
		"\36\5\36\u0119\n\36\3\37\3\37\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3\"\3#\3#"+
		"\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3+\3,\3,\3-\3-\3.\3"+
		".\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3"+
		"\65\3\66\3\66\3\67\3\67\38\38\39\39\39\3:\3:\3;\3;\3<\3<\4\u009a\u00a7"+
		"\2=\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\2\23\2\25\2\27\2\31\2\33\2\35\2\37"+
		"\2!\2#\2%\2\'\2)\2+\2-\2/\2\61\2\63\2\65\2\67\29\2;\2=\2?\2A\2C\2E\2G"+
		"\2I\2K\2M\2O\2Q\2S\2U\2W\2Y\2[\2]\2_\2a\2c\2e\2g\2i\2k\2m\2o\2q\2s\2u"+
		"\2w\2\3\2\r\4\2\13\13\"\"\4\2\f\f\16\17\4\2\f\f\17\17\n\2$$))^^ddhhpp"+
		"ttvv\3\2\63;\5\2\62;CHch\3\2\62;\6\2\f\f\17\17))^^\6\2\f\f\17\17$$^^\5"+
		"\2\u00b9\u00b9\u0302\u0371\u2041\u2042\r\2\u00c2\u00d8\u00da\u00f8\u00fa"+
		"\u0301\u0372\u037f\u0381\u2001\u200e\u200f\u2072\u2191\u2c02\u2ff1\u3003"+
		"\ud801\uf902\ufdd1\ufdf2\uffff\u0141\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\3y\3\2\2\2\5\u0080"+
		"\3\2\2\2\7\u0082\3\2\2\2\t\u0084\3\2\2\2\13\u0086\3\2\2\2\r\u0088\3\2"+
		"\2\2\17\u008a\3\2\2\2\21\u008e\3\2\2\2\23\u0090\3\2\2\2\25\u0092\3\2\2"+
		"\2\27\u0094\3\2\2\2\31\u00a0\3\2\2\2\33\u00ad\3\2\2\2\35\u00b6\3\2\2\2"+
		"\37\u00bc\3\2\2\2!\u00bf\3\2\2\2#\u00d4\3\2\2\2%\u00d6\3\2\2\2\'\u00d8"+
		"\3\2\2\2)\u00e3\3\2\2\2+\u00e5\3\2\2\2-\u00ec\3\2\2\2/\u00f6\3\2\2\2\61"+
		"\u0100\3\2\2\2\63\u0108\3\2\2\2\65\u010a\3\2\2\2\67\u010e\3\2\2\29\u0114"+
		"\3\2\2\2;\u0118\3\2\2\2=\u011a\3\2\2\2?\u011e\3\2\2\2A\u0120\3\2\2\2C"+
		"\u0122\3\2\2\2E\u0125\3\2\2\2G\u0127\3\2\2\2I\u0129\3\2\2\2K\u012b\3\2"+
		"\2\2M\u012d\3\2\2\2O\u012f\3\2\2\2Q\u0131\3\2\2\2S\u0133\3\2\2\2U\u0135"+
		"\3\2\2\2W\u0138\3\2\2\2Y\u013a\3\2\2\2[\u013c\3\2\2\2]\u013e\3\2\2\2_"+
		"\u0140\3\2\2\2a\u0142\3\2\2\2c\u0144\3\2\2\2e\u0147\3\2\2\2g\u0149\3\2"+
		"\2\2i\u014b\3\2\2\2k\u014d\3\2\2\2m\u014f\3\2\2\2o\u0151\3\2\2\2q\u0153"+
		"\3\2\2\2s\u0156\3\2\2\2u\u0158\3\2\2\2w\u015a\3\2\2\2y}\5;\36\2z|\59\35"+
		"\2{z\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\4\3\2\2\2\177}\3\2\2\2"+
		"\u0080\u0081\5-\27\2\u0081\6\3\2\2\2\u0082\u0083\5#\22\2\u0083\b\3\2\2"+
		"\2\u0084\u0085\5[.\2\u0085\n\3\2\2\2\u0086\u0087\5\25\13\2\u0087\f\3\2"+
		"\2\2\u0088\u0089\5\23\n\2\u0089\16\3\2\2\2\u008a\u008b\13\2\2\2\u008b"+
		"\20\3\2\2\2\u008c\u008f\5\23\n\2\u008d\u008f\5\25\13\2\u008e\u008c\3\2"+
		"\2\2\u008e\u008d\3\2\2\2\u008f\22\3\2\2\2\u0090\u0091\t\2\2\2\u0091\24"+
		"\3\2\2\2\u0092\u0093\t\3\2\2\u0093\26\3\2\2\2\u0094\u0095\7\61\2\2\u0095"+
		"\u0096\7,\2\2\u0096\u009a\3\2\2\2\u0097\u0099\13\2\2\2\u0098\u0097\3\2"+
		"\2\2\u0099\u009c\3\2\2\2\u009a\u009b\3\2\2\2\u009a\u0098\3\2\2\2\u009b"+
		"\u009d\3\2\2\2\u009c\u009a\3\2\2\2\u009d\u009e\7,\2\2\u009e\u009f\7\61"+
		"\2\2\u009f\30\3\2\2\2\u00a0\u00a1\7\61\2\2\u00a1\u00a2\7,\2\2\u00a2\u00a3"+
		"\7,\2\2\u00a3\u00a7\3\2\2\2\u00a4\u00a6\13\2\2\2\u00a5\u00a4\3\2\2\2\u00a6"+
		"\u00a9\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00aa\3\2"+
		"\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00ab\7,\2\2\u00ab\u00ac\7\61\2\2\u00ac"+
		"\32\3\2\2\2\u00ad\u00ae\7\61\2\2\u00ae\u00af\7\61\2\2\u00af\u00b3\3\2"+
		"\2\2\u00b0\u00b2\n\4\2\2\u00b1\u00b0\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3"+
		"\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\34\3\2\2\2\u00b5\u00b3\3\2\2"+
		"\2\u00b6\u00ba\5? \2\u00b7\u00bb\t\5\2\2\u00b8\u00bb\5!\21\2\u00b9\u00bb"+
		"\13\2\2\2\u00ba\u00b7\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00b9\3\2\2\2"+
		"\u00bb\36\3\2\2\2\u00bc\u00bd\5? \2\u00bd\u00be\13\2\2\2\u00be \3\2\2"+
		"\2\u00bf\u00ca\7w\2\2\u00c0\u00c8\5%\23\2\u00c1\u00c6\5%\23\2\u00c2\u00c4"+
		"\5%\23\2\u00c3\u00c5\5%\23\2\u00c4\u00c3\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5"+
		"\u00c7\3\2\2\2\u00c6\u00c2\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c9\3\2"+
		"\2\2\u00c8\u00c1\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00cb\3\2\2\2\u00ca"+
		"\u00c0\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\"\3\2\2\2\u00cc\u00d5\7\62\2"+
		"\2\u00cd\u00d1\t\6\2\2\u00ce\u00d0\5\'\24\2\u00cf\u00ce\3\2\2\2\u00d0"+
		"\u00d3\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d5\3\2"+
		"\2\2\u00d3\u00d1\3\2\2\2\u00d4\u00cc\3\2\2\2\u00d4\u00cd\3\2\2\2\u00d5"+
		"$\3\2\2\2\u00d6\u00d7\t\7\2\2\u00d7&\3\2\2\2\u00d8\u00d9\t\b\2\2\u00d9"+
		"(\3\2\2\2\u00da\u00db\7v\2\2\u00db\u00dc\7t\2\2\u00dc\u00dd\7w\2\2\u00dd"+
		"\u00e4\7g\2\2\u00de\u00df\7h\2\2\u00df\u00e0\7c\2\2\u00e0\u00e1\7n\2\2"+
		"\u00e1\u00e2\7u\2\2\u00e2\u00e4\7g\2\2\u00e3\u00da\3\2\2\2\u00e3\u00de"+
		"\3\2\2\2\u00e4*\3\2\2\2\u00e5\u00e8\5E#\2\u00e6\u00e9\5\35\17\2\u00e7"+
		"\u00e9\n\t\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e7\3\2\2\2\u00e9\u00ea\3\2"+
		"\2\2\u00ea\u00eb\5E#\2\u00eb,\3\2\2\2\u00ec\u00f1\5E#\2\u00ed\u00f0\5"+
		"\35\17\2\u00ee\u00f0\n\t\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00ee\3\2\2\2\u00f0"+
		"\u00f3\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f4\3\2"+
		"\2\2\u00f3\u00f1\3\2\2\2\u00f4\u00f5\5E#\2\u00f5.\3\2\2\2\u00f6\u00fb"+
		"\5G$\2\u00f7\u00fa\5\35\17\2\u00f8\u00fa\n\n\2\2\u00f9\u00f7\3\2\2\2\u00f9"+
		"\u00f8\3\2\2\2\u00fa\u00fd\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fc\3\2"+
		"\2\2\u00fc\u00fe\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fe\u00ff\5G$\2\u00ff\60"+
		"\3\2\2\2\u0100\u0105\5E#\2\u0101\u0104\5\35\17\2\u0102\u0104\n\t\2\2\u0103"+
		"\u0101\3\2\2\2\u0103\u0102\3\2\2\2\u0104\u0107\3\2\2\2\u0105\u0103\3\2"+
		"\2\2\u0105\u0106\3\2\2\2\u0106\62\3\2\2\2\u0107\u0105\3\2\2\2\u0108\u0109"+
		"\4C\\\2\u0109\64\3\2\2\2\u010a\u010b\4c|\2\u010b\66\3\2\2\2\u010c\u010f"+
		"\5\63\32\2\u010d\u010f\5\65\33\2\u010e\u010c\3\2\2\2\u010e\u010d\3\2\2"+
		"\2\u010f8\3\2\2\2\u0110\u0115\5;\36\2\u0111\u0115\4\62;\2\u0112\u0115"+
		"\5e\63\2\u0113\u0115\t\13\2\2\u0114\u0110\3\2\2\2\u0114\u0111\3\2\2\2"+
		"\u0114\u0112\3\2\2\2\u0114\u0113\3\2\2\2\u0115:\3\2\2\2\u0116\u0119\5"+
		"\67\34\2\u0117\u0119\t\f\2\2\u0118\u0116\3\2\2\2\u0118\u0117\3\2\2\2\u0119"+
		"<\3\2\2\2\u011a\u011b\7k\2\2\u011b\u011c\7p\2\2\u011c\u011d\7v\2\2\u011d"+
		">\3\2\2\2\u011e\u011f\7^\2\2\u011f@\3\2\2\2\u0120\u0121\7<\2\2\u0121B"+
		"\3\2\2\2\u0122\u0123\7<\2\2\u0123\u0124\7<\2\2\u0124D\3\2\2\2\u0125\u0126"+
		"\7)\2\2\u0126F\3\2\2\2\u0127\u0128\7$\2\2\u0128H\3\2\2\2\u0129\u012a\7"+
		"*\2\2\u012aJ\3\2\2\2\u012b\u012c\7+\2\2\u012cL\3\2\2\2\u012d\u012e\7}"+
		"\2\2\u012eN\3\2\2\2\u012f\u0130\7\177\2\2\u0130P\3\2\2\2\u0131\u0132\7"+
		"]\2\2\u0132R\3\2\2\2\u0133\u0134\7_\2\2\u0134T\3\2\2\2\u0135\u0136\7/"+
		"\2\2\u0136\u0137\7@\2\2\u0137V\3\2\2\2\u0138\u0139\7>\2\2\u0139X\3\2\2"+
		"\2\u013a\u013b\7@\2\2\u013bZ\3\2\2\2\u013c\u013d\7?\2\2\u013d\\\3\2\2"+
		"\2\u013e\u013f\7A\2\2\u013f^\3\2\2\2\u0140\u0141\7,\2\2\u0141`\3\2\2\2"+
		"\u0142\u0143\7-\2\2\u0143b\3\2\2\2\u0144\u0145\7-\2\2\u0145\u0146\7?\2"+
		"\2\u0146d\3\2\2\2\u0147\u0148\7a\2\2\u0148f\3\2\2\2\u0149\u014a\7~\2\2"+
		"\u014ah\3\2\2\2\u014b\u014c\7&\2\2\u014cj\3\2\2\2\u014d\u014e\7.\2\2\u014e"+
		"l\3\2\2\2\u014f\u0150\7=\2\2\u0150n\3\2\2\2\u0151\u0152\7\60\2\2\u0152"+
		"p\3\2\2\2\u0153\u0154\7\60\2\2\u0154\u0155\7\60\2\2\u0155r\3\2\2\2\u0156"+
		"\u0157\7B\2\2\u0157t\3\2\2\2\u0158\u0159\7%\2\2\u0159v\3\2\2\2\u015a\u015b"+
		"\7\u0080\2\2\u015bx\3\2\2\2\32\2}\u008e\u009a\u00a7\u00b3\u00ba\u00c4"+
		"\u00c6\u00c8\u00ca\u00d1\u00d4\u00e3\u00e8\u00ef\u00f1\u00f9\u00fb\u0103"+
		"\u0105\u010e\u0114\u0118\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}