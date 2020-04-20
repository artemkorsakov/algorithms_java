package com.github.artemkorsakov.primes;

import java.util.Set;

/**
 * https://en.wikipedia.org/wiki/Euler%27s_totient_function
 */
public class PhiFunction {
    /**
     * Gets phi function.
     *
     * @param number the number
     * @return the phi function
     */
// Вернуть количество относительно простых чисел по отношению к n
    public static int getPhiFunction(long number) {
        double result = number;
        Set<Integer> keys = Primes.getAllPrimeFactorsWithPow(number).keySet();
        for (int prime : keys) {
            result *= (1.0 - 1.0 / prime);
        }

        return (int) result;
    }
}
