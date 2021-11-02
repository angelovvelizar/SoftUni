package Lecture.StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();
        String command = scanner.nextLine();
        while (!command.equals("Exit")) {
            String[] studentInfo = command.split("\\s+");
            String commandName = studentInfo[0];
            String name = studentInfo[1];

            switch (commandName){
                case "Create":
                    int age = Integer.parseInt(studentInfo[2]);
                    double grade = Double.parseDouble(studentInfo[3]);
                    studentSystem.createStudent(name,age,grade);
                    break;
                case "Show":
                    studentSystem.showStudent(name);
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
