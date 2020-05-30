package com.github.artemkorsakov.numbers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A Pythagorean triplet is a set of three natural numbers, a &lt; b &lt; c, for which, a^2 + b^2 = c^2
 * a=m^2-n^2,
 * b=2mn,
 * c=m^2+n^2
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PythagoreanDeuce {
    private long m;
    private long n;

    public PythagoreanDeuce(long[] array) {
        if (array.length != 2) {
            throw new IllegalArgumentException();
        }

        m = array[0];
        n = array[1];
    }

    public long[] toArray() {
        return new long[]{m, n};
    }

    public long[][] toColumn() {
        return new long[][]{new long[]{m}, new long[]{n}};
    }

    public PythagoreanTripletLong toPythagoreanTripletLong() {
        long a = m * m - n * n;
        long b = 2 * m * n;
        long c = m * m + n * n;
        return new PythagoreanTripletLong(a, b, c);
    }

}
