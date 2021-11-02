package Exercise.Box;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double length = Double.parseDouble(sc.nextLine());
        double width = Double.parseDouble(sc.nextLine());
        double height = Double.parseDouble(sc.nextLine());

        try {
            Box box = new Box(length, width, height);

            double surfaceArea = box.calculateSurfaceArea();
            double lateralSurfaceArea = box.calculateLateralSurfaceArea();
            double volume = box.calculateVolume();

            System.out.printf("Surface area - %.2f%nLateral Surface Area - %.2f%nVolume - %.2f", surfaceArea, lateralSurfaceArea, volume);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }
}
