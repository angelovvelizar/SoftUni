package MagicBombCar;

import java.util.Scanner;

public class Bomb {
    private static int sapperRow;
    private static int sapperCol;
    private static int bombs = 0;
    private static boolean hasEnded = false;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        char[][] matrix = new char[size][size];

        String[] commands = sc.nextLine().split(",");

        for (int row = 0; row < size; row++) {
            matrix[row] = sc.nextLine().replace(" ", "").toCharArray();
        }
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 's') {
                    sapperRow = row;
                    sapperCol = col;
                } else if (matrix[row][col] == 'B') {
                    bombs++;
                }
            }
        }

        for (String command : commands) {
            switch (command) {
                case "up":
                    if(!ensureMove(matrix,sapperRow - 1, sapperCol)){
                        printEnd();
                    }
                    break;
                case "down":
                    if(!ensureMove(matrix,sapperRow + 1, sapperCol)){
                        printEnd();
                    }
                    break;
                case "left":
                    if(!ensureMove(matrix,sapperRow, sapperCol - 1)){
                        printEnd();
                    }
                    break;
                case "right":
                    if(!ensureMove(matrix,sapperRow, sapperCol + 1)){
                        printEnd();
                    }
                    break;
            }

            if(hasEnded){
                return;
            }
            if (bombs <= 0) {
                System.out.println("Congratulations! You found all bombs!");
                return;
            }
        }
        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", bombs, sapperRow, sapperCol);

    }


    private static void printEnd() {
        System.out.println("END! " + bombs + " bombs left on the field");
    }

    private static boolean ensureMove(char[][] matrix, int newRow, int newCol){
        if (isOutOfBounds(matrix, newRow, newCol)) {
            return true;
        }
        if (matrix[newRow][newCol] == 'B') {
            bombs--;
            System.out.println("You found a bomb!");
            matrix[newRow][newCol] = '+';
        } else if (matrix[newRow][newCol] == 'e') {
            hasEnded = true;
            return false;
        }

        sapperRow = newRow;
        sapperCol = newCol;
        return true;
    }

    private static boolean isOutOfBounds(char[][] matrix, int row, int col) {

        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char e : row) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}