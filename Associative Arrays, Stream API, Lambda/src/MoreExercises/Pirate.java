package MoreExercises;

import java.util.*;

public class Pirate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, List<Integer>> citiesPopulationAndGold = new TreeMap<>();

        String input =sc.nextLine();
        while(!input.equals("Sail")){
            String[] data = input.split("\\|+");
            String city = data[0];
            int population = Integer.parseInt(data[1]);
            int gold = Integer.parseInt(data[2]);
            if(!citiesPopulationAndGold.containsKey(city)){
                citiesPopulationAndGold.put(city,new ArrayList<>());
                citiesPopulationAndGold.get(city).add(population);
                citiesPopulationAndGold.get(city).add(gold);
            }else{
                citiesPopulationAndGold.get(city).set(0,citiesPopulationAndGold.get(city).get(0) + population);
                citiesPopulationAndGold.get(city).set(1,citiesPopulationAndGold.get(city).get(1) + gold);
            }
            input = sc.nextLine();
        }

        String text = sc.nextLine();
        while(!text.equals("End")){
            String[] data = text.split("=>");
            String command = data[0];
            String town = data[1];
            if(command.equals("Plunder")){
                int people = Integer.parseInt(data[2]);
                int gold = Integer.parseInt(data[3]);
                System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n",town,gold,people);
                int currentPopulation = citiesPopulationAndGold.get(town).get(0);
                int currentGold = citiesPopulationAndGold.get(town).get(1);
                citiesPopulationAndGold.get(town).set(0,currentPopulation - people);
                citiesPopulationAndGold.get(town).set(1,currentGold - gold);
                if(citiesPopulationAndGold.get(town).get(0) <= 0 || citiesPopulationAndGold.get(town).get(1) <= 0){
                    System.out.println(town + " has been wiped off the map!");
                    citiesPopulationAndGold.remove(town);
                }
            }else if(command.equals("Prosper")){
                int gold = Integer.parseInt(data[2]);
                if(gold < 0){
                    System.out.println("Gold added cannot be a negative number!");
                }else{
                    citiesPopulationAndGold.get(town).set(1,citiesPopulationAndGold.get(town).get(1) + gold);
                    System.out.println(gold + " gold added to the city treasury. " + town + " now has " +
                            citiesPopulationAndGold.get(town).get(1) + " gold.");
                }
            }

            text = sc.nextLine();
        }

        if(citiesPopulationAndGold.size() <= 0){
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }else{
            System.out.println("Ahoy, Captain! There are " + citiesPopulationAndGold.size() + " wealthy settlements to go to:");
            citiesPopulationAndGold.entrySet().stream().sorted((f,s) -> s.getValue().get(1) - f.getValue().get(1))
                    .forEach(e -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",e.getKey(),e.getValue().get(0),e.getValue().get(1)));
        }
    }
}
