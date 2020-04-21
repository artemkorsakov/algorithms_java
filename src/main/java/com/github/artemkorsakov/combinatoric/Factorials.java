package com.github.artemkorsakov.combinatoric;

import java.math.BigInteger;

public class Factorials {
    /**
     * Gets factorial.
     *
     * @see <a href="https://en.wikipedia.org/wiki/Factorial">detailed description</a>
     */
    public static long getFactorial(long n) {
        long result = 1;
        for (long i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * Gets factorial.
     *
     * @see <a href="https://en.wikipedia.org/wiki/Factorial">detailed description</a>
     */
    public static BigInteger getBigFactorial(long n) {
        BigInteger result = BigInteger.ONE;
        for (long i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

}
