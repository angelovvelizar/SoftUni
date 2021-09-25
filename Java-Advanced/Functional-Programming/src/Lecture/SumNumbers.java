package Lecture;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();


        Function<String, Integer> getCount = num -> Arrays.stream(num.split(", ")).mapToInt(Integer::parseInt).toArray().length;
        Function<String, Integer> getSum = num -> Arrays.stream(num.split(", ")).mapToInt(Integer::parseInt).sum();

        System.out.println("Count = " + getCount.apply(input));
        System.out.println("Sum = " + getSum.apply(input));



    }
}
