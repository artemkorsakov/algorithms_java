package com.github.artemkorsakov.numerals;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RomanNumeralSymbolTests {
    @Test
    public void testGetI() {
        Assert.assertEquals(RomanNumeralSymbol.I.getI(), 1);
        Assert.assertEquals(RomanNumeralSymbol.IV.getI(), 4);
        Assert.assertEquals(RomanNumeralSymbol.V.getI(), 5);
        Assert.assertEquals(RomanNumeralSymbol.IX.getI(), 9);
        Assert.assertEquals(RomanNumeralSymbol.X.getI(), 10);
        Assert.assertEquals(RomanNumeralSymbol.XL.getI(), 40);
        Assert.assertEquals(RomanNumeralSymbol.L.getI(), 50);
        Assert.assertEquals(RomanNumeralSymbol.XC.getI(), 90);
        Assert.assertEquals(RomanNumeralSymbol.C.getI(), 100);
        Assert.assertEquals(RomanNumeralSymbol.CD.getI(), 400);
        Assert.assertEquals(RomanNumeralSymbol.D.getI(), 500);
        Assert.assertEquals(RomanNumeralSymbol.CM.getI(), 900);
        Assert.assertEquals(RomanNumeralSymbol.M.getI(), 1000);
    }

    @Test
    public void testToRomanNumeralSymbol() {
        Assert.assertEquals(RomanNumeralSymbol.I, RomanNumeralSymbol.toRomanNumeralSymbol("I"));
        Assert.assertEquals(RomanNumeralSymbol.I, RomanNumeralSymbol.toRomanNumeralSymbol("II"));
        Assert.assertEquals(RomanNumeralSymbol.I, RomanNumeralSymbol.toRomanNumeralSymbol("IL"));
        Assert.assertEquals(RomanNumeralSymbol.IV, RomanNumeralSymbol.toRomanNumeralSymbol("IV"));
        Assert.assertEquals(RomanNumeralSymbol.V, RomanNumeralSymbol.toRomanNumeralSymbol("V"));
        Assert.assertEquals(RomanNumeralSymbol.V, RomanNumeralSymbol.toRomanNumeralSymbol("VV"));
        Assert.assertEquals(RomanNumeralSymbol.IX, RomanNumeralSymbol.toRomanNumeralSymbol("IX"));
        Assert.assertEquals(RomanNumeralSymbol.X, RomanNumeralSymbol.toRomanNumeralSymbol("X"));
        Assert.assertEquals(RomanNumeralSymbol.XL, RomanNumeralSymbol.toRomanNumeralSymbol("XL"));
        Assert.assertEquals(RomanNumeralSymbol.L, RomanNumeralSymbol.toRomanNumeralSymbol("L"));
        Assert.assertEquals(RomanNumeralSymbol.XC, RomanNumeralSymbol.toRomanNumeralSymbol("XC"));
        Assert.assertEquals(RomanNumeralSymbol.C, RomanNumeralSymbol.toRomanNumeralSymbol("C"));
        Assert.assertEquals(RomanNumeralSymbol.CD, RomanNumeralSymbol.toRomanNumeralSymbol("CD"));
        Assert.assertEquals(RomanNumeralSymbol.D, RomanNumeralSymbol.toRomanNumeralSymbol("D"));
        Assert.assertEquals(RomanNumeralSymbol.CM, RomanNumeralSymbol.toRomanNumeralSymbol("CM"));
        Assert.assertEquals(RomanNumeralSymbol.M, RomanNumeralSymbol.toRomanNumeralSymbol("M"));
    }

}
