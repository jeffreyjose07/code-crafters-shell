package utility;

import java.util.ArrayList;
import java.util.List;

public class InputParser {
    private InputParser() {
        /* This utility class should not be instantiated */
    }

    public static String[] parse(String input) {
        List<String> tokens = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        int i = 0;

        while (i < input.length()) {
            char c = input.charAt(i);

            if (c == '\'') {
                i++;
                while (i < input.length() && input.charAt(i) != '\'') {
                    current.append(input.charAt(i));
                    i++;
                }
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
}
