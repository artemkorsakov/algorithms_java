package com.github.artemkorsakov.powers;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PowersTests {
    @Test
    public void testIsPower() {
        Assert.assertEquals(Powers.isPower(8), 3);
        Assert.assertEquals(Powers.isPower(4), 2);
        Assert.assertEquals(Powers.isPower(9), 2);
        Assert.assertEquals(Powers.isPower(5), 1);
        Assert.assertEquals(Powers.isPower(7), 1);
        Assert.assertEquals(Powers.isPower(10), 1);
        Assert.assertEquals(Powers.isPower(16), 4);
        Assert.assertEquals(Powers.isPower(32), 5);
        Assert.assertEquals(Powers.isPower(64), 6);
        Assert.assertEquals(Powers.isPower(81), 4);
        Assert.assertEquals(Powers.isPower(36), 2);
        Assert.assertEquals(Powers.isPower(144), 2);
    }

}
