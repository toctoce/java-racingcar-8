package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputReader {

    private static final String GET_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";
    private static final String GET_ATTEMPT_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?\n";

    public String readCarNames() {
        System.out.print(GET_NAME_MESSAGE);
        return Console.readLine();
    }

    public String readAttemptCount() {
        System.out.print(GET_ATTEMPT_COUNT_MESSAGE);
        return Console.readLine();
    }

}