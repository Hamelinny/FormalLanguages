package types;

import static types.Utils.*;

public class Delimiter extends Lexeme {
    private DelimiterTypes name;
    public Delimiter(int line, int start, int end, DelimiterTypes name) {
        super(line, start, end);
        this.name = name;
    }

    @Override
    public String name() {
        return name.toString();
    }

    @Override
    public String additional() {
        return EMPTY_STRING;
    }
}
