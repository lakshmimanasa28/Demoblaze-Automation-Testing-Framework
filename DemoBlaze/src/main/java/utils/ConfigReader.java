package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    static {
        try {
            InputStream is = ConfigReader.class
                    .getClassLoader()
                    .getResourceAsStream("config.properties");

            prop = new Properties();
            prop.load(is);

        } catch (Exception e) {
            throw new RuntimeException("Config file not found");
        }
    }

    public String getBrowser() {
        return prop.getProperty("browser");
    }

    public String getBaseUrl() {
        return prop.getProperty("baseUrl");
    }

    public boolean isHeadless() {
        return Boolean.parseBoolean(prop.getProperty("headless"));
    }

    public String getUsername() {
        return prop.getProperty("username");
    }

    public String getPassword() {
        return prop.getProperty("password");
    }
}