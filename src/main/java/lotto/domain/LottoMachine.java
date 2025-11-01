package lotto.domain;

import java.util.stream.IntStream;
import lotto.domain.constants.ExceptionMessage;
import lotto.domain.constants.LottoConstant;

public class LottoMachine {
    private final LottoNumberGenerator numberGenerator;

    public LottoMachine(LottoNumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Lottos buy(int money) {
        int amount = validate(money);

        return new Lottos(IntStream.range(0, amount)
                .mapToObj(i -> new Lotto(numberGenerator.generateNumbers()))
                .toList());
    }

    private int validate(int money) {
        validateMoneyUnit(money);
        int amount = getLottoAmount(money);
        validateAmountRange(amount);
        return amount;
    }

    private void validateMoneyUnit(int money) {
        if (money % LottoConstant.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MONEY_UNIT.getMessage());
        }
    }

    private int getLottoAmount(int money) {
        return money / LottoConstant.LOTTO_PRICE;
    }

    private void validateAmountRange(int amount) {
        if (amount < LottoConstant.MIN_LOTTO_COUNT || amount > LottoConstant.MAX_LOTTO_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MONEY_RANCE.getMessage());
        }
    }

}
