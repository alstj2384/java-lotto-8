package lotto;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.LottoResults;
import lotto.domain.Lottos;
import lotto.domain.Prize;
import lotto.domain.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottosTest {
    private static final List<Integer> WINNING_LOTTO_NUMBERS = List.of(1, 2, 3, 4, 5, 6);
    private static final int WINNING_BONUS_NUMBER = 45;
    private static final Lotto FIRST_PRICE_LOTTO = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    private static final Lotto SECOND_PRICE_LOTTO = new Lotto(List.of(1, 2, 3, 4, 5, WINNING_BONUS_NUMBER));
    private static final Lotto THIRD_PRICE_LOTTO = new Lotto(List.of(1, 2, 3, 4, 5, 16));
    private static final Lotto FOURTH_PRICE_LOTTO = new Lotto(List.of(1, 2, 3, 4, 15, 16));
    private static final Lotto FIFTH_PRICE_LOTTO = new Lotto(List.of(1, 2, 3, 14, 15, 16));
    private static final Lotto LOSE_PRICE_LOTTO = new Lotto(List.of(11, 12, 13, 14, 15, 16));

    @DisplayName("모든 로또 당첨 결과를 반환해야 한다")
    @ParameterizedTest
    @MethodSource("provideSuccessLottoResult")
    void 모든_로또_당첨_결과를_반환해야_한다(List<Lotto> lottoList, List<Integer> prizes) {
        // given
        WinningLotto winningLotto = new WinningLotto(WINNING_LOTTO_NUMBERS, WINNING_BONUS_NUMBER);

        Lottos lottos = new Lottos(lottoList);
        LottoResults lottoResults = lottos.getResults(winningLotto);

        // when & then
        int i = 0;
        for (Prize prize : lottoResults.results().keySet()) {
            Assertions.assertThat(lottoResults.results().get(prize)).isEqualTo(prizes.get(i));
            i++;
        }
    }

    static Stream<Arguments> provideSuccessLottoResult() {
        return Stream.of(
                Arguments.of(List.of(
                        FIRST_PRICE_LOTTO,
                        SECOND_PRICE_LOTTO,
                        THIRD_PRICE_LOTTO,
                        FOURTH_PRICE_LOTTO,
                        FIFTH_PRICE_LOTTO,
                        LOSE_PRICE_LOTTO,
                        LOSE_PRICE_LOTTO,
                        LOSE_PRICE_LOTTO
                ), List.of(1, 1, 1, 1, 1, 3)),
                Arguments.of(List.of(
                        FIRST_PRICE_LOTTO,
                        SECOND_PRICE_LOTTO,
                        SECOND_PRICE_LOTTO,
                        SECOND_PRICE_LOTTO,
                        LOSE_PRICE_LOTTO,
                        LOSE_PRICE_LOTTO,
                        LOSE_PRICE_LOTTO,
                        LOSE_PRICE_LOTTO
                ), List.of(1, 3, 0, 0, 0, 4)),
                Arguments.of(List.of(
                        LOSE_PRICE_LOTTO,
                        LOSE_PRICE_LOTTO,
                        LOSE_PRICE_LOTTO,
                        LOSE_PRICE_LOTTO
                ), List.of(0, 0, 0, 0, 0, 4))
        );
    }
}
