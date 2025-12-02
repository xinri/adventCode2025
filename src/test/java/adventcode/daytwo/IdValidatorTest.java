package adventcode.daytwo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class IdValidatorTest {

    @ParameterizedTest
    @CsvSource({"11,true", "22,true", "12,false", "1188511885,true", "99,true", "1010,true", "123123,true", "1231234,false",
    "446446,true", "38593859,true", "1001,false", "101,false"})
    void should_return_true_when_id_is_repeated_twice_otherwise_false(long id, boolean expectedResult) {
        boolean result = IdValidator.isInvalid(id);
        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource({"11,true", "22,true", "12,false", "1188511885,true", "99,true", "1010,true", "123123,true", "1231234,false",
    "446446,true", "38593859,true", "1001,false", "101,false", "111,true", "999,true", "1188511885,true", "2121212121,true",
    "10121012,true", "1012101310121013,true", "1012101310131012,false", "2121212112,false", "102103102103, true",
    "999,true", "222222,true", "111111111111111,true"})
    void should_return_true_when_id_is_repeated_multiple_time_otherwise_false(long id, boolean expectedResult) {
        boolean result = IdValidator.isMultipleTimeInvalid(id);
        assertThat(result).isEqualTo(expectedResult);
    }
}