package utils;

import java.util.Objects;

public class Cell<E> {
    private final E value;
    private final Coordinate coordinate;
    private final Cell<E> upperCell;
    private final Cell<E> leftCell;
    private final Cell<E> belowCell;
    private final Cell<E> rightCell;

    public Cell(int indexRow, int indexColumn, E value) {
        this.coordinate = new Coordinate(indexRow, indexColumn);
        this.value = value;
        this.upperCell = null;
        this.leftCell = null;
        this.belowCell = null;
        this.rightCell = null;
    }

    public Cell(Coordinate coordinate, E value, Cell<E> upperCell, Cell<E> leftCell, Cell<E> belowCell, Cell<E> rightCell) {
        this.coordinate = coordinate;
        this.value = value;
        this.upperCell = upperCell;
        this.leftCell = leftCell;
        this.belowCell = belowCell;
        this.rightCell = rightCell;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Cell<?> cell)) return false;
        return Objects.equals(value, cell.value) && Objects.equals(getCoordinate(), cell.getCoordinate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, getCoordinate());
    }

    public Cell<E> update(Cell<E> up, Cell<E> left, Cell<E> down, Cell<E> right) {
        return new Cell<>(coordinate, value, up, left, down, right);
    }

    public Cell<E> getUpperCell() {
        return upperCell;
    }

    public Cell<E> getLeftCell() {
        return leftCell;
    }

    public Cell<E> getBelowCell() {
        return belowCell;
    }

    public Cell<E> getRightCell() {
        return rightCell;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }
}
