package org.courseproject.cards;

import org.courseproject.core.Settings;

import java.security.SecureRandom;
import java.util.*;

public class Deck {
    private ArrayList<Card> gameDeck;

    public Deck() {
        this.gameDeck = new ArrayList<>();
    }

    public Card peek(){
        return gameDeck.get(0);
    }

    public int getSize() {
        return gameDeck.size();
    }

    public void addCard(Card card) {
        gameDeck.add(card);
    }

    public void makeDeck(int deckAmount) {
        for (int i = 0; i < deckAmount; ++i) {
            for (Suit suit : Suit.values()) {
                for (Rank rank : Rank.values()) {
                    gameDeck.add(new Card(suit, rank));
                }
            }
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(gameDeck, new SecureRandom());
    }

    public Card dealCard() {
        checkCurrentDeckSize();
        return gameDeck.remove(0);
    }

    public void checkCurrentDeckSize() {
        if (gameDeck.isEmpty()) {
            gameDeck = new ArrayList<>();
            makeDeck(Settings.getInstance().getNumberOfDecks());
            shuffleDeck();
        }
    }

    public boolean isEmpty() {
        return gameDeck.isEmpty();
    }
}
