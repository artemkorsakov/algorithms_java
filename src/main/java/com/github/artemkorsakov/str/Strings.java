package com.github.artemkorsakov.str;

import java.util.Arrays;

public class Strings {
    /**
     * Gets sum of two big numbers.
     */
    public static String getSum(String first, String second) {
        first = first.replaceAll("\\D", "");
        second = second.replaceAll("\\D", "");
        if (first.isEmpty()) {
            return second;
        }
        if (second.isEmpty()) {
            return first;
        }

        int sumLast = Integer.parseInt(first.substring(first.length() - 1)) + Integer.parseInt(second.substring(second.length() - 1));
        String sumFirst = getSum(first.substring(0, first.length() - 1), second.substring(0, second.length() - 1));
        if (sumLast > 9) {
            sumFirst = getSum(sumFirst, "1");
            sumLast -= 10;
        }

        return sumFirst + sumLast;
    }

    /**
     * Are two words anagrams?
     */
    public static boolean areAnagrams(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        char[] digits1 = word1.toCharArray();
        Arrays.sort(digits1);
        char[] digits2 = word2.toCharArray();
        Arrays.sort(digits2);
        return Arrays.equals(digits1, digits2);
    }
}
