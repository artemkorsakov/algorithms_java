package com.github.artemkorsakov.numbers.cyclical;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class FiguralNumberTests {
    private static final List<Integer> FIRST_TRIANGLES = Arrays.asList(1, 3, 6, 10, 15, 21, 28, 36, 45, 55, 66, 78, 91);
    private static final List<Integer> FIRST_SQUARE = Arrays.asList(1, 4, 9, 16, 25, 36, 49, 64, 81);
    private static final List<Integer> FIRST_PENTAGONALS = Arrays.asList(1, 5, 12, 22, 35, 51, 70, 92);
    private static final List<Integer> FIRST_HEXAGONALS = Arrays.asList(1, 6, 15, 28, 45, 66, 91);
    private static final List<Integer> FIRST_HEPTAGONAL = Arrays.asList(1, 7, 18, 34, 55, 81);
    private static final List<Integer> FIRST_OCTAGONAL = Arrays.asList(1, 8, 21, 40, 65, 96);

    @Test
    public void test() {
        for (int i = 1; i < 100; i++) {
            Assert.assertEquals(TriangleFiguralNumber.isTriangle(i), FIRST_TRIANGLES.contains(i));
            Assert.assertEquals(SquareFiguralNumber.isSquare(i), FIRST_SQUARE.contains(i));
            Assert.assertEquals(PentagonalFiguralNumber.isPentagonal(i), FIRST_PENTAGONALS.contains(i));
            Assert.assertEquals(HexagonalFiguralNumber.isHexagonal(i), FIRST_HEXAGONALS.contains(i));
            Assert.assertEquals(HeptagonalFiguralNumber.isHeptagonal(i), FIRST_HEPTAGONAL.contains(i));
            Assert.assertEquals(OctagonalFiguralNumber.isOctagonal(i), FIRST_OCTAGONAL.contains(i));
        }

        Assert.assertTrue(PentagonalFiguralNumber.isPentagonal(5482660));
        Assert.assertTrue(PentagonalFiguralNumber.isPentagonal(7042750));
        Assert.assertTrue(PentagonalFiguralNumber.isPentagonal(1560090));
        Assert.assertTrue(PentagonalFiguralNumber.isPentagonal(8602840));

        Assert.assertTrue(PentagonalFiguralNumber.isPentagonal(40755));
        Assert.assertTrue(TriangleFiguralNumber.isTriangle(40755));
        Assert.assertTrue(HexagonalFiguralNumber.isHexagonal(40755));

        Assert.assertTrue(TriangleFiguralNumber.isTriangle(8256));
        Assert.assertTrue(SquareFiguralNumber.isSquare(5625));
        Assert.assertTrue(PentagonalFiguralNumber.isPentagonal(2882));
        Assert.assertTrue(HexagonalFiguralNumber.isHexagonal(8128));
        Assert.assertTrue(HeptagonalFiguralNumber.isHeptagonal(2512));
        Assert.assertTrue(OctagonalFiguralNumber.isOctagonal(1281));
    }
}
