package com.github.artemkorsakov.numbers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A Pythagorean triplet is a set of three natural numbers, a &lt; b &lt; c, for which, a^2 + b^2 = c^2
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PythagoreanTriplet {
    private int a;
    private int b;
    private int c;

    public PythagoreanTriplet(int[] array) {
        if (array.length != 3) {
            throw new IllegalArgumentException();
        }

        a = array[0];
        b = array[1];
        c = array[2];
    }

    public int[] toArray() {
        return new int[]{a, b, c};
    }

}
