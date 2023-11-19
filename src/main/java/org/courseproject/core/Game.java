package org.courseproject.core;

import org.courseproject.cards.Deck;
import org.courseproject.entities.Dealer;
import org.courseproject.entities.Player;

import java.util.Scanner;

public class Game {
    private static Game instance = null;
    private final int valueLimit = 21;
    private final Deck deck;
    private final Dealer dealer;
    private final StateManager stateManager;
    private final Player player;
    private boolean isPlayerTurn;
    private final Scanner scanner;


    private Game() {
        this.deck = new Deck();
        this.dealer = new Dealer("Benjamin", 1000000);
        this.player = new Player("Player", 1000);
        this.isPlayerTurn = true;
        this.scanner = new Scanner(System.in);
        this.stateManager = StateManager.getInstance();
        initializePlayers();
        this.stateManager.setGame(this);
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    private void initializePlayers() {
        System.out.println("Enter player name:");
        String name = scanner.nextLine();
        this.player.setName(name);
    }

    public void startGame() {
        if (player.getMoney() <= 0) {
            System.out.println("You have no money left. Returning to main menu.");
            player.setMoney(1000);
            stateManager.setCurrentState(GameState.MAIN_MENU);
            stateManager.getMainMenuController().handleUserInput();
        }
        placeBets();
        deck.makeDeck(stateManager.getSettings().getNumberOfDecks());
        deck.shuffleDeck();
        dealInitialCards();
        displayTable();
    }

    private void placeBets() {
        System.out.println("You have " + player.getMoney() + "€ left");
        System.out.println("Enter your bet:");
        int bet = scanner.nextInt();
        scanner.nextLine();
        player.placeBet(bet);
        System.out.println("You bet " + bet + "€");
        System.out.println("You have " + player.getMoney() + "€ left");
    }

    private void dealInitialCards() {
        player.addCard(deck.dealCard());
        player.addCard(deck.dealCard());
        if (player.getHandValue() > valueLimit) {
            System.out.println(player.getName() + " busted!");
            handlePlayerLoss();
        }
        dealer.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
        if (dealer.getHandValue() > valueLimit) {
            System.out.println(dealer.getName() + " busted!");
            handlePlayerWin();
        }
        if (dealer.getHandValue() == valueLimit && player.getHandValue() == valueLimit) {
            System.out.println("Both you and the dealer got Blackjack!");
            handleTie();
        }
        if (dealer.getHandValue() == valueLimit) {
            System.out.println(dealer.getName() + " got Blackjack!");
            handlePlayerLoss();
        }
        if (player.getHandValue() == valueLimit) {
            System.out.println(player.getName() + " got Blackjack!");
            handlePlayerWin();
        }
    }

    public void displayTable() {
        System.out.println("Dealer:");
        System.out.println(dealer.getHand() + " Total value: " + dealer.getHandValue());
        System.out.println("Players:");
        System.out.println(player.getName() + " " + player.getHand() + " Total value: " + player.getHandValue());
    }

    public boolean isPlayerTurn() {
        return isPlayerTurn;
    }

    public void handlePlayerTurn() {
        System.out.println("Enter your choice:");
        System.out.println("1) Hit");
        System.out.println("2) Stand");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1 -> {
                System.out.println(player.getName() + " hits");
                player.addCard(deck.dealCard());
                displayTable();
                if (player.getHandValue() > valueLimit) {
                    System.out.println(player.getName() + " busted!");
                    handlePlayerLoss();
                }
            }
            case 2 -> {
                System.out.println(player.getName() + " stands");
                isPlayerTurn = false;
            }
            default -> System.out.println("Invalid choice. Please select a valid option.");
        }
    }

    public void handleDealerTurn() {
        if (!isPlayerTurn) {
            displayTable();
        }
        int dealerLimit = 17;
        while (dealer.getHandValue() < dealerLimit) {
            dealer.addCard(deck.dealCard());
            System.out.println(dealer.getName() + " hits");
            displayTable();
            if (dealer.getHandValue() > valueLimit) {
                System.out.println(dealer.getName() + " busted!");
                handlePlayerWin();
            }
        }
    }

    public void handlePlayerLoss() {
        System.out.println("You lost " + player.getBet() + "€");
        System.out.println("You have " + player.getMoney() + "€ left");
        handlePlayAgain();
    }

    public void handlePlayerWin() {
        player.setMoney(player.getMoney() + player.getBet() * 2);
        System.out.println("You won " + player.getBet() + "€");
        System.out.println("You have " + player.getMoney() + "€ left");
        handlePlayAgain();
    }

    public void handleTie() {
        player.setMoney(player.getMoney() + player.getBet());
        System.out.println("You got your bet back");
        System.out.println("You have " + player.getMoney() + "€ left");
        handlePlayAgain();
    }

    public void handlePlayAgain() {
        System.out.println("Play again? (y/n)");
        while (true) {
            String choice = scanner.nextLine().trim();
            if (choice.equalsIgnoreCase("y")) {
                startGame();
                break;
            } else if (choice.equalsIgnoreCase("n")) {
                stateManager.setCurrentState(GameState.MAIN_MENU);
                stateManager.getMainMenuController().handleUserInput();
            } else {
                System.out.println("Invalid input. Please enter 'y' to continue or 'n' to exit.");
            }
        }
    }

    public void determineWinner() {
        if (player.getHandValue() > valueLimit) {
            handlePlayerLoss();
        } else if (dealer.getHandValue() > valueLimit) {
            handlePlayerWin();
        } else if (player.getHandValue() > dealer.getHandValue()) {
            handlePlayerWin();
        } else if (player.getHandValue() < dealer.getHandValue()) {
            handlePlayerLoss();
        } else {
            handleTie();
        }
    }
}
