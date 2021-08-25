package ConditionsMoreExercises;

import java.util.Scanner;

public class Transport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int kilometers = sc.nextInt();
        String dayOrNight = sc.next();
        double lowestPrice, taxiPrice, bussPrice, trainPrice;
        if(kilometers < 20){
            if(dayOrNight.equalsIgnoreCase("day")){
                taxiPrice = kilometers * 0.79;
                lowestPrice = 0.70 + taxiPrice;
                System.out.printf("%.2f", lowestPrice);
            } else if (dayOrNight.equalsIgnoreCase("night")){
                taxiPrice = 0.90 * kilometers;
                lowestPrice = 0.70 + taxiPrice;
                System.out.printf("%.2f", lowestPrice);
            }

        } else if (kilometers > 20 && kilometers < 100){
            bussPrice = 0.09 * kilometers;
            System.out.printf("%.2f", bussPrice);
        } else {
            trainPrice = 0.06 * kilometers;
            System.out.printf("%.2f", trainPrice);
        }
    }
}
