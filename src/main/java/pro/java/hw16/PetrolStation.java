package pro.java.hw16;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class PetrolStation {

    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String CYAN = "\u001B[36m";
    private static final String BLUE = "\033[0;34m";
    private final AtomicInteger stationFuelAmount;

    public PetrolStation(AtomicInteger initialAmount) {
        this.stationFuelAmount = initialAmount;
    }

    public synchronized void doRefuel(int fuelAmount) {
        try {
            if (fuelAmount > stationFuelAmount.get()) {
                throw new IllegalArgumentException();
            }

            int refuelTime = getRandomRefuelTime();
            sleep(refuelTime);

            decreaseAmount(fuelAmount);
            System.out.println(GREEN + "Refueled " + fuelAmount + " litres of fuel, remaining fuel in station: " + RESET
                    + BLUE + stationFuelAmount.get() + RESET);
        } catch (IllegalArgumentException e) {
            System.out.println(CYAN + Thread.currentThread().getName() + RESET + ": "
                    + RED + "Not enough fuel at the station to refuel!" + RESET);
        }
    }

    private int getRandomRefuelTime() {
        return ThreadLocalRandom.current().nextInt(3, 11) * 1000;
    }

    private void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.err.println("Sleep interrupted: " + e.getMessage());
        }
    }

    private void decreaseAmount(int fuelAmount) {
        stationFuelAmount.updateAndGet(amount -> amount - fuelAmount);
    }
}
