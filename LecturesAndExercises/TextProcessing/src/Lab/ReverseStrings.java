package Lab;

import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.nextLine();
        while(!word.equals("end")){
            StringBuilder reversedWord = new StringBuilder();
            for(int i = word.length() - 1; i >= 0; i--) {
                char currentLetter = word.charAt(i);
                reversedWord.append(currentLetter);
            }
            System.out.println(word + " = " + reversedWord);
            word = sc.nextLine();
        }
    }
}
