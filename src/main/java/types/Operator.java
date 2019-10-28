package types;

import static types.Utils.*;

public class Operator extends Lexeme {
    private OperatorTypes name;
    public Operator(int line, int start, int end, OperatorTypes name) {
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
