package org.courseproject.entities;

import org.courseproject.cards.Card;
import org.courseproject.cards.Rank;

import java.util.ArrayList;

public abstract class Person {
    private String name;
    private int money;
    private final ArrayList<Card> hand = new ArrayList<Card>();

    protected Person(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getHandValue() {
        int value = 0;
        int aceCount = 0;

        for (Card card : hand) {
            value += card.getRankValue();
            if (card.getRank() == Rank.ACE) {
                aceCount++;
            }
        }

        while (value > 21 && aceCount > 0) {
            value -= 10;
            aceCount--;
        }

        return value;
    }

    @Override
    public String toString() {
        return String.format("[%s]: %d€", name, money);
    }

    public void setName(String name) {
        this.name = name;
    }
}
