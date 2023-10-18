package pro.java.hw17;

public class FileMaxSizeReachedException extends Exception {
    private final String limitMessage;
    private final String sizeBeforeRotationMessage;
    private final String newLogFileMessage;
    private final String newLogFilePathMessage;

    public FileMaxSizeReachedException(String message, String limitMessage, String sizeBeforeRotationMessage,
                                       String newLogFileMessage, String newLogFilePathMessage) {
        super(message);
        this.limitMessage = limitMessage;
        this.sizeBeforeRotationMessage = sizeBeforeRotationMessage;
        this.newLogFileMessage = newLogFileMessage;
        this.newLogFilePathMessage = newLogFilePathMessage;
    }

    public String getLimitMessage() {
        return limitMessage;
    }

    public String getSizeBeforeRotationMessage() {
        return sizeBeforeRotationMessage;
    }

    public String getNewLogFileMessage() {
        return newLogFileMessage;
    }

    public String getNewLogFilePathMessage() {
        return newLogFilePathMessage;
    }
}