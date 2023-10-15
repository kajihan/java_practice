package pro.java.hw17;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger {
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String ARROW = " ➜ ";
    private final FileLoggerConfiguration config;
    private PrintWriter writer;
    private long currentFileSize;
    private String currentFileName;

    public FileLogger(FileLoggerConfiguration config) throws IOException {
        this.config = config;
        this.writer = config.isLogToConsole()
                ? new PrintWriter(System.out)
                : createFileWriter();
    }

    private PrintWriter createFileWriter() throws IOException {
        this.currentFileName = config.getLogFileName();
        this.currentFileSize = new File(currentFileName).length();
        return new PrintWriter(new FileWriter(currentFileName, true));
    }

    private void checkFileSize() throws FileMaxSizeReachedException {
        if (currentFileSize >= config.getMaxSize()) {
            long fileSizeBeforeRotation = new File(currentFileName).length();

            SimpleDateFormat dateFormat = new SimpleDateFormat(config.getLogFormat());
            String timestamp = dateFormat.format(new Date());
            String newFilePath = "Log_" + timestamp + ".txt";
            try {
                writer.close();

                Path currentPath = Paths.get(currentFileName);
                Path newPath = Paths.get(newFilePath);
                Files.move(currentPath, newPath, StandardCopyOption.REPLACE_EXISTING);

                writer = new PrintWriter(new FileWriter(currentFileName, true));
                currentFileSize = 0;
                currentFileName = newFilePath;

                String errorMessage = "Maximum file size reached or exceeded!";
                String limitMessage = "Log file size limit: " + config.getMaxSize() + " bytes";
                String beforeRotationMessage = "Log file size before creating a new one: " + fileSizeBeforeRotation + " bytes";
                String newLogFileMessage = "New log file created: " + currentFileName;
                String newPathMessage = GREEN + "Path to the new log file: " + ARROW + newPath.toAbsolutePath() + RESET;
                throw new FileMaxSizeReachedException(errorMessage, limitMessage, beforeRotationMessage, newLogFileMessage, newPathMessage);
            } catch (IOException e) {
                String errorMessage = "Error creating a new log file: " + e.getMessage();
                String limitMessage = "Log file size limit: " + config.getMaxSize() + " bytes";
                String beforeRotationMessage = "Log file size before creating a new one: " + fileSizeBeforeRotation + " bytes";
                String failedLogMessage = "Failed to create a new log file.";
                String failedLogPathMessage = GREEN + "Path to the failed log file: " + ARROW + Paths.get(currentFileName).toAbsolutePath() + RESET;
                throw new FileMaxSizeReachedException(errorMessage, limitMessage, beforeRotationMessage, failedLogMessage, failedLogPathMessage);
            }
        }
    }

    private String getTimestamp() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(config.getLogFormat());
        return dateFormat.format(new Date());
    }

    private void log(String message, LoggingLevel level) throws FileMaxSizeReachedException, IOException {
        if (level.ordinal() <= config.getLogLevel().ordinal()) {
            checkFileSize();
            SimpleDateFormat dateFormat = new SimpleDateFormat(config.getLogFormat());
            String timestamp = dateFormat.format(new Date());
            String logMessage = String.format("[%s][%s] %s: %s", timestamp, level, "Message", message);
            writer.println(logMessage);
            writer.flush();
            currentFileSize += logMessage.length();
        } else {
            System.out.println("Log message is not logged due to wrong logging level: " + level);
        }
    }

    public void warning(String message) {
        try {
            if (config.isLogToConsole()) {
                String logMessage = "[" + getTimestamp() + "][" + LoggingLevel.WARN + "] " + "Message: " + message;
                System.out.println(logMessage);
            } else {
                log(message, LoggingLevel.WARN);
            }
        } catch (FileMaxSizeReachedException e) {
            displayFileMaxSizeMessages(e);
        } catch (IOException e) {
            System.err.println("Error occurred while logging WARNING message: " + message);
        }
    }

    public void info(String message) {
        if (LoggingLevel.INFO.ordinal() <= config.getLogLevel().ordinal()) {
            try {
                if (config.isLogToConsole()) {
                    String logMessage = "[" + getTimestamp() + "][" + LoggingLevel.INFO + "] " + "Message: " + message;
                    System.out.println(logMessage);
                } else {
                    log(message, LoggingLevel.INFO);
                }
            } catch (FileMaxSizeReachedException e) {
                displayFileMaxSizeMessages(e);
            } catch (IOException e) {
                System.err.println("Error occurred while logging INFO message: " + message);
            }
        }
    }

    public void debug(String message) {
        if (LoggingLevel.DEBUG.ordinal() <= config.getLogLevel().ordinal()) {
            try {
                if (config.isLogToConsole()) {
                    String logMessage = "[" + getTimestamp() + "][" + LoggingLevel.DEBUG + "] " + "Message: " + message;
                    System.out.println(logMessage);
                } else {
                    log(message, LoggingLevel.DEBUG);
                }
            } catch (FileMaxSizeReachedException e) {
                displayFileMaxSizeMessages(e);
            } catch (IOException e) {
                System.err.println("Error occurred while logging DEBUG message: " + message);
            }
        }
    }

    private void displayFileMaxSizeMessages(FileMaxSizeReachedException e) {
        System.out.println(RED + "Maximum log file size reached or exceeded!" + RESET);
        System.out.println(e.getLimitMessage());
        System.out.println(e.getSizeBeforeRotationMessage());
        System.out.println(e.getNewLogFileMessage());
        System.out.println(e.getNewLogFilePathMessage());
    }

    public void close() {
        if (writer != null) {
            writer.close();
        }
    }
}
