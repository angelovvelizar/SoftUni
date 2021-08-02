package MoreExercises;

import java.util.Scanner;

public class AsciiSumator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char firstChar = sc.nextLine().charAt(0);
        char secondChar = sc.nextLine().charAt(0);
        String input = sc.nextLine();
        int totalSum = 0;
        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);
            if(currentSymbol > firstChar && currentSymbol < secondChar){
                totalSum += currentSymbol;
            }
        }
        System.out.println(totalSum);
    }
}
