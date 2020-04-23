package com.github.artemkorsakov.figure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vector {
    private BigInteger num;
    private BigInteger den;

    public Vector plus(Vector vector) {
        return new Vector(num.add(vector.num), den.add(vector.den));
    }

    public Vector mul(int a) {
        return new Vector(num.multiply(BigInteger.valueOf(a)), den.multiply(BigInteger.valueOf(a)));
    }

}
