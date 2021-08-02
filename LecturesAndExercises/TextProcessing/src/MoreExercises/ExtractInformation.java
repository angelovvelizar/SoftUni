package MoreExercises;

import java.util.Scanner;

public class ExtractInformation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            int nameStartIndex = input.indexOf("@");
            int nameEndIndex = input.indexOf("|");
            String name = input.substring(nameStartIndex + 1,nameEndIndex);
            int ageStartIndex = input.indexOf("#");
            int ageEndIndex = input.indexOf("*");
            String age = input.substring(ageStartIndex + 1, ageEndIndex);
            System.out.println(name + " is " + age + " years old.");
        }
    }
}
