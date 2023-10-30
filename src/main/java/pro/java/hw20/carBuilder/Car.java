package pro.java.hw20.carBuilder;

import pro.java.hw20.carBuilder.cars.Sports;
import pro.java.hw20.carBuilder.cars.Truck;

public class Car {
    private final String model;
    private final String engine;
    private final String body;
    private final String wheels;
    private final Transmission transmission;

    protected Car(String model, String engine, String body, String wheels, Transmission transmission) {
        this.model = model;
        this.engine = engine;
        this.body = body;
        this.wheels = wheels;
        this.transmission = transmission;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getModel() {
        return model;
    }

    public String getEngine() {
        return engine;
    }

    public String getBody() {
        return body;
    }

    public String getWheels() {
        return wheels;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    @Override
    public String toString() {
        return "Model: " + getModel() + "\n" +
                "Engine: " + getEngine() + "\n" +
                "Body: " + getBody() + "\n" +
                "Wheels: " + getWheels() + "\n" +
                "Transmission: " + getTransmission();
    }

    public static class Builder {
        private String model;
        private String engine;
        private String body;
        private String wheels;
        private Transmission transmission;

        private Builder() {
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder engine(String engine) {
            this.engine = engine;
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Builder wheels(String wheels) {
            this.wheels = wheels;
            return this;
        }

        public Builder transmission(Transmission transmission) {
            this.transmission = transmission;
            return this;
        }

        public Car build() {
            return new Car(model, engine, body, wheels, transmission);
        }

        public Sports buildSportsCar(String engineType) {
            return new Sports(model, engine, body, wheels, transmission, engineType);
        }

        public Truck buildTruckCar(int capacity) {
            return new Truck(model, engine, body, wheels, transmission, capacity);
        }
    }
}
