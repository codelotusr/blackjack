package org.courseproject.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SettingsTest {

    private Settings underTest;

    @BeforeEach
    void setUp() {
        underTest = new Settings();
    }

    @Test
    void itShouldSetTheNumberOfPlayersTo5() {
        underTest.setNumberOfPlayers(5);
        assertEquals(5, underTest.getNumberOfPlayers());
    }
    @Test
    void itShouldSetTheNumberOfDecksTo3() {
        underTest.setNumberOfDecks(3);
        assertEquals(3, underTest.getNumberOfDecks());
    }

    @Test
    void itShouldTurnTheSettingsToString() {
        String expectedSettingsString = String.format("""
                Player amount: %d
                Number of Decks: %d
                """, underTest.getNumberOfPlayers(), underTest.getNumberOfDecks());
        assertEquals(expectedSettingsString, underTest.toString());
    }
}