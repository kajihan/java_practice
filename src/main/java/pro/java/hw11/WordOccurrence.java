package pro.java.hw11;

import java.util.*;

class WordOccurrence implements Comparable<WordOccurrence> {
    private final String name;
    private final int occurrence;

    public WordOccurrence(String name, int occurrence) {
        this.name = name;
        this.occurrence = occurrence;
    }

    public static List<WordOccurrence> findOccurrence(List<String> inputList) {
        Map<String, Integer> wordCount = new HashMap<>();

        // Counting the number of repetitions of each word
        for (String word : inputList) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        List<WordOccurrence> wordOccurrences = new ArrayList<>();

        // Creating structures with results
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            wordOccurrences.add(new WordOccurrence(entry.getKey(), entry.getValue()));
        }
        // Sort results by name
        Collections.sort(wordOccurrences);
        return wordOccurrences;
    }

    public static void printOccurrence(List<WordOccurrence> result) {
        // Displaying the result with commas after each occurrence and nothing after the last
        for (WordOccurrence occurrence : result) {
            if (occurrence.equals(result.get(result.size() - 1))) {
                System.out.println(occurrence + "");
            } else {
                System.out.println(occurrence + ",");
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getOccurrence() {
        return occurrence;
    }

    @Override
    public int compareTo(WordOccurrence other) {
        return this.getName().compareTo(other.getName());
    }

    @Override
    public String toString() {
        return "{name: \"" + getName() + "\", occurrence: " + getOccurrence() + "}";
    }
}