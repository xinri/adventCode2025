package adventcode.dayeight;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.byLessThan;

class JunctionBoxTest {

    @ParameterizedTest
    @CsvSource({"10,10,13,3", "1,2,5,13"})
    void should_return_distance_with_another_junction_box(Long xToCompare, Long yToCompare, Long zToCompare, Double expectedResult) {
        JunctionBox junctionBox = new JunctionBox(10L, 10L, 10L);
        JunctionBox junctionBoxToCompare = new JunctionBox(xToCompare, yToCompare, zToCompare);

        double result = junctionBox.calculateDistanceWith(junctionBoxToCompare);
        assertThat(result).isCloseTo(expectedResult, byLessThan(0.1));
    }
}