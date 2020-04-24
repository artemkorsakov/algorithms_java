package com.github.artemkorsakov.numbers.cyclical;

/**
 * Pentagonal Pn=n(3n−1)/2    1, 5, 12, 22, 35, ...
 */
public class PentagonalFiguralNumber {
    public static long getPentagonal(long n) {
        return n * (3 * n - 1) / 2;
    }

    public static boolean isPentagonal(long n) {
        double possible = 1.0 / 6.0 + Math.sqrt(2.0 * n / 3.0 + 1.0 / 36.0);
        return Math.abs(possible - Math.round(possible)) < 1E-10;
    }
}
