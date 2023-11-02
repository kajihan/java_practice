package pro.java.hw23.storages.collection_storage;

import pro.java.hw23.DataStorage;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDataStorage implements DataStorage {
    private final List<String> dataList = new ArrayList<>();

    public List<String> getDataList() {
        return dataList;
    }

    @Override
    public void save(List<String> data) {
        dataList.addAll(data);
        for (String inputData : data) {
            System.out.println("Saved data: " + inputData);
        }
        System.out.println("In total, " + dataList.size() + " data saved to In-Memory Collection");
    }
}
