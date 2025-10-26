package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputWriterTest {
    private PrintStream standardOut;
    private OutputStream captor;

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @BeforeEach
    protected final void init() {
        standardOut = System.out;

        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    protected final void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
        Console.close();
    }

    protected final String output() {
        return captor.toString();
    }
    @Test
    void 중간_결과_출력() {
        assertRandomNumberInRangeTest(
            () -> {

                // given
                Car car1 = new Car("A");
                Car car2 = new Car("B");
                List<Car> cars = List.of(car1, car2);

                List<StepResult> stepResults = new ArrayList<>();
                stepResults.add(new StepResult(cars));

                car1.operate();
                car2.operate();
                stepResults.add(new StepResult(cars));

                // when
                OutputWriter.writeStepResult(stepResults);

                // then
                assertThat(output()).contains("""
                        실행 결과
                        A :\s
                        B :\s
                        
                        A : -
                        B :\s
                        """);
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 우승자_한_명_최종_결과_출력() {
        assertRandomNumberInRangeTest(
                () -> {

                    // given
                    Car car1 = new Car("A");
                    Car car2 = new Car("B");
                    List<Car> cars = List.of(car1, car2);

                    car1.operate();
                    car2.operate();
                    FinalResult finalResult = new FinalResult(cars);

                    // when
                    OutputWriter.writeFinalResult(finalResult);

                    // then
                    assertThat(output()).contains("""
                        최종 우승자 : A""");
                },
                MOVING_FORWARD, STOP
        );
    }
    @Test
    void 우승자_두_명_최종_결과_출력() {
        assertRandomNumberInRangeTest(
                () -> {

                    // given
                    Car car1 = new Car("A");
                    Car car2 = new Car("B");
                    List<Car> cars = List.of(car1, car2);

                    car1.operate();
                    car2.operate();
                    FinalResult finalResult = new FinalResult(cars);

                    // when
                    OutputWriter.writeFinalResult(finalResult);

                    // then
                    assertThat(output()).contains("""
                        최종 우승자 : A, B""");
                },
                STOP, STOP
        );
    }
}