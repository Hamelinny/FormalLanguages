package types;

import static types.Utils.*;

public class LiteralBool extends Lexeme {
    private LiteralBoolTypes name;
    public LiteralBool(int line, int start, int end, LiteralBoolTypes name) {
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
