package pro.java.hw11.phonebook;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Record userOne = new Record("Ivan", "123-111-222");
        Record userTwo = new Record("Masha", "123-222-222");
        Record userThree = new Record("Petya", "123-333-222");
        Record userFour = new Record("Masha", "222-123-345");
        Record userFive = new Record("Vova", "222-444-222");
        Record userSix = new Record("Ivan", "321-011-334");
        phoneBook.add(userOne);
        phoneBook.add(userTwo);
        phoneBook.add(userThree);
        phoneBook.add(userFour);
        phoneBook.add(userFive);
        phoneBook.add(userSix);
        System.out.println(phoneBook.find("Masha"));
        System.out.println(phoneBook.findAll("Masha"));
    }
}
