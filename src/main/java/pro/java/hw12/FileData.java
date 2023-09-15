package pro.java.hw12;

public class FileData {
    private final String fileName;
    private final long fileSize;
    private final String filePath;

    public FileData(String fileName, long fileSize, String filePath) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public String getFilePath() {
        return filePath;
    }

    @Override
    public String toString() {
        return fileName;
    }
}
