package com.github.artemkorsakov.primes;

import java.util.Set;

public class PhiFunction {
    /**
     * Counts the positive integers up to a given integer n that are relatively prime to n.
     *
     * @see <a href="https://en.wikipedia.org/wiki/Euler%27s_totient_function">detailed description</a>
     */
    public static long getPhiFunction(long number) {
        double result = number;
        Set<Integer> keys = Primes.getAllPrimeFactorsWithPow(number).keySet();
        for (int prime : keys) {
            result *= (1.0 - 1.0 / prime);
        }

        return (long) result;
    }
}
