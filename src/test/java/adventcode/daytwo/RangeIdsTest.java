package adventcode.daytwo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RangeIdsTest {

    @ParameterizedTest
    @CsvSource({"11-22,11,22", " 1188511880-1188511890,1188511880,1188511890", "998-1012 ,998,1012"})
    void should_create_range_id_from_string(String rawData, long expectStart, long expectEnd) {
        RangeIds rangeIds = new RangeIds(rawData);
        assertThat(rangeIds.getStart()).isEqualTo(expectStart);
        assertThat(rangeIds.getEnd()).isEqualTo(expectEnd);
    }

    @ParameterizedTest
    @MethodSource("argumentForInvalidIds")
    void should_find_list_invalid_ids_when_executing_nominal_cases(String rawData, List<Long> expectedInvalidId) {
        RangeIds rangeIds = new RangeIds(rawData);
        assertThat(rangeIds.getInvalidIds()).containsExactly(expectedInvalidId.toArray(Long[]::new));
    }

    public static Stream<Arguments> argumentForInvalidIds() {
        return Stream.of(
                Arguments.of("11-22", List.of(11L, 22L)),
                Arguments.of("95-115", List.of(99L)),
                Arguments.of("1188511880-1188511890", List.of(1188511885L)),
                Arguments.of("222220-222224", List.of(222222L)),
                Arguments.of("1698522-1698528", List.of()),
                Arguments.of("446443-446449", List.of(446446L)),
                Arguments.of("38593856-38593862", List.of(38593859L)),
                Arguments.of("565653-565659", List.of()),
                Arguments.of("824824821-824824827", List.of()),
                Arguments.of("2121212118-2121212124", List.of())
        );
    }

    @ParameterizedTest
    @MethodSource("argumentForSumInvalidIds")
    void should_sum_invalid_ids_when_executing_nominal_cases(String rawData, long expectedSumInvalidIds) {
        RangeIds rangeIds = new RangeIds(rawData);
        assertThat(rangeIds.sumInvalidIds()).isEqualTo(expectedSumInvalidIds);
    }

    public static Stream<Arguments> argumentForSumInvalidIds() {
        return Stream.of(
                Arguments.of("11-22", 33),
                Arguments.of("95-115", 99),
                Arguments.of("1188511880-1188511890", 1188511885),
                Arguments.of("222220-222224", 222222),
                Arguments.of("1698522-1698528", 0),
                Arguments.of("446443-446449", 446446),
                Arguments.of("38593856-38593862", 38593859),
                Arguments.of("565653-565659", 0),
                Arguments.of("824824821-824824827", 0),
                Arguments.of("2121212118-2121212124", 0)
        );
    }
}