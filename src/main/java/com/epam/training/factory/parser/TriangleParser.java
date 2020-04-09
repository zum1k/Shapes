package com.epam.training.factory.parser;

import java.util.ArrayList;
import java.util.List;

public class TriangleParser {
    private static final String REG_EXP_CHECKER = "^(\\s[-]?\\d{1,10}+){6}";
    private static final String SPACE_DELINATOR = " ";
    private static final String SPACE_REG_EXP = "\\s+";

    public List<String> parseStrings(List<String> strings) {
        List<String> parsedLines = new ArrayList<>();
        for (String string : strings) {
            String result = string.trim();
            result = result.replaceAll(SPACE_REG_EXP, SPACE_DELINATOR);
            if (result.matches(REG_EXP_CHECKER)) {
                parsedLines.add(result);
            }
        }
        return parsedLines;
    }
}
