package lotto.presentation;

import java.util.List;
import lotto.domain.LottoGame;
import lotto.domain.dto.LottoBuyResultDto;
import lotto.domain.dto.LottoResultDto;
import lotto.util.CsvParser;
import lotto.util.IntegerParser;

public class LottoGameApp {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGame lottoGame;

    public LottoGameApp(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoGame = new LottoGame();
    }

    public void run() {
        inputPurchaseAmount();
        printPurchaseResult();

        inputWinningLottoNumbers();
        inputBonusNumber();

        printResults();
    }

    private void inputPurchaseAmount() {
        while (true) {
            try {
                outputView.printInputMoneyAmount();
                String moneyString = inputView.getUserInput();
                int money = IntegerParser.parse(moneyString);
                lottoGame.purchaseLottos(money);
                return;
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e.getMessage());
            }
        }
    }

    private void printPurchaseResult() {
        LottoBuyResultDto dto = lottoGame.getPurchasedLottos();
        outputView.printPurchaseAmountInfo(dto.size());
        outputView.printLottoInfos(dto.lottos());
    }

    private void inputWinningLottoNumbers() {
        while (true) {
            try {
                outputView.printInputLottoNumberGuidance();
                String input = inputView.getUserInput();
                List<Integer> winningNumbers = CsvParser.parseToInt(input);
                lottoGame.registerWinningNumbers(winningNumbers);
                return;
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e.getMessage());
            }
        }
    }

    private void inputBonusNumber() {
        while (true) {
            try {
                outputView.printInputBonusNumberGuidance();
                String input = inputView.getUserInput();
                int bonusNumber = IntegerParser.parse(input);
                lottoGame.registerBonusNumber(bonusNumber);
                return;
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e.getMessage());
            }
        }
    }

    private void printResults() {
        LottoResultDto dto = lottoGame.calculateResults();
        outputView.printResultStatistics(dto.results());
        outputView.printTotalProfit(dto.profit());
    }
}
