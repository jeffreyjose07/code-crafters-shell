package utility;

import java.util.ArrayList;
import java.util.List;

public class InputParser {
    private InputParser() {}

    public static String[] parse(String input) {
        List<String> tokens = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        int i = 0;

        while (i < input.length()) {
            char c = input.charAt(i);

            if (c == '\'' || c == '"') {
                i = consumeQuoted(c, input, i + 1, current);
            } else if (c == ' ') {
                if (!current.isEmpty()) {
                    tokens.add(current.toString());
                    current.setLength(0);
                }
            } else {
                current.append(c);
            }

            i++;
        }

        if (!current.isEmpty()) {
            tokens.add(current.toString());
        }

        return tokens.toArray(String[]::new);
    }

    private static int consumeQuoted(char quote, String input, int start, StringBuilder current) {
        int i = start;
        while (i < input.length() && input.charAt(i) != quote) {
            current.append(input.charAt(i));
            i++;
        }
        return i;
    }
}
