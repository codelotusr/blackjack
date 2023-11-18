package org.courseproject.core;

import org.courseproject.cards.Deck;
import org.courseproject.entities.Dealer;
import org.courseproject.entities.Player;

import java.util.ArrayList;
import java.util.Scanner; // Import Scanner for input

public class Game {

    private static Game instance = null;
    private final Deck deck;
    private final Dealer dealer;
    private ArrayList<Player> players;
    private boolean isPlayerTurn;
    private Scanner scanner;
    private final StateManager stateManager = StateManager.getInstance();

    public Game() {
        this.deck = new Deck();
        this.dealer = new Dealer("Benjamin", 1000000);
        this.players = new ArrayList<>();
        this.isPlayerTurn = true;
        this.scanner = new Scanner(System.in);
        initializePlayers();
    }

    private void initializePlayers() {
        int numberOfPlayers = stateManager.getSettings().getNumberOfPlayers();
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player("Player " + (i + 1), 1000)); // Example player creation with initial balance
        }
    }

    public void startGame() {
        placeBets();
    }

    private void placeBets() {
        for (Player player : players) {
            System.out.println(player.getName() + ", enter your bet:");
            int bet = scanner.nextInt();
            player.placeBet(bet);
        }
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

}

