package pro.java.hw20.carBuilder;

public class Car {
    private String model;
    private String engine;
    private String body;
    private String wheels;
    private Transmission transmission;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getWheels() {
        return wheels;
    }

    public void setWheels(String wheels) {
        this.wheels = wheels;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public void showInfo() {
        System.out.println("Model: " + getModel());
        System.out.println("Engine: " + getEngine());
        System.out.println("Body: " + getBody());
        System.out.println("Wheels: " + getWheels());
        System.out.println("Transmission: " + getTransmission());
    }
}
