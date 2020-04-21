package com.github.artemkorsakov.primes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Primes {
    /**
     * Is number a prime number?
     * Some useful facts:
     * 1 is not a prime.
     * All primes except 2 are odd.
     * All primes greater than 3 can be written in the form 6k+/-1.
     * The consequence for primality testing of a number n is: if we cannot find a number f less than
     * or equal n that divides n then n is prime: the only primefactor of n is n itself
     */
    public static boolean isPrime(long n) {
        if (n < 2) {
            return false;
        }
        if (n < 4) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        if (n < 9) {
            return true;
        }
        if (n % 3 == 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(n);
        int candidate = 5;
        while (candidate <= sqrt) {
            if (n % candidate == 0) {
                return false;
            }
            if (n % (candidate + 2) == 0) {
                return false;
            }
            candidate = candidate + 6;
        }
        return true;
    }

    /**
     * Get next prime number for the given prime number.
     */
    public static long getNextPrime(long prime) {
        if (prime == 2) {
            return 3;
        }
        if (prime == 3) {
            return 5;
        }

        long nextPrime = prime % 3 == 1 ? prime + 4 : prime + 2;
        while (!isPrime(nextPrime)) {
            nextPrime = nextPrime % 3 == 1 ? nextPrime + 4 : nextPrime + 2;
        }

        return nextPrime;
    }

    /**
     * {@link Primes#getNextPrime(long)}  getNextPrime(long)}
     */
    public static int getNextPrime(int prime) {
        return (int) getNextPrime((long) prime);
    }

    /**
     * Get all primes not more than limit (inclusive).
     */
    public static int[] getAllPrimesNotMoreThanLimit(int limit) {
        boolean[] isPrime = getAllPrimesNotMoreThanLimitInBooleanArray(limit);
        return IntStream.range(0, isPrime.length).filter(i -> isPrime[i]).toArray();
    }

    /**
     * Returns a Boolean array 'isPrime' where isPrime[i] indicates whether i is prime, for 0 {@literal <}= i {@literal <}= n.
     */
    public static boolean[] getAllPrimesNotMoreThanLimitInBooleanArray(int limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("Negative array size");
        }
        boolean[] result = new boolean[limit + 1];
        if (limit >= 2) {
            result[2] = true;
        }
        if (limit >= 3) {
            result[3] = true;
        }

        int candidate = 5;
        while (candidate <= limit) {
            result[candidate] = true;
            candidate += 2;
            if (candidate <= limit) {
                result[candidate] = true;
            }
            candidate += 4;
        }

        candidate = 5;
        while (candidate * candidate <= limit) {
            if (result[candidate]) {
                for (int j = candidate * candidate; j <= limit; j += candidate * 2) {
                    result[j] = false;
                }
            }
            candidate += 2;
            if (candidate <= limit && result[candidate]) {
                for (int j = candidate * candidate; j <= limit; j += candidate * 2) {
                    result[j] = false;
                }
            }
            candidate += 4;
        }

        return result;
    }

    /**
     * Get the given number of primes.
     */
    public static List<Long> getTheGivenNumberOfPrimes(int count) {
        if (count <= 0) {
            return new ArrayList<>();
        }
        List<Long> primes = new ArrayList<>();
        primes.add(2L);
        if (count == 1) {
            return primes;
        }
        primes.add(3L);
        if (count == 2) {
            return primes;
        }

        long candidate = 5;
        while (primes.size() < count) {
            if (isPrime(candidate)) {
                primes.add(candidate);
            }
            candidate += 2;
            if (primes.size() < count && isPrime(candidate)) {
                primes.add(candidate);
            }
            candidate += 4;
        }

        return primes;
    }

    /**
     * Get the largest prime factor.
     */
    public static long getTheLargestPrimeFactor(long number) {
        long max = 1;
        int i = 2;
        while (i <= number) {
            if (number % i == 0) {
                max = i;
                while (number % i == 0) {
                    number = number / i;
                }
            }
            i = Primes.getNextPrime(i);
        }

        return max;
    }

    /**
     * Returns an array spf where spf[k] is the smallest prime factor of k, valid for 2 {@literal <}= k {@literal <}= n.
     * For example: listSmallestPrimeFactors(10) = {0, 0, 2, 3, 2, 5, 2, 7, 2, 3, 2}.
     */
    public static int[] getListSmallestPrimeFactors(int n) {
        int[] result = new int[n + 1];
        int limit = (int) Math.sqrt(n);
        for (int i = 2; i < result.length; i++) {
            if (result[i] == 0) {
                result[i] = i;
                if (i <= limit) {
                    for (int j = i * i; j <= n; j += i) {
                        if (result[j] == 0) {
                            result[j] = i;
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * Get the smallest prime factor.
     */
    public static long getTheSmallestPrimeFactor(long number) {
        long i = 2;
        while (i <= (int) Math.sqrt(number)) {
            if (number % i == 0) {
                return i;
            }
            i++;
        }

        return number;
    }

    /**
     * Get all prime divisors of a number along with its powers.
     */
    public static Map<Integer, Integer> getAllPrimeFactorsWithPow(long number) {
        Map<Integer, Integer> result = new HashMap<>();

        int i = 2;
        while (number > 1) {
            if (isPrime(i) && number % i == 0) {
                int pow = 0;
                while (number % i == 0) {
                    number = number / i;
                    pow++;
                }
                result.put(i, pow);
            }
            i++;
        }

        return result;
    }

}
