package adventcode.dayeight;

public class JunctionBox {
    private final Long x;
    private final Long y;
    private final Long z;

    public JunctionBox(Long x, Long y, Long z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double calculateDistanceWith(JunctionBox junctionBoxToCompare) {
        return Math.sqrt(Math.pow(x - junctionBoxToCompare.getX(), 2) +
                Math.pow(y - junctionBoxToCompare.getY(), 2) +
                Math.pow(z - junctionBoxToCompare.getZ(), 2));
    }

    public Long getX() {
        return x;
    }

    public Long getY() {
        return y;
    }

    public Long getZ() {
        return z;
    }
}
