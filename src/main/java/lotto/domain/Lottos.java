package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottoResults getResults(WinningLotto winningLotto) {
        // 로또 받으면 여러 개 비교해서 출력
        Map<Prize, Integer> results = new EnumMap<>(Prize.class);

        // 초기값 설정
        results.put(Prize.FIRST, 0);
        results.put(Prize.SECOND, 0);
        results.put(Prize.THIRD, 0);
        results.put(Prize.FOURTH, 0);
        results.put(Prize.FIFTH, 0);
        results.put(Prize.LOSE, 0);

        for (Lotto lotto : lottos) {
            Prize result = lotto.getResult(winningLotto);

            if (results.get(result) == null) {
                results.put(result, 1);
            } else {
                results.put(result, results.get(result) + 1);
            }
        }
        return new LottoResults(results);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int size() {
        return lottos.size();
    }

}
