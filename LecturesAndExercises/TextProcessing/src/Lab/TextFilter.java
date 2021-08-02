package Lab;

import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] banList = sc.nextLine().split(", ");
        String text = sc.nextLine();

        for (String word : banList) {
            int currentWordLength = word.length();
            StringBuilder replacement = new StringBuilder();
            for (int j = 0; j < currentWordLength; j++) {
                replacement.append("*");
            }
            text = text.replace(word, replacement);
        }
        System.out.println(text);
    }
}
