package com.github.artemkorsakov.operations;

public class Sums {
    /**
     * Returns the sum of numbers from 1 to a given.
     */
    public static long getSumToGiven(long n) {
        return n * (n + 1) / 2;
    }

    /**
     * Returns the sum of squares of numbers from 1 to a given limit, inclusive.
     */
    public static long computeSumOfSquaresTo(long input) {
        return input * (input + 1) * (2 * input + 1) / 6;
    }

}
