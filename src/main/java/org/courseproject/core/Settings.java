package org.courseproject.core;

import java.io.Serializable;

public class Settings implements Serializable {

    private static Settings instance = null;
    private int numberOfPlayers;
    private int numberOfDecks;

    public Settings() {
        this.numberOfPlayers = 1;
        this.numberOfDecks = 2;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public int getNumberOfDecks() {
        return numberOfDecks;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public void setNumberOfDecks(int numberOfDecks) {
        this.numberOfDecks = numberOfDecks;
    }

    public static Settings getInstance() {
        if (instance == null) {
            instance = new Settings();
        }
        return instance;
    }

    @Override
    public String toString() {
        return String.format("""
                1) Player amount: %d
                2) Number of Decks: %d
                3) Back to main menu
                """, numberOfPlayers, numberOfDecks);
    }
}
