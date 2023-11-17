package org.courseproject.utils;
import org.courseproject.core.Settings;

import java.io.*;

public class SettingsIO {

    public static void saveSettings(Settings settings) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/main/java/org/courseproject/settings.dat"))) {
            out.writeObject(settings);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Settings loadSettings() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/main/java/org/courseproject/settings.dat"))) {
            return (Settings) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new Settings();
        }
    }
}

