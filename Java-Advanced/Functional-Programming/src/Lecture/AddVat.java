package Lecture;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class AddVat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Function<String, Double> getVatValue = x -> Double.parseDouble(x) * 1.2;

        System.out.println("Prices with VAT:");
        Arrays.stream(sc.nextLine().split(", "))
                .map(getVatValue)
                .forEach(e -> System.out.printf("%.2f%n", e));

    }
}
