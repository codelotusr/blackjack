package org.courseproject.core;

public class StateManager {
    private final Settings settings;

    public StateManager() {
        this.settings = Settings.getInstance();
    }

    public Settings getSettings() {
        return settings;
    }
}
