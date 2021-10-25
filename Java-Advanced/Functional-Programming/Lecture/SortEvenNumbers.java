package Lecture;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split(", ")).map(Integer::parseInt)
                .collect(Collectors.toList());
        /*int[] numbers = Arrays.stream(sc.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();*/
        numbers.removeIf(num -> num % 2 != 0);
        /*String functionalOutput = Arrays.stream(numbers).mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));*/
        System.out.println(numbers.stream().map(String::valueOf).collect(Collectors.joining(", ")));

        numbers.sort(Integer::compare);
        String output = numbers.stream().map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(output);


    }
}
