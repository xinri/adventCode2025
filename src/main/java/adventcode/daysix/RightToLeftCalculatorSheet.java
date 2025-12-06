package adventcode.daysix;

import java.util.ArrayList;
import java.util.List;

public class RightToLeftCalculatorSheet {

    private final List<LineCalculation> listOfCalculationLine;

    public RightToLeftCalculatorSheet(String sheet) {
        char[][] calculatorSheet = sheet.lines()
                .map(String::toCharArray)
                .toArray(char[][]::new);

        listOfCalculationLine = new ArrayList<>(calculatorSheet[0].length);

        List<Long> listOfNumberToCalculate = new ArrayList<>();
        for(int j = calculatorSheet[0].length - 1; j >= 0; j--) {

            String concatNumber = "";
            for (int i = 0; i < calculatorSheet.length; i++) {
                Character c = calculatorSheet[i][j];
                if (!c.equals(' ')) {
                    if (c.equals('*') || c.equals('+')) {
                        listOfNumberToCalculate.add(Long.valueOf(concatNumber));
                        listOfCalculationLine.add(new LineCalculation(listOfNumberToCalculate, String.valueOf(c)));
                        listOfNumberToCalculate = new ArrayList<>();
                        concatNumber = "";
                        break;
                    }
                    concatNumber = concatNumber + c;
                }
            }
            if (!concatNumber.isEmpty()) {
                listOfNumberToCalculate.add(Long.valueOf(concatNumber));
            }
        }
    }

    public Long calculate() {
        return listOfCalculationLine.stream()
                .mapToLong(LineCalculation::calculate)
                .sum();
    }
}
