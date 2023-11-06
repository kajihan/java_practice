package pro.java.hw23;

import pro.java.hw23.storages.collection_storage.InMemoryDataStorage;
import pro.java.hw23.storages.db_storage.DatabaseDataStorage;
import pro.java.hw23.storages.file_storage.FileDataStorage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataStorageApp {
    public static void main(String[] args) throws IOException {
        List<String> inputData = readInputFromCommandLine();
        DataStorage selectedStorage = getStorageMethod();
        StorageCommand selectedCommand = createCommand(selectedStorage);
        selectedCommand.execute(inputData);
    }

    public static List<String> readInputFromCommandLine() {
        System.out.println("Enter any information to be saved later in the selected method. Enter 'done' to finish input.");
        List<String> inputData = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            input = scanner.nextLine();
            if ("done".equalsIgnoreCase(input)) {
                break;
            }
            inputData.add(input);
        }

        return inputData;
    }

    public static DataStorage getStorageMethod() {
        System.out.println("Select a storage type:");
        System.out.println("1. In-Memory Collection");
        System.out.println("2. Save to File");
        System.out.println("3. Save to Database");
        System.out.print("Enter your choice (1/2/3): ");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        return switch (choice) {
            case 1 -> new InMemoryDataStorage();
            case 2 -> new FileDataStorage("data.txt");
            case 3 -> new DatabaseDataStorage();
            default -> {
                System.out.println("Invalid choice " + choice + " entered ");
                throw new IllegalArgumentException("An error occurred with choice");
            }
        };
    }

    public static StorageCommand createCommand(DataStorage dataStorage) {
        return new StorageCommand(dataStorage);
    }
}
