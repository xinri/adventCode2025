package adventcode.ex1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RotateRightTest {

    @ParameterizedTest
    @CsvSource({"0,3,3", "5,5,10", "99,1,0", "99,4,3", "5,505,10"})
    public void should_rotate_with_a_modulo_100(int currentNumber, int numberToRotate, int expectNumber) {
        RotateRight sut = new RotateRight(currentNumber, numberToRotate);
        int result = sut.rotate();
        assertThat(result).isEqualTo(expectNumber);
    }

    @ParameterizedTest
    @CsvSource({"0,3,false", "5,5,false", "99,1,true", "99,4,false", "36,63,false", "36,64,true", "5, 505,false"})
    public void should_return_true_when_point_at_0(int currentNumber, int numberToRotate, boolean expectResult) {
        RotateRight sut = new RotateRight(currentNumber, numberToRotate);
        boolean result = sut.isDialPointAt0();
        assertThat(result).isEqualTo(expectResult);
    }

    @ParameterizedTest
    @CsvSource({"0,3,0", "5,5,0", "99,1,1", "99,4,1", "36,63,0", "36,64,1", "5,505,5"})
    public void should_return_true_when_through_at_0(int currentNumber, int numberToRotate, int expectResult) {
        RotateRight sut = new RotateRight(currentNumber, numberToRotate);
        int result = sut.numberPassThrough0();
        assertThat(result).isEqualTo(expectResult);
    }
}