package pro.java.hw20.carBuilder;

public interface CarBuilder {
    CarBuilder buildModel(String model);

    CarBuilder buildEngine(String engine);

    CarBuilder buildBody(String body);

    CarBuilder buildWheels(String wheels);

    CarBuilder buildTransmission(Transmission transmission);

    Car build();
}
