package lotto.util;

import java.util.Arrays;
import java.util.List;

public class CsvParser {
    private static final String DELIMITER = ",";

    private CsvParser() {
    }

    public static List<Integer> parseToInt(String input) {
        String[] values = splitByDelimiter(input);
        return toIntegerList(values);
    }

    private static String[] splitByDelimiter(String input){
        return input.split(DELIMITER);
    }

    private static List<Integer> toIntegerList(String[] values){
        return Arrays.stream(values)
                .map(String::strip)
                .map(IntegerParser::parseStringToInt)
                .toList();
    }


}
