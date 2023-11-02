package pro.java.hw23.storages.db_storage;

import pro.java.hw23.DataStorage;
import pro.java.hw23.config.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DatabaseDataStorage implements DataStorage {
    private final Connection connection;

    public DatabaseDataStorage() {
        this.connection = DataBaseConnection.getConnection();
    }

    public DatabaseDataStorage(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(List<String> data) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO smartstorage.storage (data) VALUES (?)");

            for (String inputData : data) {
                statement.setString(1, inputData);
                statement.executeUpdate();
            }

            System.out.println("Data saved to the database");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
