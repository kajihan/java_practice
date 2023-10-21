package pro.java.hw19;

import pro.java.hw19.dao.HomeworkDao;
import pro.java.hw19.dao.LessonDao;
import pro.java.hw19.dto.Homework;
import pro.java.hw19.dto.Lesson;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // Create homeworks
        Homework homework1 = new Homework("HomeWork 1", "HomeWork description 1");
        Homework homework2 = new Homework("HomeWork 2", "HomeWork description 2");

        // Add homeworks to database
        HomeworkDao homeworkDao = new HomeworkDao();
        homeworkDao.addHomework(homework1);
        homeworkDao.addHomework(homework2);

        // Create lessons
        Lesson lesson1 = new Lesson("Lesson 1", homework1);
        Lesson lesson2 = new Lesson("Lesson 2", homework2);

        // Add lessons to database
        LessonDao lessonDao = new LessonDao();
        lessonDao.addLesson(lesson1);
        lessonDao.addLesson(lesson2);

        // Get all lessons
        getAllLessons(lessonDao);
        separateLogicalBlock();

        // Get all homeworks
        getAllHomeworks(homeworkDao);
        separateLogicalBlock();

        // Get lesson by id = 1
        getLessonByID(lessonDao, 1);
        separateLogicalBlock();

        // Delete lesson by ID = 2
        deleteLessonByID(lessonDao, 2);
        separateLogicalBlock();

        // Verify lessons after deletion
        getAllLessons(lessonDao);
    }

    private static void deleteLessonByID(LessonDao lessonDao, int lessonID) {
        lessonDao.deleteLesson(lessonID);
        System.out.println("Lesson by id " + lessonID + " was deleted");
    }

    private static void getLessonByID(LessonDao lessonDao, int lessonID) {
        Lesson retrievedLesson = lessonDao.getLessonById(lessonID);
        String message = lessonDao.getLessonById(lessonID) != null
                ? "Lesson by id " + lessonID + ": " + retrievedLesson.getName() + ", " + "Homework: " + retrievedLesson.getHomework().getName()
                : "Lesson by id " + lessonID + " not found";
        System.out.println(message);
    }

    private static void getAllLessons(LessonDao lessonDao) {
        List<Lesson> allLessons = lessonDao.getAllLessons();
        allLessons.forEach(System.out::println);
    }

    private static void getAllHomeworks(HomeworkDao homeworkDao) {
        List<Homework> allHomeworks = homeworkDao.getAllHomework();
        allHomeworks.forEach(System.out::println);
    }

    private static void separateLogicalBlock() {
        System.out.println(Stream.generate(() -> "- ").limit(38).collect(Collectors.joining()));
    }
}
