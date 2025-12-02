package adventcode.daytwo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GiftData {
    private final List<RangeIds> listOfRangeIds;

    public GiftData(String rawData) {
        this.listOfRangeIds = Arrays.stream(rawData.trim().replaceAll("\n", "").split(","))
                .map(RangeIds::new)
                .collect(Collectors.toList());
    }

    public List<RangeIds> getListOfRangeId() {
        return listOfRangeIds;
    }

    public long sumInvalidIds() {
        return listOfRangeIds.stream()
                .map(RangeIds::sumInvalidIds)
                .mapToLong(Long::valueOf)
                .sum();
    }

    public long sumMultipleInvalidIds() {
        return listOfRangeIds.stream()
                .map(RangeIds::sumMultipleInvalidIds)
                .mapToLong(Long::valueOf)
                .sum();
    }
}
