/** document comment */
lexer grammar LexerGrammar;

/** document comment */
import ign=ImportedLexerGrammar;

/** document comment */
@header {
import mypackage.TokenClassWithAPackageAndQualifiedExtends1;
import mypackage.TokenClassWithAPackageAndUnqualifiedImplements1;

import org.nemesis.lexers.Lexer1;

import org.antlr.v4.runtime.CommonToken;
import org.nemesis.tokens.TokenExtension1;
}

/** document comment */

options {
tokenVocab = PackagedTokenFile;
tokenVocab = ImportedTokens1;
//tokenVocab = CombinedGrammar;
superClass = Lexer1;
language = 'Java';
TokenLabelType = TokenExtension1;
}

/** document comment */
channels { ChannelA, ChannelB, ChannelC }

/** document comment */
tokens { LG_TOKEN_1, LG_TOKEN_2 }

LG_TOKEN_3 : [a-z] LG_FRAGMENT -> mode(Mode1), channel(ChannelA);

fragment LG_FRAGMENT : 'A';

mode Mode1;

LG_TOKEN_4 : [a-z] -> popMode, type(LG_TOKEN_1), channel(ChannelB)
                        , pushMode(Mode2)
    ;

mode Mode2;

LG_TOKEN_5 : 'azerty';