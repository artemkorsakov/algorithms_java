package com.github.artemkorsakov.games.nim;

public class Nim {
    /**
     * <a href="https://en.wikipedia.org/wiki/Nim">Nim</a>
     */
    public static long getX(long... params) {
        long result = params[0];
        for (int i = 1; i < params.length; i++) {
            result = result ^ params[i];
        }
        return result;
    }
}
