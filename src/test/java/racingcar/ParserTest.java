package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class ParserTest {

    @Test
    void 자동차_이름_입력되면_이름_리스트로_반환해야한다() {
        // given
        String input = "a,b,ccccc,ddddd";

        // when
        List<String> nameList = Parser.carNamesInputToNameList(input);

        // then
        assertThat(nameList).isEqualTo(List.of("a", "b", "ccccc", "ddddd"));
    }

    @Test
    void 이름은_알파벳으로_구성된다() {
        // given
        String input = "a_a";

        // when, then
        assertThatThrownBy(() -> Parser.carNamesInputToNameList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_CAR_NAME.getMessage());
    }

    @Test
    void 이름은_5글자_이하이다() {
        // given
        String input = "aaaaaa";

        // when, then
        assertThatThrownBy(() -> Parser.carNamesInputToNameList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_CAR_NAME.getMessage());
    }

    @Test
    void String을_int로_올바르게_변환한다() {
        // given
        String input1 = "1";
        String input2 = "10000";
        String input3 = "2147483647";

        // when
        int i1 = Parser.stringToInt(input1);
        int i2 = Parser.stringToInt(input2);
        int i3 = Parser.stringToInt(input3);

        // then
        assertThat(i1).isEqualTo(1);
        assertThat(i2).isEqualTo(10000);
        assertThat(i3).isEqualTo(2147483647);
    }
    @Test
    void 음수와_0은_입력될_수_없다() {
        // given
        String input1 = "-1";
        String input2 = "0";

        // when, then
        assertThatThrownBy(() -> Parser.stringToInt(input1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_POSITIVE_NUMBER.getMessage());
        assertThatThrownBy(() -> Parser.stringToInt(input2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_POSITIVE_NUMBER.getMessage());
    }

    @Test
    void 정수_범위를_초과할_수_없다() {

        // given
        String input3 = "2147483648";

        // when, then
        assertThatThrownBy(() -> Parser.stringToInt(input3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_AN_INTEGER.getMessage());
    }

    @Test
    void 올바른_이름_검증() {
        // given
        String name1 = "a";
        String name2 = "aaaaa";
        String name3 = "AAAAA";

        // when, then
        Parser.validateName(name1);
        Parser.validateName(name2);
        Parser.validateName(name3);
    }

    @Test
    void 잘못된_이름_검증() {
        // given
        String name1 = "aaaaaa";
        String name2 = "aaa_";
        String name3 = "박";


        // when, then
        assertThatThrownBy(() -> Parser.validateName(name1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_CAR_NAME.getMessage());
        assertThatThrownBy(() -> Parser.validateName(name2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_CAR_NAME.getMessage());
        assertThatThrownBy(() -> Parser.validateName(name3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_CAR_NAME.getMessage());
    }

}