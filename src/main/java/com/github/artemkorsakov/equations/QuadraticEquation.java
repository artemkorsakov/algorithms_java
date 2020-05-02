package com.github.artemkorsakov.equations;

import com.github.artemkorsakov.numbers.ComplexNumber;

/**
 * a*x^2 + b*x + c = 0;
 *
 * @see <a href="https://en.wikipedia.org/wiki/Quadratic_equation">detailed description</a>
 */
public class QuadraticEquation {
    /**
     * x = (-b +/- sqrt(b^2 - 4ac))/2a
     */
    public static int[] getSolutionsInIntegers(int a, int b, int c) {
        return null;
    }

    /**
     * x = (-b +/- sqrt(b^2 - 4ac))/2a
     */
    public static double[] getSolutionsInDoubles(int a, int b, int c) {
        return null;
    }

    /**
     * x = -b/2a +/- (sqrt(4ac - b^2)/2a)i
     */
    public static ComplexNumber[] getSolutionsInComplexNumbers(int a, int b, int c) {
        return null;
    }
}
