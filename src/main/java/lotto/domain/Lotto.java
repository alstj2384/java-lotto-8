package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.validator.LottoValidator;

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

    private void validate(List<Integer> numbers) {
        LottoValidator.validateSize(numbers);
        LottoValidator.validateIsDuplicated(numbers);
        LottoValidator.validateRange(numbers);
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
}
