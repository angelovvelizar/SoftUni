package Exercise.CardRank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cardRank = sc.nextLine();
        String cardSuit = sc.nextLine();

        CardRank currentCardRank = CardRank.valueOf(cardRank);
        CardSuit currentCarSuit = CardSuit.valueOf(cardSuit);

        Card card = new Card(currentCardRank, currentCarSuit);

        int power = card.calculatePower(currentCardRank.getValue(), currentCarSuit.getValue());

        System.out.printf("Card name: %s of %s; Card power: %d", currentCardRank,currentCarSuit,power);

    }
}
