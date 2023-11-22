package pro.java.hw22.storages.file_storage;

import pro.java.hw22.DataStorage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileDataStorage implements DataStorage {
    private final String filename;

    public FileDataStorage(String filename) {
        this.filename = filename;
    }


    @Override
    public void save(List<String> data) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            for (String item : data) {
                writer.println(item);
            }
            System.out.println("Data saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}