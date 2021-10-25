package PastryFormulaCafe;

import java.util.Scanner;

public class FormulaOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        int countOfCommands = Integer.parseInt(sc.nextLine());
        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {
            matrix[row] = sc.nextLine().toCharArray();
        }

        int currentPlayerRow = 0;
        int currentPlayerCol = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'P') {
                    currentPlayerRow = row;
                    currentPlayerCol = col;
                    break;
                }
            }
        }

        boolean hasFinished = false;
        while (countOfCommands-- > 0) {
            String command = sc.nextLine();
            switch (command) {
                case "up":
                    changeLastPositionWithDot(matrix,currentPlayerRow,currentPlayerCol);
                    if(!isInBounds(matrix,currentPlayerRow - 1)){
                        //currentPlayerRow += size - 1;
                        currentPlayerRow = matrix.length - 1;
                    }else {
                        currentPlayerRow -= 1;
                    }
                    if(matrix[currentPlayerRow][currentPlayerCol] == 'B'){
                        currentPlayerRow -= 1;
                    }else if(matrix[currentPlayerRow][currentPlayerCol] == 'T'){
                        if(isInBounds(matrix, currentPlayerRow + 1)) {
                            currentPlayerRow += 1;
                        }else{
                            currentPlayerRow = 0;
                        }
                    }
                    if(hasFinished(matrix, currentPlayerRow, currentPlayerCol)){
                        hasFinished = true;
                        break;
                    }
                    break;
                case "down":
                    changeLastPositionWithDot(matrix,currentPlayerRow,currentPlayerCol);
                    if(!isInBounds(matrix,currentPlayerRow + 1)){
                        //currentPlayerRow -= size-1;
                        currentPlayerRow = 0;
                    }else {
                        currentPlayerRow += 1;
                    }
                    if(matrix[currentPlayerRow][currentPlayerCol] == 'B'){
                        currentPlayerRow += 1;
                    }else if(matrix[currentPlayerRow][currentPlayerCol] == 'T'){
                        if(isInBounds(matrix,currentPlayerRow - 1)) {
                            currentPlayerRow -= 1;
                        }else{
                            currentPlayerRow = size - 1;
                        }
                    }
                    if(hasFinished(matrix, currentPlayerRow, currentPlayerCol)){
                        hasFinished = true;
                        break;
                    }
                    break;
                case "left":
                    changeLastPositionWithDot(matrix,currentPlayerRow,currentPlayerCol);
                    if(!isInBounds(matrix,currentPlayerCol - 1)){
                        //currentPlayerCol += size - 1;
                        currentPlayerCol = size - 1;
                    }else {
                        currentPlayerCol -= 1;
                    }
                    if(matrix[currentPlayerRow][currentPlayerCol] == 'B'){
                        currentPlayerCol -= 1;
                    }else if(matrix[currentPlayerRow][currentPlayerCol] == 'T'){
                        if(isInBounds(matrix, currentPlayerCol + 1)) {
                            currentPlayerCol += 1;
                        }else{
                            currentPlayerCol = 0;
                        }
                    }
                    if(hasFinished(matrix, currentPlayerRow, currentPlayerCol)){
                        hasFinished = true;
                        break;
                    }
                    break;
                case "right":
                    changeLastPositionWithDot(matrix,currentPlayerRow,currentPlayerCol);
                    if(!isInBounds(matrix,currentPlayerCol + 1)){
                        //currentPlayerCol -= size - 1;
                        currentPlayerCol = 0;
                    }else {
                        currentPlayerCol += 1;
                    }
                    if(matrix[currentPlayerRow][currentPlayerCol] == 'B'){
                        currentPlayerCol += 1;
                    }else if(matrix[currentPlayerRow][currentPlayerCol] == 'T'){
                        if(isInBounds(matrix,currentPlayerCol - 1)){
                            currentPlayerCol -= 1;
                        }else{
                            currentPlayerCol = size - 1;
                        }
                    }
                    if(hasFinished(matrix, currentPlayerRow, currentPlayerCol)){
                        hasFinished = true;
                        break;
                    }
                    break;
            }
        }

        matrix[currentPlayerRow][currentPlayerCol] = 'P';
        if(hasFinished){
            System.out.println("Well done, the player won first place!");
        }else{
            System.out.println("Oh no, the player got lost on the track!");
        }

        for (char[] row : matrix) {
            for (char element : row) {
                System.out.print(element);
            }
            System.out.println();
        }

    }

    private static void changeLastPositionWithDot(char[][] matrix, int currentPlayerRow, int currentPlayerCol) {
        matrix[currentPlayerRow][currentPlayerCol] = '.';
    }

    private static boolean isInBounds(char[][] matrix, int index){
        return index >= 0 && index < matrix.length;
    }

    private static boolean hasFinished(char[][] matrix, int currentPlayerRow, int currentPlayerCol) {
        return matrix[currentPlayerRow][currentPlayerCol] == 'F';
    }
}
