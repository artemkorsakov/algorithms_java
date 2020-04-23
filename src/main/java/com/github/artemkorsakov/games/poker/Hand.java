package com.github.artemkorsakov.games.poker;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Hand implements Comparable<Hand>, Comparator<Hand> {
    private String hand;
    private List<Card> cards;
    private PokerHands pokerHands = PokerHands.HIGH_CARD;
    private List<PokerRank> ranks = Arrays.asList(PokerRank.TWO, PokerRank.TWO, PokerRank.TWO, PokerRank.TWO, PokerRank.TWO);
    private List<PokerRank> sortedDistinctPokerRanks = null;
    private List<PokerRank> sortedPokerRanks = null;

    Hand(String hand) {
        this.hand = hand;
        String[] split = hand.split(" ");
        if (split.length != 5) {
            throw new IllegalArgumentException("Invalid hand - " + hand);
        }
        cards = Arrays.stream(split).map(Card::new).collect(Collectors.toList());
        calculate();
    }

    private void calculate() {
        if (isFiveOfAKind()) {
            calculateFiveOfAKind();
        } else if (isStraightFlush()) {
            calculateStraightFlush();
        } else if (isFourOfAKind()) {
            calculateFourOfAKind();
        } else if (isFullHouse()) {
            calculateFullHouse();
        } else if (isFlush()) {
            calculateFlush();
        } else if (isStraight()) {
            calculateStraight();
        } else if (isThreeOfAKind()) {
            calculateThreeOfAKind();
        } else if (isTwoPair()) {
            calculateTwoPair();
        } else if (isOnePair()) {
            calculateOnePair();
        } else {
            calculateHighCard();
        }
    }

    String getHand() {
        return hand;
    }

    @Override
    public int compare(Hand o1, Hand o2) {
        return o1.compareTo(o2);
    }

    @Override
    public int compareTo(Hand o) {
        int diff = pokerHands.compareTo(o.pokerHands);
        return diff != 0 ? diff : IntStream.range(0, ranks.size()).map(i -> ranks.get(i).compareTo(o.ranks.get(i)))
                .filter(r -> r != 0).findFirst().orElse(0);
    }

    private List<PokerRank> getSortedPokerRanks() {
        if (sortedPokerRanks == null) {
            sortedPokerRanks = cards.stream().map(Card::getPokerRank).sorted((o1, o2) -> o2.getRank() - o1.getRank()).collect(Collectors.toList());
        }
        return sortedPokerRanks;
    }

    private List<PokerRank> getSortedDistinctPokerRanks() {
        if (sortedDistinctPokerRanks == null) {
            sortedDistinctPokerRanks = getSortedPokerRanks().stream().distinct().collect(Collectors.toList());
        }
        return sortedDistinctPokerRanks;
    }

    private boolean isFiveOfAKind() {
        return getSortedDistinctPokerRanks().size() == 1;
    }

    private void calculateFiveOfAKind() {
        pokerHands = PokerHands.FIVE_OF_A_KIND;
        ranks.set(0, cards.get(0).getPokerRank());
    }

    private boolean isStraightFlush() {
        return isStraight() && isFlush();
    }

    private void calculateStraightFlush() {
        pokerHands = PokerHands.STRAIGHT_FLUSH;
        List<PokerRank> sortedRanks = getSortedPokerRanks();
        PokerRank pokerRank = (sortedRanks.get(0) == PokerRank.A && sortedRanks.get(1) == PokerRank.FIVE) ? PokerRank.FIVE : sortedRanks.get(0);
        ranks.set(0, pokerRank);
    }

    private boolean isStraight() {
        List<PokerRank> ranks = getSortedPokerRanks();
        if (ranks.containsAll(Arrays.asList(PokerRank.FIVE, PokerRank.FOUR, PokerRank.THREE, PokerRank.TWO, PokerRank.A))) {
            return true;
        }
        for (int i = 0; i < ranks.size() - 1; i++) {
            if (ranks.get(i).getRank() - ranks.get(i + 1).getRank() != 1) {
                return false;
            }
        }
        return true;
    }

    private void calculateStraight() {
        pokerHands = PokerHands.STRAIGHT;
        List<PokerRank> sortedRanks = getSortedPokerRanks();
        PokerRank pokerRank = (sortedRanks.get(0) == PokerRank.A && sortedRanks.get(1) == PokerRank.FIVE) ? PokerRank.FIVE : sortedRanks.get(0);
        ranks.set(0, pokerRank);
    }

    private boolean isFlush() {
        return cards.stream().map(Card::getPokerSuit).distinct().count() == 1;
    }

    private void calculateFlush() {
        ranks = getSortedPokerRanks();
        pokerHands = PokerHands.FLUSH;
    }

    private boolean isFourOfAKind() {
        long countOfRank = getSortedDistinctPokerRanks().size();
        long countOfFirstCard = cards.stream().filter(c -> c.getPokerRank() == cards.get(0).getPokerRank()).count();
        return countOfRank == 2 && (countOfFirstCard == 1 || countOfFirstCard == 4);
    }

    private void calculateFourOfAKind() {
        List<PokerRank> sortedRanks = getSortedPokerRanks();
        pokerHands = PokerHands.FOUR_OF_A_KIND;
        boolean isFirstEqualSecond = sortedRanks.get(0).getRank() == sortedRanks.get(1).getRank();
        ranks.set(0, isFirstEqualSecond ? sortedRanks.get(0) : sortedRanks.get(1));
        ranks.set(1, isFirstEqualSecond ? sortedRanks.get(4) : sortedRanks.get(0));
    }

    private boolean isFullHouse() {
        long countOfRank = getSortedDistinctPokerRanks().size();
        long countOfFirstCard = cards.stream().filter(c -> c.getPokerRank() == cards.get(0).getPokerRank()).count();
        return countOfRank == 2 && (countOfFirstCard == 2 || countOfFirstCard == 3);
    }

    private void calculateFullHouse() {
        List<PokerRank> sortedRanks = getSortedPokerRanks();
        pokerHands = PokerHands.FULL_HOUSE;
        ranks.set(0, sortedRanks.get(2));
        boolean isSecondEqualThird = sortedRanks.get(1).getRank() == sortedRanks.get(2).getRank();
        ranks.set(1, isSecondEqualThird ? sortedRanks.get(3) : sortedRanks.get(1));
    }

    private boolean isThreeOfAKind() {
        return isTwoOrThreePair(false);
    }

    private void calculateThreeOfAKind() {
        List<PokerRank> sortedRanks = getSortedPokerRanks();
        pokerHands = PokerHands.THREE_OF_A_KIND;
        int index = IntStream.range(0, sortedRanks.size() - 2)
                .filter(i -> sortedRanks.get(i).getRank() == sortedRanks.get(i + 1).getRank()
                        && sortedRanks.get(i + 1).getRank() == sortedRanks.get(i + 2).getRank())
                .findFirst().orElse(0);
        ranks.set(0, sortedRanks.get(2));
        ranks.set(1, sortedRanks.get(index == 0 ? 3 : 0));
        ranks.set(2, sortedRanks.get(index == 2 ? 1 : 4));
    }

    private boolean isTwoPair() {
        return isTwoOrThreePair(true);
    }

    private boolean isTwoOrThreePair(boolean isTwo) {
        long countOfRank = getSortedDistinctPokerRanks().size();
        if (countOfRank != 3) {
            return false;
        }
        List<PokerRank> ranks = getSortedPokerRanks();
        long countOfFirstCard = cards.stream().filter(c -> c.getPokerRank() == ranks.get(0)).count();
        long countOfLastCard = cards.stream().filter(c -> c.getPokerRank() == ranks.get(ranks.size() - 1)).count();
        return isTwo
                ? (countOfFirstCard == 2 && countOfLastCard == 2)
                || (countOfFirstCard == 2 && countOfLastCard == 1)
                || (countOfFirstCard == 1 && countOfLastCard == 2)
                : (countOfFirstCard == 1 && countOfLastCard == 1)
                || (countOfFirstCard == 3 && countOfLastCard == 1)
                || (countOfFirstCard == 1 && countOfLastCard == 3);
    }

    private void calculateTwoPair() {
        List<PokerRank> sortedRanks = getSortedPokerRanks();
        pokerHands = PokerHands.TWO_PAIR;
        boolean isFirstEqualSecond = sortedRanks.get(0).getRank() == sortedRanks.get(1).getRank();
        boolean isThirdEqualFourth = sortedRanks.get(2).getRank() == sortedRanks.get(3).getRank();
        ranks.set(0, sortedRanks.get(1));
        ranks.set(1, sortedRanks.get(3));
        int thirdIndex = isFirstEqualSecond && isThirdEqualFourth ? 4 : isFirstEqualSecond ? 2 : 0;
        ranks.set(2, sortedRanks.get(thirdIndex));
    }

    private boolean isOnePair() {
        return getSortedDistinctPokerRanks().size() == 4;
    }

    private void calculateOnePair() {
        pokerHands = PokerHands.ONE_PAIR;
        List<PokerRank> sortedRanks = getSortedPokerRanks();
        int index = IntStream.range(0, sortedRanks.size() - 1)
                .filter(i -> sortedRanks.get(i).getRank() == sortedRanks.get(i + 1).getRank())
                .findFirst().orElse(0);
        ranks.set(0, sortedRanks.get(index));
        ranks.set(1, sortedRanks.get(index == 0 ? 2 : 0));
        ranks.set(2, sortedRanks.get(index < 2 ? 3 : 1));
        ranks.set(3, sortedRanks.get(index != 3 ? 4 : 2));
    }

    private void calculateHighCard() {
        ranks = getSortedPokerRanks();
        pokerHands = PokerHands.HIGH_CARD;
    }
}
