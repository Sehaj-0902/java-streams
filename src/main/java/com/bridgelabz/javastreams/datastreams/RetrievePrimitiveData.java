package com.bridgelabz.javastreams.datastreams;

import java.io.*;

public class RetrievePrimitiveData {
    public static void main(String[] args) {
        String filename = "C:\\Users\\DELL\\Desktop\\bridgelabz-workspace\\java-streams\\src\\main\\java\\com\\bridgelabz\\javastreams\\datastreams\\studentDetails.bin";

        // Storing student data
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
            dos.writeInt(101);
            dos.writeUTF("Sehaj");
            dos.writeDouble(3.8);

            dos.writeInt(102);
            dos.writeUTF("Sanya");
            dos.writeDouble(3.9);

            System.out.println("Student data stored successfully.");

        }
        catch (IOException e) {
            System.err.println("Error storing data: " + e.getMessage());
        }

        // Retrieving student data
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
            System.out.println("\nRetrieved Student Data:");

            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();

                System.out.println("Roll Number: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
            }

        }
        catch (EOFException e) {
            //This is handled by the available() check above.
        }
        catch (IOException e) {
            System.err.println("Error retrieving data: " + e.getMessage());
        }
    }
}
