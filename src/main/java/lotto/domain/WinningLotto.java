package lotto.domain;

import java.util.List;
import lotto.domain.validator.LottoValidator;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        LottoValidator.validateWinningLotto(numbers, bonusNumber);

        this.lotto = new Lotto(numbers);
        this.bonusNumber = bonusNumber;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
