package lotto.domain;

import java.util.List;
import java.util.Map;
import lotto.domain.dto.LottoBuyResultDto;
import lotto.domain.dto.LottoResultDto;

public class LottoGame {
    private Lottos lottos;
    private WinningLotto winningLotto;

    public LottoGame() {
        this.winningLotto = new WinningLotto();
    }

    public void buy(int money) {
        lottos = LottoMachine.buy(money);
    }

    public LottoResultDto getResults() {
        LottoResults lottoResults = lottos.getResults(winningLotto);

        Map<Prize, Integer> results = lottoResults.getResults();
        double profit = lottoResults.getProfit();

        return LottoResultDto.from(results, profit);
    }

    public LottoBuyResultDto getBuyResult() {
        int size = lottos.size();
        List<Lotto> lottoInfos = lottos.getLottos();

        return LottoBuyResultDto.from(size, lottoInfos);
    }

    public void setWinningNumber(List<Integer> numbers) {
        winningLotto.setLotto(numbers);
    }

    public void setBonusNumber(int bonusNumber) {
        winningLotto.setBonusNumber(bonusNumber);
    }
}
