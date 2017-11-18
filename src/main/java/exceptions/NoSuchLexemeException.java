package exceptions;

public class NoSuchLexemeException extends Exception {
    private int line;
    private int column;
    public NoSuchLexemeException(int line, int column) {
        this.line = line;
        this.column = column;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public void printInfo() {
        System.out.println("fail:" + Integer.toString(line) + " line, " +
                Integer.toString(column) + " column");
    }
}
