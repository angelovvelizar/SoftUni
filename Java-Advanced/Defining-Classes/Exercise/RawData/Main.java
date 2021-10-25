package Exercise.RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Car> cars = new ArrayList<>();


        while (n-- > 0) {
            String[] input = sc.nextLine().split("\\s+");
            String model = input[0];

            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            double tire1Pressure = Double.parseDouble(input[5]);
            int tire1Age = Integer.parseInt(input[6]);
            Tire tire1 = new Tire(tire1Age, tire1Pressure);

            double tire2Pressure = Double.parseDouble(input[7]);
            int tire2Age = Integer.parseInt(input[8]);
            Tire tire2 = new Tire(tire2Age, tire2Pressure);

            double tire3Pressure = Double.parseDouble(input[9]);
            int tire3Age = Integer.parseInt(input[10]);
            Tire tire3 = new Tire(tire3Age, tire3Pressure);

            double tire4Pressure = Double.parseDouble(input[11]);
            int tire4Age = Integer.parseInt(input[12]);
            Tire tire4 = new Tire(tire4Age, tire4Pressure);

            Car car = new Car(model, engine, cargo);

            addAllTires(car,tire1,tire2,tire3,tire4);
            cars.add(car);
        }

        String command = sc.nextLine();
        if (command.equals("fragile")) {
            cars.stream().filter(c -> c.getCargo().getType().equals("fragile")
                    && c.getTires().stream().anyMatch(t -> t.getPressure() < 1))
                    .forEach(c -> System.out.println(c.getModel()));

        } else if (command.equals("flamable")) {
            cars.stream()
                    .filter(c -> c.getCargo().getType().equals("flamable")
                            && c.getEngine().getPower() > 250)
                    .forEach(c -> System.out.println(c.getModel()));
        }
    }

    public static void addAllTires(Car car, Tire tire1, Tire tire2, Tire tire3, Tire tire4){
        car.getTires().add(tire1);
        car.getTires().add(tire2);
        car.getTires().add(tire3);
        car.getTires().add(tire4);
    }
}
