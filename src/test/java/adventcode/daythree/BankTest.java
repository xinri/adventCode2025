package adventcode.daythree;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class BankTest {

    @Test
    void should_return_818181911112111_when_requesting_the_same_representation_from_a_Bank() {
        Bank bank = new Bank("818181911112111");
        assertThat(bank.toString()).isEqualTo("818181911112111");
    }

    @ParameterizedTest
    @CsvSource({"987654321111111,98", "811111111111119,89", "891111111111111,91",
            "234234234234278,78", "818181911112111,92", "11111922222988888922229,99",
            "777777777911312114,94", "000000000000,0", "11111111111111,11", "11111111111121,21",
            "11111111111112,12", "11111111111119,19", "11111511111119,59"})
    void should_return_max_output_when_finding_max_values(String batteries, long expectedResult) {
        Bank bank = new Bank(batteries);
        assertThat(bank.calculateMaxOutputVoltage()).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource({"987654321111111,987654321111", "811111111111119,811111111119",
            "234234234234278,434234234278", "818181911112111,888911112111"})
    void should_return_max_output_when_finding_max_values_with_twelve_digit(String batteries, long expectedResult) {
        Bank bank = new Bank(batteries);
        assertThat(bank.calculateMaxOutputVoltageWithTwelveDigits()).isEqualTo(expectedResult);
    }
}