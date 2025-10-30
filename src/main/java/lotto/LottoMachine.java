package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constants.ExceptionMessage;

public class LottoMachine {
    public static final int MIN_LOTTO_COUNT = 1;
    public static final int MAX_LOTTO_COUNT = 1000000;
    public static final int LOTTO_PRICE = 1000;

    public List<Lotto> buy(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MONEY_UNIT.getMessage(LOTTO_PRICE));
        }

        int amount = money / 1000;

        if (amount < 1 || amount > 1000000) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MONEY_UNIT.getMessage(MIN_LOTTO_COUNT,
                    MAX_LOTTO_COUNT));
        }

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money / 1000; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto);
        }
        return lottos;
    }
}
