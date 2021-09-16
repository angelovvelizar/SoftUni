package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] rowsAndColumns = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int rows = rowsAndColumns[0];
        int cols = rowsAndColumns[1];

        String[][] matrix = new String[rows][cols];
        char startLetter = 'a';

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                String palindrome = "" + startLetter + (char)(startLetter + col) + startLetter;
                matrix[row][col] = palindrome;
            }
            startLetter++;
        }
        printMatrix(matrix);

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
