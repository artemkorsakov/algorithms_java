package com.github.artemkorsakov.numerals;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * I = 1
 * V = 5
 * X = 10
 * L = 50
 * C = 100
 * D = 500
 * M = 1000
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum RomanNumeralSymbol {
    I(1),
    IV(4),
    V(5),
    IX(9),
    X(10),
    XL(40),
    L(50),
    XC(90),
    C(100),
    CD(400),
    D(500),
    CM(900),
    M(1000);

    @Getter
    private final int i;

    /**
     * String to Roman Numeral Symbol.
     */
    public static RomanNumeralSymbol toRomanNumeralSymbol(String twoChars) {
        return Arrays.stream(values()).filter(v -> v.name().equalsIgnoreCase(twoChars)).findFirst()
                .orElse(Arrays.stream(values()).filter(v -> v.name().equalsIgnoreCase(twoChars.substring(0, 1))).findFirst().orElseThrow());
    }
}
