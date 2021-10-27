package Lecture;

import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());

        String rombOfStars = buildRombsOfStars(size);
        System.out.println(rombOfStars);

    }

    private static String buildRombsOfStars(int size) {
        StringBuilder out = new StringBuilder();
        for (int r = 1; r <= size; r++) {
            out.append(printRow(size -r, r)).append(System.lineSeparator());
        }

        for (int r = size - 1; r > 0 ; r--) {
            out.append(printRow(size - r, r)).append(System.lineSeparator());
        }

        return out.toString();
    }

    private static String printRow(int spaces, int stars) {
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < spaces; i++) {
            out.append(" ");
        }

        for (int i = 0; i < stars; i++) {
            out.append("* ");
        }

        return out.toString();
    }


}
