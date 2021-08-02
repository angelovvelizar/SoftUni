package MoreExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().replace(" ", "");
        List<String> tickets = Arrays.stream(input.split(",")).collect(Collectors.toList());


        for (String currentTicket : tickets) {
            if (currentTicket.length() != 20) {
                System.out.println("invalid ticket");
                continue;
            }
            char winningSymbol;
            if (currentTicket.contains("@")) {
                winningSymbol = '@';
            } else if (currentTicket.contains("#")) {
                winningSymbol = '#';
            } else if (currentTicket.contains("$")) {
                winningSymbol = '$';
            } else if (currentTicket.contains("^")) {
                winningSymbol = '^';
            } else {
                System.out.printf("ticket \"%s\" - no match%n",currentTicket);
                continue;
            }
            String leftSide = currentTicket.substring(0, 10);
            String rightSide = currentTicket.substring(10);
            int leftCounter = 0;
            for (int j = 0; j < leftSide.length(); j++) {
                if (leftSide.charAt(j) == winningSymbol) {
                    leftCounter++;
                }
            }
            int rightCounter = 0;
            for (int j = 0; j < rightSide.length(); j++) {
                if (rightSide.charAt(j) == winningSymbol) {
                    rightCounter++;
                }
            }
            if (rightCounter == leftCounter) {
                if (leftCounter >= 6 && leftCounter <= 9) {
                    System.out.printf("ticket \"%s\" - %d%c%n", currentTicket, leftCounter, winningSymbol);
                } else if (leftCounter == 10) {
                    System.out.printf("ticket \"%s\" - %d%c Jackpot!%n", currentTicket, leftCounter, winningSymbol);
                }
            }

        }
    }
}
