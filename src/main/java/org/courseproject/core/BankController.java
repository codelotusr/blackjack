package org.courseproject.core;

import java.util.Scanner;

public class BankController {
    private final StateManager stateManager;
    private final Scanner scanner;

    public BankController(StateManager stateManager) {
        this.stateManager = stateManager;
        this.scanner = new Scanner(System.in);
    }

    public void handleUserInput() {
        // Implement the logic for the BANK state
        // Example: Display balance, deposit, withdraw options
        // After completing actions, you can set the state back to MAIN_MENU
    }
}

