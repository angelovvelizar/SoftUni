package Lecture;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Map<String, Integer> peopleInfo = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] tokens = sc.nextLine().split(", ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            peopleInfo.put(name, age);

        }

        String ageCondition = sc.nextLine();
        int ageFilter = Integer.parseInt(sc.nextLine());
        String printFormat = sc.nextLine();

        Predicate<Map.Entry<String, Integer>> isInAgeCondition = getPredicate(ageCondition, ageFilter);

        Consumer<Map.Entry<String, Integer>> printByFormat = getConsumer(printFormat);

        peopleInfo.entrySet().stream()
                .filter(isInAgeCondition)
                .forEach(printByFormat);


    }

    public static Predicate<Map.Entry<String, Integer>> getPredicate(String ageCondition, int ageFilter) {
        if (ageCondition.equals("older")) {
            return e -> e.getValue() >= ageFilter;
        }
        return e -> e.getValue() <= ageFilter;
    }

    public static Consumer<Map.Entry<String, Integer>> getConsumer(String printFormat) {
        if (printFormat.equals("name age")) {
            return e -> System.out.println(e.getKey() + " - " + e.getValue());
        } else if (printFormat.equals("name")) {
            return e -> System.out.println(e.getKey());
        } else {
            return e -> System.out.println(e.getValue());
        }
    }
}


