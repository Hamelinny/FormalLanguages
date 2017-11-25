import AST.Visitor;
import generated.LLexer;
import generated.LParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String args[]) {
        FileInputStream input = null;
        try {
            input = new FileInputStream(new File(args[0]));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
        System.out.println();
        System.out.println(visitor.visitBlock(t));

    }


}
