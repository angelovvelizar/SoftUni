
package KeysEmojiPirates;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Emoji {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        long threshold = 1;
        BigInteger num = new BigInteger("0");
        String digitRegex = "\\d";
        Pattern digitPattern = Pattern.compile(digitRegex);
        Matcher digitMatcher = digitPattern.matcher(input);
        while (digitMatcher.find()){
            threshold *= Long.parseLong(digitMatcher.group());
        }
        String emojiRegex = "([:]{2}|[*]{2})(?<emoji>[A-Z][a-z]{2,})\\1";
        Pattern emojiPattern = Pattern.compile(emojiRegex);
        Matcher emojiMatcher = emojiPattern.matcher(input);
        List<String> coolEmojis = new ArrayList<>();
        int emojisFound = 0;
        while(emojiMatcher.find()){
            long coolness = 0;
            for (int i = 0; i < emojiMatcher.group("emoji").length(); i++) {
                coolness += emojiMatcher.group("emoji").charAt(i);
            }
            if(coolness >= threshold){
                coolEmojis.add(emojiMatcher.group());
            }
            emojisFound++;
        }
        System.out.println("Cool threshold: " + threshold);
        System.out.println(emojisFound + " emojis found in the text. The cool ones are:");
        coolEmojis.forEach(System.out::println);

    }
}