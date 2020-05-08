package amerebagatelle.github.io.thresher;

import java.io.*;
import java.util.Properties;

public class Settings {

    public static File settingsFile = new File("config/thresher.properties");

    public static void initSettings() {
        // Init settings file if it doesn't exist
        if (!settingsFile.exists()) {
            try {
                boolean fileCreated = settingsFile.createNewFile();

                if (fileCreated) {
                    Properties prop = new Properties();
                    prop.setProperty("minimumDedicatedRAM", "4096");

                    BufferedWriter writer = new BufferedWriter(new FileWriter(settingsFile));
                    prop.store(writer, null);
                    writer.flush();
                    writer.close();
                } else {
                    throw new IOException();
                }
            } catch (IOException e) {
                throw new RuntimeException("Could not create settings file for Thresher!");
            }
        }
    }

    public static String loadSetting(String setting) {
        BufferedReader reader;
        Properties prop = new Properties();

        try {
            reader = new BufferedReader(new FileReader(settingsFile));
            prop.load(reader);
            reader.close();

            return prop.getProperty(setting);
        } catch (IOException e) {
            throw new RuntimeException("Can't read settings for Thresher!");
        }
    }

    public static void writeSetting(String setting, String setpoint) {
        BufferedReader reader;
        BufferedWriter writer;
        Properties prop = new Properties();

        try {
            reader = new BufferedReader(new FileReader(settingsFile));
            prop.load(reader);
            reader.close();

            prop.setProperty(setting, setpoint);

            writer = new BufferedWriter(new FileWriter(settingsFile));
            prop.store(writer, null);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException("Can't read settings for Thresher!");
        }
    }
}
