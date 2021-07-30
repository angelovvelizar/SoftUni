package Lab;

import java.util.*;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split("\\s+");
        Map<String, Integer> counts = new LinkedHashMap<>();


        for(String word : words){
            String wordInLowerCase = word.toLowerCase();
            if(counts.containsKey(wordInLowerCase)){
                counts.put(wordInLowerCase, counts.get(wordInLowerCase) + 1);
            }else{
                counts.put(wordInLowerCase, 1);
            }
        }
        List<String> odds = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if(entry.getValue() % 2 != 0){
                odds.add(entry.getKey());
            }
        }
        System.out.println(String.join(", ", odds));

    }
}
