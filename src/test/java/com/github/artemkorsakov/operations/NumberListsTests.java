package com.github.artemkorsakov.operations;

import com.github.artemkorsakov.primes.Primes;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;

public class NumberListsTests {
    @Test
    public void testGetAllNumbersVariants() {
        Assert.assertEquals(NumberLists.getAllNumbersVariants(Arrays.asList(2, 3)), Arrays.asList(Collections.singletonList(2), Collections.singletonList(3), Arrays.asList(2, 3)));
        Assert.assertEquals(NumberLists.getAllNumbersVariants(Arrays.asList(2, 3, 5, 7)), Arrays.asList(Collections.singletonList(2), Collections.singletonList(3), Collections.singletonList(5), Collections.singletonList(7), Arrays.asList(5, 7), Arrays.asList(3, 5), Arrays.asList(3, 7), Arrays.asList(3, 5, 7), Arrays.asList(2, 3), Arrays.asList(2, 5), Arrays.asList(2, 7), Arrays.asList(2, 5, 7), Arrays.asList(2, 3, 5), Arrays.asList(2, 3, 7), Arrays.asList(2, 3, 5, 7)));
    }

    @Test
    public void testGetCountOfNumbers() {
        Assert.assertEquals(NumberLists.getCountOfNumbers(-1, new int[]{2, 3}), 0);
        Assert.assertEquals(NumberLists.getCountOfNumbers(0, new int[]{2, 3}), 0);
        Assert.assertEquals(NumberLists.getCountOfNumbers(0, new int[]{}), 0);
        Assert.assertEquals(NumberLists.getCountOfNumbers(1, new int[]{}), 1);

        Assert.assertEquals(NumberLists.getCountOfNumbers(1, new int[]{2}), 1);
        Assert.assertEquals(NumberLists.getCountOfNumbers(2, new int[]{2}), 2);
        Assert.assertEquals(NumberLists.getCountOfNumbers(3, new int[]{2}), 2);
        Assert.assertEquals(NumberLists.getCountOfNumbers(4, new int[]{2}), 3);
        Assert.assertEquals(NumberLists.getCountOfNumbers(100, new int[]{2}), 7);

        Assert.assertEquals(NumberLists.getCountOfNumbers(10, new int[]{2, 3}), 7);
        Assert.assertEquals(NumberLists.getCountOfNumbers(100, new int[]{2, 3}), 20);
        Assert.assertEquals(NumberLists.getCountOfNumbers(100, new int[]{2, 3, 5}), 34);
        Assert.assertEquals(NumberLists.getCountOfNumbers(100, new int[]{2, 3, 5, 7}), 46);
        Assert.assertEquals(NumberLists.getCountOfNumbers(100L, new int[]{2, 3, 5, 7}), 46);

        int[] primes = Primes.getAllPrimesNotMoreThanLimit(100);
        Assert.assertEquals(NumberLists.getCountOfNumbers(10_000, primes), 3716);
        primes = Primes.getAllPrimesNotMoreThanLimit(1000);
        Assert.assertEquals(NumberLists.getCountOfNumbers(1_000_000, primes), 344_299);
        primes = Primes.getAllPrimesNotMoreThanLimit(10000);
        Assert.assertEquals(NumberLists.getCountOfNumbers(100_000_000, primes), 33_268_090);
        Assert.assertEquals(NumberLists.getCountOfNumbers(100_000_000L, primes), 33_268_090);
    }

}
