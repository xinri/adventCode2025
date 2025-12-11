package adventcode.dayeleven;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ServerRack {

    private final Device[] deviceArray;
    private final Map<String, List<String>> deviceMapPerOutput;
    private final Map<String, Long> storeResultForRecursiveCall;

    public ServerRack(String input) {
        deviceArray = input.lines()
                .map(str -> str.split(": "))
                .map(Device::new)
                .toArray(Device[]::new);

        deviceMapPerOutput = Arrays.stream(deviceArray)
                .collect(Collectors.toMap(Device::getDeviceName, Device::getOutputNamesList));

        storeResultForRecursiveCall = new HashMap<>();
    }

    public Long calculateDifferentPath() {
        return findDifferentPathRecursive("you");
    }

    private long findDifferentPathRecursive(String deviceName) {
        if (storeResultForRecursiveCall.containsKey(deviceName)) {
            return storeResultForRecursiveCall.get(deviceName);
        }

        if ("out".equals(deviceName)) {
            return 1; // One path found
        }

        List<String> nameListForRequestName = deviceMapPerOutput.get(deviceName);

        if (nameListForRequestName == null || nameListForRequestName.isEmpty()) {
            storeResultForRecursiveCall.put(deviceName, 0L);
            return 0;
        }

        long totalPaths = 0;
        for (String neighbor : nameListForRequestName) {
            totalPaths += findDifferentPathRecursive(neighbor);
        }

        storeResultForRecursiveCall.put(deviceName, totalPaths);
        return totalPaths;
    }
}
