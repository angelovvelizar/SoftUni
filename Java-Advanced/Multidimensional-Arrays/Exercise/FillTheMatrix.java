package Exercise;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(", ");

        int size = Integer.parseInt(input[0]);

        String matrixFillType = input[1];
        int[][] matrix = new int[size][size];

        //int elementToAdd = 1;

        if (matrixFillType.equals("A")) {
            fillPatternA(matrix, size);
        } else if (matrixFillType.equals("B")) {
           fillPatternB(matrix, size);
        }

        printMatrix(matrix);


    }

    private static void fillPatternB(int[][] matrix, int size) {
        int elementToAdd = 1;
        for (int col = 0; col < size; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = elementToAdd++;
                }
            }else{
                for (int row = size - 1 ; row >= 0; row--) {
                    matrix[row][col] = elementToAdd++;
                }
            }
        }

    }

    private static void fillPatternA(int[][] matrix, int size) {
        int elementToAdd = 1;
        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                matrix[row][col] = elementToAdd++;

            }
            
        }

    }

    private static void printMatrix(int[][] matrix){
        for (int[] array : matrix) {
            for (int element : array) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
