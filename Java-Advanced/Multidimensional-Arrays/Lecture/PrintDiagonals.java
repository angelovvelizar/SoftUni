package Lecture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PrintDiagonals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int matrixSize = Integer.parseInt(sc.nextLine());

        int[][] matrix = new int[matrixSize][matrixSize];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }

        int col = 1;
        System.out.print(matrix[0][0] + " ");

        for (int row = 0; row < matrix.length - 1; row++) {
            int elementToAdd = matrix[row + 1][col];
            System.out.print(elementToAdd + " ");
            col++;
        }

        System.out.println();

        col = 0;

        for (int row = matrix.length - 1; row >= 0; row--) {
            int elementToAdd = matrix[row][col];
            System.out.print(elementToAdd + " ");
            col++;
        }

    }
}
