package org.courseproject.core;

public class MainMenu {
    private final String options;

    public MainMenu() {
        this.options = """
                1) Play
                2) Check Bank
                3) Cash Out
                4) Settings
                """;
    }

    @Override
    public String toString() {
        return options;
    }
}
