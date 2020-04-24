package com.github.artemkorsakov.numbers.cyclical;

/**
 * Heptagonal	 	P7,n=n(5n−3)/2	 	1, 7, 18, 34, 55, ...
 */
public class HeptagonalFiguralNumber {
    public static long getHeptagonal(long n) {
        return n * (5 * n - 3) / 2;
    }

    public static boolean isHeptagonal(long n) {
        double possible = 3.0 / 10.0 + Math.sqrt(2.0 * n / 5.0 + 9.0 / 100.0);
        return Math.abs(possible - Math.round(possible)) < 1E-10;
    }
}
