package com.github.artemkorsakov.equations;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigInteger;

public class DiophantineEquationTests {
    @Test
    public void testGetMinimalEquation() {
        Assert.assertEquals(DiophantineEquation.getMinimalEquation(67),
                new Equation(BigInteger.valueOf(48842), BigInteger.valueOf(5967)));
        Assert.assertEquals(DiophantineEquation.getMinimalEquation(13),
                new Equation(BigInteger.valueOf(649), BigInteger.valueOf(180)));
        Assert.assertEquals(DiophantineEquation.getMinimalEquation(2),
                new Equation(BigInteger.valueOf(3), BigInteger.valueOf(2)));
        Assert.assertEquals(DiophantineEquation.getMinimalEquation(3),
                new Equation(BigInteger.valueOf(2), BigInteger.valueOf(1)));
        Assert.assertEquals(DiophantineEquation.getMinimalEquation(5),
                new Equation(BigInteger.valueOf(9), BigInteger.valueOf(4)));
        Assert.assertEquals(DiophantineEquation.getMinimalEquation(6),
                new Equation(BigInteger.valueOf(5), BigInteger.valueOf(2)));
        Assert.assertEquals(DiophantineEquation.getMinimalEquation(7),
                new Equation(BigInteger.valueOf(8), BigInteger.valueOf(3)));
        Assert.assertNull(DiophantineEquation.getMinimalEquation(4));
        Assert.assertNull(DiophantineEquation.getMinimalEquation(9));
        Assert.assertEquals(DiophantineEquation.getMinimalEquation(61),
                new Equation(BigInteger.valueOf(1766319049), BigInteger.valueOf(226153980)));
        Assert.assertEquals(DiophantineEquation.getMinimalEquation(73),
                new Equation(BigInteger.valueOf(2281249), BigInteger.valueOf(267000)));
        Assert.assertEquals(DiophantineEquation.getMinimalEquation(94),
                new Equation(BigInteger.valueOf(2143295), BigInteger.valueOf(221064)));
        Assert.assertEquals(DiophantineEquation.getMinimalEquation(109),
                new Equation(BigInteger.valueOf(158070671986249L), BigInteger.valueOf(15140424455100L)));
        Assert.assertEquals(DiophantineEquation.getMinimalEquation(110),
                new Equation(BigInteger.valueOf(21), BigInteger.valueOf(2)));
    }

    @Test
    public void testIsSuccess() {
        Assert.assertTrue(DiophantineEquation.isSuccess(61, BigInteger.valueOf(1766319049), BigInteger.valueOf(226153980)));
    }

}
