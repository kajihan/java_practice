package pro.java.hw19.dao;

import pro.java.hw19.config.DataBaseConnection;
import pro.java.hw19.dto.Homework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HomeworkDao implements AutoCloseable {
    Connection connection;

    public void addHomework(Homework homework) {
        try (Connection connection = DataBaseConnection.getConnection()) {
            if (connection == null) {
                return;
            }

            String sql = "INSERT INTO Homework (name, description) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, homework.getName());
                statement.setString(2, homework.getDescription());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Homework> getAllHomework() {
        List<Homework> homeworkList = new ArrayList<>();
        try (Connection connection = DataBaseConnection.getConnection()) {
            if (connection == null) {
                return homeworkList;
            }

            String sql = "SELECT * FROM Homework";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String description = resultSet.getString("description");
                    Homework homework = new Homework(name, description);
                    homeworkList.add(homework);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return homeworkList;
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

