package PlanningPythonGrooming;

import java.util.Arrays;
import java.util.Scanner;

public class Python {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());

        String[][] matrix = new String[size][size];

        String[] commands = sc.nextLine().split(", ");

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = sc.nextLine().split("\\s+");
        }

        int currentRow = 0;
        int currentCol = 0;

        int countOfFood = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("s")) {
                    currentRow = row;
                    currentCol = col;
                } else if (matrix[row][col].equals("f")) {
                    countOfFood++;
                }
            }
        }

        int length = 1;
        for (String currentCommand : commands) {
            switch (currentCommand) {
                case "up":
                    if (isInBounds(matrix, currentRow - 1)) {
                        currentRow -= 1;
                    } else {
                        currentRow = matrix.length - 1;
                    }

                    if (matrix[currentRow][currentCol].equals("f")) {
                        length++;
                        countOfFood--;
                        if (anyFoodLeft(countOfFood, length)) return;
                    }

                    if (steppedOnEnemy(matrix, currentRow, currentCol)) {
                        return;
                    }

                    break;
                case "down":
                    if (isInBounds(matrix, currentRow + 1)) {
                        currentRow += 1;
                    } else {
                        currentRow = 0;
                    }

                    if (matrix[currentRow][currentCol].equals("f")) {
                        length++;
                        countOfFood--;
                        if (anyFoodLeft(countOfFood, length)) return;
                    }

                    if (steppedOnEnemy(matrix, currentRow, currentCol)) {
                        return;
                    }

                    break;
                case "left":
                    if (isInBounds(matrix, currentCol - 1)) {
                        currentCol -= 1;
                    } else {
                        currentCol = matrix.length - 1;
                    }

                    if (matrix[currentRow][currentCol].equals("f")) {
                        length++;
                        countOfFood--;
                        if (anyFoodLeft(countOfFood, length)) return;
                    }

                    if (steppedOnEnemy(matrix, currentRow, currentCol)) {
                        return;
                    }

                    break;
                case "right":
                    if (isInBounds(matrix, currentCol + 1)) {
                        currentCol += 1;
                    } else {
                        currentCol = 0;
                    }

                    if (matrix[currentRow][currentCol].equals("f")) {
                        length++;
                        countOfFood--;
                        if (anyFoodLeft(countOfFood, length)) return;
                    }

                    if (steppedOnEnemy(matrix, currentRow, currentCol)) {
                        return;
                    }
                    break;
            }
        }

        System.out.println("You lose! There is still " + countOfFood + " food to be eaten.");
    }

    private static boolean anyFoodLeft(int countOfFood, int length) {
        if (countOfFood <= 0) {
            System.out.println("You win! Final python length is " + length);
            return true;
        }
        return false;
    }

    private static boolean steppedOnEnemy(String[][] matrix, int currentRow, int currentCol) {
        if (matrix[currentRow][currentCol].equals("e")) {
            System.out.println("You lose! Killed by an enemy!");
            return true;
        }
        return false;
    }

    private static boolean isInBounds(String[][] matrix, int index) {
        return index >= 0 && index < matrix.length;
    }
}
