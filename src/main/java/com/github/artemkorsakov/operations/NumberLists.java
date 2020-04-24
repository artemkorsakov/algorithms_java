package com.github.artemkorsakov.operations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberLists {
    /**
     * Returns a list of unique lists containing given numbers without repetition.
     */
    public static List<List<Integer>> getAllNumbersVariants(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            return new ArrayList<>();
        }

        List<List<Integer>> allNumbersVariant = new ArrayList<>();
        if (numbers.size() == 1) {
            allNumbersVariant.add(numbers);
            return allNumbersVariant;
        }

        int number = numbers.get(0);
        allNumbersVariant.add(Collections.singletonList(number));

        List<List<Integer>> allNumbersVariantTemp = getAllNumbersVariants(numbers.subList(1, numbers.size()));
        allNumbersVariant.addAll(allNumbersVariantTemp); // without current

        for (List<Integer> tempVariant : allNumbersVariantTemp) {
            List<Integer> temp = new ArrayList<>();
            temp.add(number);
            temp.addAll(tempVariant);
            allNumbersVariant.add(temp);
        }

        return allNumbersVariant;
    }

}
