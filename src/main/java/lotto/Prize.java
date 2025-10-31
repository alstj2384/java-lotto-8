package lotto;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Prize {
    FIRST(2_000_000_000, (condition, isRequire) -> condition == 6),
    SECOND(30_000_000, (condition, isRequire) -> condition == 5 && isRequire),
    THIRD(1_500_000, (condition, isRequire) -> condition == 5 && !isRequire),
    FOURTH(50_000, (condition, isRequire) -> condition == 4),
    FIFTH(5_000, (condition, isRequire) -> condition == 3),
    LOSE(0, (condition, isRequire) -> condition < 3);

    private final long prizeMoney;
    private final BiPredicate<Integer, Boolean> predicate;

    Prize(long prizeMoney, BiPredicate<Integer, Boolean> predicate) {
        this.prizeMoney = prizeMoney;
        this.predicate = predicate;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public static Prize getPrize(int condition, boolean isRequire) {
        return Arrays.stream(values())
                .filter(prize -> prize.predicate.test(condition, isRequire))
                .findFirst()
                .orElse(LOSE);
    }

}
