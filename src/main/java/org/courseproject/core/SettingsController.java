package org.courseproject.core;

import java.util.Scanner;

public class SettingsController {

    private final Settings settings;
    private final Scanner scanner;

    public SettingsController() {
        this.settings = new Settings();
        this.scanner = new Scanner(System.in);
    }

    private void display() {
        System.out.println(settings);
        System.out.println("Which setting do you want to modify?");
    }

    public void handleUserInput() {
        display();
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> {
                System.out.println("Change player amount");
                int playerAmount = scanner.nextInt();
                settings.setNumberOfPlayers(playerAmount);
            }
            case 2 -> {
                System.out.println("Change deck amount");
                int deckAmount = scanner.nextInt();
                settings.setNumberOfDecks(deckAmount);
            }
            case 3 -> System.out.println("Returning to main menu...");
        }
    }
}
