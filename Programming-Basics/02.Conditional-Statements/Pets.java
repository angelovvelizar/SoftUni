package Conditional;

import java.util.Scanner;

public class Pets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int days = Integer.parseInt(sc.nextLine());
        int foodLeftInKg = Integer.parseInt(sc.nextLine());
        double foodForDog = Double.parseDouble(sc.nextLine());
        double foodForCat = Double.parseDouble(sc.nextLine());
        double foodForTurtleInGrams = Double.parseDouble(sc.nextLine());

        double foodNeeededForDog = foodForDog * days;
        double foodNeededForCat = foodForCat * days;
        double foodNeededForTurtle = (foodForTurtleInGrams * days) / 1000;

        double totalFoodNeeded = foodNeededForCat + foodNeededForTurtle + foodNeeededForDog;
        if(totalFoodNeeded <= foodLeftInKg){
            double foodLeft = Math.floor(foodLeftInKg - totalFoodNeeded);
            System.out.printf("%.0f kilos of food left.", foodLeft);
        }else{
            double foodNeeded = Math.ceil(totalFoodNeeded - foodLeftInKg);
            System.out.printf("%.0f more kilos of food are needed.", foodNeeded);
        }
    }
}
