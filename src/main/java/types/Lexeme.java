package types;

public abstract class Lexeme {
    private int line;
    private int start;
    private int end;

    public Lexeme(int line, int start, int end) {
        this.line = line;
        this.start = start;
        this.end = end;
    }

    public abstract String name();
    public abstract String additional();

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name())
                .append("(")
                .append(Integer.toString(line))
                .append(", ")
                .append(Integer.toString(start))
                .append(", ")
                .append(Integer.toString(end));
        if (!additional().isEmpty()) {
                builder.append(", ")
                        .append(additional());
        }
        builder.append(")");
        return builder.toString();
    }
}
