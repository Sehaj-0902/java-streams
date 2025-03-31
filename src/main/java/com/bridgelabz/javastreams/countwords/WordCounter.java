package com.bridgelabz.javastreams.countwords;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordCounter {
    public static void main(String[] args) {
        String filename = "C:\\Users\\DELL\\Desktop\\bridgelabz-workspace\\java-streams\\src\\main\\java\\com\\bridgelabz\\javastreams\\countwords\\input.txt";

        Map<String, Integer> wordCounts = new HashMap<>();
        int totalWordCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().split("[\\s\\p{Punct}]+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                        totalWordCount++;
                    }
                }
            }

            // Sorting words by frequency
            List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCounts.entrySet());
            sortedWords.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

            System.out.println("Total words: " + totalWordCount);

            System.out.println("\nTop 5 most frequent words:");
            for (int i = 0; i < Math.min(5, sortedWords.size()); i++) {
                Map.Entry<String, Integer> entry = sortedWords.get(i);
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

        }
        catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
