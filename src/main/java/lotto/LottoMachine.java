package lotto;

import java.util.List;
import java.util.stream.IntStream;
import lotto.constants.ExceptionMessage;

public class LottoMachine {
    public static final int MIN_LOTTO_COUNT = 1;
    public static final int MAX_LOTTO_COUNT = 1000000;
    public static final int LOTTO_PRICE = 1000;

    private final LottoNumberGenerator numberGenerator;

    public LottoMachine(LottoNumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> buy(int money) {
        int amount = validate(money);

        return IntStream.range(0, amount)
                .mapToObj(i -> new Lotto(numberGenerator.generateNumbers()))
                .toList();
    }

    private int validate(int money) {
        validateMoneyUnit(money);
        int amount = getLottoAmount(money);
        validateAmountRange(amount);
        return amount;
    }

    private void validateMoneyUnit(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MONEY_UNIT.getMessage(LOTTO_PRICE));
        }
    }

    private int getLottoAmount(int money) {
        return money / LOTTO_PRICE;
    }

    private void validateAmountRange(int amount) {
        if (amount < MIN_LOTTO_COUNT || amount > MAX_LOTTO_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MONEY_UNIT.getMessage(MIN_LOTTO_COUNT,
                    MAX_LOTTO_COUNT));
        }
    }

}
