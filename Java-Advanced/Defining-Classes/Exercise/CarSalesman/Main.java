package Exercise.CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int linesOfEngines = Integer.parseInt(sc.nextLine());
        List<Engine> engineList = new ArrayList<>();

        while(linesOfEngines-- > 0){
            String[] tokens = sc.nextLine().split("\\s+");
            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);
            Engine engine = new Engine(model,power);

            getEngineElements(tokens, engine);
            engineList.add(engine);
        }

        int linesOfCars = Integer.parseInt(sc.nextLine());
        List<Car> cars = new ArrayList<>();

        while(linesOfCars-- > 0){
            String[] tokens = sc.nextLine().split("\\s+");
            String model = tokens[0];
            String engineName = tokens[1];

            Engine engine = engineList.stream().filter(e -> e.getModel().equals(engineName)).findAny().orElse(null);
            Car car = new Car(model,engine);

            getCarElements(tokens, car);
            cars.add(car);
        }


        cars.forEach(System.out::println);
    }

    private static void getCarElements(String[] tokens, Car car) {
        if(tokens.length == 4){
            String weight = tokens[2];
            String color = tokens[3];
            car.setWeight(weight);
            car.setColor(color);

        }else if(tokens.length == 3){
            if(Character.isLetter(tokens[2].charAt(0))){
                String color = tokens[2];
                car.setColor(color);
            }else{
                String weight = tokens[2];
                car.setWeight(weight);
            }
        }
    }

    private static void getEngineElements(String[] tokens, Engine engine) {
        if(tokens.length == 4){
            String displacement = tokens[2];
            String efficiency = tokens[3];

            engine.setDisplacement(displacement);
            engine.setEfficiency(efficiency);

        }else if(tokens.length == 3){
            if(Character.isLetter(tokens[2].charAt(0))){
                String efficiency = tokens[2];
                engine.setEfficiency(efficiency);
            }else{
                String displacement = tokens[2];
                engine.setDisplacement(displacement);
            }
        }
    }
}
