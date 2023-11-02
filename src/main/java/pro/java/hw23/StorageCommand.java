package pro.java.hw23;

import java.io.IOException;
import java.util.List;

public class StorageCommand {
    private final DataStorage dataStorage;

    public StorageCommand(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    public void execute(List<String> data) throws IOException {
        dataStorage.save(data);
    }
}
