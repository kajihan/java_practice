package pro.java.hw19.dto;

public class Homework {
    private final String name;
    private final String description;
    private int id;

    public Homework(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Homework(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return ("Homework: " + getName() + ", " +
                "Description: " + getDescription());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
