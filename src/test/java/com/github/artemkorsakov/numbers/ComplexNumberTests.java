package com.github.artemkorsakov.numbers;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ComplexNumberTests {
    @Test
    public void testMul() {
        ComplexNumber complexNumber = new ComplexNumber(5, 6);
        complexNumber.mul(new ComplexNumber(11, -13));
        Assert.assertEquals(complexNumber.getA(), 133);
        Assert.assertEquals(complexNumber.getB(), 1);
    }

    @Test
    public void testAbs() {
        ComplexNumber complexNumber = new ComplexNumber(5, 6);
        complexNumber.abs();
        Assert.assertEquals(complexNumber.getA(), 5);
        Assert.assertEquals(complexNumber.getB(), 6);

        complexNumber = new ComplexNumber(-5, 6);
        complexNumber.abs();
        Assert.assertEquals(complexNumber.getA(), 5);
        Assert.assertEquals(complexNumber.getB(), 6);

        complexNumber = new ComplexNumber(5, -6);
        complexNumber.abs();
        Assert.assertEquals(complexNumber.getA(), 5);
        Assert.assertEquals(complexNumber.getB(), 6);

        complexNumber = new ComplexNumber(-5, -6);
        complexNumber.abs();
        Assert.assertEquals(complexNumber.getA(), 5);
        Assert.assertEquals(complexNumber.getB(), 6);
    }
}
