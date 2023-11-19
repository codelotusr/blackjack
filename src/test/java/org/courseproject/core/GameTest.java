package org.courseproject.core;

import org.courseproject.cards.Card;
import org.courseproject.cards.Rank;
import org.courseproject.cards.Suit;
import org.courseproject.core.Game;
import org.courseproject.entities.Dealer;
import org.courseproject.entities.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game;

    @BeforeEach
    void setUp() {
        game = Game.getInstance();
    }

    @Test
    void testPlayerWin() {
        Player player = new Player("Player", 1000);
        Dealer dealer = new Dealer("Dealer", 1000000);

        player.placeBet(100);
        player.addCard(new Card(Suit.SPADE, Rank.ACE));
        player.addCard(new Card(Suit.CLUB, Rank.TEN));
        dealer.addCard(new Card(Suit.HEART, Rank.FIVE));
        dealer.addCard(new Card(Suit.DIAMOND, Rank.SEVEN));

        game.determineWinner();

        assertEquals(1100, player.getMoney());
        assertEquals(900, dealer.getMoney());
    }

    @Test
    void testPlayerLoss() {
        Player player = new Player("Player", 1000);
        Dealer dealer = new Dealer("Dealer", 1000000);

        // Set up a scenario where the player loses
        player.placeBet(100);
        player.addCard(new Card(Suit.SPADE, Rank.KING));
        player.addCard(new Card(Suit.CLUB, Rank.TEN));
        dealer.addCard(new Card(Suit.HEART, Rank.FIVE));
        dealer.addCard(new Card(Suit.DIAMOND, Rank.SIX));

        game.determineWinner();

        assertEquals(900, player.getMoney());
        assertEquals(1100, dealer.getMoney());
    }

    @Test
    void testPlayerTie() {
        Player player = new Player("Player", 1000);
        Dealer dealer = new Dealer("Dealer", 1000000);

        // Set up a scenario where the player ties with the dealer
        player.placeBet(100);
        player.addCard(new Card(Suit.SPADE, Rank.KING));
        player.addCard(new Card(Suit.CLUB, Rank.SEVEN));
        dealer.addCard(new Card(Suit.HEART, Rank.FIVE));
        dealer.addCard(new Card(Suit.DIAMOND, Rank.SIX));

        game.determineWinner();

        assertEquals(1000, player.getMoney());
        assertEquals(1000, dealer.getMoney());
    }

    @Test
    void testPlayerBust() {
        Player player = new Player("Player", 1000);

        // Set up a scenario where the player busts
        player.placeBet(100);
        player.addCard(new Card(Suit.SPADE, Rank.KING));
        player.addCard(new Card(Suit.CLUB, Rank.SEVEN));
        player.addCard(new Card(Suit.HEART, Rank.FIVE));

        game.determineWinner();

        assertEquals(900, player.getMoney());
    }

    @Test
    void testDealerBust() {
        Player player = new Player("Player", 1000);
        Dealer dealer = new Dealer("Dealer", 1000000);

        // Set up a scenario where the dealer busts
        player.placeBet(100);
        player.addCard(new Card(Suit.SPADE, Rank.KING));
        player.addCard(new Card(Suit.CLUB, Rank.SEVEN));
        dealer.addCard(new Card(Suit.HEART, Rank.FIVE));
        dealer.addCard(new Card(Suit.DIAMOND, Rank.SIX));
        dealer.addCard(new Card(Suit.HEART, Rank.TEN));

        game.determineWinner();

        assertEquals(1100, player.getMoney());
    }

    @Test
    void testPlayerBlackjack() {
        Player player = new Player("Player", 1000);
        Dealer dealer = new Dealer("Dealer", 1000000);

        // Set up a scenario where the player gets a blackjack
        player.placeBet(100);
        player.addCard(new Card(Suit.SPADE, Rank.ACE));
        player.addCard(new Card(Suit.CLUB, Rank.TEN));
        dealer.addCard(new Card(Suit.HEART, Rank.FIVE));
        dealer.addCard(new Card(Suit.DIAMOND, Rank.KING));

        game.determineWinner();

        assertEquals(1100, player.getMoney());
    }

    @Test
    void testDealerBlackjack() {
        Player player = new Player("Player", 1000);
        Dealer dealer = new Dealer("Dealer", 1000000);

        // Set up a scenario where the dealer gets a blackjack
        player.placeBet(100);
        player.addCard(new Card(Suit.SPADE, Rank.NINE));
        dealer.addCard(new Card(Suit.HEART, Rank.ACE));
        dealer.addCard(new Card(Suit.DIAMOND, Rank.TEN));

        game.determineWinner();

        assertEquals(900, player.getMoney());
    }

    @Test
    void testPlayerTurn() {
        Player player = new Player("Player", 1000);

        // Set up a scenario where the player chooses to hit
        player.placeBet(100);
        player.addCard(new Card(Suit.SPADE, Rank.KING));
        player.addCard(new Card(Suit.CLUB, Rank.SEVEN));

        game.handlePlayerTurn();

        // Assert player's state after hitting
        assertEquals(3, player.getHand().size());
        // You can add more assertions based on your game logic
    }

    @Test
    void testDealerTurn() {
        Dealer dealer = new Dealer("Dealer", 1000000);

        // Set up a scenario where the dealer hits until reaching a certain value
        dealer.addCard(new Card(Suit.SPADE, Rank.KING));
        dealer.addCard(new Card(Suit.CLUB, Rank.SEVEN));

        game.handleDealerTurn();

        // Assert dealer's state after hitting
        assertTrue(dealer.getHandValue() >= 17);
        // You can add more assertions based on your game logic
    }
}