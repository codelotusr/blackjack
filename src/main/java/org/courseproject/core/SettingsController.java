package org.courseproject.core;

import org.courseproject.utils.SettingsIO;

import java.util.Scanner;

public class SettingsController {
    private final StateManager stateManager;
    private final Scanner scanner;

    public SettingsController(StateManager stateManager) {
        this.stateManager = stateManager;
        this.scanner = new Scanner(System.in);
    }

    public void handleUserInput() {
        while (stateManager.getCurrentState() == GameState.SETTINGS) {
            displaySettings();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter number of players:");
                    int numPlayers = scanner.nextInt();
                    stateManager.getSettings().setNumberOfPlayers(numPlayers);
                    System.out.println("Enter number of decks:");
                    int numDecks = scanner.nextInt();
                    stateManager.getSettings().setNumberOfDecks(numDecks);
                }
                case 2 -> {
                    System.out.println("Current Settings:");
                    System.out.println(stateManager.getSettings());
                }
                case 3 -> {
                    SettingsIO.saveSettings(stateManager.getSettings());
                    stateManager.setCurrentState(GameState.MAIN_MENU);
                }
                default -> System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private void displaySettings() {
        System.out.println("Settings:");
        System.out.println("1. Change settings");
        System.out.println("2. Show current settings");
        System.out.println("3. Back to main menu");
    }
}
