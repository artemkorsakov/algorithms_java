package com.github.artemkorsakov.games.poker;

public enum PokerHands {
    FIVE_OF_A_KIND(9),    // All cards are equal
    STRAIGHT_FLUSH(8),    // A straight flush is a hand that contains five cards of sequential rank, all of the same suit
    FOUR_OF_A_KIND(7),    // Four of a kind is a hand that contains four cards of one rank and one card of another rank
    FULL_HOUSE(6),        // A full house is a hand that contains three cards of one rank and two cards of another rank
    FLUSH(5),             // A flush is a hand that contains five cards all of the same suit, not all of sequential rank
    STRAIGHT(4),          // A straight is a hand that contains five cards of sequential rank, not all of the same suit
    THREE_OF_A_KIND(3),   // Three of a kind is a hand that contains three cards of one rank and two cards of two other ranks (the kickers)
    TWO_PAIR(2),          // Two pair is a hand that contains two cards of one rank, two cards of another rank and one card of a third rank (the kicker)
    ONE_PAIR(1),          // One pair is a hand that contains two cards of one rank and three cards of three other ranks (the kickers)
    HIGH_CARD(0);          // High card is a hand that does not fall into any other category

    private final int rank;

    PokerHands(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }
}
