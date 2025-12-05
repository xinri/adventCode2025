package adventcode.dayfive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IngredientDb {

    private final List<String> freshIngredients;
    private final List<Long> availableIngredients;

    public IngredientDb(String listOfFreshAndAvailableIngredient) {

        String[] splitBetweenFreshAndAvailable = listOfFreshAndAvailableIngredient.split("\n\n");

        freshIngredients = splitBetweenFreshAndAvailable[0].lines()
                .collect(Collectors.toList());

        /*freshIngredients = splitBetweenFreshAndAvailable[0].lines()
                .map(value -> value.split("-"))
                .map(value -> LongStream.rangeClosed(Long.parseLong(value[0]), Long.parseLong(value[1]))
                        .boxed().collect(Collectors.toSet()))
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());*/
        availableIngredients = splitBetweenFreshAndAvailable[1].lines()
                .map(Long::valueOf)
                .collect(Collectors.toList());
    }

    public long findAmountOfAvailableFreshIngredient() {
        long count = 0;

        for (Long availableIngredient : availableIngredients) {
            for (String freshIngredient : freshIngredients) {
                String[] split = freshIngredient.split("-");
                Long begin = Long.parseLong(split[0]);
                Long end = Long.parseLong(split[1]);

                if (begin <= availableIngredient && end >= availableIngredient) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }
}
