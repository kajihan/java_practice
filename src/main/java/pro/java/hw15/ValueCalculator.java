package pro.java.hw15;

import java.util.Arrays;

public class ValueCalculator {
    private final double[] values;
    private final int halfSize;

    public ValueCalculator(int arraySize) {
        int arraySize1 = Math.max(arraySize, 1000000);
        this.halfSize = arraySize1 / 2;
        this.values = new double[arraySize1];
    }

    public void fillAndSplitArray() {
        long start = System.currentTimeMillis();

        Arrays.fill(values, 1);

        double[] a1 = new double[halfSize];
        double[] a2 = new double[halfSize];

        System.arraycopy(values, 0, a1, 0, halfSize);
        System.arraycopy(values, halfSize, a2, 0, halfSize);

        Thread thread1 = new Thread(() -> calculateValues(a1, 0));
        Thread thread2 = new Thread(() -> calculateValues(a2, halfSize));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.arraycopy(a1, 0, values, 0, halfSize);
        System.arraycopy(a2, 0, values, halfSize, halfSize);

        long end = System.currentTimeMillis();
        long elapsedTime = end - start;
        System.out.println("Time taken: " + elapsedTime + " ms");
    }

    private void calculateValues(double[] array, int offset) {
        for (int i = 0; i < array.length; i++) {
            int index = i + offset;
            array[i] = (array[i] * Math.sin(0.2f + (double) index / 5) *
                    Math.cos(0.2f + (double) index / 5) * Math.cos(0.4f + (double) index / 2));
        }
    }
}