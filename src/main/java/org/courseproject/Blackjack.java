package org.courseproject;

import org.courseproject.core.*;
import org.courseproject.utils.SettingsIO;

public class Blackjack {
    public static void main(String[] args) {
        System.out.println("Welcome to Blackjack!");

        Settings settings = SettingsIO.loadSettings();
        StateManager stateManager = new StateManager(settings, MainMenu.getInstance());

        MainMenuController mainMenuController = new MainMenuController(stateManager);
        SettingsController settingsController = new SettingsController(stateManager);

        while (stateManager.getCurrentState() != GameState.EXIT) {
            switch (stateManager.getCurrentState()) {
                case MAIN_MENU -> mainMenuController.handleUserInput();
                case BANK -> {
                }
                case CASH_OUT -> {
                    // implement the logic for the CASH_OUT state
                }
                case SETTINGS -> settingsController.handleUserInput();
                case GAME -> {
                    Game game = stateManager.getGame();
                    game.startGame();
                    stateManager.setCurrentState(GameState.MAIN_MENU);
                }
                case RULES -> {
                    // implement the logic for the RULES state
                }
                case EXIT -> {
                    // implement the logic for the EXIT state
                }
            }
        }

        System.out.println("Thank you for playing Blackjack!");
    }
}


