package FinalExam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class AutumnCocktails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] ingredients = getAsIntArray(sc);
        ArrayDeque<Integer> ingredientsQueue = new ArrayDeque<>();
        Arrays.stream(ingredients).forEach(ingredientsQueue::offer);

        int[] freshness = getAsIntArray(sc);
        ArrayDeque<Integer> freshnessStack = new ArrayDeque<>();
        Arrays.stream(freshness).forEach(freshnessStack::push);

        int pearSour = 0; //150
        int theHarvest = 0; //250
        int appleHinny = 0; //300
        int highFashion = 0; //400
        while(!ingredientsQueue.isEmpty() && !freshnessStack.isEmpty()){
            int currentIngredient = ingredientsQueue.poll();

            if(currentIngredient == 0){
                continue;
            }

            int currentFreshness = freshnessStack.pop();
            int product = currentIngredient * currentFreshness;

            switch (product){
                case 150:
                    pearSour++;
                    break;
                case 250:
                    theHarvest++;
                    break;
                case 300:
                    appleHinny++;
                    break;
                case 400:
                    highFashion++;
                    break;
                default:
                    currentIngredient += 5;
                    ingredientsQueue.offer(currentIngredient);
                    break;
            }
        }

        if(pearSour >= 1 && theHarvest >= 1 && appleHinny >= 1 && highFashion >= 1){
            System.out.println("It's party time! The cocktails are ready!");
        }else{
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if(!ingredientsQueue.isEmpty()){
            int sumOfIngredients = ingredientsQueue.stream().mapToInt(Integer::intValue).sum();
            System.out.println("Ingredients left: " + sumOfIngredients);
        }

        //" # {cocktail name} --> {amount}";

        if(appleHinny > 0){
            System.out.println(" # Apple Hinny --> " + appleHinny);
        }
        if(highFashion > 0){
            System.out.println(" # High Fashion --> " + highFashion);
        }
        if(pearSour > 0){
            System.out.println(" # Pear Sour --> " + pearSour);
        }
        if(theHarvest > 0){
            System.out.println(" # The Harvest --> " + theHarvest);
        }


    }

    private static int[] getAsIntArray(Scanner sc) {
        return Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}
