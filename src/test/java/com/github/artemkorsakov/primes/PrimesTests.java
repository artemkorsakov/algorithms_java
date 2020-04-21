package com.github.artemkorsakov.primes;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

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

    @Test
    public void testGetTheGivenNumberOfPrimes() {
        List<Long> primes = Primes.getTheGivenNumberOfPrimes(6);
        Assert.assertEquals(13L, (long) primes.get(5));
        primes = Primes.getTheGivenNumberOfPrimes(10001);
        Assert.assertEquals(104743L, (long) primes.get(10000));
    }

    @Test
    public void testGetTheLargestPrimeFactor() {
        long primeFactor = Primes.getTheLargestPrimeFactor(6);
        Assert.assertEquals(primeFactor, 3L);
        primeFactor = Primes.getTheLargestPrimeFactor(104743);
        Assert.assertEquals(primeFactor, 104743);
        primeFactor = Primes.getTheLargestPrimeFactor(1024);
        Assert.assertEquals(primeFactor, 2);
        primeFactor = Primes.getTheLargestPrimeFactor(13195L);
        Assert.assertEquals(29L, primeFactor);
        primeFactor = Primes.getTheLargestPrimeFactor(600851475143L);
        Assert.assertEquals(6857L, primeFactor);
    }

    @Test
    public void testGetListSmallestPrimeFactors() {
        int[] result = Primes.getListSmallestPrimeFactors(10);
        Assert.assertEquals(result, new int[]{0, 0, 2, 3, 2, 5, 2, 7, 2, 3, 2});
    }

    @Test
    public void testGetTheSmallestPrimeFactor() {
        long primeFactor = Primes.getTheSmallestPrimeFactor(6);
        Assert.assertEquals(primeFactor, 2);
        primeFactor = Primes.getTheSmallestPrimeFactor(104743);
        Assert.assertEquals(primeFactor, 104743);
        primeFactor = Primes.getTheSmallestPrimeFactor(1024);
        Assert.assertEquals(primeFactor, 2);
        primeFactor = Primes.getTheSmallestPrimeFactor(42);
        Assert.assertEquals(primeFactor, 2);
    }

    @Test
    public void testGetAllPrimeFactorsWithPow() {
        Map<Integer, Integer> allPrimeFactorsWithPow = Primes.getAllPrimeFactorsWithPow(1000);
        Assert.assertEquals(allPrimeFactorsWithPow.keySet().size(), 2);
        Assert.assertEquals(allPrimeFactorsWithPow.get(2).intValue(), 3);
        Assert.assertEquals(allPrimeFactorsWithPow.get(5).intValue(), 3);

        allPrimeFactorsWithPow = Primes.getAllPrimeFactorsWithPow(1024);
        Assert.assertEquals(allPrimeFactorsWithPow.keySet().size(), 1);
        Assert.assertEquals(allPrimeFactorsWithPow.get(2).intValue(), 10);

        allPrimeFactorsWithPow = Primes.getAllPrimeFactorsWithPow(777111);
        Assert.assertEquals(allPrimeFactorsWithPow.keySet().size(), 3);
        Assert.assertEquals(allPrimeFactorsWithPow.get(3).intValue(), 1);
        Assert.assertEquals(allPrimeFactorsWithPow.get(37).intValue(), 1);
        Assert.assertEquals(allPrimeFactorsWithPow.get(7001).intValue(), 1);
    }

}
