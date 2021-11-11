package Exercise.WildFarm;

import Exercise.WildFarm.Animals.*;
import Exercise.WildFarm.Food.Food;
import Exercise.WildFarm.Food.Meat;
import Exercise.WildFarm.Food.Vegetable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String animalInfo = sc.nextLine();

        List<Animal> animals = new ArrayList<>();

        while(!animalInfo.equals("End")){
            String foodInfo = sc.nextLine();

            String[] animalTokens = animalInfo.split("\\s+");
            Animal animal = createAnimal(animalTokens);

            String[] foodTokens = foodInfo.split("\\s+");
            Food food = createFood(foodTokens);

            animal.makeSound();

            try{
                animal.eat(food);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

            animals.add(animal);


            animalInfo = sc.nextLine();
        }

        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }

    private static Food createFood(String[] foodTokens) {
        if(foodTokens[0].equals("Exercise.WildFarm.Food.Vegetable")){
            return new Vegetable(Integer.parseInt(foodTokens[1]));
        }

        return new Meat(Integer.parseInt(foodTokens[1]));
    }

    private static Animal createAnimal(String[] animalTokens) {
        switch (animalTokens[0]){
            case "Exercise.WildFarm.Animals.Cat":
                return new Cat(animalTokens[1],animalTokens[0],Double.parseDouble(animalTokens[2]),animalTokens[3],animalTokens[4]);
            case "Exercise.WildFarm.Animals.Tiger":
                return new Tiger(animalTokens[1],animalTokens[0],Double.parseDouble(animalTokens[2]), animalTokens[3]);
            case "Exercise.WildFarm.Animals.Zebra":
                return new Zebra(animalTokens[1],animalTokens[0],Double.parseDouble(animalTokens[2]),animalTokens[3]);
            case "Exercise.WildFarm.Animals.Mouse":
                return new Mouse(animalTokens[1],animalTokens[0],Double.parseDouble(animalTokens[2]),animalTokens[3]);
            default:
                throw new IllegalStateException("unknown animal type " + animalTokens[0]);
        }
    }
}
