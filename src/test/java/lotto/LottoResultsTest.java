package lotto;

import lotto.domain.LottoResults;
import lotto.domain.Prize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoResultsTest {
    @Test
    void 로또_결과_합계_금액_구하기() {
        LottoResults results = new LottoResults();

        results.add(Prize.FIRST);
        results.add(Prize.SECOND);
        results.add(Prize.THIRD);
        results.add(Prize.FOURTH);
        results.add(Prize.FIFTH);

        long totalPrice = results.totalPrice();

        Assertions.assertThat(totalPrice).isEqualTo(2000000000 + 30000000 + 1500000 + 50000 + 5000);
    }

}
