package lotto.domain.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.constants.ExceptionMessage;
import lotto.domain.constants.LottoConstant;

public class LottoValidator {
    private LottoValidator() {
    }

    public static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.LOTTO_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    public static void validateIsDuplicated(List<Integer> numbers) {
        Set<Integer> uniqueValues = new HashSet<>(numbers);

        if (uniqueValues.size() != numbers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_LOTTO_NUMBER.getMessage());
        }
    }

    public static void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(LottoValidator::isOutOfRange)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER_RANCE.getMessage());
        }
    }

    private static boolean isOutOfRange(Integer number) {
        return number < LottoConstant.LOTTO_MIN_RANGE || number > LottoConstant.LOTTO_MAX_RANGE;
    }
}
