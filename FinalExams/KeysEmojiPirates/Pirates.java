package KeysEmojiPirates;

import java.util.*;

public class Pirates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Map<String, List<Integer>> citiesData = new TreeMap<>();
        while(!input.equals("Sail")){
            String[] tokens = input.split("\\|\\|");
            String city = tokens[0];
            int population = Integer.parseInt(tokens[1]);
            int gold = Integer.parseInt(tokens[2]);
            if(!citiesData.containsKey(city)){
                citiesData.put(city, new ArrayList<>());
                citiesData.get(city).add(0,population);
                citiesData.get(city).add(1,gold);
            }else{
                citiesData.get(city).set(0,citiesData.get(city).get(0) + population);
                citiesData.get(city).set(1,citiesData.get(city).get(1) + gold);
            }

            input = sc.nextLine();
        }
        String event = sc.nextLine();
        while(!event.equals("End")){
            String[] eventData = event.split("=>");
            String command = eventData[0];
            String town = eventData[1];
            switch(command){
                case "Plunder":
                    int people = Integer.parseInt(eventData[2]);
                    int gold = Integer.parseInt(eventData[3]);
                    citiesData.get(town).set(0, citiesData.get(town).get(0) - people);
                    citiesData.get(town).set(1, citiesData.get(town).get(1) - gold);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n",town,gold,people);
                    if(citiesData.get(town).get(0) == 0 || citiesData.get(town).get(1) == 0){
                        citiesData.remove(town);
                        System.out.println(town + " has been wiped off the map!");
                    }
                    break;
                case "Prosper":
                    int goldToAdd = Integer.parseInt(eventData[2]);
                    if(goldToAdd <= 0){
                        System.out.println("Gold added cannot be a negative number!");
                    }else {
                        citiesData.get(town).set(1, citiesData.get(town).get(1) + goldToAdd);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n",goldToAdd,town,citiesData.get(town).get(1));
                    }
                    break;
            }
            event = sc.nextLine();
        }
        if(citiesData.size() > 0){
            System.out.println("Ahoy, Captain! There are " + citiesData.size() + " wealthy settlements to go to:");
            citiesData.entrySet().stream()
                    .sorted((f,s) -> s.getValue().get(1) - f.getValue().get(1))
                    .forEach(e -> {
                        System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",e.getKey(),e.getValue().get(0),e.getValue().get(1));
                    });
        }
    }
}
