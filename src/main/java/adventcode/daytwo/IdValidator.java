package adventcode.daytwo;

import java.util.Arrays;
import java.util.stream.IntStream;

public final class IdValidator {

    private IdValidator() throws IllegalAccessException {
        throw new IllegalAccessException("should not be able to access this contructor");
    }

    public static boolean isInvalid(long id) {
        String valueInString = String.valueOf(id);
        int lengthOfWord = valueInString.length();
        if (lengthOfWord % 2 != 0) return false;

        int middle = Math.floorDiv(lengthOfWord, 2);

        return IntStream.range(0, middle)
                .filter(i -> valueInString.charAt(i) != valueInString.charAt(middle + i))
                .findAny().isEmpty();
    }

    public static boolean isMultipleTimeInvalid(long id) {
        String valueInString = String.valueOf(id);
        return checkInvalidInFrameOf(valueInString, 1) ||
                checkInvalidInFrameOf(valueInString, 2) ||
                checkInvalidInFrameOf(valueInString, 3) ||
                checkInvalidInFrameOf(valueInString, 4) ||
                checkInvalidInFrameOf(valueInString, 5) ||
                checkInvalidInFrameOf(valueInString, 6) ||
                checkInvalidInFrameOf(valueInString, 7) ||
                checkInvalidInFrameOf(valueInString, 8) ||
                checkInvalidInFrameOf(valueInString, 9);
    }

    private static boolean checkInvalidInFrameOf(String valueInString, int frame) {
        String[] result = valueInString.split("(?<=\\G.{" + frame + "})");
        if (result.length == 1) {
            return false;
        }
        return Arrays.stream(result).allMatch(value -> result[0].equals(value));
    }
}
