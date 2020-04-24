package com.github.artemkorsakov.powers;

import com.github.artemkorsakov.primes.Primes;

import java.util.Map;

public class Powers {
    public static int isPower(int number) {
        Map<Integer, Integer> factors = Primes.getAllPrimeFactorsWithPow(number);
        int min = factors.values().stream().min(Integer::compareTo).orElse(1);
        if (min < 2) {
            return 1;
        }

        return min;
    }

    /**
     * Returns x^y mod m.
     */
    public static int powMod(int x, int y, int m) {
        if (x < 0) {
            throw new IllegalArgumentException("Negative base not supported");
        }
        if (y < 0) {
            throw new IllegalArgumentException("Modular reciprocal not supported");
        }
        if (m <= 0) {
            throw new IllegalArgumentException("Modulus must be positive");
        }
        if (m == 1) {
            return 0;
        }

        // Exponentiation by squaring
        int z = 1;
        for (; y != 0; y >>>= 1) {
            if ((y & 1) != 0) {
                z = (int) ((long) z * x % m);
            }
            x = (int) ((long) x * x % m);
        }
        return z;
    }

}
