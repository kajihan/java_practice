package pro.java.hw11.phonebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// PhoneBook class for saving records
public class PhoneBook {
    private final List<Record> records = new ArrayList<>();

    // Method for adding a new entry
    public void add(Record record) {
        records.add(record);
    }

    // Method to search for a record by name (returns the first record found)
    public Record find(String name) {
        for (Record record : records) {
            if (record.getName().equals(name)) {
                return record;
            }
        }
        return null;
    }

    // Method to search for all records by name
    public List<Record> findAll(String name) {
        List<Record> allRecords = new ArrayList<>();
        for (Record record : records) {
            if (record.getName().equals(name)) {
                allRecords.add(record);
            }
        }
        return allRecords.isEmpty() ? null : allRecords;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneBook phoneBook = (PhoneBook) o;
        return Objects.equals(records, phoneBook.records);
    }

    @Override
    public int hashCode() {
        return Objects.hash(records);
    }
}