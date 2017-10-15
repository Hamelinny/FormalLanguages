package types;

public class Identifier extends Lexeme {
    private String nameOfIdent;
    public Identifier(int line, int start, int end, String name) {
        super(line, start, end);
        this.nameOfIdent = name;
    }

    @Override
    public String name() {
        return "IDENT";
    }

    @Override
    public String additional() {
        return nameOfIdent;
    }
}
