package lotto.domain;

import java.util.stream.IntStream;
import lotto.domain.constants.ExceptionMessage;
import lotto.domain.constants.LottoConstant;

public class LottoMachine {
    public static Lottos purchase(int money) {
        int amount = validate(money);

        return new Lottos(IntStream.range(0, amount)
                .mapToObj(i -> new Lotto(RandomLottoNumberGenerator.generate()))
                .toList());
    }

    private static int validate(int money) {
        validateMoneyUnit(money);
        int amount = getLottoAmount(money);
        validateAmountRange(amount);
        return amount;
    }

    private static void validateMoneyUnit(int money) {
        if (money % LottoConstant.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MONEY_UNIT.getMessage());
        }
    }

    private static int getLottoAmount(int money) {
        return money / LottoConstant.LOTTO_PRICE;
    }

    private static void validateAmountRange(int amount) {
        if (amount < LottoConstant.MIN_LOTTO_COUNT || amount > LottoConstant.MAX_LOTTO_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MONEY_RANCE.getMessage());
        }
    }
}
