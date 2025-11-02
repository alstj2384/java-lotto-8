package lotto;

import java.util.stream.Stream;
import lotto.domain.Prize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PrizeTest {
    @DisplayName("조건에 맞는 등수가 결정되어야 한다")
    @ParameterizedTest
    @MethodSource("provideConditions")
    void 조건에_맞는_등수가_결정되어야_한다(int condition, boolean hasBonusNumber, Prize expected) {
        Assertions.assertThat(Prize.getPrize(condition, hasBonusNumber)).isEqualTo(expected);
    }

    static Stream<Arguments> provideConditions() {
        return Stream.of(
                Arguments.of(6, false, Prize.FIRST),
                Arguments.of(6, true, Prize.FIRST),
                Arguments.of(5, true, Prize.SECOND),
                Arguments.of(5, false, Prize.THIRD),
                Arguments.of(4, false, Prize.FOURTH),
                Arguments.of(4, true, Prize.FOURTH),
                Arguments.of(3, false, Prize.FIFTH),
                Arguments.of(3, true, Prize.FIFTH),
                Arguments.of(2, false, Prize.LOSE),
                Arguments.of(1, false, Prize.LOSE),
                Arguments.of(0, false, Prize.LOSE)
        );
    }
}
