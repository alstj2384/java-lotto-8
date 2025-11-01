package lotto.domain;

import java.util.List;
import lotto.domain.constants.ExceptionMessage;
import lotto.domain.constants.LottoConstant;

public class WinningLotto {
    private Lotto lotto;
    private int bonusNumber;

    public WinningLotto() {
    }

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        validateNumberRange(bonusNumber);
        this.lotto = new Lotto(numbers);
        validateIsDuplicated(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setLotto(List<Integer> numbers) {
        this.lotto = new Lotto(numbers);
    }

    public void setBonusNumber(int bonusNumber) {
        validateNumberRange(bonusNumber);
        validateIsDuplicated(bonusNumber);
        this.bonusNumber = bonusNumber;
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
