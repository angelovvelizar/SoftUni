package WhileLoop;

import java.util.Scanner;

public class AccountBalance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double sumAccount = 0.0;
        String text = sc.nextLine();

        while (!text.equals("NoMoreMoney")) {
            double sum = Double.parseDouble(text);
            if (sum < 0) {
                System.out.println("Invalid operation!");
                break;
            } else {
                System.out.printf("Increase: %.2f%n", sum);
                sumAccount += sum;
            }
            text = sc.nextLine();
        }
        System.out.printf("Total: %.2f",sumAccount);

    }
}
