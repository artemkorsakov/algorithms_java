package com.github.artemkorsakov.combinatoric;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CoinsTests {
    @Test
    public void testGetCountWays() {
        long sum = Coins.getCountWays(Collections.singletonList(200), 200);
        Assert.assertEquals(sum, 1);
        sum = Coins.getCountWays(Collections.singletonList(200), 199);
        Assert.assertEquals(sum, 0);
        sum = Coins.getCountWays(Arrays.asList(1, 2, 5), 10);
        Assert.assertEquals(sum, 10);
        sum = Coins.getCountWays(Arrays.asList(1, 2, 5, 10), 10);
        Assert.assertEquals(sum, 11);
        sum = Coins.getCountWays(Arrays.asList(1, 2, 5, 10, 20, 50, 100, 200), 200);
        Assert.assertEquals(sum, 73682);

        sum = Coins.getCountWays(new int[]{200}, 200);
        Assert.assertEquals(sum, 1);
        sum = Coins.getCountWays(new int[]{200}, 199);
        Assert.assertEquals(sum, 0);
        sum = Coins.getCountWays(new int[]{1, 2, 5}, 10);
        Assert.assertEquals(sum, 10);
        sum = Coins.getCountWays(new int[]{1, 2, 5, 10}, 10);
        Assert.assertEquals(sum, 11);
        sum = Coins.getCountWays(new int[]{1, 2, 5, 10, 20, 50, 100, 200}, 200);
        Assert.assertEquals(sum, 73682);
    }

    @Test
    public void testGetPartitionsCount() {
        Assert.assertEquals(Coins.getPartitionsCount(55374), new BigInteger("36325300925435785930832331577396761646715836173633893227071086460709268608053489541731404543537668438991170680745272159154493740615385823202158167635276250554555342115855424598920159035413044811245082197335097953570911884252410730174907784762924663654000000"));
    }

    @Test
    public void testGetCount() {
        Assert.assertEquals(Coins.getCount(2), 1);
        Assert.assertEquals(Coins.getCount(3), 2);
        Assert.assertEquals(Coins.getCount(4), 4);
        Assert.assertEquals(Coins.getCount(5), 6);
        Assert.assertEquals(Coins.getCount(6), 10);
        Assert.assertEquals(Coins.getCount(7), 14);
        Assert.assertEquals(Coins.getCount(8), 21);
        Assert.assertEquals(Coins.getCount(9), 29);
        Assert.assertEquals(Coins.getCount(10), 41);
        Assert.assertEquals(Coins.getCount(11), 55);
        Assert.assertEquals(Coins.getCount(20), 626);
        Assert.assertEquals(Coins.getCount(25), 1957);
        Assert.assertEquals(Coins.getCount(100), 190569291);
    }

    @Test
    public void testGetBlockWays() {
        Assert.assertEquals(Coins.getBlockWays(4, 1, 1), 4);
        Assert.assertEquals(Coins.getBlockWays(3, 2, 2), 6);
    }

    @Test
    public void testGetCandidatesPowers() {
        List<List<Integer>> powersList = Coins.getCandidatesPowers(5, 1);
        Assert.assertEquals(powersList, Collections.singletonList(Collections.singletonList(5)));
        powersList = Coins.getCandidatesPowers(5, 2);
        Assert.assertEquals(powersList, Arrays.asList(Arrays.asList(4, 1), Arrays.asList(3, 2)));
        powersList = Coins.getCandidatesPowers(5, 3);
        Assert.assertEquals(powersList, Arrays.asList(Arrays.asList(3, 1, 1), Arrays.asList(2, 2, 1)));
        powersList = Coins.getCandidatesPowers(5, 4);
        Assert.assertEquals(powersList, Collections.singletonList(Arrays.asList(2, 1, 1, 1)));
        powersList = Coins.getCandidatesPowers(5, 5);
        Assert.assertEquals(powersList, Collections.singletonList(Arrays.asList(1, 1, 1, 1, 1)));
        powersList = Coins.getCandidatesPowers(10, 1);
        Assert.assertEquals(powersList, Collections.singletonList(Collections.singletonList(10)));
        powersList = Coins.getCandidatesPowers(10, 2);
        Assert.assertEquals(powersList, Arrays.asList(Arrays.asList(9, 1), Arrays.asList(8, 2), Arrays.asList(7, 3), Arrays.asList(6, 4), Arrays.asList(5, 5)));
        powersList = Coins.getCandidatesPowers(10, 3);
        Assert.assertEquals(powersList, Arrays.asList(Arrays.asList(8, 1, 1), Arrays.asList(7, 2, 1), Arrays.asList(6, 3, 1), Arrays.asList(6, 2, 2), Arrays.asList(5, 4, 1), Arrays.asList(5, 3, 2), Arrays.asList(4, 4, 2), Arrays.asList(4, 3, 3)));
        powersList = Coins.getCandidatesPowers(10, 4);
        Assert.assertEquals(powersList, Arrays.asList(Arrays.asList(7, 1, 1, 1), Arrays.asList(6, 2, 1, 1), Arrays.asList(5, 3, 1, 1), Arrays.asList(5, 2, 2, 1), Arrays.asList(4, 4, 1, 1), Arrays.asList(4, 3, 2, 1), Arrays.asList(4, 2, 2, 2), Arrays.asList(3, 3, 3, 1), Arrays.asList(3, 3, 2, 2)));
        powersList = Coins.getCandidatesPowers(10, 5);
        Assert.assertEquals(powersList, Arrays.asList(Arrays.asList(6, 1, 1, 1, 1), Arrays.asList(5, 2, 1, 1, 1), Arrays.asList(4, 3, 1, 1, 1), Arrays.asList(4, 2, 2, 1, 1), Arrays.asList(3, 3, 2, 1, 1), Arrays.asList(3, 2, 2, 2, 1), Arrays.asList(2, 2, 2, 2, 2)));
        powersList = Coins.getCandidatesPowers(10, 6);
        Assert.assertEquals(powersList, Arrays.asList(Arrays.asList(5, 1, 1, 1, 1, 1), Arrays.asList(4, 2, 1, 1, 1, 1), Arrays.asList(3, 3, 1, 1, 1, 1), Arrays.asList(3, 2, 2, 1, 1, 1), Arrays.asList(2, 2, 2, 2, 1, 1)));
        powersList = Coins.getCandidatesPowers(10, 7);
        Assert.assertEquals(powersList, Arrays.asList(Arrays.asList(4, 1, 1, 1, 1, 1, 1), Arrays.asList(3, 2, 1, 1, 1, 1, 1), Arrays.asList(2, 2, 2, 1, 1, 1, 1)));
        powersList = Coins.getCandidatesPowers(10, 8);
        Assert.assertEquals(powersList, Arrays.asList(Arrays.asList(3, 1, 1, 1, 1, 1, 1, 1), Arrays.asList(2, 2, 1, 1, 1, 1, 1, 1)));
        powersList = Coins.getCandidatesPowers(10, 9);
        Assert.assertEquals(powersList, Collections.singletonList(Arrays.asList(2, 1, 1, 1, 1, 1, 1, 1, 1)));
        powersList = Coins.getCandidatesPowers(10, 10);
        Assert.assertEquals(powersList, Collections.singletonList(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1)));
    }

}
