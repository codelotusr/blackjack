package org.courseproject;

public enum Suit {
    SPADE("Spades"),
    CLUB("Clubs"),
    HEART("Hearts"),
    DIAMOND("Diamonds");

    final String name;

    Suit(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
