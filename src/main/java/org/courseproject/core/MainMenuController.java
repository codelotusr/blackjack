package org.courseproject.core;

import java.util.Scanner;

public class MainMenuController {

    private final MainMenu mainMenu;
    private final Scanner scanner;

    public MainMenuController() {
        this.mainMenu = new MainMenu();
        this.scanner = new Scanner(System.in);
    }

    private void display() {
        System.out.println(mainMenu);
    }

    public void handleUserInput() {
        display();
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> System.out.println("Starting the game...");
            case 2 -> System.out.println("Checking bank balance...");
            case 3 -> System.out.println("Cashing out...");
            case 4 -> System.out.println("Opening settings...");
            case 5 -> {
                System.out.println("Thank you for playing!");
                System.exit(1);
            }
            default -> {
                System.out.println("Invalid choice. Please select a valid option.");
                handleUserInput();
            }
        }
    }
}
