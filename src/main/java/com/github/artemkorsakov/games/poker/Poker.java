package com.github.artemkorsakov.games.poker;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Poker {
    private List<Hand> hands = new ArrayList<>();

    Poker(List<String> hands) {
        this.hands = hands.stream().map(Hand::new).sorted(Comparator.comparing(o -> ((Hand) o))).collect(Collectors.toList());
    }

    public Poker(String player1, String player2) {
        hands.add(new Hand(player1));
        hands.add(new Hand(player2));
    }

    public boolean isPlayer1Win() {
        return hands.get(0).compareTo(hands.get(1)) < 0;
    }

    List<String> getBestHands() {
        return hands.stream().filter(h -> h.compareTo(hands.get(0)) == 0).map(Hand::getHand).collect(Collectors.toList());
    }
}
