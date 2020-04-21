package com.github.artemkorsakov.combinatoric;

import java.math.BigInteger;

public class BinomialCoefficient {
    /**
     * Get Binomial Coefficient
     *
     * @see <a href="https://en.wikipedia.org/wiki/Binomial_coefficient">detailed description</a>
     */
    public static BigInteger getBinomialCoefficient(long n, long r) {
        if (r < 0 || r > n) {
            return BigInteger.ZERO;
        }

        BigInteger num = BigInteger.ONE;
        BigInteger den = BigInteger.ONE;
        for (long i = 0; i < r; i++) {
            num = num.multiply(BigInteger.valueOf(n - i));
            den = den.multiply(BigInteger.valueOf(r - i));
        }

        return num.divide(den);
    }

    /**
     * Get Binomial Coefficient by modulus
     *
     * @see <a href="https://en.wikipedia.org/wiki/Binomial_coefficient">detailed description</a>
     */
    public static BigInteger getBinomialCoefficient(long n, long r, BigInteger mod) {
        return getBinomialCoefficient(n, r).mod(mod);
    }

}
