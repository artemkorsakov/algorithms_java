package com.github.artemkorsakov.operations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

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

    /**
     * Пусть S[k] - кол-во различных чисел, не превышающих limit, вида p[1]^a[1]*...*p[k]^a[k], a[i] >= 0,
     * p[i] = i-е по порядку простое число.
     */
    public static long getCountOfNumbers(int limit, int[] primes) {
        if (limit < 1) {
            return 0;
        }

        if (primes.length == 0 || limit < primes[0]) {
            return 1;
        }

        long count = 0;

        boolean[] numbers = new boolean[limit + 1];
        numbers[1] = true;

        for (int i = 1; i <= limit / 2; i++) {
            if (numbers[i]) {
                count++;

                for (int prime : primes) {
                    int mul = prime * i;
                    if (mul <= 0 || mul > limit) {
                        break;
                    }

                    numbers[mul] = true;
                }
            }
        }

        count += IntStream.range(limit / 2 + 1, limit + 1).parallel().filter(i -> numbers[i]).count();
        return count;
    }

    /**
     * {@link NumberLists#getCountOfNumbers(int, int[])}
     */
    public static long getCountOfNumbers(long limit, int[] primes) {
        if (limit < Integer.MAX_VALUE) {
            return getCountOfNumbers((int) limit, primes);
        }

        if (primes.length == 0) {
            return 1;
        }

        List<Long> numbers = new ArrayList<>();
        numbers.add(1L);

        int index = 0;
        while (index < numbers.size()) {
            long number = numbers.get(index);

            for (long prime : primes) {
                long mul = prime * number;
                if (mul <= 0 || mul > limit) {
                    break;
                }

                if (!numbers.contains(mul)) {
                    numbers.add(mul);
                }
            }

            index++;
        }

        return numbers.size();
    }
}
