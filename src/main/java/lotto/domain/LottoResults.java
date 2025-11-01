package lotto.domain;

import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.constants.LottoConstant;

public class LottoResults {
    private final Map<Prize, Integer> results;

    public LottoResults(Map<Prize, Integer> results) {
        this.results = results;
    }

    public long getTotalPrice() {
        long sum = 0;
        for (Entry<Prize, Integer> prizeIntegerEntry : results.entrySet()) {
            sum += prizeIntegerEntry.getKey().getPrizeMoney() * prizeIntegerEntry.getValue();
        }
        return sum;
    }

    public double getProfit() {
        System.out.println(getTotalPrice());
        System.out.println((double) (getSize() * LottoConstant.LOTTO_PRICE));
        return (getTotalPrice() / (double) (getSize() * LottoConstant.LOTTO_PRICE)) * 100;
    }

    private int getSize() {
        return results.values().stream()
                .reduce(0, Integer::sum);
    }

    public Map<Prize, Integer> getResults() {
        return results;
    }
}
