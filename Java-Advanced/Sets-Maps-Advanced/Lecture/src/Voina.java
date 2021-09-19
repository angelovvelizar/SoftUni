import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Voina {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        LinkedHashSet<Integer> firstPlayerDeck = readDeck(sc.nextLine());
        LinkedHashSet<Integer> secondPlayerDeck = readDeck(sc.nextLine());

        int rounds = 0;
        while (rounds < 50) {
            int firstPlayerCard = getFirst(firstPlayerDeck);
            firstPlayerDeck.remove(firstPlayerCard);

            int secondPlayerCard = getFirst(secondPlayerDeck);
            secondPlayerDeck.remove(secondPlayerCard);

            if (firstPlayerCard > secondPlayerCard) {
                firstPlayerDeck.add(firstPlayerCard);
                firstPlayerDeck.add(secondPlayerCard);
            } else if (secondPlayerCard > firstPlayerCard) {
                secondPlayerDeck.add(firstPlayerCard);
                secondPlayerDeck.add(secondPlayerCard);
            }

            if (firstPlayerDeck.isEmpty() || secondPlayerDeck.isEmpty()) {
                break;
            }
            rounds++;
        }

        if (firstPlayerDeck.size() > secondPlayerDeck.size()) {
            System.out.println("First player win!");
        } else if (secondPlayerDeck.size() > firstPlayerDeck.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }

    }

    public static LinkedHashSet<Integer> readDeck(String line) {
        return Arrays.stream(line.split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public static int getFirst(LinkedHashSet<Integer> deck) {
        for (Integer card : deck) {
            return card;
        }
        return 0;
    }
}
