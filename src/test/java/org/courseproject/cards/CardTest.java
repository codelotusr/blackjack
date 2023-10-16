package org.courseproject.cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    private Card underTest;

    @Test
    void itShouldReturnCorrectCardNameAndValueWhenCardIsAceOfSpades() {
        underTest = new Card(Suit.SPADE, Rank.ACE);
        assertEquals("[Ace of Spades] (11)", underTest.toString());
    }

    @Test
    void itShouldReturnCorrectCardNameWhenCardIsKingOfHearts() {
        underTest = new Card(Suit.HEART, Rank.KING);
        assertEquals("King", underTest.getRank().name);
    }

    @Test
    void itShouldReturnCorrectCardNameWhenCardIsAce() {
        underTest = new Card(Suit.HEART, Rank.ACE);
        assertEquals("Ace", underTest.getRank().name);
    }

    @Test
    void itShouldReturnCorrectCardValueWhenCardIsKingOfHearts() {
        underTest = new Card(Suit.HEART, Rank.KING);
        assertEquals(10, underTest.getRank().value);
    }

    @Test
    void itShouldReturnCorrectCardValueWhenCardIsAce() {
        underTest = new Card(Suit.HEART, Rank.ACE);
        assertEquals(11, underTest.getRank().value);
    }

    @Test
    void itShouldReturnCorrectCardSuitWhenCardIsKingOfHearts() {
        underTest = new Card(Suit.HEART, Rank.KING);
        assertEquals("Hearts", underTest.getSuit().name);
    }

    @Test
    void itShouldReturnCorrectCardSuitWhenCardIsAceOfSpades() {
        underTest = new Card(Suit.SPADE, Rank.ACE);
        assertEquals("Spades", underTest.getSuit().name);
    }

    @Test
    void itShouldReturnCorrectCardRankWhenCardIsKingOfHearts() {
        underTest = new Card(Suit.HEART, Rank.KING);
        assertEquals("King", underTest.getRank().name);
    }
}