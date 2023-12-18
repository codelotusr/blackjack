package org.courseproject.entities;

public class Player extends Person {

    private int bet;
    public Player(String name, int money) {
        super(name, money);
    }

    public void placeBet(int betAmount) {
        this.bet = betAmount;
        this.setMoney(this.getMoney() - betAmount);
    }

    public int getBet() {
        return this.bet;
    }
    public void setBet(int newBet) {
        this.bet = newBet;
    }


}
