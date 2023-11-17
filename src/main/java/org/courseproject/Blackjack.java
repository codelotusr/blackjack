package org.courseproject;

import org.courseproject.core.MainMenu;
import org.courseproject.core.MainMenuController;
import org.courseproject.core.Settings;
import org.courseproject.core.StateManager;
import org.courseproject.utils.SettingsIO;


public class Blackjack {
    public static void main(String[] args) {
        System.out.println("Welcome to Blackjack!");
        Settings settings = SettingsIO.loadSettings();
        MainMenu mainMenu = new MainMenu();
        StateManager stateManager = new StateManager(settings, mainMenu);
        MainMenuController mainMenuController = new MainMenuController(stateManager);
        mainMenuController.handleUserInput();
    }
}
