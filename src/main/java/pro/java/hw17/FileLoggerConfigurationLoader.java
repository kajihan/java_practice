package pro.java.hw17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileLoggerConfigurationLoader {
    public static final String CONFIG_FILE = "properties.txt";
    public static FileLoggerConfiguration load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CONFIG_FILE))) {
            String filePath = getValue(reader.readLine());
            LoggingLevel logLevel = LoggingLevel.valueOf(getValue(reader.readLine()).toUpperCase());
            long maxSize = Long.parseLong(getValue(reader.readLine()));
            String logFormat = getValue(reader.readLine());
            boolean logToConsole = Boolean.parseBoolean(getValue(reader.readLine()));
            return new FileLoggerConfiguration(filePath, logLevel, maxSize, logFormat, logToConsole);
        } catch (IOException e) {
            System.err.println("Error loading configuration file" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private static String getValue(String line) {
        return line.split("=")[1];
    }
}
