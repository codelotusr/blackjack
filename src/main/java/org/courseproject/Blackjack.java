package org.courseproject;

public class Blackjack {
    public static void main(String[] args) {
        System.out.println("Welcome to Blackjack!");
        Game blackjack = new Game();
        Card card = new Card(Suit.SPADE, Rank.ACE);
        System.out.println(card);
    }
}
