package adventcode.dayten;

import java.util.List;

public class GroupMachine {

    private final List<Machine> machineList;

    public GroupMachine(String input) {
        machineList = input.lines()
                .map(Machine::new)
                .toList();
    }

    public long findNbTotalAttempt() {
        return machineList.stream()
                .mapToLong(Machine::calculateFewestButtonPressForLightPattern)
                .sum();
    }

    public long findNbTotalAttemptWithJoltage() {
        return machineList.stream()
                .mapToLong(Machine::calculateFewestButtonPressForLightPatternWithJoltage)
                .sum();
    }
}
