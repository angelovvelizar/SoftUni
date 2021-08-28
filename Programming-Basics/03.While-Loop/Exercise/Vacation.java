package WhileLoop.Exercise;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double moneyNeeded = Double.parseDouble(sc.nextLine());
        double moneyAvailable = Double.parseDouble(sc.nextLine());


        int spendDays = 0;
        int totalDays = 0;
        while (moneyAvailable < moneyNeeded && spendDays < 5) {
            String activity = sc.nextLine();
            double sum = Double.parseDouble(sc.nextLine());
            totalDays++;
            if(activity.equals("spend")){
                moneyAvailable -= sum;
                spendDays++;
                if(moneyAvailable < 0){
                    moneyAvailable = 0;
                }
            }else if(activity.equals("save")){
                moneyAvailable += sum;
                spendDays = 0;
            }
        }
        if(moneyAvailable >= moneyNeeded){
            System.out.printf("You saved the money for %d days.", totalDays);
        }
        if(spendDays == 5){
            System.out.println("You can't save the money.");
            System.out.println(totalDays);
        }


    }
}
