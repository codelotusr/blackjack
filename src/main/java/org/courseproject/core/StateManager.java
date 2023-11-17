package org.courseproject.core;

public class StateManager {
    private final Settings settings;
    private final MainMenu mainMenu;
    private GameState currentState;

    public StateManager(Settings settings, MainMenu mainMenu) {
        this.settings = settings;
        this.mainMenu = mainMenu;
        this.currentState = GameState.MAIN_MENU;
    }

    public Settings getSettings() {
        return settings;
    }

    public MainMenu getMainMenu() {
        return mainMenu;
    }

    public GameState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(GameState newState) {
        this.currentState = newState;
    }

}
