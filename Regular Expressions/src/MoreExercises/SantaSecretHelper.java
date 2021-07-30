package MoreExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantaSecretHelper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int key = Integer.parseInt(sc.nextLine());

        String regex = "@(?<name>[A-Za-z]+)[^@\\-!:>]*!(?<type>[GN])!";
        Pattern pattern = Pattern.compile(regex);
        String message = sc.nextLine();
        while(!message.equals("end")){
            StringBuilder decryptedMessage = new StringBuilder();
            for (int i = 0; i < message.length(); i++) {
                char currentSymbol = message.charAt(i);
                decryptedMessage.append((char)(currentSymbol - key));
            }
            Matcher matcher = pattern.matcher(decryptedMessage.toString());
            while (matcher.find()){
                if(matcher.group("type").equals("G")){
                    System.out.println(matcher.group("name"));
                }
            }
            message = sc.nextLine();
        }
    }
}
