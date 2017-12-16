package AST;

import generated.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class Visitor extends LBaseVisitor<String> {

    private int block = 0;
    private int statement = 0;
    private int expression = 0;
    private int whiles = 0;
    private int ifs = 0;
    private int parameters = 0;
    private int assign = 0;
    private int returns = 0;
    private int reads = 0;
    private int writes = 0;
    private int arguments = 0;

    static String buildInfo(ParserRuleContext ctx) {
        String info = "";
        info += "[start: ";
        info += ctx.getStart().getLine() + " ";
        info += ctx.getStart().getStartIndex() + " ";
        info += "stop: ";
        info += ctx.getStop().getLine() + " ";
        info += ctx.getStop().getStopIndex() + " ]\n";
        return info;
    }

    static String buildName(String s, int num) {
        return s + Integer.toString(num);
    }

    static String buildName(String s, String nm) {
        return s + " " + nm;
    }

    @Override public String visitProgram(LParser.ProgramContext ctx) {
        String info = "";
        String name = buildName("program", "");
        info += name;
        info += buildInfo(ctx);
        for (ParseTree child : ctx.children) {
            info += name;
            info += visit(child);
        }
        return info;
    }

    @Override public String visitBlock(LParser.BlockContext ctx) {
        String info = "";
        String name = buildName("block", block++);
        info += " -> " + name + "\n";
        info += name;
        info += buildInfo(ctx);
        for (ParseTree child : ctx.statement()) {
            info += name;
            info += visit(child);
        }
        return info;
    }

    @Override public String visitBlockNBraces(LParser.BlockNBracesContext ctx) {
        String info = "";
        String name = buildName("block", block++);
        info += " -> " + name + "\n";
        info += name;
        info += buildInfo(ctx);
        info += name;
        info += " -> {\n";
        info += name;
        info += " -> }\n";
        info += name;
        info += visit(ctx.block());
        return info;
    }

    @Override public String visitStatement(LParser.StatementContext ctx) {
        String info = "";
        String name = buildName("statement", statement++);
        info += " -> " + name + "\n";
        info += name;
        info += buildInfo(ctx);
        for (ParseTree child : ctx.children) {
            info += name;
            info += visit(child);
        }
        return info;
    }

    @Override public String visitFunction(LParser.FunctionContext ctx) {
        String info = "";
        String name = buildName("function", ctx.Identifier().getText());
        info += " -> " + name + "\n";
        info += name;
        info += buildInfo(ctx);
        info += name;
        info += visit(ctx.parameters());
        info += name;
        info += visit(ctx.blockNBraces());
        return info;
    }

    @Override public String visitParameters(LParser.ParametersContext ctx) {
        String info = "";
        String name = buildName("parameters", parameters++);
        info += " -> " + name + "\n";
        info += name;
        info += buildInfo(ctx);
        for (ParseTree param : ctx.Identifier()) {
            info += name;
            info += " -> identifier " + param.getText() + "\n";
        }
        return info;
    }

    @Override public String visitWhileStatement(LParser.WhileStatementContext ctx) {
        String info = "";
        String name = buildName("while", whiles++);
        info += " -> " + name + "\n";
        info += name;
        info += buildInfo(ctx);
        info += name;
        info += visit(ctx.expression());
        info += name;
        info += visit(ctx.blockNBraces());
        return info;
    }

    @Override public String visitIfStatement(LParser.IfStatementContext ctx) {
        String info = "";
        String name = buildName("if", ifs++);
        info += " -> " + name + "\n";
        info += name;
        info += buildInfo(ctx);
        info += name;
        info += visit(ctx.expression());
        for (ParseTree t : ctx.blockNBraces()) {
            info += name;
            info += visit(t);
        }
        return info;
    }

    @Override public String visitAssignment(LParser.AssignmentContext ctx) {
        String info = "";
        String name = buildName("assign", assign++);
        info += " -> " + name + "\n";
        info += name;
        info += buildInfo(ctx);
        info += name;
        info += " -> identifier " + ctx.Identifier().getText() + "\n";
        info += name;
        info += visit(ctx.expression());
        return info;
    }

    @Override public String visitReturnStatement(LParser.ReturnStatementContext ctx) {
        String info = "";
        String name = buildName("return", returns++);
        info += " -> " + name + "\n";
        info += name;
        info += buildInfo(ctx);
        info += name;
        info +=  visit(ctx.expression());
        return info;
    }

    @Override public String visitReadStatement(LParser.ReadStatementContext ctx) {
        String info = "";
        String name = buildName("read", reads++);
        info += " -> " + name + "\n";
        info += name;
        info += buildInfo(ctx);
        info += name;
        info += " -> " + ctx.Identifier().getText() + "\n";
        return info;
    }

    @Override public String visitWriteStatement(LParser.WriteStatementContext ctx) {
        String info = "";
        String name = buildName("write", writes++);
        info += " -> " + name + "\n";
        info += name;
        info += buildInfo(ctx);
        info += name;
        info +=  visit(ctx.expression());
        return info;
    }

    @Override public String visitMinusExpression(LParser.MinusExpressionContext ctx) {
        String info = "";
        String name = buildName("expression", expression++);
        info += " -> " + name + "\n";
        info += name;
        info += buildInfo(ctx);
        info += name;
        info += " -> " + " -\n";
        info += name;
        info += visit(ctx.expression());
        return info;
    }

    @Override public String visitIdentifierExpression(LParser.IdentifierExpressionContext ctx) {
        String info = "";
        String name = buildName("identifier", ctx.Identifier().getText());
        info += " -> " + name + "\n";
        return info;
    }

    @Override public String visitFunctionCallExpression(LParser.FunctionCallExpressionContext ctx) {
        String info = "";
        String name = buildName("expression", expression++);
        info += " -> " + name + "\n";
        info += name;
        info += buildInfo(ctx);
        info += name;
        info +=  visit(ctx.functionCall());
        return info;
    }

    @Override public String visitLiteralExpression(LParser.LiteralExpressionContext ctx) {
        String info = "";
        String name = buildName("literal", ctx.Literal().getText());
        info += " -> " + name + "\n";
        return info;
    }

    @Override public String visitBinaryOperationExpression(LParser.BinaryOperationExpressionContext ctx) {
        String info = "";
        String name = buildName("expression", expression++);
        info += " -> " + name + "\n";
        info += name;
        info += buildInfo(ctx);
        info += name;
        info += " -> " + ctx.op.getText() + "\n";
        for (ParseTree expr : ctx.expression()) {
            info += name;
            info +=  visit(expr);
        }
        return info;
    }

    @Override public String visitExpressionWithParentheses(LParser.ExpressionWithParenthesesContext ctx) {
        String info = "";
        String name = buildName("expression", expression++);
        info += " -> " + name + "\n";
        info += name;
        info += buildInfo(ctx);
        info += name;
        info += " -> (\n";
        info += name;
        info += " -> )\n";
        info += name;
        info += visit(ctx.expression());
        return info;
    }

    @Override public String visitIdentifierFunctionCall(LParser.IdentifierFunctionCallContext ctx) {
        String info = "";
        String name = buildName("function call",  ctx.Identifier().getText());
        info += " -> " + name + "\n";
        info += name;
        info += buildInfo(ctx);
        info += name;
        info += visit(ctx.arguments());
        return info;
    }

    @Override public String visitArguments(LParser.ArgumentsContext ctx) {
        String info = "";
        String name = buildName("arguments",  arguments++);
        info += " -> " + name + "\n";
        info += name;
        info += buildInfo(ctx);
        for (ParseTree expr : ctx.expression()) {
            info += name;
            info += visit(expr);
        }
        return info;
    }
}
