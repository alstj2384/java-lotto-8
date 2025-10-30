package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constants.ExceptionMessage;

public class Lotto {
    public static final int LOTTO_MAX_RANGE = 45;
    public static final int LOTTO_MIN_RANGE = 1;
    public static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateIsDuplicated(numbers);
        validateNumberRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    private void validateIsDuplicated(List<Integer> numbers) {
        Set<Integer> uniqueValues = new HashSet<>(numbers);

        if (uniqueValues.size() != numbers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_LOTTO_NUMBER.getMessage());
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(this::validateNumberRange)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER_RANCE.getMessage());
        }
    }

    private boolean validateNumberRange(Integer number) {
        return number < LOTTO_MIN_RANGE || number > LOTTO_MAX_RANGE;
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

}
