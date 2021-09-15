package Lecture;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] rowsAndColumns = Arrays.stream(sc.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int[][] matrix = new int[rowsAndColumns[0]][rowsAndColumns[1]];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(sc.nextLine().split(",\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }

        int maxSum = 0;

        int bestRow = 0;
        int bestCol = 0;

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int sum =
                matrix[row][col] +
                matrix[row][col + 1] +
                matrix[row + 1][col] +
                matrix[row + 1][col + 1];

                if(sum > maxSum){
                    maxSum = sum;
                    bestRow = row;
                    bestCol = col;
                }

            }
        }
        System.out.println(matrix[bestRow][bestCol] + " " + matrix[bestRow][bestCol + 1]);
        System.out.println(matrix[bestRow + 1][bestCol] + " " + matrix[bestRow + 1][bestCol + 1]);

        System.out.println(maxSum);
    }
}
