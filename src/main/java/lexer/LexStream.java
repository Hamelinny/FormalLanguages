package lexer;

import exceptions.NoSuchLexemeException;
import types.Delimiter;
import types.Lexeme;
import types.LiteralFloat;

import java.io.IOException;
import java.util.Iterator;

public class LexStream implements Iterator<Lexeme>{
    private Lexer lexer;
    private Lexeme next;
    private Lexeme prev = null;

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
        } catch (NoSuchLexemeException e) {
            e.printInfo();
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
            } catch (NoSuchLexemeException e) {
                e.printInfo();
            }
        }

        Lexeme lexeme = next;
        next = null;
        if (prev != null) {
            if (prev.getClass() == LiteralFloat.class && prev.getLine() == lexeme.getLine()
                && prev.getEnd() == lexeme.getStart() && lexeme.getClass() != Delimiter.class) {
                try {
                    throw new NoSuchLexemeException(prev.getLine(), prev.getStart());
                } catch (NoSuchLexemeException e) {
                    e.printInfo();
                }
            }
        }
        prev = lexeme;
        return lexeme;
    }
}
