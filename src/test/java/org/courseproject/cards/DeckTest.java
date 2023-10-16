package org.courseproject.cards;

import org.courseproject.core.Settings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    private Deck underTest;

    @BeforeEach
    void setUp() {
        underTest = new Deck();
    }

    @Test
    void itShouldAddTheSpecifiedCardToTheTopOfTheDeck() {
        Card card = new Card(Suit.SPADE, Rank.JACK);
        underTest.addCard(card);
        assertEquals(card, underTest.peek());
    }

    @Test
    void itShouldCreateADeckOf104CardsWhenTheSettingsAreDefault() {
        Settings settings = new Settings();
        underTest.makeDeck(settings.getNumberOfDecks());
        assertEquals(104, underTest.getSize());
    }

    @Test
    void itShouldCreateADeckOf208CardsWhenTheSettingsDeckAmountIsSetTo4() {
        Settings settings = new Settings();
        settings.setNumberOfDecks(4);
        underTest.makeDeck(settings.getNumberOfDecks());
        assertEquals(208, underTest.getSize());
    }


}