package Exercise.PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] pizzaInfo = getAsArray(sc.nextLine());

        try {
            Pizza pizza = new Pizza(pizzaInfo[1], Integer.parseInt(pizzaInfo[2]));

            String[] doughInfo = getAsArray(sc.nextLine());

            Dough dough = new Dough(doughInfo[1], doughInfo[2], Double.parseDouble(doughInfo[3]));

            pizza.setDough(dough);

            String toppingInfo = sc.nextLine();
            while (!toppingInfo.equals("END")) {
                String[] toppingTokens = getAsArray(toppingInfo);
                String toppingType = toppingTokens[1];

                double toppingWeight = Double.parseDouble(toppingTokens[2]);
                Topping topping = new Topping(toppingType, toppingWeight);

                pizza.addTopping(topping);

                toppingInfo = sc.nextLine();
            }

            double totalCalories = pizza.getOverallCalories();
            System.out.printf("%s - %.2f", pizza.getName(), totalCalories);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    private static String[] getAsArray(String s) {
        return s.split("\\s+");
    }
}
