package pro.java.hw19.dao;

import pro.java.hw19.config.DataBaseConnection;
import pro.java.hw19.dto.Homework;
import pro.java.hw19.dto.Lesson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LessonDao {
    private final Connection connection;

    public LessonDao() {
        this.connection = DataBaseConnection.getConnection();
    }

    public void addLesson(Lesson lesson) {
        String sql = "INSERT INTO Lesson (name, homework_id) VALUES " +
                "(?, (SELECT id FROM Homework WHERE name = ? LIMIT 1))";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, lesson.getName());
            statement.setString(2, lesson.getHomework().getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public List<Lesson> getAllLessons() {
        List<Lesson> lessons = new ArrayList<>();
        String sql = "SELECT Lesson.name, Homework.name, Homework.description FROM Lesson " +
                "LEFT JOIN Homework ON Lesson.homework_id = Homework.id";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String lessonName = resultSet.getString(1);
                String homeworkName = resultSet.getString(2);
                String homeworkDescription = resultSet.getString(3);

                Homework homework = new Homework(homeworkName, homeworkDescription);
                Lesson lesson = new Lesson(lessonName, homework);
                lessons.add(lesson);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return lessons;
    }

    public void deleteLesson(int lessonId) {
        String sql = "DELETE FROM Lesson WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, lessonId);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public Lesson getLessonById(int lessonId) {
        Lesson lesson = null;
        String sql = "SELECT Lesson.name, Homework.name, Homework.description " +
                "FROM Lesson " +
                "LEFT JOIN Homework ON Lesson.homework_id = Homework.id " +
                "WHERE Lesson.id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, lessonId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String lessonName = resultSet.getString(1);
                    String homeworkName = resultSet.getString(2);
                    String homeworkDescription = resultSet.getString(3);

                    Homework homework = new Homework(homeworkName, homeworkDescription);
                    lesson = new Lesson(lessonName, homework);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return lesson;
    }
}
