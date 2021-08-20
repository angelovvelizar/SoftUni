package ForLoop.MoreExercises;

import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int students = Integer.parseInt(sc.nextLine());

        int topStudents = 0;
        int studentsBetween3and4 = 0;
        int studentsBetween4and5 = 0;
        int failedStudents = 0;
        double gradesSum = 0;
        for (int i = 0; i < students; i++) {
            double grade = Double.parseDouble(sc.nextLine());
            if(grade >= 5.00){
                topStudents++;
            }else if(grade >= 4.00 && grade <= 4.99){
                studentsBetween4and5++;
            }else if(grade >= 3.00 && grade <= 3.99){
                studentsBetween3and4++;
            }else{
                failedStudents++;
            }
            gradesSum += grade;
        }
        double topPercent = (double)topStudents / students * 100;
        double between4and5Percent = (double)studentsBetween4and5 / students * 100;
        double between3and4Percent = (double)studentsBetween3and4 / students * 100;
        double failedPercent = (double) failedStudents / students * 100;
        double average = gradesSum / students;

        System.out.printf("Top students: %.2f%%%n", topPercent);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n", between4and5Percent);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n", between3and4Percent);
        System.out.printf("Fail: %.2f%%%n", failedPercent);
        System.out.printf("Average: %.2f", average);

    }
}
