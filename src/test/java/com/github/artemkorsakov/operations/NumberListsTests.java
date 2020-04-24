package com.github.artemkorsakov.operations;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;

public class NumberListsTests {
    @Test
    public void test() {
        Assert.assertEquals(NumberLists.getAllNumbersVariants(Arrays.asList(2, 3)), Arrays.asList(Collections.singletonList(2), Collections.singletonList(3), Arrays.asList(2, 3)));
        Assert.assertEquals(NumberLists.getAllNumbersVariants(Arrays.asList(2, 3, 5, 7)), Arrays.asList(Collections.singletonList(2), Collections.singletonList(3), Collections.singletonList(5), Collections.singletonList(7), Arrays.asList(5, 7), Arrays.asList(3, 5), Arrays.asList(3, 7), Arrays.asList(3, 5, 7), Arrays.asList(2, 3), Arrays.asList(2, 5), Arrays.asList(2, 7), Arrays.asList(2, 5, 7), Arrays.asList(2, 3, 5), Arrays.asList(2, 3, 7), Arrays.asList(2, 3, 5, 7)));
    }
}
