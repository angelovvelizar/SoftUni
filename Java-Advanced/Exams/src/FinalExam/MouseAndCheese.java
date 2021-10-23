package FinalExam;

import java.util.Scanner;

public class MouseAndCheese {
    private static int mouseRow;
    private static int mouseCol;
    private static boolean isOut;
    private static int cheeseEaten = 0;



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());

        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {
            matrix[row] = sc.nextLine().toCharArray();
        }

        findMouseStartingPosition(matrix);

        String command = sc.nextLine();
        while(!command.equals("end")){
            switch (command){
                case "up":
                    moveMouse(matrix,mouseRow - 1, mouseCol, command);
                    break;
                case "down":
                    moveMouse(matrix,mouseRow + 1, mouseCol, command);
                    break;
                case "left":
                    moveMouse(matrix,mouseRow, mouseCol - 1, command);
                    break;
                case "right":
                    moveMouse(matrix,mouseRow, mouseCol + 1, command);
                    break;
            }
            if(isOut){
                System.out.println("Where is the mouse?");
                break;
            }
            command = sc.nextLine();
        }

        if(cheeseEaten < 5){
            System.out.println("The mouse couldn't eat the cheeses, she needed " + (5 - cheeseEaten) + " cheeses more.");
        }else{
            System.out.println("Great job, the mouse is fed " + cheeseEaten + " cheeses!");
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

    private static void moveMouse(char[][] matrix, int newRow, int newCol, String command) {
        if(isOutOfBounds(matrix,newRow, newCol)){
            matrix[mouseRow][mouseCol] = '-';
            isOut = true;
            return;
        }

        matrix[mouseRow][mouseCol] = '-';

        if(matrix[newRow][newCol] == 'B'){
            matrix[newRow][newCol] = '-';
            switch (command){
                case "up":
                    newRow -= 1;
                    break;
                case "down":
                    newRow += 1;
                    break;
                case "left":
                    newCol -= 1;
                    break;
                case "right":
                    newCol += 1;
                    break;
            }
        }

        if(matrix[newRow][newCol] == 'c'){
            cheeseEaten++;
        }

        matrix[newRow][newCol] = 'M';
        mouseRow = newRow;
        mouseCol = newCol;
    }

    private static boolean isOutOfBounds(char[][] matrix, int r, int c) {
        return r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length;
    }

    private static void findMouseStartingPosition(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == 'M'){
                    mouseRow = row;
                    mouseCol = col;
                    break;
                }
            }
        }
    }
}
