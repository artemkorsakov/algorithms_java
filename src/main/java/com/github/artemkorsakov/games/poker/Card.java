package com.github.artemkorsakov.games.poker;

public class Card {
    private PokerRank pokerRank;
    private PokerSuit pokerSuit;

    Card(String card) {
        if (card.length() != 2 && card.length() != 3) {
            throw new IllegalArgumentException("Invalid card");
        }
        pokerRank = PokerRank.getPokerRank(card.substring(0, card.length() - 1));
        pokerSuit = PokerSuit.valueOf(card.substring(card.length() - 1));
    }

    PokerRank getPokerRank() {
        return pokerRank;
    }

    PokerSuit getPokerSuit() {
        return pokerSuit;
    }
}
