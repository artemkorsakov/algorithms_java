package com.github.artemkorsakov.games.cubes;

import com.github.artemkorsakov.numbers.Fraction;

import java.util.Arrays;

public class DiceGame {
    /**
     * An array of probabilities to get the given sums from the cube with the maximum face maxCube and for a given count of steps.
     */
    public static Fraction[] getFractions(int step, int maxCube) {
        int[] sums = new int[37];
        for (int i = 0; i < sums.length; i++) {
            sums[i] = getCubeCount(step, maxCube, i);
        }

        int total = Arrays.stream(sums).sum();
        Fraction[] fractions = new Fraction[sums.length];
        for (int i = 0; i < sums.length; i++) {
            fractions[i] = new Fraction(sums[i], total);
        }

        return fractions;
    }

    /**
     * How many options to get the sum sum for steps of the cube with the maximum given number?
     */
    public static int getCubeCount(int steps, int maxCube, int sum) {
        if (steps < 0 || sum < 0 || sum < steps) {
            return 0;
        }

        if (steps == 0) {
            return sum == 0 ? 1 : 0;
        }

        if (steps == sum) {
            return 1;
        }

        int count = 0;
        for (int i = 1; i <= maxCube; i++) {
            count += getCubeCount(steps - 1, maxCube, sum - i);
        }

        return count;
    }

}
