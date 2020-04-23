package com.github.artemkorsakov.equations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equation {
    private BigInteger x;
    private BigInteger y;
}
