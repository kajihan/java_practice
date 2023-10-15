package pro.java.hw17;

public class FileLoggerConfiguration {
    private final String logFileName;
    private final LoggingLevel logLevel;
    private final long maxSize;
    private final String logFormat;
    private final boolean logToConsole;

    public FileLoggerConfiguration(String logFileName, LoggingLevel logLevel, long maxSize, String logFormat, Boolean logToConsole) {
        this.logFileName = logFileName;
        this.logLevel = logLevel;
        this.maxSize = maxSize;
        this.logFormat = logFormat;
        this.logToConsole = logToConsole;
    }

    public boolean isLogToConsole() {
        return logToConsole;
    }

    public String getLogFileName() {
        return logFileName;
    }

    public LoggingLevel getLogLevel() {
        return logLevel;
    }

    public long getMaxSize() {
        return maxSize;
    }

    public String getLogFormat() {
        return logFormat;
    }
}
