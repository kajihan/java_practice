package pro.java.hw7;

import java.util.Arrays;
import java.util.Scanner;

public class GuessWord {

    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private final static String[] WORDS = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
            "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
            "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

    private final Scanner input;
    private char[] originalWord;
    private char[] currentWord;
    private int misses;

    public GuessWord() {
        this.input = new Scanner(System.in);
    }

    private static char[] hideRealWord(char[] originalWord) {
        char[] hiddenWord = new char[originalWord.length];
        for (int i = 0; i < originalWord.length; i++) {
            hiddenWord[i] = '#';
        }
        return hiddenWord;
    }

    private static char[] chooseWord() {
        return WORDS[(int) (Math.random() * WORDS.length)].toCharArray();
    }

    public void start() {
        boolean keepPlaying = true;

        while (keepPlaying) {
            // Choose a random word
            this.originalWord = chooseWord();
            this.currentWord = hideRealWord(originalWord);
            this.misses = 0;
            while (!Arrays.equals(this.originalWord, this.currentWord)) {
                guess();
            }

            // Display result
            System.out.println("The word is " + ANSI_GREEN + String.valueOf(this.originalWord) + ANSI_RESET + (misses == 0 ? " you are correct"
                    : " you missed " + (misses == 1 ? ANSI_RED + "just one time" + ANSI_RESET : ANSI_YELLOW + misses + ANSI_RESET + " times")));

            // Ask for another game
            keepPlaying = userWantsAnotherGame();
        }
    }

    private boolean userWantsAnotherGame() {
        System.out.print("\nDo you want to start a new attempt?\nEnter y or n: ");
        char gameCase = this.input.nextLine().charAt(0);
        return (gameCase == 'y');
    }

    private void guess() {
        System.out.print("Enter a letter or whole word to guess the answer: " + ANSI_CYAN + String.valueOf(currentWord) + ANSI_RESET + " ");
        String guessWord = this.input.nextLine();

        if (guessWord.length() > 1) {

            if (String.valueOf(originalWord).equals(guessWord)) {
                currentWord = originalWord;
            } else {
                System.out.println(ANSI_RED + guessWord + ANSI_RESET + " is an incorrectly guessed word");
                misses = misses + 1;

            }
        } else {
            char firstChar = guessWord.charAt(0);

            //Check if already made this guess
            for (char character : this.currentWord) {
                if (character == firstChar) {
                    System.out.println(firstChar + " is already in the word you're guessing");
                    misses = misses + 1;
                    return;
                }
            }

            boolean isCorrect = false;
            for (int j = 0; j < this.originalWord.length; j++) {
                if (this.originalWord[j] == firstChar) {
                    currentWord[j] = firstChar;
                    isCorrect = true;
                }
            }
            if (!isCorrect) {
                System.out.println(ANSI_RED + firstChar + ANSI_RESET + " is not in the guessing word");
                misses = misses + 1;
            }
        }
    }
}   