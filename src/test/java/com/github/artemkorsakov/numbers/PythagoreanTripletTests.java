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

    @Test
    public void testGetNextPythagoreanTriplets() {
        PythagoreanTripletLong[] pythagoreanTriplets = PythagoreanTripletHelper.getNextPythagoreanTriplets(PythagoreanTripletHelper.PRIMITIVE_PYTHAGOREAN_TRIPLET);
        Assert.assertEquals(pythagoreanTriplets[0], new PythagoreanTripletLong(5, 12, 13));
        Assert.assertEquals(pythagoreanTriplets[1], new PythagoreanTripletLong(21, 20, 29));
        Assert.assertEquals(pythagoreanTriplets[2], new PythagoreanTripletLong(15, 8, 17));
        pythagoreanTriplets = PythagoreanTripletHelper.getNextPythagoreanTriplets(pythagoreanTriplets[0]);
        Assert.assertEquals(pythagoreanTriplets[0], new PythagoreanTripletLong(7, 24, 25));
        Assert.assertEquals(pythagoreanTriplets[1], new PythagoreanTripletLong(55, 48, 73));
        Assert.assertEquals(pythagoreanTriplets[2], new PythagoreanTripletLong(45, 28, 53));
        pythagoreanTriplets = PythagoreanTripletHelper.getNextPythagoreanTriplets(pythagoreanTriplets[0]);
        Assert.assertEquals(pythagoreanTriplets[0], new PythagoreanTripletLong(9, 40, 41));
        Assert.assertEquals(pythagoreanTriplets[1], new PythagoreanTripletLong(105, 88, 137));
        Assert.assertEquals(pythagoreanTriplets[2], new PythagoreanTripletLong(91, 60, 109));
    }

    @Test
    public void testGetNextPythagoreanDeuces() {
        Assert.assertEquals(PythagoreanTripletHelper.PRIMITIVE_PYTHAGOREAN_DEUCE.toPythagoreanTripletLong(), new PythagoreanTripletLong(3, 4, 5));
        PythagoreanDeuce[] pythagoreanDeuces = PythagoreanTripletHelper.getNextPythagoreanDeuce(PythagoreanTripletHelper.PRIMITIVE_PYTHAGOREAN_DEUCE);
        Assert.assertEquals(pythagoreanDeuces[0].toPythagoreanTripletLong(), new PythagoreanTripletLong(5, 12, 13));
        Assert.assertEquals(pythagoreanDeuces[1].toPythagoreanTripletLong(), new PythagoreanTripletLong(21, 20, 29));
        Assert.assertEquals(pythagoreanDeuces[2].toPythagoreanTripletLong(), new PythagoreanTripletLong(15, 8, 17));
        pythagoreanDeuces = PythagoreanTripletHelper.getNextPythagoreanDeuce(pythagoreanDeuces[0]);
        Assert.assertEquals(pythagoreanDeuces[0].toPythagoreanTripletLong(), new PythagoreanTripletLong(7, 24, 25));
        Assert.assertEquals(pythagoreanDeuces[1].toPythagoreanTripletLong(), new PythagoreanTripletLong(55, 48, 73));
        Assert.assertEquals(pythagoreanDeuces[2].toPythagoreanTripletLong(), new PythagoreanTripletLong(45, 28, 53));
        pythagoreanDeuces = PythagoreanTripletHelper.getNextPythagoreanDeuce(pythagoreanDeuces[0]);
        Assert.assertEquals(pythagoreanDeuces[0].toPythagoreanTripletLong(), new PythagoreanTripletLong(9, 40, 41));
        Assert.assertEquals(pythagoreanDeuces[1].toPythagoreanTripletLong(), new PythagoreanTripletLong(105, 88, 137));
        Assert.assertEquals(pythagoreanDeuces[2].toPythagoreanTripletLong(), new PythagoreanTripletLong(91, 60, 109));
    }
}
