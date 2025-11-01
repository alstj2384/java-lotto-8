package lotto;

import java.util.EnumMap;
import java.util.Map;
import lotto.domain.LottoResults;
import lotto.domain.Prize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoResultsTest {
    @Test
    void 로또_결과_합계_금액_구하기() {
        Map<Prize, Integer> results = new EnumMap<>(Prize.class);

        results.put(Prize.FIRST, 1);
        results.put(Prize.SECOND, 1);
        results.put(Prize.THIRD, 1);
        results.put(Prize.FOURTH, 1);
        results.put(Prize.FIFTH, 1);
        results.put(Prize.LOSE, 0);

        LottoResults lottoResults = new LottoResults(results);

        long totalPrice = lottoResults.getTotalPrice();

        Assertions.assertThat(totalPrice).isEqualTo(2000000000 + 30000000 + 1500000 + 50000 + 5000);
    }

}
