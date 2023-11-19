package org.courseproject.entities;

import org.courseproject.cards.Card;

import java.util.ArrayList;

public abstract class Person {
    private String name;
    private int money;
    private ArrayList<Card> hand = new ArrayList<Card>();

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

    public void addMoney(int money) {
        this.money += money;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void clearHand() {
        hand.clear();
    }

    public int getHandValue() {
        int value = 0;
        for (Card card : hand) {
            value += card.getRank().getValue();
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
