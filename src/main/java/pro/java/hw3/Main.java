package pro.java.hw3;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        Employee employee = new Employee("John", "Smith", "QA", "jsmith@test.net", "012-3456789", 32);
        car.start();
        System.out.println(employee.getName() + " " + employee.getSurname());
    }

}
