package Exercise.CardSuit;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        System.out.println("Card Suits:");
        for(CardSuit cardSuit : CardSuit.values()){
            System.out.println("Ordinal value: " + cardSuit.getValue() + "; " + "Name value: " + cardSuit);
        }

    }
}
