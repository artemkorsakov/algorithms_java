package com.github.artemkorsakov.numbers;

public class HammingNumber {
    /**
     * We will call a positive number a generalised Hamming number of type n, if it has no prime factor larger than n.
     */
    public static boolean isHammingNumber(long number, int[] primes) {
        if (number < 2) {
            return true;
        }

        for (int prime : primes) {
            while (number % prime == 0) {
                number = number / prime;
            }
            if (number == 1) {
                return true;
            }
        }

        return false;
    }
}
