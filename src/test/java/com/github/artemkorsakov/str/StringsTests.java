package com.github.artemkorsakov.str;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StringsTests {
    @Test
    public void testGetSum() {
        Assert.assertEquals(Strings.getSum("37107287533902102798797998220837590246510135740250", "46376937677490009712648124896970078050417018260538"), "83484225211392112511446123117807668296927154000788");
    }

    @Test
    public void test() {
        Assert.assertTrue(Strings.areAnagrams("post", "stop"));
        Assert.assertFalse(Strings.areAnagrams("post", "stoop"));
        Assert.assertFalse(Strings.areAnagrams("post", "soop"));
    }
}
