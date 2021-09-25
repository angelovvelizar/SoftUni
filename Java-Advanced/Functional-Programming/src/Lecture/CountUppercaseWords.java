package Lecture;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        String[] words = text.split("\\s+");
        List<String> uppercaseWords = new ArrayList<>();

        Predicate<String> isUpperCase = word -> Character.isUpperCase(word.charAt(0));
        for (String word : words) {
            if(isUpperCase.test(word)){
                uppercaseWords.add(word);
            }
        }

        System.out.println(uppercaseWords.size());
        uppercaseWords.forEach(System.out::println);
    }
}
