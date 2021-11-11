package Exercise.VehicleExtension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();

        String[] tokens = getAsArray(sc);
        vehicleMap.put("Car", new Car(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3])));

        tokens = getAsArray(sc);
        vehicleMap.put("Truck", new Truck(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3])));

        tokens = getAsArray(sc);
        Bus bus  = new Bus(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
        vehicleMap.put("Bus", bus);

        int n = Integer.parseInt(sc.nextLine());
        while(n-- > 0){
            String[] commandInfo = getAsArray(sc);
            String command = commandInfo[0];
            String vehicleType = commandInfo[1];
            double argument = Double.parseDouble(commandInfo[2]);

            if(command.equals("Drive")){
                System.out.println(vehicleMap.get(vehicleType).drive(argument));
            }else if(command.equals("Refuel")){
                try {
                    vehicleMap.get(vehicleType).refuel(argument);
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
            }else if(command.equals("DriveEmpty")){
                System.out.println(bus.driveWithoutPassengers(argument));
            }
        }

        for (Vehicle value : vehicleMap.values()) {
            System.out.println(value.toString());
        }
    }

    private static String[] getAsArray(Scanner sc) {
        return sc.nextLine().split("\\s+");
    }
}
