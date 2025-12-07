package utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MatrixTransformerTest {

    @Test
    void should_return_a_matrix_array_from_simple_string_input() {
        final String input = """
                1234.A.S..7890^
                """;

        final MatrixTransformer matrixTransformer = new MatrixTransformer(input);
        char[][] sut = matrixTransformer.getArrayMatrix();
        assertThat(sut).containsExactly(new char[]{'1', '2', '3', '4', '.', 'A', '.', 'S', '.', '.', '7', '8', '9', '0', '^',});
    }

    @Test
    void should_return_a_matrix_array_from_string_input() {
        final String input = """
                .......S.......
                .......|.......
                ......|^.......
                """;

        final MatrixTransformer matrixTransformer = new MatrixTransformer(input);
        char[][] sut = matrixTransformer.getArrayMatrix();
        assertThat(sut).containsExactly(new char[]{'.', '.', '.', '.', '.', '.', '.', 'S', '.', '.', '.', '.', '.', '.', '.',},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '|', '.', '.', '.', '.', '.', '.', '.',},
                new char[]{'.', '.', '.', '.', '.', '.', '|', '^', '.', '.', '.', '.', '.', '.', '.',});
    }

    @Test
    void should_return_inverted_or_transposed_matrix_when_we_have_a_simple_input() {
        final String input = """
                1234.A.S..7890^
                """;

        final MatrixTransformer matrixTransformer = new MatrixTransformer(input);
        char[][] sut = matrixTransformer.getInvertedMatrix();
        assertThat(sut).containsExactly(
                new char[]{'1'},
                new char[]{'2'},
                new char[]{'3'},
                new char[]{'4'},
                new char[]{'.'},
                new char[]{'A'},
                new char[]{'.'},
                new char[]{'S'},
                new char[]{'.'},
                new char[]{'.'},
                new char[]{'7'},
                new char[]{'8'},
                new char[]{'9'},
                new char[]{'0'},
                new char[]{'^'});
    }

    @Test
    void should_return_inverted_or_transposed_matrix_when_we_have_a_input() {
        final String input = """
                .......S.......
                .......|.......
                ......|^.......
                """;

        final MatrixTransformer matrixTransformer = new MatrixTransformer(input);
        char[][] sut = matrixTransformer.getInvertedMatrix();
        assertThat(sut).containsExactly(
                new char[]{'.', '.', '.'},
                new char[]{'.', '.', '.'},
                new char[]{'.', '.', '.'},
                new char[]{'.', '.', '.'},
                new char[]{'.', '.', '.'},
                new char[]{'.', '.', '.'},
                new char[]{'.', '.', '|'},
                new char[]{'S', '|', '^'},
                new char[]{'.', '.', '.'},
                new char[]{'.', '.', '.'},
                new char[]{'.', '.', '.'},
                new char[]{'.', '.', '.'},
                new char[]{'.', '.', '.'},
                new char[]{'.', '.', '.'},
                new char[]{'.', '.', '.'});
    }

    @Test
    void should_return_a_matrix_array_with_cells_from_string_simple_input() {
        final String input = """
                1234.A.S..7890^
                """;

        final MatrixTransformer matrixTransformer = new MatrixTransformer(input);
        Cell<Character>[][] sut = matrixTransformer.getCellMatrix();
        assertThat(sut).containsExactly(new Cell[]{
                new Cell<>(0, 0, '1'),
                new Cell<>(0, 1, '2'),
                new Cell<>(0, 2, '3'),
                new Cell<>(0, 3, '4'),
                new Cell<>(0, 4, '.'),
                new Cell<>(0, 5, 'A'),
                new Cell<>(0, 6, '.'),
                new Cell<>(0, 7, 'S'),
                new Cell<>(0, 8, '.'),
                new Cell<>(0, 9, '.'),
                new Cell<>(0, 10, '7'),
                new Cell<>(0, 11, '8'),
                new Cell<>(0, 12, '9'),
                new Cell<>(0, 13, '0'),
                new Cell<>(0, 14, '^')
        });
    }
    @Test
    void should_return_a_matrix_array_with_cells_and_neighbours_from_string_input() {
        final String input = """
                123
                456
                789
                """;

        final MatrixTransformer matrixTransformer = new MatrixTransformer(input);
        Cell<Character>[][] sut = matrixTransformer.getCellMatrix();

        // top row
        Cell<Character> topLeft = sut[0][0];
        Cell<Character> topMiddle = sut[0][1];
        Cell<Character> topRight = sut[0][2];

        Cell<Character> middleLeft = sut[1][0];
        Cell<Character> middle = sut[1][1];
        Cell<Character> middleRight = sut[1][2];

        Cell<Character> bottomLeft = sut[2][0];
        Cell<Character> bottom = sut[2][1];
        Cell<Character> bottomRight = sut[2][2];


        assertThat(topLeft.getUpperCell()).isEqualTo(null);
        assertThat(topLeft.getLeftCell()).isEqualTo(null);
        assertThat(topLeft.getBelowCell()).isEqualTo(middleLeft);
        assertThat(topLeft.getRightCell()).isEqualTo(topMiddle);

        assertThat(topMiddle.getUpperCell()).isEqualTo(null);
        assertThat(topMiddle.getLeftCell()).isEqualTo(topLeft);
        assertThat(topMiddle.getBelowCell()).isEqualTo(middle);
        assertThat(topMiddle.getRightCell()).isEqualTo(topRight);

        assertThat(topRight.getUpperCell()).isEqualTo(null);
        assertThat(topRight.getLeftCell()).isEqualTo(topMiddle);
        assertThat(topRight.getBelowCell()).isEqualTo(middleRight);
        assertThat(topRight.getRightCell()).isEqualTo(null);

        // middle row
        assertThat(middleLeft.getUpperCell()).isEqualTo(topLeft);
        assertThat(middleLeft.getLeftCell()).isEqualTo(null);
        assertThat(middleLeft.getBelowCell()).isEqualTo(bottomLeft);
        assertThat(middleLeft.getRightCell()).isEqualTo(middle);

        assertThat(middle.getUpperCell()).isEqualTo(topMiddle);
        assertThat(middle.getLeftCell()).isEqualTo(middleLeft);
        assertThat(middle.getBelowCell()).isEqualTo(bottom);
        assertThat(middle.getRightCell()).isEqualTo(middleRight);

        assertThat(middleRight.getUpperCell()).isEqualTo(topRight);
        assertThat(middleRight.getLeftCell()).isEqualTo(middle);
        assertThat(middleRight.getBelowCell()).isEqualTo(bottomRight);
        assertThat(middleRight.getRightCell()).isEqualTo(null);

        // bottom row
        assertThat(bottomLeft.getUpperCell()).isEqualTo(middleLeft);
        assertThat(bottomLeft.getLeftCell()).isEqualTo(null);
        assertThat(bottomLeft.getBelowCell()).isEqualTo(null);
        assertThat(bottomLeft.getRightCell()).isEqualTo(bottom);

        assertThat(bottom.getUpperCell()).isEqualTo(middle);
        assertThat(bottom.getLeftCell()).isEqualTo(bottomLeft);
        assertThat(bottom.getBelowCell()).isEqualTo(null);
        assertThat(bottom.getRightCell()).isEqualTo(bottomRight);

        assertThat(bottomRight.getUpperCell()).isEqualTo(middleRight);
        assertThat(bottomRight.getLeftCell()).isEqualTo(bottom);
        assertThat(bottomRight.getBelowCell()).isEqualTo(null);
        assertThat(bottomRight.getRightCell()).isEqualTo(null);
    }
}
