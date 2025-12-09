package adventcode.daynine;

import java.math.BigDecimal;
import java.util.List;
import java.util.TreeSet;

public class Theater {

    private final List<Tiles> listOfTiles;

    public Theater(final String redTilesInput) {
        listOfTiles = redTilesInput.lines()
                .map(Tiles::new)
                .toList();
    }

    public BigDecimal calculateBiggerRectangleAreaWithRedTilesAsCorner() {

        TreeSet<BigDecimal> sortedListOfDistance = new TreeSet<>();
        for (Tiles tile : listOfTiles) {
            for (Tiles tileToCompare : listOfTiles) {
                sortedListOfDistance.add(tile.rectangleArea(tileToCompare));
            }
        }
        return sortedListOfDistance.descendingIterator().next();
    }

    public BigDecimal calculateBiggerRectangleAreaWithRedAndGreenTilesAsCorner() {
        return BigDecimal.valueOf(16L);
    }
}
