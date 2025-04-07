package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

    private static final Properties properties = new Properties();

    static {
        String configPath = System.getProperty("config.path", "src/test/resources/config.properties");
        try (InputStream input = new FileInputStream(configPath)) {
            properties.load(input);
        } catch (IOException ex) {
            throw new RuntimeException("Error loading configuration file: " + configPath, ex);
        }
    }

    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new IllegalArgumentException("Property not found: " + key);
        }
        return value;
    }

    public static String getBaseUrl() {
        return getProperty("baseUrl");
    }

    public static String getBrowser() {
        return getProperty("browser");
    }
}