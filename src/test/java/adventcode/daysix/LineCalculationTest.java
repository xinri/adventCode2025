package adventcode.daysix;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LineCalculationTest {

    @ParameterizedTest
    @MethodSource("listOfArgumentForCalculation")
    void should_return_result_by_adding_or_multiplying_each_element_of_the_list(List<Long> listToCalculate, String operator, Long expectedResult) {
        LineCalculation lineCalculation = new LineCalculation(listToCalculate, operator);
        Long result = lineCalculation.calculate();
        assertThat(result).isEqualTo(expectedResult);
    }

    public static Stream<Arguments> listOfArgumentForCalculation() {
        return Stream.of(
                Arguments.of(List.of(1L, 2L, 3L, 4L), "+", 10L),
                Arguments.of(List.of(1L, 1L, 1L, 1L), "+", 4L),
                Arguments.of(List.of(0L, 0L, 0L, 0L), "+", 0L),
                Arguments.of(List.of(1000L, 2L, 2000L, 4L), "+", 3006L),
                Arguments.of(List.of(1L, 2L, 3L, 4L), "*", 24L),
                Arguments.of(List.of(1L, 1L, 1L, 1L), "*", 1L),
                Arguments.of(List.of(15L, 20L, 4000L, 0L), "*", 0L),
                Arguments.of(List.of(9000L, 0L, 1000L, 6L), "*", 0L),
                Arguments.of(List.of(0L, 0L, 0L, 0L), "*", 0L)
        );
    }
}