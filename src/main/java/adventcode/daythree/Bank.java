package adventcode.daythree;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private final String batteries;
    private final List<Battery> batteryList;

    public Bank(final String batteries) {
        this.batteries = batteries;
        this.batteryList = new ArrayList<>(batteries.length());
        char[] batteryArray = batteries.toCharArray();
        for (int i = 0; i < batteryArray.length; i++) {
            this.batteryList.add(new Battery(Character.getNumericValue(batteryArray[i]), i + 1));
        }
    }

    @Override
    public String toString() {
        return batteries;
    }

    public Long calculateMaxOutputVoltage() {

        int maxIndex = batteries.length() - 1;

        long resultPart1 = -1L;
        long resultPart2 = -1L;

        for (int i = 0; i <= maxIndex; i++) {
            int numericValue = Character.getNumericValue(batteries.charAt(i));
            if (numericValue > resultPart1 && i != maxIndex) {
                resultPart1 = numericValue;
                resultPart2 = -1L;
            } else if (numericValue > resultPart2) {
                resultPart2 = numericValue;
            }
        }

        return (resultPart1 * 10) + resultPart2;
    }

    public Long calculateMaxOutputVoltageWithTwelveDigits() {
        int maxIndex = batteries.length() - 1;

        long resultPart1 = -1L;
        long resultPart2 = -1L;
        long resultPart3 = -1L;
        long resultPart4 = -1L;
        long resultPart5 = -1L;
        long resultPart6 = -1L;
        long resultPart7 = -1L;
        long resultPart8 = -1L;
        long resultPart9 = -1L;
        long resultPart10 = -1L;
        long resultPart11 = -1L;
        long resultPart12 = -1L;

        for (int i = 0; i <= maxIndex; i++) {
            int numericValue = Character.getNumericValue(batteries.charAt(i));
            if (numericValue > resultPart1 && i < maxIndex - 10) {
                resultPart1 = numericValue;
                resultPart2 = -1L;
                resultPart3 = -1L;
                resultPart4 = -1L;
                resultPart5 = -1L;
                resultPart6 = -1L;
                resultPart7 = -1L;
                resultPart8 = -1L;
                resultPart9 = -1L;
                resultPart10 = -1L;
                resultPart11 = -1L;
                resultPart12 = -1L;
            } else if (numericValue > resultPart2 && i < maxIndex - 9) {
                resultPart2 = numericValue;
                resultPart3 = -1L;
                resultPart4 = -1L;
                resultPart5 = -1L;
                resultPart6 = -1L;
                resultPart7 = -1L;
                resultPart8 = -1L;
                resultPart9 = -1L;
                resultPart10 = -1L;
                resultPart11 = -1L;
                resultPart12 = -1L;
            } else if (numericValue > resultPart3 && i < maxIndex - 8) {
                resultPart3 = numericValue;
                resultPart4 = -1L;
                resultPart5 = -1L;
                resultPart6 = -1L;
                resultPart7 = -1L;
                resultPart8 = -1L;
                resultPart9 = -1L;
                resultPart10 = -1L;
                resultPart11 = -1L;
                resultPart12 = -1L;
            } else if (numericValue > resultPart4 && i < maxIndex - 7) {
                resultPart4 = numericValue;
                resultPart5 = -1L;
                resultPart6 = -1L;
                resultPart7 = -1L;
                resultPart8 = -1L;
                resultPart9 = -1L;
                resultPart10 = -1L;
                resultPart11 = -1L;
                resultPart12 = -1L;
            } else if (numericValue > resultPart5 && i < maxIndex - 6) {
                resultPart5 = numericValue;
                resultPart6 = -1L;
                resultPart7 = -1L;
                resultPart8 = -1L;
                resultPart9 = -1L;
                resultPart10 = -1L;
                resultPart11 = -1L;
                resultPart12 = -1L;
            } else if (numericValue > resultPart6 && i < maxIndex - 5) {
                resultPart6 = numericValue;
                resultPart7 = -1L;
                resultPart8 = -1L;
                resultPart9 = -1L;
                resultPart10 = -1L;
                resultPart11 = -1L;
                resultPart12 = -1L;
            } else if (numericValue > resultPart7 && i < maxIndex - 4) {
                resultPart7 = numericValue;
                resultPart8 = -1L;
                resultPart9 = -1L;
                resultPart10 = -1L;
                resultPart11 = -1L;
                resultPart12 = -1L;
            } else if (numericValue > resultPart8 && i < maxIndex - 3) {
                resultPart8 = numericValue;
                resultPart9 = -1L;
                resultPart10 = -1L;
                resultPart11 = -1L;
                resultPart12 = -1L;
            } else if (numericValue > resultPart9 && i < maxIndex - 2) {
                resultPart9 = numericValue;
                resultPart10 = -1L;
                resultPart11 = -1L;
                resultPart12 = -1L;
            } else if (numericValue > resultPart10 && i < maxIndex - 1) {
                resultPart10 = numericValue;
                resultPart11 = -1L;
                resultPart12 = -1L;
            } else if (numericValue > resultPart11 && i < maxIndex) {
                resultPart11 = numericValue;
                resultPart12 = -1L;
            } else if (numericValue > resultPart12) {
                resultPart12 = numericValue;
            }
        }

        return (resultPart1 * 100000000000L) + (resultPart2 * 10000000000L) + (resultPart3 * 1000000000) + (resultPart4 * 100000000) +
                (resultPart5 * 10000000) + (resultPart6 * 1000000) + (resultPart7 * 100000) + (resultPart8 * 10000) + (resultPart9 * 1000) +
                (resultPart10 * 100) + (resultPart11 * 10) + resultPart12;
    }
}
