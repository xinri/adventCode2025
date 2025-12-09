package adventcode.daynine;

import java.math.BigDecimal;
import java.util.Objects;

public class Tiles {

    private final Long x;
    private final Long y;

    public Tiles(String str) {
        String[] split = str.split(",");
        x = Long.valueOf(split[0]);
        y = Long.valueOf(split[1]);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Tiles tiles)) return false;
        return Objects.equals(x, tiles.x) && Objects.equals(y, tiles.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public BigDecimal rectangleArea(Tiles tileToCompare) {
        return BigDecimal.valueOf(Math.abs(tileToCompare.y - y + 1)).multiply(
                BigDecimal.valueOf(Math.abs(tileToCompare.x - x + 1)));
    }
}
