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

    /**
     * phi(p*n) = p*phi(n), if n%p == 0; phi(p)*phi(n), if n%p != 0
     */
    public static int[] getPhiFunctionArray(int limit) {
        int[] phiArray = new int[limit + 1];
        phiArray[1] = 1;

        int[] primes = Primes.getAllPrimesNotMoreThanLimit(limit);

        for (int n = 1; n <= limit / 2; n++) {
            for (int p : primes) {
                if (n * p > limit) {
                    break;
                }
                if (n % p == 0) {
                    phiArray[n * p] = phiArray[n] * p;
                } else {
                    phiArray[n * p] = phiArray[n] * (p - 1);
                }
            }
        }

        return phiArray;
    }
}
