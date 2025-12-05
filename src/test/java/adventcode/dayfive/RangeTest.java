package adventcode.dayfive;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RangeTest {

    @ParameterizedTest
    @CsvSource({"11-22,11", "50-750, 700", "1234-4567,3333"})
    void should_count_number_in_the_range(String input, Long expectedValue) {
        Range range = new Range(input);
        assertThat(range.count()).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @CsvSource({"11-22,12-21,true", "11-22,20-21,true", "11-22,21-22,true",  "11-22,22-23,false", "11-22,10-11,false",
            "11-22,11-12,true", "11-22,10-23,false"})
    void should_return_if_completely_inside(String existingOne, String sut, Boolean expectResult) {
        Range existingRange = new Range(existingOne);
        Range sutRange = new Range(sut);

        assertThat(sutRange.isCompletelyIncluded(existingRange)).isEqualTo(expectResult);
    }

    @ParameterizedTest
    @CsvSource({"11-22,5-11,false", "11-22,5-10,false", "11-22,22-23,false",  "11-22,23-100,false", "11-22,12-20,false",
            "11-22,5-9,true", "11-22,24-100,true"/*, "11-22,10-23,true"*/})
    void should_return_if_cannot_be_fused(String existingOne, String sut, Boolean expectResult) {
        Range existingRange = new Range(existingOne);
        Range sutRange = new Range(sut);

        assertThat(sutRange.cannotBeFused(existingRange)).isEqualTo(expectResult);
    }

    @ParameterizedTest
    @CsvSource({"11-22,5-11,5-22", "11-22,5-10,5-22", "11-22,22-23,11-23",  "11-22,23-100,11-100",
            "11-22,12-23,11-23"})
    void should_return_the_new_range_when_it_can_be_fused(String existingOne, String sut, String expectResult) {
        Range existingRange = new Range(existingOne);
        Range sutRange = new Range(sut);

        Range result = sutRange.newMergedRange(existingRange);
        Range expectedRange = new Range(expectResult);
        assertThat(result).isEqualTo(expectedRange);
    }

}