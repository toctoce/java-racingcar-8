package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @Test
    void 무작위로_생성된_숫자_검증() {
        // given
        int randomNumber  = RandomNumberGenerator.generate();

        // when, then
        assertThat(randomNumber).isBetween(0, 9);
    }

}