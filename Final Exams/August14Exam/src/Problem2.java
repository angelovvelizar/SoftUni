import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String regex = "[!](?<command>[A-Z][a-z]{2,})[!][:][\\[](?<string>[A-Za-z]{8,})[\\]]";
        Pattern pattern = Pattern.compile(regex);
        for (int i = 0; i < n; i++) {
            String command = sc.nextLine();
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()){
                printEncryptedString(command,matcher);
            }else{
                System.out.println("The message is invalid");
            }
        }


    }

    private static void printEncryptedString(String command, Matcher matcher) {
        System.out.print(matcher.group("command") + ": ");
        for (int i = 0; i < matcher.group("string").length(); i++) {
            char currentChar = matcher.group("string").charAt(i);
            System.out.print((int)currentChar + " ");
        }

        System.out.println();
    }
}
