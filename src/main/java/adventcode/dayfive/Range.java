package adventcode.dayfive;

import java.util.Objects;

public class Range {


    private Long begin;
    private Long end;

    public Range(String input) {
        String[] split = input.split("-");
        begin = Long.valueOf(split[0]);
        end = Long.valueOf(split[1]);
    }

    public Long count() {
        return end - begin + 1;
    }

    public Long getBegin() {
        return begin;
    }

    public Long getEnd() {
        return end;
    }

    public void updateWithExitingRange(Range existingRange) {
        if (existingRange.begin <= begin && existingRange.end >= begin) {

        }
    }

    public boolean isCompletelyIncluded(Range existingRange) {
        return existingRange.getBegin() <= begin && existingRange.getEnd() >= end;
    }

    public boolean cannotBeFused(Range existingRange) {
        return existingRange.getEnd() < begin - 1 || existingRange.getBegin() > end + 1;
    }

    public Range newMergedRange(Range existingRange) {
        return new Range(Math.min(begin, existingRange.getBegin()) + "-" + Math.max(end, existingRange.end));
    }

    public void setNewRange(Range newMergedRanged) {
        this.begin = newMergedRanged.getBegin();
        this.end = newMergedRanged.getEnd();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Range range)) return false;
        return Objects.equals(getBegin(), range.getBegin()) && Objects.equals(getEnd(), range.getEnd());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBegin(), getEnd());
    }
}
