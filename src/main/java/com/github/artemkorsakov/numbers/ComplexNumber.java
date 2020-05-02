package com.github.artemkorsakov.numbers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @see <a href="https://en.wikipedia.org/wiki/Complex_number">Complex number</a>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ComplexNumber {
    private double a;
    private double b;

    public ComplexNumber(long a, long b) {
        this.a = a;
        this.b = b;
    }

    public ComplexNumber(ComplexNumber complexNumber) {
        a = complexNumber.a;
        b = complexNumber.b;
    }

    public void add(ComplexNumber complexNumber) {
        a += complexNumber.a;
        b += complexNumber.b;
    }

    public void sub(ComplexNumber complexNumber) {
        a -= complexNumber.a;
        b -= complexNumber.b;
    }

    public void mul(ComplexNumber complexNumber) {
        double c = a * complexNumber.a - b * complexNumber.b;
        double d = a * complexNumber.b + b * complexNumber.a;
        a = c;
        b = d;
    }

    public void div(ComplexNumber complexNumber) {
        if (complexNumber.a == 0 && complexNumber.b == 0) {
            throw new IllegalArgumentException("Can't divide by 0");
        }

        double den = Math.pow(complexNumber.a, 2) + Math.pow(complexNumber.b, 2);
        double c = a * complexNumber.a + b * complexNumber.b;
        double d = b * complexNumber.a - a * complexNumber.b;
        a = c / den;
        b = d / den;
    }

    public void abs() {
        a = Math.abs(a);
        b = Math.abs(b);
    }

    public ComplexNumber conjugate() {
        return new ComplexNumber(a, -b);
    }

    public double getTheProductOfThisAndItsConjugate() {
        return a * a + b * b;
    }

    public void power2() {
        double c = a * a - b * b;
        double d = 2 * a * b;
        a = c;
        b = d;
    }

    public void power(int p) {
        if (p < 1) {
            throw new IllegalArgumentException();
        }
        if (p == 1) {
            return;
        }

        String powers = Long.toBinaryString(p);
        ComplexNumber[] powersC = new ComplexNumber[powers.length()];
        powersC[0] = this;
        for (int i = 1; i < powersC.length; i++) {
            powersC[i] = new ComplexNumber(powersC[i - 1]);
            powersC[i].power2();
        }

        ComplexNumber c = powersC[powersC.length - 1];
        for (int i = 1; i < powers.length(); i++) {
            if (powers.charAt(i) == '1') {
                c.mul(powersC[powersC.length - 1 - i]);
            }
        }

        a = c.a;
        b = c.b;
    }

    public ComplexNumber[] sqrt() {
        ComplexNumber[] solutions = new ComplexNumber[2];
        double sqrtProd = Math.sqrt(getTheProductOfThisAndItsConjugate());
        double c = Math.sqrt((sqrtProd + a) / 2.0);
        double d = Math.sqrt((sqrtProd - a) / 2.0);
        solutions[0] = new ComplexNumber(c, d);
        solutions[1] = new ComplexNumber(c, -d);
        return solutions;
    }

}
