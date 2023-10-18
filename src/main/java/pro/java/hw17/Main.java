package pro.java.hw17;

import java.io.IOException;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        FileLoggerConfiguration config = FileLoggerConfigurationLoader.load();
        try (FileLogger logger = new FileLogger(config)) {
            logMessageGenerator(logger);
        } catch (IOException e) {
            System.err.println("Error occurred while logging message: " + e.getMessage());
        }
    }

    private static void logMessageGenerator(FileLogger logger) {
        try (logger) {
            IntStream.range(0, 100)
                    .forEach(i -> {
                        logger.warning("This is a warning message.");
                        logger.info("This is an info message.");
                        logger.debug("This is a debug message.");
                    });
        }
    }
}
