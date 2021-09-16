package Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        int degrees = Integer.parseInt(command.substring(command.indexOf("(") + 1, command.indexOf(")")));
        degrees = degrees %  360;

        String element = sc.nextLine();
        int longestLength = Integer.MIN_VALUE;
        List<String> elements = new ArrayList<>();

        while (!element.equals("END")) {
            int currentLength = element.length();
            if (currentLength > longestLength) {
                longestLength = currentLength;
            }
            elements.add(element);
            element = sc.nextLine();
        }

        char[][] matrix = new char[elements.size()][longestLength];
        for (int i = 0, elementsSize = elements.size(); i < elementsSize; i++) {
            String currentElement = elements.get(i);
            while (currentElement.length() != longestLength) {
                currentElement += " ";
            }
            elements.set(i, currentElement);

        }

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = elements.get(row).toCharArray();
        }
        int rows = matrix.length;
        int cols = longestLength;

        rotateMatrix(matrix,degrees,rows,cols);



    }

    private static void printMatrix(char[][] matrix) {
        for (char[] array : matrix) {
            for (char element : array) {
                System.out.print(element);
            }
            System.out.println();
        }
    }

    private static void rotateMatrix(char[][] matrix, int degrees, int rows, int cols) {
        if (degrees == 90) {
            for (int col = 0; col < cols; col++) {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }else if(degrees == 180){
            for (int row = rows - 1; row >= 0; row--) {
                for (int col = cols - 1; col >= 0; col--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }

        }else if(degrees == 270){
            for (int col = cols - 1; col >= 0 ; col--) {
                for (int row = 0; row < rows; row++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }

        }else{
            printMatrix(matrix);
        }
    }
}

