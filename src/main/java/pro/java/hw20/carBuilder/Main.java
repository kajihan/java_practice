package pro.java.hw20.carBuilder;

import pro.java.hw20.carBuilder.cars.Sports;
import pro.java.hw20.carBuilder.cars.Truck;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static pro.java.hw20.carBuilder.Transmission.AUTOMATIC;
import static pro.java.hw20.carBuilder.Transmission.MANUAL;


public class Main {
    public static void main(String[] args) {
        Car renault = Car.builder()
                .model("Renault Megan")
                .engine("Standard engine")
                .body("Standard car body")
                .wheels("Standard car wheels")
                .transmission(MANUAL)
                .build();
        System.out.println(renault.toString());
        separateLogicalBlock();

        Sports ferrari = Car.builder()
                .model("Ferrari F8")
                .engine("Powerful engine")
                .body("Sports car body")
                .wheels("Sports car wheels")
                .transmission(AUTOMATIC)
                .buildSportsCar("Engine for speed racing");
        System.out.println(ferrari.toString());
        separateLogicalBlock();

        Truck ford = Car.builder()
                .model("Ford F150")
                .engine("Powerful engine for truck")
                .body("Heavy truck body")
                .wheels("Large truck wheels")
                .transmission(MANUAL)
                .buildTruckCar(1000);
        System.out.println(ford.toString());
    }

    private static void separateLogicalBlock() {
        System.out.println(Stream.generate(() -> "- ").limit(20).collect(Collectors.joining()));
    }
}
