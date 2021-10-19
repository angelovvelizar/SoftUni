package BombsSnakeParking;

import java.util.Scanner;

public class Snake {
    private static int snakeRow;
    private static int snakeCol;
    private static int firstBurrowRow = -1;
    private static int firstBurrowCol;
    private static int secondBurrowRow;
    private static int secondBurrowCol;
    private static boolean isOut;
    private static int foodEaten = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());

        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {
            matrix[row] = sc.nextLine().toCharArray();
        }

        findSnakeAndBurrows(matrix);

        while (foodEaten < 10){
            String command = sc.nextLine();
            switch (command){
                case "up":
                    moveSnake(matrix, snakeRow - 1, snakeCol);
                    break;
                case "down":
                    moveSnake(matrix,snakeRow + 1, snakeCol);
                    break;
                case "left":
                    moveSnake(matrix, snakeRow, snakeCol - 1);
                    break;
                case "right":
                    moveSnake(matrix, snakeRow, snakeCol + 1);
                    break;
            }
            if(isOut){
                System.out.println("Game over!");
                break;
            }
        }

        if(!isOut && foodEaten >= 10){
            System.out.println("You won! You fed the snake.");
        }
        System.out.println("Food eaten: " + foodEaten);
        
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

    private static void moveSnake(char[][] matrix, int newRow, int newCol) {
        if(isOut(matrix,newRow,newCol)){
            matrix[snakeRow][snakeCol] = '.';
            isOut = true;
            return;
        }

        matrix[snakeRow][snakeCol] = '.';
        if(matrix[newRow][newCol] == 'B'){
            matrix[newRow][newCol] = '.';
            newRow = secondBurrowRow;
            newCol = secondBurrowCol;
        }else if(matrix[newRow][newCol] == '*'){
            foodEaten++;
            matrix[newRow][newCol] = 'S';
        }

        matrix[newRow][newCol] = 'S';
        snakeRow = newRow;
        snakeCol = newCol;



    }

    private static boolean isOut(char[][] matrix, int newRow, int newCol) {
        return newRow < 0 || newRow >= matrix.length || newCol < 0 || newCol >= matrix[newRow].length;
    }

    private static void findSnakeAndBurrows(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == 'S'){
                    snakeRow = row;
                    snakeCol = col;
                }
                if(matrix[row][col] == 'B' && firstBurrowRow == -1){
                    firstBurrowRow = row;
                    firstBurrowCol = col;
                }else if(matrix[row][col] == 'B' && firstBurrowRow != -1){
                    secondBurrowRow = row;
                    secondBurrowCol = col;
                }
            }
        }
    }
}
