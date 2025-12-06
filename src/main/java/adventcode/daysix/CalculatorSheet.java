package adventcode.daysix;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class CalculatorSheet {


    private final List<LineCalculation> listOfCalculationLine;

    public CalculatorSheet(String sheet) {
        String[][] calculatorSheet = sheet.lines()
                .map(String::trim)
                .map(str -> str.split("\\s+"))
                .toArray(String[][]::new);

        listOfCalculationLine = new ArrayList<>(calculatorSheet[0].length);

        for (int j = 0; j < calculatorSheet[0].length; j++) {

            int finalJ = j;

            List<Long> listOfNumber = IntStream.range(0, calculatorSheet.length - 1)
                    .mapToLong(index -> Long.valueOf(calculatorSheet[index][finalJ]))
                    .boxed()
                    .toList();

            listOfCalculationLine.add(
                    new LineCalculation(listOfNumber, calculatorSheet[calculatorSheet.length - 1][j]));
        }
    }


    public Long calculate() {
        return listOfCalculationLine.stream()
                .mapToLong(LineCalculation::calculate)
                .sum();
    }
}
