import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        Map<String, LinkedHashMap<String, Double>> shopsAndProducts = new TreeMap<>();

        while (!input.equals("Revision")) {
            String shop = input.split(", ")[0];
            String product = input.split(", ")[1];
            double price = Double.parseDouble(input.split(", ")[2]);

            shopsAndProducts.putIfAbsent(shop, new LinkedHashMap<>());
            shopsAndProducts.get(shop).put(product, price);

            input = sc.nextLine();
        }


        /*for(Map.Entry<String, LinkedHashMap<String,Double>> shop : shopsAndProducts.entrySet()){
            System.out.println(shop.getKey() + "->");
            for(Map.Entry<String,Double> product : shop.getValue().entrySet()){
                System.out.printf("Product: %s, Price: %.1f%n",product.getKey(),product.getValue());
            }
        }*/

        shopsAndProducts.forEach((key1, value1) -> {
            System.out.println(key1 + "->");
            value1.forEach((key, value) -> System.out.printf("Product: %s, Price: %.1f%n", key, value));
        });
    }
}
