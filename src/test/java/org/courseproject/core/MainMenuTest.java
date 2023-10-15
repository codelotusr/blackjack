package org.courseproject.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainMenuTest {

    @Test
    void displayCorrectMainMenu() {
        MainMenu underTest = new MainMenu();
        String expectedMainMenu = """
                1) Play
                2) Check Bank
                3) Cash Out
                4) Deck Amount
                """;

        assertEquals(expectedMainMenu, underTest.toString());
    }
}