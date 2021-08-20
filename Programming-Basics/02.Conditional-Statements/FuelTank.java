package Conditional;

import java.util.Scanner;

public class FuelTank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fuel = sc.nextLine();
        double litersFuel = Double.parseDouble(sc.nextLine());
        try {
            switch (fuel) {
                case "Diesel":
                    output(fuel, litersFuel);
                    break;
                case "Gasoline":
                    output(fuel, litersFuel);
                    break;
                case "Gas":
                    output(fuel, litersFuel);
                    break;
                default:
                    System.out.println("Invalid fuel!");
                    break;
            }
        }
        catch(Exception e){
            System.out.println("Error somewhere!");
        }
    }
    public static void output(String fuel, double litersFuel){
        if(litersFuel >= 25){
            System.out.println("You have enough " + fuel.toLowerCase() + ".");
        }else{
            System.out.println("Fill your tank with "+ fuel.toLowerCase() + "!");
        }
    }
}
