package com.github.artemkorsakov.numerals;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RomanNumeralsTests {
    @Test
    public void testGetMinimal() {
        Assert.assertEquals(new RomanNumerals("XXXXVIIII").getMinimal(), "XLIX");
        Assert.assertEquals(new RomanNumerals("XXXXIIIIIIIII").getMinimal(), "XLIX");
        Assert.assertEquals(new RomanNumerals("XXXXVIIII").getMinimal(), "XLIX");
        Assert.assertEquals(new RomanNumerals("XXXXIX").getMinimal(), "XLIX");
        Assert.assertEquals(new RomanNumerals("XLIIIIIIIII").getMinimal(), "XLIX");
        Assert.assertEquals(new RomanNumerals("XLVIIII").getMinimal(), "XLIX");
        Assert.assertEquals(new RomanNumerals("MCCCCCCVI").getMinimal(), "MDCVI");
        Assert.assertEquals(new RomanNumerals("XIIIIII").getMinimal(), "XVI");
        Assert.assertEquals(new RomanNumerals("VVVI").getMinimal(), "XVI");
        Assert.assertEquals(new RomanNumerals("VIIIIIIIIIII").getMinimal(), "XVI");
    }

}
