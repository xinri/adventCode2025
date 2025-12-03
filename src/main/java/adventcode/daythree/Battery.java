package adventcode.daythree;

public class Battery {
    private final int joltage;
    private final int position;

    public Battery(int joltage, int position) {
        this.joltage = joltage;
        this.position = position;
    }

    public int getJoltage() {
        return joltage;
    }

    public int getPosition() {
        return position;
    }
}
