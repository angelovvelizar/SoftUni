package Exercise.ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String command = sc.nextLine();
        List<Person> persons = new ArrayList<>();
        while(!command.equals("END")){
            String[] tokens = command.split("\\s+");
            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            persons.add(person);
            command = sc.nextLine();
        }

        int n = Integer.parseInt(sc.nextLine());
        int equalPeople = 0;

        Person personToCompare = persons.get(n - 1);


        for (Person person : persons) {
            if(person.compareTo(personToCompare) == 0){
                equalPeople++;
            }
        }


        if(equalPeople <= 1){
            System.out.println("No matches");
        }else{
            System.out.println(equalPeople + " " + (persons.size() - equalPeople) + " " + persons.size());
        }


    }
}
