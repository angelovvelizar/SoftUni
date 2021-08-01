package SecretMirrorNFS;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Map<String, String> mirrorWords = new LinkedHashMap<>();
        List<String> mirrorWords = new ArrayList<>();
        String input = sc.nextLine();
        String regex = "([@|#])(?<firstWord>[A-Za-z]{3,})\\1{2}(?<secondWord>[A-Za-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        boolean foundPairs = false;
        int count = 0;
        while (matcher.find()){
            StringBuilder reversedSecondWord = new StringBuilder(matcher.group("secondWord")).reverse();
            //StringBuilder firstWord = new StringBuilder(matcher.group("firstWord"));
            if(matcher.group("firstWord").equals(reversedSecondWord.toString())){
                mirrorWords.add(matcher.group("firstWord"));
            }
            count++;
            foundPairs = true;
        }
        if(!foundPairs){
            System.out.println("No word pairs found!");
            System.out.println("No mirror words!");
            return;
        }
        System.out.println(count + " word pairs found!");
        if(mirrorWords.isEmpty()){
            System.out.println("No mirror words!");
        }else{
            System.out.println("The mirror words are:");
            for (int i = 0; i < mirrorWords.size(); i++) {
                StringBuilder reversedWord = new StringBuilder(mirrorWords.get(i)).reverse();
                String word = mirrorWords.get(i);
                if(i == mirrorWords.size() - 1){
                    System.out.print(word + " <=> " + reversedWord);
                }else{
                    System.out.print(word + " <=> " + reversedWord + ", ");
                }
            }

        }
    }
}
