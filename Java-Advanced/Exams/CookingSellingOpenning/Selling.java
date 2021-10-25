package CookingSellingOpenning;

import java.util.Scanner;

public class Selling {
    private static int sellerRow;
    private static int sellerCol;
    private static int moneyCollected;
    private static int firsPillarRow;
    private static int firsPillarCol;
    private static int secondPillarRow;
    private static int secondPillarCol;
    private static boolean isOut;



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());

        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {
            matrix[row] = sc.nextLine().toCharArray();
        }

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if(matrix[row][col] == 'S'){
                    sellerRow = row;
                    sellerCol = col;
                }else if(matrix[row][col] == 'O'){
                    secondPillarRow = row;
                    secondPillarCol = col;
                }
            }
        }

        for (int row = 0; row <= secondPillarRow; row++) {
            for (int col = 0; col < secondPillarCol; col++) {
                if(matrix[row][col] == 'O'){
                    firsPillarRow = row;
                    firsPillarCol = col;
                }
            }
        }

        while(moneyCollected < 50){
            String command = sc.nextLine();
            switch (command){
                case "up":
                    move(matrix, sellerRow - 1, sellerCol);
                    break;
                case "down":
                    move(matrix,sellerRow + 1, sellerCol);
                    break;
                case "left":
                    move(matrix,sellerRow, sellerCol - 1);
                    break;
                case "right":
                    move(matrix,sellerRow, sellerCol + 1);
                    break;
            }
            if(isOut){
                System.out.println("Bad news, you are out of the bakery.");
                System.out.println("Money: " + moneyCollected);
                printMatrix(matrix);
                return;
            }
        }


        System.out.println("Good news! You succeeded in collecting enough money!");
        System.out.println("Money: " + moneyCollected);
        printMatrix(matrix);

    }

    private static void move(char[][] matrix, int newRow, int newCol) {
        if(isOutOfBounds(matrix,newRow, newCol)){
            isOut = true;
            matrix[sellerRow][sellerCol] = '-';
            return;
        }

        matrix[sellerRow][sellerCol] = '-';

        if(matrix[newRow][newCol] == 'O' && newRow == firsPillarRow && newCol == firsPillarCol){
            matrix[firsPillarRow][firsPillarCol] = '-';
            sellerRow = secondPillarRow;
            sellerCol = secondPillarCol;
            matrix[sellerRow][sellerCol] = 'S';
        }else if(matrix[newRow][newCol] == 'O' && newRow == secondPillarRow && newCol == secondPillarCol){
            matrix[secondPillarRow][secondPillarCol] = '-';
            sellerRow = firsPillarRow;
            sellerCol = firsPillarCol;
            matrix[sellerRow][sellerCol] = 'S';
        }else if(Character.isDigit(matrix[newRow][newCol])){
            moneyCollected += Character.getNumericValue(matrix[newRow][newCol]);
            //matrix[newRow][newCol] = '-';
            sellerRow = newRow;
            sellerCol = newCol;
            matrix[newRow][newCol] = 'S';
        }else{
            sellerRow = newRow;
            sellerCol = newCol;
            matrix[newRow][newCol] = 'S';
        }



    }

    private static boolean isOutOfBounds(char[][] matrix, int row, int col){
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }


    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char e : row) {
                System.out.print(e);
            }
            System.out.println();
        }
    }
}
