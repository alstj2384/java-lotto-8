package lotto.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.constants.LottoConstant;

public class LottoResults {
    private final Map<Prize, Integer> results;

    public LottoResults() {
        results = new EnumMap<>(Prize.class);
        init();
    }

    public void add(Prize prize) {
        int prevCount = results.get(prize);
        results.put(prize, prevCount + 1);
    }

    public long totalPrice() {
        long sum = 0;
        for (Entry<Prize, Integer> prizeIntegerEntry : results.entrySet()) {
            sum += prizeIntegerEntry.getKey().getPrizeMoney() * prizeIntegerEntry.getValue();
        }
        return sum;
    }

    public double profitRate() {
        return (totalPrice() / (double) (getLottoCount() * LottoConstant.LOTTO_PRICE)) * 100;
    }

    public Map<Prize, Integer> results() {
        return Collections.unmodifiableMap(results);
    }

    private int getLottoCount() {
        return results.values().stream()
                .reduce(0, Integer::sum);
    }

    private void init() {
        results.put(Prize.FIRST, 0);
        results.put(Prize.SECOND, 0);
        results.put(Prize.THIRD, 0);
        results.put(Prize.FOURTH, 0);
        results.put(Prize.FIFTH, 0);
        results.put(Prize.LOSE, 0);
    }
}
