package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @Test
    void 무작위로_생성된_숫자가_0이상_9이하이다() {
        // given
        int randomNumber  = RandomNumberGenerator.generate();

        // when, then
        assertThat(randomNumber).isBetween(0, 9);
    }

}