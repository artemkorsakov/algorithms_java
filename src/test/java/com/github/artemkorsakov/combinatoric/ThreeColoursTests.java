package com.github.artemkorsakov.combinatoric;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ThreeColoursTests {
    @Test
    public void testGetCount() {
        Assert.assertEquals(ThreeColours.getCount(1, 1, 1), 6);
        Assert.assertEquals(ThreeColours.getCount(2, 1, 1), 12);
        Assert.assertEquals(ThreeColours.getCount(2, 2, 0), 6);
        Assert.assertEquals(ThreeColours.getCount(2, 2, 1), 30);
        Assert.assertEquals(ThreeColours.getCount(2, 2, 2), 90);
        Assert.assertEquals(ThreeColours.getCount(0, 2, 2), 6);
        Assert.assertEquals(ThreeColours.getCount(2, 0, 2), 6);
    }
}
