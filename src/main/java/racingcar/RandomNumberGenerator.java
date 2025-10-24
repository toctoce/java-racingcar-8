package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    private static final int RANGE_START = 0;
    private static final int RANGE_END = 0;

    public static int generate() {
        return Randoms.pickNumberInRange(RANGE_START, RANGE_END);
    }
}
