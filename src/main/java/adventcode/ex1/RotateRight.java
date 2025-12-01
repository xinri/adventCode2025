package adventcode.ex1;

public class RotateRight {

    private final int currentNumber;
    private final int numberToRotate;

    public RotateRight(int currentNumber, int numberToRotate) {
        this.currentNumber = currentNumber;
        this.numberToRotate = numberToRotate;
    }


    public int rotate() {
        return (currentNumber + numberToRotate) % 100;
    }

    public boolean isDialPointAt0() {
        return rotate() == 0;
    }

    public int numberPassThrough0() {
        return Math.floorDiv(currentNumber + numberToRotate, 100);
    }
}
