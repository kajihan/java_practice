package pro.java.hw22;

import java.io.IOException;
import java.util.List;

public interface DataStorage {
    void save(List<String> data) throws IOException;
}
