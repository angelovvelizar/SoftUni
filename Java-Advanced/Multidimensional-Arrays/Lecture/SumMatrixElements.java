package Lecture;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] rowsAndColumns = Arrays.stream(sc.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int[][] matrix = new int[rowsAndColumns[0]][rowsAndColumns[1]];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(sc.nextLine().split(",\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(rowsAndColumns[0]);
        System.out.println(rowsAndColumns[1]);

        System.out.println(getSum(matrix));
    }

    public static int getSum(int[][] matrix){
        int sum = 0;
        for (int[] arr : matrix) {
            for (int currentElement : arr) {
                sum += currentElement;
            }
        }
        return sum;
    }
}
