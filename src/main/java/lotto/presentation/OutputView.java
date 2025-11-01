package lotto.presentation;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Prize;

public class OutputView {
    private static final String INPUT_AMOUNT_GUIDANCE = "구매금액을 입력해 주세요.";
    private static final String PURCHASE_AMOUNT_GUIDANCE = "%d개를 구매했습니다.";
    private static final String INPUT_LOTTO_NUMBER_GUIDANCE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_GUIDANCE = "보너스 번호를 입력해 주세요.";
    private static final String RESULT_STATISTICS_GUIDANCE = "당첨 통계\n---";
    private static final String PRINT_PROFIT = "총 수익률은 %.1f%%입니다.";

    public void printInputMoneyAmount() {
        println(INPUT_AMOUNT_GUIDANCE);
    }

    public void printPurchaseAmountInfo(int amount) {
        println(String.format(PURCHASE_AMOUNT_GUIDANCE, amount));
    }

    public void printLottoInfos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            println(lotto.numbers().toString());
        }
    }

    public void printInputLottoNumberGuidance() {
        println(INPUT_LOTTO_NUMBER_GUIDANCE);
    }

    public void printInputBonusNumberGuidance() {
        println(INPUT_BONUS_NUMBER_GUIDANCE);
    }

    public void printResultStatistics(Map<Prize, Integer> result) {
        println(RESULT_STATISTICS_GUIDANCE);
        println("3개 일치 (5,000원) - " + result.get(Prize.FIFTH) + "개");
        println("4개 일치 (50,000원) - " + result.get(Prize.FOURTH) + "개");
        println("5개 일치 (1,500,000원) - " + result.get(Prize.THIRD) + "개");
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.get(Prize.SECOND) + "개");
        println("6개 일치 (2,000,000,000원) - " + result.get(Prize.FIRST) + "개");
    }

    public void printTotalProfit(double profit) {
        println(String.format(PRINT_PROFIT, profit));
    }

    public void printExceptionMessage(String message) {
        println(message);
    }

    private void println(String input) {
        System.out.println(input);
    }
}
