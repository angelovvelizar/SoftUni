package ForLoop.MoreExercises;

import java.util.Scanner;

public class BackInThePast {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double moneyInherited = Double.parseDouble(sc.nextLine());
        int yearToLive = Integer.parseInt(sc.nextLine());

        double moneySpent = 0;
        int age = 18;
        for (int i = 1800; i <= yearToLive; i++) {
            if(i % 2 == 0){
                moneySpent += 12000;
            }
            if(i % 2 != 0){
                moneySpent = moneySpent + 12000 + 50 * age;
            }
            age++;
        }
        if(moneyInherited >= moneySpent){
            double moneyLeft = moneyInherited - moneySpent;
            System.out.printf("Yes! He will live a carefree life and will have %.2f dollars left.", moneyLeft);
        }else{
            double moneyNeeded = moneySpent - moneyInherited;
            System.out.printf("He will need %.2f dollars to survive.", moneyNeeded);
        }
    }
}
