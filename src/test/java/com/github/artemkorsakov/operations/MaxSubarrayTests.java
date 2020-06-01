package com.github.artemkorsakov.operations;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MaxSubarrayTests {
    @Test
    public void test() {
        long[] array = new long[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        MaxSubarray maxSubarray = MaxSubarray.findMaxSubarray(array, 0, array.length - 1);
        System.out.println(maxSubarray);
        Assert.assertEquals(maxSubarray.getMaxSum(), 43);
        Assert.assertEquals(maxSubarray.getLeftIndex(), 7);
        Assert.assertEquals(maxSubarray.getRightIndex(), 10);
    }
}
