package pro.java.hw20.carBuilder.cars;

import pro.java.hw20.carBuilder.Car;
import pro.java.hw20.carBuilder.CarBuilder;
import pro.java.hw20.carBuilder.Transmission;

public class Sports implements CarBuilder {
    private final Car car;

    public Sports() {
        car = new Car();
    }

    @Override
    public CarBuilder buildModel(String model) {
        car.setModel(model);
        return this;
    }

    @Override
    public CarBuilder buildEngine(String engine) {
        car.setEngine(engine);
        return this;
    }

    @Override
    public CarBuilder buildBody(String body) {
        car.setBody(body);
        return this;
    }

    @Override
    public CarBuilder buildWheels(String wheels) {
        car.setWheels(wheels);
        return this;
    }

    @Override
    public CarBuilder buildTransmission(Transmission transmission) {
        car.setTransmission(transmission);
        return this;
    }

    @Override
    public Car build() {
        return car;
    }
}
