package MoreExercises;

import java.util.*;

public class NeedForSpeed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, List<Integer>> carsInfo = new TreeMap<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String carData = sc.nextLine();
            String[] tokens = carData.split("\\|");
            String carName = tokens[0];
            int carMileage = Integer.parseInt(tokens[1]);
            int carFuel = Integer.parseInt(tokens[2]);
            carsInfo.putIfAbsent(carName,new ArrayList<>());
            carsInfo.get(carName).add(0,carMileage);
            carsInfo.get(carName).add(1,carFuel);
        }

        String command = sc.nextLine();
        while(!command.equals("Stop")){
            String[] tokens = command.split("\\s+:\\s+");
            String commandType = tokens[0];
            String carName = tokens[1];
            switch (commandType){
                case "Drive":
                    int distance = Integer.parseInt(tokens[2]);
                    int fuel = Integer.parseInt(tokens[3]);
                    if(carsInfo.get(carName).get(1) < fuel){
                        System.out.println("Not enough fuel to make that ride");
                    }else{
                        carsInfo.get(carName).set(0,carsInfo.get(carName).get(0) + distance);
                        carsInfo.get(carName).set(1,carsInfo.get(carName).get(1) - fuel);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n",carName,distance,fuel);
                        if(carsInfo.get(carName).get(0) >= 100000){
                            carsInfo.remove(carName);
                            System.out.println("Time to sell the " + carName + "!");
                        }
                    }
                    break;
                case "Refuel":
                    int fuelToAdd = Integer.parseInt(tokens[2]);
                    int fuelFilled = Math.min(75 - carsInfo.get(carName).get(1), fuelToAdd);
                    carsInfo.get(carName).set(1,carsInfo.get(carName).get(1) + fuelFilled);
                    System.out.printf("%s refueled with %d liters%n",carName,fuelFilled);
                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(tokens[2]);
                    carsInfo.get(carName).set(0,carsInfo.get(carName).get(0) - kilometers);
                    if(carsInfo.get(carName).get(0) < 10000){
                        carsInfo.get(carName).set(0,10000);
                    }else{
                        System.out.printf("%s mileage decreased by %d kilometers%n",carName,kilometers);
                    }
                    break;
            }
            command = sc.nextLine();
        }

        carsInfo.entrySet().stream()
                .sorted((f,s) -> s.getValue().get(0) - f.getValue().get(0))
                .forEach(e -> {
                    System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",e.getKey(),e.getValue().get(0),e.getValue().get(1));
                });
    }
}
