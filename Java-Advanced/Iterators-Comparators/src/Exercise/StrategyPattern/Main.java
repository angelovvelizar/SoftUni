package Exercise.StrategyPattern;

import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Set<Person> firstSet = new TreeSet<>(new NameComparator());
        Set<Person> secondSet = new TreeSet<>(new AgeComparator());

        while(n-- > 0){
            String[] tokens = sc.nextLine().split("\\s+");
            Person person = new Person(tokens[0],Integer.parseInt(tokens[1]));

            firstSet.add(person);
            secondSet.add(person);
        }

        firstSet.forEach(p -> System.out.printf("%s %d%n", p.getName(), p.getAge()));

        secondSet.forEach(p -> System.out.printf("%s %d%n", p.getName(), p.getAge()));

    }
}
