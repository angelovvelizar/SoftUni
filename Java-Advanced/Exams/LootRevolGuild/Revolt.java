package LootRevolGuild;

import java.util.Scanner;

public class Revolt {
    private static int playerRow;
    private static int playerCol;
    private static boolean hasWon;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = Integer.parseInt(sc.nextLine());
        int commands = Integer.parseInt(sc.nextLine());

        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {
            matrix[row] = sc.nextLine().toCharArray();
        }

        findPlayerPosition(matrix);

        while (commands-- > 0) {
            String command = sc.nextLine();
            switch (command) {
                case "up":
                    move(matrix, playerRow - 1, playerCol, command);
                    break;
                case "down":
                    move(matrix, playerRow + 1, playerCol, command);
                    break;
                case "left":
                    move(matrix, playerRow, playerCol - 1, command);
                    break;
                case "right":
                    move(matrix, playerRow, playerCol + 1, command);
                    break;
            }

            if (hasWon) {
                System.out.println("Player won!");
                break;
            }
        }

        if (!hasWon) {
            System.out.println("Player lost!");
        }

        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char element : row) {
                System.out.print(element);
            }
            System.out.println();
        }
    }

    private static void move(char[][] matrix, int newRow, int newCol, String command) {
        if (isOut(matrix, newRow, newCol)) {
            switch (command) {
                case "up":
                    newRow = matrix.length - 1;
                    break;
                case "down":
                    newRow = 0;
                    break;
                case "left":
                    newCol = matrix[newCol].length - 1;
                    break;
                case "right":
                    newCol = 0;
                    break;
            }
        }

        matrix[playerRow][playerCol] = '-';

        if (matrix[newRow][newCol] == 'T') {
            newRow = playerRow;
            newCol = playerCol;
            matrix[playerRow][playerCol] = 'f';
        } else if (matrix[newRow][newCol] == 'B') {
            switch (command) {
                case "up":
                    newRow--;
                    if (isOut(matrix, newRow, newCol)) {
                        newRow = matrix.length - 1;
                    }
                    break;
                case "down":
                    newRow++;
                    if (isOut(matrix, newRow, newCol)) {
                        newRow = 0;
                    }
                    break;
                case "left":
                    newCol--;
                    if (isOut(matrix, newRow, newCol)) {
                        newCol = matrix[newRow].length - 1;
                    }
                    break;
                case "right":
                    newCol++;
                    if (isOut(matrix, newRow, newCol)) {
                        newCol = 0;
                    }
                    break;
            }

        } else if (matrix[newRow][newCol] == 'F') {
            hasWon = true;
        }

        matrix[newRow][newCol] = 'f';
        playerRow = newRow;
        playerCol = newCol;

    }

    private static boolean isOut(char[][] matrix, int newRow, int newCol) {
        return newRow < 0 || newRow >= matrix.length || newCol < 0 || newCol >= matrix[newRow].length;
    }

    private static void findPlayerPosition(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'f') {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }
    }
}
