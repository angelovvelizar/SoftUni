package Exercise.WildFarm.Animals;

import Exercise.WildFarm.Food.Food;

import java.text.DecimalFormat;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private Double animalWeight;
    private Integer foodEaten;
    private String livingRegion;

    protected Animal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
        this.livingRegion = livingRegion;
    }

    public abstract void makeSound();

    public void eat(Food food){
        this.foodEaten += food.getQuantity();
    }

    protected  String getAnimalType() {
        return animalType;
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("#.##");

        return String.format("%s[%s, %s, %s, %d]",
                this.animalType, this.animalName,
                format.format(this.animalWeight),
                this.livingRegion,
                this.foodEaten
                );
    }
}
