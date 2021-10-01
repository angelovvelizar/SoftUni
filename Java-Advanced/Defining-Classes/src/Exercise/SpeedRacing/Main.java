package Exercise.SpeedRacing;

import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Set<Car> cars = new LinkedHashSet<>();

        while(n-- > 0){
            String[] input = sc.nextLine().split("\\s+");
            String model = input[0];
            double fuelAmount = Double.parseDouble(input[1]);
            double fuelCostFor1Km = Double.parseDouble(input[2]);
            int distanceTraveled = 0;
            Car car = new Car(model,fuelAmount,fuelCostFor1Km,distanceTraveled);
            cars.add(car);
        }

        String command = sc.nextLine();

        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");
            String carModel = tokens[1];
            int amountOfKm = Integer.parseInt(tokens[2]);
            for(Car car : cars){
                if(car.getModel().equals(carModel)){
                    car.canMove(amountOfKm);
                }
            }

            command = sc.nextLine();
        }

        cars.forEach(System.out::println);


    }
}
