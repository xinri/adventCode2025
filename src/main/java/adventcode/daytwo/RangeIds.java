package adventcode.daytwo;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class RangeIds {
    private final String rangeOfIds;
    private final long start;
    private final long end;

    public RangeIds(String rangeOfIds) {
        this.rangeOfIds = rangeOfIds.trim();
        String[] split = rangeOfIds.split("-");
        this.start = Long.parseLong(split[0]);
        this.end = Long.parseLong(split[1]);
    }

    public long getStart() {
        return start;
    }

    public long getEnd() {
        return end;
    }

    public List<Long> getInvalidIds() {
        return LongStream.rangeClosed(start, end)
                .filter(IdValidator::isInvalid)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Long> getMultipleInvalidIds() {
        return LongStream.rangeClosed(start, end)
                .filter(IdValidator::isMultipleTimeInvalid)
                .boxed()
                .collect(Collectors.toList());
    }

    public long sumInvalidIds() {
        return getInvalidIds().stream()
                .mapToLong(Long::valueOf)
                .sum();
    }

    public long sumMultipleInvalidIds() {
        return getMultipleInvalidIds().stream()
                .mapToLong(Long::valueOf)
                .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof RangeIds)) return false;
        RangeIds rangeIds = (RangeIds) o;
        return Objects.equals(rangeOfIds, rangeIds.rangeOfIds);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(rangeOfIds);
    }
}
