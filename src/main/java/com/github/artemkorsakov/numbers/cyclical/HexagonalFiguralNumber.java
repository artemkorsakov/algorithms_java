package com.github.artemkorsakov.numbers.cyclical;

/**
 * Hexagonal	 	Hn=n(2n−1)	 	1, 6, 15, 28, 45, ...
 */
public class HexagonalFiguralNumber {
    public static long getHexagonal(long n) {
        return n * (2 * n - 1);
    }

    public static boolean isHexagonal(long n) {
        double possible = 1.0 / 4.0 + Math.sqrt(n / 2.0 + 1.0 / 16.0);
        return Math.abs(possible - Math.round(possible)) < 1E-10;
    }
}
