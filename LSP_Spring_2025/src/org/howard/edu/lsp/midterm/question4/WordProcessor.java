package org.howard.edu.lsp.midterm.question4;

import java.util.*;

public class WordProcessor {
    private String sentence;

    // Constructor
    public WordProcessor(String sentence) {
        this.sentence = sentence;
    }

    // Method to find all longest words in the sentence
    public List<String> findLongestWords() {
        if (sentence == null || sentence.trim().isEmpty()) {
            return new ArrayList<>(); // Return empty list if no valid words
        }
        
        String[] words = sentence.split("\\s+"); // Split sentence by whitespace
        int maxLength = 0;
        List<String> longestWords = new ArrayList<>();
        
        for (String word : words) {
            int length = word.length();
            if (length > maxLength) {
                maxLength = length;
                longestWords.clear(); // Reset list with new max length
                longestWords.add(word);
            } else if (length == maxLength) {
                longestWords.add(word); // Add to list if same max length
            }
        }
        return longestWords;
    }
}
