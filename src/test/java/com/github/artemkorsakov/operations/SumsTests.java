package com.github.artemkorsakov.operations;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SumsTests {
    @Test
    public void test() {
        Assert.assertEquals(Sums.getSumToGiven(1_000_000), 500000500000L);
        Assert.assertEquals(Sums.computeSumOfSquaresTo(1_000), 333833500);
    }
}
