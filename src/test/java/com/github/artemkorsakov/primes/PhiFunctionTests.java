package com.github.artemkorsakov.primes;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PhiFunctionTests {
    @Test
    public void testGetPhiFunction() {
        int[] primes = Primes.getAllPrimesNotMoreThanLimit(100);
        for (int i = 0; i < primes.length - 1; i++) {
            Assert.assertEquals(Primes.getNextPrime(primes[i]), primes[i + 1]);
        }

        Assert.assertEquals(PhiFunction.getPhiFunction(1), 1);
        Assert.assertEquals(PhiFunction.getPhiFunction(2), 1);
        Assert.assertEquals(PhiFunction.getPhiFunction(3), 2);
        Assert.assertEquals(PhiFunction.getPhiFunction(4), 2);
        Assert.assertEquals(PhiFunction.getPhiFunction(5), 4);
        Assert.assertEquals(PhiFunction.getPhiFunction(6), 2);
        Assert.assertEquals(PhiFunction.getPhiFunction(7), 6);
        Assert.assertEquals(PhiFunction.getPhiFunction(8), 4);
        Assert.assertEquals(PhiFunction.getPhiFunction(9), 6);
        Assert.assertEquals(PhiFunction.getPhiFunction(10), 4);

        Assert.assertEquals(PhiFunction.getPhiFunction(87109), 79180);
        Assert.assertEquals(PhiFunction.getPhiFunction(284029), 282940);
        Assert.assertEquals(PhiFunction.getPhiFunction(9983167), 9973816);
    }

}
