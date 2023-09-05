package pro.java.hw3;

public class Employee {
    private final String name;
    private final String surname;
    private final String position;
    private final String email;
    private final String phone;
    private final int age;

    public Employee(String name, String surname, String position, String email, String phone, int age) {
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getAge() {
        return age;
    }
}