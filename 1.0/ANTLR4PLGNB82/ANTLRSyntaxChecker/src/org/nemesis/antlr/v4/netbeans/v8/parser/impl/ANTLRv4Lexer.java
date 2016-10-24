// Generated from ANTLRv4Lexer.g4 by ANTLR 4.5.3
package org.nemesis.antlr.v4.netbeans.v8.parser.impl;
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
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ID_STARTING_WITH_UPPERCASE=1, ID_STARTING_WITH_LOWERCASE=2, LEXER_CHAR_SET=3, 
		DOC_COMMENT=4, BLOCK_COMMENT=5, LINE_COMMENT=6, INT=7, STRING_LITERAL=8, 
		UNTERMINATED_STRING_LITERAL=9, BEGIN_ARGUMENT=10, BEGIN_ACTION=11, OPTIONS=12, 
		TOKENS=13, CHANNELS=14, IMPORT=15, FRAGMENT=16, LEXER=17, PARSER=18, GRAMMAR=19, 
		PROTECTED=20, PUBLIC=21, PRIVATE=22, RETURNS=23, LOCALS=24, THROWS=25, 
		CATCH=26, FINALLY=27, MODE=28, COLON=29, COLONCOLON=30, COMMA=31, SEMI=32, 
		LPAREN=33, RPAREN=34, LBRACE=35, RBRACE=36, RARROW=37, LT=38, ASSOC=39, 
		RIGHT=40, LEFT=41, FAIL=42, GT=43, ASSIGN=44, QUESTION=45, STAR=46, PLUS_ASSIGN=47, 
		PLUS=48, OR=49, DOLLAR=50, RANGE=51, DOT=52, AT=53, HEADER=54, MEMBERS=55, 
		SHARP=56, NOT=57, ID=58, WS=59, ERRCHAR=60, END_ARGUMENT=61, UNTERMINATED_ARGUMENT=62, 
		ARGUMENT_CONTENT=63, END_ACTION=64, UNTERMINATED_ACTION=65, ACTION_CONTENT=66, 
		SUPER_CLASS=67, LANGUAGE=68, TOKEN_VOCAB=69, TOKEN_LABEL_TYPE=70, TOK_ID=71, 
		SKIP_COMMAND=72, MORE_COMMAND=73, TYPE_COMMAND=74, CHANNEL_COMMAND=75, 
		MODE_COMMAND=76, PUSHMODE_COMMAND=77, POPMODE_COMMAND=78, UNTERMINATED_CHAR_SET=79;
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
		"PROTECTED", "PUBLIC", "PRIVATE", "RETURNS", "LOCALS", "THROWS", "CATCH", 
		"FINALLY", "MODE", "COLON", "COLONCOLON", "COMMA", "SEMI", "LPAREN", "RPAREN", 
		"LBRACE", "RBRACE", "RARROW", "LT", "ASSOC", "RIGHT", "LEFT", "FAIL", 
		"GT", "ASSIGN", "QUESTION", "STAR", "PLUS_ASSIGN", "PLUS", "OR", "DOLLAR", 
		"RANGE", "DOT", "AT", "HEADER", "MEMBERS", "SHARP", "NOT", "ID", "WS", 
		"ERRCHAR", "Ws", "Hws", "Vws", "BlockComment", "DocComment", "LineComment", 
		"EscSeq", "EscAny", "UnicodeEsc", "DecimalNumeral", "HexDigit", "DecDigit", 
		"BoolLiteral", "CharLiteral", "SQuoteLiteral", "DQuoteLiteral", "USQuoteLiteral", 
		"UpperCaseLatinChar", "LowerCaseLatinChar", "LatinChar", "NameChar", "NameStartChar", 
		"Int", "Esc", "Colon", "DColon", "SQuote", "DQuote", "LParen", "RParen", 
		"LBrace", "RBrace", "LBrack", "RBrack", "RArrow", "Lt", "Gt", "Equal", 
		"Question", "Star", "Plus", "PlusAssign", "Underscore", "Pipe", "Dollar", 
		"Comma", "Semi", "Dot", "Range", "At", "Sharp", "Tilde", "NESTED_ARGUMENT", 
		"ARGUMENT_ESCAPE", "ARGUMENT_STRING_LITERAL", "ARGUMENT_CHAR_LITERAL", 
		"END_ARGUMENT", "UNTERMINATED_ARGUMENT", "ARGUMENT_CONTENT", "NESTED_ACTION", 
		"ACTION_ESCAPE", "ACTION_STRING_LITERAL", "ACTION_CHAR_LITERAL", "ACTION_DOC_COMMENT", 
		"ACTION_BLOCK_COMMENT", "ACTION_LINE_COMMENT", "END_ACTION", "UNTERMINATED_ACTION", 
		"ACTION_CONTENT", "OPT_DOC_COMMENT", "OPT_BLOCK_COMMENT", "OPT_LINE_COMMENT", 
		"OPT_LBRACE", "OPT_RBRACE", "SUPER_CLASS", "LANGUAGE", "TOKEN_VOCAB", 
		"TOKEN_LABEL_TYPE", "OPT_ID", "OPT_DOT", "OPT_ASSIGN", "OPT_STRING_LITERAL", 
		"OPT_INT", "OPT_STAR", "OPT_SEMI", "OPT_WS", "OPT_ERR", "TOK_DOC_COMMENT", 
		"TOK_BLOCK_COMMENT", "TOK_LINE_COMMENT", "TOK_LBRACE", "TOK_RBRACE", "TOK_ID", 
		"TOK_DOT", "TOK_COMMA", "TOK_WS", "CHN_DOC_COMMENT", "CHN_BLOCK_COMMENT", 
		"CHN_LINE_COMMENT", "CHN_LBRACE", "CHN_RBRACE", "CHN_ID", "CHN_DOT", "CHN_COMMA", 
		"CHN_WS", "LEXER_COMMAND_LINE_COMMENT", "SKIP_COMMAND", "MORE_COMMAND", 
		"TYPE_COMMAND", "CHANNEL_COMMAND", "MODE_COMMAND", "PUSHMODE_COMMAND", 
		"POPMODE_COMMAND", "LEXER_COMMAND_LPAREN", "LEXER_COMMAND_ID", "LEXER_COMMAND_INT", 
		"LEXER_COMMAND_RPAREN", "LEXER_COMMAND_COMMA", "LEXER_COMMAND_WS", "LEXER_COMMAND_SEMI", 
		"LEXER_CHAR_SET_BODY", "LEXER_CHAR_SET", "UNTERMINATED_CHAR_SET"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"'options'", "'tokens'", "'channels'", "'import'", "'fragment'", "'lexer'", 
		"'parser'", "'grammar'", "'protected'", "'public'", "'private'", "'returns'", 
		"'locals'", "'throws'", "'catch'", "'finally'", null, null, null, null, 
		null, null, null, null, null, null, null, "'assoc'", "'right'", "'left'", 
		"'fail'", null, null, null, null, null, null, null, null, null, null, 
		null, "'header'", "'members'", null, null, null, null, null, null, null, 
		null, null, null, null, "'superClass'", "'language'", "'tokenVocab'", 
		"'TokenLabelType'", null, "'skip'", "'more'", "'type'", "'channel'", null, 
		"'pushMode'", "'popMode'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ID_STARTING_WITH_UPPERCASE", "ID_STARTING_WITH_LOWERCASE", "LEXER_CHAR_SET", 
		"DOC_COMMENT", "BLOCK_COMMENT", "LINE_COMMENT", "INT", "STRING_LITERAL", 
		"UNTERMINATED_STRING_LITERAL", "BEGIN_ARGUMENT", "BEGIN_ACTION", "OPTIONS", 
		"TOKENS", "CHANNELS", "IMPORT", "FRAGMENT", "LEXER", "PARSER", "GRAMMAR", 
		"PROTECTED", "PUBLIC", "PRIVATE", "RETURNS", "LOCALS", "THROWS", "CATCH", 
		"FINALLY", "MODE", "COLON", "COLONCOLON", "COMMA", "SEMI", "LPAREN", "RPAREN", 
		"LBRACE", "RBRACE", "RARROW", "LT", "ASSOC", "RIGHT", "LEFT", "FAIL", 
		"GT", "ASSIGN", "QUESTION", "STAR", "PLUS_ASSIGN", "PLUS", "OR", "DOLLAR", 
		"RANGE", "DOT", "AT", "HEADER", "MEMBERS", "SHARP", "NOT", "ID", "WS", 
		"ERRCHAR", "END_ARGUMENT", "UNTERMINATED_ARGUMENT", "ARGUMENT_CONTENT", 
		"END_ACTION", "UNTERMINATED_ACTION", "ACTION_CONTENT", "SUPER_CLASS", 
		"LANGUAGE", "TOKEN_VOCAB", "TOKEN_LABEL_TYPE", "TOK_ID", "SKIP_COMMAND", 
		"MORE_COMMAND", "TYPE_COMMAND", "CHANNEL_COMMAND", "MODE_COMMAND", "PUSHMODE_COMMAND", 
		"POPMODE_COMMAND", "UNTERMINATED_CHAR_SET"
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
	//    System.out.println("emit() : type=" + _type);
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
		case 24:
			MODE_action((RuleContext)_localctx, actionIndex);
			break;
		case 25:
			COLON_action((RuleContext)_localctx, actionIndex);
			break;
		case 28:
			SEMI_action((RuleContext)_localctx, actionIndex);
			break;
		case 54:
			ID_action((RuleContext)_localctx, actionIndex);
			break;
		case 113:
			END_ARGUMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 123:
			END_ACTION_action((RuleContext)_localctx, actionIndex);
			break;
		case 149:
			TOK_ID_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void BEGIN_ARGUMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:

			  // If we are in a lexer rule, then the brackets can only represent a lexer 
			  // char set definition so we pass in lexer char set mode
			     if (inLexerRule()) {
			 //        System.out.println("It is a lexer char set definition");
			         pushMode(ANTLRv4Lexer.LexerCharSet);
			         more();
			  // else we are in a parser rule and the brackets represent argument(s)
			     } else {
			 //        System.out.println("It is an argument definition");
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
			    
			break;
		}
	}
	private void END_ARGUMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 8:

			     popMode();
			     if (_modeStack.size() > 0) {
			         setType(ANTLRv4Lexer.ARGUMENT_CONTENT);
			     }
			    
			break;
		}
	}
	private void END_ACTION_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 9:

			     popMode();
			     if (_modeStack.size() > 0) {
			        setType(ANTLRv4Lexer.ACTION_CONTENT);
			     }
			    
			break;
		}
	}
	private void TOK_ID_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 10:

			     String idValue = getText();
			     if ( Character.isUpperCase(idValue.charAt(0)) )
			         setType(ID_STARTING_WITH_UPPERCASE);
			     else
			         setType(ID_STARTING_WITH_LOWERCASE);
			//     System.out.println("TOK_ID: returned token type=" + _SYMBOLIC_NAMES[_type]);
			    
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2Q\u04cd\b\1\b\1\b"+
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
		"\t\u00b0\4\u00b1\t\u00b1\4\u00b2\t\u00b2\4\u00b3\t\u00b3\4\u00b4\t\u00b4"+
		"\4\u00b5\t\u00b5\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3"+
		"\6\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\37"+
		"\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3#\3#\3$\3$\3%\3%\3%\3%\3%\3%\3&\3&\3"+
		"&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,"+
		"\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3"+
		"\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\66\3"+
		"\66\3\67\3\67\38\38\78\u0270\n8\f8\168\u0273\138\38\38\39\69\u0278\n9"+
		"\r9\169\u0279\39\39\3:\3:\3;\3;\5;\u0282\n;\3<\3<\3=\3=\3>\3>\3>\3>\7"+
		">\u028c\n>\f>\16>\u028f\13>\3>\3>\3>\5>\u0294\n>\3?\3?\3?\3?\3?\7?\u029b"+
		"\n?\f?\16?\u029e\13?\3?\3?\3?\5?\u02a3\n?\3@\3@\3@\3@\7@\u02a9\n@\f@\16"+
		"@\u02ac\13@\3A\3A\3A\3A\5A\u02b2\nA\3B\3B\3B\3C\3C\3C\3C\3C\5C\u02bc\n"+
		"C\5C\u02be\nC\5C\u02c0\nC\5C\u02c2\nC\3D\3D\3D\7D\u02c7\nD\fD\16D\u02ca"+
		"\13D\5D\u02cc\nD\3E\3E\3F\3F\3G\3G\3G\3G\3G\3G\3G\3G\3G\5G\u02db\nG\3"+
		"H\3H\3H\5H\u02e0\nH\3H\3H\3I\3I\3I\7I\u02e7\nI\fI\16I\u02ea\13I\3I\3I"+
		"\3J\3J\3J\7J\u02f1\nJ\fJ\16J\u02f4\13J\3J\3J\3K\3K\3K\7K\u02fb\nK\fK\16"+
		"K\u02fe\13K\3L\3L\3M\3M\3N\3N\5N\u0306\nN\3O\3O\3O\3O\5O\u030c\nO\3P\3"+
		"P\5P\u0310\nP\3Q\3Q\3Q\3Q\3R\3R\3S\3S\3T\3T\3T\3U\3U\3V\3V\3W\3W\3X\3"+
		"X\3Y\3Y\3Z\3Z\3[\3[\3\\\3\\\3]\3]\3]\3^\3^\3_\3_\3`\3`\3a\3a\3b\3b\3c"+
		"\3c\3d\3d\3d\3e\3e\3f\3f\3g\3g\3h\3h\3i\3i\3j\3j\3k\3k\3k\3l\3l\3m\3m"+
		"\3n\3n\3o\3o\3o\3o\3o\3p\3p\3p\3p\3q\3q\3q\3q\3r\3r\3r\3r\3s\3s\3s\3t"+
		"\3t\3t\3t\3u\3u\3v\3v\3v\3v\3v\3w\3w\3w\3w\3x\3x\3x\3x\3y\3y\3y\3y\3z"+
		"\3z\3z\3z\3{\3{\3{\3{\3|\3|\3|\3|\3}\3}\3}\3~\3~\3~\3~\3\177\3\177\3\u0080"+
		"\3\u0080\3\u0080\3\u0080\3\u0081\3\u0081\3\u0081\3\u0081\3\u0081\3\u0082"+
		"\3\u0082\3\u0082\3\u0082\3\u0082\3\u0083\3\u0083\3\u0083\3\u0083\3\u0084"+
		"\3\u0084\3\u0084\3\u0084\3\u0084\3\u0085\3\u0085\3\u0085\3\u0085\3\u0085"+
		"\3\u0085\3\u0085\3\u0085\3\u0085\3\u0085\3\u0085\3\u0086\3\u0086\3\u0086"+
		"\3\u0086\3\u0086\3\u0086\3\u0086\3\u0086\3\u0086\3\u0087\3\u0087\3\u0087"+
		"\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087\3\u0088"+
		"\3\u0088\3\u0088\3\u0088\3\u0088\3\u0088\3\u0088\3\u0088\3\u0088\3\u0088"+
		"\3\u0088\3\u0088\3\u0088\3\u0088\3\u0088\3\u0089\3\u0089\7\u0089\u03db"+
		"\n\u0089\f\u0089\16\u0089\u03de\13\u0089\3\u0089\3\u0089\3\u008a\3\u008a"+
		"\3\u008a\3\u008a\3\u008b\3\u008b\3\u008b\3\u008b\3\u008c\3\u008c\3\u008c"+
		"\3\u008c\3\u008d\3\u008d\3\u008d\3\u008d\3\u008e\3\u008e\3\u008e\3\u008e"+
		"\3\u008f\3\u008f\3\u008f\3\u008f\3\u0090\6\u0090\u03fb\n\u0090\r\u0090"+
		"\16\u0090\u03fc\3\u0090\3\u0090\3\u0090\3\u0091\3\u0091\3\u0091\3\u0091"+
		"\3\u0092\3\u0092\3\u0092\3\u0092\3\u0093\3\u0093\3\u0093\3\u0093\3\u0093"+
		"\3\u0094\3\u0094\3\u0094\3\u0094\3\u0094\3\u0095\3\u0095\3\u0095\3\u0095"+
		"\3\u0096\3\u0096\3\u0096\3\u0096\3\u0096\3\u0097\3\u0097\7\u0097\u041f"+
		"\n\u0097\f\u0097\16\u0097\u0422\13\u0097\3\u0097\3\u0097\3\u0098\3\u0098"+
		"\3\u0098\3\u0098\3\u0099\3\u0099\3\u0099\3\u0099\3\u009a\6\u009a\u042f"+
		"\n\u009a\r\u009a\16\u009a\u0430\3\u009a\3\u009a\3\u009a\3\u009b\3\u009b"+
		"\3\u009b\3\u009b\3\u009c\3\u009c\3\u009c\3\u009c\3\u009c\3\u009d\3\u009d"+
		"\3\u009d\3\u009d\3\u009d\3\u009e\3\u009e\3\u009e\3\u009e\3\u009f\3\u009f"+
		"\3\u009f\3\u009f\3\u009f\3\u00a0\3\u00a0\7\u00a0\u044f\n\u00a0\f\u00a0"+
		"\16\u00a0\u0452\13\u00a0\3\u00a0\3\u00a0\3\u00a1\3\u00a1\3\u00a1\3\u00a1"+
		"\3\u00a2\3\u00a2\3\u00a2\3\u00a2\3\u00a3\6\u00a3\u045f\n\u00a3\r\u00a3"+
		"\16\u00a3\u0460\3\u00a3\3\u00a3\3\u00a3\3\u00a4\3\u00a4\3\u00a4\3\u00a4"+
		"\3\u00a4\3\u00a5\3\u00a5\3\u00a5\3\u00a5\3\u00a5\3\u00a6\3\u00a6\3\u00a6"+
		"\3\u00a6\3\u00a6\3\u00a7\3\u00a7\3\u00a7\3\u00a7\3\u00a7\3\u00a8\3\u00a8"+
		"\3\u00a8\3\u00a8\3\u00a8\3\u00a8\3\u00a8\3\u00a8\3\u00a9\3\u00a9\3\u00a9"+
		"\3\u00a9\3\u00a9\3\u00aa\3\u00aa\3\u00aa\3\u00aa\3\u00aa\3\u00aa\3\u00aa"+
		"\3\u00aa\3\u00aa\3\u00ab\3\u00ab\3\u00ab\3\u00ab\3\u00ab\3\u00ab\3\u00ab"+
		"\3\u00ab\3\u00ac\3\u00ac\3\u00ac\3\u00ac\3\u00ad\3\u00ad\7\u00ad\u049e"+
		"\n\u00ad\f\u00ad\16\u00ad\u04a1\13\u00ad\3\u00ad\3\u00ad\3\u00ae\3\u00ae"+
		"\3\u00ae\3\u00ae\3\u00af\3\u00af\3\u00af\3\u00af\3\u00b0\3\u00b0\3\u00b0"+
		"\3\u00b0\3\u00b1\6\u00b1\u04b2\n\u00b1\r\u00b1\16\u00b1\u04b3\3\u00b1"+
		"\3\u00b1\3\u00b1\3\u00b2\3\u00b2\3\u00b2\3\u00b2\3\u00b2\3\u00b3\3\u00b3"+
		"\6\u00b3\u04c0\n\u00b3\r\u00b3\16\u00b3\u04c1\3\u00b3\3\u00b3\3\u00b4"+
		"\3\u00b4\3\u00b4\3\u00b4\3\u00b5\3\u00b5\3\u00b5\3\u00b5\4\u028d\u029c"+
		"\2\u00b6\n\6\f\7\16\b\20\t\22\n\24\13\26\f\30\r\32\16\34\17\36\20 \21"+
		"\"\22$\23&\24(\25*\26,\27.\30\60\31\62\32\64\33\66\348\35:\36<\37> @!"+
		"B\"D#F$H%J&L\'N(P)R*T+V,X-Z.\\/^\60`\61b\62d\63f\64h\65j\66l\67n8p9r:"+
		"t;v<x=z>|\2~\2\u0080\2\u0082\2\u0084\2\u0086\2\u0088\2\u008a\2\u008c\2"+
		"\u008e\2\u0090\2\u0092\2\u0094\2\u0096\2\u0098\2\u009a\2\u009c\2\u009e"+
		"\2\u00a0\2\u00a2\2\u00a4\2\u00a6\2\u00a8\2\u00aa\2\u00ac\2\u00ae\2\u00b0"+
		"\2\u00b2\2\u00b4\2\u00b6\2\u00b8\2\u00ba\2\u00bc\2\u00be\2\u00c0\2\u00c2"+
		"\2\u00c4\2\u00c6\2\u00c8\2\u00ca\2\u00cc\2\u00ce\2\u00d0\2\u00d2\2\u00d4"+
		"\2\u00d6\2\u00d8\2\u00da\2\u00dc\2\u00de\2\u00e0\2\u00e2\2\u00e4\2\u00e6"+
		"\2\u00e8\2\u00ea\2\u00ec?\u00ee@\u00f0A\u00f2\2\u00f4\2\u00f6\2\u00f8"+
		"\2\u00fa\2\u00fc\2\u00fe\2\u0100B\u0102C\u0104D\u0106\2\u0108\2\u010a"+
		"\2\u010c\2\u010e\2\u0110E\u0112F\u0114G\u0116H\u0118\2\u011a\2\u011c\2"+
		"\u011e\2\u0120\2\u0122\2\u0124\2\u0126\2\u0128\2\u012a\2\u012c\2\u012e"+
		"\2\u0130\2\u0132\2\u0134I\u0136\2\u0138\2\u013a\2\u013c\2\u013e\2\u0140"+
		"\2\u0142\2\u0144\2\u0146\2\u0148\2\u014a\2\u014c\2\u014e\2\u0150J\u0152"+
		"K\u0154L\u0156M\u0158N\u015aO\u015cP\u015e\2\u0160\2\u0162\2\u0164\2\u0166"+
		"\2\u0168\2\u016a\2\u016c\2\u016e\5\u0170Q\n\2\3\4\5\6\7\b\t\16\4\2\13"+
		"\13\"\"\4\2\f\f\16\17\4\2\f\f\17\17\n\2$$))^^ddhhppttvv\3\2\63;\5\2\62"+
		";CHch\3\2\62;\6\2\f\f\17\17))^^\6\2\f\f\17\17$$^^\5\2\u00b9\u00b9\u0302"+
		"\u0371\u2041\u2042\r\2\u00c2\u00d8\u00da\u00f8\u00fa\u0301\u0372\u037f"+
		"\u0381\u2001\u200e\u200f\u2072\u2191\u2c02\u2ff1\u3003\ud801\uf902\ufdd1"+
		"\ufdf2\uffff\3\2^_\u04b8\2\n\3\2\2\2\2\f\3\2\2\2\2\16\3\2\2\2\2\20\3\2"+
		"\2\2\2\22\3\2\2\2\2\24\3\2\2\2\2\26\3\2\2\2\2\30\3\2\2\2\2\32\3\2\2\2"+
		"\2\34\3\2\2\2\2\36\3\2\2\2\2 \3\2\2\2\2\"\3\2\2\2\2$\3\2\2\2\2&\3\2\2"+
		"\2\2(\3\2\2\2\2*\3\2\2\2\2,\3\2\2\2\2.\3\2\2\2\2\60\3\2\2\2\2\62\3\2\2"+
		"\2\2\64\3\2\2\2\2\66\3\2\2\2\28\3\2\2\2\2:\3\2\2\2\2<\3\2\2\2\2>\3\2\2"+
		"\2\2@\3\2\2\2\2B\3\2\2\2\2D\3\2\2\2\2F\3\2\2\2\2H\3\2\2\2\2J\3\2\2\2\2"+
		"L\3\2\2\2\2N\3\2\2\2\2P\3\2\2\2\2R\3\2\2\2\2T\3\2\2\2\2V\3\2\2\2\2X\3"+
		"\2\2\2\2Z\3\2\2\2\2\\\3\2\2\2\2^\3\2\2\2\2`\3\2\2\2\2b\3\2\2\2\2d\3\2"+
		"\2\2\2f\3\2\2\2\2h\3\2\2\2\2j\3\2\2\2\2l\3\2\2\2\2n\3\2\2\2\2p\3\2\2\2"+
		"\2r\3\2\2\2\2t\3\2\2\2\2v\3\2\2\2\2x\3\2\2\2\2z\3\2\2\2\3\u00e4\3\2\2"+
		"\2\3\u00e6\3\2\2\2\3\u00e8\3\2\2\2\3\u00ea\3\2\2\2\3\u00ec\3\2\2\2\3\u00ee"+
		"\3\2\2\2\3\u00f0\3\2\2\2\4\u00f2\3\2\2\2\4\u00f4\3\2\2\2\4\u00f6\3\2\2"+
		"\2\4\u00f8\3\2\2\2\4\u00fa\3\2\2\2\4\u00fc\3\2\2\2\4\u00fe\3\2\2\2\4\u0100"+
		"\3\2\2\2\4\u0102\3\2\2\2\4\u0104\3\2\2\2\5\u0106\3\2\2\2\5\u0108\3\2\2"+
		"\2\5\u010a\3\2\2\2\5\u010c\3\2\2\2\5\u010e\3\2\2\2\5\u0110\3\2\2\2\5\u0112"+
		"\3\2\2\2\5\u0114\3\2\2\2\5\u0116\3\2\2\2\5\u0118\3\2\2\2\5\u011a\3\2\2"+
		"\2\5\u011c\3\2\2\2\5\u011e\3\2\2\2\5\u0120\3\2\2\2\5\u0122\3\2\2\2\5\u0124"+
		"\3\2\2\2\5\u0126\3\2\2\2\5\u0128\3\2\2\2\6\u012a\3\2\2\2\6\u012c\3\2\2"+
		"\2\6\u012e\3\2\2\2\6\u0130\3\2\2\2\6\u0132\3\2\2\2\6\u0134\3\2\2\2\6\u0136"+
		"\3\2\2\2\6\u0138\3\2\2\2\6\u013a\3\2\2\2\7\u013c\3\2\2\2\7\u013e\3\2\2"+
		"\2\7\u0140\3\2\2\2\7\u0142\3\2\2\2\7\u0144\3\2\2\2\7\u0146\3\2\2\2\7\u0148"+
		"\3\2\2\2\7\u014a\3\2\2\2\7\u014c\3\2\2\2\b\u014e\3\2\2\2\b\u0150\3\2\2"+
		"\2\b\u0152\3\2\2\2\b\u0154\3\2\2\2\b\u0156\3\2\2\2\b\u0158\3\2\2\2\b\u015a"+
		"\3\2\2\2\b\u015c\3\2\2\2\b\u015e\3\2\2\2\b\u0160\3\2\2\2\b\u0162\3\2\2"+
		"\2\b\u0164\3\2\2\2\b\u0166\3\2\2\2\b\u0168\3\2\2\2\b\u016a\3\2\2\2\t\u016c"+
		"\3\2\2\2\t\u016e\3\2\2\2\t\u0170\3\2\2\2\n\u0172\3\2\2\2\f\u0174\3\2\2"+
		"\2\16\u0178\3\2\2\2\20\u017c\3\2\2\2\22\u017e\3\2\2\2\24\u0180\3\2\2\2"+
		"\26\u0182\3\2\2\2\30\u0185\3\2\2\2\32\u0189\3\2\2\2\34\u0193\3\2\2\2\36"+
		"\u019c\3\2\2\2 \u01a7\3\2\2\2\"\u01b0\3\2\2\2$\u01bb\3\2\2\2&\u01c1\3"+
		"\2\2\2(\u01c8\3\2\2\2*\u01d2\3\2\2\2,\u01dc\3\2\2\2.\u01e3\3\2\2\2\60"+
		"\u01eb\3\2\2\2\62\u01f3\3\2\2\2\64\u01fa\3\2\2\2\66\u0201\3\2\2\28\u0207"+
		"\3\2\2\2:\u020f\3\2\2\2<\u0216\3\2\2\2>\u0219\3\2\2\2@\u021b\3\2\2\2B"+
		"\u021d\3\2\2\2D\u0220\3\2\2\2F\u0222\3\2\2\2H\u0224\3\2\2\2J\u0226\3\2"+
		"\2\2L\u0228\3\2\2\2N\u022c\3\2\2\2P\u022e\3\2\2\2R\u0234\3\2\2\2T\u023a"+
		"\3\2\2\2V\u023f\3\2\2\2X\u0244\3\2\2\2Z\u0246\3\2\2\2\\\u0248\3\2\2\2"+
		"^\u024a\3\2\2\2`\u024c\3\2\2\2b\u024e\3\2\2\2d\u0250\3\2\2\2f\u0252\3"+
		"\2\2\2h\u0254\3\2\2\2j\u0256\3\2\2\2l\u0258\3\2\2\2n\u025a\3\2\2\2p\u0261"+
		"\3\2\2\2r\u0269\3\2\2\2t\u026b\3\2\2\2v\u026d\3\2\2\2x\u0277\3\2\2\2z"+
		"\u027d\3\2\2\2|\u0281\3\2\2\2~\u0283\3\2\2\2\u0080\u0285\3\2\2\2\u0082"+
		"\u0287\3\2\2\2\u0084\u0295\3\2\2\2\u0086\u02a4\3\2\2\2\u0088\u02ad\3\2"+
		"\2\2\u008a\u02b3\3\2\2\2\u008c\u02b6\3\2\2\2\u008e\u02cb\3\2\2\2\u0090"+
		"\u02cd\3\2\2\2\u0092\u02cf\3\2\2\2\u0094\u02da\3\2\2\2\u0096\u02dc\3\2"+
		"\2\2\u0098\u02e3\3\2\2\2\u009a\u02ed\3\2\2\2\u009c\u02f7\3\2\2\2\u009e"+
		"\u02ff\3\2\2\2\u00a0\u0301\3\2\2\2\u00a2\u0305\3\2\2\2\u00a4\u030b\3\2"+
		"\2\2\u00a6\u030f\3\2\2\2\u00a8\u0311\3\2\2\2\u00aa\u0315\3\2\2\2\u00ac"+
		"\u0317\3\2\2\2\u00ae\u0319\3\2\2\2\u00b0\u031c\3\2\2\2\u00b2\u031e\3\2"+
		"\2\2\u00b4\u0320\3\2\2\2\u00b6\u0322\3\2\2\2\u00b8\u0324\3\2\2\2\u00ba"+
		"\u0326\3\2\2\2\u00bc\u0328\3\2\2\2\u00be\u032a\3\2\2\2\u00c0\u032c\3\2"+
		"\2\2\u00c2\u032f\3\2\2\2\u00c4\u0331\3\2\2\2\u00c6\u0333\3\2\2\2\u00c8"+
		"\u0335\3\2\2\2\u00ca\u0337\3\2\2\2\u00cc\u0339\3\2\2\2\u00ce\u033b\3\2"+
		"\2\2\u00d0\u033e\3\2\2\2\u00d2\u0340\3\2\2\2\u00d4\u0342\3\2\2\2\u00d6"+
		"\u0344\3\2\2\2\u00d8\u0346\3\2\2\2\u00da\u0348\3\2\2\2\u00dc\u034a\3\2"+
		"\2\2\u00de\u034d\3\2\2\2\u00e0\u034f\3\2\2\2\u00e2\u0351\3\2\2\2\u00e4"+
		"\u0353\3\2\2\2\u00e6\u0358\3\2\2\2\u00e8\u035c\3\2\2\2\u00ea\u0360\3\2"+
		"\2\2\u00ec\u0364\3\2\2\2\u00ee\u0367\3\2\2\2\u00f0\u036b\3\2\2\2\u00f2"+
		"\u036d\3\2\2\2\u00f4\u0372\3\2\2\2\u00f6\u0376\3\2\2\2\u00f8\u037a\3\2"+
		"\2\2\u00fa\u037e\3\2\2\2\u00fc\u0382\3\2\2\2\u00fe\u0386\3\2\2\2\u0100"+
		"\u038a\3\2\2\2\u0102\u038d\3\2\2\2\u0104\u0391\3\2\2\2\u0106\u0393\3\2"+
		"\2\2\u0108\u0397\3\2\2\2\u010a\u039c\3\2\2\2\u010c\u03a1\3\2\2\2\u010e"+
		"\u03a5\3\2\2\2\u0110\u03aa\3\2\2\2\u0112\u03b5\3\2\2\2\u0114\u03be\3\2"+
		"\2\2\u0116\u03c9\3\2\2\2\u0118\u03d8\3\2\2\2\u011a\u03e1\3\2\2\2\u011c"+
		"\u03e5\3\2\2\2\u011e\u03e9\3\2\2\2\u0120\u03ed\3\2\2\2\u0122\u03f1\3\2"+
		"\2\2\u0124\u03f5\3\2\2\2\u0126\u03fa\3\2\2\2\u0128\u0401\3\2\2\2\u012a"+
		"\u0405\3\2\2\2\u012c\u0409\3\2\2\2\u012e\u040e\3\2\2\2\u0130\u0413\3\2"+
		"\2\2\u0132\u0417\3\2\2\2\u0134\u041c\3\2\2\2\u0136\u0425\3\2\2\2\u0138"+
		"\u0429\3\2\2\2\u013a\u042e\3\2\2\2\u013c\u0435\3\2\2\2\u013e\u0439\3\2"+
		"\2\2\u0140\u043e\3\2\2\2\u0142\u0443\3\2\2\2\u0144\u0447\3\2\2\2\u0146"+
		"\u044c\3\2\2\2\u0148\u0455\3\2\2\2\u014a\u0459\3\2\2\2\u014c\u045e\3\2"+
		"\2\2\u014e\u0465\3\2\2\2\u0150\u046a\3\2\2\2\u0152\u046f\3\2\2\2\u0154"+
		"\u0474\3\2\2\2\u0156\u0479\3\2\2\2\u0158\u0481\3\2\2\2\u015a\u0486\3\2"+
		"\2\2\u015c\u048f\3\2\2\2\u015e\u0497\3\2\2\2\u0160\u049b\3\2\2\2\u0162"+
		"\u04a4\3\2\2\2\u0164\u04a8\3\2\2\2\u0166\u04ac\3\2\2\2\u0168\u04b1\3\2"+
		"\2\2\u016a\u04b8\3\2\2\2\u016c\u04bf\3\2\2\2\u016e\u04c5\3\2\2\2\u0170"+
		"\u04c9\3\2\2\2\u0172\u0173\5\u0084?\2\u0173\13\3\2\2\2\u0174\u0175\5\u0082"+
		">\2\u0175\u0176\3\2\2\2\u0176\u0177\b\3\2\2\u0177\r\3\2\2\2\u0178\u0179"+
		"\5\u0086@\2\u0179\u017a\3\2\2\2\u017a\u017b\b\4\2\2\u017b\17\3\2\2\2\u017c"+
		"\u017d\5\u008eD\2\u017d\21\3\2\2\2\u017e\u017f\5\u0098I\2\u017f\23\3\2"+
		"\2\2\u0180\u0181\5\u009cK\2\u0181\25\3\2\2\2\u0182\u0183\5\u00bc[\2\u0183"+
		"\u0184\b\b\3\2\u0184\27\3\2\2\2\u0185\u0186\5\u00b8Y\2\u0186\u0187\3\2"+
		"\2\2\u0187\u0188\b\t\4\2\u0188\31\3\2\2\2\u0189\u018a\7q\2\2\u018a\u018b"+
		"\7r\2\2\u018b\u018c\7v\2\2\u018c\u018d\7k\2\2\u018d\u018e\7q\2\2\u018e"+
		"\u018f\7p\2\2\u018f\u0190\7u\2\2\u0190\u0191\3\2\2\2\u0191\u0192\b\n\5"+
		"\2\u0192\33\3\2\2\2\u0193\u0194\7v\2\2\u0194\u0195\7q\2\2\u0195\u0196"+
		"\7m\2\2\u0196\u0197\7g\2\2\u0197\u0198\7p\2\2\u0198\u0199\7u\2\2\u0199"+
		"\u019a\3\2\2\2\u019a\u019b\b\13\6\2\u019b\35\3\2\2\2\u019c\u019d\7e\2"+
		"\2\u019d\u019e\7j\2\2\u019e\u019f\7c\2\2\u019f\u01a0\7p\2\2\u01a0\u01a1"+
		"\7p\2\2\u01a1\u01a2\7g\2\2\u01a2\u01a3\7n\2\2\u01a3\u01a4\7u\2\2\u01a4"+
		"\u01a5\3\2\2\2\u01a5\u01a6\b\f\7\2\u01a6\37\3\2\2\2\u01a7\u01a8\7k\2\2"+
		"\u01a8\u01a9\7o\2\2\u01a9\u01aa\7r\2\2\u01aa\u01ab\7q\2\2\u01ab\u01ac"+
		"\7t\2\2\u01ac\u01ad\7v\2\2\u01ad\u01ae\3\2\2\2\u01ae\u01af\b\r\b\2\u01af"+
		"!\3\2\2\2\u01b0\u01b1\7h\2\2\u01b1\u01b2\7t\2\2\u01b2\u01b3\7c\2\2\u01b3"+
		"\u01b4\7i\2\2\u01b4\u01b5\7o\2\2\u01b5\u01b6\7g\2\2\u01b6\u01b7\7p\2\2"+
		"\u01b7\u01b8\7v\2\2\u01b8\u01b9\3\2\2\2\u01b9\u01ba\b\16\t\2\u01ba#\3"+
		"\2\2\2\u01bb\u01bc\7n\2\2\u01bc\u01bd\7g\2\2\u01bd\u01be\7z\2\2\u01be"+
		"\u01bf\7g\2\2\u01bf\u01c0\7t\2\2\u01c0%\3\2\2\2\u01c1\u01c2\7r\2\2\u01c2"+
		"\u01c3\7c\2\2\u01c3\u01c4\7t\2\2\u01c4\u01c5\7u\2\2\u01c5\u01c6\7g\2\2"+
		"\u01c6\u01c7\7t\2\2\u01c7\'\3\2\2\2\u01c8\u01c9\7i\2\2\u01c9\u01ca\7t"+
		"\2\2\u01ca\u01cb\7c\2\2\u01cb\u01cc\7o\2\2\u01cc\u01cd\7o\2\2\u01cd\u01ce"+
		"\7c\2\2\u01ce\u01cf\7t\2\2\u01cf\u01d0\3\2\2\2\u01d0\u01d1\b\21\n\2\u01d1"+
		")\3\2\2\2\u01d2\u01d3\7r\2\2\u01d3\u01d4\7t\2\2\u01d4\u01d5\7q\2\2\u01d5"+
		"\u01d6\7v\2\2\u01d6\u01d7\7g\2\2\u01d7\u01d8\7e\2\2\u01d8\u01d9\7v\2\2"+
		"\u01d9\u01da\7g\2\2\u01da\u01db\7f\2\2\u01db+\3\2\2\2\u01dc\u01dd\7r\2"+
		"\2\u01dd\u01de\7w\2\2\u01de\u01df\7d\2\2\u01df\u01e0\7n\2\2\u01e0\u01e1"+
		"\7k\2\2\u01e1\u01e2\7e\2\2\u01e2-\3\2\2\2\u01e3\u01e4\7r\2\2\u01e4\u01e5"+
		"\7t\2\2\u01e5\u01e6\7k\2\2\u01e6\u01e7\7x\2\2\u01e7\u01e8\7c\2\2\u01e8"+
		"\u01e9\7v\2\2\u01e9\u01ea\7g\2\2\u01ea/\3\2\2\2\u01eb\u01ec\7t\2\2\u01ec"+
		"\u01ed\7g\2\2\u01ed\u01ee\7v\2\2\u01ee\u01ef\7w\2\2\u01ef\u01f0\7t\2\2"+
		"\u01f0\u01f1\7p\2\2\u01f1\u01f2\7u\2\2\u01f2\61\3\2\2\2\u01f3\u01f4\7"+
		"n\2\2\u01f4\u01f5\7q\2\2\u01f5\u01f6\7e\2\2\u01f6\u01f7\7c\2\2\u01f7\u01f8"+
		"\7n\2\2\u01f8\u01f9\7u\2\2\u01f9\63\3\2\2\2\u01fa\u01fb\7v\2\2\u01fb\u01fc"+
		"\7j\2\2\u01fc\u01fd\7t\2\2\u01fd\u01fe\7q\2\2\u01fe\u01ff\7y\2\2\u01ff"+
		"\u0200\7u\2\2\u0200\65\3\2\2\2\u0201\u0202\7e\2\2\u0202\u0203\7c\2\2\u0203"+
		"\u0204\7v\2\2\u0204\u0205\7e\2\2\u0205\u0206\7j\2\2\u0206\67\3\2\2\2\u0207"+
		"\u0208\7h\2\2\u0208\u0209\7k\2\2\u0209\u020a\7p\2\2\u020a\u020b\7c\2\2"+
		"\u020b\u020c\7n\2\2\u020c\u020d\7n\2\2\u020d\u020e\7{\2\2\u020e9\3\2\2"+
		"\2\u020f\u0210\7o\2\2\u0210\u0211\7q\2\2\u0211\u0212\7f\2\2\u0212\u0213"+
		"\7g\2\2\u0213\u0214\3\2\2\2\u0214\u0215\b\32\13\2\u0215;\3\2\2\2\u0216"+
		"\u0217\5\u00acS\2\u0217\u0218\b\33\f\2\u0218=\3\2\2\2\u0219\u021a\5\u00ae"+
		"T\2\u021a?\3\2\2\2\u021b\u021c\5\u00d6h\2\u021cA\3\2\2\2\u021d\u021e\5"+
		"\u00d8i\2\u021e\u021f\b\36\r\2\u021fC\3\2\2\2\u0220\u0221\5\u00b4W\2\u0221"+
		"E\3\2\2\2\u0222\u0223\5\u00b6X\2\u0223G\3\2\2\2\u0224\u0225\5\u00b8Y\2"+
		"\u0225I\3\2\2\2\u0226\u0227\5\u00baZ\2\u0227K\3\2\2\2\u0228\u0229\5\u00c0"+
		"]\2\u0229\u022a\3\2\2\2\u022a\u022b\b#\16\2\u022bM\3\2\2\2\u022c\u022d"+
		"\5\u00c2^\2\u022dO\3\2\2\2\u022e\u022f\7c\2\2\u022f\u0230\7u\2\2\u0230"+
		"\u0231\7u\2\2\u0231\u0232\7q\2\2\u0232\u0233\7e\2\2\u0233Q\3\2\2\2\u0234"+
		"\u0235\7t\2\2\u0235\u0236\7k\2\2\u0236\u0237\7i\2\2\u0237\u0238\7j\2\2"+
		"\u0238\u0239\7v\2\2\u0239S\3\2\2\2\u023a\u023b\7n\2\2\u023b\u023c\7g\2"+
		"\2\u023c\u023d\7h\2\2\u023d\u023e\7v\2\2\u023eU\3\2\2\2\u023f\u0240\7"+
		"h\2\2\u0240\u0241\7c\2\2\u0241\u0242\7k\2\2\u0242\u0243\7n\2\2\u0243W"+
		"\3\2\2\2\u0244\u0245\5\u00c4_\2\u0245Y\3\2\2\2\u0246\u0247\5\u00c6`\2"+
		"\u0247[\3\2\2\2\u0248\u0249\5\u00c8a\2\u0249]\3\2\2\2\u024a\u024b\5\u00ca"+
		"b\2\u024b_\3\2\2\2\u024c\u024d\5\u00ced\2\u024da\3\2\2\2\u024e\u024f\5"+
		"\u00ccc\2\u024fc\3\2\2\2\u0250\u0251\5\u00d2f\2\u0251e\3\2\2\2\u0252\u0253"+
		"\5\u00d4g\2\u0253g\3\2\2\2\u0254\u0255\5\u00dck\2\u0255i\3\2\2\2\u0256"+
		"\u0257\5\u00daj\2\u0257k\3\2\2\2\u0258\u0259\5\u00del\2\u0259m\3\2\2\2"+
		"\u025a\u025b\7j\2\2\u025b\u025c\7g\2\2\u025c\u025d\7c\2\2\u025d\u025e"+
		"\7f\2\2\u025e\u025f\7g\2\2\u025f\u0260\7t\2\2\u0260o\3\2\2\2\u0261\u0262"+
		"\7o\2\2\u0262\u0263\7g\2\2\u0263\u0264\7o\2\2\u0264\u0265\7d\2\2\u0265"+
		"\u0266\7g\2\2\u0266\u0267\7t\2\2\u0267\u0268\7u\2\2\u0268q\3\2\2\2\u0269"+
		"\u026a\5\u00e0m\2\u026as\3\2\2\2\u026b\u026c\5\u00e2n\2\u026cu\3\2\2\2"+
		"\u026d\u0271\5\u00a6P\2\u026e\u0270\5\u00a4O\2\u026f\u026e\3\2\2\2\u0270"+
		"\u0273\3\2\2\2\u0271\u026f\3\2\2\2\u0271\u0272\3\2\2\2\u0272\u0274\3\2"+
		"\2\2\u0273\u0271\3\2\2\2\u0274\u0275\b8\17\2\u0275w\3\2\2\2\u0276\u0278"+
		"\5|;\2\u0277\u0276\3\2\2\2\u0278\u0279\3\2\2\2\u0279\u0277\3\2\2\2\u0279"+
		"\u027a\3\2\2\2\u027a\u027b\3\2\2\2\u027b\u027c\b9\2\2\u027cy\3\2\2\2\u027d"+
		"\u027e\13\2\2\2\u027e{\3\2\2\2\u027f\u0282\5~<\2\u0280\u0282\5\u0080="+
		"\2\u0281\u027f\3\2\2\2\u0281\u0280\3\2\2\2\u0282}\3\2\2\2\u0283\u0284"+
		"\t\2\2\2\u0284\177\3\2\2\2\u0285\u0286\t\3\2\2\u0286\u0081\3\2\2\2\u0287"+
		"\u0288\7\61\2\2\u0288\u0289\7,\2\2\u0289\u028d\3\2\2\2\u028a\u028c\13"+
		"\2\2\2\u028b\u028a\3\2\2\2\u028c\u028f\3\2\2\2\u028d\u028e\3\2\2\2\u028d"+
		"\u028b\3\2\2\2\u028e\u0293\3\2\2\2\u028f\u028d\3\2\2\2\u0290\u0291\7,"+
		"\2\2\u0291\u0294\7\61\2\2\u0292\u0294\7\2\2\3\u0293\u0290\3\2\2\2\u0293"+
		"\u0292\3\2\2\2\u0294\u0083\3\2\2\2\u0295\u0296\7\61\2\2\u0296\u0297\7"+
		",\2\2\u0297\u0298\7,\2\2\u0298\u029c\3\2\2\2\u0299\u029b\13\2\2\2\u029a"+
		"\u0299\3\2\2\2\u029b\u029e\3\2\2\2\u029c\u029d\3\2\2\2\u029c\u029a\3\2"+
		"\2\2\u029d\u02a2\3\2\2\2\u029e\u029c\3\2\2\2\u029f\u02a0\7,\2\2\u02a0"+
		"\u02a3\7\61\2\2\u02a1\u02a3\7\2\2\3\u02a2\u029f\3\2\2\2\u02a2\u02a1\3"+
		"\2\2\2\u02a3\u0085\3\2\2\2\u02a4\u02a5\7\61\2\2\u02a5\u02a6\7\61\2\2\u02a6"+
		"\u02aa\3\2\2\2\u02a7\u02a9\n\4\2\2\u02a8\u02a7\3\2\2\2\u02a9\u02ac\3\2"+
		"\2\2\u02aa\u02a8\3\2\2\2\u02aa\u02ab\3\2\2\2\u02ab\u0087\3\2\2\2\u02ac"+
		"\u02aa\3\2\2\2\u02ad\u02b1\5\u00aaR\2\u02ae\u02b2\t\5\2\2\u02af\u02b2"+
		"\5\u008cC\2\u02b0\u02b2\13\2\2\2\u02b1\u02ae\3\2\2\2\u02b1\u02af\3\2\2"+
		"\2\u02b1\u02b0\3\2\2\2\u02b2\u0089\3\2\2\2\u02b3\u02b4\5\u00aaR\2\u02b4"+
		"\u02b5\13\2\2\2\u02b5\u008b\3\2\2\2\u02b6\u02c1\7w\2\2\u02b7\u02bf\5\u0090"+
		"E\2\u02b8\u02bd\5\u0090E\2\u02b9\u02bb\5\u0090E\2\u02ba\u02bc\5\u0090"+
		"E\2\u02bb\u02ba\3\2\2\2\u02bb\u02bc\3\2\2\2\u02bc\u02be\3\2\2\2\u02bd"+
		"\u02b9\3\2\2\2\u02bd\u02be\3\2\2\2\u02be\u02c0\3\2\2\2\u02bf\u02b8\3\2"+
		"\2\2\u02bf\u02c0\3\2\2\2\u02c0\u02c2\3\2\2\2\u02c1\u02b7\3\2\2\2\u02c1"+
		"\u02c2\3\2\2\2\u02c2\u008d\3\2\2\2\u02c3\u02cc\7\62\2\2\u02c4\u02c8\t"+
		"\6\2\2\u02c5\u02c7\5\u0092F\2\u02c6\u02c5\3\2\2\2\u02c7\u02ca\3\2\2\2"+
		"\u02c8\u02c6\3\2\2\2\u02c8\u02c9\3\2\2\2\u02c9\u02cc\3\2\2\2\u02ca\u02c8"+
		"\3\2\2\2\u02cb\u02c3\3\2\2\2\u02cb\u02c4\3\2\2\2\u02cc\u008f\3\2\2\2\u02cd"+
		"\u02ce\t\7\2\2\u02ce\u0091\3\2\2\2\u02cf\u02d0\t\b\2\2\u02d0\u0093\3\2"+
		"\2\2\u02d1\u02d2\7v\2\2\u02d2\u02d3\7t\2\2\u02d3\u02d4\7w\2\2\u02d4\u02db"+
		"\7g\2\2\u02d5\u02d6\7h\2\2\u02d6\u02d7\7c\2\2\u02d7\u02d8\7n\2\2\u02d8"+
		"\u02d9\7u\2\2\u02d9\u02db\7g\2\2\u02da\u02d1\3\2\2\2\u02da\u02d5\3\2\2"+
		"\2\u02db\u0095\3\2\2\2\u02dc\u02df\5\u00b0U\2\u02dd\u02e0\5\u0088A\2\u02de"+
		"\u02e0\n\t\2\2\u02df\u02dd\3\2\2\2\u02df\u02de\3\2\2\2\u02e0\u02e1\3\2"+
		"\2\2\u02e1\u02e2\5\u00b0U\2\u02e2\u0097\3\2\2\2\u02e3\u02e8\5\u00b0U\2"+
		"\u02e4\u02e7\5\u0088A\2\u02e5\u02e7\n\t\2\2\u02e6\u02e4\3\2\2\2\u02e6"+
		"\u02e5\3\2\2\2\u02e7\u02ea\3\2\2\2\u02e8\u02e6\3\2\2\2\u02e8\u02e9\3\2"+
		"\2\2\u02e9\u02eb\3\2\2\2\u02ea\u02e8\3\2\2\2\u02eb\u02ec\5\u00b0U\2\u02ec"+
		"\u0099\3\2\2\2\u02ed\u02f2\5\u00b2V\2\u02ee\u02f1\5\u0088A\2\u02ef\u02f1"+
		"\n\n\2\2\u02f0\u02ee\3\2\2\2\u02f0\u02ef\3\2\2\2\u02f1\u02f4\3\2\2\2\u02f2"+
		"\u02f0\3\2\2\2\u02f2\u02f3\3\2\2\2\u02f3\u02f5\3\2\2\2\u02f4\u02f2\3\2"+
		"\2\2\u02f5\u02f6\5\u00b2V\2\u02f6\u009b\3\2\2\2\u02f7\u02fc\5\u00b0U\2"+
		"\u02f8\u02fb\5\u0088A\2\u02f9\u02fb\n\t\2\2\u02fa\u02f8\3\2\2\2\u02fa"+
		"\u02f9\3\2\2\2\u02fb\u02fe\3\2\2\2\u02fc\u02fa\3\2\2\2\u02fc\u02fd\3\2"+
		"\2\2\u02fd\u009d\3\2\2\2\u02fe\u02fc\3\2\2\2\u02ff\u0300\4C\\\2\u0300"+
		"\u009f\3\2\2\2\u0301\u0302\4c|\2\u0302\u00a1\3\2\2\2\u0303\u0306\5\u009e"+
		"L\2\u0304\u0306\5\u00a0M\2\u0305\u0303\3\2\2\2\u0305\u0304\3\2\2\2\u0306"+
		"\u00a3\3\2\2\2\u0307\u030c\5\u00a6P\2\u0308\u030c\4\62;\2\u0309\u030c"+
		"\5\u00d0e\2\u030a\u030c\t\13\2\2\u030b\u0307\3\2\2\2\u030b\u0308\3\2\2"+
		"\2\u030b\u0309\3\2\2\2\u030b\u030a\3\2\2\2\u030c\u00a5\3\2\2\2\u030d\u0310"+
		"\5\u00a2N\2\u030e\u0310\t\f\2\2\u030f\u030d\3\2\2\2\u030f\u030e\3\2\2"+
		"\2\u0310\u00a7\3\2\2\2\u0311\u0312\7k\2\2\u0312\u0313\7p\2\2\u0313\u0314"+
		"\7v\2\2\u0314\u00a9\3\2\2\2\u0315\u0316\7^\2\2\u0316\u00ab\3\2\2\2\u0317"+
		"\u0318\7<\2\2\u0318\u00ad\3\2\2\2\u0319\u031a\7<\2\2\u031a\u031b\7<\2"+
		"\2\u031b\u00af\3\2\2\2\u031c\u031d\7)\2\2\u031d\u00b1\3\2\2\2\u031e\u031f"+
		"\7$\2\2\u031f\u00b3\3\2\2\2\u0320\u0321\7*\2\2\u0321\u00b5\3\2\2\2\u0322"+
		"\u0323\7+\2\2\u0323\u00b7\3\2\2\2\u0324\u0325\7}\2\2\u0325\u00b9\3\2\2"+
		"\2\u0326\u0327\7\177\2\2\u0327\u00bb\3\2\2\2\u0328\u0329\7]\2\2\u0329"+
		"\u00bd\3\2\2\2\u032a\u032b\7_\2\2\u032b\u00bf\3\2\2\2\u032c\u032d\7/\2"+
		"\2\u032d\u032e\7@\2\2\u032e\u00c1\3\2\2\2\u032f\u0330\7>\2\2\u0330\u00c3"+
		"\3\2\2\2\u0331\u0332\7@\2\2\u0332\u00c5\3\2\2\2\u0333\u0334\7?\2\2\u0334"+
		"\u00c7\3\2\2\2\u0335\u0336\7A\2\2\u0336\u00c9\3\2\2\2\u0337\u0338\7,\2"+
		"\2\u0338\u00cb\3\2\2\2\u0339\u033a\7-\2\2\u033a\u00cd\3\2\2\2\u033b\u033c"+
		"\7-\2\2\u033c\u033d\7?\2\2\u033d\u00cf\3\2\2\2\u033e\u033f\7a\2\2\u033f"+
		"\u00d1\3\2\2\2\u0340\u0341\7~\2\2\u0341\u00d3\3\2\2\2\u0342\u0343\7&\2"+
		"\2\u0343\u00d5\3\2\2\2\u0344\u0345\7.\2\2\u0345\u00d7\3\2\2\2\u0346\u0347"+
		"\7=\2\2\u0347\u00d9\3\2\2\2\u0348\u0349\7\60\2\2\u0349\u00db\3\2\2\2\u034a"+
		"\u034b\7\60\2\2\u034b\u034c\7\60\2\2\u034c\u00dd\3\2\2\2\u034d\u034e\7"+
		"B\2\2\u034e\u00df\3\2\2\2\u034f\u0350\7%\2\2\u0350\u00e1\3\2\2\2\u0351"+
		"\u0352\7\u0080\2\2\u0352\u00e3\3\2\2\2\u0353\u0354\5\u00bc[\2\u0354\u0355"+
		"\3\2\2\2\u0355\u0356\bo\20\2\u0356\u0357\bo\21\2\u0357\u00e5\3\2\2\2\u0358"+
		"\u0359\5\u008aB\2\u0359\u035a\3\2\2\2\u035a\u035b\bp\20\2\u035b\u00e7"+
		"\3\2\2\2\u035c\u035d\5\u009aJ\2\u035d\u035e\3\2\2\2\u035e\u035f\bq\20"+
		"\2\u035f\u00e9\3\2\2\2\u0360\u0361\5\u0098I\2\u0361\u0362\3\2\2\2\u0362"+
		"\u0363\br\20\2\u0363\u00eb\3\2\2\2\u0364\u0365\5\u00be\\\2\u0365\u0366"+
		"\bs\22\2\u0366\u00ed\3\2\2\2\u0367\u0368\7\2\2\3\u0368\u0369\3\2\2\2\u0369"+
		"\u036a\bt\23\2\u036a\u00ef\3\2\2\2\u036b\u036c\13\2\2\2\u036c\u00f1\3"+
		"\2\2\2\u036d\u036e\5\u00b8Y\2\u036e\u036f\3\2\2\2\u036f\u0370\bv\24\2"+
		"\u0370\u0371\bv\4\2\u0371\u00f3\3\2\2\2\u0372\u0373\5\u008aB\2\u0373\u0374"+
		"\3\2\2\2\u0374\u0375\bw\24\2\u0375\u00f5\3\2\2\2\u0376\u0377\5\u009aJ"+
		"\2\u0377\u0378\3\2\2\2\u0378\u0379\bx\24\2\u0379\u00f7\3\2\2\2\u037a\u037b"+
		"\5\u0098I\2\u037b\u037c\3\2\2\2\u037c\u037d\by\24\2\u037d\u00f9\3\2\2"+
		"\2\u037e\u037f\5\u0084?\2\u037f\u0380\3\2\2\2\u0380\u0381\bz\24\2\u0381"+
		"\u00fb\3\2\2\2\u0382\u0383\5\u0082>\2\u0383\u0384\3\2\2\2\u0384\u0385"+
		"\b{\24\2\u0385\u00fd\3\2\2\2\u0386\u0387\5\u0086@\2\u0387\u0388\3\2\2"+
		"\2\u0388\u0389\b|\24\2\u0389\u00ff\3\2\2\2\u038a\u038b\5\u00baZ\2\u038b"+
		"\u038c\b}\25\2\u038c\u0101\3\2\2\2\u038d\u038e\7\2\2\3\u038e\u038f\3\2"+
		"\2\2\u038f\u0390\b~\23\2\u0390\u0103\3\2\2\2\u0391\u0392\13\2\2\2\u0392"+
		"\u0105\3\2\2\2\u0393\u0394\5\u0084?\2\u0394\u0395\3\2\2\2\u0395\u0396"+
		"\b\u0080\26\2\u0396\u0107\3\2\2\2\u0397\u0398\5\u0082>\2\u0398\u0399\3"+
		"\2\2\2\u0399\u039a\b\u0081\27\2\u039a\u039b\b\u0081\2\2\u039b\u0109\3"+
		"\2\2\2\u039c\u039d\5\u0086@\2\u039d\u039e\3\2\2\2\u039e\u039f\b\u0082"+
		"\30\2\u039f\u03a0\b\u0082\2\2\u03a0\u010b\3\2\2\2\u03a1\u03a2\5\u00b8"+
		"Y\2\u03a2\u03a3\3\2\2\2\u03a3\u03a4\b\u0083\31\2\u03a4\u010d\3\2\2\2\u03a5"+
		"\u03a6\5\u00baZ\2\u03a6\u03a7\3\2\2\2\u03a7\u03a8\b\u0084\32\2\u03a8\u03a9"+
		"\b\u0084\23\2\u03a9\u010f\3\2\2\2\u03aa\u03ab\7u\2\2\u03ab\u03ac\7w\2"+
		"\2\u03ac\u03ad\7r\2\2\u03ad\u03ae\7g\2\2\u03ae\u03af\7t\2\2\u03af\u03b0"+
		"\7E\2\2\u03b0\u03b1\7n\2\2\u03b1\u03b2\7c\2\2\u03b2\u03b3\7u\2\2\u03b3"+
		"\u03b4\7u\2\2\u03b4\u0111\3\2\2\2\u03b5\u03b6\7n\2\2\u03b6\u03b7\7c\2"+
		"\2\u03b7\u03b8\7p\2\2\u03b8\u03b9\7i\2\2\u03b9\u03ba\7w\2\2\u03ba\u03bb"+
		"\7c\2\2\u03bb\u03bc\7i\2\2\u03bc\u03bd\7g\2\2\u03bd\u0113\3\2\2\2\u03be"+
		"\u03bf\7v\2\2\u03bf\u03c0\7q\2\2\u03c0\u03c1\7m\2\2\u03c1\u03c2\7g\2\2"+
		"\u03c2\u03c3\7p\2\2\u03c3\u03c4\7X\2\2\u03c4\u03c5\7q\2\2\u03c5\u03c6"+
		"\7e\2\2\u03c6\u03c7\7c\2\2\u03c7\u03c8\7d\2\2\u03c8\u0115\3\2\2\2\u03c9"+
		"\u03ca\7V\2\2\u03ca\u03cb\7q\2\2\u03cb\u03cc\7m\2\2\u03cc\u03cd\7g\2\2"+
		"\u03cd\u03ce\7p\2\2\u03ce\u03cf\7N\2\2\u03cf\u03d0\7c\2\2\u03d0\u03d1"+
		"\7d\2\2\u03d1\u03d2\7g\2\2\u03d2\u03d3\7n\2\2\u03d3\u03d4\7V\2\2\u03d4"+
		"\u03d5\7{\2\2\u03d5\u03d6\7r\2\2\u03d6\u03d7\7g\2\2\u03d7\u0117\3\2\2"+
		"\2\u03d8\u03dc\5\u00a6P\2\u03d9\u03db\5\u00a4O\2\u03da\u03d9\3\2\2\2\u03db"+
		"\u03de\3\2\2\2\u03dc\u03da\3\2\2\2\u03dc\u03dd\3\2\2\2\u03dd\u03df\3\2"+
		"\2\2\u03de\u03dc\3\2\2\2\u03df\u03e0\b\u0089\33\2\u03e0\u0119\3\2\2\2"+
		"\u03e1\u03e2\5\u00daj\2\u03e2\u03e3\3\2\2\2\u03e3\u03e4\b\u008a\34\2\u03e4"+
		"\u011b\3\2\2\2\u03e5\u03e6\5\u00c6`\2\u03e6\u03e7\3\2\2\2\u03e7\u03e8"+
		"\b\u008b\35\2\u03e8\u011d\3\2\2\2\u03e9\u03ea\5\u0098I\2\u03ea\u03eb\3"+
		"\2\2\2\u03eb\u03ec\b\u008c\36\2\u03ec\u011f\3\2\2\2\u03ed\u03ee\5\u00a8"+
		"Q\2\u03ee\u03ef\3\2\2\2\u03ef\u03f0\b\u008d\37\2\u03f0\u0121\3\2\2\2\u03f1"+
		"\u03f2\5\u00cab\2\u03f2\u03f3\3\2\2\2\u03f3\u03f4\b\u008e \2\u03f4\u0123"+
		"\3\2\2\2\u03f5\u03f6\5\u00d8i\2\u03f6\u03f7\3\2\2\2\u03f7\u03f8\b\u008f"+
		"!\2\u03f8\u0125\3\2\2\2\u03f9\u03fb\5|;\2\u03fa\u03f9\3\2\2\2\u03fb\u03fc"+
		"\3\2\2\2\u03fc\u03fa\3\2\2\2\u03fc\u03fd\3\2\2\2\u03fd\u03fe\3\2\2\2\u03fe"+
		"\u03ff\b\u0090\"\2\u03ff\u0400\b\u0090\2\2\u0400\u0127\3\2\2\2\u0401\u0402"+
		"\13\2\2\2\u0402\u0403\3\2\2\2\u0403\u0404\b\u0091#\2\u0404\u0129\3\2\2"+
		"\2\u0405\u0406\5\u0084?\2\u0406\u0407\3\2\2\2\u0407\u0408\b\u0092\26\2"+
		"\u0408\u012b\3\2\2\2\u0409\u040a\5\u0082>\2\u040a\u040b\3\2\2\2\u040b"+
		"\u040c\b\u0093\27\2\u040c\u040d\b\u0093\2\2\u040d\u012d\3\2\2\2\u040e"+
		"\u040f\5\u0086@\2\u040f\u0410\3\2\2\2\u0410\u0411\b\u0094\30\2\u0411\u0412"+
		"\b\u0094\2\2\u0412\u012f\3\2\2\2\u0413\u0414\5\u00b8Y\2\u0414\u0415\3"+
		"\2\2\2\u0415\u0416\b\u0095\31\2\u0416\u0131\3\2\2\2\u0417\u0418\5\u00ba"+
		"Z\2\u0418\u0419\3\2\2\2\u0419\u041a\b\u0096\32\2\u041a\u041b\b\u0096\23"+
		"\2\u041b\u0133\3\2\2\2\u041c\u0420\5\u00a6P\2\u041d\u041f\5\u00a4O\2\u041e"+
		"\u041d\3\2\2\2\u041f\u0422\3\2\2\2\u0420\u041e\3\2\2\2\u0420\u0421\3\2"+
		"\2\2\u0421\u0423\3\2\2\2\u0422\u0420\3\2\2\2\u0423\u0424\b\u0097$\2\u0424"+
		"\u0135\3\2\2\2\u0425\u0426\5\u00daj\2\u0426\u0427\3\2\2\2\u0427\u0428"+
		"\b\u0098\34\2\u0428\u0137\3\2\2\2\u0429\u042a\5\u00d6h\2\u042a\u042b\3"+
		"\2\2\2\u042b\u042c\b\u0099%\2\u042c\u0139\3\2\2\2\u042d\u042f\5|;\2\u042e"+
		"\u042d\3\2\2\2\u042f\u0430\3\2\2\2\u0430\u042e\3\2\2\2\u0430\u0431\3\2"+
		"\2\2\u0431\u0432\3\2\2\2\u0432\u0433\b\u009a\"\2\u0433\u0434\b\u009a\2"+
		"\2\u0434\u013b\3\2\2\2\u0435\u0436\5\u0084?\2\u0436\u0437\3\2\2\2\u0437"+
		"\u0438\b\u009b\26\2\u0438\u013d\3\2\2\2\u0439\u043a\5\u0082>\2\u043a\u043b"+
		"\3\2\2\2\u043b\u043c\b\u009c\27\2\u043c\u043d\b\u009c\2\2\u043d\u013f"+
		"\3\2\2\2\u043e\u043f\5\u0086@\2\u043f\u0440\3\2\2\2\u0440\u0441\b\u009d"+
		"\30\2\u0441\u0442\b\u009d\2\2\u0442\u0141\3\2\2\2\u0443\u0444\5\u00b8"+
		"Y\2\u0444\u0445\3\2\2\2\u0445\u0446\b\u009e\31\2\u0446\u0143\3\2\2\2\u0447"+
		"\u0448\5\u00baZ\2\u0448\u0449\3\2\2\2\u0449\u044a\b\u009f\32\2\u044a\u044b"+
		"\b\u009f\23\2\u044b\u0145\3\2\2\2\u044c\u0450\5\u00a6P\2\u044d\u044f\5"+
		"\u00a4O\2\u044e\u044d\3\2\2\2\u044f\u0452\3\2\2\2\u0450\u044e\3\2\2\2"+
		"\u0450\u0451\3\2\2\2\u0451\u0453\3\2\2\2\u0452\u0450\3\2\2\2\u0453\u0454"+
		"\b\u00a0\33\2\u0454\u0147\3\2\2\2\u0455\u0456\5\u00daj\2\u0456\u0457\3"+
		"\2\2\2\u0457\u0458\b\u00a1\34\2\u0458\u0149\3\2\2\2\u0459\u045a\5\u00d6"+
		"h\2\u045a\u045b\3\2\2\2\u045b\u045c\b\u00a2%\2\u045c\u014b\3\2\2\2\u045d"+
		"\u045f\5|;\2\u045e\u045d\3\2\2\2\u045f\u0460\3\2\2\2\u0460\u045e\3\2\2"+
		"\2\u0460\u0461\3\2\2\2\u0461\u0462\3\2\2\2\u0462\u0463\b\u00a3\"\2\u0463"+
		"\u0464\b\u00a3\2\2\u0464\u014d\3\2\2\2\u0465\u0466\5\u0086@\2\u0466\u0467"+
		"\3\2\2\2\u0467\u0468\b\u00a4\30\2\u0468\u0469\b\u00a4\2\2\u0469\u014f"+
		"\3\2\2\2\u046a\u046b\7u\2\2\u046b\u046c\7m\2\2\u046c\u046d\7k\2\2\u046d"+
		"\u046e\7r\2\2\u046e\u0151\3\2\2\2\u046f\u0470\7o\2\2\u0470\u0471\7q\2"+
		"\2\u0471\u0472\7t\2\2\u0472\u0473\7g\2\2\u0473\u0153\3\2\2\2\u0474\u0475"+
		"\7v\2\2\u0475\u0476\7{\2\2\u0476\u0477\7r\2\2\u0477\u0478\7g\2\2\u0478"+
		"\u0155\3\2\2\2\u0479\u047a\7e\2\2\u047a\u047b\7j\2\2\u047b\u047c\7c\2"+
		"\2\u047c\u047d\7p\2\2\u047d\u047e\7p\2\2\u047e\u047f\7g\2\2\u047f\u0480"+
		"\7n\2\2\u0480\u0157\3\2\2\2\u0481\u0482\7o\2\2\u0482\u0483\7q\2\2\u0483"+
		"\u0484\7f\2\2\u0484\u0485\7g\2\2\u0485\u0159\3\2\2\2\u0486\u0487\7r\2"+
		"\2\u0487\u0488\7w\2\2\u0488\u0489\7u\2\2\u0489\u048a\7j\2\2\u048a\u048b"+
		"\7O\2\2\u048b\u048c\7q\2\2\u048c\u048d\7f\2\2\u048d\u048e\7g\2\2\u048e"+
		"\u015b\3\2\2\2\u048f\u0490\7r\2\2\u0490\u0491\7q\2\2\u0491\u0492\7r\2"+
		"\2\u0492\u0493\7O\2\2\u0493\u0494\7q\2\2\u0494\u0495\7f\2\2\u0495\u0496"+
		"\7g\2\2\u0496\u015d\3\2\2\2\u0497\u0498\5\u00b4W\2\u0498\u0499\3\2\2\2"+
		"\u0499\u049a\b\u00ac&\2\u049a\u015f\3\2\2\2\u049b\u049f\5\u00a6P\2\u049c"+
		"\u049e\5\u00a4O\2\u049d\u049c\3\2\2\2\u049e\u04a1\3\2\2\2\u049f\u049d"+
		"\3\2\2\2\u049f\u04a0\3\2\2\2\u04a0\u04a2\3\2\2\2\u04a1\u049f\3\2\2\2\u04a2"+
		"\u04a3\b\u00ad\33\2\u04a3\u0161\3\2\2\2\u04a4\u04a5\5\u008eD\2\u04a5\u04a6"+
		"\3\2\2\2\u04a6\u04a7\b\u00ae\37\2\u04a7\u0163\3\2\2\2\u04a8\u04a9\5\u00b6"+
		"X\2\u04a9\u04aa\3\2\2\2\u04aa\u04ab\b\u00af\'\2\u04ab\u0165\3\2\2\2\u04ac"+
		"\u04ad\5\u00d6h\2\u04ad\u04ae\3\2\2\2\u04ae\u04af\b\u00b0%\2\u04af\u0167"+
		"\3\2\2\2\u04b0\u04b2\5|;\2\u04b1\u04b0\3\2\2\2\u04b2\u04b3\3\2\2\2\u04b3"+
		"\u04b1\3\2\2\2\u04b3\u04b4\3\2\2\2\u04b4\u04b5\3\2\2\2\u04b5\u04b6\b\u00b1"+
		"\"\2\u04b6\u04b7\b\u00b1\2\2\u04b7\u0169\3\2\2\2\u04b8\u04b9\5\u00d8i"+
		"\2\u04b9\u04ba\3\2\2\2\u04ba\u04bb\b\u00b2\23\2\u04bb\u04bc\b\u00b2!\2"+
		"\u04bc\u016b\3\2\2\2\u04bd\u04c0\n\r\2\2\u04be\u04c0\5\u008aB\2\u04bf"+
		"\u04bd\3\2\2\2\u04bf\u04be\3\2\2\2\u04c0\u04c1\3\2\2\2\u04c1\u04bf\3\2"+
		"\2\2\u04c1\u04c2\3\2\2\2\u04c2\u04c3\3\2\2\2\u04c3\u04c4\b\u00b3(\2\u04c4"+
		"\u016d\3\2\2\2\u04c5\u04c6\5\u00be\\\2\u04c6\u04c7\3\2\2\2\u04c7\u04c8"+
		"\b\u00b4\23\2\u04c8\u016f\3\2\2\2\u04c9\u04ca\7\2\2\3\u04ca\u04cb\3\2"+
		"\2\2\u04cb\u04cc\b\u00b5\23\2\u04cc\u0171\3\2\2\2.\2\3\4\5\6\7\b\t\u0271"+
		"\u0279\u0281\u028d\u0293\u029c\u02a2\u02aa\u02b1\u02bb\u02bd\u02bf\u02c1"+
		"\u02c8\u02cb\u02da\u02df\u02e6\u02e8\u02f0\u02f2\u02fa\u02fc\u0305\u030b"+
		"\u030f\u03dc\u03fc\u0420\u0430\u0450\u0460\u049f\u04b3\u04bf\u04c1)\b"+
		"\2\2\3\b\2\7\4\2\7\5\2\7\6\2\7\7\2\3\r\3\3\16\4\3\21\5\3\32\6\3\33\7\3"+
		"\36\b\7\b\2\38\t\tA\2\7\3\2\3s\n\6\2\2\tD\2\3}\13\t\6\2\t\7\2\t\b\2\t"+
		"%\2\t&\2\t<\2\t\66\2\t.\2\t\n\2\t\t\2\t\60\2\t\"\2\t=\2\t>\2\3\u0097\f"+
		"\t!\2\t#\2\t$\2\5\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}