package com.github.artemkorsakov.sort;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SortTests {
    @Test
    public void testInsertion() {
        int[] actual = new int[]{5, 2, 4, 6, 1, 3};
        Sort.insertion(actual);
        Assert.assertEquals(actual, new int[]{1, 2, 3, 4, 5, 6});
        Sort.insertionReverse(actual);
        Assert.assertEquals(actual, new int[]{6, 5, 4, 3, 2, 1});
    }

    @Test
    public void testSelection() {
        int[] actual = new int[]{5, 2, 4, 6, 1, 3};
        Sort.selection(actual);
        Assert.assertEquals(actual, new int[]{1, 2, 3, 4, 5, 6});
        Sort.selectionReverse(actual);
        Assert.assertEquals(actual, new int[]{6, 5, 4, 3, 2, 1});
    }

    @Test
    public void testMergeSort() {
        int[] actual = new int[]{5, 2, 4, 6, 1, 3};
        Sort.mergeSort(actual);
        Assert.assertEquals(actual, new int[]{1, 2, 3, 4, 5, 6});
    }
}
