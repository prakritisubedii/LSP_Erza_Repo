package org.howard.edu.lsp.midterm.question4;

import java.util.List;
import java.util.stream.Collectors;

public class WordProcessorDriver {
    public static void main(String[] args) {
        // Test case 1: Sentence with single longest word
        WordProcessor wp1 = new WordProcessor("This is a test with amazing results amazing achievements");
        System.out.println("Test 1 - Longest words: " + formatOutput(wp1.findLongestWords())); // Expected: ["achievements"]

        // Test case 2: Sentence with multiple occurrences of the same longest word and length
        WordProcessor wp2 = new WordProcessor("Java is a powerful powerful tool");
        System.out.println("Test 2 - Longest words: " + formatOutput(wp2.findLongestWords())); // Expected: ["powerful", "powerful"]

        // Test case 3: Sentence with multiple longest words
        WordProcessor wp3 = new WordProcessor("apple banana cherry date");
        System.out.println("Test 3 - Longest words: " + formatOutput(wp3.findLongestWords())); // Expected: ["banana", "cherry"]

        // Test case 4: Sentence with single character words
        WordProcessor wp4 = new WordProcessor("A B C D E");
        System.out.println("Test 4 - Longest words: " + formatOutput(wp4.findLongestWords())); // Expected: ["A", "B", "C", "D", "E"]

        // Test case 5: Empty string input
        WordProcessor wp5 = new WordProcessor("");
        System.out.println("Test 5 - Longest words: " + formatOutput(wp5.findLongestWords())); // Expected: []
    }
    
    // Helper method to format output with double quotes - moved outside of main
    private static String formatOutput(List<String> words) {
        return "[" + words.stream()
            .map(word -> "\"" + word + "\"") // Add double quotes around words
            .collect(Collectors.joining(", ")) + "]";
    }
}