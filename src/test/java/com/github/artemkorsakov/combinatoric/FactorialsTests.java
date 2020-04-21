package com.github.artemkorsakov.combinatoric;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigInteger;

public class FactorialsTests {
    @Test
    public void testGetFactorial() {
        Assert.assertEquals(Factorials.getFactorial(0), 1);
        Assert.assertEquals(Factorials.getFactorial(1), 1);
        Assert.assertEquals(Factorials.getFactorial(2), 2);
        Assert.assertEquals(Factorials.getFactorial(9), 362880);
        Assert.assertEquals(Factorials.getFactorial(15), 1307674368000L);

        Assert.assertEquals(Factorials.getBigFactorial(0).longValueExact(), 1);
        Assert.assertEquals(Factorials.getBigFactorial(1).longValueExact(), 1);
        Assert.assertEquals(Factorials.getBigFactorial(2).longValueExact(), 2);
        Assert.assertEquals(Factorials.getBigFactorial(9), new BigInteger("362880"));
        Assert.assertEquals(Factorials.getBigFactorial(15), new BigInteger("1307674368000"));
        Assert.assertEquals(Factorials.getBigFactorial(30), new BigInteger("265252859812191058636308480000000"));
    }
}
