package org.courseproject.core;

import org.courseproject.cards.Deck;
import org.courseproject.entities.Dealer;
import org.courseproject.entities.Player;

import java.util.ArrayList;

public class Game {
    private final Deck deck;
    private final Dealer dealer;
    private ArrayList<Player> players;
    private boolean isPlayerTurn;
    private int playerBet;
    private final StateManager stateManager;

    public Game(int playerBet, StateManager stateManager) {
        this.playerBet = playerBet;
        this.stateManager = stateManager;
        this.deck = new Deck();
        this.dealer = new Dealer("Benjamin", 1000000);
        this.players = new ArrayList<Player>();
        this.isPlayerTurn = true;
    }



}


