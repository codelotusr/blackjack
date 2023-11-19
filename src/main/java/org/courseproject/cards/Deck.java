package org.courseproject.cards;

import org.courseproject.core.Settings;

import java.security.SecureRandom;
import java.util.*;

public class Deck {
    private ArrayList<Card> deck;

    public Deck() {
        this.deck = new ArrayList<>();
    }

    public Card peek(){
        return deck.get(0);
    }

    public int getSize() {
        return deck.size();
    }

    public void addCard(Card card) {
        deck.add(card);
    }

    public void makeDeck(int deckAmount) {
        for (int i = 0; i < deckAmount; ++i) {
            for (Suit suit : Suit.values()) {
                for (Rank rank : Rank.values()) {
                    deck.add(new Card(suit, rank));
                }
            }
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(deck, new SecureRandom());
    }

    public Card dealCard() {
        checkCurrentDeckSize();
        return deck.remove(0);
    }

    public void checkCurrentDeckSize() {
        if (deck.isEmpty()) {
            deck = new ArrayList<>();
            makeDeck(Settings.getInstance().getNumberOfDecks());
            shuffleDeck();
        }
    }

    public boolean isEmpty() {
        return deck.isEmpty();
    }
}
