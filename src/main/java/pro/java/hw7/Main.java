package pro.java.hw7;

public class Main {

    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) {
        GuessWord game = new GuessWord();
        findSymbolOccurance("Java", 'a');
        findWordPosition("Java is the best programming language", "the best");
        stringReverse("Hello");
        isPalindrome("level");
        game.start();
    }

    public static void findSymbolOccurance(String text, Character charInText) {
        char[] convert = text.toCharArray();
        int result = 0;

        for (int i = 0; i < convert.length; i++) {
            if (text.charAt(i) == charInText) {
                result++;
            }
        }
        System.out.printf("The number of characters '%s' in %s is %d\n", charInText, text, result);
    }

    public static void findWordPosition(String source, String target) {
        boolean isTargetInSource = source.contains(target);

        if (isTargetInSource) {
            int targetPosition = source.indexOf(target);
            System.out.printf("The first occurrence index of the word %s%s%s in the text %s%s%s is %s%d%s\n",
                    ANSI_YELLOW, target, ANSI_RESET,
                    ANSI_GREEN, source, ANSI_RESET,
                    ANSI_RED, source.indexOf(target, targetPosition), ANSI_RESET);
        } else {
            System.out.println(source.indexOf(target));
        }
    }

    public static void stringReverse(String text) {
        char[] source = text.toCharArray();
        for (int i = source.length - 1; i >= 0; i--)
            System.out.print(source[i]);
        System.out.println();
    }

    public static void isPalindrome(String text) {
        System.out.println(text.equals(new StringBuilder(text).reverse().toString()));
    }
}
