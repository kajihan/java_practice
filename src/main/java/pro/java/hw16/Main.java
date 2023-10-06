package pro.java.hw16;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //Testing of ThreadSafeList functionality
        ThreadSafeList<Integer> threadSafeList = new ThreadSafeList<>();
        threadSafeList.add(10);
        threadSafeList.add(20);
        threadSafeList.add(30);

        System.out.println("Element with number 1: " + threadSafeList.get(1));
        threadSafeList.remove(20);

        System.out.println("Elements after deleted element 20: " + threadSafeList.get(0) + ", " + threadSafeList.get(1));
        separateLogicalBlock();

        //Testing of PetrolStation functionality
        PetrolStation petrolStation = new PetrolStation(100);

        for (int i = 0; i < 3; i++) {  //Running 3 threads that are trying to refuel at the same time
            int fuelAmount = (int) (Math.random() * 30) + 10;
            new Thread(() -> {
                System.out.println("Request for refueling of " + fuelAmount + " litres of fuel");
                petrolStation.doRefuel(fuelAmount);
            }).start();
        }
    }

    private static void separateLogicalBlock() {
        System.out.println(Stream.generate(() -> "- ").limit(30).collect(Collectors.joining()));
    }
}
