package Lecture.HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("\\s+");

        double pricePerDay = Double.parseDouble(input[0]);
        int numberOfDays = Integer.parseInt(input[1]);
        Season season = Season.valueOf(input[2].toUpperCase());
        Discount discount = Discount.parseDiscount(input[3]);

        PriceCalculator calculator = new PriceCalculator(pricePerDay, numberOfDays, season, discount);
        double totalPrice = calculator.calculateTotalPrice(pricePerDay, numberOfDays, season, discount);
        System.out.printf("%.2f", totalPrice);
    }
}
