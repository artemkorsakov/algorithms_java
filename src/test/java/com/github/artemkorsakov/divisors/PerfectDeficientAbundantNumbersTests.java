package com.github.artemkorsakov.divisors;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PerfectDeficientAbundantNumbersTests {
    @Test
    public void testGetTypeNumber() {
        Assert.assertEquals(PerfectDeficientAbundantNumbers.getTypeNumber(6), PerfectDeficientAbundantNumbers.TypeNumber.Perfect);
        Assert.assertEquals(PerfectDeficientAbundantNumbers.getTypeNumber(7), PerfectDeficientAbundantNumbers.TypeNumber.Deficient);
        Assert.assertEquals(PerfectDeficientAbundantNumbers.getTypeNumber(12), PerfectDeficientAbundantNumbers.TypeNumber.Abundant);
    }
}
