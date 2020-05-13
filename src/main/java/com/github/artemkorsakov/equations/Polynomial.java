package com.github.artemkorsakov.equations;

/**
 * Polynomial with powers up to n-1, where we have a relation x^n = sum a_i*x^i, i = 0..n-1
 */
public class Polynomial {
    private final int n;
    private final long[] coeff;
    private final int d;

    public Polynomial(int n) {
        this.n = n;
        coeff = new long[1];
        coeff[0] = 1;
        d = 1;
    }

    public Polynomial(int n, long[] startPoly) {
        this.n = n;
        coeff = new long[n];
        System.arraycopy(startPoly, 0, coeff, 0, startPoly.length);
        int ret = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (coeff[i] != 0) {
                ret = i + 1;
                break;
            }
        }
        d = ret;
    }

    public Polynomial(Polynomial p) {
        n = p.n;
        coeff = new long[n];
        System.arraycopy(p.coeff, 0, coeff, 0, p.d);
        d = p.d;
    }

    public Polynomial multiply(Polynomial p) {
        long[] ret = new long[n];
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < p.d; j++) {
                long t = coeff[i] * p.coeff[j];
                if ((i + j) < n) {
                    ret[i + j] += t;
                } else {
                    ret[(i + j) % n + 1] += t;
                    ret[(i + j) % n] += t;
                }
            }
        }
        return new Polynomial(n, ret);
    }

    public Polynomial modPow(long pow, long m) {
        String s = Long.toBinaryString(pow);
        int l = s.length();
        Polynomial[] arr = new Polynomial[l];
        arr[0] = new Polynomial(this);
        for (int i = 1; i < l; i++) {
            arr[i] = arr[i - 1].multiply(arr[i - 1]);
            arr[i].mod(m);
        }
        Polynomial ret = new Polynomial(n);
        for (int i = 0; i < l; i++) {
            if (s.charAt(l - 1 - i) == '1') {
                ret = ret.multiply(arr[i]);
                ret.mod(m);
            }
        }
        return ret;
    }

    public void mod(long m) {
        for (int i = 0; i < d; i++) {
            coeff[i] %= m;
        }
    }

    public long sumCoefficients() {
        long ret = 0;
        for (int i = 0; i < n; i++) {
            ret += coeff[i];
        }
        return ret;
    }
}
