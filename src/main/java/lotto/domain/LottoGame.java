package lotto.domain;

import java.util.List;
import java.util.Map;
import lotto.domain.dto.LottoBuyResultDto;
import lotto.domain.dto.LottoResultDto;

public class LottoGame {
    private Lottos lottos;
    private WinningLotto winningLotto;

    public void purchaseLottos(int money) {
        lottos = LottoMachine.purchase(money);
    }

    public LottoResultDto calculateResults() {
        LottoResults lottoResults = lottos.getResults(winningLotto);

        Map<Prize, Integer> results = lottoResults.results();
        double profit = lottoResults.profitRate();

        return new LottoResultDto(results, profit);
    }

    public LottoBuyResultDto getPurchasedLottos() {
        int size = lottos.size();
        List<Lotto> lottoInfos = lottos.getLottos();

        return new LottoBuyResultDto(size, lottoInfos);
    }

    public void registerWinningLotto(List<Integer> numbers, int bonus) {
        this.winningLotto = new WinningLotto(numbers, bonus);
    }
}
