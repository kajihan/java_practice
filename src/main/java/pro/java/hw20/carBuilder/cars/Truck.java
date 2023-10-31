package pro.java.hw20.carBuilder.cars;

import pro.java.hw20.carBuilder.Car;
import pro.java.hw20.carBuilder.Transmission;

public class Truck extends Car {
    private final int capacity;

    public Truck(String model, String engine, String body, String wheels, Transmission transmission, int capacity) {
        super(model, engine, body, wheels, transmission);
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Capacity: " + getCapacity();
    }

    public int getCapacity() {
        return capacity;
    }
}
