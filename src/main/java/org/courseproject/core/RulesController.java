package org.courseproject.core;

import java.util.Scanner;

public class RulesController {
    private final StateManager stateManager;
    private final Rules rules;

    public RulesController(StateManager stateManager) {
        this.stateManager = stateManager;
        this.rules = new Rules();
    }

    public void handleUserInput() {
Scanner scanner = new Scanner(System.in);
        while (stateManager.getCurrentState() == GameState.RULES) {
            System.out.println("Rules");
            System.out.println(rules);
            System.out.println("1. Back to main menu");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                stateManager.setCurrentState(GameState.MAIN_MENU);
            } else {
                System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
