package com.github.artemkorsakov.numbers;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FractionTests {
    @Test
    public void testCompareFractions() {
        Assert.assertTrue(new Fraction(2, 5).compareTo(new Fraction(3, 7)) < 0);
        Assert.assertEquals(new Fraction(3, 7).compareTo(new Fraction(3, 7)), 0);
        Assert.assertTrue(new Fraction(1, 2).compareTo(new Fraction(3, 7)) > 0);
    }
}
