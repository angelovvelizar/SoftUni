package CookingSellingOpenning;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Cooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //bread - 25
        int bread = 0;
        //cake - 50
        int cake = 0;
        //pastry - 75
        int pastry = 0;
        //fruitpie - 100
        int fruitPie = 0;

        int[] liquids = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> liquidsQueue  = new ArrayDeque<>();
        Arrays.stream(liquids).forEach(liquidsQueue::offer);

        int[] ingredients = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        Arrays.stream(ingredients).forEach(ingredientsStack::push);

        while(!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()){
            int currentLiquid = liquidsQueue.poll();
            int currentIngredient = ingredientsStack.peek();

            int sum = currentIngredient + currentLiquid;
            switch (sum){
                case 25:
                    bread++;
                    ingredientsStack.pop();
                    break;
                case 50:
                    cake++;
                    ingredientsStack.pop();
                    break;
                case 75:
                    pastry++;
                    ingredientsStack.pop();
                    break;
                case 100:
                    fruitPie++;
                    ingredientsStack.pop();
                    break;
                default:
                    currentIngredient += 3;
                    ingredientsStack.pop();
                    ingredientsStack.push(currentIngredient);
                    break;
            }
        }

        String output;
        if(bread > 0 && cake > 0 && pastry > 0  && fruitPie > 0){
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        }else{
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        if(liquidsQueue.isEmpty()){
            System.out.println("Liquids left: none");
        }else{
            System.out.print("Liquids left: ");
            output = liquidsQueue.stream().map(String::valueOf).collect(Collectors.joining(","));
            System.out.println(output);
        }

        if(ingredientsStack.isEmpty()){
            System.out.println("Ingredients left: none");
        }else{
            System.out.print("Ingredients left: ");
            output = ingredientsStack.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println(output);
        }

        printInfo(bread,cake,fruitPie,pastry);
    }

    private static void printInfo(int bread, int cake, int fruitPie, int pastry){
        System.out.println("Bread: " + bread);
        System.out.println("Cake: " + cake);
        System.out.println("Fruit Pie: " + fruitPie);
        System.out.println("Pastry: " + pastry);
    }


}
