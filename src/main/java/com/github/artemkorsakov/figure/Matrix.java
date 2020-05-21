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
        return IntStream.range(0, x.length).parallel()
                .filter(i -> x[i] != 0 && y[i] != 0)
                .mapToLong(i -> x[i] * y[i])
                .sum();
    }

    public static double dot(double[] x, double[] y) {
        if (x.length != y.length) {
            throw new IllegalArgumentException("Vector lengths should be equal");
        }
        return IntStream.range(0, x.length).parallel()
                .filter(i -> x[i] != 0 && y[i] != 0)
                .mapToDouble(i -> x[i] * y[i]).sum();
    }

    public static BigInteger dot(BigInteger[] x, BigInteger[] y) {
        if (x.length != y.length) {
            throw new IllegalArgumentException("Vector lengths should be equal");
        }
        return IntStream.range(0, x.length).parallel()
                .filter(i -> !x[i].equals(BigInteger.ZERO) && !y[i].equals(BigInteger.ZERO))
                .mapToObj(i -> x[i].multiply(y[i]))
                .reduce(BigInteger::add).orElse(BigInteger.ZERO);
    }

    public static long dotMod(long[] x, long[] y, long module) {
        if (x.length != y.length) {
            throw new IllegalArgumentException("Vector lengths should be equal");
        }
        return IntStream.range(0, x.length).parallel()
                .filter(i -> x[i] != 0 && y[i] != 0)
                .mapToLong(i -> BigInteger.valueOf(x[i]).multiply(BigInteger.valueOf(y[i])).mod(BigInteger.valueOf(module)).longValueExact())
                .reduce((l1, l2) -> l1 = (l1 + l2) % module).orElse(0);
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

    public static long[][] multMod(long[][] a, long b, long module) {
        long[][] c = new long[a.length][];
        for (int i = 0; i < c.length; i++) {
            c[i] = new long[a[0].length];
            for (int j = 0; j < c[i].length; j++) {
                c[i][j] = b * a[i][j] % module;
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

    public static long[] multMod(long[][] a, long[] b, long module) {
        return Arrays.stream(multMod(a, new long[][]{b}, module)).mapToLong(r -> r[0]).toArray();
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

    public static long[] multMod(long[] a, long[][] b, long module) {
        return multMod(new long[][]{a}, b, module)[0];
    }

    /**
     * <a href="https://en.wikipedia.org/wiki/Matrix_multiplication">multiplication</a>
     */
    public static long[][] mult(long[][] a, long[][] b) {
        if (a.length == 0 || b.length == 0 || Arrays.stream(a).anyMatch(i -> i.length != a[0].length)
                || Arrays.stream(b).anyMatch(i -> i.length != b[0].length) || a[0].length != b.length) {
            throw new IllegalArgumentException();
        }

        long[][] c = new long[a.length][b[0].length];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                long[] x = a[i];
                int finalJ = j;
                long[] y = Arrays.stream(b).mapToLong(col -> col[finalJ]).toArray();
                c[i][j] = dot(x, y);
            }
        }

        return c;
    }

    /**
     * {@link Matrix#mult(long[][], long[])} multiplication
     */
    public static double[][] mult(double[][] a, double[][] b) {
        if (a.length == 0 || b.length == 0 || Arrays.stream(a).anyMatch(i -> i.length != a[0].length)
                || Arrays.stream(b).anyMatch(i -> i.length != b[0].length) || a[0].length != b.length) {
            throw new IllegalArgumentException();
        }

        double[][] c = new double[a.length][b[0].length];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                double[] x = a[i];
                int finalJ = j;
                double[] y = Arrays.stream(b).mapToDouble(col -> col[finalJ]).toArray();
                c[i][j] = dot(x, y);
            }
        }

        return c;
    }

    /**
     * {@link Matrix#mult(long[][], long[])} multiplication
     */
    public static BigInteger[][] mult(BigInteger[][] a, BigInteger[][] b) {
        if (a.length == 0 || b.length == 0 || Arrays.stream(a).anyMatch(i -> i.length != a[0].length)
                || Arrays.stream(b).anyMatch(i -> i.length != b[0].length) || a[0].length != b.length) {
            throw new IllegalArgumentException();
        }

        BigInteger[][] c = new BigInteger[a.length][b[0].length];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                BigInteger[] x = a[i];
                int finalJ = j;
                BigInteger[] y = Arrays.stream(b).map(col -> col[finalJ]).toArray(BigInteger[]::new);
                c[i][j] = dot(x, y);
            }
        }

        return c;
    }

    /**
     * {@link Matrix#mult(long[][], long[])} multiplication
     */
    public static long[][] multMod(long[][] a, long[][] b, long module) {
        if (a.length == 0 || b.length == 0 || Arrays.stream(a).anyMatch(i -> i.length != a[0].length)
                || Arrays.stream(b).anyMatch(i -> i.length != b[0].length) || a[0].length != b.length) {
            throw new IllegalArgumentException();
        }

        long[][] c = new long[a.length][b[0].length];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                long[] x = a[i];
                int finalJ = j;
                long[] y = Arrays.stream(b).parallel().mapToLong(col -> col[finalJ]).toArray();
                c[i][j] = dotMod(x, y, module);
            }
        }

        return c;
    }

    public static long[][] power(long[][] a, long b) {
        if (b < 1) {
            throw new IllegalArgumentException();
        }
        if (b == 1) {
            return a;
        }

        String powers = Long.toBinaryString(b);
        long[][][] powersC = new long[powers.length()][][];
        powersC[0] = a;
        for (int i = 1; i < powersC.length; i++) {
            powersC[i] = mult(powersC[i - 1], powersC[i - 1]);
        }

        long[][] c = powersC[powersC.length - 1];

        for (int i = 1; i < powers.length(); i++) {
            if (powers.charAt(i) == '1') {
                c = mult(c, powersC[powersC.length - 1 - i]);
            }
        }

        return c;
    }

    public static double[][] power(double[][] a, long b) {
        if (b < 1) {
            throw new IllegalArgumentException();
        }
        if (b == 1) {
            return a;
        }

        String powers = Long.toBinaryString(b);
        double[][][] powersC = new double[powers.length()][][];
        powersC[0] = a;
        for (int i = 1; i < powersC.length; i++) {
            powersC[i] = mult(powersC[i - 1], powersC[i - 1]);
        }

        double[][] c = powersC[powersC.length - 1];

        for (int i = 1; i < powers.length(); i++) {
            if (powers.charAt(i) == '1') {
                c = mult(c, powersC[powersC.length - 1 - i]);
            }
        }

        return c;
    }

    public static BigInteger[][] power(BigInteger[][] a, long b) {
        if (b < 1) {
            throw new IllegalArgumentException();
        }
        if (b == 1) {
            return a;
        }

        String powers = Long.toBinaryString(b);
        BigInteger[][][] powersC = new BigInteger[powers.length()][][];
        powersC[0] = a;
        for (int i = 1; i < powersC.length; i++) {
            powersC[i] = mult(powersC[i - 1], powersC[i - 1]);
        }

        BigInteger[][] c = powersC[powersC.length - 1];

        for (int i = 1; i < powers.length(); i++) {
            if (powers.charAt(i) == '1') {
                c = mult(c, powersC[powersC.length - 1 - i]);
            }
        }

        return c;
    }

    public static long[][] powerMod(long[][] a, long b, long module) {
        if (b < 1) {
            throw new IllegalArgumentException();
        }
        if (b == 1) {
            return a;
        }

        String powers = Long.toBinaryString(b);
        long[][][] powersC = new long[powers.length()][][];
        powersC[0] = a;
        for (int i = 1; i < powersC.length; i++) {
            powersC[i] = multMod(powersC[i - 1], powersC[i - 1], module);
        }

        long[][] c = powersC[powersC.length - 1];

        for (int i = 1; i < powers.length(); i++) {
            if (powers.charAt(i) == '1') {
                c = multMod(c, powersC[powersC.length - 1 - i], module);
            }
        }

        return c;
    }

}
