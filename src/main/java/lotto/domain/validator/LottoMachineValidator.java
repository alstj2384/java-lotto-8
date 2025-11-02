package lotto.domain.validator;

import lotto.domain.constants.ExceptionMessage;
import lotto.domain.constants.LottoConstant;

public class LottoMachineValidator {
    private LottoMachineValidator() {
    }

    public static void validateAmountRange(int amount) {
        if (amount < LottoConstant.MIN_LOTTO_COUNT || amount > LottoConstant.MAX_LOTTO_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MONEY_RANCE.getMessage());
        }
    }

    public static void validateMoneyUnit(int money) {
        if (money % LottoConstant.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MONEY_UNIT.getMessage());
        }
    }
}
