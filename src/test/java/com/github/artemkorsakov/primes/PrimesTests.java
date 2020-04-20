package com.github.artemkorsakov.primes;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimesTests {
    @Test
    public void testIsPrime() {
        Assert.assertFalse(Primes.isPrime(-1));
        Assert.assertFalse(Primes.isPrime(0));
        Assert.assertFalse(Primes.isPrime(1));
        Assert.assertTrue(Primes.isPrime(2));
        Assert.assertTrue(Primes.isPrime(3));
        Assert.assertFalse(Primes.isPrime(4));
        Assert.assertTrue(Primes.isPrime(5));
        Assert.assertTrue(Primes.isPrime(1000999));
    }

    @Test
    public void testGetNextPrime() {
        Assert.assertEquals(Primes.getNextPrime(2), 3);
        Assert.assertEquals(Primes.getNextPrime(3), 5);
        Assert.assertEquals(Primes.getNextPrime(13), 17);
        Assert.assertEquals(Primes.getNextPrime(1000999), 1001003);
    }

    @Test
    public void testGetAllPrimesNotMoreThanLimit() {
        Assert.assertEquals(Primes.getAllPrimesNotMoreThanLimit(10), new int[]{2, 3, 5, 7});
        int[] primes = Primes.getAllPrimesNotMoreThanLimit(1001003);
        Assert.assertEquals(primes[primes.length - 1], 1001003);
        Assert.assertEquals(primes[primes.length - 2], 1000999);
    }

    @Test
    public void testGetAllPrimesNotMoreThanLimitInBooleanArray() {
        Assert.assertEquals(Primes.getAllPrimesNotMoreThanLimitInBooleanArray(10),
                new boolean[]{false, false, true, true, false, true, false, true, false, false, false});
        boolean[] primes = Primes.getAllPrimesNotMoreThanLimitInBooleanArray(1001003);
        Assert.assertTrue(primes[1001003]);
        Assert.assertFalse(primes[1001002]);
        Assert.assertFalse(primes[1001001]);
        Assert.assertFalse(primes[1001000]);
        Assert.assertTrue(primes[1000999]);
        Assert.assertFalse(primes[1000998]);
    }
}
