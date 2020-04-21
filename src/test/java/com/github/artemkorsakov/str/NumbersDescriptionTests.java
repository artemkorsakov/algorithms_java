package com.github.artemkorsakov.str;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NumbersDescriptionTests {
    @Test
    public void testGetDescription() {
        Assert.assertEquals(NumbersDescription.getDescription(111), "one hundred and eleven");
        Assert.assertEquals("five hundred", NumbersDescription.getDescription(500));
        Assert.assertEquals("five thousand", NumbersDescription.getDescription(5000));
        Assert.assertEquals("one thousand four hundred and thirty-five", NumbersDescription.getDescription(1435));
        Assert.assertEquals("nine hundred and ninety-nine thousand nine hundred and ninety-nine", NumbersDescription.getDescription(999999));
        Assert.assertEquals("three hundred and forty-two", NumbersDescription.getDescription(342));
        Assert.assertEquals("one hundred and fifteen", NumbersDescription.getDescription(115));
    }
}
