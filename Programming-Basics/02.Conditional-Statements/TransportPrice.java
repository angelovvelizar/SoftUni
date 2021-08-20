package Conditional;

import java.util.Scanner;

public class TransportPrice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int kilometers = Integer.parseInt(sc.nextLine());
        String dayOrNight = sc.nextLine();
        double price = 0;

        if(kilometers < 20){
            if(dayOrNight.equals("day")){
                price = 0.70 + kilometers * 0.79;
            }else if(dayOrNight.equals("night")){
                price = 0.70 + kilometers * 0.90;
            }
            System.out.printf("%.2f",price);
        }
        if(kilometers >= 20 && kilometers < 100){
            price = kilometers * 0.09;
            System.out.printf("%.2f",price);
        }
        if(kilometers >= 100){
            price = kilometers * 0.06;
            System.out.printf("%.2f", price);
        }
    }
}
