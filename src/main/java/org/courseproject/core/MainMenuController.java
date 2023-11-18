package org.courseproject.core;

import java.util.Scanner;

public class MainMenuController {
    private final StateManager stateManager;
    private final Scanner scanner;

    public MainMenuController(StateManager stateManager) {
        this.stateManager = stateManager;
        this.scanner = new Scanner(System.in);
    }

    public void handleUserInput() {
        while (stateManager.getCurrentState() == GameState.MAIN_MENU) {
            System.out.println(stateManager.getMainMenu());
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> stateManager.setCurrentState(GameState.GAME);
                case 2 -> stateManager.setCurrentState(GameState.BANK);
                case 3 -> stateManager.setCurrentState(GameState.CASH_OUT);
                case 4 -> stateManager.setCurrentState(GameState.SETTINGS);
                case 5 -> stateManager.setCurrentState(GameState.RULES);
                case 6 -> {
                    System.out.println("Exiting...");
                    stateManager.setCurrentState(GameState.EXIT);
                }
                default -> System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}


