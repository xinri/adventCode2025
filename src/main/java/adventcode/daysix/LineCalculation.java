package adventcode.daysix;

import java.util.List;

public class LineCalculation {
    private final List<Long> listOfNumber;
    private final String operator;

    public LineCalculation(List<Long> listOfNumber, String operator) {
        this.listOfNumber = listOfNumber;
        this.operator = operator;
    }

    public Long calculate() {
        // please use switch case
        Long result = 0L;
        if ("+".equals(operator)) {
            result = listOfNumber.stream().reduce(0L, Long::sum);
        } else if ("*".equals(operator)) {
            result = listOfNumber.stream().reduce(1L, (a, b) -> a * b);
        }
        return result;
    }
}
