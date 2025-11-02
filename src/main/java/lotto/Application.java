package lotto;

import lotto.domain.LottoGame;
import lotto.presentation.InputView;
import lotto.presentation.LottoGameApp;
import lotto.presentation.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoGame lottoGame = new LottoGame();

        LottoGameApp lottoGameApp = new LottoGameApp(inputView, outputView, lottoGame);
        lottoGameApp.run();
    }
}
