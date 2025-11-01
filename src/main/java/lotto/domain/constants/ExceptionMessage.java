package lotto.domain.constants;

public enum ExceptionMessage {
    INVALID_LOTTO_NUMBER_COUNT(String.format("로또 번호는 %d개여야 합니다.", LottoConstant.LOTTO_SIZE)),
    DUPLICATED_LOTTO_NUMBER("로또 번호는 중복될 수 없습니다"),
    INVALID_LOTTO_NUMBER_RANCE(String.format("로또 번호는 %d부터 %d 사이의 숫자여야 합니다."
            , LottoConstant.LOTTO_MIN_RANGE, LottoConstant.LOTTO_MAX_RANGE)),
    DUPLICATED_BONUS_NUMBER("보너스 번호는 로또 번호와 중복될 수 없습니다."),
    INVALID_MONEY_UNIT(String.format("구매 금액은 %d 단위여야 합니다.", LottoConstant.LOTTO_PRICE)),
    INVALID_MONEY_RANCE(String.format("로또는 %d ~ %d 범위로 구매할 수 있습니다."
            , LottoConstant.MIN_LOTTO_COUNT, LottoConstant.MAX_LOTTO_COUNT)),
    INVALID_NUMBER_INPUT_FORMAT("숫자만 입력해야 합니다."),
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
