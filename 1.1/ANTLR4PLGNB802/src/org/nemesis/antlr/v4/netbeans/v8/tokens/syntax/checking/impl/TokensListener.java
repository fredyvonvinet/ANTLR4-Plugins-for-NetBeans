// Generated from Tokens.g4 by ANTLR 4.6
package org.nemesis.antlr.v4.netbeans.v8.tokens.syntax.checking.impl;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TokensParser}.
 */
public interface TokensListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TokensParser#token_declarations}.
	 * @param ctx the parse tree
	 */
	void enterToken_declarations(TokensParser.Token_declarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#token_declarations}.
	 * @param ctx the parse tree
	 */
	void exitToken_declarations(TokensParser.Token_declarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(TokensParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(TokensParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#token_declaration}.
	 * @param ctx the parse tree
	 */
	void enterToken_declaration(TokensParser.Token_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#token_declaration}.
	 * @param ctx the parse tree
	 */
	void exitToken_declaration(TokensParser.Token_declarationContext ctx);
}