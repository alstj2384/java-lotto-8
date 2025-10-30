package lotto;

import java.util.List;
import lotto.constants.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoMachineTest {
    private static final int LOTTO_MAX_PRICE = LottoMachine.MAX_LOTTO_COUNT * LottoMachine.LOTTO_PRICE;
    LottoMachine lottoMachine = new LottoMachine(new RandomLottoNumberGenerator());

    @ParameterizedTest
    @DisplayName("금액이 나누어 떨어지지 않으면 예외가 발생한다")
    @ValueSource(ints = {1001, 2010, 99999})
    void 금액이_나누어_떨어지지_않으면_예외가_발생한다(int money) {
        Assertions.assertThatThrownBy(() -> lottoMachine.buy(money)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_MONEY_UNIT.getMessage(LottoMachine.LOTTO_PRICE));
    }

    @ParameterizedTest
    @DisplayName("정확한 개수의 로또가 생성되어야 한다")
    @ValueSource(ints = {1000, 2000, 5000, LOTTO_MAX_PRICE})
    void 정확한_개수의_로또가_생성되어야_한다(int money) {
        List<Lotto> buy = lottoMachine.buy(money);

        Assertions.assertThat(buy.size()).isEqualTo(money / 1000);
    }

    @ParameterizedTest
    @DisplayName("로또 구매 가능 범위를 벗어나면 예외가 발생한다")
    @ValueSource(ints = {0, LOTTO_MAX_PRICE + LottoMachine.LOTTO_PRICE})
    void 로또_구매_가능_범위를_벗어나면_예외가_발생한다(int money) {
        Assertions.assertThatThrownBy(() -> lottoMachine.buy(money)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_MONEY_UNIT.getMessage(LottoMachine.MIN_LOTTO_COUNT,
                        LottoMachine.MAX_LOTTO_COUNT));
    }

}
