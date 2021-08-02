package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(" ");
        /*for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            int timesToRepeat = currentWord.length();
            for (int j = 0; j < timesToRepeat; j++) {
                System.out.print(currentWord);
            }
        }*/
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            int count = word.length();
            for (int i = 0; i < count; i++) {
                result.append(word);
            }
        }
        System.out.println(result);

    }
}
