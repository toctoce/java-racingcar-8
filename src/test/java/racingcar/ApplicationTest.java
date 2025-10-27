package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("""
                            pobi :\s
                            woni :\s
                            """, "최종 우승자 : pobi, woni");
                },
                STOP, STOP
        );
    }

    @Test
    void 기능_테스트2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("""
                            pobi : -
                            woni :\s
                            """, "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 기능_테스트3() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("""
                            pobi :\s
                            woni : -
                            """, "최종 우승자 : woni");
                },
                STOP, MOVING_FORWARD
        );
    }

    @Test
    void 기능_테스트4() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("""
                            pobi : -
                            woni : -
                            """, "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 기능_테스트5() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("a,b,c", "5");
                    assertThat(output()).contains("""
                            실행 결과
                            a : -
                            b : -
                            c :\s
                            
                            a : --
                            b : -
                            c :\s
                            
                            a : --
                            b : --
                            c :\s
                            
                            a : --
                            b : --
                            c :\s
                            
                            a : ---
                            b : ---
                            c :\s
                            """, "최종 우승자 : a, b");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP, STOP,
                STOP, MOVING_FORWARD, STOP,
                STOP, STOP, STOP,
                MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"aaaaaa,a", "a,,aa", "a,abcdef"})
    void 이름은_한글자_이상_다섯글자_이하가_아니면_에러O(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input, "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "2147483648"})
    void 양수가_아니거나_정수범위_밖이면_에러O(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a", input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @ParameterizedTest
    @CsvSource(value = {
            "A,B,C;10",
            "AAAAA;10",
            "AAAAA,BBBBB;10",
            "a,b,c,d,e,f,g,h,i,j,k,l,m,n;10",
            "a;10",
            "a;1",
            "a;2",
            "a;10000"
    }, delimiter = ';')
    void 올바른_입력이_들어오면_에러X(String input1, String input2) {
        assertRandomNumberInRangeTest(
                () -> {
                    run(input1, input2);
                },
                MOVING_FORWARD, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
