package com.github.artemkorsakov.numbers;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigInteger;

public class FibonacciTests {
    @Test
    public void testGetFibonacciNumber() {
        Assert.assertEquals(Fibonacci.getFibonacciNumber(1).longValueExact(), 1);
        Assert.assertEquals(Fibonacci.getFibonacciNumber(2).longValueExact(), 1);
        Assert.assertEquals(Fibonacci.getFibonacciNumber(3).longValueExact(), 2);
        Assert.assertEquals(Fibonacci.getFibonacciNumber(4).longValueExact(), 3);
        Assert.assertEquals(Fibonacci.getFibonacciNumber(5).longValueExact(), 5);
        Assert.assertEquals(Fibonacci.getFibonacciNumber(6).longValueExact(), 8);
        Assert.assertEquals(Fibonacci.getFibonacciNumber(7).longValueExact(), 13);
        Assert.assertEquals(Fibonacci.getFibonacciNumber(8).longValueExact(), 21);
        Assert.assertEquals(Fibonacci.getFibonacciNumber(9).longValueExact(), 34);
        Assert.assertEquals(Fibonacci.getFibonacciNumber(10).longValueExact(), 55);
        Assert.assertEquals(Fibonacci.getFibonacciNumber(11).longValueExact(), 89);
        Assert.assertEquals(Fibonacci.getFibonacciNumber(12).longValueExact(), 144);
        Assert.assertEquals(Fibonacci.getFibonacciNumber(13).longValueExact(), 233);
        Assert.assertEquals(Fibonacci.getFibonacciNumber(14).longValueExact(), 377);
        Assert.assertEquals(Fibonacci.getFibonacciNumber(15).longValueExact(), 610);
        Assert.assertEquals(Fibonacci.getFibonacciNumber(16).longValueExact(), 987);
        Assert.assertEquals(Fibonacci.getFibonacciNumber(17).longValueExact(), 1597);
        Assert.assertEquals(Fibonacci.getFibonacciNumber(18).longValueExact(), 2584);
        Assert.assertEquals(Fibonacci.getFibonacciNumber(19).longValueExact(), 4181);
        Assert.assertEquals(Fibonacci.getFibonacciNumber(20).longValueExact(), 6765);
        Assert.assertEquals(Fibonacci.getFibonacciNumber(21).longValueExact(), 10946);

        Assert.assertEquals(Fibonacci.getFibonacciNumber(100), new BigInteger("354224848179265190133"));
    }

    @Test
    public void testGetFibonacciMatrix() {
        long[][] matrix = Fibonacci.getFibonacciMatrix(20);
        Assert.assertEquals(matrix[0][0], Fibonacci.getFibonacciNumber(21).longValueExact());
        Assert.assertEquals(matrix[0][1], Fibonacci.getFibonacciNumber(20).longValueExact());
        Assert.assertEquals(matrix[1][0], Fibonacci.getFibonacciNumber(20).longValueExact());
        Assert.assertEquals(matrix[1][1], Fibonacci.getFibonacciNumber(19).longValueExact());
    }

    @Test
    public void testGetFibonacciMatrixMod() {
        long[][] matrix = Fibonacci.getFibonacciMatrix(20, 100);
        Assert.assertEquals(matrix[0][0], Fibonacci.getFibonacciNumber(21).longValueExact() % 100);
        Assert.assertEquals(matrix[0][1], Fibonacci.getFibonacciNumber(20).longValueExact() % 100);
        Assert.assertEquals(matrix[1][0], Fibonacci.getFibonacciNumber(20).longValueExact() % 100);
        Assert.assertEquals(matrix[1][1], Fibonacci.getFibonacciNumber(19).longValueExact() % 100);

        long N = 1_000_000_000_000_000L;
        long MODULO = 1307674368000L;
        matrix = Fibonacci.getFibonacciMatrix(N, MODULO);
        Assert.assertEquals(matrix[0][0], 73179529501L);
        Assert.assertEquals(matrix[0][1], 36651874875L);
        Assert.assertEquals(matrix[1][0], 36651874875L);
        Assert.assertEquals(matrix[1][1], 36527654626L);
    }
}
