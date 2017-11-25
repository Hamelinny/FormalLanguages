package generated;// Generated from L.g4 by ANTLR 4.5.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(LParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link LParser#blockNBraces}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockNBraces(LParser.BlockNBracesContext ctx);
	/**
	 * Visit a parse tree produced by {@link LParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(LParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(LParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(LParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link LParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(LParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link LParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(LParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(LParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(LParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link LParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(LParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LParser#readStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadStatement(LParser.ReadStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LParser#writeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteStatement(LParser.WriteStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryMinusExpression}
	 * labeled alternative in {@link LParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryMinusExpression(LParser.UnaryMinusExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link LParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierExpression(LParser.IdentifierExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionCallExpression}
	 * labeled alternative in {@link LParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallExpression(LParser.FunctionCallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literalExpression}
	 * labeled alternative in {@link LParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralExpression(LParser.LiteralExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryOperationExpression}
	 * labeled alternative in {@link LParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOperationExpression(LParser.BinaryOperationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionWithParentheses}
	 * labeled alternative in {@link LParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionWithParentheses(LParser.ExpressionWithParenthesesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifierFunctionCall}
	 * labeled alternative in {@link LParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierFunctionCall(LParser.IdentifierFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link LParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(LParser.ArgumentsContext ctx);
}