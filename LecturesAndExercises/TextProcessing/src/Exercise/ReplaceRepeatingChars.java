package Exercise;

import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            output.append(input.charAt(i));
        }

        for (int i = 1; i <= output.length() - 1; i++) {
            if(output.charAt(i) == output.charAt(i - 1)){
                output.deleteCharAt(i);
                i--;
            }
        }
        System.out.println(output);
    }
}

