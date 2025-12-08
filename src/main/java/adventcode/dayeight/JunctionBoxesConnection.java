package adventcode.dayeight;

import java.util.*;

public class JunctionBoxesConnection {

    private final List<JunctionBox> listOfJunctionBox;

    public JunctionBoxesConnection(String input) {
        this.listOfJunctionBox = input.lines()
                .map(str -> str.split(","))
                .map(split -> new JunctionBox(Long.valueOf(split[0]),
                        Long.valueOf(split[1]), Long.valueOf(split[2])))
                .toList();
    }

    public long calculate3LargestCircuits(int nbOfMaxConnection) {
        TreeMap<Double, JunctionBox[]> treeMap = new TreeMap<>();

        for (JunctionBox junctionBox : listOfJunctionBox) {
            for (JunctionBox junctionBoxToCompare : listOfJunctionBox) {
                if (junctionBox.equals(junctionBoxToCompare)) {
                    break;
                }
                double distance = junctionBox.calculateDistanceWith(junctionBoxToCompare);
                treeMap.computeIfAbsent(distance, (d) -> new JunctionBox[]{junctionBox, junctionBoxToCompare});
            }
        }

        Iterator<JunctionBox[]> iterator = treeMap.values().iterator();
        List<Circuit> listOfCircuit = new ArrayList<>(nbOfMaxConnection);
        Map<JunctionBox, Circuit> mapOfCircuit = new HashMap<>(treeMap.size());
        int nbConnection = 0;
        while (iterator.hasNext() && nbConnection < nbOfMaxConnection) {
            JunctionBox[] next = iterator.next();
            JunctionBox junctionBoxFirst = next[0];
            JunctionBox junctionBoxSecond = next[1];

            if (!mapOfCircuit.containsKey(junctionBoxFirst) && !mapOfCircuit.containsKey(junctionBoxSecond)) {
                Circuit circuit = new Circuit(junctionBoxFirst, junctionBoxSecond);
                mapOfCircuit.put(junctionBoxFirst, circuit);
                mapOfCircuit.put(junctionBoxSecond, circuit);
                listOfCircuit.add(circuit);
                nbConnection++;
            } else if (mapOfCircuit.containsKey(junctionBoxFirst) && !mapOfCircuit.containsKey(junctionBoxSecond)) {
                Circuit circuit = mapOfCircuit.get(junctionBoxFirst);
                mapOfCircuit.put(junctionBoxSecond, circuit);
                circuit.add(junctionBoxSecond);
                nbConnection++;
            } else if (!mapOfCircuit.containsKey(junctionBoxFirst) && mapOfCircuit.containsKey(junctionBoxSecond)) {
                Circuit circuit = mapOfCircuit.get(junctionBoxSecond);
                mapOfCircuit.put(junctionBoxFirst, circuit);
                circuit.add(junctionBoxFirst);
                nbConnection++;
            } else if (mapOfCircuit.containsKey(junctionBoxFirst) && mapOfCircuit.containsKey(junctionBoxSecond)) {
                Circuit circuit = mapOfCircuit.get(junctionBoxFirst);
                Circuit circuit2 = mapOfCircuit.get(junctionBoxSecond);

                if (circuit != circuit2) {
                    for (JunctionBox toReplace : circuit2.getSetOfJunctionBox()) {
                        mapOfCircuit.put(toReplace, circuit);
                    }
                    circuit.add(circuit2);
                    listOfCircuit.remove(circuit2);
                }
                nbConnection++;
            }
        }

        return listOfCircuit.stream()
                .mapToInt(Circuit::sizeOfCircuit)
                .boxed()
                .sorted(Collections.reverseOrder())
                .limit(3)
                .reduce(1, (a, b) -> a * b);
    }

    public long multiplyLastXJunctionBox() {
        TreeMap<Double, JunctionBox[]> treeMap = new TreeMap<>();

        int nbJunctionBoxes = listOfJunctionBox.size();

        for (JunctionBox junctionBox : listOfJunctionBox) {
            for (JunctionBox junctionBoxToCompare : listOfJunctionBox) {
                if (junctionBox.equals(junctionBoxToCompare)) {
                    break;
                }
                double distance = junctionBox.calculateDistanceWith(junctionBoxToCompare);
                treeMap.computeIfAbsent(distance, (d) -> new JunctionBox[]{junctionBox, junctionBoxToCompare});
            }
        }

        Iterator<JunctionBox[]> iterator = treeMap.values().iterator();
        List<Circuit> listOfCircuit = new ArrayList<>();
        Map<JunctionBox, Circuit> mapOfCircuit = new HashMap<>(treeMap.size());
        while (iterator.hasNext()) {
            JunctionBox[] next = iterator.next();
            JunctionBox junctionBoxFirst = next[0];
            JunctionBox junctionBoxSecond = next[1];

            if (!mapOfCircuit.containsKey(junctionBoxFirst) && !mapOfCircuit.containsKey(junctionBoxSecond)) {
                Circuit circuit = new Circuit(junctionBoxFirst, junctionBoxSecond);
                mapOfCircuit.put(junctionBoxFirst, circuit);
                mapOfCircuit.put(junctionBoxSecond, circuit);
                listOfCircuit.add(circuit);

                if (listOfCircuit.size() == 1 && listOfCircuit.get(0).sizeOfCircuit() == nbJunctionBoxes) {
                    return junctionBoxFirst.getX() * junctionBoxSecond.getX();
                }

            } else if (mapOfCircuit.containsKey(junctionBoxFirst) && !mapOfCircuit.containsKey(junctionBoxSecond)) {
                Circuit circuit = mapOfCircuit.get(junctionBoxFirst);
                mapOfCircuit.put(junctionBoxSecond, circuit);
                circuit.add(junctionBoxSecond);

                if (listOfCircuit.size() == 1 && listOfCircuit.get(0).sizeOfCircuit() == nbJunctionBoxes) {
                    return junctionBoxFirst.getX() * junctionBoxSecond.getX();
                }

            } else if (!mapOfCircuit.containsKey(junctionBoxFirst) && mapOfCircuit.containsKey(junctionBoxSecond)) {
                Circuit circuit = mapOfCircuit.get(junctionBoxSecond);
                mapOfCircuit.put(junctionBoxFirst, circuit);
                circuit.add(junctionBoxFirst);

                if (listOfCircuit.size() == 1 && listOfCircuit.get(0).sizeOfCircuit() == nbJunctionBoxes) {
                    return junctionBoxFirst.getX() * junctionBoxSecond.getX();
                }

            } else if (mapOfCircuit.containsKey(junctionBoxFirst) && mapOfCircuit.containsKey(junctionBoxSecond)) {
                Circuit circuit = mapOfCircuit.get(junctionBoxFirst);
                Circuit circuit2 = mapOfCircuit.get(junctionBoxSecond);

                if (circuit != circuit2) {
                    for (JunctionBox toReplace : circuit2.getSetOfJunctionBox()) {
                        mapOfCircuit.put(toReplace, circuit);
                    }
                    circuit.add(circuit2);
                    listOfCircuit.remove(circuit2);
                }

                if (listOfCircuit.size() == 1 && listOfCircuit.get(0).sizeOfCircuit() == nbJunctionBoxes) {
                    return junctionBoxFirst.getX() * junctionBoxSecond.getX();
                }
            }
        }

        return 0;
    }
}
