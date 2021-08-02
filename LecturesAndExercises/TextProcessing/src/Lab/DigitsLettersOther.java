package Lab;

import java.util.Scanner;

public class DigitsLettersOther {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringBuilder digits = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder others = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if(Character.isDigit(currentChar)){
                digits.append(currentChar);
            }else if(Character.isLetter(currentChar)){
                letters.append(currentChar);
            }else{
                others.append(currentChar);
            }
        }
        System.out.println(digits);
        System.out.println(letters);
        System.out.println(others);
    }
}
