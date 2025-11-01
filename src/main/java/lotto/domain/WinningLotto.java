package lotto.domain;

import java.util.List;
import lotto.domain.constants.ExceptionMessage;
import lotto.domain.constants.LottoConstant;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(List<String> numbers, int bonusNumber) {
        validateNumberRange(bonusNumber);
        this.lotto = new Lotto(toIntegerList(numbers));
        validateIsDuplicated(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public WinningLotto(Lotto lotto, int bonusNumber) {
        validateNumberRange(bonusNumber);
        this.lotto = lotto;
        validateIsDuplicated(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private List<Integer> toIntegerList(List<String> numbers) {
        return numbers.stream()
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateNumberRange(int bonusNumber) {
        if (bonusNumber < LottoConstant.LOTTO_MIN_RANGE || bonusNumber > LottoConstant.LOTTO_MAX_RANGE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER_RANCE.getMessage());
        }
    }

    private void validateIsDuplicated(int bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_BONUS_NUMBER.getMessage());
        }
    }

}
