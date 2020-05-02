package com.github.artemkorsakov.equations;

import com.github.artemkorsakov.numbers.ComplexNumber;
import com.github.artemkorsakov.operations.Squares;

import java.util.Arrays;

/**
 * a*x^2 + b*x + c = 0;
 *
 * @see <a href="https://en.wikipedia.org/wiki/Quadratic_equation">detailed description</a>
 */
public class QuadraticEquation {
    /**
     * x = (-b +/- sqrt(b^2 - 4ac))/2a
     */
    public static long[] getSolutionsInIntegers(long a, long b, long c) {
        long d = b * b - 4 * a * c;
        long den = 2 * a;
        if (d < 0 || !Squares.isSquare(d)) {
            return new long[]{};
        }

        long sqrt = Math.round(Math.sqrt(d));
        if (sqrt == 0) {
            return b % den == 0 ? new long[]{-b / den} : new long[]{};
        }

        if ((-b + sqrt) % den == 0 && (-b - sqrt) % den == 0) {
            long[] solutions = new long[2];
            solutions[0] = (-b + sqrt) / den;
            solutions[1] = (-b - sqrt) / den;
            return solutions;
        }
        if ((-b + sqrt) % den == 0) {
            return new long[]{(-b + sqrt) / den};
        }
        if ((-b - sqrt) % den == 0) {
            return new long[]{(-b - sqrt) / den};

        }
        return new long[]{};
    }

    /**
     * x = (-b +/- sqrt(b^2 - 4ac))/2a
     */
    public static double[] getSolutionsInDoubles(double a, double b, double c) {
        double d = b * b - 4 * a * c;
        double den = 2 * a;
        if (d < 0) {
            return new double[]{};
        }

        double sqrt = Math.sqrt(d);
        if (sqrt == 0) {
            return new double[]{-b / den};
        }

        double[] solutions = new double[2];
        solutions[0] = (-b + sqrt) / den;
        solutions[1] = (-b - sqrt) / den;
        return solutions;
    }

    /**
     * x = -b/2a +/- (sqrt(4ac - b^2)/2a)i
     */
    public static ComplexNumber[] getSolutionsInComplexNumbers(double a, double b, double c) {
        double d = b * b - 4 * a * c;
        if (d >= 0) {
            return Arrays.stream(getSolutionsInDoubles(a, b, c))
                    .mapToObj(s -> new ComplexNumber(s, 0.0)).toArray(ComplexNumber[]::new);
        }

        double sqrt = Math.sqrt(-d);
        double den = 2 * a;
        ComplexNumber[] solutions = new ComplexNumber[2];
        solutions[0] = new ComplexNumber(-b / den, sqrt / den);
        solutions[1] = new ComplexNumber(-b / den, -sqrt / den);
        return solutions;
    }
}
