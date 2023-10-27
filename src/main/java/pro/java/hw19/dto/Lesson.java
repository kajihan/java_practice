package pro.java.hw19.dto;

public class Lesson {
    private int id;
    private final String name;
    private final Homework homework;

    public Lesson(String name, Homework homework) {
        this.name = name;
        this.homework = homework;
    }

    public Lesson(int id, String name, Homework homework) {
        this.id = id;
        this.name = name;
        this.homework = homework;
    }

    @Override
    public String toString() {
        return ("Lesson: " + getName() + ", " +
                "Homework: " + getHomework().getName() + ", " +
                "Description: " + getHomework().getDescription());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Homework getHomework() {
        return homework;
    }
}
