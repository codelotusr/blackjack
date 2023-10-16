package org.courseproject.entities;

public abstract class Person {
    private final String name;
    private final int age;
    private int money;

    protected Person(String name, int age, int money) {
        this.name = name;
        this.age = age;
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return String.format("[%s]: %d€", name, money);
    }
}
