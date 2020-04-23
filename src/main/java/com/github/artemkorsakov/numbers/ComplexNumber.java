package com.github.artemkorsakov.numbers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @see <a href="https://en.wikipedia.org/wiki/Complex_number">Complex number</a>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComplexNumber {
    private long a;
    private long b;

    public void mul(ComplexNumber complexNumber) {
        long newA = a * complexNumber.a - b * complexNumber.b;
        long newB = a * complexNumber.b + b * complexNumber.a;
        a = newA;
        b = newB;
    }

    public void abs() {
        a = Math.abs(a);
        b = Math.abs(b);
    }

}
