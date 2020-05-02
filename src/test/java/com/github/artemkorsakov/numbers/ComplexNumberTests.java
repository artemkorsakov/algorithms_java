package com.github.artemkorsakov.numbers;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ComplexNumberTests {
    @Test
    public void testAdd() {
        ComplexNumber complexNumber = new ComplexNumber(2, 3);
        complexNumber.add(new ComplexNumber(1, 4));
        Assert.assertEquals(complexNumber.getA(), 3.0);
        Assert.assertEquals(complexNumber.getB(), 7.0);
    }

    @Test
    public void testSub() {
        ComplexNumber complexNumber = new ComplexNumber(2, 3);
        complexNumber.sub(new ComplexNumber(1, 4));
        Assert.assertEquals(complexNumber.getA(), 1.0);
        Assert.assertEquals(complexNumber.getB(), -1.0);
    }

    @Test
    public void testMul() {
        ComplexNumber complexNumber = new ComplexNumber(2, 3);
        complexNumber.mul(new ComplexNumber(1, 4));
        Assert.assertEquals(complexNumber.getA(), -10.0);
        Assert.assertEquals(complexNumber.getB(), 11.0);
    }

    @Test
    public void testDiv() {
        ComplexNumber complexNumber = new ComplexNumber(2, 3);
        complexNumber.div(new ComplexNumber(1, 4));
        Assert.assertEquals(complexNumber.getA(), 14.0 / 17.0, 1e-10);
        Assert.assertEquals(complexNumber.getB(), -5.0 / 17.0, 1e-10);

        complexNumber = new ComplexNumber(1, 1);
        complexNumber.mul(new ComplexNumber(2, 1));
        complexNumber.mul(new ComplexNumber(3, 1));
        complexNumber.div(new ComplexNumber(1, -1));
        Assert.assertEquals(complexNumber.getA(), -5.0, 1e-10);
        Assert.assertEquals(complexNumber.getB(), 5.0, 1e-10);

        complexNumber = new ComplexNumber(1, 1);
        complexNumber.div(new ComplexNumber(1, -1));
        Assert.assertEquals(complexNumber.getA(), 0.0, 1e-10);
        Assert.assertEquals(complexNumber.getB(), 1.0, 1e-10);

        complexNumber = new ComplexNumber(1, 1);
        complexNumber.div(new ComplexNumber(2, -1));
        Assert.assertEquals(complexNumber.getA(), 1.0 / 5, 1e-10);
        Assert.assertEquals(complexNumber.getB(), 3.0 / 5, 1e-10);

        complexNumber = new ComplexNumber(1, 0);
        complexNumber.div(new ComplexNumber(0, 1));
        Assert.assertEquals(complexNumber.getA(), 0, 1e-10);
        Assert.assertEquals(complexNumber.getB(), -1.0, 1e-10);

        complexNumber = new ComplexNumber(1, 0);
        complexNumber.div(new ComplexNumber(-2, 1));
        complexNumber.div(new ComplexNumber(1, -3));
        Assert.assertEquals(complexNumber.getA(), 1.0 / 50, 1e-10);
        Assert.assertEquals(complexNumber.getB(), -7.0 / 50, 1e-10);
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

    @Test
    public void testConjugate() {
        ComplexNumber complexNumber = new ComplexNumber(5, 6);
        ComplexNumber conjugate = complexNumber.conjugate();
        Assert.assertEquals(conjugate.getA(), 5);
        Assert.assertEquals(conjugate.getB(), -6);

        conjugate = conjugate.conjugate();
        Assert.assertEquals(conjugate.getA(), 5);
        Assert.assertEquals(conjugate.getB(), 6);
        Assert.assertEquals(complexNumber, conjugate);
    }

    @Test
    public void testPower2() {
        ComplexNumber complexNumber = new ComplexNumber(5.0, 3.0);
        complexNumber.power2();
        Assert.assertEquals(complexNumber.getA(), 16.0, 1e-10);
        Assert.assertEquals(complexNumber.getB(), 30.0, 1e-10);

        complexNumber.power2();
        Assert.assertEquals(complexNumber.getA(), -644.0, 1e-10);
        Assert.assertEquals(complexNumber.getB(), 960.0, 1e-10);

        complexNumber.power2();
        Assert.assertEquals(complexNumber.getA(), -506864.0, 1e-10);
        Assert.assertEquals(complexNumber.getB(), -1236480.0, 1e-10);

        complexNumber = new ComplexNumber(-0.5, Math.sqrt(3.0) / 2.0);
        complexNumber.power2();
        Assert.assertEquals(complexNumber.getA(), -0.5, 1e-10);
        Assert.assertEquals(complexNumber.getB(), -Math.sqrt(3.0) / 2.0, 1e-10);

        complexNumber = new ComplexNumber(4, -5);
        complexNumber.power2();
        ComplexNumber complexNumber2 = new ComplexNumber(2, -3);
        complexNumber2.power2();
        complexNumber.div(complexNumber2);
        Assert.assertEquals(complexNumber.getA(), 525.0 / 169, 1e-10);
        Assert.assertEquals(complexNumber.getB(), 92.0 / 169, 1e-10);
    }

    @Test
    public void testPower() {
        ComplexNumber complexNumber = new ComplexNumber(5.0, 3.0);
        complexNumber.power(8);
        Assert.assertEquals(complexNumber.getA(), -506864.0, 1e-10);
        Assert.assertEquals(complexNumber.getB(), -1236480.0, 1e-10);

        complexNumber = new ComplexNumber(-1.0 / 2.0, Math.sqrt(3.0) / 2.0);
        complexNumber.power(3);
        Assert.assertEquals(complexNumber.getA(), 1.0, 1e-10);
        Assert.assertEquals(complexNumber.getB(), 0.0, 1e-10);
    }

    @Test
    public void testSqrt() {
        ComplexNumber complexNumber = new ComplexNumber(5.0, 12.0);
        Assert.assertEquals(complexNumber.getTheProductOfThisAndItsConjugate(), 169.0);

        ComplexNumber[] solutions = complexNumber.sqrt();
        Assert.assertEquals(solutions.length, 2);
        Assert.assertEquals(solutions[0].getA(), 3.0, 1e-10);
        Assert.assertEquals(solutions[0].getB(), 2.0, 1e-10);
        Assert.assertEquals(solutions[1].getA(), 3.0, 1e-10);
        Assert.assertEquals(solutions[1].getB(), -2.0, 1e-10);
    }
}
