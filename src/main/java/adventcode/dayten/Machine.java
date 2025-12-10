package adventcode.dayten;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Machine {

    private final char[] lightBubbleTarget;
    private final List<ButtonForLightBubble> listOfButton;
    private final Integer[] joltageTarget;

    public Machine(final String input) {
        String[] split = input.split(" ");
        lightBubbleTarget = split[0].replaceAll("\\[", "")
                .replaceAll("]", "")
                .toCharArray();

        joltageTarget = Arrays.stream(split[split.length - 1].replace("{", "").replaceAll("}", "")
                        .split(","))
                .map(Integer::valueOf)
                .toArray(Integer[]::new);

        listOfButton = new ArrayList<>();
        for (int i = 1; i < split.length - 1; i++) {
            Set<Integer> setOfLightBubble = Arrays.stream(split[i].replaceAll("\\(", "")
                            .replace(")", "")
                            .split(","))
                    .map(Integer::valueOf)
                    .collect(Collectors.toSet());
            listOfButton.add(new ButtonForLightBubble(setOfLightBubble));
        }
    }

    public Long calculateFewestButtonPressForLightPattern() {

      /*  List<Long> listOfIndexForLight = IntStream.range(0, lightBubbleTarget.length)
                .filter(i -> lightBubbleTarget[i] == '#')
                .mapToLong(i -> lightBubbleTarget[i])
                .boxed()
                .toList();*/
        long targetMask = 0L;
        for (int i = 0; i < lightBubbleTarget.length; i++) {
            if (lightBubbleTarget[i] == '#') {
                targetMask |= (1L << i);
            }
        }

        List<Long> buttonMask = listOfButton.stream()
                .map(ButtonForLightBubble::getBitmask)
                .toList();

        return calculateFewestButton(0, 0, targetMask, buttonMask, 0);
    }

    private long calculateFewestButton(int index, long currentValue, long targetMask, List<Long> buttonMask, int currentCount) {
        if (index == buttonMask.size()) {
            return (currentValue == targetMask) ? currentCount : Integer.MAX_VALUE;
        }

        // Optimization: If we already have a partial solution that is deeper than a known best,
        // we usually prune, but here we just need to explore the tree.

        // Option A: Don't press the button at 'index'
        long resNoPress = calculateFewestButton(index + 1, currentValue, targetMask, buttonMask, currentCount);

        // Option B: Press the button at 'index'
        // XOR the button mask with current state
        long resPress = calculateFewestButton(index + 1, currentValue ^ buttonMask.get(index), targetMask, buttonMask, currentCount + 1);

        return Math.min(resNoPress, resPress);
    }

    public long calculateFewestButtonPressForLightPatternWithJoltage() {
        return calculateMinForJoltage(0, new int[joltageTarget.length]);
    }

    // TODO: Need an optimization. Will do it later
    private long calculateMinForJoltage(int indexForRecursion, int[] currentState) {
        // Base Case: We have considered all buttons
        if (indexForRecursion == listOfButton.size()) {
            // Check if we hit the target exactly
            for (int i = 0; i < joltageTarget.length; i++) {
                if (currentState[i] != joltageTarget[i]) return Integer.MAX_VALUE;
            }
            return 0;
        }

        ButtonForLightBubble currentButton = listOfButton.get(indexForRecursion);

        // Determine the MAXIMUM times we can press this button.
        // We cannot press it if doing so would exceed the joltageTarget for any affected counter.
        // maxPress = min( (joltageTarget[k] - currentState[k]) for all k affected by this button )
        int maxPressesForThisButton = currentButton.getMaxPressButton(currentState, joltageTarget);
        ;

        // If the button affects nothing relevant (or we have infinite room?),
        // effectively 0 is the only sensible move to minimize cost, unless it's a dummy button.
        // But assuming valid inputs:
        if (maxPressesForThisButton == Integer.MAX_VALUE) maxPressesForThisButton = 0;

        long globalMin = Integer.MAX_VALUE;

        // Try pressing this button i times (from 0 up to max)
        for (int i = 0; i <= maxPressesForThisButton; i++) {

            // 1. Create new state
            int[] nextState = Arrays.copyOf(currentState, currentState.length);
            for (int counterIndex : currentButton.getSetOfLightBubble()) {
                nextState[counterIndex] += i;
            }

            // 2. Recurse
            long resultFromChild = calculateMinForJoltage(indexForRecursion + 1, nextState);

            // 3. Combine result (currentState presses 'i' + best from child)
            if (resultFromChild != Integer.MAX_VALUE) {
                globalMin = Math.min(globalMin, i + resultFromChild);
            }
        }

        return globalMin;
    }
}
