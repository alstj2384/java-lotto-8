package lotto;

import java.util.List;
import lotto.constants.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningLottoTest {

    @Test
    @DisplayName("로또 번호와 보너스 번호가 중복되면 예외가 발생한다")
    void 로또_번호와_보너스_번호가_중복되면_예외가_발생한다() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 45);
        int bonusNumber = 1;

        // when & then
        Assertions.assertThatThrownBy(() -> new WinningLotto(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.DUPLICATED_BONUS_NUMBER.getMessage());
    }

    @DisplayName("보너스 번호는 1~45 사이의 숫자여야 한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 보너스_번호는_1부터_45_사이의_숫자여야_한다(int bonusNumber) {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // when & then
        Assertions.assertThatThrownBy(() -> new WinningLotto(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_LOTTO_NUMBER_RANCE.getMessage());
    }
}
