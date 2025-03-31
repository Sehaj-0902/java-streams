package com.bridgelabz.javastreams.filterstreams;

import java.io.*;

public class UppercaseToLowercase {
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\DELL\\Desktop\\bridgelabz-workspace\\java-streams\\src\\main\\java\\com\\bridgelabz\\javastreams\\filterstreams\\input.txt";
        String outputFile = "C:\\Users\\DELL\\Desktop\\bridgelabz-workspace\\java-streams\\src\\main\\java\\com\\bridgelabz\\javastreams\\filterstreams\\output.txt";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF-8"));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"))) {

            int character;
            while ((character = reader.read()) != -1) {
                writer.write(Character.toLowerCase(character));
            }

            System.out.println("File converted successfully.");

        }
        catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }
}
