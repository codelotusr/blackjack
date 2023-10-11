package org.courseproject;

import java.io.Serializable;

public class Card implements Serializable {
    private Suit suit;

    public Card(Suit suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    private int value;
}
