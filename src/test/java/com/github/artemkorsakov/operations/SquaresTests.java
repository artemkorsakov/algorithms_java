package com.github.artemkorsakov.operations;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class SquaresTests {
    @Test
    public void testIsSquare() {
        Assert.assertTrue(Squares.isSquare(36));
        Assert.assertFalse(Squares.isSquare(35));
        Assert.assertFalse(Squares.isSquare(37));
    }

    @Test
    public void testGetAllSquares() {
        List<Integer> squares = Squares.getAllSquares(2);
        Assert.assertEquals(squares, Arrays.asList(16, 25, 36, 49, 64, 81));
        squares = Squares.getAllSquares(4);
        Assert.assertEquals(squares, Arrays.asList(1024, 1089, 1156, 1225, 1296, 1369, 1444, 1521, 1600, 1681, 1764, 1849, 1936, 2025, 2116, 2209, 2304, 2401, 2500, 2601, 2704, 2809, 2916, 3025, 3136, 3249, 3364, 3481, 3600, 3721, 3844, 3969, 4096, 4225, 4356, 4489, 4624, 4761, 4900, 5041, 5184, 5329, 5476, 5625, 5776, 5929, 6084, 6241, 6400, 6561, 6724, 6889, 7056, 7225, 7396, 7569, 7744, 7921, 8100, 8281, 8464, 8649, 8836, 9025, 9216, 9409, 9604, 9801));

        squares = Squares.getAllSquares(36, 49);
        Assert.assertEquals(squares, Arrays.asList(36, 49));
        squares = Squares.getAllSquares(1023, 1445);
        Assert.assertEquals(squares, Arrays.asList(1024, 1089, 1156, 1225, 1296, 1369, 1444));
        squares = Squares.getAllSquares(1024, 1444);
        Assert.assertEquals(squares, Arrays.asList(1024, 1089, 1156, 1225, 1296, 1369, 1444));
        squares = Squares.getAllSquares(1025, 1443);
        Assert.assertEquals(squares, Arrays.asList(1089, 1156, 1225, 1296, 1369));
    }
}
