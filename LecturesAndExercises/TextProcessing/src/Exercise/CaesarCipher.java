package Exercise;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            int newSymbol = text.charAt(i) + 3;

            encryptedText.append((char)newSymbol);
        }
        System.out.println(encryptedText.toString());
    }
}
