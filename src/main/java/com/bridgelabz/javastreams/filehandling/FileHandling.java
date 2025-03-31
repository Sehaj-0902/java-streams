package com.bridgelabz.javastreams.filehandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileHandling {
    public static void main(String[] args) throws IOException {
        String sourceFile = "C:\\Users\\DELL\\Desktop\\bridgelabz-workspace\\java-streams\\src\\main\\java\\com\\bridgelabz\\javastreams\\filehandling\\input.txt";
        String destinationFile = "C:\\Users\\DELL\\Desktop\\bridgelabz-workspace\\java-streams\\src\\main\\java\\com\\bridgelabz\\javastreams\\filehandling\\output.txt";

        try {
                FileInputStream fis = new FileInputStream(sourceFile);
                FileOutputStream fos = new FileOutputStream(destinationFile);

            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
            System.out.println("File copied successfully.");
        }
        catch (FileNotFoundException e) {
            System.out.println("IOException caught: " + e.getMessage());
        }
    }
}
