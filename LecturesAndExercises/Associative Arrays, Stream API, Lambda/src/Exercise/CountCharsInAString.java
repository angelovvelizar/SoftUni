package Exercise;

import java.util.*;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Map<Character, Integer> charCounts = new LinkedHashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar == ' ') {
                continue;
            }
            if (!charCounts.containsKey(currentChar)) {
                charCounts.put(currentChar, 1);
            } else {
                charCounts.put(currentChar, charCounts.get(currentChar) + 1);
            }

        }
        for (Map.Entry<Character, Integer> characterEntry : charCounts.entrySet()) {
            System.out.printf("%s -> %d%n", characterEntry.getKey(), characterEntry.getValue());
        }
    }
}
