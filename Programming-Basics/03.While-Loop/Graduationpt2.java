package WhileLoop;

import java.util.Scanner;

public class Graduationpt2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        int counter = 1;
        double graduates = 0;

        while (counter <=12) {
            double graduate = Double.parseDouble(scanner.nextLine());
            if (graduate >= 4) {
                graduates += graduate;
            } else {
                System.out.printf("%s has been excluded at %d grade" , name, counter);
                break;
            }
            counter++;
        }if (counter>=12){
            double average = graduates / 12;
            System.out.printf("%s graduated. Average grade: %.2f", name, average);
        }

    }
}

