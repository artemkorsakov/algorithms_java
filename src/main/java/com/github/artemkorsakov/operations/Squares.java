package com.github.artemkorsakov.operations;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Squares.
 */
public class Squares {
    /**
     * Is number a square?
     *
     * @param n the n
     * @return the boolean
     */
    public static boolean isSquare(long n) {
        long s = (long) Math.sqrt(n);
        return s * s == n;
    }

    /**
     * Gets all square numbers the number of digits in which is equal to the given.
     *
     * @param countOfDigits the count of digits
     * @return the all squares
     */
    public static List<Integer> getAllSquares(int countOfDigits) {
        int start = (int) Math.pow(10, countOfDigits - 1);
        int finish = start * 10 - 1;
        return getAllSquares(start, finish);
    }

    /**
     * Gets all square numbers from start to finish inclusive.
     *
     * @param start  the start
     * @param finish the finish
     * @return the all squares
     */
    public static List<Integer> getAllSquares(int start, int finish) {
        List<Integer> result = new ArrayList<>();
        int first = isSquare(start) ? (int) Math.sqrt(start) : (int) Math.sqrt(start) + 1;

        for (int i = first; i <= (int) Math.sqrt(finish); i++) {
            result.add(i * i);
        }

        return result;
    }

}
