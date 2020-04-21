package com.github.artemkorsakov.str;

public class NumbersDescription {
    /**
     * Gets number description.
     */
    public static String getDescription(int number) {
        if (number < 21) {
            return getNumberDescription(number);
        }

        if (number < 100) {
            int first = number / 10;
            int second = number % 10;
            String rest = second == 0 ? "" : "-" + getNumberDescription(second);
            return getNumberDescription(first * 10) + rest;
        }

        if (number < 1000) {
            String first = getNumberDescription(number / 100) + " " + getNumberDescription(100);
            int rest = number % 100;
            String second = rest == 0 ? "" : " and " + getDescription(rest);
            return first + second;
        }

        if (number < 1000000) {
            String first = getDescription(number / 1000) + " " + getNumberDescription(1000);
            int rest = number % 1000;
            String second = rest == 0 ? "" : " " + getDescription(rest);
            return first + second;
        }

        throw new IllegalArgumentException();
    }

    private static String getNumberDescription(int number) {
        if (number == 0) {
            return "";
        }
        if (number == 1) {
            return "one";
        }
        if (number == 2) {
            return "two";
        }
        if (number == 3) {
            return "three";
        }
        if (number == 4) {
            return "four";
        }
        if (number == 5) {
            return "five";
        }
        if (number == 6) {
            return "six";
        }
        if (number == 7) {
            return "seven";
        }
        if (number == 8) {
            return "eight";
        }
        if (number == 9) {
            return "nine";
        }
        if (number == 10) {
            return "ten";
        }
        if (number == 11) {
            return "eleven";
        }
        if (number == 12) {
            return "twelve";
        }
        if (number == 13) {
            return "thirteen";
        }
        if (number == 14) {
            return "fourteen";
        }
        if (number == 15) {
            return "fifteen";
        }
        if (number == 16) {
            return "sixteen";
        }
        if (number == 17) {
            return "seventeen";
        }
        if (number == 18) {
            return "eighteen";
        }
        if (number == 19) {
            return "nineteen";
        }
        if (number == 20) {
            return "twenty";
        }
        if (number == 30) {
            return "thirty";
        }
        if (number == 40) {
            return "forty";
        }
        if (number == 50) {
            return "fifty";
        }
        if (number == 60) {
            return "sixty";
        }
        if (number == 70) {
            return "seventy";
        }
        if (number == 80) {
            return "eighty";
        }
        if (number == 90) {
            return "ninety";
        }
        if (number == 100) {
            return "hundred";
        }
        if (number == 1000) {
            return "thousand";
        }

        throw new IllegalArgumentException();
    }
}
