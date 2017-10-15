package types;

import static types.Utils.*;

public class KeyWord extends Lexeme {
    private KeyWordTypes name;
    public KeyWord(int line, int start, int end, KeyWordTypes name) {
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
