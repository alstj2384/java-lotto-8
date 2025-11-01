package lotto.presentation;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getLine() {
        return readLine();
    }

    private String readLine() {
        return Console.readLine();
    }
}
