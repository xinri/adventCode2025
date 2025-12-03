package adventcode.daythree;

import java.util.List;
import java.util.stream.Collectors;

public class EmergencyPowerPlant {

    private final List<Bank> bankList;

    public EmergencyPowerPlant(final String powerPlantRepresentation) {
        this.bankList = powerPlantRepresentation.lines()
                .map(Bank::new)
                .collect(Collectors.toList());
    }

    public long calculateTotalOutputJoltage() {
        return bankList.stream()
                .map(Bank::calculateMaxOutputVoltage)
                .mapToLong(Long::valueOf)
                .sum();
    }

    public long calculateTotalOutputJoltageWithTwelveDigits() {
        return bankList.stream()
                .map(Bank::calculateMaxOutputVoltageWithTwelveDigits)
                .mapToLong(Long::valueOf)
                .sum();
    }

    public List<Bank> getBankList() {
        return bankList;
    }
}
