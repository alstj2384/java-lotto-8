package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.constants.ExceptionMessage;
import lotto.domain.constants.LottoConstant;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortNumbers(numbers);
    }

    public Prize getResult(WinningLotto winningLotto) {
        int count = getMatchCount(winningLotto.getLotto());
        boolean hasBonusNumber = numbers.contains(winningLotto.getBonusNumber());

        return Prize.getPrize(count, hasBonusNumber);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public List<Integer> numbers() {
        return numbers;
    }

    private List<Integer> sortNumbers(List<Integer> target) {
        List<Integer> numbers = new ArrayList<>(target);
        numbers.sort(Integer::compareTo);
        return List.copyOf(numbers);
    }

    private int getMatchCount(Lotto target) {
        return (int) target.numbers.stream()
                .filter(numbers::contains)
                .count();
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateIsDuplicated(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.LOTTO_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    private void validateIsDuplicated(List<Integer> numbers) {
        Set<Integer> uniqueValues = new HashSet<>(numbers);

        if (uniqueValues.size() != numbers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_LOTTO_NUMBER.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(this::isOutOfRanges)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER_RANCE.getMessage());
        }
    }

    private boolean isOutOfRanges(Integer number) {
        return number < LottoConstant.LOTTO_MIN_RANGE || number > LottoConstant.LOTTO_MAX_RANGE;
    }
}
