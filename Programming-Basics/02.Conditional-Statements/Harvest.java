package Conditional;

import java.util.Scanner;

public class Harvest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int areaCubicMeters = Integer.parseInt(sc.nextLine());
        double grapeForOneCubicMeter = Double.parseDouble(sc.nextLine());
        int neededLitresWine = Integer.parseInt(sc.nextLine());
        int workersNumber = Integer.parseInt(sc.nextLine());


        double totalGrape = areaCubicMeters * grapeForOneCubicMeter;
        double wine = 0.40 * totalGrape/ 2.5;
        if(wine < neededLitresWine){
            double wineMissing = neededLitresWine - wine;
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.", Math.floor(wineMissing));
        }
        else if(wine >= neededLitresWine){
            double wineLeft = Math.ceil(wine - neededLitresWine);
            double share = Math.ceil(wineLeft / workersNumber);
            System.out.printf("Good harvest this year! Total wine: %.0f liters.%n", Math.floor(wine));
            System.out.printf("%.0f liters left -> %.0f liters per person.", wineLeft, share);
        }

    }
}
