package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// 입출력 검증(NsTest.java 코드 활용)
class InputReaderTest {
    private PrintStream standardOut;
    private InputStream standardIn;
    private OutputStream captor;

    private InputReader inputReader;

    @BeforeEach
    protected final void setup() {
        standardOut = System.out;
        standardIn = System.in;

        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
        inputReader = new InputReader();
    }

    @AfterEach
    protected final void printOutput() {
        System.setOut(standardOut);
        System.setIn(standardIn);
        System.out.println(output());
        Console.close();
    }

    protected final String output() {
        return captor.toString().trim();
    }

    void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    void 자동차_이름_입력시_메시지_호출해야한다() {
        // given
        setInput("\n");

        // when
        inputReader.readCarNames();

        // then
        assertThat(output()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    void 시도_회수_입력시_메시지_호출해야한다() {
        // given
        setInput("\n");

        // when
        inputReader.readAttemptCount();

        // then
        assertThat(output()).contains("시도할 횟수는 몇 회인가요?");
    }


    @Test
    void 입력_검증() {
        // given
        setInput("A,B,C\n");

        // when
        String input = inputReader.readCarNames();

        // then
        assertThat(input).isEqualTo("A,B,C");
    }
}