package pro.java.hw23.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection implements AutoCloseable {
    Connection connection;

    public static Connection getConnection() {
        String url = DataBaseProperties.getUrl();
        String user = DataBaseProperties.getUser();
        String password = DataBaseProperties.getPassword();
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}