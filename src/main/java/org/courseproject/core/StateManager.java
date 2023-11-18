package org.courseproject.core;

import org.courseproject.utils.SettingsIO;

public class StateManager {
    private final Settings settings;
    private final MainMenu mainMenu;
    private final Game game;
    private GameState currentState;

    public StateManager(Settings settings, MainMenu mainMenu, Game game) {
        this.settings = settings;
        this.mainMenu = mainMenu;
        this.game = game;
        this.currentState = GameState.MAIN_MENU;
    }

    public static StateManager getInstance() {
        Settings settings = SettingsIO.loadSettings();
        MainMenu mainMenu = MainMenu.getInstance();
        Game game = Game.getInstance();
        return new StateManager(settings, mainMenu, game);
    }

    public Settings getSettings() {
        return settings;
    }

    public MainMenu getMainMenu() {
        return mainMenu;
    }

    public Game getGame() {
        return game;
    }

    public GameState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(GameState newState) {
        this.currentState = newState;
    }

}
