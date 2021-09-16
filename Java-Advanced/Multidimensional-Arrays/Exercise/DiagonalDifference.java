package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        int[][] matrix = readMatrix(sc, size);

        int primaryDiagonalSum = getPrimaryDiagonalSum(matrix);
        int secondaryDiagonalSum = getSecondaryDiagonalSum(matrix);

        System.out.println(Math.abs(primaryDiagonalSum - secondaryDiagonalSum));



    }

    private static int getSecondaryDiagonalSum(int[][] matrix) {
        int secondaryDiagonalSum = 0;
        int col = 0;
        for (int row = matrix.length - 1; row >= 0; row--) {
            secondaryDiagonalSum += matrix[row][col++];

        }
        return secondaryDiagonalSum;
    }

    private static int getPrimaryDiagonalSum(int[][] matrix) {
        int primaryDiagonalSum = 0;
        int col = 0;
        for (int[] array : matrix) {
            primaryDiagonalSum += array[col++];
        }
        return  primaryDiagonalSum;
    }

    private static int[][] readMatrix(Scanner sc, int size) {
        int[][] matrix = new int[size][size];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return  matrix;
    }
}
