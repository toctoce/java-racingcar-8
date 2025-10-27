package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarManagerTest {

    private final CarManager carManager = new CarManager();

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void carManager_정상동작_검증() {
        assertRandomNumberInRangeTest(
                () -> {
                    // given
                    carManager.makeAllCars(List.of("a", "b", "c"));

                    // when
                    carManager.operateAllCars();
                    StepResult stepResult1 = carManager.makeStepResult();

                    carManager.operateAllCars();
                    StepResult stepResult2 = carManager.makeStepResult();

                    FinalResult finalResult = carManager.makeFinalResult();

                    // then
                    assertThat(stepResult1.toString()).isEqualTo("""
                            a : -
                            b : -
                            c :\s""");
                    assertThat(stepResult2.toString()).isEqualTo("""
                            a : --
                            b : -
                            c :\s""");
                    assertThat(finalResult.toString()).isEqualTo("""
                            a""");
                },
            MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, STOP
        );
    }
}