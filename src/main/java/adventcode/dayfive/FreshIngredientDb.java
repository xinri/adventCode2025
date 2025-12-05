package adventcode.dayfive;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FreshIngredientDb {

    private final List<Range> freshIngredients;

    public FreshIngredientDb(String input) {

        freshIngredients = input.lines()
                .map(Range::new)
                .collect(Collectors.toList());
    }

    public Long countOfFreshIngredient() {

        List<Range> freshIngredientUpdate = new ArrayList<>();

        for (Range freshIngredient : freshIngredients) {
            if (freshIngredientUpdate.isEmpty()) {
                freshIngredientUpdate.add(freshIngredient);
            } else {
                List<Range> newUpdatedList = new ArrayList<>(freshIngredientUpdate);

                boolean cannotBeFused = true;
                boolean hasBeenMerged = false;
                boolean hasRemoved = false;
                for (Range existingFreshIngredient : freshIngredientUpdate) {
                    if (freshIngredient.isCompletelyIncluded(existingFreshIngredient)) {
                        cannotBeFused = false;
                    } else if (existingFreshIngredient.isCompletelyIncluded(freshIngredient)) {
                        cannotBeFused = false;
                        hasRemoved = true;
                        newUpdatedList.remove(existingFreshIngredient);
                    } else if (freshIngredient.cannotBeFused(existingFreshIngredient)) {

                    } else {
                        cannotBeFused = false;
                        hasBeenMerged = true;
                        newUpdatedList.remove(existingFreshIngredient);
                        Range newRangeMerged = freshIngredient.newMergedRange(existingFreshIngredient);
                        freshIngredient.setNewRange(newRangeMerged);
                    }
                }

                if (cannotBeFused) {
                    newUpdatedList.add(freshIngredient);
                } else if(hasBeenMerged || hasRemoved) {
                    newUpdatedList.add(freshIngredient);
                }
                freshIngredientUpdate = newUpdatedList;
            }
        }

        return freshIngredientUpdate.stream()
                .mapToLong(Range::count)
                .sum();
    }
}
