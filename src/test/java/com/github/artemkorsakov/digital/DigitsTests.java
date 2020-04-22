package com.github.artemkorsakov.digital;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DigitsTests {
    @Test
    public void testContainTheSameDigits() {
        Assert.assertTrue(Digits.containTheSameDigits(125874, 251748));
        Assert.assertFalse(Digits.containTheSameDigits(125874, 251744));
        Assert.assertFalse(Digits.containTheSameDigits(135796744L, 371694959L));
        Assert.assertTrue(Digits.containTheSameDigits(135796744L, 476379541L));
        Assert.assertFalse(Digits.containTheSameDigits(135796744L, 679151439L));
        Assert.assertFalse(Digits.containTheSameDigits(135796744L, 763551944L));
        Assert.assertTrue(Digits.containTheSameDigits(127035954683L, 352045367981L));
        Assert.assertTrue(Digits.containTheSameDigits(127035954683L, 373559126408L));
        Assert.assertTrue(Digits.containTheSameDigits(127035954683L, 569310543872L));
        Assert.assertTrue(Digits.containTheSameDigits(127035954683L, 589323567104L));
        Assert.assertTrue(Digits.containTheSameDigits("41063625", "56623104"));
        Assert.assertTrue(Digits.containTheSameDigits("41063625", "66430125"));
        Assert.assertTrue(Digits.containTheSameDigits("1234543", "1325434"));
        Assert.assertFalse(Digits.containTheSameDigits("1234543", "1325433"));
        Assert.assertFalse(Digits.containTheSameDigits("1234543", "132543"));
        Assert.assertTrue(Digits.containTheSameDigits("125874", "251748"));
        Assert.assertFalse(Digits.containTheSameDigits("125874", "251744"));
    }

    @Test
    public void testGetDigits() {
        Assert.assertEquals(Digits.getDigits(1406357289L), Arrays.asList(9, 8, 2, 7, 5, 3, 6, 0, 4, 1));
        List<Integer> digits = Digits.getDigits(1234);
        Assert.assertEquals(digits, Arrays.asList(4, 3, 2, 1));
        digits = Digits.getDigits("0001234");
        Assert.assertEquals(digits, Arrays.asList(4, 3, 2, 1, 0, 0, 0));
    }

    @Test
    public void testGetSumOfDigits() {
        Assert.assertEquals(Digits.getSumOfDigits(1457), 17);
        Assert.assertEquals(Digits.getSumOfDigits(BigInteger.valueOf(1457)), 17);
    }

    @Test
    public void testHasEqualDigits() {
        Assert.assertTrue(Digits.hasEqualDigits(111));
        Assert.assertTrue(Digits.hasEqualDigits(112));
        Assert.assertFalse(Digits.hasEqualDigits(123));
        Assert.assertTrue(Digits.hasEqualDigits(56003));
        Assert.assertTrue(Digits.hasEqualDigits(56113));
        Assert.assertTrue(Digits.hasEqualDigits(56333));
        Assert.assertTrue(Digits.hasEqualDigits(56443));
        Assert.assertTrue(Digits.hasEqualDigits(56663));
        Assert.assertTrue(Digits.hasEqualDigits(56773));
        Assert.assertTrue(Digits.hasEqualDigits(56993));
        Assert.assertTrue(Digits.hasEqualDigits(569993, 3, 9));
        Assert.assertTrue(Digits.hasEqualDigits(56993, 2, 9));
        Assert.assertFalse(Digits.hasEqualDigits(56993, 3, 9));
    }

    @Test
    public void testGetPossibleVariants() {
        List<Integer> variants = Digits.getPossibleVariants(Arrays.asList(1, 3, 7));
        Assert.assertEquals(Arrays.asList(137, 173, 317, 371, 713, 731), variants);
        variants = Digits.getPossibleVariants(Arrays.asList(1, 1));
        Assert.assertEquals(Collections.singletonList(11), variants);
        variants = Digits.getPossibleVariants(Arrays.asList(1, 1, 5, 6));
        System.out.println(variants);
        Assert.assertEquals(Arrays.asList(1156, 1165, 1516, 1561, 1615, 1651, 5116, 5161, 5611, 6115, 6151, 6511), variants);
    }
}
