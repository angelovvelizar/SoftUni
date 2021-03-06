package Exercise.WildFarm.Animals;

import Exercise.WildFarm.Food.Food;
import Exercise.WildFarm.Food.Meat;

public class Tiger extends Felime {
    private String livingRegion;

    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.livingRegion = livingRegion;
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");

    }


    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            super.eat(food);
        } else {
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }
    }

}
