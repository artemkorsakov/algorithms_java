package com.github.artemkorsakov.primes;

import java.util.Map;

/**
 * The radical of n, rad(n), is the product of distinct prime factors of n.
 * For example, 504 = 2^3 × 3^2 × 7, so rad(504) = 2 × 3 × 7 = 42.
 */
public class Radicals {
    /**
     * Return array of products of distinct prime factors of any n not more limit.
     */
    public static int[] getAllRads(int limit) {
        int[] rads = new int[limit + 1];
        rads[1] = 1;

        int[] primes = Primes.getAllPrimesNotMoreThanLimit(limit);
        for (int prime : primes) {
            for (int i = 1; i <= limit / prime; i++) {
                rads[i * prime] = rads[i * prime] == 0 ? prime : rads[i * prime] * prime;
            }
        }

        return rads;
    }

    /**
     * Return the product of distinct prime factors of n.
     */
    public static long getRad(int number) {
        Map<Integer, Integer> primes = Primes.getAllPrimeFactorsWithPow(number);
        return primes.keySet().stream().mapToLong(Integer::longValue).reduce((c1, c2) -> c1 * c2).orElse(1);
    }

    /**
     * Does a number consist only the first power of primes?
     */
    public static boolean isConsistOnlyTheFirstPowerOfPrimes(long number) {
        int i = 2;
        while (number > 1) {
            if (Primes.isPrime(i) && number % i == 0) {
                int pow = 0;
                while (number % i == 0) {
                    number = number / i;
                    pow++;
                    if (pow > 1) {
                        return false;
                    }
                }
            }
            i++;
        }

        return true;
    }

}
