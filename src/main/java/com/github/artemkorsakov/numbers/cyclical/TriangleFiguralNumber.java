package com.github.artemkorsakov.numbers.cyclical;

/**
 * Triangle	 	Tn=n(n+1)/2	 	1, 3, 6, 10, 15, ...
 */
public class TriangleFiguralNumber {
    public static long getTriangle(long n) {
        return n * (n + 1) / 2;
    }

    public static boolean isTriangle(long n) {
        double possible = -1.0 / 2.0 + Math.sqrt(2.0 * n + 1.0 / 4.0);
        return Math.abs(possible - Math.round(possible)) < 1E-10;
    }
}
