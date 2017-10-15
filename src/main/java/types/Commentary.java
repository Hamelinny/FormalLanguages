package types;

import static types.Utils.*;

public class Commentary extends Lexeme {
    public Commentary(int line, int start, int end) {
        super(line, start, end);
    }

    @Override
    public String name() {
        return "COMMENT";
    }

    @Override
    public String additional() {
        return EMPTY_STRING;
    }
}
