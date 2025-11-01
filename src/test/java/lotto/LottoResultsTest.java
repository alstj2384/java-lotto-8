package lotto;

import lotto.domain.LottoResults;
import lotto.domain.Prize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoResultsTest {
    @Test
    void 로또_결과_합계_금액_구하기() {
        LottoResults results = new LottoResults();

        results.put(Prize.FIRST);
        results.put(Prize.SECOND);
        results.put(Prize.THIRD);
        results.put(Prize.FOURTH);
        results.put(Prize.FIFTH);

        long totalPrice = results.getTotalPrice();

        Assertions.assertThat(totalPrice).isEqualTo(2000000000 + 30000000 + 1500000 + 50000 + 5000);
    }

}
