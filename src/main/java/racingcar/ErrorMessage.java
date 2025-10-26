package racingcar;

public enum ErrorMessage {
    INVALID_FORMAT("입력 형식이 잘못되었습니다."),
    INVALID_CAR_NAME("이름 형식이 잘못되었습니다. 1~5글자의 알파벳으로 작성해주세요."),
    NOT_AN_INTEGER("정수로 변환할 수 없습니다. 2147483647보다 작은 수의 숫자만 입력해주세요."),
    NOT_POSITIVE_NUMBER("음수나 0은 입력될 수 없습니다. 양수를 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}