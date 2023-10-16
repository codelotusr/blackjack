package org.courseproject.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RulesTest {

    @Test
    void itShouldPrintTheCorrectRulesAlways() {
        Rules underTest = new Rules();
        String expectedRules = """
                Each player starts with two cards, one of the dealer's cards is hidden until the end.
                To 'Hit' is to ask for another card. To 'Stand' is to hold your total and end your turn.
                If you go over 21 you bust, and the dealer wins regardless of the dealer's hand. 
                """;
        assertEquals(expectedRules, underTest.toString());
    }
}