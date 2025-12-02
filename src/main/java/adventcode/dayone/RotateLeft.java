package adventcode.dayone;

public class RotateLeft {

    private final int currentNumber;
    private final int numberToRotate;

    public RotateLeft(int currentNumber, int numberToRotate) {
        this.currentNumber = currentNumber;
        this.numberToRotate = numberToRotate;
    }

    public int rotate() {
        int result = (currentNumber - numberToRotate) % 100;
        if (result < 0) {
            result += 100;
        }
        return result;
    }

    public boolean isDialPointAt0() {
        return rotate() == 0;
    }

    public int numberPassThrough0() {
        int result = 0;
        int newCalculation = currentNumber - numberToRotate;
        if (currentNumber != 0 && newCalculation <= 0) result++;
        result += Math.floorDiv(Math.abs(newCalculation), 100);
        return result;
    }
}
