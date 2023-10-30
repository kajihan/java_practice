package pro.java.hw20.carBuilder.cars;

import pro.java.hw20.carBuilder.Car;
import pro.java.hw20.carBuilder.Transmission;

public class Sports extends Car {
    private final String engineType;

    public Sports(String model, String engine, String body, String wheels, Transmission transmission, String engineType) {
        super(model, engine, body, wheels, transmission);
        this.engineType = engineType;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "EngineType: " + getEngineType();
    }

    public String getEngineType() {
        return engineType;
    }
}
