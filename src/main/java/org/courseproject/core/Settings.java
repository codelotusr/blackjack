package org.courseproject.core;

public class Settings {
    private int numberOfPlayers;
    private int numberOfDecks;

    public Settings() {
        this.numberOfPlayers = 1;
        this.numberOfDecks = 2;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public void setNumberOfDecks(int numberOfDecks) {
        this.numberOfDecks = numberOfDecks;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public int getNumberOfDecks() {
        return numberOfDecks;
    }

    @Override
    public String toString() {
        return String.format("""
                Player amount: %d
                Number of Decks: %d
                """, numberOfPlayers, numberOfDecks);
    }
}
