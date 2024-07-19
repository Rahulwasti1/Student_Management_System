package com.example.assignment;

import java.util.Scanner;

import static com.example.assignment.Static.RandomIDGenerator.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Press Enter: ");
            scanner.nextLine();
            System.out.println(generateRandomStudentId());
            System.out.println(generateRandomTeacherId());
            System.out.println(generateRandomStaffId());
        }
    }
}
