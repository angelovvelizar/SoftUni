
package Exercise.GreedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int bagCapacity = Integer.parseInt(scanner.nextLine());
        String[] inputData = scanner.nextLine().split("\\s+");

        Bag bag = new Bag(bagCapacity, 0, 0, 0);

        for (int i = 0; i < inputData.length; i += 2) {
            String name = inputData[i];
            int quantity = Integer.parseInt(inputData[i + 1]);

            String type = "";

            if (name.length() == 3) {
                type = "Cash";
            } else if (name.toLowerCase().endsWith("gem")) {
                type = "Gem";
            } else if (name.toLowerCase().equals("gold")) {
                type = "Gold";
            }

            if (type.equals("")) {
                continue;
            } else if (bagCapacity < bag.getCurrentVolume(quantity)) {
                continue;
            }

            switch (type) {
                case "Gem":
                    if (quantity > bag.getGold()) {
                        continue;
                    }
                    if (bag.getGems() + quantity > bag.getGold()) {
                        continue;
                    }
                    bag.setGems(bag.getGems() + quantity);
                    break;
                case "Cash":
                    if (quantity > bag.getGold()) {
                        continue;
                    }
                    if (bag.getMoney() + quantity > bag.getGems()) {
                        continue;
                    }
                    bag.setMoney(bag.getMoney() + quantity);
                    break;
                case "Gold":
                    if (quantity > bag.getGold()) {
                        continue;
                    }
                    if (bag.getGold() + quantity > bag.getMoney()) {
                        continue;
                    }
                    bag.setGold(bag.getGold() + quantity);
                    break;
            }

        }
        //String, LinkedHashMap<String, Integer>

        //TODO: print the output
    }
}