package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public final class RandomNumberGenerator {
    private static final int RANGE_START = 0;
    private static final int RANGE_END = 0;

    // 객체 생성 방지
    private RandomNumberGenerator() {}

    public static int generate() {
        return Randoms.pickNumberInRange(RANGE_START, RANGE_END);
    }
}
