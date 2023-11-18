package org.courseproject;

import org.courseproject.core.*;
import org.courseproject.utils.SettingsIO;

public class Blackjack {
    public static void main(String[] args) {
        System.out.println("Welcome to Blackjack!");

        Settings settings = SettingsIO.loadSettings();

        StateManager stateManager = new StateManager(settings, new MainMenu(), new Game());
        MainMenuController mainMenuController = new MainMenuController(stateManager);
        SettingsController settingsController = new SettingsController(stateManager);

        while (true) {
            switch (stateManager.getCurrentState()) {
                case MAIN_MENU -> mainMenuController.handleUserInput();
                case SETTINGS -> settingsController.handleUserInput();
                case GAME -> {
                    Game game = stateManager.getGame();
                    game.startGame();
                    stateManager.setCurrentState(GameState.MAIN_MENU);
                }
            }
        }
    }
}
