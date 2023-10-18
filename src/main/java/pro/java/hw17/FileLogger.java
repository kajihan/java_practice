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

public class FileLogger implements AutoCloseable {
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
                Result result = getResult(fileSizeBeforeRotation, newPath);
                throw new FileMaxSizeReachedException(result.errorMessage, result.limitMessage,
                        result.beforeRotationMessage, result.newLogFileMessage, result.newPathMessage);
            } catch (IOException e) {
                ExceptionResult exceptionResult = getExceptionResult(e, fileSizeBeforeRotation);
                throw new FileMaxSizeReachedException(exceptionResult.errorMessage, exceptionResult.limitMessage,
                        exceptionResult.beforeRotationMessage, exceptionResult.failedLogMessage, exceptionResult.failedLogPathMessage);
            }
        }
    }

    private ExceptionResult getExceptionResult(IOException e, long fileSizeBeforeRotation) {
        String errorMessage = "Error creating a new log file: " + e.getMessage();
        String limitMessage = "Log file size limit: " + config.getMaxSize() + " bytes";
        String beforeRotationMessage = "Log file size before creating a new one: " + fileSizeBeforeRotation + " bytes";
        String failedLogMessage = "Failed to create a new log file.";
        String failedLogPathMessage = GREEN + "Path to the failed log file: " + ARROW + Paths.get(currentFileName).toAbsolutePath() + RESET;
        return new ExceptionResult(errorMessage, limitMessage, beforeRotationMessage, failedLogMessage, failedLogPathMessage);
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

    public void print(boolean isLogToConsole, LoggingLevel level, String message) {
        if (shouldLog(level)) {
            try {
                if (isLogToConsole) {
                    String logMessage = formatLogMessage(level, message);
                    System.out.println(logMessage);
                } else {
                    log(message, level);
                }
            } catch (FileMaxSizeReachedException e) {
                displayFileMaxSizeMessages(e);
            } catch (IOException e) {
                logErrorMessage(level.toString(), message);
            }
        }
    }

    public void info(String message) {
        print(config.isLogToConsole(), LoggingLevel.INFO, message);
    }

    public void debug(String message) {
        print(config.isLogToConsole(), LoggingLevel.DEBUG, message);
    }

    public void warning(String message) {
        print(config.isLogToConsole(), LoggingLevel.WARN, message);
    }

    private boolean shouldLog(LoggingLevel level) {
        return level.ordinal() <= config.getLogLevel().ordinal();
    }

    private String formatLogMessage(LoggingLevel level, String message) {
        return "[" + getTimestamp() + "][" + level + "] " + "Message: " + message;
    }

    private void logErrorMessage(String level, String message) {
        System.err.println("Error occurred while logging " + level + " message: " + message);
    }

    private void displayFileMaxSizeMessages(FileMaxSizeReachedException e) {
        System.out.println(RED + "Maximum log file size reached or exceeded!" + RESET);
        System.out.println(e.getLimitMessage());
        System.out.println(e.getSizeBeforeRotationMessage());
        System.out.println(e.getNewLogFileMessage());
        System.out.println(e.getNewLogFilePathMessage());
    }

    @Override
    public void close() {
        if (writer != null) writer.close();
    }

    private Result getResult(long fileSizeBeforeRotation, Path newPath) {
        String errorMessage = "Maximum file size reached or exceeded!";
        String limitMessage = "Log file size limit: " + config.getMaxSize() + " bytes";
        String beforeRotationMessage = "Log file size before creating a new one: " + fileSizeBeforeRotation + " bytes";
        String newLogFileMessage = "New log file created: " + currentFileName;
        String newPathMessage = GREEN + "Path to the new log file: " + ARROW + newPath.toAbsolutePath() + RESET;
        return new Result(errorMessage, limitMessage, beforeRotationMessage, newLogFileMessage, newPathMessage);
    }

    private static class Result {
        public final String errorMessage;
        public final String limitMessage;
        public final String beforeRotationMessage;
        public final String newLogFileMessage;
        public final String newPathMessage;

        public Result(String errorMessage, String limitMessage, String beforeRotationMessage,
                      String newLogFileMessage, String newPathMessage) {
            this.errorMessage = errorMessage;
            this.limitMessage = limitMessage;
            this.beforeRotationMessage = beforeRotationMessage;
            this.newLogFileMessage = newLogFileMessage;
            this.newPathMessage = newPathMessage;
        }
    }

    private static class ExceptionResult {
        public final String errorMessage;
        public final String limitMessage;
        public final String beforeRotationMessage;
        public final String failedLogMessage;
        public final String failedLogPathMessage;

        public ExceptionResult(String errorMessage, String limitMessage, String beforeRotationMessage,
                               String failedLogMessage, String failedLogPathMessage) {
            this.errorMessage = errorMessage;
            this.limitMessage = limitMessage;
            this.beforeRotationMessage = beforeRotationMessage;
            this.failedLogMessage = failedLogMessage;
            this.failedLogPathMessage = failedLogPathMessage;
        }
    }
}
