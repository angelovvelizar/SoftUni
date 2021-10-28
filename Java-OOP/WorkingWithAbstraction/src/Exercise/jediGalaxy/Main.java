package Exercise.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = getAsIntArray(scanner.nextLine());
        int row = dimensions[0];
        int col = dimensions[1];

        int[][] matrix = new int[row][col];

        int valueFromStars = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = valueFromStars++;
            }
        }

        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] ivoPosition = getAsIntArray(command);
            int[] evil = getAsIntArray(scanner.nextLine());
            int evilRow = evil[0];
            int evilCol = evil[1];

            moveEvilPlayer(matrix, evilRow, evilCol);

            int ivoRow = ivoPosition[0];
            int ivoCol = ivoPosition[1];

            sum = moveIvo(matrix, sum, ivoRow, ivoCol);

            command = scanner.nextLine();
        }

        System.out.println(sum);


    }

    private static long moveIvo(int[][] matrix, long sum, int ivoRow, int ivoCol) {
        while (ivoRow >= 0 && ivoCol < matrix[0].length) {
            if (isInBounds(matrix, ivoRow, ivoCol)) {
                sum += matrix[ivoRow][ivoCol];
            }
            ivoCol++;
            ivoRow--;
        }
        return sum;
    }

    private static void moveEvilPlayer(int[][] matrix, int evilRow, int evilCol) {
        while (evilRow >= 0 && evilCol >= 0) {
            if (isInBounds(matrix, evilRow, evilCol)) {
                matrix[evilRow][evilCol] = 0;
            }
            evilRow--;
            evilCol--;
        }
    }

    private static boolean isInBounds(int[][] matrix, int evilRow, int evilCol) {
        return evilRow >= 0 && evilRow < matrix.length && evilCol >= 0 && evilCol < matrix[0].length;
    }

    private static int[] getAsIntArray(String str) {
        return Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
