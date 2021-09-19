import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        Set<String> carPlates = new LinkedHashSet<>();


        while(!input.equals("END")){
            String carPlate = input.split("\\s+")[1];
            if(input.contains("IN")){
                carPlates.add(carPlate);
            }else if(input.contains("OUT")){
                carPlates.remove(carPlate);
            }
            input = sc.nextLine();
        }

        if(carPlates.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else {
            System.out.println(String.join(System.lineSeparator(), carPlates));
        }
    }
}
