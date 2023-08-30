package pro.java.hw8;

public class ArrayValueCalculator {

    public static void main(String[] args) {
        String[][] array = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int calcArray = doCalc(array);
            System.out.println("Summary result: " + calcArray);
        } catch (ArraySizeException | ArrayDataException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static int doCalc(String[][] array) throws ArraySizeException, ArrayDataException {
        try {
            if (array.length != 4 || array[0].length != 4) {
                throw new ArraySizeException("Incorrect array size");
            }

            int result = 0;

            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    String valueStr = array[i][j];
                    try {
                        int value = Integer.parseInt(valueStr);
                        result += value;
                    } catch (NumberFormatException e) {
                        try {
                            throw new ArrayDataException("Invalid value at element [" + i + "][" + j + "]", e);
                        } catch (Throwable throwable) {
                            throwable.printStackTrace();
                            return 0;
                        }
                    }
                }
            }
            return result;
        } catch (Exception e) {
            try {
                throw new ArrayDataException("Error processing array", e).getCause();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
        return 0;
    }
}