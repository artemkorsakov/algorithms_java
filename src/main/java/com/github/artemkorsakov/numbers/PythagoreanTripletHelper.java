package com.github.artemkorsakov.numbers;

import com.github.artemkorsakov.divisors.Divisors;
import com.github.artemkorsakov.figure.Matrix;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * A Pythagorean triplet is a set of three natural numbers, a &lt; b &lt; c, for which, a^2 + b^2 = c^2
 */
@Data
public class PythagoreanTripletHelper {
    public static final PythagoreanTripletLong PRIMITIVE_PYTHAGOREAN_TRIPLET = new PythagoreanTripletLong(3, 4, 5);
    public static final long[][] A_MATRIX = new long[][]{new long[]{1, -2, 2}, new long[]{2, -1, 2}, new long[]{2, -2, 3}};
    public static final long[][] B_MATRIX = new long[][]{new long[]{1, 2, 2}, new long[]{2, 1, 2}, new long[]{2, 2, 3}};
    public static final long[][] C_MATRIX = new long[][]{new long[]{-1, 2, 2}, new long[]{-2, 1, 2}, new long[]{-2, 2, 3}};
    public static final PythagoreanDeuce PRIMITIVE_PYTHAGOREAN_DEUCE = new PythagoreanDeuce(2, 1);
    public static final long[][] A_DEUCE_MATRIX = new long[][]{new long[]{2, -1}, new long[]{1, 0}};
    public static final long[][] B_DEUCE_MATRIX = new long[][]{new long[]{2, 1}, new long[]{1, 0}};
    public static final long[][] C_DEUCE_MATRIX = new long[][]{new long[]{1, 2}, new long[]{0, 1}};

    /**
     * <a href="https://projecteuler.net/overview=009">detailed description</a>
     */
    public static List<PythagoreanTriplet> getAllPythagoreanTriplet(int sum) {
        List<PythagoreanTriplet> pythagoreanTriplets = new ArrayList<>();

        int s2 = sum / 2;
        int sqrt = (int) Math.sqrt(s2);
        int mLimit = sqrt * sqrt == s2 ? sqrt - 1 : sqrt;

        for (int m = 2; m <= mLimit; m++) {
            if (s2 % m == 0) {
                int sm = s2 / m;
                while (sm % 2 == 0) { // reduce the search space by
                    sm = sm / 2; // removing all factors 2
                }
                int k = m % 2 == 1 ? m + 2 : m + 1;
                while (k < 2 * m && k <= sm) {
                    if (sm % k == 0 && Divisors.gcd(k, m) == 1) {
                        int d = s2 / (k * m);
                        int n = k - m;
                        int a = d * (m * m - n * n);
                        int b = 2 * d * m * n;
                        int c = d * (m * m + n * n);
                        pythagoreanTriplets.add(a < b ? new PythagoreanTriplet(a, b, c) : new PythagoreanTriplet(b, a, c));
                    }
                    k += 2;
                }
            }
        }

        return pythagoreanTriplets;
    }

    /**
     * https://en.wikipedia.org/wiki/Tree_of_primitive_Pythagorean_triples
     */
    public static PythagoreanTripletLong[] getNextPythagoreanTriplets(PythagoreanTripletLong pythagoreanTriplet) {
        PythagoreanTripletLong[] pythagoreanTriplets = new PythagoreanTripletLong[3];
        long[][] mult = Matrix.mult(A_MATRIX, pythagoreanTriplet.toColumn());
        pythagoreanTriplets[0] = new PythagoreanTripletLong(mult[0][0], mult[1][0], mult[2][0]);
        mult = Matrix.mult(B_MATRIX, pythagoreanTriplet.toColumn());
        pythagoreanTriplets[1] = new PythagoreanTripletLong(mult[0][0], mult[1][0], mult[2][0]);
        mult = Matrix.mult(C_MATRIX, pythagoreanTriplet.toColumn());
        pythagoreanTriplets[2] = new PythagoreanTripletLong(mult[0][0], mult[1][0], mult[2][0]);
        return pythagoreanTriplets;
    }

    /**
     * https://en.wikipedia.org/wiki/Tree_of_primitive_Pythagorean_triples
     */
    public static PythagoreanDeuce[] getNextPythagoreanDeuce(PythagoreanDeuce pythagoreanDeuce) {
        PythagoreanDeuce[] pythagoreanTriplets = new PythagoreanDeuce[3];
        long[][] mult = Matrix.mult(A_DEUCE_MATRIX, pythagoreanDeuce.toColumn());
        pythagoreanTriplets[0] = new PythagoreanDeuce(mult[0][0], mult[1][0]);
        mult = Matrix.mult(B_DEUCE_MATRIX, pythagoreanDeuce.toColumn());
        pythagoreanTriplets[1] = new PythagoreanDeuce(mult[0][0], mult[1][0]);
        mult = Matrix.mult(C_DEUCE_MATRIX, pythagoreanDeuce.toColumn());
        pythagoreanTriplets[2] = new PythagoreanDeuce(mult[0][0], mult[1][0]);
        return pythagoreanTriplets;
    }

}
