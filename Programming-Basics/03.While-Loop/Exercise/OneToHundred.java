package WhileLoop.Exercise;

import java.util.Scanner;

public class OneToHundred {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        double sum = 0;
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(sc.nextLine());
            sum += number;
        }
        double average = sum / n;
        System.out.printf("%.2f", average);
    }
}
