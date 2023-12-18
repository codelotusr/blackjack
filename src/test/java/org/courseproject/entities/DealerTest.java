package org.courseproject.entities;

import org.courseproject.cards.Card;
import org.courseproject.cards.Rank;
import org.courseproject.cards.Suit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DealerTest {
    private Dealer underTest;
    @BeforeEach
    void setUp() {
        underTest = new Dealer("Dealer", 1000);
    }

    @Test
    void itShouldReturnCorrectNameWhenNameIsDealer() {
        assertEquals("Dealer", underTest.getName());
    }

    @Test
    void itShouldReturnCorrectMoneyWhenMoneyIs1000() {
        assertEquals(1000, underTest.getMoney());
    }

    @Test
    void itShouldReturnCorrectMoneyWhenMoneyIs2000() {
        underTest.setMoney(2000);
        assertEquals(2000, underTest.getMoney());
    }

    @Test
    void itShouldReturnCorrectNameWhenNameIsDealer2() {
        underTest.setName("Dealer2");
        assertEquals("Dealer2", underTest.getName());
    }

    @Test
    void itShouldReturnCorrectHandValueWhenHandIsAceOfSpadesAndKingOfHearts() {
        underTest.addCard(new Card(Suit.SPADE, Rank.ACE));
        underTest.addCard(new Card(Suit.HEART, Rank.KING));
        assertEquals(21, underTest.getHandValue());
    }

    @Test
    void itShouldReturnCorrectHandValueWhenHandIsAceOfSpadesAndKingOfHeartsAndQueenOfHearts() {
        underTest.addCard(new Card(Suit.SPADE, Rank.ACE));
        underTest.addCard(new Card(Suit.HEART, Rank.KING));
        underTest.addCard(new Card(Suit.HEART, Rank.QUEEN));
        assertEquals(21, underTest.getHandValue());
    }
}