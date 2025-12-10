package adventcode.dayten;

import java.util.Set;

public class ButtonForLightBubble {

    private final Set<Integer> setOfLightBubble;

    public ButtonForLightBubble(final Set<Integer> setOfLightBubble) {
        this.setOfLightBubble = setOfLightBubble;
    }

    public boolean contains(Long index) {
        return setOfLightBubble.contains(index.intValue());
    }

    public Set<Integer> getSetOfLightBubble() {
        return setOfLightBubble;
    }

    public Long getBitmask() {
        Long bitmask = 0L;
        for (Integer l : setOfLightBubble) {
            bitmask |= (1L << l);
        }
        return bitmask;
    }

    public int getMaxPressButton(int[] currentState, Integer[] joltageTarget) {
        int maxPressesForThisButton = Integer.MAX_VALUE;

        for (Integer counterIndex : setOfLightBubble) {
            int remainingSpace = joltageTarget[counterIndex] - currentState[counterIndex];
            if (remainingSpace < 0) return Integer.MAX_VALUE; // Already exceeded
            maxPressesForThisButton = Math.min(maxPressesForThisButton, remainingSpace);
        }

        return maxPressesForThisButton;
    }
}
