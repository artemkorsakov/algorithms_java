package com.github.artemkorsakov.powers;

import java.util.ArrayList;
import java.util.List;

public class TwoPowers {
    public static int getMaxPowerOfTwo(int limit) {
        int power = -1;
        int mul = 1;

        while (mul <= limit) {
            mul <<= 1;
            power++;
        }

        return power;
    }

    public static long getDigitSumPowerOfTwo(int power) {
        return getListPowerOfTwo(power).stream().mapToInt(Integer::intValue).sum();
    }

    public static List<Integer> getListPowerOfTwo(int power) {
        List<Integer> result = new ArrayList<>();
        if (power == 0) {
            result.add(1);
            return result;
        }

        List<Integer> oldResult = getListPowerOfTwo(power - 1);

        int rest = 0;
        for (Integer integer : oldResult) {
            int number = integer * 2 + rest;
            rest = number / 10;
            result.add(number % 10);
        }

        if (rest > 0) {
            result.add(rest);
        }

        return result;
    }

}
