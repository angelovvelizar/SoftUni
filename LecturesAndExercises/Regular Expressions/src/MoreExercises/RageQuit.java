package MoreExercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> stringsToRepeat = new LinkedHashMap<>();
        List<Character> uniqueSymbols = new ArrayList<>();
        String input = sc.nextLine().toUpperCase();
        String regex = "(?<string>[\\D]*)(?<count>\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()){
            stringsToRepeat.put(matcher.group("string"),Integer.parseInt(matcher.group("count")));
            for (int i = 0; i < matcher.group("string").length(); i++) {
                char currentSymbol = matcher.group("string").charAt(i);
                if(!uniqueSymbols.contains(currentSymbol) && Integer.parseInt(matcher.group("count")) > 0){
                    uniqueSymbols.add(currentSymbol);
                }
            }
        }
        System.out.println("Unique symbols used: " + uniqueSymbols.size());
        for(Map.Entry<String, Integer> entry : stringsToRepeat.entrySet()){
            for (int i = 0; i < entry.getValue(); i++) {
                System.out.print(entry.getKey());
            }
        }
    }
}
