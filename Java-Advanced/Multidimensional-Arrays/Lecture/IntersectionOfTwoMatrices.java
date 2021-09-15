package Lecture;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = Integer.parseInt(sc.nextLine());
        int cols = Integer.parseInt(sc.nextLine());

        char[][] firstMatrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] tokens = sc.nextLine().split("\\s+");
            for (int col = 0; col < tokens.length; col++) {
                firstMatrix[row][col] = tokens[col].charAt(0);
            }
        }

        char[][] secondMatrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] tokens = sc.nextLine().split("\\s+");
            for (int col = 0; col < tokens.length; col++) {
                secondMatrix[row][col] = tokens[col].charAt(0);
            }
        }

        char[][] result =getMatricesIntersection(firstMatrix,secondMatrix);

        for (char[] array : result) {
            for (char element: array) {
                System.out.print(element + " ");
            }
            System.out.println();
        }


    }

    public static char[][] getMatricesIntersection(char[][] firstMatrix, char[][] secondMatrix){
        char[][] out = new char[firstMatrix.length][];

        for (int row = 0; row < firstMatrix.length; row++) {
            out[row] = new char[firstMatrix[row].length];
            for (int col = 0; col < firstMatrix[row].length; col++) {
                out[row][col] =firstMatrix[row][col] == secondMatrix[row][col]
                        ? firstMatrix[row][col] : '*';
            }
        }



        return  out;
    }
}
