package com.github.artemkorsakov.combinatoric;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigInteger;

public class BinomialCoefficientTests {
    @Test
    public void testGetBinomialCoefficient() {
        Assert.assertEquals(BinomialCoefficient.getBinomialCoefficient(100, -1).longValueExact(), 0);
        Assert.assertEquals(BinomialCoefficient.getBinomialCoefficient(-1, 100).longValueExact(), 0);
        Assert.assertEquals(BinomialCoefficient.getBinomialCoefficient(100, 0).longValueExact(), 1);
        Assert.assertEquals(BinomialCoefficient.getBinomialCoefficient(100, 1).longValueExact(), 100);
        Assert.assertEquals(BinomialCoefficient.getBinomialCoefficient(100, 32), new BigInteger("143012501349174257560226775"));
        Assert.assertEquals(BinomialCoefficient.getBinomialCoefficient(100, 50), new BigInteger("100891344545564193334812497256"));
        Assert.assertEquals(BinomialCoefficient.getBinomialCoefficient(100, 99).longValueExact(), 100);
        Assert.assertEquals(BinomialCoefficient.getBinomialCoefficient(100, 100).longValueExact(), 1);
        Assert.assertEquals(BinomialCoefficient.getBinomialCoefficient(100, 101).longValueExact(), 0);

        Assert.assertEquals(BinomialCoefficient.getBinomialCoefficient(100, 32, BigInteger.valueOf(1_000_000)).longValueExact(), 226775);
        Assert.assertEquals(BinomialCoefficient.getBinomialCoefficient(100, 50, BigInteger.valueOf(1_000_000)).longValueExact(), 497256);
    }

}
