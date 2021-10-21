package DatingBookRabbits;

import java.util.Scanner;

public class BookWorm {
    private static int playerRow;
    private static int playerCol;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder text = new StringBuilder(sc.nextLine());

        int size = Integer.parseInt(sc.nextLine());

        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {
            matrix[row] = sc.nextLine().toCharArray();
        }

        findPlayerPosition(size, matrix);

        String command = sc.nextLine();
        while(!command.equals("end")){
            switch (command){
                case "up":
                    move(matrix,playerRow - 1, playerCol, text);
                    break;
                case "down":
                    move(matrix,playerRow + 1, playerCol, text);
                    break;
                case "left":
                    move(matrix,playerRow, playerCol - 1, text);
                    break;
                case "right":
                    move(matrix,playerRow, playerCol + 1, text);
                    break;
            }
            command = sc.nextLine();
        }

        System.out.println(text);
        for (char[] row : matrix) {
            for (char element : row) {
                System.out.print(element);
            }
            System.out.println();
        }
    }

    private static void move(char[][] matrix, int newRow, int newCol, StringBuilder text) {
        if(isOut(matrix,newRow,newCol)){
            if(text.length() > 0) {
                text.delete(text.length() - 1, text.length());
            }
            newRow = playerRow;
            newCol = playerCol;
            return;
        }

        matrix[playerRow][playerCol] = '-';

        if(Character.isLetter(matrix[newRow][newCol])){
            text.append(matrix[newRow][newCol]);
        }

        matrix[newRow][newCol] = 'P';
        playerRow = newRow;
        playerCol = newCol;


    }

    private static boolean isOut(char[][] matrix, int newRow, int newCol) {
        return newRow < 0 || newRow >= matrix.length || newCol < 0 || newCol >= matrix[newRow].length;
    }

    private static void findPlayerPosition(int size, char[][] matrix) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if(matrix[row][col] == 'P'){
                    playerRow = row;
                    playerCol = col;
                }
            }
        }
    }
}
