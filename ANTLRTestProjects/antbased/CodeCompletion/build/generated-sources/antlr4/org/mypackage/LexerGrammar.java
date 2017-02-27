// Generated from D:\NetBeansProjects\ANTLRTestProjects\antbased\CodeCompletion\grammar\org\mypackage\LexerGrammar.g4 by ANTLR 4.6
package org.mypackage;

import mypackage.TokenClassWithAPackageAndQualifiedExtends1;
import mypackage.TokenClassWithAPackageAndUnqualifiedImplements1;

import org.nemesis.lexers.Lexer1;

import org.antlr.v4.runtime.CommonToken;
import org.nemesis.tokens.TokenExtension1;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LexerGrammar extends Lexer1 {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IT_1_TOKEN_1=1, IT_1_TOKEN_2=2, LG_TOKEN_1=3, LG_TOKEN_2=4, ILG_1_TOKEN_1=5, 
		LG_TOKEN_3=6, ILG_1_TOKEN_2=7, ILG_1_TOKEN_3=8, ILG_1_TOKEN_4=9, LG_TOKEN_5=10;
	public static final int
		ChannelA=2, ChannelB=3, ChannelC=4;
	public static final int Mode1 = 1;
	public static final int Mode2 = 2;
	public static String[] modeNames = {
		"DEFAULT_MODE", "Mode1", "Mode2"
	};

	public static final String[] ruleNames = {
		"LG_TOKEN_3", "LG_FRAGMENT", "ILG_1_TOKEN_2", "ILG_1_TOKEN_3", "ILG_1_TOKEN_4", 
		"ILG_1_FRAGMENT", "LG_TOKEN_4", "LG_TOKEN_5"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "'azerty'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "IT_1_TOKEN_1", "IT_1_TOKEN_2", "LG_TOKEN_1", "LG_TOKEN_2", "ILG_1_TOKEN_1", 
		"LG_TOKEN_3", "ILG_1_TOKEN_2", "ILG_1_TOKEN_3", "ILG_1_TOKEN_4", "LG_TOKEN_5"
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


	public LexerGrammar(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LexerGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\fK\b\1\b\1\b\1\4"+
		"\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\3\3\3\3\4\6\4\37\n\4\r\4\16\4 \3\5\6\5$\n\5\r\5\16"+
		"\5%\3\6\5\6)\n\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\2\2\n\5\b\7\2\t\t\13\n\r\13\17\2\21\2\23\f\5\2\3\4\5\3\2c|\4"+
		"\2C\\c|\3\2\62;I\2\5\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\3\21"+
		"\3\2\2\2\4\23\3\2\2\2\5\25\3\2\2\2\7\33\3\2\2\2\t\36\3\2\2\2\13#\3\2\2"+
		"\2\r(\3\2\2\2\17,\3\2\2\2\21=\3\2\2\2\23D\3\2\2\2\25\26\t\2\2\2\26\27"+
		"\5\7\3\2\27\30\3\2\2\2\30\31\b\2\2\2\31\32\b\2\3\2\32\6\3\2\2\2\33\34"+
		"\7C\2\2\34\b\3\2\2\2\35\37\t\3\2\2\36\35\3\2\2\2\37 \3\2\2\2 \36\3\2\2"+
		"\2 !\3\2\2\2!\n\3\2\2\2\"$\t\4\2\2#\"\3\2\2\2$%\3\2\2\2%#\3\2\2\2%&\3"+
		"\2\2\2&\f\3\2\2\2\')\7\17\2\2(\'\3\2\2\2()\3\2\2\2)*\3\2\2\2*+\7\f\2\2"+
		"+\16\3\2\2\2,-\7k\2\2-.\7o\2\2./\7r\2\2/\60\7q\2\2\60\61\7t\2\2\61\62"+
		"\7v\2\2\62\63\7g\2\2\63\64\7f\2\2\64\65\7H\2\2\65\66\7t\2\2\66\67\7c\2"+
		"\2\678\7i\2\289\7o\2\29:\7g\2\2:;\7p\2\2;<\7v\2\2<\20\3\2\2\2=>\t\2\2"+
		"\2>?\3\2\2\2?@\b\b\4\2@A\b\b\5\2AB\b\b\6\2BC\b\b\7\2C\22\3\2\2\2DE\7c"+
		"\2\2EF\7|\2\2FG\7g\2\2GH\7t\2\2HI\7v\2\2IJ\7{\2\2J\24\3\2\2\2\b\2\3\4"+
		" %(\b\4\3\2\2\4\2\6\2\2\t\5\2\2\5\2\7\4\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}