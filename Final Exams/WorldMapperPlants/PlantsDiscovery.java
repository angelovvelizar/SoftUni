package WorldMapperPlants;

import java.lang.reflect.Array;
import java.util.*;

public class PlantsDiscovery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String, Integer> plantRarity = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String plant = sc.nextLine();
            String[] plantInfo = plant.split("<->");
            String plantName = plantInfo[0];
            int rarity = Integer.parseInt(plantInfo[1]);
            plantRarity.put(plantName,rarity);
        }

        String command = sc.nextLine();
        Map<String, List<Double>> plantRating = new LinkedHashMap<>();
        while(!command.equals("Exhibition")){
            String[] data = command.split(": ");
            String commandType = data[0];
            String[] plantInfo = data[1].split(" - ");
            String plantName = plantInfo[0].trim();
            switch (commandType){
                case "Rate":
                    double rating = Double.parseDouble(plantInfo[1].trim());
                    if(plantRarity.containsKey(plantName)){
                        if(!plantRating.containsKey(plantName)) {
                            plantRating.put(plantName, new ArrayList<>());
                        }
                        plantRating.get(plantName).add(rating);
                    }else{
                        System.out.println("error");
                    }
                    break;
                case "Update":
                    int newRarity = Integer.parseInt(plantInfo[1].trim());
                    if(plantRarity.containsKey(plantName)){
                        plantRarity.put(plantName,newRarity);
                    }else{
                        System.out.println("error");
                    }
                    break;
                case "Reset":
                    if(plantRarity.containsKey(plantName)){
                        plantRating.get(plantName).clear();
                    }else{
                        System.out.println("error");
                    }
                    break;
            }
            command = sc.nextLine();
        }
        System.out.println("Plants for the exhibition:");

        plantRarity.entrySet().stream()
                .sorted(Map.Entry.<String,Integer>comparingByValue()
                .thenComparingDouble(x -> plantRating.get(x.getKey()).stream()
                .mapToDouble(Double::doubleValue)
                .average().orElse(0.0))
                .reversed())
                .forEach(e -> System.out.printf("- %s; Rarity: %d; Rating: %.2f%n",e.getKey(),e.getValue(),
                        plantRating.get(e.getKey()).stream().mapToDouble(Double::doubleValue).average().orElse(0.0)));
    }
}
