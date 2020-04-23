package com.github.artemkorsakov.numerals;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://en.wikipedia.org/wiki/Roman_numerals">Roman Numerals</a>
 *
 * @see <a href="https://projecteuler.net/about=roman_numerals">About Roman Numerals</a>
 */
@Data
public class RomanNumerals {
    private String number;
    private String minimal;
    private List<RomanNumeralSymbol> romanNumeralSymbols = new ArrayList<>();

    public RomanNumerals(String number) {
        this.number = number;
        minimal = calculateMinimal();
        String temp = number + "  ";
        for (int i = 0; i < number.length(); i = i + romanNumeralSymbols.get(romanNumeralSymbols.size() - 1).name().length()) {
            RomanNumeralSymbol romanNumeralSymbol = RomanNumeralSymbol.toRomanNumeralSymbol(temp.substring(i, i + 2));
            romanNumeralSymbols.add(romanNumeralSymbol);
        }
    }

    /**
     * I(1), V(5), X(10), L(50), C(100), D(500), M(1000)
     * Numerals must be arranged in descending order of size.
     * M, C, and X cannot be equalled or exceeded by smaller denominations.
     * D, L, and V can each only appear once.
     * Only one I, X, and C can be used as the leading numeral in part of a subtractive pair.
     * I can only be placed before V and X.
     * X can only be placed before L and C.
     * C can only be placed before D and M.
     */
    private String calculateMinimal() {
        return number.toUpperCase()
                .replaceAll("IIIII", "V")
                .replaceAll("VV", "X")
                .replaceAll("XXXXX", "L")
                .replaceAll("LL", "C")
                .replaceAll("CCCCC", "D")
                .replaceAll("DD", "M")
                .replaceAll("VIIII", "IX")
                .replaceAll("IIII", "IV")
                .replaceAll("LXXXX", "XC")
                .replaceAll("XXXX", "XL")
                .replaceAll("DCCCC", "CM")
                .replaceAll("CCCC", "CD");
    }
}
