package Exercise;

import java.util.*;

public class Orders {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Double> productsPrice = new LinkedHashMap<>();
        Map<String, Integer> productsQuantity = new LinkedHashMap<>();


        String command = sc.nextLine();
        while (!command.equals("buy")) {
            String[] tokens = command.split("\\s+");
            String productName = tokens[0];
            double price = Double.parseDouble(tokens[1]);
            int quantity = Integer.parseInt(tokens[2]);
            productsPrice.put(productName,price);
            if(!productsQuantity.containsKey(productName)){
                productsQuantity.put(productName,quantity);
            }else{
                productsQuantity.put(productName,productsQuantity.get(productName) + quantity);
            }

            command = sc.nextLine();
        }
        for (Map.Entry<String, Integer> entry : productsQuantity.entrySet()) {
            double finalSum = productsPrice.get(entry.getKey()) * entry.getValue();
            System.out.printf("%s -> %.2f%n",entry.getKey(),finalSum);
        }
    }
}
