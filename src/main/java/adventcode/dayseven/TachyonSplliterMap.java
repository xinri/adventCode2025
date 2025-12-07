package adventcode.dayseven;

import javax.swing.text.AttributeSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TachyonSplliterMap {
    private final String map;

    public TachyonSplliterMap(String map) {
        this.map = map;
    }

    public long numberOfSplit() {

        char[][] mapOfCluster = map.lines()
                .map(String::toCharArray)
                .toArray(char[][]::new);

        int startingColumn = findStartingPoint(mapOfCluster);
        int indexFound = findNextSplitterRow(mapOfCluster, startingColumn);
        int maxRow = mapOfCluster[0].length + 1;
        long countSplitter = 1;

        List<int[]> listOfCoordinateToExecute = new ArrayList<>();
        listOfCoordinateToExecute.add(new int[]{indexFound, startingColumn});

        while (!listOfCoordinateToExecute.isEmpty()) {
            int[] coordinate = listOfCoordinateToExecute.remove(0);

            int columnLeft = coordinate[1]-1;
            int columnRight = coordinate[1]+1;
            int originalRow = coordinate[0];

            int searchingRow = originalRow;
            if (mapOfCluster[originalRow][columnLeft] == '.') {
                do {
                    mapOfCluster[searchingRow][columnLeft] = '|';
                    searchingRow++;
                } while (searchingRow != maxRow && mapOfCluster[searchingRow][columnLeft] == '.');

                if (searchingRow < maxRow && mapOfCluster[searchingRow][columnLeft] == '^') {
                    listOfCoordinateToExecute.add(new int[]{searchingRow,columnLeft});
                    countSplitter++;
                }
            }

            searchingRow = originalRow;
            if (mapOfCluster[originalRow][columnRight] == '.') {
                do {
                    mapOfCluster[searchingRow][columnRight] = '|';
                    searchingRow++;
                } while (searchingRow != maxRow && mapOfCluster[searchingRow][columnRight] == '.');

                if (searchingRow < maxRow && mapOfCluster[searchingRow][columnRight] == '^') {
                    listOfCoordinateToExecute.add(new int[]{searchingRow,columnRight});
                    countSplitter++;
                }
            }
        }

        getMap(mapOfCluster);
        return countSplitter;
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

    public void getMap(char[][] mapOfCluster) {
        String result = Arrays.stream(mapOfCluster)
                .map(String::new)
                .collect(Collectors.joining("\n"));
        System.out.println(result);
    }
}
