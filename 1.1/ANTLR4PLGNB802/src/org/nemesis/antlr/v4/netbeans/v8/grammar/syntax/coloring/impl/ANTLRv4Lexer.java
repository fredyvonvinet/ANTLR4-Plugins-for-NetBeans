// Generated from ANTLRv4Lexer.g4 by ANTLR 4.6
package org.nemesis.antlr.v4.netbeans.v8.grammar.syntax.coloring.impl;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ANTLRv4Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ID_STARTING_WITH_UPPERCASE=1, ID_STARTING_WITH_LOWERCASE=2, LEXER_CHAR_SET=3, 
		DOC_COMMENT=4, BLOCK_COMMENT=5, LINE_COMMENT=6, INT=7, STRING_LITERAL=8, 
		UNTERMINATED_STRING_LITERAL=9, BEGIN_ARGUMENT=10, BEGIN_ACTION=11, OPTIONS=12, 
		TOKENS=13, CHANNELS=14, IMPORT=15, FRAGMENT=16, LEXER=17, PARSER=18, GRAMMAR=19, 
		PROTECTED=20, PUBLIC=21, PRIVATE=22, RETURNS=23, LOCALS=24, INIT=25, AFTER=26, 
		THROWS=27, CATCH=28, FINALLY=29, MODE=30, COLON=31, COLONCOLON=32, COMMA=33, 
		SEMI=34, LPAREN=35, RPAREN=36, LBRACE=37, RBRACE=38, RARROW=39, LT=40, 
		ASSOC=41, RIGHT=42, LEFT=43, FAIL=44, GT=45, ASSIGN=46, QUESTION=47, STAR=48, 
		PLUS_ASSIGN=49, PLUS=50, OR=51, DOLLAR=52, RANGE=53, DOT=54, AT=55, HEADER=56, 
		MEMBERS=57, SHARP=58, NOT=59, ID=60, WS=61, ERRCHAR=62, END_ARGUMENT=63, 
		UNTERMINATED_ARGUMENT=64, ARGUMENT_CONTENT=65, END_ACTION=66, UNTERMINATED_ACTION=67, 
		ACTION_CONTENT=68, SUPER_CLASS=69, LANGUAGE=70, TOKEN_VOCAB=71, TOKEN_LABEL_TYPE=72, 
		OPT_WS=73, TOK_ID=74, TOK_WS=75, CHN_WS=76, SKIP_COMMAND=77, MORE_COMMAND=78, 
		TYPE_COMMAND=79, CHANNEL_COMMAND=80, MODE_COMMAND=81, PUSHMODE_COMMAND=82, 
		POPMODE_COMMAND=83, LEXER_COMMAND_WS=84, UNTERMINATED_CHAR_SET=85;
	public static final int Argument = 1;
	public static final int Action = 2;
	public static final int Options = 3;
	public static final int Tokens = 4;
	public static final int Channels = 5;
	public static final int LexerCommands = 6;
	public static final int LexerCharSet = 7;
	public static String[] modeNames = {
		"DEFAULT_MODE", "Argument", "Action", "Options", "Tokens", "Channels", 
		"LexerCommands", "LexerCharSet"
	};

	public static final String[] ruleNames = {
		"DOC_COMMENT", "BLOCK_COMMENT", "LINE_COMMENT", "INT", "STRING_LITERAL", 
		"UNTERMINATED_STRING_LITERAL", "BEGIN_ARGUMENT", "BEGIN_ACTION", "OPTIONS", 
		"TOKENS", "CHANNELS", "IMPORT", "FRAGMENT", "LEXER", "PARSER", "GRAMMAR", 
		"PROTECTED", "PUBLIC", "PRIVATE", "RETURNS", "LOCALS", "INIT", "AFTER", 
		"THROWS", "CATCH", "FINALLY", "MODE", "COLON", "COLONCOLON", "COMMA", 
		"SEMI", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "RARROW", "LT", "ASSOC", 
		"RIGHT", "LEFT", "FAIL", "GT", "ASSIGN", "QUESTION", "STAR", "PLUS_ASSIGN", 
		"PLUS", "OR", "DOLLAR", "RANGE", "DOT", "AT", "HEADER", "MEMBERS", "SHARP", 
		"NOT", "ID", "WS", "ERRCHAR", "Ws", "Hws", "Vws", "BlockComment", "DocComment", 
		"LineComment", "EscSeq", "EscAny", "UnicodeEsc", "DecimalNumeral", "HexDigit", 
		"DecDigit", "BoolLiteral", "CharLiteral", "SQuoteLiteral", "DQuoteLiteral", 
		"USQuoteLiteral", "UpperCaseLatinChar", "LowerCaseLatinChar", "LatinChar", 
		"NameChar", "NameStartChar", "Int", "Esc", "Colon", "DColon", "SQuote", 
		"DQuote", "LParen", "RParen", "LBrace", "RBrace", "LBrack", "RBrack", 
		"RArrow", "Lt", "Gt", "Equal", "Question", "Star", "Plus", "PlusAssign", 
		"Underscore", "Pipe", "Dollar", "Comma", "Semi", "Dot", "Range", "At", 
		"Sharp", "Tilde", "NESTED_ARGUMENT", "ARGUMENT_ESCAPE", "ARGUMENT_STRING_LITERAL", 
		"ARGUMENT_CHAR_LITERAL", "END_ARGUMENT", "UNTERMINATED_ARGUMENT", "ARGUMENT_CONTENT", 
		"NESTED_ACTION", "END_ACTION", "UNTERMINATED_ACTION", "ACTION_CONTENT", 
		"OPT_DOC_COMMENT", "OPT_BLOCK_COMMENT", "OPT_LINE_COMMENT", "OPT_LBRACE", 
		"OPT_RBRACE", "SUPER_CLASS", "LANGUAGE", "TOKEN_VOCAB", "TOKEN_LABEL_TYPE", 
		"OPT_ID", "OPT_DOT", "OPT_ASSIGN", "OPT_STRING_LITERAL", "OPT_INT", "OPT_STAR", 
		"OPT_SEMI", "OPT_WS", "TOK_DOC_COMMENT", "TOK_BLOCK_COMMENT", "TOK_LINE_COMMENT", 
		"TOK_LBRACE", "TOK_RBRACE", "TOK_ID", "TOK_DOT", "TOK_COMMA", "TOK_WS", 
		"CHN_DOC_COMMENT", "CHN_BLOCK_COMMENT", "CHN_LINE_COMMENT", "CHN_LBRACE", 
		"CHN_RBRACE", "CHN_ID", "CHN_DOT", "CHN_COMMA", "CHN_WS", "LEXER_COMMAND_LINE_COMMENT", 
		"SKIP_COMMAND", "MORE_COMMAND", "TYPE_COMMAND", "CHANNEL_COMMAND", "MODE_COMMAND", 
		"PUSHMODE_COMMAND", "POPMODE_COMMAND", "LEXER_COMMAND_LPAREN", "LEXER_COMMAND_ID", 
		"LEXER_COMMAND_INT", "LEXER_COMMAND_RPAREN", "LEXER_COMMAND_COMMA", "LEXER_COMMAND_WS", 
		"LEXER_COMMAND_SEMI", "LEXER_CHAR_SET_BODY", "LEXER_CHAR_SET", "UNTERMINATED_CHAR_SET"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"'options'", "'tokens'", "'channels'", "'import'", "'fragment'", "'lexer'", 
		"'parser'", "'grammar'", "'protected'", "'public'", "'private'", "'returns'", 
		"'locals'", "'init'", "'after'", "'throws'", "'catch'", "'finally'", null, 
		null, null, null, null, null, null, null, null, null, null, "'assoc'", 
		"'right'", "'left'", "'fail'", null, null, null, null, null, null, null, 
		null, null, null, null, "'header'", "'members'", null, null, null, null, 
		null, null, null, null, null, null, null, "'superClass'", "'language'", 
		"'tokenVocab'", "'TokenLabelType'", null, null, null, null, "'skip'", 
		"'more'", "'type'", "'channel'", null, "'pushMode'", "'popMode'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ID_STARTING_WITH_UPPERCASE", "ID_STARTING_WITH_LOWERCASE", "LEXER_CHAR_SET", 
		"DOC_COMMENT", "BLOCK_COMMENT", "LINE_COMMENT", "INT", "STRING_LITERAL", 
		"UNTERMINATED_STRING_LITERAL", "BEGIN_ARGUMENT", "BEGIN_ACTION", "OPTIONS", 
		"TOKENS", "CHANNELS", "IMPORT", "FRAGMENT", "LEXER", "PARSER", "GRAMMAR", 
		"PROTECTED", "PUBLIC", "PRIVATE", "RETURNS", "LOCALS", "INIT", "AFTER", 
		"THROWS", "CATCH", "FINALLY", "MODE", "COLON", "COLONCOLON", "COMMA", 
		"SEMI", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "RARROW", "LT", "ASSOC", 
		"RIGHT", "LEFT", "FAIL", "GT", "ASSIGN", "QUESTION", "STAR", "PLUS_ASSIGN", 
		"PLUS", "OR", "DOLLAR", "RANGE", "DOT", "AT", "HEADER", "MEMBERS", "SHARP", 
		"NOT", "ID", "WS", "ERRCHAR", "END_ARGUMENT", "UNTERMINATED_ARGUMENT", 
		"ARGUMENT_CONTENT", "END_ACTION", "UNTERMINATED_ACTION", "ACTION_CONTENT", 
		"SUPER_CLASS", "LANGUAGE", "TOKEN_VOCAB", "TOKEN_LABEL_TYPE", "OPT_WS", 
		"TOK_ID", "TOK_WS", "CHN_WS", "SKIP_COMMAND", "MORE_COMMAND", "TYPE_COMMAND", 
		"CHANNEL_COMMAND", "MODE_COMMAND", "PUSHMODE_COMMAND", "POPMODE_COMMAND", 
		"LEXER_COMMAND_WS", "UNTERMINATED_CHAR_SET"
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


	private int _currentRuleId = Token.INVALID_TYPE;
	private int _idMode = 0;
	private boolean _fragment = false;

	public int getCurrentRuleId() {
	    return _currentRuleId;
	}

	public void setCurrentRuleId(int ruleType) {
	    this._currentRuleId = ruleType;
	}

	private boolean inLexerRule() {
	    return _fragment
	           ? true
	           : _currentRuleId == ANTLRv4Lexer.ID_STARTING_WITH_UPPERCASE;
	}

	@Override
	public Token emit() {
	//    System.out.println("emit() : token=" + _SYMBOLIC_NAMES[_type]);
	    if (_type == ANTLRv4Lexer.ID_STARTING_WITH_UPPERCASE |
	        _type == ANTLRv4Lexer.ID_STARTING_WITH_LOWERCASE) {
		if (_currentRuleId == Token.INVALID_TYPE) { // if outside of rule def
	            _currentRuleId = _type; // set to inside lexer or parser rule
	        }
	    } else if (_type == ANTLRv4Lexer.SEMI) { // exit rule def
	        _currentRuleId = Token.INVALID_TYPE;
	    }

	    return super.emit();
	}


	public ANTLRv4Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ANTLRv4Lexer.g4"; }

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
		case 6:
			BEGIN_ARGUMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 11:
			IMPORT_action((RuleContext)_localctx, actionIndex);
			break;
		case 12:
			FRAGMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 15:
			GRAMMAR_action((RuleContext)_localctx, actionIndex);
			break;
		case 26:
			MODE_action((RuleContext)_localctx, actionIndex);
			break;
		case 27:
			COLON_action((RuleContext)_localctx, actionIndex);
			break;
		case 30:
			SEMI_action((RuleContext)_localctx, actionIndex);
			break;
		case 56:
			ID_action((RuleContext)_localctx, actionIndex);
			break;
		case 57:
			WS_action((RuleContext)_localctx, actionIndex);
			break;
		case 115:
			END_ARGUMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 119:
			END_ACTION_action((RuleContext)_localctx, actionIndex);
			break;
		case 138:
			OPT_WS_action((RuleContext)_localctx, actionIndex);
			break;
		case 144:
			TOK_ID_action((RuleContext)_localctx, actionIndex);
			break;
		case 147:
			TOK_WS_action((RuleContext)_localctx, actionIndex);
			break;
		case 156:
			CHN_WS_action((RuleContext)_localctx, actionIndex);
			break;
		case 170:
			LEXER_COMMAND_WS_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void BEGIN_ARGUMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:

			  // If we are in a lexer rule, then the brackets can only represent a lexer 
			  // char set definition so we pass in lexer char set mode
			     if (inLexerRule()) {
			//         System.out.println("It is a lexer char set definition");
			         pushMode(ANTLRv4Lexer.LexerCharSet);
			         more();
			  // else we are in a parser rule and the brackets represent argument(s)
			     } else {
			//         System.out.println("It is an argument definition");
			         pushMode(ANTLRv4Lexer.Argument);
			     }
			    
			break;
		}
	}
	private void IMPORT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:

			     _idMode = ANTLRv4Lexer.IMPORT;
			    
			break;
		}
	}
	private void FRAGMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:

			     _idMode = ANTLRv4Lexer.FRAGMENT;
			     _fragment = true;
			    
			break;
		}
	}
	private void GRAMMAR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:

			     _idMode=ANTLRv4Lexer.GRAMMAR;
			    
			break;
		}
	}
	private void MODE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:

			     _idMode = ANTLRv4Lexer.MODE;
			    
			break;
		}
	}
	private void COLON_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:

			     if (_idMode == ANTLRv4Lexer.FRAGMENT)
			         _idMode = 0;
			    
			break;
		}
	}
	private void SEMI_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6:

			     if ((_idMode == ANTLRv4Lexer.GRAMMAR) ||
			         (_idMode == ANTLRv4Lexer.IMPORT)  ||
			         (_idMode == ANTLRv4Lexer.MODE)      )
			         _idMode = 0;
			     if (_fragment)
			        _fragment = false;
			    
			break;
		}
	}
	private void ID_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 7:

			//     System.out.println("ID token rule");
			     String idValue = getText();
			//     System.out.println("ID value=" + idValue);
			     if (_idMode == 0) {
			         if ( Character.isUpperCase(idValue.charAt(0)) )
			             setType(ID_STARTING_WITH_UPPERCASE);
			         else
			             setType(ID_STARTING_WITH_LOWERCASE);
			     }
			//     System.out.println("ID: returned token=" + _SYMBOLIC_NAMES[_type]);
			    
			break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 8:

			     getText();
			//     skip();
			    
			break;
		}
	}
	private void END_ARGUMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 9:

			     popMode();
			     if (_modeStack.size() > 0) {
			         setType(ANTLRv4Lexer.ARGUMENT_CONTENT);
			     }
			    
			break;
		}
	}
	private void END_ACTION_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 10:

			     int mode = popMode();
			//     System.out.println("ANTLRv4Lexer.END_ACTION (syntax coloring): mode=" + mode);
			     if (_modeStack.size() > 0) {
			        more();
			     }
			    
			break;
		}
	}
	private void OPT_WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 11:

			     setType (WS);
			     getText();
			    
			break;
		}
	}
	private void TOK_ID_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 12:

			     String idValue = getText();
			     if ( Character.isUpperCase(idValue.charAt(0)) )
			         setType(ID_STARTING_WITH_UPPERCASE);
			     else
			         setType(ID_STARTING_WITH_LOWERCASE);
			//     System.out.println("TOK_ID: returned token type=" + _SYMBOLIC_NAMES[_type]);
			    
			break;
		}
	}
	private void TOK_WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 13:

			     setType (WS);
			     getText();
			    
			break;
		}
	}
	private void CHN_WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 14:

			     setType (WS);
			     getText();
			    
			break;
		}
	}
	private void LEXER_COMMAND_WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 15:

			     setType(WS);
			     getText();
			    
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2W\u04a4\b\1\b\1\b"+
		"\1\b\1\b\1\b\1\b\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7"+
		"\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17"+
		"\4\20\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26"+
		"\4\27\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35"+
		"\4\36\t\36\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t"+
		"\'\4(\t(\4)\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61"+
		"\4\62\t\62\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49"+
		"\t9\4:\t:\4;\t;\4<\t<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD"+
		"\4E\tE\4F\tF\4G\tG\4H\tH\4I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P"+
		"\tP\4Q\tQ\4R\tR\4S\tS\4T\tT\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t["+
		"\4\\\t\\\4]\t]\4^\t^\4_\t_\4`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4"+
		"g\tg\4h\th\4i\ti\4j\tj\4k\tk\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\t"+
		"r\4s\ts\4t\tt\4u\tu\4v\tv\4w\tw\4x\tx\4y\ty\4z\tz\4{\t{\4|\t|\4}\t}\4"+
		"~\t~\4\177\t\177\4\u0080\t\u0080\4\u0081\t\u0081\4\u0082\t\u0082\4\u0083"+
		"\t\u0083\4\u0084\t\u0084\4\u0085\t\u0085\4\u0086\t\u0086\4\u0087\t\u0087"+
		"\4\u0088\t\u0088\4\u0089\t\u0089\4\u008a\t\u008a\4\u008b\t\u008b\4\u008c"+
		"\t\u008c\4\u008d\t\u008d\4\u008e\t\u008e\4\u008f\t\u008f\4\u0090\t\u0090"+
		"\4\u0091\t\u0091\4\u0092\t\u0092\4\u0093\t\u0093\4\u0094\t\u0094\4\u0095"+
		"\t\u0095\4\u0096\t\u0096\4\u0097\t\u0097\4\u0098\t\u0098\4\u0099\t\u0099"+
		"\4\u009a\t\u009a\4\u009b\t\u009b\4\u009c\t\u009c\4\u009d\t\u009d\4\u009e"+
		"\t\u009e\4\u009f\t\u009f\4\u00a0\t\u00a0\4\u00a1\t\u00a1\4\u00a2\t\u00a2"+
		"\4\u00a3\t\u00a3\4\u00a4\t\u00a4\4\u00a5\t\u00a5\4\u00a6\t\u00a6\4\u00a7"+
		"\t\u00a7\4\u00a8\t\u00a8\4\u00a9\t\u00a9\4\u00aa\t\u00aa\4\u00ab\t\u00ab"+
		"\4\u00ac\t\u00ac\4\u00ad\t\u00ad\4\u00ae\t\u00ae\4\u00af\t\u00af\4\u00b0"+
		"\t\u00b0\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3"+
		"\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27"+
		"\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36"+
		"\3\37\3\37\3 \3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3%\3%\3&\3&\3\'\3"+
		"\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3+"+
		"\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3"+
		"\64\3\64\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3"+
		"\67\3\67\3\67\3\67\3\67\38\38\39\39\3:\3:\7:\u026d\n:\f:\16:\u0270\13"+
		":\3:\3:\3;\6;\u0275\n;\r;\16;\u0276\3;\3;\3<\3<\3<\3<\3=\3=\5=\u0281\n"+
		"=\3>\3>\3?\3?\3@\3@\3@\3@\7@\u028b\n@\f@\16@\u028e\13@\3@\3@\3@\3A\3A"+
		"\3A\3A\3A\7A\u0298\nA\fA\16A\u029b\13A\3A\3A\3A\3B\3B\3B\3B\7B\u02a4\n"+
		"B\fB\16B\u02a7\13B\3C\3C\3C\3C\5C\u02ad\nC\3D\3D\3D\3E\3E\3E\3E\3E\5E"+
		"\u02b7\nE\5E\u02b9\nE\5E\u02bb\nE\5E\u02bd\nE\3F\3F\3F\7F\u02c2\nF\fF"+
		"\16F\u02c5\13F\5F\u02c7\nF\3G\3G\3H\3H\3I\3I\3I\3I\3I\3I\3I\3I\3I\5I\u02d6"+
		"\nI\3J\3J\3J\5J\u02db\nJ\3J\3J\3K\3K\3K\7K\u02e2\nK\fK\16K\u02e5\13K\3"+
		"K\3K\3L\3L\3L\7L\u02ec\nL\fL\16L\u02ef\13L\3L\3L\3M\3M\3M\7M\u02f6\nM"+
		"\fM\16M\u02f9\13M\3N\3N\3O\3O\3P\3P\5P\u0301\nP\3Q\3Q\3Q\3Q\5Q\u0307\n"+
		"Q\3R\3R\5R\u030b\nR\3S\3S\3S\3S\3T\3T\3U\3U\3V\3V\3V\3W\3W\3X\3X\3Y\3"+
		"Y\3Z\3Z\3[\3[\3\\\3\\\3]\3]\3^\3^\3_\3_\3_\3`\3`\3a\3a\3b\3b\3c\3c\3d"+
		"\3d\3e\3e\3f\3f\3f\3g\3g\3h\3h\3i\3i\3j\3j\3k\3k\3l\3l\3m\3m\3m\3n\3n"+
		"\3o\3o\3p\3p\3q\3q\3q\3q\3q\3r\3r\3r\3r\3s\3s\3s\3s\3t\3t\3t\3t\3u\3u"+
		"\3u\3v\3v\3v\3v\3w\3w\3x\3x\3x\3x\3x\3y\3y\3y\3z\3z\3z\3z\3{\6{\u0376"+
		"\n{\r{\16{\u0377\3|\3|\3|\3|\3}\3}\3}\3}\3~\3~\3~\3~\3\177\3\177\3\177"+
		"\3\177\3\u0080\3\u0080\3\u0080\3\u0080\3\u0080\3\u0081\3\u0081\3\u0081"+
		"\3\u0081\3\u0081\3\u0081\3\u0081\3\u0081\3\u0081\3\u0081\3\u0081\3\u0082"+
		"\3\u0082\3\u0082\3\u0082\3\u0082\3\u0082\3\u0082\3\u0082\3\u0082\3\u0083"+
		"\3\u0083\3\u0083\3\u0083\3\u0083\3\u0083\3\u0083\3\u0083\3\u0083\3\u0083"+
		"\3\u0083\3\u0084\3\u0084\3\u0084\3\u0084\3\u0084\3\u0084\3\u0084\3\u0084"+
		"\3\u0084\3\u0084\3\u0084\3\u0084\3\u0084\3\u0084\3\u0084\3\u0085\3\u0085"+
		"\7\u0085\u03bf\n\u0085\f\u0085\16\u0085\u03c2\13\u0085\3\u0085\3\u0085"+
		"\3\u0086\3\u0086\3\u0086\3\u0086\3\u0087\3\u0087\3\u0087\3\u0087\3\u0088"+
		"\3\u0088\3\u0088\3\u0088\3\u0089\3\u0089\3\u0089\3\u0089\3\u008a\3\u008a"+
		"\3\u008a\3\u008a\3\u008b\3\u008b\3\u008b\3\u008b\3\u008c\6\u008c\u03df"+
		"\n\u008c\r\u008c\16\u008c\u03e0\3\u008c\3\u008c\3\u008d\3\u008d\3\u008d"+
		"\3\u008d\3\u008e\3\u008e\3\u008e\3\u008e\3\u008f\3\u008f\3\u008f\3\u008f"+
		"\3\u0090\3\u0090\3\u0090\3\u0090\3\u0091\3\u0091\3\u0091\3\u0091\3\u0091"+
		"\3\u0092\3\u0092\7\u0092\u03fc\n\u0092\f\u0092\16\u0092\u03ff\13\u0092"+
		"\3\u0092\3\u0092\3\u0093\3\u0093\3\u0093\3\u0093\3\u0094\3\u0094\3\u0094"+
		"\3\u0094\3\u0095\6\u0095\u040c\n\u0095\r\u0095\16\u0095\u040d\3\u0095"+
		"\3\u0095\3\u0096\3\u0096\3\u0096\3\u0096\3\u0097\3\u0097\3\u0097\3\u0097"+
		"\3\u0098\3\u0098\3\u0098\3\u0098\3\u0099\3\u0099\3\u0099\3\u0099\3\u009a"+
		"\3\u009a\3\u009a\3\u009a\3\u009a\3\u009b\3\u009b\7\u009b\u0429\n\u009b"+
		"\f\u009b\16\u009b\u042c\13\u009b\3\u009b\3\u009b\3\u009c\3\u009c\3\u009c"+
		"\3\u009c\3\u009d\3\u009d\3\u009d\3\u009d\3\u009e\6\u009e\u0439\n\u009e"+
		"\r\u009e\16\u009e\u043a\3\u009e\3\u009e\3\u009f\3\u009f\3\u009f\3\u009f"+
		"\3\u00a0\3\u00a0\3\u00a0\3\u00a0\3\u00a0\3\u00a1\3\u00a1\3\u00a1\3\u00a1"+
		"\3\u00a1\3\u00a2\3\u00a2\3\u00a2\3\u00a2\3\u00a2\3\u00a3\3\u00a3\3\u00a3"+
		"\3\u00a3\3\u00a3\3\u00a3\3\u00a3\3\u00a3\3\u00a4\3\u00a4\3\u00a4\3\u00a4"+
		"\3\u00a4\3\u00a5\3\u00a5\3\u00a5\3\u00a5\3\u00a5\3\u00a5\3\u00a5\3\u00a5"+
		"\3\u00a5\3\u00a6\3\u00a6\3\u00a6\3\u00a6\3\u00a6\3\u00a6\3\u00a6\3\u00a6"+
		"\3\u00a7\3\u00a7\3\u00a7\3\u00a7\3\u00a8\3\u00a8\7\u00a8\u0476\n\u00a8"+
		"\f\u00a8\16\u00a8\u0479\13\u00a8\3\u00a8\3\u00a8\3\u00a9\3\u00a9\3\u00a9"+
		"\3\u00a9\3\u00aa\3\u00aa\3\u00aa\3\u00aa\3\u00ab\3\u00ab\3\u00ab\3\u00ab"+
		"\3\u00ac\6\u00ac\u048a\n\u00ac\r\u00ac\16\u00ac\u048b\3\u00ac\3\u00ac"+
		"\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ae\3\u00ae\6\u00ae\u0497"+
		"\n\u00ae\r\u00ae\16\u00ae\u0498\3\u00ae\3\u00ae\3\u00af\3\u00af\3\u00af"+
		"\3\u00af\3\u00b0\3\u00b0\3\u00b0\3\u00b0\4\u028c\u0299\2\u00b1\n\6\f\7"+
		"\16\b\20\t\22\n\24\13\26\f\30\r\32\16\34\17\36\20 \21\"\22$\23&\24(\25"+
		"*\26,\27.\30\60\31\62\32\64\33\66\348\35:\36<\37> @!B\"D#F$H%J&L\'N(P"+
		")R*T+V,X-Z.\\/^\60`\61b\62d\63f\64h\65j\66l\67n8p9r:t;v<x=z>|?~@\u0080"+
		"\2\u0082\2\u0084\2\u0086\2\u0088\2\u008a\2\u008c\2\u008e\2\u0090\2\u0092"+
		"\2\u0094\2\u0096\2\u0098\2\u009a\2\u009c\2\u009e\2\u00a0\2\u00a2\2\u00a4"+
		"\2\u00a6\2\u00a8\2\u00aa\2\u00ac\2\u00ae\2\u00b0\2\u00b2\2\u00b4\2\u00b6"+
		"\2\u00b8\2\u00ba\2\u00bc\2\u00be\2\u00c0\2\u00c2\2\u00c4\2\u00c6\2\u00c8"+
		"\2\u00ca\2\u00cc\2\u00ce\2\u00d0\2\u00d2\2\u00d4\2\u00d6\2\u00d8\2\u00da"+
		"\2\u00dc\2\u00de\2\u00e0\2\u00e2\2\u00e4\2\u00e6\2\u00e8\2\u00ea\2\u00ec"+
		"\2\u00ee\2\u00f0A\u00f2B\u00f4C\u00f6\2\u00f8D\u00faE\u00fcF\u00fe\2\u0100"+
		"\2\u0102\2\u0104\2\u0106\2\u0108G\u010aH\u010cI\u010eJ\u0110\2\u0112\2"+
		"\u0114\2\u0116\2\u0118\2\u011a\2\u011c\2\u011eK\u0120\2\u0122\2\u0124"+
		"\2\u0126\2\u0128\2\u012aL\u012c\2\u012e\2\u0130M\u0132\2\u0134\2\u0136"+
		"\2\u0138\2\u013a\2\u013c\2\u013e\2\u0140\2\u0142N\u0144\2\u0146O\u0148"+
		"P\u014aQ\u014cR\u014eS\u0150T\u0152U\u0154\2\u0156\2\u0158\2\u015a\2\u015c"+
		"\2\u015eV\u0160\2\u0162\2\u0164\5\u0166W\n\2\3\4\5\6\7\b\t\17\4\2\13\13"+
		"\"\"\4\2\f\f\16\17\4\2\f\f\17\17\n\2$$))^^ddhhppttvv\3\2\63;\5\2\62;C"+
		"Hch\3\2\62;\6\2\f\f\17\17))^^\6\2\f\f\17\17$$^^\5\2\u00b9\u00b9\u0302"+
		"\u0371\u2041\u2042\r\2\u00c2\u00d8\u00da\u00f8\u00fa\u0301\u0372\u037f"+
		"\u0381\u2001\u200e\u200f\u2072\u2191\u2c02\u2ff1\u3003\ud801\uf902\ufdd1"+
		"\ufdf2\uffff\4\2}}\177\177\3\2^_\u048e\2\n\3\2\2\2\2\f\3\2\2\2\2\16\3"+
		"\2\2\2\2\20\3\2\2\2\2\22\3\2\2\2\2\24\3\2\2\2\2\26\3\2\2\2\2\30\3\2\2"+
		"\2\2\32\3\2\2\2\2\34\3\2\2\2\2\36\3\2\2\2\2 \3\2\2\2\2\"\3\2\2\2\2$\3"+
		"\2\2\2\2&\3\2\2\2\2(\3\2\2\2\2*\3\2\2\2\2,\3\2\2\2\2.\3\2\2\2\2\60\3\2"+
		"\2\2\2\62\3\2\2\2\2\64\3\2\2\2\2\66\3\2\2\2\28\3\2\2\2\2:\3\2\2\2\2<\3"+
		"\2\2\2\2>\3\2\2\2\2@\3\2\2\2\2B\3\2\2\2\2D\3\2\2\2\2F\3\2\2\2\2H\3\2\2"+
		"\2\2J\3\2\2\2\2L\3\2\2\2\2N\3\2\2\2\2P\3\2\2\2\2R\3\2\2\2\2T\3\2\2\2\2"+
		"V\3\2\2\2\2X\3\2\2\2\2Z\3\2\2\2\2\\\3\2\2\2\2^\3\2\2\2\2`\3\2\2\2\2b\3"+
		"\2\2\2\2d\3\2\2\2\2f\3\2\2\2\2h\3\2\2\2\2j\3\2\2\2\2l\3\2\2\2\2n\3\2\2"+
		"\2\2p\3\2\2\2\2r\3\2\2\2\2t\3\2\2\2\2v\3\2\2\2\2x\3\2\2\2\2z\3\2\2\2\2"+
		"|\3\2\2\2\2~\3\2\2\2\3\u00e8\3\2\2\2\3\u00ea\3\2\2\2\3\u00ec\3\2\2\2\3"+
		"\u00ee\3\2\2\2\3\u00f0\3\2\2\2\3\u00f2\3\2\2\2\3\u00f4\3\2\2\2\4\u00f6"+
		"\3\2\2\2\4\u00f8\3\2\2\2\4\u00fa\3\2\2\2\4\u00fc\3\2\2\2\5\u00fe\3\2\2"+
		"\2\5\u0100\3\2\2\2\5\u0102\3\2\2\2\5\u0104\3\2\2\2\5\u0106\3\2\2\2\5\u0108"+
		"\3\2\2\2\5\u010a\3\2\2\2\5\u010c\3\2\2\2\5\u010e\3\2\2\2\5\u0110\3\2\2"+
		"\2\5\u0112\3\2\2\2\5\u0114\3\2\2\2\5\u0116\3\2\2\2\5\u0118\3\2\2\2\5\u011a"+
		"\3\2\2\2\5\u011c\3\2\2\2\5\u011e\3\2\2\2\6\u0120\3\2\2\2\6\u0122\3\2\2"+
		"\2\6\u0124\3\2\2\2\6\u0126\3\2\2\2\6\u0128\3\2\2\2\6\u012a\3\2\2\2\6\u012c"+
		"\3\2\2\2\6\u012e\3\2\2\2\6\u0130\3\2\2\2\7\u0132\3\2\2\2\7\u0134\3\2\2"+
		"\2\7\u0136\3\2\2\2\7\u0138\3\2\2\2\7\u013a\3\2\2\2\7\u013c\3\2\2\2\7\u013e"+
		"\3\2\2\2\7\u0140\3\2\2\2\7\u0142\3\2\2\2\b\u0144\3\2\2\2\b\u0146\3\2\2"+
		"\2\b\u0148\3\2\2\2\b\u014a\3\2\2\2\b\u014c\3\2\2\2\b\u014e\3\2\2\2\b\u0150"+
		"\3\2\2\2\b\u0152\3\2\2\2\b\u0154\3\2\2\2\b\u0156\3\2\2\2\b\u0158\3\2\2"+
		"\2\b\u015a\3\2\2\2\b\u015c\3\2\2\2\b\u015e\3\2\2\2\b\u0160\3\2\2\2\t\u0162"+
		"\3\2\2\2\t\u0164\3\2\2\2\t\u0166\3\2\2\2\n\u0168\3\2\2\2\f\u016a\3\2\2"+
		"\2\16\u016c\3\2\2\2\20\u016e\3\2\2\2\22\u0170\3\2\2\2\24\u0172\3\2\2\2"+
		"\26\u0174\3\2\2\2\30\u0177\3\2\2\2\32\u017b\3\2\2\2\34\u0185\3\2\2\2\36"+
		"\u018e\3\2\2\2 \u0199\3\2\2\2\"\u01a2\3\2\2\2$\u01ad\3\2\2\2&\u01b3\3"+
		"\2\2\2(\u01ba\3\2\2\2*\u01c4\3\2\2\2,\u01ce\3\2\2\2.\u01d5\3\2\2\2\60"+
		"\u01dd\3\2\2\2\62\u01e5\3\2\2\2\64\u01ec\3\2\2\2\66\u01f1\3\2\2\28\u01f7"+
		"\3\2\2\2:\u01fe\3\2\2\2<\u0204\3\2\2\2>\u020c\3\2\2\2@\u0213\3\2\2\2B"+
		"\u0216\3\2\2\2D\u0218\3\2\2\2F\u021a\3\2\2\2H\u021d\3\2\2\2J\u021f\3\2"+
		"\2\2L\u0221\3\2\2\2N\u0223\3\2\2\2P\u0225\3\2\2\2R\u0229\3\2\2\2T\u022b"+
		"\3\2\2\2V\u0231\3\2\2\2X\u0237\3\2\2\2Z\u023c\3\2\2\2\\\u0241\3\2\2\2"+
		"^\u0243\3\2\2\2`\u0245\3\2\2\2b\u0247\3\2\2\2d\u0249\3\2\2\2f\u024b\3"+
		"\2\2\2h\u024d\3\2\2\2j\u024f\3\2\2\2l\u0251\3\2\2\2n\u0253\3\2\2\2p\u0255"+
		"\3\2\2\2r\u0257\3\2\2\2t\u025e\3\2\2\2v\u0266\3\2\2\2x\u0268\3\2\2\2z"+
		"\u026a\3\2\2\2|\u0274\3\2\2\2~\u027a\3\2\2\2\u0080\u0280\3\2\2\2\u0082"+
		"\u0282\3\2\2\2\u0084\u0284\3\2\2\2\u0086\u0286\3\2\2\2\u0088\u0292\3\2"+
		"\2\2\u008a\u029f\3\2\2\2\u008c\u02a8\3\2\2\2\u008e\u02ae\3\2\2\2\u0090"+
		"\u02b1\3\2\2\2\u0092\u02c6\3\2\2\2\u0094\u02c8\3\2\2\2\u0096\u02ca\3\2"+
		"\2\2\u0098\u02d5\3\2\2\2\u009a\u02d7\3\2\2\2\u009c\u02de\3\2\2\2\u009e"+
		"\u02e8\3\2\2\2\u00a0\u02f2\3\2\2\2\u00a2\u02fa\3\2\2\2\u00a4\u02fc\3\2"+
		"\2\2\u00a6\u0300\3\2\2\2\u00a8\u0306\3\2\2\2\u00aa\u030a\3\2\2\2\u00ac"+
		"\u030c\3\2\2\2\u00ae\u0310\3\2\2\2\u00b0\u0312\3\2\2\2\u00b2\u0314\3\2"+
		"\2\2\u00b4\u0317\3\2\2\2\u00b6\u0319\3\2\2\2\u00b8\u031b\3\2\2\2\u00ba"+
		"\u031d\3\2\2\2\u00bc\u031f\3\2\2\2\u00be\u0321\3\2\2\2\u00c0\u0323\3\2"+
		"\2\2\u00c2\u0325\3\2\2\2\u00c4\u0327\3\2\2\2\u00c6\u032a\3\2\2\2\u00c8"+
		"\u032c\3\2\2\2\u00ca\u032e\3\2\2\2\u00cc\u0330\3\2\2\2\u00ce\u0332\3\2"+
		"\2\2\u00d0\u0334\3\2\2\2\u00d2\u0336\3\2\2\2\u00d4\u0339\3\2\2\2\u00d6"+
		"\u033b\3\2\2\2\u00d8\u033d\3\2\2\2\u00da\u033f\3\2\2\2\u00dc\u0341\3\2"+
		"\2\2\u00de\u0343\3\2\2\2\u00e0\u0345\3\2\2\2\u00e2\u0348\3\2\2\2\u00e4"+
		"\u034a\3\2\2\2\u00e6\u034c\3\2\2\2\u00e8\u034e\3\2\2\2\u00ea\u0353\3\2"+
		"\2\2\u00ec\u0357\3\2\2\2\u00ee\u035b\3\2\2\2\u00f0\u035f\3\2\2\2\u00f2"+
		"\u0362\3\2\2\2\u00f4\u0366\3\2\2\2\u00f6\u0368\3\2\2\2\u00f8\u036d\3\2"+
		"\2\2\u00fa\u0370\3\2\2\2\u00fc\u0375\3\2\2\2\u00fe\u0379\3\2\2\2\u0100"+
		"\u037d\3\2\2\2\u0102\u0381\3\2\2\2\u0104\u0385\3\2\2\2\u0106\u0389\3\2"+
		"\2\2\u0108\u038e\3\2\2\2\u010a\u0399\3\2\2\2\u010c\u03a2\3\2\2\2\u010e"+
		"\u03ad\3\2\2\2\u0110\u03bc\3\2\2\2\u0112\u03c5\3\2\2\2\u0114\u03c9\3\2"+
		"\2\2\u0116\u03cd\3\2\2\2\u0118\u03d1\3\2\2\2\u011a\u03d5\3\2\2\2\u011c"+
		"\u03d9\3\2\2\2\u011e\u03de\3\2\2\2\u0120\u03e4\3\2\2\2\u0122\u03e8\3\2"+
		"\2\2\u0124\u03ec\3\2\2\2\u0126\u03f0\3\2\2\2\u0128\u03f4\3\2\2\2\u012a"+
		"\u03f9\3\2\2\2\u012c\u0402\3\2\2\2\u012e\u0406\3\2\2\2\u0130\u040b\3\2"+
		"\2\2\u0132\u0411\3\2\2\2\u0134\u0415\3\2\2\2\u0136\u0419\3\2\2\2\u0138"+
		"\u041d\3\2\2\2\u013a\u0421\3\2\2\2\u013c\u0426\3\2\2\2\u013e\u042f\3\2"+
		"\2\2\u0140\u0433\3\2\2\2\u0142\u0438\3\2\2\2\u0144\u043e\3\2\2\2\u0146"+
		"\u0442\3\2\2\2\u0148\u0447\3\2\2\2\u014a\u044c\3\2\2\2\u014c\u0451\3\2"+
		"\2\2\u014e\u0459\3\2\2\2\u0150\u045e\3\2\2\2\u0152\u0467\3\2\2\2\u0154"+
		"\u046f\3\2\2\2\u0156\u0473\3\2\2\2\u0158\u047c\3\2\2\2\u015a\u0480\3\2"+
		"\2\2\u015c\u0484\3\2\2\2\u015e\u0489\3\2\2\2\u0160\u048f\3\2\2\2\u0162"+
		"\u0496\3\2\2\2\u0164\u049c\3\2\2\2\u0166\u04a0\3\2\2\2\u0168\u0169\5\u0088"+
		"A\2\u0169\13\3\2\2\2\u016a\u016b\5\u0086@\2\u016b\r\3\2\2\2\u016c\u016d"+
		"\5\u008aB\2\u016d\17\3\2\2\2\u016e\u016f\5\u0092F\2\u016f\21\3\2\2\2\u0170"+
		"\u0171\5\u009cK\2\u0171\23\3\2\2\2\u0172\u0173\5\u00a0M\2\u0173\25\3\2"+
		"\2\2\u0174\u0175\5\u00c0]\2\u0175\u0176\b\b\2\2\u0176\27\3\2\2\2\u0177"+
		"\u0178\5\u00bc[\2\u0178\u0179\3\2\2\2\u0179\u017a\b\t\3\2\u017a\31\3\2"+
		"\2\2\u017b\u017c\7q\2\2\u017c\u017d\7r\2\2\u017d\u017e\7v\2\2\u017e\u017f"+
		"\7k\2\2\u017f\u0180\7q\2\2\u0180\u0181\7p\2\2\u0181\u0182\7u\2\2\u0182"+
		"\u0183\3\2\2\2\u0183\u0184\b\n\4\2\u0184\33\3\2\2\2\u0185\u0186\7v\2\2"+
		"\u0186\u0187\7q\2\2\u0187\u0188\7m\2\2\u0188\u0189\7g\2\2\u0189\u018a"+
		"\7p\2\2\u018a\u018b\7u\2\2\u018b\u018c\3\2\2\2\u018c\u018d\b\13\5\2\u018d"+
		"\35\3\2\2\2\u018e\u018f\7e\2\2\u018f\u0190\7j\2\2\u0190\u0191\7c\2\2\u0191"+
		"\u0192\7p\2\2\u0192\u0193\7p\2\2\u0193\u0194\7g\2\2\u0194\u0195\7n\2\2"+
		"\u0195\u0196\7u\2\2\u0196\u0197\3\2\2\2\u0197\u0198\b\f\6\2\u0198\37\3"+
		"\2\2\2\u0199\u019a\7k\2\2\u019a\u019b\7o\2\2\u019b\u019c\7r\2\2\u019c"+
		"\u019d\7q\2\2\u019d\u019e\7t\2\2\u019e\u019f\7v\2\2\u019f\u01a0\3\2\2"+
		"\2\u01a0\u01a1\b\r\7\2\u01a1!\3\2\2\2\u01a2\u01a3\7h\2\2\u01a3\u01a4\7"+
		"t\2\2\u01a4\u01a5\7c\2\2\u01a5\u01a6\7i\2\2\u01a6\u01a7\7o\2\2\u01a7\u01a8"+
		"\7g\2\2\u01a8\u01a9\7p\2\2\u01a9\u01aa\7v\2\2\u01aa\u01ab\3\2\2\2\u01ab"+
		"\u01ac\b\16\b\2\u01ac#\3\2\2\2\u01ad\u01ae\7n\2\2\u01ae\u01af\7g\2\2\u01af"+
		"\u01b0\7z\2\2\u01b0\u01b1\7g\2\2\u01b1\u01b2\7t\2\2\u01b2%\3\2\2\2\u01b3"+
		"\u01b4\7r\2\2\u01b4\u01b5\7c\2\2\u01b5\u01b6\7t\2\2\u01b6\u01b7\7u\2\2"+
		"\u01b7\u01b8\7g\2\2\u01b8\u01b9\7t\2\2\u01b9\'\3\2\2\2\u01ba\u01bb\7i"+
		"\2\2\u01bb\u01bc\7t\2\2\u01bc\u01bd\7c\2\2\u01bd\u01be\7o\2\2\u01be\u01bf"+
		"\7o\2\2\u01bf\u01c0\7c\2\2\u01c0\u01c1\7t\2\2\u01c1\u01c2\3\2\2\2\u01c2"+
		"\u01c3\b\21\t\2\u01c3)\3\2\2\2\u01c4\u01c5\7r\2\2\u01c5\u01c6\7t\2\2\u01c6"+
		"\u01c7\7q\2\2\u01c7\u01c8\7v\2\2\u01c8\u01c9\7g\2\2\u01c9\u01ca\7e\2\2"+
		"\u01ca\u01cb\7v\2\2\u01cb\u01cc\7g\2\2\u01cc\u01cd\7f\2\2\u01cd+\3\2\2"+
		"\2\u01ce\u01cf\7r\2\2\u01cf\u01d0\7w\2\2\u01d0\u01d1\7d\2\2\u01d1\u01d2"+
		"\7n\2\2\u01d2\u01d3\7k\2\2\u01d3\u01d4\7e\2\2\u01d4-\3\2\2\2\u01d5\u01d6"+
		"\7r\2\2\u01d6\u01d7\7t\2\2\u01d7\u01d8\7k\2\2\u01d8\u01d9\7x\2\2\u01d9"+
		"\u01da\7c\2\2\u01da\u01db\7v\2\2\u01db\u01dc\7g\2\2\u01dc/\3\2\2\2\u01dd"+
		"\u01de\7t\2\2\u01de\u01df\7g\2\2\u01df\u01e0\7v\2\2\u01e0\u01e1\7w\2\2"+
		"\u01e1\u01e2\7t\2\2\u01e2\u01e3\7p\2\2\u01e3\u01e4\7u\2\2\u01e4\61\3\2"+
		"\2\2\u01e5\u01e6\7n\2\2\u01e6\u01e7\7q\2\2\u01e7\u01e8\7e\2\2\u01e8\u01e9"+
		"\7c\2\2\u01e9\u01ea\7n\2\2\u01ea\u01eb\7u\2\2\u01eb\63\3\2\2\2\u01ec\u01ed"+
		"\7k\2\2\u01ed\u01ee\7p\2\2\u01ee\u01ef\7k\2\2\u01ef\u01f0\7v\2\2\u01f0"+
		"\65\3\2\2\2\u01f1\u01f2\7c\2\2\u01f2\u01f3\7h\2\2\u01f3\u01f4\7v\2\2\u01f4"+
		"\u01f5\7g\2\2\u01f5\u01f6\7t\2\2\u01f6\67\3\2\2\2\u01f7\u01f8\7v\2\2\u01f8"+
		"\u01f9\7j\2\2\u01f9\u01fa\7t\2\2\u01fa\u01fb\7q\2\2\u01fb\u01fc\7y\2\2"+
		"\u01fc\u01fd\7u\2\2\u01fd9\3\2\2\2\u01fe\u01ff\7e\2\2\u01ff\u0200\7c\2"+
		"\2\u0200\u0201\7v\2\2\u0201\u0202\7e\2\2\u0202\u0203\7j\2\2\u0203;\3\2"+
		"\2\2\u0204\u0205\7h\2\2\u0205\u0206\7k\2\2\u0206\u0207\7p\2\2\u0207\u0208"+
		"\7c\2\2\u0208\u0209\7n\2\2\u0209\u020a\7n\2\2\u020a\u020b\7{\2\2\u020b"+
		"=\3\2\2\2\u020c\u020d\7o\2\2\u020d\u020e\7q\2\2\u020e\u020f\7f\2\2\u020f"+
		"\u0210\7g\2\2\u0210\u0211\3\2\2\2\u0211\u0212\b\34\n\2\u0212?\3\2\2\2"+
		"\u0213\u0214\5\u00b0U\2\u0214\u0215\b\35\13\2\u0215A\3\2\2\2\u0216\u0217"+
		"\5\u00b2V\2\u0217C\3\2\2\2\u0218\u0219\5\u00daj\2\u0219E\3\2\2\2\u021a"+
		"\u021b\5\u00dck\2\u021b\u021c\b \f\2\u021cG\3\2\2\2\u021d\u021e\5\u00b8"+
		"Y\2\u021eI\3\2\2\2\u021f\u0220\5\u00baZ\2\u0220K\3\2\2\2\u0221\u0222\5"+
		"\u00bc[\2\u0222M\3\2\2\2\u0223\u0224\5\u00be\\\2\u0224O\3\2\2\2\u0225"+
		"\u0226\5\u00c4_\2\u0226\u0227\3\2\2\2\u0227\u0228\b%\r\2\u0228Q\3\2\2"+
		"\2\u0229\u022a\5\u00c6`\2\u022aS\3\2\2\2\u022b\u022c\7c\2\2\u022c\u022d"+
		"\7u\2\2\u022d\u022e\7u\2\2\u022e\u022f\7q\2\2\u022f\u0230\7e\2\2\u0230"+
		"U\3\2\2\2\u0231\u0232\7t\2\2\u0232\u0233\7k\2\2\u0233\u0234\7i\2\2\u0234"+
		"\u0235\7j\2\2\u0235\u0236\7v\2\2\u0236W\3\2\2\2\u0237\u0238\7n\2\2\u0238"+
		"\u0239\7g\2\2\u0239\u023a\7h\2\2\u023a\u023b\7v\2\2\u023bY\3\2\2\2\u023c"+
		"\u023d\7h\2\2\u023d\u023e\7c\2\2\u023e\u023f\7k\2\2\u023f\u0240\7n\2\2"+
		"\u0240[\3\2\2\2\u0241\u0242\5\u00c8a\2\u0242]\3\2\2\2\u0243\u0244\5\u00ca"+
		"b\2\u0244_\3\2\2\2\u0245\u0246\5\u00ccc\2\u0246a\3\2\2\2\u0247\u0248\5"+
		"\u00ced\2\u0248c\3\2\2\2\u0249\u024a\5\u00d2f\2\u024ae\3\2\2\2\u024b\u024c"+
		"\5\u00d0e\2\u024cg\3\2\2\2\u024d\u024e\5\u00d6h\2\u024ei\3\2\2\2\u024f"+
		"\u0250\5\u00d8i\2\u0250k\3\2\2\2\u0251\u0252\5\u00e0m\2\u0252m\3\2\2\2"+
		"\u0253\u0254\5\u00del\2\u0254o\3\2\2\2\u0255\u0256\5\u00e2n\2\u0256q\3"+
		"\2\2\2\u0257\u0258\7j\2\2\u0258\u0259\7g\2\2\u0259\u025a\7c\2\2\u025a"+
		"\u025b\7f\2\2\u025b\u025c\7g\2\2\u025c\u025d\7t\2\2\u025ds\3\2\2\2\u025e"+
		"\u025f\7o\2\2\u025f\u0260\7g\2\2\u0260\u0261\7o\2\2\u0261\u0262\7d\2\2"+
		"\u0262\u0263\7g\2\2\u0263\u0264\7t\2\2\u0264\u0265\7u\2\2\u0265u\3\2\2"+
		"\2\u0266\u0267\5\u00e4o\2\u0267w\3\2\2\2\u0268\u0269\5\u00e6p\2\u0269"+
		"y\3\2\2\2\u026a\u026e\5\u00aaR\2\u026b\u026d\5\u00a8Q\2\u026c\u026b\3"+
		"\2\2\2\u026d\u0270\3\2\2\2\u026e\u026c\3\2\2\2\u026e\u026f\3\2\2\2\u026f"+
		"\u0271\3\2\2\2\u0270\u026e\3\2\2\2\u0271\u0272\b:\16\2\u0272{\3\2\2\2"+
		"\u0273\u0275\5\u0080=\2\u0274\u0273\3\2\2\2\u0275\u0276\3\2\2\2\u0276"+
		"\u0274\3\2\2\2\u0276\u0277\3\2\2\2\u0277\u0278\3\2\2\2\u0278\u0279\b;"+
		"\17\2\u0279}\3\2\2\2\u027a\u027b\13\2\2\2\u027b\u027c\3\2\2\2\u027c\u027d"+
		"\b<\20\2\u027d\177\3\2\2\2\u027e\u0281\5\u0082>\2\u027f\u0281\5\u0084"+
		"?\2\u0280\u027e\3\2\2\2\u0280\u027f\3\2\2\2\u0281\u0081\3\2\2\2\u0282"+
		"\u0283\t\2\2\2\u0283\u0083\3\2\2\2\u0284\u0285\t\3\2\2\u0285\u0085\3\2"+
		"\2\2\u0286\u0287\7\61\2\2\u0287\u0288\7,\2\2\u0288\u028c\3\2\2\2\u0289"+
		"\u028b\13\2\2\2\u028a\u0289\3\2\2\2\u028b\u028e\3\2\2\2\u028c\u028d\3"+
		"\2\2\2\u028c\u028a\3\2\2\2\u028d\u028f\3\2\2\2\u028e\u028c\3\2\2\2\u028f"+
		"\u0290\7,\2\2\u0290\u0291\7\61\2\2\u0291\u0087\3\2\2\2\u0292\u0293\7\61"+
		"\2\2\u0293\u0294\7,\2\2\u0294\u0295\7,\2\2\u0295\u0299\3\2\2\2\u0296\u0298"+
		"\13\2\2\2\u0297\u0296\3\2\2\2\u0298\u029b\3\2\2\2\u0299\u029a\3\2\2\2"+
		"\u0299\u0297\3\2\2\2\u029a\u029c\3\2\2\2\u029b\u0299\3\2\2\2\u029c\u029d"+
		"\7,\2\2\u029d\u029e\7\61\2\2\u029e\u0089\3\2\2\2\u029f\u02a0\7\61\2\2"+
		"\u02a0\u02a1\7\61\2\2\u02a1\u02a5\3\2\2\2\u02a2\u02a4\n\4\2\2\u02a3\u02a2"+
		"\3\2\2\2\u02a4\u02a7\3\2\2\2\u02a5\u02a3\3\2\2\2\u02a5\u02a6\3\2\2\2\u02a6"+
		"\u008b\3\2\2\2\u02a7\u02a5\3\2\2\2\u02a8\u02ac\5\u00aeT\2\u02a9\u02ad"+
		"\t\5\2\2\u02aa\u02ad\5\u0090E\2\u02ab\u02ad\13\2\2\2\u02ac\u02a9\3\2\2"+
		"\2\u02ac\u02aa\3\2\2\2\u02ac\u02ab\3\2\2\2\u02ad\u008d\3\2\2\2\u02ae\u02af"+
		"\5\u00aeT\2\u02af\u02b0\13\2\2\2\u02b0\u008f\3\2\2\2\u02b1\u02bc\7w\2"+
		"\2\u02b2\u02ba\5\u0094G\2\u02b3\u02b8\5\u0094G\2\u02b4\u02b6\5\u0094G"+
		"\2\u02b5\u02b7\5\u0094G\2\u02b6\u02b5\3\2\2\2\u02b6\u02b7\3\2\2\2\u02b7"+
		"\u02b9\3\2\2\2\u02b8\u02b4\3\2\2\2\u02b8\u02b9\3\2\2\2\u02b9\u02bb\3\2"+
		"\2\2\u02ba\u02b3\3\2\2\2\u02ba\u02bb\3\2\2\2\u02bb\u02bd\3\2\2\2\u02bc"+
		"\u02b2\3\2\2\2\u02bc\u02bd\3\2\2\2\u02bd\u0091\3\2\2\2\u02be\u02c7\7\62"+
		"\2\2\u02bf\u02c3\t\6\2\2\u02c0\u02c2\5\u0096H\2\u02c1\u02c0\3\2\2\2\u02c2"+
		"\u02c5\3\2\2\2\u02c3\u02c1\3\2\2\2\u02c3\u02c4\3\2\2\2\u02c4\u02c7\3\2"+
		"\2\2\u02c5\u02c3\3\2\2\2\u02c6\u02be\3\2\2\2\u02c6\u02bf\3\2\2\2\u02c7"+
		"\u0093\3\2\2\2\u02c8\u02c9\t\7\2\2\u02c9\u0095\3\2\2\2\u02ca\u02cb\t\b"+
		"\2\2\u02cb\u0097\3\2\2\2\u02cc\u02cd\7v\2\2\u02cd\u02ce\7t\2\2\u02ce\u02cf"+
		"\7w\2\2\u02cf\u02d6\7g\2\2\u02d0\u02d1\7h\2\2\u02d1\u02d2\7c\2\2\u02d2"+
		"\u02d3\7n\2\2\u02d3\u02d4\7u\2\2\u02d4\u02d6\7g\2\2\u02d5\u02cc\3\2\2"+
		"\2\u02d5\u02d0\3\2\2\2\u02d6\u0099\3\2\2\2\u02d7\u02da\5\u00b4W\2\u02d8"+
		"\u02db\5\u008cC\2\u02d9\u02db\n\t\2\2\u02da\u02d8\3\2\2\2\u02da\u02d9"+
		"\3\2\2\2\u02db\u02dc\3\2\2\2\u02dc\u02dd\5\u00b4W\2\u02dd\u009b\3\2\2"+
		"\2\u02de\u02e3\5\u00b4W\2\u02df\u02e2\5\u008cC\2\u02e0\u02e2\n\t\2\2\u02e1"+
		"\u02df\3\2\2\2\u02e1\u02e0\3\2\2\2\u02e2\u02e5\3\2\2\2\u02e3\u02e1\3\2"+
		"\2\2\u02e3\u02e4\3\2\2\2\u02e4\u02e6\3\2\2\2\u02e5\u02e3\3\2\2\2\u02e6"+
		"\u02e7\5\u00b4W\2\u02e7\u009d\3\2\2\2\u02e8\u02ed\5\u00b6X\2\u02e9\u02ec"+
		"\5\u008cC\2\u02ea\u02ec\n\n\2\2\u02eb\u02e9\3\2\2\2\u02eb\u02ea\3\2\2"+
		"\2\u02ec\u02ef\3\2\2\2\u02ed\u02eb\3\2\2\2\u02ed\u02ee\3\2\2\2\u02ee\u02f0"+
		"\3\2\2\2\u02ef\u02ed\3\2\2\2\u02f0\u02f1\5\u00b6X\2\u02f1\u009f\3\2\2"+
		"\2\u02f2\u02f7\5\u00b4W\2\u02f3\u02f6\5\u008cC\2\u02f4\u02f6\n\t\2\2\u02f5"+
		"\u02f3\3\2\2\2\u02f5\u02f4\3\2\2\2\u02f6\u02f9\3\2\2\2\u02f7\u02f5\3\2"+
		"\2\2\u02f7\u02f8\3\2\2\2\u02f8\u00a1\3\2\2\2\u02f9\u02f7\3\2\2\2\u02fa"+
		"\u02fb\4C\\\2\u02fb\u00a3\3\2\2\2\u02fc\u02fd\4c|\2\u02fd\u00a5\3\2\2"+
		"\2\u02fe\u0301\5\u00a2N\2\u02ff\u0301\5\u00a4O\2\u0300\u02fe\3\2\2\2\u0300"+
		"\u02ff\3\2\2\2\u0301\u00a7\3\2\2\2\u0302\u0307\5\u00aaR\2\u0303\u0307"+
		"\4\62;\2\u0304\u0307\5\u00d4g\2\u0305\u0307\t\13\2\2\u0306\u0302\3\2\2"+
		"\2\u0306\u0303\3\2\2\2\u0306\u0304\3\2\2\2\u0306\u0305\3\2\2\2\u0307\u00a9"+
		"\3\2\2\2\u0308\u030b\5\u00a6P\2\u0309\u030b\t\f\2\2\u030a\u0308\3\2\2"+
		"\2\u030a\u0309\3\2\2\2\u030b\u00ab\3\2\2\2\u030c\u030d\7k\2\2\u030d\u030e"+
		"\7p\2\2\u030e\u030f\7v\2\2\u030f\u00ad\3\2\2\2\u0310\u0311\7^\2\2\u0311"+
		"\u00af\3\2\2\2\u0312\u0313\7<\2\2\u0313\u00b1\3\2\2\2\u0314\u0315\7<\2"+
		"\2\u0315\u0316\7<\2\2\u0316\u00b3\3\2\2\2\u0317\u0318\7)\2\2\u0318\u00b5"+
		"\3\2\2\2\u0319\u031a\7$\2\2\u031a\u00b7\3\2\2\2\u031b\u031c\7*\2\2\u031c"+
		"\u00b9\3\2\2\2\u031d\u031e\7+\2\2\u031e\u00bb\3\2\2\2\u031f\u0320\7}\2"+
		"\2\u0320\u00bd\3\2\2\2\u0321\u0322\7\177\2\2\u0322\u00bf\3\2\2\2\u0323"+
		"\u0324\7]\2\2\u0324\u00c1\3\2\2\2\u0325\u0326\7_\2\2\u0326\u00c3\3\2\2"+
		"\2\u0327\u0328\7/\2\2\u0328\u0329\7@\2\2\u0329\u00c5\3\2\2\2\u032a\u032b"+
		"\7>\2\2\u032b\u00c7\3\2\2\2\u032c\u032d\7@\2\2\u032d\u00c9\3\2\2\2\u032e"+
		"\u032f\7?\2\2\u032f\u00cb\3\2\2\2\u0330\u0331\7A\2\2\u0331\u00cd\3\2\2"+
		"\2\u0332\u0333\7,\2\2\u0333\u00cf\3\2\2\2\u0334\u0335\7-\2\2\u0335\u00d1"+
		"\3\2\2\2\u0336\u0337\7-\2\2\u0337\u0338\7?\2\2\u0338\u00d3\3\2\2\2\u0339"+
		"\u033a\7a\2\2\u033a\u00d5\3\2\2\2\u033b\u033c\7~\2\2\u033c\u00d7\3\2\2"+
		"\2\u033d\u033e\7&\2\2\u033e\u00d9\3\2\2\2\u033f\u0340\7.\2\2\u0340\u00db"+
		"\3\2\2\2\u0341\u0342\7=\2\2\u0342\u00dd\3\2\2\2\u0343\u0344\7\60\2\2\u0344"+
		"\u00df\3\2\2\2\u0345\u0346\7\60\2\2\u0346\u0347\7\60\2\2\u0347\u00e1\3"+
		"\2\2\2\u0348\u0349\7B\2\2\u0349\u00e3\3\2\2\2\u034a\u034b\7%\2\2\u034b"+
		"\u00e5\3\2\2\2\u034c\u034d\7\u0080\2\2\u034d\u00e7\3\2\2\2\u034e\u034f"+
		"\5\u00c0]\2\u034f\u0350\3\2\2\2\u0350\u0351\bq\21\2\u0351\u0352\bq\22"+
		"\2\u0352\u00e9\3\2\2\2\u0353\u0354\5\u008eD\2\u0354\u0355\3\2\2\2\u0355"+
		"\u0356\br\21\2\u0356\u00eb\3\2\2\2\u0357\u0358\5\u009eL\2\u0358\u0359"+
		"\3\2\2\2\u0359\u035a\bs\21\2\u035a\u00ed\3\2\2\2\u035b\u035c\5\u009cK"+
		"\2\u035c\u035d\3\2\2\2\u035d\u035e\bt\21\2\u035e\u00ef\3\2\2\2\u035f\u0360"+
		"\5\u00c2^\2\u0360\u0361\bu\23\2\u0361\u00f1\3\2\2\2\u0362\u0363\7\2\2"+
		"\3\u0363\u0364\3\2\2\2\u0364\u0365\bv\24\2\u0365\u00f3\3\2\2\2\u0366\u0367"+
		"\13\2\2\2\u0367\u00f5\3\2\2\2\u0368\u0369\5\u00bc[\2\u0369\u036a\3\2\2"+
		"\2\u036a\u036b\bx\25\2\u036b\u036c\bx\3\2\u036c\u00f7\3\2\2\2\u036d\u036e"+
		"\5\u00be\\\2\u036e\u036f\by\26\2\u036f\u00f9\3\2\2\2\u0370\u0371\7\2\2"+
		"\3\u0371\u0372\3\2\2\2\u0372\u0373\bz\24\2\u0373\u00fb\3\2\2\2\u0374\u0376"+
		"\n\r\2\2\u0375\u0374\3\2\2\2\u0376\u0377\3\2\2\2\u0377\u0375\3\2\2\2\u0377"+
		"\u0378\3\2\2\2\u0378\u00fd\3\2\2\2\u0379\u037a\5\u0088A\2\u037a\u037b"+
		"\3\2\2\2\u037b\u037c\b|\27\2\u037c\u00ff\3\2\2\2\u037d\u037e\5\u0086@"+
		"\2\u037e\u037f\3\2\2\2\u037f\u0380\b}\30\2\u0380\u0101\3\2\2\2\u0381\u0382"+
		"\5\u008aB\2\u0382\u0383\3\2\2\2\u0383\u0384\b~\31\2\u0384\u0103\3\2\2"+
		"\2\u0385\u0386\5\u00bc[\2\u0386\u0387\3\2\2\2\u0387\u0388\b\177\32\2\u0388"+
		"\u0105\3\2\2\2\u0389\u038a\5\u00be\\\2\u038a\u038b\3\2\2\2\u038b\u038c"+
		"\b\u0080\33\2\u038c\u038d\b\u0080\24\2\u038d\u0107\3\2\2\2\u038e\u038f"+
		"\7u\2\2\u038f\u0390\7w\2\2\u0390\u0391\7r\2\2\u0391\u0392\7g\2\2\u0392"+
		"\u0393\7t\2\2\u0393\u0394\7E\2\2\u0394\u0395\7n\2\2\u0395\u0396\7c\2\2"+
		"\u0396\u0397\7u\2\2\u0397\u0398\7u\2\2\u0398\u0109\3\2\2\2\u0399\u039a"+
		"\7n\2\2\u039a\u039b\7c\2\2\u039b\u039c\7p\2\2\u039c\u039d\7i\2\2\u039d"+
		"\u039e\7w\2\2\u039e\u039f\7c\2\2\u039f\u03a0\7i\2\2\u03a0\u03a1\7g\2\2"+
		"\u03a1\u010b\3\2\2\2\u03a2\u03a3\7v\2\2\u03a3\u03a4\7q\2\2\u03a4\u03a5"+
		"\7m\2\2\u03a5\u03a6\7g\2\2\u03a6\u03a7\7p\2\2\u03a7\u03a8\7X\2\2\u03a8"+
		"\u03a9\7q\2\2\u03a9\u03aa\7e\2\2\u03aa\u03ab\7c\2\2\u03ab\u03ac\7d\2\2"+
		"\u03ac\u010d\3\2\2\2\u03ad\u03ae\7V\2\2\u03ae\u03af\7q\2\2\u03af\u03b0"+
		"\7m\2\2\u03b0\u03b1\7g\2\2\u03b1\u03b2\7p\2\2\u03b2\u03b3\7N\2\2\u03b3"+
		"\u03b4\7c\2\2\u03b4\u03b5\7d\2\2\u03b5\u03b6\7g\2\2\u03b6\u03b7\7n\2\2"+
		"\u03b7\u03b8\7V\2\2\u03b8\u03b9\7{\2\2\u03b9\u03ba\7r\2\2\u03ba\u03bb"+
		"\7g\2\2\u03bb\u010f\3\2\2\2\u03bc\u03c0\5\u00aaR\2\u03bd\u03bf\5\u00a8"+
		"Q\2\u03be\u03bd\3\2\2\2\u03bf\u03c2\3\2\2\2\u03c0\u03be\3\2\2\2\u03c0"+
		"\u03c1\3\2\2\2\u03c1\u03c3\3\2\2\2\u03c2\u03c0\3\2\2\2\u03c3\u03c4\b\u0085"+
		"\34\2\u03c4\u0111\3\2\2\2\u03c5\u03c6\5\u00del\2\u03c6\u03c7\3\2\2\2\u03c7"+
		"\u03c8\b\u0086\35\2\u03c8\u0113\3\2\2\2\u03c9\u03ca\5\u00cab\2\u03ca\u03cb"+
		"\3\2\2\2\u03cb\u03cc\b\u0087\36\2\u03cc\u0115\3\2\2\2\u03cd\u03ce\5\u009c"+
		"K\2\u03ce\u03cf\3\2\2\2\u03cf\u03d0\b\u0088\37\2\u03d0\u0117\3\2\2\2\u03d1"+
		"\u03d2\5\u00acS\2\u03d2\u03d3\3\2\2\2\u03d3\u03d4\b\u0089 \2\u03d4\u0119"+
		"\3\2\2\2\u03d5\u03d6\5\u00ced\2\u03d6\u03d7\3\2\2\2\u03d7\u03d8\b\u008a"+
		"!\2\u03d8\u011b\3\2\2\2\u03d9\u03da\5\u00dck\2\u03da\u03db\3\2\2\2\u03db"+
		"\u03dc\b\u008b\"\2\u03dc\u011d\3\2\2\2\u03dd\u03df\5\u0080=\2\u03de\u03dd"+
		"\3\2\2\2\u03df\u03e0\3\2\2\2\u03e0\u03de\3\2\2\2\u03e0\u03e1\3\2\2\2\u03e1"+
		"\u03e2\3\2\2\2\u03e2\u03e3\b\u008c#\2\u03e3\u011f\3\2\2\2\u03e4\u03e5"+
		"\5\u0088A\2\u03e5\u03e6\3\2\2\2\u03e6\u03e7\b\u008d\27\2\u03e7\u0121\3"+
		"\2\2\2\u03e8\u03e9\5\u0086@\2\u03e9\u03ea\3\2\2\2\u03ea\u03eb\b\u008e"+
		"\30\2\u03eb\u0123\3\2\2\2\u03ec\u03ed\5\u008aB\2\u03ed\u03ee\3\2\2\2\u03ee"+
		"\u03ef\b\u008f\31\2\u03ef\u0125\3\2\2\2\u03f0\u03f1\5\u00bc[\2\u03f1\u03f2"+
		"\3\2\2\2\u03f2\u03f3\b\u0090\32\2\u03f3\u0127\3\2\2\2\u03f4\u03f5\5\u00be"+
		"\\\2\u03f5\u03f6\3\2\2\2\u03f6\u03f7\b\u0091\33\2\u03f7\u03f8\b\u0091"+
		"\24\2\u03f8\u0129\3\2\2\2\u03f9\u03fd\5\u00aaR\2\u03fa\u03fc\5\u00a8Q"+
		"\2\u03fb\u03fa\3\2\2\2\u03fc\u03ff\3\2\2\2\u03fd\u03fb\3\2\2\2\u03fd\u03fe"+
		"\3\2\2\2\u03fe\u0400\3\2\2\2\u03ff\u03fd\3\2\2\2\u0400\u0401\b\u0092$"+
		"\2\u0401\u012b\3\2\2\2\u0402\u0403\5\u00del\2\u0403\u0404\3\2\2\2\u0404"+
		"\u0405\b\u0093\35\2\u0405\u012d\3\2\2\2\u0406\u0407\5\u00daj\2\u0407\u0408"+
		"\3\2\2\2\u0408\u0409\b\u0094%\2\u0409\u012f\3\2\2\2\u040a\u040c\5\u0080"+
		"=\2\u040b\u040a\3\2\2\2\u040c\u040d\3\2\2\2\u040d\u040b\3\2\2\2\u040d"+
		"\u040e\3\2\2\2\u040e\u040f\3\2\2\2\u040f\u0410\b\u0095&\2\u0410\u0131"+
		"\3\2\2\2\u0411\u0412\5\u0088A\2\u0412\u0413\3\2\2\2\u0413\u0414\b\u0096"+
		"\27\2\u0414\u0133\3\2\2\2\u0415\u0416\5\u0086@\2\u0416\u0417\3\2\2\2\u0417"+
		"\u0418\b\u0097\30\2\u0418\u0135\3\2\2\2\u0419\u041a\5\u008aB\2\u041a\u041b"+
		"\3\2\2\2\u041b\u041c\b\u0098\31\2\u041c\u0137\3\2\2\2\u041d\u041e\5\u00bc"+
		"[\2\u041e\u041f\3\2\2\2\u041f\u0420\b\u0099\32\2\u0420\u0139\3\2\2\2\u0421"+
		"\u0422\5\u00be\\\2\u0422\u0423\3\2\2\2\u0423\u0424\b\u009a\33\2\u0424"+
		"\u0425\b\u009a\24\2\u0425\u013b\3\2\2\2\u0426\u042a\5\u00aaR\2\u0427\u0429"+
		"\5\u00a8Q\2\u0428\u0427\3\2\2\2\u0429\u042c\3\2\2\2\u042a\u0428\3\2\2"+
		"\2\u042a\u042b\3\2\2\2\u042b\u042d\3\2\2\2\u042c\u042a\3\2\2\2\u042d\u042e"+
		"\b\u009b\34\2\u042e\u013d\3\2\2\2\u042f\u0430\5\u00del\2\u0430\u0431\3"+
		"\2\2\2\u0431\u0432\b\u009c\35\2\u0432\u013f\3\2\2\2\u0433\u0434\5\u00da"+
		"j\2\u0434\u0435\3\2\2\2\u0435\u0436\b\u009d%\2\u0436\u0141\3\2\2\2\u0437"+
		"\u0439\5\u0080=\2\u0438\u0437\3\2\2\2\u0439\u043a\3\2\2\2\u043a\u0438"+
		"\3\2\2\2\u043a\u043b\3\2\2\2\u043b\u043c\3\2\2\2\u043c\u043d\b\u009e\'"+
		"\2\u043d\u0143\3\2\2\2\u043e\u043f\5\u008aB\2\u043f\u0440\3\2\2\2\u0440"+
		"\u0441\b\u009f\31\2\u0441\u0145\3\2\2\2\u0442\u0443\7u\2\2\u0443\u0444"+
		"\7m\2\2\u0444\u0445\7k\2\2\u0445\u0446\7r\2\2\u0446\u0147\3\2\2\2\u0447"+
		"\u0448\7o\2\2\u0448\u0449\7q\2\2\u0449\u044a\7t\2\2\u044a\u044b\7g\2\2"+
		"\u044b\u0149\3\2\2\2\u044c\u044d\7v\2\2\u044d\u044e\7{\2\2\u044e\u044f"+
		"\7r\2\2\u044f\u0450\7g\2\2\u0450\u014b\3\2\2\2\u0451\u0452\7e\2\2\u0452"+
		"\u0453\7j\2\2\u0453\u0454\7c\2\2\u0454\u0455\7p\2\2\u0455\u0456\7p\2\2"+
		"\u0456\u0457\7g\2\2\u0457\u0458\7n\2\2\u0458\u014d\3\2\2\2\u0459\u045a"+
		"\7o\2\2\u045a\u045b\7q\2\2\u045b\u045c\7f\2\2\u045c\u045d\7g\2\2\u045d"+
		"\u014f\3\2\2\2\u045e\u045f\7r\2\2\u045f\u0460\7w\2\2\u0460\u0461\7u\2"+
		"\2\u0461\u0462\7j\2\2\u0462\u0463\7O\2\2\u0463\u0464\7q\2\2\u0464\u0465"+
		"\7f\2\2\u0465\u0466\7g\2\2\u0466\u0151\3\2\2\2\u0467\u0468\7r\2\2\u0468"+
		"\u0469\7q\2\2\u0469\u046a\7r\2\2\u046a\u046b\7O\2\2\u046b\u046c\7q\2\2"+
		"\u046c\u046d\7f\2\2\u046d\u046e\7g\2\2\u046e\u0153\3\2\2\2\u046f\u0470"+
		"\5\u00b8Y\2\u0470\u0471\3\2\2\2\u0471\u0472\b\u00a7(\2\u0472\u0155\3\2"+
		"\2\2\u0473\u0477\5\u00aaR\2\u0474\u0476\5\u00a8Q\2\u0475\u0474\3\2\2\2"+
		"\u0476\u0479\3\2\2\2\u0477\u0475\3\2\2\2\u0477\u0478\3\2\2\2\u0478\u047a"+
		"\3\2\2\2\u0479\u0477\3\2\2\2\u047a\u047b\b\u00a8\34\2\u047b\u0157\3\2"+
		"\2\2\u047c\u047d\5\u0092F\2\u047d\u047e\3\2\2\2\u047e\u047f\b\u00a9 \2"+
		"\u047f\u0159\3\2\2\2\u0480\u0481\5\u00baZ\2\u0481\u0482\3\2\2\2\u0482"+
		"\u0483\b\u00aa)\2\u0483\u015b\3\2\2\2\u0484\u0485\5\u00daj\2\u0485\u0486"+
		"\3\2\2\2\u0486\u0487\b\u00ab%\2\u0487\u015d\3\2\2\2\u0488\u048a\5\u0080"+
		"=\2\u0489\u0488\3\2\2\2\u048a\u048b\3\2\2\2\u048b\u0489\3\2\2\2\u048b"+
		"\u048c\3\2\2\2\u048c\u048d\3\2\2\2\u048d\u048e\b\u00ac*\2\u048e\u015f"+
		"\3\2\2\2\u048f\u0490\5\u00dck\2\u0490\u0491\3\2\2\2\u0491\u0492\b\u00ad"+
		"\24\2\u0492\u0493\b\u00ad\"\2\u0493\u0161\3\2\2\2\u0494\u0497\n\16\2\2"+
		"\u0495\u0497\5\u008eD\2\u0496\u0494\3\2\2\2\u0496\u0495\3\2\2\2\u0497"+
		"\u0498\3\2\2\2\u0498\u0496\3\2\2\2\u0498\u0499\3\2\2\2\u0499\u049a\3\2"+
		"\2\2\u049a\u049b\b\u00ae\25\2\u049b\u0163\3\2\2\2\u049c\u049d\5\u00c2"+
		"^\2\u049d\u049e\3\2\2\2\u049e\u049f\b\u00af\24\2\u049f\u0165\3\2\2\2\u04a0"+
		"\u04a1\7\2\2\3\u04a1\u04a2\3\2\2\2\u04a2\u04a3\b\u00b0\24\2\u04a3\u0167"+
		"\3\2\2\2-\2\3\4\5\6\7\b\t\u026e\u0276\u0280\u028c\u0299\u02a5\u02ac\u02b6"+
		"\u02b8\u02ba\u02bc\u02c3\u02c6\u02d5\u02da\u02e1\u02e3\u02eb\u02ed\u02f5"+
		"\u02f7\u0300\u0306\u030a\u0377\u03c0\u03e0\u03fd\u040d\u042a\u043a\u0477"+
		"\u048b\u0496\u0498+\3\b\2\7\4\2\7\5\2\7\6\2\7\7\2\3\r\3\3\16\4\3\21\5"+
		"\3\34\6\3\35\7\3 \b\7\b\2\3:\t\3;\n\b\2\2\tC\2\7\3\2\3u\13\6\2\2\5\2\2"+
		"\3y\f\t\6\2\t\7\2\t\b\2\t\'\2\t(\2\t>\2\t8\2\t\60\2\t\n\2\t\t\2\t\62\2"+
		"\t$\2\3\u008c\r\3\u0092\16\t#\2\3\u0095\17\3\u009e\20\t%\2\t&\2\3\u00ac"+
		"\21";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}