package Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String regex = "(?<=\\s)([a-z]+|\\d+)(\\d+|\\w+|\\.+|-+)([a-z]+|\\d+)\\@[a-z]+\\-?[a-z]+\\.[a-z]+(\\.[a-z]+)?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List<String> emails = new ArrayList<>();
        while(matcher.find()){
            emails.add(matcher.group());
        }
        emails.forEach(System.out::println);
    }
}
