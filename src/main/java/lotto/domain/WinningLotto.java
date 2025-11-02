package lotto.domain;

import java.util.List;
import lotto.domain.validator.LottoValidator;

public class WinningLotto {
    private Lotto lotto;
    private int bonusNumber;

    public WinningLotto() {
    }

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        LottoValidator.validateNumberRange(bonusNumber);
        this.lotto = new Lotto(numbers);
        LottoValidator.validateIsDuplicatedBonusNumber(lotto, bonusNumber);
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
        LottoValidator.validateNumberRange(bonusNumber);
        LottoValidator.validateIsDuplicatedBonusNumber(lotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }
}
