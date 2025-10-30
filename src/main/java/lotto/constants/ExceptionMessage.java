package lotto.constants;

public enum ExceptionMessage {
    INVALID_LOTTO_NUMBER_COUNT("로또 번호는 6개여야 합니다."),
    DUPLICATED_LOTTO_NUMBER("로또 번호는 중복될 수 없습니다"),
    INVALID_LOTTO_NUMBER_RANCE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
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
