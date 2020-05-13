package com.github.artemkorsakov.numbers;

import com.github.artemkorsakov.divisors.Divisors;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * A Pythagorean triplet is a set of three natural numbers, a &lt; b &lt; c, for which, a^2 + b^2 = c^2
 */
@Data
public class PythagoreanTripletHelper {
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
}
