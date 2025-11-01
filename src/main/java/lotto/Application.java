package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResults;
import lotto.domain.Lottos;
import lotto.domain.RandomLottoNumberGenerator;
import lotto.domain.WinningLotto;
import lotto.presentation.InputView;
import lotto.presentation.OutputView;
import lotto.util.CsvParser;
import lotto.util.IntegerParser;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        Lottos buy = inputMoney(inputView, outputView);
        List<Lotto> lottos1 = buy.getLottos();
        outputView.printPurchaseAmountInfo(lottos1.size());
        outputView.printLottoInfos(buy);

        Lotto lotto = getLotto(inputView, outputView);

        int bonusNumber = getBonusNumber(inputView, outputView);

        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        LottoResults results = buy.getResults(winningLotto);
        double totalPrice = results.getProfit();

        outputView.printResultStatistics(results.getResults());
        outputView.printTotalProfit(totalPrice);
    }

    private static int getBonusNumber(InputView inputView, OutputView outputView) {
        while (true) {
            try {
                outputView.printInputBonusNumberGuidance();
                String bonusNumberString = inputView.getLine();
                return IntegerParser.parseStringToInt(bonusNumberString);
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e.getMessage());
            }
        }
    }

    private static Lotto getLotto(InputView inputView, OutputView outputView) {
        while (true) {
            try {
                outputView.printInputLottoNumberGuidance();
                String lottos = inputView.getLine();
                List<Integer> parsed = CsvParser.parseToInt(lottos);
                return new Lotto(parsed);
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e.getMessage());
            }
        }
    }

    private static Lottos inputMoney(InputView inputView, OutputView outputView) {
        while (true) {
            try {
                outputView.printInputMoneyAmount();
                String moneyString = inputView.getLine();
                int money = IntegerParser.parseStringToInt(moneyString);
                LottoMachine lottoMachine = new LottoMachine(new RandomLottoNumberGenerator());
                return lottoMachine.buy(money);
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e.getMessage());
            }
        }
    }
}
