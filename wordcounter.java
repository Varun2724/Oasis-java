import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = "";

        System.out.println("Enter 'T' to input text manually or 'F' to provide a file:");
        String choice = scanner.nextLine().trim();

        if (choice.equalsIgnoreCase("T")) {
            System.out.println("Enter the text:");
            text = scanner.nextLine();
        } else if (choice.equalsIgnoreCase("F")) {
            System.out.println("Enter the file path:");
            String filePath = scanner.nextLine().trim();
            try {
                text = readFile(filePath);
            } catch (FileNotFoundException e) {
                System.out.println("File not found. Exiting the program.");
                System.exit(0);
            }
        } else {
            System.out.println("Invalid choice. Exiting the program.");
            System.exit(0);
        }

        String[] words = text.split("[\\s\\p{Punct}]+");
        int totalWordCount = words.length;

        // Removing stop words
        Set<String> stopWords = new HashSet<>(Arrays.asList("the", "a", "an", "and", "or"));
        List<String> filteredWords = new ArrayList<>();
        for (String word : words) {
            if (!stopWords.contains(word.toLowerCase())) {
                filteredWords.add(word);
            }
        }
        int filteredWordCount = filteredWords.size();

        // Counting unique words and their frequency
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : filteredWords) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }
        int uniqueWordCount = wordFrequency.size();

        // Displaying statistics
        System.out.println("Total Word Count: " + totalWordCount);
        System.out.println("Filtered Word Count (excluding stop words): " + filteredWordCount);
        System.out.println("Unique Word Count: " + uniqueWordCount);

        // Displaying word frequency
        System.out.println("\nWord Frequency:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
    }

    public static String readFile(String filePath) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        File file = new File(filePath);
        Scanner fileScanner = new Scanner(file);

        while (fileScanner.hasNextLine()) {
            sb.append(fileScanner.nextLine()).append("\n");
        }

        fileScanner.close();
        return sb.toString();
    }
}
