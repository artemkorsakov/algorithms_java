package com.github.artemkorsakov.games.poker;

public enum PokerRank {
    A(14),
    K(13),
    Q(12),
    J(11),
    TEN(10),
    NINE(9),
    EIGHT(8),
    SEVEN(7),
    SIX(6),
    FIVE(5),
    FOUR(4),
    THREE(3),
    TWO(2);

    private final int rank;

    PokerRank(int rank) {
        this.rank = rank;
    }

    public static PokerRank getPokerRank(String s) {
        switch (s) {
            case "A":
                return A;
            case "K":
                return K;
            case "Q":
                return Q;
            case "J":
                return J;
            case "10":
            case "T":
                return TEN;
            case "9":
                return NINE;
            case "8":
                return EIGHT;
            case "7":
                return SEVEN;
            case "6":
                return SIX;
            case "5":
                return FIVE;
            case "4":
                return FOUR;
            case "3":
                return THREE;
            case "2":
                return TWO;
        }
        return null;
    }

    public int getRank() {
        return rank;
    }
}
