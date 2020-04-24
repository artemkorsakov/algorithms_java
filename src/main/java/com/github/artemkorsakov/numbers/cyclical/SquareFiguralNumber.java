package com.github.artemkorsakov.numbers.cyclical;

/**
 * Square	 	P4,n=n^2	 	1, 4, 9, 16, 25, ...
 */
public class SquareFiguralNumber {
    public static long getSquare(long n) {
        return n * n;
    }

    public static boolean isSquare(long n) {
        double possible = Math.sqrt(n);
        return Math.abs(possible - Math.round(possible)) < 1E-10;
    }
}
