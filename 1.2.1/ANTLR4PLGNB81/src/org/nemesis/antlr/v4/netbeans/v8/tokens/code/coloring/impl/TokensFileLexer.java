// Generated from TokensFileLexer.g4 by ANTLR 4.6
package org.nemesis.antlr.v4.netbeans.v8.tokens.code.coloring.impl;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TokensFileLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TOKEN_ID=1, TOKEN_LITERAL=2, TOKEN_VALUE=3, EQUAL=4, WS=5, ERROR=6;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"TOKEN_ID", "TOKEN_LITERAL", "TOKEN_VALUE", "EQUAL", "WS", "ERROR", "Ws", 
		"Hws", "Vws", "BlockComment", "DocComment", "LineComment", "EscSeq", "EscAny", 
		"UnicodeEsc", "DecimalNumeral", "HexDigit", "DecDigit", "BoolLiteral", 
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
		null, "TOKEN_ID", "TOKEN_LITERAL", "TOKEN_VALUE", "EQUAL", "WS", "ERROR"
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


	public TokensFileLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TokensFileLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 4:
			WS_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:

			     getText();
			    
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\b\u015d\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\3\2\3\2\7\2"+
		"z\n\2\f\2\16\2}\13\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\6\6\u0086\n\6\r\6\16"+
		"\6\u0087\3\6\3\6\3\7\3\7\3\b\3\b\5\b\u0090\n\b\3\t\3\t\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\7\13\u009a\n\13\f\13\16\13\u009d\13\13\3\13\3\13\3\13\3"+
		"\f\3\f\3\f\3\f\3\f\7\f\u00a7\n\f\f\f\16\f\u00aa\13\f\3\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\7\r\u00b3\n\r\f\r\16\r\u00b6\13\r\3\16\3\16\3\16\3\16\5\16"+
		"\u00bc\n\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\5\20\u00c6\n\20\5"+
		"\20\u00c8\n\20\5\20\u00ca\n\20\5\20\u00cc\n\20\3\21\3\21\3\21\7\21\u00d1"+
		"\n\21\f\21\16\21\u00d4\13\21\5\21\u00d6\n\21\3\22\3\22\3\23\3\23\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00e5\n\24\3\25\3\25\3\25"+
		"\5\25\u00ea\n\25\3\25\3\25\3\26\3\26\3\26\7\26\u00f1\n\26\f\26\16\26\u00f4"+
		"\13\26\3\26\3\26\3\27\3\27\3\27\7\27\u00fb\n\27\f\27\16\27\u00fe\13\27"+
		"\3\27\3\27\3\30\3\30\3\30\7\30\u0105\n\30\f\30\16\30\u0108\13\30\3\31"+
		"\3\31\3\32\3\32\3\33\3\33\5\33\u0110\n\33\3\34\3\34\3\34\3\34\5\34\u0116"+
		"\n\34\3\35\3\35\5\35\u011a\n\35\3\36\3\36\3\36\3\36\3\37\3\37\3 \3 \3"+
		"!\3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3*\3"+
		"+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\63\3"+
		"\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\38\39\39\3:\3:\3;\3"+
		";\4\u009b\u00a8\2<\3\3\5\4\7\5\t\6\13\7\r\b\17\2\21\2\23\2\25\2\27\2\31"+
		"\2\33\2\35\2\37\2!\2#\2%\2\'\2)\2+\2-\2/\2\61\2\63\2\65\2\67\29\2;\2="+
		"\2?\2A\2C\2E\2G\2I\2K\2M\2O\2Q\2S\2U\2W\2Y\2[\2]\2_\2a\2c\2e\2g\2i\2k"+
		"\2m\2o\2q\2s\2u\2\3\2\r\4\2\13\13\"\"\4\2\f\f\16\17\4\2\f\f\17\17\n\2"+
		"$$))^^ddhhppttvv\3\2\63;\5\2\62;CHch\3\2\62;\6\2\f\f\17\17))^^\6\2\f\f"+
		"\17\17$$^^\5\2\u00b9\u00b9\u0302\u0371\u2041\u2042\r\2\u00c2\u00d8\u00da"+
		"\u00f8\u00fa\u0301\u0372\u037f\u0381\u2001\u200e\u200f\u2072\u2191\u2c02"+
		"\u2ff1\u3003\ud801\uf902\ufdd1\ufdf2\uffff\u0143\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\3w\3\2\2\2\5~\3\2"+
		"\2\2\7\u0080\3\2\2\2\t\u0082\3\2\2\2\13\u0085\3\2\2\2\r\u008b\3\2\2\2"+
		"\17\u008f\3\2\2\2\21\u0091\3\2\2\2\23\u0093\3\2\2\2\25\u0095\3\2\2\2\27"+
		"\u00a1\3\2\2\2\31\u00ae\3\2\2\2\33\u00b7\3\2\2\2\35\u00bd\3\2\2\2\37\u00c0"+
		"\3\2\2\2!\u00d5\3\2\2\2#\u00d7\3\2\2\2%\u00d9\3\2\2\2\'\u00e4\3\2\2\2"+
		")\u00e6\3\2\2\2+\u00ed\3\2\2\2-\u00f7\3\2\2\2/\u0101\3\2\2\2\61\u0109"+
		"\3\2\2\2\63\u010b\3\2\2\2\65\u010f\3\2\2\2\67\u0115\3\2\2\29\u0119\3\2"+
		"\2\2;\u011b\3\2\2\2=\u011f\3\2\2\2?\u0121\3\2\2\2A\u0123\3\2\2\2C\u0126"+
		"\3\2\2\2E\u0128\3\2\2\2G\u012a\3\2\2\2I\u012c\3\2\2\2K\u012e\3\2\2\2M"+
		"\u0130\3\2\2\2O\u0132\3\2\2\2Q\u0134\3\2\2\2S\u0136\3\2\2\2U\u0139\3\2"+
		"\2\2W\u013b\3\2\2\2Y\u013d\3\2\2\2[\u013f\3\2\2\2]\u0141\3\2\2\2_\u0143"+
		"\3\2\2\2a\u0145\3\2\2\2c\u0148\3\2\2\2e\u014a\3\2\2\2g\u014c\3\2\2\2i"+
		"\u014e\3\2\2\2k\u0150\3\2\2\2m\u0152\3\2\2\2o\u0154\3\2\2\2q\u0157\3\2"+
		"\2\2s\u0159\3\2\2\2u\u015b\3\2\2\2w{\59\35\2xz\5\67\34\2yx\3\2\2\2z}\3"+
		"\2\2\2{y\3\2\2\2{|\3\2\2\2|\4\3\2\2\2}{\3\2\2\2~\177\5+\26\2\177\6\3\2"+
		"\2\2\u0080\u0081\5!\21\2\u0081\b\3\2\2\2\u0082\u0083\5Y-\2\u0083\n\3\2"+
		"\2\2\u0084\u0086\5\17\b\2\u0085\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087"+
		"\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\b\6"+
		"\2\2\u008a\f\3\2\2\2\u008b\u008c\13\2\2\2\u008c\16\3\2\2\2\u008d\u0090"+
		"\5\21\t\2\u008e\u0090\5\23\n\2\u008f\u008d\3\2\2\2\u008f\u008e\3\2\2\2"+
		"\u0090\20\3\2\2\2\u0091\u0092\t\2\2\2\u0092\22\3\2\2\2\u0093\u0094\t\3"+
		"\2\2\u0094\24\3\2\2\2\u0095\u0096\7\61\2\2\u0096\u0097\7,\2\2\u0097\u009b"+
		"\3\2\2\2\u0098\u009a\13\2\2\2\u0099\u0098\3\2\2\2\u009a\u009d\3\2\2\2"+
		"\u009b\u009c\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u009e\3\2\2\2\u009d\u009b"+
		"\3\2\2\2\u009e\u009f\7,\2\2\u009f\u00a0\7\61\2\2\u00a0\26\3\2\2\2\u00a1"+
		"\u00a2\7\61\2\2\u00a2\u00a3\7,\2\2\u00a3\u00a4\7,\2\2\u00a4\u00a8\3\2"+
		"\2\2\u00a5\u00a7\13\2\2\2\u00a6\u00a5\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8"+
		"\u00a9\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9\u00ab\3\2\2\2\u00aa\u00a8\3\2"+
		"\2\2\u00ab\u00ac\7,\2\2\u00ac\u00ad\7\61\2\2\u00ad\30\3\2\2\2\u00ae\u00af"+
		"\7\61\2\2\u00af\u00b0\7\61\2\2\u00b0\u00b4\3\2\2\2\u00b1\u00b3\n\4\2\2"+
		"\u00b2\u00b1\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5"+
		"\3\2\2\2\u00b5\32\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7\u00bb\5=\37\2\u00b8"+
		"\u00bc\t\5\2\2\u00b9\u00bc\5\37\20\2\u00ba\u00bc\13\2\2\2\u00bb\u00b8"+
		"\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00ba\3\2\2\2\u00bc\34\3\2\2\2\u00bd"+
		"\u00be\5=\37\2\u00be\u00bf\13\2\2\2\u00bf\36\3\2\2\2\u00c0\u00cb\7w\2"+
		"\2\u00c1\u00c9\5#\22\2\u00c2\u00c7\5#\22\2\u00c3\u00c5\5#\22\2\u00c4\u00c6"+
		"\5#\22\2\u00c5\u00c4\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c8\3\2\2\2\u00c7"+
		"\u00c3\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00ca\3\2\2\2\u00c9\u00c2\3\2"+
		"\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cc\3\2\2\2\u00cb\u00c1\3\2\2\2\u00cb"+
		"\u00cc\3\2\2\2\u00cc \3\2\2\2\u00cd\u00d6\7\62\2\2\u00ce\u00d2\t\6\2\2"+
		"\u00cf\u00d1\5%\23\2\u00d0\u00cf\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2\u00d0"+
		"\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5"+
		"\u00cd\3\2\2\2\u00d5\u00ce\3\2\2\2\u00d6\"\3\2\2\2\u00d7\u00d8\t\7\2\2"+
		"\u00d8$\3\2\2\2\u00d9\u00da\t\b\2\2\u00da&\3\2\2\2\u00db\u00dc\7v\2\2"+
		"\u00dc\u00dd\7t\2\2\u00dd\u00de\7w\2\2\u00de\u00e5\7g\2\2\u00df\u00e0"+
		"\7h\2\2\u00e0\u00e1\7c\2\2\u00e1\u00e2\7n\2\2\u00e2\u00e3\7u\2\2\u00e3"+
		"\u00e5\7g\2\2\u00e4\u00db\3\2\2\2\u00e4\u00df\3\2\2\2\u00e5(\3\2\2\2\u00e6"+
		"\u00e9\5C\"\2\u00e7\u00ea\5\33\16\2\u00e8\u00ea\n\t\2\2\u00e9\u00e7\3"+
		"\2\2\2\u00e9\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ec\5C\"\2\u00ec"+
		"*\3\2\2\2\u00ed\u00f2\5C\"\2\u00ee\u00f1\5\33\16\2\u00ef\u00f1\n\t\2\2"+
		"\u00f0\u00ee\3\2\2\2\u00f0\u00ef\3\2\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f0"+
		"\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f5\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5"+
		"\u00f6\5C\"\2\u00f6,\3\2\2\2\u00f7\u00fc\5E#\2\u00f8\u00fb\5\33\16\2\u00f9"+
		"\u00fb\n\n\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00f9\3\2\2\2\u00fb\u00fe\3\2"+
		"\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00ff\3\2\2\2\u00fe"+
		"\u00fc\3\2\2\2\u00ff\u0100\5E#\2\u0100.\3\2\2\2\u0101\u0106\5C\"\2\u0102"+
		"\u0105\5\33\16\2\u0103\u0105\n\t\2\2\u0104\u0102\3\2\2\2\u0104\u0103\3"+
		"\2\2\2\u0105\u0108\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107"+
		"\60\3\2\2\2\u0108\u0106\3\2\2\2\u0109\u010a\4C\\\2\u010a\62\3\2\2\2\u010b"+
		"\u010c\4c|\2\u010c\64\3\2\2\2\u010d\u0110\5\61\31\2\u010e\u0110\5\63\32"+
		"\2\u010f\u010d\3\2\2\2\u010f\u010e\3\2\2\2\u0110\66\3\2\2\2\u0111\u0116"+
		"\59\35\2\u0112\u0116\4\62;\2\u0113\u0116\5c\62\2\u0114\u0116\t\13\2\2"+
		"\u0115\u0111\3\2\2\2\u0115\u0112\3\2\2\2\u0115\u0113\3\2\2\2\u0115\u0114"+
		"\3\2\2\2\u01168\3\2\2\2\u0117\u011a\5\65\33\2\u0118\u011a\t\f\2\2\u0119"+
		"\u0117\3\2\2\2\u0119\u0118\3\2\2\2\u011a:\3\2\2\2\u011b\u011c\7k\2\2\u011c"+
		"\u011d\7p\2\2\u011d\u011e\7v\2\2\u011e<\3\2\2\2\u011f\u0120\7^\2\2\u0120"+
		">\3\2\2\2\u0121\u0122\7<\2\2\u0122@\3\2\2\2\u0123\u0124\7<\2\2\u0124\u0125"+
		"\7<\2\2\u0125B\3\2\2\2\u0126\u0127\7)\2\2\u0127D\3\2\2\2\u0128\u0129\7"+
		"$\2\2\u0129F\3\2\2\2\u012a\u012b\7*\2\2\u012bH\3\2\2\2\u012c\u012d\7+"+
		"\2\2\u012dJ\3\2\2\2\u012e\u012f\7}\2\2\u012fL\3\2\2\2\u0130\u0131\7\177"+
		"\2\2\u0131N\3\2\2\2\u0132\u0133\7]\2\2\u0133P\3\2\2\2\u0134\u0135\7_\2"+
		"\2\u0135R\3\2\2\2\u0136\u0137\7/\2\2\u0137\u0138\7@\2\2\u0138T\3\2\2\2"+
		"\u0139\u013a\7>\2\2\u013aV\3\2\2\2\u013b\u013c\7@\2\2\u013cX\3\2\2\2\u013d"+
		"\u013e\7?\2\2\u013eZ\3\2\2\2\u013f\u0140\7A\2\2\u0140\\\3\2\2\2\u0141"+
		"\u0142\7,\2\2\u0142^\3\2\2\2\u0143\u0144\7-\2\2\u0144`\3\2\2\2\u0145\u0146"+
		"\7-\2\2\u0146\u0147\7?\2\2\u0147b\3\2\2\2\u0148\u0149\7a\2\2\u0149d\3"+
		"\2\2\2\u014a\u014b\7~\2\2\u014bf\3\2\2\2\u014c\u014d\7&\2\2\u014dh\3\2"+
		"\2\2\u014e\u014f\7.\2\2\u014fj\3\2\2\2\u0150\u0151\7=\2\2\u0151l\3\2\2"+
		"\2\u0152\u0153\7\60\2\2\u0153n\3\2\2\2\u0154\u0155\7\60\2\2\u0155\u0156"+
		"\7\60\2\2\u0156p\3\2\2\2\u0157\u0158\7B\2\2\u0158r\3\2\2\2\u0159\u015a"+
		"\7%\2\2\u015at\3\2\2\2\u015b\u015c\7\u0080\2\2\u015cv\3\2\2\2\33\2{\u0087"+
		"\u008f\u009b\u00a8\u00b4\u00bb\u00c5\u00c7\u00c9\u00cb\u00d2\u00d5\u00e4"+
		"\u00e9\u00f0\u00f2\u00fa\u00fc\u0104\u0106\u010f\u0115\u0119\3\3\6\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}