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

        primes = Primes.getAllPrimesNotMoreThanLimitInBooleanArray(2_000_000_000);
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
        primeFactor = Primes.getTheLargestPrimeFactor(5);
        Assert.assertEquals(5, primeFactor);
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

    @Test
    public void testGetAllPrimePowers() {
        int[][] primePowers = Primes.getAllPrimePowers(100);
        Assert.assertEquals(primePowers[2], new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        Assert.assertEquals(primePowers[3], new int[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        Assert.assertEquals(primePowers[4], new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        Assert.assertEquals(primePowers[5], new int[]{0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        Assert.assertEquals(primePowers[6], new int[]{1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        Assert.assertEquals(primePowers[7], new int[]{0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        Assert.assertEquals(primePowers[100], new int[]{2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});

        Map<Integer, Map<Integer, Integer>> primePowers2 = Primes.getAllPrimePowers2(100);
        Assert.assertEquals(primePowers2.get(2).get(2).intValue(), 1);
        Assert.assertEquals(primePowers2.get(2).keySet().size(), 1);
        Assert.assertEquals(primePowers2.get(3).get(3).intValue(), 1);
        Assert.assertEquals(primePowers2.get(3).keySet().size(), 1);
        Assert.assertEquals(primePowers2.get(4).get(2).intValue(), 2);
        Assert.assertEquals(primePowers2.get(4).keySet().size(), 1);
        Assert.assertEquals(primePowers2.get(5).get(5).intValue(), 1);
        Assert.assertEquals(primePowers2.get(4).keySet().size(), 1);
        Assert.assertEquals(primePowers2.get(100).get(2).intValue(), 2);
        Assert.assertEquals(primePowers2.get(100).get(5).intValue(), 2);
        Assert.assertEquals(primePowers2.get(100).keySet().size(), 2);

        primePowers2 = Primes.getAllPrimePowers2(1_000_000);
        Assert.assertEquals(primePowers2.get(1_000_000).get(2).intValue(), 6);
        Assert.assertEquals(primePowers2.get(1_000_000).get(5).intValue(), 6);
        Assert.assertEquals(primePowers2.get(1_000_000).keySet().size(), 2);
    }

}
