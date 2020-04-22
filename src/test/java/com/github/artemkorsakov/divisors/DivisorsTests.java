package com.github.artemkorsakov.divisors;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class DivisorsTests {
    @Test
    public void testGCD() {
        Assert.assertEquals(Divisors.gcd(15, 12), 3);
        Assert.assertEquals(Divisors.gcd(1, 12), 1);
        Assert.assertEquals(Divisors.gcd(7, 12), 1);
        Assert.assertEquals(Divisors.gcd(7, 49), 7);
        Assert.assertEquals(Divisors.gcd(12121212L, 23422344L), 12);
    }

    @Test
    public void testGCDInverse() {
        Assert.assertEquals(Divisors.gcdInverse(111, 10), 1);
    }

    @Test
    public void testGCDex() {
        Assert.assertEquals(Divisors.gcdex(15, 10).getD(), 5);
    }

    @Test
    public void testGetDivisors() {
        Assert.assertEquals(Divisors.getDivisors(30), Arrays.asList(2L, 15L, 3L, 10L, 5L, 6L));
    }

    @Test
    public void testGetSumOfDivisors() {
        Assert.assertEquals(284, Divisors.getSumOfDivisorsLessThanN(220));
        Assert.assertEquals(220, Divisors.getSumOfDivisorsLessThanN(284));
        Assert.assertEquals(504, Divisors.getSumOfDivisors(220L).intValueExact());
        Assert.assertEquals(504, Divisors.getSumOfDivisors(284L).intValueExact());
    }

    @Test
    public void testGetCountOfDivisors() {
        Assert.assertEquals(Divisors.getCountOfDivisors(100), 9);
    }
}
