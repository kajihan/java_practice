package pro.java.hw11;

import java.util.*;

import static pro.java.hw11.WordOccurrence.*;

public class Main {
    public static void main(String[] args) {
        //Task 1
        List<String> stringList = new ArrayList<>();
        stringList.add("Orange");
        stringList.add("Banana");
        stringList.add("Banana");
        stringList.add("Apple");
        stringList.add("Orange");
        stringList.add("Orange");
        System.out.println("The target word is occurred: " +
                countOccurrence(stringList, "Orange") + " times");

        //Task 2
        Integer[] intArray = {1, 2, 3};
        List<Integer> intList = ArrayToListConverter(intArray);
        System.out.println("Array: " + Arrays.toString(intArray));
        System.out.println("List: " + intList);

        //Task 3
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(1);
        List<Integer> uniqueList = findUnique(integerList);
        System.out.println("Original list: " + integerList);
        System.out.println("Unique list: " + uniqueList);

        //Task 4
        List<String> wordsList = new ArrayList<>();
        wordsList.add("bird");
        wordsList.add("fox");
        wordsList.add("bird");
        wordsList.add("fox");
        wordsList.add("cat");
        wordsList.add("dog");
        wordsList.add("fox");
        wordsList.add("cat");
        wordsList.add("cat");
        wordsList.add("fox");

        List<WordOccurrence> occurrences = findOccurrence(wordsList);
        System.out.println("Original list: " + wordsList);
        printOccurrence(occurrences);
    }

    public static int countOccurrence(List<String> stringList, String targetString) {
        int count = 0;
        for (String str : stringList) {
            if (str.equals(targetString)) {
                count++;
            }
        }
        return count;
    }

    public static <T> List<T> ArrayToListConverter(T[] array) {
        List<T> list = new ArrayList<>();
        Collections.addAll(list, array);
        return list;
    }

    public static List<Integer> findUnique(List<Integer> inputList) {
        Set<Integer> uniqueSet = new HashSet<>(inputList);
        return new ArrayList<>(uniqueSet);
    }
}
