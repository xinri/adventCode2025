package adventcode.dayeight;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Circuit {

    private final Set<JunctionBox> setOfJunctionBox;

    public Circuit(JunctionBox junctionBoxFirst, JunctionBox junctionBoxSecond) {
        this.setOfJunctionBox = new HashSet<>();
        setOfJunctionBox.add(junctionBoxFirst);
        setOfJunctionBox.add(junctionBoxSecond);
    }

    public void add(JunctionBox junctionBoxSecond) {
        setOfJunctionBox.add(junctionBoxSecond);
    }

    public void add(Circuit circuit) {
        setOfJunctionBox.addAll(circuit.getSetOfJunctionBox());
    }

    public int sizeOfCircuit() {
        return setOfJunctionBox.size();
    }

    public Set<JunctionBox> getSetOfJunctionBox() {
        return setOfJunctionBox;
    }
}
