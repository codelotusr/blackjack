package org.courseproject.cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    private Card underTest;

    @Test
    void shouldReturnCorrectCardNameAndValueWhenCardIsAceOfSpades() {
        underTest = new Card(Suit.SPADE, Rank.ACE);
        assertEquals("[Ace of Spades] (11)", underTest.toString());
    }

    @Test
    void shouldReturnCorrectCardNameWhenCardIsKingOfHearts() {
        underTest = new Card(Suit.HEART, Rank.KING);
        assertEquals("King", underTest.getRank().name);
    }

    @Test
    void shouldReturnCorrectCardNameWhenCardIsAce() {
        underTest = new Card(Suit.HEART, Rank.ACE);
        assertEquals("Ace", underTest.getRank().name);
    }

    @Test
    void shouldReturnCorrectCardValueWhenCardIsKingOfHearts() {
        underTest = new Card(Suit.HEART, Rank.KING);
        assertEquals(10, underTest.getRank().value);
    }

    @Test
    void shouldReturnCorrectCardValueWhenCardIsAce() {
        underTest = new Card(Suit.HEART, Rank.ACE);
        assertEquals(11, underTest.getRank().value);
    }

    @Test
    void shouldReturnCorrectCardSuitWhenCardIsKingOfHearts() {
        underTest = new Card(Suit.HEART, Rank.KING);
        assertEquals("Hearts", underTest.getSuit().name);
    }

    @Test
    void shouldReturnCorrectCardSuitWhenCardIsAceOfSpades() {
        underTest = new Card(Suit.SPADE, Rank.ACE);
        assertEquals("Spades", underTest.getSuit().name);
    }

    @Test
    void shouldReturnCorrectCardRankWhenCardIsKingOfHearts() {
        underTest = new Card(Suit.HEART, Rank.KING);
        assertEquals("King", underTest.getRank().name);
    }
}