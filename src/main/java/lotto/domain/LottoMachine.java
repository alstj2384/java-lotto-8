package lotto.domain;

import java.util.stream.IntStream;
import lotto.domain.constants.LottoConstant;
import lotto.domain.validator.LottoMachineValidator;

public class LottoMachine {
    public static Lottos purchase(int money) {
        int amount = validate(money);

        return new Lottos(IntStream.range(0, amount)
                .mapToObj(i -> new Lotto(RandomLottoNumberGenerator.generate()))
                .toList());
    }

    private static int validate(int money) {
        LottoMachineValidator.validateMoneyUnit(money);
        int amount = getLottoAmount(money);
        LottoMachineValidator.validateAmountRange(amount);
        return amount;
    }

    private static int getLottoAmount(int money) {
        return money / LottoConstant.LOTTO_PRICE;
    }
}
