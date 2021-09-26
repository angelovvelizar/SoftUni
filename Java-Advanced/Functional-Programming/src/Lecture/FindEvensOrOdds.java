package Lecture;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tokens = sc.nextLine().split(" ");

        int lower = Integer.parseInt(tokens[0]);
        int upper = Integer.parseInt(tokens[1]);
        String evenOrOdd = sc.nextLine();

        List<Integer> numbers = getListOfNumbers(lower,upper);

        Predicate<Integer> isEvenOrOdd = x -> {
            if(evenOrOdd.equals("even")){
                return x % 2 == 0;
            }
            return  x % 2 != 0;
        };
        
        numbers.stream().filter(isEvenOrOdd)
                .forEach( x -> System.out.print(x + " "));

    }

    private static List<Integer> getListOfNumbers(int lower, int upper) {
         List<Integer> numbers = new ArrayList<>();
        for (int i = lower; i <= upper; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}
