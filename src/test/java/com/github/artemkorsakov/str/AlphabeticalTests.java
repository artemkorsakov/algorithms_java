package com.github.artemkorsakov.str;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AlphabeticalTests {
    @Test
    public void testGetTheAlphabeticalValue() {
        Assert.assertEquals(64, Alphabetical.getTheAlphabeticalValue("test"));
        Assert.assertEquals(53, Alphabetical.getTheAlphabeticalValue("COLIN"));
        Assert.assertEquals(53, Alphabetical.getTheAlphabeticalValue("\"COLIN\""));
        Assert.assertEquals(53, Alphabetical.getTheAlphabeticalValue("COL'IN"));
        Assert.assertEquals(55, Alphabetical.getTheAlphabeticalValue("SKY"));
    }
}
