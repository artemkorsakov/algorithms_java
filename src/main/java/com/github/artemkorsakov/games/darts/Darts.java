package com.github.artemkorsakov.games.darts;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Darts {
    public static Map<Integer, Integer> getAllDistinctWaysToCheckOut() {
        Map<Integer, Integer> integerMap = new HashMap<>();
        int[] points = getPoints();
        int[] doublePoints = getDoublePoints();

        // First step checkout
        for (int point : doublePoints) {
            integerMap.put(point, integerMap.getOrDefault(point, 0) + 1);
        }

        // Second step checkout
        for (int value : points) {
            for (int doublePoint : doublePoints) {
                int point = value + doublePoint;
                integerMap.put(point, integerMap.getOrDefault(point, 0) + 1);
            }
        }

        // Third step checkout
        for (int i = 0; i < points.length; i++) {
            for (int j = i; j < points.length; j++) {
                for (int doublePoint : doublePoints) {
                    int point = points[i] + points[j] + doublePoint;
                    integerMap.put(point, integerMap.getOrDefault(point, 0) + 1);
                }
            }
        }

        return integerMap;
    }

    public static int[] getPoints() {
        int[] result = new int[62];
        System.arraycopy(getSinglePoints(), 0, result, 0, 21);
        System.arraycopy(getDoublePoints(), 0, result, 21, 21);
        System.arraycopy(getTriplePoints(), 0, result, 42, 20);
        return result;
    }

    public static int[] getSinglePoints() {
        int[] result = new int[21];
        System.arraycopy(IntStream.range(1, 21).toArray(), 0, result, 0, 20);
        result[20] = 25;
        return result;
    }

    public static int[] getDoublePoints() {
        return Arrays.stream(getSinglePoints()).map(i -> 2 * i).toArray();
    }

    public static int[] getTriplePoints() {
        return IntStream.range(1, 21).map(i -> 3 * i).toArray();
    }

}
