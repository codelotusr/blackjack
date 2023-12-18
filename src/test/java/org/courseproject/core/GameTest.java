package org.courseproject.core;

import org.courseproject.cards.Deck;
import org.courseproject.entities.Dealer;
import org.courseproject.entities.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game underTest;
    private Settings settings;
    private Player player;
    private Dealer dealer;
    private Deck deck;

    @BeforeEach
    void setUp() {
        underTest = Game.getInstance();
        settings = new Settings();
        player = new Player("Player", 1000);
        dealer = new Dealer("Benjamin", 1000000);
    }

    @Test
    void itShouldReturnTheSameInstanceOfGameWhenCallingGetInstance() {
        Game game1 = Game.getInstance();
        Game game2 = Game.getInstance();
        assertEquals(game1, game2);
    }

    @Test
    public void itShouldCorrectlyDoInitialGameSetup() {
        Game game = Game.getInstance();

        game.getDeck().makeDeck(2);
        game.getDeck().shuffleDeck();

        assertFalse(game.getDeck().isEmpty(), "Deck should be initialized and not empty");
        assertNotNull(game.getDealer(), "Dealer should be initialized");
        assertNotNull(game.getPlayer(), "Player should be initialized");
        assertEquals(GameState.MAIN_MENU, game.getStateManager().getCurrentState(), "Initial game state should be MAIN_MENU");
    }

    @Test
    public void itShouldCorrectlyPlaceTheBets() {
        Game game = Game.getInstance();

        Scanner mockScanner = Mockito.mock(Scanner.class);
        Mockito.when(mockScanner.nextInt()).thenReturn(100);

        game.setScanner(mockScanner);

        game.placeBets();

        assertEquals(900, game.getPlayer().getMoney(), "Player should have 900 left after placing a 100 bet");
    }

    @Test
    public void itShouldCorrectlyDealInitialCards() {
        Game game = Game.getInstance();

        game.getDeck().makeDeck(2);
        game.getDeck().shuffleDeck();

        game.dealInitialCards();

        assertEquals(2, game.getPlayer().getHand().size(), "Player should have 2 cards in hand after initial deal");
        assertEquals(2, game.getDealer().getHand().size(), "Dealer should have 2 cards in hand after initial deal");
    }


}