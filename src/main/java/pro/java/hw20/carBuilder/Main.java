package pro.java.hw20.carBuilder;

import pro.java.hw20.carBuilder.cars.Sports;
import pro.java.hw20.carBuilder.cars.Truck;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static pro.java.hw20.carBuilder.Transmission.AUTOMATIC;
import static pro.java.hw20.carBuilder.Transmission.MANUAL;


public class Main {
    public static void main(String[] args) {
        Car sportsCar = new Sports()
                .buildModel("Ferrari F8 Tribute")
                .buildEngine("Powerful engine for sports car")
                .buildBody("Sports car body")
                .buildWheels("Sports car wheels")
                .buildTransmission(AUTOMATIC)
                .build();

        Car truckCar = new Truck()
                .buildModel("Ford F150 Raptor")
                .buildEngine("Powerful engine for truck")
                .buildBody("Heavy truck body")
                .buildWheels("Large truck wheels")
                .buildTransmission(MANUAL)
                .build();

        sportsCar.showInfo();
        separateLogicalBlock();
        truckCar.showInfo();
    }

    private static void separateLogicalBlock() {
        System.out.println(Stream.generate(() -> "- ").limit(20).collect(Collectors.joining()));
    }
}
