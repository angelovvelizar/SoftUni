package Exercise.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Person> people = new ArrayList<>();

        while(n-- > 0){
            String[] peopleInformation = sc.nextLine().split("\\s+");
            String name = peopleInformation[0];
            int age = Integer.parseInt(peopleInformation[1]);
            Person currentPerson = new Person(name,age);
            people.add(currentPerson);
        }

        people.stream().filter(p -> p.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
    }
}
