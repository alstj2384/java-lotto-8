package lotto.util;

import lotto.domain.constants.ExceptionMessage;

public class IntegerParser {
    private IntegerParser() {
    }

    public static int parseStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_INPUT_FORMAT.getMessage());
        }
    }
}
