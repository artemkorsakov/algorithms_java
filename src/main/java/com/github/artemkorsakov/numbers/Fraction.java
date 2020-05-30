package com.github.artemkorsakov.numbers;

import com.github.artemkorsakov.divisors.Divisors;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * <a href="https://en.wikipedia.org/wiki/Fraction_(mathematics)">Fraction</a>
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Fraction implements Comparable<Fraction> {
    public static final Fraction ZERO = new Fraction(0, 1);
    private BigInteger numerator;
    private BigInteger denominator;

    public Fraction(int numerator, int denominator) {
        this(BigInteger.valueOf(numerator), BigInteger.valueOf(denominator));
    }

    public Fraction(int numerator) {
        this(BigInteger.valueOf(numerator), BigInteger.ONE);
    }

    public Fraction(long numerator, long denominator) {
        this(BigInteger.valueOf(numerator), BigInteger.valueOf(denominator));
    }

    public Fraction(long numerator) {
        this(BigInteger.valueOf(numerator), BigInteger.ONE);
    }

    public Fraction(BigInteger numerator) {
        this(numerator, BigInteger.ONE);
    }

    public Fraction(BigInteger numerator, BigInteger denominator) {
        if (denominator.equals(BigInteger.ZERO)) {
            throw new IllegalArgumentException();
        }

        if (numerator.equals(BigInteger.ZERO)) {
            this.numerator = BigInteger.ZERO;
            this.denominator = BigInteger.ONE;
        } else {
            BigInteger gcd = Divisors.gcd(numerator, denominator);
            this.numerator = numerator.divide(gcd);
            this.denominator = denominator.divide(gcd);
        }
    }

    public Fraction(Fraction fraction) {
        numerator = fraction.getNumerator();
        denominator = fraction.getDenominator();
    }

    /**
     * Add number to the fraction.
     */
    public void plus(int number) {
        numerator = BigInteger.valueOf(number).multiply(denominator).add(numerator);
    }

    /**
     * Returns a fraction - sum of two fractions.
     */
    public Fraction plus(Fraction fraction) {
        BigInteger newNumerator = numerator.multiply(fraction.denominator).add(denominator.multiply(fraction.numerator));
        BigInteger newDenominator = denominator.multiply(fraction.denominator);
        return new Fraction(newNumerator, newDenominator);
    }

    /**
     * Returns a fraction - this fraction minus the given fraction.
     */
    public Fraction minus(Fraction fraction) {
        BigInteger newNumerator = numerator.multiply(fraction.denominator).subtract(denominator.multiply(fraction.numerator));
        BigInteger newDenominator = denominator.multiply(fraction.denominator);
        return new Fraction(newNumerator, newDenominator);
    }

    /**
     * Returns a fraction - multiplication of two fractions.
     */
    public Fraction mul(Fraction fraction) {
        return new Fraction(numerator.multiply(fraction.numerator), denominator.multiply(fraction.denominator));
    }

    /**
     * Returns a fraction - this fraction divide the given fraction.
     */
    public Fraction divide(Fraction fraction) {
        return new Fraction(numerator.multiply(fraction.denominator), denominator.multiply(fraction.numerator));
    }

    public void upend() {
        BigInteger temp = numerator;
        numerator = denominator;
        denominator = temp;
    }

    /**
     * Fraction to percent
     */
    public double getPercent() {
        return new BigDecimal(numerator).divide(new BigDecimal(denominator), 15, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public int compareTo(Fraction o) {
        BigInteger bigInteger = (numerator.multiply(o.denominator)).subtract(o.numerator.multiply(denominator));
        return bigInteger.compareTo(BigInteger.ZERO);
    }
}
