package lotto.domain;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = List.copyOf(lottos);
    }

    public LottoResults getResults(WinningLotto winningLotto) {
        LottoResults lottoResults = new LottoResults();

        for (Lotto lotto : lottos) {
            Prize result = lotto.getResult(winningLotto);
            lottoResults.add(result);
        }
        return lottoResults;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int size() {
        return lottos.size();
    }
}
