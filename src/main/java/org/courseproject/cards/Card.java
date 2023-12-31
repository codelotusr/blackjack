package org.courseproject.cards;

import java.io.Serializable;

public class Card implements Serializable {

    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public int getRankValue() {
        return rank.value;
    }

    @Override
    public String toString() {
        return String.format("[%s of %s] (%d)", rank, suit, this.getRankValue());
    }

}
