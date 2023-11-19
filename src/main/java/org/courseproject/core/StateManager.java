package org.courseproject.core;

import org.courseproject.utils.SettingsIO;

public class StateManager {
    private final Settings settings;
    private final MainMenu mainMenu;
    private Game game;

    private final MainMenuController mainMenuController;
    private final RulesController rulesController;
    private GameState currentState;

    public StateManager(Settings settings, MainMenu mainMenu, MainMenuController mainMenuController) {
        this.settings = settings;
        this.mainMenu = mainMenu;
        this.mainMenuController = mainMenuController;
        this.rulesController = new RulesController(this);
        this.currentState = GameState.MAIN_MENU;
    }

    public static StateManager getInstance() {
        Settings settings = SettingsIO.loadSettings();
        MainMenu mainMenu = MainMenu.getInstance();
        MainMenuController mainMenuController = new MainMenuController(new StateManager(settings, mainMenu, null));
        return new StateManager(settings, mainMenu, mainMenuController);
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Settings getSettings() {
        return settings;
    }

    public MainMenu getMainMenu() {
        return mainMenu;
    }

    public MainMenuController getMainMenuController() {
        return mainMenuController;
    }

    public Game getGame() {
        return game;
    }

    public RulesController getRulesController() {
        return rulesController;
    }

    public GameState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(GameState newState) {
        this.currentState = newState;
    }
}

