package com.github.artemkorsakov.numbers;

import com.github.artemkorsakov.figure.Matrix;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * @see <a href="https://en.wikipedia.org/wiki/Fibonacci_number">Fibonacci number</a>
 */
public class Fibonacci {
    private static final long[][] MATRIX = new long[][]{new long[]{1, 1}, new long[]{1, 0}};

    public static BigInteger getFibonacciNumber(int k) {
        return BigDecimal.valueOf(GoldenRatio.PHI).pow(k).divide(BigDecimal.valueOf(Math.sqrt(5)), 0, RoundingMode.HALF_UP).toBigInteger();
    }

    public static long[][] getFibonacciMatrix(int k) {
        return Matrix.power(MATRIX, k);
    }
}
