package Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lengthCondition = Integer.parseInt(sc.nextLine());
        String[] names = sc.nextLine().split(" ");

        Predicate<String> isLessOrEqual = str -> str.length() <= lengthCondition;

        Arrays.stream(names).filter(isLessOrEqual)
                .forEach(System.out::println);
    }
}
