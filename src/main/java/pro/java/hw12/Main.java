package pro.java.hw12;

public class Main {

    private static final String FILE_ONE = "file1.txt";
    private static final String FILE_TWO = "file2.txt";
    private static final String FILE_THREE = "firstApp.java";
    private static final String FILE_FOUR = "secondApp.java";
    private static final String FILE_FIVE = "file3.csv";

    public static final int SIZE_50 = 50;
    private static final int SIZE_100 = 100;
    public static final int SIZE_1000 = 1000;
    public static final int SIZE_500 = 500;

    private static final String TEXT_FILES_DIR = "../text";
    private static final String JAVA_FILES_DIR = "../java";

    public static final FileData FILE_1 = new FileData(FILE_ONE, SIZE_500, TEXT_FILES_DIR);
    public static final FileData FILE_2 = new FileData(FILE_TWO, SIZE_100, TEXT_FILES_DIR);
    public static final FileData FILE_3 = new FileData(FILE_THREE, SIZE_50, JAVA_FILES_DIR);
    public static final FileData FILE_4 = new FileData(FILE_FOUR, SIZE_500, JAVA_FILES_DIR);
    public static final FileData FILE_5 = new FileData(FILE_FIVE, SIZE_1000, TEXT_FILES_DIR);

    public static void main(String[] args) {
        FileNavigator navigator = new FileNavigator();

        //File path for file 'secondApp.java' does not match map key!
        navigator.add(TEXT_FILES_DIR, FILE_4);

        //Add files to specified directory
        navigator.add(TEXT_FILES_DIR, FILE_1);
        navigator.add(TEXT_FILES_DIR, FILE_2);
        navigator.add(JAVA_FILES_DIR, FILE_3);
        navigator.add(TEXT_FILES_DIR, FILE_5);

        //Show all files in specified directory
        System.out.println("File added to directory " +
                TEXT_FILES_DIR + ": " + navigator.find(TEXT_FILES_DIR));
        System.out.println("File added to directory " +
                JAVA_FILES_DIR + ": " + navigator.find(JAVA_FILES_DIR) + "\n");

        //Filter files by file size in bytes
        System.out.println("Files with a maximum size of 500 bytes: " + navigator.filterBySize(500) + "\n");

        //Remove specified folder and all files inside
        System.out.println("Folders before removal: " + navigator.getPaths());
        navigator.remove(JAVA_FILES_DIR);
        System.out.println("Folders after removal: " + navigator.getPaths() + "\n");

        //Sort files by size
        System.out.println("Files sorted by size: " + navigator.sortBySize());
    }
}
