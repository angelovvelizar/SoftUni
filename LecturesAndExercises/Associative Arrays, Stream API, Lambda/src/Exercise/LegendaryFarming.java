package Exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> itemMaterials = new TreeMap<>();
        Map<String, Integer> junkItems = new TreeMap<>();
        itemMaterials.put("shards", 0);
        itemMaterials.put("fragments", 0);
        itemMaterials.put("motes", 0);

        while (true) {
            String[] tokens = sc.nextLine().split("\\s+");

            for (int i = 0; i < tokens.length; i += 2) {
                int quantity = Integer.parseInt(tokens[i]);
                String item = tokens[i + 1].toLowerCase();
                if (item.equalsIgnoreCase("shards") || item.equalsIgnoreCase("fragments") || item.equalsIgnoreCase("motes")) {
                    if (!itemMaterials.containsKey(item)) {
                        itemMaterials.put(item, quantity);
                    } else {
                        itemMaterials.put(item, itemMaterials.get(item) + quantity);
                    }
                    if (itemMaterials.get(item) >= 250) {
                        if (item.equalsIgnoreCase("fragments")) {
                            System.out.println("Valanyr obtained!");
                        } else if (item.equalsIgnoreCase("shards")) {
                            System.out.println("Shadowmourne obtained!");
                        } else if (item.equalsIgnoreCase("motes")) {
                            System.out.println("Dragonwrath obtained!");
                        }
                        itemMaterials.put(item, itemMaterials.get(item) - 250);
                        itemMaterials.entrySet().stream()
                                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

                        junkItems.forEach((k, v) -> System.out.println(k + ": " + v));

                        return;
                    }
                } else {
                    if (!junkItems.containsKey(item)) {
                        junkItems.put(item, quantity);
                    } else {
                        junkItems.put(item, junkItems.get(item) + quantity);
                    }
                }
            }
        }
    }
}
