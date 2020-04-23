package com.github.artemkorsakov.equations;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.github.artemkorsakov.equations.PolynomialEquation.getPolynomialSolution;

public class PolynomialEquationTests {
    @Test
    public void test() {
        long[] expected = new long[]{1, 683, 44287, 838861, 8138021, 51828151,
                247165843, 954437177, 3138105961L, 9090909091L, 23775972551L, 57154490053L, 128011456717L,
                269971011311L, 540609741211L, 1034834473201L, 1903994239313L, 3382547898907L, 5824512944911L};
        long[] temp = getGoodPolynomialArrayTemp();

        long[] aList = PolynomialEquation.getPolynomialCoefficients(2, temp);
        Assert.assertEquals(getPolynomialSolution(1, aList), 1.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(2, aList), 8.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(3, aList), 15.0, 0.0001);

        aList = PolynomialEquation.getPolynomialCoefficients(3, temp);
        Assert.assertEquals(getPolynomialSolution(1, aList), 1.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(2, aList), 8.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(3, aList), 27.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(4, aList), 58.0, 0.0001);

        aList = PolynomialEquation.getPolynomialCoefficients(1, expected);
        Assert.assertEquals(getPolynomialSolution(1, aList), 1.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(2, aList), 1.0, 0.0001);

        aList = PolynomialEquation.getPolynomialCoefficients(2, expected);
        Assert.assertEquals(getPolynomialSolution(1, aList), 1.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(2, aList), 683.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(3, aList), 1365.0, 0.0001);

        aList = PolynomialEquation.getPolynomialCoefficients(3, expected);
        Assert.assertEquals(getPolynomialSolution(1, aList), 1.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(2, aList), 683.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(3, aList), 44287.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(4, aList), 130813.0, 0.0001);

        aList = PolynomialEquation.getPolynomialCoefficients(4, expected);
        Assert.assertEquals(getPolynomialSolution(1, aList), 1.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(2, aList), 683.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(3, aList), 44287.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(4, aList), 838861.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(5, aList), 3092453.0, 0.0001);

        aList = PolynomialEquation.getPolynomialCoefficients(5, expected);
        Assert.assertEquals(getPolynomialSolution(1, aList), 1.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(2, aList), 683.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(3, aList), 44287.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(4, aList), 838861.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(5, aList), 8138021.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(6, aList), 32740951);

        aList = PolynomialEquation.getPolynomialCoefficients(6, expected);
        Assert.assertEquals(getPolynomialSolution(1, aList), 1.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(2, aList), 683.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(3, aList), 44287.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(4, aList), 838861.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(5, aList), 8138021.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(6, aList), 51828151.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(7, aList), 205015603);

        aList = PolynomialEquation.getPolynomialCoefficients(7, expected);
        Assert.assertEquals(getPolynomialSolution(1, aList), 1.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(2, aList), 683.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(3, aList), 44287.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(4, aList), 838861.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(5, aList), 8138021.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(6, aList), 51828151.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(7, aList), 247165843.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(8, aList), 898165577);

        aList = PolynomialEquation.getPolynomialCoefficients(8, expected);
        Assert.assertEquals(getPolynomialSolution(1, aList), 1.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(2, aList), 683.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(3, aList), 44287.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(4, aList), 838861.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(5, aList), 8138021.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(6, aList), 51828151.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(7, aList), 247165843.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(8, aList), 954437177.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(9, aList), 3093310441L);

        aList = PolynomialEquation.getPolynomialCoefficients(9, expected);
        Assert.assertEquals(getPolynomialSolution(1, aList), 1.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(2, aList), 683.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(3, aList), 44287.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(4, aList), 838861.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(5, aList), 8138021.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(6, aList), 51828151.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(7, aList), 247165843.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(8, aList), 954437177.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(9, aList), 3138105961.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(10, aList), 9071313571L);

        aList = PolynomialEquation.getPolynomialCoefficients(10, expected);
        Assert.assertEquals(getPolynomialSolution(1, aList), 1.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(2, aList), 683.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(3, aList), 44287.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(4, aList), 838861.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(5, aList), 8138021.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(6, aList), 51828151.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(7, aList), 247165843.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(8, aList), 954437177.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(9, aList), 3138105961.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(10, aList), 9090909091.0, 0.0001);
        Assert.assertEquals(getPolynomialSolution(11, aList), 23772343751L);
    }

    private long[] getGoodPolynomialArrayTemp() {
        long[] result = new long[10];
        for (int i = 0; i < result.length; i++) {
            result[i] = (long) Math.pow(i + 1, 3);
        }
        return result;
    }
}
