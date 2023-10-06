package pro.java.hw16;

public class PetrolStation {
    private int amount;

    public PetrolStation(int initialAmount) {
        this.amount = initialAmount;
    }

    public int getAmount() {
        return amount;
    }

    public synchronized void doRefuel(int fuelAmount) {
        if (fuelAmount > getAmount()) {
            System.out.println("Not enough fuel in the station!");
            return;
        }

        int refuelTime = getRandomRefuelTime();
        sleep(refuelTime * 1000);

        decreaseAmount(fuelAmount);
        System.out.println("Refueled " + fuelAmount + " litres of fuel, remaining fuel in station: " + getAmount());
    }

    private int getRandomRefuelTime() {
        return (int) (Math.random() * 8) + 3;
    }

    private void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.err.println("Sleep interrupted: " + e.getMessage());
        }
    }

    private void decreaseAmount(int fuelAmount) {
        amount -= fuelAmount;
    }
}
