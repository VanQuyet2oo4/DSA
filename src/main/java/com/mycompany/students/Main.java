/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.students;

/**
 *
 * @author PC DMX
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyList studentList = new MyList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display Students");
            System.out.println("5. Sort Students by Marks (Bubble Sort)");
            System.out.println("6. Sort Students by Marks (Selection Sort)");
            System.out.println("7. Search Student by ID");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume leftover newline

                switch (choice) {
                    case 1 -> addStudent(scanner, studentList);
                    case 2 -> editStudent(scanner, studentList);
                    case 3 -> deleteStudent(scanner, studentList);
                    case 4 -> studentList.displayStudents();
                    case 5 -> {
                        studentList.sortStudents(); // Bubble Sort
                        System.out.println("Students sorted by marks using Bubble Sort.");
                    }
                    case 6 -> {
                        studentList.selectionSortStudents(); // Selection Sort
                        System.out.println("Students sorted by marks using Selection Sort.");
                    }
                    case 7 -> searchStudent(scanner, studentList);
                    case 8 -> {
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Invalid choice. Please select from 1 to 8.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 8.");
                scanner.nextLine(); // Consume invalid input
            }
        }
    }

    private static void addStudent(Scanner scanner, MyList studentList) {
        String id = getValidatedString(scanner, "Enter ID (numbers only): ", "\\d+");
        String fullName = getValidatedString(scanner, "Enter full name (letters and spaces only, max 30 characters): ", "[a-zA-Z ]{1,30}");
        double marks = getValidatedDouble(scanner, "Enter marks (1.0 to 10.0): ", 1.0, 10.0);

        studentList.addStudent(new Students(id, fullName, marks));
        System.out.println("Student added successfully.");
    }

    private static void editStudent(Scanner scanner, MyList studentList) {
        String id = getValidatedString(scanner, "Enter ID to edit (numbers only): ", "\\d+");
        String fullName = getValidatedString(scanner, "Enter new full name (letters and spaces only, max 30 characters): ", "[a-zA-Z ]{1,30}");
        double marks = getValidatedDouble(scanner, "Enter new marks (1.0 to 10.0): ", 1.0, 10.0);

        studentList.editStudent(id, fullName, marks);
        System.out.println("Student details updated successfully.");
    }

    private static void deleteStudent(Scanner scanner, MyList studentList) {
        String id = getValidatedString(scanner, "Enter ID to delete (numbers only): ", "\\d+");
        studentList.deleteStudent(id);
    }

    private static void searchStudent(Scanner scanner, MyList studentList) {
        String id = getValidatedString(scanner, "Enter ID to search (numbers only): ", "\\d+");
        Students foundStudent = studentList.searchStudent(id);
        if (foundStudent != null) {
            System.out.println("Found: " + foundStudent);
        } else {
            System.out.println("Student not found.");
        }
    }

    private static String getValidatedString(Scanner scanner, String prompt, String regex) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (input.matches(regex)) {
                return input;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    private static double getValidatedDouble(Scanner scanner, String prompt, double min, double max) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                double input = scanner.nextDouble();
                scanner.nextLine(); // Consume leftover newline
                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.out.println("Invalid range. Please enter a value between " + min + " and " + max + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.next(); // Consume invalid input
            }
        }
    }
}