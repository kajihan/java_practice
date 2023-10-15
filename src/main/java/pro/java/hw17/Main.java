package pro.java.hw17;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileLoggerConfiguration config = FileLoggerConfigurationLoader.load();
        FileLogger logger = new FileLogger(config);

        logMessageGenerator(logger);
    }

    private static void logMessageGenerator(FileLogger logger) {
        for (int i = 0; i < 100; i++) {
            logger.warning("This is a warning message.");
            logger.info("This is an info message.");
            logger.debug("This is a debug message.");
        }
        logger.close();
    }
}
