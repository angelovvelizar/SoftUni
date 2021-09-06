package WhileLoop.Exercise;

import java.util.Scanner;

public class Report {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int targetSum = Integer.parseInt(sc.nextLine());
        double sum = 0;

        int cardPayments = 0;
        int cashPayments = 0;

        int counter = 0;
        int successfulCardTransactions = 0;
        int successfulCashTransactions = 0;


        while (sum < targetSum){
            String input = sc.nextLine();

            if ("End".equals(input)){
                break;
            }
            int money = Integer.parseInt(input);
            counter++;

            if (counter % 2 == 0 && money >=10){
                successfulCardTransactions++;
                cardPayments += money;
                sum += money;
                System.out.println("Product sold!");
            } else if (counter % 2 != 0 && money <= 100){
                successfulCashTransactions++;
                cashPayments += money;
                sum += money;
                System.out.println("Product sold!");
            } else {
                System.out.println("Error in transaction!");
            }
        }

        if (sum >= targetSum) {
            double averageCash = cashPayments * 1.0 / successfulCashTransactions;
            double averageCard = cardPayments * 1.0 / successfulCardTransactions;
            System.out.printf("Average CS: %.2f%n", averageCash);
            System.out.printf("Average CC: %.2f", averageCard);
        } else {
            System.out.println("Failed to collect required money for charity.");
        }
    }
}
