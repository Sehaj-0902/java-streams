package com.bridgelabz.javastreams.serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Employee implements Serializable {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', department='" + department + "', salary=" + salary + '}';
    }
}

public class EmployeeSerialization {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Sehaj", "Sales", 55000.0));
        employees.add(new Employee(2, "Sanya", "Engineering", 70000.0));
        employees.add(new Employee(3, "Shruti", "HR", 60000.0));

        String filename = "C:\\Users\\DELL\\Desktop\\bridgelabz-workspace\\java-streams\\src\\main\\java\\com\\bridgelabz\\javastreams\\serialization\\employees.ser";

        // Serializing the list
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(employees);
            System.out.println("Employees serialized successfully.");
        }
        catch (IOException e) {
            System.err.println("Error serializing employees: " + e.getMessage());
        }

        // Deserializing the list
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            List<Employee> deserializedEmployees = (List<Employee>) ois.readObject();
            System.out.println("Deserialized Employees:");
            for (Employee employee : deserializedEmployees) {
                System.out.println(employee);
            }
        }
        catch (IOException | ClassNotFoundException e) {
            System.err.println("Error deserializing employees: " + e.getMessage());
        }
    }
}
