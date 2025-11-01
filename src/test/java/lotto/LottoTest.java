package lotto;

import static lotto.domain.constants.ExceptionMessage.DUPLICATED_LOTTO_NUMBER;
import static lotto.domain.constants.ExceptionMessage.INVALID_LOTTO_NUMBER_COUNT;
import static lotto.domain.constants.ExceptionMessage.INVALID_LOTTO_NUMBER_RANCE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {
    @Test
    @DisplayName("생성 테스트")
    void 정상적인_로또_번호로_생성할_수_있다() {
        // give & when
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // then
        assertThat(lotto.numbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LOTTO_NUMBER_COUNT.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATED_LOTTO_NUMBER.getMessage());
    }

    @ParameterizedTest
    @MethodSource("provideOutOfRanceLottoNumbers")
    @DisplayName("범위가 벗어난 숫자가 있으면 예외가 발생한다.")
    void 범위를_벗어난_숫자가_있으면_예외가_발생한다(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LOTTO_NUMBER_RANCE.getMessage());
    }

    static Stream<List<Integer>> provideOutOfRanceLottoNumbers() {
        return Stream.of(
                List.of(0, 1, 2, 3, 4, 5),
                List.of(1, 2, 3, 4, 5, 46)
        );
    }

    @Test
    @DisplayName("생성된 로또는 오름차순으로 정렬되어야 한다")
    void 생성된_로또는_오름차순으로_정렬되어야_한다() {
        // given & when
        Lotto lotto = new Lotto(List.of(6, 5, 4, 3, 2, 1));

        // then
        assertThat(lotto.numbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
