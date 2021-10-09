package PastryFormulaCafe;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PastryShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*Biscuit	25
        Cake	50
        Pastry	75
        Pie	100*/

        int[] liquids = getAsArray(sc);

        ArrayDeque<Integer> liquidsQue = new ArrayDeque<>();
        Arrays.stream(liquids).forEach(liquidsQue::offer);

        int[] ingredients = getAsArray(sc);

        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        Arrays.stream(ingredients).forEach(ingredientsStack::push);

        int biscuitsMade = 0;
        int cakesMade = 0;
        int pastryMade = 0;
        int piesMade = 0;

        while (!liquidsQue.isEmpty() && !ingredientsStack.isEmpty()) {
            int liquid = liquidsQue.poll();
            int ingredient = ingredientsStack.peek();

            int sum = liquid + ingredient;
            switch (sum) {
                case 25:
                    biscuitsMade++;
                    ingredientsStack.pop();
                    break;
                case 50:
                    cakesMade++;
                    ingredientsStack.pop();
                    break;
                case 75:
                    pastryMade++;
                    ingredientsStack.pop();
                    break;
                case 100:
                    piesMade++;
                    ingredientsStack.pop();
                    break;
                default:
                    ingredient += 3;
                    ingredientsStack.pop();
                    ingredientsStack.push(ingredient);
                    break;
            }
        }

        if (biscuitsMade > 0 && cakesMade > 0 && pastryMade > 0 && piesMade > 0) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        String output;

        if (liquidsQue.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: ");
            output = getElementsAsCollector(liquidsQue);
            System.out.println(output);
        }

        if (ingredientsStack.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.print("Ingredients left: ");
            output = getElementsAsCollector(ingredientsStack);
            System.out.println(output);
        }

        System.out.println("Biscuit: " + biscuitsMade);
        System.out.println("Cake: " + cakesMade);
        System.out.println("Pie: " + piesMade);
        System.out.println("Pastry: " + pastryMade);


    }

    private static String getElementsAsCollector(ArrayDeque<Integer> liquidsQue) {
        return liquidsQue.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }

    private static int[] getAsArray(Scanner sc) {
        return Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}
