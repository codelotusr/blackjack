package org.courseproject.entities;

public abstract class Person {
    private final String name;
    private int money;

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

    @Override
    public String toString() {
        return String.format("[%s]: %d€", name, money);
    }
}
