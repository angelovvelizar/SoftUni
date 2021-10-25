package FlowerBeeVetClinic;

import java.util.Scanner;

public class Bee {
    private static int beeRow;
    private static int beeCol;
    private static int pollinatedFlowers;
    private static boolean isOut;



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        char[][] matrix = new char[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i] = sc.nextLine().toCharArray();
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == 'B'){
                    beeRow = row;
                    beeCol = col;
                    break;
                }
            }
        }

        String command = sc.nextLine();
        while(!command.equals("End")){
            switch (command){
                case "up":
                    move(matrix, beeRow - 1, beeCol, command);
                    break;
                case "down":
                    move(matrix, beeRow + 1, beeCol, command);
                    break;
                case "left":
                    move(matrix, beeRow, beeCol - 1, command);
                    break;
                case "right":
                    move(matrix, beeRow, beeCol + 1, command);
                    break;
            }
            if(isOut){
                System.out.println("The bee got lost!");
                break;
            }
            command = sc.nextLine();
        }

        if(pollinatedFlowers < 5){
            System.out.println("The bee couldn't pollinate the flowers, she needed " + (5 - pollinatedFlowers) + " flowers more");
        }else{
            System.out.println("Great job, the bee manage to pollinate " + pollinatedFlowers + " flowers!");
        }

        printMatrix(matrix);

    }

    private static void move(char[][] matrix, int newRow, int newCol, String command) {
        if(isOut(matrix,newRow, newCol)){
            matrix[beeRow][beeCol] = '.';
            isOut = true;
            return;
        }

        matrix[beeRow][beeCol] = '.';

        if(matrix[newRow][newCol] == 'f'){
            pollinatedFlowers++;
        }else if(matrix[newRow][newCol] == 'O'){
            matrix[newRow][newCol] = '.';
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
            if(matrix[newRow][newCol] == 'f'){
                pollinatedFlowers++;
            }
        }
        matrix[newRow][newCol] = 'B';
        beeRow = newRow;
        beeCol = newCol;
    }

    private static boolean isOut(char[][] matrix, int newRow, int newCol) {
        return newRow < 0 || newRow >= matrix.length || newCol < 0 || newCol >= matrix[newRow].length;
    }

    private static void printMatrix(char[][] matrix){
        for(char[] row : matrix){
            for (char element : row) {
                System.out.print(element);
            }
            System.out.println();
        }
    }
}
