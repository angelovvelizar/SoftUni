package ForLoop.MoreExercises;

import java.util.Scanner;

public class Logistics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberCargos = Integer.parseInt(sc.nextLine());

        double pricePerTon = 0;
        double totalTons = 0;
        double n = 0;
        double bus = 0;
        double truck = 0;
        double train = 0;
        for (int i = 0; i < numberCargos; i++) {
            int tonsOfCargo = Integer.parseInt(sc.nextLine());
            if(tonsOfCargo <= 3){
                pricePerTon = 200;
                bus += tonsOfCargo;
            }else if(tonsOfCargo > 3 && tonsOfCargo <= 11){
                pricePerTon = 175;
                truck += tonsOfCargo;
            }else {
                pricePerTon = 120;
                train += tonsOfCargo;
            }
            n += tonsOfCargo * pricePerTon;
            totalTons += tonsOfCargo;
        }
        double average = n / totalTons;
        double busPercent = bus / totalTons * 100;
        double truckPercent = truck / totalTons * 100;
        double trainPercent = train / totalTons * 100;
        System.out.printf("%.2f%n", average);
        System.out.printf("%.2f%%%n",busPercent);
        System.out.printf("%.2f%%%n",truckPercent);
        System.out.printf("%.2f%%%n",trainPercent);



    }
}
