package org.courseproject.core;

import org.courseproject.utils.SettingsIO;

public class StateManager {
    private final Settings settings;
    private final MainMenu mainMenu;
    private Game game; // Game instance
    private final BankController bankController;
    private final CashOutController cashOutController;
    private final RulesController rulesController;
    private GameState currentState;

    // Constructor without Game instance
    public StateManager(Settings settings, MainMenu mainMenu) {
        this.settings = settings;
        this.mainMenu = mainMenu;
        this.bankController = new BankController(this);
        this.cashOutController = new CashOutController(this);
        this.rulesController = new RulesController(this);
        this.currentState = GameState.MAIN_MENU;
    }

    // Static method to get instance
    public static StateManager getInstance() {
        Settings settings = SettingsIO.loadSettings();
        MainMenu mainMenu = MainMenu.getInstance();
        return new StateManager(settings, mainMenu);
    }

    // Setter for Game instance
    public void setGame(Game game) {
        this.game = game;
    }

    // Getters and other methods
    public Settings getSettings() {
        return settings;
    }

    public MainMenu getMainMenu() {
        return mainMenu;
    }

    public Game getGame() {
        return game;
    }

    public BankController getBankController() {
        return bankController;
    }

    public CashOutController getCashOutController() {
        return cashOutController;
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

