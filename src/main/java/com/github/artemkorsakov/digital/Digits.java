package com.github.artemkorsakov.digital;

import com.github.artemkorsakov.str.Strings;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Digits {
    /**
     * Do two numbers contain the same digits boolean?
     */
    public static boolean containTheSameDigits(long number1, long number2) {
        return containTheSameDigits(String.valueOf(number1), String.valueOf(number2));
    }

    /**
     * Do two numbers contain the same digits boolean?
     */
    public static boolean containTheSameDigits(String number1, String number2) {
        return Strings.areAnagrams(number1, number2);
    }

    /**
     * Returns the digits of a number starting with the last.
     */
    public static List<Integer> getDigits(int number) {
        return getDigits((long) number);
    }

    /**
     * Returns the digits of a number starting with the last.
     */
    public static List<Integer> getDigits(long number) {
        List<Integer> digits = new ArrayList<>();

        while (number > 0) {
            int digit = (int) (number % 10);
            digits.add(digit);
            number = number / 10;
        }

        return digits;
    }

    /**
     * Returns the digits of a number starting with the last.
     */
    public static List<Integer> getDigits(String number) {
        List<Integer> digits = new ArrayList<>();

        for (int i = number.length() - 1; i >= 0; i--) {
            digits.add(Character.getNumericValue(number.charAt(i)));
        }

        return digits;
    }

    /**
     * Returns the sum of the digits of a number.
     */
    public static int getSumOfDigits(long number) {
        int sum = 0;

        while (number > 0) {
            sum += (int) (number % 10);
            number = number / 10;
        }

        return sum;
    }

    /**
     * Returns the sum of the digits of a number.
     */
    public static long getSumOfDigits(BigInteger number) {
        long sum = 0;

        while (number.compareTo(BigInteger.valueOf(0)) > 0) {
            sum += number.mod(BigInteger.valueOf(10)).intValue();
            number = number.divide(BigInteger.valueOf(10));
        }

        return sum;
    }

    /**
     * Is the given digit in the given number at least countOfEqual times?
     */
    public static boolean hasEqualDigits(long number, int countOfEqual, int digit) {
        return getDigits(number).stream().filter(d -> d == digit).count() >= countOfEqual;
    }

    /**
     * Has equal digits?
     */
    public static boolean hasEqualDigits(long number) {
        List<Integer> digits = getDigits(number);
        return digits.size() != digits.stream().distinct().count();
    }

    /**
     * Returns all numbers made up of given digits.
     */
    public static List<Integer> getPossibleVariants(List<Integer> digits) {
        return getStringPossibleVariants(digits).stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    /**
     * Returns all numbers made up of given digits.
     */
    public static List<String> getStringPossibleVariants(List<Integer> digits) {
        if (digits.size() == 1) {
            return Collections.singletonList("" + digits.get(0));
        }

        List<String> products = new ArrayList<>();
        for (int i = 0; i < digits.size(); i++) {
            String digit = "" + digits.get(i);
            List<Integer> tmpDigits = new ArrayList<>();
            tmpDigits.addAll(digits.subList(0, i));
            tmpDigits.addAll(digits.subList(i + 1, digits.size()));
            List<String> tmpVariants = getStringPossibleVariants(tmpDigits);
            for (String tmpVariant : tmpVariants) {
                String newProduct = digit + tmpVariant;
                if (!products.contains(newProduct)) {
                    products.add(newProduct);
                }
            }
        }

        return products;
    }

}
