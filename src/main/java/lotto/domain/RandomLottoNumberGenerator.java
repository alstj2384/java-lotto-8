package lotto.domain;

import static lotto.domain.constants.LottoConstant.LOTTO_MAX_RANGE;
import static lotto.domain.constants.LottoConstant.LOTTO_MIN_RANGE;
import static lotto.domain.constants.LottoConstant.LOTTO_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {
    @Override
    public List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_RANGE, LOTTO_MAX_RANGE, LOTTO_SIZE);
    }
}
