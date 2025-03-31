package com.bridgelabz.javastreams.readinput;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadUserInput {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileWriter writer = null;

            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your age: ");
            String age = reader.readLine();

            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();

            String outputFile = "C:\\Users\\DELL\\Desktop\\bridgelabz-workspace\\java-streams\\src\\main\\java\\com\\bridgelabz\\javastreams\\readinput\\userInformation.txt";

            writer = new FileWriter(outputFile);
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Language: " + language + "\n");

            System.out.println("\nUser information saved to userInformation.txt");
        }
        catch (IOException e) {
            System.err.println("IOException caught: " + e.getMessage());
        }
        catch (NumberFormatException e){
            System.err.println("NumberFormatException caught: Invalid age input");
        }
    }
}
