package org.courseproject.core;

public class MainMenu {
    public static MainMenu instance = null;
    private final String options;

    public MainMenu() {
        this.options = """
                1) Play
                2) Check Bank
                3) Cash Out
                4) Settings
                5) Rules
                6) Quit
                """;
    }

    public static MainMenu getInstance() {
        if (instance == null) {
            instance = new MainMenu();
        }
        return instance;
    }

    @Override
    public String toString() {
        return options;
    }
}
