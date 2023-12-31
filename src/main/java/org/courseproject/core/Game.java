package org.courseproject.core;

import org.courseproject.cards.Deck;
import org.courseproject.entities.Dealer;
import org.courseproject.entities.Person;
import org.courseproject.entities.Player;
import org.courseproject.interfaces.HandleTurn;

import java.util.Scanner;

public class Game {
    private static Game instance = null;
    private static final int VALUE_LIMIT = 21;
    private static final String EURO = "€";
    private final Deck deck;
    private final Dealer dealer;
    private final StateManager stateManager;
    private final Player player;
    private boolean isPlayerTurn;
    private Scanner scanner;
    HandleTurn playerTurn = new PlayerTurn();
    HandleTurn dealerTurn = new DealerTurn();


    private Game() {
        this.deck = new Deck();
        this.dealer = new Dealer("Benjamin", 1000000);
        this.player = new Player("Player", 1000);
        this.isPlayerTurn = true;
        this.scanner = new Scanner(System.in);
        this.stateManager = StateManager.getInstance();
        this.stateManager.setGame(this);
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public void startGame() {
        if (player.getMoney() <= 0) {
            System.out.println("You have no money left. Returning to main menu.");
            player.setMoney(1000);
            stateManager.setCurrentState(GameState.MAIN_MENU);
            stateManager.getMainMenuController().handleUserInput();
        }
        placeBets();
        if (deck.isEmpty()) {
            deck.makeDeck(stateManager.getSettings().getNumberOfDecks());
            deck.shuffleDeck();
        }
        dealInitialCards();
        displayTable();
        while (isPlayerTurn) {
            playerTurn.executeTurn(this);
        }
        dealerTurn.executeTurn(this);
        determineWinner();
    }

    void placeBets() {
        printMoneyLeft();
        System.out.println("Enter your bet:");
        int bet = scanner.nextInt();
        scanner.nextLine();
        player.placeBet(bet);
        System.out.println("You bet " + bet + EURO);
        printMoneyLeft();
    }

    void dealInitialCards() {
        player.addCard(deck.dealCard());
        player.addCard(deck.dealCard());
        if (player.getHandValue() > VALUE_LIMIT) {
            printBusted(player);
            handlePlayerLoss();
        }
        dealer.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
        if (dealer.getHandValue() > VALUE_LIMIT) {
            printBusted(dealer);
            handlePlayerWin();
        }
        if (dealer.getHandValue() == VALUE_LIMIT && player.getHandValue() == VALUE_LIMIT) {
            System.out.println("Both you and the dealer got Blackjack!");
            handleTie();
        }
        if (dealer.getHandValue() == VALUE_LIMIT) {
            printBlackjack(dealer);
            handlePlayerLoss();
        }
        if (player.getHandValue() == VALUE_LIMIT) {
            printBlackjack(player);
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

    public void handlePlayerLoss() {
        displayTable();
        System.out.println("You lost " + player.getBet() + EURO);
        printMoneyLeft();
        handlePlayAgain();
    }

    public void handlePlayerWin() {
        displayTable();
        player.setMoney(player.getMoney() + player.getBet() * 2);
        System.out.println("You won " + player.getBet() + EURO);
        printMoneyLeft();
        handlePlayAgain();
    }

    public void handleTie() {
        displayTable();
        player.setMoney(player.getMoney() + player.getBet());
        System.out.println("You got your bet back");
        printMoneyLeft();
        handlePlayAgain();
    }

    public void handlePlayAgain() {
        player.getHand().clear();
        dealer.getHand().clear();
        isPlayerTurn = true;
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
        if (player.getHandValue() > VALUE_LIMIT) {
            handlePlayerLoss();
        } else if (dealer.getHandValue() > VALUE_LIMIT) {
            handlePlayerWin();
        } else if (player.getHandValue() > dealer.getHandValue()) {
            handlePlayerWin();
        } else if (player.getHandValue() < dealer.getHandValue()) {
            handlePlayerLoss();
        } else {
            handleTie();
        }
    }

    public void printMoneyLeft() {
        System.out.println("You have " + player.getMoney() + EURO + " left");
    }

    public void printBusted(Person person) {
        System.out.println(person.getName() + " busted!");
    }

    public void printBlackjack(Person person) {
        System.out.println(person.getName() + " got Blackjack!");
    }

    public void printHit(Person person) {
        System.out.println(person.getName() + " hits");
    }

    public Deck getDeck() {
        return deck;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public Player getPlayer() {
        return player;
    }

    public StateManager getStateManager() {
        return stateManager;
    }

    public void setScanner(Scanner mockScanner) {
        this.scanner = mockScanner;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public int getValueLimit() {
        return VALUE_LIMIT;
    }

    public void setPlayerTurn(boolean b) {
        this.isPlayerTurn = b;
    }
}
