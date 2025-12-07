package utils;

public class MatrixTransformer {
    private final String rawText;
    private final char[][] arrayMatrix;

    public MatrixTransformer(final String rawText) {
        if (rawText == null || rawText.isBlank()) {
            throw new IllegalStateException("the input should not be null, empty or blank");
        }
        this.rawText = rawText;
        this.arrayMatrix = rawText.lines()
                .map(String::toCharArray)
                .toArray(char[][]::new);
    }

    public final char[][] getArrayMatrix() {
        return arrayMatrix;
    }

    public char[][] getInvertedMatrix() {
        int nbLine = arrayMatrix.length;
        int nbColumn = arrayMatrix[0].length;

        char[][] transposedMatrix = new char[nbColumn][nbLine];
        for (int i = 0; i < nbLine; i++) {
            for (int j = 0; j < nbColumn; j++) {
                transposedMatrix[j][i] = arrayMatrix[i][j];
            }
        }
        return transposedMatrix;
    }

    public Cell<Character>[][] getCellMatrix() {
        int nbLine = arrayMatrix.length;
        int nbColumn = arrayMatrix[0].length;

        Cell<Character>[][] cells = new Cell[nbLine][nbColumn];
        for (int i = 0; i < nbLine; i++) {
            for (int j = 0; j < nbColumn; j++) {
                cells[i][j] = new Cell<>(i, j, arrayMatrix[i][j]);
            }
        }

        for (int i = 0; i < nbLine; i++) {
            for (int j = 0; j < nbColumn; j++) {
                cells[i][j] = cells[i][j].update(i > 0 ? cells[i - 1][j] : null, j > 0 ? cells[i][j - 1] : null,
                        i < (nbLine - 1) ? cells[i + 1][j] : null, j < (nbColumn - 1) ? cells[i][j + 1] : null);
            }
        }

        return cells;
    }
}
