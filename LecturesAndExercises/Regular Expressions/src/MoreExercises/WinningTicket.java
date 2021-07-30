package MoreExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tickets = sc.nextLine().split("\\s*,\\s*");
        for (String ticket : tickets) {
            if (ticket.length() != 20) {
                System.out.println("invalid ticket");
                continue;
            }
            StringBuilder leftSide = getLeftSide(ticket);
            StringBuilder rightSide = getRightSide(ticket);
            String winningSymbols = "[@#$^]";
            Pattern pattern = Pattern.compile(winningSymbols);
            Matcher leftMatcher = pattern.matcher(leftSide);
            Matcher rightMatcher = pattern.matcher(rightSide);
            int leftCount = 0;
            int rightCount = 0;

            while (leftMatcher.find()) {
                leftCount++;
            }
            while (rightMatcher.find()) {
                rightCount++;
            }
            leftMatcher.reset();
            if (leftCount < 6) {
                System.out.printf("ticket \"%s\" - no match%n", ticket);
            } else {
                if (leftCount <= 9 && leftMatcher.find()) {
                    System.out.printf("ticket \"%s\" - %d%s%n",ticket,leftCount,leftMatcher.group());
                }else if(leftCount == 10 && leftMatcher.find()){
                    System.out.printf("ticket \"%s\" - %d%s Jackpot!%n",ticket,leftCount,leftMatcher.group());
                }
            }
        }

    }

    private static StringBuilder getRightSide(String ticket) {
        StringBuilder  rightSide = new StringBuilder();
        for (int i = 10; i < ticket.length(); i++) {
            rightSide.append(ticket.charAt(i));
        }
        return  rightSide;
    }

    private static StringBuilder getLeftSide(String ticket) {
        StringBuilder leftSide = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            leftSide.append(ticket.charAt(i));
        }
        return leftSide;
    }
}
