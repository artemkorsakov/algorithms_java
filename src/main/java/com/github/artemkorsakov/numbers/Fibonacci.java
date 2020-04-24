package com.github.artemkorsakov.numbers;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * @see <a href="https://en.wikipedia.org/wiki/Fibonacci_number">Fibonacci number</a>
 */
public class Fibonacci {
    public static BigInteger getFibonacciNumber(int k) {
        return BigDecimal.valueOf(GoldenRatio.PHI).pow(k).divide(BigDecimal.valueOf(Math.sqrt(5)), 0, RoundingMode.HALF_UP).toBigInteger();
    }

    // Необходимо добавить метод вычисления числа Фиббоначи по формуле
    // https://ru.wikipedia.org/wiki/%D0%A7%D0%B8%D1%81%D0%BB%D0%B0_%D0%A4%D0%B8%D0%B1%D0%BE%D0%BD%D0%B0%D1%87%D1%87%D0%B8
    // (1 1)^n = (F[n+1] F[n])
    // (1 0)     (F[n] F[n-1])
}
