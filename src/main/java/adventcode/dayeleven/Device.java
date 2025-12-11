package adventcode.dayeleven;

import java.util.Arrays;
import java.util.List;

public class Device {

    private final String deviceName;
    private final String[] outputNames;

    public Device(String[] input) {
        deviceName = input[0];
        outputNames = input[1].split(" ");
    }


    public String getDeviceName() {
        return deviceName;
    }

    public String[] getOutputNames() {
        return outputNames;
    }

    public List<String> getOutputNamesList() {
        return Arrays.stream(outputNames).toList();
    }
}
