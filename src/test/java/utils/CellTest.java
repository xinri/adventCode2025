package utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CellTest {

    @Test
    void should_get_coordinate_of_the_cell() {
        Cell<String> center = new Cell<>(5, 5, "center");
        Coordinate coordinate = center.getCoordinate();
        assertThat(coordinate).isEqualTo(new Coordinate(5, 5));
    }

    @Test
    void should_have_surrounded_cell_when_calling_the_function_update() {
        Cell<String> center = new Cell<>(5, 5, "center");

        Cell<String> up = new Cell<>(4, 5, "center");
        Cell<String> down = new Cell<>(6, 5, "down");
        Cell<String> left = new Cell<>(5, 4, "left");
        Cell<String> right = new Cell<>(5, 6, "right");

        Cell<String> updated = center.update(up, left, down, right);
        assertThat(updated.getUpperCell()).isEqualTo(up);
        assertThat(updated.getLeftCell()).isEqualTo(left);
        assertThat(updated.getBelowCell()).isEqualTo(down);
        assertThat(updated.getRightCell()).isEqualTo(right);
    }
}