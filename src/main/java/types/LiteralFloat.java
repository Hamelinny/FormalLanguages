package types;

public class LiteralFloat extends Lexeme {
    private double val;
    public LiteralFloat(int line, int start, int end, double val) {
        super(line, start, end);
        this.val = val;
    }

    @Override
    public String name() {
        return "FLOAT";
    }

    @Override
    public String additional() {
        return Double.toString(val);
    }
}
