package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class WordFilter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       /* String[] words = sc.nextLine().split("\\s+");
        Arrays.stream(words).filter(word -> word.length() % 2 == 0).forEach(word -> System.out.println(word));*/

        String[] words = Arrays.stream(sc.nextLine().split("\\s+"))
                .filter(word -> word.length() % 2 == 0).toArray(String[]::new);

        for (String word : words) {
            System.out.println(word);
        }

    }
}
