package adventcode.dayseven;

import java.beans.PropertyEditorSupport;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class QuantumTachyonSplliterMap {
    private final char[][] mapOfCluster;
    private final Map<Coordinate, Long> coordinateRecordPoint;

    public QuantumTachyonSplliterMap(String map) {
        mapOfCluster = map.lines()
                .map(String::toCharArray)
                .toArray(char[][]::new);
        coordinateRecordPoint = new HashMap<>();
    }

    public long calculateNumberPath() {
        int startingColumn = findStartingPoint(mapOfCluster);
        int indexFound = findNextSplitterRow(mapOfCluster, startingColumn);
        int maxRow = mapOfCluster.length;

        new Coordinate(indexFound, startingColumn -1);

        return recursiveCallToFindSplitter(new Coordinate(indexFound, startingColumn -1), maxRow) +
                recursiveCallToFindSplitter(new Coordinate(indexFound, startingColumn +1), maxRow);
    }

    private long recursiveCallToFindSplitter(final Coordinate coordinate, int maxRow) {
        int row = coordinate.getRow();
        int col = coordinate.getColumn();

        do {
            row++;
        } while (row != maxRow && mapOfCluster[row][col] != '^');

        if (row < maxRow && mapOfCluster[row][col] == '^') {
            Coordinate coordinateOfTheSplitter = new Coordinate(row, col);
            if (coordinateRecordPoint.containsKey(coordinateOfTheSplitter)) {
                return coordinateRecordPoint.get(coordinateOfTheSplitter);
            } else {
                long result = recursiveCallToFindSplitter(new Coordinate(row, col -1), maxRow) +
                        recursiveCallToFindSplitter(new Coordinate(row, col +1), maxRow);
                coordinateRecordPoint.put(coordinateOfTheSplitter, result);
                return result;
            }
        }

        return 1;
    }

    public int findNextSplitterRow(char[][] mapOfCluster, int startingColumn) {
        int lineFirstSplitter = 0;
        do {
            lineFirstSplitter++;
        } while (mapOfCluster[lineFirstSplitter][startingColumn] != '^');
        return lineFirstSplitter;
    }

    public int findStartingPoint(char[][] mapOfCluster) {
        return Arrays.binarySearch(mapOfCluster[0], 'S');
    }
}
