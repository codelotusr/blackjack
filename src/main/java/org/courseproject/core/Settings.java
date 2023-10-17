package org.courseproject.core;

public class Settings {
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

    @Override
    public String toString() {
        return String.format("""
                1) Player amount: %d
                2) Number of Decks: %d
                3) Back to main menu
                """, numberOfPlayers, numberOfDecks);
    }
}
