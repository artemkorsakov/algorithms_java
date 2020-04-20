package com.github.artemkorsakov.combinatoric;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Coins {
    /**
     * How many options to get a given result from given coins?
     *
     * @see <a href="https://projecteuler.net/overview=031">detailed description</a>
     */
    public static long getCountWays(List<Integer> coins, int total) {
        return getCountWays(coins.stream().mapToInt(Integer::intValue).toArray(), total);
    }

    /**
     * {@link Coins#getCountWays(List, int)}  getCountWays}
     */
    public static long getCountWays(int[] coins, int total) {
        int[] ways = new int[total + 1];
        ways[0] = 1;

        for (int coin : coins) {
            for (int j = coin; j <= total; j++) {
                ways[j] += ways[j - coin];
            }
        }

        return ways[total];
    }

    /**
     * A way of writing n as a sum of positive integers.
     *
     * @see <a href="https://en.wikipedia.org/wiki/Partition_(number_theory)">detailed description</a>
     */
    public static BigInteger getPartitionsCount(int limit) {
        Hashtable<Integer, BigInteger> List = new Hashtable<>();
        List.put(0, BigInteger.ONE);
        List.put(1, BigInteger.ONE);
        List.put(2, BigInteger.TWO);
        for (int n = 3; n <= limit; n++) {
            BigInteger p = BigInteger.ZERO;
            for (int k = 1, op = 1; op <= n; k++, op = k * (3 * k - 1) / 2) {
                if ((k + 1) % 2 == 0) {
                    p = p.add(List.get(n - op));
                } else {
                    p = p.subtract(List.get(n - op));
                }
            }
            for (int k = -1, op = 2; op <= n; k--, op = k * (3 * k - 1) / 2) {
                if ((k + 1) % 2 == 0) {
                    p = p.add(List.get(n - op));
                } else {
                    p = p.subtract(List.get(n - op));
                }
            }
            List.put(n, p);
        }

        return List.get(limit);
    }

    /**
     * How many options to get sum as a sum of at least two positive numbers?
     */
    public static long getCount(int sum) {
        return getPartitionsCount(sum).subtract(BigInteger.ONE).longValueExact();
    }

    /**
     * Returns all options to get the sum sum with a given count of numbers.
     */
    public static List<List<Integer>> getCandidatesPowers(int sum, int count) {
        return getCandidatesPowers(sum, count, sum);
    }

    private static List<List<Integer>> getCandidatesPowers(int sum, int count, int pred) {
        List<List<Integer>> powersList = new ArrayList<>();

        if (sum < count) {
            return powersList;
        }

        if (count == 1) {
            if (pred >= sum) {
                List<Integer> powers = new ArrayList<>();
                powers.add(sum);
                powersList.add(powers);
            }
            return powersList;
        }

        if (sum == count) {
            powersList.add(IntStream.range(1, count + 1).map(i -> 1).boxed().collect(Collectors.toList()));
            return powersList;
        }

        if ((long) pred * count < sum) {
            return powersList;
        }

        for (int i = pred; i >= sum / count; i--) {
            List<List<Integer>> newTempPowersList = getCandidatesPowers(sum - i, count - 1, i);
            for (List<Integer> tempPowers : newTempPowersList) {
                List<Integer> tmpPowers = new ArrayList<>();
                tmpPowers.add(i);
                tmpPowers.addAll(tempPowers);
                powersList.add(tmpPowers);
            }
        }

        return powersList;
    }
}
