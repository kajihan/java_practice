package pro.java.hw19.config;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
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
}
