package SecretMirrorNFS;

import java.util.*;

public class NFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String, List<Integer>> cars = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String car = sc.nextLine();
            String[] carsData = car.split("\\|");
            int mileage = Integer.parseInt(carsData[1]);
            int fuel = Integer.parseInt(carsData[2]);
            cars.put(carsData[0],new ArrayList<>());
            cars.get(carsData[0]).add(0,mileage);
            cars.get(carsData[0]).add(1,fuel);
        }

        String command = sc.nextLine();
        while(!command.equals("Stop")){
            String[] commandData = command.split(" : ");
            String commandType = commandData[0];
            String car = commandData[1];
            switch (commandType){
                case "Drive":
                    int distance = Integer.parseInt(commandData[2]);
                    int fuel = Integer.parseInt(commandData[3]);
                    if(fuel > cars.get(car).get(1)){
                        System.out.println("Not enough fuel to make that ride");
                    }else{
                        cars.get(car).set(0,cars.get(car).get(0) + distance);
                        cars.get(car).set(1,cars.get(car).get(1) - fuel);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n"
                                ,car,distance,fuel);
                        if(cars.get(car).get(0) >= 100000){
                            cars.remove(car);
                            System.out.println("Time to sell the " + car + "!");
                        }
                    }
                    break;
                case "Refuel":
                    int fuelToAdd = Integer.parseInt(commandData[2]);
                    int fuelAdded = Math.min(fuelToAdd,75 - cars.get(car).get(1));
                    cars.get(car).set(1,cars.get(car).get(1) + fuelAdded);
                    System.out.printf("%s refueled with %d liters%n",car,fuelAdded);
                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(commandData[2]);
                    cars.get(car).set(0,cars.get(car).get(0) - kilometers);
                    if(cars.get(car).get(0) < 10000){
                        cars.get(car).set(0,10000);
                    }else{
                        System.out.printf("%s mileage decreased by %d kilometers%n",car, kilometers);
                    }
                    break;
            }

            command = sc.nextLine();
        }

        cars.entrySet().stream()
                .sorted((f,s) -> s.getValue().get(0) - f.getValue().get(0))
                .forEach(e -> {
                    System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",
                            e.getKey(),e.getValue().get(0),e.getValue().get(1));
                });
    }
}
