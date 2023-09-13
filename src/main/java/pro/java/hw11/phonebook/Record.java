package pro.java.hw11.phonebook;

// Class Record for saving Name and Phone number
public class Record {
    private final String name;
    private final String phone;

    public Record(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "name: " + this.getName() + ", " + "phone: " + this.getPhone();
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
