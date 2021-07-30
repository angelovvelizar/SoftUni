package Lab;

import java.util.*;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, List<String>> wordsAndSynonyms = new LinkedHashMap<>();


        int n = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= n; i++) {
            String word = sc.nextLine();
            String synonym = sc.nextLine();
            wordsAndSynonyms.putIfAbsent(word,new ArrayList<>());
            wordsAndSynonyms.get(word).add(synonym);
        }
        for (Map.Entry<String, List<String>> word : wordsAndSynonyms.entrySet()) {
            System.out.printf("%s - %s%n",word.getKey(),String.join(", ", word.getValue()));
        }

    }
}
