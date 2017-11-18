import exceptions.NoSuchLexemeException;
import lexer.LexStream;
import lexer.Main;
import org.junit.Test;

import java.io.StringReader;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;


public class Tests {

    public static String streamToString(LexStream stream) {
        StringBuilder builder = new StringBuilder();
        while (stream.hasNext()) {
            builder.append(stream.next());
            builder.append("\n");
        }
        return builder.toString();
    }

    @Test
    public void testReadIdent() {
        String s = "read x;";
        StringReader reader = new StringReader(s);
        LexStream stream = new LexStream(reader);
        String ans = "KW_READ(0, 0, 4)\n" +
                "IDENT(0, 5, 6, x)\n" +
                "SEMICOLON(0, 6, 7)\n";
        assertEquals(ans, streamToString(stream));
    }

    @Test
    public void testWriteFloat() {
        String s = "write 3";
        StringReader reader = new StringReader(s);
        LexStream stream = new LexStream(reader);
        String ans = "KW_WRITE(0, 0, 5)\n" +
                "FLOAT(0, 6, 7, 3.0)\n";
        assertEquals(ans, streamToString(stream));
    }

    @Test
    public void testWhileDo() {
        String s = "while (true)\ndo\nbegin\nwrite x + 1\nend";
        StringReader reader = new StringReader(s);
        LexStream stream = new LexStream(reader);
        String ans = "KW_WHILE(0, 0, 5)\n" +
                "LEFT_PAREN(0, 6, 7)\n" +
                "TRUE(0, 7, 11)\n" +
                "RIGHT_PAREN(0, 11, 12)\n" +
                "KW_DO(1, 0, 2)\n" +
                "KW_BEGIN(2, 0, 5)\n" +
                "KW_WRITE(3, 0, 5)\n" +
                "IDENT(3, 6, 7, x)\n" +
                "PLUS(3, 8, 9)\n" +
                "FLOAT(3, 10, 11, 1.0)\n" +
                "KW_END(4, 0, 3)\n";
        assertEquals(ans, streamToString(stream));
    }

    @Test
    public void testFloat() {
        String s = "1e-9 0.6e5 e56 .56e-7 123_456_789 101010.26727e-6 1__2__3 0.5 5.0";
        StringReader reader = new StringReader(s);
        LexStream stream = new LexStream(reader);
        String ans = "FLOAT(0, 0, 4, 1.0E-9)\n" +
                "FLOAT(0, 5, 10, 60000.0)\n" +
                "IDENT(0, 11, 14, e56)\n" +
                "FLOAT(0, 15, 21, 5.6E-8)\n" +
                "FLOAT(0, 22, 33, 1.23456789E8)\n" +
                "FLOAT(0, 34, 49, 0.10101026727)\n" +
                "FLOAT(0, 50, 57, 123.0)\n" +
                "FLOAT(0, 58, 61, 0.5)\n" +
                "FLOAT(0, 62, 65, 5.0)\n";
        assertEquals(ans, streamToString(stream));
    }

    @Test
    public void testOperators() {
        String s = "x == x; x >= x; x <= x";
        StringReader reader = new StringReader(s);
        LexStream stream = new LexStream(reader);
        String ans = "IDENT(0, 0, 1, x)\n" +
                "EQ(0, 2, 4)\n" +
                "IDENT(0, 5, 6, x)\n" +
                "SEMICOLON(0, 6, 7)\n" +
                "IDENT(0, 8, 9, x)\n" +
                "GEQ(0, 10, 12)\n" +
                "IDENT(0, 13, 14, x)\n" +
                "SEMICOLON(0, 14, 15)\n" +
                "IDENT(0, 16, 17, x)\n" +
                "LEQ(0, 18, 20)\n" +
                "IDENT(0, 21, 22, x)\n";
        assertEquals(ans, streamToString(stream));
        s = "+ - * / % < > != && ||";
        reader = new StringReader(s);
        stream = new LexStream(reader);
        ans = "PLUS(0, 0, 1)\n" +
                "MINUS(0, 2, 3)\n" +
                "MUL(0, 4, 5)\n" +
                "DIV(0, 6, 7)\n" +
                "REM(0, 8, 9)\n" +
                "LS(0, 10, 11)\n" +
                "GT(0, 12, 13)\n" +
                "NEQ(0, 14, 16)\n" +
                "AND(0, 17, 19)\n" +
                "OR(0, 20, 22)\n";
        assertEquals(ans, streamToString(stream));
    }

    @Test
    public void testIfElse() {
        String s = "if (false) then x;\nelse y;";
        StringReader reader = new StringReader(s);
        LexStream stream = new LexStream(reader);
        String ans = "KW_IF(0, 0, 2)\n" +
                "LEFT_PAREN(0, 3, 4)\n" +
                "FALSE(0, 4, 9)\n" +
                "RIGHT_PAREN(0, 9, 10)\n" +
                "KW_THEN(0, 11, 15)\n" +
                "IDENT(0, 16, 17, x)\n" +
                "SEMICOLON(0, 17, 18)\n" +
                "KW_ELSE(1, 0, 4)\n" +
                "IDENT(1, 5, 6, y)\n" +
                "SEMICOLON(1, 6, 7)\n";
        assertEquals(ans, streamToString(stream));
    }

    @Test
    public void testCommentary() {
        String s = "//8u90878uhewnfjregfhuwiejfbuwqhefneru+-";
        StringReader reader = new StringReader(s);
        LexStream stream = new LexStream(reader);
        String ans = "COMMENT(0, 0, 40)\n";
        assertEquals(ans, streamToString(stream));
    }

    @Test
    public void testAlmostMatching() {
        String s = "e el els i t th the d w wh whi whil tr tru f fa fal fals b be beg begi" +
                " en r re rea wr wri writ";
        StringReader reader = new StringReader(s);
        LexStream stream = new LexStream(reader);
        String ans = "IDENT(0, 0, 1, e)\n" +
                "IDENT(0, 2, 4, el)\n" +
                "IDENT(0, 5, 8, els)\n" +
                "IDENT(0, 9, 10, i)\n" +
                "IDENT(0, 11, 12, t)\n" +
                "IDENT(0, 13, 15, th)\n" +
                "IDENT(0, 16, 19, the)\n" +
                "IDENT(0, 20, 21, d)\n" +
                "IDENT(0, 22, 23, w)\n" +
                "IDENT(0, 24, 26, wh)\n" +
                "IDENT(0, 27, 30, whi)\n" +
                "IDENT(0, 31, 35, whil)\n" +
                "IDENT(0, 36, 38, tr)\n" +
                "IDENT(0, 39, 42, tru)\n" +
                "IDENT(0, 43, 44, f)\n" +
                "IDENT(0, 45, 47, fa)\n" +
                "IDENT(0, 48, 51, fal)\n" +
                "IDENT(0, 52, 56, fals)\n" +
                "IDENT(0, 57, 58, b)\n" +
                "IDENT(0, 59, 61, be)\n" +
                "IDENT(0, 62, 65, beg)\n" +
                "IDENT(0, 66, 70, begi)\n" +
                "IDENT(0, 71, 73, en)\n" +
                "IDENT(0, 74, 75, r)\n" +
                "IDENT(0, 76, 78, re)\n" +
                "IDENT(0, 79, 82, rea)\n" +
                "IDENT(0, 83, 85, wr)\n" +
                "IDENT(0, 86, 89, wri)\n" +
                "IDENT(0, 90, 94, writ)\n";
        assertEquals(ans, streamToString(stream));
    }

    @Test(expected = NoSuchLexemeException.class)
    public void testException() {
        String s = "=,";
        StringReader reader = new StringReader(s);
        LexStream stream = new LexStream(reader);
        Main.print(stream);
    }

}
