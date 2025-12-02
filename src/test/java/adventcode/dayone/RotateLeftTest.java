package adventcode.dayone;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RotateLeftTest {

    @ParameterizedTest
    @CsvSource({"0,3,97", "5,5,0", "99,1,98", "99,4,95", "5,100,5", "10,510,0", "10,500,10", "50,68,82"})
    public void should_rotate_with_a_modulo_100(int currentNumber, int numberToRotate, int expectNumber) {
        RotateLeft sut = new RotateLeft(currentNumber, numberToRotate);
        int result = sut.rotate();
        assertThat(result).isEqualTo(expectNumber);
    }

    @ParameterizedTest
    @CsvSource({"0,3,false", "5,5,true", "99,1,false", "99,4,false", "36,63,false", "36,64,false", "10,510,true"})
    public void should_return_true_when_point_at_0(int currentNumber, int numberToRotate, boolean expectResult) {
        RotateLeft sut = new RotateLeft(currentNumber, numberToRotate);
        boolean result = sut.isDialPointAt0();
        assertThat(result).isEqualTo(expectResult);
    }

    @ParameterizedTest
    @CsvSource({"0,3,0", "5,5,1", "99,1,0", "99,4,0", "36,63,1", "36,64,1", "10,510,6", "0,99,0", "1,99,1"})
    public void should_return_true_when_through_at_0(int currentNumber, int numberToRotate, int expectResult) {
        RotateLeft sut = new RotateLeft(currentNumber, numberToRotate);
        int result = sut.numberPassThrough0();
        assertThat(result).isEqualTo(expectResult);
    }
}
