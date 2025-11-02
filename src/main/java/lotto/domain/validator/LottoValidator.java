package lotto.domain.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.constants.ExceptionMessage;
import lotto.domain.constants.LottoConstant;

public class LottoValidator {
    private LottoValidator() {
    }

    public static void validateLotto(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateNumberRanges(numbers);
        validateHasUniqueNumbers(numbers);
    }

    public static void validateWinningLotto(List<Integer> numbers, int bonusNumber) {
        validateHasDuplicatedNumber(numbers, bonusNumber);
        validateNumberRange(bonusNumber);
    }

    private static void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.LOTTO_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    private static void validateNumberRanges(List<Integer> numbers) {
        numbers.forEach(LottoValidator::validateNumberRange);
    }

    private static void validateHasUniqueNumbers(List<Integer> numbers) {
        Set<Integer> uniqueValues = new HashSet<>(numbers);

        if (uniqueValues.size() != numbers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_LOTTO_NUMBER.getMessage());
        }
    }

    private static void validateHasDuplicatedNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_BONUS_NUMBER.getMessage());
        }
    }

    private static void validateNumberRange(int number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER_RANCE.getMessage());
        }
    }

    private static boolean isOutOfRange(Integer number) {
        return number < LottoConstant.LOTTO_MIN_RANGE || number > LottoConstant.LOTTO_MAX_RANGE;
    }
}
