package com.github.artemkorsakov.numbers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A Pythagorean triplet is a set of three natural numbers, a &lt; b &lt; c, for which, a^2 + b^2 = c^2
 * a less b less c   therefore   a less sum / 3; b less (sum - 1) / 2
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PythagoreanTriplet {
    private int a;
    private int b;
    private int c;
}
