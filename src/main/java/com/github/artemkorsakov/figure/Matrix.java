package com.github.artemkorsakov.figure;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Matrix
 *
 * @see <a href="https://en.wikipedia.org/wiki/Matrix_(mathematics)">detailed description</a>
 */
public class Matrix {
    public static long dot(long[] x, long[] y) {
        if (x.length != y.length) {
            throw new IllegalArgumentException("Vector lengths should be equal");
        }
        return IntStream.range(0, x.length).parallel().mapToLong(i -> x[i] * y[i]).sum();
    }

    public static double dot(double[] x, double[] y) {
        if (x.length != y.length) {
            throw new IllegalArgumentException("Vector lengths should be equal");
        }
        return IntStream.range(0, x.length).parallel().mapToDouble(i -> x[i] * y[i]).sum();
    }

    public static BigInteger dot(BigInteger[] x, BigInteger[] y) {
        if (x.length != y.length) {
            throw new IllegalArgumentException("Vector lengths should be equal");
        }
        return IntStream.range(0, x.length).parallel().mapToObj(i -> x[i].multiply(y[i]))
                .reduce(BigInteger::add).orElse(BigInteger.ZERO);
    }

    /**
     * The <a href="https://en.wikipedia.org/wiki/Transpose">transpose</a> of a matrix.
     */
    public static long[][] transpose(long[][] a) {
        long[][] b = new long[a[0].length][];

        for (int i = 0; i < b.length; i++) {
            b[i] = new long[a.length];
            for (int j = 0; j < a.length; j++) {
                b[i][j] = a[j][i];
            }
        }

        return b;
    }

    /**
     * {@link Matrix#transpose(long[][]) transpose
     */
    public static double[][] transpose(double[][] a) {
        double[][] b = new double[a[0].length][];

        for (int i = 0; i < b.length; i++) {
            b[i] = new double[a.length];
            for (int j = 0; j < a.length; j++) {
                b[i][j] = a[j][i];
            }
        }

        return b;
    }

    /**
     * {@link Matrix#transpose(long[][]) transpose
     */
    public static BigInteger[][] transpose(BigInteger[][] a) {
        BigInteger[][] b = new BigInteger[a[0].length][];

        for (int i = 0; i < b.length; i++) {
            b[i] = new BigInteger[a.length];
            for (int j = 0; j < a.length; j++) {
                b[i][j] = a[j][i];
            }
        }

        return b;
    }

    /**
     * The <a href="https://en.wikipedia.org/wiki/Determinant">determinant</a> of a matrix.
     */
    public static long det(long[][] a) {
        if (a.length == 0 || Arrays.stream(a).anyMatch(i -> i.length != a.length)) {
            throw new IllegalArgumentException("Matrix is not a square matrix!");
        }

        if (a.length == 1) {
            return a[0][0];
        }

        long det = 0;

        for (int i = 0; i < a[0].length; i++) {
            det += Math.pow(-1, i) * a[0][i] * det(minor(a, 0, i));
        }

        return det;
    }

    /**
     * {@link Matrix#det(long[][])}  determinant
     */
    public static double det(double[][] a) {
        if (a.length == 0 || Arrays.stream(a).anyMatch(i -> i.length != a.length)) {
            throw new IllegalArgumentException("Matrix is not a square matrix!");
        }

        if (a.length == 1) {
            return a[0][0];
        }

        double det = 0;

        for (int i = 0; i < a[0].length; i++) {
            det += Math.pow(-1, i) * a[0][i] * det(minor(a, 0, i));
        }

        return det;
    }

    /**
     * {@link Matrix#det(long[][])}  determinant
     */
    public static BigInteger det(BigInteger[][] a) {
        if (a.length == 0 || Arrays.stream(a).anyMatch(i -> i.length != a.length)) {
            throw new IllegalArgumentException("Matrix is not a square matrix!");
        }

        if (a.length == 1) {
            return a[0][0];
        }

        BigInteger det = BigInteger.ZERO;

        for (int i = 0; i < a[0].length; i++) {
            det = det.add(BigInteger.valueOf((long) Math.pow(-1, i)).multiply(a[0][i].multiply(det(minor(a, 0, i)))));
        }

        return det;
    }

    public static long[][] minor(long[][] a, int row, int column) {
        if (a.length == 0 || Arrays.stream(a).anyMatch(i -> i.length != a.length)) {
            throw new IllegalArgumentException("Minor exists only for a square matrix!");
        }

        if (row < 0 || row >= a.length || column < 0 || column >= a[0].length) {
            throw new IllegalArgumentException("Invalid row or column");
        }

        long[][] b = new long[a.length - 1][a[0].length - 1];

        for (int i = 0; i < a.length; i++) {
            if (i != row) {
                for (int j = 0; j < a[0].length; j++) {
                    if (j != column) {
                        b[i < row ? i : i - 1][j < column ? j : j - 1] = a[i][j];
                    }
                }
            }
        }

        return b;
    }

    public static double[][] minor(double[][] a, int row, int column) {
        if (a.length == 0 || Arrays.stream(a).anyMatch(i -> i.length != a.length)) {
            throw new IllegalArgumentException("Minor exists only for a square matrix!");
        }

        if (row < 0 || row >= a.length || column < 0 || column >= a[0].length) {
            throw new IllegalArgumentException("Invalid row or column");
        }

        double[][] b = new double[a.length - 1][a[0].length - 1];

        for (int i = 0; i < a.length; i++) {
            if (i != row) {
                for (int j = 0; j < a[0].length; j++) {
                    if (j != column) {
                        b[i < row ? i : i - 1][j < column ? j : j - 1] = a[i][j];
                    }
                }
            }
        }

        return b;
    }

    public static BigInteger[][] minor(BigInteger[][] a, int row, int column) {
        if (a.length == 0 || Arrays.stream(a).anyMatch(i -> i.length != a.length)) {
            throw new IllegalArgumentException("Minor exists only for a square matrix!");
        }

        if (row < 0 || row >= a.length || column < 0 || column >= a[0].length) {
            throw new IllegalArgumentException("Invalid row or column");
        }

        BigInteger[][] b = new BigInteger[a.length - 1][a[0].length - 1];

        for (int i = 0; i < a.length; i++) {
            if (i != row) {
                for (int j = 0; j < a[0].length; j++) {
                    if (j != column) {
                        b[i < row ? i : i - 1][j < column ? j : j - 1] = a[i][j];
                    }
                }
            }
        }

        return b;
    }

    public static long[][] add(long[][] a, long[][] b) {
        if (a.length != b.length || IntStream.range(0, a.length).anyMatch(i -> a[i].length != b[i].length)) {
            throw new IllegalArgumentException("Matrix size must be the same");
        }

        long[][] c = new long[a.length][];
        for (int i = 0; i < c.length; i++) {
            c[i] = new long[a[0].length];
            for (int j = 0; j < c[i].length; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }

        return c;
    }

    public static double[][] add(double[][] a, double[][] b) {
        if (a.length != b.length || IntStream.range(0, a.length).anyMatch(i -> a[i].length != b[i].length)) {
            throw new IllegalArgumentException("Matrix size must be the same");
        }

        double[][] c = new double[a.length][];
        for (int i = 0; i < c.length; i++) {
            c[i] = new double[a[0].length];
            for (int j = 0; j < c[i].length; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }

        return c;
    }

    public static BigInteger[][] add(BigInteger[][] a, BigInteger[][] b) {
        if (a.length != b.length || IntStream.range(0, a.length).anyMatch(i -> a[i].length != b[i].length)) {
            throw new IllegalArgumentException("Matrix size must be the same");
        }

        BigInteger[][] c = new BigInteger[a.length][];
        for (int i = 0; i < c.length; i++) {
            c[i] = new BigInteger[a[0].length];
            for (int j = 0; j < c[i].length; j++) {
                c[i][j] = a[i][j].add(b[i][j]);
            }
        }

        return c;
    }

    public static long[][] mult(long[][] a, long b) {
        long[][] c = new long[a.length][];
        for (int i = 0; i < c.length; i++) {
            c[i] = new long[a[0].length];
            for (int j = 0; j < c[i].length; j++) {
                c[i][j] = b * a[i][j];
            }
        }

        return c;
    }

    public static double[][] mult(double[][] a, double b) {
        double[][] c = new double[a.length][];
        for (int i = 0; i < c.length; i++) {
            c[i] = new double[a[0].length];
            for (int j = 0; j < c[i].length; j++) {
                c[i][j] = b * a[i][j];
            }
        }

        return c;
    }

    public static BigInteger[][] mult(BigInteger[][] a, BigInteger b) {
        BigInteger[][] c = new BigInteger[a.length][];
        for (int i = 0; i < c.length; i++) {
            c[i] = new BigInteger[a[0].length];
            for (int j = 0; j < c[i].length; j++) {
                c[i][j] = a[i][j].multiply(b);
            }
        }

        return c;
    }

    public static long[] mult(long[][] a, long[] b) {
        return Arrays.stream(mult(a, new long[][]{b})).mapToLong(r -> r[0]).toArray();
    }

    public static double[] mult(double[][] a, double[] b) {
        return Arrays.stream(mult(a, new double[][]{b})).mapToDouble(r -> r[0]).toArray();
    }

    public static BigInteger[] mult(BigInteger[][] a, BigInteger[] b) {
        return Arrays.stream(mult(a, new BigInteger[][]{b})).map(r -> r[0]).toArray(BigInteger[]::new);
    }

    public static long[] mult(long[] a, long[][] b) {
        return mult(new long[][]{a}, b)[0];
    }

    public static double[] mult(double[] a, double[][] b) {
        return mult(new double[][]{a}, b)[0];
    }

    public static BigInteger[] mult(BigInteger[] a, BigInteger[][] b) {
        return mult(new BigInteger[][]{a}, b)[0];
    }

    /**
     * <a href="https://en.wikipedia.org/wiki/Matrix_multiplication">multiplication</a>
     */
    public static long[][] mult(long[][] a, long[][] b) {
        return null;
    }

    /**
     * {@link Matrix#mult(long[][], long[])} multiplication
     */
    public static double[][] mult(double[][] a, double[][] b) {
        return null;
    }

    /**
     * {@link Matrix#mult(long[][], long[])} multiplication
     */
    public static BigInteger[][] mult(BigInteger[][] a, BigInteger[][] b) {
        return null;
    }

    public static long[][] power(long[][] a, long b) {
        return null;
    }

    public static double[][] power(double[][] a, long b) {
        return null;
    }

    public static BigInteger[][] power(BigInteger[][] a, BigInteger b) {
        return null;
    }

}
