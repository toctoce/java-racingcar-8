package racingcar;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Parser {

    private static final Pattern NAME_PATTERN = Pattern.compile("[a-zA-Z]{1,5}");

    public static List<String> carNamesInputToNameList(String input) {
        String[] nameArray;

        try {
            nameArray = input.split(",");
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FORMAT.getMessage());
        }

        List<String> nameList = List.of(nameArray);
        nameList.forEach(name -> validateName(name));

        return nameList;
    }

    public static void validateName(String name) {
        Matcher matcher = NAME_PATTERN.matcher(name);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME.getMessage());
        }
    }

    public static int stringToInt(String input) {
        int number;

        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_AN_INTEGER.getMessage());
        }

        if (number <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE_NUMBER.getMessage());
        }

        return number;
    }
}
