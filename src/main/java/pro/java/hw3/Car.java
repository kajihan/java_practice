package pro.java.hw3;

public class Car {
    public void start() {
        startElectricity();
        startCommand();
        startFuelSystem();
    }

    private void startFuelSystem() {
        System.out.println("Fuel system starts operation");
    }

    private void startCommand() {
        System.out.println("Start command activated");
    }

    private void startElectricity() {
        System.out.println("The power is on");
    }
}
