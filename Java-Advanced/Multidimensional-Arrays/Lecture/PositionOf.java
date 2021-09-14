package Lecture;

import java.util.Arrays;
import java.util.Scanner;

public class PositionOf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] rowsAndColumns = readArray(sc.nextLine());
        int[][] matrix = new int[rowsAndColumns[0]][rowsAndColumns[1]];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = readArray(sc.nextLine());
        }

        int numberToFind = Integer.parseInt(sc.nextLine());
        boolean isFound = false;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == numberToFind) {
                    System.out.println(row + " " + col);
                    isFound = true;
                }
            }
        }

        if(!isFound){
            System.out.println("not found");
        }
    }

    public static int[] readArray(String line){
        return Arrays.stream(line.split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }

}
