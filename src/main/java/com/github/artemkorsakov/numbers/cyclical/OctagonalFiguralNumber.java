package com.github.artemkorsakov.numbers.cyclical;

/**
 * Octagonal	 	P8,n=n(3n−2)	 	1, 8, 21, 40, 65, ...
 */
public class OctagonalFiguralNumber {
    public static long getOctagonal(long n) {
        return n * (3 * n - 2);
    }

    public static boolean isOctagonal(long n) {
        double possible = 1.0 / 3.0 + Math.sqrt(n / 3.0 + 1.0 / 9.0);
        return Math.abs(possible - Math.round(possible)) < 1E-10;
    }
}
