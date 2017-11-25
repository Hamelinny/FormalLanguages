package generated;// Generated from L.g4 by ANTLR 4.5.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LParser}.
 */
public interface LListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(LParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link LParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(LParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link LParser#blockNBraces}.
	 * @param ctx the parse tree
	 */
	void enterBlockNBraces(LParser.BlockNBracesContext ctx);
	/**
	 * Exit a parse tree produced by {@link LParser#blockNBraces}.
	 * @param ctx the parse tree
	 */
	void exitBlockNBraces(LParser.BlockNBracesContext ctx);
	/**
	 * Enter a parse tree produced by {@link LParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(LParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(LParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(LParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(LParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(LParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link LParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(LParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link LParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(LParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link LParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(LParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link LParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(LParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(LParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(LParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(LParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(LParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link LParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(LParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link LParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(LParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(LParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LParser#readStatement}.
	 * @param ctx the parse tree
	 */
	void enterReadStatement(LParser.ReadStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LParser#readStatement}.
	 * @param ctx the parse tree
	 */
	void exitReadStatement(LParser.ReadStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LParser#writeStatement}.
	 * @param ctx the parse tree
	 */
	void enterWriteStatement(LParser.WriteStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LParser#writeStatement}.
	 * @param ctx the parse tree
	 */
	void exitWriteStatement(LParser.WriteStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryMinusExpression}
	 * labeled alternative in {@link LParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMinusExpression(LParser.UnaryMinusExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryMinusExpression}
	 * labeled alternative in {@link LParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMinusExpression(LParser.UnaryMinusExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link LParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpression(LParser.IdentifierExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link LParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpression(LParser.IdentifierExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionCallExpression}
	 * labeled alternative in {@link LParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExpression(LParser.FunctionCallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionCallExpression}
	 * labeled alternative in {@link LParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExpression(LParser.FunctionCallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literalExpression}
	 * labeled alternative in {@link LParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExpression(LParser.LiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literalExpression}
	 * labeled alternative in {@link LParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExpression(LParser.LiteralExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryOperationExpression}
	 * labeled alternative in {@link LParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOperationExpression(LParser.BinaryOperationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryOperationExpression}
	 * labeled alternative in {@link LParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOperationExpression(LParser.BinaryOperationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionWithParentheses}
	 * labeled alternative in {@link LParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionWithParentheses(LParser.ExpressionWithParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionWithParentheses}
	 * labeled alternative in {@link LParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionWithParentheses(LParser.ExpressionWithParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierFunctionCall}
	 * labeled alternative in {@link LParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierFunctionCall(LParser.IdentifierFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierFunctionCall}
	 * labeled alternative in {@link LParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierFunctionCall(LParser.IdentifierFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link LParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(LParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(LParser.ArgumentsContext ctx);
}