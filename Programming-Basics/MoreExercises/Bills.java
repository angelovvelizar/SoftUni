package ForLoop.MoreExercises;

import java.util.Scanner;

public class Bills {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int months = Integer.parseInt(sc.nextLine());

        double totalEBill = 0;
        double waterBill = 0;
        double internetBill = 0;
        double otherBills = 0;
        for (int i = 0; i <months ; i++) {
            double electricityBill = Double.parseDouble(sc.nextLine());
            totalEBill += electricityBill;
            waterBill += 20;
            internetBill += 15;
            double others = 20 + 15 + electricityBill;
            otherBills += others + (others * 0.2);

        }
        double average = (totalEBill + waterBill + internetBill + otherBills) / months;

        System.out.printf("Electricity: %.2f lv%n", totalEBill);
        System.out.printf("Water: %.2f lv%n", waterBill);
        System.out.printf("Internet: %.2f lv%n", internetBill);
        System.out.printf("Other: %.2f lv%n", otherBills);
        System.out.printf("Average: %.2f lv", average);

    }
}
