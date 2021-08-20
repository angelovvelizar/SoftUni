package ForLoop;

import java.util.Scanner;

public class EvenOddPositions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        double sumOdd = 0;
        double sumEven = 0;
        double oddMin = Integer.MAX_VALUE;
        double oddMax = Integer.MIN_VALUE;
        double evenMin = Integer.MAX_VALUE;
        double evenMax = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            double number = Double.parseDouble(sc.nextLine());
            if (i % 2 == 0) {
                sumEven += number;
                if (number > evenMax) {
                    evenMax = number;
                }
                if (number < evenMin) {
                    evenMin = number;
                }
            } else {
                sumOdd += number;
                if (number > oddMax) {
                    oddMax = number;
                }
                if (number < oddMin) {
                    oddMin = number;
                }
            }

        }
        System.out.printf("OddSum=%.2f,%n", sumOdd);
        if (n < 2 && oddMin % 2 == 0 && oddMax % 2 == 0 || n == 0) {
            System.out.printf("OddMin=No,%n");
            System.out.printf("OddMax=No,%n");
        } else {
            System.out.printf("OddMin=%.2f,%n", oddMin);
            System.out.printf("OddMax=%.2f,%n", oddMax);
        }
        System.out.printf("EvenSum=%.2f,%n", sumEven);
        if (n < 2 && oddMax % 2 != 0 && oddMin % 2 != 0 || n == 0) {
            System.out.printf("EvenMin=No,%n");
            System.out.printf("EvenMax=No%n");
        } else {
            System.out.printf("EvenMin=%.2f,%n", evenMin);
            System.out.printf("EvenMax=%.2f%n", evenMax);
        }
    }
}
