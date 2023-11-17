package org.courseproject;

import org.courseproject.core.MainMenuController;
import org.courseproject.utils.SettingsIO;


public class Blackjack {
    public static void main(String[] args) {
        System.out.println("Welcome to Blackjack!");
        SettingsIO.loadSettings();
        MainMenuController mainMenuController = new MainMenuController();
        mainMenuController.handleUserInput();
    }
}
