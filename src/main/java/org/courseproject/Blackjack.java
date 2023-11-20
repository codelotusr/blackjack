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
        RulesController rulesController = new RulesController(stateManager);

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

                    if (!game.isPlayerTurn()){
                        game.handleDealerTurn();
                    }

                    game.determineWinner();

                }
                case RULES -> rulesController.handleUserInput();
                case EXIT -> {
                    System.out.println("Exiting...");
                    SettingsIO.saveSettings(settings);
                    System.exit(0);
                }
                default -> System.out.println("Invalid state");
            }
        }

        System.out.println("Thank you for playing Blackjack!");
    }
}


