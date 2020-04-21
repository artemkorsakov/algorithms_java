package com.github.artemkorsakov.primes;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RadicalsTests {
    @Test
    public void testGetAllRads() {
        int[] results = new int[]{0, 1, 2, 3, 2, 5, 6, 7, 2, 3, 10, 11, 6, 13, 14, 15, 2, 17, 6, 19, 10, 21, 22, 23, 6, 5, 26, 3, 14, 29, 30, 31, 2, 33, 34, 35, 6, 37, 38, 39, 10, 41, 42, 43, 22, 15, 46, 47, 6, 7, 10, 51, 26, 53, 6, 55, 14, 57, 58, 59, 30, 61, 62, 21, 2, 65, 66, 67, 34, 69, 70, 71, 6, 73, 74, 15, 38, 77, 78, 79, 10, 3, 82, 83, 42, 85, 86, 87, 22, 89, 30, 91, 46, 93, 94, 95, 6, 97, 14, 33, 10};
        Assert.assertEquals(Radicals.getAllRads(100), results);
    }

    @Test
    public void testGetRad() {
        Assert.assertEquals(Radicals.getRad(100), 10);
        Assert.assertEquals(Radicals.getRad(7), 7);
        Assert.assertEquals(Radicals.getRad(8), 2);
        Assert.assertEquals(Radicals.getRad(12), 6);
    }

    @Test
    public void testIsConsistOnlyTheFirstPowerOfPrimes() {
        Assert.assertTrue(Radicals.isConsistOnlyTheFirstPowerOfPrimes(10));
        Assert.assertFalse(Radicals.isConsistOnlyTheFirstPowerOfPrimes(100));
    }
}
