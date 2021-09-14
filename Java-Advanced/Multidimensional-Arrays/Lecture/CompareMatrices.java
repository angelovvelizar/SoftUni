package Lecture;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] rowsAndColumns = readArray(sc.nextLine());

        int[][] firstMatrix = readMatrix(sc, rowsAndColumns);

        rowsAndColumns = readArray(sc.nextLine());


        int[][] secondMatrix = readMatrix(sc, rowsAndColumns);

        if (matricesAreEqual(firstMatrix, secondMatrix)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }

    }

    public static boolean matricesAreEqual(int[][] first, int[][] second) {
        if (first.length != second.length) {
            return false;
        }

        for (int row = 0; row < first.length; row++) {
            int[] firstArray = first[row];
            int[] secondArray = second[row];
            if (firstArray.length != secondArray.length) {
                return false;
            }

            for (int col = 0; col < firstArray.length; col++) {
                if (firstArray[col] != secondArray[col]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[][] readMatrix(Scanner sc, int[] rowsAndColumns) {
        int[][] matrix = new int[rowsAndColumns[0]][rowsAndColumns[1]];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = readArray(sc.nextLine());
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static int[] readArray(String line) {
        return Arrays.stream(line.split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }

}
