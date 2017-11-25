import AST.Visitor;
import generated.LLexer;
import generated.LParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tests {
    @Test
    public void simpleExpression() {
        String s = "a + b";
        InputStreamReader input = new InputStreamReader(new ByteArrayInputStream(s.getBytes()));
        CharStream inp = null;
        try {
            inp = new ANTLRInputStream(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LLexer lexer = new LLexer(inp);
        TokenStream tokens = new CommonTokenStream(lexer);
        LParser parser = new LParser(tokens);
        Visitor visitor = new Visitor();
        LParser.BlockContext t = parser.block();
        System.out.println(visitor.visitBlock(t));
    }

    @Test
    public void functionDefinition() {
        String s = "fun sum(a, b) {return a + b}";
        InputStreamReader input = new InputStreamReader(new ByteArrayInputStream(s.getBytes()));
        CharStream inp = null;
        try {
            inp = new ANTLRInputStream(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LLexer lexer = new LLexer(inp);
        TokenStream tokens = new CommonTokenStream(lexer);
        LParser parser = new LParser(tokens);
        Visitor visitor = new Visitor();
        LParser.BlockContext t = parser.block();
        System.out.println(visitor.visitBlock(t));
    }

    @Test
    public void ifTest() {
        String s = "if (a < b) {a := b} if (a < b) {a := b} else {b := a}";
        InputStreamReader input = new InputStreamReader(new ByteArrayInputStream(s.getBytes()));
        CharStream inp = null;
        try {
            inp = new ANTLRInputStream(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LLexer lexer = new LLexer(inp);
        TokenStream tokens = new CommonTokenStream(lexer);
        LParser parser = new LParser(tokens);
        Visitor visitor = new Visitor();
        LParser.BlockContext t = parser.block();
        System.out.println(visitor.visitBlock(t));
    }

    @Test
    public void whileTest() {
        String s = "while (a < b) {b := b % a}";
        InputStreamReader input = new InputStreamReader(new ByteArrayInputStream(s.getBytes()));
        CharStream inp = null;
        try {
            inp = new ANTLRInputStream(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LLexer lexer = new LLexer(inp);
        TokenStream tokens = new CommonTokenStream(lexer);
        LParser parser = new LParser(tokens);
        Visitor visitor = new Visitor();
        LParser.BlockContext t = parser.block();
        System.out.println(visitor.visitBlock(t));
    }

    @Test
    public void readWriteTest() {
        String s = "write(2*3+7) read(a)";
        InputStreamReader input = new InputStreamReader(new ByteArrayInputStream(s.getBytes()));
        CharStream inp = null;
        try {
            inp = new ANTLRInputStream(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LLexer lexer = new LLexer(inp);
        TokenStream tokens = new CommonTokenStream(lexer);
        LParser parser = new LParser(tokens);
        Visitor visitor = new Visitor();
        LParser.BlockContext t = parser.block();
        System.out.println(visitor.visitBlock(t));
    }

    @Test
    public void functionCallTest() {
        String s = "c = sum(a, b)";
        InputStreamReader input = new InputStreamReader(new ByteArrayInputStream(s.getBytes()));
        CharStream inp = null;
        try {
            inp = new ANTLRInputStream(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LLexer lexer = new LLexer(inp);
        TokenStream tokens = new CommonTokenStream(lexer);
        LParser parser = new LParser(tokens);
        Visitor visitor = new Visitor();
        LParser.BlockContext t = parser.block();
        System.out.println(visitor.visitBlock(t));
    }

    @Test
    public void operatorsTest() {
        String s = "(5 * a) - b % c x <= y x >= y x < y x > y x && y x || y";
        InputStreamReader input = new InputStreamReader(new ByteArrayInputStream(s.getBytes()));
        CharStream inp = null;
        try {
            inp = new ANTLRInputStream(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LLexer lexer = new LLexer(inp);
        TokenStream tokens = new CommonTokenStream(lexer);
        LParser parser = new LParser(tokens);
        Visitor visitor = new Visitor();
        LParser.BlockContext t = parser.block();
        System.out.println(visitor.visitBlock(t));
    }

    @Test
    public void unaryMinus() {
        String s = "-(x*y)";
        InputStreamReader input = new InputStreamReader(new ByteArrayInputStream(s.getBytes()));
        CharStream inp = null;
        try {
            inp = new ANTLRInputStream(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LLexer lexer = new LLexer(inp);
        TokenStream tokens = new CommonTokenStream(lexer);
        LParser parser = new LParser(tokens);
        Visitor visitor = new Visitor();
        LParser.BlockContext t = parser.block();
        System.out.println(visitor.visitBlock(t));
    }
}
