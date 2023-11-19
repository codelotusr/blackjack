package org.courseproject;

import org.courseproject.core.*;
import org.courseproject.utils.SettingsIO;

public class Blackjack {
    public static void main(String[] args) {
        System.out.println("Welcome to Blackjack!");

        Settings settings = SettingsIO.loadSettings();
        MainMenuController mainMenuController = null;
        StateManager stateManager = new StateManager(settings, MainMenu.getInstance(), mainMenuController);

        mainMenuController = new MainMenuController(stateManager);
        SettingsController settingsController = new SettingsController(stateManager);

        while (stateManager.getCurrentState() != GameState.EXIT) {
            switch (stateManager.getCurrentState()) {
                case MAIN_MENU -> mainMenuController.handleUserInput();
                case SETTINGS -> settingsController.handleUserInput();
                case GAME -> {
                    Game game = stateManager.getGame();

                    if (game == null) {
                        game = Game.getInstance();
                        stateManager.setGame(game);
                    }

                    game.startGame();

                    while (game.isPlayerTurn()) {
                        game.handlePlayerTurn();
                    }

                    game.handleDealerTurn();

                    game.determineWinner();

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


