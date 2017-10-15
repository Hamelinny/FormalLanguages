package lexer;

import types.Lexeme;

import java.io.IOException;
import java.util.Iterator;

public class LexStream implements Iterator<Lexeme>{
    private Lexer lexer;
    private Lexeme next;

    public LexStream(java.io.Reader in) {
        lexer = new Lexer(in);
    }
    @Override
    public boolean hasNext() {
        if (next != null) {
            return true;
        }

        try {
            next = lexer.yylex();
        } catch (IOException e) {
        }

        return next!= null;
    }

    @Override
    public Lexeme next() {
        if (next == null) {
            try {
                next = lexer.yylex();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Lexeme lexeme = next;
        next = null;
        return lexeme;
    }
}
