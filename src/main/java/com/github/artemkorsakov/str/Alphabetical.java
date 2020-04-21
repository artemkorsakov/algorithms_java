package com.github.artemkorsakov.str;

public class Alphabetical {
    /**
     * Gets the alphabetical value.
     */
    public static int getTheAlphabeticalValue(String name) {
        int sum = 0;
        for (char aChar : name.replaceAll("\\W", "").toUpperCase().toCharArray()) {
            sum += (aChar - 'A') + 1;
        }
        return sum;
    }

}
