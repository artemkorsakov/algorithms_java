package com.github.artemkorsakov.equations;

import com.github.artemkorsakov.numbers.ComplexNumber;
import org.testng.Assert;
import org.testng.annotations.Test;

public class QuadraticEquationTests {
    @Test
    public void testGetSolutionsInIntegers() {
        long[] solutions = QuadraticEquation.getSolutionsInIntegers(1, -5, 6);
        Assert.assertEquals(solutions.length, 2);
        Assert.assertEquals(solutions[0], 3);
        Assert.assertEquals(solutions[1], 2);

        solutions = QuadraticEquation.getSolutionsInIntegers(1, -5, -6);
        Assert.assertEquals(solutions.length, 2);
        Assert.assertEquals(solutions[0], 6);
        Assert.assertEquals(solutions[1], -1);

        solutions = QuadraticEquation.getSolutionsInIntegers(4, -8, 4);
        Assert.assertEquals(solutions.length, 1);
        Assert.assertEquals(solutions[0], 1);

        solutions = QuadraticEquation.getSolutionsInIntegers(1, -5, 7);
        Assert.assertEquals(solutions.length, 0);

        solutions = QuadraticEquation.getSolutionsInIntegers(1, -5, 5);
        Assert.assertEquals(solutions.length, 0);

        solutions = QuadraticEquation.getSolutionsInIntegers(3, -4, 1);
        Assert.assertEquals(solutions.length, 1);
        Assert.assertEquals(solutions[0], 1);

        solutions = QuadraticEquation.getSolutionsInIntegers(3, 4, 1);
        Assert.assertEquals(solutions.length, 1);
        Assert.assertEquals(solutions[0], -1);
    }

    @Test
    public void testGetSolutionsInDoubles() {
        double[] solutions = QuadraticEquation.getSolutionsInDoubles(1, -5, 6);
        Assert.assertEquals(solutions.length, 2);
        Assert.assertEquals(solutions[0], 3);
        Assert.assertEquals(solutions[1], 2);

        solutions = QuadraticEquation.getSolutionsInDoubles(1, -5, -6);
        Assert.assertEquals(solutions.length, 2);
        Assert.assertEquals(solutions[0], 6);
        Assert.assertEquals(solutions[1], -1);

        solutions = QuadraticEquation.getSolutionsInDoubles(1, -2, 1);
        Assert.assertEquals(solutions.length, 1);
        Assert.assertEquals(solutions[0], 1);

        solutions = QuadraticEquation.getSolutionsInDoubles(1, -5, 7);
        Assert.assertEquals(solutions.length, 0);

        solutions = QuadraticEquation.getSolutionsInDoubles(1, -5, 5);
        Assert.assertEquals(solutions.length, 2);
        Assert.assertEquals(solutions[0], (5 + Math.sqrt(5)) / 2.0);
        Assert.assertEquals(solutions[1], (5 - Math.sqrt(5)) / 2.0);

        solutions = QuadraticEquation.getSolutionsInDoubles(3, -4, 1);
        Assert.assertEquals(solutions.length, 2);
        Assert.assertEquals(solutions[0], 1);
        Assert.assertEquals(solutions[1], 1.0 / 3.0);

        solutions = QuadraticEquation.getSolutionsInDoubles(3, 4, 1);
        Assert.assertEquals(solutions.length, 2);
        Assert.assertEquals(solutions[0], -1.0 / 3.0);
        Assert.assertEquals(solutions[1], -1);
    }

    @Test
    public void testGetSolutionsInComplexNumbers() {
        ComplexNumber[] solutions = QuadraticEquation.getSolutionsInComplexNumbers(1, -2, 2);
        Assert.assertEquals(solutions.length, 2);
        Assert.assertEquals(solutions[0], new ComplexNumber(1, 1));
        Assert.assertEquals(solutions[1], new ComplexNumber(1, -1));

        solutions = QuadraticEquation.getSolutionsInComplexNumbers(3, 4, 1);
        Assert.assertEquals(solutions.length, 2);
        Assert.assertEquals(solutions[0], new ComplexNumber(-1.0 / 3.0, 0.0));
        Assert.assertEquals(solutions[1], new ComplexNumber(-1, 0.0));
    }
}
