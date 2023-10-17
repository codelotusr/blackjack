package org.courseproject;

import org.courseproject.cards.UnicodeIcon;
import org.courseproject.core.Game;
import org.courseproject.core.MainMenu;
import org.courseproject.core.MainMenuController;


public class Blackjack {
    public static void main(String[] args) {
        System.out.println("Welcome to Blackjack!");
        MainMenuController mainMenuController = new MainMenuController();
        mainMenuController.handleUserInput();
    }
}
