package pro.java.hw12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Comparator;

public class FileNavigator {
    private final Map<String, List<FileData>> filesMap;

    public FileNavigator() {
        filesMap = new HashMap<>();
    }

    public void add(String path, FileData file) {
        List<FileData> files = filesMap.get(path);

        if (files == null) {
            files = new ArrayList<>();
            filesMap.put(path, files);
        }
        if (!file.getFilePath().equals(path)) {
            System.out.println("File path for file '" + file.getFileName() + "' does not match map key!" + "\n");
            return;
        }
        files.add(file);
    }

    public List<FileData> find(String filePath) {
        return filesMap.get(filePath);
    }

    public Set<FileData> filterBySize(long maxSize) {
        Set<FileData> filtered = new LinkedHashSet<>();
        for (List<FileData> list : filesMap.values()) {
            for (FileData file : list) {
                if (file.getFileSize() <= maxSize) {
                    filtered.add(file);
                }
            }
        }
        return filtered;
    }

    public void remove(String filePath) {
        filesMap.remove(filePath);
        System.out.println("Folder '" + filePath + "' and its files have been removed");
    }

    public Set<FileData> sortBySize() {
        Set<FileData> sortedFiles = new LinkedHashSet<>();

        for (List<FileData> fileList : filesMap.values()) {
            List<FileData> copy = new ArrayList<>(fileList);
            copy.sort(Comparator.comparingLong(FileData::getFileSize));
            sortedFiles.addAll(copy);
        }
        return sortedFiles;
    }

    public Set<String> getPaths() {
        return new LinkedHashSet<>(filesMap.keySet());
    }
}
