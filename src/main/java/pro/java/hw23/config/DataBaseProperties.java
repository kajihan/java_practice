package pro.java.hw23.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataBaseProperties {
    private static final String PROPERTIES_FILE = "dbstorage.properties";

    public static String getUrl() {
        return getProperty("db.url");
    }

    public static String getUser() {
        return getProperty("db.user");
    }

    public static String getPassword() {
        return getProperty("db.password");
    }

    private static String getProperty(String key) {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(PROPERTIES_FILE)) {
            properties.load(fis);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return properties.getProperty(key);
    }
}
