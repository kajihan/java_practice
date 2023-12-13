import com.github.javafaker.Faker;
import dao.StudentDAO;
import dto.Student;

import java.util.List;

public class Main {
    static Faker faker = new Faker();

    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        addTestStudents(studentDAO, 5);

        addNewStudent("John", "john@example.com");
        modifyStudent(4, "Modified", "modified@email.com");
        displayStudentById(4);
        deleteStudentById(5);
        displayAllStudents();
    }

    private static void addNewStudent(String name, String email) {
        System.out.println("Adding new student:");
        StudentDAO studentDAO = new StudentDAO();
        Student newStudent = new Student(name, email);
        studentDAO.addStudent(newStudent);
    }

    private static void modifyStudent(int studentId, String name, String email) {
        System.out.println("Modifying student with ID " + studentId + ":");
        StudentDAO studentDAO = new StudentDAO();
        dto.Student studentToUpdate = studentDAO.getStudentById(studentId);
        studentToUpdate.setName(name);
        studentToUpdate.setEmail(email);
        studentDAO.updateStudent(studentToUpdate);
    }

    private static void displayStudentById(int studentId) {
        System.out.println("Displaying student by ID " + studentId + ":");
        StudentDAO studentDAO = new StudentDAO();
        dto.Student retrievedStudent = studentDAO.getStudentById(studentId);
        System.out.println(retrievedStudent);
    }

    private static void deleteStudentById(int studentId) {
        System.out.println("Deleting student with ID " + studentId + ":");
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.deleteStudentById(studentId);
    }

    private static void displayAllStudents() {
        System.out.println("Displaying all students after modification and deletion:");
        StudentDAO studentDAO = new StudentDAO();
        List<Student> remainingStudents = studentDAO.getAllStudents();
        remainingStudents.forEach(System.out::println);
    }

    private static void addTestStudents(StudentDAO studentDAO, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Student student = new Student(faker.name().firstName(), faker.internet().emailAddress());
            studentDAO.addStudent(student);
        }
    }
}
