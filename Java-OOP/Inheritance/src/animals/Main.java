package animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Animal> animals = new ArrayList<>();

        String input = sc.nextLine();
        while(!input.equals("Beast!")){
            String[] tokens = sc.nextLine().split("\\s+");

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String gender = tokens[2];

            try {
                switch (input) {
                    case "Dog":
                        animals.add(new Dog(name, age, gender));
                        break;
                    case "Frog":
                        animals.add(new Frog(name, age, gender));
                        break;
                    case "Cat":
                        animals.add(new Cat(name, age, gender));
                        break;
                    case "Tomcat":
                        animals.add(new Tomcat(name, age));
                        break;
                    case "Kitten":
                        animals.add(new Kitten(name, age));
                        break;
                }
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

            input = sc.nextLine();
        }

        animals.forEach(a -> System.out.println(a.toString()));
    }
}
