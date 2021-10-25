package BoquetsCookingUniversity;

import java.util.Scanner;

public class CookingJourney {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());

        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {
            matrix[row] = sc.nextLine().toCharArray();
        }

        int currentRow = 0;
        int currentCol = 0;

        int firstPillarRow = 0;
        int firstPillarCol = 0;

        int secondPillarRow = -1;
        int secondPillarCol = -1;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrix[row][col] == 'S') {
                    currentRow = row;
                    currentCol = col;
                } else if (matrix[row][col] == 'P') {
                    secondPillarRow = row;
                    secondPillarCol = col;
                }
            }
        }

        if (secondPillarRow != -1) {
            for (int row = 0; row <= secondPillarRow; row++) {
                for (int col = 0; col < secondPillarCol; col++) {
                    if (matrix[row][col] == 'P') {
                        firstPillarRow = row;
                        firstPillarCol = col;
                        break;
                    }
                }
            }
        }

        int dollarsMade = 0;


        while (true) {
            String command = sc.nextLine();
            switch (command) {
                case "up":
                    if (!isInBounds(matrix, currentRow - 1)) {
                        matrix[currentRow][currentCol] = '-';
                        printOutMessage(matrix, dollarsMade);
                        return;
                    }
                    matrix[currentRow][currentCol] = '-';
                    currentRow -= 1;

                    if(currentRow == firstPillarRow && currentCol == firstPillarCol && matrix[currentRow][currentCol] == 'P'){
                        currentRow = secondPillarRow;
                        currentCol = secondPillarCol;
                        matrix[firstPillarRow][firstPillarCol] = '-';
                        matrix[secondPillarRow][secondPillarCol] = '-';
                    }else if(currentRow == secondPillarRow && currentCol == secondPillarCol && matrix[currentRow][currentCol] == 'P'){
                        currentRow = firstPillarRow;
                        currentCol = firstPillarCol;
                        matrix[firstPillarRow][firstPillarCol] = '-';
                        matrix[secondPillarRow][secondPillarCol] = '-';
                    }else if(Character.isDigit(matrix[currentRow][currentCol])){
                        dollarsMade = getDollarsMade(matrix, currentRow, currentCol, dollarsMade);
                    }
                    matrix[currentRow][currentCol] = 'S';
                    break;
                case "down":
                    if (!isInBounds(matrix, currentRow + 1)) {
                        matrix[currentRow][currentCol] = '-';
                        printOutMessage(matrix, dollarsMade);
                        return;
                    }
                    matrix[currentRow][currentCol] = '-';
                    currentRow += 1;

                    if(currentRow == firstPillarRow && currentCol == firstPillarCol && matrix[currentRow][currentCol] == 'P'){
                        currentRow = secondPillarRow;
                        currentCol = secondPillarCol;
                        matrix[firstPillarRow][firstPillarCol] = '-';
                        matrix[secondPillarRow][secondPillarCol] = '-';
                    }else if(currentRow == secondPillarRow && currentCol == secondPillarCol && matrix[currentRow][currentCol] == 'P'){
                        currentRow = firstPillarRow;
                        currentCol = firstPillarCol;
                        matrix[firstPillarRow][firstPillarCol] = '-';
                        matrix[secondPillarRow][secondPillarCol] = '-';
                    }else if(Character.isDigit(matrix[currentRow][currentCol])){
                        dollarsMade = getDollarsMade(matrix, currentRow, currentCol, dollarsMade);
                    }
                    matrix[currentRow][currentCol] = 'S';
                    break;
                case "left":
                    if (!isInBounds(matrix, currentCol - 1)) {
                        matrix[currentRow][currentCol] = '-';
                        printOutMessage(matrix,dollarsMade);
                        return;
                    }
                    matrix[currentRow][currentCol] = '-';
                    currentCol -= 1;

                    if(currentRow == firstPillarRow && currentCol == firstPillarCol && matrix[currentRow][currentCol] == 'P'){
                        currentRow = secondPillarRow;
                        currentCol = secondPillarCol;
                        matrix[firstPillarRow][firstPillarCol] = '-';
                        matrix[secondPillarRow][secondPillarCol] = '-';
                    }else if(currentRow == secondPillarRow && currentCol == secondPillarCol && matrix[currentRow][currentCol] == 'P'){
                        currentRow = firstPillarRow;
                        currentCol = firstPillarCol;
                        matrix[firstPillarRow][firstPillarCol] = '-';
                        matrix[secondPillarRow][secondPillarCol] = '-';
                    }else if(Character.isDigit(matrix[currentRow][currentCol])){
                        dollarsMade = getDollarsMade(matrix, currentRow, currentCol, dollarsMade);
                    }
                    matrix[currentRow][currentCol] = 'S';
                    break;
                case "right":
                    if (!isInBounds(matrix, currentCol + 1)) {
                        matrix[currentRow][currentCol] = '-';
                        printOutMessage(matrix,dollarsMade);
                        return;
                    }
                    matrix[currentRow][currentCol] = '-';
                    currentCol += 1;

                    if(currentRow == firstPillarRow && currentCol == firstPillarCol && matrix[currentRow][currentCol] == 'P'){
                        currentRow = secondPillarRow;
                        currentCol = secondPillarCol;
                        matrix[firstPillarRow][firstPillarCol] = '-';
                        matrix[secondPillarRow][secondPillarCol] = '-';
                    }else if(currentRow == secondPillarRow && currentCol == secondPillarCol && matrix[currentRow][currentCol] == 'P'){
                        currentRow = firstPillarRow;
                        currentCol = firstPillarCol;
                        matrix[firstPillarRow][firstPillarCol] = '-';
                        matrix[secondPillarRow][secondPillarCol] = '-';
                    }else if(Character.isDigit(matrix[currentRow][currentCol])){
                        dollarsMade = getDollarsMade(matrix, currentRow, currentCol, dollarsMade);
                    }
                    matrix[currentRow][currentCol] = 'S';
                    break;
            }
            matrix[currentRow][currentCol] = 'S';
            if(dollarsMade >= 50){
                System.out.println("Good news! You succeeded in collecting enough money!");
                System.out.println("Money: " + dollarsMade);
                printMatrix(matrix);
                return;
            }
        }
    }

    private static int getDollarsMade(char[][] matrix, int currentRow, int currentCol, int dollarsMade) {
        dollarsMade += Character.getNumericValue(matrix[currentRow][currentCol]);
        matrix[currentRow][currentCol] = '-';
        return dollarsMade;
    }

    private static void printOutMessage(char[][] matrix, int dollarsMade) {
        System.out.println("Bad news! You are out of the pastry shop.");
        System.out.println("Money: " + dollarsMade);
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for(char[] row : matrix){
            for(char symbol : row){
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    private static boolean isInBounds(char[][] matrix, int index) {
        return index >= 0 && index < matrix.length;
    }
}
