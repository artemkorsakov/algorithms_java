package com.github.artemkorsakov.equations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://en.wikipedia.org/wiki/Polynomial">Polynomial equation</a>.
 */
public class PolynomialEquation {
    /**
     * Solution of a polynomial equation with given coefficients for a given n.
     */
    public static long getPolynomialSolution(int n, long[] aList) {
        long result = 0;
        for (int i = 0; i < aList.length; i++) {
            result += aList[i] * Math.pow(n, aList.length - 1 - i);
        }
        return result;
    }

    /**
     * Returns the coefficients of a polynomial equation.
     *
     * @param k         - +1 on the power of equation: a[1]*n^k-1 + ... + a[i]*n^k-i + ... + a[k]
     * @param solutions - known solutions for 1, 2, 3, ... , size
     * @return a[1], a[2], ..., a[k]
     */
    public static long[] getPolynomialCoefficients(int k, long[] solutions) {
        long[] aList = new long[k];

        List<List<Long>> coefficientsList = getCoefficientsForSolutionSearching(k);
        for (int i = k - 1; i >= 0; i--) {
            List<Long> coefficients = coefficientsList.get(i);
            int index = k - coefficients.size();
            long divisor = 0;
            for (int j = 0; j < coefficients.size(); j++) {
                aList[index] += coefficients.get(j) * solutions[coefficients.size() - 1 - j];
                for (int m = 0; m < index; m++) {
                    aList[index] -= aList[m] * coefficients.get(j) * Math.pow(coefficients.size() - j, k - 1 - m);
                }
                divisor += coefficients.get(j) * Math.pow(coefficients.size() - j, coefficients.size() - 1);
            }

            aList[index] /= divisor;
        }

        return aList;
    }

    private static List<List<Long>> getCoefficientsForSolutionSearching(int k) {
        List<List<Long>> coefficients = new ArrayList<>();
        if (k == 1) {
            coefficients.add(Collections.singletonList(1L));
            return coefficients;
        }

        coefficients.addAll(getCoefficientsForSolutionSearching(k - 1));
        List<Long> last = coefficients.get(coefficients.size() - 1);

        List<Long> current = new ArrayList<>();
        current.add(1L);
        for (int i = 0; i < last.size() - 1; i++) {
            current.add(last.get(i + 1) - last.get(i));
        }
        current.add(-last.get(last.size() - 1));

        coefficients.add(current);
        return coefficients;
    }
}
