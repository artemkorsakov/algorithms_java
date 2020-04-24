package com.github.artemkorsakov.powers;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TwoPowersTests {
    @Test
    public void testGetMaxPowerOfTwo() {
        Assert.assertEquals(TwoPowers.getMaxPowerOfTwo(100), 6);
        Assert.assertEquals(TwoPowers.getMaxPowerOfTwo(32), 5);
        Assert.assertEquals(TwoPowers.getMaxPowerOfTwo(33), 5);
        Assert.assertEquals(TwoPowers.getMaxPowerOfTwo(31), 4);
    }
}
