package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] rowsAndColumns = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int rows = rowsAndColumns[0];
        int cols = rowsAndColumns[1];

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = sc.nextLine().split("\\s+");
        }

        String command = sc.nextLine();

        while (!command.equals("END")) {
            String[] commandData = command.split("\\s+");
            if (commandData[0].equals("swap") && commandData.length == 5){
                int row1Coordinates = Integer.parseInt(commandData[1]);
                int col1Coordinates = Integer.parseInt(commandData[2]);
                int row2Coordinates = Integer.parseInt(commandData[3]);
                int col2Coordinates = Integer.parseInt(commandData[4]);

                if(isInBounds(matrix,row1Coordinates,col1Coordinates,row2Coordinates,col2Coordinates)){
                    swapMatrixElements(matrix, row1Coordinates, col1Coordinates, row2Coordinates, col2Coordinates);
                    printMatrix(matrix);
                }else{
                    System.out.println("Invalid input!");
                }
            }else{
                System.out.println("Invalid input!");
            }
                command = sc.nextLine();
        }
    }

    private static String[][] swapMatrixElements(String[][] matrix, int row1Coordinates, int col1Coordinates,
                                                 int row2Coordinates, int col2Coordinates) {
        String temp = matrix[row1Coordinates][col1Coordinates];
        matrix[row1Coordinates][col1Coordinates] = matrix[row2Coordinates][col2Coordinates];
        matrix[row2Coordinates][col2Coordinates] = temp;
        return matrix;
    }

    private static boolean isInBounds(String[][] matrix, int firstRow, int firstCol, int secondRow, int secondCol) {
        boolean isInBound = true;

        if (firstRow < 0 || firstRow >= matrix.length) {
            isInBound = false;
        }else{
            if(firstCol < 0 || firstCol >= matrix[firstRow].length){
                isInBound = false;
            }
        }

        if (secondRow < 0 || secondRow >= matrix.length) {
            isInBound = false;
        }else{
            if(secondCol < 0 || secondCol >= matrix[secondRow].length){
                isInBound = false;
            }
        }
        return isInBound;
    }

    private static void printMatrix(String[][] matrix){
        for (String[] array : matrix) {
            for (String element : array) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
