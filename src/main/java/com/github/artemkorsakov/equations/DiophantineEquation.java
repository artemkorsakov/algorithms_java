package com.github.artemkorsakov.equations;

import com.github.artemkorsakov.operations.Squares;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.math.BigInteger;

/**
 * x^2 – D*y^2 = 1
 */
public class DiophantineEquation {
    /**
     * The <a href="https://en.wikipedia.org/wiki/Chakravala_method">chakravala method</a>
     * is a cyclic algorithm to solve indeterminate quadratic equations.
     */
    public static Equation getMinimalEquation(int d) {
        if (Squares.isSquare(d)) {
            return null;
        }

        BigInteger a = BigInteger.valueOf(Math.round(Math.sqrt(d)));
        BigInteger k = a.pow(2).subtract(BigInteger.valueOf(d));
        Iteration iteration = new Iteration(a, BigInteger.ONE, k, d);
        while (!iteration.isSuccess()) {
            iteration = iteration.getNext();
        }

        return new Equation(iteration.a, iteration.b);
    }

    /**
     * Is x^2 – D*y^2 = 1?
     */
    public static boolean isSuccess(int d, BigInteger x, BigInteger y) {
        return x.pow(2).subtract(y.pow(2).multiply(BigInteger.valueOf(d))).compareTo(BigInteger.ONE) == 0;
    }

    @AllArgsConstructor
    @ToString
    private static class Iteration {
        private BigInteger a;
        private BigInteger b;
        private BigInteger k;
        private int d;

        private boolean isSuccess() {
            return k.compareTo(BigInteger.ONE) == 0;
        }

        // Update a, b and k to (am+Nb)/|k|, (a+bm)/|k|,(m^2-N)/k
        private Iteration getNext() {
            if (isSuccess()) {
                return this;
            }

            BigInteger m = getM();
            BigInteger newA = ((a.multiply(m)).add(b.multiply(BigInteger.valueOf(d)))).divide(k.abs());
            BigInteger newB = (a.add(b.multiply(m))).divide(k.abs());
            BigInteger newK = (m.pow(2).subtract(BigInteger.valueOf(d))).divide(k);
            return new Iteration(newA, newB, newK, d);
        }

        // At each iteration we find m > 0, such that k divides a + bm and |m^2 − d| minimall.
        private BigInteger getM() {
            BigInteger m = BigInteger.valueOf(-1);
            long min = d + 1;
            int last = (int) Math.sqrt(2 * d);
            for (int i = 1; i <= last; i++) {
                if (isMCorrect(BigInteger.valueOf(i))) {
                    long tmp = Math.abs(i * i - d);
                    if (tmp < min) {
                        min = tmp;
                        m = BigInteger.valueOf(i);
                    }
                }
            }

            if (m.compareTo(BigInteger.valueOf(-1)) > 0) {
                return m;
            }

            m = BigInteger.valueOf(last + 1);
            while (!isMCorrect(m)) {
                m = m.add(BigInteger.ONE);
            }

            return m;
        }

        private boolean isMCorrect(BigInteger m) {
            return (a.add(b.multiply(m)).abs()).mod(k.abs()).compareTo(BigInteger.ZERO) == 0;
        }
    }
}
