package com.github.artemkorsakov.numbers;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PythagoreanTripletTests {
    @Test
    public void testGetAllPythagoreanTriplet() {
        PythagoreanTriplet pt = PythagoreanTripletHelper.getAllPythagoreanTriplet(1000).get(0);
        Assert.assertEquals(200, pt.getA());
        Assert.assertEquals(375, pt.getB());
        Assert.assertEquals(425, pt.getC());
    }
}
