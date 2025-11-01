package lotto.constants;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;

public enum ExceptionMessage {
    INVALID_LOTTO_NUMBER_COUNT(String.format("로또 번호는 %d개여야 합니다.", Lotto.LOTTO_SIZE)),
    DUPLICATED_LOTTO_NUMBER("로또 번호는 중복될 수 없습니다"),
    INVALID_LOTTO_NUMBER_RANCE(String.format("로또 번호는 %d부터 %d 사이의 숫자여야 합니다.", Lotto.LOTTO_MIN_RANGE, Lotto.LOTTO_MAX_RANGE)),
    DUPLICATED_BONUS_NUMBER("보너스 번호는 로또 번호와 중복될 수 없습니다."),
    INVALID_MONEY_UNIT(String.format("구매 금액은 %d 단위여야 합니다.", LottoMachine.LOTTO_PRICE)),
    INVALID_MONEY_FORMAT("구매 금액은 숫자만 입력할 수 있습니다."),
    INVALID_MONEY_RANCE(String.format("로또는 %d ~ %d 범위로 구매할 수 있습니다.", LottoMachine.MIN_LOTTO_COUNT, LottoMachine.MAX_LOTTO_COUNT)),
    ;

    private static final String EXCEPTION_PREFIX = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return EXCEPTION_PREFIX + message;
    }
}
