package lexer;

import java.io.*;
import java.util.stream.Stream;

public class Main {
    public static String print(LexStream tokens) {
        StringBuilder builder = new StringBuilder();
        while (tokens.hasNext()) {
            builder.append(tokens.next());
            builder.append("\n");
        }
        return builder.toString();
    }

    public static void main(String[] args) {

        LexStream stream = null;
        try {
            stream = new LexStream(new FileReader(new File(args[0])));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileWriter writer = new FileWriter(new File(args[1]));
            String s = print(stream);
            writer.write(s);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
